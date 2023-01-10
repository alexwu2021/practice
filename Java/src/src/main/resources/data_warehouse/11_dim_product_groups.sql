# use dw;

drop table if exists dim_product_groups;
CREATE TABLE dim_product_groups (
    id          int not null primary key auto_increment,
    nug_id     bigint not null
);

alter table dim_product_groups add unique key pk_dim_product_groups (nug_id);