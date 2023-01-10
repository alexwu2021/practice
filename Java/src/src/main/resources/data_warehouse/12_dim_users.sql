# use dw;

drop table if exists dim_users;
CREATE TABLE dim_users (
    id          int not null primary key auto_increment,
    uid         bigint not null
);

alter table dim_users add constraint uk_dim_users unique key (uid);

