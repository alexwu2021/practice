# use dw;

drop table if exists dim_messages;
CREATE TABLE dim_messages (
    id                      int NOT NULL primary key auto_increment,
    message_id              int null,       # if it is from db, then it has a non-null value
    message_seq_num         nvarchar(50),   # if it is from streaming before saved to db, then store the sequence number
    fact_uuid_hash          int not null,   ## populated by processor, the joining point between facts table and dim tables

    discussion_id           int null,
    subject                 nvarchar(200) NOT NULL,
    transmission_type       varchar(10) null,
    dt_created              date not null,

    prev_fact_uuid_hash     int null
);
