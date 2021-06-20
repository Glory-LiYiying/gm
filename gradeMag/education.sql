/*
 Navicat Premium Data Transfer

 Source Server         : mysql_local
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : education

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 26/05/2021 17:28:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `acot` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`acot`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程Id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据结构');
INSERT INTO `course` VALUES (2, '大学英语1');
INSERT INTO `course` VALUES (3, '大学英语2');
INSERT INTO `course` VALUES (4, '大学英语3');
INSERT INTO `course` VALUES (5, '大学英语4');
INSERT INTO `course` VALUES (6, '操作系统');
INSERT INTO `course` VALUES (7, '计算机组成原理');
INSERT INTO `course` VALUES (8, '计算机网络');
INSERT INTO `course` VALUES (9, '中国近代史');
INSERT INTO `course` VALUES (10, '大学体育');
INSERT INTO `course` VALUES (11, '音乐赏析');
INSERT INTO `course` VALUES (12, '高等数学1');
INSERT INTO `course` VALUES (13, '高等数学2');
INSERT INTO `course` VALUES (14, '离散数学');
INSERT INTO `course` VALUES (15, '线性代数');
INSERT INTO `course` VALUES (16, '编译原理');

-- ----------------------------
-- Table structure for courseresult
-- ----------------------------
DROP TABLE IF EXISTS `courseresult`;
CREATE TABLE `courseresult`  (
  `studentId` int(10) UNSIGNED NOT NULL COMMENT '学生ID',
  `courseId` int(10) UNSIGNED NOT NULL COMMENT '课程ID',
  `grade` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '成绩,'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程成绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseresult
-- ----------------------------
INSERT INTO `courseresult` VALUES (1, 13, 17);
INSERT INTO `courseresult` VALUES (1, 4, 59);
INSERT INTO `courseresult` VALUES (1, 5, 16);
INSERT INTO `courseresult` VALUES (1, 11, 63);
INSERT INTO `courseresult` VALUES (1, 2, 83);
INSERT INTO `courseresult` VALUES (1, 6, 33);
INSERT INTO `courseresult` VALUES (2, 15, 26);
INSERT INTO `courseresult` VALUES (2, 8, 63);
INSERT INTO `courseresult` VALUES (2, 4, 51);
INSERT INTO `courseresult` VALUES (2, 7, 13);
INSERT INTO `courseresult` VALUES (2, 5, 97);
INSERT INTO `courseresult` VALUES (2, 3, 63);
INSERT INTO `courseresult` VALUES (3, 10, 64);
INSERT INTO `courseresult` VALUES (3, 5, 48);
INSERT INTO `courseresult` VALUES (3, 4, 8);
INSERT INTO `courseresult` VALUES (3, 2, 88);
INSERT INTO `courseresult` VALUES (3, 10, 52);
INSERT INTO `courseresult` VALUES (3, 13, 48);
INSERT INTO `courseresult` VALUES (4, 10, 94);
INSERT INTO `courseresult` VALUES (4, 6, 63);
INSERT INTO `courseresult` VALUES (4, 13, 84);
INSERT INTO `courseresult` VALUES (4, 5, 46);
INSERT INTO `courseresult` VALUES (4, 14, 99);
INSERT INTO `courseresult` VALUES (4, 7, 100);
INSERT INTO `courseresult` VALUES (5, 7, 38);
INSERT INTO `courseresult` VALUES (5, 16, 66);
INSERT INTO `courseresult` VALUES (5, 3, 73);
INSERT INTO `courseresult` VALUES (5, 16, 61);
INSERT INTO `courseresult` VALUES (5, 5, 76);
INSERT INTO `courseresult` VALUES (5, 4, 37);
INSERT INTO `courseresult` VALUES (6, 9, 85);
INSERT INTO `courseresult` VALUES (6, 13, 59);
INSERT INTO `courseresult` VALUES (6, 2, 99);
INSERT INTO `courseresult` VALUES (6, 14, 68);
INSERT INTO `courseresult` VALUES (6, 14, 1);
INSERT INTO `courseresult` VALUES (6, 14, 53);
INSERT INTO `courseresult` VALUES (7, 6, 34);
INSERT INTO `courseresult` VALUES (7, 12, 27);
INSERT INTO `courseresult` VALUES (7, 14, 36);
INSERT INTO `courseresult` VALUES (7, 13, 73);
INSERT INTO `courseresult` VALUES (7, 1, 42);
INSERT INTO `courseresult` VALUES (7, 13, 13);
INSERT INTO `courseresult` VALUES (8, 14, 89);
INSERT INTO `courseresult` VALUES (8, 3, 33);
INSERT INTO `courseresult` VALUES (8, 1, 27);
INSERT INTO `courseresult` VALUES (8, 13, 96);
INSERT INTO `courseresult` VALUES (8, 11, 89);
INSERT INTO `courseresult` VALUES (8, 7, 3);
INSERT INTO `courseresult` VALUES (9, 5, 22);
INSERT INTO `courseresult` VALUES (9, 11, 42);
INSERT INTO `courseresult` VALUES (9, 1, 16);
INSERT INTO `courseresult` VALUES (9, 6, 0);
INSERT INTO `courseresult` VALUES (9, 13, 7);
INSERT INTO `courseresult` VALUES (9, 10, 97);
INSERT INTO `courseresult` VALUES (10, 10, 80);
INSERT INTO `courseresult` VALUES (10, 13, 9);
INSERT INTO `courseresult` VALUES (10, 15, 5);
INSERT INTO `courseresult` VALUES (10, 13, 74);
INSERT INTO `courseresult` VALUES (10, 4, 70);
INSERT INTO `courseresult` VALUES (10, 4, 26);
INSERT INTO `courseresult` VALUES (11, 9, 23);
INSERT INTO `courseresult` VALUES (11, 13, 95);
INSERT INTO `courseresult` VALUES (11, 11, 92);
INSERT INTO `courseresult` VALUES (11, 11, 87);
INSERT INTO `courseresult` VALUES (11, 5, 48);
INSERT INTO `courseresult` VALUES (11, 2, 91);
INSERT INTO `courseresult` VALUES (12, 9, 77);
INSERT INTO `courseresult` VALUES (12, 1, 100);
INSERT INTO `courseresult` VALUES (12, 1, 49);
INSERT INTO `courseresult` VALUES (12, 4, 72);
INSERT INTO `courseresult` VALUES (12, 1, 39);
INSERT INTO `courseresult` VALUES (12, 16, 54);
INSERT INTO `courseresult` VALUES (13, 12, 28);
INSERT INTO `courseresult` VALUES (13, 13, 30);
INSERT INTO `courseresult` VALUES (13, 16, 45);
INSERT INTO `courseresult` VALUES (13, 6, 41);
INSERT INTO `courseresult` VALUES (13, 12, 6);
INSERT INTO `courseresult` VALUES (13, 3, 62);
INSERT INTO `courseresult` VALUES (14, 7, 72);
INSERT INTO `courseresult` VALUES (14, 7, 59);
INSERT INTO `courseresult` VALUES (14, 9, 99);
INSERT INTO `courseresult` VALUES (14, 12, 57);
INSERT INTO `courseresult` VALUES (14, 10, 28);
INSERT INTO `courseresult` VALUES (14, 5, 70);
INSERT INTO `courseresult` VALUES (15, 1, 56);
INSERT INTO `courseresult` VALUES (15, 8, 76);
INSERT INTO `courseresult` VALUES (15, 1, 20);
INSERT INTO `courseresult` VALUES (15, 16, 90);
INSERT INTO `courseresult` VALUES (15, 16, 76);
INSERT INTO `courseresult` VALUES (15, 2, 74);
INSERT INTO `courseresult` VALUES (16, 4, 68);
INSERT INTO `courseresult` VALUES (16, 12, 55);
INSERT INTO `courseresult` VALUES (16, 9, 50);
INSERT INTO `courseresult` VALUES (16, 1, 10);
INSERT INTO `courseresult` VALUES (16, 13, 4);
INSERT INTO `courseresult` VALUES (16, 5, 7);
INSERT INTO `courseresult` VALUES (17, 14, 39);
INSERT INTO `courseresult` VALUES (17, 11, 74);
INSERT INTO `courseresult` VALUES (17, 3, 70);
INSERT INTO `courseresult` VALUES (17, 12, 86);
INSERT INTO `courseresult` VALUES (17, 4, 65);
INSERT INTO `courseresult` VALUES (17, 1, 31);
INSERT INTO `courseresult` VALUES (18, 6, 39);
INSERT INTO `courseresult` VALUES (18, 8, 49);
INSERT INTO `courseresult` VALUES (18, 4, 74);
INSERT INTO `courseresult` VALUES (18, 13, 5);
INSERT INTO `courseresult` VALUES (18, 10, 8);
INSERT INTO `courseresult` VALUES (18, 12, 78);
INSERT INTO `courseresult` VALUES (19, 13, 96);
INSERT INTO `courseresult` VALUES (19, 14, 9);
INSERT INTO `courseresult` VALUES (19, 15, 15);
INSERT INTO `courseresult` VALUES (19, 14, 58);
INSERT INTO `courseresult` VALUES (19, 2, 10);
INSERT INTO `courseresult` VALUES (19, 14, 24);
INSERT INTO `courseresult` VALUES (20, 6, 0);
INSERT INTO `courseresult` VALUES (20, 12, 61);
INSERT INTO `courseresult` VALUES (20, 2, 81);
INSERT INTO `courseresult` VALUES (20, 11, 63);
INSERT INTO `courseresult` VALUES (20, 1, 10);
INSERT INTO `courseresult` VALUES (20, 13, 13);
INSERT INTO `courseresult` VALUES (21, 5, 89);
INSERT INTO `courseresult` VALUES (21, 14, 72);
INSERT INTO `courseresult` VALUES (21, 12, 97);
INSERT INTO `courseresult` VALUES (21, 8, 69);
INSERT INTO `courseresult` VALUES (21, 11, 14);
INSERT INTO `courseresult` VALUES (21, 12, 64);
INSERT INTO `courseresult` VALUES (22, 5, 16);
INSERT INTO `courseresult` VALUES (22, 10, 28);
INSERT INTO `courseresult` VALUES (22, 1, 2);
INSERT INTO `courseresult` VALUES (22, 16, 55);
INSERT INTO `courseresult` VALUES (22, 1, 40);
INSERT INTO `courseresult` VALUES (22, 11, 61);
INSERT INTO `courseresult` VALUES (23, 9, 83);
INSERT INTO `courseresult` VALUES (23, 3, 23);
INSERT INTO `courseresult` VALUES (23, 6, 25);
INSERT INTO `courseresult` VALUES (23, 6, 33);
INSERT INTO `courseresult` VALUES (23, 1, 7);
INSERT INTO `courseresult` VALUES (23, 14, 61);
INSERT INTO `courseresult` VALUES (24, 6, 69);
INSERT INTO `courseresult` VALUES (24, 8, 68);
INSERT INTO `courseresult` VALUES (24, 6, 42);
INSERT INTO `courseresult` VALUES (24, 9, 4);
INSERT INTO `courseresult` VALUES (24, 11, 39);
INSERT INTO `courseresult` VALUES (24, 10, 85);
INSERT INTO `courseresult` VALUES (25, 10, 43);
INSERT INTO `courseresult` VALUES (25, 15, 71);
INSERT INTO `courseresult` VALUES (25, 13, 47);
INSERT INTO `courseresult` VALUES (25, 5, 10);
INSERT INTO `courseresult` VALUES (25, 14, 71);
INSERT INTO `courseresult` VALUES (25, 2, 97);
INSERT INTO `courseresult` VALUES (26, 5, 39);
INSERT INTO `courseresult` VALUES (26, 13, 38);
INSERT INTO `courseresult` VALUES (26, 2, 52);
INSERT INTO `courseresult` VALUES (26, 12, 24);
INSERT INTO `courseresult` VALUES (26, 12, 65);
INSERT INTO `courseresult` VALUES (26, 10, 84);
INSERT INTO `courseresult` VALUES (27, 15, 73);
INSERT INTO `courseresult` VALUES (27, 15, 10);
INSERT INTO `courseresult` VALUES (27, 1, 18);
INSERT INTO `courseresult` VALUES (27, 1, 27);
INSERT INTO `courseresult` VALUES (27, 1, 31);
INSERT INTO `courseresult` VALUES (27, 2, 58);
INSERT INTO `courseresult` VALUES (28, 14, 7);
INSERT INTO `courseresult` VALUES (28, 16, 91);
INSERT INTO `courseresult` VALUES (28, 15, 90);
INSERT INTO `courseresult` VALUES (28, 1, 21);
INSERT INTO `courseresult` VALUES (28, 16, 40);
INSERT INTO `courseresult` VALUES (28, 3, 69);
INSERT INTO `courseresult` VALUES (29, 3, 35);
INSERT INTO `courseresult` VALUES (29, 4, 28);
INSERT INTO `courseresult` VALUES (29, 3, 32);
INSERT INTO `courseresult` VALUES (29, 14, 19);
INSERT INTO `courseresult` VALUES (29, 6, 0);
INSERT INTO `courseresult` VALUES (29, 14, 53);
INSERT INTO `courseresult` VALUES (30, 5, 66);
INSERT INTO `courseresult` VALUES (30, 3, 75);
INSERT INTO `courseresult` VALUES (30, 2, 55);
INSERT INTO `courseresult` VALUES (30, 14, 56);
INSERT INTO `courseresult` VALUES (30, 2, 30);
INSERT INTO `courseresult` VALUES (30, 1, 1);
INSERT INTO `courseresult` VALUES (31, 11, 55);
INSERT INTO `courseresult` VALUES (31, 2, 28);
INSERT INTO `courseresult` VALUES (31, 3, 39);
INSERT INTO `courseresult` VALUES (31, 15, 31);
INSERT INTO `courseresult` VALUES (31, 8, 25);
INSERT INTO `courseresult` VALUES (31, 10, 36);
INSERT INTO `courseresult` VALUES (32, 11, 45);
INSERT INTO `courseresult` VALUES (32, 8, 72);
INSERT INTO `courseresult` VALUES (32, 13, 11);
INSERT INTO `courseresult` VALUES (32, 11, 62);
INSERT INTO `courseresult` VALUES (32, 8, 13);
INSERT INTO `courseresult` VALUES (32, 7, 42);
INSERT INTO `courseresult` VALUES (33, 15, 76);
INSERT INTO `courseresult` VALUES (33, 15, 50);
INSERT INTO `courseresult` VALUES (33, 11, 7);
INSERT INTO `courseresult` VALUES (33, 9, 77);
INSERT INTO `courseresult` VALUES (33, 6, 0);
INSERT INTO `courseresult` VALUES (33, 2, 93);
INSERT INTO `courseresult` VALUES (34, 12, 36);
INSERT INTO `courseresult` VALUES (34, 1, 76);
INSERT INTO `courseresult` VALUES (34, 14, 37);
INSERT INTO `courseresult` VALUES (34, 10, 18);
INSERT INTO `courseresult` VALUES (34, 3, 23);
INSERT INTO `courseresult` VALUES (34, 16, 92);
INSERT INTO `courseresult` VALUES (35, 12, 24);
INSERT INTO `courseresult` VALUES (35, 6, 20);
INSERT INTO `courseresult` VALUES (35, 10, 22);
INSERT INTO `courseresult` VALUES (35, 1, 54);
INSERT INTO `courseresult` VALUES (35, 6, 82);
INSERT INTO `courseresult` VALUES (35, 1, 82);
INSERT INTO `courseresult` VALUES (36, 13, 73);
INSERT INTO `courseresult` VALUES (36, 5, 98);
INSERT INTO `courseresult` VALUES (36, 1, 89);
INSERT INTO `courseresult` VALUES (36, 2, 2);
INSERT INTO `courseresult` VALUES (36, 11, 100);
INSERT INTO `courseresult` VALUES (36, 2, 28);
INSERT INTO `courseresult` VALUES (37, 13, 72);
INSERT INTO `courseresult` VALUES (37, 1, 87);
INSERT INTO `courseresult` VALUES (37, 7, 14);
INSERT INTO `courseresult` VALUES (37, 3, 14);
INSERT INTO `courseresult` VALUES (37, 5, 51);
INSERT INTO `courseresult` VALUES (37, 1, 49);
INSERT INTO `courseresult` VALUES (38, 3, 39);
INSERT INTO `courseresult` VALUES (38, 10, 15);
INSERT INTO `courseresult` VALUES (38, 11, 24);
INSERT INTO `courseresult` VALUES (38, 9, 53);
INSERT INTO `courseresult` VALUES (38, 3, 76);
INSERT INTO `courseresult` VALUES (38, 11, 30);
INSERT INTO `courseresult` VALUES (39, 15, 3);
INSERT INTO `courseresult` VALUES (39, 5, 52);
INSERT INTO `courseresult` VALUES (39, 7, 69);
INSERT INTO `courseresult` VALUES (39, 14, 9);
INSERT INTO `courseresult` VALUES (39, 16, 89);
INSERT INTO `courseresult` VALUES (39, 7, 63);
INSERT INTO `courseresult` VALUES (40, 2, 0);
INSERT INTO `courseresult` VALUES (40, 11, 95);
INSERT INTO `courseresult` VALUES (40, 6, 73);
INSERT INTO `courseresult` VALUES (40, 9, 14);
INSERT INTO `courseresult` VALUES (40, 12, 93);
INSERT INTO `courseresult` VALUES (40, 3, 91);
INSERT INTO `courseresult` VALUES (41, 13, 0);
INSERT INTO `courseresult` VALUES (41, 15, 10);
INSERT INTO `courseresult` VALUES (41, 7, 11);
INSERT INTO `courseresult` VALUES (41, 6, 22);
INSERT INTO `courseresult` VALUES (41, 11, 12);
INSERT INTO `courseresult` VALUES (41, 4, 64);
INSERT INTO `courseresult` VALUES (42, 14, 93);
INSERT INTO `courseresult` VALUES (42, 5, 47);
INSERT INTO `courseresult` VALUES (42, 10, 20);
INSERT INTO `courseresult` VALUES (42, 14, 7);
INSERT INTO `courseresult` VALUES (42, 16, 94);
INSERT INTO `courseresult` VALUES (42, 6, 38);
INSERT INTO `courseresult` VALUES (43, 14, 67);
INSERT INTO `courseresult` VALUES (43, 16, 92);
INSERT INTO `courseresult` VALUES (43, 1, 61);
INSERT INTO `courseresult` VALUES (43, 6, 98);
INSERT INTO `courseresult` VALUES (43, 9, 49);
INSERT INTO `courseresult` VALUES (43, 4, 17);
INSERT INTO `courseresult` VALUES (44, 5, 58);
INSERT INTO `courseresult` VALUES (44, 4, 99);
INSERT INTO `courseresult` VALUES (44, 12, 15);
INSERT INTO `courseresult` VALUES (44, 16, 18);
INSERT INTO `courseresult` VALUES (44, 5, 31);
INSERT INTO `courseresult` VALUES (44, 1, 77);
INSERT INTO `courseresult` VALUES (45, 3, 50);
INSERT INTO `courseresult` VALUES (45, 5, 75);
INSERT INTO `courseresult` VALUES (45, 13, 40);
INSERT INTO `courseresult` VALUES (45, 9, 6);
INSERT INTO `courseresult` VALUES (45, 10, 49);
INSERT INTO `courseresult` VALUES (45, 2, 58);
INSERT INTO `courseresult` VALUES (46, 3, 10);
INSERT INTO `courseresult` VALUES (46, 10, 82);
INSERT INTO `courseresult` VALUES (46, 9, 19);
INSERT INTO `courseresult` VALUES (46, 1, 19);
INSERT INTO `courseresult` VALUES (46, 13, 20);
INSERT INTO `courseresult` VALUES (46, 2, 39);
INSERT INTO `courseresult` VALUES (47, 12, 19);
INSERT INTO `courseresult` VALUES (47, 15, 47);
INSERT INTO `courseresult` VALUES (47, 1, 95);
INSERT INTO `courseresult` VALUES (47, 15, 95);
INSERT INTO `courseresult` VALUES (47, 8, 2);
INSERT INTO `courseresult` VALUES (47, 6, 64);
INSERT INTO `courseresult` VALUES (48, 11, 67);
INSERT INTO `courseresult` VALUES (48, 2, 54);
INSERT INTO `courseresult` VALUES (48, 7, 72);
INSERT INTO `courseresult` VALUES (48, 6, 41);
INSERT INTO `courseresult` VALUES (48, 5, 10);
INSERT INTO `courseresult` VALUES (48, 10, 41);
INSERT INTO `courseresult` VALUES (49, 11, 4);
INSERT INTO `courseresult` VALUES (49, 3, 19);
INSERT INTO `courseresult` VALUES (49, 12, 2);
INSERT INTO `courseresult` VALUES (49, 10, 63);
INSERT INTO `courseresult` VALUES (49, 7, 73);
INSERT INTO `courseresult` VALUES (49, 13, 19);
INSERT INTO `courseresult` VALUES (50, 4, 98);
INSERT INTO `courseresult` VALUES (50, 1, 31);
INSERT INTO `courseresult` VALUES (50, 13, 34);
INSERT INTO `courseresult` VALUES (50, 2, 0);
INSERT INTO `courseresult` VALUES (50, 11, 41);
INSERT INTO `courseresult` VALUES (50, 1, 26);
INSERT INTO `courseresult` VALUES (51, 1, 61);
INSERT INTO `courseresult` VALUES (51, 7, 87);
INSERT INTO `courseresult` VALUES (51, 3, 91);
INSERT INTO `courseresult` VALUES (51, 13, 60);
INSERT INTO `courseresult` VALUES (51, 12, 25);
INSERT INTO `courseresult` VALUES (51, 10, 46);
INSERT INTO `courseresult` VALUES (52, 11, 89);
INSERT INTO `courseresult` VALUES (52, 6, 58);
INSERT INTO `courseresult` VALUES (52, 9, 93);
INSERT INTO `courseresult` VALUES (52, 13, 70);
INSERT INTO `courseresult` VALUES (52, 7, 4);
INSERT INTO `courseresult` VALUES (52, 5, 26);
INSERT INTO `courseresult` VALUES (53, 5, 31);
INSERT INTO `courseresult` VALUES (53, 6, 13);
INSERT INTO `courseresult` VALUES (53, 6, 37);
INSERT INTO `courseresult` VALUES (53, 9, 79);
INSERT INTO `courseresult` VALUES (53, 15, 87);
INSERT INTO `courseresult` VALUES (53, 3, 30);
INSERT INTO `courseresult` VALUES (54, 2, 99);
INSERT INTO `courseresult` VALUES (54, 1, 59);
INSERT INTO `courseresult` VALUES (54, 12, 59);
INSERT INTO `courseresult` VALUES (54, 3, 12);
INSERT INTO `courseresult` VALUES (54, 3, 22);
INSERT INTO `courseresult` VALUES (54, 13, 17);
INSERT INTO `courseresult` VALUES (55, 14, 46);
INSERT INTO `courseresult` VALUES (55, 10, 56);
INSERT INTO `courseresult` VALUES (55, 3, 77);
INSERT INTO `courseresult` VALUES (55, 1, 41);
INSERT INTO `courseresult` VALUES (55, 15, 42);
INSERT INTO `courseresult` VALUES (55, 12, 34);
INSERT INTO `courseresult` VALUES (56, 10, 87);
INSERT INTO `courseresult` VALUES (56, 2, 72);
INSERT INTO `courseresult` VALUES (56, 12, 2);
INSERT INTO `courseresult` VALUES (56, 9, 6);
INSERT INTO `courseresult` VALUES (56, 15, 70);
INSERT INTO `courseresult` VALUES (56, 1, 93);
INSERT INTO `courseresult` VALUES (57, 15, 18);
INSERT INTO `courseresult` VALUES (57, 15, 86);
INSERT INTO `courseresult` VALUES (57, 16, 22);
INSERT INTO `courseresult` VALUES (57, 1, 91);
INSERT INTO `courseresult` VALUES (57, 7, 98);
INSERT INTO `courseresult` VALUES (57, 9, 77);
INSERT INTO `courseresult` VALUES (58, 1, 14);
INSERT INTO `courseresult` VALUES (58, 8, 43);
INSERT INTO `courseresult` VALUES (58, 16, 51);
INSERT INTO `courseresult` VALUES (58, 7, 66);
INSERT INTO `courseresult` VALUES (58, 3, 67);
INSERT INTO `courseresult` VALUES (58, 2, 23);
INSERT INTO `courseresult` VALUES (59, 1, 78);
INSERT INTO `courseresult` VALUES (59, 4, 6);
INSERT INTO `courseresult` VALUES (59, 16, 66);
INSERT INTO `courseresult` VALUES (59, 12, 64);
INSERT INTO `courseresult` VALUES (59, 6, 73);
INSERT INTO `courseresult` VALUES (59, 9, 14);
INSERT INTO `courseresult` VALUES (60, 16, 40);
INSERT INTO `courseresult` VALUES (60, 5, 72);
INSERT INTO `courseresult` VALUES (60, 10, 75);
INSERT INTO `courseresult` VALUES (60, 1, 99);
INSERT INTO `courseresult` VALUES (60, 9, 68);
INSERT INTO `courseresult` VALUES (60, 1, 97);
INSERT INTO `courseresult` VALUES (61, 1, 88);
INSERT INTO `courseresult` VALUES (61, 15, 48);
INSERT INTO `courseresult` VALUES (61, 11, 34);
INSERT INTO `courseresult` VALUES (61, 13, 13);
INSERT INTO `courseresult` VALUES (61, 9, 39);
INSERT INTO `courseresult` VALUES (61, 1, 5);
INSERT INTO `courseresult` VALUES (62, 10, 60);
INSERT INTO `courseresult` VALUES (62, 5, 42);
INSERT INTO `courseresult` VALUES (62, 12, 50);
INSERT INTO `courseresult` VALUES (62, 2, 83);
INSERT INTO `courseresult` VALUES (62, 10, 41);
INSERT INTO `courseresult` VALUES (62, 5, 71);
INSERT INTO `courseresult` VALUES (63, 14, 31);
INSERT INTO `courseresult` VALUES (63, 11, 41);
INSERT INTO `courseresult` VALUES (63, 15, 41);
INSERT INTO `courseresult` VALUES (63, 8, 97);
INSERT INTO `courseresult` VALUES (63, 5, 42);
INSERT INTO `courseresult` VALUES (63, 10, 37);
INSERT INTO `courseresult` VALUES (64, 2, 10);
INSERT INTO `courseresult` VALUES (64, 9, 67);
INSERT INTO `courseresult` VALUES (64, 13, 74);
INSERT INTO `courseresult` VALUES (64, 10, 27);
INSERT INTO `courseresult` VALUES (64, 6, 52);
INSERT INTO `courseresult` VALUES (64, 8, 77);
INSERT INTO `courseresult` VALUES (65, 14, 15);
INSERT INTO `courseresult` VALUES (65, 3, 5);
INSERT INTO `courseresult` VALUES (65, 6, 100);
INSERT INTO `courseresult` VALUES (65, 15, 54);
INSERT INTO `courseresult` VALUES (65, 15, 32);
INSERT INTO `courseresult` VALUES (65, 1, 68);
INSERT INTO `courseresult` VALUES (66, 16, 36);
INSERT INTO `courseresult` VALUES (66, 13, 0);
INSERT INTO `courseresult` VALUES (66, 1, 46);
INSERT INTO `courseresult` VALUES (66, 14, 64);
INSERT INTO `courseresult` VALUES (66, 8, 29);
INSERT INTO `courseresult` VALUES (66, 2, 96);
INSERT INTO `courseresult` VALUES (67, 15, 69);
INSERT INTO `courseresult` VALUES (67, 7, 62);
INSERT INTO `courseresult` VALUES (67, 1, 68);
INSERT INTO `courseresult` VALUES (67, 12, 77);
INSERT INTO `courseresult` VALUES (67, 8, 72);
INSERT INTO `courseresult` VALUES (67, 16, 20);
INSERT INTO `courseresult` VALUES (68, 12, 60);
INSERT INTO `courseresult` VALUES (68, 2, 36);
INSERT INTO `courseresult` VALUES (68, 5, 99);
INSERT INTO `courseresult` VALUES (68, 10, 0);
INSERT INTO `courseresult` VALUES (68, 11, 16);
INSERT INTO `courseresult` VALUES (68, 2, 4);
INSERT INTO `courseresult` VALUES (69, 5, 42);
INSERT INTO `courseresult` VALUES (69, 1, 46);
INSERT INTO `courseresult` VALUES (69, 15, 79);
INSERT INTO `courseresult` VALUES (69, 13, 21);
INSERT INTO `courseresult` VALUES (69, 9, 16);
INSERT INTO `courseresult` VALUES (69, 16, 77);
INSERT INTO `courseresult` VALUES (70, 15, 23);
INSERT INTO `courseresult` VALUES (70, 6, 19);
INSERT INTO `courseresult` VALUES (70, 11, 60);
INSERT INTO `courseresult` VALUES (70, 4, 30);
INSERT INTO `courseresult` VALUES (70, 10, 96);
INSERT INTO `courseresult` VALUES (70, 6, 3);
INSERT INTO `courseresult` VALUES (71, 4, 12);
INSERT INTO `courseresult` VALUES (71, 15, 44);
INSERT INTO `courseresult` VALUES (71, 5, 50);
INSERT INTO `courseresult` VALUES (71, 11, 22);
INSERT INTO `courseresult` VALUES (71, 10, 63);
INSERT INTO `courseresult` VALUES (71, 4, 62);
INSERT INTO `courseresult` VALUES (72, 2, 6);
INSERT INTO `courseresult` VALUES (72, 7, 82);
INSERT INTO `courseresult` VALUES (72, 14, 89);
INSERT INTO `courseresult` VALUES (72, 14, 79);
INSERT INTO `courseresult` VALUES (72, 5, 2);
INSERT INTO `courseresult` VALUES (72, 6, 53);
INSERT INTO `courseresult` VALUES (73, 4, 86);
INSERT INTO `courseresult` VALUES (73, 1, 28);
INSERT INTO `courseresult` VALUES (73, 2, 41);
INSERT INTO `courseresult` VALUES (73, 11, 28);
INSERT INTO `courseresult` VALUES (73, 7, 12);
INSERT INTO `courseresult` VALUES (73, 12, 36);
INSERT INTO `courseresult` VALUES (74, 9, 100);
INSERT INTO `courseresult` VALUES (74, 8, 39);
INSERT INTO `courseresult` VALUES (74, 4, 76);
INSERT INTO `courseresult` VALUES (74, 16, 23);
INSERT INTO `courseresult` VALUES (74, 4, 16);
INSERT INTO `courseresult` VALUES (74, 15, 60);
INSERT INTO `courseresult` VALUES (75, 16, 3);
INSERT INTO `courseresult` VALUES (75, 1, 12);
INSERT INTO `courseresult` VALUES (75, 12, 98);
INSERT INTO `courseresult` VALUES (75, 1, 70);
INSERT INTO `courseresult` VALUES (75, 2, 46);
INSERT INTO `courseresult` VALUES (75, 11, 51);
INSERT INTO `courseresult` VALUES (76, 11, 29);
INSERT INTO `courseresult` VALUES (76, 10, 11);
INSERT INTO `courseresult` VALUES (76, 15, 78);
INSERT INTO `courseresult` VALUES (76, 15, 0);
INSERT INTO `courseresult` VALUES (76, 10, 36);
INSERT INTO `courseresult` VALUES (76, 15, 3);
INSERT INTO `courseresult` VALUES (77, 9, 15);
INSERT INTO `courseresult` VALUES (77, 7, 2);
INSERT INTO `courseresult` VALUES (77, 12, 26);
INSERT INTO `courseresult` VALUES (77, 6, 27);
INSERT INTO `courseresult` VALUES (77, 10, 10);
INSERT INTO `courseresult` VALUES (77, 7, 68);
INSERT INTO `courseresult` VALUES (78, 16, 5);
INSERT INTO `courseresult` VALUES (78, 3, 41);
INSERT INTO `courseresult` VALUES (78, 10, 16);
INSERT INTO `courseresult` VALUES (78, 6, 12);
INSERT INTO `courseresult` VALUES (78, 4, 90);
INSERT INTO `courseresult` VALUES (78, 7, 51);
INSERT INTO `courseresult` VALUES (79, 9, 49);
INSERT INTO `courseresult` VALUES (79, 3, 95);
INSERT INTO `courseresult` VALUES (79, 16, 86);
INSERT INTO `courseresult` VALUES (79, 9, 56);
INSERT INTO `courseresult` VALUES (79, 5, 61);
INSERT INTO `courseresult` VALUES (79, 7, 31);
INSERT INTO `courseresult` VALUES (80, 3, 18);
INSERT INTO `courseresult` VALUES (80, 11, 35);
INSERT INTO `courseresult` VALUES (80, 1, 50);
INSERT INTO `courseresult` VALUES (80, 8, 63);
INSERT INTO `courseresult` VALUES (80, 15, 15);
INSERT INTO `courseresult` VALUES (80, 8, 7);
INSERT INTO `courseresult` VALUES (81, 11, 66);
INSERT INTO `courseresult` VALUES (81, 6, 28);
INSERT INTO `courseresult` VALUES (81, 6, 92);
INSERT INTO `courseresult` VALUES (81, 15, 2);
INSERT INTO `courseresult` VALUES (81, 2, 61);
INSERT INTO `courseresult` VALUES (81, 1, 62);
INSERT INTO `courseresult` VALUES (82, 12, 39);
INSERT INTO `courseresult` VALUES (82, 13, 66);
INSERT INTO `courseresult` VALUES (82, 16, 11);
INSERT INTO `courseresult` VALUES (82, 12, 88);
INSERT INTO `courseresult` VALUES (82, 4, 57);
INSERT INTO `courseresult` VALUES (82, 13, 39);
INSERT INTO `courseresult` VALUES (83, 1, 6);
INSERT INTO `courseresult` VALUES (83, 14, 67);
INSERT INTO `courseresult` VALUES (83, 16, 14);
INSERT INTO `courseresult` VALUES (83, 6, 87);
INSERT INTO `courseresult` VALUES (83, 3, 7);
INSERT INTO `courseresult` VALUES (83, 14, 22);
INSERT INTO `courseresult` VALUES (84, 10, 18);
INSERT INTO `courseresult` VALUES (84, 15, 29);
INSERT INTO `courseresult` VALUES (84, 10, 39);
INSERT INTO `courseresult` VALUES (84, 14, 50);
INSERT INTO `courseresult` VALUES (84, 12, 34);
INSERT INTO `courseresult` VALUES (84, 8, 38);
INSERT INTO `courseresult` VALUES (85, 6, 45);
INSERT INTO `courseresult` VALUES (85, 4, 47);
INSERT INTO `courseresult` VALUES (85, 15, 91);
INSERT INTO `courseresult` VALUES (85, 1, 52);
INSERT INTO `courseresult` VALUES (85, 2, 43);
INSERT INTO `courseresult` VALUES (85, 13, 28);
INSERT INTO `courseresult` VALUES (1, 3, 78);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '123456' COMMENT '密码，默认123456',
  `classId` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '班级号',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '性别',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '雅何辉', '123456', 'c3', '男', '13421057546');
INSERT INTO `student` VALUES (2, '峰林成', '123456', 'c2', '男', '13441057561');
INSERT INTO `student` VALUES (3, '朝浚诗', '123456', 'c5', '女', '13471457304');
INSERT INTO `student` VALUES (4, '刘蔚徐', '123456', 'c1', '女', '13401157832');
INSERT INTO `student` VALUES (5, '杏辉张', '123456', 'c2', '女', '13431557109');
INSERT INTO `student` VALUES (6, '林龙辉', '123456', 'c3', '女', '13411257002');
INSERT INTO `student` VALUES (7, '雅麦刘', '123456', 'c3', '男', '13481457076');
INSERT INTO `student` VALUES (8, '毛佳家', '123456', 'c1', '女', '13491557790');
INSERT INTO `student` VALUES (9, '辉莹龙', '123456', 'c1', '女', '13491657171');
INSERT INTO `student` VALUES (10, '梁杏张', '123456', 'c5', '男', '13401157811');
INSERT INTO `student` VALUES (11, '刘发巨', '123456', 'c1', '女', '13481557388');
INSERT INTO `student` VALUES (12, '家老儿', '123456', 'c4', '男', '13401257507');
INSERT INTO `student` VALUES (13, '梁蔚阿', '123456', 'c3', '女', '13481157404');
INSERT INTO `student` VALUES (14, '文龙咏', '123456', 'c6', '男', '13491957753');
INSERT INTO `student` VALUES (15, '张梁丽', '123456', 'c1', '男', '13431257959');
INSERT INTO `student` VALUES (16, '发家丽', '123456', 'c3', '男', '13451857232');
INSERT INTO `student` VALUES (17, '雅徐辉', '123456', 'c5', '男', '13401357808');
INSERT INTO `student` VALUES (18, '易朝辉', '123456', 'c4', '男', '13481457411');
INSERT INTO `student` VALUES (19, '丽诗辉', '123456', 'c6', '男', '13491957722');
INSERT INTO `student` VALUES (20, '朝梁汉', '123456', 'c5', '女', '13421657554');
INSERT INTO `student` VALUES (21, '细琪成', '123456', 'c1', '女', '13421657262');
INSERT INTO `student` VALUES (22, '咏欣杏', '123456', 'c3', '女', '13481857669');
INSERT INTO `student` VALUES (23, '欣易蔚', '123456', 'c4', '男', '13461657758');
INSERT INTO `student` VALUES (24, '张辉梁', '123456', 'c6', '男', '13441857846');
INSERT INTO `student` VALUES (25, '欣狼家', '123456', 'c6', '女', '13451757793');
INSERT INTO `student` VALUES (26, '小胡不', '123456', 'c3', '女', '13421957515');
INSERT INTO `student` VALUES (27, '文梁毛', '123456', 'c4', '男', '13471157924');
INSERT INTO `student` VALUES (28, '琪发阿', '123456', 'c4', '男', '13431357334');
INSERT INTO `student` VALUES (29, '何林咏', '123456', 'c1', '女', '13401057674');
INSERT INTO `student` VALUES (30, '梁丽巨', '123456', 'c1', '女', '13471557621');
INSERT INTO `student` VALUES (31, '梁麦家', '123456', 'c1', '女', '13451457925');
INSERT INTO `student` VALUES (32, '胡何家', '123456', 'c1', '女', '13451757195');
INSERT INTO `student` VALUES (33, '浚林蔚', '123456', 'c3', '男', '13461657345');
INSERT INTO `student` VALUES (34, '梁琴家', '123456', 'c2', '女', '13411457140');
INSERT INTO `student` VALUES (35, '汉古梁', '123456', 'c3', '男', '13471457086');
INSERT INTO `student` VALUES (36, '佳杏古', '123456', 'c4', '女', '13421357688');
INSERT INTO `student` VALUES (37, '欣莫莫', '123456', 'c4', '男', '13431357914');
INSERT INTO `student` VALUES (38, '欣佳发', '123456', 'c1', '男', '13481457238');
INSERT INTO `student` VALUES (39, '梁梁琴', '123456', 'c1', '女', '13441957525');
INSERT INTO `student` VALUES (40, '梁阿蔚', '123456', 'c5', '女', '13451857111');
INSERT INTO `student` VALUES (41, '慧莹邓', '123456', 'c6', '女', '13401857128');
INSERT INTO `student` VALUES (42, '徐黎蔚', '123456', 'c5', '男', '13491557447');
INSERT INTO `student` VALUES (43, '麦龙伟', '123456', 'c5', '男', '13491457736');
INSERT INTO `student` VALUES (44, '欣胡伟', '123456', 'c1', '男', '13441557046');
INSERT INTO `student` VALUES (45, '邓慧梁', '123456', 'c5', '女', '13401657243');
INSERT INTO `student` VALUES (46, '林诗琴', '123456', 'c1', '男', '13491057979');
INSERT INTO `student` VALUES (47, '何杏徐', '123456', 'c6', '女', '13451257644');
INSERT INTO `student` VALUES (48, '基麦细', '123456', 'c1', '女', '13491057257');
INSERT INTO `student` VALUES (49, '蔚巨易', '123456', 'c1', '男', '13491457749');
INSERT INTO `student` VALUES (50, '龙阿周', '123456', 'c5', '男', '13421157964');
INSERT INTO `student` VALUES (51, '佳儿阿', '123456', 'c1', '女', '13411557354');
INSERT INTO `student` VALUES (52, '峰咏刘', '123456', 'c6', '女', '13431757412');
INSERT INTO `student` VALUES (53, '咏梁徐', '123456', 'c4', '男', '13451157625');
INSERT INTO `student` VALUES (54, '细汉梁', '123456', 'c6', '男', '13481557986');
INSERT INTO `student` VALUES (55, '文伟蔡', '123456', 'c1', '男', '13421457174');
INSERT INTO `student` VALUES (56, '林朝欣', '123456', 'c6', '女', '13451957789');
INSERT INTO `student` VALUES (57, '徐丽莹', '123456', 'c1', '女', '13461957898');
INSERT INTO `student` VALUES (58, '古不林', '123456', 'c4', '男', '13481657606');
INSERT INTO `student` VALUES (59, '刘蔡巨', '123456', 'c1', '女', '13481257196');
INSERT INTO `student` VALUES (60, '家何蔡', '123456', 'c4', '男', '13471757105');
INSERT INTO `student` VALUES (61, '欣润易', '123456', 'c6', '女', '13441357879');
INSERT INTO `student` VALUES (62, '毛家梁', '123456', 'c5', '男', '13421757995');
INSERT INTO `student` VALUES (63, '杏老麦', '123456', 'c2', '女', '13481457079');
INSERT INTO `student` VALUES (64, '琪雅琪', '123456', 'c1', '男', '13471157844');
INSERT INTO `student` VALUES (65, '黎雅老', '123456', 'c6', '女', '13461857795');
INSERT INTO `student` VALUES (66, '基龙辉', '123456', 'c5', '男', '13471157872');
INSERT INTO `student` VALUES (67, '辉明丽', '123456', 'c4', '男', '13441857059');
INSERT INTO `student` VALUES (68, '杏润文', '123456', 'c6', '男', '13461257754');
INSERT INTO `student` VALUES (69, '梁杏邓', '123456', 'c3', '女', '13401957551');
INSERT INTO `student` VALUES (70, '家胡雅', '123456', 'c3', '女', '13481857082');
INSERT INTO `student` VALUES (71, '蔚林文', '123456', 'c1', '女', '13471257259');
INSERT INTO `student` VALUES (72, '家不狼', '123456', 'c6', '女', '13421857156');
INSERT INTO `student` VALUES (73, '辉慧莫', '123456', 'c5', '男', '13451457710');
INSERT INTO `student` VALUES (74, '毛林龙', '123456', 'c6', '男', '13421857535');
INSERT INTO `student` VALUES (75, '明龙黎', '123456', 'c3', '女', '13471457092');
INSERT INTO `student` VALUES (76, '雅丽汉', '123456', 'c1', '女', '13401857378');
INSERT INTO `student` VALUES (77, '欣伟慧', '123456', 'c6', '男', '13441657849');
INSERT INTO `student` VALUES (78, '莹慧丽', '123456', 'c1', '男', '13411557662');
INSERT INTO `student` VALUES (79, '梁莫古', '123456', 'c6', '男', '13471157797');
INSERT INTO `student` VALUES (80, '何基细', '123456', 'c6', '男', '13491657289');
INSERT INTO `student` VALUES (81, '家莫文', '123456', 'c2', '女', '13421957967');
INSERT INTO `student` VALUES (82, '浚阿辉', '123456', 'c5', '女', '13401457891');
INSERT INTO `student` VALUES (83, '周雅梁', '123456', 'c2', '女', '13491457296');
INSERT INTO `student` VALUES (84, '杏发毛', '123456', 'c3', '男', '13441757988');
INSERT INTO `student` VALUES (85, '老周丽', '123456', 'c4', '男', '13421357172');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教师号',
  `name` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '123456' COMMENT '默认123456',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '性别',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '电话',
  `academy` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学院',
  `classId` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级号（一个老师最多只负责一个班级）',
  `studentNum` int(11) NULL DEFAULT NULL COMMENT '班级的学生人数',
  `courseId` int(11) NOT NULL COMMENT '执教课程ID（简单起见，一个老师最多只执教一门课）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '向建国', '123456', '男', '15513079078', '计算机学院', 'c1', NULL, 1);
INSERT INTO `teacher` VALUES (2, '萨芬', '123456', '男', '155131279078', '计算机学院', NULL, NULL, 2);
INSERT INTO `teacher` VALUES (3, '达娃', '123456', '男', '155130349078', '计算机学院', 'c2', 15, 3);
INSERT INTO `teacher` VALUES (4, '梁汉文', '123456', '男', '155132279078', '体育学院', NULL, NULL, 4);
INSERT INTO `teacher` VALUES (5, '林峰', '123456', '男', '15513079178', '体育学院', 'c3', 15, 5);
INSERT INTO `teacher` VALUES (6, '武广德', '123456', '男', '15513669078', '体育学院', NULL, NULL, 6);
INSERT INTO `teacher` VALUES (7, '杨千嬅', '123456', '女', '155130779078', '体育学院', 'c4', 15, 7);
INSERT INTO `teacher` VALUES (8, '阿娇', '123456', '女', '15513079888', '艺术学院', NULL, NULL, 8);
INSERT INTO `teacher` VALUES (9, '卫兰', '123456', '女', '15513079098', '艺术学院', 'c5', 15, 9);
INSERT INTO `teacher` VALUES (10, '芬兰', '123456', '女', '15513079070', '艺术学院', 'c6', 10, 10);
INSERT INTO `teacher` VALUES (11, '佘诗曼', '123456', '女', '123513079078', '计算机学院', NULL, NULL, 11);
INSERT INTO `teacher` VALUES (12, '莫文蔚', '123456', '女', '15343079078', '计算机学院', NULL, NULL, 12);
INSERT INTO `teacher` VALUES (13, '梅艳芳', '123456', '女', '15543079078', '计算机学院', NULL, NULL, 13);
INSERT INTO `teacher` VALUES (14, '徐小凤', '123456', '女', '15883079078', '计算机学院', NULL, NULL, 14);
INSERT INTO `teacher` VALUES (15, '张洁', '123456', '女', '15503089547', '计算机学院', NULL, NULL, 15);
INSERT INTO `teacher` VALUES (16, '马龙', '123456', '男', '15503329547', '计算机学院', NULL, NULL, 16);

SET FOREIGN_KEY_CHECKS = 1;
