package cn.yourgourmet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface CuisineMapper {
    String selectCuisineNameByRecipeId(@Param("cuisineId") Integer cuisineId);
}
