package cn.yourgourmet.mapper;

import cn.yourgourmet.entity.Uses;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UsesMapper {
    @MapKey("id")
    List<Map<String, Object>> selectUsesByRecipeId(@Param("recipeId") String id);
}
