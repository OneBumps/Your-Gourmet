package cn.yourgourmet.po;

import com.mchange.util.ByteArrayMap;

/**
 * 用户实体类 用户表
 */
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 838026389105996578L;
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String userGroup;
    private String gender;
    private String userIntro;
    private ByteArrayMap avatar;

    public User() {
    }

    /**
     * @param userId    用户Id
     * @param userName  用户名
     * @param password  密码
     * @param email     邮箱
     * @param phone     电话
     * @param userGroup 用户分组
     * @param gender    性别
     * @param userIntro 用户简介
     * @param avatar    头像
     */
    public User(int userId, String userName, String password, String email, String phone, String userGroup, String gender, String userIntro, ByteArrayMap avatar) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userGroup = userGroup;
        this.gender = gender;
        this.userIntro = userIntro;
        this.avatar = avatar;
    }

    /**
     * @return 用户Id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId 用户Id
     */
    public void setUserId(int userId) {
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
    public String getPassword() {
        return password;
    }

    /**
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getGender() {
        return gender;
    }

    /**
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return 用户简介
     */
    public String getUserIntro() {
        return userIntro;
    }

    /**
     * @param userIntro 用户简介
     */
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    /**
     * @return 头像
     */
    public ByteArrayMap getAvatar() {
        return avatar;
    }

    /**
     * @param avatar 头像
     */
    public void setAvatar(ByteArrayMap avatar) {
        this.avatar = avatar;
    }
}