# use dw;

drop table if exists dim_actions;
CREATE TABLE dim_actions (
    id      int      NOT NULL,
    name    nvarchar(25) NOT NULL
);

alter table dim_actions add primary key pk_dim_actions (id);
