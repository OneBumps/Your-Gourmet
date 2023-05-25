package cn.yourgourmet.entity;

/**
 * 用户实体类 使用表  【菜谱--使用--食材】
 */
public class Uses implements java.io.Serializable {
    private static final long serialVersionUID = -3899918517339780731L;
    private int recipeId;
    private int ingredientId;
    private String ingredientAmount;

    public Uses() {
    }

    /**
     * @param recipeId         菜谱Id
     * @param ingredientId     食材Id
     * @param ingredientAmount 食材用量
     */
    public Uses(int recipeId, int ingredientId, String ingredientAmount) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.ingredientAmount = ingredientAmount;
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
     * @return 食材Id
     */
    public int getIngredientId() {
        return ingredientId;
    }

    /**
     * @param ingredientId 食材Id
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    /**
     * @return 食材用量
     */
    public String getIngredientAmount() {
        return ingredientAmount;
    }

    /**
     * @param ingredientAmount 食材用量
     */
    public void setIngredientAmount(String ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }
}
