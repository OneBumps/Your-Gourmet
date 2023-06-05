package cn.yourgourmet.entity;

import org.apache.ibatis.type.Alias;

import java.util.Arrays;

/**
 * 用户实体类 用户表
 */
@Alias("User")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 2990519417178527722L;
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userGroup;
    private String userGender;
    private String userIntroduction;
    private String userAvatar;

    public User() {
    }

    /**
     * @param userId    用户Id
     * @param userName  用户名
     * @param userPassword  密码
     * @param userEmail     邮箱
     * @param userPhone     电话
     * @param userGroup 用户分组
     * @param userGender    性别
     * @param userIntroduction 用户简介
     * @param userAvatar    头像
     */
    public User(String userId, String userName, String userPassword, String userEmail, String userPhone, String userGroup, String userGender, String userIntroduction, String userAvatar) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userGroup = userGroup;
        this.userGender = userGender;
        this.userIntroduction = userIntroduction;
        this.userAvatar = userAvatar;
    }

    /**
     * @return 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return 邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail 邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return 电话
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone 电话
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return 用户分组
     */
    public String getUserGroup() {
        return userGroup;
    }

    /**
     * @param userGroup 用户分组
     */
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    /**
     * @return 性别
     */
    public String getUserGender() {
        return userGender;
    }

    /**
     * @param userGender 性别
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    /**
     * @return 用户简介
     */
    public String getUserIntroduction() {
        return userIntroduction;
    }

    /**
     * @param userIntroduction 用户简介
     */
    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    /**
     * @return 头像
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * @param userAvatar 头像
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userGroup='" + userGroup + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                '}';
    }
}