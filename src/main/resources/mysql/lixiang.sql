/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 5.1.32-community : Database - ane
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ane` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ane`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `provinceId` int(11) DEFAULT NULL,
  `cityName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`cityId`,`provinceId`,`cityName`) values 
(1,1,'北京'),
(2,2,'天津市'),
(3,2,'蓟县09827'),
(4,3,'石家庄市'),
(5,3,'唐山市'),
(6,3,'邯郸市'),
(7,3,'保定市'),
(8,3,'沧州市'),
(9,3,'邢台市'),
(10,3,'廊坊市'),
(11,3,'承德市'),
(12,3,'张家口市'),
(13,3,'衡水市'),
(14,3,'秦皇岛市'),
(15,4,'沈阳市'),
(16,4,'大连市'),
(17,4,'鞍山市'),
(18,4,'抚顺市'),
(19,4,'本溪市'),
(20,4,'丹东市'),
(21,4,'锦州市'),
(22,4,'营口市'),
(23,4,'阜新市'),
(24,4,'辽阳市'),
(25,4,'盘锦市'),
(26,4,'铁岭市'),
(27,4,'朝阳市'),
(28,4,'葫芦岛市'),
(29,5,'长春市'),
(30,5,'吉林市'),
(31,5,'四平市'),
(32,5,'辽源市'),
(33,5,'通化市'),
(34,5,'白山市'),
(35,5,'松原市'),
(36,5,'白城市'),
(37,5,'延边朝鲜族自治州'),
(38,6,'齐齐哈尔市'),
(39,6,'牡丹江市'),
(40,6,'大庆市'),
(41,6,'伊春市'),
(42,6,'鹤岗市'),
(43,6,'黑河市'),
(44,6,'绥化市'),
(45,6,'哈尔滨市'),
(46,6,'双鸭山市'),
(47,6,'佳木斯市'),
(48,6,'鸡西市'),
(49,6,'七台河市'),
(50,6,'大兴安岭地区'),
(51,18,'岳阳市'),
(52,18,'长沙市'),
(53,18,'湘潭市'),
(54,18,'株洲市'),
(55,18,'衡阳市'),
(56,18,'郴州市'),
(57,18,'常德市'),
(58,18,'益阳市'),
(59,18,'娄底市'),
(60,18,'邵阳市'),
(61,18,'湘西土家族苗族自治州'),
(62,18,'张家界市'),
(63,18,'怀化市'),
(64,18,'永州市'),
(65,19,'十堰市'),
(66,19,'武汉市'),
(67,19,'襄阳市'),
(68,19,'鄂州市'),
(69,19,'孝感市'),
(70,19,'黄冈市'),
(71,19,'仙桃市09897'),
(72,19,'黄石市'),
(73,19,'咸宁市'),
(74,19,'宜昌市'),
(75,19,'仙桃市09897'),
(76,19,'恩施土家族苗族自治州'),
(77,19,'随州市'),
(78,19,'荆门市'),
(79,19,'天门市09895'),
(80,19,'潜江市09896'),
(81,19,'荆州市'),
(82,19,'神农架林区'),
(83,19,'天门市'),
(84,19,'仙桃市'),
(85,19,'潜江市');

/*Table structure for table `district` */

DROP TABLE IF EXISTS `district`;

CREATE TABLE `district` (
  `districtId` int(11) NOT NULL AUTO_INCREMENT,
  `provinceId` int(11) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  `districtName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`districtId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `district` */

insert  into `district`(`districtId`,`provinceId`,`cityId`,`districtName`) values 
(1,18,52,'雨花区'),
(2,18,52,'天心区'),
(3,18,52,'宁乡县'),
(4,18,52,'宁乡市'),
(5,18,52,'岳麓区'),
(6,18,52,'开福区'),
(7,18,52,'望城区'),
(8,18,52,'浏阳市'),
(9,18,52,'芙蓉区'),
(10,18,52,'长沙县'),
(11,19,66,'东西湖区'),
(12,19,66,'新洲区'),
(13,19,66,'武昌区'),
(14,19,66,'汉南区'),
(15,19,66,'汉阳区'),
(16,19,66,'江夏区'),
(17,19,66,'江岸区'),
(18,19,66,'江汉区'),
(19,19,66,'洪山区'),
(20,19,66,'硚口区'),
(21,19,66,'蔡甸区'),
(22,19,66,'青山区'),
(23,19,66,'黄陂区');

/*Table structure for table `path` */

DROP TABLE IF EXISTS `path`;

CREATE TABLE `path` (
  `pathId` int(11) NOT NULL AUTO_INCREMENT,
  `startStation` int(11) DEFAULT NULL,
  `stationIds` varchar(100) DEFAULT NULL,
  `destination` int(11) DEFAULT NULL,
  PRIMARY KEY (`pathId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `path` */

insert  into `path`(`pathId`,`startStation`,`stationIds`,`destination`) values 
(1,1,'2-6-9-',13),
(2,12,'14-16-',19),
(3,14,'15-',17),
(4,10,'12-15-18-',22),
(5,8,'1-',6),
(6,2,'12-',16);

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `provinceId` int(11) NOT NULL AUTO_INCREMENT,
  `provinceName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`provinceId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `province` */

insert  into `province`(`provinceId`,`provinceName`) values 
(1,'北京'),
(2,'天津'),
(3,'河北'),
(4,'辽宁'),
(5,'吉林'),
(6,'黑龙江'),
(7,'山东'),
(8,'江苏'),
(9,'上海'),
(10,'浙江'),
(11,'安徽'),
(12,'福建'),
(13,'江西'),
(14,'广东'),
(15,'广西'),
(16,'海南'),
(17,'河南'),
(18,'湖南'),
(19,'湖北'),
(20,'山西'),
(21,'内蒙古'),
(22,'宁夏'),
(23,'青海'),
(24,'陕西'),
(25,'甘肃'),
(26,'新疆'),
(27,'四川'),
(28,'贵州'),
(29,'云南'),
(30,'重庆'),
(31,'西藏'),
(32,'香港'),
(33,'澳门'),
(34,'台湾');

/*Table structure for table `route` */

DROP TABLE IF EXISTS `route`;

CREATE TABLE `route` (
  `routeId` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `pathId` int(11) DEFAULT NULL,
  `startTime` varchar(50) DEFAULT NULL,
  `arriveTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`routeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `route` */

/*Table structure for table `station` */

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `stationId` int(11) NOT NULL AUTO_INCREMENT,
  `cityId` int(20) DEFAULT NULL,
  `stationName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stationId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `station` */

insert  into `station`(`stationId`,`cityId`,`stationName`) values 
(1,52,'长沙望城集散站'),
(2,52,'岳麓东方红'),
(3,52,'长沙岳麓航天S'),
(4,52,'长沙毛塘铺'),
(5,52,'长沙望城捷传'),
(6,52,'雨花区高桥'),
(7,52,'长沙望城丁字铺'),
(8,66,'走马岭工业区'),
(9,66,'武昌积玉桥'),
(10,66,'阳逻开发区'),
(11,66,'青山内三环'),
(12,66,'汉阳太子湖'),
(13,66,'武汉百步亭'),
(14,66,'东西湖将军路'),
(15,66,'汉口北商贸区'),
(16,66,'汉口新华路'),
(17,66,'光谷未来城'),
(18,66,'东西湖中小企业城'),
(19,66,'东西湖高桥'),
(20,66,'麻绳港'),
(21,66,'汉口长青路'),
(22,66,'武昌凤凰园');

/*Table structure for table `trucks` */

DROP TABLE IF EXISTS `trucks`;

CREATE TABLE `trucks` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tnumber` varchar(7) DEFAULT NULL,
  `eid` int(11) DEFAULT NULL,
  `parcelId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `trucks` */

insert  into `trucks`(`tid`,`tnumber`,`eid`,`parcelId`,`state`) values 
(1,'湘A12345',1,1,1),
(2,'湘A56324',2,2,0),
(3,'湘A68433',3,3,0),
(4,'湘A97568',4,4,0),
(5,'湘A48469',5,5,0),
(6,'湘A08575',6,6,0),
(7,'湘A47925',7,7,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
