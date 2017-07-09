/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2017-07-02 10:03:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order1`
-- ----------------------------
DROP TABLE IF EXISTS `order1`;
CREATE TABLE `order1` (
  `OD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OD_Name` varchar(100) DEFAULT NULL,
  `U_ID` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`OD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order1
-- ----------------------------
INSERT INTO `order1` VALUES ('1', '订单11', '1');
INSERT INTO `order1` VALUES ('2', '233', '1');
INSERT INTO `order1` VALUES ('3', '12多少度', '2');
INSERT INTO `order1` VALUES ('4', '问问切', '2');
INSERT INTO `order1` VALUES ('5', '热热翁', '2');
INSERT INTO `order1` VALUES ('6', '而我若', '6');

-- ----------------------------
-- Table structure for `tb_grade_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_grade_info`;
CREATE TABLE `tb_grade_info` (
  `ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `SUBJECT_ID` int(11) DEFAULT NULL,
  `GRADE` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_grade_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_menu_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_info`;
CREATE TABLE `tb_menu_info` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL,
  `MEMO` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_order_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_apply`;
CREATE TABLE `tb_order_apply` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ORDER_ID` varchar(30) DEFAULT NULL COMMENT '订单号',
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_order_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_info`;
CREATE TABLE `tb_order_info` (
  `ID` varchar(30) NOT NULL COMMENT '主键',
  `NAME` varchar(30) DEFAULT NULL COMMENT '订单名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `AMOUNT` decimal(9,2) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_test_chind`
-- ----------------------------
DROP TABLE IF EXISTS `tb_test_chind`;
CREATE TABLE `tb_test_chind` (
  `ID` int(11) NOT NULL,
  `VLAUE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_test_chind
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Role_ID` int(11) NOT NULL DEFAULT '2',
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '注解更新成功', '111');
INSERT INTO `user` VALUES ('2', '2', '222', '12');
INSERT INTO `user` VALUES ('6', '2', '注解名3', '4');
INSERT INTO `user` VALUES ('7', '2', '注解名4', '5');
INSERT INTO `user` VALUES ('11', '2', '注解名3', '4');
INSERT INTO `user` VALUES ('12', '2', '注解名4', '5');
INSERT INTO `user` VALUES ('16', '2', '注解名3', '4');
INSERT INTO `user` VALUES ('17', '2', '注解名4', '5');

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `R_ID` int(11) NOT NULL,
  `R_Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`R_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '管理员');
INSERT INTO `userrole` VALUES ('2', '系统操作员');

-- ----------------------------
-- Procedure structure for `getUsersbyAge`
-- ----------------------------
DROP PROCEDURE IF EXISTS `getUsersbyAge`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUsersbyAge`(IN `AgeNUM` int)
BEGIN
	#Routine body goes here...
select * from user where age>=AgeNUM;
END
;;
DELIMITER ;
