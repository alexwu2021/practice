# use dw;

drop table if exists dim_operations;
CREATE TABLE dim_operations (
       id   int  NOT NULL primary key auto_increment,
       name nvarchar(50) null,
       action_target_id int not null,
       action_id int not null
);

