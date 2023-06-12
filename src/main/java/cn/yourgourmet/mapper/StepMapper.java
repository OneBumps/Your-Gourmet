package cn.yourgourmet.mapper;

import cn.yourgourmet.entity.Step;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StepMapper {
    List<Step> selectBySteps(@Param("recipeId") String id);
}
