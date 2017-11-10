/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : advertis

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-11-10 17:27:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `filename` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `attname` varchar(255) DEFAULT NULL COMMENT '附件存储名称',
  `filepath` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `filesize` int(11) DEFAULT NULL COMMENT '文件大小',
  `cid` int(11) DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `attachment_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('1', '53abd200ee0a3.jpg', 'b0ac2a772b0f42e7bd64399a16189189.jpg', 'http://127.0.0.1/53abd200ee0a3.jpg', '28509', '1');
INSERT INTO `attachment` VALUES ('3', 'desk.jpg', '08a7b4deef5a42a5947751519274cc69.jpg', 'http://127.0.0.1/desk.jpg', '204868', '1');

-- ----------------------------
-- Table structure for browse
-- ----------------------------
DROP TABLE IF EXISTS `browse`;
CREATE TABLE `browse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `createdate` date DEFAULT NULL COMMENT '日期',
  `number` int(11) DEFAULT '0' COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问量统计表';

-- ----------------------------
-- Records of browse
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='分类信息表';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'VI/CI设计', '0', '2017-11-03 10:18:41');
INSERT INTO `category` VALUES ('2', '标志设计', '0', '2017-11-03 10:18:54');
INSERT INTO `category` VALUES ('3', '图形/图案设计', '0', '2017-11-03 10:19:04');
INSERT INTO `category` VALUES ('4', '字体/字形设计', '0', '2017-11-03 10:19:18');
INSERT INTO `category` VALUES ('5', '宣传单/平面广告设计', '0', '2017-11-03 10:19:28');
INSERT INTO `category` VALUES ('6', '海报设计 ', '0', '2017-11-03 10:19:37');
INSERT INTO `category` VALUES ('7', '包装设计', '0', '2017-11-03 10:19:52');
INSERT INTO `category` VALUES ('8', '书装/画册设计', '0', '2017-11-03 10:20:02');
INSERT INTO `category` VALUES ('9', ' 其他平面设计', '0', '2017-11-03 10:20:16');

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '姓名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `message` varchar(255) DEFAULT NULL COMMENT '信息',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0:未读，1:已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='客户意向表';

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', '路人甲', '1334996110@qq.com', '18368921130', '测试客户意向仪表盘', '2017-11-03 17:28:06', '1');
INSERT INTO `customers` VALUES ('2', '路人乙', '1334996110@qq.com', '18368921130', '测试客户意向仪表盘', '2017-11-03 17:28:12', '1');

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `desction` varchar(255) DEFAULT NULL COMMENT '介绍',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='模块表';

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '首页', 'Bootstrap Modals（模态框）是使用定制的 Jquery 插件创建的。它可以用来创建模态窗口丰富用户体验，或者为用户添加实用功能。您可以在 Modals（模态框）中使用 Popover（弹出框）和 Tooltip（工具提示插件）。', '2017-11-02 17:54:33');
INSERT INTO `module` VALUES ('2', '案例展示', '案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试', '2017-11-02 16:41:26');
INSERT INTO `module` VALUES ('3', '服务内容', '服务内容简介测试服务内容简介测试服务内容简介测试', '2017-11-02 16:39:03');
INSERT INTO `module` VALUES ('4', '最新动态', '最新动态简介测试最新动态简介测试最新动态简介测试', '2017-11-02 16:39:07');
INSERT INTO `module` VALUES ('5', '关于我们', '关于我们简介测试关于我们简介测试关于我们简介测试', '2017-11-02 16:39:10');
INSERT INTO `module` VALUES ('6', '联系我们', '联系我们简介测试联系我们简介测试联系我们简介测试', '2017-11-02 16:39:14');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginname` varchar(255) DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `updatetime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '2017-11-01 11:35:58', '王世聪', '管理员');
INSERT INTO `users` VALUES ('2', 'xuehb', '111111', '2017-11-02 11:39:54', '薛宏博', '平面设计');
INSERT INTO `users` VALUES ('3', 'wangsc', '111111', '2017-11-02 11:42:41', '你猜猜', '开发者');
