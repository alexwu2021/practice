# use dw;

drop table if exists dim_discussions;
CREATE TABLE dim_discussions (
    id                      int not null primary key auto_increment,
    discussion_id           int not null,
    name                    nvarchar(200) null,
    thread_msid             int null,
    first_message_id        int null,      # or the id of the post message
    dt_created              date null,
    status                  nvarchar(20) null
);
