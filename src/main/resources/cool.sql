/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : cool

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-04-29 15:28:24
*/
/*
    在数据库的mysql中进行主从设置
    maxflag用来模拟生成分片列
    user是要分数据的逻辑表
    user_0,user_1,user_2,user_3,user_4是存储数据的实际表
 */
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for maxflag
-- ----------------------------
DROP TABLE IF EXISTS `maxflag`;
CREATE TABLE `maxflag` (
  `count` int(11) DEFAULT '0',
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx-username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_0
-- ----------------------------
DROP TABLE IF EXISTS `user_0`;
CREATE TABLE `user_0` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx-username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=324 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_1
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx-username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=313 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_2
-- ----------------------------
DROP TABLE IF EXISTS `user_2`;
CREATE TABLE `user_2` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx-username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=322 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_3
-- ----------------------------
DROP TABLE IF EXISTS `user_3`;
CREATE TABLE `user_3` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx-username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=310 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_4
-- ----------------------------
DROP TABLE IF EXISTS `user_4`;
CREATE TABLE `user_4` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx-username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
