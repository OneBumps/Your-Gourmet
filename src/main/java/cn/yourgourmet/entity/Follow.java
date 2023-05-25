package cn.yourgourmet.entity;

/**
 * 用户实体类 关注表  【用户--关注--用户】
 */
public class Follow implements java.io.Serializable {
    private static final long serialVersionUID = -2338542025231338966L;
    private int userId;
    private int followedUserId;

    public Follow() {
    }

    /**
     * @param userId         用户Id
     * @param followedUserId 被关注用户Id
     */
    public Follow(int userId, int followedUserId) {
        this.userId = userId;
        this.followedUserId = followedUserId;
    }

    /**
     * @return 用户Id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId 用户Id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return 被关注用户Id
     */
    public int getFollowedUserId() {
        return followedUserId;
    }

    /**
     * @param followedUserId 被关注用户Id
     */
    public void setFollowedUserId(int followedUserId) {
        this.followedUserId = followedUserId;
    }
}
