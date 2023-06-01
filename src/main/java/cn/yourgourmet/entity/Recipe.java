package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

import java.util.Arrays;
import java.util.Date;

/**
 * 用户实体类 菜谱表
 */
@Alias("Recipe")
public class Recipe implements java.io.Serializable {
    private static final long serialVersionUID = 6859146815109407023L;
    private Integer recipeId;
    private String userId;
    private Date recipePublishTime;
    private String recipeName;
    private String recipeImage;
    private String recipeIntroduction;
    private String recipeVideo;
    private Integer recipeLike;
    private Integer recipeDislike;

    public Recipe() {
    }

    /**
     * @param recipeId           菜谱ID
     * @param userId             用户ID
     * @param recipePublishTime  发布时间
     * @param recipeName         菜名
     * @param recipeImage        菜谱图片
     * @param recipeIntroduction 菜谱简介
     * @param recipeVideo        菜谱视频
     * @param recipeLike         点赞数
     * @param recipeDislike      点踩数
     */
    public Recipe(Integer recipeId, String userId, Date recipePublishTime, String recipeName, String recipeImage, String recipeIntroduction, String recipeVideo, Integer recipeLike, Integer recipeDislike) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.recipePublishTime = recipePublishTime;
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
        this.recipeIntroduction = recipeIntroduction;
        this.recipeVideo = recipeVideo;
        this.recipeLike = recipeLike;
        this.recipeDislike = recipeDislike;
    }

    /**
     * @return 菜谱ID
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱ID
     */
    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return 发布时间
     */
    public Date getRecipePublishTime() {
        return recipePublishTime;
    }

    /**
     * @param recipePublishTime 发布时间
     */
    public void setRecipePublishTime(Date recipePublishTime) {
        this.recipePublishTime = recipePublishTime;
    }

    /**
     * @return 菜名
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName 菜名
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return 菜谱图片
     */
    public String getRecipeImage() {
        return recipeImage;
    }

    /**
     * @param recipeImage 菜谱图片
     */
    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    /**
     * @return 菜谱简介
     */
    public String getRecipeIntroduction() {
        return recipeIntroduction;
    }

    /**
     * @param recipeIntroduction 菜谱简介
     */
    public void setRecipeIntroduction(String recipeIntroduction) {
        this.recipeIntroduction = recipeIntroduction;
    }

    /**
     * @return 菜谱视频
     */
    public String getRecipeVideo() {
        return recipeVideo;
    }

    /**
     * @param recipeVideo 菜谱视频
     */
    public void setRecipeVideo(String recipeVideo) {
        this.recipeVideo = recipeVideo;
    }

    /**
     * @return 点赞数
     */
    public Integer getRecipeLike() {
        return recipeLike;
    }

    /**
     * @param recipeLike 点赞数
     */
    public void setRecipeLike(Integer recipeLike) {
        this.recipeLike = recipeLike;
    }

    /**
     * @return 点踩数
     */
    public Integer getRecipeDislike() {
        return recipeDislike;
    }

    /**
     * @param recipeDislike 点踩数
     */
    public void setRecipeDislike(Integer recipeDislike) {
        this.recipeDislike = recipeDislike;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", userId='" + userId + '\'' +
                ", recipePublishTime=" + recipePublishTime +
                ", recipeName='" + recipeName + '\'' +
                ", recipeImage='" + recipeImage + '\'' +
                ", recipeIntroduction='" + recipeIntroduction + '\'' +
                ", recipeVideo='" + recipeVideo + '\'' +
                ", recipeLike=" + recipeLike +
                ", recipeDislike=" + recipeDislike +
                '}';
    }
}
