# use dw;

drop table if exists dim_processing_status;
CREATE TABLE dim_processing_status (
    id                  int             NOT NULL,
    name                nvarchar(100)    NOT NULL,
    description         nvarchar(400)   NOT NULL
);

alter table dim_processing_status add primary key pk_dim_processing_status (id);
