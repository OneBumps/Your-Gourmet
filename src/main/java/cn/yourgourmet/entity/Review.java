package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 用户实体类 评论表
 */
@Alias("Review")
public class Review implements java.io.Serializable {
    private static final long serialVersionUID = -6713267836925470618L;
    private String userId;
    private Integer recipeId;
    private Date reviewTime;
    private String reviewContent;
    private String reviewImage;

    public Review() {
    }

    /**
     * @param userId              用户id
     * @param recipeId            菜谱id
     * @param reviewTime          评论时间
     * @param reviewContent   评论内容
     * @param reviewImage 评论图片
     */
    public Review(String userId, Integer recipeId, Date reviewTime, String reviewContent, String reviewImage) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.reviewTime = reviewTime;
        this.reviewContent = reviewContent;
        this.reviewImage = reviewImage;
    }

    /**
     * @return 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return 菜谱id
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱id
     */
    public void setRecipeId(Integer recipeId) {
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
    public String getReviewContent() {
        return reviewContent;
    }

    /**
     * @param reviewContent 评论内容
     */
    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    /**
     * @return 评论图片
     */
    public String getReviewImage() {
        return reviewImage;
    }

    /**
     * @param reviewImage 评论图片
     */
    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }

    @Override
    public String toString() {
        return "Review{" +
                "userId=" + userId +
                ", recipeId=" + recipeId +
                ", reviewTime=" + reviewTime +
                ", reviewTextContent='" + reviewContent + '\'' +
                ", reviewImageLocation='" + reviewImage + '\'' +
                '}';
    }
}
