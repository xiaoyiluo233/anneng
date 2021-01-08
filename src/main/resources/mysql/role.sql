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

/*Table structure for table `employee` */

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) NOT NULL,
  `epassword` varchar(20) NOT NULL,
  `eage` int(11) NOT NULL,
  `esex` char(1) NOT NULL,
  `ephone` varchar(11) NOT NULL,
  `districtId` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`eid`,`ename`,`epassword`,`eage`,`esex`,`ephone`,`districtId`,`state`) values 
(1,'12345','123',18,'男','12345678910',1,1),
(2,'123','11',11,'女','23456',1,2),
(6,'12345','123',12,'男','12345678901',12,1);

/*Table structure for table `employeerole` */

CREATE TABLE `employeerole` (
  `erid` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`erid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `employeerole` */

insert  into `employeerole`(`erid`,`eid`,`roleId`) values 
(7,1,6),
(8,2,5);

/*Table structure for table `menu` */

CREATE TABLE `menu` (
  `menuId` varchar(10) NOT NULL,
  `title` varchar(50) NOT NULL,
  `url` varchar(50) DEFAULT NULL,
  `levelId` varchar(10) NOT NULL,
  `iconCls` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuId`,`title`,`url`,`levelId`,`iconCls`) values 
('A01','订单管理','','root','fa fa-pencil-square-o'),
('A0101','订单信息',NULL,'A01',NULL),
('A0102','工单信息',NULL,'A01',NULL),
('A0103','快递签收信息',NULL,'A01',NULL),
('A0104','用户下单信息',NULL,'A01',NULL),
('A02','员工管理',NULL,'root','glyphicon glyphicon-user'),
('A0201','员工在职信息',NULL,'A02',NULL),
('A0202','员工离职信息',NULL,'A02',NULL),
('A03','财务管理',NULL,'root','fa fa-bar-chart-o'),
('A0301','计费系统',NULL,'A03',NULL),
('A04','用户管理',NULL,'root','fa fa-users'),
('A0401','用户信息',NULL,'A04',NULL),
('A0402','投诉信息',NULL,'A04',NULL),
('A05','运输管理',NULL,'root','fa fa-truck'),
('A0501','路由信息',NULL,'A05',NULL),
('A0502','物流跟踪信息',NULL,'A05',NULL),
('A0503','中转站信息',NULL,'A05',NULL),
('A0504','货车信息',NULL,'A05',NULL),
('A06','仓库管理',NULL,'root','fa fa-home'),
('A0601','仓库信息',NULL,'A06',NULL),
('A07','权限管理',NULL,'root','fa fa-cog'),
('A0701','修改密码',NULL,'A07',NULL),
('A0702','角色管理',NULL,'A07',NULL),
('A0703','菜单管理','','A07',''),
('A0704','权限分配','','A07','');

/*Table structure for table `role` */

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleId`,`roleName`) values 
(1,'司机'),
(2,'仓库管理员'),
(3,'客服'),
(4,'会计'),
(5,'人事经理'),
(6,'总经理'),
(7,'快递员');

/*Table structure for table `rolemenu` */

CREATE TABLE `rolemenu` (
  `rmid` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `menuId` varchar(10) NOT NULL,
  PRIMARY KEY (`rmid`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

/*Data for the table `rolemenu` */

insert  into `rolemenu`(`rmid`,`roleId`,`menuId`) values 
(49,6,'A01'),
(50,6,'A0101'),
(51,6,'A0102'),
(52,6,'A0103'),
(53,6,'A0104'),
(54,6,'A02'),
(55,6,'A0201'),
(56,6,'A0202'),
(57,6,'A03'),
(58,6,'A0301'),
(59,6,'A04'),
(60,6,'A0401'),
(61,6,'A0402'),
(62,6,'A05'),
(63,6,'A0501'),
(64,6,'A0502'),
(65,6,'A0503'),
(66,6,'A0504'),
(67,6,'A06'),
(68,6,'A0601'),
(69,6,'A07'),
(70,6,'A0701'),
(71,6,'A0702'),
(72,6,'A0703'),
(73,6,'A0704'),
(74,7,'A01'),
(75,7,'A0101'),
(76,7,'A0102'),
(77,7,'A0103'),
(78,7,'A0104'),
(79,7,'A07'),
(80,7,'A0701'),
(81,5,'A01'),
(82,5,'A0102'),
(83,5,'A02'),
(84,5,'A0201'),
(85,5,'A0202'),
(86,5,'A07'),
(87,5,'A0701'),
(88,4,'A03'),
(89,4,'A0301'),
(90,4,'A07'),
(91,4,'A0701'),
(92,3,'A04'),
(93,3,'A0402'),
(94,3,'A07'),
(95,3,'A0701'),
(96,2,'A06'),
(97,2,'A0601'),
(98,2,'A07'),
(99,2,'A0701'),
(100,1,'A05'),
(101,1,'A0504'),
(102,1,'A07'),
(103,1,'A0701');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
