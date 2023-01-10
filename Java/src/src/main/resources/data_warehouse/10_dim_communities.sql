# use dw;

drop table if exists dim_communities;
CREATE TABLE dim_communities (
    id          int not null primary key auto_increment,
    nug_id     bigint not null
);

alter table dim_communities add unique key uk_dim_communities (nug_id);