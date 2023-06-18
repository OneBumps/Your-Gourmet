package cn.yourgourmet.mapper;


import org.apache.ibatis.annotations.Param;

public interface BelongMapper {
    Integer selectCuisineIdByRecipeId(@Param("recipeId") String id);
}
