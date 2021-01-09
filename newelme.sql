/*
Navicat MySQL Data Transfer

Source Server         : elem
Source Server Version : 50729
Source Host           : localhost:3308
Source Database       : elme

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-12-30 10:11:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for discount
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `discount_id` bigint(11) NOT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `store_id` bigint(11) NOT NULL,
  `discount_name` varchar(20) NOT NULL,
  `discount_money` float NOT NULL,
  `start_money` float NOT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of discount
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `class_name` varchar(50) NOT NULL,
  `goods_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `store_id` bigint(11) DEFAULT NULL,
  `goods_name` varchar(50) NOT NULL,
  `goods_price` float(8,2) NOT NULL,
  `goods_picture` varchar(2083) DEFAULT NULL,
  `goods_description` text,
  `month_sales` int(11) DEFAULT NULL,
  `high_rating` float DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for goods_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `goods_evaluation`;
CREATE TABLE `goods_evaluation` (
  `store_id` bigint(11) DEFAULT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `evaluation_content` text,
  `evaluation_star` float DEFAULT NULL,
  `evaluation_img` varchar(500) DEFAULT NULL,
  `evaluation_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for ord
-- ----------------------------
DROP TABLE IF EXISTS `ord`;
CREATE TABLE `ord` (
  `ord_id` bigint(11) NOT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `store_id` bigint(11) DEFAULT NULL,
  `rider_id` bigint(11) DEFAULT NULL,
  `total_money` float(8,2) NOT NULL,
  `total_discount` float(8,2) NOT NULL,
  `ord_time` datetime NOT NULL,
  `rider_get` float(8,2) NOT NULL,
  PRIMARY KEY (`ord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ord
-- ----------------------------

-- ----------------------------
-- Table structure for ord_goods
-- ----------------------------
DROP TABLE IF EXISTS `ord_goods`;
CREATE TABLE `ord_goods` (
  `ord_id` bigint(11) DEFAULT NULL,
  `goods_name` varchar(50) DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `goods_price` float(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ord_goods
-- ----------------------------

-- ----------------------------
-- Table structure for reduction_plan
-- ----------------------------
DROP TABLE IF EXISTS `reduction_plan`;
CREATE TABLE `reduction_plan` (
  `plan_id` bigint(11) NOT NULL,
  `store_id` bigint(11) DEFAULT NULL,
  `reduction_require` float(8,2) NOT NULL,
  `reduction_money` float(8,2) NOT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of reduction_plan
-- ----------------------------

-- ----------------------------
-- Table structure for rider
-- ----------------------------
DROP TABLE IF EXISTS `rider`;
CREATE TABLE `rider` (
  `rider_id` bigint(11) NOT NULL,
  `rider_name` varchar(20) NOT NULL,
  `rider_passwd` varchar(20) NOT NULL,
  `rider_phone` char(11) NOT NULL,
  `rider_position` varchar(100) NOT NULL,
  PRIMARY KEY (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of rider
-- ----------------------------

-- ----------------------------
-- Table structure for rider_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `rider_evaluation`;
CREATE TABLE `rider_evaluation` (
  `rider_id` bigint(11) DEFAULT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `rider_evaluate` text,
  `rider_stars` float DEFAULT NULL,
  `evaluate_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of rider_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `store_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(50) DEFAULT NULL,
  `store_passwd` varchar(20) DEFAULT NULL,
  `store_address` varchar(200) DEFAULT NULL,
  `store_phone` char(11) DEFAULT NULL,
  `delivery_begin` varchar(200) DEFAULT NULL,
  `delivery_end` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_phone` char(11) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_address_id` bigint(11) NOT NULL,
  `user_main_address` varchar(100) DEFAULT NULL,
  `user_sex` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', null, '123456', 'aaa42296669b958c3cee6c0475c8093e', '0', null, '0');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `user_id` bigint(11) DEFAULT NULL,
  `address_id` bigint(11) NOT NULL,
  `user_address` varchar(100) NOT NULL,
  `main_address` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(20) NOT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `address_detail` varchar(100) DEFAULT NULL,
  `address_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_address
-- ----------------------------
