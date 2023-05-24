package cn.yourgourmet.po;

/**
 * 用户实体类 食材表
 */
public class Ingredient implements java.io.Serializable {
    private static final long serialVersionUID = 5482350501113210646L;
    private int ingredientId;
    private String ingredientName;
    private String ingredientCategory;
    private String ingredientAlias;

    public Ingredient() {
    }

    /**
     * @param ingredientId       食材Id
     * @param ingredientName     食材名称
     * @param ingredientCategory 食材分类
     * @param ingredientAlias    食材别名
     */
    public Ingredient(int ingredientId, String ingredientName, String ingredientCategory, String ingredientAlias) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
        this.ingredientAlias = ingredientAlias;
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
     * @return 食材名称
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * @param ingredientName 食材名称
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * @return 食材分类
     */
    public String getIngredientCategory() {
        return ingredientCategory;
    }

    /**
     * @param ingredientCategory 食材分类
     */
    public void setIngredientCategory(String ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }

    /**
     * @return 食材别名
     */
    public String getIngredientAlias() {
        return ingredientAlias;
    }

    /**
     * @param ingredientAlias 食材别名
     */
    public void setIngredientAlias(String ingredientAlias) {
        this.ingredientAlias = ingredientAlias;
    }
}
