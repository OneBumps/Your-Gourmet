package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类 使用表  【菜谱--使用--食材】
 */
@Alias("Uses")
public class Uses implements java.io.Serializable {
    private static final long serialVersionUID = -3899918517339780731L;
    private Integer recipeId;
    private Integer ingredientId;
    private String ingredientAmount;

    public Uses() {
    }

    /**
     * @param recipeId         菜谱Id
     * @param ingredientId     食材Id
     * @param ingredientAmount 食材用量
     */
    public Uses(Integer recipeId, Integer ingredientId, String ingredientAmount) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.ingredientAmount = ingredientAmount;
    }

    /**
     * @return 菜谱Id
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId 菜谱Id
     */
    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return 食材Id
     */
    public Integer getIngredientId() {
        return ingredientId;
    }

    /**
     * @param ingredientId 食材Id
     */
    public void setIngredientId(Integer ingredientId) {
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

    @Override
    public String toString() {
        return "Uses{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                ", ingredientAmount='" + ingredientAmount + '\'' +
                '}';
    }
}
