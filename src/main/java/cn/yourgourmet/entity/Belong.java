package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类 归属表  【菜谱--归属--菜系】
 */
@Alias("Belong")
public class Belong implements java.io.Serializable {
    private static final long serialVersionUID = 5101892586614439416L;

    private Integer recipeId;
    private Integer cuisineId;

    public Belong() {
    }

    /**
     * @param recipeId  菜谱Id
     * @param cuisineId 菜系Id
     */
    public Belong(Integer recipeId, Integer cuisineId) {
        this.recipeId = recipeId;
        this.cuisineId = cuisineId;
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
     * @return 菜系Id
     */
    public Integer getCuisineId() {
        return cuisineId;
    }

    /**
     * @param cuisineId 菜系Id
     */
    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    @Override
    public String toString() {
        return "Belong{" +
                "recipeId=" + recipeId +
                ", cuisineId=" + cuisineId +
                '}';
    }
}