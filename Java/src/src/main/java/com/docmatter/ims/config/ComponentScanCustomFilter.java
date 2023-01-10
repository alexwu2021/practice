package com.docmatter.ims.config;


import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ComponentScanCustomFilter implements TypeFilter {

    private Set<String> excluded;
    @Override
    public boolean match(MetadataReader metadataReader,
                         MetadataReaderFactory metadataReaderFactory) throws IOException {
        excluded = getClassesToExclude();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String fullyQualifiedName = classMetadata.getClassName();
        String className = fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf(".") + 1);
        System.out.println("className found to be " + className);
//        if(excluded.contains(className)){
//            System.out.println("excluding " + className);
//            return false;
//        }
        return true;
    }

    private Set<String> getClassesToExclude() {
        Set<String> ret = new HashSet<>();
        ret.add("CtxEntityBatchConfig.class");
        ret.add("CtxEntityRelBatchConfig.class");
        ret.add("UserCommunityBatchConfig.class");
        ret.add("UserProductGroupBatchConfig.class");
        ret.add("CtxMessageBatchConfig.class");
        ret.add("NotificationCtxMessageBatchConfig.class");
        ret.add("LogNotificationEmailViewBatchConfig.class");
        ret.add("EmailOpenUdtBatchConfig.class");
        return ret;
    }
}

