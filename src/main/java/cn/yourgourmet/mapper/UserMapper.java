package cn.yourgourmet.mapper;

import cn.yourgourmet.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User selectByUserIdAndPassword(@Param("userId") String userId,@Param("userPassword") String userPassword);
    Integer insert(@Param("userId") String userId,@Param("userPassword") String userPassword ,@Param("userName" )String userName,@Param("userPhone") String userPhone);
}
