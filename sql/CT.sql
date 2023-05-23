-- 带外键
-- 创建用户表
CREATE TABLE User (
    UserId INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    UserGroup VARCHAR(20) COMMENT '用户分组',
    Nickname VARCHAR(50) COMMENT '昵称',
    Password VARCHAR(50) COMMENT '密码',
    Avatar BLOB COMMENT '头像',
    Phone VARCHAR(20) COMMENT '电话',
    Email VARCHAR(50) COMMENT '邮箱',
    Gender ENUM('male', 'female') COMMENT '性别',
    UserIntro VARCHAR(200) COMMENT '用户简介'
);

-- 创建菜系表
CREATE TABLE Cuisine (
    CuisineId INT PRIMARY KEY COMMENT '菜系ID',
    CuisineName VARCHAR(50) COMMENT '菜系名称'
);

-- 创建食材表
CREATE TABLE Ingredient (
    IngredientId INT PRIMARY KEY COMMENT '食材ID',
    IngredientCategory VARCHAR(50) COMMENT '食材类别',
    IngredientName VARCHAR(50) COMMENT '食材名称',
    IngredientAlias VARCHAR(50) COMMENT '食材别名'
);

-- 创建菜谱表
CREATE TABLE Recipe (
    RecipeId INT PRIMARY KEY COMMENT '菜谱ID',
    UserId INT COMMENT '用户ID',
    RecipePublishTime DATETIME COMMENT '菜谱发布时间',
    DishName VARCHAR(50) COMMENT '菜名',
    RecipeImage VARCHAR(100) COMMENT '菜谱图片',
    RecipeVideoLocation VARCHAR(100) COMMENT '菜谱视频位置',
    RecipeIntro VARCHAR(200) COMMENT '菜谱简介',
    LikeCount INT COMMENT '喜欢数',
    DislikeCount INT COMMENT '讨厌数',
    FOREIGN KEY (UserId) REFERENCES User (UserId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 创建步骤表
CREATE TABLE Step (
    RecipeId INT COMMENT '菜谱ID',
    StepNumber INT COMMENT '步骤序号',
    StepImageLocation VARCHAR(100) COMMENT '步骤图片位置',
    StepDescription VARCHAR(200) COMMENT '步骤描述',
    PRIMARY KEY (RecipeId, StepNumber),
    FOREIGN KEY (RecipeId) REFERENCES Recipe (RecipeId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 创建评价表
CREATE TABLE Review (
    UserId INT COMMENT '用户ID',
    ReviewTime DATETIME COMMENT '评价时间',
    RecipeId INT COMMENT '菜谱ID',
    ReviewTextContent VARCHAR(200) COMMENT '评价文本内容',
    ReviewImage VARCHAR(100) COMMENT '评价图片',
    PRIMARY KEY (UserId, ReviewTime, RecipeId),
    FOREIGN KEY (UserId) REFERENCES User (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (RecipeId) REFERENCES Recipe (RecipeId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 创建关注表
CREATE TABLE Follow (
    UserId INT COMMENT '用户ID',
    FollowedUserId INT COMMENT '被关注的用户ID',
    PRIMARY KEY (UserId, FollowedUserId),
    FOREIGN KEY (UserId) REFERENCES User (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (FollowedUserId) REFERENCES User (UserId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 创建收藏表
CREATE TABLE Favorite (
    UserId INT COMMENT '用户ID',
    RecipeId INT COMMENT '菜谱ID',
    PRIMARY KEY (UserId, RecipeId),
    FOREIGN KEY (UserId) REFERENCES User (UserId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (RecipeId) REFERENCES Recipe (RecipeId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 创建归属表
CREATE TABLE Belong (
    RecipeId INT COMMENT '菜谱ID',
    CuisineId INT COMMENT '菜系ID',
    PRIMARY KEY (RecipeId, CuisineId),
    FOREIGN KEY (RecipeId) REFERENCES Recipe (RecipeId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (CuisineId) REFERENCES Cuisine (CuisineId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 创建使用表
CREATE TABLE Use (
    RecipeId INT COMMENT '菜谱ID',
    IngredientId INT 评论 '食材ID,
   IngredientAmount VARCHAR(20) 评论' 食材用量,
    PRIMARY KEY (RecipeId, IngredientId),
    FOREIGN KEY (RecipeId) REFERENCES Recipe (RecipeId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (IngredientId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 不带外键
-- 创建用户表
CREATE TABLE User (
    UserId INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    UserGroup VARCHAR(20) COMMENT '用户分组',
    Nickname VARCHAR(50) COMMENT '昵称',
    Password VARCHAR(50) COMMENT '密码',
    Avatar BLOB COMMENT '头像',
    Phone VARCHAR(20) COMMENT '电话',
    Email VARCHAR(50) COMMENT '邮箱',
    Gender ENUM('male', 'female') COMMENT '性别',
    UserIntro VARCHAR(200) COMMENT '用户简介'
);

-- 创建菜系表
CREATE TABLE Cuisine (
    CuisineId INT PRIMARY KEY COMMENT '菜系ID',
    CuisineName VARCHAR(50) COMMENT '菜系名称'
);

-- 创建食材表
CREATE TABLE Ingredient (
    IngredientId INT PRIMARY KEY COMMENT '食材ID',
    IngredientType VARCHAR(50) COMMENT '食材类别',
    IngredientName VARCHAR(50) COMMENT '食材名称',
    IngredientAlias VARCHAR(50) COMMENT '食材别名'
);

-- 创建菜谱表
CREATE TABLE Recipe (
    RecipeId INT PRIMARY KEY COMMENT '菜谱ID',
    UserId INT COMMENT '用户ID',
    RecipePublishTime DATETIME COMMENT '菜谱发布时间',
    DishName VARCHAR(50) COMMENT '菜名',
    RecipeImage VARCHAR(100) COMMENT '菜谱图片',
    RecipeVideoLocation VARCHAR(100) COMMENT '菜谱视频位置',
    RecipeIntro VARCHAR(200) COMMENT '菜谱简介',
    LikeCount INT COMMENT '喜欢数',
    DislikeCount INT COMMENT '讨厌数'
);

-- 创建步骤表
CREATE TABLE Step (
    RecipeId INT COMMENT '菜谱ID',
    StepNumber INT COMMENT '步骤序号',
    StepImageLocation VARCHAR(100) COMMENT '步骤图片位置',
    StepDescription VARCHAR(200) COMMENT '步骤描述',
    PRIMARY KEY (RecipeId, StepNumber)
);

-- 创建评价表
CREATE TABLE Comment (
    UserId INT COMMENT '用户ID',
    CommentTime DATETIME COMMENT '评价时间',
    RecipeId INT COMMENT '菜谱ID',
    CommentTextContent VARCHAR(200) COMMENT '评价文本内容',
    CommentImage VARCHAR(100) COMMENT '评价图片',
    PRIMARY KEY (UserId, CommentTime, RecipeId)
);

-- 创建关注表
CREATE TABLE Follow (
    UserId INT COMMENT '用户ID',
    FollowedUserId INT COMMENT '被关注的用户ID',
    PRIMARY KEY (UserId, FollowedUserId)
);

-- 创建收藏表
CREATE TABLE Collect (
    UserId INT COMMENT '用户ID',
    RecipeId INT COMMENT '菜谱ID',
    PRIMARY KEY (UserId, RecipeId)
);

-- 创建归属表
CREATE TABLE Belong (
    RecipeId INT COMMENT '菜谱ID',
    CuisineId INT COMMENT '菜系ID',
    PRIMARY KEY (RecipeId, CuisineId)
);

-- 创建使用表
CREATE TABLE Use (
    RecipeId INT COMMENT '菜谱ID',
    IngredientId INT COMMENT '食材ID',
    IngredientAmount VARCHAR(20) COMMENT '食材用量',
    PRIMARY KEY (RecipeId, IngredientId)
);