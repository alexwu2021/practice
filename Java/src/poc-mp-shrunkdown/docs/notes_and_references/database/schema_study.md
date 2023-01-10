# there exists no a sure way to tell a collection of users

i have to resort to the following formula

users := { u | {all entities - known community entities - known product groups} }

and there goes the query:

#query
select  distinct ce.ctxtype, ce.ctxid, ce.state, ce.name
from ctx_entity ce
where (ce.ctxid + ce.ctxtype *100000)
not in
(
select (c.id + 100000 * c.type)
-- as seqId  -- not sure if this will save the batch work
from
( SELECT distinct c.ctxid as id, c.ctxtype as type
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype AND c.state = 1

union

SELECT distinct c.ctxid as id, c.ctxtype as type
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200
AND r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype AND c.state = 1 ) as c
)
and  ce.state > 0;

# but in reality, this kind of query can not be utilized by batch, so I have to set disjoining in java code


#not all message senders are users, some are valid communities
use kpi_data;
-- show tables;
select distinct m.ctxtype, m.ctxid
from ctx_message m inner join
(
SELECT distinct c.ctxid, c.ctxtype
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype AND c.state = 1
) as a
on m.ctxtype = a.ctxtype and m.ctxid = a.ctxid;


# the mapping from those from supposed to be users and the union of valid communities and valid product groups


use kpi_data;

select count(*) from ctx_entity_rel rel -- limit 10
where rel.ctxid + rel.ctxtype *100000

not in
(
select c.id + 100000 * c.type
from
(
SELECT distinct c.ctxid as id, c.ctxtype as type
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype AND c.state = 1

union

SELECT distinct c.ctxid as id, c.ctxtype as type
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200
AND r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype AND c.state = 1
) as c

)


and rel.ctxid_to + rel.ctxtype_to *100000

in
(
select c.id + 100000 * c.type
from
(
SELECT distinct c.ctxid as id, c.ctxtype as type
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND ((r.type = 'follow' AND r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype AND c.state = 1

union

SELECT distinct c.ctxid as id, c.ctxtype as type
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200
AND r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype AND c.state = 1
) as c

)

;
