package cn.yourgourmet.mapper;

import cn.yourgourmet.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    /**
     * 根据用户id查询用户
     *
     * @param user 用户id
     * @return User
     */
    /**
     * 根据用户id查询用户
     * @param userId 用户id
     * @param userPassword 用户密码
     * @return User
     */
    Boolean selectByUserIdAndPassword(@Param("userId") String userId, @Param("userPassword") String userPassword);

    /**
     * 查询用户名是否存在
     *
     * @param userId 用户Id
     * @return Boolean
     */
    Boolean selectByUserId(@Param("userId") String userId);

    /**
     * 根据用户id查询用户
     *
     * @param user 用户Id
     */
    void insertUser(User user);
}
