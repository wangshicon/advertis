/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.10-log : Database - advertis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`advertis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `advertis`;

/*Table structure for table `attachment` */

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='附件表';

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`filename`,`attname`,`filepath`,`filesize`,`cid`) values 
(1,'pf1.jpg','49671d33075c48a6827671cd5809c6e8.jpg','http://127.0.0.1/49671d33075c48a6827671cd5809c6e8.jpg',38471,1),
(2,'pf4.jpg','1b7faa84b55146c286c050eeebfa044f.jpg','http://127.0.0.1/1b7faa84b55146c286c050eeebfa044f.jpg',76031,1),
(3,'pf6.jpg','ce38cd2a7814463a968da232769ea20f.jpg','http://127.0.0.1/ce38cd2a7814463a968da232769ea20f.jpg',70640,1),
(4,'pf2.jpg','bf229a420d524c84b0dda0ae20a83a94.jpg','http://127.0.0.1/bf229a420d524c84b0dda0ae20a83a94.jpg',94593,1),
(5,'pf3.jpg','78cfb3ca2b1242b2b67c1917572aa9f8.jpg','http://127.0.0.1/78cfb3ca2b1242b2b67c1917572aa9f8.jpg',46523,1),
(6,'pf5.jpg','0880d0ca14ad492ca371c843c6afe008.jpg','http://127.0.0.1/0880d0ca14ad492ca371c843c6afe008.jpg',73687,1),
(7,'pf7.jpg','8b8c099a10e14a79b43dc2b73a3fe3b2.jpg','http://127.0.0.1/8b8c099a10e14a79b43dc2b73a3fe3b2.jpg',72192,1),
(8,'pf8.jpg','1362c64f0668422c852e2522e9cf0035.jpg','http://127.0.0.1/1362c64f0668422c852e2522e9cf0035.jpg',66149,1);

/*Table structure for table `browse` */

DROP TABLE IF EXISTS `browse`;

CREATE TABLE `browse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `createdate` date DEFAULT NULL COMMENT '日期',
  `number` int(11) DEFAULT '0' COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问量统计表';

/*Data for the table `browse` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='分类信息表';

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`status`,`createtime`) values 
(1,'VI/CI设计',0,'2017-11-03 10:18:41'),
(2,'标志设计',0,'2017-11-03 10:18:54'),
(3,'图形/图案设计',0,'2017-11-03 10:19:04'),
(4,'字体/字形设计',0,'2017-11-03 10:19:18'),
(5,'宣传单/平面广告设计',0,'2017-11-03 10:19:28'),
(6,'海报设计 ',0,'2017-11-03 10:19:37'),
(7,'包装设计',0,'2017-11-03 10:19:52'),
(8,'书装/画册设计',0,'2017-11-03 10:20:02'),
(9,' 其他平面设计',0,'2017-11-03 10:20:16');

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '姓名',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `phone` varchar(255) NOT NULL COMMENT '电话',
  `message` varchar(255) DEFAULT NULL COMMENT '信息',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0:未读，1:已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='客户意向表';

/*Data for the table `customers` */

insert  into `customers`(`id`,`username`,`email`,`phone`,`message`,`createtime`,`status`) values 
(1,'路人甲','1334996110@qq.com','18368921130','测试客户意向仪表盘','2017-11-03 17:28:06',1),
(2,'路人乙','1334996110@qq.com','18368921130','测试客户意向仪表盘','2017-11-03 17:28:12',1),
(11,'萨的发生','1334996110@qq.com','15212','1213132','2017-11-16 18:30:17',0),
(12,'admin','1334996110@qq.com','15293418716','sdasfasdfasdfa','2017-11-16 18:38:32',0),
(13,'wew','1334996110@qq.com','15293418716','wewe','2017-11-17 11:14:12',0);

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `desction` varchar(255) DEFAULT NULL COMMENT '介绍',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='模块表';

/*Data for the table `module` */

insert  into `module`(`id`,`name`,`desction`,`createtime`) values 
(1,'首页','创新企业定制服务,来自宏博广告永不畏惧的创新力量。 全力为小企业提供门头广告设计制作于安装、名片/宣传页/彩旗等产品设计、展架、海报、喷绘、条幅、写真等订制服务。','2017-11-15 15:47:49'),
(2,'关于我们','案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试案例展示简介测试','2017-11-15 15:45:08'),
(3,'服务内容','VI/CI设计 、 标志设计 、 图形/图案设计 、 字体/字形设计 、 宣传单/平面广告设计 、 海报设计 、 包装设计 、 书装/画册设计 、 PPT/演示设计 、 其他平面设计。','2017-11-16 14:57:24'),
(4,'案例展示','专业的服务团队为您量身定制，优秀的设计方案及后期制作，为您解决一切后顾之忧。','2017-11-15 16:09:43'),
(5,'联系我们','拥有不一样的高端品牌服务，你还在等什么？可以从以下方式联系我们。','2017-11-16 14:55:40');

/*Table structure for table `users` */

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

/*Data for the table `users` */

insert  into `users`(`id`,`loginname`,`password`,`updatetime`,`username`,`role`) values 
(1,'admin','admin','2017-11-01 11:35:58','王世聪','管理员'),
(2,'xuehb','111111','2017-11-02 11:39:54','薛宏博','平面设计'),
(3,'wangsc','111111','2017-11-02 11:42:41','你猜猜','开发者');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
