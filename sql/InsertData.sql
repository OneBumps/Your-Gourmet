-- 插入用户表
INSERT INTO user(pk_user_id, user_name, user_phone, user_password)
VALUES (REPLACE(UUID(), "-", ""), '☆完美少年☆', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '一滴水的际遇', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '孤影メ残刀', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '你是俄的眼', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '风逝无迹', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '挑战，你的吻', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '聆风吟', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '画上句点', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '空瞳', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '迷路的男人。', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), 'ゐ先生请松手', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '温柔鬼余生', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '辞安.', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '故事就适事づ', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '逃避。世俗', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '给兴奋打一针消极', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '安心温馨', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '若沐', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '淡沫', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '浅笑繁华', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '梦中的天使”', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '一场痴情梦。', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '温柔鬼余生', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '空气变的好浑浊', '15668879885', 'csirhtvoeirhier'),
       (REPLACE(UUID(), "-", ""), '此时，彼地', '15668879885', 'csirhtvoeirhier');
-- 插入菜系表
INSERT INTO cuisine(cuisine_name)
VALUES ('家常菜'),
       ('川菜'),
       ('粤菜'),
       ('鲁菜'),
       ('闽菜'),
       ('苏菜'),
       ('湘菜'),
       ('浙菜'),
       ('徽菜'),
       ('京菜'),
       ('沪菜'),
       ('陕菜'),
       ('楚菜'),
       ('豫菜'),
       ('日本菜'),
       ('韩国菜'),
       ('东南亚菜'),
       ('土耳其菜'),
       ('中亚菜'),
       ('中东菜'),
       ('南亚菜'),
       ('法国菜'),
       ('欧洲菜'),
       ('美洲菜'),
       ('大洋洲菜');

-- 插入菜谱表
INSERT INTO recipe(fk_user_id, recipe_name, recipe_publish_time)
VALUES ('ADMINISTRATOR', '蛋花丝瓜汤', NOW()),
       ('ADMINISTRATOR', '馄饨', NOW()),
       ('ADMINISTRATOR', '海蜇汤菜', NOW()),
       ('ADMINISTRATOR', '三色鲜贝', NOW()),
       ('ADMINISTRATOR', '夹馅黄瓜', NOW()),
       ('ADMINISTRATOR', '萝卜丝糕', NOW()),
       ('ADMINISTRATOR', '熘黄瓜', NOW()),
       ('ADMINISTRATOR', '熘莲鱼丁', NOW()),
       ('ADMINISTRATOR', '香菇烧茭白', NOW()),
       ('ADMINISTRATOR', '莼菜汤', NOW());

-- 插入步骤表
INSERT INTO step(pk_fk_recipe_id, pk_step_number, step_description)
VALUES (1, 1, '丝瓜洗净，去皮切片；香菜择洗干净切段。'),
       (1, 2, '油锅烧热，放入葱花炝锅，下丝瓜煸炒，加适量清水、盐煮沸后，倒入蛋花液，加香菜、味精即成。'),
       (2, 1, '虾仁洗净控干水，剁碎，加葱、姜、盐、味精、淀粉浆、蛋清、料酒、植物油搅打成馅。'),
       (2, 2, '取皮包制馄饨，煮熟。'),
       (2, 3, '碗中置虾皮、紫菜末，连汤盛入馄饨。'),
       (3, 1, '黄瓜洗净，切片；熟炎腿切片。'),
       (3, 2, '海蜇以沸水泡发后洗涤3遍，待其软嫩后，放凉开水中浸泡；再以烧沸鸡汤浸烫后捞出，盛入碗中。'),
       (3, 3, '将鸡蛋和蛋清搅打，加约100克鸡汤、盐搅匀，上锅蒸熟取出。'),
       (3, 4, '鸡汤加盐味精烧沸后倒入放海蜇的碗中，用勺将蒸好的鸡蛋一勺勺舀入碗中，加熟火腿片和黄瓜片即成。'),
       (4, 1, '油菜叶择洗干净，入沸水锅中略焯，待用。'),
       (4, 2, '鲜贝洗净，一半切片，一半放碗中捣成泥状，加蛋清、盐搅匀后制成小丸子。'),
       (4, 3, '油锅烧热，将鲜贝片入锅，炸好捞出。'),
       (4, 4, '锅内留少许油，加料酒、水、盐、白糖、番茄酱、味精烧开，投入鲜贝丸子烧至入味，盛盘中。'),
       (4, 5, '另起油锅烧热，入鲜贝片，加盐、味精，烧至入味后盛在鲜贝丸子周围，放油菜叶点缀即成。');

-- 插入归属表【关系】
INSERT INTO belong(pk_fk_recipe_id, fk_cuisine_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 3),
       (5, 6),
       (6, 3);
-- 插入食材表【关系】
INSERT INTO ingredient(ingredient_name)
VALUES ('洋葱'),
       ('大蒜'),
       ('土豆'),
       ('菠菜'),
       ('芹菜'),
       ('白菜'),
       ('萝卜'),
       ('胡萝卜'),
       ('藕'),
       ('豆芽'),
       ('茄子'),
       ('韭菜'),
       ('菜花'),
       ('油菜'),
       ('生菜'),
       ('蘑菇'),
       ('木耳'),
       ('杏鲍菇'),
       ('银耳'),
       ('丝瓜'),
       ('鸡蛋');


-- 插入使用表【关系】
INSERT INTO uses(pk_fk_recipe_id, pk_fk_ingredient_id, ingredient_amount)
VALUES (1, 20, '480克'),
       (1, 21, '200克');