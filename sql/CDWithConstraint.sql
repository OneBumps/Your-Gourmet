CREATE DATABASE IF NOT EXISTS yourgourmet DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE yourgourmet;
-- 创建用户表
CREATE TABLE user
(
    pk_user_id        VARCHAR(36) PRIMARY KEY COMMENT '账户ID',
    user_name         VARCHAR(30) NOT NULL COMMENT '昵称',
    user_phone        VARCHAR(20) NOT NULL COMMENT '电话',
    user_password     VARCHAR(18) NOT NULL COMMENT '密码',
    user_group        VARCHAR(15) NOT NULL DEFAULT 'USER' COMMENT '用户分组',
    user_gender       CHAR(1) COMMENT '性别',
    user_email        VARCHAR(40) COMMENT '邮箱',
    user_avatar       VARCHAR(70) COMMENT '头像',
    user_introduction VARCHAR(200) COMMENT '用户简介'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 插入管理员
INSERT INTO user(pk_user_id, user_name, user_phone, user_password, user_group, user_gender)
VALUES ('ADMINISTRATOR', 'ADMINISTRATOR', '111111111', '9c19ac.4f91e._r41c', 'ADMINISTRATOR', '男');
-- 创建菜系表
CREATE TABLE cuisine
(
    pk_cuisine_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '菜系ID',
    cuisine_name  VARCHAR(30) NOT NULL COMMENT '菜系名称'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建食材表
CREATE TABLE ingredient
(
    pk_ingredient_id    INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '食材ID',
    ingredient_category VARCHAR(20) NOT NULL DEFAULT '未添加' COMMENT '食材类别',
    ingredient_name     VARCHAR(20) NOT NULL COMMENT '食材名称',
    ingredient_alias    VARCHAR(30) COMMENT '食材别名'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建菜谱表
CREATE TABLE recipe
(
    pk_recipe_id        INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '菜谱ID',
    fk_user_id          VARCHAR(36)           DEFAULT 'ADMINISTRATOR' COMMENT 'fk_用户ID',
    recipe_name         VARCHAR(30)  NOT NULL COMMENT '菜谱名字',
    recipe_publish_time DATETIME     NOT NULL COMMENT '菜谱发布时间',
    recipe_image        VARCHAR(70) COMMENT '菜谱图片',
    recipe_video        VARCHAR(70) COMMENT '菜谱视频',
    recipe_introduction VARCHAR(500) COMMENT '菜谱简介',
    recipe_like         INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜谱喜欢数',
    recipe_dislike      INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜谱讨厌数',
    FOREIGN KEY (fk_user_id) REFERENCES user (pk_user_id) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建步骤表
CREATE TABLE step
(
    pk_fk_recipe_id  INT UNSIGNED COMMENT '菜谱ID',
    pk_step_number   INT UNSIGNED COMMENT '步骤序号',
    step_image       VARCHAR(100) COMMENT '步骤图片',
    step_description VARCHAR(300) NOT NULL COMMENT '步骤描述',
    PRIMARY KEY (pk_fk_recipe_id, pk_step_number),
    FOREIGN KEY (pk_fk_recipe_id) REFERENCES recipe (pk_recipe_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建评价表[关系]
CREATE TABLE review
(
    pk_fk_user_id   VARCHAR(36) COMMENT '用户ID',
    pk_fk_recipe_id INT UNSIGNED COMMENT '菜谱ID',
    pk_review_time  DATETIME COMMENT '评价时间',
    review_image    VARCHAR(100) COMMENT '评价图片',
    review_content  VARCHAR(200) NOT NULL COMMENT '评价文本内容',
    PRIMARY KEY (pk_fk_user_id, pk_review_time, pk_fk_recipe_id),
    FOREIGN KEY (pk_fk_user_id) REFERENCES User (pk_user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (pk_fk_recipe_id) REFERENCES recipe (pk_recipe_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建关注表[关系]
CREATE TABLE follow
(
    pk_fk_user_id   VARCHAR(36) COMMENT '用户ID',
    pk_fk_follow_id VARCHAR(36) COMMENT '被关注的用户ID',
    PRIMARY KEY (pk_fk_user_id, pk_fk_follow_id),
    FOREIGN KEY (pk_fk_user_id) REFERENCES user (pk_user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (pk_fk_follow_id) REFERENCES user (pk_user_id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建收藏表[关系]
CREATE TABLE favorite
(
    pk_fk_user_id   VARCHAR(36) COMMENT '用户ID',
    pk_fk_recipe_id INT UNSIGNED COMMENT '菜谱ID',
    PRIMARY KEY (pk_fk_user_id, pk_fk_recipe_id),
    FOREIGN KEY (pk_fk_user_id) REFERENCES user (pk_user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (pk_fk_recipe_id) REFERENCES recipe (pk_recipe_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建归属表[关系]
CREATE TABLE belong
(
    pk_fk_recipe_id INT UNSIGNED COMMENT '菜谱ID',
    fk_cuisine_id   INT UNSIGNED COMMENT '菜系ID',
    PRIMARY KEY (pk_fk_recipe_id),
    FOREIGN KEY (pk_fk_recipe_id) REFERENCES recipe (pk_recipe_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fk_cuisine_id) REFERENCES cuisine (pk_cuisine_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
-- 创建使用表[关系]
CREATE TABLE uses
(
    pk_fk_recipe_id     INT UNSIGNED COMMENT '菜谱ID',
    pk_fk_ingredient_id INT UNSIGNED COMMENT '食材ID',
    ingredient_amount   VARCHAR(20) COMMENT '食材用量',
    PRIMARY KEY (pk_fk_recipe_id, pk_fk_ingredient_id),
    FOREIGN KEY (pk_fk_recipe_id) REFERENCES recipe (pk_recipe_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (pk_fk_ingredient_id) REFERENCES ingredient (pk_ingredient_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;