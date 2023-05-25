package cn.yourgourmet.entity;

/**
 * 用户实体类 归属表  【菜谱--归属--菜系】
 */
public class Belong implements java.io.Serializable {
    private static final long serialVersionUID = 5101892586614439416L;

    private int recipeId;
    private int cuisineId;

    public Belong() {
    }

    /**
     * @param recipeId  菜谱Id
     * @param cuisineId 菜系Id
     */
    public Belong(int recipeId, int cuisineId) {
        this.recipeId = recipeId;
        this.cuisineId = cuisineId;
    }

    /**
     * @return 菜谱Id
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱Id
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 菜系Id
     */
    public int getCuisineId() {
        return cuisineId;
    }

    /**
     * @param cuisineId 菜系Id
     */
    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }
}