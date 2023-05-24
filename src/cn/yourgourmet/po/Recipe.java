package cn.yourgourmet.po;

import com.mchange.util.ByteArrayMap;

import java.util.Date;

/**
 * 用户实体类 菜谱表
 */
public class Recipe implements java.io.Serializable {
    private static final long serialVersionUID = 6859146815109407023L;
    private int recipeId;
    private int userId;
    private Date recipePublishTime;
    private String DishName;
    private ByteArrayMap recipeImage;
    private String recipeIntro;
    private String recipeVideoLocation;
    private String likeCount;
    private String dislikeCount;

    public Recipe() {
    }

    /**
     * @param recipeId            菜谱ID
     * @param userId              用户ID
     * @param recipePublishTime   发布时间
     * @param dishName            菜名
     * @param recipeImage         菜谱图片
     * @param recipeIntro         菜谱简介
     * @param recipeVideoLocation 菜谱视频
     * @param likeCount           点赞数
     * @param dislikeCount        点踩数
     */
    public Recipe(int recipeId, int userId, Date recipePublishTime, String dishName, ByteArrayMap recipeImage, String recipeIntro, String recipeVideoLocation, String likeCount, String dislikeCount) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.recipePublishTime = recipePublishTime;
        DishName = dishName;
        this.recipeImage = recipeImage;
        this.recipeIntro = recipeIntro;
        this.recipeVideoLocation = recipeVideoLocation;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }

    /**
     * @return 菜谱ID
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱ID
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 用户ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId 用户ID
     */
    public void setUserId(int userId) {
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
    public String getDishName() {
        return DishName;
    }

    /**
     * @param dishName 菜名
     */
    public void setDishName(String dishName) {
        DishName = dishName;
    }

    /**
     * @return 菜谱图片
     */
    public ByteArrayMap getRecipeImage() {
        return recipeImage;
    }

    /**
     * @param recipeImage 菜谱图片
     */
    public void setRecipeImage(ByteArrayMap recipeImage) {
        this.recipeImage = recipeImage;
    }

    /**
     * @return 菜谱简介
     */
    public String getRecipeIntro() {
        return recipeIntro;
    }

    /**
     * @param recipeIntro 菜谱简介
     */
    public void setRecipeIntro(String recipeIntro) {
        this.recipeIntro = recipeIntro;
    }

    /**
     * @return 菜谱视频
     */
    public String getRecipeVideoLocation() {
        return recipeVideoLocation;
    }

    /**
     * @param recipeVideoLocation 菜谱视频
     */
    public void setRecipeVideoLocation(String recipeVideoLocation) {
        this.recipeVideoLocation = recipeVideoLocation;
    }

    /**
     * @return 点赞数
     */
    public String getLikeCount() {
        return likeCount;
    }

    /**
     * @param likeCount 点赞数
     */
    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * @return 点踩数
     */
    public String getDislikeCount() {
        return dislikeCount;
    }

    /**
     * @param dislikeCount 点踩数
     */
    public void setDislikeCount(String dislikeCount) {
        this.dislikeCount = dislikeCount;
    }
}
