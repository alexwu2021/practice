# use dw;

# intended to make daily snapshots of the user to non-user group mapping

drop table if exists dim_reference_data_structure;
CREATE TABLE dim_reference_data_structure (
    id          int     NOT NULL primary key auto_increment,
    date_id     int not null,
    nick_name   nvarchar(50) null,
    uid         bigint not null,
    nug_ids     text not null   # comma separated nug_ids
);
