    select
        distinct v.NOTIFICATION_EMAIL_ID,
        v.EMAIL_TO_UID,
        date(v.VIEW_DATE) as VIEW_DATE,
        nm.msid,
        pc.ctxtype,
        pc.ctxid,
        pc.access_ctxtype,
        pc.access_ctxid,
        m.THREAD_MSID

    from
        log_notification_email_view v inner join notification_ctx_message nm on v.notification_id = nm.notification_id
        inner join post_comm pc on pc.msid = nm.msid
        inner join ctx_message m on nm.msid = m.msid

    where v.VIEW_DATE > '20211201'

    LIMIT 1;


-- 980661
