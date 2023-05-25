package cn.yourgourmet.entity;

import java.util.Date;

/**
 * 用户实体类 评论表
 */
public class Review implements java.io.Serializable {
    private static final long serialVersionUID = -6713267836925470618L;
    private int userId;
    private int recipeId;
    private Date reviewTime;
    private String reviewTextContent;
    private String reviewImageLocation;

    public Review() {
    }

    /**
     * @param userId              用户id
     * @param recipeId            菜谱id
     * @param reviewTime          评论时间
     * @param reviewTextContent   评论内容
     * @param reviewImageLocation 评论图片
     */
    public Review(int userId, int recipeId, Date reviewTime, String reviewTextContent, String reviewImageLocation) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.reviewTime = reviewTime;
        this.reviewTextContent = reviewTextContent;
        this.reviewImageLocation = reviewImageLocation;
    }

    /**
     * @return 用户id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId 用户id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return 菜谱id
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱id
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 评论时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * @param reviewTime 评论时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * @return 评论内容
     */
    public String getReviewTextContent() {
        return reviewTextContent;
    }

    /**
     * @param reviewTextContent 评论内容
     */
    public void setReviewTextContent(String reviewTextContent) {
        this.reviewTextContent = reviewTextContent;
    }

    /**
     * @return 评论图片
     */
    public String getReviewImageLocation() {
        return reviewImageLocation;
    }

    /**
     * @param reviewImageLocation 评论图片
     */
    public void setReviewImageLocation(String reviewImageLocation) {
        this.reviewImageLocation = reviewImageLocation;
    }
}
