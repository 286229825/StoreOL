/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.54 : Database - store_online
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`store_online` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `store_online`;

/*Table structure for table `tb_customer` */

DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `vocation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `tb_customer` */

insert  into `tb_customer`(`id`,`name`,`password`,`realName`,`birthday`,`vocation`,`email`,`sex`) values (1,'小宋','66','宋小宝','2017-04-10','老师','12345@qq.com','男'),(2,'小岳','66','岳云鹏','2017-04-02','老师','67890@qq.com','男'),(3,'小余','66','余罪','2017-04-15','学生','12345@qq.com','男'),(5,'小白','66','白客','2017-04-12','老师','12345@qq.com','男'),(6,'小孙','88','孙俪','2017-04-20','老师','67890@qq.com','女'),(7,'小马','66','马岩松','2017-04-11','设计师','12345@qq.com','男'),(10,'小苏','66','苏昱','2017-04-04','程序员','12345@qq.com','男'),(12,'小郭','66','郭靖','2017-04-26','老师','67890@qq.com','男'),(20,'小宋','66','宋小宝','2017-04-12','老师','1233565@qq.com','男'),(22,'小吴','66','吴尊','2017-04-06','老师','2334223@qq.com','男'),(23,'DD','66','DD','2017-04-12','程序员','1234456@qq.com','女');

/*Table structure for table `tb_goods` */

DROP TABLE IF EXISTS `tb_goods`;

CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `goodFrom` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `nowPrice` float DEFAULT NULL,
  `salePrice` float DEFAULT NULL,
  `buyTimes` int(11) DEFAULT NULL,
  `ifSale` int(11) DEFAULT NULL,
  `pictrue` varchar(255) DEFAULT NULL,
  `ggId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk3qjm4iwcfhsfy5ds5gjkbcjx` (`ggId`),
  CONSTRAINT `FKk3qjm4iwcfhsfy5ds5gjkbcjx` FOREIGN KEY (`ggId`) REFERENCES `tb_goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `tb_goods` */

insert  into `tb_goods`(`id`,`name`,`goodFrom`,`introduce`,`creatTime`,`nowPrice`,`salePrice`,`buyTimes`,`ifSale`,`pictrue`,`ggId`) values (3,'活着','作家出版社','获法兰西文学和艺术骑士勋章','2017-04-11 16:08:16',27,17,10,1,'book02.jpg',1),(5,'行者无疆','岳麓书社','新华书店正版畅销图书籍','2017-04-15 17:13:25',14,0,8,2,'book04.jpg',1),(7,'小米Air','中国大陆','全金属超轻薄笔记本电脑','2017-04-11 16:19:31',4999,0,6,2,'computer01.jpg',6),(8,'联想小新310','中国大陆','15.6英寸笔记本电脑','2017-04-11 16:22:37',5599,0,5,2,'computer03.jpg',6),(9,'三星550R5L-Z03','中国大陆','15.6英寸笔记本电脑','2017-04-11 16:24:48',4698,0,4,2,'computer02.jpg',6),(10,'惠普暗影精灵II代','中国大陆','15.6英寸游戏笔记本','2017-04-11 16:26:26',5999,0,3,2,'computer04.jpg',6),(11,'戴尔灵越游匣','中国大陆','15.6英寸游戏笔记本电脑','2017-04-11 16:28:02',4798,0,2,2,'computer06.jpg',6);

/*Table structure for table `tb_goodstype` */

DROP TABLE IF EXISTS `tb_goodstype`;

CREATE TABLE `tb_goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_goodstype` */

insert  into `tb_goodstype`(`id`,`type`) values (1,'书籍'),(2,'服装'),(3,'家具'),(4,'家电'),(5,'手机'),(6,'电脑');

/*Table structure for table `tb_manager` */

DROP TABLE IF EXISTS `tb_manager`;

CREATE TABLE `tb_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_manager` */

insert  into `tb_manager`(`id`,`name`,`password`,`realName`,`level`) values (1,'mgrAA','66','AA','super'),(3,'mgrBB','66','BB','super'),(4,'mgrCC','88','CC','simple');

/*Table structure for table `tb_notice` */

DROP TABLE IF EXISTS `tb_notice`;

CREATE TABLE `tb_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `tb_notice` */

insert  into `tb_notice`(`id`,`notice`) values (2,'无线你的无限'),(3,'多一些润滑，少一些摩擦'),(4,'只要有梦想 凡事可成真'),(5,'世界因你而广阔'),(6,'非常可乐，非常选择'),(7,'情系中国结，联通四海心'),(8,'时间因我存在'),(9,'温暖亲情，金龙鱼的大家庭'),(10,'臭名远扬，香飘万里'),(11,'永远要让驾驶执照比你自己先到期'),(12,'邦迪坚信，没有愈合不了的伤口'),(13,'原来生活可以更美的'),(14,'飘柔，就是这么自信'),(15,'三千烦恼丝，健康新开始'),(16,'安全保障 自有一套');

/*Table structure for table `tb_orders` */

DROP TABLE IF EXISTS `tb_orders`;

CREATE TABLE `tb_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `totalMoney` float DEFAULT NULL,
  `payMent` varchar(255) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `postMethod` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `ifPost` int(11) DEFAULT NULL,
  `coId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhklspmfuo8sdru5nrs35qhus3` (`coId`),
  CONSTRAINT `FKhklspmfuo8sdru5nrs35qhus3` FOREIGN KEY (`coId`) REFERENCES `tb_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_orders` */

insert  into `tb_orders`(`id`,`address`,`phone`,`totalMoney`,`payMent`,`creatTime`,`postMethod`,`remarks`,`ifPost`,`coId`) values (5,'BB','BB',56.7,'BB','2017-04-14 13:44:33','支付宝','BB',2,1),(8,'VV','123454',5030,'微信','2017-04-16 16:21:59','QQ','SD',2,1);

/*Table structure for table `tb_ordersdetail` */

DROP TABLE IF EXISTS `tb_ordersdetail`;

CREATE TABLE `tb_ordersdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `ooId` int(11) DEFAULT NULL,
  `ogId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4t99hnektamj54jbjaomriifg` (`ooId`),
  KEY `FK8h0vf0dydsp5lmgqso3fwg7hr` (`ogId`),
  CONSTRAINT `FK4t99hnektamj54jbjaomriifg` FOREIGN KEY (`ooId`) REFERENCES `tb_orders` (`id`),
  CONSTRAINT `FK8h0vf0dydsp5lmgqso3fwg7hr` FOREIGN KEY (`ogId`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `tb_ordersdetail` */

insert  into `tb_ordersdetail`(`id`,`number`,`money`,`ooId`,`ogId`) values (12,1,17,5,3),(18,1,14,8,5),(19,1,17,8,3),(20,1,4999,8,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
