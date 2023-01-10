package com.docmatter.ims.service.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.streams.KafkaStreams;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

/**
 *
 *
 */
@Component
public abstract class BaseStreamService implements DMKafkaStreamService {

    //private static  Logger logger = null;
    protected Thread serviceThread;
    protected CountDownLatch serviceLatch;
    protected KafkaStreams serviceStreams;

    private String insert_event_topic_log = "";
    //"INSERT INTO eba.eba_event_topic_log (event_id, topic, state, error) VALUES (:id, :topic, :state, :error)";

    /**
     *
     */
    public BaseStreamService() //Logger instanceLogger) {
    {
        try {
            //logger = instanceLogger;
            //logger.info("Starting service");
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    execute();
                }
            };
            serviceThread = new Thread(runnable);
            serviceLatch = new CountDownLatch(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Override
    public void startService() {
        serviceThread.start();
        //logger.info("Service Started.");
        System.out.println("Service Started.");
    }

    /**
     *
     */
    @Override
    public Thread stopService() {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (serviceStreams != null) {
                    // TODO: this will block till all streaming threads are done // will we lose data by timeout ???
                    serviceStreams.close(Duration.ofMinutes(1));
                }
                serviceLatch.countDown();
                //logger.info("Service Stopped.");
            }
        };
        Thread shutdownThread = new Thread(runnable);
        shutdownThread.start();
        return shutdownThread;
    }

    /**
     *
     */
    protected abstract void execute();

    /**
     *
     * @param reqId
     * @return
     * @throws Exception
     */
    public JsonNode checkOutRequest(long reqId)
            throws Exception {
//        Session db = null;
//        Transaction trx = null;
//        try {
//            db = DBService.getInstance().openSession();
//            KafkaRequest req = (KafkaRequest)db.get(KafkaRequest.class, reqId);
//            if (req == null) {
//                return null;
//            }
//            if (req.getState() == Constant.QUEUE_READY) {
//                trx = db.beginTransaction();
//                req.setState(Constant.QUEUE_PROCESSING);
//                req.setLastModifiedDate(new Date());
//                db.update(req);
//                trx.commit();
//                trx = null;
//            }
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode node = mapper.readTree(req.getPayload());
//            return node;
//        } catch (final Exception ex) {
//            logger.error("Error", ex);
//            if (trx != null) {
//                trx.rollback();
//            }
//            throw ex;
//        } finally {
//            DBService.getInstance().closeSession(db);
//        }
        return null;
    }

    /**
     *
     * @param reqId
     * @throws Exception
     */
    public void completeRequest(long reqId)
            throws Exception {
//        Session db = null;
//        Transaction trx = null;
//        try {
//            db = DBService.getInstance().openSession();
//            KafkaRequest req = (KafkaRequest)db.get(KafkaRequest.class, reqId);
//            if (req == null) {
//                return;
//            }
//            if (req.getState() != Constant.QUEUE_DONE_SUCCESS) {
//                trx = db.beginTransaction();
//                req.setState(Constant.QUEUE_DONE_SUCCESS);
//                req.setLastModifiedDate(new Date());
//                db.update(req);
//                trx.commit();
//                trx = null;
//            }
//
//        } catch (final Exception ex) {
//            logger.error("Error", ex);
//            if (trx != null) {
//                trx.rollback();
//            }
//            throw ex;
//        } finally {
//            DBService.getInstance().closeSession(db);
//        }
    }

    /**
     *
     * @param eventId
     * @param topic
     */
    protected void addEventTopicLog(int eventId, String topic, int state, String error) {
//        if (eventId > 0) {
//            Session db = null;
//            Transaction trx = null;
//            try {
//                db = DBService.getInstance().openSession();
//                trx = db.beginTransaction();
//                if (error != null && error.length() > 2000) {
//                    error = error.substring(0, 2000);
//                }
//                db.createSQLQuery(insert_event_topic_log)
//                        .setParameter("id", eventId)
//                        .setParameter("topic", topic)
//                        .setParameter("state", state)
//                        .setParameter("error", error)
//                        .executeUpdate();
//                trx.commit();
//                trx = null;
//
//            } catch (Exception ex) {
//                logger.error("Error", ex);
//                if (trx != null) {
//                    trx.rollback();
//                }
//            } finally {
//                DBService.getInstance().closeSession(db);
//            }
//        }
    }

    /**
     *
     * @param payload
     * @return
     */
    protected int getEventId(JsonNode payload) {
        try {
//            return payload.get(EBAConstant.EBA_PAYLOAD_ITEM_EVENT_ID).asInt();
        } catch (Exception ex) {
//            logger.error("Error", ex);
            return 0;
        }
        return 1001;
    }

    /**
     *
     * @param payload
     * @return
     */
    protected int getEventType(JsonNode payload) {
        try {
//            return payload.get(EBAConstant.EBA_PAYLOAD_ITEM_EVENT_TYPE).asInt();
        } catch (Exception ex) {
//            logger.error("Error", ex);
            return 0;
        }
        return 101;
    }

}
