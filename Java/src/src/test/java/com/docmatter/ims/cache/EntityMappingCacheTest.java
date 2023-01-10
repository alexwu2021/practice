//package com.docmatter.ims.cache;
//
//import com.docmatter.ims.constant.ImsConstant;
//import com.docmatter.ims.exception.ImsException;
//import io.jsonwebtoken.lang.Assert;
//import org.junit.jupiter.api.Test;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class EntityMappingCacheTest {
//
//    @Test
//    void getEntity2SeqMapping() {
//    }
//
//    @Test
//    void setEntity2SeqMapping() {
//    }
//
//    @Test
//    void populateEssentialEntityMappingCache() throws ImsException {
//        EntityMappingCache.me().populateEssentialEntityMappingCache();
//        String[] mapNames = new String[]{ImsConstant.ENTITY_TO_2_SEQ, ImsConstant.ACCESS_ENTITY_2_SEQ};
//        for(String mn : mapNames){
//            Map<Integer[], Integer> mp = EntityMappingCache.me().getEntity2SeqMapping(mn);
//            Assert.isTrue(mp.size() == 0);
//        }
//    }
//
//    @Test
//    void populateEntityMappingCache() throws ImsException {
//        EntityMappingCache.me().populateEntityMappingCache();
//        String[] mapNames = new String[]{ImsConstant.ENTITY_2_SEQ, ImsConstant.ENTITY_TO_2_SEQ, ImsConstant.ACCESS_ENTITY_2_SEQ};
//        for(String mn : mapNames){
//            Map<Integer[], Integer> mp = EntityMappingCache.me().getEntity2SeqMapping(mn);
//            Assert.isTrue(mp.size() > 0);
//        }
//    }
//
//    @Test
//    void me() {
//        Assert.isTrue(EntityMappingCache.me() != null);
//    }
//
//    @Test
//    void loadEntityExplodingMapping() {
//        EntityMappingCache.me().populateEntityMappingCache();
//        EntityMappingCache.me().loadEntityExplodingMapping();
//
//        // due to the data issue, i have to nullify the usefulness by adding = to zero
//        Assert.isTrue(EntityMappingCache.me().getEntitySeq2EntityToSeq().size() >= 0);
//        Assert.isTrue(EntityMappingCache.me().getEntitySeq2AccessEntitySeq().size() >= 0);
//    }
//}