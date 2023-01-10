use kpi_hive;

## Error during job, obtaining debugging information...
## FAILED: Execution Error, return code 2 from org.apache.hadoop.hive.ql.exec.mr.MapRedTask
select * from post_comm where ctxtype in (select ctxtype from ctxentity where ctxtype is not null) ;

select e.ctxtype, e.ctxid, e.name, pc.created_by from ctxentity e inner join post_comm pc on e.ctxtype = pc.ctxtype and e.ctxid = pc.ctxid where pc.ctxtype = 100;


## Error during job, obtaining debugging information...
## FAILED: Execution Error, return code 2 from org.apache.hadoop.hive.ql.exec.mr.MapRedTask

select * from ctxmessage m inner join post_comm pc on m.msid = pc.msid;


