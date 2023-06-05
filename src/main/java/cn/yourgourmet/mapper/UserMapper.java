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
     *
     * @param userId       用户id
     * @param userPassword 用户密码
     * @return User
     */
    Integer selectByUserIdAndPassword(@Param("userId") String userId, @Param("userPassword") String userPassword);

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

    /**
     * 更新密码
     *
     * @param username 用户名
     * @param password 密码
     * @return Boolean
     */

    int updatePassword(@Param("userId") String username, @Param("userPassword") String password);

    User selectAllByUserId(@Param("userId") String userId);

    Integer insert(@Param("userId") String userId,@Param("userPassword") String userPassword ,@Param("userName" )String userName,@Param("userPhone") String userPhone);
}
