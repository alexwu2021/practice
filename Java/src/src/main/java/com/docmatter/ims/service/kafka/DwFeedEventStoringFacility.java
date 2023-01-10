package com.docmatter.ims.service.kafka;

import com.docmatter.ims.db.jpa.DimCommunitiesEntity;
import com.docmatter.ims.db.jpa.DimReferenceDataStructureEntity;
import com.docmatter.ims.db.jpa.DimUsersEntity;
import com.docmatter.ims.db.jpa.FactsEntity;
import com.docmatter.ims.domain.model.TopicDwFeedEventPayload;
import com.docmatter.ims.repository.dw.*;
import com.docmatter.ims.util.DateTimeUtil;
import com.docmatter.ims.util.HashUtil;
import com.docmatter.ims.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:dev/application.yml")
public class DwFeedEventStoringFacility{

    @Autowired
    private IDimUserEntityRepository iDimUserEntityRepository;

    public IDimUserEntityRepository getiDimUserEntityRepository(){
        return iDimUserEntityRepository;
    }


    @Autowired
    private IDimReferenceDataStructureEntityRepository iDimReferenceDataStructureEntityRepository;

    @Autowired
    private IDimCommunitiesEntityRepository iDimCommunitiesEntityRepository;

    @Autowired
    private IDimProductGroupEntityRepository iDimProductGroupEntityRepository;

    @Autowired
    private IFactsEntityRepository iFactsEntityRepository;


    @Value("${appConfig.KafkaServers}")
    public String KAFKA_SERVERS;

    public DwFeedEventStoringFacility(){
        System.out.println("DwFeedEventStoringFacility created");
    }


    private void saveUserToDw(TopicDwFeedEventPayload topicDwFeedEventPayload) {
        System.out.println("in saveUserToDw, TopicDwFeedEventPayload: " + topicDwFeedEventPayload);
        try {
            DimUsersEntity dimUsersEntity = new DimUsersEntity();
            dimUsersEntity.setUid(topicDwFeedEventPayload.uid);
            if(iDimUserEntityRepository != null){
                iDimUserEntityRepository.save(dimUsersEntity);
                System.out.println("user with id of " + topicDwFeedEventPayload.uid + " saved to dw user table.");
            }else{
                System.out.println("no op due to null iDimUserEntityRepository");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saveRefDtToDw(TopicDwFeedEventPayload topicDwFeedEventPayload) {
        System.out.println("in saveRefDtToDw, user_cid_list size is " + topicDwFeedEventPayload.user_cid_list.size());
        for(Long cid : topicDwFeedEventPayload.user_cid_list){
            DimCommunitiesEntity dimCommunitiesEntity = new DimCommunitiesEntity();
            dimCommunitiesEntity.setNugId(cid);
            try {
                if(iDimCommunitiesEntityRepository != null){
                    iDimCommunitiesEntityRepository.save(dimCommunitiesEntity);
                    System.out.println("community with id of " + cid + " saved to dw community table");
                }else{
                    System.out.println("no op due to null iDimCommunitiesEntityRepository");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        // under development
        try {
            DimReferenceDataStructureEntity dimReferenceDataStructureEntity = new DimReferenceDataStructureEntity();
            dimReferenceDataStructureEntity.setDateId(DateTimeUtil.getDefaultDimDateId());
            dimReferenceDataStructureEntity.setUid(topicDwFeedEventPayload.uid);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for(Long cid: topicDwFeedEventPayload.user_cid_list){
                i++;
                sb.append(cid);
                if(i < topicDwFeedEventPayload.user_cid_list.size()){
                    sb.append( ",");
                }
            }
            dimReferenceDataStructureEntity.setNugIds(sb.toString());
            if (iDimReferenceDataStructureEntityRepository != null) {
                iDimReferenceDataStructureEntityRepository.save(dimReferenceDataStructureEntity);
                System.out.println("DimReferenceDataStructureEntity " + dimReferenceDataStructureEntity.toString() + " saved to dw refdt table");
            }else{
                System.out.println("no op due to null iDimReferenceDataStructureEntityRepository");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveFactToDw(TopicDwFeedEventPayload topicDwFeedEventPayload) {
        System.out.println("in saveFactToDw, TopicDwFeedEventPayload: " + topicDwFeedEventPayload);
        try {
            System.out.println("saveFactToDw");
            Integer actionTargetId = 1;
            Integer measuredOperationId  = 5;
            FactsEntity factsEntity = new FactsEntity();
            factsEntity.setActionUserId(topicDwFeedEventPayload.uid);
            factsEntity.setFactUuidHash(HashUtil.getUuidHash());
            factsEntity.setActionTargetId(actionTargetId);
            factsEntity.setExtractionDateId(DateTimeUtil.getDefaultDimDateId());
            factsEntity.setEventDateId(DateTimeUtil.getDimDateIdFromDateTicks(topicDwFeedEventPayload.open_date));
            factsEntity.setOperationId(measuredOperationId);
            factsEntity.setProcessingStatusId(11);
            if(iFactsEntityRepository != null){
                iFactsEntityRepository.save(factsEntity);
                System.out.println("fact with value of " + factsEntity.toString() + " saved to dw facts table");
            }else{
                System.out.println("no op due to null iFactsEntityRepository");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("done saveFactToDw");
        }
    }

    public void saveToDwTables(String jsonString) {
        System.out.println("in saveToDwTables, jsonString: " + jsonString);
        try{
            if(jsonString != null && jsonString.length() > 0)
                System.out.println("in saveToDwTables, receiving jsonString as " + jsonString);
            TopicDwFeedEventPayload topicDwFeedEventPayload = JsonUtil.fromJson(jsonString);
            if(topicDwFeedEventPayload != null){
                saveUserToDw(topicDwFeedEventPayload);
                saveRefDtToDw(topicDwFeedEventPayload);
                saveFactToDw(topicDwFeedEventPayload);
            }else{
                System.out.println("----- Failed to deserialize from the feed " + jsonString) ;
            }
        }catch (Exception ex){
            System.out.println("##### exception encountered in saveToDwTables " + ex);
        }finally {
            System.out.println("done saveToDwTables()");
        }
    }

}


