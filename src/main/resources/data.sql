-- -- INSERT INTO teacher (tea_id,password) VALUES ('0000000000','0000000000');
-- -- INSERT IGNORE INTO teacher VALUE (tea_id,password) VALUES ('0000000000','0000000000');
-- -- IF not exists(select * from teacher where tea_id = '0000000000') INSERT INTO teacher (tea_id,password) VALUES ('0000000000','0000000000');
-- INSERT IGNORE INTO teacher(tea_id,password,authority,email)  VALUE("0000000000","0000000000",99,"983604371@qq.com");
INSERT INTO `userinfo` VALUES (2, '111', '111', '2018-2-2', '983604371@qq.com', '123', '456', '123456789', '8888', '2345', '6789', 'male');
INSERT INTO `userinfo` VALUES (1, '111', '1111155551', '2018-2-2', '555@qq.com', '123', '789798', '789', '123456789', '2345', '6789', 'male');
INSERT INTO `userinfo` VALUES (3, '111', '111', '2018-2-2', '2596331356@qq.com', '123', '456', '123456789', '1234', '2345', '6789', 'male');
INSERT INTO `userinfo` VALUES (4, '111', '111', '2018-2-2', '2540365386@qq.com', '123', '456', '123456789', '1234', '2345', '6789', 'male');

INSERT INTO `flight` VALUES (1, '2018-2-2 12:30:15', '2018-2-2 12:30:15', 30, 3000,'0.8', 40, 400, '北京乌海','北京', 10, 10000, 'A0001', 'normal', '上海浦东','上海','2020-6-20 13:49:09', '2020-6-18 13:49:14', 80);
INSERT INTO `flight` VALUES (2, '2018-2-3 12:30:15', '2018-2-3 12:30:15', 30, 3000,'1.0', 40, 400, '北京乌海','北京', 10, 10000, 'A0002', 'normal', '深圳安保','深圳','2020-6-20 13:49:09', '2020-6-18 13:49:14', 80);
INSERT INTO `flight` VALUES (7, '2018-2-4 12:30:15', '2018-2-4 12:30:15', 30, 3000,'1.0', 40, 400, '广州白云','广州', 10, 10000, 'A0003', 'normal', '上海浦东','上海','2020-6-20 13:49:09', '2020-6-18 13:49:14', 80);
INSERT INTO `flight` VALUES (8, '2018-2-5 12:30:15', '2018-2-5 12:30:15', 30, 3000,'1.0',40, 400, '成都双流','成都', 10, 10000, 'A0004', 'normal', '上海浦东','上海','2020-6-20 13:49:09', '2020-6-26 13:49:14', 80);

INSERT INTO `order_ticket` VALUES (1, '2020-6-20 18:20:15','1.0', '555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678', 'OT555@qq.com', '1','123456789012345678', '18081440318', 10000, '张明明','male', '上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (2, '2020-6-20 18:20:15','1.0', '555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678', 'OT555@qq.com', '1','123456789012345678', '18081440311', 10000, '张大双','male', '上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (3, '2020-6-20 18:20:15','1.0', '555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678', 'OT555@qq.com', '1','123456789012345678','18081440312', 10000, '王菲菲', 'male','上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (4, '2020-6-20 18:20:15','1.0', '5555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678','OT555@qq.com', '1','123456789012345678', '18081440313', 10000, '妲萌萌','male','上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (5, '2020-6-20 18:20:15','1.0', '5555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678','OT555@qq.com', '1','123456789012345678', '18081440314', 10000, '王三三','male', '上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (6, '2020-6-20 18:20:15','1.0', '5555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678', 'T0001', '1','123456789012345678', '18081440315', 10000, '李四四','male','上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (7, '2020-6-20 18:20:15','1.0', '5555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678', 'T0001', '1','123456789012345678', '18081440317', 10000, '李小四','male', '上海浦东','上海', '2020-6-19 18:21:36', 'A0001');
INSERT INTO `order_ticket` VALUES (8, '2020-6-20 18:20:15','1.0', '5555@qq.com', '北京乌海','北京', 'firstClass','123456789012345678', 'T0001', '1','123456789012345678', '18081440316', 10000, '李大四','male','上海浦东','上海', '2020-6-19 18:21:36', 'A0001');