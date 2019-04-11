package com.skytech.api.model;

/**
 * Created by LiWei on 2019/4/5.
 */
public class MyActivity {
    //活动id
    Integer activityId;
    //活动名称
    String activityName;
    //活动图片
    String activityPic;
    //活动时间
    String activityTime;
    //活动加入人数
    String activityJoinedNum;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityPic() {
        return activityPic;
    }

    public void setActivityPic(String activityPic) {
        this.activityPic = activityPic;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getActivityJoinedNum() {
        return activityJoinedNum;
    }

    public void setActivityJoinedNum(String activityJoinedNum) {
        this.activityJoinedNum = activityJoinedNum;
    }
}
