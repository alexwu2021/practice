# use dw;

drop table if exists dim_action_targets;
CREATE TABLE dim_action_targets (
    id   int  NOT NULL,
    name nvarchar(100) NOT NULL
);

alter table dim_action_targets add primary key pk_dim_action_targets (id);