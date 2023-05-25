package cn.yourgourmet.entity;

/**
 * 用户实体类 收藏表  【用户--收藏--菜谱】
 */
public class Favorite implements java.io.Serializable {
    private static final long serialVersionUID = -3232444241106115454L;
    private int userId;
    private int recipeId;

    public Favorite() {
    }

    /**
     * @param userId   用户id
     * @param recipeId 菜谱id
     */
    public Favorite(int userId, int recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
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
}
