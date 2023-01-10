# use dw;

# describing to which communities or product groups a message belongs at any given day
# intended to make daily snapshots of the message to non-user group mapping

drop table if exists dim_message_context;
CREATE TABLE dim_message_context (
    id                  int     NOT NULL primary key auto_increment,
    date                date    not null,
    nick_name           nvarchar(50) null,
    message_id          int not null,
    nug_ids   text null   # comma separated product group ctx_seqs
);