package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类 菜系表
 */
@Alias("Cuisine")
public class Cuisine implements java.io.Serializable {
    private static final long serialVersionUID = 4641022957862877019L;
    private Integer cuisineId;
    private String cuisineName;

    public Cuisine() {
    }

    /**
     * @param cuisineId   菜系Id
     * @param cuisineName 菜系名称
     */
    public Cuisine(Integer cuisineId, String cuisineName) {
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
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

    /**
     * @return 菜系名称
     */
    public String getCuisineName() {
        return cuisineName;
    }

    /**
     * @param cuisineName 菜系名称
     */
    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    @Override
    public String toString() {
        return "Cuisine{" +
                "cuisineId=" + cuisineId +
                ", cuisineName='" + cuisineName + '\'' +
                '}';
    }
}
