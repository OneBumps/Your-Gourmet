package cn.yourgourmet.mapper;

import cn.yourgourmet.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    /**
     * 根据用户id查询用户
     *
     * @param userId       用户Id
     * @param userPassword 用户密码
     * @return User
     */
    Integer selectByUserNameAndPassword(@Param("userName") String userId, @Param("userPassword") String userPassword);

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

    /**
     * 更新密码
     *
     * @param username 用户名
     * @param password 密码
     * @return Boolean
     */
    int updatePassword(@Param("userId") String username, @Param("userPassword") String password);

    int updateUserInfo(User user);

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return User
     */
    User selectAllByUserId(@Param("userId") String userId);
    Integer insertUser(User user);
    /**
     * 删除用户
     *
     * @param userId       用户id
     * @param userPassword 用户密码
     * @return Integer
     */
    Integer deleteUser(@Param("userId") String userId, @Param("userPassword") String userPassword);

    Integer updateUserAvatar(@Param("userAvatar") String avatar, @Param("userId") String userId);

    String selectUserIdByUserNameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
