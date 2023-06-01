package cn.yourgourmet.mapper;

import cn.yourgourmet.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User selectByUserIdAndPassword(@Param("userId") String userId,@Param("userPassword") String userPassword);
}
