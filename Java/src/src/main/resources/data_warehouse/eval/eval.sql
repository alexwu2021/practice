use kpi_data;

select count(*) as dates_count from dim_dates;

select count(*) as action_target_count from dim_action_targets;
select count(*) as operations_count from dim_operations;
select count(*) as actions_count from dim_actions;
select count(*) as discussion_count from dim_discussions;
select count(*) as processing_status_count from dim_processing_status;
select count(*) as community_count from dim_communities;
select count(*) as message_context_count from dim_message_context;
select count(*) as message_count from dim_messages;
select count(*) as product_group_count from dim_product_groups;
select count(*) as users_reference_data_structure from dim_reference_data_structure;
select count(*) as users_count from dim_users;
select count(*) as facts_count from facts;

