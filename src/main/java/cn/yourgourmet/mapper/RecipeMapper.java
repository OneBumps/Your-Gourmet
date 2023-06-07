package cn.yourgourmet.mapper;


import cn.yourgourmet.entity.Recipe;

import java.util.List;
import java.util.Map;

public interface RecipeMapper {
    Boolean existMenu(String recipeName);

    List<Recipe> selectByMenuName(String content);
}
