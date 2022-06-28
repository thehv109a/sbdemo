package thehv.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoApplicationRunner implements ApplicationRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void run(ApplicationArguments args) {
        String sql = "DROP TABLE IF EXISTS `user`; CREATE TABLE `user`  ( `id` int(11) NOT NULL AUTO_INCREMENT, `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, PRIMARY KEY (`id`) USING BTREE, UNIQUE INDEX `user_uk`(`email`) USING BTREE ) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact; INSERT INTO `user` VALUES (1, 'admin', '$2a$04$vgLYVKrBTTtvgArbrLSKL.HBBSA6OphnsEz1vjTev4IE/rSm9HG5y');  DROP TABLE IF EXISTS `role`; CREATE TABLE `role`  ( `id` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, PRIMARY KEY (`id`) USING BTREE ) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact; INSERT INTO `role` VALUES (1, 'ROLE_ADMIN'); INSERT INTO `role` VALUES (2, 'ROLE_MEMBER'); DROP TABLE IF EXISTS `user_role`; CREATE TABLE `user_role`  ( `user_id` int(11) NOT NULL, `role_id` int(11) NOT NULL, PRIMARY KEY (`user_id`, `role_id`) USING BTREE ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact; INSERT INTO `user_role` VALUES (1, 1); INSERT INTO `user_role` VALUES (1, 2);";
        Arrays.asList(sql.split(";")).forEach(subSql -> {
            // jdbcTemplate.execute(subSql);
        });
    }
}