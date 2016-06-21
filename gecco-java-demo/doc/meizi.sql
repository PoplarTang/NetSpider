-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.17 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 jadmin 的数据库结构
CREATE DATABASE IF NOT EXISTS `jadmin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jadmin`;


-- 导出  表 jadmin.t_mz_pic 结构
CREATE TABLE IF NOT EXISTS `t_mz_pic` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PicInfoId` int(11) DEFAULT NULL COMMENT '图片信息',
  `URL` varchar(100) NOT NULL DEFAULT '0' COMMENT '图片地址',
  `Path` varchar(100) NOT NULL DEFAULT '0' COMMENT '下载下来后的本地地址(保存相对路径)',
  `CreateDate` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `UpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片地址(原始地址，以及本地地址)';

-- 数据导出被取消选择。


-- 导出  表 jadmin.t_mz_picinfo 结构
CREATE TABLE IF NOT EXISTS `t_mz_picinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tag` int(11) NOT NULL DEFAULT '0' COMMENT '所属标签',
  `Alt` varchar(255) NOT NULL DEFAULT '0' COMMENT '图片描述',
  `Thumbnail` varchar(255) NOT NULL DEFAULT '0' COMMENT '缩略图',
  `Href` varchar(255) NOT NULL DEFAULT '0' COMMENT '超链接',
  `CreateDate` datetime DEFAULT '0000-00-00 00:00:00',
  `UpdateDate` datetime DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片信息';

-- 数据导出被取消选择。


-- 导出  表 jadmin.t_mz_tag 结构
CREATE TABLE IF NOT EXISTS `t_mz_tag` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tag` varchar(50) NOT NULL DEFAULT '0' COMMENT '分类',
  `url` varchar(100) DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='妹子图-分类';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
