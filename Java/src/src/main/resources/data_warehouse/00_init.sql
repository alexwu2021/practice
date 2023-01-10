# use dw;

alter table dim_reference_data_structure drop foreign key fk_dim_reference_data_structure_dim_users;

alter table facts drop foreign key fk_facts_dim_reference_data_structure;
alter table facts drop foreign key fk_facts_dim_operations;
alter table facts drop foreign key fk_facts_dim_action_targets;
alter table facts drop foreign key fk_facts_dim_users;
alter table facts drop foreign key fk_facts_dim_dates_event_date;
alter table facts drop foreign key fk_facts_dim_dates_extraction_date;

alter table dim_operations drop foreign key fk_dim_operations_dim_action_targets ;
alter table dim_operations drop foreign key  fk_dim_operations_dim_actions ;
