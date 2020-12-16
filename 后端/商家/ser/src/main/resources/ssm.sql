/*
 Navicat Premium Data Transfer

 Source Server         : work
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 07/12/2020 10:20:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contact_info
-- ----------------------------
DROP TABLE IF EXISTS `contact_info`;
CREATE TABLE `contact_info`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `contact_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact_info
-- ----------------------------
INSERT INTO `contact_info` VALUES (1, '王宇超联系人', '13500000000', 100, '20184056');

-- ----------------------------
-- Table structure for custom
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES (1, '王宇超', '天津', '王宇超联系人');
INSERT INTO `custom` VALUES (2, '王宇超1', '北京', '王宇超联系人1');
INSERT INTO `custom` VALUES (3, '王宇超2', '南京', '王宇超联系人2');
INSERT INTO `custom` VALUES (4, '王宇超3', '重庆', '王宇超联系人3');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '王宇超', 21, '20184056');
INSERT INTO `student` VALUES (2, '张三', 20, '20180101');

SET FOREIGN_KEY_CHECKS = 1;
