/*
Navicat MySQL Data Transfer

Source Server         : 181_mysql
Source Server Version : 80015
Source Host           : 192.168.1.181:3306
Source Database       : bull-scheduling

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-01-13 16:20:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `TASK_NAME` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务名称',
  `TARGET_URL` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '调用地址',
  `METHOD` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'http调用方法 get post',
  `CRON` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'cron表达式',
  `PARAM` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求参数',
  `PARAM_TYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参数类型  ParamType',
  `OPERATE_CODE` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作人CODE',
  `OPERATE_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作人名称',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFY` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态 参考NormalStatus',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='任务表';

-- ----------------------------
-- Table structure for t_task_exe_record
-- ----------------------------
DROP TABLE IF EXISTS `t_task_exe_record`;
CREATE TABLE `t_task_exe_record` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `TASK_CODE` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务编号',
  `GMT_START` datetime DEFAULT NULL COMMENT '任务执行开始时间',
  `GMT_END` datetime DEFAULT NULL COMMENT '任务执行结束时间',
  `RESULTS` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '执行结果',
  `RESULT_BODY` tinytext COLLATE utf8mb4_bin COMMENT '执行返回体',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='任务执行记录';
