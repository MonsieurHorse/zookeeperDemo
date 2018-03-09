package com.common.zookeeper;

/**
 * Created by junbaoma on 2017/12/12.
 */
public class NoticeInfo {

    private String noticeId;
    private Integer noticeType;
    private Integer actionType;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NoticeInfo{");
        sb.append("noticeId='").append(noticeId).append('\'');
        sb.append(", noticeType=").append(noticeType);
        sb.append(", actionType=").append(actionType);
        sb.append('}');
        return sb.toString();
    }
}
