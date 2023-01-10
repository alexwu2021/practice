package com.docmatter.ims.constant;

public class ImsConstant {

    public static String SPLITTER = ",";
    public static String FACT_FILE_EXT = ".fac";
    public static String EXPLODED_FACT_FILE_EXT = ".exf";

    //    INPUT DATA
    public static String BASE_DIRECTORY = "/Users/prodadmin/pocmp/";

    public static String INPUT_FILE_FOLDER = BASE_DIRECTORY + "/mapred/input/";
    public static String CTX_MESSAGE_INPUT_FILE = INPUT_FILE_FOLDER + "ctxMessage.mpi";
    public static String POST_COMM_INPUT_FILE = INPUT_FILE_FOLDER + "postComm.mpi";
    public static final String NOTIFICATION_CTX_MESSAGE_INPUT_FILE = INPUT_FILE_FOLDER + "notificationCtxMessage.mpi";
    public static String LOG_NOTIFICATION_EMAIL_VIEW_INPUT_FILE = INPUT_FILE_FOLDER + "logNotificationEmailView.mpi";
    public static final String EMAIL_OPEN_UDT_INPUT_FILE = INPUT_FILE_FOLDER + "emailOpenUdt.mpi";

//    REFERENCE DATA
    public static final String REFERENCE_DATA_CONTAINING_FOLDER =  BASE_DIRECTORY + "/mapred/reference_data/";
    public static final String REFERENCE_DATA_CONTAINING_FOLDER_BASE = REFERENCE_DATA_CONTAINING_FOLDER + "base/";

    public static final String USER_COMMUNITY_INPUT_FILE =  REFERENCE_DATA_CONTAINING_FOLDER_BASE + "userCommunity.mpi";;
    public static final String USER_PRODUCT_GROUP_INPUT_FILE =  REFERENCE_DATA_CONTAINING_FOLDER_BASE + "userProductGroup.mpi";;
    public static String CTX_ENTITY_INPUT_FILE = REFERENCE_DATA_CONTAINING_FOLDER_BASE + "ctxEntity.mpi";
    public static String COMMUNITY_INPUT_FILE = REFERENCE_DATA_CONTAINING_FOLDER_BASE + "community.mpi";
    public static String PRODUCT_GROUP_INPUT_FILE = REFERENCE_DATA_CONTAINING_FOLDER_BASE + "productGroup.mpi";
    public static String CTX_ENTITY_REL_INPUT_FILE = REFERENCE_DATA_CONTAINING_FOLDER_BASE + "ctxEntityRel.mpi";

    public static final String REFERENCE_DATA_CONTAINING_FOLDER_COMPUTED = REFERENCE_DATA_CONTAINING_FOLDER + "computed/";
    public static final String REFERENCE_DATA_USER_2_NUGLIST_FILE_NAME = REFERENCE_DATA_CONTAINING_FOLDER_COMPUTED + "user_2_nugList.ref";
    public static final String REFERENCE_DATA_USER_COLLECTION_FILE_NAME =  REFERENCE_DATA_CONTAINING_FOLDER_COMPUTED + "userIds.ref";;

    //    INTERMEDIATE DATA
    public static String FACT_FILE_OUTPUT_FOLDER =  BASE_DIRECTORY + "/mapred/output/fact_files/";
    public static String EXPLODED_FACT_FILE_OUTPUT_FOLDER =  BASE_DIRECTORY + "/mapred/output/exploded_fact_files/";

    public static int MB_SIZE = 1024 * 1024;
    public static int DEFAULT_CHAR_BUFFER_SIZE = 100_100;

    public static String HEALTH_MONITORING_FILE =  BASE_DIRECTORY + "/health_monitoring/health_monitoring.hmn";


    public static String PAY_LOAD_DATA_FILE = "/Users/Alex/pocmp/mockdata/postpayload.json";

}
