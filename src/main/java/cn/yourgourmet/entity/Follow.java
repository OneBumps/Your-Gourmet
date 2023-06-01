package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类 关注表  【用户--关注--用户】
 */
@Alias("Follow")
public class Follow implements java.io.Serializable {
    private static final long serialVersionUID = -2338542025231338966L;
    private String userId;
    private String followId;

    public Follow() {
    }

    /**
     * @param userId   用户Id
     * @param followId 被关注用户Id
     */
    public Follow(String userId, String followId) {
        this.userId = userId;
        this.followId = followId;
    }

    /**
     * @return 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return 被关注用户Id
     */
    public String getFollowId() {
        return followId;
    }

    /**
     * @param followId 被关注用户Id
     */
    public void setFollowId(String followId) {
        this.followId = followId;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "userId=" + userId +
                ", followedUserId=" + followId +
                '}';
    }
}
