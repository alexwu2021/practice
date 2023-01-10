package com.docmatter.ims.domain.model;

import com.docmatter.ims.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TopicDwFeedEventPayload {
    public String event_type;
    public int uid;
    public int noti_id;
    public int noti_email_id;
    public String category;
    public long open_date;
    public int user_state;
    public long date;
    public List<Long> discussion_thread_id_list;
    public List<Long> post_id_list;
    public List<Long> post_author_list;
    public List<Long> user_cid_list;
    public List<Long> discussion_cid_list;


    public TopicDwFeedEventPayload(){
        this.discussion_cid_list = new ArrayList<>();
        this.post_id_list = new ArrayList<>();
        this.post_author_list = new ArrayList<>();
        this.discussion_thread_id_list = new ArrayList<>();
    }

//    public OperationEnum event_type; // possible value: “email-open”
//    public int uid; // ID of the user who received and opened the email
//    public int noti_id; // notification.id
//    public int noti_email_id; // notification_em.id
//    public String category; // notification category
//    public long open_date; // date of opened, System.currentTimeMillis() of the open date
//    public List<Long> discussion_thread_id_list; // array of NUMBERs (thread IDs of the discussion)
//    public List<Long> post_id_list; // array of NUMBERs (ID of invidiaul posts in the mentioned)
//    public List<Long> user_cid_list; // array of NUMBERS (community cids that user is member of)
//    public List<Long> discussion_cid_list; // array of NUMBERS (community cids that the discussion belongs to)
//
//    public List<Long> post_author_list; // array of NUMBER (user IDs of the authors of posts in the email)
//    public long invite_id; // ID of invitation)
//    public int invite_afu_path_id; // ID of invite auto follow-up path ID
//    public int invite_afu_step_id; // ID Of invite auto follow-up step ID
//    public long date; // System.currentTimeMillis(), datetime of this topic published
//    public int user_state; // NUMBER (1 for active, 2 for ghost) – user account state of the person who opened the email

    public String toJson(){
        return JsonUtil.toJson(this);
    }

    @Override
    public String toString() {
        return "TopicDwFeedEventPayload{" +
                "event_type='" + event_type + '\'' +
                ", uid=" + uid +
                ", noti_id=" + noti_id +
                ", noti_email_id=" + noti_email_id +
                ", category='" + category + '\'' +
                ", open_date=" + open_date +
                ", user_state=" + user_state +
                ", date=" + date +
                ", discussion_thread_id_list=" + discussion_thread_id_list +
                ", post_id_list=" + post_id_list +
                ", post_author_list=" + post_author_list +
                ", user_cid_list=" + user_cid_list +
                ", discussion_cid_list=" + discussion_cid_list +
                '}';
    }
}
