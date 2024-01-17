package com.example.zhihuapp.api;

import com.hjq.http.config.IRequestApi;
import com.hjq.http.config.IRequestServer;

import androidx.annotation.NonNull;

public final class AnswerApi implements IRequestServer, IRequestApi {

    private String DEF = "data%5B%2A%5D.is_normal%2Cadmin_closed_comment%2Creward_info%2Cis_collapsed%2Cannotation_action%2Cannotation_detail%2Ccollapse_reason%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cattachment%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Ccreated_time%2Cupdated_time%2Creview_info%2Crelevant_info%2Cquestion%2Cexcerpt%2Cis_labeled%2Cpaid_info%2Cpaid_info_content%2Creaction_instruction%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%3Bdata%5B%2A%5D.mark_infos%5B%2A%5D.url%3Bdata%5B%2A%5D.author.follower_count%2Cvip_info%2Cbadge%5B%2A%5D.topics%3Bdata%5B%2A%5D.settings.table_of_content.enabled&order=default&platform=desktop";
    //    private String DEF2 = "data[*].is_normal,admin_closed_comment,reward_info,is_collapsed,annotation_action,annotation_detail,collapse_reason,is_sticky,collapsed_by,suggest_edit,comment_count,can_comment,content,editable_content,voteup_count,reshipment_settings,comment_permission,created_time,updated_time,review_info,question,excerpt,is_labeled,paid_info,paid_info_content,relationship.is_authorized,voting,is_author,is_thanked,is_nothelp,is_recognized,mark_infos[*].url;data[*].author.follower_count,vip_info,badge[*].topics;data[*].settings.table_of_content.enabled";
    String answerId = "";
    String limit = "5";
    String offset = "0";

    public String getAnswerId() {
        return answerId;
    }

    public AnswerApi setAnswerId(String answerId) {
        this.answerId = answerId;
        return this;
    }

    public String getLimit() {
        return limit;
    }

    public AnswerApi setLimit(String limit) {
        this.limit = limit;
        return this;
    }

    public String getOffset() {
        return offset;
    }

    public AnswerApi setOffset(String offset) {
        this.offset = offset;
        return this;
    }

    @NonNull
    @Override
    public String getHost() {
        return "https://api.zhihu.com/questions/";
    }

    @NonNull
    @Override
    public String getApi() {
        return getAnswerId() + "/answers?limit=" + getLimit() + "&offset=" + getOffset() + "&include=" + DEF;
    }
}