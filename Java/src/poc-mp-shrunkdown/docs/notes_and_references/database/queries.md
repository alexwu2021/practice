
The facts are:

## email is opened by user U

email_to_uid in log_notification_email_view table is the ID of the user who opens the email.
To see, if the user’s account status, you can use query ctx_entity table;

SELECT state FROM ctx_entity WHERE ctxtype = 100 AND ctxid = :user_id

State =1 means active account
State =2 means ghost account
State = 0 means deleted account
 


## User U belongs to a community C (member of the community)
if user belongs to more than one community, there will be multiple facts.

The community membership is in ctx_entity_rel table.
As the name suggests, it keeps the relationships from a ctx_entity to another ctx_entity.  In ctx_entity_rel table,
ctxid, ctxtype : defines entity of “from”
ctxid_to, ctxtype_to : defines entity of “to”
access_ctxid_to, access_ctxtype_to : defines access entity of “to”

To find all communities that the user belongs to;

-- improved by adding distinct and sysntax-corrected
use kpi_data;
SELECT distinct c.ctxid, c.ctxtype
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100 and r.ctxid = :usrid  
AND r.state = 1
AND ((r.type = 'follow' AND  r.ctxtype_to IN (300, 600)) OR (r.type = 'member' AND r.ctxtype_to = 400))
AND r.ctxid_to = c.ctxid AND r.ctxtype_to = c.ctxtype AND c.state = 1 ;


Also, if a user belongs to a product (ctxtype_to = 300), that implies that the user belongs to the product’s vendor implicitly.

-- improved by adding distinct
SELECT distinct c.ctxid, c.ctxtype
FROM ctx_entity_rel r, ctx_entity c
WHERE
r.ctxtype = 100
AND r.state = 1
AND r.type = 'follow' AND r.ctxtype_to = 300 AND r.access_ctxtype_to = 200
AND r.access_ctxid_to = c.ctxid AND r.access_ctxtype_to = c.ctxtype AND c.state = 1 ;





email is of a notification category T

The category of notification email opened is in column category of log_notification_email_view

email is about a discussion thread D
This means the category is post, response, digest, or share

Post notification emails are sent for posts.   A discussion thread has one or more posts. So, this is to get about the discussion thread that the post belongs to.  Note that if notification email is not related to any post, it wouldn’t have any fact about any discussion thread.

To get thread IDs of notification emails related to posts, use the following query;

SELECT DISTINCT m.thread_msid
FROM  Ctx_message m, notification_ctx_message n, log_notification_email_view g
WHERE
m.msid = n.msid
AND n.notification_id = g.notification_id
AND m.state <> 13  (not deleted)


email is about a post P
Note that email can be for more than one post. If more than one post, there will be multiple facts of this category.

SELECT DISTINCT m.msid
FROM  Ctx_message m, notification_ctx_message n, log_notification_email_view g
WHERE
m.msid = n.msid
AND n.notification_id = g.notification_id
AND m.state <> 13  (not deleted)


email is about a post authored by user A

This is post-author centric.  So first is to get all authors (distinct) of the posts the notification email is for.

SELECT DISTINCT m.created_by
FROM  Ctx_message m, notification_ctx_message n, log_notification_email_view g
WHERE
m.msid = n.msid
AND n.notification_id = g.notification_id
AND m.state <> 13  (not deleted)


email is about a discussion shared in a community C
Note that a discussion can be for more than one community. If more than one community, there will multiple facts of this category.

Find all communities in which the discussion(s) of the posts in the notification email opened is shared.
We need two queries below – first is for product, and second is for other communities.  We can use union to get distinct records.

SELECT p.ctxid, p.ctxtype
FROM  Ctx_message m, notification_ctx_message n, log_notification_email_view g, post_comm p, ctx_entity c
WHERE
m.msid = n.msid
AND n.notification_id = g.notification_id
AND m.state <> 13  (not deleted)
AND m.thread_msid = p.msid
AND p.mode = 1  AND p.ctxtype = 300
AND c.ctxid = p.ctxid AND c.ctxtype = p.ctxtype AND c.state = 1 (active communities)

UNION
SELECT p.access_ctxid, p.access_ctxtype
FROM  Ctx_message m, notification_ctx_message n, log_notification_email_view g, post_comm p, ctx_entity c
WHERE
m.msid = n.msid
AND n.notification_id = g.notification_id
AND m.state <> 13  (not deleted)
AND m.thread_msid = p.msid
AND p.mode = 1
AND c.ctxid = p.access_ctxid AND c.ctxtype = p.access_ctxtype AND c.state = 1 (active communities)




Aggregation periods are (all are in UTC time)

Daily
Weekly: Monday to Sunday
Monthly

Yong
 
 
 
