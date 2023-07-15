use kpi_data;

-- ====================================part 1========================================
-- purpose: how many raw records we may expect for the given state of data

-- based on the existing query, we may expect 4994 qualified email open records
-- question: is this correct? i am doubting about it

# original query:

select count(*)

from

    (
        select   a.NOTIFICATION_EMAIL_ID, a.EMAIL_TO_UID,  date(a.VIEW_DATE) as VIEW_DATE,  a.msid,  a.ctxtype,  a.ctxid,  a.access_ctxtype,  a.access_ctxid,   a.THREAD_MSID, a.USER_TYPE, a.FULL_NAME from  (select distinct v.NOTIFICATION_EMAIL_ID,              v.EMAIL_TO_UID,              v.VIEW_DATE,              nm.msid,              pc.ctxtype,              pc.ctxid,              pc.access_ctxtype,              pc.access_ctxid,              m.THREAD_MSID, u.USER_TYPE, u.FULL_NAME                      from          log_notification_email_view v inner join notification_ctx_message nm on v.notification_id = nm.notification_id                      inner join post_comm pc on pc.msid = nm.msid                      inner join ctx_message m on nm.msid = m.msid                        inner join sec_user u on v.EMAIL_TO_UID = u.UID   ) as a  where  (a.ctxid * 1000000 + a.ctxtype)     IN (             SELECT distinct (c.ctxid * 1000000 +  c.ctxtype)     FROM ctx_entity_rel r, ctx_entity c     WHERE     r.ctxtype = 100 and r.ctxid = a.EMAIL_TO_UID     AND r.state = 1     AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))     AND r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype AND c.state = 1      union      SELECT distinct (c.ctxid * 1000000 +  c.ctxtype)     FROM ctx_entity_rel r, ctx_entity c     WHERE     r.ctxtype = 100 and r.ctxid = a.EMAIL_TO_UID     AND r.state = 1     AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200     AND r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype AND c.state = 1 )


    ) as bb;

-- 4994


-- if we just join those relevant tables together, and without any restriction, then
-- we will have 8724 records

-- the number is so little, which is quite unlikely!!
select count(*) from (
select distinct v.NOTIFICATION_EMAIL_ID,              v.EMAIL_TO_UID,              v.VIEW_DATE,              nm.msid,              pc.ctxtype,              pc.ctxid,              pc.access_ctxtype,              pc.access_ctxid,              m.THREAD_MSID, u.USER_TYPE, u.FULL_NAME
from          log_notification_email_view v
inner join notification_ctx_message nm on v.notification_id = nm.notification_id
inner join post_comm pc on pc.msid = nm.msid
inner join ctx_message m on nm.msid = m.msid
inner join sec_user u on v.EMAIL_TO_UID = u.UID  ) as stem;  -- 8724



-- what if we don't not join post_comm and ctx_message? then the result (of 27227 records) makes more sense to me
select count(*) from log_notification_email_view v
inner join notification_ctx_message nm on v.notification_id = nm.notification_id
    -- inner join post_comm pc on pc.msid = nm.msid
    -- inner join ctx_message m on nm.msid = m.msid
inner join sec_user u on v.EMAIL_TO_UID = u.UID; -- 27227


-- when we reduce the joining to just the two tables, it will be 16362 overally
select count(*) from log_notification_email_view v
 -- inner join notification_ctx_message nm on v.notification_id = nm.notification_id
 -- inner join post_comm pc on pc.msid = nm.msid
 -- inner join ctx_message m on nm.msid = m.msid
 inner join sec_user u on v.EMAIL_TO_UID = u.UID; -- 16362

-- if we want to count all the distinct notificaitons, then it comes to 3398, which is quite small
select count(distinct v.NOTIFICATION_ID) from log_notification_email_view v
-- inner join notification_ctx_message nm on v.notification_id = nm.notification_id
-- inner join post_comm pc on pc.msid = nm.msid
-- inner join ctx_message m on nm.msid = m.msid
inner join sec_user u on v.EMAIL_TO_UID = u.UID; -- 3398

-- yes overall we have 1,791,614 records
select count(*) from log_notification_email_view;  -- 1791614


-- among them we have 143293 distinct messages
select count(distinct v.NOTIFICATION_ID) from log_notification_email_view v;

-- while we have no a single record that has null email to uid
select count(*) from log_notification_email_view v where v.EMAIL_TO_UID is null;  -- 0


-- at most we will 16362 email open messages/records for POC
select count(v.NOTIFICATION_EMAIL_ID) from log_notification_email_view v where v.EMAIL_TO_UID in (select distinct UID from sec_user) ; -- 16362

-- a majority (>94%) of email open records will be discarded because the EMAIL_TO_UID is not found in sec_user
select count(distinct EMAIL_TO_UID)  from log_notification_email_view ; -- 72037
select count(distinct UID) from sec_user;  -- 3964

select count(distinct UID) from sec_user;  -- 3964


-- =======================================part 2=====================================
-- purpose: how many legit users that have belonging communities or product groups

-- original user community query
SELECT distinct s.UID, c.ctxtype, c.ctxid

FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID

WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1 ;


select count(*)
from (
SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1 ) as uc;  -- 12680


-- original user product group query
SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200 ;

select count(*) from
(SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200 ) as up;  -- 2013



select count(*)
from  (

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1

union

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200  ) as base;   -- 14693

select 12680 + 2013;





select count(distinct ucup.UID) from
(

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1

union

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200  ) as ucup;  -- 2651



select count(distinct ucup.UID) from
(
SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1

union

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200  ) as ucup
where ucup.UID in
(select distinct UID from sec_user);  -- 2651




select count(distinct ucup.UID) from
(
SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1

union

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200  ) as ucup
where ucup.UID in
(select distinct v.NOTIFICATION_EMAIL_ID from log_notification_email_view v where v.EMAIL_TO_UID in (select distinct UID from sec_user)) ;  -- 0 !!!



select count(distinct v.NOTIFICATION_EMAIL_ID)
from log_notification_email_view v where v.EMAIL_TO_UID in (select distinct UID from sec_user)
and v.NOTIFICATION_EMAIL_ID in
(
select distinct ucup.UID
from
(
SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND c.state = 1

union

SELECT distinct s.UID, c.ctxtype, c.ctxid
FROM ctx_entity_rel r inner join ctx_entity c
on r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype
inner join sec_user s on r.ctxid = s.UID
WHERE r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200  ) as ucup
);  -- 0.  !!!  that means no way to explode upward

