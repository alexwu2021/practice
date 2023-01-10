# use dw;

drop table if exists facts;
CREATE TABLE facts (

    # --------------------section 1: the record identities--------------------
    # --------------------note: we might add search key in the future--------------------
    # the identities of a fact record
    id                      int not null primary key auto_increment,

    # a hashed value generated from uuid, for the purpose of linking the facts table and other dim tables
    fact_uuid_hash          int not null,               ## populated by processor



    # --------------------section 2: the event actor and its context --------------------
    # --------------------the event actor is a person or an app that triggers the event --------------------
    # the who or the subject                            # who triggers this event
    action_user_id          bigint NOT NULL,               ## case study: the email sender
                                                        ### could be any person or any app

    # the context of the what or the object             ## the reference data structure about the action user
    reference_data_structure_id       int null,         ## the id of a snapshot of user to nug list mapping



    # --------------------section 3: the when--------------------
    # the when                                          ## event occurrence date
    event_date_id           int not null,               ## case study: VIEW_DATE



    # --------------------section 4: the how--------------------
    # the how or the verb                               ## the id of the pair of action target and action
    operation_id            int null,                   ## case study: 5, with action_target_id being 1 and action_id being 5



    # --------------------section 5: the event onto object and its context--------------------
    # --------------------describing the object of the event (to what the event has happened)--------------------
    # --------------------this could be a message, a page, a link--------------------
    # --------------------and how the object is situated--------------------
    # --------------------like belonging to or associated with an organization or be part of a containing entity say discussion--------------------

    # the what or the object                            ## a dup field as it can be inferred from operation_id
                                                        ## used for quick lookup
    action_target_id        int null,                   ## case study: object_type_id[dim_action_targets]

                                                        ## a placeholder for the original identity of the what or the object
    object_id               int null,                   ## case study: NOTIFICATION_EMAIL_ID


    # the context of the what or the object
    object_context_id       int null,                   ## describing how the object_id is related to a containing context
                                                        ## here is a placeholder for field like discussion_id



    # --------------------section 6: the event-ee or the whom, that is, parties affected by the event--------------------
    # --------------------for an example, the recipient list of a message--------------------
    # the whom
    object_user_ids         text null,                  # comma separated use id list ## case study: EMAIL_TO_ID




    # --------------------section 7: for processor--------------------
    # the info about the processor
    extraction_date_id      int null,                   ## case study: added by processor
    processing_status_id    int not null default 11     ## case study: default 'db data processing started'
);

## case study
# " a.NOTIFICATION_EMAIL_ID," +
#             " a.EMAIL_TO_UID, " +
#             " date(a.VIEW_DATE) as VIEW_DATE, " +
#             " a.msid, " +
#             " a.ctxtype, " +
#             " a.ctxid, " +
#             " a.access_ctxtype, " +
#             " a.access_ctxid, " +
#             "  a.THREAD_MSID ";



alter table facts add constraint fk_facts_dim_users foreign key (action_user_id) references dim_users (UID);
alter table facts add constraint fk_facts_dim_reference_data_structure foreign key (reference_data_structure_id) references dim_reference_data_structure (id);

alter table facts add constraint fk_facts_dim_dates_event_date foreign key (event_date_id) references dim_dates (id);
alter table facts add constraint fk_facts_dim_dates_extraction_date foreign key (extraction_date_id) references dim_dates (id);

alter table facts add constraint fk_facts_dim_operations foreign key (operation_id) references dim_operations (id);
alter table facts add constraint fk_facts_dim_action_targets foreign key (action_target_id) references dim_action_targets (id);