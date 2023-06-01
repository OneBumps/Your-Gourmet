package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类 收藏表  【用户--收藏--菜谱】
 */
@Alias("Favorite")
public class Favorite implements java.io.Serializable {
    private static final long serialVersionUID = -3232444241106115454L;
    private String userId;
    private Integer recipeId;

    public Favorite() {
    }

    /**
     * @param userId   用户id
     * @param recipeId 菜谱id
     */
    public Favorite(String userId, Integer recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
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

    @Override
    public String toString() {
        return "Favorite{" +
                "userId=" + userId +
                ", recipeId=" + recipeId +
                '}';
    }
}
