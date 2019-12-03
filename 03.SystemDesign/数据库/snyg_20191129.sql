/*
Navicat MySQL Data Transfer

Source Server         : 47.94.3.77
Source Server Version : 50727
Source Host           : 47.94.3.77:3306
Source Database       : snyg_20191129

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-03 11:29:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_pub_areacode
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_areacode`;
CREATE TABLE `t_pub_areacode` (
  `F_PROVINCE_NO` int(11) DEFAULT NULL COMMENT '省',
  `F_CITY_NO` int(11) DEFAULT NULL COMMENT '市',
  `F_ZONE_NO` int(11) NOT NULL DEFAULT '0' COMMENT '区',
  `F_AREA_NAME` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`F_ZONE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pub_areacode
-- ----------------------------
INSERT INTO `t_pub_areacode` VALUES ('11', '1100', '110000', '北京市');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110100', '北京市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110101', '北京市东城区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110102', '北京市西城区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110103', '北京市崇文区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110104', '北京市宣武区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110105', '北京市朝阳区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110106', '北京市丰台区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110107', '北京市石景山区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110108', '北京市海淀区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110109', '北京市门头沟区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110111', '北京市房山区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110112', '北京市通州区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110113', '北京市顺义区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110114', '北京市昌平区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110115', '北京市大兴区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110116', '北京市怀柔区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1101', '110117', '北京市平谷区');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110200', '北京市市辖县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110221', '北京市昌平县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110222', '北京市顺义县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110223', '北京市通县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110224', '北京市大兴县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110226', '北京市平谷县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110227', '北京市怀柔县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110228', '北京市密云县');
INSERT INTO `t_pub_areacode` VALUES ('11', '1102', '110229', '北京市延庆县');
INSERT INTO `t_pub_areacode` VALUES ('12', '1200', '120000', '天津市');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120100', '天津市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120101', '天津市和平区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120102', '天津市河东区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120103', '天津市河西区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120104', '天津市南开区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120105', '天津市河北区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120106', '天津市红桥区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120107', '天津市塘沽区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120108', '天津市汉沽区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120109', '天津市大港区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120110', '天津市东丽区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120111', '天津市西青区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120112', '天津市津南区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120113', '天津市北辰区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120114', '天津市武清区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1201', '120115', '天津市宝坻区');
INSERT INTO `t_pub_areacode` VALUES ('12', '1202', '120200', '天津市市辖县');
INSERT INTO `t_pub_areacode` VALUES ('12', '1202', '120221', '天津市宁河县');
INSERT INTO `t_pub_areacode` VALUES ('12', '1202', '120222', '天津市武清县');
INSERT INTO `t_pub_areacode` VALUES ('12', '1202', '120223', '天津市静海县');
INSERT INTO `t_pub_areacode` VALUES ('12', '1202', '120224', '天津市宝坻县');
INSERT INTO `t_pub_areacode` VALUES ('12', '1202', '120225', '天津市蓟县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1300', '130000', '河北省');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130100', '河北省石家庄市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130101', '河北省石家庄市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130102', '河北省石家庄市长安区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130103', '河北省石家庄市桥东区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130104', '河北省石家庄市桥西区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130105', '河北省石家庄市新华区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130106', '河北省石家庄市郊区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130107', '河北省石家庄市井陉矿区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130108', '河北省石家庄市裕华区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130121', '河北省井陉县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130122', '河北省获鹿县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130123', '河北省正定县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130124', '河北省栾城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130125', '河北省行唐县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130126', '河北省灵寿县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130127', '河北省高邑县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130128', '河北省深泽县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130129', '河北省赞皇县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130130', '河北省无极县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130131', '河北省平山县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130132', '河北省元氏县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130133', '河北省赵县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130181', '河北省辛集市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130182', '河北省藁城市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130183', '河北省晋州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130184', '河北省新乐市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1301', '130185', '河北省石家庄市鹿泉市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130200', '河北省唐山市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130201', '河北省唐山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130202', '河北省唐山市路南区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130203', '河北省唐山市路北区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130204', '河北省唐山市东矿区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130205', '河北省唐山市开平区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130206', '河北省唐山市新区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130207', '河北省唐山市丰南区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130208', '河北省唐山市丰润区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130221', '河北省丰润县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130222', '河北省丰南县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130223', '河北省滦县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130224', '河北省滦南县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130225', '河北省乐亭县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130226', '河北省迁安县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130227', '河北省迁西县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130229', '河北省玉田县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130230', '河北省唐海县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130281', '河北省遵化市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1302', '130283', '河北省唐山市迁安市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130300', '河北省秦皇岛市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130301', '河北省秦皇岛市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130302', '河北省秦皇岛市海港区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130303', '河北省秦皇岛市山海关区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130304', '河北省秦皇岛市北戴河区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130321', '河北省青龙满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130322', '河北省昌黎县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130323', '河北省抚宁县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1303', '130324', '河北省卢龙县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130400', '河北省邯郸市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130401', '河北省邯郸市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130402', '河北省邯郸市邯山区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130403', '河北省邯郸市丛台区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130404', '河北省邯郸市复兴区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130406', '河北省邯郸市峰峰矿区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130421', '河北省邯郸县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130423', '河北省临漳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130424', '河北省成安县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130425', '河北省大名县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130426', '河北省涉县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130427', '河北省磁县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130428', '河北省肥乡县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130429', '河北省永年县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130430', '河北省丘县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130431', '河北省鸡泽县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130432', '河北省广平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130433', '河北省馆陶县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130434', '河北省魏县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130435', '河北省曲周县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1304', '130481', '河北省武安市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130500', '河北省邢台市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130501', '河北省邢台市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130502', '河北省邢台市桥东区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130503', '河北省邢台市桥西区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130521', '河北省邢台县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130522', '河北省临城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130523', '河北省内丘县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130524', '河北省柏乡县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130525', '河北省隆尧县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130526', '河北省任县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130527', '河北省南和县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130528', '河北省宁晋县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130529', '河北省巨鹿县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130530', '河北省新河县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130531', '河北省广宗县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130532', '河北省平乡县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130533', '河北省威县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130534', '河北省清河县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130535', '河北省临西县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130581', '河北省南宫市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1305', '130582', '河北省沙河市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130600', '河北省保定市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130601', '河北省保定市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130602', '河北省保定市新市区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130603', '河北省保定市北市区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130604', '河北省保定市南市区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130621', '河北省满城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130622', '河北省清苑县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130623', '河北省保定市涞水县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130624', '河北省保定市阜平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130625', '河北省保定市徐水县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130626', '河北省保定市定兴县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130627', '河北省保定市唐县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130628', '河北省保定市高阳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130629', '河北省保定市容城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130630', '河北省保定市涞源县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130631', '河北省保定市望都县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130632', '河北省保定市安新县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130633', '河北省保定市易县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130634', '河北省保定市曲阳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130635', '河北省保定市蠡县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130636', '河北省保定市顺平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130637', '河北省保定市博野县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130638', '河北省保定市雄县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130681', '河北省保定市涿州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130682', '河北省保定市定州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130683', '河北省保定市安国市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1306', '130684', '河北省保定市高碑店市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130700', '河北省张家口市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130701', '河北省张家口市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130702', '河北省张家口市桥东区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130703', '河北省张家口市桥西区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130705', '河北省张家口市宣化区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130706', '河北省张家口市下花园区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130721', '河北省宣化县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130722', '河北省张北县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130723', '河北省康保县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130724', '河北省沽源县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130725', '河北省尚义县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130726', '河北省蔚县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130727', '河北省阳原县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130728', '河北省怀安县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130729', '河北省万全县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130730', '河北省怀来县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130731', '河北省涿鹿县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130732', '河北省赤城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1307', '130733', '河北省崇礼县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130800', '河北省承德市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130801', '河北省承德市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130802', '河北省承德市双桥区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130803', '河北省承德市双滦区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130804', '河北省承德市鹰手营子矿区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130821', '河北省承德县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130822', '河北省兴隆县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130823', '河北省平泉县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130824', '河北省滦平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130825', '河北省隆化县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130826', '河北省丰宁满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130827', '河北省宽城满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1308', '130828', '河北省围场满族蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130900', '河北省沧洲市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130901', '河北省沧洲市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130902', '河北省沧洲市新华区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130903', '河北省沧洲市运河区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130904', '河北省沧洲市郊区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130921', '河北省沧县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130922', '河北省青县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130923', '河北省东光县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130924', '河北省海兴县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130925', '河北省盐山县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130926', '河北省肃宁县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130927', '河北省南皮县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130928', '河北省吴桥县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130929', '河北省献县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130930', '河北省孟村回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130981', '河北省泊头市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130982', '河北省任丘市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130983', '河北省黄骅市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1309', '130984', '河北省河间市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131000', '河北省廊坊市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131001', '河北省廊坊市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131002', '河北省廊坊市安次区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131003', '河北省廊坊市广阳区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131022', '河北省固安县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131023', '河北省永清县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131024', '河北省香河县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131025', '河北省大城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131026', '河北省文安县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131028', '河北省大厂回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131081', '河北省霸州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1310', '131082', '河北省三河市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131100', '河北省衡水市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131101', '河北省衡水市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131102', '河北省衡水市桃城区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131121', '河北省衡水市枣强县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131122', '河北省衡水市武邑县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131123', '河北省衡水市武强县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131124', '河北省衡水市饶阳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131125', '河北省衡水市安平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131126', '河北省衡水市故城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131127', '河北省衡水市景县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131128', '河北省衡水市阜城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131181', '河北省衡水市冀州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1311', '131182', '河北省衡水市深州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132400', '河北省保定地区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132401', '河北省定州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132402', '河北省涿州市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132403', '河北省安国市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132404', '河北省高碑店市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132421', '河北省易县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132423', '河北省徐水县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132424', '河北省涞源县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132425', '河北省定兴县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132426', '河北省顺平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132427', '河北省唐县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132428', '河北省望都县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132429', '河北省涞水县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132432', '河北省高阳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132433', '河北省安新县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132434', '河北省雄县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132435', '河北省容城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132437', '河北省曲阳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132438', '河北省阜平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132441', '河北省博野县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1324', '132442', '河北省蠡县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133000', '河北省衡水地区');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133001', '河北省衡水市');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133002', '河北省冀州县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133023', '河北省枣强县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133024', '河北省武邑县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133025', '河北省深县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133026', '河北省武强县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133027', '河北省饶阳县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133028', '河北省安平县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133029', '河北省故城县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133030', '河北省景县');
INSERT INTO `t_pub_areacode` VALUES ('13', '1330', '133031', '河北省阜城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1400', '140000', '山西省');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140100', '山西省太原市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140101', '山西省太原市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140102', '山西省太原市南城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140103', '山西省太原市北城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140104', '山西省太原市河西区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140105', '山西省太原市小店区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140106', '山西省太原市迎泽区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140107', '山西省太原市杏花岭区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140108', '山西省太原市尖草坪区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140109', '山西省太原市万柏林区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140110', '山西省太原市晋源区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140112', '山西省太原市南郊区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140113', '山西省太原市北郊区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140121', '山西省清徐县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140122', '山西省阳曲县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140123', '山西省娄烦县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1401', '140181', '山西省古交市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140200', '山西省大同市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140201', '山西省大同市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140202', '山西省大同市城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140203', '山西省大同市矿区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140211', '山西省大同市南郊区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140212', '山西省大同市新荣区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140221', '山西省阳高县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140222', '山西省天镇县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140223', '山西省广灵县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140224', '山西省灵丘县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140225', '山西省浑源县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140226', '山西省左云县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1402', '140227', '山西省大同县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140300', '山西省阳泉市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140301', '山西省阳泉市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140302', '山西省阳泉市城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140303', '山西省阳泉市矿区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140311', '山西省阳泉市郊区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140321', '山西省平定县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1403', '140322', '山西省盂县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140400', '山西省长治市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140401', '山西省长治市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140402', '山西省长治市城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140411', '山西省长治市郊区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140421', '山西省长治县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140422', '山西省潞城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140423', '山西省襄垣县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140424', '山西省屯留县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140425', '山西省平顺县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140426', '山西省黎城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140427', '山西省壶关县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140428', '山西省长子县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140429', '山西省武乡县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140430', '山西省沁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140431', '山西省沁源县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1404', '140481', '山西省长治市潞城市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140500', '山西省晋城市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140501', '山西省晋城市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140502', '山西省晋城市城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140511', '山西省晋城市郊区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140521', '山西省沁水县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140522', '山西省阳城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140524', '山西省陵川县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140525', '山西省晋城市泽州县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1405', '140581', '山西省高平市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140600', '山西省朔州市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140601', '山西省朔州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140602', '山西省朔州市朔城区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140603', '山西省朔州市平鲁区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140621', '山西省山阴县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140622', '山西省应县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140623', '山西省右玉县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1406', '140624', '山西省怀仁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140700', '山西省晋中市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140701', '山西省晋中市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140702', '山西省晋中市榆次区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140721', '山西省晋中市榆社县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140722', '山西省晋中市左权县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140723', '山西省晋中市和顺县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140724', '山西省晋中市昔阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140725', '山西省晋中市寿阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140726', '山西省晋中市太谷县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140727', '山西省晋中市祁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140728', '山西省晋中市平遥县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140729', '山西省晋中市灵石县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1407', '140781', '山西省晋中市介休市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140800', '山西省运城市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140801', '山西省运城市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140802', '山西省运城市盐湖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140821', '山西省运城市临猗县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140822', '山西省运城市万荣县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140823', '山西省运城市闻喜县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140824', '山西省运城市稷山县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140825', '山西省运城市新绛县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140826', '山西省运城市绛县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140827', '山西省运城市垣曲县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140828', '山西省运城市夏县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140829', '山西省运城市平陆县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140830', '山西省运城市芮城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140881', '山西省运城市永济市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1408', '140882', '山西省运城市河津市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140900', '山西省忻州市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140901', '山西省忻州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140902', '山西省忻州市忻府区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140921', '山西省忻州市定襄县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140922', '山西省忻州市五台县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140923', '山西省忻州市代县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140924', '山西省忻州市繁峙县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140925', '山西省忻州市宁武县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140926', '山西省忻州市静乐县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140927', '山西省忻州市神池县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140928', '山西省忻州市五寨县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140929', '山西省忻州市岢岚县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140930', '山西省忻州市河曲县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140931', '山西省忻州市保德县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140932', '山西省忻州市偏关县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1409', '140981', '山西省忻州市原平市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141000', '山西省临汾市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141001', '山西省临汾市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141002', '山西省临汾市尧都区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141021', '山西省临汾市曲沃县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141022', '山西省临汾市翼城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141023', '山西省临汾市襄汾县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141024', '山西省临汾市洪洞县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141025', '山西省临汾市古县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141026', '山西省临汾市安泽县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141027', '山西省临汾市浮山县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141028', '山西省临汾市吉县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141029', '山西省临汾市乡宁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141030', '山西省临汾市大宁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141031', '山西省临汾市隰县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141032', '山西省临汾市永和县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141033', '山西省临汾市蒲县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141034', '山西省临汾市汾西县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141081', '山西省临汾市侯马市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1410', '141082', '山西省临汾市霍州市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141100', '山西省吕梁市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141101', '山西省吕梁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141102', '山西省吕梁市离石区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141121', '山西省吕梁市文水县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141122', '山西省吕梁市交城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141123', '山西省吕梁市兴县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141124', '山西省吕梁市临县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141125', '山西省吕梁市柳林县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141126', '山西省吕梁市石楼县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141127', '山西省吕梁市岚县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141128', '山西省吕梁市方山县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141129', '山西省吕梁市中阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141130', '山西省吕梁市交口县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141181', '山西省吕梁市孝义市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1411', '141182', '山西省吕梁市汾阳市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142200', '山西省忻洲地区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142201', '山西省忻州市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142202', '山西省原平县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142222', '山西省定襄县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142223', '山西省五台县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142225', '山西省代县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142226', '山西省繁峙县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142227', '山西省宁武县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142228', '山西省静乐县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142229', '山西省神池县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142230', '山西省五寨县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142231', '山西省苛岚县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142232', '山西省河曲县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142233', '山西省保德县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1422', '142234', '山西省偏关县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142300', '山西省吕梁地区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142301', '山西省孝义市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142321', '山西省汾阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142322', '山西省文水县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142323', '山西省交城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142325', '山西省兴县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142326', '山西省临县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142327', '山西省柳林县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142328', '山西省石楼县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142329', '山西省岚县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142330', '山西省方山县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142331', '山西省离石县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142332', '山西省中阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1423', '142333', '山西省交口县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142400', '山西省晋中地区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142401', '山西省榆次市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142402', '山西省介休市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142421', '山西省榆社县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142422', '山西省左权县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142423', '山西省和顺县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142424', '山西省昔阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142427', '山西省寿阳县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142429', '山西省太谷县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142430', '山西省祁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142431', '山西省平遥县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1424', '142433', '山西省灵石县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142600', '山西省临汾地区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142601', '山西省临汾市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142602', '山西省侯马市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142603', '山西省霍州市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142621', '山西省曲沃县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142622', '山西省翼城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142623', '山西省襄汾县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142625', '山西省洪洞县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142627', '山西省古县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142628', '山西省安泽县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142629', '山西省浮山县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142630', '山西省吉县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142631', '山西省乡宁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142632', '山西省蒲县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142633', '山西省大宁县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142634', '山西省永和县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142635', '山西省隰县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1426', '142636', '山西省汾西县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142700', '山西省运城地区');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142701', '山西省运城市');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142722', '山西省永济县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142723', '山西省芮城县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142724', '山西省临猗县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142725', '山西省万荣县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142726', '山西省新绛县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142727', '山西省稷山县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142728', '山西省河津县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142729', '山西省闻喜县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142730', '山西省夏县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142731', '山西省绛县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142732', '山西省平陆县');
INSERT INTO `t_pub_areacode` VALUES ('14', '1427', '142733', '山西省垣曲县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1500', '150000', '内蒙古');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150100', '内蒙古呼和浩特市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150101', '内蒙古呼和浩特市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150102', '内蒙古呼和浩特市新城区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150103', '内蒙古呼和浩特市回民区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150104', '内蒙古呼和浩特市玉泉区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150105', '内蒙古呼和浩特市郊区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150121', '内蒙古土默特左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150122', '内蒙古托克托县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150123', '内蒙古自治区呼和浩特市和林格尔县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150124', '内蒙古自治区呼和浩特市清水河县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1501', '150125', '内蒙古自治区呼和浩特市武川县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150200', '内蒙古包头市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150201', '内蒙古包头市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150202', '内蒙古包头市东河区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150203', '内蒙古包头市昆都伦区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150204', '内蒙古包头市青山区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150205', '内蒙古包头市石拐矿区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150206', '内蒙古包头市白云矿区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150207', '内蒙古包头市郊区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150221', '内蒙古土默特右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150222', '内蒙古固阳县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1502', '150223', '内蒙古自治区包头市达尔罕茂明安联合旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1503', '150300', '内蒙古乌海市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1503', '150301', '内蒙古乌海市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1503', '150302', '内蒙古乌海市海勃湾区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1503', '150303', '内蒙古乌海市海南区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1503', '150304', '内蒙古乌海市乌达区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150400', '内蒙古赤峰市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150401', '内蒙古赤峰市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150402', '内蒙古赤峰市红山区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150403', '内蒙古赤峰市元宝山区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150404', '内蒙古赤峰市松山区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150421', '内蒙古阿鲁科尔沁旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150422', '内蒙古巴林左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150423', '内蒙古巴林右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150424', '内蒙古林西县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150425', '内蒙古克什克腾旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150426', '内蒙古翁牛特旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150428', '内蒙古喀喇沁旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150429', '内蒙古宁城县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1504', '150430', '内蒙古敖汉旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150500', '内蒙古自治区通辽市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150501', '内蒙古自治区通辽市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150502', '内蒙古自治区通辽市科尔沁区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150521', '内蒙古自治区通辽市科尔沁左翼中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150522', '内蒙古自治区通辽市科尔沁左翼后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150523', '内蒙古自治区通辽市开鲁县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150524', '内蒙古自治区通辽市库伦旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150525', '内蒙古自治区通辽市奈曼旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150526', '内蒙古自治区通辽市扎鲁特旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1505', '150581', '内蒙古自治区通辽市霍林郭勒市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150600', '内蒙古自治区鄂尔多斯市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150602', '内蒙古自治区鄂尔多斯市东胜区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150621', '内蒙古自治区鄂尔多斯市达拉特旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150622', '内蒙古自治区鄂尔多斯市准格尔旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150623', '内蒙古自治区鄂尔多斯市鄂托克前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150624', '内蒙古自治区鄂尔多斯市鄂托克旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150625', '内蒙古自治区鄂尔多斯市杭锦旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150626', '内蒙古自治区鄂尔多斯市乌审旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1506', '150627', '内蒙古自治区鄂尔多斯市伊金霍洛旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150700', '内蒙古自治区呼伦贝尔市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150701', '内蒙古自治区呼伦贝尔市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150702', '内蒙古自治区呼伦贝尔市海拉尔区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150721', '内蒙古自治区呼伦贝尔市阿荣旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150722', '内蒙古自治区呼伦贝尔市莫力达瓦达斡尔族自治旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150723', '内蒙古自治区呼伦贝尔市鄂伦春自治旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150724', '内蒙古自治区呼伦贝尔市鄂温克族自治旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150725', '内蒙古自治区呼伦贝尔市陈巴尔虎旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150726', '内蒙古自治区呼伦贝尔市新巴尔虎左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150727', '内蒙古自治区呼伦贝尔市新巴尔虎右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150781', '内蒙古自治区呼伦贝尔市满洲里市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150782', '内蒙古自治区呼伦贝尔市牙克石市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150783', '内蒙古自治区呼伦贝尔市扎兰屯市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150784', '内蒙古自治区呼伦贝尔市额尔古纳市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1507', '150785', '内蒙古自治区呼伦贝尔市根河市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150800', '内蒙古自治区巴彦淖尔市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150801', '内蒙古自治区巴彦淖尔市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150802', '内蒙古自治区巴彦淖尔市临河区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150821', '内蒙古自治区巴彦淖尔市五原县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150822', '内蒙古自治区巴彦淖尔市磴口县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150823', '内蒙古自治区巴彦淖尔市乌拉特前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150824', '内蒙古自治区巴彦淖尔市乌拉特中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150825', '内蒙古自治区巴彦淖尔市乌拉特后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1508', '150826', '内蒙古自治区巴彦淖尔市杭锦后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150900', '内蒙古自治区乌兰察布市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150901', '内蒙古自治区乌兰察布市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150902', '内蒙古自治区乌兰察布市集宁区');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150921', '内蒙古自治区乌兰察布市卓资县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150922', '内蒙古自治区乌兰察布市化德县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150923', '内蒙古自治区乌兰察布市商都县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150924', '内蒙古自治区乌兰察布市兴和县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150925', '内蒙古自治区乌兰察布市凉城县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150926', '内蒙古自治区乌兰察布市察哈尔右翼前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150927', '内蒙古自治区乌兰察布市察哈尔右翼中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150928', '内蒙古自治区乌兰察布市察哈尔右翼后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150929', '内蒙古自治区乌兰察布市四子王旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1509', '150981', '内蒙古自治区乌兰察布市丰镇市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152100', '内蒙古呼伦贝尔盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152101', '内蒙古海拉尔市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152102', '内蒙古满洲里市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152103', '内蒙古扎兰屯市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152104', '内蒙古牙克石市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152122', '内蒙古阿荣旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152123', '内蒙古莫力达瓦达翰尔族自治旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152125', '内蒙古额尔古纳右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152126', '内蒙古额尔古纳左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152127', '内蒙古鄂伦春自治旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152128', '内蒙古鄂温克族自治旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152129', '内蒙古新巴尔虎右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152130', '内蒙古新巴尔虎左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1521', '152131', '内蒙古陈巴尔虎旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152200', '内蒙古兴安盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152201', '内蒙古乌兰浩特市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152202', '内蒙古自治区兴安盟阿尔山市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152221', '内蒙古科尔沁右翼前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152222', '内蒙古科尔沁右翼中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152223', '内蒙古扎赍特旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1522', '152224', '内蒙古突泉县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152300', '内蒙古哲里木盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152301', '内蒙古通辽市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152302', '内蒙古霍林郭勒市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152322', '内蒙古科尔沁左翼中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152323', '内蒙古科尔沁左翼后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152324', '内蒙古开鲁县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152325', '内蒙古库伦旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152326', '内蒙古奈曼旗　');
INSERT INTO `t_pub_areacode` VALUES ('15', '1523', '152327', '内蒙古扎鲁特旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152500', '内蒙古锡林郭勒盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152501', '内蒙古二连浩特市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152502', '内蒙古锡林浩特市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152522', '内蒙古阿巴嘎旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152523', '内蒙古苏尼特左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152524', '内蒙古苏尼特右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152525', '内蒙古东乌珠穆沁旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152526', '内蒙古西乌珠穆沁旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152527', '内蒙古太仆寺旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152528', '内蒙古镶黄旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152529', '内蒙古正镶白旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152530', '内蒙古正蓝旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1525', '152531', '内蒙古多伦县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152600', '内蒙古乌兰察布盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152601', '内蒙古集宁市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152602', '内蒙古丰镇市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152621', '内蒙古武川县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152622', '内蒙古和林格尔县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152623', '内蒙古清水河县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152624', '内蒙古卓资县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152625', '内蒙古化德县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152626', '内蒙古商都县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152627', '内蒙古兴和县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152629', '内蒙古凉城县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152630', '内蒙古察哈尔右翼前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152631', '内蒙古察哈尔右翼中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152632', '内蒙古察哈尔右翼后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152633', '内蒙古达尔罕茂明安联合旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1526', '152634', '内蒙古四子王旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152700', '内蒙古伊克昭盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152701', '内蒙古东胜市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152722', '内蒙古达拉特旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152723', '内蒙古准格尔旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152724', '内蒙古鄂托克前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152725', '内蒙古鄂托克旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152726', '内蒙古杭锦旗　');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152727', '内蒙古乌审旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1527', '152728', '内蒙古伊金霍洛旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152800', '内蒙古巴彦淖尔盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152801', '内蒙古临河市');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152822', '内蒙古五原县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152823', '内蒙古磴口县');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152824', '内蒙古乌拉特前旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152825', '内蒙古乌拉特中旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152826', '内蒙古乌拉特后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1528', '152827', '内蒙古杭锦后旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1529', '152900', '内蒙古阿拉善盟');
INSERT INTO `t_pub_areacode` VALUES ('15', '1529', '152921', '内蒙古阿拉善左旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1529', '152922', '内蒙古阿拉善右旗');
INSERT INTO `t_pub_areacode` VALUES ('15', '1529', '152923', '内蒙古额济纳旗');
INSERT INTO `t_pub_areacode` VALUES ('21', '2100', '210000', '辽宁省');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210100', '辽宁省沈阳市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210101', '辽宁省沈阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210102', '辽宁省沈阳市和平区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210103', '辽宁省沈阳市沈河区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210104', '辽宁省沈阳市大东区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210105', '辽宁省沈阳市皇姑区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210106', '辽宁省沈阳市铁西区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210111', '辽宁省沈阳市苏家屯区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210112', '辽宁省沈阳市东陵区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210113', '辽宁省沈阳市新城子区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210114', '辽宁省沈阳市于洪区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210122', '辽宁省辽中县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210123', '辽宁省康平县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210124', '辽宁省法库县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2101', '210181', '辽宁省新民市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210200', '辽宁省大连市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210201', '辽宁省大连市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210202', '辽宁省大连市中山区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210203', '辽宁省大连市西岗区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210204', '辽宁省大连市沙河口区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210211', '辽宁省大连市甘井子区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210212', '辽宁省大连市旅顺口区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210213', '辽宁省大连市金州区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210224', '辽宁省长海县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210281', '辽宁省瓦房店市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210282', '辽宁省普兰店市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2102', '210283', '辽宁省庄河市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210300', '辽宁省鞍山市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210301', '辽宁省鞍山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210302', '辽宁省鞍山市铁东区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210303', '辽宁省鞍山市铁西区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210304', '辽宁省鞍山市立山区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210311', '辽宁省鞍山市旧堡区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210321', '辽宁省台安县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210323', '辽宁省岫岩满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2103', '210381', '辽宁省海城市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210400', '辽宁省抚顺市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210401', '辽宁省抚顺市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210402', '辽宁省抚顺市新抚区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210403', '辽宁省抚顺市露天区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210404', '辽宁省抚顺市望花区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210411', '辽宁省抚顺市顺城区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210421', '辽宁省抚顺县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210422', '辽宁省新宾满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2104', '210423', '辽宁省清原满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210500', '辽宁省本溪市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210501', '辽宁省本溪市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210502', '辽宁省本溪市平山区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210503', '辽宁省本溪市溪湖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210504', '辽宁省本溪市明山区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210505', '辽宁省本溪市南芬区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210511', '辽宁省本溪市南芬区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210521', '辽宁省本溪满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2105', '210522', '辽宁省桓仁满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210600', '辽宁省丹东市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210601', '辽宁省丹东市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210602', '辽宁省丹东市元宝区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210603', '辽宁省丹东市振兴区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210604', '辽宁省丹东市振安区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210621', '辽宁省凤城满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210624', '辽宁省宽甸满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210681', '辽宁省东港市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2106', '210682', '辽宁省丹东市凤城市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210700', '辽宁省锦州市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210701', '辽宁省锦州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210702', '辽宁省锦州市古塔区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210703', '辽宁省锦州市凌河区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210711', '辽宁省锦州市太和区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210725', '辽宁省北镇满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210726', '辽宁省黑山县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210727', '辽宁省义县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210781', '辽宁省凌海市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2107', '210782', '辽宁省锦州市北镇市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210800', '辽宁省营口市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210801', '辽宁省营口市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210802', '辽宁省营口市站前区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210803', '辽宁省营口市西市区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210804', '辽宁省营口市鲅鱼圈区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210811', '辽宁省营口市老边区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210881', '辽宁省盖州市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2108', '210882', '辽宁省大石桥市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210900', '辽宁省阜新市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210901', '辽宁省阜新市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210902', '辽宁省阜新市海洲区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210903', '辽宁省阜新市新邱区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210904', '辽宁省阜新市太平区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210905', '辽宁省阜新市清河门区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210911', '辽宁省阜新市细河区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210921', '辽宁省阜新蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2109', '210922', '辽宁省彰武县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211000', '辽宁省辽阳市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211001', '辽宁省辽阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211002', '辽宁省辽阳市白塔区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211003', '辽宁省辽阳市文圣区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211004', '辽宁省辽阳市宏伟区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211005', '辽宁省辽阳市弓长岭区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211011', '辽宁省辽阳市太子河区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211021', '辽宁省辽阳县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211022', '辽宁省灯塔县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2110', '211081', '辽宁省辽阳市灯塔市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2111', '211100', '辽宁省盘锦市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2111', '211101', '辽宁省盘锦市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2111', '211102', '辽宁省盘锦市双台子区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2111', '211103', '辽宁省盘锦市兴隆台区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2111', '211121', '辽宁省大洼县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2111', '211122', '辽宁省盘山县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211200', '辽宁省铁岭市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211201', '辽宁省铁岭市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211202', '辽宁省铁岭市银州区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211204', '辽宁省铁岭市清河区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211221', '辽宁省铁岭县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211223', '辽宁省西丰县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211224', '辽宁省昌图县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211281', '辽宁省铁法市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2112', '211282', '辽宁省开原市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211300', '辽宁省朝阳市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211301', '辽宁省朝阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211302', '辽宁省朝阳市双塔区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211303', '辽宁省朝阳市龙城区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211321', '辽宁省朝阳县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211322', '辽宁省建平县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211324', '辽宁省喀喇沁左翼蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211381', '辽宁省北票市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2113', '211382', '辽宁省凌源市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211400', '辽宁省锦西市');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211401', '辽宁省锦西市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211402', '辽宁省锦西市连山区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211403', '辽宁省锦西市葫芦岛区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211404', '辽宁省锦西市南票区');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211421', '辽宁省绥中县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211422', '辽宁省建昌县');
INSERT INTO `t_pub_areacode` VALUES ('21', '2114', '211481', '辽宁省兴城市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2200', '220000', '吉林省');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220100', '吉林省长春市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220101', '吉林省长春市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220102', '吉林省长春市南关区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220103', '吉林省长春市宽城区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220104', '吉林省长春市朝阳区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220105', '吉林省长春市二道河子区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220106', '吉林省长春市绿园区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220111', '吉林省长春市郊区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220112', '吉林省长春市双阳区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220122', '吉林省农安县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220124', '吉林省德惠县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220125', '吉林省双阳县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220181', '吉林省九台市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220182', '吉林省榆树市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2201', '220183', '吉林省长春市德惠市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220200', '吉林省吉林市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220201', '吉林省吉林市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220202', '吉林省吉林市昌邑区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220203', '吉林省吉林市龙潭区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220204', '吉林省吉林市船营区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220211', '吉林省吉林市丰满区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220221', '吉林省永吉县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220223', '吉林省磐石县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220281', '吉林省蛟河市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220282', '吉林省桦甸市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220283', '吉林省舒兰市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2202', '220284', '吉林省吉林市磐石市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220300', '吉林省四平市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220301', '吉林省四平市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220302', '吉林省四平市铁西区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220303', '吉林省四平市铁东区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220322', '吉林省梨树县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220323', '吉林省伊通满族自治县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220324', '吉林省双辽县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220381', '吉林省公主岭市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2203', '220382', '吉林省四平市双辽市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2204', '220400', '吉林省辽源市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2204', '220401', '吉林省辽源市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2204', '220402', '吉林省辽源市龙山区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2204', '220403', '吉林省辽源市西安区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2204', '220421', '吉林省东丰县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2204', '220422', '吉林省东辽县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220500', '吉林省通化市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220501', '吉林省通化市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220502', '吉林省通化市东昌区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220503', '吉林省通化市二道江区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220521', '吉林省通化县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220523', '吉林省辉南县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220524', '吉林省柳河县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220581', '吉林省梅河口市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2205', '220582', '吉林省集安市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220600', '吉林省浑江市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220601', '吉林省浑江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220602', '吉林省浑江市八道江区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220603', '吉林省浑江市三岔子区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220605', '吉林省白山市江源区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220621', '吉林省抚松县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220622', '吉林省靖宇县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220623', '吉林省长白朝鲜族自治县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2206', '220681', '吉林省临江市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220700', '吉林省松原市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220701', '吉林省松原市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220702', '吉林省松原市扶余区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220721', '吉林省前郭尔罗斯蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220722', '吉林省长岭县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220723', '吉林省乾安县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2207', '220724', '吉林省松原市扶余县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220800', '吉林省白城市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220801', '吉林省白城市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220802', '吉林省白城市洮北区');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220821', '吉林省镇赍县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220822', '吉林省通榆县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220881', '吉林省洮南市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2208', '220882', '吉林省大安市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222400', '吉林省延边朝鲜族自治州');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222401', '吉林省延吉市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222402', '吉林省图们市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222403', '吉林省敦化市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222404', '吉林省珲春市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222405', '吉林省龙井市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222406', '吉林省和龙市');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222424', '吉林省汪清县');
INSERT INTO `t_pub_areacode` VALUES ('22', '2224', '222426', '吉林省安图县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2300', '230000', '黑龙江');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230100', '黑龙江哈尔滨市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230101', '黑龙江哈尔滨市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230102', '黑龙江哈尔滨市道里区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230103', '黑龙江哈尔滨市南岗区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230104', '黑龙江哈尔滨市道外区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230105', '黑龙江哈尔滨市太平区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230106', '黑龙江哈尔滨市香坊区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230107', '黑龙江哈尔滨市动力区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230108', '黑龙江哈尔滨市平房区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230109', '黑龙江省哈尔滨市松北区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230110', '黑龙江省哈尔滨市香坊区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230111', '黑龙江省哈尔滨市呼兰区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230112', '黑龙江省哈尔滨市阿城区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230121', '黑龙江呼兰县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230123', '黑龙江依兰县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230124', '黑龙江方正县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230125', '黑龙江宾县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230126', '黑龙江省哈尔滨市巴彦县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230127', '黑龙江省哈尔滨市木兰县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230128', '黑龙江省哈尔滨市通河县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230129', '黑龙江省哈尔滨市延寿县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230181', '黑龙江阿城市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230182', '黑龙江省哈尔滨市双城市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230183', '黑龙江省哈尔滨市尚志市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2301', '230184', '黑龙江省哈尔滨市五常市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230200', '黑龙江齐齐哈尔市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230201', '黑龙江齐齐哈尔市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230202', '黑龙江齐齐哈尔市龙沙区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230203', '黑龙江齐齐哈尔市建华区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230204', '黑龙江齐齐哈尔市铁锋区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230205', '黑龙江齐齐哈尔市昂昂溪区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230206', '黑龙江齐齐哈尔市富拉尔基区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230207', '黑龙江齐齐哈尔市碾子山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230208', '黑龙江齐齐哈尔市梅里斯达斡尔族');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230221', '黑龙江龙江县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230223', '黑龙江依安县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230224', '黑龙江泰来县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230225', '黑龙江甘南县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230227', '黑龙江富裕县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230229', '黑龙江克山县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230230', '黑龙江克东县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230231', '黑龙江拜泉县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2302', '230281', '黑龙江讷河市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230300', '黑龙江鸡西市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230301', '黑龙江鸡西市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230302', '黑龙江鸡西市鸡冠区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230303', '黑龙江鸡西市恒山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230304', '黑龙江鸡西市滴道区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230305', '黑龙江鸡西市梨树区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230306', '黑龙江鸡西市城子河区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230307', '黑龙江鸡西市麻山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230321', '黑龙江鸡东县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230322', '黑龙江虎林县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230381', '黑龙江省鸡西市虎林市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2303', '230382', '黑龙江省鸡西市密山市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230400', '黑龙江鹤岗市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230401', '黑龙江鹤岗市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230402', '黑龙江鹤岗市向阳区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230403', '黑龙江鹤岗市工农区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230404', '黑龙江鹤岗市南山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230405', '黑龙江鹤岗市兴安区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230406', '黑龙江鹤岗市东山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230407', '黑龙江鹤岗市兴山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230421', '黑龙江萝北县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2304', '230422', '黑龙江绥滨县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230500', '黑龙江双鸭山市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230501', '黑龙江双鸭山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230502', '黑龙江双鸭山市尖山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230503', '黑龙江双鸭山市岭东区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230505', '黑龙江双鸭山市四方台区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230506', '黑龙江双鸭山市宝山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230521', '黑龙江集贤县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230522', '黑龙江友谊县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230523', '黑龙江宝清县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2305', '230524', '黑龙江饶河县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230600', '黑龙江大庆市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230601', '黑龙江大庆市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230602', '黑龙江大庆市萨尔图区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230603', '黑龙江大庆市龙凤区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230604', '黑龙江大庆市让胡路区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230605', '黑龙江大庆市红岗区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230606', '黑龙江大庆市大同区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230621', '黑龙江肇州县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230622', '黑龙江肇源县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230623', '黑龙江林甸县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2306', '230624', '黑龙江杜尔伯特蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230700', '黑龙江伊春市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230701', '黑龙江伊春市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230702', '黑龙江伊春市伊春区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230703', '黑龙江伊春市南岔区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230704', '黑龙江伊春市友好区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230705', '黑龙江伊春市西林区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230706', '黑龙江伊春市翠峦区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230707', '黑龙江伊春市新青区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230708', '黑龙江伊春市美溪区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230709', '黑龙江伊春市金山屯区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230710', '黑龙江伊春市五营区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230711', '黑龙江伊春市乌马河区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230712', '黑龙江伊春市汤旺河区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230713', '黑龙江伊春市带岭区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230714', '黑龙江伊春市乌伊岭区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230715', '黑龙江伊春市红星区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230716', '黑龙江伊春市上甘岭区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230722', '黑龙江嘉荫县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2307', '230781', '黑龙江铁力市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230800', '黑龙江佳木斯市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230801', '黑龙江佳木斯市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230802', '黑龙江佳木斯市永红区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230803', '黑龙江佳木斯市向阳区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230804', '黑龙江佳木斯市前进区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230805', '黑龙江佳木斯市东风区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230811', '黑龙江佳木斯市郊区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230822', '黑龙江桦南县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230826', '黑龙江桦川县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230828', '黑龙江汤原县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230833', '黑龙江扶远县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230881', '黑龙江同江市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2308', '230882', '黑龙江富锦市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2309', '230900', '黑龙江七台河市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2309', '230901', '黑龙江七台河市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2309', '230902', '黑龙江七台河市新兴区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2309', '230903', '黑龙江七台河市桃山区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2309', '230904', '黑龙江七台河市茄子河区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2309', '230921', '黑龙江勃利县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231000', '黑龙江牡丹江市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231001', '黑龙江牡丹江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231002', '黑龙江牡丹江市东安区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231003', '黑龙江牡丹江市阳明区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231004', '黑龙江牡丹江市爱民区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231005', '黑龙江牡丹江市西安区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231011', '黑龙江牡丹江市郊区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231023', '黑龙江穆棱县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231024', '黑龙江东宁县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231025', '黑龙江林口县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231081', '黑龙江绥芬河市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231082', '黑龙江密山市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231083', '黑龙江海林市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231084', '黑龙江宁安市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2310', '231085', '黑龙江省牡丹江市穆棱市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231100', '黑龙江黑河市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231101', '黑龙江黑河市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231102', '黑龙江黑河市爱辉区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231121', '黑龙江嫩江县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231122', '黑龙江德都县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231123', '黑龙江逊克县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231124', '黑龙江孙吴县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231181', '黑龙江北安市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2311', '231182', '黑龙江五大连池市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231200', '黑龙江省绥化市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231201', '黑龙江省绥化市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231202', '黑龙江省绥化市北林区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231221', '黑龙江省绥化市望奎县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231222', '黑龙江省绥化市兰西县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231223', '黑龙江省绥化市青冈县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231224', '黑龙江省绥化市庆安县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231225', '黑龙江省绥化市明水县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231226', '黑龙江省绥化市绥棱县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231281', '黑龙江省绥化市安达市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231282', '黑龙江省绥化市肇东市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2312', '231283', '黑龙江省绥化市海伦市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232100', '黑龙江松花江地区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232101', '黑龙江双城市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232102', '黑龙江尚志市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232103', '黑龙江五常市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232126', '黑龙江巴彦县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232127', '黑龙江木兰县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232128', '黑龙江通河县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2321', '232131', '黑龙江延寿县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232300', '黑龙江绥化地区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232301', '黑龙江绥化市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232302', '黑龙江安达市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232303', '黑龙江肇东市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232304', '黑龙江海伦市');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232324', '黑龙江望奎县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232325', '黑龙江兰西县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232326', '黑龙江青冈县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232330', '黑龙江庆安县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232331', '黑龙江明水县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2323', '232332', '黑龙江绥棱县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2325', '232500', '黑龙江林业系统');
INSERT INTO `t_pub_areacode` VALUES ('23', '2327', '232700', '黑龙江大兴安岭地区');
INSERT INTO `t_pub_areacode` VALUES ('23', '2327', '232721', '黑龙江呼玛县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2327', '232722', '黑龙江塔河县');
INSERT INTO `t_pub_areacode` VALUES ('23', '2327', '232723', '黑龙江漠河县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3100', '310000', '上海市');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310100', '上海市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310101', '上海市黄浦区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310102', '上海市南市区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310103', '上海市卢湾区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310104', '上海市徐汇区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310105', '上海市长宁区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310106', '上海市静安区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310107', '上海市普陀区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310108', '上海市闸北区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310109', '上海市虹口区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310110', '上海市扬浦区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310112', '上海市闵行区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310113', '上海市宝山区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310114', '上海市嘉定区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310115', '上海市浦东新区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310116', '上海市金山区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310117', '上海市松江区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310118', '上海市青浦区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310119', '上海市南汇区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3101', '310120', '上海市奉贤区');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310200', '上海市市辖县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310225', '上海市南汇县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310226', '上海市奉贤县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310227', '上海市松江县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310228', '上海市金山县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310229', '上海市青浦县');
INSERT INTO `t_pub_areacode` VALUES ('31', '3102', '310230', '上海市崇明县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3200', '320000', '江苏省');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320100', '江苏省南京市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320101', '江苏省南京市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320102', '江苏省南京市玄武区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320103', '江苏省南京市白下区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320104', '江苏省南京市秦淮区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320105', '江苏省南京市建邺区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320106', '江苏省南京市鼓楼区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320107', '江苏省南京市下关区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320111', '江苏省南京市浦口区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320112', '江苏省南京市大厂区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320113', '江苏省南京市栖霞区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320114', '江苏省南京市雨花台区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320115', '江苏省南京市江宁区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320116', '江苏省南京市六合区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320121', '江苏省江宁县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320122', '江苏省江浦县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320123', '江苏省六合县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320124', '江苏省溧水县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3201', '320125', '江苏省高淳县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320200', '江苏省无锡市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320201', '江苏省无锡市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320202', '江苏省无锡市崇安区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320203', '江苏省无锡市南长区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320204', '江苏省无锡市北塘区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320205', '江苏省无锡市锡山区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320206', '江苏省无锡市惠山区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320211', '江苏省无锡市郊区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320212', '江苏省无锡市马山区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320222', '江苏省无锡县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320281', '江苏省江阴市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3202', '320282', '江苏省宜兴市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320300', '江苏省徐州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320301', '江苏省徐州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320302', '江苏省徐州市鼓楼区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320303', '江苏省徐州市云龙区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320304', '江苏省徐州市矿区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320305', '江苏省徐州市贾汪区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320311', '江苏省徐州市泉山区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320321', '江苏省丰县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320322', '江苏省沛县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320323', '江苏省铜山县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320324', '江苏省睢宁县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320381', '江苏省新沂市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3203', '320382', '江苏省邳州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320400', '江苏省常州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320401', '江苏省常州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320402', '江苏省常州市天宁区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320404', '江苏省常州市钟楼区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320405', '江苏省常州市戚墅堰区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320411', '江苏省常州市郊区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320412', '江苏省常州市武进区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320421', '江苏省武进县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320481', '江苏省溧阳市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3204', '320482', '江苏省金坛市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320500', '江苏省苏州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320501', '江苏省苏州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320502', '江苏省苏州市沧浪区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320503', '江苏省苏州市平江区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320504', '江苏省苏州市金阊区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320505', '江苏省苏州市虎丘区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320506', '江苏省苏州市吴中区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320507', '江苏省苏州市相城区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320511', '江苏省苏州市郊区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320524', '江苏省吴县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320581', '江苏省常熟市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320582', '江苏省张家港市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320583', '江苏省昆山市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320584', '江苏省吴江市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3205', '320585', '江苏省太仓市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320600', '江苏省南通市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320601', '江苏省南通市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320602', '江苏省南通市崇川区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320611', '江苏省南通市港闸区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320621', '江苏省海安县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320623', '江苏省如东县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320625', '江苏省海门县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320681', '江苏省启东市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320682', '江苏省如皋市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320683', '江苏省通州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3206', '320684', '江苏省南通市海门市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320700', '江苏省连云港市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320701', '江苏省连云港市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320703', '江苏省连云港市连云区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320704', '江苏省连云港市云台区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320705', '江苏省连云港市新浦区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320706', '江苏省连云港市海州区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320721', '江苏省赣榆县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320722', '江苏省东海县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320723', '江苏省灌云县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3207', '320724', '江苏省连云港市灌南县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320800', '江苏省淮阴市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320801', '江苏省淮阴市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320802', '江苏省淮阴市清河区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320803', '江苏省淮安市楚州区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320804', '江苏省淮安市淮阴区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320811', '江苏省淮阴市清浦区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320821', '江苏省淮阴县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320822', '江苏省灌南县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320823', '江苏省沭阳县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320825', '江苏省泗阳县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320826', '江苏省涟水县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320827', '江苏省泗洪县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320829', '江苏省洪泽县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320830', '江苏省盱眙县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320831', '江苏省金湖县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320881', '江苏省宿迁市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3208', '320882', '江苏省淮安市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320900', '江苏省盐城市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320901', '江苏省盐城市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320902', '江苏省盐城市城区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320903', '江苏省盐城市盐都区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320911', '江苏省盐城市郊区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320921', '江苏省响水县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320922', '江苏省滨海县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320923', '江苏省阜宁县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320924', '江苏省射阳县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320925', '江苏省建湖县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320926', '江苏省大丰县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320981', '江苏省东台市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3209', '320982', '江苏省盐城市大丰市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321000', '江苏省扬州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321001', '江苏省扬州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321002', '江苏省扬州市广陵区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321003', '江苏省扬州市邗江区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321011', '江苏省扬州市郊区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321023', '江苏省宝应县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321026', '江苏省江都县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321027', '江苏省邗江县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321028', '江苏省泰县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321081', '江苏省仪征市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321082', '江苏省泰州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321083', '江苏省兴化市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321084', '江苏省高邮市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321085', '江苏省泰兴市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321086', '江苏省靖江市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3210', '321088', '江苏省扬州市江都市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321100', '江苏省镇江市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321101', '江苏省镇江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321102', '江苏省镇江市京口区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321111', '江苏省镇江市润州区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321112', '江苏省镇江市丹徒区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321121', '江苏省丹徒县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321123', '江苏省句容县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321124', '江苏省扬中县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321181', '江苏省丹阳市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321182', '江苏省镇江市扬中市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3211', '321183', '江苏省镇江市句容市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321200', '江苏省泰州市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321201', '江苏省泰州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321202', '江苏省泰州市海陵区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321203', '江苏省泰州市高港区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321281', '江苏省泰州市兴化市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321282', '江苏省泰州市靖江市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321283', '江苏省泰州市泰兴市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3212', '321284', '江苏省泰州市姜堰市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321300', '江苏省宿迁市');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321301', '江苏省宿迁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321302', '江苏省宿迁市宿城区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321311', '江苏省宿迁市宿豫区');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321322', '江苏省宿迁市沭阳县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321323', '江苏省宿迁市泗阳县');
INSERT INTO `t_pub_areacode` VALUES ('32', '3213', '321324', '江苏省宿迁市泗洪县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3300', '330000', '浙江省');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330100', '浙江省杭州市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330101', '浙江省杭州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330102', '浙江省杭州市上城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330103', '浙江省杭州市下城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330104', '浙江省杭州市江干区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330105', '浙江省杭州市拱墅区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330106', '浙江省杭州市西湖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330108', '浙江省杭州市滨江区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330109', '浙江省杭州市萧山区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330110', '浙江省杭州市余杭区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330122', '浙江省桐庐县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330123', '浙江省富阳县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330124', '浙江省临安县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330125', '浙江省余杭县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330126', '浙江省建德县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330127', '浙江省淳安县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330181', '浙江省萧山市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330182', '浙江省杭州市建德市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330183', '浙江省杭州市富阳市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3301', '330185', '浙江省杭州市临安市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330200', '浙江省宁波市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330201', '浙江省宁波市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330203', '浙江省宁波市海曙区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330204', '浙江省宁波市江东区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330205', '浙江省宁波市江北区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330206', '浙江省宁波市北仓区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330211', '浙江省宁波市镇海区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330212', '浙江省宁波市鄞州区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330225', '浙江省象山县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330226', '浙江省宁海县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330227', '浙江省鄞县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330281', '浙江省余姚市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330282', '浙江省慈溪市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3302', '330283', '浙江省奉化市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330300', '浙江省温州市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330301', '浙江省温州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330302', '浙江省温州市鹿城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330303', '浙江省温州市龙湾区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330304', '浙江省温州市瓯海区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330322', '浙江省洞头县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330324', '浙江省永嘉县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330326', '浙江省平阳县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330327', '浙江省苍南县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330328', '浙江省文成县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330329', '浙江省泰顺县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330381', '浙江省瑞安市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3303', '330382', '浙江省乐清市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330400', '浙江省嘉兴市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330401', '浙江省嘉兴市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330402', '浙江省嘉兴市城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330411', '浙江省嘉兴市郊区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330421', '浙江省嘉善县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330424', '浙江省海盐县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330481', '浙江省海宁市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330482', '浙江省平湖市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3304', '330483', '浙江省桐乡市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330500', '浙江省湖洲市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330501', '浙江省湖洲市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330502', '浙江省湖州市吴兴区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330503', '浙江省湖州市南浔区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330521', '浙江省德清县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330522', '浙江省长兴县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3305', '330523', '浙江省安吉县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330600', '浙江省绍兴市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330601', '浙江省绍兴市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330602', '浙江省绍兴市越城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330621', '浙江省绍兴县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330623', '浙江省嵊县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330624', '浙江省新昌县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330681', '浙江省诸暨市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330682', '浙江省上虞市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3306', '330683', '浙江省绍兴市嵊州市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330700', '浙江省金华市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330701', '浙江省金华市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330702', '浙江省金华市婺城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330703', '浙江省金华市金东区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330721', '浙江省金华县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330723', '浙江省武义县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330726', '浙江省浦江县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330727', '浙江省磐安县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330728', '浙江省永康市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330781', '浙江省兰溪市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330782', '浙江省义乌市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330783', '浙江省东阳市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3307', '330784', '浙江省金华市永康市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330800', '浙江省衢州市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330801', '浙江省衢州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330802', '浙江省衢州市柯城区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330803', '浙江省衢州市衢江区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330821', '浙江省衢县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330822', '浙江省常山县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330824', '浙江省开化县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330825', '浙江省龙游县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3308', '330881', '浙江省江山市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3309', '330900', '浙江省舟山市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3309', '330901', '浙江省舟山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3309', '330902', '浙江省舟山市定海区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3309', '330903', '浙江省舟山市普陀区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3309', '330921', '浙江省岱山县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3309', '330922', '浙江省嵊泗县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331000', '浙江省台州市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331001', '浙江省台州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331002', '浙江省台州市椒江区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331003', '浙江省台州市黄岩区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331004', '浙江省台州市路桥区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331021', '浙江省台州市玉环县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331022', '浙江省台州市三门县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331023', '浙江省台州市天台县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331024', '浙江省台州市仙居县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331081', '浙江省台州市温岭市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3310', '331082', '浙江省台州市临海市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331100', '浙江省丽水市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331101', '浙江省丽水市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331102', '浙江省丽水市莲都区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331121', '浙江省丽水市青田县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331122', '浙江省丽水市缙云县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331123', '浙江省丽水市遂昌县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331124', '浙江省丽水市松阳县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331125', '浙江省丽水市云和县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331126', '浙江省丽水市庆元县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331127', '浙江省丽水市景宁畲族自治县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3311', '331181', '浙江省丽水市龙泉市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332500', '浙江省丽水地区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332501', '浙江省丽水市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332502', '浙江省龙泉市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332522', '浙江省青田县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332523', '浙江省云和县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332525', '浙江省庆元县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332526', '浙江省缙云县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332527', '浙江省遂昌县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332528', '浙江省松阳县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3325', '332529', '浙江省景宁畲族自治县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332600', '浙江省台州地区');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332601', '浙江省椒江市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332602', '浙江省临海市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332603', '浙江省黄岩市');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332623', '浙江省温岭县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332624', '浙江省仙居县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332625', '浙江省天台县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332626', '浙江省三门县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3326', '332627', '浙江省玉环县');
INSERT INTO `t_pub_areacode` VALUES ('33', '3390', '339011', '浙江省诸暨市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3400', '340000', '安徽省');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340100', '安徽省合肥市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340101', '安徽省合肥市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340102', '安徽省合肥市东市区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340103', '安徽省合肥市中市区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340104', '安徽省合肥市西市区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340111', '安徽省合肥市郊区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340121', '安徽省长丰县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340122', '安徽省肥东县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3401', '340123', '安徽省肥西县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340200', '安徽省芜湖市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340201', '安徽省芜湖市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340202', '安徽省芜湖市镜湖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340203', '安徽省芜湖市马塘区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340204', '安徽省芜湖市新芜区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340207', '安徽省芜湖市鸠江区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340208', '安徽省芜湖市三山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340221', '安徽省芜湖县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340222', '安徽省繁昌县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3402', '340223', '安徽省南陵县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340300', '安徽省蚌埠市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340301', '安徽省蚌埠市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340302', '安徽省蚌埠市东市区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340303', '安徽省蚌埠市中市区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340304', '安徽省蚌埠市西市区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340311', '安徽省蚌埠市郊区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340321', '安徽省怀远县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340322', '安徽省五河县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3403', '340323', '安徽省固镇县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340400', '安徽省淮南市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340401', '安徽省淮南市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340402', '安徽省淮南市大通区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340403', '安徽省淮南市田家庵区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340404', '安徽省淮南市谢家集区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340405', '安徽省淮南市八公山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340406', '安徽省淮南市潘集区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3404', '340421', '安徽省凤台县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340500', '安徽省马鞍山市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340501', '安徽省马鞍山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340502', '安徽省马鞍山市金家庄区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340503', '安徽省马鞍山市花山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340504', '安徽省马鞍山市雨山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340505', '安徽省马鞍山市向山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3405', '340521', '安徽省当涂县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3406', '340600', '安徽省淮北市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3406', '340601', '安徽省淮北市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3406', '340602', '安徽省淮北市杜集区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3406', '340603', '安徽省淮北市相山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3406', '340604', '安徽省淮北市烈山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3406', '340621', '安徽省濉溪县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3407', '340700', '安徽省铜陵市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3407', '340701', '安徽省铜陵市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3407', '340702', '安徽省铜陵市铜官山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3407', '340703', '安徽省铜陵市狮子山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3407', '340711', '安徽省铜陵市郊区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3407', '340721', '安徽省铜陵县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340800', '安徽省安庆市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340801', '安徽省安庆市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340802', '安徽省安庆市迎江区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340803', '安徽省安庆市大观区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340811', '安徽省安庆市郊区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340821', '安徽省桐城县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340822', '安徽省怀宁县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340823', '安徽省枞阳县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340824', '安徽省潜山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340825', '安徽省太湖县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340826', '安徽省宿松县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340827', '安徽省望江县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340828', '安徽省岳西县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3408', '340881', '安徽省安庆市桐城市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341000', '安徽省黄山市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341001', '安徽省黄山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341002', '安徽省黄山市屯溪区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341003', '安徽省黄山市黄山区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341004', '安徽省黄山市徽州区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341021', '安徽省歙县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341022', '安徽省休宁县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341023', '安徽省黟县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3410', '341024', '安徽省祁门县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341100', '安徽省滁州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341101', '安徽省滁州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341102', '安徽省滁州市琅琊区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341103', '安徽省滁州市南谯区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341122', '安徽省来安县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341124', '安徽省全椒县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341125', '安徽省定远县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341126', '安徽省凤阳县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341127', '安徽省嘉山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341181', '安徽省天长县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3411', '341182', '安徽省滁州市明光市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341200', '安徽省阜阳市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341201', '安徽省阜阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341202', '安徽省阜阳市颍州区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341203', '安徽省阜阳市颍东区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341204', '安徽省阜阳市颍泉区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341221', '安徽省阜阳市临泉县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341222', '安徽省阜阳市太和县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341225', '安徽省阜阳市阜南县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341226', '安徽省阜阳市颍上县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3412', '341282', '安徽省阜阳市界首市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341300', '安徽省宿州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341301', '安徽省宿州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341302', '安徽省宿州市墉桥区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341321', '安徽省宿州市砀山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341322', '安徽省宿州市萧县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341323', '安徽省宿州市灵璧县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3413', '341324', '安徽省宿州市泗县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341400', '安徽省巢湖市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341401', '安徽省巢湖市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341402', '安徽省巢湖市居巢区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341421', '安徽省巢湖市庐江县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341422', '安徽省巢湖市无为县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341423', '安徽省巢湖市含山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3414', '341424', '安徽省巢湖市和县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341500', '安徽省六安市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341501', '安徽省六安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341502', '安徽省六安市金安区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341503', '安徽省六安市裕安区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341521', '安徽省六安市寿县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341522', '安徽省六安市霍邱县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341523', '安徽省六安市舒城县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341524', '安徽省六安市金寨县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3415', '341525', '安徽省六安市霍山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3416', '341600', '安徽省亳州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3416', '341601', '安徽省亳州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3416', '341602', '安徽省亳州市谯城区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3416', '341621', '安徽省亳州市涡阳县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3416', '341622', '安徽省亳州市蒙城县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3416', '341623', '安徽省亳州市利辛县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3417', '341700', '安徽省池州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3417', '341701', '安徽省池州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3417', '341702', '安徽省池州市贵池区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3417', '341721', '安徽省池州市东至县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3417', '341722', '安徽省池州市石台县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3417', '341723', '安徽省池州市青阳县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341800', '安徽省宣城市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341801', '安徽省宣城市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341802', '安徽省宣城市宣州区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341821', '安徽省宣城市郎溪县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341822', '安徽省宣城市广德县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341823', '安徽省宣城市泾县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341824', '安徽省宣城市绩溪县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341825', '安徽省宣城市旌德县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3418', '341881', '安徽省宣城市宁国市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342100', '安徽省阜阳地区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342101', '安徽省阜阳市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342102', '安徽省毫州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342103', '安徽省界首市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342122', '安徽省临泉县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342123', '安徽省太和县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342124', '安徽省涡阳县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342125', '安徽省蒙城县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342127', '安徽省阜南县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342128', '安徽省颖上县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3421', '342130', '安徽省利辛县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3422', '342200', '安徽省宿县地区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3422', '342201', '安徽省宿州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3422', '342221', '安徽省砀山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3422', '342222', '安徽省萧县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3422', '342224', '安徽省灵壁县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3422', '342225', '安徽省泗县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342400', '安徽省六安地区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342401', '安徽省六安市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342422', '安徽省寿县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342423', '安徽省霍邱县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342425', '安徽省舒城县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342426', '安徽省金寨县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3424', '342427', '安徽省霍山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342500', '安徽省宣城地区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342501', '安徽省宣州市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342522', '安徽省郎溪县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342523', '安徽省广德县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342524', '安徽省宁国县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342529', '安徽省泾县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342530', '安徽省旌德县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3425', '342531', '安徽省绩溪县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3426', '342600', '安徽省巢湖地区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3426', '342601', '安徽省巢湖市');
INSERT INTO `t_pub_areacode` VALUES ('34', '3426', '342622', '安徽省庐江县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3426', '342623', '安徽省无为县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3426', '342625', '安徽省含山县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3426', '342626', '安徽省和县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3429', '342900', '安徽省池州地区');
INSERT INTO `t_pub_areacode` VALUES ('34', '3429', '342901', '安徽省贵池县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3429', '342921', '安徽省东至县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3429', '342922', '安徽省石台县');
INSERT INTO `t_pub_areacode` VALUES ('34', '3429', '342923', '安徽省青阳县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3500', '350000', '福建省');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350100', '福建省福州市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350101', '福建省福州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350102', '福建省福州市鼓楼区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350103', '福建省福州市台江区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350104', '福建省福州市仓山区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350105', '福建省福州市马尾区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350111', '福建省福州市郊区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350121', '福建省闽侯县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350122', '福建省连江县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350123', '福建省罗源县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350124', '福建省闽清县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350125', '福建省永泰县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350126', '福建省长乐县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350128', '福建省平潭县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350181', '福建省福清市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3501', '350182', '福建省福州市长乐市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350200', '福建省厦门市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350201', '福建省厦门市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350202', '福建省厦门市鼓浪屿区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350203', '福建省厦门市思明区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350204', '福建省厦门市开元区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350205', '福建省厦门市杏林区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350206', '福建省厦门市湖里区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350211', '福建省厦门市集美区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350212', '福建省厦门市同安区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350213', '福建省厦门市翔安区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3502', '350221', '福建省同安县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350300', '福建省莆田市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350301', '福建省莆田市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350302', '福建省莆田市城厢区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350303', '福建省莆田市涵江区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350304', '福建省莆田市荔城区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350305', '福建省莆田市秀屿区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350321', '福建省莆田县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3503', '350322', '福建省仙游县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350400', '福建省三明市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350401', '福建省三明市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350402', '福建省三明市梅列区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350403', '福建省三明市三元区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350421', '福建省明溪县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350423', '福建省清流县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350424', '福建省宁化县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350425', '福建省大田县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350426', '福建省尤溪县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350427', '福建省沙县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350428', '福建省将乐县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350429', '福建省泰宁县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350430', '福建省建宁县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3504', '350481', '福建省永安市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350500', '福建省泉州市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350501', '福建省泉州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350502', '福建省泉州市鲤城区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350503', '福建省泉州市丰泽区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350504', '福建省泉州市洛江区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350505', '福建省泉州市泉港区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350521', '福建省惠安县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350524', '福建省安溪县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350525', '福建省永春县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350526', '福建省德化县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350527', '福建省金门县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350581', '福建省石狮市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350582', '福建省晋江市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3505', '350583', '福建省南安市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350600', '福建省漳州市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350601', '福建省漳州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350602', '福建省漳州市芗城区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350603', '福建省漳州市龙文区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350619', '福建省漳州市漳州开发区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350622', '福建省云霄县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350623', '福建省漳浦县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350624', '福建省诏安县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350625', '福建省长泰县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350626', '福建省东山县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350627', '福建省南靖县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350628', '福建省平和县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350629', '福建省华安县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3506', '350681', '福建省龙海市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350700', '福建省南平市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350701', '福建省南平市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350702', '福建省南平市延平区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350721', '福建省南平市顺昌县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350722', '福建省南平市浦城县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350723', '福建省南平市光泽县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350724', '福建省南平市松溪县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350725', '福建省南平市政和县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350781', '福建省南平市邵武市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350782', '福建省南平市武夷山市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350783', '福建省南平市建瓯市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3507', '350784', '福建省南平市建阳市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350800', '福建省龙岩市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350801', '福建省龙岩市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350802', '福建省龙岩市新罗区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350821', '福建省龙岩市长汀县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350822', '福建省龙岩市永定县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350823', '福建省龙岩市上杭县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350824', '福建省龙岩市武平县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350825', '福建省龙岩市连城县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3508', '350881', '福建省龙岩市漳平市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350900', '福建省宁德市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350901', '福建省宁德市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350902', '福建省宁德市蕉城区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350909', '福建省宁德市闽东华侨经济开发区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350921', '福建省宁德市霞浦县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350922', '福建省宁德市古田县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350923', '福建省宁德市屏南县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350924', '福建省宁德市寿宁县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350925', '福建省宁德市周宁县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350926', '福建省宁德市柘荣县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350981', '福建省宁德市福安市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3509', '350982', '福建省宁德市福鼎市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352100', '福建省南平地区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352101', '福建省南平市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352102', '福建省邵武市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352103', '福建省武夷山市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352104', '福建省建瓯市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352121', '福建省顺昌县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352122', '福建省建阳县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352124', '福建省浦城县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352127', '福建省光泽县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352128', '福建省松溪县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3521', '352129', '福建省政和县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352200', '福建省宁德地区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352201', '福建省宁德市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352202', '福建省福安市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352224', '福建省福鼎县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352225', '福建省霞浦县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352227', '福建省古田县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352228', '福建省屏南县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352229', '福建省寿宁县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352230', '福建省周宁县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3522', '352231', '福建省柘荣县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352600', '福建省龙岩地区');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352601', '福建省龙岩市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352602', '福建省漳平市');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352622', '福建省长汀县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352623', '福建省永定县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352624', '福建省上杭县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352625', '福建省武平县');
INSERT INTO `t_pub_areacode` VALUES ('35', '3526', '352627', '福建省连城县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3600', '360000', '江西省');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360100', '江西省南昌市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360101', '江西省南昌市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360102', '江西省南昌市东湖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360103', '江西省南昌市西湖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360104', '江西省南昌市青云谱区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360105', '江西省南昌市湾里区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360111', '江西省南昌市郊区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360121', '江西省南昌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360122', '江西省新建县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360123', '江西省安义县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3601', '360124', '江西省进贤县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3602', '360200', '江西省景德镇市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3602', '360201', '江西省景德镇市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3602', '360202', '江西省景德镇市昌江区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3602', '360203', '江西省景德镇市珠山区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3602', '360222', '江西省浮梁县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3602', '360281', '江西省乐平市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360300', '江西省萍乡市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360301', '江西省萍乡市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360302', '江西省萍乡市安源区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360311', '江西省萍乡市上栗区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360312', '江西省萍乡市芦溪区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360313', '江西省萍乡市湘东区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360321', '江西省莲花县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360322', '江西省萍乡市上栗县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3603', '360323', '江西省萍乡市芦溪县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360400', '江西省九江市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360401', '江西省九江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360402', '江西省九江市庐山区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360403', '江西省浔阳县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360421', '江西省九江县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360423', '江西省武宁县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360424', '江西省修水县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360425', '江西省永修县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360426', '江西省德安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360427', '江西省星子县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360428', '江西省都昌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360429', '江西省湖口县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360430', '江西省彭泽县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3604', '360481', '江西省瑞昌市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3605', '360500', '江西省新余市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3605', '360501', '江西省新余市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3605', '360502', '江西省新余市渝水区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3605', '360521', '江西省分宜县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3606', '360600', '江西省鹰潭市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3606', '360601', '江西省鹰潭市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3606', '360602', '江西省鹰潭市月湖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3606', '360621', '江西省贵溪县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3606', '360622', '江西省余江县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3606', '360681', '江西省鹰潭市贵溪市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360700', '江西省赣州市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360701', '江西省赣州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360702', '江西省赣州市章贡区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360721', '江西省赣州市赣县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360722', '江西省赣州市信丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360723', '江西省赣州市大余县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360724', '江西省赣州市上犹县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360725', '江西省赣州市崇义县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360726', '江西省赣州市安远县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360727', '江西省赣州市龙南县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360728', '江西省赣州市定南县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360729', '江西省赣州市全南县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360730', '江西省赣州市宁都县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360731', '江西省赣州市于都县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360732', '江西省赣州市兴国县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360733', '江西省赣州市会昌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360734', '江西省赣州市寻乌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360735', '江西省赣州市石城县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360781', '江西省赣州市瑞金市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3607', '360782', '江西省赣州市南康市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360800', '江西省吉安市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360801', '江西省吉安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360802', '江西省吉安市吉州区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360803', '江西省吉安市青原区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360821', '江西省吉安市吉安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360822', '江西省吉安市吉水县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360823', '江西省吉安市峡江县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360824', '江西省吉安市新干县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360825', '江西省吉安市永丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360826', '江西省吉安市泰和县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360827', '江西省吉安市遂川县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360828', '江西省吉安市万安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360829', '江西省吉安市安福县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360830', '江西省吉安市永新县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3608', '360881', '江西省吉安市井冈山市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360900', '江西省宜春市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360901', '江西省宜春市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360902', '江西省宜春市袁州区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360921', '江西省宜春市奉新县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360922', '江西省宜春市万载县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360923', '江西省宜春市上高县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360924', '江西省宜春市宜丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360925', '江西省宜春市靖安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360926', '江西省宜春市铜鼓县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360981', '江西省宜春市丰城市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360982', '江西省宜春市樟树市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3609', '360983', '江西省宜春市高安市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361000', '江西省抚州市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361001', '江西省抚州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361002', '江西省抚州市临川区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361021', '江西省抚州市南城县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361022', '江西省抚州市黎川县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361023', '江西省抚州市南丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361024', '江西省抚州市崇仁县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361025', '江西省抚州市乐安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361026', '江西省抚州市宜黄县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361027', '江西省抚州市金溪县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361028', '江西省抚州市资溪县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361029', '江西省抚州市东乡县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3610', '361030', '江西省抚州市广昌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361100', '江西省上饶市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361101', '江西省上饶市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361102', '江西省上饶市信州区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361121', '江西省上饶市上饶县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361122', '江西省上饶市广丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361123', '江西省上饶市玉山县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361124', '江西省上饶市铅山县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361125', '江西省上饶市横峰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361126', '江西省上饶市弋阳县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361127', '江西省上饶市余干县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361128', '江西省上饶市鄱阳县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361129', '江西省上饶市万年县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361130', '江西省上饶市婺源县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3611', '361181', '江西省上饶市德兴市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362100', '江西省赣州地区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362101', '江西省赣州市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362121', '江西省赣县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362122', '江西省南康县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362123', '江西省信丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362124', '江西省大余县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362125', '江西省上犹县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362126', '江西省崇义县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362127', '江西省安远县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362128', '江西省龙南县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362129', '江西省定南县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362130', '江西省全南县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362131', '江西省宁都县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362132', '江西省于都县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362133', '江西省兴国县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362134', '江西省瑞金县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362135', '江西省会昌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362136', '江西省寻乌县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3621', '362137', '江西省石城县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362200', '江西省宜春地区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362201', '江西省宜春市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362202', '江西省丰城市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362203', '江西省樟树市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362204', '江西省高安市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362226', '江西省奉新县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362227', '江西省万载县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362228', '江西省上高县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362229', '江西省宜丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362232', '江西省靖安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3622', '362233', '江西省铜鼓县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362300', '江西省上饶地区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362301', '江西省上饶市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362302', '江西省德兴市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362321', '江西省上饶县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362322', '江西省广丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362323', '江西省玉山县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362324', '江西省铅山县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362325', '江西省横峰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362326', '江西省弋阳县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362329', '江西省余干县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362330', '江西省波阳县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362331', '江西省万年县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3623', '362334', '江西省婺源县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362400', '江西省吉安地区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362401', '江西省吉安市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362402', '江西省井岗山市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362421', '江西省吉安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362422', '江西省吉水县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362423', '江西省峡江县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362424', '江西省新干县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362425', '江西省永丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362426', '江西省泰和县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362427', '江西省遂川县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362428', '江西省万安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362429', '江西省安福县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362430', '江西省永新县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3624', '362432', '江西省宁冈县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362500', '江西省抚州地区');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362502', '江西省临川市');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362522', '江西省南城县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362523', '江西省黎川县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362524', '江西省南丰县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362525', '江西省崇仁县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362526', '江西省乐安县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362527', '江西省宜黄县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362528', '江西省金溪县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362529', '江西省资溪县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362531', '江西省东乡县');
INSERT INTO `t_pub_areacode` VALUES ('36', '3625', '362532', '江西省广昌县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3700', '370000', '山东省');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370100', '山东省济南市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370101', '山东省济南市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370102', '山东省济南市历下区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370103', '山东省济南市市中区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370104', '山东省济南市槐荫区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370105', '山东省济南市天桥区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370112', '山东省济南市历城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370113', '山东省济南市长清区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370123', '山东省长清县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370124', '山东省平阴县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370125', '山东省商河县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370126', '山东省济阳县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3701', '370181', '山东省章丘市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370200', '山东省青岛市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370201', '山东省青岛市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370202', '山东省青岛市市南区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370203', '山东省青岛市市北区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370204', '山东省青岛市台东区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370205', '山东省青岛市四方区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370206', '山东省青岛市沧口区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370211', '山东省青岛市黄岛区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370212', '山东省青岛市崂山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370213', '山东省青岛市李沧区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370214', '山东省青岛市城阳区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370281', '山东省胶州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370282', '山东省即墨市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370283', '山东省平度市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370284', '山东省胶南市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3702', '370285', '山东省菜西市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370300', '山东省淄博市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370301', '山东省淄博市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370302', '山东省淄博市淄川区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370303', '山东省淄博市张店区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370304', '山东省淄博市博山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370305', '山东省淄博市临淄区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370306', '山东省淄博市周村区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370321', '山东省桓台县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370322', '山东省高青县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3703', '370323', '山东省沂源县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370400', '山东省枣庄市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370401', '山东省枣庄市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370402', '山东省枣庄市市中区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370403', '山东省枣庄市薛城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370404', '山东省枣庄市峄城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370405', '山东省枣庄市台儿庄区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370406', '山东省枣庄市山亭区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3704', '370481', '山东省滕州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370500', '山东省东营市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370501', '山东省东营市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370502', '山东省东营市东营区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370503', '山东省东营市河口区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370521', '山东省垦利县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370522', '山东省利津县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3705', '370523', '山东省广饶县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370600', '山东省烟台市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370601', '山东省烟台市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370602', '山东省烟台市芝罘区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370611', '山东省烟台市福山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370612', '山东省烟台市牟平区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370613', '山东省烟台市莱山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370628', '山东省栖霞县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370629', '山东省海阳县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370631', '山东省牟平县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370634', '山东省长岛县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370681', '山东省龙口市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370682', '山东省莱阳市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370683', '山东省莱州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370684', '山东省蓬莱市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370685', '山东省招远市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370686', '山东省烟台市栖霞市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3706', '370687', '山东省烟台市海阳市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370700', '山东省潍坊市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370701', '山东省潍坊市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370702', '山东省潍坊市潍城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370703', '山东省潍坊市寒亭区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370704', '山东省潍坊市坊子区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370705', '山东省潍坊市奎文区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370722', '山东省安丘县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370724', '山东省临朐县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370725', '山东省昌乐县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370726', '山东省昌邑县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370727', '山东省高密县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370781', '山东省青州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370782', '山东省诸城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370783', '山东省寿光市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370784', '山东省潍坊市安丘市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370785', '山东省潍坊市高密市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3707', '370786', '山东省潍坊市昌邑市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370800', '山东省济宁市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370801', '山东省济宁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370802', '山东省济宁市市中区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370811', '山东省济宁市任城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370826', '山东省微山县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370827', '山东省鱼台县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370828', '山东省金乡县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370829', '山东省嘉祥县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370830', '山东省汶上县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370831', '山东省泗水县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370832', '山东省梁山县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370881', '山东省曲阜市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370882', '山东省兖州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3708', '370883', '山东省邹城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370900', '山东省泰安市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370901', '山东省泰安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370902', '山东省泰安市泰山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370903', '山东省泰安市岱岳区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370911', '山东省泰安市郊区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370921', '山东省宁阳县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370923', '山东省东平县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370982', '山东省新泰市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3709', '370983', '山东省肥城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3710', '371000', '山东省威海市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3710', '371001', '山东省威海市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3710', '371002', '山东省威海市环翠区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3710', '371081', '山东省文登市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3710', '371082', '山东省荣城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3710', '371083', '山东省乳山市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3711', '371100', '山东省日照市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3711', '371101', '山东省日照市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3711', '371102', '山东省日照市东港区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3711', '371103', '山东省日照市岚山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3711', '371121', '山东省五莲县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3711', '371122', '山东省莒县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3712', '371200', '山东省莱芜市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3712', '371201', '山东省莱芜市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3712', '371202', '山东省莱芜市莱城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3712', '371203', '山东省莱芜市钢城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371300', '山东省临沂市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371301', '山东省临沂市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371302', '山东省临沂市兰山区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371311', '山东省临沂市罗庄区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371312', '山东省临沂市河东区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371321', '山东省临沂市沂南县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371322', '山东省临沂市郯城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371323', '山东省临沂市沂水县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371324', '山东省临沂市苍山县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371325', '山东省临沂市费县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371326', '山东省临沂市平邑县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371327', '山东省临沂市莒南县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371328', '山东省临沂市蒙阴县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3713', '371329', '山东省临沂市临沭县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371400', '山东省德州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371401', '山东省德州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371402', '山东省德州市德城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371421', '山东省德州市陵县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371422', '山东省德州市宁津县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371423', '山东省德州市庆云县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371424', '山东省德州市临邑县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371425', '山东省德州市齐河县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371426', '山东省德州市平原县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371427', '山东省德州市夏津县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371428', '山东省德州市武城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371481', '山东省德州市乐陵市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3714', '371482', '山东省德州市禹城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371500', '山东省聊城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371501', '山东省聊城市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371502', '山东省聊城市东昌府区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371521', '山东省聊城市阳谷县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371522', '山东省聊城市莘县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371523', '山东省聊城市茌平县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371524', '山东省聊城市东阿县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371525', '山东省聊城市冠县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371526', '山东省聊城市高唐县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3715', '371581', '山东省聊城市临清市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371600', '山东省滨州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371601', '山东省滨州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371602', '山东省滨州市滨城区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371621', '山东省滨州市惠民县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371622', '山东省滨州市阳信县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371623', '山东省滨州市无棣县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371624', '山东省滨州市沾化县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371625', '山东省滨州市博兴县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3716', '371626', '山东省滨州市邹平县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371700', '山东省荷泽市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371701', '山东省荷泽市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371702', '山东省荷泽市牡丹区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371721', '山东省荷泽市曹县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371722', '山东省荷泽市单县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371723', '山东省荷泽市成武县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371724', '山东省荷泽市巨野县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371725', '山东省荷泽市郓城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371726', '山东省荷泽市鄄城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371727', '山东省荷泽市定陶县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3717', '371728', '山东省荷泽市东明县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372300', '山东省滨州地区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372301', '山东省滨州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372321', '山东省惠民县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372323', '山东省阳信县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372324', '山东省无棣县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372325', '山东省沾化县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372328', '山东省博兴县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3723', '372330', '山东省邹平县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372400', '山东省德州地区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372401', '山东省德州市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372402', '山东省乐陵市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372403', '山东省禹城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372421', '山东省陵县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372422', '山东省平原县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372423', '山东省夏津县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372424', '山东省武城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372425', '山东省齐河县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372428', '山东省临邑县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372431', '山东省宁津县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3724', '372432', '山东省庆云县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372500', '山东省聊城地区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372501', '山东省聊城市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372502', '山东省临清市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372522', '山东省阳谷县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372523', '山东省莘县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372524', '山东省茌平县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372525', '山东省东阿县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372526', '山东省冠县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3725', '372527', '山东省高唐县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372800', '山东省临沂地区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372801', '山东省临沂市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372822', '山东省郯城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372823', '山东省苍山县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372824', '山东省莒南县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372827', '山东省沂水县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372829', '山东省蒙阴县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372830', '山东省平邑县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372831', '山东省费县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372832', '山东省沂南县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3728', '372833', '山东省临沭县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372900', '山东省菏泽地区');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372901', '山东省菏泽市');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372922', '山东省曹县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372923', '山东省定陶县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372924', '山东省成武县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372925', '山东省单县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372926', '山东省巨野县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372928', '山东省郓城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372929', '山东省鄄城县');
INSERT INTO `t_pub_areacode` VALUES ('37', '3729', '372930', '山东省东明县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4100', '410000', '河南省');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410100', '河南省郑州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410101', '河南省郑州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410102', '河南省郑州市中原区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410103', '河南省郑州市二七区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410104', '河南省郑州市管城回族区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410105', '河南省郑州市金水区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410106', '河南省郑州市上街区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410108', '河南省郑州市邙山区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410121', '河南省荥阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410122', '河南省中牟县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410123', '河南省新郑县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410125', '河南省登封县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410126', '河南省密县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410181', '河南省巩义市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410182', '河南省郑州市荥阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410183', '河南省郑州市新密市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410184', '河南省郑州市新郑市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4101', '410185', '河南省郑州市登封市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410200', '河南省开封市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410201', '河南省开封市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410202', '河南省开封市龙亭区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410203', '河南省开封市顺河回族区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410204', '河南省开封市鼓楼区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410205', '河南省开封市南关区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410211', '河南省开封市郊区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410221', '河南省杞县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410222', '河南省通许县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410223', '河南省尉氏县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410224', '河南省开封县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4102', '410225', '河南省兰考县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410300', '河南省洛阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410301', '河南省洛阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410302', '河南省洛阳市老城区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410303', '河南省洛阳市西工区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410304', '河南省洛阳市廛河回族区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410305', '河南省洛阳市涧西区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410306', '河南省洛阳市吉利区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410307', '河南省洛阳市洛龙区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410311', '河南省洛阳市郊区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410322', '河南省孟津县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410323', '河南省新安县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410324', '河南省栾川县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410325', '河南省嵩县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410326', '河南省汝阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410327', '河南省宜阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410328', '河南省洛宁县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410329', '河南省伊川县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4103', '410381', '河南省偃师市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410400', '河南省平顶山市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410401', '河南省平顶山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410402', '河南省平顶山市新华区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410403', '河南省平顶山市卫东区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410404', '河南省平顶山市石龙区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410411', '河南省平顶山市郊区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410421', '河南省宝丰县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410422', '河南省叶县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410423', '河南省鲁山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410425', '河南省郏县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410426', '河南省襄城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410481', '河南省舞钢市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4104', '410482', '河南省汝州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410500', '河南省安阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410501', '河南省安阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410502', '河南省安阳市文峰区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410503', '河南省安阳市北关区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410504', '河南省安阳市铁西区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410505', '河南省安阳市殷都区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410506', '河南省安阳市龙安区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410511', '河南省安阳市郊区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410521', '河南省林县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410522', '河南省安阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410523', '河南省汤阴县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410526', '河南省滑县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410527', '河南省内黄县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4105', '410581', '河南省安阳市林州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410600', '河南省鹤壁市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410601', '河南省鹤壁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410602', '河南省鹤壁市鹤山区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410603', '河南省鹤壁市山城区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410611', '河南省鹤壁市郊区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410621', '河南省浚县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4106', '410622', '河南省淇县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410700', '河南省新乡市　　　　　　');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410701', '河南省新乡市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410702', '河南省新乡市红旗区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410703', '河南省新乡市新华区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410704', '河南省新乡市北站区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410711', '河南省新乡市郊区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410721', '河南省新乡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410724', '河南省获嘉县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410725', '河南省原阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410726', '河南省延津县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410727', '河南省封丘县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410728', '河南省长恒县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410781', '河南省卫辉市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4107', '410782', '河南省辉县市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410800', '河南省焦作市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410801', '河南省焦作市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410802', '河南省焦作市解放区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410803', '河南省焦作市中站区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410804', '河南省焦作市马村区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410811', '河南省焦作市山阳区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410821', '河南省修武县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410822', '河南省博爱县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410823', '河南省武陟县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410825', '河南省温县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410826', '河南省孟县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410881', '河南省济源市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410882', '河南省沁阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4108', '410883', '河南省焦作市孟州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410900', '河南省濮阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410901', '河南省濮阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410902', '河南省濮阳市市区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410922', '河南省清丰县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410923', '河南省南乐县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410926', '河南省范县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410927', '河南省台前县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4109', '410928', '河南省濮阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411000', '河南省许昌市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411001', '河南省许昌市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411002', '河南省许昌市魏都区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411023', '河南省许昌县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411024', '河南省鄢陵县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411025', '河南省许昌市襄城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411081', '河南省禹州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4110', '411082', '河南省长葛市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411100', '河南省漯河市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411101', '河南省漯河市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411102', '河南省漯河市源仁区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411103', '河南省漯河市郾城区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411104', '河南省漯河市召陵区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411121', '河南省舞阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411122', '河南省临颖县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4111', '411123', '河南省郾城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411200', '河南省三门峡市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411201', '河南省三门峡市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411202', '河南省三门峡市湖滨区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411221', '河南省渑池县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411222', '河南省陕县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411224', '河南省卢氏县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411281', '河南省义马市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4112', '411282', '河南省灵宝市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411300', '河南省南阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411301', '河南省南阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411302', '河南省南阳市宛城区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411303', '河南省南阳市卧龙区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411321', '河南省南阳市南召县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411322', '河南省南阳市方城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411323', '河南省南阳市西峡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411324', '河南省南阳市镇平县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411325', '河南省南阳市内乡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411326', '河南省南阳市淅川县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411327', '河南省南阳市社旗县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411328', '河南省南阳市唐河县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411329', '河南省南阳市新野县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411330', '河南省南阳市桐柏县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4113', '411381', '河南省南阳市邓州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411400', '河南省商丘市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411401', '河南省商丘市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411402', '河南省商丘市梁园区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411403', '河南省商丘市睢阳区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411421', '河南省商丘市民权县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411422', '河南省商丘市睢县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411423', '河南省商丘市宁陵县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411424', '河南省商丘市柘城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411425', '河南省商丘市虞城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411426', '河南省商丘市夏邑县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4114', '411481', '河南省商丘市永城市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411500', '河南省信阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411501', '河南省信阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411502', '河南省信阳市师河区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411503', '河南省信阳市平桥区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411521', '河南省信阳市罗山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411522', '河南省信阳市光山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411523', '河南省信阳市新县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411524', '河南省信阳市商城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411525', '河南省信阳市固始县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411526', '河南省信阳市潢川县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411527', '河南省信阳市淮滨县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4115', '411528', '河南省信阳市息县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411600', '河南省周口市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411601', '河南省周口市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411602', '河南省周口市川汇区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411621', '河南省周口市扶沟县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411622', '河南省周口市西华县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411623', '河南省周口市商水县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411624', '河南省周口市沈丘县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411625', '河南省周口市郸城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411626', '河南省周口市淮阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411627', '河南省周口市太康县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411628', '河南省周口市鹿邑县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4116', '411681', '河南省周口市项城市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411700', '河南省驻马店市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411701', '河南省驻马店市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411702', '河南省驻马店市驿城区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411721', '河南省驻马店市西平县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411722', '河南省驻马店市上蔡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411723', '河南省驻马店市平舆县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411724', '河南省驻马店市正阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411725', '河南省驻马店市确山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411726', '河南省驻马店市泌阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411727', '河南省驻马店市汝南县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411728', '河南省驻马店市遂平县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4117', '411729', '河南省驻马店市新蔡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412300', '河南省商丘地区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412301', '河南省商丘市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412321', '河南省虞城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412322', '河南省商丘县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412323', '河南省民权县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412324', '河南省宁陵县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412325', '河南省睢县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412326', '河南省夏邑县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412327', '河南省柘城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4123', '412328', '河南省永城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412700', '河南省周口地区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412701', '河南省周口市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412702', '河南省项城市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412721', '河南省扶沟县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412722', '河南省西华县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412723', '河南省商水县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412724', '河南省太康县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412725', '河南省鹿邑县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412726', '河南省郸城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412727', '河南省淮阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4127', '412728', '河南省沈丘县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412800', '河南省驻马店地区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412801', '河南省驻马店市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412821', '河南省确山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412822', '河南省泌阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412823', '河南省遂平县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412824', '河南省西平县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412825', '河南省上蔡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412826', '河南省汝南县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412827', '河南省平舆县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412828', '河南省新蔡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4128', '412829', '河南省正阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412900', '河南省南阳地区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412901', '河南省南阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412902', '河南省邓州市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412921', '河南省南召县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412922', '河南省方城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412923', '河南省西峡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412924', '河南省南阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412925', '河南省镇平县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412926', '河南省内乡县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412927', '河南省淅川县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412928', '河南省社旗县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412929', '河南省唐河县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412931', '河南省新野县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4129', '412932', '河南省桐柏县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413000', '河南省信阳地区');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413001', '河南省信阳市');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413021', '河南省息县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413022', '河南省淮滨县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413023', '河南省信阳县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413024', '河南省横川县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413025', '河南省光山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413026', '河南省固始县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413027', '河南省商城县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413028', '河南省罗山县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4130', '413029', '河南省新县');
INSERT INTO `t_pub_areacode` VALUES ('41', '4190', '419000', '河南省省直辖行政单位');
INSERT INTO `t_pub_areacode` VALUES ('41', '4190', '419001', '河南省济源市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4200', '420000', '湖北省');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420100', '湖北省武汉市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420101', '湖北省武汉市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420102', '湖北省武汉市江岸区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420103', '湖北省武汉市江汉区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420104', '湖北省武汉市乔口区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420105', '湖北省武汉市汉阳区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420106', '湖北省武汉市武昌区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420107', '湖北省武汉市青山区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420111', '湖北省武汉市洪山区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420112', '湖北省武汉市东西湖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420113', '湖北省武汉市汉南区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420114', '湖北省蔡甸区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420115', '湖北省武汉市江夏区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420116', '湖北省武汉市黄陂区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420117', '湖北省武汉市新洲区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420122', '湖北省武昌县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420123', '湖北省黄陂县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4201', '420124', '湖北省新洲县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420200', '湖北省黄石市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420201', '湖北省黄石市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420202', '湖北省黄石市黄石港区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420203', '湖北省黄石市石灰窑区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420204', '湖北省黄石市下陆区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420205', '湖北省黄石市铁山区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420221', '湖北省大冶县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420222', '湖北省黄石市阳新县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4202', '420281', '湖北省黄石市大冶市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420300', '湖北省十堰市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420301', '湖北省十堰市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420302', '湖北省十堰市茅箭区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420303', '湖北省十堰市张湾区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420321', '湖北省十堰市郧县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420322', '湖北省十堰市郧西县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420323', '湖北省十堰市竹山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420324', '湖北省十堰市竹溪县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420325', '湖北省十堰市房县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4203', '420381', '湖北省十堰市丹江口市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4204', '420400', '湖北省沙市市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420500', '湖北省宜昌市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420501', '湖北省宜昌市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420502', '湖北省宜昌市西陵区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420503', '湖北省宜昌市伍家岗区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420504', '湖北省宜昌市点军区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420505', '湖北省宜昌市猇亭区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420506', '湖北省宜昌市夷陵区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420521', '湖北省宜昌县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420523', '湖北省枝江县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420525', '湖北省远安县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420526', '湖北省兴山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420527', '湖北省秭归县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420528', '湖北省长阳土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420529', '湖北省五峰土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420581', '湖北省枝城市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420582', '湖北省当阳市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4205', '420583', '湖北省宜昌市枝江市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420600', '湖北省襄樊市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420601', '湖北省襄樊市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420602', '湖北省襄樊市襄城区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420603', '湖北省襄樊市樊东区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420604', '湖北省襄樊市樊西区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420605', '湖北省襄樊市郊区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420606', '湖北省襄樊市樊城区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420607', '湖北省襄樊市襄阳区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420621', '湖北省襄阳县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420623', '湖北省宜城县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420624', '湖北省南漳县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420625', '湖北省谷城县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420626', '湖北省保康县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420681', '湖北省随州市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420682', '湖北省老河口市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420683', '湖北省枣阳市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4206', '420684', '湖北省襄樊市宜城市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4207', '420700', '湖北省鄂州市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4207', '420701', '湖北省鄂州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4207', '420702', '湖北省鄂州市梁子湖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4207', '420703', '湖北省鄂州市谷容区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4207', '420704', '湖北省鄂州市鄂城区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420800', '湖北省荆门市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420801', '湖北省荆门市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420802', '湖北省荆门市东宝区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420803', '湖北省荆门市沙洋区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420804', '湖北省荆门市掇刀区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420821', '湖北省荆门市京山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420822', '湖北省荆门市沙洋县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4208', '420881', '湖北省荆门市钟祥市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420900', '湖北省孝感市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420901', '湖北省孝感市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420902', '湖北省孝感市孝南区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420903', '湖北省孝感市孝昌区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420921', '湖北省孝感市孝昌县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420922', '湖北省大悟县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420923', '湖北省云梦县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420924', '湖北省汉川县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420981', '湖北省应城市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420982', '湖北省安陆市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420983', '湖北省广水市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4209', '420984', '湖北省孝感市汉川市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421000', '湖北省荆州市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421001', '湖北省荆州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421002', '湖北省荆州市沙市区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421003', '湖北省荆州市荆州区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421022', '湖北省荆州市公安县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421023', '湖北省荆州市监利县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421024', '湖北省荆州市江陵县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421081', '湖北省荆州市石首市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421083', '湖北省荆州市洪湖市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4210', '421087', '湖北省荆州市松滋市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421100', '湖北省黄冈市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421101', '湖北省黄冈市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421102', '湖北省黄冈市黄州区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421121', '湖北省黄冈市团风县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421122', '湖北省黄冈市红安县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421123', '湖北省黄冈市罗田县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421124', '湖北省黄冈市英山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421125', '湖北省黄冈市浠水县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421126', '湖北省黄冈市蕲春县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421127', '湖北省黄冈市黄梅县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421181', '湖北省黄冈市麻城市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4211', '421182', '湖北省黄冈市武穴市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421200', '湖北省咸宁市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421201', '湖北省咸宁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421202', '湖北省咸宁市咸安区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421221', '湖北省咸宁市嘉鱼县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421222', '湖北省咸宁市通城县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421223', '湖北省咸宁市崇阳县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421224', '湖北省咸宁市通山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4212', '421281', '湖北省咸宁市赤壁市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4213', '421300', '湖北省随州市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4213', '421301', '湖北省随州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4213', '421302', '湖北省随州市曾都区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4213', '421381', '湖北省随州市广水市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422100', '湖北省黄冈地区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422101', '湖北省麻城市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422102', '湖北省武穴市　　　　　　');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422103', '湖北省黄州市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422123', '湖北省红安县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422125', '湖北省罗田县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422126', '湖北省英山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422127', '湖北省浠水县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422128', '湖北省蕲春县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4221', '422130', '湖北省黄梅县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422300', '湖北省咸宁地区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422301', '湖北省咸宁市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422302', '湖北省蒲圻市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422322', '湖北省嘉鱼县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422324', '湖北省通城县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422325', '湖北省崇阳县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422326', '湖北省通山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4223', '422327', '湖北省阳新县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422400', '湖北省荆州地区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422401', '湖北省仙桃市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422402', '湖北省石首市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422403', '湖北省洪湖市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422404', '湖北省天门市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422405', '湖北省潜江市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422406', '湖北省钟祥市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422421', '湖北省江陵县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422422', '湖北省松滋县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422423', '湖北省公安县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422425', '湖北省监利县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4224', '422432', '湖北省京山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422600', '湖北省郧阳地区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422601', '湖北省丹江口市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422622', '湖北省郧县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422623', '湖北省郧西县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422624', '湖北省竹山县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422625', '湖北省竹溪县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4226', '422626', '湖北省房县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422800', '湖北省恩施土家族苗族自治州');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422801', '湖北省恩施市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422802', '湖北省利川市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422822', '湖北省建始县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422823', '湖北省巴东县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422825', '湖北省宣恩县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422826', '湖北省咸丰县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422827', '湖北省来凤县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4228', '422828', '湖北省鹤峰县');
INSERT INTO `t_pub_areacode` VALUES ('42', '4229', '422900', '湖北省省直辖行政单位');
INSERT INTO `t_pub_areacode` VALUES ('42', '4229', '422921', '湖北省神农架林区');
INSERT INTO `t_pub_areacode` VALUES ('42', '4290', '429000', '湖北省省直辖县级行政区划');
INSERT INTO `t_pub_areacode` VALUES ('42', '4290', '429004', '湖北省仙桃市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4290', '429005', '湖北省潜江市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4290', '429006', '湖北省天门市');
INSERT INTO `t_pub_areacode` VALUES ('42', '4290', '429021', '湖北省神农架林区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4300', '430000', '湖南省');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430100', '湖南省长沙市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430101', '湖南省长沙市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430102', '湖南省长沙市东区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430103', '湖南省长沙市南区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430104', '湖南省长沙市西区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430105', '湖南省长沙市北区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430111', '湖南省长沙市郊区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430121', '湖南省长沙县　　');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430122', '湖南省望城县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430124', '湖南省宁乡县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4301', '430181', '湖南省浏阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430200', '湖南省株洲市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430201', '湖南省株洲市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430202', '湖南省株洲市东区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430203', '湖南省株洲市北区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430204', '湖南省株洲市南区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430211', '湖南省株洲市郊区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430221', '湖南省株洲县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430223', '湖南省攸县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430224', '湖南省茶陵县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430225', '湖南省酃县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4302', '430281', '湖南省醴陵市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430300', '湖南省湘潭市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430301', '湖南省湘潭市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430302', '湖南省湘潭市雨湖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430304', '湖南省湘潭市岳塘区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430321', '湖南省湘潭县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430381', '湖南省湘乡市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4303', '430382', '湖南省韶山市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430400', '湖南省衡阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430401', '湖南省衡阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430402', '湖南省衡阳市江东区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430403', '湖南省衡阳市城南区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430404', '湖南省衡阳市城北区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430405', '湖南省衡阳市珠晖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430406', '湖南省衡阳市雁峰区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430407', '湖南省衡阳市石鼓区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430408', '湖南省衡阳市蒸湘区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430411', '湖南省衡阳市郊区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430412', '湖南省衡阳市南岳区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430421', '湖南省衡阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430422', '湖南省衡南县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430423', '湖南省衡山县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430424', '湖南省衡东县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430425', '湖南省常宁县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430426', '湖南省祁东县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430481', '湖南省耒阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4304', '430482', '湖南省衡阳市常宁市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430500', '湖南省邵阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430501', '湖南省邵阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430502', '湖南省邵阳市东区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430503', '湖南省邵阳市西区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430511', '湖南省邵阳市郊区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430521', '湖南省邵东县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430522', '湖南省新邵县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430523', '湖南省邵阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430524', '湖南省隆回县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430525', '湖南省洞口县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430526', '湖南省武冈县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430527', '湖南省绥宁县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430528', '湖南省新宁县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430529', '湖南省城步苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4305', '430581', '湖南省邵阳市武冈市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430600', '湖南省岳阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430601', '湖南省岳阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430602', '湖南省岳阳市南区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430603', '湖南省岳阳市北区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430611', '湖南省岳阳市郊区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430621', '湖南省岳阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430623', '湖南省华容县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430624', '湖南省湘阴县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430626', '湖南省平江县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430681', '湖南省汨罗市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4306', '430682', '湖南省临湘市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430700', '湖南省常德市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430701', '湖南省常德市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430702', '湖南省常德市武陵区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430703', '湖南省常德市鼎城区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430721', '湖南省安乡县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430722', '湖南省汉寿县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430723', '湖南省澧县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430724', '湖南省临澧县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430725', '湖南省桃源县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430726', '湖南省石门县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4307', '430781', '湖南省津市市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4308', '430800', '湖南省大庸市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4308', '430801', '湖南省大庸市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4308', '430802', '湖南省大庸市永定区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4308', '430811', '湖南省大庸市武陵源区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4308', '430821', '湖南省慈利县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4308', '430822', '湖南省桑植县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430900', '湖南省益阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430901', '湖南省益阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430902', '湖南省益阳市资阳区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430903', '湖南省益阳市赫山区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430921', '湖南省益阳市南县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430922', '湖南省益阳市桃江县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430923', '湖南省益阳市安化县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4309', '430981', '湖南省益阳市沅江市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431000', '湖南省郴州市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431001', '湖南省郴州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431002', '湖南省郴州市北湖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431003', '湖南省郴州市苏仙区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431021', '湖南省郴州市桂阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431022', '湖南省郴州市宜章县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431023', '湖南省郴州市永兴县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431024', '湖南省郴州市嘉禾县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431025', '湖南省郴州市临武县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431026', '湖南省郴州市汝城县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431027', '湖南省郴州市桂东县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431028', '湖南省郴州市安仁县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4310', '431081', '湖南省郴州市资兴市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431100', '湖南省永州市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431101', '湖南省永州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431102', '湖南省永州市零陵区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431103', '湖南省永州市冷水滩区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431121', '湖南省永州市祁阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431122', '湖南省永州市东安县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431123', '湖南省永州市双牌县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431124', '湖南省永州市道县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431125', '湖南省永州市江永县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431126', '湖南省永州市宁远县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431127', '湖南省永州市蓝山县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431128', '湖南省永州市新田县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4311', '431129', '湖南省永州市江华瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431200', '湖南省怀化市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431201', '湖南省怀化市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431202', '湖南省怀化市鹤城区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431221', '湖南省怀化市中方县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431222', '湖南省怀化市沅陵县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431223', '湖南省怀化市辰溪县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431224', '湖南省怀化市溆浦县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431225', '湖南省怀化市会同县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431226', '湖南省怀化市麻阳苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431227', '湖南省怀化市新晃侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431228', '湖南省怀化市芷江侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431229', '湖南省怀化市靖州苗族侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431230', '湖南省怀化市通道侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4312', '431281', '湖南省怀化市洪江市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431300', '湖南省娄底市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431301', '湖南省娄底市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431302', '湖南省娄底市娄星区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431321', '湖南省娄底市双峰县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431322', '湖南省娄底市新化县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431381', '湖南省娄底市冷水江市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4313', '431382', '湖南省娄底市涟源市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432300', '湖南省益阳地区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432301', '湖南省益阳市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432302', '湖南省沅江市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432321', '湖南省益阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432322', '湖南省南县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432325', '湖南省桃江县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4323', '432326', '湖南省安化县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4325', '432500', '湖南省娄底地区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4325', '432501', '湖南省娄底市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4325', '432502', '湖南省冷水江市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4325', '432503', '湖南省涟源市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4325', '432522', '湖南省双峰县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4325', '432524', '湖南省新化县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432800', '湖南省郴州地区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432801', '湖南省郴州市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432802', '湖南省资兴市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432821', '湖南省郴县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432822', '湖南省桂阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432823', '湖南省永兴县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432824', '湖南省宜章县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432826', '湖南省嘉禾县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432827', '湖南省临武县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432828', '湖南省汝城县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432829', '湖南省桂东县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4328', '432831', '湖南省安仁县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432900', '湖南省零陵地区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432901', '湖南省永州市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432902', '湖南省冷水滩市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432922', '湖南省东安县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432923', '湖南省道县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432924', '湖南省宁远县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432925', '湖南省江永县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432926', '湖南省江华瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432927', '湖南省蓝山县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432928', '湖南省新田县　');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432929', '湖南省双牌县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4329', '432930', '湖南省祁阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433000', '湖南省怀化地区');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433001', '湖南省怀化市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433002', '湖南省洪江市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433021', '湖南省黔阳县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433022', '湖南省沅陵县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433023', '湖南省辰溪县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433024', '湖南省溆浦县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433025', '湖南省麻阳苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433026', '湖南省新晃侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433027', '湖南省芷江侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433029', '湖南省会同县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433030', '湖南省靖州苗族侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4330', '433031', '湖南省通道侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433100', '湖南省湘西土家族苗族自治州');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433101', '湖南省吉首市');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433122', '湖南省泸溪县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433123', '湖南省风凰县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433124', '湖南省花垣县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433125', '湖南省保靖县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433126', '湖南省古丈县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433127', '湖南省永顺县');
INSERT INTO `t_pub_areacode` VALUES ('43', '4331', '433130', '湖南省龙山县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4400', '440000', '广东省');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440100', '广东省广州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440101', '广东省广州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440102', '广东省广州市东山区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440103', '广东省广州市荔湾区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440104', '广东省广州市越秀区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440105', '广东省广州市海珠区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440106', '广东省广州市天河区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440107', '广东省广州市芳村区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440111', '广东省广州市白云区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440112', '广东省广州市黄埔区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440113', '广东省广州市番禺区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440114', '广东省广州市花都区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440115', '广东省广州市南沙区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440116', '广东省广州市萝岗区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440122', '广东省从花县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440181', '广东省番禺市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440182', '广东省花都市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440183', '广东省增城市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4401', '440184', '广东省广州市从化市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440200', '广东省韶关市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440201', '广东省韶关市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440202', '广东省韶关市北江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440203', '广东省韶关市武江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440204', '广东省韶关市浈江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440205', '广东省韶关市曲江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440221', '广东省曲江县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440222', '广东省始兴县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440223', '广东省南雄县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440224', '广东省仁化县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440225', '广东省乐昌县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440229', '广东省翁源县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440232', '广东省乳源瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440233', '广东省新丰县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440281', '广东省韶关市乐昌市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4402', '440282', '广东省韶关市南雄市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440300', '广东省深圳市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440301', '广东省深圳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440303', '广东省深圳市罗湖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440304', '广东省深圳市福田区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440305', '广东省深圳市南山区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440306', '广东省深圳市宝安区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440307', '广东省深圳市龙岗区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4403', '440308', '广东省深圳市盐田区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440400', '广东省珠海市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440401', '广东省珠海市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440402', '广东省珠海市香州区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440403', '广东省珠海市斗门区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440404', '广东省珠海市金湾区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440407', '广东省汕头市龙湖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4404', '440421', '广东省斗门县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440500', '广东省汕头市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440501', '广东省汕头市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440506', '广东省汕头市达濠区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440507', '广东省汕头市龙湖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440508', '广东省汕头市金园区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440509', '广东省汕头市升平区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440511', '广东省汕头市金平区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440512', '广东省汕头市濠江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440513', '广东省汕头市潮阳区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440514', '广东省汕头市潮南区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440515', '广东省汕头市澄海区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440521', '广东省澄海县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440523', '广东省南懊县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4405', '440582', '广东省潮阳市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440600', '广东省佛山市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440601', '广东省佛山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440602', '广东省佛山市城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440603', '广东省佛山市石湾区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440604', '广东省佛山市禅城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440605', '广东省佛山市南海区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440606', '广东省佛山市顺德区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440607', '广东省佛山市三水区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440608', '广东省佛山市高明区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440624', '广东省高明县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440681', '广东省顺德市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440682', '广东省南海市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4406', '440683', '广东省三水市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440700', '广东省江门市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440701', '广东省江门市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440702', '广东省江门市城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440703', '广东省江门市蓬江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440704', '广东省江门市江海区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440705', '广东省江门市新会区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440711', '广东省江门市郊区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440723', '广东省恩平县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440781', '广东省台山市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440782', '广东省新会市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440783', '广东省开平市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440784', '广东省鹤山市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4407', '440785', '广东省江门市恩平市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440800', '广东省湛江市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440801', '广东省湛江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440802', '广东省湛江市赤坎区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440803', '广东省湛江市霞山区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440804', '广东省湛江市坡头区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440811', '广东省湛江市郊区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440821', '广东省吴川县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440823', '广东省遂溪县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440824', '广东省海康县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440825', '广东省徐闻县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440881', '广东省廉江市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440882', '广东省湛江市雷州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4408', '440883', '广东省湛江市吴川市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440900', '广东省茂名市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440901', '广东省茂名市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440902', '广东省茂名市茂南区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440903', '广东省茂名市茂港区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440921', '广东省信宜县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440923', '广东省电白县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440924', '广东省化州县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440981', '广东省高州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440982', '广东省茂名市化州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4409', '440983', '广东省茂名市信宜市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441200', '广东省肇庆市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441201', '广东省肇庆市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441202', '广东省肇庆市端州区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441203', '广东省肇庆市鼎湖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441223', '广东省广宁县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441224', '广东省怀集县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441225', '广东省封开县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441226', '广东省德庆县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441228', '广东省新兴县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441229', '广东省郁南县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441281', '广东省云浮市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441282', '广东省罗定市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441283', '广东省高要市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4412', '441284', '广东省四会市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441300', '广东省惠州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441301', '广东省惠州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441302', '广东省惠州市惠城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441303', '广东省惠州市惠阳区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441321', '广东省惠阳县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441322', '广东省博罗县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441323', '广东省惠东县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4413', '441324', '广东省龙门县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441400', '广东省梅州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441401', '广东省梅州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441402', '广东省梅州市梅江区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441421', '广东省梅县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441422', '广东省大埔县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441423', '广东省丰顺县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441424', '广东省五华县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441425', '广东省兴宁县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441426', '广东省平远县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441427', '广东省蕉岭县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4414', '441481', '广东省梅州市兴宁市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441500', '广东省汕尾市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441501', '广东省汕尾市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441502', '广东省汕尾市城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441521', '广东省海丰县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441522', '广东省陆丰县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441523', '广东省陆河县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4415', '441581', '广东省汕尾市陆丰市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441600', '广东省河源市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441601', '广东省河源市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441602', '广东省河源市源城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441621', '广东省紫金县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441622', '广东省龙川县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441623', '广东省连平县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441624', '广东省和平县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4416', '441625', '广东省东源县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441700', '广东省阳江市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441701', '广东省阳江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441702', '广东省阳江市江城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441721', '广东省阳西县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441722', '广东省阳春县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441723', '广东省阳东县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4417', '441781', '广东省阳江市阳春市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441800', '广东省清远市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441801', '广东省清远市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441802', '广东省清远市清城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441821', '广东省佛冈县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441822', '广东省英德县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441823', '广东省阳山县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441824', '广东省连县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441825', '广东省连山壮族瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441826', '广东省连南瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441827', '广东省清新县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441881', '广东省清远市英德市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4418', '441882', '广东省清远市连州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4419', '441900', '广东省东莞市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4420', '442000', '广东省中山市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4451', '445100', '广东省潮州市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4451', '445101', '广东省潮州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4451', '445102', '广东省潮州市湘桥区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4451', '445121', '广东省潮州市潮安县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4451', '445122', '广东省饶平县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445200', '广东省揭阳市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445201', '广东省揭阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445202', '广东省揭阳市榕城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445221', '广东省揭东县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445222', '广东省揭西县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445224', '广东省惠来县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4452', '445281', '广东省普宁县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445300', '广东省云浮市');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445301', '广东省云浮市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445302', '广东省云浮市云城区');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445321', '广东省云浮市新兴县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445322', '广东省云浮市郁南县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445323', '广东省云浮市云安县');
INSERT INTO `t_pub_areacode` VALUES ('44', '4453', '445381', '广东省云浮市罗定市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4500', '450000', '广西');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450100', '广西南宁市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450101', '广西南宁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450102', '广西南宁市兴宁区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450103', '广西南宁市新城区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450104', '广西南宁市城北区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450105', '广西南宁市江南区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450106', '广西南宁市永新区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450107', '广西壮族自治区南宁市西乡塘区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450108', '广西壮族自治区南宁市良庆区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450109', '广西壮族自治区南宁市邕宁区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450111', '广西南宁市市郊区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450121', '广西邕宁县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450122', '广西武鸣县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450123', '广西壮族自治区南宁市隆安县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450124', '广西壮族自治区南宁市马山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450125', '广西壮族自治区南宁市上林县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450126', '广西壮族自治区南宁市宾阳县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4501', '450127', '广西壮族自治区南宁市横县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450200', '广西柳州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450201', '广西柳州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450202', '广西柳州市城中区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450203', '广西柳州市鱼峰区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450204', '广西柳州市柳南区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450205', '广西柳州市柳北区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450211', '广西柳州市市郊区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450221', '广西柳江县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450222', '广西柳城县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450223', '广西壮族自治区柳州市鹿寨县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450224', '广西壮族自治区柳州市融安县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450225', '广西壮族自治区柳州市融水苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4502', '450226', '广西壮族自治区柳州市三江侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450300', '广西桂林市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450301', '广西桂林市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450302', '广西桂林市秀峰区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450303', '广西桂林市叠彩区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450304', '广西桂林市象山区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450305', '广西桂林市七星区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450311', '广西桂林市市郊区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450321', '广西阳朔县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450322', '广西临桂县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450323', '广西壮族自治区桂林市灵川县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450324', '广西壮族自治区桂林市全州县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450325', '广西壮族自治区桂林市兴安县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450326', '广西壮族自治区桂林市永福县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450327', '广西壮族自治区桂林市灌阳县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450328', '广西壮族自治区桂林市龙胜各族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450329', '广西壮族自治区桂林市资源县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450330', '广西壮族自治区桂林市平乐县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450331', '广西壮族自治区桂林市荔蒲县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4503', '450332', '广西壮族自治区桂林市恭城瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450400', '广西梧州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450401', '广西梧州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450403', '广西梧州市万秀区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450404', '广西梧州市蝶山区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450405', '广西壮族自治区梧州市长洲区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450411', '广西梧州市市郊区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450421', '广西苍梧县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450422', '广西壮族自治区梧州市藤县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450423', '广西壮族自治区梧州市蒙山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4504', '450481', '广西壮族自治区梧州市岑溪市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450500', '广西北海市　');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450501', '广西北海市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450502', '广西北海市海城区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450503', '广西壮族自治区北海市银海区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450511', '广西北海市市郊区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450512', '广西壮族自治区北海市铁山港区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4505', '450521', '广西合浦县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4506', '450600', '广西防城港市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4506', '450601', '广西防城港市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4506', '450602', '广西防城港市港口区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4506', '450603', '广西防城港市防城区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4506', '450621', '广西上思县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4506', '450681', '广西壮族自治区防城港市东兴市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4507', '450700', '广西壮族自治区钦州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4507', '450701', '广西壮族自治区钦州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4507', '450702', '广西壮族自治区钦州市钦南区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4507', '450703', '广西壮族自治区钦州市钦北区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4507', '450721', '广西壮族自治区钦州市灵山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4507', '450722', '广西壮族自治区钦州市浦北县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450800', '广西壮族自治区贵港市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450801', '广西壮族自治区贵港市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450802', '广西壮族自治区贵港市港北区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450803', '广西壮族自治区贵港市港南区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450804', '广西壮族自治区贵港市覃塘区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450821', '广西壮族自治区贵港市平南县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4508', '450881', '广西壮族自治区贵港市桂平市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450900', '广西壮族自治区玉林市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450901', '广西壮族自治区玉林市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450902', '广西壮族自治区玉林市玉州区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450921', '广西壮族自治区玉林市容县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450922', '广西壮族自治区玉林市陆川县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450923', '广西壮族自治区玉林市博白县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450924', '广西壮族自治区玉林市兴业县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4509', '450981', '广西壮族自治区玉林市北流市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451000', '广西壮族自治区百色市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451001', '广西壮族自治区百色市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451002', '广西壮族自治区百色市右江区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451021', '广西壮族自治区百色市田阳县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451022', '广西壮族自治区百色市田东县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451023', '广西壮族自治区百色市平果县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451024', '广西壮族自治区百色市德保县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451025', '广西壮族自治区百色市靖西县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451026', '广西壮族自治区百色市那坡县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451027', '广西壮族自治区百色市凌云县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451028', '广西壮族自治区百色市乐业县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451029', '广西壮族自治区百色市田林县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451030', '广西壮族自治区百色市西林县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4510', '451031', '广西壮族自治区百色市隆林各族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4511', '451100', '广西壮族自治区贺州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4511', '451101', '广西壮族自治区贺州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4511', '451102', '广西壮族自治区贺州市八步区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4511', '451121', '广西壮族自治区贺州市昭平县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4511', '451122', '广西壮族自治区贺州市钟山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4511', '451123', '广西壮族自治区贺州市富川瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451200', '广西壮族自治区河池市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451201', '广西壮族自治区河池市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451202', '广西壮族自治区河池市金城江区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451221', '广西壮族自治区河池市南丹县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451222', '广西壮族自治区河池市天峨县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451223', '广西壮族自治区河池市凤山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451224', '广西壮族自治区河池市东兰县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451225', '广西壮族自治区河池市罗城仫佬族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451226', '广西壮族自治区河池市环江毛南族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451227', '广西壮族自治区河池市巴马瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451228', '广西壮族自治区河池市都安瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451229', '广西壮族自治区河池市大化瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4512', '451281', '广西壮族自治区河池市宜州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451300', '广西壮族自治区来宾市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451301', '广西壮族自治区来宾市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451302', '广西壮族自治区来宾市兴宾区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451321', '广西壮族自治区来宾市忻城县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451322', '广西壮族自治区来宾市象州县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451323', '广西壮族自治区来宾市武宣县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451324', '广西壮族自治区来宾市金秀瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4513', '451381', '广西壮族自治区来宾市合山市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451400', '广西壮族自治区崇左市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451401', '广西壮族自治区崇左市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451402', '广西壮族自治区崇左市江洲区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451421', '广西壮族自治区崇左市扶绥县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451422', '广西壮族自治区崇左市宁明县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451423', '广西壮族自治区崇左市龙州县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451424', '广西壮族自治区崇左市大新县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451425', '广西壮族自治区崇左市天等县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4514', '451481', '广西壮族自治区崇左市凭祥市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452100', '广西南宁地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452101', '广西凭祥市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452122', '广西横县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452123', '广西宾阳县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452124', '广西上林县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452126', '广西隆安县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452127', '广西马山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452128', '广西扶绥县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452129', '广西崇左县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452130', '广西大新县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452131', '广西天等县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452132', '广西宁明县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4521', '452133', '广西龙州县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452200', '广西柳州地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452201', '广西合山市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452223', '广西鹿寨县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452224', '广西象州县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452225', '广西武宣县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452226', '广西来宾县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452227', '广西融安县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452228', '广西三江侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452229', '广西融水苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452230', '广西金秀瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4522', '452231', '广西忻城县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452300', '广西桂林地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452322', '广西灵川县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452323', '广西全州县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452324', '广西兴安县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452325', '广西永福县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452327', '广西灌阳县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452328', '广西龙胜各族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452329', '广西资源县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452330', '广西平乐县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452331', '广西荔浦县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4523', '452332', '广西恭城瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452400', '广西梧州地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452421', '广西岑溪县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452423', '广西藤县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452424', '广西昭平县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452425', '广西蒙山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452426', '广西贺县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452427', '广西钟山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4524', '452428', '广西富川瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452500', '广西玉林地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452501', '广西玉林市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452502', '广西贵港市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452523', '广西桂平县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452524', '广西平南县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452525', '广西容县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452526', '广西北流县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452527', '广西陆川县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4525', '452528', '广西博白县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452600', '广西百色地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452601', '广西百色市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452622', '广西田阳县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452623', '广西田东县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452624', '广西平果县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452625', '广西德保县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452626', '广西靖西县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452627', '广西那坡县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452628', '广西凌云县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452629', '广西乐业县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452630', '广西田林县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452631', '广西隆林各族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4526', '452632', '广西西林县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452700', '广西河池地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452701', '广西河池市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452702', '广西宜州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452723', '广西罗城仫佬族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452724', '广西环江毛南族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452725', '广西南丹县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452726', '广西天峨县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452727', '广西凤山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452728', '广西东兰县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452729', '广西巴马瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452730', '广西都安瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4527', '452731', '广西大化瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4528', '452800', '广西钦州地区');
INSERT INTO `t_pub_areacode` VALUES ('45', '4528', '452802', '广西钦州市');
INSERT INTO `t_pub_areacode` VALUES ('45', '4528', '452824', '广西灵山县');
INSERT INTO `t_pub_areacode` VALUES ('45', '4528', '452826', '广西浦北县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460000', '海南省三亚各市县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460001', '海南省通什市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460002', '海南省琼海市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460003', '海南省儋州市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460021', '海南省琼山县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460022', '海南省文昌县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460024', '海南省万宁县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460025', '海南省定安县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460026', '海南省屯昌县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460027', '海南省澄迈县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460028', '海南省临高县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460030', '海南省白沙黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460031', '海南省昌江黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460032', '海南省东方黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460033', '海南省乐东黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460034', '海南省陵水黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460035', '海南省保亭黎族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460036', '海南省琼中黎族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460037', '海南省西沙群岛');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460038', '海南省南沙群岛');
INSERT INTO `t_pub_areacode` VALUES ('46', '4600', '460039', '海南省中沙群岛的岛礁及其海域');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460100', '海南省海口市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460101', '海南省海口市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460102', '海南省海口市振东区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460103', '海南省海口市新华区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460104', '海南省海口市秀英区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460105', '海南省海口市秀英区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460106', '海南省海口市龙华区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460107', '海南省海口市琼山区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4601', '460108', '海南省海口市美兰区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4602', '460200', '海南省三亚市　　　　　　　');
INSERT INTO `t_pub_areacode` VALUES ('46', '4602', '460201', '海南省三亚市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469000', '海南省省直辖县级行政区划');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469001', '海南省五指山市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469002', '海南省琼海市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469003', '海南省儋州市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469005', '海南省文昌市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469006', '海南省万宁市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469007', '海南省东方市');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469021', '海南省定安县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469022', '海南省屯昌县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469023', '海南省澄迈县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469024', '海南省临高县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469025', '海南省白沙黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469026', '海南省昌江黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469027', '海南省乐东黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469028', '海南省陵水黎族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469029', '海南省保亭黎族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469030', '海南省琼中黎族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469031', '海南省西沙群岛');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469032', '海南省南沙群岛');
INSERT INTO `t_pub_areacode` VALUES ('46', '4690', '469033', '海南省中沙群岛的岛礁及其海域');
INSERT INTO `t_pub_areacode` VALUES ('50', '5000', '500000', '重庆市');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500100', '重庆市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500101', '重庆市万州区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500102', '重庆市涪陵区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500103', '重庆市渝中区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500104', '重庆市大渡口区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500105', '重庆市江北区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500106', '重庆市沙坪坝区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500107', '重庆市九龙坡区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500108', '重庆市南岸区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500109', '重庆市北碚区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500110', '重庆市万盛区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500111', '重庆市双桥区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500112', '重庆市渝北区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500113', '重庆市巴南区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500114', '重庆市黔江区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500115', '重庆市长寿区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500116', '重庆市江津区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500117', '重庆市合川区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500118', '重庆市永川区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5001', '500119', '重庆市南川区');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500200', '重庆市县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500222', '重庆市綦江县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500223', '重庆市潼南县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500224', '重庆市铜梁县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500225', '重庆市大足县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500226', '重庆市荣昌县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500227', '重庆市璧山县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500228', '重庆市梁平县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500229', '重庆市城口县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500230', '重庆市丰都县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500231', '重庆市垫江县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500232', '重庆市武隆县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500233', '重庆市忠县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500234', '重庆市开县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500235', '重庆市云阳县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500236', '重庆市奉节县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500237', '重庆市巫山县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500238', '重庆市巫溪县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500240', '重庆市石柱土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500241', '重庆市秀山土家族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500242', '重庆市酉阳土家族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('50', '5002', '500243', '重庆市彭水苗族土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5100', '510000', '四川省');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510100', '四川省成都市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510101', '四川省成都市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510104', '四川省成都市锦江区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510105', '四川省成都市青羊区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510106', '四川省成都市金牛区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510107', '四川省成都市武候区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510108', '四川省成都市成华区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510112', '四川省成都市龙泉驿区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510113', '四川省成都市青白江区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510114', '四川省成都市新都区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510115', '四川省成都市温江区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510121', '四川省金堂县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510122', '四川省双流县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510123', '四川省温江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510124', '四川省郫县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510125', '四川省新都县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510128', '四川省崇庆县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510129', '四川省大邑县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510130', '四川省邛崃县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510131', '四川省蒲江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510132', '四川省新津县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510181', '四川省都江堰市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510182', '四川省彭州市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510183', '四川省成都市邛崃市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5101', '510184', '四川省成都市崇州市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510200', '四川省重庆市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510201', '四川省重庆市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510202', '四川省重庆市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510203', '四川省重庆市大渡口区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510211', '四川省重庆市江北区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510212', '四川省重庆市沙坪坝区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510213', '四川省重庆市九龙坡区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510214', '四川省重庆市南岸区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510215', '四川省重庆市北碚区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510216', '四川省重庆市万盛区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510217', '四川省重庆市双桥区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510221', '四川省长寿县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510222', '四川省巴县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510223', '四川省綦江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510224', '四川省江北县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510227', '四川省潼南县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510228', '四川省铜梁县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510230', '四川省大足县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510231', '四川省荣昌县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510232', '四川省璧山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510281', '四川省永川市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510282', '四川省江津市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5102', '510283', '四川省合川市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510300', '四川省自贡市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510301', '四川省自贡市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510302', '四川省自贡市自流井区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510303', '四川省自贡市贡井区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510304', '四川省自贡市大安区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510311', '四川省自贡市沿滩区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510321', '四川省荣县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5103', '510322', '四川省富顺县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510400', '四川省攀枝花市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510401', '四川省攀枝花市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510402', '四川省攀枝花市东区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510403', '四川省攀枝花市西区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510411', '四川省攀枝花市仁和区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510421', '四川省米易县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5104', '510422', '四川省盐边县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510500', '四川省泸州市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510501', '四川省泸州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510502', '四川省泸州市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510503', '四川省泸州市纳溪区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510504', '四川省泸州市龙马潭区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510521', '四川省泸县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510522', '四川省合江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510523', '四川省纳溪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510524', '四川省叙永县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5105', '510525', '四川省古蔺县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510600', '四川省德阳市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510601', '四川省德阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510602', '四川省德阳市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510603', '四川省德阳市旌阳区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510622', '四川省绵竹县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510623', '四川省中江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510625', '四川省什邡县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510626', '四川省德阳市罗江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510681', '四川省广汉市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510682', '四川省德阳市什邡市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5106', '510683', '四川省德阳市绵竹市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510700', '四川省绵阳市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510701', '四川省绵阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510703', '四川省绵阳市涪城区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510704', '四川省绵阳市游仙区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510722', '四川省三台县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510723', '四川省盐亭县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510724', '四川省安县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510725', '四川省梓潼县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510726', '四川省北川县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510727', '四川省平武县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5107', '510781', '四川省江油市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510800', '四川省广元市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510801', '四川省广元市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510802', '四川省广元市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510811', '四川省广元市元坝区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510812', '四川省广元市朝天区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510821', '四川省旺苍县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510822', '四川省青川县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510823', '四川省剑阁县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5108', '510824', '四川省苍溪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510900', '四川省遂宁市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510901', '四川省遂宁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510902', '四川省遂宁市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510903', '四川省遂宁市船山区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510904', '四川省遂宁市安居区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510921', '四川省蓬溪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510922', '四川省射洪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5109', '510923', '四川省遂宁市大英县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511000', '四川省内江市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511001', '四川省内江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511002', '四川省内江市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511011', '四川省内江市东兴区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511022', '四川省乐至县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511023', '四川省安岳县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511024', '四川省威远县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511025', '四川省资中县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511027', '四川省简阳县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511028', '四川省隆昌县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5110', '511081', '四川省资阳市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511100', '四川省乐山市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511101', '四川省乐山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511102', '四川省乐山市市中区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511111', '四川省乐山市沙湾区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511112', '四川省乐山市五通桥区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511113', '四川省乐山市金口河区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511121', '四川省仁寿县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511122', '四川省眉山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511123', '四川省犍为县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511124', '四川省井研县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511126', '四川省夹江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511127', '四川省洪雅县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511128', '四川省彭山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511129', '四川省沐川县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511130', '四川省青神县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511131', '四川省丹棱县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511132', '四川省峨边彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511133', '四川省马边彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5111', '511181', '四川省峨眉山市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511200', '四川省万县市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511201', '四川省万县市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511202', '四川省万县市龙宝区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511203', '四川省万县市天城区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511204', '四川省万县市五桥区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511221', '四川省开县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511222', '四川省忠县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511223', '四川省梁平县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511224', '四川省云阳县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511225', '四川省奉节县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511226', '四川省巫山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511227', '四川省巫溪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5112', '511228', '四川省城口县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511300', '四川省南充市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511301', '四川省南充市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511302', '四川省南充市顺庆区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511303', '四川省南充市高坪区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511304', '四川省南充市嘉陵区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511321', '四川省南部县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511322', '四川省营山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511323', '四川省蓬安县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511324', '四川省仪陇县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511325', '四川省西充县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5113', '511381', '四川省阆中市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511400', '四川省眉山市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511401', '四川省眉山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511402', '四川省眉山市东坡区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511421', '四川省眉山市仁寿县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511422', '四川省眉山市彭山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511423', '四川省眉山市洪雅县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511424', '四川省眉山市丹棱县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5114', '511425', '四川省眉山市青神县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511500', '四川省宜宾市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511501', '四川省宜宾市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511502', '四川省宜宾市翠屏区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511521', '四川省宜宾市宜宾县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511522', '四川省宜宾市南溪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511523', '四川省宜宾市江安县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511524', '四川省宜宾市长宁县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511525', '四川省宜宾市高县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511526', '四川省宜宾市珙县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511527', '四川省宜宾市筠连县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511528', '四川省宜宾市兴文县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5115', '511529', '四川省宜宾市屏山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511600', '四川省广安市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511601', '四川省广安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511602', '四川省广安市广安区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511621', '四川省广安市岳池县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511622', '四川省广安市武胜县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511623', '四川省广安市邻水县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5116', '511681', '四川省广安市华莹市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511700', '四川省达州市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511701', '四川省达州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511702', '四川省达州市通川区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511721', '四川省达州市达县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511722', '四川省达州市宣汉县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511723', '四川省达州市开江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511724', '四川省达州市大竹县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511725', '四川省达州市渠县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5117', '511781', '四川省达州市万源市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511800', '四川省雅安市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511801', '四川省雅安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511802', '四川省雅安市雨城区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511821', '四川省雅安市名山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511822', '四川省雅安市荥经县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511823', '四川省雅安市汉源县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511824', '四川省雅安市石棉县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511825', '四川省雅安市天全县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511826', '四川省雅安市芦山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5118', '511827', '四川省雅安市宝兴县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5119', '511900', '四川省巴中市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5119', '511901', '四川省巴中市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5119', '511902', '四川省巴中市巴州区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5119', '511921', '四川省巴中市通江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5119', '511922', '四川省巴中市南江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5119', '511923', '四川省巴中市平昌县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5120', '512000', '四川省资阳市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5120', '512001', '四川省资阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5120', '512002', '四川省资阳市雁江区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5120', '512021', '四川省资阳市安岳县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5120', '512022', '四川省资阳市乐至县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5120', '512081', '四川省资阳市简阳市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5123', '512300', '四川省涪陵地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5123', '512301', '四川省涪陵市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5123', '512322', '四川省垫江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5123', '512323', '四川省南川县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5123', '512324', '四川省丰都县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5123', '512326', '四川省武隆县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512500', '四川省宜宾地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512501', '四川省宜宾市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512527', '四川省宜宾县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512528', '四川省南溪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512529', '四川省江安县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512530', '四川省长宁县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512531', '四川省高县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512532', '四川省筠连县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512533', '四川省珙县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512534', '四川省兴文县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5125', '512535', '四川省屏山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513000', '四川省达川地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513001', '四川省达川市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513002', '四川省万源县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513021', '四川省达县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513022', '四川省宣汉县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513023', '四川省开江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513029', '四川省大竹县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5130', '513030', '四川省渠县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513100', '四川省雅安地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513101', '四川省雅安市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513122', '四川省名山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513123', '四川省荥经县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513124', '四川省汉源县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513125', '四川省石棉县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513126', '四川省天全县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513127', '四川省芦山县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5131', '513128', '四川省宝兴县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513200', '四川省阿坝藏族羌族自治州');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513221', '四川省汶川县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513222', '四川省理县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513223', '四川省茂县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513224', '四川省松潘县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513225', '四川省南坪县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513226', '四川省金川县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513227', '四川省小金县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513228', '四川省黑水县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513229', '四川省马尔康县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513230', '四川省壤塘县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513231', '四川省阿坝县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513232', '四川省若尔盖县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5132', '513233', '四川省红原县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513300', '四川省甘孜藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513321', '四川省康定县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513322', '四川省泸定县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513323', '四川省丹巴县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513324', '四川省九龙县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513325', '四川省雅江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513326', '四川省道孚县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513327', '四川省炉霍县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513328', '四川省甘孜县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513329', '四川省新龙县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513330', '四川省德格县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513331', '四川省白玉县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513332', '四川省石渠县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513333', '四川省色达县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513334', '四川省理塘县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513335', '四川省巴塘县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513336', '四川省乡城县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513337', '四川省稻城县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5133', '513338', '四川省得荣县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513400', '四川省凉山彝族自治州');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513401', '四川省西昌市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513422', '四川省木里藏族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513423', '四川省盐源县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513424', '四川省德昌县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513425', '四川省会理县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513426', '四川省会东县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513427', '四川省宁南县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513428', '四川省普格县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513429', '四川省布拖县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513430', '四川省金阳县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513431', '四川省昭觉县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513432', '四川省喜德县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513433', '四川省冕宁县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513434', '四川省越西县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513435', '四川省甘洛县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513436', '四川省美姑县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5134', '513437', '四川省雷波县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5135', '513500', '四川省黔江地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5135', '513521', '四川省石柱土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5135', '513522', '四川省秀山土家族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5135', '513523', '四川省黔江土家族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5135', '513524', '四川省酉阳土家族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5135', '513525', '四川省彭水苗族土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5136', '513600', '四川省广安地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5136', '513601', '四川省华蓥市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5136', '513621', '四川省岳池县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5136', '513622', '四川省广安县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5136', '513623', '四川省武胜县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5136', '513624', '四川省邻水县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5137', '513700', '四川省巴中地区');
INSERT INTO `t_pub_areacode` VALUES ('51', '5137', '513701', '四川省巴中市');
INSERT INTO `t_pub_areacode` VALUES ('51', '5137', '513721', '四川省通江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5137', '513722', '四川省南江县');
INSERT INTO `t_pub_areacode` VALUES ('51', '5137', '513723', '四川省平昌县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5200', '520000', '贵州省');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520100', '贵州省贵阳市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520101', '贵州省贵阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520102', '贵州省贵阳市南明区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520103', '贵州省贵阳市云岩区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520111', '贵州省贵阳市花溪区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520112', '贵州省贵阳市乌当区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520113', '贵州省贵阳市白云区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520114', '贵州省贵阳市小河区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520121', '贵州省贵阳市开阳县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520122', '贵州省贵阳市息烽县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520123', '贵州省贵阳市修文县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5201', '520181', '贵州省贵阳市清镇市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5202', '520200', '贵州省六盘水市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5202', '520201', '贵州省六盘水市钟山区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5202', '520202', '贵州省六盘水市盘县特区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5202', '520203', '贵州省六盘水市六枝特区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5202', '520221', '贵州省水城县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5202', '520222', '贵州省六盘水市盘县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520300', '贵州省遵义市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520301', '贵州省遵义市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520302', '贵州省遵义市红花岗区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520303', '贵州省遵义市汇川区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520321', '贵州省遵义市遵义县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520322', '贵州省遵义市桐梓县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520323', '贵州省遵义市绥阳县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520324', '贵州省遵义市正安县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520325', '贵州省遵义市道真仡佬族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520326', '贵州省遵义市务川仡佬族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520327', '贵州省遵义市凤冈县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520328', '贵州省遵义市湄潭县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520329', '贵州省遵义市余庆县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520330', '贵州省遵义市习水县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520381', '贵州省遵义市赤水市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5203', '520382', '贵州省遵义市仁怀市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520400', '贵州省安顺市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520401', '贵州省安顺市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520402', '贵州省安顺市西秀区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520421', '贵州省安顺市平坝县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520422', '贵州省安顺市普定县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520423', '贵州省安顺市镇宁布依族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520424', '贵州省安顺市关岭布依族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5204', '520425', '贵州省安顺市紫云苗族布依族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522100', '贵州省遵义地区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522101', '贵州省遵义市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522102', '贵州省赤水市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522121', '贵州省遵义县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522122', '贵州省桐梓县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522123', '贵州省绥阳县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522124', '贵州省正安县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522125', '贵州省道真仡佬苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522126', '贵州省务川仡佬苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522127', '贵州省凤冈县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522128', '贵州省湄潭县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522129', '贵州省余庆县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522130', '贵州省仁怀县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5221', '522132', '贵州省习水县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522200', '贵州省铜仁地区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522201', '贵州省铜仁市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522222', '贵州省江口县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522223', '贵州省玉屏侗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522224', '贵州省石阡县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522225', '贵州省思南县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522226', '贵州省印江土家族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522227', '贵州省德江县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522228', '贵州省沿河土家族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522229', '贵州省松桃苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5222', '522230', '贵州省万山特区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522300', '贵州省黔西南布依族苗族自治州');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522301', '贵州省兴义市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522322', '贵州省兴仁县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522323', '贵州省普安县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522324', '贵州省晴隆县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522325', '贵州省贞丰县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522326', '贵州省望谟县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522327', '贵州省册亨县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5223', '522328', '贵州省安龙县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522400', '贵州省毕节地区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522401', '贵州省毕节市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522422', '贵州省大方县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522423', '贵州省黔西县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522424', '贵州省金沙县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522425', '贵州省织金县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522426', '贵州省纳雍县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522427', '贵州省威宁彝族回族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5224', '522428', '贵州省赫章县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522500', '贵州省安顺地区');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522501', '贵州省安顺市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522502', '贵州省清镇市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522522', '贵州省开阳县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522523', '贵州省息烽县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522524', '贵州省修文县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522526', '贵州省平坝县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522527', '贵州省普定县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522528', '贵州省关岭布依族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522529', '贵州省镇宁布依族苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5225', '522530', '贵州省紫云苗族布依族自治县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522600', '贵州省黔东南苗族侗族自治州');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522601', '贵州省凯里市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522622', '贵州省黄平县　');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522623', '贵州省施秉县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522624', '贵州省三穗县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522625', '贵州省镇远县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522626', '贵州省岑巩县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522627', '贵州省天柱县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522628', '贵州省锦屏县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522629', '贵州省剑河县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522630', '贵州省台江县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522631', '贵州省黎平县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522632', '贵州省榕江县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522633', '贵州省从江县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522634', '贵州省雷山县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522635', '贵州省麻江县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5226', '522636', '贵州省丹寨县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522700', '贵州省黔南布依族苗族自治州');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522701', '贵州省都匀市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522702', '贵州省黔南布依族苗族自治州福泉市');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522722', '贵州省荔波县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522723', '贵州省贵定县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522724', '贵州省福泉县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522725', '贵州省瓮安县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522726', '贵州省独山县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522727', '贵州省平塘县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522728', '贵州省罗甸县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522729', '贵州省长顺县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522730', '贵州省龙里县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522731', '贵州省惠水县');
INSERT INTO `t_pub_areacode` VALUES ('52', '5227', '522732', '贵州省三都水族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5300', '530000', '云南省');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530100', '云南省昆明市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530101', '云南省昆明市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530102', '云南省昆明市五华区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530103', '云南省昆明市盘龙区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530111', '云南省昆明市官渡区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530112', '云南省昆明市西山区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530113', '云南省昆明市东川区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530121', '云南省呈贡县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530122', '云南省晋宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530123', '云南省安宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530124', '云南省富民县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530125', '云南省宜良县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530126', '云南省路南彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530127', '云南省嵩明县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530128', '云南省禄劝彝族苗族自治区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530129', '云南省昆明市寻甸回族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5301', '530181', '云南省昆明市安宁市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5302', '530200', '云南省东川市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5302', '530201', '云南省东川市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530300', '云南省曲靖市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530301', '云南省曲靖市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530302', '云南省曲靖市麒麟区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530321', '云南省曲靖市马龙县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530322', '云南省曲靖市陆良县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530323', '云南省曲靖市师宗县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530324', '云南省曲靖市罗平县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530325', '云南省曲靖市富源县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530326', '云南省曲靖市会泽县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530328', '云南省曲靖市沾益县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5303', '530381', '云南省曲靖市宣威市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530400', '云南省玉溪市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530401', '云南省玉溪市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530402', '云南省玉溪市红塔区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530421', '云南省玉溪市江川县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530422', '云南省玉溪市澄江县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530423', '云南省玉溪市通海县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530424', '云南省玉溪市华宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530425', '云南省玉溪市易门县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530426', '云南省玉溪市峨山彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530427', '云南省玉溪市新平彝族傣族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5304', '530428', '云南省玉溪市元江哈尼族彝族傣族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530500', '云南省保山市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530501', '云南省保山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530502', '云南省保山市隆阳区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530521', '云南省保山市施甸县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530522', '云南省保山市腾冲县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530523', '云南省保山市龙陵县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5305', '530524', '云南省保山市昌宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530600', '云南省昭通市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530601', '云南省昭通市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530602', '云南省昭通市昭阳区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530621', '云南省昭通市鲁甸县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530622', '云南省昭通市巧家县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530623', '云南省昭通市盐津县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530624', '云南省昭通市大关县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530625', '云南省昭通市永善县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530626', '云南省昭通市绥江县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530627', '云南省昭通市镇雄县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530628', '云南省昭通市彝良县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530629', '云南省昭通市威信县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5306', '530630', '云南省昭通市水富县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530700', '云南省丽江市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530701', '云南省丽江市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530702', '云南省丽江市古城区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530721', '云南省丽江市玉龙纳西族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530722', '云南省丽江市永胜县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530723', '云南省丽江市华坪县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5307', '530724', '云南省丽江市宁蒗彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530800', '云南省普洱市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530801', '云南省普洱市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530802', '云南省普洱市思茅区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530821', '云南省普洱市宁洱哈尼族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530822', '云南省普洱市墨江哈尼族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530823', '云南省普洱市景东彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530824', '云南省普洱市景谷傣族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530825', '云南省普洱市镇沅彝族哈尼族拉祜族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530826', '云南省普洱市江城哈尼族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530827', '云南省普洱市孟连傣族拉祜族佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530828', '云南省普洱市澜沧拉祜族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5308', '530829', '云南省普洱市西盟佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530900', '云南省临沧市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530901', '云南省临沧市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530902', '云南省临沧市临翔区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530921', '云南省临沧市凤庆县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530922', '云南省临沧市云县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530923', '云南省临沧市永德县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530924', '云南省临沧市镇康县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530925', '云南省临沧市双江拉祜族佤族布朗族傣族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530926', '云南省临沧市耿马傣族佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5309', '530927', '云南省临沧市沧源佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532100', '云南省昭通地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532101', '云南省昭通市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532122', '云南省鲁甸县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532123', '云南省巧家县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532124', '云南省盐津县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532125', '云南省大关县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532126', '云南省永善县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532127', '云南省绥江县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532128', '云南省镇雄县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532129', '云南省彝良县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532130', '云南省威信县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5321', '532131', '云南省水富县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532200', '云南省曲靖地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532201', '云南省曲靖市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532223', '云南省马龙县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532224', '云南省宜威县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532225', '云南省富源县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532226', '云南省罗平县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532227', '云南省师宗县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532228', '云南省陆良县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532231', '云南省寻甸回族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5322', '532233', '云南省会泽县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532300', '云南省楚雄彝族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532301', '云南省楚雄市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532322', '云南省双柏县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532323', '云南省牟定县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532324', '云南省南华县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532325', '云南省姚安县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532326', '云南省大姚县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532327', '云南省永仁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532328', '云南省元谋县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532329', '云南省武定县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5323', '532331', '云南省禄丰县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532400', '云南省玉溪地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532401', '云南省玉溪市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532422', '云南省江川县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532423', '云南省澄江县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532424', '云南省通海县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532425', '云南省华宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532426', '云南省易门县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532427', '云南省峨山彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532428', '云南省新平彝族傣族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5324', '532429', '云南省元江哈尼族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532500', '云南省红河哈尼族彝族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532501', '云南省个旧市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532502', '云南省开远市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532522', '云南省蒙自县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532523', '云南省屏边苗族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532524', '云南省建水县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532525', '云南省石屏县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532526', '云南省弥勒县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532527', '云南省泸西县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532528', '云南省元阳县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532529', '云南省红河县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532530', '云南省金平苗族瑶族傣族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532531', '云南省绿春县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5325', '532532', '云南省河口瑶族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532600', '云南省文山壮族苗族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532621', '云南省文山县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532622', '云南省砚山县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532623', '云南省西畴县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532624', '云南省麻栗坡县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532625', '云南省马关县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532626', '云南省丘北县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532627', '云南省广南县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5326', '532628', '云南省富宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532700', '云南省思茅地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532701', '云南省思茅市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532722', '云南省普洱哈尼族继族自治区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532723', '云南省墨江哈尼族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532724', '云南省景东彝族自治区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532725', '云南省景谷傣族彝族自治区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532726', '云南省镇沅彝族哈尼族拉祜族自治');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532727', '云南省江城哈尼族彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532728', '云南省孟连傣族拉祜族佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532729', '云南省澜沧拉祜族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5327', '532730', '云南省西盟佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5328', '532800', '云南省西双版纳傣族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5328', '532801', '云南省景洪市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5328', '532822', '云南省勐海县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5328', '532823', '云南省勐腊县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532900', '云南省大理白族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532901', '云南省大理市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532922', '云南省漾濞彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532923', '云南省祥云县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532924', '云南省宾川县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532925', '云南省弥渡县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532926', '云南省南涧彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532927', '云南省巍山彝族回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532928', '云南省永平县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532929', '云南省云龙县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532930', '云南省洱源县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532931', '云南省剑川县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5329', '532932', '云南省鹤庆县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5330', '533000', '云南省保山地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5330', '533001', '云南省保山市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5330', '533022', '云南省施甸县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5330', '533023', '云南省腾冲县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5330', '533024', '云南省龙陵县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5330', '533025', '云南省昌宁县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533100', '云南省德宏傣族景颇族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533101', '云南省畹町市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533102', '云南省瑞丽市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533103', '云南省德宏傣族景颇族自治州潞西市');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533121', '云南省潞西县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533122', '云南省梁河县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533123', '云南省盈江县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5331', '533124', '云南省陇川县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5332', '533200', '云南省丽江地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5332', '533221', '云南省丽江纳西族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5332', '533222', '云南省永胜县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5332', '533223', '云南省华坪县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5332', '533224', '云南省宁蒗彝族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5333', '533300', '云南省怒江傈僳族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5333', '533321', '云南省泸水县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5333', '533323', '云南省福贡县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5333', '533324', '云南省贡山独龙族怒族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5333', '533325', '云南省兰坪白族普米族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5334', '533400', '云南省迪庆藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('53', '5334', '533421', '云南省中甸县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5334', '533422', '云南省德钦县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5334', '533423', '云南省维西傈傈族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533500', '云南省临沧地区');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533521', '云南省临沧县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533522', '云南省凤庆县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533523', '云南省云县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533524', '云南省永德县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533525', '云南省镇康县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533526', '云南省双江拉祜族佤族布朗族傣族');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533527', '云南省耿马傣族佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('53', '5335', '533528', '云南省沧源佤族自治县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5400', '540000', '西藏自治区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540100', '西藏拉萨市');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540101', '西藏拉萨市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540102', '西藏拉萨市城关区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540121', '西藏林周县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540122', '西藏当雄县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540123', '西藏尼木县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540124', '西藏曲水县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540125', '西藏堆龙德庆县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540126', '西藏达孜县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5401', '540127', '西藏墨竹工卡县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542100', '西藏昌都地区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542121', '西藏昌都县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542122', '西藏江达县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542123', '西藏贡觉县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542124', '西藏类乌齐县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542125', '西藏丁青县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542126', '西藏察雅县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542127', '西藏八宿县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542128', '西藏左贡县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542129', '西藏芒康县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542132', '西藏洛隆县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542133', '西藏边坝县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542134', '西藏盐井县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542135', '西藏碧土县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542136', '西藏妥坝县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5421', '542137', '西藏生达县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542200', '西藏山南地区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542221', '西藏乃东县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542222', '西藏扎襄县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542223', '西藏贡嘎县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542224', '西藏桑日县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542225', '西藏琼结县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542226', '西藏曲松县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542227', '西藏措美县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542228', '西藏洛扎县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542229', '西藏加查县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542231', '西藏隆子县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542232', '西藏错那县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5422', '542233', '西藏浪卡子县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542300', '西藏日喀则地区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542301', '西藏日喀则市');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542322', '西藏南木林县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542323', '西藏江孜县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542324', '西藏定日县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542325', '西藏萨迦县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542326', '西藏拉孜县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542327', '西藏昂仁县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542328', '西藏谢通门县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542329', '西藏白朗县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542330', '西藏仁布县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542331', '西藏康马县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542332', '西藏定结县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542333', '西藏仲巴县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542334', '西藏亚东县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542335', '西藏吉隆县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542336', '西藏聂拉木县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542337', '西藏萨嘎县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5423', '542338', '西藏岗巴县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542400', '西藏那曲地区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542421', '西藏那曲县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542422', '西藏嘉黎县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542423', '西藏比如县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542424', '西藏聂荣县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542425', '西藏安多县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542426', '西藏申扎县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542427', '西藏索县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542428', '西藏班戈县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542429', '西藏巴青县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5424', '542430', '西藏尼玛县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542500', '西藏阿里地区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542521', '西藏普兰县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542522', '西藏札达县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542523', '西藏噶尔县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542524', '西藏日土县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542525', '西藏革吉县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542526', '西藏改则县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542527', '西藏措勤县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5425', '542528', '西藏隆格尔县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542600', '西藏林芝地区');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542621', '西藏林芝县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542622', '西藏工布江达县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542623', '西藏米林县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542624', '西藏墨脱县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542625', '西藏波密县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542626', '西藏察隅县');
INSERT INTO `t_pub_areacode` VALUES ('54', '5426', '542627', '西藏朗县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6100', '610000', '陕西省');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610100', '陕西省西安市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610101', '陕西省西安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610102', '陕西省西安市新城区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610103', '陕西省西安市碑林区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610104', '陕西省西安市莲湖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610111', '陕西省西安市灞桥区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610112', '陕西省西安市未央区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610113', '陕西省西安市雁塔区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610114', '陕西省西安市阎良区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610115', '陕西省西安市临潼区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610116', '陕西省西安市长安区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610121', '陕西省长安县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610122', '陕西省蓝田县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610123', '陕西省临潼县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610124', '陕西省周至县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610125', '陕西省户县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6101', '610126', '陕西省高陵县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610200', '陕西省铜川市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610201', '陕西省铜川市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610202', '陕西省铜川市城区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610203', '陕西省铜川市郊区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610204', '陕西省铜川市耀州区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610221', '陕西省耀县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6102', '610222', '陕西省宜君县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610300', '陕西省宝鸡市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610301', '陕西省宝鸡市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610302', '陕西省宝鸡市渭滨区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610303', '陕西省宝鸡市金台区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610304', '陕西省宝鸡市陈仓区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610321', '陕西省宝鸡县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610322', '陕西省凤翔县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610323', '陕西省岐山县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610324', '陕西省扶风县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610326', '陕西省眉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610327', '陕西省陇县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610328', '陕西省千阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610329', '陕西省麟游县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610330', '陕西省凤县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6103', '610331', '陕西省太白县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610400', '陕西省咸阳市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610401', '陕西省咸阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610402', '陕西省咸阳市秦都区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610403', '陕西省咸阳市杨陵区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610404', '陕西省咸阳市渭城区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610422', '陕西省三原县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610423', '陕西省泾阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610424', '陕西省乾县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610425', '陕西省礼泉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610426', '陕西省永寿县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610427', '陕西省彬县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610428', '陕西省长武县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610429', '陕西省旬邑县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610430', '陕西省淳化县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610431', '陕西省武功县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6104', '610481', '陕西省兴平市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610500', '陕西省渭南市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610501', '陕西省渭南市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610502', '陕西省渭南市临渭区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610521', '陕西省渭南市华县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610522', '陕西省渭南市潼关县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610523', '陕西省渭南市大荔县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610524', '陕西省渭南市合阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610525', '陕西省渭南市澄城县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610526', '陕西省渭南市蒲城县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610527', '陕西省渭南市白水县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610528', '陕西省渭南市富平县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610581', '陕西省渭南市韩城市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6105', '610582', '陕西省渭南市华阴市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610600', '陕西省延安市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610601', '陕西省延安市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610602', '陕西省延安市宝塔区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610621', '陕西省延安市延长县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610622', '陕西省延安市延川县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610623', '陕西省延安市子长县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610624', '陕西省延安市安塞县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610625', '陕西省延安市志丹县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610626', '陕西省延安市吴起县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610627', '陕西省延安市甘泉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610628', '陕西省延安市富县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610629', '陕西省延安市洛川县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610630', '陕西省延安市宜川县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610631', '陕西省延安市黄龙县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6106', '610632', '陕西省延安市黄陵县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610700', '陕西省汉中市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610701', '陕西省汉中市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610702', '陕西省汉中市汉台区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610721', '陕西省汉中市南郑县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610722', '陕西省汉中市城固县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610723', '陕西省汉中市洋县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610724', '陕西省汉中市西乡县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610725', '陕西省汉中市勉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610726', '陕西省汉中市宁强县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610727', '陕西省汉中市略阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610728', '陕西省汉中市镇巴县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610729', '陕西省汉中市留坝县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6107', '610730', '陕西省汉中市佛坪县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610800', '陕西省榆林市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610801', '陕西省榆林市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610802', '陕西省榆林市榆阳区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610821', '陕西省榆林市神木县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610822', '陕西省榆林市府谷县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610823', '陕西省榆林市横山县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610824', '陕西省榆林市靖边县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610825', '陕西省榆林市定边县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610826', '陕西省榆林市绥德县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610827', '陕西省榆林市米脂县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610828', '陕西省榆林市佳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610829', '陕西省榆林市吴堡县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610830', '陕西省榆林市清涧县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6108', '610831', '陕西省榆林市子洲县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610900', '陕西省安康市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610901', '陕西省安康市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610902', '陕西省安康市汉滨区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610921', '陕西省安康市汉阴县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610922', '陕西省安康市石泉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610923', '陕西省安康市宁陕县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610924', '陕西省安康市紫阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610925', '陕西省安康市岚皋县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610926', '陕西省安康市平利县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610927', '陕西省安康市镇坪县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610928', '陕西省安康市旬阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6109', '610929', '陕西省安康市白河县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611000', '陕西省商洛市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611001', '陕西省商洛市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611002', '陕西省商洛市商州区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611021', '陕西省商洛市洛南县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611022', '陕西省商洛市丹凤县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611023', '陕西省商洛市商南县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611024', '陕西省商洛市山阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611025', '陕西省商洛市镇安县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6110', '611026', '陕西省商洛市柞水县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612100', '陕西省渭南地区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612101', '陕西省渭南市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612102', '陕西省韩城市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612103', '陕西省华阴市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612124', '陕西省华县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612126', '陕西省潼关县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612127', '陕西省大荔县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612128', '陕西省蒲城县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612129', '陕西省澄城县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612130', '陕西省白水县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612132', '陕西省合阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6121', '612133', '陕西省富平县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612300', '陕西省汉中地区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612301', '陕西省汉中市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612321', '陕西省南郑县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612322', '陕西省城固县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612323', '陕西省洋县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612324', '陕西省西乡县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612325', '陕西省勉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612326', '陕西省宁强县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612327', '陕西省略阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612328', '陕西省镇巴县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612329', '陕西省留坝县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6123', '612330', '陕西省佛坪县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612400', '陕西省安康地区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612401', '陕西省安康市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612422', '陕西省汉阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612423', '陕西省石泉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612424', '陕西省宁陕县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612425', '陕西省紫阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612426', '陕西省岚皋县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612427', '陕西省平利县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612428', '陕西省镇坪县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612429', '陕西省旬阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6124', '612430', '陕西省白河县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612500', '陕西省商洛地区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612501', '陕西省商州市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612522', '陕西省洛南县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612523', '陕西省丹风县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612524', '陕西省商南县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612525', '陕西省山阳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612526', '陕西省镇安县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6125', '612527', '陕西省柞水县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612600', '陕西省延安地区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612601', '陕西省延安市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612621', '陕西省延长县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612622', '陕西省延川县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612623', '陕西省子长县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612624', '陕西省安塞县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612625', '陕西省志丹县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612626', '陕西省吴旗县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612627', '陕西省甘泉县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612628', '陕西省富县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612629', '陕西省洛川县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612630', '陕西省宜川县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612631', '陕西省黄龙县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6126', '612632', '陕西省黄陵县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612700', '陕西省榆林地区');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612701', '陕西省榆林市');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612722', '陕西省神木县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612723', '陕西省府谷县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612724', '陕西省横山县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612725', '陕西省靖边县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612726', '陕西省定边县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612727', '陕西省绥德县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612728', '陕西省米脂县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612729', '陕西省佳县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612730', '陕西省吴堡县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612731', '陕西省清涧县');
INSERT INTO `t_pub_areacode` VALUES ('61', '6127', '612732', '陕西省子洲县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6200', '620000', '甘肃省');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620100', '甘肃省兰州市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620101', '甘肃省兰州市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620102', '甘肃省兰州市城关区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620103', '甘肃省兰州市七里河区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620104', '甘肃省兰州市西固区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620105', '甘肃省兰州市安宁区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620111', '甘肃省兰州市红古区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620121', '甘肃省永登县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620122', '甘肃省皋兰县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6201', '620123', '甘肃省榆中县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6202', '620200', '甘肃省嘉峪关市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6202', '620201', '甘肃省嘉峪关市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6203', '620300', '甘肃省金昌市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6203', '620301', '甘肃省金昌市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6203', '620302', '甘肃省金昌市金川区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6203', '620321', '甘肃省永昌县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620400', '甘肃省白银市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620401', '甘肃省白银市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620402', '甘肃省白银市白银区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620403', '甘肃省白银市平川区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620421', '甘肃省清远县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620422', '甘肃省会宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6204', '620423', '甘肃省景泰县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620500', '甘肃省天水市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620501', '甘肃省天水市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620502', '甘肃省天水市秦城区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620503', '甘肃省天水市北道区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620521', '甘肃省清水县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620522', '甘肃省秦安县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620523', '甘肃省甘谷县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620524', '甘肃省武山县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6205', '620525', '甘肃省张家川回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6206', '620600', '甘肃省武威市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6206', '620601', '甘肃省武威市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6206', '620602', '甘肃省武威市凉州区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6206', '620621', '甘肃省武威市民勤县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6206', '620622', '甘肃省武威市古浪县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6206', '620623', '甘肃省武威市天祝藏族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620700', '甘肃省张掖市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620701', '甘肃省张掖市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620702', '甘肃省张掖市甘州区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620721', '甘肃省张掖市肃南裕固族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620722', '甘肃省张掖市民乐县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620723', '甘肃省张掖市临泽县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620724', '甘肃省张掖市高台县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6207', '620725', '甘肃省张掖市山丹县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620800', '甘肃省平凉市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620801', '甘肃省平凉市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620802', '甘肃省平凉市崆峒区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620821', '甘肃省平凉市泾川县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620822', '甘肃省平凉市灵台县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620823', '甘肃省平凉市崇信县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620824', '甘肃省平凉市华亭县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620825', '甘肃省平凉市庄浪县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6208', '620826', '甘肃省平凉市静宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620900', '甘肃省酒泉市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620901', '甘肃省酒泉市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620902', '甘肃省酒泉市肃州区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620921', '甘肃省酒泉市金塔县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620922', '甘肃省酒泉市瓜州县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620923', '甘肃省酒泉市肃北蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620924', '甘肃省酒泉市阿克塞哈萨克族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620981', '甘肃省酒泉市玉门市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6209', '620982', '甘肃省酒泉市敦煌市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621000', '甘肃省庆阳市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621001', '甘肃省庆阳市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621002', '甘肃省庆阳市西峰区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621021', '甘肃省庆阳市庆城县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621022', '甘肃省庆阳市环县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621023', '甘肃省庆阳市华池县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621024', '甘肃省庆阳市合水县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621025', '甘肃省庆阳市正宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621026', '甘肃省庆阳市宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6210', '621027', '甘肃省庆阳市镇原县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621100', '甘肃省定西市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621101', '甘肃省定西市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621102', '甘肃省定西市安定区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621121', '甘肃省定西市通渭县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621122', '甘肃省定西市陇西县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621123', '甘肃省定西市渭源县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621124', '甘肃省定西市临洮县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621125', '甘肃省定西市漳县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6211', '621126', '甘肃省定西市岷县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621200', '甘肃省陇南市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621201', '甘肃省陇南市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621202', '甘肃省陇南市武都区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621221', '甘肃省陇南市成县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621222', '甘肃省陇南市文县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621223', '甘肃省陇南市宕昌县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621224', '甘肃省陇南市康县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621225', '甘肃省陇南市西和县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621226', '甘肃省陇南市礼县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621227', '甘肃省陇南市徽县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6212', '621228', '甘肃省陇南市两当县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622100', '甘肃省酒泉地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622101', '甘肃省玉门市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622102', '甘肃省酒泉市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622103', '甘肃省敦煌市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622123', '甘肃省金塔县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622124', '甘肃省肃北蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622125', '甘肃省阿克塞哈萨克族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6221', '622126', '甘肃省安西县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622200', '甘肃省张掖地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622201', '甘肃省张掖市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622222', '甘肃省肃南裕固族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622223', '甘肃省民乐县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622224', '甘肃省临泽县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622225', '甘肃省高台县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6222', '622226', '甘肃省山丹县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6223', '622300', '甘肃省武威地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6223', '622301', '甘肃省武威市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6223', '622322', '甘肃省民勤县　');
INSERT INTO `t_pub_areacode` VALUES ('62', '6223', '622323', '甘肃省古浪县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6223', '622326', '甘肃省天祝藏族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622400', '甘肃省定西地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622421', '甘肃省定西县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622424', '甘肃省通渭县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622425', '甘肃省陇西县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622426', '甘肃省渭源县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622427', '甘肃省临洮县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622428', '甘肃省漳县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6224', '622429', '甘肃省岷县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622600', '甘肃省陇南地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622621', '甘肃省武都县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622623', '甘肃省宕昌县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622624', '甘肃省成县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622625', '甘肃省康县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622626', '甘肃省文县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622627', '甘肃省西和县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622628', '甘肃省礼县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622629', '甘肃省两当县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6226', '622630', '甘肃省徽县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622700', '甘肃省平凉地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622701', '甘肃省平凉市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622722', '甘肃省泾川县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622723', '甘肃省灵台县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622724', '甘肃省崇信县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622725', '甘肃省华亭县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622726', '甘肃省庄浪县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6227', '622727', '甘肃省静宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622800', '甘肃省庆阳地区');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622801', '甘肃省西峰市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622821', '甘肃省庆阳县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622822', '甘肃省环县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622823', '甘肃省华池县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622824', '甘肃省合水县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622825', '甘肃省正宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622826', '甘肃省宁县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6228', '622827', '甘肃省镇原县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622900', '甘肃省临夏回族自治州');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622901', '甘肃省临夏市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622921', '甘肃省临夏县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622922', '甘肃省康乐县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622923', '甘肃省永靖县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622924', '甘肃省广河县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622925', '甘肃省和政县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622926', '甘肃省东乡族自治县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6229', '622927', '甘肃省积石山保安族东乡族撒拉族');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623000', '甘肃省甘南藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623001', '甘肃省甘南藏族自治州合作市');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623021', '甘肃省临潭县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623022', '甘肃省卓尼县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623023', '甘肃省舟曲县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623024', '甘肃省迭部县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623025', '甘肃省玛曲县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623026', '甘肃省碌曲县');
INSERT INTO `t_pub_areacode` VALUES ('62', '6230', '623027', '甘肃省夏河县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6300', '630000', '青海省');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630100', '青海省西宁市');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630101', '青海省西宁市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630102', '青海省西宁市城东区');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630103', '青海省西宁市城中区');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630104', '青海省西宁市城西区');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630105', '青海省西宁市城北区');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630121', '青海省大通回族土族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630122', '青海省西宁市湟中县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6301', '630123', '青海省西宁市湟源县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632100', '青海省海东地区');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632121', '青海省平安县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632122', '青海省民和回族土族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632123', '青海省乐都县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632124', '青海省湟中县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632125', '青海省湟源县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632126', '青海省互助土族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632127', '青海省化隆回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6321', '632128', '青海省循化撒拉族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6322', '632200', '青海省海北藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('63', '6322', '632221', '青海省门源回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6322', '632222', '青海省祁连县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6322', '632223', '青海省海晏县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6322', '632224', '青海省刚察县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6323', '632300', '青海省黄南藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('63', '6323', '632321', '青海省同仁县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6323', '632322', '青海省尖扎县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6323', '632323', '青海省泽库县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6323', '632324', '青海省河南蒙古族自治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6325', '632500', '青海省海南藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('63', '6325', '632521', '青海省共和县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6325', '632522', '青海省同德县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6325', '632523', '青海省贵德县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6325', '632524', '青海省兴海县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6325', '632525', '青海省贵南县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632600', '青海省果洛藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632621', '青海省玛沁县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632622', '青海省班玛县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632623', '青海省甘德县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632624', '青海省达日县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632625', '青海省久治县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6326', '632626', '青海省玛多县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632700', '青海省玉树藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632721', '青海省玉树县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632722', '青海省杂多县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632723', '青海省称多县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632724', '青海省治多县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632725', '青海省囊谦县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6327', '632726', '青海省曲麻莱县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6328', '632800', '青海省海西蒙古族藏族自治州');
INSERT INTO `t_pub_areacode` VALUES ('63', '6328', '632801', '青海省格尔木市');
INSERT INTO `t_pub_areacode` VALUES ('63', '6328', '632802', '青海省德令哈市');
INSERT INTO `t_pub_areacode` VALUES ('63', '6328', '632821', '青海省乌兰县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6328', '632822', '青海省都兰县');
INSERT INTO `t_pub_areacode` VALUES ('63', '6328', '632823', '青海省天峻县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6400', '640000', '宁夏');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640100', '宁夏银川市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640101', '宁夏银川市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640102', '宁夏银川市城区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640103', '宁夏银川市新城区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640104', '宁夏回族自治区银川市兴庆区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640105', '宁夏回族自治区银川市西夏区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640106', '宁夏回族自治区银川市金凤区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640111', '宁夏银川市郊区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640121', '宁夏永宁县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640122', '宁夏贺兰县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6401', '640181', '宁夏回族自治区银川市灵武市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640200', '宁夏石嘴山市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640201', '宁夏石嘴山市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640202', '宁夏石嘴山市大武口区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640203', '宁夏石嘴山市石嘴山区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640204', '宁夏石嘴山市石炭井区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640205', '宁夏回族自治区石嘴山市惠农区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640221', '宁夏平罗县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640222', '宁夏陶乐县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6402', '640223', '宁夏惠农县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6403', '640300', '宁夏回族自治区吴忠市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6403', '640301', '宁夏回族自治区吴忠市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6403', '640302', '宁夏回族自治区吴忠市利通区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6403', '640323', '宁夏回族自治区吴忠市盐池县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6403', '640324', '宁夏回族自治区吴忠市同心县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6403', '640381', '宁夏回族自治区吴忠市青铜峡市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640400', '宁夏回族自治区固原市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640401', '宁夏回族自治区固原市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640402', '宁夏回族自治区固原市原州区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640422', '宁夏回族自治区固原市西吉县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640423', '宁夏回族自治区固原市隆德县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640424', '宁夏回族自治区固原市泾源县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6404', '640425', '宁夏回族自治区固原市彭阳县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6405', '640500', '宁夏回族自治区中卫市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6405', '640501', '宁夏回族自治区中卫市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6405', '640502', '宁夏回族自治区中卫市沙坡头区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6405', '640521', '宁夏回族自治区中卫市中宁县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6405', '640522', '宁夏回族自治区中卫市海原县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642100', '宁夏银南地区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642101', '宁夏吴忠市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642102', '宁夏青铜峡市');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642123', '宁夏中卫县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642124', '宁夏中宁县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642125', '宁夏灵武县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642126', '宁夏盐池县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6421', '642127', '宁夏同心县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642200', '宁夏固原地区');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642221', '宁夏固原县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642222', '宁夏海原县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642223', '宁夏西吉县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642224', '宁夏隆德县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642225', '宁夏泾源县');
INSERT INTO `t_pub_areacode` VALUES ('64', '6422', '642226', '宁夏彭阳县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6500', '650000', '新疆');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650100', '新疆乌鲁木齐市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650101', '新疆乌鲁木齐市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650102', '新疆乌鲁木齐市天山区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650103', '新疆乌鲁木齐市沙衣巴克区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650104', '新疆乌鲁木齐市新市区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650105', '新疆乌鲁木齐市水磨沟区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650106', '新疆乌鲁木齐市头屯河区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650107', '新疆乌鲁木齐市南山矿区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650108', '新疆乌鲁木齐市东山区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650109', '新疆维吾尔自治区乌鲁木齐市米东区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6501', '650121', '新疆乌鲁木齐县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6502', '650200', '新疆克拉玛依市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6502', '650201', '新疆克拉玛依市市辖区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6502', '650202', '新疆克拉玛依市独山子区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6502', '650203', '新疆克拉玛依市克拉玛依区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6502', '650204', '新疆克拉玛依市白碱滩区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6502', '650205', '新疆克拉玛依市乌尔禾区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6521', '652100', '新疆吐鲁番地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6521', '652101', '新疆吐鲁番市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6521', '652122', '新疆鄯善县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6521', '652123', '新疆托克逊县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6522', '652200', '新疆哈密地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6522', '652201', '新疆哈密市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6522', '652222', '新疆巴里坤哈萨克自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6522', '652223', '新疆伊吾县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652300', '新疆昌吉回族自治州');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652301', '新疆昌吉市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652302', '新疆阜康市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652322', '新疆米泉县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652323', '新疆呼图壁县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652324', '新疆玛纳斯县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652325', '新疆奇台县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652327', '新疆吉木萨尔县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6523', '652328', '新疆木垒哈萨克自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6527', '652700', '新疆博尔塔拉蒙古自治州');
INSERT INTO `t_pub_areacode` VALUES ('65', '6527', '652701', '新疆博乐市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6527', '652722', '新疆精河县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6527', '652723', '新疆温泉县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652800', '新疆巴音郭楞蒙古自治州');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652801', '新疆库尔勒市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652822', '新疆轮台县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652823', '新疆尉梨县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652824', '新疆若羌县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652825', '新疆且未县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652826', '新疆焉耆回族自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652827', '新疆和静县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652828', '新疆和硕县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6528', '652829', '新疆博湖县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652900', '新疆阿克苏地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652901', '新疆阿克苏市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652922', '新疆温宿县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652923', '新疆库车县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652924', '新疆沙雅县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652925', '新疆新和县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652926', '新疆拜城县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652927', '新疆乌什县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652928', '新疆阿瓦提县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6529', '652929', '新疆柯坪县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6530', '653000', '新疆克孜勒苏柯尔克孜自治州');
INSERT INTO `t_pub_areacode` VALUES ('65', '6530', '653001', '新疆阿图什市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6530', '653022', '新疆阿克陶县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6530', '653023', '新疆阿合奇县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6530', '653024', '新疆乌恰县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653100', '新疆喀什地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653101', '新疆喀什市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653121', '新疆疏附县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653122', '新疆疏勒县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653123', '新疆英吉沙县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653124', '新疆泽普县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653125', '新疆莎车县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653126', '新疆叶城县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653127', '新疆麦盖提县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653128', '新疆岳普湖县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653129', '新疆伽师县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653130', '新疆巴楚县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6531', '653131', '新疆塔什库尔干塔吉克自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653200', '新疆和田地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653201', '新疆和田市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653221', '新疆和田县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653222', '新疆墨玉县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653223', '新疆皮山县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653224', '新疆洛浦县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653225', '新疆策勒县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653226', '新疆于田县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6532', '653227', '新疆民丰县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654000', '新疆伊犁哈萨克自治州');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654001', '新疆奎屯市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654002', '新疆维吾尔自治区伊犁哈萨克自治州伊宁市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654003', '新疆维吾尔自治区伊犁哈萨克自治州奎屯市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654021', '新疆维吾尔自治区伊犁哈萨克自治州伊宁县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654022', '新疆维吾尔自治区伊犁哈萨克自治州察布查尔锡伯自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654023', '新疆维吾尔自治区伊犁哈萨克自治州霍城县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654024', '新疆维吾尔自治区伊犁哈萨克自治州巩留县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654025', '新疆维吾尔自治区伊犁哈萨克自治州新源县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654026', '新疆维吾尔自治区伊犁哈萨克自治州昭苏县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654027', '新疆维吾尔自治区伊犁哈萨克自治州特克斯县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6540', '654028', '新疆维吾尔自治区伊犁哈萨克自治州尼勒克县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654100', '新疆伊犁地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654101', '新疆伊宁市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654121', '新疆伊宁县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654122', '新疆察布查尔锡伯自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654123', '新疆霍城县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654124', '新疆巩留县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654125', '新疆新源县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654126', '新疆昭苏县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654127', '新疆特克斯县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6541', '654128', '新疆尼勒克县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654200', '新疆塔城地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654201', '新疆塔城市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654202', '新疆维吾尔自治区塔城地区乌苏市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654221', '新疆额敏县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654222', '新疆乌苏县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654223', '新疆沙湾县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654224', '新疆托里县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654225', '新疆裕民县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6542', '654226', '新疆和布克赛尔蒙古自治县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654300', '新疆阿勒泰地区');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654301', '新疆阿勒泰市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654321', '新疆布尔津县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654322', '新疆富蕴县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654323', '新疆福海县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654324', '新疆哈巴河县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654325', '新疆青河县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6543', '654326', '新疆吉木乃县');
INSERT INTO `t_pub_areacode` VALUES ('65', '6590', '659000', '新疆省直辖行政单位');
INSERT INTO `t_pub_areacode` VALUES ('65', '6590', '659001', '新疆石河子市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6590', '659002', '新疆维吾尔自治区阿拉尔市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6590', '659003', '新疆维吾尔自治区图木舒克市');
INSERT INTO `t_pub_areacode` VALUES ('65', '6590', '659004', '新疆维吾尔自治区五家渠市');

-- ----------------------------
-- Table structure for t_pub_carousel
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_carousel`;
CREATE TABLE `t_pub_carousel` (
  `F_CAROUSELID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '轮播图ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号',
  `F_NAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `F_DESC` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  `F_TYPE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`F_CAROUSELID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图表';

-- ----------------------------
-- Records of t_pub_carousel
-- ----------------------------
INSERT INTO `t_pub_carousel` VALUES ('867bfc98ad0042c5bcc4bed562c7f1b1', 'da14b98e-cb26-4169-9b58-babe98b98047', '首页轮播图', null, '2019-11-16 16:06:26', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '2019-11-16 19:49:53', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '0', null);
INSERT INTO `t_pub_carousel` VALUES ('bcc7d3090117413a9f4271656ebe6543', 'da14b98e-cb26-4169-9b58-babe98b98047', '首页拼团专区', null, '2019-11-16 16:06:46', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '2019-11-16 20:02:47', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '0', null);
INSERT INTO `t_pub_carousel` VALUES ('e326d5f032f74d7e95573ab52ab77229', 'da14b98e-cb26-4169-9b58-babe98b98047', '首页商品精选', null, '2019-11-16 16:06:52', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '2019-11-16 20:03:06', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '0', null);

-- ----------------------------
-- Table structure for t_pub_carouselitem
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_carouselitem`;
CREATE TABLE `t_pub_carouselitem` (
  `F_ITEMID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '轮播图明细ID',
  `F_CAROUSELID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '轮播图ID',
  `F_TITLE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '明细标题',
  `F_PICURL` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片URL',
  `F_LINKURL` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联URL',
  `F_SEQNUM` decimal(3,0) DEFAULT NULL COMMENT '顺序',
  PRIMARY KEY (`F_ITEMID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图明细表';

-- ----------------------------
-- Records of t_pub_carouselitem
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_childsystem
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_childsystem`;
CREATE TABLE `t_pub_childsystem` (
  `F_CSID` varchar(30) NOT NULL COMMENT '子系统编号',
  `F_CSNAME` varchar(100) NOT NULL COMMENT '子系统名称',
  `F_MENUURL` varchar(255) DEFAULT NULL COMMENT '生成菜单URL',
  `F_CSORDER` int(11) DEFAULT NULL COMMENT '子系统顺序号',
  `F_CSDESC` varchar(255) DEFAULT NULL COMMENT '子系统描述',
  PRIMARY KEY (`F_CSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子系统表';

-- ----------------------------
-- Records of t_pub_childsystem
-- ----------------------------
INSERT INTO `t_pub_childsystem` VALUES ('1', '系统管理', '', '0', '');
INSERT INTO `t_pub_childsystem` VALUES ('2', '运营商管理系统', '', '0', '');

-- ----------------------------
-- Table structure for t_pub_city
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_city`;
CREATE TABLE `t_pub_city` (
  `F_CITYID` decimal(6,0) NOT NULL COMMENT '地市编号',
  `F_CITYCODE` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT 'NNN-NN-NNNN-NNNN 国家-省份-地市-区县，没有-分隔',
  `F_CITYNAME` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `F_CITYLEVEL` decimal(1,0) DEFAULT NULL COMMENT '0-国家1-省份2-地市3-区县',
  `F_FOREIGH` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '0-国内1-国外',
  `F_PCITYID` decimal(6,0) DEFAULT NULL COMMENT '上级ID',
  `F_PROVINCE` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '所属省份',
  `F_CITY` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '所属市',
  `F_XIAN` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '所属区县',
  `F_PY` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '拼音码',
  `F_ISALAWAY` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否常用',
  PRIMARY KEY (`F_CITYID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='省市区表-来源全域通';

-- ----------------------------
-- Records of t_pub_city
-- ----------------------------
INSERT INTO `t_pub_city` VALUES ('1', '230000', '黑龙江', '1', '0', null, '黑龙江', null, null, 'HLJS', null);
INSERT INTO `t_pub_city` VALUES ('2', '320000', '江苏', '1', '0', null, '江苏', null, null, 'JSS', null);
INSERT INTO `t_pub_city` VALUES ('3', '330000', '浙江', '1', '0', null, '浙江', null, null, 'ZJS', null);
INSERT INTO `t_pub_city` VALUES ('4', '340000', '安徽', '1', '0', null, '安徽', null, null, 'AHS', null);
INSERT INTO `t_pub_city` VALUES ('5', '350000', '福建', '1', '0', null, '福建', null, null, 'FJS', null);
INSERT INTO `t_pub_city` VALUES ('6', '360000', '江西', '1', '0', null, '江西', null, null, 'JXS', null);
INSERT INTO `t_pub_city` VALUES ('7', '370000', '山东', '1', '0', null, '山东', null, null, 'SDS', null);
INSERT INTO `t_pub_city` VALUES ('8', '410000', '河南', '1', '0', null, '河南', null, null, 'HNS', null);
INSERT INTO `t_pub_city` VALUES ('9', '110000', '北京', '1', '0', null, '北京', null, null, 'BJ', '1');
INSERT INTO `t_pub_city` VALUES ('10', '120000', '天津', '1', '0', null, '天津', null, null, 'TJ', '1');
INSERT INTO `t_pub_city` VALUES ('11', '130000', '河北', '1', '0', null, '河北', null, null, 'HBS', null);
INSERT INTO `t_pub_city` VALUES ('12', '140000', '山西', '1', '0', null, '山西', null, null, 'SXS', null);
INSERT INTO `t_pub_city` VALUES ('13', '150000', '内蒙古自治区', '1', '0', null, '内蒙古自治区', null, null, 'NMGZZQ', null);
INSERT INTO `t_pub_city` VALUES ('14', '210000', '辽宁', '1', '0', null, '辽宁', null, null, 'LNS', null);
INSERT INTO `t_pub_city` VALUES ('15', '220000', '吉林', '1', '0', null, '吉林', null, null, 'JLS', null);
INSERT INTO `t_pub_city` VALUES ('16', '710000', '台湾', '1', '1', null, '台湾', null, null, 'TWS', null);
INSERT INTO `t_pub_city` VALUES ('17', '810000', '香港特别行政区', '1', '1', null, '香港特别行政区', null, null, 'XGTBHZQ', null);
INSERT INTO `t_pub_city` VALUES ('18', '820000', '澳门特别行政区', '1', '1', null, '澳门特别行政区', null, null, 'AMTBHZQ', '2');
INSERT INTO `t_pub_city` VALUES ('19', '420000', '湖北', '1', '0', null, '湖北', null, null, 'HBS', '1');
INSERT INTO `t_pub_city` VALUES ('20', '430000', '湖南', '1', '0', null, '湖南', null, null, 'HNS', '1');
INSERT INTO `t_pub_city` VALUES ('21', '440000', '广东', '1', '0', null, '广东', null, null, 'ADS', null);
INSERT INTO `t_pub_city` VALUES ('22', '450000', '广西壮族自治区', '1', '0', null, '广西壮族自治区', null, null, 'AXZZZZQ', null);
INSERT INTO `t_pub_city` VALUES ('23', '460000', '海南', '1', '0', null, '海南', null, null, 'HNS', null);
INSERT INTO `t_pub_city` VALUES ('24', '510000', '四川', '1', '0', null, '四川', null, null, 'SCS', null);
INSERT INTO `t_pub_city` VALUES ('25', '520000', '贵州', '1', '0', null, '贵州', null, null, 'GZS', null);
INSERT INTO `t_pub_city` VALUES ('26', '530000', '云南', '1', '0', null, '云南', null, null, 'YNS', null);
INSERT INTO `t_pub_city` VALUES ('27', '540000', '西藏自治区', '1', '0', null, '西藏自治区', null, null, 'XCZZQ', null);
INSERT INTO `t_pub_city` VALUES ('28', '610000', '陕西', '1', '0', null, '陕西', null, null, 'SXS', null);
INSERT INTO `t_pub_city` VALUES ('29', '620000', '甘肃', '1', '0', null, '甘肃', null, null, 'GSS', null);
INSERT INTO `t_pub_city` VALUES ('30', '630000', '青海', '1', '0', null, '青海', null, null, 'QHS', null);
INSERT INTO `t_pub_city` VALUES ('31', '640000', '宁夏回族自治区', '1', '0', null, '宁夏回族自治区', null, null, 'NXHZZZQ', null);
INSERT INTO `t_pub_city` VALUES ('32', '650000', '新疆维吾尔自治区', '1', '0', null, '新疆维吾尔自治区', null, null, 'XJWWEZZQ', null);
INSERT INTO `t_pub_city` VALUES ('33', '310000', '上海', '1', '0', null, '上海', null, null, 'SH', null);
INSERT INTO `t_pub_city` VALUES ('34', '500000', '重庆', '1', '0', null, '重庆', null, null, 'CQ', null);
INSERT INTO `t_pub_city` VALUES ('35', '220800', '白城', '2', '0', '15', '吉林', '白城', null, 'BC', null);
INSERT INTO `t_pub_city` VALUES ('36', '230100', '哈尔滨', '2', '0', '1', '黑龙江', '哈尔滨', null, 'HEB', null);
INSERT INTO `t_pub_city` VALUES ('37', '230300', '鸡西', '2', '0', '1', '黑龙江', '鸡西', null, 'JX', null);
INSERT INTO `t_pub_city` VALUES ('38', '230500', '双鸭山', '2', '0', '1', '黑龙江', '双鸭山', null, 'SYS', null);
INSERT INTO `t_pub_city` VALUES ('39', '230700', '伊春', '2', '0', '1', '黑龙江', '伊春', null, 'YC', null);
INSERT INTO `t_pub_city` VALUES ('40', '231000', '牡丹江', '2', '0', '1', '黑龙江', '牡丹江', null, 'MDJ', null);
INSERT INTO `t_pub_city` VALUES ('41', '231200', '绥化', '2', '0', '1', '黑龙江', '绥化', null, 'SH', null);
INSERT INTO `t_pub_city` VALUES ('42', '310101', '黄浦区', '2', '0', '33', '上海', '黄浦区', null, 'HPQ', null);
INSERT INTO `t_pub_city` VALUES ('43', '310105', '长宁区', '2', '0', '33', '上海', '长宁区', null, 'CNQ', null);
INSERT INTO `t_pub_city` VALUES ('44', '310107', '普陀区', '2', '0', '33', '上海', '普陀区', null, 'PTQ', null);
INSERT INTO `t_pub_city` VALUES ('45', '310110', '杨浦区', '2', '0', '33', '上海', '杨浦区', null, 'YPQ', null);
INSERT INTO `t_pub_city` VALUES ('46', '310113', '宝山区', '2', '0', '33', '上海', '宝山区', null, 'BSQ', null);
INSERT INTO `t_pub_city` VALUES ('47', '310115', '浦东新区', '2', '0', '33', '上海', '浦东新区', null, 'PDXQ', null);
INSERT INTO `t_pub_city` VALUES ('48', '310117', '松江区', '2', '0', '33', '上海', '松江区', null, 'SJQ', null);
INSERT INTO `t_pub_city` VALUES ('49', '310120', '奉贤区', '2', '0', '33', '上海', '奉贤区', null, 'FXQ', null);
INSERT INTO `t_pub_city` VALUES ('50', '320100', '南京', '2', '0', '2', '江苏', '南京', null, 'NJ', null);
INSERT INTO `t_pub_city` VALUES ('51', '320300', '徐州', '2', '0', '2', '江苏', '徐州', null, 'XZ', null);
INSERT INTO `t_pub_city` VALUES ('52', '320500', '苏州', '2', '0', '2', '江苏', '苏州', null, 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('53', '320700', '连云港', '2', '0', '2', '江苏', '连云港', null, 'LYG', null);
INSERT INTO `t_pub_city` VALUES ('54', '321000', '扬州', '2', '0', '2', '江苏', '扬州', null, 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('55', '321200', '泰州', '2', '0', '2', '江苏', '泰州', null, 'TZ', null);
INSERT INTO `t_pub_city` VALUES ('56', '330100', '杭州', '2', '0', '3', '浙江', '杭州', null, 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('57', '330400', '嘉兴', '2', '0', '3', '浙江', '嘉兴', null, 'JX', null);
INSERT INTO `t_pub_city` VALUES ('58', '330700', '金华', '2', '0', '3', '浙江', '金华', null, 'JH', null);
INSERT INTO `t_pub_city` VALUES ('59', '330900', '舟山', '2', '0', '3', '浙江', '舟山', null, 'ZS', null);
INSERT INTO `t_pub_city` VALUES ('60', '331100', '丽水', '2', '0', '3', '浙江', '丽水', null, 'LS', null);
INSERT INTO `t_pub_city` VALUES ('61', '340200', '芜湖', '2', '0', '4', '安徽', '芜湖', null, 'WH', null);
INSERT INTO `t_pub_city` VALUES ('62', '340500', '马鞍山', '2', '0', '4', '安徽', '马鞍山', null, 'MAS', null);
INSERT INTO `t_pub_city` VALUES ('63', '340700', '铜陵', '2', '0', '4', '安徽', '铜陵', null, 'TL', null);
INSERT INTO `t_pub_city` VALUES ('64', '341000', '黄山', '2', '0', '4', '安徽', '黄山', null, 'HS', null);
INSERT INTO `t_pub_city` VALUES ('65', '341300', '宿州', '2', '0', '4', '安徽', '宿州', null, 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('66', '341600', '亳州', '2', '0', '4', '安徽', '亳州', null, 'BZ', null);
INSERT INTO `t_pub_city` VALUES ('67', '341800', '宣城', '2', '0', '4', '安徽', '宣城', null, 'XC', null);
INSERT INTO `t_pub_city` VALUES ('68', '350200', '厦门', '2', '0', '5', '福建', '厦门', null, 'SM', null);
INSERT INTO `t_pub_city` VALUES ('69', '350500', '泉州', '2', '0', '5', '福建', '泉州', null, 'QZ', null);
INSERT INTO `t_pub_city` VALUES ('70', '350700', '南平', '2', '0', '5', '福建', '南平', null, 'NP', null);
INSERT INTO `t_pub_city` VALUES ('71', '350900', '宁德', '2', '0', '5', '福建', '宁德', null, 'ND', null);
INSERT INTO `t_pub_city` VALUES ('72', '360200', '景德镇', '2', '0', '6', '江西', '景德镇', null, 'JDZ', null);
INSERT INTO `t_pub_city` VALUES ('73', '360600', '鹰潭', '2', '0', '6', '江西', '鹰潭', null, 'YT', null);
INSERT INTO `t_pub_city` VALUES ('74', '360900', '宜春', '2', '0', '6', '江西', '宜春', null, 'YC', null);
INSERT INTO `t_pub_city` VALUES ('75', '361100', '上饶', '2', '0', '6', '江西', '上饶', null, 'SR', null);
INSERT INTO `t_pub_city` VALUES ('76', '370200', '青岛', '2', '0', '7', '山东', '青岛', null, 'QD', null);
INSERT INTO `t_pub_city` VALUES ('77', '370400', '枣庄', '2', '0', '7', '山东', '枣庄', null, 'ZZ', null);
INSERT INTO `t_pub_city` VALUES ('78', '370700', '潍坊', '2', '0', '7', '山东', '潍坊', null, 'WF', null);
INSERT INTO `t_pub_city` VALUES ('79', '370900', '泰安', '2', '0', '7', '山东', '泰安', null, 'TA', null);
INSERT INTO `t_pub_city` VALUES ('80', '371100', '日照', '2', '0', '7', '山东', '日照', null, 'RZ', null);
INSERT INTO `t_pub_city` VALUES ('81', '371300', '临沂', '2', '0', '7', '山东', '临沂', null, 'LY', null);
INSERT INTO `t_pub_city` VALUES ('82', '371600', '滨州', '2', '0', '7', '山东', '滨州', null, 'BZ', null);
INSERT INTO `t_pub_city` VALUES ('83', '410100', '郑州', '2', '0', '8', '河南', '郑州', null, 'ZZ', null);
INSERT INTO `t_pub_city` VALUES ('84', '410300', '洛阳', '2', '0', '8', '河南', '洛阳', null, 'LY', null);
INSERT INTO `t_pub_city` VALUES ('85', '410500', '安阳', '2', '0', '8', '河南', '安阳', null, 'AY', null);
INSERT INTO `t_pub_city` VALUES ('86', '110102', '西城区', '2', '0', '9', '北京', '西城区', null, 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('87', '110106', '丰台区', '2', '0', '9', '北京', '丰台区', null, 'FTQ', null);
INSERT INTO `t_pub_city` VALUES ('88', '110108', '海淀区', '2', '0', '9', '北京', '海淀区', null, 'HDQ', null);
INSERT INTO `t_pub_city` VALUES ('89', '110111', '房山区', '2', '0', '9', '北京', '房山区', null, 'FSQ', null);
INSERT INTO `t_pub_city` VALUES ('90', '110113', '顺义区', '2', '0', '9', '北京', '顺义区', null, 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('91', '110115', '大兴区', '2', '0', '9', '北京', '大兴区', null, 'DXQ', null);
INSERT INTO `t_pub_city` VALUES ('92', '110117', '平谷区', '2', '0', '9', '北京', '平谷区', null, 'PGQ', null);
INSERT INTO `t_pub_city` VALUES ('93', '110119', '延庆区', '2', '0', '9', '北京', '延庆区', null, 'YQQ', null);
INSERT INTO `t_pub_city` VALUES ('94', '120102', '河东区', '2', '0', '10', '天津', '河东区', null, 'HDQ', null);
INSERT INTO `t_pub_city` VALUES ('95', '120104', '南开区', '2', '0', '10', '天津', '南开区', null, 'NKQ', null);
INSERT INTO `t_pub_city` VALUES ('96', '120106', '红桥区', '2', '0', '10', '天津', '红桥区', null, 'GQQ', null);
INSERT INTO `t_pub_city` VALUES ('97', '120111', '西青区', '2', '0', '10', '天津', '西青区', null, 'XQQ', null);
INSERT INTO `t_pub_city` VALUES ('98', '120113', '北辰区', '2', '0', '10', '天津', '北辰区', null, 'BCQ', null);
INSERT INTO `t_pub_city` VALUES ('99', '120115', '宝坻区', '2', '0', '10', '天津', '宝坻区', null, 'BCQ', null);
INSERT INTO `t_pub_city` VALUES ('100', '120117', '宁河区', '2', '0', '10', '天津', '宁河区', null, 'NHQ', null);
INSERT INTO `t_pub_city` VALUES ('101', '120225', '蓟县', '2', '0', '10', '天津', '蓟县', null, 'JX', null);
INSERT INTO `t_pub_city` VALUES ('102', '130200', '唐山', '2', '0', '11', '河北', '唐山', null, 'TS', null);
INSERT INTO `t_pub_city` VALUES ('103', '130400', '邯郸', '2', '0', '11', '河北', '邯郸', null, 'HD', null);
INSERT INTO `t_pub_city` VALUES ('104', '130600', '保定', '2', '0', '11', '河北', '保定', null, 'BD', null);
INSERT INTO `t_pub_city` VALUES ('105', '130800', '承德', '2', '0', '11', '河北', '承德', null, 'CD', null);
INSERT INTO `t_pub_city` VALUES ('106', '131000', '廊坊', '2', '0', '11', '河北', '廊坊', null, 'LF', null);
INSERT INTO `t_pub_city` VALUES ('107', '140100', '太原', '2', '0', '12', '山西', '太原', null, 'TY', null);
INSERT INTO `t_pub_city` VALUES ('108', '140400', '长治', '2', '0', '12', '山西', '长治', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('109', '140600', '朔州', '2', '0', '12', '山西', '朔州', null, 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('110', '140800', '运城', '2', '0', '12', '山西', '运城', null, 'YC', null);
INSERT INTO `t_pub_city` VALUES ('111', '141000', '临汾', '2', '0', '12', '山西', '临汾', null, 'LF', null);
INSERT INTO `t_pub_city` VALUES ('112', '150200', '包头', '2', '0', '13', '内蒙古自治区', '包头', null, 'BT', null);
INSERT INTO `t_pub_city` VALUES ('113', '150500', '通辽', '2', '0', '13', '内蒙古自治区', '通辽', null, 'TL', null);
INSERT INTO `t_pub_city` VALUES ('114', '150700', '呼伦贝尔', '2', '0', '13', '内蒙古自治区', '呼伦贝尔', null, 'HLBE', null);
INSERT INTO `t_pub_city` VALUES ('115', '152200', '兴安盟', '2', '0', '13', '内蒙古自治区', '兴安盟', null, 'XAM', null);
INSERT INTO `t_pub_city` VALUES ('116', '152900', '阿拉善盟', '2', '0', '13', '内蒙古自治区', '阿拉善盟', null, 'ALSM', null);
INSERT INTO `t_pub_city` VALUES ('117', '210200', '大连', '2', '0', '14', '辽宁', '大连', null, 'DL', null);
INSERT INTO `t_pub_city` VALUES ('118', '210400', '抚顺', '2', '0', '14', '辽宁', '抚顺', null, 'FS', null);
INSERT INTO `t_pub_city` VALUES ('119', '210700', '锦州', '2', '0', '14', '辽宁', '锦州', null, 'JZ', null);
INSERT INTO `t_pub_city` VALUES ('120', '210900', '阜新', '2', '0', '14', '辽宁', '阜新', null, 'FX', null);
INSERT INTO `t_pub_city` VALUES ('121', '211100', '盘锦', '2', '0', '14', '辽宁', '盘锦', null, 'PJ', null);
INSERT INTO `t_pub_city` VALUES ('122', '211300', '朝阳', '2', '0', '14', '辽宁', '朝阳', null, 'CY', null);
INSERT INTO `t_pub_city` VALUES ('123', '220100', '长春', '2', '0', '15', '吉林', '长春', null, 'CC', null);
INSERT INTO `t_pub_city` VALUES ('124', '220400', '辽源', '2', '0', '15', '吉林', '辽源', null, 'LY', null);
INSERT INTO `t_pub_city` VALUES ('125', '220600', '白山', '2', '0', '15', '吉林', '白山', null, 'BS', null);
INSERT INTO `t_pub_city` VALUES ('126', '652700', '博尔塔拉蒙古自治州', '2', '0', '32', '新疆维吾尔自治区', '博尔塔拉蒙古自治州', null, 'BEDLMGZZZ', null);
INSERT INTO `t_pub_city` VALUES ('127', '652800', '巴音郭楞蒙古自治州', '2', '0', '32', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', null, 'BYGLMGZZZ', null);
INSERT INTO `t_pub_city` VALUES ('128', '652900', '阿克苏地区', '2', '0', '32', '新疆维吾尔自治区', '阿克苏地区', null, 'AKSDQ', null);
INSERT INTO `t_pub_city` VALUES ('129', '653000', '克孜勒苏柯尔克孜自治州', '2', '0', '32', '新疆维吾尔自治区', '克孜勒苏柯尔克孜自治州', null, 'KZLSKEKZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('130', '653100', '喀什地区', '2', '0', '32', '新疆维吾尔自治区', '喀什地区', null, 'KSDQ', null);
INSERT INTO `t_pub_city` VALUES ('131', '653200', '和田地区', '2', '0', '32', '新疆维吾尔自治区', '和田地区', null, 'HTDQ', null);
INSERT INTO `t_pub_city` VALUES ('132', '654000', '伊犁哈萨克自治州', '2', '0', '32', '新疆维吾尔自治区', '伊犁哈萨克自治州', null, 'YLHSKZZZ', null);
INSERT INTO `t_pub_city` VALUES ('133', '654200', '塔城地区', '2', '0', '32', '新疆维吾尔自治区', '塔城地区', null, 'DCDQ', null);
INSERT INTO `t_pub_city` VALUES ('134', '654300', '阿勒泰地区', '2', '0', '32', '新疆维吾尔自治区', '阿勒泰地区', null, 'ALTDQ', null);
INSERT INTO `t_pub_city` VALUES ('135', '220700', '松原', '2', '0', '15', '吉林', '松原', null, 'SY', null);
INSERT INTO `t_pub_city` VALUES ('136', '222400', '延边朝鲜族自治州', '2', '0', '15', '吉林', '延边朝鲜族自治州', null, 'YBCXZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('137', '230200', '齐齐哈尔', '2', '0', '1', '黑龙江', '齐齐哈尔', null, 'JJHE', null);
INSERT INTO `t_pub_city` VALUES ('138', '230400', '鹤岗', '2', '0', '1', '黑龙江', '鹤岗', null, 'HG', null);
INSERT INTO `t_pub_city` VALUES ('139', '230600', '大庆', '2', '0', '1', '黑龙江', '大庆', null, 'DQ', null);
INSERT INTO `t_pub_city` VALUES ('140', '230800', '佳木斯', '2', '0', '1', '黑龙江', '佳木斯', null, 'JMS', null);
INSERT INTO `t_pub_city` VALUES ('141', '230900', '七台河', '2', '0', '1', '黑龙江', '七台河', null, 'QTH', null);
INSERT INTO `t_pub_city` VALUES ('142', '231100', '黑河', '2', '0', '1', '黑龙江', '黑河', null, 'HH', null);
INSERT INTO `t_pub_city` VALUES ('143', '232700', '大兴安岭地区', '2', '0', '1', '黑龙江', '大兴安岭地区', null, 'DXALDQ', null);
INSERT INTO `t_pub_city` VALUES ('144', '320200', '无锡', '2', '0', '2', '江苏', '无锡', null, 'MX', null);
INSERT INTO `t_pub_city` VALUES ('145', '320400', '常州', '2', '0', '2', '江苏', '常州', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('146', '320600', '南通', '2', '0', '2', '江苏', '南通', null, 'NT', null);
INSERT INTO `t_pub_city` VALUES ('147', '320800', '淮安', '2', '0', '2', '江苏', '淮安', null, 'HA', null);
INSERT INTO `t_pub_city` VALUES ('148', '320900', '盐城', '2', '0', '2', '江苏', '盐城', null, 'YC', null);
INSERT INTO `t_pub_city` VALUES ('149', '321100', '镇江', '2', '0', '2', '江苏', '镇江', null, 'ZJ', null);
INSERT INTO `t_pub_city` VALUES ('150', '321300', '宿迁', '2', '0', '2', '江苏', '宿迁', null, 'SQ', null);
INSERT INTO `t_pub_city` VALUES ('151', '330200', '宁波', '2', '0', '3', '浙江', '宁波', null, 'NB', null);
INSERT INTO `t_pub_city` VALUES ('152', '330300', '温州', '2', '0', '3', '浙江', '温州', null, 'WZ', null);
INSERT INTO `t_pub_city` VALUES ('153', '330500', '湖州', '2', '0', '3', '浙江', '湖州', null, 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('154', '330600', '绍兴', '2', '0', '3', '浙江', '绍兴', null, 'SX', null);
INSERT INTO `t_pub_city` VALUES ('155', '330800', '衢州', '2', '0', '3', '浙江', '衢州', null, 'QZ', null);
INSERT INTO `t_pub_city` VALUES ('156', '331000', '台州', '2', '0', '3', '浙江', '台州', null, 'TZ', null);
INSERT INTO `t_pub_city` VALUES ('157', '340100', '合肥', '2', '0', '4', '安徽', '合肥', null, 'GF', null);
INSERT INTO `t_pub_city` VALUES ('158', '340300', '蚌埠', '2', '0', '4', '安徽', '蚌埠', null, 'BB', null);
INSERT INTO `t_pub_city` VALUES ('159', '340400', '淮南', '2', '0', '4', '安徽', '淮南', null, 'HN', null);
INSERT INTO `t_pub_city` VALUES ('160', '340600', '淮北', '2', '0', '4', '安徽', '淮北', null, 'HB', null);
INSERT INTO `t_pub_city` VALUES ('161', '340800', '安庆', '2', '0', '4', '安徽', '安庆', null, 'AQ', null);
INSERT INTO `t_pub_city` VALUES ('162', '341100', '滁州', '2', '0', '4', '安徽', '滁州', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('163', '341200', '阜阳', '2', '0', '4', '安徽', '阜阳', null, 'FY', null);
INSERT INTO `t_pub_city` VALUES ('164', '341500', '六安', '2', '0', '4', '安徽', '六安', null, 'LA', null);
INSERT INTO `t_pub_city` VALUES ('165', '341700', '池州', '2', '0', '4', '安徽', '池州', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('166', '350100', '福州', '2', '0', '5', '福建', '福州', null, 'FZ', null);
INSERT INTO `t_pub_city` VALUES ('167', '350300', '莆田', '2', '0', '5', '福建', '莆田', null, 'PT', null);
INSERT INTO `t_pub_city` VALUES ('168', '350400', '三明', '2', '0', '5', '福建', '三明', null, 'SM', null);
INSERT INTO `t_pub_city` VALUES ('169', '350600', '漳州', '2', '0', '5', '福建', '漳州', null, 'ZZ', null);
INSERT INTO `t_pub_city` VALUES ('170', '350800', '龙岩', '2', '0', '5', '福建', '龙岩', null, 'LY', null);
INSERT INTO `t_pub_city` VALUES ('171', '360100', '南昌', '2', '0', '6', '江西', '南昌', null, 'NC', null);
INSERT INTO `t_pub_city` VALUES ('172', '360300', '萍乡', '2', '0', '6', '江西', '萍乡', null, 'PX', null);
INSERT INTO `t_pub_city` VALUES ('173', '360400', '九江', '2', '0', '6', '江西', '九江', null, 'JJ', null);
INSERT INTO `t_pub_city` VALUES ('174', '360500', '新余', '2', '0', '6', '江西', '新余', null, 'XY', null);
INSERT INTO `t_pub_city` VALUES ('175', '360700', '赣州', '2', '0', '6', '江西', '赣州', null, 'GZ', null);
INSERT INTO `t_pub_city` VALUES ('176', '360800', '吉安', '2', '0', '6', '江西', '吉安', null, 'JA', null);
INSERT INTO `t_pub_city` VALUES ('177', '361000', '抚州', '2', '0', '6', '江西', '抚州', null, 'FZ', null);
INSERT INTO `t_pub_city` VALUES ('178', '370100', '济南', '2', '0', '7', '山东', '济南', null, 'JN', null);
INSERT INTO `t_pub_city` VALUES ('179', '370300', '淄博', '2', '0', '7', '山东', '淄博', null, 'ZB', null);
INSERT INTO `t_pub_city` VALUES ('180', '370500', '东营', '2', '0', '7', '山东', '东营', null, 'DY', null);
INSERT INTO `t_pub_city` VALUES ('181', '370600', '烟台', '2', '0', '7', '山东', '烟台', null, 'YT', null);
INSERT INTO `t_pub_city` VALUES ('182', '370800', '济宁', '2', '0', '7', '山东', '济宁', null, 'JN', null);
INSERT INTO `t_pub_city` VALUES ('183', '371000', '威海', '2', '0', '7', '山东', '威海', null, 'WH', null);
INSERT INTO `t_pub_city` VALUES ('184', '371200', '莱芜', '2', '0', '7', '山东', '莱芜', null, 'LW', null);
INSERT INTO `t_pub_city` VALUES ('185', '371400', '德州', '2', '0', '7', '山东', '德州', null, 'DZ', null);
INSERT INTO `t_pub_city` VALUES ('186', '371500', '聊城', '2', '0', '7', '山东', '聊城', null, 'LC', null);
INSERT INTO `t_pub_city` VALUES ('187', '371700', '菏泽', '2', '0', '7', '山东', '菏泽', null, 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('188', '410200', '开封', '2', '0', '8', '河南', '开封', null, 'KF', null);
INSERT INTO `t_pub_city` VALUES ('189', '410400', '平顶山', '2', '0', '8', '河南', '平顶山', null, 'PDS', null);
INSERT INTO `t_pub_city` VALUES ('190', '410600', '鹤壁', '2', '0', '8', '河南', '鹤壁', null, 'HB', null);
INSERT INTO `t_pub_city` VALUES ('191', '410700', '新乡', '2', '0', '8', '河南', '新乡', null, 'XX', null);
INSERT INTO `t_pub_city` VALUES ('192', '130100', '石家庄', '2', '0', '11', '河北', '石家庄', null, 'SJZ', null);
INSERT INTO `t_pub_city` VALUES ('193', '130300', '秦皇岛', '2', '0', '11', '河北', '秦皇岛', null, 'QHD', null);
INSERT INTO `t_pub_city` VALUES ('194', '130500', '邢台', '2', '0', '11', '河北', '邢台', null, 'GT', null);
INSERT INTO `t_pub_city` VALUES ('195', '130700', '张家口', '2', '0', '11', '河北', '张家口', null, 'ZJK', null);
INSERT INTO `t_pub_city` VALUES ('196', '130900', '沧州', '2', '0', '11', '河北', '沧州', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('197', '131100', '衡水', '2', '0', '11', '河北', '衡水', null, 'HS', null);
INSERT INTO `t_pub_city` VALUES ('198', '140200', '大同', '2', '0', '12', '山西', '大同', null, 'DT', null);
INSERT INTO `t_pub_city` VALUES ('199', '140300', '阳泉', '2', '0', '12', '山西', '阳泉', null, 'YQ', null);
INSERT INTO `t_pub_city` VALUES ('200', '140500', '晋城', '2', '0', '12', '山西', '晋城', null, 'JC', null);
INSERT INTO `t_pub_city` VALUES ('201', '140700', '晋中', '2', '0', '12', '山西', '晋中', null, 'JZ', null);
INSERT INTO `t_pub_city` VALUES ('202', '140900', '忻州', '2', '0', '12', '山西', '忻州', null, 'XZ', null);
INSERT INTO `t_pub_city` VALUES ('203', '141100', '吕梁', '2', '0', '12', '山西', '吕梁', null, 'LL', null);
INSERT INTO `t_pub_city` VALUES ('204', '150100', '呼和浩特', '2', '0', '13', '内蒙古自治区', '呼和浩特', null, 'HHHT', null);
INSERT INTO `t_pub_city` VALUES ('205', '150300', '乌海', '2', '0', '13', '内蒙古自治区', '乌海', null, 'WH', null);
INSERT INTO `t_pub_city` VALUES ('206', '150400', '赤峰', '2', '0', '13', '内蒙古自治区', '赤峰', null, 'CF', null);
INSERT INTO `t_pub_city` VALUES ('207', '150600', '鄂尔多斯', '2', '0', '13', '内蒙古自治区', '鄂尔多斯', null, 'EEDS', null);
INSERT INTO `t_pub_city` VALUES ('208', '150800', '巴彦淖尔', '2', '0', '13', '内蒙古自治区', '巴彦淖尔', null, 'BYNE', null);
INSERT INTO `t_pub_city` VALUES ('209', '150900', '乌兰察布', '2', '0', '13', '内蒙古自治区', '乌兰察布', null, 'WLCB', null);
INSERT INTO `t_pub_city` VALUES ('210', '152500', '锡林郭勒盟', '2', '0', '13', '内蒙古自治区', '锡林郭勒盟', null, 'XLGLM', null);
INSERT INTO `t_pub_city` VALUES ('211', '210100', '沈阳', '2', '0', '14', '辽宁', '沈阳', null, 'SY', null);
INSERT INTO `t_pub_city` VALUES ('212', '210300', '鞍山', '2', '0', '14', '辽宁', '鞍山', null, 'AS', null);
INSERT INTO `t_pub_city` VALUES ('213', '210500', '本溪', '2', '0', '14', '辽宁', '本溪', null, 'BX', null);
INSERT INTO `t_pub_city` VALUES ('214', '210600', '丹东', '2', '0', '14', '辽宁', '丹东', null, 'DD', null);
INSERT INTO `t_pub_city` VALUES ('215', '210800', '营口', '2', '0', '14', '辽宁', '营口', null, 'YK', null);
INSERT INTO `t_pub_city` VALUES ('216', '211000', '辽阳', '2', '0', '14', '辽宁', '辽阳', null, 'LY', null);
INSERT INTO `t_pub_city` VALUES ('217', '211200', '铁岭', '2', '0', '14', '辽宁', '铁岭', null, 'TL', null);
INSERT INTO `t_pub_city` VALUES ('218', '211400', '葫芦岛', '2', '0', '14', '辽宁', '葫芦岛', null, 'HLD', null);
INSERT INTO `t_pub_city` VALUES ('219', '220200', '吉林', '2', '0', '15', '吉林', '吉林', null, 'JL', null);
INSERT INTO `t_pub_city` VALUES ('220', '220300', '四平', '2', '0', '15', '吉林', '四平', null, 'SP', null);
INSERT INTO `t_pub_city` VALUES ('221', '220500', '通化', '2', '0', '15', '吉林', '通化', null, 'TH', '1');
INSERT INTO `t_pub_city` VALUES ('222', '410800', '焦作', '2', '0', '8', '河南', '焦作', null, 'JZ', null);
INSERT INTO `t_pub_city` VALUES ('223', '411000', '许昌', '2', '0', '8', '河南', '许昌', null, 'HC', null);
INSERT INTO `t_pub_city` VALUES ('224', '411100', '漯河', '2', '0', '8', '河南', '漯河', null, 'LH', null);
INSERT INTO `t_pub_city` VALUES ('225', '411300', '南阳', '2', '0', '8', '河南', '南阳', null, 'NY', null);
INSERT INTO `t_pub_city` VALUES ('226', '411500', '信阳', '2', '0', '8', '河南', '信阳', null, 'XY', null);
INSERT INTO `t_pub_city` VALUES ('227', '411700', '驻马店', '2', '0', '8', '河南', '驻马店', null, 'ZMD', null);
INSERT INTO `t_pub_city` VALUES ('228', '420200', '黄石', '2', '0', '19', '湖北', '黄石', null, 'HS', '1');
INSERT INTO `t_pub_city` VALUES ('229', '420300', '十堰', '2', '0', '19', '湖北', '十堰', null, 'SY', null);
INSERT INTO `t_pub_city` VALUES ('230', '420600', '襄阳', '2', '0', '19', '湖北', '襄阳', null, 'XY', null);
INSERT INTO `t_pub_city` VALUES ('231', '420800', '荆门', '2', '0', '19', '湖北', '荆门', null, 'JM', null);
INSERT INTO `t_pub_city` VALUES ('232', '421000', '荆州', '2', '0', '19', '湖北', '荆州', null, 'JZ', null);
INSERT INTO `t_pub_city` VALUES ('233', '421200', '咸宁', '2', '0', '19', '湖北', '咸宁', null, 'XN', null);
INSERT INTO `t_pub_city` VALUES ('234', '421300', '随州', '2', '0', '19', '湖北', '随州', null, 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('235', '430100', '长沙', '2', '0', '20', '湖南', '长沙', null, 'CS', '1');
INSERT INTO `t_pub_city` VALUES ('236', '430300', '湘潭', '2', '0', '20', '湖南', '湘潭', null, 'XT', '1');
INSERT INTO `t_pub_city` VALUES ('237', '430500', '邵阳', '2', '0', '20', '湖南', '邵阳', null, 'SY', null);
INSERT INTO `t_pub_city` VALUES ('238', '430600', '岳阳', '2', '0', '20', '湖南', '岳阳', null, 'YY', null);
INSERT INTO `t_pub_city` VALUES ('239', '430800', '张家界', '2', '0', '20', '湖南', '张家界', null, 'ZJJ', '1');
INSERT INTO `t_pub_city` VALUES ('240', '431000', '郴州', '2', '0', '20', '湖南', '郴州', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('241', '431200', '怀化', '2', '0', '20', '湖南', '怀化', null, 'HH', null);
INSERT INTO `t_pub_city` VALUES ('242', '433100', '湘西土家族苗族自治州', '2', '0', '20', '湖南', '湘西土家族苗族自治州', null, 'XXTJZMZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('243', '440300', '深圳', '2', '0', '21', '广东', '深圳', null, 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('244', '440400', '珠海', '2', '0', '21', '广东', '珠海', null, 'ZH', null);
INSERT INTO `t_pub_city` VALUES ('245', '440600', '佛山', '2', '0', '21', '广东', '佛山', null, 'FS', null);
INSERT INTO `t_pub_city` VALUES ('246', '440800', '湛江', '2', '0', '21', '广东', '湛江', null, 'ZJ', null);
INSERT INTO `t_pub_city` VALUES ('247', '441200', '肇庆', '2', '0', '21', '广东', '肇庆', null, 'ZQ', null);
INSERT INTO `t_pub_city` VALUES ('248', '441400', '梅州', '2', '0', '21', '广东', '梅州', null, 'MZ', null);
INSERT INTO `t_pub_city` VALUES ('249', '441500', '汕尾', '2', '0', '21', '广东', '汕尾', null, 'SW', null);
INSERT INTO `t_pub_city` VALUES ('250', '441700', '阳江', '2', '0', '21', '广东', '阳江', null, 'YJ', null);
INSERT INTO `t_pub_city` VALUES ('251', '441900', '东莞', '2', '0', '21', '广东', '东莞', null, 'DG', null);
INSERT INTO `t_pub_city` VALUES ('252', '445100', '潮州', '2', '0', '21', '广东', '潮州', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('253', '445300', '云浮', '2', '0', '21', '广东', '云浮', null, 'YF', null);
INSERT INTO `t_pub_city` VALUES ('254', '450100', '南宁', '2', '0', '22', '广西壮族自治区', '南宁', null, 'NN', null);
INSERT INTO `t_pub_city` VALUES ('255', '450300', '桂林', '2', '0', '22', '广西壮族自治区', '桂林', null, 'GL', null);
INSERT INTO `t_pub_city` VALUES ('256', '450400', '梧州', '2', '0', '22', '广西壮族自治区', '梧州', null, 'WZ', null);
INSERT INTO `t_pub_city` VALUES ('257', '450600', '防城港', '2', '0', '22', '广西壮族自治区', '防城港', null, 'FCG', null);
INSERT INTO `t_pub_city` VALUES ('258', '450700', '钦州', '2', '0', '22', '广西壮族自治区', '钦州', null, 'QZ', null);
INSERT INTO `t_pub_city` VALUES ('259', '450900', '玉林', '2', '0', '22', '广西壮族自治区', '玉林', null, 'YL', null);
INSERT INTO `t_pub_city` VALUES ('260', '451000', '百色', '2', '0', '22', '广西壮族自治区', '百色', null, 'BS', null);
INSERT INTO `t_pub_city` VALUES ('261', '451200', '河池', '2', '0', '22', '广西壮族自治区', '河池', null, 'HC', null);
INSERT INTO `t_pub_city` VALUES ('262', '451300', '来宾', '2', '0', '22', '广西壮族自治区', '来宾', null, 'LB', null);
INSERT INTO `t_pub_city` VALUES ('263', '460100', '海口', '2', '0', '23', '海南', '海口', null, 'HK', null);
INSERT INTO `t_pub_city` VALUES ('264', '460200', '三亚', '2', '0', '23', '海南', '三亚', null, 'SY', null);
INSERT INTO `t_pub_city` VALUES ('265', '510100', '成都', '2', '0', '24', '四川', '成都', null, 'CD', null);
INSERT INTO `t_pub_city` VALUES ('266', '510300', '自贡', '2', '0', '24', '四川', '自贡', null, 'ZG', null);
INSERT INTO `t_pub_city` VALUES ('267', '510500', '泸州', '2', '0', '24', '四川', '泸州', null, 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('268', '510700', '绵阳', '2', '0', '24', '四川', '绵阳', null, 'MY', null);
INSERT INTO `t_pub_city` VALUES ('269', '510900', '遂宁', '2', '0', '24', '四川', '遂宁', null, 'SN', null);
INSERT INTO `t_pub_city` VALUES ('270', '511000', '内江', '2', '0', '24', '四川', '内江', null, 'NJ', null);
INSERT INTO `t_pub_city` VALUES ('271', '511300', '南充', '2', '0', '24', '四川', '南充', null, 'NC', null);
INSERT INTO `t_pub_city` VALUES ('272', '511500', '宜宾', '2', '0', '24', '四川', '宜宾', null, 'YB', null);
INSERT INTO `t_pub_city` VALUES ('273', '511700', '达州', '2', '0', '24', '四川', '达州', null, 'DZ', null);
INSERT INTO `t_pub_city` VALUES ('274', '511900', '巴中', '2', '0', '24', '四川', '巴中', null, 'BZ', null);
INSERT INTO `t_pub_city` VALUES ('275', '512000', '资阳', '2', '0', '24', '四川', '资阳', null, 'ZY', null);
INSERT INTO `t_pub_city` VALUES ('276', '513300', '甘孜藏族自治州', '2', '0', '24', '四川', '甘孜藏族自治州', null, 'GZCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('277', '520200', '六盘水', '2', '0', '25', '贵州', '六盘水', null, 'LPS', null);
INSERT INTO `t_pub_city` VALUES ('278', '520300', '遵义', '2', '0', '25', '贵州', '遵义', null, 'ZY', null);
INSERT INTO `t_pub_city` VALUES ('279', '520500', '毕节', '2', '0', '25', '贵州', '毕节', null, 'BJ', null);
INSERT INTO `t_pub_city` VALUES ('280', '522600', '黔东南苗族侗族自治州', '2', '0', '25', '贵州', '黔东南苗族侗族自治州', null, 'QDNMZDZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('281', '530100', '昆明', '2', '0', '26', '云南', '昆明', null, 'KM', null);
INSERT INTO `t_pub_city` VALUES ('282', '530400', '玉溪', '2', '0', '26', '云南', '玉溪', null, 'YX', null);
INSERT INTO `t_pub_city` VALUES ('283', '530600', '昭通', '2', '0', '26', '云南', '昭通', null, 'ZT', null);
INSERT INTO `t_pub_city` VALUES ('284', '530800', '普洱', '2', '0', '26', '云南', '普洱', null, 'PE', null);
INSERT INTO `t_pub_city` VALUES ('285', '532300', '楚雄彝族自治州', '2', '0', '26', '云南', '楚雄彝族自治州', null, 'CXYZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('286', '532600', '文山壮族苗族自治州', '2', '0', '26', '云南', '文山壮族苗族自治州', null, 'WSZZMZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('287', '533100', '德宏傣族景颇族自治州', '2', '0', '26', '云南', '德宏傣族景颇族自治州', null, 'DHDZJPZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('288', '533400', '迪庆藏族自治州', '2', '0', '26', '云南', '迪庆藏族自治州', null, 'DQCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('289', '540200', '日喀则', '2', '0', '27', '西藏自治区', '日喀则', null, 'RKZ', null);
INSERT INTO `t_pub_city` VALUES ('290', '540400', '林芝', '2', '0', '27', '西藏自治区', '林芝', null, 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('291', '542400', '那曲地区', '2', '0', '27', '西藏自治区', '那曲地区', null, 'NQDQ', null);
INSERT INTO `t_pub_city` VALUES ('292', '542500', '阿里地区', '2', '0', '27', '西藏自治区', '阿里地区', null, 'ALDQ', null);
INSERT INTO `t_pub_city` VALUES ('293', '610200', '铜川', '2', '0', '28', '陕西', '铜川', null, 'TC', null);
INSERT INTO `t_pub_city` VALUES ('294', '610400', '咸阳', '2', '0', '28', '陕西', '咸阳', null, 'XY', null);
INSERT INTO `t_pub_city` VALUES ('295', '610600', '延安', '2', '0', '28', '陕西', '延安', null, 'YA', null);
INSERT INTO `t_pub_city` VALUES ('296', '610700', '汉中', '2', '0', '28', '陕西', '汉中', null, 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('297', '610900', '安康', '2', '0', '28', '陕西', '安康', null, 'AK', null);
INSERT INTO `t_pub_city` VALUES ('298', '620100', '兰州', '2', '0', '29', '甘肃', '兰州', null, 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('299', '620300', '金昌', '2', '0', '29', '甘肃', '金昌', null, 'JC', null);
INSERT INTO `t_pub_city` VALUES ('300', '620500', '天水', '2', '0', '29', '甘肃', '天水', null, 'TS', null);
INSERT INTO `t_pub_city` VALUES ('301', '620600', '武威', '2', '0', '29', '甘肃', '武威', null, 'WW', null);
INSERT INTO `t_pub_city` VALUES ('302', '620800', '平凉', '2', '0', '29', '甘肃', '平凉', null, 'PL', null);
INSERT INTO `t_pub_city` VALUES ('303', '621000', '庆阳', '2', '0', '29', '甘肃', '庆阳', null, 'QY', null);
INSERT INTO `t_pub_city` VALUES ('304', '621200', '陇南', '2', '0', '29', '甘肃', '陇南', null, 'LN', null);
INSERT INTO `t_pub_city` VALUES ('305', '622900', '临夏回族自治州', '2', '0', '29', '甘肃', '临夏回族自治州', null, 'LXHZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('306', '630200', '海东', '2', '0', '30', '青海', '海东', null, 'HD', null);
INSERT INTO `t_pub_city` VALUES ('307', '632300', '黄南藏族自治州', '2', '0', '30', '青海', '黄南藏族自治州', null, 'HNCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('308', '632600', '果洛藏族自治州', '2', '0', '30', '青海', '果洛藏族自治州', null, 'GLCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('309', '632800', '海西蒙古族藏族自治州', '2', '0', '30', '青海', '海西蒙古族藏族自治州', null, 'HXMGZCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('310', '640200', '石嘴山', '2', '0', '31', '宁夏回族自治区', '石嘴山', null, 'SZS', null);
INSERT INTO `t_pub_city` VALUES ('311', '640400', '固原', '2', '0', '31', '宁夏回族自治区', '固原', null, 'GY', null);
INSERT INTO `t_pub_city` VALUES ('312', '640500', '中卫', '2', '0', '31', '宁夏回族自治区', '中卫', null, 'ZW', null);
INSERT INTO `t_pub_city` VALUES ('313', '650200', '克拉玛依', '2', '0', '32', '新疆维吾尔自治区', '克拉玛依', null, 'KLMY', null);
INSERT INTO `t_pub_city` VALUES ('314', '650400', '吐鲁番', '2', '0', '32', '新疆维吾尔自治区', '吐鲁番', null, 'TLF', null);
INSERT INTO `t_pub_city` VALUES ('315', '652300', '昌吉回族自治州', '2', '0', '32', '新疆维吾尔自治区', '昌吉回族自治州', null, 'CJHZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('316', '410900', '濮阳', '2', '0', '8', '河南', '濮阳', null, 'PY', null);
INSERT INTO `t_pub_city` VALUES ('317', '411200', '三门峡', '2', '0', '8', '河南', '三门峡', null, 'SMX', null);
INSERT INTO `t_pub_city` VALUES ('318', '411400', '商丘', '2', '0', '8', '河南', '商丘', null, 'SQ', null);
INSERT INTO `t_pub_city` VALUES ('319', '411600', '周口', '2', '0', '8', '河南', '周口', null, 'ZK', null);
INSERT INTO `t_pub_city` VALUES ('320', '420100', '武汉', '2', '0', '19', '湖北', '武汉', null, 'WH', '1');
INSERT INTO `t_pub_city` VALUES ('321', '420500', '宜昌', '2', '0', '19', '湖北', '宜昌', null, 'YC', null);
INSERT INTO `t_pub_city` VALUES ('322', '420700', '鄂州', '2', '0', '19', '湖北', '鄂州', null, 'EZ', null);
INSERT INTO `t_pub_city` VALUES ('323', '420900', '孝感', '2', '0', '19', '湖北', '孝感', null, 'XG', null);
INSERT INTO `t_pub_city` VALUES ('324', '421100', '黄冈', '2', '0', '19', '湖北', '黄冈', null, 'HG', null);
INSERT INTO `t_pub_city` VALUES ('325', '422800', '恩施土家族苗族自治州', '2', '0', '19', '湖北', '恩施土家族苗族自治州', null, 'ESTJZMZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('326', '430200', '株洲', '2', '0', '20', '湖南', '株洲', null, 'ZZ', '1');
INSERT INTO `t_pub_city` VALUES ('327', '430400', '衡阳', '2', '0', '20', '湖南', '衡阳', null, 'HY', null);
INSERT INTO `t_pub_city` VALUES ('328', '430700', '常德', '2', '0', '20', '湖南', '常德', null, 'CD', '1');
INSERT INTO `t_pub_city` VALUES ('329', '430900', '益阳', '2', '0', '20', '湖南', '益阳', null, 'YY', null);
INSERT INTO `t_pub_city` VALUES ('330', '431100', '永州', '2', '0', '20', '湖南', '永州', null, 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('331', '431300', '娄底', '2', '0', '20', '湖南', '娄底', null, 'LD', null);
INSERT INTO `t_pub_city` VALUES ('332', '440100', '广州', '2', '0', '21', '广东', '广州', null, 'AZ', null);
INSERT INTO `t_pub_city` VALUES ('333', '440200', '韶关', '2', '0', '21', '广东', '韶关', null, 'SG', null);
INSERT INTO `t_pub_city` VALUES ('334', '440500', '汕头', '2', '0', '21', '广东', '汕头', null, 'ST', null);
INSERT INTO `t_pub_city` VALUES ('335', '440700', '江门', '2', '0', '21', '广东', '江门', null, 'JM', null);
INSERT INTO `t_pub_city` VALUES ('336', '440900', '茂名', '2', '0', '21', '广东', '茂名', null, 'MM', null);
INSERT INTO `t_pub_city` VALUES ('337', '441300', '惠州', '2', '0', '21', '广东', '惠州', null, 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('338', '441600', '河源', '2', '0', '21', '广东', '河源', null, 'HY', null);
INSERT INTO `t_pub_city` VALUES ('339', '441800', '清远', '2', '0', '21', '广东', '清远', null, 'QY', null);
INSERT INTO `t_pub_city` VALUES ('340', '442000', '中山', '2', '0', '21', '广东', '中山', null, 'ZS', null);
INSERT INTO `t_pub_city` VALUES ('341', '445200', '揭阳', '2', '0', '21', '广东', '揭阳', null, 'JY', null);
INSERT INTO `t_pub_city` VALUES ('342', '450200', '柳州', '2', '0', '22', '广西壮族自治区', '柳州', null, 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('343', '450500', '北海', '2', '0', '22', '广西壮族自治区', '北海', null, 'BH', null);
INSERT INTO `t_pub_city` VALUES ('344', '450800', '贵港', '2', '0', '22', '广西壮族自治区', '贵港', null, 'GG', null);
INSERT INTO `t_pub_city` VALUES ('345', '451100', '贺州', '2', '0', '22', '广西壮族自治区', '贺州', null, 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('346', '451400', '崇左', '2', '0', '22', '广西壮族自治区', '崇左', null, 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('347', '460300', '三沙', '2', '0', '23', '海南', '三沙', null, 'SS', null);
INSERT INTO `t_pub_city` VALUES ('348', '500101', '万州区', '2', '0', '34', '重庆', '万州区', null, 'WZQ', null);
INSERT INTO `t_pub_city` VALUES ('349', '500103', '渝中区', '2', '0', '34', '重庆', '渝中区', null, 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('350', '500105', '江北区', '2', '0', '34', '重庆', '江北区', null, 'JBQ', null);
INSERT INTO `t_pub_city` VALUES ('351', '500107', '九龙坡区', '2', '0', '34', '重庆', '九龙坡区', null, 'JLPQ', null);
INSERT INTO `t_pub_city` VALUES ('352', '500108', '南岸区', '2', '0', '34', '重庆', '南岸区', null, 'NAQ', null);
INSERT INTO `t_pub_city` VALUES ('353', '500110', '綦江区', '2', '0', '34', '重庆', '綦江区', null, 'QJQ', null);
INSERT INTO `t_pub_city` VALUES ('354', '500112', '渝北区', '2', '0', '34', '重庆', '渝北区', null, 'YBQ', null);
INSERT INTO `t_pub_city` VALUES ('355', '500114', '黔江区', '2', '0', '34', '重庆', '黔江区', null, 'QJQ', null);
INSERT INTO `t_pub_city` VALUES ('356', '500116', '江津区', '2', '0', '34', '重庆', '江津区', null, 'JJQ', null);
INSERT INTO `t_pub_city` VALUES ('357', '500118', '永川区', '2', '0', '34', '重庆', '永川区', null, 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('358', '500120', '璧山区', '2', '0', '34', '重庆', '璧山区', null, 'BSQ', null);
INSERT INTO `t_pub_city` VALUES ('359', '500152', '潼南区', '2', '0', '34', '重庆', '潼南区', null, 'TNQ', null);
INSERT INTO `t_pub_city` VALUES ('360', '500154', '开州区', '2', '0', '34', '重庆', '开州区', null, 'KZQ', null);
INSERT INTO `t_pub_city` VALUES ('361', '500229', '城口县', '2', '0', '34', '重庆', '城口县', null, 'CKX', null);
INSERT INTO `t_pub_city` VALUES ('362', '500231', '垫江县', '2', '0', '34', '重庆', '垫江县', null, 'DJX', null);
INSERT INTO `t_pub_city` VALUES ('363', '500233', '忠县', '2', '0', '34', '重庆', '忠县', null, 'ZX', null);
INSERT INTO `t_pub_city` VALUES ('364', '500236', '奉节县', '2', '0', '34', '重庆', '奉节县', null, 'FJX', null);
INSERT INTO `t_pub_city` VALUES ('365', '500238', '巫溪县', '2', '0', '34', '重庆', '巫溪县', null, 'WXX', null);
INSERT INTO `t_pub_city` VALUES ('366', '500241', '秀山土家族苗族自治县', '2', '0', '34', '重庆', '秀山土家族苗族自治县', null, 'XSTJZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('367', '500242', '酉阳土家族苗族自治县', '2', '0', '34', '重庆', '酉阳土家族苗族自治县', null, 'YYTJZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('368', '510400', '攀枝花', '2', '0', '24', '四川', '攀枝花', null, 'PZH', null);
INSERT INTO `t_pub_city` VALUES ('369', '510600', '德阳', '2', '0', '24', '四川', '德阳', null, 'DY', null);
INSERT INTO `t_pub_city` VALUES ('370', '510800', '广元', '2', '0', '24', '四川', '广元', null, 'AY', null);
INSERT INTO `t_pub_city` VALUES ('371', '511100', '乐山', '2', '0', '24', '四川', '乐山', null, 'LS', null);
INSERT INTO `t_pub_city` VALUES ('372', '511400', '眉山', '2', '0', '24', '四川', '眉山', null, 'MS', null);
INSERT INTO `t_pub_city` VALUES ('373', '511600', '广安', '2', '0', '24', '四川', '广安', null, 'AA', null);
INSERT INTO `t_pub_city` VALUES ('374', '511800', '雅安', '2', '0', '24', '四川', '雅安', null, 'YA', null);
INSERT INTO `t_pub_city` VALUES ('375', '513200', '阿坝藏族羌族自治州', '2', '0', '24', '四川', '阿坝藏族羌族自治州', null, 'ABCZQZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('376', '513400', '凉山彝族自治州', '2', '0', '24', '四川', '凉山彝族自治州', null, 'LSYZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('377', '520100', '贵阳', '2', '0', '25', '贵州', '贵阳', null, 'GY', null);
INSERT INTO `t_pub_city` VALUES ('378', '520400', '安顺', '2', '0', '25', '贵州', '安顺', null, 'AS', null);
INSERT INTO `t_pub_city` VALUES ('379', '520600', '铜仁', '2', '0', '25', '贵州', '铜仁', null, 'TR', '1');
INSERT INTO `t_pub_city` VALUES ('380', '522300', '黔西南布依族苗族自治州', '2', '0', '25', '贵州', '黔西南布依族苗族自治州', null, 'QXNBYZMZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('381', '522700', '黔南布依族苗族自治州', '2', '0', '25', '贵州', '黔南布依族苗族自治州', null, 'QNBYZMZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('382', '530300', '曲靖', '2', '0', '26', '云南', '曲靖', null, 'QJ', null);
INSERT INTO `t_pub_city` VALUES ('383', '530500', '保山', '2', '0', '26', '云南', '保山', null, 'BS', null);
INSERT INTO `t_pub_city` VALUES ('384', '530700', '丽江', '2', '0', '26', '云南', '丽江', null, 'LJ', null);
INSERT INTO `t_pub_city` VALUES ('385', '530900', '临沧', '2', '0', '26', '云南', '临沧', null, 'LC', null);
INSERT INTO `t_pub_city` VALUES ('386', '532500', '红河哈尼族彝族自治州', '2', '0', '26', '云南', '红河哈尼族彝族自治州', null, 'GHHNZYZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('387', '532800', '西双版纳傣族自治州', '2', '0', '26', '云南', '西双版纳傣族自治州', null, 'XSBNDZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('388', '532900', '大理白族自治州', '2', '0', '26', '云南', '大理白族自治州', null, 'DLBZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('389', '533300', '怒江傈僳族自治州', '2', '0', '26', '云南', '怒江傈僳族自治州', null, 'NJLSZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('390', '540100', '拉萨', '2', '0', '27', '西藏自治区', '拉萨', null, 'LS', null);
INSERT INTO `t_pub_city` VALUES ('391', '540300', '昌都', '2', '0', '27', '西藏自治区', '昌都', null, 'CD', null);
INSERT INTO `t_pub_city` VALUES ('392', '540500', '山南', '2', '0', '27', '西藏自治区', '山南', null, 'SN', null);
INSERT INTO `t_pub_city` VALUES ('393', '610100', '西安', '2', '0', '28', '陕西', '西安', null, 'XA', null);
INSERT INTO `t_pub_city` VALUES ('394', '610300', '宝鸡', '2', '0', '28', '陕西', '宝鸡', null, 'BJ', null);
INSERT INTO `t_pub_city` VALUES ('395', '610500', '渭南', '2', '0', '28', '陕西', '渭南', null, 'WN', null);
INSERT INTO `t_pub_city` VALUES ('396', '610800', '榆林', '2', '0', '28', '陕西', '榆林', null, 'YL', null);
INSERT INTO `t_pub_city` VALUES ('397', '611000', '商洛', '2', '0', '28', '陕西', '商洛', null, 'SL', null);
INSERT INTO `t_pub_city` VALUES ('398', '620200', '嘉峪关', '2', '0', '29', '甘肃', '嘉峪关', null, 'JYG', null);
INSERT INTO `t_pub_city` VALUES ('399', '620400', '白银', '2', '0', '29', '甘肃', '白银', null, 'BY', null);
INSERT INTO `t_pub_city` VALUES ('400', '620700', '张掖', '2', '0', '29', '甘肃', '张掖', null, 'ZY', null);
INSERT INTO `t_pub_city` VALUES ('401', '620900', '酒泉', '2', '0', '29', '甘肃', '酒泉', null, 'JQ', null);
INSERT INTO `t_pub_city` VALUES ('402', '621100', '定西', '2', '0', '29', '甘肃', '定西', null, 'DX', null);
INSERT INTO `t_pub_city` VALUES ('403', '623000', '甘南藏族自治州', '2', '0', '29', '甘肃', '甘南藏族自治州', null, 'GNCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('404', '630100', '西宁', '2', '0', '30', '青海', '西宁', null, 'XN', null);
INSERT INTO `t_pub_city` VALUES ('405', '632200', '海北藏族自治州', '2', '0', '30', '青海', '海北藏族自治州', null, 'HBCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('406', '632500', '海南藏族自治州', '2', '0', '30', '青海', '海南藏族自治州', null, 'HNCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('407', '632700', '玉树藏族自治州', '2', '0', '30', '青海', '玉树藏族自治州', null, 'YSCZZZZ', null);
INSERT INTO `t_pub_city` VALUES ('408', '640100', '银川', '2', '0', '31', '宁夏回族自治区', '银川', null, 'YC', null);
INSERT INTO `t_pub_city` VALUES ('409', '640300', '吴忠', '2', '0', '31', '宁夏回族自治区', '吴忠', null, 'WZ', null);
INSERT INTO `t_pub_city` VALUES ('410', '650100', '乌鲁木齐', '2', '0', '32', '新疆维吾尔自治区', '乌鲁木齐', null, 'WLMJ', null);
INSERT INTO `t_pub_city` VALUES ('411', '310104', '徐汇区', '2', '0', '33', '上海', '徐汇区', null, 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('412', '310106', '静安区', '2', '0', '33', '上海', '静安区', null, 'JAQ', null);
INSERT INTO `t_pub_city` VALUES ('413', '310109', '虹口区', '2', '0', '33', '上海', '虹口区', null, 'HKQ', null);
INSERT INTO `t_pub_city` VALUES ('414', '310112', '闵行区', '2', '0', '33', '上海', '闵行区', null, 'MHQ', null);
INSERT INTO `t_pub_city` VALUES ('415', '310114', '嘉定区', '2', '0', '33', '上海', '嘉定区', null, 'JDQ', null);
INSERT INTO `t_pub_city` VALUES ('416', '310116', '金山区', '2', '0', '33', '上海', '金山区', null, 'JSQ', null);
INSERT INTO `t_pub_city` VALUES ('417', '310118', '青浦区', '2', '0', '33', '上海', '青浦区', null, 'QPQ', null);
INSERT INTO `t_pub_city` VALUES ('418', '310151', '崇明区', '2', '0', '33', '上海', '崇明区', null, 'CMQ', null);
INSERT INTO `t_pub_city` VALUES ('419', '110101', '东城区', '2', '0', '9', '北京', '东城区', null, 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('420', '110105', '朝阳区', '2', '0', '9', '北京', '朝阳区', null, 'CYQ', null);
INSERT INTO `t_pub_city` VALUES ('421', '110107', '石景山区', '2', '0', '9', '北京', '石景山区', null, 'SJSQ', null);
INSERT INTO `t_pub_city` VALUES ('422', '110109', '门头沟区', '2', '0', '9', '北京', '门头沟区', null, 'MTGQ', null);
INSERT INTO `t_pub_city` VALUES ('423', '110112', '通州区', '2', '0', '9', '北京', '通州区', null, 'TZQ', null);
INSERT INTO `t_pub_city` VALUES ('424', '110114', '昌平区', '2', '0', '9', '北京', '昌平区', null, 'CPQ', null);
INSERT INTO `t_pub_city` VALUES ('425', '110116', '怀柔区', '2', '0', '9', '北京', '怀柔区', null, 'HRQ', null);
INSERT INTO `t_pub_city` VALUES ('426', '110118', '密云区', '2', '0', '9', '北京', '密云区', null, 'MYQ', null);
INSERT INTO `t_pub_city` VALUES ('427', '120101', '和平区', '2', '0', '10', '天津', '和平区', null, 'HPQ', null);
INSERT INTO `t_pub_city` VALUES ('428', '120103', '河西区', '2', '0', '10', '天津', '河西区', null, 'HXQ', null);
INSERT INTO `t_pub_city` VALUES ('429', '120105', '河北区', '2', '0', '10', '天津', '河北区', null, 'HBQ', null);
INSERT INTO `t_pub_city` VALUES ('430', '120110', '东丽区', '2', '0', '10', '天津', '东丽区', null, 'DLQ', null);
INSERT INTO `t_pub_city` VALUES ('431', '120112', '津南区', '2', '0', '10', '天津', '津南区', null, 'JNQ', null);
INSERT INTO `t_pub_city` VALUES ('432', '120114', '武清区', '2', '0', '10', '天津', '武清区', null, 'WQQ', null);
INSERT INTO `t_pub_city` VALUES ('433', '120116', '滨海新区', '2', '0', '10', '天津', '滨海新区', null, 'BHXQ', null);
INSERT INTO `t_pub_city` VALUES ('434', '120118', '静海区', '2', '0', '10', '天津', '静海区', null, 'JHQ', null);
INSERT INTO `t_pub_city` VALUES ('435', '500102', '涪陵区', '2', '0', '34', '重庆', '涪陵区', null, 'FLQ', null);
INSERT INTO `t_pub_city` VALUES ('436', '500104', '大渡口区', '2', '0', '34', '重庆', '大渡口区', null, 'DDKQ', null);
INSERT INTO `t_pub_city` VALUES ('437', '500106', '沙坪坝区', '2', '0', '34', '重庆', '沙坪坝区', null, 'SPBQ', null);
INSERT INTO `t_pub_city` VALUES ('438', '500109', '北碚区', '2', '0', '34', '重庆', '北碚区', null, 'BBQ', null);
INSERT INTO `t_pub_city` VALUES ('439', '500111', '大足区', '2', '0', '34', '重庆', '大足区', null, 'DZQ', null);
INSERT INTO `t_pub_city` VALUES ('440', '500113', '巴南区', '2', '0', '34', '重庆', '巴南区', null, 'BNQ', null);
INSERT INTO `t_pub_city` VALUES ('441', '500115', '长寿区', '2', '0', '34', '重庆', '长寿区', null, 'CSQ', null);
INSERT INTO `t_pub_city` VALUES ('442', '500117', '合川区', '2', '0', '34', '重庆', '合川区', null, 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('443', '500119', '南川区', '2', '0', '34', '重庆', '南川区', null, 'NCQ', null);
INSERT INTO `t_pub_city` VALUES ('444', '500151', '铜梁区', '2', '0', '34', '重庆', '铜梁区', null, 'TLQ', null);
INSERT INTO `t_pub_city` VALUES ('445', '500153', '荣昌区', '2', '0', '34', '重庆', '荣昌区', null, 'RCQ', null);
INSERT INTO `t_pub_city` VALUES ('446', '500228', '梁平县', '2', '0', '34', '重庆', '梁平县', null, 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('447', '500230', '丰都县', '2', '0', '34', '重庆', '丰都县', null, 'FDX', null);
INSERT INTO `t_pub_city` VALUES ('448', '500232', '武隆县', '2', '0', '34', '重庆', '武隆县', null, 'WLX', null);
INSERT INTO `t_pub_city` VALUES ('449', '500235', '云阳县', '2', '0', '34', '重庆', '云阳县', null, 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('450', '500237', '巫山县', '2', '0', '34', '重庆', '巫山县', null, 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('451', '500240', '石柱土家族自治县', '2', '0', '34', '重庆', '石柱土家族自治县', null, 'SZTJZZZX', null);
INSERT INTO `t_pub_city` VALUES ('452', '500243', '彭水苗族土家族自治县', '2', '0', '34', '重庆', '彭水苗族土家族自治县', null, 'PSMZTJZZZX', null);
INSERT INTO `t_pub_city` VALUES ('453', '220605', '江源区', '3', '0', '125', '吉林', '白山', '江源区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('454', '220622', '靖宇县', '3', '0', '125', '吉林', '白山', '靖宇县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('455', '220681', '临江', '3', '0', '125', '吉林', '白山', '临江', 'LJ', null);
INSERT INTO `t_pub_city` VALUES ('456', '220721', '前郭尔罗斯蒙古族自治县', '3', '0', '135', '吉林', '松原', '前郭尔罗斯蒙古族自治县', 'QGELSMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('457', '220723', '乾安县', '3', '0', '135', '吉林', '松原', '乾安县', 'GAX', null);
INSERT INTO `t_pub_city` VALUES ('458', '220781', '扶余', '3', '0', '135', '吉林', '松原', '扶余', 'FY', null);
INSERT INTO `t_pub_city` VALUES ('459', '220821', '镇赉县', '3', '0', '35', '吉林', '白城', '镇赉县', 'ZLX', null);
INSERT INTO `t_pub_city` VALUES ('460', '220881', '洮南', '3', '0', '35', '吉林', '白城', '洮南', 'TN', null);
INSERT INTO `t_pub_city` VALUES ('461', '222402', '图们', '3', '0', '136', '吉林', '延边朝鲜族自治州', '图们', 'TM', null);
INSERT INTO `t_pub_city` VALUES ('462', '222405', '龙井', '3', '0', '136', '吉林', '延边朝鲜族自治州', '龙井', 'LJ', null);
INSERT INTO `t_pub_city` VALUES ('463', '222424', '汪清县', '3', '0', '136', '吉林', '延边朝鲜族自治州', '汪清县', 'WQX', null);
INSERT INTO `t_pub_city` VALUES ('464', '230102', '道里区', '3', '0', '36', '黑龙江', '哈尔滨', '道里区', 'DLQ', null);
INSERT INTO `t_pub_city` VALUES ('465', '230104', '道外区', '3', '0', '36', '黑龙江', '哈尔滨', '道外区', 'DWQ', null);
INSERT INTO `t_pub_city` VALUES ('466', '230109', '松北区', '3', '0', '36', '黑龙江', '哈尔滨', '松北区', 'SBQ', null);
INSERT INTO `t_pub_city` VALUES ('467', '230112', '阿城区', '3', '0', '36', '黑龙江', '哈尔滨', '阿城区', 'ACQ', null);
INSERT INTO `t_pub_city` VALUES ('468', '230123', '依兰县', '3', '0', '36', '黑龙江', '哈尔滨', '依兰县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('469', '230126', '巴彦县', '3', '0', '36', '黑龙江', '哈尔滨', '巴彦县', 'BYX', null);
INSERT INTO `t_pub_city` VALUES ('470', '230128', '通河县', '3', '0', '36', '黑龙江', '哈尔滨', '通河县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('471', '230183', '尚志', '3', '0', '36', '黑龙江', '哈尔滨', '尚志', 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('472', '230202', '龙沙区', '3', '0', '137', '黑龙江', '齐齐哈尔', '龙沙区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('473', '230204', '铁锋区', '3', '0', '137', '黑龙江', '齐齐哈尔', '铁锋区', 'TFQ', null);
INSERT INTO `t_pub_city` VALUES ('474', '230206', '富拉尔基区', '3', '0', '137', '黑龙江', '齐齐哈尔', '富拉尔基区', 'FLEJQ', null);
INSERT INTO `t_pub_city` VALUES ('475', '230208', '梅里斯达斡尔族区', '3', '0', '137', '黑龙江', '齐齐哈尔', '梅里斯达斡尔族区', 'MLSDWEZQ', null);
INSERT INTO `t_pub_city` VALUES ('476', '230224', '泰来县', '3', '0', '137', '黑龙江', '齐齐哈尔', '泰来县', 'TLX', null);
INSERT INTO `t_pub_city` VALUES ('477', '230227', '富裕县', '3', '0', '137', '黑龙江', '齐齐哈尔', '富裕县', 'FYX', null);
INSERT INTO `t_pub_city` VALUES ('478', '230230', '克东县', '3', '0', '137', '黑龙江', '齐齐哈尔', '克东县', 'KDX', null);
INSERT INTO `t_pub_city` VALUES ('479', '230281', '讷河', '3', '0', '137', '黑龙江', '齐齐哈尔', '讷河', 'NH', null);
INSERT INTO `t_pub_city` VALUES ('480', '230303', '恒山区', '3', '0', '37', '黑龙江', '鸡西', '恒山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('481', '230305', '梨树区', '3', '0', '37', '黑龙江', '鸡西', '梨树区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('482', '230307', '麻山区', '3', '0', '37', '黑龙江', '鸡西', '麻山区', 'MSQ', null);
INSERT INTO `t_pub_city` VALUES ('483', '230381', '虎林', '3', '0', '37', '黑龙江', '鸡西', '虎林', 'HL', null);
INSERT INTO `t_pub_city` VALUES ('484', '230402', '向阳区', '3', '0', '138', '黑龙江', '鹤岗', '向阳区', 'XYQ', null);
INSERT INTO `t_pub_city` VALUES ('485', '230404', '南山区', '3', '0', '138', '黑龙江', '鹤岗', '南山区', 'NSQ', null);
INSERT INTO `t_pub_city` VALUES ('486', '230406', '东山区', '3', '0', '138', '黑龙江', '鹤岗', '东山区', 'DSQ', null);
INSERT INTO `t_pub_city` VALUES ('487', '230407', '兴山区', '3', '0', '138', '黑龙江', '鹤岗', '兴山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('488', '230422', '绥滨县', '3', '0', '138', '黑龙江', '鹤岗', '绥滨县', 'SBX', null);
INSERT INTO `t_pub_city` VALUES ('489', '230503', '岭东区', '3', '0', '38', '黑龙江', '双鸭山', '岭东区', 'LDQ', null);
INSERT INTO `t_pub_city` VALUES ('490', '230506', '宝山区', '3', '0', '38', '黑龙江', '双鸭山', '宝山区', 'BSQ', null);
INSERT INTO `t_pub_city` VALUES ('491', '230522', '友谊县', '3', '0', '38', '黑龙江', '双鸭山', '友谊县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('492', '230602', '萨尔图区', '3', '0', '139', '黑龙江', '大庆', '萨尔图区', 'SETQ', null);
INSERT INTO `t_pub_city` VALUES ('493', '230603', '龙凤区', '3', '0', '139', '黑龙江', '大庆', '龙凤区', 'LFQ', null);
INSERT INTO `t_pub_city` VALUES ('494', '230605', '红岗区', '3', '0', '139', '黑龙江', '大庆', '红岗区', 'GGQ', null);
INSERT INTO `t_pub_city` VALUES ('495', '230621', '肇州县', '3', '0', '139', '黑龙江', '大庆', '肇州县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('496', '230623', '林甸县', '3', '0', '139', '黑龙江', '大庆', '林甸县', 'LDX', null);
INSERT INTO `t_pub_city` VALUES ('497', '230702', '伊春区', '3', '0', '39', '黑龙江', '伊春', '伊春区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('498', '230703', '南岔区', '3', '0', '39', '黑龙江', '伊春', '南岔区', 'NCQ', null);
INSERT INTO `t_pub_city` VALUES ('499', '230705', '西林区', '3', '0', '39', '黑龙江', '伊春', '西林区', 'XLQ', null);
INSERT INTO `t_pub_city` VALUES ('500', '230707', '新青区', '3', '0', '39', '黑龙江', '伊春', '新青区', 'XQQ', null);
INSERT INTO `t_pub_city` VALUES ('501', '230709', '金山屯区', '3', '0', '39', '黑龙江', '伊春', '金山屯区', 'JSTQ', null);
INSERT INTO `t_pub_city` VALUES ('502', '230711', '乌马河区', '3', '0', '39', '黑龙江', '伊春', '乌马河区', 'WMHQ', null);
INSERT INTO `t_pub_city` VALUES ('503', '230713', '带岭区', '3', '0', '39', '黑龙江', '伊春', '带岭区', 'DLQ', null);
INSERT INTO `t_pub_city` VALUES ('504', '230714', '乌伊岭区', '3', '0', '39', '黑龙江', '伊春', '乌伊岭区', 'WYLQ', null);
INSERT INTO `t_pub_city` VALUES ('505', '230716', '上甘岭区', '3', '0', '39', '黑龙江', '伊春', '上甘岭区', 'SGLQ', null);
INSERT INTO `t_pub_city` VALUES ('506', '230781', '铁力', '3', '0', '39', '黑龙江', '伊春', '铁力', 'TL', null);
INSERT INTO `t_pub_city` VALUES ('507', '230804', '前进区', '3', '0', '140', '黑龙江', '佳木斯', '前进区', 'QJQ', null);
INSERT INTO `t_pub_city` VALUES ('508', '230811', '郊区', '3', '0', '140', '黑龙江', '佳木斯', '郊区', 'JQ', null);
INSERT INTO `t_pub_city` VALUES ('509', '230826', '桦川县', '3', '0', '140', '黑龙江', '佳木斯', '桦川县', 'HCX', null);
INSERT INTO `t_pub_city` VALUES ('510', '230882', '富锦', '3', '0', '140', '黑龙江', '佳木斯', '富锦', 'FJ', null);
INSERT INTO `t_pub_city` VALUES ('511', '230902', '新兴区', '3', '0', '141', '黑龙江', '七台河', '新兴区', 'XXQ', null);
INSERT INTO `t_pub_city` VALUES ('512', '230904', '茄子河区', '3', '0', '141', '黑龙江', '七台河', '茄子河区', 'JZHQ', null);
INSERT INTO `t_pub_city` VALUES ('513', '231002', '东安区', '3', '0', '40', '黑龙江', '牡丹江', '东安区', 'DAQ', null);
INSERT INTO `t_pub_city` VALUES ('514', '231004', '爱民区', '3', '0', '40', '黑龙江', '牡丹江', '爱民区', 'AMQ', null);
INSERT INTO `t_pub_city` VALUES ('515', '231025', '林口县', '3', '0', '40', '黑龙江', '牡丹江', '林口县', 'LKX', null);
INSERT INTO `t_pub_city` VALUES ('516', '231083', '海林', '3', '0', '40', '黑龙江', '牡丹江', '海林', 'HL', null);
INSERT INTO `t_pub_city` VALUES ('517', '231085', '穆棱', '3', '0', '40', '黑龙江', '牡丹江', '穆棱', 'ML', null);
INSERT INTO `t_pub_city` VALUES ('518', '231102', '爱辉区', '3', '0', '142', '黑龙江', '黑河', '爱辉区', 'AHQ', null);
INSERT INTO `t_pub_city` VALUES ('519', '231123', '逊克县', '3', '0', '142', '黑龙江', '黑河', '逊克县', 'XKX', null);
INSERT INTO `t_pub_city` VALUES ('520', '231181', '北安', '3', '0', '142', '黑龙江', '黑河', '北安', 'BA', null);
INSERT INTO `t_pub_city` VALUES ('521', '231202', '北林区', '3', '0', '41', '黑龙江', '绥化', '北林区', 'BLQ', null);
INSERT INTO `t_pub_city` VALUES ('522', '231221', '望奎县', '3', '0', '41', '黑龙江', '绥化', '望奎县', 'WKX', null);
INSERT INTO `t_pub_city` VALUES ('523', '231223', '青冈县', '3', '0', '41', '黑龙江', '绥化', '青冈县', 'QGX', null);
INSERT INTO `t_pub_city` VALUES ('524', '231225', '明水县', '3', '0', '41', '黑龙江', '绥化', '明水县', 'MSX', null);
INSERT INTO `t_pub_city` VALUES ('525', '231281', '安达', '3', '0', '41', '黑龙江', '绥化', '安达', 'AD', null);
INSERT INTO `t_pub_city` VALUES ('526', '231283', '海伦', '3', '0', '41', '黑龙江', '绥化', '海伦', 'HL', null);
INSERT INTO `t_pub_city` VALUES ('527', '232722', '塔河县', '3', '0', '143', '黑龙江', '大兴安岭地区', '塔河县', 'DHX', null);
INSERT INTO `t_pub_city` VALUES ('528', '320102', '玄武区', '3', '0', '50', '江苏', '南京', '玄武区', 'XWQ', null);
INSERT INTO `t_pub_city` VALUES ('529', '320105', '建邺区', '3', '0', '50', '江苏', '南京', '建邺区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('530', '320111', '浦口区', '3', '0', '50', '江苏', '南京', '浦口区', 'PKQ', null);
INSERT INTO `t_pub_city` VALUES ('531', '320114', '雨花台区', '3', '0', '50', '江苏', '南京', '雨花台区', 'YHTQ', null);
INSERT INTO `t_pub_city` VALUES ('532', '320116', '六合区', '3', '0', '50', '江苏', '南京', '六合区', 'LGQ', null);
INSERT INTO `t_pub_city` VALUES ('533', '320118', '高淳区', '3', '0', '50', '江苏', '南京', '高淳区', 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('534', '320206', '惠山区', '3', '0', '144', '江苏', '无锡', '惠山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('535', '320213', '梁溪区', '3', '0', '144', '江苏', '无锡', '梁溪区', 'LXQ', null);
INSERT INTO `t_pub_city` VALUES ('536', '320281', '江阴', '3', '0', '144', '江苏', '无锡', '江阴', 'JY', null);
INSERT INTO `t_pub_city` VALUES ('537', '320302', '鼓楼区', '3', '0', '51', '江苏', '徐州', '鼓楼区', 'GLQ', null);
INSERT INTO `t_pub_city` VALUES ('538', '320305', '贾汪区', '3', '0', '51', '江苏', '徐州', '贾汪区', 'GWQ', null);
INSERT INTO `t_pub_city` VALUES ('539', '320312', '铜山区', '3', '0', '51', '江苏', '徐州', '铜山区', 'TSQ', null);
INSERT INTO `t_pub_city` VALUES ('540', '320321', '丰县', '3', '0', '51', '江苏', '徐州', '丰县', 'FX', null);
INSERT INTO `t_pub_city` VALUES ('541', '320381', '新沂', '3', '0', '51', '江苏', '徐州', '新沂', 'XY', null);
INSERT INTO `t_pub_city` VALUES ('542', '320382', '邳州', '3', '0', '51', '江苏', '徐州', '邳州', 'PZ', null);
INSERT INTO `t_pub_city` VALUES ('543', '320404', '钟楼区', '3', '0', '145', '江苏', '常州', '钟楼区', 'ZLQ', null);
INSERT INTO `t_pub_city` VALUES ('544', '320412', '武进区', '3', '0', '145', '江苏', '常州', '武进区', 'WJQ', null);
INSERT INTO `t_pub_city` VALUES ('545', '320481', '溧阳', '3', '0', '145', '江苏', '常州', '溧阳', 'LY', null);
INSERT INTO `t_pub_city` VALUES ('546', '320506', '吴中区', '3', '0', '52', '江苏', '苏州', '吴中区', 'WZQ', null);
INSERT INTO `t_pub_city` VALUES ('547', '320508', '姑苏区', '3', '0', '52', '江苏', '苏州', '姑苏区', 'GSQ', null);
INSERT INTO `t_pub_city` VALUES ('548', '320581', '常熟', '3', '0', '52', '江苏', '苏州', '常熟', 'CS', null);
INSERT INTO `t_pub_city` VALUES ('549', '320583', '昆山', '3', '0', '52', '江苏', '苏州', '昆山', 'KS', null);
INSERT INTO `t_pub_city` VALUES ('550', '320602', '崇川区', '3', '0', '146', '江苏', '南通', '崇川区', 'CCQ', null);
INSERT INTO `t_pub_city` VALUES ('551', '320612', '通州区', '3', '0', '146', '江苏', '南通', '通州区', 'TZQ', null);
INSERT INTO `t_pub_city` VALUES ('552', '320623', '如东县', '3', '0', '146', '江苏', '南通', '如东县', 'RDX', null);
INSERT INTO `t_pub_city` VALUES ('553', '320682', '如皋', '3', '0', '146', '江苏', '南通', '如皋', 'RG', null);
INSERT INTO `t_pub_city` VALUES ('554', '320703', '连云区', '3', '0', '53', '江苏', '连云港', '连云区', 'LYQ', null);
INSERT INTO `t_pub_city` VALUES ('555', '320707', '赣榆区', '3', '0', '53', '江苏', '连云港', '赣榆区', 'GYQ', null);
INSERT INTO `t_pub_city` VALUES ('556', '320723', '灌云县', '3', '0', '53', '江苏', '连云港', '灌云县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('557', '320802', '清河区', '3', '0', '147', '江苏', '淮安', '清河区', 'QHQ', null);
INSERT INTO `t_pub_city` VALUES ('558', '320804', '淮阴区', '3', '0', '147', '江苏', '淮安', '淮阴区', 'HYQ', null);
INSERT INTO `t_pub_city` VALUES ('559', '320813', '洪泽区', '3', '0', '147', '江苏', '淮安', '洪泽区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('560', '320831', '金湖县', '3', '0', '147', '江苏', '淮安', '金湖县', 'JHX', null);
INSERT INTO `t_pub_city` VALUES ('561', '320902', '亭湖区', '3', '0', '148', '江苏', '盐城', '亭湖区', 'THQ', null);
INSERT INTO `t_pub_city` VALUES ('562', '320904', '大丰区', '3', '0', '148', '江苏', '盐城', '大丰区', 'DFQ', null);
INSERT INTO `t_pub_city` VALUES ('563', '320922', '滨海县', '3', '0', '148', '江苏', '盐城', '滨海县', 'BHX', null);
INSERT INTO `t_pub_city` VALUES ('564', '320924', '射阳县', '3', '0', '148', '江苏', '盐城', '射阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('565', '320981', '东台', '3', '0', '148', '江苏', '盐城', '东台', 'DT', null);
INSERT INTO `t_pub_city` VALUES ('566', '321003', '邗江区', '3', '0', '54', '江苏', '扬州', '邗江区', 'HJQ', null);
INSERT INTO `t_pub_city` VALUES ('567', '321023', '宝应县', '3', '0', '54', '江苏', '扬州', '宝应县', 'BYX', null);
INSERT INTO `t_pub_city` VALUES ('568', '321102', '京口区', '3', '0', '149', '江苏', '镇江', '京口区', 'JKQ', null);
INSERT INTO `t_pub_city` VALUES ('569', '321112', '丹徒区', '3', '0', '149', '江苏', '镇江', '丹徒区', 'DTQ', null);
INSERT INTO `t_pub_city` VALUES ('570', '321183', '句容', '3', '0', '149', '江苏', '镇江', '句容', 'GR', null);
INSERT INTO `t_pub_city` VALUES ('571', '321203', '高港区', '3', '0', '55', '江苏', '泰州', '高港区', 'GGQ', null);
INSERT INTO `t_pub_city` VALUES ('572', '321282', '靖江', '3', '0', '55', '江苏', '泰州', '靖江', 'JJ', null);
INSERT INTO `t_pub_city` VALUES ('573', '321302', '宿城区', '3', '0', '150', '江苏', '宿迁', '宿城区', 'SCQ', null);
INSERT INTO `t_pub_city` VALUES ('574', '321323', '泗阳县', '3', '0', '150', '江苏', '宿迁', '泗阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('575', '330102', '上城区', '3', '0', '56', '浙江', '杭州', '上城区', 'SCQ', null);
INSERT INTO `t_pub_city` VALUES ('576', '330104', '江干区', '3', '0', '56', '浙江', '杭州', '江干区', 'JGQ', null);
INSERT INTO `t_pub_city` VALUES ('577', '330106', '西湖区', '3', '0', '56', '浙江', '杭州', '西湖区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('578', '330110', '余杭区', '3', '0', '56', '浙江', '杭州', '余杭区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('579', '330122', '桐庐县', '3', '0', '56', '浙江', '杭州', '桐庐县', 'TLX', null);
INSERT INTO `t_pub_city` VALUES ('580', '330182', '建德', '3', '0', '56', '浙江', '杭州', '建德', 'JD', null);
INSERT INTO `t_pub_city` VALUES ('581', '330204', '江东区', '3', '0', '151', '浙江', '宁波', '江东区', 'JDQ', null);
INSERT INTO `t_pub_city` VALUES ('582', '330206', '北仑区', '3', '0', '151', '浙江', '宁波', '北仑区', 'BLQ', null);
INSERT INTO `t_pub_city` VALUES ('583', '330211', '镇海区', '3', '0', '151', '浙江', '宁波', '镇海区', 'ZHQ', null);
INSERT INTO `t_pub_city` VALUES ('584', '330225', '象山县', '3', '0', '151', '浙江', '宁波', '象山县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('585', '330281', '余姚', '3', '0', '151', '浙江', '宁波', '余姚', 'YY', null);
INSERT INTO `t_pub_city` VALUES ('586', '330283', '奉化', '3', '0', '151', '浙江', '宁波', '奉化', 'FH', null);
INSERT INTO `t_pub_city` VALUES ('587', '330303', '龙湾区', '3', '0', '152', '浙江', '温州', '龙湾区', 'LWQ', null);
INSERT INTO `t_pub_city` VALUES ('588', '330305', '洞头区', '3', '0', '152', '浙江', '温州', '洞头区', 'DTQ', null);
INSERT INTO `t_pub_city` VALUES ('589', '330326', '平阳县', '3', '0', '152', '浙江', '温州', '平阳县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('590', '330327', '苍南县', '3', '0', '152', '浙江', '温州', '苍南县', 'CNX', null);
INSERT INTO `t_pub_city` VALUES ('591', '330329', '泰顺县', '3', '0', '152', '浙江', '温州', '泰顺县', 'TSX', null);
INSERT INTO `t_pub_city` VALUES ('592', '330382', '乐清', '3', '0', '152', '浙江', '温州', '乐清', 'LQ', null);
INSERT INTO `t_pub_city` VALUES ('593', '330411', '秀洲区', '3', '0', '57', '浙江', '嘉兴', '秀洲区', 'XZQ', null);
INSERT INTO `t_pub_city` VALUES ('594', '330424', '海盐县', '3', '0', '57', '浙江', '嘉兴', '海盐县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('595', '330482', '平湖', '3', '0', '57', '浙江', '嘉兴', '平湖', 'PH', null);
INSERT INTO `t_pub_city` VALUES ('596', '330502', '吴兴区', '3', '0', '153', '浙江', '湖州', '吴兴区', 'WXQ', null);
INSERT INTO `t_pub_city` VALUES ('597', '330521', '德清县', '3', '0', '153', '浙江', '湖州', '德清县', 'DQX', null);
INSERT INTO `t_pub_city` VALUES ('598', '330523', '安吉县', '3', '0', '153', '浙江', '湖州', '安吉县', 'AJX', null);
INSERT INTO `t_pub_city` VALUES ('599', '330603', '柯桥区', '3', '0', '154', '浙江', '绍兴', '柯桥区', 'KQQ', null);
INSERT INTO `t_pub_city` VALUES ('600', '330624', '新昌县', '3', '0', '154', '浙江', '绍兴', '新昌县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('601', '330683', '嵊州', '3', '0', '154', '浙江', '绍兴', '嵊州', 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('602', '330703', '金东区', '3', '0', '58', '浙江', '金华', '金东区', 'JDQ', null);
INSERT INTO `t_pub_city` VALUES ('603', '330726', '浦江县', '3', '0', '58', '浙江', '金华', '浦江县', 'PJX', null);
INSERT INTO `t_pub_city` VALUES ('604', '330781', '兰溪', '3', '0', '58', '浙江', '金华', '兰溪', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('605', '330782', '义乌', '3', '0', '58', '浙江', '金华', '义乌', 'YW', null);
INSERT INTO `t_pub_city` VALUES ('606', '330784', '永康', '3', '0', '58', '浙江', '金华', '永康', 'YK', null);
INSERT INTO `t_pub_city` VALUES ('607', '330803', '衢江区', '3', '0', '155', '浙江', '衢州', '衢江区', 'QJQ', null);
INSERT INTO `t_pub_city` VALUES ('608', '330824', '开化县', '3', '0', '155', '浙江', '衢州', '开化县', 'KHX', null);
INSERT INTO `t_pub_city` VALUES ('609', '330881', '江山', '3', '0', '155', '浙江', '衢州', '江山', 'JS', null);
INSERT INTO `t_pub_city` VALUES ('610', '330903', '普陀区', '3', '0', '59', '浙江', '舟山', '普陀区', 'PTQ', null);
INSERT INTO `t_pub_city` VALUES ('611', '330922', '嵊泗县', '3', '0', '59', '浙江', '舟山', '嵊泗县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('612', '331003', '黄岩区', '3', '0', '156', '浙江', '台州', '黄岩区', 'HYQ', null);
INSERT INTO `t_pub_city` VALUES ('613', '331021', '玉环县', '3', '0', '156', '浙江', '台州', '玉环县', 'YHX', null);
INSERT INTO `t_pub_city` VALUES ('614', '331023', '天台县', '3', '0', '156', '浙江', '台州', '天台县', 'TTX', null);
INSERT INTO `t_pub_city` VALUES ('615', '331081', '温岭', '3', '0', '156', '浙江', '台州', '温岭', 'WL', null);
INSERT INTO `t_pub_city` VALUES ('616', '331102', '莲都区', '3', '0', '60', '浙江', '丽水', '莲都区', 'LDQ', null);
INSERT INTO `t_pub_city` VALUES ('617', '331122', '缙云县', '3', '0', '60', '浙江', '丽水', '缙云县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('618', '331124', '松阳县', '3', '0', '60', '浙江', '丽水', '松阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('619', '331126', '庆元县', '3', '0', '60', '浙江', '丽水', '庆元县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('620', '331127', '景宁畲族自治县', '3', '0', '60', '浙江', '丽水', '景宁畲族自治县', 'JNSZZZX', null);
INSERT INTO `t_pub_city` VALUES ('621', '340102', '瑶海区', '3', '0', '157', '安徽', '合肥', '瑶海区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('622', '340104', '蜀山区', '3', '0', '157', '安徽', '合肥', '蜀山区', 'SSQ', null);
INSERT INTO `t_pub_city` VALUES ('623', '340121', '长丰县', '3', '0', '157', '安徽', '合肥', '长丰县', 'CFX', null);
INSERT INTO `t_pub_city` VALUES ('624', '340123', '肥西县', '3', '0', '157', '安徽', '合肥', '肥西县', 'FXX', null);
INSERT INTO `t_pub_city` VALUES ('625', '340181', '巢湖', '3', '0', '157', '安徽', '合肥', '巢湖', 'CH', null);
INSERT INTO `t_pub_city` VALUES ('626', '340203', '弋江区', '3', '0', '61', '安徽', '芜湖', '弋江区', 'YJQ', null);
INSERT INTO `t_pub_city` VALUES ('627', '340208', '三山区', '3', '0', '61', '安徽', '芜湖', '三山区', 'SSQ', null);
INSERT INTO `t_pub_city` VALUES ('628', '340222', '繁昌县', '3', '0', '61', '安徽', '芜湖', '繁昌县', 'FCX', null);
INSERT INTO `t_pub_city` VALUES ('629', '340225', '无为县', '3', '0', '61', '安徽', '芜湖', '无为县', 'MWX', null);
INSERT INTO `t_pub_city` VALUES ('630', '340303', '蚌山区', '3', '0', '158', '安徽', '蚌埠', '蚌山区', 'BSQ', null);
INSERT INTO `t_pub_city` VALUES ('631', '340311', '淮上区', '3', '0', '158', '安徽', '蚌埠', '淮上区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('632', '340322', '五河县', '3', '0', '158', '安徽', '蚌埠', '五河县', 'WHX', null);
INSERT INTO `t_pub_city` VALUES ('633', '340323', '固镇县', '3', '0', '158', '安徽', '蚌埠', '固镇县', 'GZX', null);
INSERT INTO `t_pub_city` VALUES ('634', '340403', '田家庵区', '3', '0', '159', '安徽', '淮南', '田家庵区', 'TJAQ', null);
INSERT INTO `t_pub_city` VALUES ('635', '340405', '八公山区', '3', '0', '159', '安徽', '淮南', '八公山区', 'BGSQ', null);
INSERT INTO `t_pub_city` VALUES ('636', '340421', '凤台县', '3', '0', '159', '安徽', '淮南', '凤台县', 'FTX', null);
INSERT INTO `t_pub_city` VALUES ('637', '340503', '花山区', '3', '0', '62', '安徽', '马鞍山', '花山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('638', '340506', '博望区', '3', '0', '62', '安徽', '马鞍山', '博望区', 'BWQ', null);
INSERT INTO `t_pub_city` VALUES ('639', '340522', '含山县', '3', '0', '62', '安徽', '马鞍山', '含山县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('640', '340603', '相山区', '3', '0', '160', '安徽', '淮北', '相山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('641', '340604', '烈山区', '3', '0', '160', '安徽', '淮北', '烈山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('642', '340705', '铜官区', '3', '0', '63', '安徽', '铜陵', '铜官区', 'TGQ', null);
INSERT INTO `t_pub_city` VALUES ('643', '340711', '郊区', '3', '0', '63', '安徽', '铜陵', '郊区', 'JQ', null);
INSERT INTO `t_pub_city` VALUES ('644', '340802', '迎江区', '3', '0', '161', '安徽', '安庆', '迎江区', 'YJQ', null);
INSERT INTO `t_pub_city` VALUES ('645', '340811', '宜秀区', '3', '0', '161', '安徽', '安庆', '宜秀区', 'YXQ', null);
INSERT INTO `t_pub_city` VALUES ('646', '340824', '潜山县', '3', '0', '161', '安徽', '安庆', '潜山县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('647', '340826', '宿松县', '3', '0', '161', '安徽', '安庆', '宿松县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('648', '340828', '岳西县', '3', '0', '161', '安徽', '安庆', '岳西县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('649', '341002', '屯溪区', '3', '0', '64', '安徽', '黄山', '屯溪区', 'TXQ', null);
INSERT INTO `t_pub_city` VALUES ('650', '341004', '徽州区', '3', '0', '64', '安徽', '黄山', '徽州区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('651', '341022', '休宁县', '3', '0', '64', '安徽', '黄山', '休宁县', 'XNX', null);
INSERT INTO `t_pub_city` VALUES ('652', '341024', '祁门县', '3', '0', '64', '安徽', '黄山', '祁门县', 'QMX', null);
INSERT INTO `t_pub_city` VALUES ('653', '341103', '南谯区', '3', '0', '162', '安徽', '滁州', '南谯区', 'NQQ', null);
INSERT INTO `t_pub_city` VALUES ('654', '341124', '全椒县', '3', '0', '162', '安徽', '滁州', '全椒县', 'QJX', null);
INSERT INTO `t_pub_city` VALUES ('655', '341126', '凤阳县', '3', '0', '162', '安徽', '滁州', '凤阳县', 'FYX', null);
INSERT INTO `t_pub_city` VALUES ('656', '341182', '明光', '3', '0', '162', '安徽', '滁州', '明光', 'MG', null);
INSERT INTO `t_pub_city` VALUES ('657', '341203', '颍东区', '3', '0', '163', '安徽', '阜阳', '颍东区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('658', '341221', '临泉县', '3', '0', '163', '安徽', '阜阳', '临泉县', 'LQX', null);
INSERT INTO `t_pub_city` VALUES ('659', '341225', '阜南县', '3', '0', '163', '安徽', '阜阳', '阜南县', 'FNX', null);
INSERT INTO `t_pub_city` VALUES ('660', '341226', '颍上县', '3', '0', '163', '安徽', '阜阳', '颍上县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('661', '341302', '埇桥区', '3', '0', '65', '安徽', '宿州', '埇桥区', 'YQQ', null);
INSERT INTO `t_pub_city` VALUES ('662', '341322', '萧县', '3', '0', '65', '安徽', '宿州', '萧县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('663', '341324', '泗县', '3', '0', '65', '安徽', '宿州', '泗县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('664', '341503', '裕安区', '3', '0', '164', '安徽', '六安', '裕安区', 'YAQ', null);
INSERT INTO `t_pub_city` VALUES ('665', '341522', '霍邱县', '3', '0', '164', '安徽', '六安', '霍邱县', 'HQX', null);
INSERT INTO `t_pub_city` VALUES ('666', '341524', '金寨县', '3', '0', '164', '安徽', '六安', '金寨县', 'JZX', null);
INSERT INTO `t_pub_city` VALUES ('667', '341602', '谯城区', '3', '0', '66', '安徽', '亳州', '谯城区', 'QCQ', null);
INSERT INTO `t_pub_city` VALUES ('668', '341622', '蒙城县', '3', '0', '66', '安徽', '亳州', '蒙城县', 'MCX', null);
INSERT INTO `t_pub_city` VALUES ('669', '341702', '贵池区', '3', '0', '165', '安徽', '池州', '贵池区', 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('670', '341722', '石台县', '3', '0', '165', '安徽', '池州', '石台县', 'STX', null);
INSERT INTO `t_pub_city` VALUES ('671', '341802', '宣州区', '3', '0', '67', '安徽', '宣城', '宣州区', 'XZQ', null);
INSERT INTO `t_pub_city` VALUES ('672', '341822', '广德县', '3', '0', '67', '安徽', '宣城', '广德县', 'ADX', null);
INSERT INTO `t_pub_city` VALUES ('673', '341824', '绩溪县', '3', '0', '67', '安徽', '宣城', '绩溪县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('674', '341881', '宁国', '3', '0', '67', '安徽', '宣城', '宁国', 'NG', null);
INSERT INTO `t_pub_city` VALUES ('675', '350103', '台江区', '3', '0', '166', '福建', '福州', '台江区', 'TJQ', null);
INSERT INTO `t_pub_city` VALUES ('676', '350105', '马尾区', '3', '0', '166', '福建', '福州', '马尾区', 'MWQ', null);
INSERT INTO `t_pub_city` VALUES ('677', '350111', '晋安区', '3', '0', '166', '福建', '福州', '晋安区', 'JAQ', null);
INSERT INTO `t_pub_city` VALUES ('678', '350122', '连江县', '3', '0', '166', '福建', '福州', '连江县', 'LJX', null);
INSERT INTO `t_pub_city` VALUES ('679', '350124', '闽清县', '3', '0', '166', '福建', '福州', '闽清县', 'MQX', null);
INSERT INTO `t_pub_city` VALUES ('680', '350128', '平潭县', '3', '0', '166', '福建', '福州', '平潭县', 'PTX', null);
INSERT INTO `t_pub_city` VALUES ('681', '350182', '长乐', '3', '0', '166', '福建', '福州', '长乐', 'CL', null);
INSERT INTO `t_pub_city` VALUES ('682', '350205', '海沧区', '3', '0', '68', '福建', '厦门', '海沧区', 'HCQ', null);
INSERT INTO `t_pub_city` VALUES ('683', '350211', '集美区', '3', '0', '68', '福建', '厦门', '集美区', 'JMQ', null);
INSERT INTO `t_pub_city` VALUES ('684', '350213', '翔安区', '3', '0', '68', '福建', '厦门', '翔安区', 'XAQ', null);
INSERT INTO `t_pub_city` VALUES ('685', '350303', '涵江区', '3', '0', '167', '福建', '莆田', '涵江区', 'HJQ', null);
INSERT INTO `t_pub_city` VALUES ('686', '350305', '秀屿区', '3', '0', '167', '福建', '莆田', '秀屿区', 'XYQ', null);
INSERT INTO `t_pub_city` VALUES ('687', '350402', '梅列区', '3', '0', '168', '福建', '三明', '梅列区', 'MLQ', null);
INSERT INTO `t_pub_city` VALUES ('688', '350421', '明溪县', '3', '0', '168', '福建', '三明', '明溪县', 'MXX', null);
INSERT INTO `t_pub_city` VALUES ('689', '350424', '宁化县', '3', '0', '168', '福建', '三明', '宁化县', 'NHX', null);
INSERT INTO `t_pub_city` VALUES ('690', '350426', '尤溪县', '3', '0', '168', '福建', '三明', '尤溪县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('691', '350428', '将乐县', '3', '0', '168', '福建', '三明', '将乐县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('692', '350430', '建宁县', '3', '0', '168', '福建', '三明', '建宁县', 'JNX', null);
INSERT INTO `t_pub_city` VALUES ('693', '350502', '鲤城区', '3', '0', '69', '福建', '泉州', '鲤城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('694', '350503', '丰泽区', '3', '0', '69', '福建', '泉州', '丰泽区', 'FZQ', null);
INSERT INTO `t_pub_city` VALUES ('695', '350505', '泉港区', '3', '0', '69', '福建', '泉州', '泉港区', 'QGQ', null);
INSERT INTO `t_pub_city` VALUES ('696', '350524', '安溪县', '3', '0', '69', '福建', '泉州', '安溪县', 'AXX', null);
INSERT INTO `t_pub_city` VALUES ('697', '350526', '德化县', '3', '0', '69', '福建', '泉州', '德化县', 'DHX', null);
INSERT INTO `t_pub_city` VALUES ('698', '350581', '石狮', '3', '0', '69', '福建', '泉州', '石狮', 'SS', null);
INSERT INTO `t_pub_city` VALUES ('699', '350583', '南安', '3', '0', '69', '福建', '泉州', '南安', 'NA', null);
INSERT INTO `t_pub_city` VALUES ('700', '350603', '龙文区', '3', '0', '169', '福建', '漳州', '龙文区', 'LWQ', null);
INSERT INTO `t_pub_city` VALUES ('701', '350623', '漳浦县', '3', '0', '169', '福建', '漳州', '漳浦县', 'ZPX', null);
INSERT INTO `t_pub_city` VALUES ('702', '350625', '长泰县', '3', '0', '169', '福建', '漳州', '长泰县', 'CTX', null);
INSERT INTO `t_pub_city` VALUES ('703', '350628', '平和县', '3', '0', '169', '福建', '漳州', '平和县', 'PHX', null);
INSERT INTO `t_pub_city` VALUES ('704', '350681', '龙海', '3', '0', '169', '福建', '漳州', '龙海', 'LH', null);
INSERT INTO `t_pub_city` VALUES ('705', '350721', '顺昌县', '3', '0', '70', '福建', '南平', '顺昌县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('706', '350723', '光泽县', '3', '0', '70', '福建', '南平', '光泽县', 'GZX', null);
INSERT INTO `t_pub_city` VALUES ('707', '350781', '邵武', '3', '0', '70', '福建', '南平', '邵武', 'SW', null);
INSERT INTO `t_pub_city` VALUES ('708', '350783', '建瓯', '3', '0', '70', '福建', '南平', '建瓯', 'JO', null);
INSERT INTO `t_pub_city` VALUES ('709', '350802', '新罗区', '3', '0', '170', '福建', '龙岩', '新罗区', 'XLQ', null);
INSERT INTO `t_pub_city` VALUES ('710', '350823', '上杭县', '3', '0', '170', '福建', '龙岩', '上杭县', 'SHX', null);
INSERT INTO `t_pub_city` VALUES ('711', '350825', '连城县', '3', '0', '170', '福建', '龙岩', '连城县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('712', '350921', '霞浦县', '3', '0', '71', '福建', '宁德', '霞浦县', 'XPX', null);
INSERT INTO `t_pub_city` VALUES ('713', '350923', '屏南县', '3', '0', '71', '福建', '宁德', '屏南县', 'PNX', null);
INSERT INTO `t_pub_city` VALUES ('714', '350926', '柘荣县', '3', '0', '71', '福建', '宁德', '柘荣县', 'ZRX', null);
INSERT INTO `t_pub_city` VALUES ('715', '350982', '福鼎', '3', '0', '71', '福建', '宁德', '福鼎', 'FD', null);
INSERT INTO `t_pub_city` VALUES ('716', '360104', '青云谱区', '3', '0', '171', '江西', '南昌', '青云谱区', 'QYPQ', null);
INSERT INTO `t_pub_city` VALUES ('717', '360111', '青山湖区', '3', '0', '171', '江西', '南昌', '青山湖区', 'QSHQ', null);
INSERT INTO `t_pub_city` VALUES ('718', '360123', '安义县', '3', '0', '171', '江西', '南昌', '安义县', 'AYX', null);
INSERT INTO `t_pub_city` VALUES ('719', '360202', '昌江区', '3', '0', '72', '江西', '景德镇', '昌江区', 'CJQ', null);
INSERT INTO `t_pub_city` VALUES ('720', '360281', '乐平', '3', '0', '72', '江西', '景德镇', '乐平', 'LP', null);
INSERT INTO `t_pub_city` VALUES ('721', '360313', '湘东区', '3', '0', '172', '江西', '萍乡', '湘东区', 'XDQ', null);
INSERT INTO `t_pub_city` VALUES ('722', '360323', '芦溪县', '3', '0', '172', '江西', '萍乡', '芦溪县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('723', '360402', '庐山区', '3', '0', '173', '江西', '九江', '庐山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('724', '360421', '九江县', '3', '0', '173', '江西', '九江', '九江县', 'JJX', null);
INSERT INTO `t_pub_city` VALUES ('725', '360424', '修水县', '3', '0', '173', '江西', '九江', '修水县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('726', '360426', '德安县', '3', '0', '173', '江西', '九江', '德安县', 'DAX', null);
INSERT INTO `t_pub_city` VALUES ('727', '360428', '都昌县', '3', '0', '173', '江西', '九江', '都昌县', 'DCX', null);
INSERT INTO `t_pub_city` VALUES ('728', '360430', '彭泽县', '3', '0', '173', '江西', '九江', '彭泽县', 'PZX', null);
INSERT INTO `t_pub_city` VALUES ('729', '360481', '瑞昌', '3', '0', '173', '江西', '九江', '瑞昌', 'RC', null);
INSERT INTO `t_pub_city` VALUES ('730', '360502', '渝水区', '3', '0', '174', '江西', '新余', '渝水区', 'YSQ', null);
INSERT INTO `t_pub_city` VALUES ('731', '360602', '月湖区', '3', '0', '73', '江西', '鹰潭', '月湖区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('732', '360681', '贵溪', '3', '0', '73', '江西', '鹰潭', '贵溪', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('733', '360703', '南康区', '3', '0', '175', '江西', '赣州', '南康区', 'NKQ', null);
INSERT INTO `t_pub_city` VALUES ('734', '360722', '信丰县', '3', '0', '175', '江西', '赣州', '信丰县', 'XFX', null);
INSERT INTO `t_pub_city` VALUES ('735', '360724', '上犹县', '3', '0', '175', '江西', '赣州', '上犹县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('736', '360726', '安远县', '3', '0', '175', '江西', '赣州', '安远县', 'AYX', null);
INSERT INTO `t_pub_city` VALUES ('737', '360728', '定南县', '3', '0', '175', '江西', '赣州', '定南县', 'DNX', null);
INSERT INTO `t_pub_city` VALUES ('738', '360730', '宁都县', '3', '0', '175', '江西', '赣州', '宁都县', 'NDX', null);
INSERT INTO `t_pub_city` VALUES ('739', '360732', '兴国县', '3', '0', '175', '江西', '赣州', '兴国县', 'XGX', null);
INSERT INTO `t_pub_city` VALUES ('740', '360734', '寻乌县', '3', '0', '175', '江西', '赣州', '寻乌县', 'XWX', null);
INSERT INTO `t_pub_city` VALUES ('741', '360781', '瑞金', '3', '0', '175', '江西', '赣州', '瑞金', 'RJ', null);
INSERT INTO `t_pub_city` VALUES ('742', '360803', '青原区', '3', '0', '176', '江西', '吉安', '青原区', 'QYQ', null);
INSERT INTO `t_pub_city` VALUES ('743', '360822', '吉水县', '3', '0', '176', '江西', '吉安', '吉水县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('744', '360823', '峡江县', '3', '0', '176', '江西', '吉安', '峡江县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('745', '360825', '永丰县', '3', '0', '176', '江西', '吉安', '永丰县', 'YFX', null);
INSERT INTO `t_pub_city` VALUES ('746', '360827', '遂川县', '3', '0', '176', '江西', '吉安', '遂川县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('747', '360829', '安福县', '3', '0', '176', '江西', '吉安', '安福县', 'AFX', null);
INSERT INTO `t_pub_city` VALUES ('748', '360902', '袁州区', '3', '0', '74', '江西', '宜春', '袁州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('749', '360922', '万载县', '3', '0', '74', '江西', '宜春', '万载县', 'WZX', null);
INSERT INTO `t_pub_city` VALUES ('750', '360924', '宜丰县', '3', '0', '74', '江西', '宜春', '宜丰县', 'YFX', null);
INSERT INTO `t_pub_city` VALUES ('751', '360926', '铜鼓县', '3', '0', '74', '江西', '宜春', '铜鼓县', 'TGX', null);
INSERT INTO `t_pub_city` VALUES ('752', '360982', '樟树', '3', '0', '74', '江西', '宜春', '樟树', 'ZS', null);
INSERT INTO `t_pub_city` VALUES ('753', '361002', '临川区', '3', '0', '177', '江西', '抚州', '临川区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('754', '361022', '黎川县', '3', '0', '177', '江西', '抚州', '黎川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('755', '361024', '崇仁县', '3', '0', '177', '江西', '抚州', '崇仁县', 'CRX', null);
INSERT INTO `t_pub_city` VALUES ('756', '361026', '宜黄县', '3', '0', '177', '江西', '抚州', '宜黄县', 'YHX', null);
INSERT INTO `t_pub_city` VALUES ('757', '361027', '金溪县', '3', '0', '177', '江西', '抚州', '金溪县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('758', '361029', '东乡县', '3', '0', '177', '江西', '抚州', '东乡县', 'DXX', null);
INSERT INTO `t_pub_city` VALUES ('759', '361102', '信州区', '3', '0', '75', '江西', '上饶', '信州区', 'XZQ', null);
INSERT INTO `t_pub_city` VALUES ('760', '361103', '广丰区', '3', '0', '75', '江西', '上饶', '广丰区', 'AFQ', null);
INSERT INTO `t_pub_city` VALUES ('761', '361124', '铅山县', '3', '0', '75', '江西', '上饶', '铅山县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('762', '361126', '弋阳县', '3', '0', '75', '江西', '上饶', '弋阳县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('763', '361128', '鄱阳县', '3', '0', '75', '江西', '上饶', '鄱阳县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('764', '361130', '婺源县', '3', '0', '75', '江西', '上饶', '婺源县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('765', '370102', '历下区', '3', '0', '178', '山东', '济南', '历下区', 'LXQ', null);
INSERT INTO `t_pub_city` VALUES ('766', '370104', '槐荫区', '3', '0', '178', '山东', '济南', '槐荫区', 'HYQ', null);
INSERT INTO `t_pub_city` VALUES ('767', '370112', '历城区', '3', '0', '178', '山东', '济南', '历城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('768', '370124', '平阴县', '3', '0', '178', '山东', '济南', '平阴县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('769', '370126', '商河县', '3', '0', '178', '山东', '济南', '商河县', 'SHX', null);
INSERT INTO `t_pub_city` VALUES ('770', '370202', '市南区', '3', '0', '76', '山东', '青岛', '市南区', 'SNQ', null);
INSERT INTO `t_pub_city` VALUES ('771', '370211', '黄岛区', '3', '0', '76', '山东', '青岛', '黄岛区', 'HDQ', null);
INSERT INTO `t_pub_city` VALUES ('772', '370212', '崂山区', '3', '0', '76', '山东', '青岛', '崂山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('773', '370214', '城阳区', '3', '0', '76', '山东', '青岛', '城阳区', 'CYQ', null);
INSERT INTO `t_pub_city` VALUES ('774', '370282', '即墨', '3', '0', '76', '山东', '青岛', '即墨', 'JM', null);
INSERT INTO `t_pub_city` VALUES ('775', '370285', '莱西', '3', '0', '76', '山东', '青岛', '莱西', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('776', '370303', '张店区', '3', '0', '179', '山东', '淄博', '张店区', 'ZDQ', null);
INSERT INTO `t_pub_city` VALUES ('777', '370305', '临淄区', '3', '0', '179', '山东', '淄博', '临淄区', 'LZQ', null);
INSERT INTO `t_pub_city` VALUES ('778', '370321', '桓台县', '3', '0', '179', '山东', '淄博', '桓台县', 'HTX', null);
INSERT INTO `t_pub_city` VALUES ('779', '370323', '沂源县', '3', '0', '179', '山东', '淄博', '沂源县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('780', '370403', '薛城区', '3', '0', '77', '山东', '枣庄', '薛城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('781', '370405', '台儿庄区', '3', '0', '77', '山东', '枣庄', '台儿庄区', 'TEZQ', null);
INSERT INTO `t_pub_city` VALUES ('782', '370481', '滕州', '3', '0', '77', '山东', '枣庄', '滕州', 'TZ', null);
INSERT INTO `t_pub_city` VALUES ('783', '370503', '河口区', '3', '0', '180', '山东', '东营', '河口区', 'HKQ', null);
INSERT INTO `t_pub_city` VALUES ('784', '370522', '利津县', '3', '0', '180', '山东', '东营', '利津县', 'LJX', null);
INSERT INTO `t_pub_city` VALUES ('785', '370602', '芝罘区', '3', '0', '181', '山东', '烟台', '芝罘区', 'ZFQ', null);
INSERT INTO `t_pub_city` VALUES ('786', '370611', '福山区', '3', '0', '181', '山东', '烟台', '福山区', 'FSQ', null);
INSERT INTO `t_pub_city` VALUES ('787', '370613', '莱山区', '3', '0', '181', '山东', '烟台', '莱山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('788', '370681', '龙口', '3', '0', '181', '山东', '烟台', '龙口', 'LK', null);
INSERT INTO `t_pub_city` VALUES ('789', '370683', '莱州', '3', '0', '181', '山东', '烟台', '莱州', 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('790', '370685', '招远', '3', '0', '181', '山东', '烟台', '招远', 'QY', null);
INSERT INTO `t_pub_city` VALUES ('791', '370687', '海阳', '3', '0', '181', '山东', '烟台', '海阳', 'HY', null);
INSERT INTO `t_pub_city` VALUES ('792', '370703', '寒亭区', '3', '0', '78', '山东', '潍坊', '寒亭区', 'HTQ', null);
INSERT INTO `t_pub_city` VALUES ('793', '370705', '奎文区', '3', '0', '78', '山东', '潍坊', '奎文区', 'KWQ', null);
INSERT INTO `t_pub_city` VALUES ('794', '370725', '昌乐县', '3', '0', '78', '山东', '潍坊', '昌乐县', 'CLX', null);
INSERT INTO `t_pub_city` VALUES ('795', '370782', '诸城', '3', '0', '78', '山东', '潍坊', '诸城', 'ZC', null);
INSERT INTO `t_pub_city` VALUES ('796', '370784', '安丘', '3', '0', '78', '山东', '潍坊', '安丘', 'AQ', null);
INSERT INTO `t_pub_city` VALUES ('797', '370786', '昌邑', '3', '0', '78', '山东', '潍坊', '昌邑', 'CY', null);
INSERT INTO `t_pub_city` VALUES ('798', '370812', '兖州区', '3', '0', '182', '山东', '济宁', '兖州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('799', '370827', '鱼台县', '3', '0', '182', '山东', '济宁', '鱼台县', 'YTX', null);
INSERT INTO `t_pub_city` VALUES ('800', '370829', '嘉祥县', '3', '0', '182', '山东', '济宁', '嘉祥县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('801', '370830', '汶上县', '3', '0', '182', '山东', '济宁', '汶上县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('802', '370832', '梁山县', '3', '0', '182', '山东', '济宁', '梁山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('803', '370883', '邹城', '3', '0', '182', '山东', '济宁', '邹城', 'JC', null);
INSERT INTO `t_pub_city` VALUES ('804', '370911', '岱岳区', '3', '0', '79', '山东', '泰安', '岱岳区', 'DYQ', null);
INSERT INTO `t_pub_city` VALUES ('805', '370923', '东平县', '3', '0', '79', '山东', '泰安', '东平县', 'DPX', null);
INSERT INTO `t_pub_city` VALUES ('806', '370983', '肥城', '3', '0', '79', '山东', '泰安', '肥城', 'FC', null);
INSERT INTO `t_pub_city` VALUES ('807', '371003', '文登区', '3', '0', '183', '山东', '威海', '文登区', 'WDQ', null);
INSERT INTO `t_pub_city` VALUES ('808', '371083', '乳山', '3', '0', '183', '山东', '威海', '乳山', 'RS', null);
INSERT INTO `t_pub_city` VALUES ('809', '371103', '岚山区', '3', '0', '80', '山东', '日照', '岚山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('810', '371122', '莒县', '3', '0', '80', '山东', '日照', '莒县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('811', '371203', '钢城区', '3', '0', '184', '山东', '莱芜', '钢城区', 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('812', '371311', '罗庄区', '3', '0', '81', '山东', '临沂', '罗庄区', 'LZQ', null);
INSERT INTO `t_pub_city` VALUES ('813', '371321', '沂南县', '3', '0', '81', '山东', '临沂', '沂南县', 'YNX', null);
INSERT INTO `t_pub_city` VALUES ('814', '371323', '沂水县', '3', '0', '81', '山东', '临沂', '沂水县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('815', '371325', '费县', '3', '0', '81', '山东', '临沂', '费县', 'FX', null);
INSERT INTO `t_pub_city` VALUES ('816', '371326', '平邑县', '3', '0', '81', '山东', '临沂', '平邑县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('817', '371328', '蒙阴县', '3', '0', '81', '山东', '临沂', '蒙阴县', 'MYX', null);
INSERT INTO `t_pub_city` VALUES ('818', '371402', '德城区', '3', '0', '185', '山东', '德州', '德城区', 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('819', '371422', '宁津县', '3', '0', '185', '山东', '德州', '宁津县', 'NJX', null);
INSERT INTO `t_pub_city` VALUES ('820', '371424', '临邑县', '3', '0', '185', '山东', '德州', '临邑县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('821', '371426', '平原县', '3', '0', '185', '山东', '德州', '平原县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('822', '371428', '武城县', '3', '0', '185', '山东', '德州', '武城县', 'WCX', null);
INSERT INTO `t_pub_city` VALUES ('823', '371482', '禹城', '3', '0', '185', '山东', '德州', '禹城', 'YC', null);
INSERT INTO `t_pub_city` VALUES ('824', '371521', '阳谷县', '3', '0', '186', '山东', '聊城', '阳谷县', 'YGX', null);
INSERT INTO `t_pub_city` VALUES ('825', '371523', '茌平县', '3', '0', '186', '山东', '聊城', '茌平县', 'CPX', null);
INSERT INTO `t_pub_city` VALUES ('826', '371525', '冠县', '3', '0', '186', '山东', '聊城', '冠县', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('827', '371581', '临清', '3', '0', '186', '山东', '聊城', '临清', 'LQ', null);
INSERT INTO `t_pub_city` VALUES ('828', '371603', '沾化区', '3', '0', '82', '山东', '滨州', '沾化区', 'ZHQ', null);
INSERT INTO `t_pub_city` VALUES ('829', '371622', '阳信县', '3', '0', '82', '山东', '滨州', '阳信县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('830', '371625', '博兴县', '3', '0', '82', '山东', '滨州', '博兴县', 'BXX', null);
INSERT INTO `t_pub_city` VALUES ('831', '371626', '邹平县', '3', '0', '82', '山东', '滨州', '邹平县', 'JPX', null);
INSERT INTO `t_pub_city` VALUES ('832', '371703', '定陶区', '3', '0', '187', '山东', '菏泽', '定陶区', 'DTQ', null);
INSERT INTO `t_pub_city` VALUES ('833', '371722', '单县', '3', '0', '187', '山东', '菏泽', '单县', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('834', '371724', '巨野县', '3', '0', '187', '山东', '菏泽', '巨野县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('835', '371726', '鄄城县', '3', '0', '187', '山东', '菏泽', '鄄城县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('836', '410102', '中原区', '3', '0', '83', '河南', '郑州', '中原区', 'ZYQ', null);
INSERT INTO `t_pub_city` VALUES ('837', '410104', '管城回族区', '3', '0', '83', '河南', '郑州', '管城回族区', 'GCHZQ', null);
INSERT INTO `t_pub_city` VALUES ('838', '410106', '上街区', '3', '0', '83', '河南', '郑州', '上街区', 'SJQ', null);
INSERT INTO `t_pub_city` VALUES ('839', '410122', '中牟县', '3', '0', '83', '河南', '郑州', '中牟县', 'ZMX', null);
INSERT INTO `t_pub_city` VALUES ('840', '410182', '荥阳', '3', '0', '83', '河南', '郑州', '荥阳', 'XY', null);
INSERT INTO `t_pub_city` VALUES ('841', '410184', '新郑', '3', '0', '83', '河南', '郑州', '新郑', 'XZ', null);
INSERT INTO `t_pub_city` VALUES ('842', '410202', '龙亭区', '3', '0', '188', '河南', '开封', '龙亭区', 'LTQ', null);
INSERT INTO `t_pub_city` VALUES ('843', '410204', '鼓楼区', '3', '0', '188', '河南', '开封', '鼓楼区', 'GLQ', null);
INSERT INTO `t_pub_city` VALUES ('844', '410205', '禹王台区', '3', '0', '188', '河南', '开封', '禹王台区', 'YWTQ', null);
INSERT INTO `t_pub_city` VALUES ('845', '410221', '杞县', '3', '0', '188', '河南', '开封', '杞县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('846', '410223', '尉氏县', '3', '0', '188', '河南', '开封', '尉氏县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('847', '410302', '老城区', '3', '0', '84', '河南', '洛阳', '老城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('848', '410304', '瀍河回族区', '3', '0', '84', '河南', '洛阳', '瀍河回族区', 'CHHZQ', null);
INSERT INTO `t_pub_city` VALUES ('849', '410306', '吉利区', '3', '0', '84', '河南', '洛阳', '吉利区', 'JLQ', null);
INSERT INTO `t_pub_city` VALUES ('850', '410322', '孟津县', '3', '0', '84', '河南', '洛阳', '孟津县', 'MJX', null);
INSERT INTO `t_pub_city` VALUES ('851', '410325', '嵩县', '3', '0', '84', '河南', '洛阳', '嵩县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('852', '410327', '宜阳县', '3', '0', '84', '河南', '洛阳', '宜阳县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('853', '410381', '偃师', '3', '0', '84', '河南', '洛阳', '偃师', 'YS', null);
INSERT INTO `t_pub_city` VALUES ('854', '410403', '卫东区', '3', '0', '189', '河南', '平顶山', '卫东区', 'WDQ', null);
INSERT INTO `t_pub_city` VALUES ('855', '410421', '宝丰县', '3', '0', '189', '河南', '平顶山', '宝丰县', 'BFX', null);
INSERT INTO `t_pub_city` VALUES ('856', '410423', '鲁山县', '3', '0', '189', '河南', '平顶山', '鲁山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('857', '410482', '汝州', '3', '0', '189', '河南', '平顶山', '汝州', 'RZ', null);
INSERT INTO `t_pub_city` VALUES ('858', '410505', '殷都区', '3', '0', '85', '河南', '安阳', '殷都区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('859', '410522', '安阳县', '3', '0', '85', '河南', '安阳', '安阳县', 'AYX', null);
INSERT INTO `t_pub_city` VALUES ('860', '410527', '内黄县', '3', '0', '85', '河南', '安阳', '内黄县', 'NHX', null);
INSERT INTO `t_pub_city` VALUES ('861', '410602', '鹤山区', '3', '0', '190', '河南', '鹤壁', '鹤山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('862', '410621', '浚县', '3', '0', '190', '河南', '鹤壁', '浚县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('863', '410702', '红旗区', '3', '0', '191', '河南', '新乡', '红旗区', 'GQQ', null);
INSERT INTO `t_pub_city` VALUES ('864', '410711', '牧野区', '3', '0', '191', '河南', '新乡', '牧野区', 'MYQ', null);
INSERT INTO `t_pub_city` VALUES ('865', '410724', '获嘉县', '3', '0', '191', '河南', '新乡', '获嘉县', 'HJX', null);
INSERT INTO `t_pub_city` VALUES ('866', '410727', '封丘县', '3', '0', '191', '河南', '新乡', '封丘县', 'FQX', null);
INSERT INTO `t_pub_city` VALUES ('867', '130105', '新华区', '3', '0', '192', '河北', '石家庄', '新华区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('868', '130108', '裕华区', '3', '0', '192', '河北', '石家庄', '裕华区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('869', '130110', '鹿泉区', '3', '0', '192', '河北', '石家庄', '鹿泉区', 'LQQ', null);
INSERT INTO `t_pub_city` VALUES ('870', '130121', '井陉县', '3', '0', '192', '河北', '石家庄', '井陉县', 'JJX', null);
INSERT INTO `t_pub_city` VALUES ('871', '130125', '行唐县', '3', '0', '192', '河北', '石家庄', '行唐县', 'HTX', null);
INSERT INTO `t_pub_city` VALUES ('872', '130128', '深泽县', '3', '0', '192', '河北', '石家庄', '深泽县', 'SZX', null);
INSERT INTO `t_pub_city` VALUES ('873', '130130', '无极县', '3', '0', '192', '河北', '石家庄', '无极县', 'MJX', null);
INSERT INTO `t_pub_city` VALUES ('874', '130132', '元氏县', '3', '0', '192', '河北', '石家庄', '元氏县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('875', '130181', '辛集', '3', '0', '192', '河北', '石家庄', '辛集', 'XJ', null);
INSERT INTO `t_pub_city` VALUES ('876', '130184', '新乐', '3', '0', '192', '河北', '石家庄', '新乐', 'XL', null);
INSERT INTO `t_pub_city` VALUES ('877', '130204', '古冶区', '3', '0', '102', '河北', '唐山', '古冶区', 'GYQ', null);
INSERT INTO `t_pub_city` VALUES ('878', '130207', '丰南区', '3', '0', '102', '河北', '唐山', '丰南区', 'FNQ', null);
INSERT INTO `t_pub_city` VALUES ('879', '130209', '曹妃甸区', '3', '0', '102', '河北', '唐山', '曹妃甸区', 'CFDQ', null);
INSERT INTO `t_pub_city` VALUES ('880', '130224', '滦南县', '3', '0', '102', '河北', '唐山', '滦南县', 'LNX', null);
INSERT INTO `t_pub_city` VALUES ('881', '130227', '迁西县', '3', '0', '102', '河北', '唐山', '迁西县', 'QXX', null);
INSERT INTO `t_pub_city` VALUES ('882', '130281', '遵化', '3', '0', '102', '河北', '唐山', '遵化', 'ZH', null);
INSERT INTO `t_pub_city` VALUES ('883', '130302', '海港区', '3', '0', '193', '河北', '秦皇岛', '海港区', 'HGQ', null);
INSERT INTO `t_pub_city` VALUES ('884', '130304', '北戴河区', '3', '0', '193', '河北', '秦皇岛', '北戴河区', 'BDHQ', null);
INSERT INTO `t_pub_city` VALUES ('885', '130321', '青龙满族自治县', '3', '0', '193', '河北', '秦皇岛', '青龙满族自治县', 'QLMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('886', '130402', '邯山区', '3', '0', '103', '河北', '邯郸', '邯山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('887', '130404', '复兴区', '3', '0', '103', '河北', '邯郸', '复兴区', 'FXQ', null);
INSERT INTO `t_pub_city` VALUES ('888', '130421', '邯郸县', '3', '0', '103', '河北', '邯郸', '邯郸县', 'HDX', null);
INSERT INTO `t_pub_city` VALUES ('889', '130424', '成安县', '3', '0', '103', '河北', '邯郸', '成安县', 'CAX', null);
INSERT INTO `t_pub_city` VALUES ('890', '130426', '涉县', '3', '0', '103', '河北', '邯郸', '涉县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('891', '130428', '肥乡县', '3', '0', '103', '河北', '邯郸', '肥乡县', 'FXX', null);
INSERT INTO `t_pub_city` VALUES ('892', '130431', '鸡泽县', '3', '0', '103', '河北', '邯郸', '鸡泽县', 'JZX', null);
INSERT INTO `t_pub_city` VALUES ('893', '130433', '馆陶县', '3', '0', '103', '河北', '邯郸', '馆陶县', 'GTX', null);
INSERT INTO `t_pub_city` VALUES ('894', '130435', '曲周县', '3', '0', '103', '河北', '邯郸', '曲周县', 'QZX', null);
INSERT INTO `t_pub_city` VALUES ('895', '130502', '桥东区', '3', '0', '194', '河北', '邢台', '桥东区', 'QDQ', null);
INSERT INTO `t_pub_city` VALUES ('896', '130521', '邢台县', '3', '0', '194', '河北', '邢台', '邢台县', 'GTX', null);
INSERT INTO `t_pub_city` VALUES ('897', '130523', '内丘县', '3', '0', '194', '河北', '邢台', '内丘县', 'NQX', null);
INSERT INTO `t_pub_city` VALUES ('898', '130525', '隆尧县', '3', '0', '194', '河北', '邢台', '隆尧县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('899', '130527', '南和县', '3', '0', '194', '河北', '邢台', '南和县', 'NHX', null);
INSERT INTO `t_pub_city` VALUES ('900', '130529', '巨鹿县', '3', '0', '194', '河北', '邢台', '巨鹿县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('901', '130531', '广宗县', '3', '0', '194', '河北', '邢台', '广宗县', 'AZX', null);
INSERT INTO `t_pub_city` VALUES ('902', '130533', '威县', '3', '0', '194', '河北', '邢台', '威县', 'WX', null);
INSERT INTO `t_pub_city` VALUES ('903', '130535', '临西县', '3', '0', '194', '河北', '邢台', '临西县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('904', '130582', '沙河', '3', '0', '194', '河北', '邢台', '沙河', 'SH', null);
INSERT INTO `t_pub_city` VALUES ('905', '130604', '南市区', '3', '0', '104', '河北', '保定', '南市区', 'NSQ', null);
INSERT INTO `t_pub_city` VALUES ('906', '130607', '满城区', '3', '0', '104', '河北', '保定', '满城区', 'MCQ', null);
INSERT INTO `t_pub_city` VALUES ('907', '130608', '清苑区', '3', '0', '104', '河北', '保定', '清苑区', 'QYQ', null);
INSERT INTO `t_pub_city` VALUES ('908', '130623', '涞水县', '3', '0', '104', '河北', '保定', '涞水县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('909', '130626', '定兴县', '3', '0', '104', '河北', '保定', '定兴县', 'DXX', null);
INSERT INTO `t_pub_city` VALUES ('910', '130628', '高阳县', '3', '0', '104', '河北', '保定', '高阳县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('911', '130630', '涞源县', '3', '0', '104', '河北', '保定', '涞源县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('912', '130632', '安新县', '3', '0', '104', '河北', '保定', '安新县', 'AXX', null);
INSERT INTO `t_pub_city` VALUES ('913', '130634', '曲阳县', '3', '0', '104', '河北', '保定', '曲阳县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('914', '130636', '顺平县', '3', '0', '104', '河北', '保定', '顺平县', 'SPX', null);
INSERT INTO `t_pub_city` VALUES ('915', '130638', '雄县', '3', '0', '104', '河北', '保定', '雄县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('916', '130682', '定州', '3', '0', '104', '河北', '保定', '定州', 'DZ', null);
INSERT INTO `t_pub_city` VALUES ('917', '130684', '高碑店', '3', '0', '104', '河北', '保定', '高碑店', 'GBD', null);
INSERT INTO `t_pub_city` VALUES ('918', '130703', '桥西区', '3', '0', '195', '河北', '张家口', '桥西区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('919', '130706', '下花园区', '3', '0', '195', '河北', '张家口', '下花园区', 'XHYQ', null);
INSERT INTO `t_pub_city` VALUES ('920', '130709', '崇礼区', '3', '0', '195', '河北', '张家口', '崇礼区', 'CLQ', null);
INSERT INTO `t_pub_city` VALUES ('921', '130722', '张北县', '3', '0', '195', '河北', '张家口', '张北县', 'ZBX', null);
INSERT INTO `t_pub_city` VALUES ('922', '130725', '尚义县', '3', '0', '195', '河北', '张家口', '尚义县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('923', '130727', '阳原县', '3', '0', '195', '河北', '张家口', '阳原县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('924', '130730', '怀来县', '3', '0', '195', '河北', '张家口', '怀来县', 'HLX', null);
INSERT INTO `t_pub_city` VALUES ('925', '130732', '赤城县', '3', '0', '195', '河北', '张家口', '赤城县', 'CCX', null);
INSERT INTO `t_pub_city` VALUES ('926', '130803', '双滦区', '3', '0', '105', '河北', '承德', '双滦区', 'SLQ', null);
INSERT INTO `t_pub_city` VALUES ('927', '130821', '承德县', '3', '0', '105', '河北', '承德', '承德县', 'CDX', null);
INSERT INTO `t_pub_city` VALUES ('928', '130822', '兴隆县', '3', '0', '105', '河北', '承德', '兴隆县', 'XLX', null);
INSERT INTO `t_pub_city` VALUES ('929', '130824', '滦平县', '3', '0', '105', '河北', '承德', '滦平县', 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('930', '130826', '丰宁满族自治县', '3', '0', '105', '河北', '承德', '丰宁满族自治县', 'FNMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('931', '130828', '围场满族蒙古族自治县', '3', '0', '105', '河北', '承德', '围场满族蒙古族自治县', 'WCMZMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('932', '130902', '新华区', '3', '0', '196', '河北', '沧州', '新华区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('933', '130921', '沧县', '3', '0', '196', '河北', '沧州', '沧县', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('934', '130923', '东光县', '3', '0', '196', '河北', '沧州', '东光县', 'DGX', null);
INSERT INTO `t_pub_city` VALUES ('935', '130925', '盐山县', '3', '0', '196', '河北', '沧州', '盐山县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('936', '130927', '南皮县', '3', '0', '196', '河北', '沧州', '南皮县', 'NPX', null);
INSERT INTO `t_pub_city` VALUES ('937', '130929', '献县', '3', '0', '196', '河北', '沧州', '献县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('938', '130982', '任丘', '3', '0', '196', '河北', '沧州', '任丘', 'RQ', null);
INSERT INTO `t_pub_city` VALUES ('939', '130984', '河间', '3', '0', '196', '河北', '沧州', '河间', 'HJ', null);
INSERT INTO `t_pub_city` VALUES ('940', '131003', '广阳区', '3', '0', '106', '河北', '廊坊', '广阳区', 'AYQ', null);
INSERT INTO `t_pub_city` VALUES ('941', '131023', '永清县', '3', '0', '106', '河北', '廊坊', '永清县', 'YQX', null);
INSERT INTO `t_pub_city` VALUES ('942', '131025', '大城县', '3', '0', '106', '河北', '廊坊', '大城县', 'DCX', null);
INSERT INTO `t_pub_city` VALUES ('943', '131028', '大厂回族自治县', '3', '0', '106', '河北', '廊坊', '大厂回族自治县', 'DAHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('944', '131082', '三河', '3', '0', '106', '河北', '廊坊', '三河', 'SH', null);
INSERT INTO `t_pub_city` VALUES ('945', '131103', '冀州区', '3', '0', '197', '河北', '衡水', '冀州区', 'JZQ', null);
INSERT INTO `t_pub_city` VALUES ('946', '131122', '武邑县', '3', '0', '197', '河北', '衡水', '武邑县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('947', '131124', '饶阳县', '3', '0', '197', '河北', '衡水', '饶阳县', 'RYX', null);
INSERT INTO `t_pub_city` VALUES ('948', '131126', '故城县', '3', '0', '197', '河北', '衡水', '故城县', 'GCX', null);
INSERT INTO `t_pub_city` VALUES ('949', '131127', '景县', '3', '0', '197', '河北', '衡水', '景县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('950', '131182', '深州', '3', '0', '197', '河北', '衡水', '深州', 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('951', '140106', '迎泽区', '3', '0', '107', '山西', '太原', '迎泽区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('952', '140108', '尖草坪区', '3', '0', '107', '山西', '太原', '尖草坪区', 'JCPQ', null);
INSERT INTO `t_pub_city` VALUES ('953', '140110', '晋源区', '3', '0', '107', '山西', '太原', '晋源区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('954', '140122', '阳曲县', '3', '0', '107', '山西', '太原', '阳曲县', 'YQX', null);
INSERT INTO `t_pub_city` VALUES ('955', '140181', '古交', '3', '0', '107', '山西', '太原', '古交', 'GJ', null);
INSERT INTO `t_pub_city` VALUES ('956', '140203', '矿区', '3', '0', '198', '山西', '大同', '矿区', 'KQ', null);
INSERT INTO `t_pub_city` VALUES ('957', '140212', '新荣区', '3', '0', '198', '山西', '大同', '新荣区', 'XRQ', null);
INSERT INTO `t_pub_city` VALUES ('958', '140222', '天镇县', '3', '0', '198', '山西', '大同', '天镇县', 'TZX', null);
INSERT INTO `t_pub_city` VALUES ('959', '140224', '灵丘县', '3', '0', '198', '山西', '大同', '灵丘县', 'LQX', null);
INSERT INTO `t_pub_city` VALUES ('960', '140226', '左云县', '3', '0', '198', '山西', '大同', '左云县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('961', '140302', '城区', '3', '0', '199', '山西', '阳泉', '城区', 'CQ', null);
INSERT INTO `t_pub_city` VALUES ('962', '140303', '矿区', '3', '0', '199', '山西', '阳泉', '矿区', 'KQ', null);
INSERT INTO `t_pub_city` VALUES ('963', '140322', '盂县', '3', '0', '199', '山西', '阳泉', '盂县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('964', '140402', '城区', '3', '0', '108', '山西', '长治', '城区', 'CQ', null);
INSERT INTO `t_pub_city` VALUES ('965', '140423', '襄垣县', '3', '0', '108', '山西', '长治', '襄垣县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('966', '140424', '屯留县', '3', '0', '108', '山西', '长治', '屯留县', 'TLX', null);
INSERT INTO `t_pub_city` VALUES ('967', '140426', '黎城县', '3', '0', '108', '山西', '长治', '黎城县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('968', '140428', '长子县', '3', '0', '108', '山西', '长治', '长子县', 'CZX', null);
INSERT INTO `t_pub_city` VALUES ('969', '140430', '沁县', '3', '0', '108', '山西', '长治', '沁县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('970', '140481', '潞城', '3', '0', '108', '山西', '长治', '潞城', 'LC', null);
INSERT INTO `t_pub_city` VALUES ('971', '140521', '沁水县', '3', '0', '200', '山西', '晋城', '沁水县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('972', '140524', '陵川县', '3', '0', '200', '山西', '晋城', '陵川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('973', '140581', '高平', '3', '0', '200', '山西', '晋城', '高平', 'GP', null);
INSERT INTO `t_pub_city` VALUES ('974', '140603', '平鲁区', '3', '0', '109', '山西', '朔州', '平鲁区', 'PLQ', null);
INSERT INTO `t_pub_city` VALUES ('975', '140622', '应县', '3', '0', '109', '山西', '朔州', '应县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('976', '140624', '怀仁县', '3', '0', '109', '山西', '朔州', '怀仁县', 'HRX', null);
INSERT INTO `t_pub_city` VALUES ('977', '140721', '榆社县', '3', '0', '201', '山西', '晋中', '榆社县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('978', '140723', '和顺县', '3', '0', '201', '山西', '晋中', '和顺县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('979', '140726', '太谷县', '3', '0', '201', '山西', '晋中', '太谷县', 'TGX', null);
INSERT INTO `t_pub_city` VALUES ('980', '140728', '平遥县', '3', '0', '201', '山西', '晋中', '平遥县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('981', '140802', '盐湖区', '3', '0', '110', '山西', '运城', '盐湖区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('982', '140822', '万荣县', '3', '0', '110', '山西', '运城', '万荣县', 'WRX', null);
INSERT INTO `t_pub_city` VALUES ('983', '140825', '新绛县', '3', '0', '110', '山西', '运城', '新绛县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('984', '140827', '垣曲县', '3', '0', '110', '山西', '运城', '垣曲县', 'YQX', null);
INSERT INTO `t_pub_city` VALUES ('985', '140830', '芮城县', '3', '0', '110', '山西', '运城', '芮城县', 'RCX', null);
INSERT INTO `t_pub_city` VALUES ('986', '140882', '河津', '3', '0', '110', '山西', '运城', '河津', 'HJ', null);
INSERT INTO `t_pub_city` VALUES ('987', '140921', '定襄县', '3', '0', '202', '山西', '忻州', '定襄县', 'DXX', null);
INSERT INTO `t_pub_city` VALUES ('988', '140924', '繁峙县', '3', '0', '202', '山西', '忻州', '繁峙县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('989', '140926', '静乐县', '3', '0', '202', '山西', '忻州', '静乐县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('990', '140929', '岢岚县', '3', '0', '202', '山西', '忻州', '岢岚县', 'KLX', null);
INSERT INTO `t_pub_city` VALUES ('991', '140930', '河曲县', '3', '0', '202', '山西', '忻州', '河曲县', 'HQX', null);
INSERT INTO `t_pub_city` VALUES ('992', '140932', '偏关县', '3', '0', '202', '山西', '忻州', '偏关县', 'PGX', null);
INSERT INTO `t_pub_city` VALUES ('993', '141022', '翼城县', '3', '0', '111', '山西', '临汾', '翼城县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('994', '141024', '洪洞县', '3', '0', '111', '山西', '临汾', '洪洞县', 'HDX', null);
INSERT INTO `t_pub_city` VALUES ('995', '141026', '安泽县', '3', '0', '111', '山西', '临汾', '安泽县', 'AZX', null);
INSERT INTO `t_pub_city` VALUES ('996', '141028', '吉县', '3', '0', '111', '山西', '临汾', '吉县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('997', '141030', '大宁县', '3', '0', '111', '山西', '临汾', '大宁县', 'DNX', null);
INSERT INTO `t_pub_city` VALUES ('998', '141032', '永和县', '3', '0', '111', '山西', '临汾', '永和县', 'YHX', null);
INSERT INTO `t_pub_city` VALUES ('999', '141034', '汾西县', '3', '0', '111', '山西', '临汾', '汾西县', 'FXX', null);
INSERT INTO `t_pub_city` VALUES ('1000', '141082', '霍州', '3', '0', '111', '山西', '临汾', '霍州', 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('1001', '141121', '文水县', '3', '0', '203', '山西', '吕梁', '文水县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('1002', '141123', '兴县', '3', '0', '203', '山西', '吕梁', '兴县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('1003', '141125', '柳林县', '3', '0', '203', '山西', '吕梁', '柳林县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('1004', '141127', '岚县', '3', '0', '203', '山西', '吕梁', '岚县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('1005', '141129', '中阳县', '3', '0', '203', '山西', '吕梁', '中阳县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('1006', '141181', '孝义', '3', '0', '203', '山西', '吕梁', '孝义', 'XY', null);
INSERT INTO `t_pub_city` VALUES ('1007', '150102', '新城区', '3', '0', '204', '内蒙古自治区', '呼和浩特', '新城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('1008', '150104', '玉泉区', '3', '0', '204', '内蒙古自治区', '呼和浩特', '玉泉区', 'YQQ', null);
INSERT INTO `t_pub_city` VALUES ('1009', '150121', '土默特左旗', '3', '0', '204', '内蒙古自治区', '呼和浩特', '土默特左旗', 'TMTZQ', null);
INSERT INTO `t_pub_city` VALUES ('1010', '150123', '和林格尔县', '3', '0', '204', '内蒙古自治区', '呼和浩特', '和林格尔县', 'HLGEX', null);
INSERT INTO `t_pub_city` VALUES ('1011', '150125', '武川县', '3', '0', '204', '内蒙古自治区', '呼和浩特', '武川县', 'WCX', null);
INSERT INTO `t_pub_city` VALUES ('1012', '150203', '昆都仑区', '3', '0', '112', '内蒙古自治区', '包头', '昆都仑区', 'KDLQ', null);
INSERT INTO `t_pub_city` VALUES ('1013', '150205', '石拐区', '3', '0', '112', '内蒙古自治区', '包头', '石拐区', 'SGQ', null);
INSERT INTO `t_pub_city` VALUES ('1014', '150207', '九原区', '3', '0', '112', '内蒙古自治区', '包头', '九原区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('1015', '150222', '固阳县', '3', '0', '112', '内蒙古自治区', '包头', '固阳县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('1016', '150223', '达尔罕茂明安联合旗', '3', '0', '112', '内蒙古自治区', '包头', '达尔罕茂明安联合旗', 'DEHMMALGQ', null);
INSERT INTO `t_pub_city` VALUES ('1017', '150303', '海南区', '3', '0', '205', '内蒙古自治区', '乌海', '海南区', 'HNQ', null);
INSERT INTO `t_pub_city` VALUES ('1018', '150402', '红山区', '3', '0', '206', '内蒙古自治区', '赤峰', '红山区', 'GSQ', null);
INSERT INTO `t_pub_city` VALUES ('1019', '150404', '松山区', '3', '0', '206', '内蒙古自治区', '赤峰', '松山区', 'SSQ', null);
INSERT INTO `t_pub_city` VALUES ('1020', '150422', '巴林左旗', '3', '0', '206', '内蒙古自治区', '赤峰', '巴林左旗', 'BLZQ', null);
INSERT INTO `t_pub_city` VALUES ('1021', '150423', '巴林右旗', '3', '0', '206', '内蒙古自治区', '赤峰', '巴林右旗', 'BLYQ', null);
INSERT INTO `t_pub_city` VALUES ('1022', '150425', '克什克腾旗', '3', '0', '206', '内蒙古自治区', '赤峰', '克什克腾旗', 'KSKTQ', null);
INSERT INTO `t_pub_city` VALUES ('1023', '150428', '喀喇沁旗', '3', '0', '206', '内蒙古自治区', '赤峰', '喀喇沁旗', 'KLQQ', null);
INSERT INTO `t_pub_city` VALUES ('1024', '150430', '敖汉旗', '3', '0', '206', '内蒙古自治区', '赤峰', '敖汉旗', 'AHQ', null);
INSERT INTO `t_pub_city` VALUES ('1025', '150521', '科尔沁左翼中旗', '3', '0', '113', '内蒙古自治区', '通辽', '科尔沁左翼中旗', 'KEQZYZQ', null);
INSERT INTO `t_pub_city` VALUES ('1026', '150523', '开鲁县', '3', '0', '113', '内蒙古自治区', '通辽', '开鲁县', 'KLX', null);
INSERT INTO `t_pub_city` VALUES ('1027', '150524', '库伦旗', '3', '0', '113', '内蒙古自治区', '通辽', '库伦旗', 'KLQ', null);
INSERT INTO `t_pub_city` VALUES ('1028', '150526', '扎鲁特旗', '3', '0', '113', '内蒙古自治区', '通辽', '扎鲁特旗', 'ZLTQ', null);
INSERT INTO `t_pub_city` VALUES ('1029', '150602', '东胜区', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '东胜区', 'DSQ', null);
INSERT INTO `t_pub_city` VALUES ('1030', '150622', '准格尔旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '准格尔旗', 'ZGEQ', null);
INSERT INTO `t_pub_city` VALUES ('1031', '150624', '鄂托克旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '鄂托克旗', 'ETKQ', null);
INSERT INTO `t_pub_city` VALUES ('1032', '150626', '乌审旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '乌审旗', 'WSQ', null);
INSERT INTO `t_pub_city` VALUES ('1033', '150702', '海拉尔区', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '海拉尔区', 'HLEQ', null);
INSERT INTO `t_pub_city` VALUES ('1034', '150721', '阿荣旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '阿荣旗', 'ARQ', null);
INSERT INTO `t_pub_city` VALUES ('1035', '150723', '鄂伦春自治旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '鄂伦春自治旗', 'ELCZZQ', null);
INSERT INTO `t_pub_city` VALUES ('1036', '150725', '陈巴尔虎旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '陈巴尔虎旗', 'CBEHQ', null);
INSERT INTO `t_pub_city` VALUES ('1037', '150726', '新巴尔虎左旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '新巴尔虎左旗', 'XBEHZQ', null);
INSERT INTO `t_pub_city` VALUES ('1038', '150781', '满洲里', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '满洲里', 'MZL', null);
INSERT INTO `t_pub_city` VALUES ('1039', '150783', '扎兰屯', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '扎兰屯', 'ZLT', null);
INSERT INTO `t_pub_city` VALUES ('1040', '150785', '根河', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '根河', 'GH', null);
INSERT INTO `t_pub_city` VALUES ('1041', '150821', '五原县', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '五原县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('1042', '150823', '乌拉特前旗', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '乌拉特前旗', 'WLTQQ', null);
INSERT INTO `t_pub_city` VALUES ('1043', '150825', '乌拉特后旗', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '乌拉特后旗', 'WLTHQ', null);
INSERT INTO `t_pub_city` VALUES ('1044', '150902', '集宁区', '3', '0', '209', '内蒙古自治区', '乌兰察布', '集宁区', 'JNQ', null);
INSERT INTO `t_pub_city` VALUES ('1045', '150923', '商都县', '3', '0', '209', '内蒙古自治区', '乌兰察布', '商都县', 'SDX', null);
INSERT INTO `t_pub_city` VALUES ('1046', '150925', '凉城县', '3', '0', '209', '内蒙古自治区', '乌兰察布', '凉城县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('1047', '150927', '察哈尔右翼中旗', '3', '0', '209', '内蒙古自治区', '乌兰察布', '察哈尔右翼中旗', 'CHEYYZQ', null);
INSERT INTO `t_pub_city` VALUES ('1048', '150929', '四子王旗', '3', '0', '209', '内蒙古自治区', '乌兰察布', '四子王旗', 'SZWQ', null);
INSERT INTO `t_pub_city` VALUES ('1049', '150981', '丰镇', '3', '0', '209', '内蒙古自治区', '乌兰察布', '丰镇', 'FZ', null);
INSERT INTO `t_pub_city` VALUES ('1050', '152202', '阿尔山', '3', '0', '115', '内蒙古自治区', '兴安盟', '阿尔山', 'AES', null);
INSERT INTO `t_pub_city` VALUES ('1051', '152222', '科尔沁右翼中旗', '3', '0', '115', '内蒙古自治区', '兴安盟', '科尔沁右翼中旗', 'KEQYYZQ', null);
INSERT INTO `t_pub_city` VALUES ('1052', '152223', '扎赉特旗', '3', '0', '115', '内蒙古自治区', '兴安盟', '扎赉特旗', 'ZLTQ', null);
INSERT INTO `t_pub_city` VALUES ('1053', '152502', '锡林浩特', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '锡林浩特', 'XLHT', null);
INSERT INTO `t_pub_city` VALUES ('1054', '152522', '阿巴嘎旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '阿巴嘎旗', 'ABGQ', null);
INSERT INTO `t_pub_city` VALUES ('1055', '152524', '苏尼特右旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '苏尼特右旗', 'SNTYQ', null);
INSERT INTO `t_pub_city` VALUES ('1056', '152526', '西乌珠穆沁旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '西乌珠穆沁旗', 'XWZMQQ', null);
INSERT INTO `t_pub_city` VALUES ('1057', '152528', '镶黄旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '镶黄旗', 'RHQ', null);
INSERT INTO `t_pub_city` VALUES ('1058', '152530', '正蓝旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '正蓝旗', 'ZLQ', null);
INSERT INTO `t_pub_city` VALUES ('1059', '152921', '阿拉善左旗', '3', '0', '116', '内蒙古自治区', '阿拉善盟', '阿拉善左旗', 'ALSZQ', null);
INSERT INTO `t_pub_city` VALUES ('1060', '152923', '额济纳旗', '3', '0', '116', '内蒙古自治区', '阿拉善盟', '额济纳旗', 'EJNQ', null);
INSERT INTO `t_pub_city` VALUES ('1061', '210103', '沈河区', '3', '0', '211', '辽宁', '沈阳', '沈河区', 'SHQ', null);
INSERT INTO `t_pub_city` VALUES ('1062', '210105', '皇姑区', '3', '0', '211', '辽宁', '沈阳', '皇姑区', 'HGQ', null);
INSERT INTO `t_pub_city` VALUES ('1063', '210111', '苏家屯区', '3', '0', '211', '辽宁', '沈阳', '苏家屯区', 'SJTQ', null);
INSERT INTO `t_pub_city` VALUES ('1064', '210113', '沈北新区', '3', '0', '211', '辽宁', '沈阳', '沈北新区', 'SBXQ', null);
INSERT INTO `t_pub_city` VALUES ('1065', '210115', '辽中区', '3', '0', '211', '辽宁', '沈阳', '辽中区', 'LZQ', null);
INSERT INTO `t_pub_city` VALUES ('1066', '210124', '法库县', '3', '0', '211', '辽宁', '沈阳', '法库县', 'FKX', null);
INSERT INTO `t_pub_city` VALUES ('1067', '210202', '中山区', '3', '0', '117', '辽宁', '大连', '中山区', 'ZSQ', null);
INSERT INTO `t_pub_city` VALUES ('1068', '210204', '沙河口区', '3', '0', '117', '辽宁', '大连', '沙河口区', 'SHKQ', null);
INSERT INTO `t_pub_city` VALUES ('1069', '210212', '旅顺口区', '3', '0', '117', '辽宁', '大连', '旅顺口区', 'LSKQ', null);
INSERT INTO `t_pub_city` VALUES ('1070', '210213', '金州区', '3', '0', '117', '辽宁', '大连', '金州区', 'JZQ', null);
INSERT INTO `t_pub_city` VALUES ('1071', '210281', '瓦房店', '3', '0', '117', '辽宁', '大连', '瓦房店', 'WFD', null);
INSERT INTO `t_pub_city` VALUES ('1072', '210283', '庄河', '3', '0', '117', '辽宁', '大连', '庄河', 'ZH', null);
INSERT INTO `t_pub_city` VALUES ('1073', '210303', '铁西区', '3', '0', '212', '辽宁', '鞍山', '铁西区', 'TXQ', null);
INSERT INTO `t_pub_city` VALUES ('1074', '210311', '千山区', '3', '0', '212', '辽宁', '鞍山', '千山区', 'QSQ', null);
INSERT INTO `t_pub_city` VALUES ('1075', '210323', '岫岩满族自治县', '3', '0', '212', '辽宁', '鞍山', '岫岩满族自治县', 'XYMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1076', '210402', '新抚区', '3', '0', '118', '辽宁', '抚顺', '新抚区', 'XFQ', null);
INSERT INTO `t_pub_city` VALUES ('1077', '210404', '望花区', '3', '0', '118', '辽宁', '抚顺', '望花区', 'WHQ', null);
INSERT INTO `t_pub_city` VALUES ('1078', '210421', '抚顺县', '3', '0', '118', '辽宁', '抚顺', '抚顺县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('1079', '210423', '清原满族自治县', '3', '0', '118', '辽宁', '抚顺', '清原满族自治县', 'QYMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1080', '210502', '平山区', '3', '0', '213', '辽宁', '本溪', '平山区', 'PSQ', null);
INSERT INTO `t_pub_city` VALUES ('1081', '210504', '明山区', '3', '0', '213', '辽宁', '本溪', '明山区', 'MSQ', null);
INSERT INTO `t_pub_city` VALUES ('1082', '210521', '本溪满族自治县', '3', '0', '213', '辽宁', '本溪', '本溪满族自治县', 'BXMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1083', '210602', '元宝区', '3', '0', '214', '辽宁', '丹东', '元宝区', 'YBQ', null);
INSERT INTO `t_pub_city` VALUES ('1084', '210603', '振兴区', '3', '0', '214', '辽宁', '丹东', '振兴区', 'ZXQ', null);
INSERT INTO `t_pub_city` VALUES ('1085', '210624', '宽甸满族自治县', '3', '0', '214', '辽宁', '丹东', '宽甸满族自治县', 'KDMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1086', '210682', '凤城', '3', '0', '214', '辽宁', '丹东', '凤城', 'FC', null);
INSERT INTO `t_pub_city` VALUES ('1087', '210703', '凌河区', '3', '0', '119', '辽宁', '锦州', '凌河区', 'LHQ', null);
INSERT INTO `t_pub_city` VALUES ('1088', '210726', '黑山县', '3', '0', '119', '辽宁', '锦州', '黑山县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('1089', '210781', '凌海', '3', '0', '119', '辽宁', '锦州', '凌海', 'LH', null);
INSERT INTO `t_pub_city` VALUES ('1090', '210802', '站前区', '3', '0', '215', '辽宁', '营口', '站前区', 'ZQQ', null);
INSERT INTO `t_pub_city` VALUES ('1091', '210804', '鲅鱼圈区', '3', '0', '215', '辽宁', '营口', '鲅鱼圈区', 'BYJQ', null);
INSERT INTO `t_pub_city` VALUES ('1092', '210881', '盖州', '3', '0', '215', '辽宁', '营口', '盖州', 'GZ', null);
INSERT INTO `t_pub_city` VALUES ('1093', '210902', '海州区', '3', '0', '120', '辽宁', '阜新', '海州区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('1094', '210904', '太平区', '3', '0', '120', '辽宁', '阜新', '太平区', 'TPQ', null);
INSERT INTO `t_pub_city` VALUES ('1095', '210911', '细河区', '3', '0', '120', '辽宁', '阜新', '细河区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('1096', '210921', '阜新蒙古族自治县', '3', '0', '120', '辽宁', '阜新', '阜新蒙古族自治县', 'FXMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1097', '211002', '白塔区', '3', '0', '216', '辽宁', '辽阳', '白塔区', 'BDQ', null);
INSERT INTO `t_pub_city` VALUES ('1098', '211004', '宏伟区', '3', '0', '216', '辽宁', '辽阳', '宏伟区', 'HWQ', null);
INSERT INTO `t_pub_city` VALUES ('1099', '211011', '太子河区', '3', '0', '216', '辽宁', '辽阳', '太子河区', 'TZHQ', null);
INSERT INTO `t_pub_city` VALUES ('1100', '211081', '灯塔', '3', '0', '216', '辽宁', '辽阳', '灯塔', 'DD', null);
INSERT INTO `t_pub_city` VALUES ('1101', '211103', '兴隆台区', '3', '0', '121', '辽宁', '盘锦', '兴隆台区', 'XLTQ', null);
INSERT INTO `t_pub_city` VALUES ('1102', '211122', '盘山县', '3', '0', '121', '辽宁', '盘锦', '盘山县', 'PSX', null);
INSERT INTO `t_pub_city` VALUES ('1103', '211204', '清河区', '3', '0', '217', '辽宁', '铁岭', '清河区', 'QHQ', null);
INSERT INTO `t_pub_city` VALUES ('1104', '211223', '西丰县', '3', '0', '217', '辽宁', '铁岭', '西丰县', 'XFX', null);
INSERT INTO `t_pub_city` VALUES ('1105', '211224', '昌图县', '3', '0', '217', '辽宁', '铁岭', '昌图县', 'CTX', null);
INSERT INTO `t_pub_city` VALUES ('1106', '211282', '开原', '3', '0', '217', '辽宁', '铁岭', '开原', 'KY', null);
INSERT INTO `t_pub_city` VALUES ('1107', '211303', '龙城区', '3', '0', '122', '辽宁', '朝阳', '龙城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('1108', '211322', '建平县', '3', '0', '122', '辽宁', '朝阳', '建平县', 'JPX', null);
INSERT INTO `t_pub_city` VALUES ('1109', '211381', '北票', '3', '0', '122', '辽宁', '朝阳', '北票', 'BP', null);
INSERT INTO `t_pub_city` VALUES ('1110', '211382', '凌源', '3', '0', '122', '辽宁', '朝阳', '凌源', 'LY', null);
INSERT INTO `t_pub_city` VALUES ('1111', '211403', '龙港区', '3', '0', '218', '辽宁', '葫芦岛', '龙港区', 'LGQ', null);
INSERT INTO `t_pub_city` VALUES ('1112', '211421', '绥中县', '3', '0', '218', '辽宁', '葫芦岛', '绥中县', 'SZX', null);
INSERT INTO `t_pub_city` VALUES ('1113', '211481', '兴城', '3', '0', '218', '辽宁', '葫芦岛', '兴城', 'XC', null);
INSERT INTO `t_pub_city` VALUES ('1114', '220103', '宽城区', '3', '0', '123', '吉林', '长春', '宽城区', 'KCQ', null);
INSERT INTO `t_pub_city` VALUES ('1115', '220105', '二道区', '3', '0', '123', '吉林', '长春', '二道区', 'EDQ', null);
INSERT INTO `t_pub_city` VALUES ('1116', '220112', '双阳区', '3', '0', '123', '吉林', '长春', '双阳区', 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('1117', '220122', '农安县', '3', '0', '123', '吉林', '长春', '农安县', 'NAX', null);
INSERT INTO `t_pub_city` VALUES ('1118', '220183', '德惠', '3', '0', '123', '吉林', '长春', '德惠', 'DH', null);
INSERT INTO `t_pub_city` VALUES ('1119', '220204', '船营区', '3', '0', '219', '吉林', '吉林', '船营区', 'CYQ', null);
INSERT INTO `t_pub_city` VALUES ('1120', '220221', '永吉县', '3', '0', '219', '吉林', '吉林', '永吉县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('1121', '220283', '舒兰', '3', '0', '219', '吉林', '吉林', '舒兰', 'SL', null);
INSERT INTO `t_pub_city` VALUES ('1122', '220302', '铁西区', '3', '0', '220', '吉林', '四平', '铁西区', 'TXQ', null);
INSERT INTO `t_pub_city` VALUES ('1123', '220322', '梨树县', '3', '0', '220', '吉林', '四平', '梨树县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('1124', '220381', '公主岭', '3', '0', '220', '吉林', '四平', '公主岭', 'GZL', null);
INSERT INTO `t_pub_city` VALUES ('1125', '220403', '西安区', '3', '0', '124', '吉林', '辽源', '西安区', 'XAQ', null);
INSERT INTO `t_pub_city` VALUES ('1126', '220422', '东辽县', '3', '0', '124', '吉林', '辽源', '东辽县', 'DLX', null);
INSERT INTO `t_pub_city` VALUES ('1127', '220521', '通化县', '3', '0', '221', '吉林', '通化', '通化县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('1128', '220524', '柳河县', '3', '0', '221', '吉林', '通化', '柳河县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('1129', '220582', '集安', '3', '0', '221', '吉林', '通化', '集安', 'JA', null);
INSERT INTO `t_pub_city` VALUES ('1130', '652701', '博乐', '3', '0', '126', '新疆维吾尔自治区', '博尔塔拉蒙古自治州', '博乐', 'BL', null);
INSERT INTO `t_pub_city` VALUES ('1131', '652702', '阿拉山口', '3', '0', '126', '新疆维吾尔自治区', '博尔塔拉蒙古自治州', '阿拉山口', 'ALSK', null);
INSERT INTO `t_pub_city` VALUES ('1132', '652722', '精河县', '3', '0', '126', '新疆维吾尔自治区', '博尔塔拉蒙古自治州', '精河县', 'JHX', null);
INSERT INTO `t_pub_city` VALUES ('1133', '652723', '温泉县', '3', '0', '126', '新疆维吾尔自治区', '博尔塔拉蒙古自治州', '温泉县', 'WQX', null);
INSERT INTO `t_pub_city` VALUES ('1134', '652801', '库尔勒', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '库尔勒', 'KEL', null);
INSERT INTO `t_pub_city` VALUES ('1135', '652822', '轮台县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '轮台县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('1136', '652823', '尉犁县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '尉犁县', 'WLX', null);
INSERT INTO `t_pub_city` VALUES ('1137', '652824', '若羌县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '若羌县', 'RQX', null);
INSERT INTO `t_pub_city` VALUES ('1138', '652825', '且末县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '且末县', 'JMX', null);
INSERT INTO `t_pub_city` VALUES ('1139', '652826', '焉耆回族自治县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '焉耆回族自治县', 'YQHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1140', '652827', '和静县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '和静县', 'HJX', null);
INSERT INTO `t_pub_city` VALUES ('1141', '652828', '和硕县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '和硕县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('1142', '652829', '博湖县', '3', '0', '127', '新疆维吾尔自治区', '巴音郭楞蒙古自治州', '博湖县', 'BHX', null);
INSERT INTO `t_pub_city` VALUES ('1143', '652901', '阿克苏', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '阿克苏', 'AKS', null);
INSERT INTO `t_pub_city` VALUES ('1144', '652922', '温宿县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '温宿县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('1145', '652923', '库车县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '库车县', 'KCX', null);
INSERT INTO `t_pub_city` VALUES ('1146', '652924', '沙雅县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '沙雅县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('1147', '652925', '新和县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '新和县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('1148', '652926', '拜城县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '拜城县', 'BCX', null);
INSERT INTO `t_pub_city` VALUES ('1149', '652927', '乌什县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '乌什县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('1150', '652928', '阿瓦提县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '阿瓦提县', 'AWDX', null);
INSERT INTO `t_pub_city` VALUES ('1151', '652929', '柯坪县', '3', '0', '128', '新疆维吾尔自治区', '阿克苏地区', '柯坪县', 'KPX', null);
INSERT INTO `t_pub_city` VALUES ('1152', '653001', '阿图什', '3', '0', '129', '新疆维吾尔自治区', '克孜勒苏柯尔克孜自治州', '阿图什', 'ATS', null);
INSERT INTO `t_pub_city` VALUES ('1153', '653022', '阿克陶县', '3', '0', '129', '新疆维吾尔自治区', '克孜勒苏柯尔克孜自治州', '阿克陶县', 'AKTX', null);
INSERT INTO `t_pub_city` VALUES ('1154', '653023', '阿合奇县', '3', '0', '129', '新疆维吾尔自治区', '克孜勒苏柯尔克孜自治州', '阿合奇县', 'AGJX', null);
INSERT INTO `t_pub_city` VALUES ('1155', '653024', '乌恰县', '3', '0', '129', '新疆维吾尔自治区', '克孜勒苏柯尔克孜自治州', '乌恰县', 'WQX', null);
INSERT INTO `t_pub_city` VALUES ('1156', '653101', '喀什', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '喀什', 'KS', null);
INSERT INTO `t_pub_city` VALUES ('1157', '653122', '疏勒县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '疏勒县', 'SLX', null);
INSERT INTO `t_pub_city` VALUES ('1158', '653124', '泽普县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '泽普县', 'ZPX', null);
INSERT INTO `t_pub_city` VALUES ('1159', '653126', '叶城县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '叶城县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('1160', '653128', '岳普湖县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '岳普湖县', 'YPHX', null);
INSERT INTO `t_pub_city` VALUES ('1161', '653130', '巴楚县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '巴楚县', 'BCX', null);
INSERT INTO `t_pub_city` VALUES ('1162', '653201', '和田', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '和田', 'HT', null);
INSERT INTO `t_pub_city` VALUES ('1163', '653221', '和田县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '和田县', 'HTX', null);
INSERT INTO `t_pub_city` VALUES ('1164', '653223', '皮山县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '皮山县', 'PSX', null);
INSERT INTO `t_pub_city` VALUES ('1165', '653225', '策勒县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '策勒县', 'CLX', null);
INSERT INTO `t_pub_city` VALUES ('1166', '653227', '民丰县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '民丰县', 'MFX', null);
INSERT INTO `t_pub_city` VALUES ('1167', '654004', '霍尔果斯', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '霍尔果斯', 'HEGS', null);
INSERT INTO `t_pub_city` VALUES ('1168', '654023', '霍城县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '霍城县', 'HCX', null);
INSERT INTO `t_pub_city` VALUES ('1169', '654024', '巩留县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '巩留县', 'GLX', null);
INSERT INTO `t_pub_city` VALUES ('1170', '654027', '特克斯县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '特克斯县', 'TKSX', null);
INSERT INTO `t_pub_city` VALUES ('1171', '654201', '塔城', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '塔城', 'DC', null);
INSERT INTO `t_pub_city` VALUES ('1172', '654221', '额敏县', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '额敏县', 'EMX', null);
INSERT INTO `t_pub_city` VALUES ('1173', '654224', '托里县', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '托里县', 'TLX', null);
INSERT INTO `t_pub_city` VALUES ('1174', '654226', '和布克赛尔蒙古自治县', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '和布克赛尔蒙古自治县', 'HBKSEMGZZX', null);
INSERT INTO `t_pub_city` VALUES ('1175', '654321', '布尔津县', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '布尔津县', 'BEJX', null);
INSERT INTO `t_pub_city` VALUES ('1176', '654323', '福海县', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '福海县', 'FHX', null);
INSERT INTO `t_pub_city` VALUES ('1177', '654325', '青河县', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '青河县', 'QHX', null);
INSERT INTO `t_pub_city` VALUES ('1178', '659001', '石河子', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '石河子', 'SHZ', null);
INSERT INTO `t_pub_city` VALUES ('1179', '659003', '图木舒克', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '图木舒克', 'TMSK', null);
INSERT INTO `t_pub_city` VALUES ('1180', '659005', '北屯', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '北屯', 'BT', null);
INSERT INTO `t_pub_city` VALUES ('1181', '659007', '双河', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '双河', 'SH', null);
INSERT INTO `t_pub_city` VALUES ('1182', '321081', '仪征', '3', '0', '54', '江苏', '扬州', '仪征', 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('1183', '321204', '姜堰区', '3', '0', '55', '江苏', '泰州', '姜堰区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('1184', '321311', '宿豫区', '3', '0', '150', '江苏', '宿迁', '宿豫区', 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('1185', '330109', '萧山区', '3', '0', '56', '浙江', '杭州', '萧山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('1186', '330185', '临安', '3', '0', '56', '浙江', '杭州', '临安', 'LA', null);
INSERT INTO `t_pub_city` VALUES ('1187', '350703', '建阳区', '3', '0', '70', '福建', '南平', '建阳区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('1188', '350725', '政和县', '3', '0', '70', '福建', '南平', '政和县', 'ZHX', null);
INSERT INTO `t_pub_city` VALUES ('1189', '350881', '漳平', '3', '0', '170', '福建', '龙岩', '漳平', 'ZP', null);
INSERT INTO `t_pub_city` VALUES ('1190', '350924', '寿宁县', '3', '0', '71', '福建', '宁德', '寿宁县', 'SNX', null);
INSERT INTO `t_pub_city` VALUES ('1191', '360112', '新建区', '3', '0', '171', '江西', '南昌', '新建区', 'XJQ', null);
INSERT INTO `t_pub_city` VALUES ('1192', '360203', '珠山区', '3', '0', '72', '江西', '景德镇', '珠山区', 'ZSQ', null);
INSERT INTO `t_pub_city` VALUES ('1193', '410323', '新安县', '3', '0', '84', '河南', '洛阳', '新安县', 'XAX', null);
INSERT INTO `t_pub_city` VALUES ('1194', '410328', '洛宁县', '3', '0', '84', '河南', '洛阳', '洛宁县', 'LNX', null);
INSERT INTO `t_pub_city` VALUES ('1195', '410425', '郏县', '3', '0', '189', '河南', '平顶山', '郏县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('1196', '410526', '滑县', '3', '0', '85', '河南', '安阳', '滑县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('1197', '410603', '山城区', '3', '0', '190', '河南', '鹤壁', '山城区', 'SCQ', null);
INSERT INTO `t_pub_city` VALUES ('1198', '410725', '原阳县', '3', '0', '191', '河南', '新乡', '原阳县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('1199', '140725', '寿阳县', '3', '0', '201', '山西', '晋中', '寿阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('1200', '140824', '稷山县', '3', '0', '110', '山西', '运城', '稷山县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('1201', '140829', '平陆县', '3', '0', '110', '山西', '运城', '平陆县', 'PLX', null);
INSERT INTO `t_pub_city` VALUES ('1202', '140927', '神池县', '3', '0', '202', '山西', '忻州', '神池县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('1203', '140981', '原平', '3', '0', '202', '山西', '忻州', '原平', 'YP', null);
INSERT INTO `t_pub_city` VALUES ('1204', '220281', '蛟河', '3', '0', '219', '吉林', '吉林', '蛟河', 'JH', null);
INSERT INTO `t_pub_city` VALUES ('1205', '220303', '铁东区', '3', '0', '220', '吉林', '四平', '铁东区', 'TDQ', null);
INSERT INTO `t_pub_city` VALUES ('1206', '220503', '二道江区', '3', '0', '221', '吉林', '通化', '二道江区', 'EDJQ', null);
INSERT INTO `t_pub_city` VALUES ('1207', '220602', '浑江区', '3', '0', '125', '吉林', '白山', '浑江区', 'HJQ', null);
INSERT INTO `t_pub_city` VALUES ('1208', '430626', '平江县', '3', '0', '238', '湖南', '岳阳', '平江县', 'PJX', null);
INSERT INTO `t_pub_city` VALUES ('1209', '430721', '安乡县', '3', '0', '328', '湖南', '常德', '安乡县', 'AXX', null);
INSERT INTO `t_pub_city` VALUES ('1210', '430822', '桑植县', '3', '0', '239', '湖南', '张家界', '桑植县', 'SZX', null);
INSERT INTO `t_pub_city` VALUES ('1211', '430923', '安化县', '3', '0', '329', '湖南', '益阳', '安化县', 'AHX', null);
INSERT INTO `t_pub_city` VALUES ('1212', '431027', '桂东县', '3', '0', '240', '湖南', '郴州', '桂东县', 'GDX', null);
INSERT INTO `t_pub_city` VALUES ('1213', '431121', '祁阳县', '3', '0', '330', '湖南', '永州', '祁阳县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('1214', '451222', '天峨县', '3', '0', '261', '广西壮族自治区', '河池', '天峨县', 'TEX', null);
INSERT INTO `t_pub_city` VALUES ('1215', '451227', '巴马瑶族自治县', '3', '0', '261', '广西壮族自治区', '河池', '巴马瑶族自治县', 'BMYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1216', '451422', '宁明县', '3', '0', '346', '广西壮族自治区', '崇左', '宁明县', 'NMX', null);
INSERT INTO `t_pub_city` VALUES ('1217', '460105', '秀英区', '3', '0', '263', '海南', '海口', '秀英区', 'XYQ', null);
INSERT INTO `t_pub_city` VALUES ('1218', '520221', '水城县', '3', '0', '277', '贵州', '六盘水', '水城县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('1219', '520322', '桐梓县', '3', '0', '278', '贵州', '遵义', '桐梓县', 'TZX', null);
INSERT INTO `t_pub_city` VALUES ('1220', '520402', '西秀区', '3', '0', '378', '贵州', '安顺', '西秀区', 'XXQ', null);
INSERT INTO `t_pub_city` VALUES ('1221', '520425', '紫云苗族布依族自治县', '3', '0', '378', '贵州', '安顺', '紫云苗族布依族自治县', 'ZYMZBYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1222', '610113', '雁塔区', '3', '0', '393', '陕西', '西安', '雁塔区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('1223', '610122', '蓝田县', '3', '0', '393', '陕西', '西安', '蓝田县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('1224', '640522', '海原县', '3', '0', '312', '宁夏回族自治区', '中卫', '海原县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('1225', '650106', '头屯河区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '头屯河区', 'TTHQ', null);
INSERT INTO `t_pub_city` VALUES ('1226', '650502', '伊州区', '3', '0', null, null, null, '伊州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('1227', '230110', '香坊区', '3', '0', '36', '黑龙江', '哈尔滨', '香坊区', 'XFQ', null);
INSERT INTO `t_pub_city` VALUES ('1228', '320830', '盱眙县', '3', '0', '147', '江苏', '淮安', '盱眙县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('1229', '360830', '永新县', '3', '0', '176', '江西', '吉安', '永新县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('1230', '130930', '孟村回族自治县', '3', '0', '196', '河北', '沧州', '孟村回族自治县', 'MCHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1231', '450110', '武鸣区', '3', '0', '254', '广西壮族自治区', '南宁', '武鸣区', 'WMQ', null);
INSERT INTO `t_pub_city` VALUES ('1232', '469030', '琼中黎族苗族自治县', '3', '0', '347', '海南', '三沙', '琼中黎族苗族自治县', 'QZLZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1233', '610430', '淳化县', '3', '0', '294', '陕西', '咸阳', '淳化县', 'CHX', null);
INSERT INTO `t_pub_city` VALUES ('1234', '460400', '儋州', '3', '0', '347', '海南', '三沙', '儋州', 'DZ', null);
INSERT INTO `t_pub_city` VALUES ('1235', '220621', '抚松县', '3', '0', '125', '吉林', '白山', '抚松县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('1236', '220623', '长白朝鲜族自治县', '3', '0', '125', '吉林', '白山', '长白朝鲜族自治县', 'CBCXZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1237', '220702', '宁江区', '3', '0', '135', '吉林', '松原', '宁江区', 'NJQ', null);
INSERT INTO `t_pub_city` VALUES ('1238', '220722', '长岭县', '3', '0', '135', '吉林', '松原', '长岭县', 'CLX', null);
INSERT INTO `t_pub_city` VALUES ('1239', '220802', '洮北区', '3', '0', '35', '吉林', '白城', '洮北区', 'TBQ', null);
INSERT INTO `t_pub_city` VALUES ('1240', '220822', '通榆县', '3', '0', '35', '吉林', '白城', '通榆县', 'TYX', null);
INSERT INTO `t_pub_city` VALUES ('1241', '220882', '大安', '3', '0', '35', '吉林', '白城', '大安', 'DA', null);
INSERT INTO `t_pub_city` VALUES ('1242', '222401', '延吉', '3', '0', '136', '吉林', '延边朝鲜族自治州', '延吉', 'YJ', null);
INSERT INTO `t_pub_city` VALUES ('1243', '222403', '敦化', '3', '0', '136', '吉林', '延边朝鲜族自治州', '敦化', 'DH', null);
INSERT INTO `t_pub_city` VALUES ('1244', '222404', '珲春', '3', '0', '136', '吉林', '延边朝鲜族自治州', '珲春', 'HC', null);
INSERT INTO `t_pub_city` VALUES ('1245', '222406', '和龙', '3', '0', '136', '吉林', '延边朝鲜族自治州', '和龙', 'HL', null);
INSERT INTO `t_pub_city` VALUES ('1246', '222426', '安图县', '3', '0', '136', '吉林', '延边朝鲜族自治州', '安图县', 'ATX', null);
INSERT INTO `t_pub_city` VALUES ('1247', '230103', '南岗区', '3', '0', '36', '黑龙江', '哈尔滨', '南岗区', 'NGQ', null);
INSERT INTO `t_pub_city` VALUES ('1248', '230108', '平房区', '3', '0', '36', '黑龙江', '哈尔滨', '平房区', 'PFQ', null);
INSERT INTO `t_pub_city` VALUES ('1249', '230111', '呼兰区', '3', '0', '36', '黑龙江', '哈尔滨', '呼兰区', 'HLQ', null);
INSERT INTO `t_pub_city` VALUES ('1250', '230113', '双城区', '3', '0', '36', '黑龙江', '哈尔滨', '双城区', 'SCQ', null);
INSERT INTO `t_pub_city` VALUES ('1251', '230124', '方正县', '3', '0', '36', '黑龙江', '哈尔滨', '方正县', 'FZX', null);
INSERT INTO `t_pub_city` VALUES ('1252', '230125', '宾县', '3', '0', '36', '黑龙江', '哈尔滨', '宾县', 'BX', null);
INSERT INTO `t_pub_city` VALUES ('1253', '230127', '木兰县', '3', '0', '36', '黑龙江', '哈尔滨', '木兰县', 'MLX', null);
INSERT INTO `t_pub_city` VALUES ('1254', '230129', '延寿县', '3', '0', '36', '黑龙江', '哈尔滨', '延寿县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1255', '230184', '五常', '3', '0', '36', '黑龙江', '哈尔滨', '五常', 'WC', null);
INSERT INTO `t_pub_city` VALUES ('1256', '230203', '建华区', '3', '0', '137', '黑龙江', '齐齐哈尔', '建华区', 'JHQ', null);
INSERT INTO `t_pub_city` VALUES ('1257', '230205', '昂昂溪区', '3', '0', '137', '黑龙江', '齐齐哈尔', '昂昂溪区', 'AAXQ', null);
INSERT INTO `t_pub_city` VALUES ('1258', '230207', '碾子山区', '3', '0', '137', '黑龙江', '齐齐哈尔', '碾子山区', 'NZSQ', null);
INSERT INTO `t_pub_city` VALUES ('1259', '230221', '龙江县', '3', '0', '137', '黑龙江', '齐齐哈尔', '龙江县', 'LJX', null);
INSERT INTO `t_pub_city` VALUES ('1260', '230223', '依安县', '3', '0', '137', '黑龙江', '齐齐哈尔', '依安县', 'YAX', null);
INSERT INTO `t_pub_city` VALUES ('1261', '230225', '甘南县', '3', '0', '137', '黑龙江', '齐齐哈尔', '甘南县', 'GNX', null);
INSERT INTO `t_pub_city` VALUES ('1262', '230229', '克山县', '3', '0', '137', '黑龙江', '齐齐哈尔', '克山县', 'KSX', null);
INSERT INTO `t_pub_city` VALUES ('1263', '230231', '拜泉县', '3', '0', '137', '黑龙江', '齐齐哈尔', '拜泉县', 'BQX', null);
INSERT INTO `t_pub_city` VALUES ('1264', '230302', '鸡冠区', '3', '0', '37', '黑龙江', '鸡西', '鸡冠区', 'JGQ', null);
INSERT INTO `t_pub_city` VALUES ('1265', '230304', '滴道区', '3', '0', '37', '黑龙江', '鸡西', '滴道区', 'DDQ', null);
INSERT INTO `t_pub_city` VALUES ('1266', '230306', '城子河区', '3', '0', '37', '黑龙江', '鸡西', '城子河区', 'CZHQ', null);
INSERT INTO `t_pub_city` VALUES ('1267', '410781', '卫辉', '3', '0', '191', '河南', '新乡', '卫辉', 'WH', null);
INSERT INTO `t_pub_city` VALUES ('1268', '410802', '解放区', '3', '0', '222', '河南', '焦作', '解放区', 'JFQ', null);
INSERT INTO `t_pub_city` VALUES ('1269', '410804', '马村区', '3', '0', '222', '河南', '焦作', '马村区', 'MCQ', null);
INSERT INTO `t_pub_city` VALUES ('1270', '410821', '修武县', '3', '0', '222', '河南', '焦作', '修武县', 'XWX', null);
INSERT INTO `t_pub_city` VALUES ('1271', '410823', '武陟县', '3', '0', '222', '河南', '焦作', '武陟县', 'WZX', null);
INSERT INTO `t_pub_city` VALUES ('1272', '410882', '沁阳', '3', '0', '222', '河南', '焦作', '沁阳', 'QY', null);
INSERT INTO `t_pub_city` VALUES ('1273', '410902', '华龙区', '3', '0', '316', '河南', '濮阳', '华龙区', 'HLQ', null);
INSERT INTO `t_pub_city` VALUES ('1274', '410923', '南乐县', '3', '0', '316', '河南', '濮阳', '南乐县', 'NLX', null);
INSERT INTO `t_pub_city` VALUES ('1275', '410927', '台前县', '3', '0', '316', '河南', '濮阳', '台前县', 'TQX', null);
INSERT INTO `t_pub_city` VALUES ('1276', '411002', '魏都区', '3', '0', '223', '河南', '许昌', '魏都区', 'WDQ', null);
INSERT INTO `t_pub_city` VALUES ('1277', '411024', '鄢陵县', '3', '0', '223', '河南', '许昌', '鄢陵县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('1278', '411081', '禹州', '3', '0', '223', '河南', '许昌', '禹州', 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('1279', '411082', '长葛', '3', '0', '223', '河南', '许昌', '长葛', 'CG', null);
INSERT INTO `t_pub_city` VALUES ('1280', '411103', '郾城区', '3', '0', '224', '河南', '漯河', '郾城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('1281', '411121', '舞阳县', '3', '0', '224', '河南', '漯河', '舞阳县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('1282', '411202', '湖滨区', '3', '0', '317', '河南', '三门峡', '湖滨区', 'HBQ', null);
INSERT INTO `t_pub_city` VALUES ('1283', '411221', '渑池县', '3', '0', '317', '河南', '三门峡', '渑池县', 'MCX', null);
INSERT INTO `t_pub_city` VALUES ('1284', '411282', '灵宝', '3', '0', '317', '河南', '三门峡', '灵宝', 'LB', null);
INSERT INTO `t_pub_city` VALUES ('1285', '411302', '宛城区', '3', '0', '225', '河南', '南阳', '宛城区', 'WCQ', null);
INSERT INTO `t_pub_city` VALUES ('1286', '411321', '南召县', '3', '0', '225', '河南', '南阳', '南召县', 'NSX', null);
INSERT INTO `t_pub_city` VALUES ('1287', '411323', '西峡县', '3', '0', '225', '河南', '南阳', '西峡县', 'XXX', null);
INSERT INTO `t_pub_city` VALUES ('1288', '411325', '内乡县', '3', '0', '225', '河南', '南阳', '内乡县', 'NXX', null);
INSERT INTO `t_pub_city` VALUES ('1289', '411327', '社旗县', '3', '0', '225', '河南', '南阳', '社旗县', 'SQX', null);
INSERT INTO `t_pub_city` VALUES ('1290', '411329', '新野县', '3', '0', '225', '河南', '南阳', '新野县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1291', '411381', '邓州', '3', '0', '225', '河南', '南阳', '邓州', 'DZ', null);
INSERT INTO `t_pub_city` VALUES ('1292', '411403', '睢阳区', '3', '0', '318', '河南', '商丘', '睢阳区', 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('1293', '411422', '睢县', '3', '0', '318', '河南', '商丘', '睢县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('1294', '411424', '柘城县', '3', '0', '318', '河南', '商丘', '柘城县', 'ZCX', null);
INSERT INTO `t_pub_city` VALUES ('1295', '411426', '夏邑县', '3', '0', '318', '河南', '商丘', '夏邑县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1296', '411502', '浉河区', '3', '0', '226', '河南', '信阳', '浉河区', 'SHQ', null);
INSERT INTO `t_pub_city` VALUES ('1297', '411521', '罗山县', '3', '0', '226', '河南', '信阳', '罗山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('1298', '411523', '新县', '3', '0', '226', '河南', '信阳', '新县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('1299', '411525', '固始县', '3', '0', '226', '河南', '信阳', '固始县', 'GSX', null);
INSERT INTO `t_pub_city` VALUES ('1300', '411526', '潢川县', '3', '0', '226', '河南', '信阳', '潢川县', 'HCX', null);
INSERT INTO `t_pub_city` VALUES ('1301', '411528', '息县', '3', '0', '226', '河南', '信阳', '息县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('1302', '411621', '扶沟县', '3', '0', '319', '河南', '周口', '扶沟县', 'FGX', null);
INSERT INTO `t_pub_city` VALUES ('1303', '411623', '商水县', '3', '0', '319', '河南', '周口', '商水县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('1304', '411625', '郸城县', '3', '0', '319', '河南', '周口', '郸城县', 'DCX', null);
INSERT INTO `t_pub_city` VALUES ('1305', '411627', '太康县', '3', '0', '319', '河南', '周口', '太康县', 'TKX', null);
INSERT INTO `t_pub_city` VALUES ('1306', '411681', '项城', '3', '0', '319', '河南', '周口', '项城', 'XC', null);
INSERT INTO `t_pub_city` VALUES ('1307', '411721', '西平县', '3', '0', '227', '河南', '驻马店', '西平县', 'XPX', null);
INSERT INTO `t_pub_city` VALUES ('1308', '411723', '平舆县', '3', '0', '227', '河南', '驻马店', '平舆县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('1309', '411725', '确山县', '3', '0', '227', '河南', '驻马店', '确山县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('1310', '411727', '汝南县', '3', '0', '227', '河南', '驻马店', '汝南县', 'RNX', null);
INSERT INTO `t_pub_city` VALUES ('1311', '411729', '新蔡县', '3', '0', '227', '河南', '驻马店', '新蔡县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('1312', '419001', '济源', '3', '0', '227', '河南', '驻马店', '济源', 'JY', null);
INSERT INTO `t_pub_city` VALUES ('1313', '420103', '江汉区', '3', '0', '320', '湖北', '武汉', '江汉区', 'JHQ', null);
INSERT INTO `t_pub_city` VALUES ('1314', '420105', '汉阳区', '3', '0', '320', '湖北', '武汉', '汉阳区', 'HYQ', null);
INSERT INTO `t_pub_city` VALUES ('1315', '420107', '青山区', '3', '0', '320', '湖北', '武汉', '青山区', 'QSQ', null);
INSERT INTO `t_pub_city` VALUES ('1316', '420112', '东西湖区', '3', '0', '320', '湖北', '武汉', '东西湖区', 'DXHQ', null);
INSERT INTO `t_pub_city` VALUES ('1317', '420114', '蔡甸区', '3', '0', '320', '湖北', '武汉', '蔡甸区', 'CDQ', null);
INSERT INTO `t_pub_city` VALUES ('1318', '420116', '黄陂区', '3', '0', '320', '湖北', '武汉', '黄陂区', 'HBQ', null);
INSERT INTO `t_pub_city` VALUES ('1319', '420202', '黄石港区', '3', '0', '228', '湖北', '黄石', '黄石港区', 'HSGQ', null);
INSERT INTO `t_pub_city` VALUES ('1320', '420204', '下陆区', '3', '0', '228', '湖北', '黄石', '下陆区', 'XLQ', null);
INSERT INTO `t_pub_city` VALUES ('1321', '420222', '阳新县', '3', '0', '228', '湖北', '黄石', '阳新县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('1322', '420302', '茅箭区', '3', '0', '229', '湖北', '十堰', '茅箭区', 'MJQ', null);
INSERT INTO `t_pub_city` VALUES ('1323', '420304', '郧阳区', '3', '0', '229', '湖北', '十堰', '郧阳区', 'YYQ', null);
INSERT INTO `t_pub_city` VALUES ('1324', '420322', '郧西县', '3', '0', '229', '湖北', '十堰', '郧西县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('1325', '420324', '竹溪县', '3', '0', '229', '湖北', '十堰', '竹溪县', 'ZXX', null);
INSERT INTO `t_pub_city` VALUES ('1326', '420381', '丹江口', '3', '0', '229', '湖北', '十堰', '丹江口', 'DJK', null);
INSERT INTO `t_pub_city` VALUES ('1327', '420503', '伍家岗区', '3', '0', '321', '湖北', '宜昌', '伍家岗区', 'WJGQ', null);
INSERT INTO `t_pub_city` VALUES ('1328', '420505', '猇亭区', '3', '0', '321', '湖北', '宜昌', '猇亭区', 'XTQ', null);
INSERT INTO `t_pub_city` VALUES ('1329', '420525', '远安县', '3', '0', '321', '湖北', '宜昌', '远安县', 'YAX', null);
INSERT INTO `t_pub_city` VALUES ('1330', '420527', '秭归县', '3', '0', '321', '湖北', '宜昌', '秭归县', 'ZGX', null);
INSERT INTO `t_pub_city` VALUES ('1331', '420529', '五峰土家族自治县', '3', '0', '321', '湖北', '宜昌', '五峰土家族自治县', 'WFTJZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1332', '420581', '宜都', '3', '0', '321', '湖北', '宜昌', '宜都', 'YD', null);
INSERT INTO `t_pub_city` VALUES ('1333', '420583', '枝江', '3', '0', '321', '湖北', '宜昌', '枝江', 'ZJ', null);
INSERT INTO `t_pub_city` VALUES ('1334', '420606', '樊城区', '3', '0', '230', '湖北', '襄阳', '樊城区', 'FCQ', null);
INSERT INTO `t_pub_city` VALUES ('1335', '420624', '南漳县', '3', '0', '230', '湖北', '襄阳', '南漳县', 'NZX', null);
INSERT INTO `t_pub_city` VALUES ('1336', '420626', '保康县', '3', '0', '230', '湖北', '襄阳', '保康县', 'BKX', null);
INSERT INTO `t_pub_city` VALUES ('1337', '420683', '枣阳', '3', '0', '230', '湖北', '襄阳', '枣阳', 'ZY', null);
INSERT INTO `t_pub_city` VALUES ('1338', '420702', '梁子湖区', '3', '0', '322', '湖北', '鄂州', '梁子湖区', 'LZHQ', null);
INSERT INTO `t_pub_city` VALUES ('1339', '420704', '鄂城区', '3', '0', '322', '湖北', '鄂州', '鄂城区', 'ECQ', null);
INSERT INTO `t_pub_city` VALUES ('1340', '420804', '掇刀区', '3', '0', '231', '湖北', '荆门', '掇刀区', 'DDQ', null);
INSERT INTO `t_pub_city` VALUES ('1341', '420822', '沙洋县', '3', '0', '231', '湖北', '荆门', '沙洋县', 'SXX', null);
INSERT INTO `t_pub_city` VALUES ('1342', '420902', '孝南区', '3', '0', '323', '湖北', '孝感', '孝南区', 'XNQ', null);
INSERT INTO `t_pub_city` VALUES ('1343', '420922', '大悟县', '3', '0', '323', '湖北', '孝感', '大悟县', 'DWX', null);
INSERT INTO `t_pub_city` VALUES ('1344', '420923', '云梦县', '3', '0', '323', '湖北', '孝感', '云梦县', 'YMX', null);
INSERT INTO `t_pub_city` VALUES ('1345', '420982', '安陆', '3', '0', '323', '湖北', '孝感', '安陆', 'AL', null);
INSERT INTO `t_pub_city` VALUES ('1346', '421002', '沙市区', '3', '0', '232', '湖北', '荆州', '沙市区', 'SSQ', null);
INSERT INTO `t_pub_city` VALUES ('1347', '421022', '公安县', '3', '0', '232', '湖北', '荆州', '公安县', 'GAX', null);
INSERT INTO `t_pub_city` VALUES ('1348', '421024', '江陵县', '3', '0', '232', '湖北', '荆州', '江陵县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('1349', '421083', '洪湖', '3', '0', '232', '湖北', '荆州', '洪湖', 'HH', null);
INSERT INTO `t_pub_city` VALUES ('1350', '421102', '黄州区', '3', '0', '324', '湖北', '黄冈', '黄州区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('1351', '421122', '红安县', '3', '0', '324', '湖北', '黄冈', '红安县', 'GAX', null);
INSERT INTO `t_pub_city` VALUES ('1352', '421124', '英山县', '3', '0', '324', '湖北', '黄冈', '英山县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1353', '421126', '蕲春县', '3', '0', '324', '湖北', '黄冈', '蕲春县', 'QCX', null);
INSERT INTO `t_pub_city` VALUES ('1354', '421181', '麻城', '3', '0', '324', '湖北', '黄冈', '麻城', 'MC', null);
INSERT INTO `t_pub_city` VALUES ('1355', '421202', '咸安区', '3', '0', '233', '湖北', '咸宁', '咸安区', 'XAQ', null);
INSERT INTO `t_pub_city` VALUES ('1356', '421222', '通城县', '3', '0', '233', '湖北', '咸宁', '通城县', 'TCX', null);
INSERT INTO `t_pub_city` VALUES ('1357', '421224', '通山县', '3', '0', '233', '湖北', '咸宁', '通山县', 'TSX', null);
INSERT INTO `t_pub_city` VALUES ('1358', '421303', '曾都区', '3', '0', '234', '湖北', '随州', '曾都区', 'CDQ', null);
INSERT INTO `t_pub_city` VALUES ('1359', '421321', '随县', '3', '0', '234', '湖北', '随州', '随县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('1360', '422802', '利川', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '利川', 'LC', null);
INSERT INTO `t_pub_city` VALUES ('1361', '422825', '宣恩县', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '宣恩县', 'XEX', null);
INSERT INTO `t_pub_city` VALUES ('1362', '422828', '鹤峰县', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '鹤峰县', 'HFX', null);
INSERT INTO `t_pub_city` VALUES ('1363', '429005', '潜江', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '潜江', 'QJ', null);
INSERT INTO `t_pub_city` VALUES ('1364', '430103', '天心区', '3', '0', '235', '湖南', '长沙', '天心区', 'TXQ', null);
INSERT INTO `t_pub_city` VALUES ('1365', '430105', '开福区', '3', '0', '235', '湖南', '长沙', '开福区', 'KFQ', null);
INSERT INTO `t_pub_city` VALUES ('1366', '430112', '望城区', '3', '0', '235', '湖南', '长沙', '望城区', 'WCQ', null);
INSERT INTO `t_pub_city` VALUES ('1367', '430124', '宁乡县', '3', '0', '235', '湖南', '长沙', '宁乡县', 'NXX', null);
INSERT INTO `t_pub_city` VALUES ('1368', '430202', '荷塘区', '3', '0', '326', '湖南', '株洲', '荷塘区', 'HTQ', null);
INSERT INTO `t_pub_city` VALUES ('1369', '430204', '石峰区', '3', '0', '326', '湖南', '株洲', '石峰区', 'SFQ', null);
INSERT INTO `t_pub_city` VALUES ('1370', '430221', '株洲县', '3', '0', '326', '湖南', '株洲', '株洲县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('1371', '430224', '茶陵县', '3', '0', '326', '湖南', '株洲', '茶陵县', 'CLX', null);
INSERT INTO `t_pub_city` VALUES ('1372', '430281', '醴陵', '3', '0', '326', '湖南', '株洲', '醴陵', 'LL', null);
INSERT INTO `t_pub_city` VALUES ('1373', '430304', '岳塘区', '3', '0', '236', '湖南', '湘潭', '岳塘区', 'YTQ', null);
INSERT INTO `t_pub_city` VALUES ('1374', '430321', '湘潭县', '3', '0', '236', '湖南', '湘潭', '湘潭县', 'XTX', null);
INSERT INTO `t_pub_city` VALUES ('1375', '430382', '韶山', '3', '0', '236', '湖南', '湘潭', '韶山', 'SS', null);
INSERT INTO `t_pub_city` VALUES ('1376', '430406', '雁峰区', '3', '0', '327', '湖南', '衡阳', '雁峰区', 'YFQ', null);
INSERT INTO `t_pub_city` VALUES ('1377', '430408', '蒸湘区', '3', '0', '327', '湖南', '衡阳', '蒸湘区', 'ZXQ', null);
INSERT INTO `t_pub_city` VALUES ('1378', '430421', '衡阳县', '3', '0', '327', '湖南', '衡阳', '衡阳县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('1379', '430423', '衡山县', '3', '0', '327', '湖南', '衡阳', '衡山县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('1380', '430426', '祁东县', '3', '0', '327', '湖南', '衡阳', '祁东县', 'QDX', null);
INSERT INTO `t_pub_city` VALUES ('1381', '430482', '常宁', '3', '0', '327', '湖南', '衡阳', '常宁', 'CN', null);
INSERT INTO `t_pub_city` VALUES ('1382', '430503', '大祥区', '3', '0', '237', '湖南', '邵阳', '大祥区', 'DXQ', null);
INSERT INTO `t_pub_city` VALUES ('1383', '430521', '邵东县', '3', '0', '237', '湖南', '邵阳', '邵东县', 'SDX', null);
INSERT INTO `t_pub_city` VALUES ('1384', '430523', '邵阳县', '3', '0', '237', '湖南', '邵阳', '邵阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('1385', '430525', '洞口县', '3', '0', '237', '湖南', '邵阳', '洞口县', 'DKX', null);
INSERT INTO `t_pub_city` VALUES ('1386', '430528', '新宁县', '3', '0', '237', '湖南', '邵阳', '新宁县', 'XNX', null);
INSERT INTO `t_pub_city` VALUES ('1387', '430581', '武冈', '3', '0', '237', '湖南', '邵阳', '武冈', 'WG', null);
INSERT INTO `t_pub_city` VALUES ('1388', '430602', '岳阳楼区', '3', '0', '238', '湖南', '岳阳', '岳阳楼区', 'YYLQ', null);
INSERT INTO `t_pub_city` VALUES ('1389', '430621', '岳阳县', '3', '0', '238', '湖南', '岳阳', '岳阳县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('1390', '430624', '湘阴县', '3', '0', '238', '湖南', '岳阳', '湘阴县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1391', '430682', '临湘', '3', '0', '238', '湖南', '岳阳', '临湘', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('1392', '430703', '鼎城区', '3', '0', '328', '湖南', '常德', '鼎城区', 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('1393', '430723', '澧县', '3', '0', '328', '湖南', '常德', '澧县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('1394', '430725', '桃源县', '3', '0', '328', '湖南', '常德', '桃源县', 'TYX', null);
INSERT INTO `t_pub_city` VALUES ('1395', '430802', '永定区', '3', '0', '239', '湖南', '张家界', '永定区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('1396', '430821', '慈利县', '3', '0', '239', '湖南', '张家界', '慈利县', 'CLX', null);
INSERT INTO `t_pub_city` VALUES ('1397', '430903', '赫山区', '3', '0', '329', '湖南', '益阳', '赫山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('1398', '430921', '南县', '3', '0', '329', '湖南', '益阳', '南县', 'NX', null);
INSERT INTO `t_pub_city` VALUES ('1399', '430981', '沅江', '3', '0', '329', '湖南', '益阳', '沅江', 'YJ', null);
INSERT INTO `t_pub_city` VALUES ('1400', '431003', '苏仙区', '3', '0', '240', '湖南', '郴州', '苏仙区', 'SXQ', null);
INSERT INTO `t_pub_city` VALUES ('1401', '431023', '永兴县', '3', '0', '240', '湖南', '郴州', '永兴县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('1402', '431025', '临武县', '3', '0', '240', '湖南', '郴州', '临武县', 'LWX', null);
INSERT INTO `t_pub_city` VALUES ('1403', '431028', '安仁县', '3', '0', '240', '湖南', '郴州', '安仁县', 'ARX', null);
INSERT INTO `t_pub_city` VALUES ('1404', '431102', '零陵区', '3', '0', '330', '湖南', '永州', '零陵区', 'LLQ', null);
INSERT INTO `t_pub_city` VALUES ('1405', '431122', '东安县', '3', '0', '330', '湖南', '永州', '东安县', 'DAX', null);
INSERT INTO `t_pub_city` VALUES ('1406', '431124', '道县', '3', '0', '330', '湖南', '永州', '道县', 'DX', null);
INSERT INTO `t_pub_city` VALUES ('1407', '431126', '宁远县', '3', '0', '330', '湖南', '永州', '宁远县', 'NYX', null);
INSERT INTO `t_pub_city` VALUES ('1408', '431128', '新田县', '3', '0', '330', '湖南', '永州', '新田县', 'XTX', null);
INSERT INTO `t_pub_city` VALUES ('1409', '431202', '鹤城区', '3', '0', '241', '湖南', '怀化', '鹤城区', 'HCQ', null);
INSERT INTO `t_pub_city` VALUES ('1410', '431221', '中方县', '3', '0', '241', '湖南', '怀化', '中方县', 'ZFX', null);
INSERT INTO `t_pub_city` VALUES ('1411', '431223', '辰溪县', '3', '0', '241', '湖南', '怀化', '辰溪县', 'CXX', null);
INSERT INTO `t_pub_city` VALUES ('1412', '431225', '会同县', '3', '0', '241', '湖南', '怀化', '会同县', 'HTX', null);
INSERT INTO `t_pub_city` VALUES ('1413', '431227', '新晃侗族自治县', '3', '0', '241', '湖南', '怀化', '新晃侗族自治县', 'XHDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1414', '431228', '芷江侗族自治县', '3', '0', '241', '湖南', '怀化', '芷江侗族自治县', 'ZJDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1415', '431230', '通道侗族自治县', '3', '0', '241', '湖南', '怀化', '通道侗族自治县', 'TDDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1416', '431281', '洪江', '3', '0', '241', '湖南', '怀化', '洪江', 'HJ', null);
INSERT INTO `t_pub_city` VALUES ('1417', '431321', '双峰县', '3', '0', '331', '湖南', '娄底', '双峰县', 'SFX', null);
INSERT INTO `t_pub_city` VALUES ('1418', '431381', '冷水江', '3', '0', '331', '湖南', '娄底', '冷水江', 'LSJ', null);
INSERT INTO `t_pub_city` VALUES ('1419', '433122', '泸溪县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '泸溪县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('1420', '433125', '保靖县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '保靖县', 'BJX', null);
INSERT INTO `t_pub_city` VALUES ('1421', '433130', '龙山县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '龙山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('1422', '440104', '越秀区', '3', '0', '332', '广东', '广州', '越秀区', 'YXQ', null);
INSERT INTO `t_pub_city` VALUES ('1423', '440106', '天河区', '3', '0', '332', '广东', '广州', '天河区', 'THQ', null);
INSERT INTO `t_pub_city` VALUES ('1424', '440111', '白云区', '3', '0', '332', '广东', '广州', '白云区', 'BYQ', null);
INSERT INTO `t_pub_city` VALUES ('1425', '440113', '番禺区', '3', '0', '332', '广东', '广州', '番禺区', 'FYQ', null);
INSERT INTO `t_pub_city` VALUES ('1426', '440115', '南沙区', '3', '0', '332', '广东', '广州', '南沙区', 'NSQ', null);
INSERT INTO `t_pub_city` VALUES ('1427', '440118', '增城区', '3', '0', '332', '广东', '广州', '增城区', 'ZCQ', null);
INSERT INTO `t_pub_city` VALUES ('1428', '440204', '浈江区', '3', '0', '333', '广东', '韶关', '浈江区', 'ZJQ', null);
INSERT INTO `t_pub_city` VALUES ('1429', '440222', '始兴县', '3', '0', '333', '广东', '韶关', '始兴县', 'SXX', null);
INSERT INTO `t_pub_city` VALUES ('1430', '440229', '翁源县', '3', '0', '333', '广东', '韶关', '翁源县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('1431', '440233', '新丰县', '3', '0', '333', '广东', '韶关', '新丰县', 'XFX', null);
INSERT INTO `t_pub_city` VALUES ('1432', '440281', '乐昌', '3', '0', '333', '广东', '韶关', '乐昌', 'LC', null);
INSERT INTO `t_pub_city` VALUES ('1433', '440303', '罗湖区', '3', '0', '243', '广东', '深圳', '罗湖区', 'LHQ', null);
INSERT INTO `t_pub_city` VALUES ('1434', '440305', '南山区', '3', '0', '243', '广东', '深圳', '南山区', 'NSQ', null);
INSERT INTO `t_pub_city` VALUES ('1435', '440307', '龙岗区', '3', '0', '243', '广东', '深圳', '龙岗区', 'LGQ', null);
INSERT INTO `t_pub_city` VALUES ('1436', '440402', '香洲区', '3', '0', '244', '广东', '珠海', '香洲区', 'XZQ', null);
INSERT INTO `t_pub_city` VALUES ('1437', '440404', '金湾区', '3', '0', '244', '广东', '珠海', '金湾区', 'JWQ', null);
INSERT INTO `t_pub_city` VALUES ('1438', '440511', '金平区', '3', '0', '334', '广东', '汕头', '金平区', 'JPQ', null);
INSERT INTO `t_pub_city` VALUES ('1439', '440513', '潮阳区', '3', '0', '334', '广东', '汕头', '潮阳区', 'CYQ', null);
INSERT INTO `t_pub_city` VALUES ('1440', '440515', '澄海区', '3', '0', '334', '广东', '汕头', '澄海区', 'CHQ', null);
INSERT INTO `t_pub_city` VALUES ('1441', '440604', '禅城区', '3', '0', '245', '广东', '佛山', '禅城区', 'CCQ', null);
INSERT INTO `t_pub_city` VALUES ('1442', '440606', '顺德区', '3', '0', '245', '广东', '佛山', '顺德区', 'SDQ', null);
INSERT INTO `t_pub_city` VALUES ('1443', '440608', '高明区', '3', '0', '245', '广东', '佛山', '高明区', 'GMQ', null);
INSERT INTO `t_pub_city` VALUES ('1444', '440704', '江海区', '3', '0', '335', '广东', '江门', '江海区', 'JHQ', null);
INSERT INTO `t_pub_city` VALUES ('1445', '440781', '台山', '3', '0', '335', '广东', '江门', '台山', 'TS', null);
INSERT INTO `t_pub_city` VALUES ('1446', '440783', '开平', '3', '0', '335', '广东', '江门', '开平', 'KP', null);
INSERT INTO `t_pub_city` VALUES ('1447', '440785', '恩平', '3', '0', '335', '广东', '江门', '恩平', 'EP', null);
INSERT INTO `t_pub_city` VALUES ('1448', '440803', '霞山区', '3', '0', '246', '广东', '湛江', '霞山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('1449', '440811', '麻章区', '3', '0', '246', '广东', '湛江', '麻章区', 'MZQ', null);
INSERT INTO `t_pub_city` VALUES ('1450', '440825', '徐闻县', '3', '0', '246', '广东', '湛江', '徐闻县', 'XWX', null);
INSERT INTO `t_pub_city` VALUES ('1451', '440882', '雷州', '3', '0', '246', '广东', '湛江', '雷州', 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('1452', '440902', '茂南区', '3', '0', '336', '广东', '茂名', '茂南区', 'MNQ', null);
INSERT INTO `t_pub_city` VALUES ('1453', '440981', '高州', '3', '0', '336', '广东', '茂名', '高州', 'GZ', null);
INSERT INTO `t_pub_city` VALUES ('1454', '440983', '信宜', '3', '0', '336', '广东', '茂名', '信宜', 'XY', null);
INSERT INTO `t_pub_city` VALUES ('1455', '441203', '鼎湖区', '3', '0', '247', '广东', '肇庆', '鼎湖区', 'DHQ', null);
INSERT INTO `t_pub_city` VALUES ('1456', '441223', '广宁县', '3', '0', '247', '广东', '肇庆', '广宁县', 'ANX', null);
INSERT INTO `t_pub_city` VALUES ('1457', '441225', '封开县', '3', '0', '247', '广东', '肇庆', '封开县', 'FKX', null);
INSERT INTO `t_pub_city` VALUES ('1458', '441284', '四会', '3', '0', '247', '广东', '肇庆', '四会', 'SH', null);
INSERT INTO `t_pub_city` VALUES ('1459', '441303', '惠阳区', '3', '0', '337', '广东', '惠州', '惠阳区', 'HYQ', null);
INSERT INTO `t_pub_city` VALUES ('1460', '441323', '惠东县', '3', '0', '337', '广东', '惠州', '惠东县', 'HDX', null);
INSERT INTO `t_pub_city` VALUES ('1461', '441324', '龙门县', '3', '0', '337', '广东', '惠州', '龙门县', 'LMX', null);
INSERT INTO `t_pub_city` VALUES ('1462', '441403', '梅县区', '3', '0', '248', '广东', '梅州', '梅县区', 'MXQ', null);
INSERT INTO `t_pub_city` VALUES ('1463', '441423', '丰顺县', '3', '0', '248', '广东', '梅州', '丰顺县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('1464', '441426', '平远县', '3', '0', '248', '广东', '梅州', '平远县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('1465', '441481', '兴宁', '3', '0', '248', '广东', '梅州', '兴宁', 'XN', null);
INSERT INTO `t_pub_city` VALUES ('1466', '441521', '海丰县', '3', '0', '249', '广东', '汕尾', '海丰县', 'HFX', null);
INSERT INTO `t_pub_city` VALUES ('1467', '441581', '陆丰', '3', '0', '249', '广东', '汕尾', '陆丰', 'LF', null);
INSERT INTO `t_pub_city` VALUES ('1468', '441621', '紫金县', '3', '0', '338', '广东', '河源', '紫金县', 'ZJX', null);
INSERT INTO `t_pub_city` VALUES ('1469', '441623', '连平县', '3', '0', '338', '广东', '河源', '连平县', 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('1470', '441625', '东源县', '3', '0', '338', '广东', '河源', '东源县', 'DYX', null);
INSERT INTO `t_pub_city` VALUES ('1471', '441704', '阳东区', '3', '0', '250', '广东', '阳江', '阳东区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('1472', '441781', '阳春', '3', '0', '250', '广东', '阳江', '阳春', 'YC', null);
INSERT INTO `t_pub_city` VALUES ('1473', '441803', '清新区', '3', '0', '339', '广东', '清远', '清新区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('1474', '441823', '阳山县', '3', '0', '339', '广东', '清远', '阳山县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1475', '441826', '连南瑶族自治县', '3', '0', '339', '广东', '清远', '连南瑶族自治县', 'LNYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1476', '441881', '英德', '3', '0', '339', '广东', '清远', '英德', 'YD', null);
INSERT INTO `t_pub_city` VALUES ('1477', '445102', '湘桥区', '3', '0', '252', '广东', '潮州', '湘桥区', 'XQQ', null);
INSERT INTO `t_pub_city` VALUES ('1478', '445122', '饶平县', '3', '0', '252', '广东', '潮州', '饶平县', 'RPX', null);
INSERT INTO `t_pub_city` VALUES ('1479', '445203', '揭东区', '3', '0', '341', '广东', '揭阳', '揭东区', 'JDQ', null);
INSERT INTO `t_pub_city` VALUES ('1480', '445224', '惠来县', '3', '0', '341', '广东', '揭阳', '惠来县', 'HLX', null);
INSERT INTO `t_pub_city` VALUES ('1481', '445281', '普宁', '3', '0', '341', '广东', '揭阳', '普宁', 'PN', null);
INSERT INTO `t_pub_city` VALUES ('1482', '445303', '云安区', '3', '0', '253', '广东', '云浮', '云安区', 'YAQ', null);
INSERT INTO `t_pub_city` VALUES ('1483', '445322', '郁南县', '3', '0', '253', '广东', '云浮', '郁南县', 'YNX', null);
INSERT INTO `t_pub_city` VALUES ('1484', '450102', '兴宁区', '3', '0', '254', '广西壮族自治区', '南宁', '兴宁区', 'XNQ', null);
INSERT INTO `t_pub_city` VALUES ('1485', '450105', '江南区', '3', '0', '254', '广西壮族自治区', '南宁', '江南区', 'JNQ', null);
INSERT INTO `t_pub_city` VALUES ('1486', '450108', '良庆区', '3', '0', '254', '广西壮族自治区', '南宁', '良庆区', 'LQQ', null);
INSERT INTO `t_pub_city` VALUES ('1487', '450123', '隆安县', '3', '0', '254', '广西壮族自治区', '南宁', '隆安县', 'LAX', null);
INSERT INTO `t_pub_city` VALUES ('1488', '450125', '上林县', '3', '0', '254', '广西壮族自治区', '南宁', '上林县', 'SLX', null);
INSERT INTO `t_pub_city` VALUES ('1489', '450127', '横县', '3', '0', '254', '广西壮族自治区', '南宁', '横县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('1490', '450203', '鱼峰区', '3', '0', '342', '广西壮族自治区', '柳州', '鱼峰区', 'YFQ', null);
INSERT INTO `t_pub_city` VALUES ('1491', '450205', '柳北区', '3', '0', '342', '广西壮族自治区', '柳州', '柳北区', 'LBQ', null);
INSERT INTO `t_pub_city` VALUES ('1492', '450222', '柳城县', '3', '0', '342', '广西壮族自治区', '柳州', '柳城县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('1493', '450224', '融安县', '3', '0', '342', '广西壮族自治区', '柳州', '融安县', 'RAX', null);
INSERT INTO `t_pub_city` VALUES ('1494', '450225', '融水苗族自治县', '3', '0', '342', '广西壮族自治区', '柳州', '融水苗族自治县', 'RSMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1495', '450302', '秀峰区', '3', '0', '255', '广西壮族自治区', '桂林', '秀峰区', 'XFQ', null);
INSERT INTO `t_pub_city` VALUES ('1496', '450304', '象山区', '3', '0', '255', '广西壮族自治区', '桂林', '象山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('1497', '450311', '雁山区', '3', '0', '255', '广西壮族自治区', '桂林', '雁山区', 'YSQ', null);
INSERT INTO `t_pub_city` VALUES ('1498', '450321', '阳朔县', '3', '0', '255', '广西壮族自治区', '桂林', '阳朔县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1499', '450324', '全州县', '3', '0', '255', '广西壮族自治区', '桂林', '全州县', 'QZX', null);
INSERT INTO `t_pub_city` VALUES ('1500', '450326', '永福县', '3', '0', '255', '广西壮族自治区', '桂林', '永福县', 'YFX', null);
INSERT INTO `t_pub_city` VALUES ('1501', '450327', '灌阳县', '3', '0', '255', '广西壮族自治区', '桂林', '灌阳县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('1502', '450329', '资源县', '3', '0', '255', '广西壮族自治区', '桂林', '资源县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('1503', '450331', '荔浦县', '3', '0', '255', '广西壮族自治区', '桂林', '荔浦县', 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('1504', '450403', '万秀区', '3', '0', '256', '广西壮族自治区', '梧州', '万秀区', 'WXQ', null);
INSERT INTO `t_pub_city` VALUES ('1505', '450405', '长洲区', '3', '0', '256', '广西壮族自治区', '梧州', '长洲区', 'CZQ', null);
INSERT INTO `t_pub_city` VALUES ('1506', '450421', '苍梧县', '3', '0', '256', '广西壮族自治区', '梧州', '苍梧县', 'CWX', null);
INSERT INTO `t_pub_city` VALUES ('1507', '450423', '蒙山县', '3', '0', '256', '广西壮族自治区', '梧州', '蒙山县', 'MSX', null);
INSERT INTO `t_pub_city` VALUES ('1508', '450502', '海城区', '3', '0', '343', '广西壮族自治区', '北海', '海城区', 'HCQ', null);
INSERT INTO `t_pub_city` VALUES ('1509', '450512', '铁山港区', '3', '0', '343', '广西壮族自治区', '北海', '铁山港区', 'TSGQ', null);
INSERT INTO `t_pub_city` VALUES ('1510', '450602', '港口区', '3', '0', '257', '广西壮族自治区', '防城港', '港口区', 'GKQ', null);
INSERT INTO `t_pub_city` VALUES ('1511', '450621', '上思县', '3', '0', '257', '广西壮族自治区', '防城港', '上思县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('1512', '450702', '钦南区', '3', '0', '258', '广西壮族自治区', '钦州', '钦南区', 'QNQ', null);
INSERT INTO `t_pub_city` VALUES ('1513', '450721', '灵山县', '3', '0', '258', '广西壮族自治区', '钦州', '灵山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('1514', '450802', '港北区', '3', '0', '344', '广西壮族自治区', '贵港', '港北区', 'GBQ', null);
INSERT INTO `t_pub_city` VALUES ('1515', '450804', '覃塘区', '3', '0', '344', '广西壮族自治区', '贵港', '覃塘区', 'QTQ', null);
INSERT INTO `t_pub_city` VALUES ('1516', '450881', '桂平', '3', '0', '344', '广西壮族自治区', '贵港', '桂平', 'GP', null);
INSERT INTO `t_pub_city` VALUES ('1517', '450903', '福绵区', '3', '0', '259', '广西壮族自治区', '玉林', '福绵区', 'FMQ', null);
INSERT INTO `t_pub_city` VALUES ('1518', '450922', '陆川县', '3', '0', '259', '广西壮族自治区', '玉林', '陆川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('1519', '450924', '兴业县', '3', '0', '259', '广西壮族自治区', '玉林', '兴业县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1520', '451002', '右江区', '3', '0', '260', '广西壮族自治区', '百色', '右江区', 'YJQ', null);
INSERT INTO `t_pub_city` VALUES ('1521', '451022', '田东县', '3', '0', '260', '广西壮族自治区', '百色', '田东县', 'TDX', null);
INSERT INTO `t_pub_city` VALUES ('1522', '451024', '德保县', '3', '0', '260', '广西壮族自治区', '百色', '德保县', 'DBX', null);
INSERT INTO `t_pub_city` VALUES ('1523', '451026', '那坡县', '3', '0', '260', '广西壮族自治区', '百色', '那坡县', 'NPX', null);
INSERT INTO `t_pub_city` VALUES ('1524', '451028', '乐业县', '3', '0', '260', '广西壮族自治区', '百色', '乐业县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('1525', '451030', '西林县', '3', '0', '260', '广西壮族自治区', '百色', '西林县', 'XLX', null);
INSERT INTO `t_pub_city` VALUES ('1526', '451081', '靖西', '3', '0', '260', '广西壮族自治区', '百色', '靖西', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('1527', '451103', '平桂区', '3', '0', '345', '广西壮族自治区', '贺州', '平桂区', 'PGQ', null);
INSERT INTO `t_pub_city` VALUES ('1528', '451123', '富川瑶族自治县', '3', '0', '345', '广西壮族自治区', '贺州', '富川瑶族自治县', 'FCYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1529', '451221', '南丹县', '3', '0', '261', '广西壮族自治区', '河池', '南丹县', 'NDX', null);
INSERT INTO `t_pub_city` VALUES ('1530', '451223', '凤山县', '3', '0', '261', '广西壮族自治区', '河池', '凤山县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('1531', '451225', '罗城仫佬族自治县', '3', '0', '261', '广西壮族自治区', '河池', '罗城仫佬族自治县', 'LCMLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1532', '451228', '都安瑶族自治县', '3', '0', '261', '广西壮族自治区', '河池', '都安瑶族自治县', 'DAYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1533', '451229', '大化瑶族自治县', '3', '0', '261', '广西壮族自治区', '河池', '大化瑶族自治县', 'DHYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1534', '451302', '兴宾区', '3', '0', '262', '广西壮族自治区', '来宾', '兴宾区', 'XBQ', null);
INSERT INTO `t_pub_city` VALUES ('1535', '451322', '象州县', '3', '0', '262', '广西壮族自治区', '来宾', '象州县', 'XZX', null);
INSERT INTO `t_pub_city` VALUES ('1536', '451381', '合山', '3', '0', '262', '广西壮族自治区', '来宾', '合山', 'GS', null);
INSERT INTO `t_pub_city` VALUES ('1537', '451421', '扶绥县', '3', '0', '346', '广西壮族自治区', '崇左', '扶绥县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('1538', '451424', '大新县', '3', '0', '346', '广西壮族自治区', '崇左', '大新县', 'DXX', null);
INSERT INTO `t_pub_city` VALUES ('1539', '451481', '凭祥', '3', '0', '346', '广西壮族自治区', '崇左', '凭祥', 'PX', null);
INSERT INTO `t_pub_city` VALUES ('1540', '460106', '龙华区', '3', '0', '263', '海南', '海口', '龙华区', 'LHQ', null);
INSERT INTO `t_pub_city` VALUES ('1541', '460108', '美兰区', '3', '0', '263', '海南', '海口', '美兰区', 'MLQ', null);
INSERT INTO `t_pub_city` VALUES ('1542', '460204', '天涯区', '3', '0', '264', '海南', '三亚', '天涯区', 'TYQ', null);
INSERT INTO `t_pub_city` VALUES ('1543', '469001', '五指山', '3', '0', '347', '海南', '三沙', '五指山', 'WZS', null);
INSERT INTO `t_pub_city` VALUES ('1544', '469002', '琼海', '3', '0', '347', '海南', '三沙', '琼海', 'QH', null);
INSERT INTO `t_pub_city` VALUES ('1545', '469006', '万宁', '3', '0', '347', '海南', '三沙', '万宁', 'WN', null);
INSERT INTO `t_pub_city` VALUES ('1546', '469021', '定安县', '3', '0', '347', '海南', '三沙', '定安县', 'DAX', null);
INSERT INTO `t_pub_city` VALUES ('1547', '469023', '澄迈县', '3', '0', '347', '海南', '三沙', '澄迈县', 'CMX', null);
INSERT INTO `t_pub_city` VALUES ('1548', '469024', '临高县', '3', '0', '347', '海南', '三沙', '临高县', 'LGX', null);
INSERT INTO `t_pub_city` VALUES ('1549', '469026', '昌江黎族自治县', '3', '0', '347', '海南', '三沙', '昌江黎族自治县', 'CJLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1550', '469028', '陵水黎族自治县', '3', '0', '347', '海南', '三沙', '陵水黎族自治县', 'LSLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1551', '469029', '保亭黎族苗族自治县', '3', '0', '347', '海南', '三沙', '保亭黎族苗族自治县', 'BTLZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1552', '510105', '青羊区', '3', '0', '265', '四川', '成都', '青羊区', 'QYQ', null);
INSERT INTO `t_pub_city` VALUES ('1553', '510107', '武侯区', '3', '0', '265', '四川', '成都', '武侯区', 'WHQ', null);
INSERT INTO `t_pub_city` VALUES ('1554', '510112', '龙泉驿区', '3', '0', '265', '四川', '成都', '龙泉驿区', 'LQYQ', null);
INSERT INTO `t_pub_city` VALUES ('1555', '510114', '新都区', '3', '0', '265', '四川', '成都', '新都区', 'XDQ', null);
INSERT INTO `t_pub_city` VALUES ('1556', '510116', '双流区', '3', '0', '265', '四川', '成都', '双流区', 'SLQ', null);
INSERT INTO `t_pub_city` VALUES ('1557', '510121', '金堂县', '3', '0', '265', '四川', '成都', '金堂县', 'JTX', null);
INSERT INTO `t_pub_city` VALUES ('1558', '510131', '蒲江县', '3', '0', '265', '四川', '成都', '蒲江县', 'PJX', null);
INSERT INTO `t_pub_city` VALUES ('1559', '510132', '新津县', '3', '0', '265', '四川', '成都', '新津县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('1560', '510182', '彭州', '3', '0', '265', '四川', '成都', '彭州', 'PZ', null);
INSERT INTO `t_pub_city` VALUES ('1561', '510184', '崇州', '3', '0', '265', '四川', '成都', '崇州', 'CZ', null);
INSERT INTO `t_pub_city` VALUES ('1562', '510302', '自流井区', '3', '0', '266', '四川', '自贡', '自流井区', 'ZLJQ', null);
INSERT INTO `t_pub_city` VALUES ('1563', '510304', '大安区', '3', '0', '266', '四川', '自贡', '大安区', 'DAQ', null);
INSERT INTO `t_pub_city` VALUES ('1564', '510321', '荣县', '3', '0', '266', '四川', '自贡', '荣县', 'RX', null);
INSERT INTO `t_pub_city` VALUES ('1565', '510402', '东区', '3', '0', '368', '四川', '攀枝花', '东区', 'DQ', null);
INSERT INTO `t_pub_city` VALUES ('1566', '510411', '仁和区', '3', '0', '368', '四川', '攀枝花', '仁和区', 'RHQ', null);
INSERT INTO `t_pub_city` VALUES ('1567', '510422', '盐边县', '3', '0', '368', '四川', '攀枝花', '盐边县', 'YBX', null);
INSERT INTO `t_pub_city` VALUES ('1568', '510503', '纳溪区', '3', '0', '267', '四川', '泸州', '纳溪区', 'NXQ', null);
INSERT INTO `t_pub_city` VALUES ('1569', '510521', '泸县', '3', '0', '267', '四川', '泸州', '泸县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('1570', '510524', '叙永县', '3', '0', '267', '四川', '泸州', '叙永县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1571', '510603', '旌阳区', '3', '0', '369', '四川', '德阳', '旌阳区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('1572', '510626', '罗江县', '3', '0', '369', '四川', '德阳', '罗江县', 'LJX', null);
INSERT INTO `t_pub_city` VALUES ('1573', '510682', '什邡', '3', '0', '369', '四川', '德阳', '什邡', 'SF', null);
INSERT INTO `t_pub_city` VALUES ('1574', '510703', '涪城区', '3', '0', '268', '四川', '绵阳', '涪城区', 'FCQ', null);
INSERT INTO `t_pub_city` VALUES ('1575', '510705', '安州区', '3', '0', '268', '四川', '绵阳', '安州区', 'AZQ', null);
INSERT INTO `t_pub_city` VALUES ('1576', '510723', '盐亭县', '3', '0', '268', '四川', '绵阳', '盐亭县', 'YTX', null);
INSERT INTO `t_pub_city` VALUES ('1577', '510726', '北川羌族自治县', '3', '0', '268', '四川', '绵阳', '北川羌族自治县', 'BCQZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1578', '510727', '平武县', '3', '0', '268', '四川', '绵阳', '平武县', 'PWX', null);
INSERT INTO `t_pub_city` VALUES ('1579', '510802', '利州区', '3', '0', '370', '四川', '广元', '利州区', 'LZQ', null);
INSERT INTO `t_pub_city` VALUES ('1580', '510812', '朝天区', '3', '0', '370', '四川', '广元', '朝天区', 'CTQ', null);
INSERT INTO `t_pub_city` VALUES ('1581', '510822', '青川县', '3', '0', '370', '四川', '广元', '青川县', 'QCX', null);
INSERT INTO `t_pub_city` VALUES ('1582', '510824', '苍溪县', '3', '0', '370', '四川', '广元', '苍溪县', 'CXX', null);
INSERT INTO `t_pub_city` VALUES ('1583', '510904', '安居区', '3', '0', '269', '四川', '遂宁', '安居区', 'AJQ', null);
INSERT INTO `t_pub_city` VALUES ('1584', '510922', '射洪县', '3', '0', '269', '四川', '遂宁', '射洪县', 'SHX', null);
INSERT INTO `t_pub_city` VALUES ('1585', '511002', '市中区', '3', '0', '270', '四川', '内江', '市中区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('1586', '511024', '威远县', '3', '0', '270', '四川', '内江', '威远县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('1587', '511028', '隆昌县', '3', '0', '270', '四川', '内江', '隆昌县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('1588', '511111', '沙湾区', '3', '0', '371', '四川', '乐山', '沙湾区', 'SWQ', null);
INSERT INTO `t_pub_city` VALUES ('1589', '511113', '金口河区', '3', '0', '371', '四川', '乐山', '金口河区', 'JKHQ', null);
INSERT INTO `t_pub_city` VALUES ('1590', '511124', '井研县', '3', '0', '371', '四川', '乐山', '井研县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('1591', '511126', '夹江县', '3', '0', '371', '四川', '乐山', '夹江县', 'GJX', null);
INSERT INTO `t_pub_city` VALUES ('1592', '511132', '峨边彝族自治县', '3', '0', '371', '四川', '乐山', '峨边彝族自治县', 'EBYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1593', '511181', '峨眉山', '3', '0', '371', '四川', '乐山', '峨眉山', 'EMS', null);
INSERT INTO `t_pub_city` VALUES ('1594', '511303', '高坪区', '3', '0', '271', '四川', '南充', '高坪区', 'GPQ', null);
INSERT INTO `t_pub_city` VALUES ('1595', '511321', '南部县', '3', '0', '271', '四川', '南充', '南部县', 'NBX', null);
INSERT INTO `t_pub_city` VALUES ('1596', '511323', '蓬安县', '3', '0', '271', '四川', '南充', '蓬安县', 'PAX', null);
INSERT INTO `t_pub_city` VALUES ('1597', '511325', '西充县', '3', '0', '271', '四川', '南充', '西充县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('1598', '511381', '阆中', '3', '0', '271', '四川', '南充', '阆中', 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('1599', '511403', '彭山区', '3', '0', '372', '四川', '眉山', '彭山区', 'PSQ', null);
INSERT INTO `t_pub_city` VALUES ('1600', '511423', '洪雅县', '3', '0', '372', '四川', '眉山', '洪雅县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('1601', '511425', '青神县', '3', '0', '372', '四川', '眉山', '青神县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('1602', '511503', '南溪区', '3', '0', '272', '四川', '宜宾', '南溪区', 'NXQ', null);
INSERT INTO `t_pub_city` VALUES ('1603', '511523', '江安县', '3', '0', '272', '四川', '宜宾', '江安县', 'JAX', null);
INSERT INTO `t_pub_city` VALUES ('1604', '511525', '高县', '3', '0', '272', '四川', '宜宾', '高县', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('1605', '511527', '筠连县', '3', '0', '272', '四川', '宜宾', '筠连县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('1606', '511529', '屏山县', '3', '0', '272', '四川', '宜宾', '屏山县', 'PSX', null);
INSERT INTO `t_pub_city` VALUES ('1607', '511603', '前锋区', '3', '0', '373', '四川', '广安', '前锋区', 'QFQ', null);
INSERT INTO `t_pub_city` VALUES ('1608', '511622', '武胜县', '3', '0', '373', '四川', '广安', '武胜县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('1609', '511681', '华蓥', '3', '0', '373', '四川', '广安', '华蓥', 'HY', null);
INSERT INTO `t_pub_city` VALUES ('1610', '511703', '达川区', '3', '0', '273', '四川', '达州', '达川区', 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('1611', '511723', '开江县', '3', '0', '273', '四川', '达州', '开江县', 'KJX', null);
INSERT INTO `t_pub_city` VALUES ('1612', '511725', '渠县', '3', '0', '273', '四川', '达州', '渠县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('1613', '511802', '雨城区', '3', '0', '374', '四川', '雅安', '雨城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('1614', '511822', '荥经县', '3', '0', '374', '四川', '雅安', '荥经县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('1615', '511823', '汉源县', '3', '0', '374', '四川', '雅安', '汉源县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('1616', '511825', '天全县', '3', '0', '374', '四川', '雅安', '天全县', 'TQX', null);
INSERT INTO `t_pub_city` VALUES ('1617', '511827', '宝兴县', '3', '0', '374', '四川', '雅安', '宝兴县', 'BXX', null);
INSERT INTO `t_pub_city` VALUES ('1618', '511903', '恩阳区', '3', '0', '274', '四川', '巴中', '恩阳区', 'EYQ', null);
INSERT INTO `t_pub_city` VALUES ('1619', '511922', '南江县', '3', '0', '274', '四川', '巴中', '南江县', 'NJX', null);
INSERT INTO `t_pub_city` VALUES ('1620', '512002', '雁江区', '3', '0', '275', '四川', '资阳', '雁江区', 'YJQ', null);
INSERT INTO `t_pub_city` VALUES ('1621', '512022', '乐至县', '3', '0', '275', '四川', '资阳', '乐至县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('1622', '513222', '理县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '理县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('1623', '513225', '九寨沟县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '九寨沟县', 'JZGX', null);
INSERT INTO `t_pub_city` VALUES ('1624', '513227', '小金县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '小金县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('1625', '513231', '阿坝县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '阿坝县', 'ABX', null);
INSERT INTO `t_pub_city` VALUES ('1626', '513301', '康定', '3', '0', '276', '四川', '甘孜藏族自治州', '康定', 'KD', null);
INSERT INTO `t_pub_city` VALUES ('1627', '513323', '丹巴县', '3', '0', '276', '四川', '甘孜藏族自治州', '丹巴县', 'DBX', null);
INSERT INTO `t_pub_city` VALUES ('1628', '513325', '雅江县', '3', '0', '276', '四川', '甘孜藏族自治州', '雅江县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('1629', '513328', '甘孜县', '3', '0', '276', '四川', '甘孜藏族自治州', '甘孜县', 'GZX', null);
INSERT INTO `t_pub_city` VALUES ('1630', '513330', '德格县', '3', '0', '276', '四川', '甘孜藏族自治州', '德格县', 'DGX', null);
INSERT INTO `t_pub_city` VALUES ('1631', '513333', '色达县', '3', '0', '276', '四川', '甘孜藏族自治州', '色达县', 'SDX', null);
INSERT INTO `t_pub_city` VALUES ('1632', '513335', '巴塘县', '3', '0', '276', '四川', '甘孜藏族自治州', '巴塘县', 'BTX', null);
INSERT INTO `t_pub_city` VALUES ('1633', '513338', '得荣县', '3', '0', '276', '四川', '甘孜藏族自治州', '得荣县', 'DRX', null);
INSERT INTO `t_pub_city` VALUES ('1634', '513422', '木里藏族自治县', '3', '0', '376', '四川', '凉山彝族自治州', '木里藏族自治县', 'MLCZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1635', '513425', '会理县', '3', '0', '376', '四川', '凉山彝族自治州', '会理县', 'HLX', null);
INSERT INTO `t_pub_city` VALUES ('1636', '513427', '宁南县', '3', '0', '376', '四川', '凉山彝族自治州', '宁南县', 'NNX', null);
INSERT INTO `t_pub_city` VALUES ('1637', '513429', '布拖县', '3', '0', '376', '四川', '凉山彝族自治州', '布拖县', 'BTX', null);
INSERT INTO `t_pub_city` VALUES ('1638', '513432', '喜德县', '3', '0', '376', '四川', '凉山彝族自治州', '喜德县', 'XDX', null);
INSERT INTO `t_pub_city` VALUES ('1639', '513434', '越西县', '3', '0', '376', '四川', '凉山彝族自治州', '越西县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('1640', '513437', '雷波县', '3', '0', '376', '四川', '凉山彝族自治州', '雷波县', 'LBX', null);
INSERT INTO `t_pub_city` VALUES ('1641', '520103', '云岩区', '3', '0', '377', '贵州', '贵阳', '云岩区', 'YYQ', null);
INSERT INTO `t_pub_city` VALUES ('1642', '520112', '乌当区', '3', '0', '377', '贵州', '贵阳', '乌当区', 'WDQ', null);
INSERT INTO `t_pub_city` VALUES ('1643', '520115', '观山湖区', '3', '0', '377', '贵州', '贵阳', '观山湖区', 'GSHQ', null);
INSERT INTO `t_pub_city` VALUES ('1644', '520122', '息烽县', '3', '0', '377', '贵州', '贵阳', '息烽县', 'XFX', null);
INSERT INTO `t_pub_city` VALUES ('1645', '520181', '清镇', '3', '0', '377', '贵州', '贵阳', '清镇', 'QZ', null);
INSERT INTO `t_pub_city` VALUES ('1646', '520203', '六枝特区', '3', '0', '277', '贵州', '六盘水', '六枝特区', 'LZTQ', null);
INSERT INTO `t_pub_city` VALUES ('1647', '520302', '红花岗区', '3', '0', '278', '贵州', '遵义', '红花岗区', 'GHGQ', null);
INSERT INTO `t_pub_city` VALUES ('1648', '520304', '播州区', '3', '0', '278', '贵州', '遵义', '播州区', 'BZQ', null);
INSERT INTO `t_pub_city` VALUES ('1649', '520324', '正安县', '3', '0', '278', '贵州', '遵义', '正安县', 'ZAX', null);
INSERT INTO `t_pub_city` VALUES ('1650', '520325', '道真仡佬族苗族自治县', '3', '0', '278', '贵州', '遵义', '道真仡佬族苗族自治县', 'DZGLZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1651', '520328', '湄潭县', '3', '0', '278', '贵州', '遵义', '湄潭县', 'MTX', null);
INSERT INTO `t_pub_city` VALUES ('1652', '520329', '余庆县', '3', '0', '278', '贵州', '遵义', '余庆县', 'YQX', null);
INSERT INTO `t_pub_city` VALUES ('1653', '520381', '赤水', '3', '0', '278', '贵州', '遵义', '赤水', 'CS', null);
INSERT INTO `t_pub_city` VALUES ('1654', '520403', '平坝区', '3', '0', '378', '贵州', '安顺', '平坝区', 'PBQ', null);
INSERT INTO `t_pub_city` VALUES ('1655', '520423', '镇宁布依族苗族自治县', '3', '0', '378', '贵州', '安顺', '镇宁布依族苗族自治县', 'ZNBYZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1656', '520502', '七星关区', '3', '0', '279', '贵州', '毕节', '七星关区', 'QXGQ', null);
INSERT INTO `t_pub_city` VALUES ('1657', '520521', '大方县', '3', '0', '279', '贵州', '毕节', '大方县', 'DFX', null);
INSERT INTO `t_pub_city` VALUES ('1658', '520523', '金沙县', '3', '0', '279', '贵州', '毕节', '金沙县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('1659', '520525', '纳雍县', '3', '0', '279', '贵州', '毕节', '纳雍县', 'NYX', null);
INSERT INTO `t_pub_city` VALUES ('1660', '520527', '赫章县', '3', '0', '279', '贵州', '毕节', '赫章县', 'HZX', null);
INSERT INTO `t_pub_city` VALUES ('1661', '520602', '碧江区', '3', '0', '379', '贵州', '铜仁', '碧江区', 'BJQ', null);
INSERT INTO `t_pub_city` VALUES ('1662', '520621', '江口县', '3', '0', '379', '贵州', '铜仁', '江口县', 'JKX', null);
INSERT INTO `t_pub_city` VALUES ('1663', '520623', '石阡县', '3', '0', '379', '贵州', '铜仁', '石阡县', 'SQX', null);
INSERT INTO `t_pub_city` VALUES ('1664', '520624', '思南县', '3', '0', '379', '贵州', '铜仁', '思南县', 'SNX', null);
INSERT INTO `t_pub_city` VALUES ('1665', '520626', '德江县', '3', '0', '379', '贵州', '铜仁', '德江县', 'DJX', null);
INSERT INTO `t_pub_city` VALUES ('1666', '520627', '沿河土家族自治县', '3', '0', '379', '贵州', '铜仁', '沿河土家族自治县', 'YHTJZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1667', '522322', '兴仁县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '兴仁县', 'XRX', null);
INSERT INTO `t_pub_city` VALUES ('1668', '522325', '贞丰县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '贞丰县', 'ZFX', null);
INSERT INTO `t_pub_city` VALUES ('1669', '522328', '安龙县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '安龙县', 'ALX', null);
INSERT INTO `t_pub_city` VALUES ('1670', '522622', '黄平县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '黄平县', 'HPX', null);
INSERT INTO `t_pub_city` VALUES ('1671', '522625', '镇远县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '镇远县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('1672', '522628', '锦屏县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '锦屏县', 'JPX', null);
INSERT INTO `t_pub_city` VALUES ('1673', '522631', '黎平县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '黎平县', 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('1674', '522634', '雷山县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '雷山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('1675', '522701', '都匀', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '都匀', 'DY', null);
INSERT INTO `t_pub_city` VALUES ('1676', '522723', '贵定县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '贵定县', 'GDX', null);
INSERT INTO `t_pub_city` VALUES ('1677', '522726', '独山县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '独山县', 'DSX', null);
INSERT INTO `t_pub_city` VALUES ('1678', '522729', '长顺县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '长顺县', 'CSX', null);
INSERT INTO `t_pub_city` VALUES ('1679', '522732', '三都水族自治县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '三都水族自治县', 'SDSZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1680', '530103', '盘龙区', '3', '0', '281', '云南', '昆明', '盘龙区', 'PLQ', null);
INSERT INTO `t_pub_city` VALUES ('1681', '530112', '西山区', '3', '0', '281', '云南', '昆明', '西山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('1682', '530114', '呈贡区', '3', '0', '281', '云南', '昆明', '呈贡区', 'CGQ', null);
INSERT INTO `t_pub_city` VALUES ('1683', '530124', '富民县', '3', '0', '281', '云南', '昆明', '富民县', 'FMX', null);
INSERT INTO `t_pub_city` VALUES ('1684', '530126', '石林彝族自治县', '3', '0', '281', '云南', '昆明', '石林彝族自治县', 'SLYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1685', '530128', '禄劝彝族苗族自治县', '3', '0', '281', '云南', '昆明', '禄劝彝族苗族自治县', 'LQYZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1686', '530181', '安宁', '3', '0', '281', '云南', '昆明', '安宁', 'AN', null);
INSERT INTO `t_pub_city` VALUES ('1687', '530302', '麒麟区', '3', '0', '382', '云南', '曲靖', '麒麟区', 'QLQ', null);
INSERT INTO `t_pub_city` VALUES ('1688', '530321', '马龙县', '3', '0', '382', '云南', '曲靖', '马龙县', 'MLX', null);
INSERT INTO `t_pub_city` VALUES ('1689', '530323', '师宗县', '3', '0', '382', '云南', '曲靖', '师宗县', 'SZX', null);
INSERT INTO `t_pub_city` VALUES ('1690', '530325', '富源县', '3', '0', '382', '云南', '曲靖', '富源县', 'FYX', null);
INSERT INTO `t_pub_city` VALUES ('1691', '530381', '宣威', '3', '0', '382', '云南', '曲靖', '宣威', 'XW', null);
INSERT INTO `t_pub_city` VALUES ('1692', '530403', '江川区', '3', '0', '282', '云南', '玉溪', '江川区', 'JCQ', null);
INSERT INTO `t_pub_city` VALUES ('1693', '530422', '澄江县', '3', '0', '282', '云南', '玉溪', '澄江县', 'CJX', null);
INSERT INTO `t_pub_city` VALUES ('1694', '530424', '华宁县', '3', '0', '282', '云南', '玉溪', '华宁县', 'HNX', null);
INSERT INTO `t_pub_city` VALUES ('1695', '530426', '峨山彝族自治县', '3', '0', '282', '云南', '玉溪', '峨山彝族自治县', 'ESYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1696', '530428', '元江哈尼族彝族傣族自治县', '3', '0', '282', '云南', '玉溪', '元江哈尼族彝族傣族自治县', 'YJHNZYZDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1697', '530502', '隆阳区', '3', '0', '383', '云南', '保山', '隆阳区', 'LYQ', null);
INSERT INTO `t_pub_city` VALUES ('1698', '530581', '腾冲', '3', '0', '383', '云南', '保山', '腾冲', 'TC', null);
INSERT INTO `t_pub_city` VALUES ('1699', '530524', '昌宁县', '3', '0', '383', '云南', '保山', '昌宁县', 'CNX', null);
INSERT INTO `t_pub_city` VALUES ('1700', '530621', '鲁甸县', '3', '0', '283', '云南', '昭通', '鲁甸县', 'LDX', null);
INSERT INTO `t_pub_city` VALUES ('1701', '530623', '盐津县', '3', '0', '283', '云南', '昭通', '盐津县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('1702', '530625', '永善县', '3', '0', '283', '云南', '昭通', '永善县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1703', '530627', '镇雄县', '3', '0', '283', '云南', '昭通', '镇雄县', 'ZXX', null);
INSERT INTO `t_pub_city` VALUES ('1704', '530629', '威信县', '3', '0', '283', '云南', '昭通', '威信县', 'WXX', null);
INSERT INTO `t_pub_city` VALUES ('1705', '530702', '古城区', '3', '0', '384', '云南', '丽江', '古城区', 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('1706', '530722', '永胜县', '3', '0', '384', '云南', '丽江', '永胜县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1707', '530723', '华坪县', '3', '0', '384', '云南', '丽江', '华坪县', 'HPX', null);
INSERT INTO `t_pub_city` VALUES ('1708', '530802', '思茅区', '3', '0', '284', '云南', '普洱', '思茅区', 'SMQ', null);
INSERT INTO `t_pub_city` VALUES ('1709', '530821', '宁洱哈尼族彝族自治县', '3', '0', '284', '云南', '普洱', '宁洱哈尼族彝族自治县', 'NEHNZYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1710', '530823', '景东彝族自治县', '3', '0', '284', '云南', '普洱', '景东彝族自治县', 'JDYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1711', '530825', '镇沅彝族哈尼族拉祜族自治县', '3', '0', '284', '云南', '普洱', '镇沅彝族哈尼族拉祜族自治县', 'ZYYZHNZLHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1712', '530826', '江城哈尼族彝族自治县', '3', '0', '284', '云南', '普洱', '江城哈尼族彝族自治县', 'JCHNZYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1713', '530828', '澜沧拉祜族自治县', '3', '0', '284', '云南', '普洱', '澜沧拉祜族自治县', 'LCLHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1714', '530829', '西盟佤族自治县', '3', '0', '284', '云南', '普洱', '西盟佤族自治县', 'XMWZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1715', '530902', '临翔区', '3', '0', '385', '云南', '临沧', '临翔区', 'LXQ', null);
INSERT INTO `t_pub_city` VALUES ('1716', '530922', '云县', '3', '0', '385', '云南', '临沧', '云县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('1717', '530924', '镇康县', '3', '0', '385', '云南', '临沧', '镇康县', 'ZKX', null);
INSERT INTO `t_pub_city` VALUES ('1718', '530926', '耿马傣族佤族自治县', '3', '0', '385', '云南', '临沧', '耿马傣族佤族自治县', 'GMDZWZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1719', '530927', '沧源佤族自治县', '3', '0', '385', '云南', '临沧', '沧源佤族自治县', 'CYWZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1720', '532322', '双柏县', '3', '0', '285', '云南', '楚雄彝族自治州', '双柏县', 'SBX', null);
INSERT INTO `t_pub_city` VALUES ('1721', '532324', '南华县', '3', '0', '285', '云南', '楚雄彝族自治州', '南华县', 'NHX', null);
INSERT INTO `t_pub_city` VALUES ('1722', '532327', '永仁县', '3', '0', '285', '云南', '楚雄彝族自治州', '永仁县', 'YRX', null);
INSERT INTO `t_pub_city` VALUES ('1723', '532329', '武定县', '3', '0', '285', '云南', '楚雄彝族自治州', '武定县', 'WDX', null);
INSERT INTO `t_pub_city` VALUES ('1724', '532502', '开远', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '开远', 'KY', null);
INSERT INTO `t_pub_city` VALUES ('1725', '532523', '屏边苗族自治县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '屏边苗族自治县', 'PBMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1726', '532527', '泸西县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '泸西县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('1727', '532531', '绿春县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '绿春县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('1728', '532601', '文山', '3', '0', '286', '云南', '文山壮族苗族自治州', '文山', 'WS', null);
INSERT INTO `t_pub_city` VALUES ('1729', '532624', '麻栗坡县', '3', '0', '286', '云南', '文山壮族苗族自治州', '麻栗坡县', 'MLPX', null);
INSERT INTO `t_pub_city` VALUES ('1730', '532626', '丘北县', '3', '0', '286', '云南', '文山壮族苗族自治州', '丘北县', 'QBX', null);
INSERT INTO `t_pub_city` VALUES ('1731', '532801', '景洪', '3', '0', '387', '云南', '西双版纳傣族自治州', '景洪', 'JH', null);
INSERT INTO `t_pub_city` VALUES ('1732', '532901', '大理', '3', '0', '388', '云南', '大理白族自治州', '大理', 'DL', null);
INSERT INTO `t_pub_city` VALUES ('1733', '532923', '祥云县', '3', '0', '388', '云南', '大理白族自治州', '祥云县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1734', '532925', '弥渡县', '3', '0', '388', '云南', '大理白族自治州', '弥渡县', 'MDX', null);
INSERT INTO `t_pub_city` VALUES ('1735', '532927', '巍山彝族回族自治县', '3', '0', '388', '云南', '大理白族自治州', '巍山彝族回族自治县', 'WSYZHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1736', '532929', '云龙县', '3', '0', '388', '云南', '大理白族自治州', '云龙县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('1737', '532932', '鹤庆县', '3', '0', '388', '云南', '大理白族自治州', '鹤庆县', 'HQX', null);
INSERT INTO `t_pub_city` VALUES ('1738', '533122', '梁河县', '3', '0', '287', '云南', '德宏傣族景颇族自治州', '梁河县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('1739', '533301', '泸水', '3', '0', '389', '云南', '怒江傈僳族自治州', '泸水', 'LS', null);
INSERT INTO `t_pub_city` VALUES ('1740', '533324', '贡山独龙族怒族自治县', '3', '0', '389', '云南', '怒江傈僳族自治州', '贡山独龙族怒族自治县', 'GSDLZNZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1741', '533401', '香格里拉', '3', '0', '288', '云南', '迪庆藏族自治州', '香格里拉', 'XGLL', null);
INSERT INTO `t_pub_city` VALUES ('1742', '533423', '维西傈僳族自治县', '3', '0', '288', '云南', '迪庆藏族自治州', '维西傈僳族自治县', 'WXLSZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1743', '540103', '堆龙德庆区', '3', '0', '390', '西藏自治区', '拉萨', '堆龙德庆区', 'DLDQQ', null);
INSERT INTO `t_pub_city` VALUES ('1744', '540122', '当雄县', '3', '0', '390', '西藏自治区', '拉萨', '当雄县', 'DXX', null);
INSERT INTO `t_pub_city` VALUES ('1745', '540124', '曲水县', '3', '0', '390', '西藏自治区', '拉萨', '曲水县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('1746', '540127', '墨竹工卡县', '3', '0', '390', '西藏自治区', '拉萨', '墨竹工卡县', 'MZGKX', null);
INSERT INTO `t_pub_city` VALUES ('1747', '540221', '南木林县', '3', '0', '289', '西藏自治区', '日喀则', '南木林县', 'NMLX', null);
INSERT INTO `t_pub_city` VALUES ('1748', '540223', '定日县', '3', '0', '289', '西藏自治区', '日喀则', '定日县', 'DRX', null);
INSERT INTO `t_pub_city` VALUES ('1749', '540225', '拉孜县', '3', '0', '289', '西藏自治区', '日喀则', '拉孜县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('1750', '540227', '谢通门县', '3', '0', '289', '西藏自治区', '日喀则', '谢通门县', 'XTMX', null);
INSERT INTO `t_pub_city` VALUES ('1751', '540229', '仁布县', '3', '0', '289', '西藏自治区', '日喀则', '仁布县', 'RBX', null);
INSERT INTO `t_pub_city` VALUES ('1752', '540231', '定结县', '3', '0', '289', '西藏自治区', '日喀则', '定结县', 'DJX', null);
INSERT INTO `t_pub_city` VALUES ('1753', '540233', '亚东县', '3', '0', '289', '西藏自治区', '日喀则', '亚东县', 'YDX', null);
INSERT INTO `t_pub_city` VALUES ('1754', '540235', '聂拉木县', '3', '0', '289', '西藏自治区', '日喀则', '聂拉木县', 'NLMX', null);
INSERT INTO `t_pub_city` VALUES ('1755', '540237', '岗巴县', '3', '0', '289', '西藏自治区', '日喀则', '岗巴县', 'GBX', null);
INSERT INTO `t_pub_city` VALUES ('1756', '540321', '江达县', '3', '0', '391', '西藏自治区', '昌都', '江达县', 'JDX', null);
INSERT INTO `t_pub_city` VALUES ('1757', '540323', '类乌齐县', '3', '0', '391', '西藏自治区', '昌都', '类乌齐县', 'LWJX', null);
INSERT INTO `t_pub_city` VALUES ('1758', '540325', '察雅县', '3', '0', '391', '西藏自治区', '昌都', '察雅县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('1759', '540327', '左贡县', '3', '0', '391', '西藏自治区', '昌都', '左贡县', 'ZGX', null);
INSERT INTO `t_pub_city` VALUES ('1760', '540329', '洛隆县', '3', '0', '391', '西藏自治区', '昌都', '洛隆县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('1761', '540402', '巴宜区', '3', '0', '290', '西藏自治区', '林芝', '巴宜区', 'BYQ', null);
INSERT INTO `t_pub_city` VALUES ('1762', '540422', '米林县', '3', '0', '290', '西藏自治区', '林芝', '米林县', 'MLX', null);
INSERT INTO `t_pub_city` VALUES ('1763', '540424', '波密县', '3', '0', '290', '西藏自治区', '林芝', '波密县', 'BMX', null);
INSERT INTO `t_pub_city` VALUES ('1764', '540425', '察隅县', '3', '0', '290', '西藏自治区', '林芝', '察隅县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('1765', '540521', '扎囊县', '3', '0', '392', '西藏自治区', '山南', '扎囊县', 'ZNX', null);
INSERT INTO `t_pub_city` VALUES ('1766', '540522', '贡嘎县', '3', '0', '392', '西藏自治区', '山南', '贡嘎县', 'GGX', null);
INSERT INTO `t_pub_city` VALUES ('1767', '540524', '琼结县', '3', '0', '392', '西藏自治区', '山南', '琼结县', 'QJX', null);
INSERT INTO `t_pub_city` VALUES ('1768', '540526', '措美县', '3', '0', '392', '西藏自治区', '山南', '措美县', 'CMX', null);
INSERT INTO `t_pub_city` VALUES ('1769', '540528', '加查县', '3', '0', '392', '西藏自治区', '山南', '加查县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('1770', '540530', '错那县', '3', '0', '392', '西藏自治区', '山南', '错那县', 'CNX', null);
INSERT INTO `t_pub_city` VALUES ('1771', '542421', '那曲县', '3', '0', '291', '西藏自治区', '那曲地区', '那曲县', 'NQX', null);
INSERT INTO `t_pub_city` VALUES ('1772', '542423', '比如县', '3', '0', '291', '西藏自治区', '那曲地区', '比如县', 'BRX', null);
INSERT INTO `t_pub_city` VALUES ('1773', '542425', '安多县', '3', '0', '291', '西藏自治区', '那曲地区', '安多县', 'ADX', null);
INSERT INTO `t_pub_city` VALUES ('1774', '542427', '索县', '3', '0', '291', '西藏自治区', '那曲地区', '索县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('1775', '542429', '巴青县', '3', '0', '291', '西藏自治区', '那曲地区', '巴青县', 'BQX', null);
INSERT INTO `t_pub_city` VALUES ('1776', '542431', '双湖县', '3', '0', '291', '西藏自治区', '那曲地区', '双湖县', 'SHX', null);
INSERT INTO `t_pub_city` VALUES ('1777', '542523', '噶尔县', '3', '0', '292', '西藏自治区', '阿里地区', '噶尔县', 'GEX', null);
INSERT INTO `t_pub_city` VALUES ('1778', '542525', '革吉县', '3', '0', '292', '西藏自治区', '阿里地区', '革吉县', 'GJX', null);
INSERT INTO `t_pub_city` VALUES ('1779', '542527', '措勤县', '3', '0', '292', '西藏自治区', '阿里地区', '措勤县', 'CQX', null);
INSERT INTO `t_pub_city` VALUES ('1780', '610104', '莲湖区', '3', '0', '393', '陕西', '西安', '莲湖区', 'LHQ', null);
INSERT INTO `t_pub_city` VALUES ('1781', '610112', '未央区', '3', '0', '393', '陕西', '西安', '未央区', 'WYQ', null);
INSERT INTO `t_pub_city` VALUES ('1782', '610114', '阎良区', '3', '0', '393', '陕西', '西安', '阎良区', 'YLQ', null);
INSERT INTO `t_pub_city` VALUES ('1783', '610116', '长安区', '3', '0', '393', '陕西', '西安', '长安区', 'CAQ', null);
INSERT INTO `t_pub_city` VALUES ('1784', '610124', '周至县', '3', '0', '393', '陕西', '西安', '周至县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('1785', '610202', '王益区', '3', '0', '293', '陕西', '铜川', '王益区', 'WYQ', null);
INSERT INTO `t_pub_city` VALUES ('1786', '610222', '宜君县', '3', '0', '293', '陕西', '铜川', '宜君县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('1787', '610302', '渭滨区', '3', '0', '394', '陕西', '宝鸡', '渭滨区', 'WBQ', null);
INSERT INTO `t_pub_city` VALUES ('1788', '610304', '陈仓区', '3', '0', '394', '陕西', '宝鸡', '陈仓区', 'CCQ', null);
INSERT INTO `t_pub_city` VALUES ('1789', '610323', '岐山县', '3', '0', '394', '陕西', '宝鸡', '岐山县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('1790', '610324', '扶风县', '3', '0', '394', '陕西', '宝鸡', '扶风县', 'FFX', null);
INSERT INTO `t_pub_city` VALUES ('1791', '610328', '千阳县', '3', '0', '394', '陕西', '宝鸡', '千阳县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('1792', '610330', '凤县', '3', '0', '394', '陕西', '宝鸡', '凤县', 'FX', null);
INSERT INTO `t_pub_city` VALUES ('1793', '610402', '秦都区', '3', '0', '294', '陕西', '咸阳', '秦都区', 'QDQ', null);
INSERT INTO `t_pub_city` VALUES ('1794', '610403', '杨陵区', '3', '0', '294', '陕西', '咸阳', '杨陵区', 'YLQ', null);
INSERT INTO `t_pub_city` VALUES ('1795', '610422', '三原县', '3', '0', '294', '陕西', '咸阳', '三原县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('1796', '610424', '乾县', '3', '0', '294', '陕西', '咸阳', '乾县', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('1797', '610426', '永寿县', '3', '0', '294', '陕西', '咸阳', '永寿县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('1798', '610428', '长武县', '3', '0', '294', '陕西', '咸阳', '长武县', 'CWX', null);
INSERT INTO `t_pub_city` VALUES ('1799', '610431', '武功县', '3', '0', '294', '陕西', '咸阳', '武功县', 'WGX', null);
INSERT INTO `t_pub_city` VALUES ('1800', '610502', '临渭区', '3', '0', '395', '陕西', '渭南', '临渭区', 'LWQ', null);
INSERT INTO `t_pub_city` VALUES ('1801', '610522', '潼关县', '3', '0', '395', '陕西', '渭南', '潼关县', 'TGX', null);
INSERT INTO `t_pub_city` VALUES ('1802', '610524', '合阳县', '3', '0', '395', '陕西', '渭南', '合阳县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('1803', '610526', '蒲城县', '3', '0', '395', '陕西', '渭南', '蒲城县', 'PCX', null);
INSERT INTO `t_pub_city` VALUES ('1804', '610528', '富平县', '3', '0', '395', '陕西', '渭南', '富平县', 'FPX', null);
INSERT INTO `t_pub_city` VALUES ('1805', '610582', '华阴', '3', '0', '395', '陕西', '渭南', '华阴', 'HY', null);
INSERT INTO `t_pub_city` VALUES ('1806', '610621', '延长县', '3', '0', '295', '陕西', '延安', '延长县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('1807', '610623', '子长县', '3', '0', '295', '陕西', '延安', '子长县', 'ZCX', null);
INSERT INTO `t_pub_city` VALUES ('1808', '610625', '志丹县', '3', '0', '295', '陕西', '延安', '志丹县', 'ZDX', null);
INSERT INTO `t_pub_city` VALUES ('1809', '610627', '甘泉县', '3', '0', '295', '陕西', '延安', '甘泉县', 'GQX', null);
INSERT INTO `t_pub_city` VALUES ('1810', '610629', '洛川县', '3', '0', '295', '陕西', '延安', '洛川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('1811', '610631', '黄龙县', '3', '0', '295', '陕西', '延安', '黄龙县', 'HLX', null);
INSERT INTO `t_pub_city` VALUES ('1812', '610702', '汉台区', '3', '0', '296', '陕西', '汉中', '汉台区', 'HTQ', null);
INSERT INTO `t_pub_city` VALUES ('1813', '610721', '南郑县', '3', '0', '296', '陕西', '汉中', '南郑县', 'NZX', null);
INSERT INTO `t_pub_city` VALUES ('1814', '610723', '洋县', '3', '0', '296', '陕西', '汉中', '洋县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('1815', '610725', '勉县', '3', '0', '296', '陕西', '汉中', '勉县', 'MX', null);
INSERT INTO `t_pub_city` VALUES ('1816', '610727', '略阳县', '3', '0', '296', '陕西', '汉中', '略阳县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('1817', '610729', '留坝县', '3', '0', '296', '陕西', '汉中', '留坝县', 'LBX', null);
INSERT INTO `t_pub_city` VALUES ('1818', '610802', '榆阳区', '3', '0', '396', '陕西', '榆林', '榆阳区', 'YYQ', null);
INSERT INTO `t_pub_city` VALUES ('1819', '610821', '神木县', '3', '0', '396', '陕西', '榆林', '神木县', 'SMX', null);
INSERT INTO `t_pub_city` VALUES ('1820', '610824', '靖边县', '3', '0', '396', '陕西', '榆林', '靖边县', 'JBX', null);
INSERT INTO `t_pub_city` VALUES ('1821', '610826', '绥德县', '3', '0', '396', '陕西', '榆林', '绥德县', 'SDX', null);
INSERT INTO `t_pub_city` VALUES ('1822', '610828', '佳县', '3', '0', '396', '陕西', '榆林', '佳县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('1823', '610830', '清涧县', '3', '0', '396', '陕西', '榆林', '清涧县', 'QJX', null);
INSERT INTO `t_pub_city` VALUES ('1824', '610902', '汉滨区', '3', '0', '297', '陕西', '安康', '汉滨区', 'HBQ', null);
INSERT INTO `t_pub_city` VALUES ('1825', '610922', '石泉县', '3', '0', '297', '陕西', '安康', '石泉县', 'SQX', null);
INSERT INTO `t_pub_city` VALUES ('1826', '610924', '紫阳县', '3', '0', '297', '陕西', '安康', '紫阳县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('1827', '610926', '平利县', '3', '0', '297', '陕西', '安康', '平利县', 'PLX', null);
INSERT INTO `t_pub_city` VALUES ('1828', '610927', '镇坪县', '3', '0', '297', '陕西', '安康', '镇坪县', 'ZPX', null);
INSERT INTO `t_pub_city` VALUES ('1829', '610929', '白河县', '3', '0', '297', '陕西', '安康', '白河县', 'BHX', null);
INSERT INTO `t_pub_city` VALUES ('1830', '611021', '洛南县', '3', '0', '397', '陕西', '商洛', '洛南县', 'LNX', null);
INSERT INTO `t_pub_city` VALUES ('1831', '611023', '商南县', '3', '0', '397', '陕西', '商洛', '商南县', 'SNX', null);
INSERT INTO `t_pub_city` VALUES ('1832', '611025', '镇安县', '3', '0', '397', '陕西', '商洛', '镇安县', 'ZAX', null);
INSERT INTO `t_pub_city` VALUES ('1833', '620102', '城关区', '3', '0', '298', '甘肃', '兰州', '城关区', 'CGQ', null);
INSERT INTO `t_pub_city` VALUES ('1834', '620104', '西固区', '3', '0', '298', '甘肃', '兰州', '西固区', 'XGQ', null);
INSERT INTO `t_pub_city` VALUES ('1835', '620111', '红古区', '3', '0', '298', '甘肃', '兰州', '红古区', 'GGQ', null);
INSERT INTO `t_pub_city` VALUES ('1836', '620122', '皋兰县', '3', '0', '298', '甘肃', '兰州', '皋兰县', 'GLX', null);
INSERT INTO `t_pub_city` VALUES ('1837', '620302', '金川区', '3', '0', '299', '甘肃', '金昌', '金川区', 'JCQ', null);
INSERT INTO `t_pub_city` VALUES ('1838', '620402', '白银区', '3', '0', '399', '甘肃', '白银', '白银区', 'BYQ', null);
INSERT INTO `t_pub_city` VALUES ('1839', '620421', '靖远县', '3', '0', '399', '甘肃', '白银', '靖远县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('1840', '620423', '景泰县', '3', '0', '399', '甘肃', '白银', '景泰县', 'JTX', null);
INSERT INTO `t_pub_city` VALUES ('1841', '620502', '秦州区', '3', '0', '300', '甘肃', '天水', '秦州区', 'QZQ', null);
INSERT INTO `t_pub_city` VALUES ('1842', '620521', '清水县', '3', '0', '300', '甘肃', '天水', '清水县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('1843', '620523', '甘谷县', '3', '0', '300', '甘肃', '天水', '甘谷县', 'GGX', null);
INSERT INTO `t_pub_city` VALUES ('1844', '620525', '张家川回族自治县', '3', '0', '300', '甘肃', '天水', '张家川回族自治县', 'ZJCHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1845', '620621', '民勤县', '3', '0', '301', '甘肃', '武威', '民勤县', 'MQX', null);
INSERT INTO `t_pub_city` VALUES ('1846', '620623', '天祝藏族自治县', '3', '0', '301', '甘肃', '武威', '天祝藏族自治县', 'TZCZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1847', '620721', '肃南裕固族自治县', '3', '0', '400', '甘肃', '张掖', '肃南裕固族自治县', 'SNYGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1848', '620723', '临泽县', '3', '0', '400', '甘肃', '张掖', '临泽县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('1849', '620725', '山丹县', '3', '0', '400', '甘肃', '张掖', '山丹县', 'SDX', null);
INSERT INTO `t_pub_city` VALUES ('1850', '620821', '泾川县', '3', '0', '302', '甘肃', '平凉', '泾川县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('1851', '620823', '崇信县', '3', '0', '302', '甘肃', '平凉', '崇信县', 'CXX', null);
INSERT INTO `t_pub_city` VALUES ('1852', '620825', '庄浪县', '3', '0', '302', '甘肃', '平凉', '庄浪县', 'ZLX', null);
INSERT INTO `t_pub_city` VALUES ('1853', '620902', '肃州区', '3', '0', '401', '甘肃', '酒泉', '肃州区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('1854', '620922', '瓜州县', '3', '0', '401', '甘肃', '酒泉', '瓜州县', 'GZX', null);
INSERT INTO `t_pub_city` VALUES ('1855', '620924', '阿克塞哈萨克族自治县', '3', '0', '401', '甘肃', '酒泉', '阿克塞哈萨克族自治县', 'AKSHSKZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1856', '620981', '玉门', '3', '0', '401', '甘肃', '酒泉', '玉门', 'YM', null);
INSERT INTO `t_pub_city` VALUES ('1857', '621002', '西峰区', '3', '0', '303', '甘肃', '庆阳', '西峰区', 'XFQ', null);
INSERT INTO `t_pub_city` VALUES ('1858', '621022', '环县', '3', '0', '303', '甘肃', '庆阳', '环县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('1859', '621024', '合水县', '3', '0', '303', '甘肃', '庆阳', '合水县', 'GSX', null);
INSERT INTO `t_pub_city` VALUES ('1860', '621026', '宁县', '3', '0', '303', '甘肃', '庆阳', '宁县', 'NX', null);
INSERT INTO `t_pub_city` VALUES ('1861', '621027', '镇原县', '3', '0', '303', '甘肃', '庆阳', '镇原县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('1862', '621121', '通渭县', '3', '0', '402', '甘肃', '定西', '通渭县', 'TWX', null);
INSERT INTO `t_pub_city` VALUES ('1863', '621123', '渭源县', '3', '0', '402', '甘肃', '定西', '渭源县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('1864', '621125', '漳县', '3', '0', '402', '甘肃', '定西', '漳县', 'ZX', null);
INSERT INTO `t_pub_city` VALUES ('1865', '621202', '武都区', '3', '0', '304', '甘肃', '陇南', '武都区', 'WDQ', null);
INSERT INTO `t_pub_city` VALUES ('1866', '621222', '文县', '3', '0', '304', '甘肃', '陇南', '文县', 'WX', null);
INSERT INTO `t_pub_city` VALUES ('1867', '621224', '康县', '3', '0', '304', '甘肃', '陇南', '康县', 'KX', null);
INSERT INTO `t_pub_city` VALUES ('1868', '621226', '礼县', '3', '0', '304', '甘肃', '陇南', '礼县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('1869', '621228', '两当县', '3', '0', '304', '甘肃', '陇南', '两当县', 'LDX', null);
INSERT INTO `t_pub_city` VALUES ('1870', '622922', '康乐县', '3', '0', '305', '甘肃', '临夏回族自治州', '康乐县', 'KLX', null);
INSERT INTO `t_pub_city` VALUES ('1871', '622924', '广河县', '3', '0', '305', '甘肃', '临夏回族自治州', '广河县', 'AHX', null);
INSERT INTO `t_pub_city` VALUES ('1872', '622927', '积石山保安族东乡族撒拉族自治县', '3', '0', '305', '甘肃', '临夏回族自治州', '积石山保安族东乡族撒拉族自治县', 'JSSBAZSXZSLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1873', '623021', '临潭县', '3', '0', '403', '甘肃', '甘南藏族自治州', '临潭县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('1874', '623023', '舟曲县', '3', '0', '403', '甘肃', '甘南藏族自治州', '舟曲县', 'ZQX', null);
INSERT INTO `t_pub_city` VALUES ('1875', '623026', '碌曲县', '3', '0', '403', '甘肃', '甘南藏族自治州', '碌曲县', 'LQX', null);
INSERT INTO `t_pub_city` VALUES ('1876', '630102', '城东区', '3', '0', '404', '青海', '西宁', '城东区', 'CDQ', null);
INSERT INTO `t_pub_city` VALUES ('1877', '630104', '城西区', '3', '0', '404', '青海', '西宁', '城西区', 'CXQ', null);
INSERT INTO `t_pub_city` VALUES ('1878', '630121', '大通回族土族自治县', '3', '0', '404', '青海', '西宁', '大通回族土族自治县', 'DTHZTZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1879', '630122', '湟中县', '3', '0', '404', '青海', '西宁', '湟中县', 'HZX', null);
INSERT INTO `t_pub_city` VALUES ('1880', '630202', '乐都区', '3', '0', '306', '青海', '海东', '乐都区', 'LDQ', null);
INSERT INTO `t_pub_city` VALUES ('1881', '630222', '民和回族土族自治县', '3', '0', '306', '青海', '海东', '民和回族土族自治县', 'MHHZTZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1882', '630224', '化隆回族自治县', '3', '0', '306', '青海', '海东', '化隆回族自治县', 'HLHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1883', '632221', '门源回族自治县', '3', '0', '405', '青海', '海北藏族自治州', '门源回族自治县', 'MYHZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1884', '632223', '海晏县', '3', '0', '405', '青海', '海北藏族自治州', '海晏县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('1885', '632321', '同仁县', '3', '0', '307', '青海', '黄南藏族自治州', '同仁县', 'TRX', null);
INSERT INTO `t_pub_city` VALUES ('1886', '632324', '河南蒙古族自治县', '3', '0', '307', '青海', '黄南藏族自治州', '河南蒙古族自治县', 'HNMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1887', '632522', '同德县', '3', '0', '406', '青海', '海南藏族自治州', '同德县', 'TDX', null);
INSERT INTO `t_pub_city` VALUES ('1888', '632525', '贵南县', '3', '0', '406', '青海', '海南藏族自治州', '贵南县', 'GNX', null);
INSERT INTO `t_pub_city` VALUES ('1889', '632622', '班玛县', '3', '0', '308', '青海', '果洛藏族自治州', '班玛县', 'BMX', null);
INSERT INTO `t_pub_city` VALUES ('1890', '632625', '久治县', '3', '0', '308', '青海', '果洛藏族自治州', '久治县', 'JZX', null);
INSERT INTO `t_pub_city` VALUES ('1891', '632701', '玉树', '3', '0', '407', '青海', '玉树藏族自治州', '玉树', 'YS', null);
INSERT INTO `t_pub_city` VALUES ('1892', '632724', '治多县', '3', '0', '407', '青海', '玉树藏族自治州', '治多县', 'ZDX', null);
INSERT INTO `t_pub_city` VALUES ('1893', '632726', '曲麻莱县', '3', '0', '407', '青海', '玉树藏族自治州', '曲麻莱县', 'QMLX', null);
INSERT INTO `t_pub_city` VALUES ('1894', '632821', '乌兰县', '3', '0', '309', '青海', '海西蒙古族藏族自治州', '乌兰县', 'WLX', null);
INSERT INTO `t_pub_city` VALUES ('1895', '640104', '兴庆区', '3', '0', '408', '宁夏回族自治区', '银川', '兴庆区', 'XQQ', null);
INSERT INTO `t_pub_city` VALUES ('1896', '640105', '西夏区', '3', '0', '408', '宁夏回族自治区', '银川', '西夏区', 'XXQ', null);
INSERT INTO `t_pub_city` VALUES ('1897', '640121', '永宁县', '3', '0', '408', '宁夏回族自治区', '银川', '永宁县', 'YNX', null);
INSERT INTO `t_pub_city` VALUES ('1898', '640181', '灵武', '3', '0', '408', '宁夏回族自治区', '银川', '灵武', 'LW', null);
INSERT INTO `t_pub_city` VALUES ('1899', '640205', '惠农区', '3', '0', '310', '宁夏回族自治区', '石嘴山', '惠农区', 'HNQ', null);
INSERT INTO `t_pub_city` VALUES ('1900', '640302', '利通区', '3', '0', '409', '宁夏回族自治区', '吴忠', '利通区', 'LTQ', null);
INSERT INTO `t_pub_city` VALUES ('1901', '640303', '红寺堡区', '3', '0', '409', '宁夏回族自治区', '吴忠', '红寺堡区', 'GSBQ', null);
INSERT INTO `t_pub_city` VALUES ('1902', '640324', '同心县', '3', '0', '409', '宁夏回族自治区', '吴忠', '同心县', 'TXX', null);
INSERT INTO `t_pub_city` VALUES ('1903', '640402', '原州区', '3', '0', '311', '宁夏回族自治区', '固原', '原州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('1904', '640423', '隆德县', '3', '0', '311', '宁夏回族自治区', '固原', '隆德县', 'LDX', null);
INSERT INTO `t_pub_city` VALUES ('1905', '640425', '彭阳县', '3', '0', '311', '宁夏回族自治区', '固原', '彭阳县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('1906', '640521', '中宁县', '3', '0', '312', '宁夏回族自治区', '中卫', '中宁县', 'ZNX', null);
INSERT INTO `t_pub_city` VALUES ('1907', '650103', '沙依巴克区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '沙依巴克区', 'SYBKQ', null);
INSERT INTO `t_pub_city` VALUES ('1908', '650105', '水磨沟区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '水磨沟区', 'SMGQ', null);
INSERT INTO `t_pub_city` VALUES ('1909', '650109', '米东区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '米东区', 'MDQ', null);
INSERT INTO `t_pub_city` VALUES ('1910', '650202', '独山子区', '3', '0', '313', '新疆维吾尔自治区', '克拉玛依', '独山子区', 'DSZQ', null);
INSERT INTO `t_pub_city` VALUES ('1911', '650205', '乌尔禾区', '3', '0', '313', '新疆维吾尔自治区', '克拉玛依', '乌尔禾区', 'WEHQ', null);
INSERT INTO `t_pub_city` VALUES ('1912', '650421', '鄯善县', '3', '0', '314', '新疆维吾尔自治区', '吐鲁番', '鄯善县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('1913', '650500', '哈密', '3', '0', '314', '新疆维吾尔自治区', '吐鲁番', '哈密', 'HM', null);
INSERT INTO `t_pub_city` VALUES ('1914', '650521', '巴里坤哈萨克自治县', '3', '0', null, null, null, '巴里坤哈萨克自治县', 'BLKHSKZZX', null);
INSERT INTO `t_pub_city` VALUES ('1915', '652302', '阜康', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '阜康', 'FK', null);
INSERT INTO `t_pub_city` VALUES ('1916', '652325', '奇台县', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '奇台县', 'JTX', null);
INSERT INTO `t_pub_city` VALUES ('1917', '652328', '木垒哈萨克自治县', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '木垒哈萨克自治县', 'MLHSKZZX', null);
INSERT INTO `t_pub_city` VALUES ('1918', '130637', '博野县', '3', '0', '104', '河北', '保定', '博野县', 'BYX', null);
INSERT INTO `t_pub_city` VALUES ('1919', '130681', '涿州', '3', '0', '104', '河北', '保定', '涿州', 'ZZ', null);
INSERT INTO `t_pub_city` VALUES ('1920', '130683', '安国', '3', '0', '104', '河北', '保定', '安国', 'AG', null);
INSERT INTO `t_pub_city` VALUES ('1921', '130702', '桥东区', '3', '0', '195', '河北', '张家口', '桥东区', 'QDQ', null);
INSERT INTO `t_pub_city` VALUES ('1922', '130705', '宣化区', '3', '0', '195', '河北', '张家口', '宣化区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('1923', '130708', '万全区', '3', '0', '195', '河北', '张家口', '万全区', 'WQQ', null);
INSERT INTO `t_pub_city` VALUES ('1924', '130721', '宣化县', '3', '0', '195', '河北', '张家口', '宣化县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('1925', '130723', '康保县', '3', '0', '195', '河北', '张家口', '康保县', 'KBX', null);
INSERT INTO `t_pub_city` VALUES ('1926', '130724', '沽源县', '3', '0', '195', '河北', '张家口', '沽源县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('1927', '130726', '蔚县', '3', '0', '195', '河北', '张家口', '蔚县', 'WX', null);
INSERT INTO `t_pub_city` VALUES ('1928', '130728', '怀安县', '3', '0', '195', '河北', '张家口', '怀安县', 'HAX', null);
INSERT INTO `t_pub_city` VALUES ('1929', '130731', '涿鹿县', '3', '0', '195', '河北', '张家口', '涿鹿县', 'ZLX', null);
INSERT INTO `t_pub_city` VALUES ('1930', '130802', '双桥区', '3', '0', '105', '河北', '承德', '双桥区', 'SQQ', null);
INSERT INTO `t_pub_city` VALUES ('1931', '130804', '鹰手营子矿区', '3', '0', '105', '河北', '承德', '鹰手营子矿区', 'YSYZKQ', null);
INSERT INTO `t_pub_city` VALUES ('1932', '130823', '平泉县', '3', '0', '105', '河北', '承德', '平泉县', 'PQX', null);
INSERT INTO `t_pub_city` VALUES ('1933', '130825', '隆化县', '3', '0', '105', '河北', '承德', '隆化县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('1934', '130827', '宽城满族自治县', '3', '0', '105', '河北', '承德', '宽城满族自治县', 'KCMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('1935', '130903', '运河区', '3', '0', '196', '河北', '沧州', '运河区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('1936', '130922', '青县', '3', '0', '196', '河北', '沧州', '青县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('1937', '130924', '海兴县', '3', '0', '196', '河北', '沧州', '海兴县', 'HXX', null);
INSERT INTO `t_pub_city` VALUES ('1938', '130926', '肃宁县', '3', '0', '196', '河北', '沧州', '肃宁县', 'SNX', null);
INSERT INTO `t_pub_city` VALUES ('1939', '130928', '吴桥县', '3', '0', '196', '河北', '沧州', '吴桥县', 'WQX', null);
INSERT INTO `t_pub_city` VALUES ('1940', '130981', '泊头', '3', '0', '196', '河北', '沧州', '泊头', 'BT', null);
INSERT INTO `t_pub_city` VALUES ('1941', '130983', '黄骅', '3', '0', '196', '河北', '沧州', '黄骅', 'HH', null);
INSERT INTO `t_pub_city` VALUES ('1942', '131002', '安次区', '3', '0', '106', '河北', '廊坊', '安次区', 'ACQ', null);
INSERT INTO `t_pub_city` VALUES ('1943', '131022', '固安县', '3', '0', '106', '河北', '廊坊', '固安县', 'GAX', null);
INSERT INTO `t_pub_city` VALUES ('1944', '131024', '香河县', '3', '0', '106', '河北', '廊坊', '香河县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('1945', '131026', '文安县', '3', '0', '106', '河北', '廊坊', '文安县', 'WAX', null);
INSERT INTO `t_pub_city` VALUES ('1946', '131081', '霸州', '3', '0', '106', '河北', '廊坊', '霸州', 'BZ', null);
INSERT INTO `t_pub_city` VALUES ('1947', '131102', '桃城区', '3', '0', '197', '河北', '衡水', '桃城区', 'TCQ', null);
INSERT INTO `t_pub_city` VALUES ('1948', '131121', '枣强县', '3', '0', '197', '河北', '衡水', '枣强县', 'ZJX', null);
INSERT INTO `t_pub_city` VALUES ('1949', '131123', '武强县', '3', '0', '197', '河北', '衡水', '武强县', 'WJX', null);
INSERT INTO `t_pub_city` VALUES ('1950', '131125', '安平县', '3', '0', '197', '河北', '衡水', '安平县', 'APX', null);
INSERT INTO `t_pub_city` VALUES ('1951', '131128', '阜城县', '3', '0', '197', '河北', '衡水', '阜城县', 'FCX', null);
INSERT INTO `t_pub_city` VALUES ('1952', '140105', '小店区', '3', '0', '107', '山西', '太原', '小店区', 'XDQ', null);
INSERT INTO `t_pub_city` VALUES ('1953', '140107', '杏花岭区', '3', '0', '107', '山西', '太原', '杏花岭区', 'XHLQ', null);
INSERT INTO `t_pub_city` VALUES ('1954', '140109', '万柏林区', '3', '0', '107', '山西', '太原', '万柏林区', 'WBLQ', null);
INSERT INTO `t_pub_city` VALUES ('1955', '140121', '清徐县', '3', '0', '107', '山西', '太原', '清徐县', 'QXX', null);
INSERT INTO `t_pub_city` VALUES ('1956', '140123', '娄烦县', '3', '0', '107', '山西', '太原', '娄烦县', 'LFX', null);
INSERT INTO `t_pub_city` VALUES ('1957', '140202', '城区', '3', '0', '198', '山西', '大同', '城区', 'CQ', null);
INSERT INTO `t_pub_city` VALUES ('1958', '140211', '南郊区', '3', '0', '198', '山西', '大同', '南郊区', 'NJQ', null);
INSERT INTO `t_pub_city` VALUES ('1959', '140221', '阳高县', '3', '0', '198', '山西', '大同', '阳高县', 'YGX', null);
INSERT INTO `t_pub_city` VALUES ('1960', '140223', '广灵县', '3', '0', '198', '山西', '大同', '广灵县', 'ALX', null);
INSERT INTO `t_pub_city` VALUES ('1961', '140225', '浑源县', '3', '0', '198', '山西', '大同', '浑源县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('1962', '140227', '大同县', '3', '0', '198', '山西', '大同', '大同县', 'DTX', null);
INSERT INTO `t_pub_city` VALUES ('1963', '140311', '郊区', '3', '0', '199', '山西', '阳泉', '郊区', 'JQ', null);
INSERT INTO `t_pub_city` VALUES ('1964', '140321', '平定县', '3', '0', '199', '山西', '阳泉', '平定县', 'PDX', null);
INSERT INTO `t_pub_city` VALUES ('1965', '140411', '郊区', '3', '0', '108', '山西', '长治', '郊区', 'JQ', null);
INSERT INTO `t_pub_city` VALUES ('1966', '140421', '长治县', '3', '0', '108', '山西', '长治', '长治县', 'CZX', null);
INSERT INTO `t_pub_city` VALUES ('1967', '140425', '平顺县', '3', '0', '108', '山西', '长治', '平顺县', 'PSX', null);
INSERT INTO `t_pub_city` VALUES ('1968', '140427', '壶关县', '3', '0', '108', '山西', '长治', '壶关县', 'HGX', null);
INSERT INTO `t_pub_city` VALUES ('1969', '140429', '武乡县', '3', '0', '108', '山西', '长治', '武乡县', 'WXX', null);
INSERT INTO `t_pub_city` VALUES ('1970', '140431', '沁源县', '3', '0', '108', '山西', '长治', '沁源县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('1971', '140502', '城区', '3', '0', '200', '山西', '晋城', '城区', 'CQ', null);
INSERT INTO `t_pub_city` VALUES ('1972', '140522', '阳城县', '3', '0', '200', '山西', '晋城', '阳城县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('1973', '140525', '泽州县', '3', '0', '200', '山西', '晋城', '泽州县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('1974', '140602', '朔城区', '3', '0', '109', '山西', '朔州', '朔城区', 'SCQ', null);
INSERT INTO `t_pub_city` VALUES ('1975', '140621', '山阴县', '3', '0', '109', '山西', '朔州', '山阴县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('1976', '140623', '右玉县', '3', '0', '109', '山西', '朔州', '右玉县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('1977', '140702', '榆次区', '3', '0', '201', '山西', '晋中', '榆次区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('1978', '140722', '左权县', '3', '0', '201', '山西', '晋中', '左权县', 'ZQX', null);
INSERT INTO `t_pub_city` VALUES ('1979', '140724', '昔阳县', '3', '0', '201', '山西', '晋中', '昔阳县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('1980', '140727', '祁县', '3', '0', '201', '山西', '晋中', '祁县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('1981', '140729', '灵石县', '3', '0', '201', '山西', '晋中', '灵石县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('1982', '140821', '临猗县', '3', '0', '110', '山西', '运城', '临猗县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('1983', '140823', '闻喜县', '3', '0', '110', '山西', '运城', '闻喜县', 'WXX', null);
INSERT INTO `t_pub_city` VALUES ('1984', '140826', '绛县', '3', '0', '110', '山西', '运城', '绛县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('1985', '140828', '夏县', '3', '0', '110', '山西', '运城', '夏县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('1986', '140881', '永济', '3', '0', '110', '山西', '运城', '永济', 'YJ', null);
INSERT INTO `t_pub_city` VALUES ('1987', '140902', '忻府区', '3', '0', '202', '山西', '忻州', '忻府区', 'XFQ', null);
INSERT INTO `t_pub_city` VALUES ('1988', '140923', '代县', '3', '0', '202', '山西', '忻州', '代县', 'DX', null);
INSERT INTO `t_pub_city` VALUES ('1989', '140925', '宁武县', '3', '0', '202', '山西', '忻州', '宁武县', 'NWX', null);
INSERT INTO `t_pub_city` VALUES ('1990', '140928', '五寨县', '3', '0', '202', '山西', '忻州', '五寨县', 'WZX', null);
INSERT INTO `t_pub_city` VALUES ('1991', '140931', '保德县', '3', '0', '202', '山西', '忻州', '保德县', 'BDX', null);
INSERT INTO `t_pub_city` VALUES ('1992', '141002', '尧都区', '3', '0', '111', '山西', '临汾', '尧都区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('1993', '141021', '曲沃县', '3', '0', '111', '山西', '临汾', '曲沃县', 'QWX', null);
INSERT INTO `t_pub_city` VALUES ('1994', '141023', '襄汾县', '3', '0', '111', '山西', '临汾', '襄汾县', 'XFX', null);
INSERT INTO `t_pub_city` VALUES ('1995', '141025', '古县', '3', '0', '111', '山西', '临汾', '古县', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('1996', '141027', '浮山县', '3', '0', '111', '山西', '临汾', '浮山县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('1997', '141029', '乡宁县', '3', '0', '111', '山西', '临汾', '乡宁县', 'XNX', null);
INSERT INTO `t_pub_city` VALUES ('1998', '141031', '隰县', '3', '0', '111', '山西', '临汾', '隰县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('1999', '141033', '蒲县', '3', '0', '111', '山西', '临汾', '蒲县', 'PX', null);
INSERT INTO `t_pub_city` VALUES ('2000', '141081', '侯马', '3', '0', '111', '山西', '临汾', '侯马', 'HM', null);
INSERT INTO `t_pub_city` VALUES ('2001', '141102', '离石区', '3', '0', '203', '山西', '吕梁', '离石区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2002', '141122', '交城县', '3', '0', '203', '山西', '吕梁', '交城县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('2003', '141124', '临县', '3', '0', '203', '山西', '吕梁', '临县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('2004', '141126', '石楼县', '3', '0', '203', '山西', '吕梁', '石楼县', 'SLX', null);
INSERT INTO `t_pub_city` VALUES ('2005', '141128', '方山县', '3', '0', '203', '山西', '吕梁', '方山县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('2006', '141130', '交口县', '3', '0', '203', '山西', '吕梁', '交口县', 'JKX', null);
INSERT INTO `t_pub_city` VALUES ('2007', '141182', '汾阳', '3', '0', '203', '山西', '吕梁', '汾阳', 'FY', null);
INSERT INTO `t_pub_city` VALUES ('2008', '150103', '回民区', '3', '0', '204', '内蒙古自治区', '呼和浩特', '回民区', 'HMQ', null);
INSERT INTO `t_pub_city` VALUES ('2009', '150105', '赛罕区', '3', '0', '204', '内蒙古自治区', '呼和浩特', '赛罕区', 'SHQ', null);
INSERT INTO `t_pub_city` VALUES ('2010', '150122', '托克托县', '3', '0', '204', '内蒙古自治区', '呼和浩特', '托克托县', 'TKTX', null);
INSERT INTO `t_pub_city` VALUES ('2011', '150124', '清水河县', '3', '0', '204', '内蒙古自治区', '呼和浩特', '清水河县', 'QSHX', null);
INSERT INTO `t_pub_city` VALUES ('2012', '150202', '东河区', '3', '0', '112', '内蒙古自治区', '包头', '东河区', 'DHQ', null);
INSERT INTO `t_pub_city` VALUES ('2013', '150204', '青山区', '3', '0', '112', '内蒙古自治区', '包头', '青山区', 'QSQ', null);
INSERT INTO `t_pub_city` VALUES ('2014', '150206', '白云鄂博矿区', '3', '0', '112', '内蒙古自治区', '包头', '白云鄂博矿区', 'BYEBKQ', null);
INSERT INTO `t_pub_city` VALUES ('2015', '150221', '土默特右旗', '3', '0', '112', '内蒙古自治区', '包头', '土默特右旗', 'TMTYQ', null);
INSERT INTO `t_pub_city` VALUES ('2016', '150302', '海勃湾区', '3', '0', '205', '内蒙古自治区', '乌海', '海勃湾区', 'HBWQ', null);
INSERT INTO `t_pub_city` VALUES ('2017', '150304', '乌达区', '3', '0', '205', '内蒙古自治区', '乌海', '乌达区', 'WDQ', null);
INSERT INTO `t_pub_city` VALUES ('2018', '150403', '元宝山区', '3', '0', '206', '内蒙古自治区', '赤峰', '元宝山区', 'YBSQ', null);
INSERT INTO `t_pub_city` VALUES ('2019', '150421', '阿鲁科尔沁旗', '3', '0', '206', '内蒙古自治区', '赤峰', '阿鲁科尔沁旗', 'ALKEQQ', null);
INSERT INTO `t_pub_city` VALUES ('2020', '150424', '林西县', '3', '0', '206', '内蒙古自治区', '赤峰', '林西县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('2021', '150426', '翁牛特旗', '3', '0', '206', '内蒙古自治区', '赤峰', '翁牛特旗', 'WNTQ', null);
INSERT INTO `t_pub_city` VALUES ('2022', '653127', '麦盖提县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '麦盖提县', 'MGDX', null);
INSERT INTO `t_pub_city` VALUES ('2023', '653129', '伽师县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '伽师县', 'GSX', null);
INSERT INTO `t_pub_city` VALUES ('2024', '653131', '塔什库尔干塔吉克自治县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '塔什库尔干塔吉克自治县', 'DSKEGDJKZZX', null);
INSERT INTO `t_pub_city` VALUES ('2025', '653222', '墨玉县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '墨玉县', 'MYX', null);
INSERT INTO `t_pub_city` VALUES ('2026', '653224', '洛浦县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '洛浦县', 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('2027', '653226', '于田县', '3', '0', '131', '新疆维吾尔自治区', '和田地区', '于田县', 'YTX', null);
INSERT INTO `t_pub_city` VALUES ('2028', '654002', '伊宁', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '伊宁', 'YN', null);
INSERT INTO `t_pub_city` VALUES ('2029', '654003', '奎屯', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '奎屯', 'KT', null);
INSERT INTO `t_pub_city` VALUES ('2030', '654021', '伊宁县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '伊宁县', 'YNX', null);
INSERT INTO `t_pub_city` VALUES ('2031', '654022', '察布查尔锡伯自治县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '察布查尔锡伯自治县', 'CBCEXBZZX', null);
INSERT INTO `t_pub_city` VALUES ('2032', '654025', '新源县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '新源县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('2033', '654026', '昭苏县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '昭苏县', 'ZSX', null);
INSERT INTO `t_pub_city` VALUES ('2034', '654028', '尼勒克县', '3', '0', '132', '新疆维吾尔自治区', '伊犁哈萨克自治州', '尼勒克县', 'NLKX', null);
INSERT INTO `t_pub_city` VALUES ('2035', '654202', '乌苏', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '乌苏', 'WS', null);
INSERT INTO `t_pub_city` VALUES ('2036', '654223', '沙湾县', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '沙湾县', 'SWX', null);
INSERT INTO `t_pub_city` VALUES ('2037', '654225', '裕民县', '3', '0', '133', '新疆维吾尔自治区', '塔城地区', '裕民县', 'YMX', null);
INSERT INTO `t_pub_city` VALUES ('2038', '654301', '阿勒泰', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '阿勒泰', 'ALT', null);
INSERT INTO `t_pub_city` VALUES ('2039', '654322', '富蕴县', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '富蕴县', 'FWX', null);
INSERT INTO `t_pub_city` VALUES ('2040', '654324', '哈巴河县', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '哈巴河县', 'HBHX', null);
INSERT INTO `t_pub_city` VALUES ('2041', '654326', '吉木乃县', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '吉木乃县', 'JMNX', null);
INSERT INTO `t_pub_city` VALUES ('2042', '321181', '丹阳', '3', '0', '149', '江苏', '镇江', '丹阳', 'DY', null);
INSERT INTO `t_pub_city` VALUES ('2043', '330103', '下城区', '3', '0', '56', '浙江', '杭州', '下城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('2044', '350627', '南靖县', '3', '0', '169', '福建', '漳州', '南靖县', 'NJX', null);
INSERT INTO `t_pub_city` VALUES ('2045', '350803', '永定区', '3', '0', '170', '福建', '龙岩', '永定区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('2046', '360102', '东湖区', '3', '0', '171', '江西', '南昌', '东湖区', 'DHQ', null);
INSERT INTO `t_pub_city` VALUES ('2047', '360321', '莲花县', '3', '0', '172', '江西', '萍乡', '莲花县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('2048', '410404', '石龙区', '3', '0', '189', '河南', '平顶山', '石龙区', 'SLQ', null);
INSERT INTO `t_pub_city` VALUES ('2049', '410503', '北关区', '3', '0', '85', '河南', '安阳', '北关区', 'BGQ', null);
INSERT INTO `t_pub_city` VALUES ('2050', '410703', '卫滨区', '3', '0', '191', '河南', '新乡', '卫滨区', 'WBQ', null);
INSERT INTO `t_pub_city` VALUES ('2051', '140781', '介休', '3', '0', '201', '山西', '晋中', '介休', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('2052', '140922', '五台县', '3', '0', '202', '山西', '忻州', '五台县', 'WTX', null);
INSERT INTO `t_pub_city` VALUES ('2053', '220202', '昌邑区', '3', '0', '219', '吉林', '吉林', '昌邑区', 'CYQ', null);
INSERT INTO `t_pub_city` VALUES ('2054', '220402', '龙山区', '3', '0', '124', '吉林', '辽源', '龙山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2055', '430603', '云溪区', '3', '0', '238', '湖南', '岳阳', '云溪区', 'YXQ', null);
INSERT INTO `t_pub_city` VALUES ('2056', '430726', '石门县', '3', '0', '328', '湖南', '常德', '石门县', 'SMX', null);
INSERT INTO `t_pub_city` VALUES ('2057', '431022', '宜章县', '3', '0', '240', '湖南', '郴州', '宜章县', 'YZX', null);
INSERT INTO `t_pub_city` VALUES ('2058', '451121', '昭平县', '3', '0', '345', '广西壮族自治区', '贺州', '昭平县', 'ZPX', null);
INSERT INTO `t_pub_city` VALUES ('2059', '451323', '武宣县', '3', '0', '262', '广西壮族自治区', '来宾', '武宣县', 'WXX', null);
INSERT INTO `t_pub_city` VALUES ('2060', '460203', '吉阳区', '3', '0', '264', '海南', '三亚', '吉阳区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('2061', '520327', '凤冈县', '3', '0', '278', '贵州', '遵义', '凤冈县', 'FGX', null);
INSERT INTO `t_pub_city` VALUES ('2062', '610102', '新城区', '3', '0', '393', '陕西', '西安', '新城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('2063', '610204', '耀州区', '3', '0', '293', '陕西', '铜川', '耀州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('2064', '650204', '白碱滩区', '3', '0', '313', '新疆维吾尔自治区', '克拉玛依', '白碱滩区', 'BJTQ', null);
INSERT INTO `t_pub_city` VALUES ('2065', '652323', '呼图壁县', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '呼图壁县', 'HTBX', null);
INSERT INTO `t_pub_city` VALUES ('2066', '130430', '邱县', '3', '0', '103', '河北', '邯郸', '邱县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('2067', '532530', '金平苗族瑶族傣族自治县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '金平苗族瑶族傣族自治县', 'JPMZYZDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2068', '410728', '长垣县', '3', '0', '191', '河南', '新乡', '长垣县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('2069', '410782', '辉县', '3', '0', '191', '河南', '新乡', '辉县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('2070', '410803', '中站区', '3', '0', '222', '河南', '焦作', '中站区', 'ZZQ', null);
INSERT INTO `t_pub_city` VALUES ('2071', '410811', '山阳区', '3', '0', '222', '河南', '焦作', '山阳区', 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('2072', '410822', '博爱县', '3', '0', '222', '河南', '焦作', '博爱县', 'BAX', null);
INSERT INTO `t_pub_city` VALUES ('2073', '410825', '温县', '3', '0', '222', '河南', '焦作', '温县', 'WX', null);
INSERT INTO `t_pub_city` VALUES ('2074', '410883', '孟州', '3', '0', '222', '河南', '焦作', '孟州', 'MZ', null);
INSERT INTO `t_pub_city` VALUES ('2075', '410922', '清丰县', '3', '0', '316', '河南', '濮阳', '清丰县', 'QFX', null);
INSERT INTO `t_pub_city` VALUES ('2076', '410926', '范县', '3', '0', '316', '河南', '濮阳', '范县', 'FX', null);
INSERT INTO `t_pub_city` VALUES ('2077', '410928', '濮阳县', '3', '0', '316', '河南', '濮阳', '濮阳县', 'PYX', null);
INSERT INTO `t_pub_city` VALUES ('2078', '411023', '许昌县', '3', '0', '223', '河南', '许昌', '许昌县', 'HCX', null);
INSERT INTO `t_pub_city` VALUES ('2079', '411025', '襄城县', '3', '0', '223', '河南', '许昌', '襄城县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('2080', '411102', '源汇区', '3', '0', '224', '河南', '漯河', '源汇区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('2081', '411104', '召陵区', '3', '0', '224', '河南', '漯河', '召陵区', 'SLQ', null);
INSERT INTO `t_pub_city` VALUES ('2082', '411122', '临颍县', '3', '0', '224', '河南', '漯河', '临颍县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('2083', '411203', '陕州区', '3', '0', '317', '河南', '三门峡', '陕州区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('2084', '411224', '卢氏县', '3', '0', '317', '河南', '三门峡', '卢氏县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2085', '411281', '义马', '3', '0', '317', '河南', '三门峡', '义马', 'YM', null);
INSERT INTO `t_pub_city` VALUES ('2086', '411303', '卧龙区', '3', '0', '225', '河南', '南阳', '卧龙区', 'WLQ', null);
INSERT INTO `t_pub_city` VALUES ('2087', '411322', '方城县', '3', '0', '225', '河南', '南阳', '方城县', 'FCX', null);
INSERT INTO `t_pub_city` VALUES ('2088', '411324', '镇平县', '3', '0', '225', '河南', '南阳', '镇平县', 'ZPX', null);
INSERT INTO `t_pub_city` VALUES ('2089', '411326', '淅川县', '3', '0', '225', '河南', '南阳', '淅川县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('2090', '411328', '唐河县', '3', '0', '225', '河南', '南阳', '唐河县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('2091', '411330', '桐柏县', '3', '0', '225', '河南', '南阳', '桐柏县', 'TBX', null);
INSERT INTO `t_pub_city` VALUES ('2092', '411402', '梁园区', '3', '0', '318', '河南', '商丘', '梁园区', 'LYQ', null);
INSERT INTO `t_pub_city` VALUES ('2093', '411421', '民权县', '3', '0', '318', '河南', '商丘', '民权县', 'MQX', null);
INSERT INTO `t_pub_city` VALUES ('2094', '411423', '宁陵县', '3', '0', '318', '河南', '商丘', '宁陵县', 'NLX', null);
INSERT INTO `t_pub_city` VALUES ('2095', '411425', '虞城县', '3', '0', '318', '河南', '商丘', '虞城县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2096', '411481', '永城', '3', '0', '318', '河南', '商丘', '永城', 'YC', null);
INSERT INTO `t_pub_city` VALUES ('2097', '411503', '平桥区', '3', '0', '226', '河南', '信阳', '平桥区', 'PQQ', null);
INSERT INTO `t_pub_city` VALUES ('2098', '411522', '光山县', '3', '0', '226', '河南', '信阳', '光山县', 'GSX', null);
INSERT INTO `t_pub_city` VALUES ('2099', '411524', '商城县', '3', '0', '226', '河南', '信阳', '商城县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('2100', '411527', '淮滨县', '3', '0', '226', '河南', '信阳', '淮滨县', 'HBX', null);
INSERT INTO `t_pub_city` VALUES ('2101', '411602', '川汇区', '3', '0', '319', '河南', '周口', '川汇区', 'CHQ', null);
INSERT INTO `t_pub_city` VALUES ('2102', '411622', '西华县', '3', '0', '319', '河南', '周口', '西华县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2103', '411624', '沈丘县', '3', '0', '319', '河南', '周口', '沈丘县', 'SQX', null);
INSERT INTO `t_pub_city` VALUES ('2104', '411626', '淮阳县', '3', '0', '319', '河南', '周口', '淮阳县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('2105', '411628', '鹿邑县', '3', '0', '319', '河南', '周口', '鹿邑县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('2106', '411702', '驿城区', '3', '0', '227', '河南', '驻马店', '驿城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('2107', '411722', '上蔡县', '3', '0', '227', '河南', '驻马店', '上蔡县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('2108', '411724', '正阳县', '3', '0', '227', '河南', '驻马店', '正阳县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('2109', '411726', '泌阳县', '3', '0', '227', '河南', '驻马店', '泌阳县', 'BYX', null);
INSERT INTO `t_pub_city` VALUES ('2110', '411728', '遂平县', '3', '0', '227', '河南', '驻马店', '遂平县', 'SPX', null);
INSERT INTO `t_pub_city` VALUES ('2111', '420102', '江岸区', '3', '0', '320', '湖北', '武汉', '江岸区', 'JAQ', null);
INSERT INTO `t_pub_city` VALUES ('2112', '420104', '硚口区', '3', '0', '320', '湖北', '武汉', '硚口区', 'QKQ', null);
INSERT INTO `t_pub_city` VALUES ('2113', '420106', '武昌区', '3', '0', '320', '湖北', '武汉', '武昌区', 'WCQ', null);
INSERT INTO `t_pub_city` VALUES ('2114', '420111', '洪山区', '3', '0', '320', '湖北', '武汉', '洪山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('2115', '420113', '汉南区', '3', '0', '320', '湖北', '武汉', '汉南区', 'HNQ', null);
INSERT INTO `t_pub_city` VALUES ('2116', '420115', '江夏区', '3', '0', '320', '湖北', '武汉', '江夏区', 'JXQ', null);
INSERT INTO `t_pub_city` VALUES ('2117', '420117', '新洲区', '3', '0', '320', '湖北', '武汉', '新洲区', 'XZQ', null);
INSERT INTO `t_pub_city` VALUES ('2118', '420203', '西塞山区', '3', '0', '228', '湖北', '黄石', '西塞山区', 'XSSQ', null);
INSERT INTO `t_pub_city` VALUES ('2119', '420205', '铁山区', '3', '0', '228', '湖北', '黄石', '铁山区', 'TSQ', null);
INSERT INTO `t_pub_city` VALUES ('2120', '420281', '大冶', '3', '0', '228', '湖北', '黄石', '大冶', 'DY', null);
INSERT INTO `t_pub_city` VALUES ('2121', '150429', '宁城县', '3', '0', '206', '内蒙古自治区', '赤峰', '宁城县', 'NCX', null);
INSERT INTO `t_pub_city` VALUES ('2122', '150502', '科尔沁区', '3', '0', '113', '内蒙古自治区', '通辽', '科尔沁区', 'KEQQ', null);
INSERT INTO `t_pub_city` VALUES ('2123', '150522', '科尔沁左翼后旗', '3', '0', '113', '内蒙古自治区', '通辽', '科尔沁左翼后旗', 'KEQZYHQ', null);
INSERT INTO `t_pub_city` VALUES ('2124', '150525', '奈曼旗', '3', '0', '113', '内蒙古自治区', '通辽', '奈曼旗', 'NMQ', null);
INSERT INTO `t_pub_city` VALUES ('2125', '150581', '霍林郭勒', '3', '0', '113', '内蒙古自治区', '通辽', '霍林郭勒', 'HLGL', null);
INSERT INTO `t_pub_city` VALUES ('2126', '150621', '达拉特旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '达拉特旗', 'DLTQ', null);
INSERT INTO `t_pub_city` VALUES ('2127', '150623', '鄂托克前旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '鄂托克前旗', 'ETKQQ', null);
INSERT INTO `t_pub_city` VALUES ('2128', '150625', '杭锦旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '杭锦旗', 'HJQ', null);
INSERT INTO `t_pub_city` VALUES ('2129', '150627', '伊金霍洛旗', '3', '0', '207', '内蒙古自治区', '鄂尔多斯', '伊金霍洛旗', 'YJHLQ', null);
INSERT INTO `t_pub_city` VALUES ('2130', '150703', '扎赉诺尔区', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '扎赉诺尔区', 'ZLNEQ', null);
INSERT INTO `t_pub_city` VALUES ('2131', '150722', '莫力达瓦达斡尔族自治旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '莫力达瓦达斡尔族自治旗', 'MLDWDWEZZZQ', null);
INSERT INTO `t_pub_city` VALUES ('2132', '150724', '鄂温克族自治旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '鄂温克族自治旗', 'EWKZZZQ', null);
INSERT INTO `t_pub_city` VALUES ('2133', '150727', '新巴尔虎右旗', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '新巴尔虎右旗', 'XBEHYQ', null);
INSERT INTO `t_pub_city` VALUES ('2134', '150782', '牙克石', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '牙克石', 'YKS', null);
INSERT INTO `t_pub_city` VALUES ('2135', '150784', '额尔古纳', '3', '0', '114', '内蒙古自治区', '呼伦贝尔', '额尔古纳', 'EEGN', null);
INSERT INTO `t_pub_city` VALUES ('2136', '150802', '临河区', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '临河区', 'LHQ', null);
INSERT INTO `t_pub_city` VALUES ('2137', '150822', '磴口县', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '磴口县', 'DKX', null);
INSERT INTO `t_pub_city` VALUES ('2138', '150824', '乌拉特中旗', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '乌拉特中旗', 'WLTZQ', null);
INSERT INTO `t_pub_city` VALUES ('2139', '150826', '杭锦后旗', '3', '0', '208', '内蒙古自治区', '巴彦淖尔', '杭锦后旗', 'HJHQ', null);
INSERT INTO `t_pub_city` VALUES ('2140', '150921', '卓资县', '3', '0', '209', '内蒙古自治区', '乌兰察布', '卓资县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('2141', '150922', '化德县', '3', '0', '209', '内蒙古自治区', '乌兰察布', '化德县', 'HDX', null);
INSERT INTO `t_pub_city` VALUES ('2142', '150924', '兴和县', '3', '0', '209', '内蒙古自治区', '乌兰察布', '兴和县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2143', '150926', '察哈尔右翼前旗', '3', '0', '209', '内蒙古自治区', '乌兰察布', '察哈尔右翼前旗', 'CHEYYQQ', null);
INSERT INTO `t_pub_city` VALUES ('2144', '150928', '察哈尔右翼后旗', '3', '0', '209', '内蒙古自治区', '乌兰察布', '察哈尔右翼后旗', 'CHEYYHQ', null);
INSERT INTO `t_pub_city` VALUES ('2145', '152201', '乌兰浩特', '3', '0', '115', '内蒙古自治区', '兴安盟', '乌兰浩特', 'WLHT', null);
INSERT INTO `t_pub_city` VALUES ('2146', '152221', '科尔沁右翼前旗', '3', '0', '115', '内蒙古自治区', '兴安盟', '科尔沁右翼前旗', 'KEQYYQQ', null);
INSERT INTO `t_pub_city` VALUES ('2147', '152224', '突泉县', '3', '0', '115', '内蒙古自治区', '兴安盟', '突泉县', 'TQX', null);
INSERT INTO `t_pub_city` VALUES ('2148', '152501', '二连浩特', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '二连浩特', 'ELHT', null);
INSERT INTO `t_pub_city` VALUES ('2149', '152523', '苏尼特左旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '苏尼特左旗', 'SNTZQ', null);
INSERT INTO `t_pub_city` VALUES ('2150', '152525', '东乌珠穆沁旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '东乌珠穆沁旗', 'DWZMQQ', null);
INSERT INTO `t_pub_city` VALUES ('2151', '152527', '太仆寺旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '太仆寺旗', 'TPSQ', null);
INSERT INTO `t_pub_city` VALUES ('2152', '152529', '正镶白旗', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '正镶白旗', 'ZRBQ', null);
INSERT INTO `t_pub_city` VALUES ('2153', '152531', '多伦县', '3', '0', '210', '内蒙古自治区', '锡林郭勒盟', '多伦县', 'DLX', null);
INSERT INTO `t_pub_city` VALUES ('2154', '152922', '阿拉善右旗', '3', '0', '116', '内蒙古自治区', '阿拉善盟', '阿拉善右旗', 'ALSYQ', null);
INSERT INTO `t_pub_city` VALUES ('2155', '210102', '和平区', '3', '0', '211', '辽宁', '沈阳', '和平区', 'HPQ', null);
INSERT INTO `t_pub_city` VALUES ('2156', '210104', '大东区', '3', '0', '211', '辽宁', '沈阳', '大东区', 'DDQ', null);
INSERT INTO `t_pub_city` VALUES ('2157', '210106', '铁西区', '3', '0', '211', '辽宁', '沈阳', '铁西区', 'TXQ', null);
INSERT INTO `t_pub_city` VALUES ('2158', '210112', '东陵区', '3', '0', '211', '辽宁', '沈阳', '东陵区', 'DLQ', null);
INSERT INTO `t_pub_city` VALUES ('2159', '210114', '于洪区', '3', '0', '211', '辽宁', '沈阳', '于洪区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('2160', '210123', '康平县', '3', '0', '211', '辽宁', '沈阳', '康平县', 'KPX', null);
INSERT INTO `t_pub_city` VALUES ('2161', '210181', '新民', '3', '0', '211', '辽宁', '沈阳', '新民', 'XM', null);
INSERT INTO `t_pub_city` VALUES ('2162', '210203', '西岗区', '3', '0', '117', '辽宁', '大连', '西岗区', 'XGQ', null);
INSERT INTO `t_pub_city` VALUES ('2163', '210211', '甘井子区', '3', '0', '117', '辽宁', '大连', '甘井子区', 'GJZQ', null);
INSERT INTO `t_pub_city` VALUES ('2164', '210224', '长海县', '3', '0', '117', '辽宁', '大连', '长海县', 'CHX', null);
INSERT INTO `t_pub_city` VALUES ('2165', '210214', '普兰店区', '3', '0', '117', '辽宁', '大连', '普兰店区', 'PLDQ', null);
INSERT INTO `t_pub_city` VALUES ('2166', '210302', '铁东区', '3', '0', '212', '辽宁', '鞍山', '铁东区', 'TDQ', null);
INSERT INTO `t_pub_city` VALUES ('2167', '210304', '立山区', '3', '0', '212', '辽宁', '鞍山', '立山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2168', '210321', '台安县', '3', '0', '212', '辽宁', '鞍山', '台安县', 'TAX', null);
INSERT INTO `t_pub_city` VALUES ('2169', '210381', '海城', '3', '0', '212', '辽宁', '鞍山', '海城', 'HC', null);
INSERT INTO `t_pub_city` VALUES ('2170', '210403', '东洲区', '3', '0', '118', '辽宁', '抚顺', '东洲区', 'DZQ', null);
INSERT INTO `t_pub_city` VALUES ('2171', '210411', '顺城区', '3', '0', '118', '辽宁', '抚顺', '顺城区', 'SCQ', null);
INSERT INTO `t_pub_city` VALUES ('2172', '210422', '新宾满族自治县', '3', '0', '118', '辽宁', '抚顺', '新宾满族自治县', 'XBMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2173', '210503', '溪湖区', '3', '0', '213', '辽宁', '本溪', '溪湖区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('2174', '210505', '南芬区', '3', '0', '213', '辽宁', '本溪', '南芬区', 'NFQ', null);
INSERT INTO `t_pub_city` VALUES ('2175', '210522', '桓仁满族自治县', '3', '0', '213', '辽宁', '本溪', '桓仁满族自治县', 'HRMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2176', '210604', '振安区', '3', '0', '214', '辽宁', '丹东', '振安区', 'ZAQ', null);
INSERT INTO `t_pub_city` VALUES ('2177', '210681', '东港', '3', '0', '214', '辽宁', '丹东', '东港', 'DG', null);
INSERT INTO `t_pub_city` VALUES ('2178', '210702', '古塔区', '3', '0', '119', '辽宁', '锦州', '古塔区', 'GDQ', null);
INSERT INTO `t_pub_city` VALUES ('2179', '210711', '太和区', '3', '0', '119', '辽宁', '锦州', '太和区', 'THQ', null);
INSERT INTO `t_pub_city` VALUES ('2180', '210727', '义县', '3', '0', '119', '辽宁', '锦州', '义县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('2181', '210782', '北镇', '3', '0', '119', '辽宁', '锦州', '北镇', 'BZ', null);
INSERT INTO `t_pub_city` VALUES ('2182', '210803', '西市区', '3', '0', '215', '辽宁', '营口', '西市区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('2183', '210811', '老边区', '3', '0', '215', '辽宁', '营口', '老边区', 'LBQ', null);
INSERT INTO `t_pub_city` VALUES ('2184', '210882', '大石桥', '3', '0', '215', '辽宁', '营口', '大石桥', 'DSQ', null);
INSERT INTO `t_pub_city` VALUES ('2185', '210903', '新邱区', '3', '0', '120', '辽宁', '阜新', '新邱区', 'XQQ', null);
INSERT INTO `t_pub_city` VALUES ('2186', '210905', '清河门区', '3', '0', '120', '辽宁', '阜新', '清河门区', 'QHMQ', null);
INSERT INTO `t_pub_city` VALUES ('2187', '210922', '彰武县', '3', '0', '120', '辽宁', '阜新', '彰武县', 'ZWX', null);
INSERT INTO `t_pub_city` VALUES ('2188', '211003', '文圣区', '3', '0', '216', '辽宁', '辽阳', '文圣区', 'WSQ', null);
INSERT INTO `t_pub_city` VALUES ('2189', '211005', '弓长岭区', '3', '0', '216', '辽宁', '辽阳', '弓长岭区', 'GCLQ', null);
INSERT INTO `t_pub_city` VALUES ('2190', '211021', '辽阳县', '3', '0', '216', '辽宁', '辽阳', '辽阳县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('2191', '211102', '双台子区', '3', '0', '121', '辽宁', '盘锦', '双台子区', 'STZQ', null);
INSERT INTO `t_pub_city` VALUES ('2192', '211104', '大洼区', '3', '0', '121', '辽宁', '盘锦', '大洼区', 'DWQ', null);
INSERT INTO `t_pub_city` VALUES ('2193', '211202', '银州区', '3', '0', '217', '辽宁', '铁岭', '银州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('2194', '211221', '铁岭县', '3', '0', '217', '辽宁', '铁岭', '铁岭县', 'TLX', null);
INSERT INTO `t_pub_city` VALUES ('2195', '211281', '调兵山', '3', '0', '217', '辽宁', '铁岭', '调兵山', 'DBS', null);
INSERT INTO `t_pub_city` VALUES ('2196', '211302', '双塔区', '3', '0', '122', '辽宁', '朝阳', '双塔区', 'SDQ', null);
INSERT INTO `t_pub_city` VALUES ('2197', '211321', '朝阳县', '3', '0', '122', '辽宁', '朝阳', '朝阳县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('2198', '211324', '喀喇沁左翼蒙古族自治县', '3', '0', '122', '辽宁', '朝阳', '喀喇沁左翼蒙古族自治县', 'KLQZYMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2199', '211402', '连山区', '3', '0', '218', '辽宁', '葫芦岛', '连山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2200', '211404', '南票区', '3', '0', '218', '辽宁', '葫芦岛', '南票区', 'NPQ', null);
INSERT INTO `t_pub_city` VALUES ('2201', '211422', '建昌县', '3', '0', '218', '辽宁', '葫芦岛', '建昌县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('2202', '220102', '南关区', '3', '0', '123', '吉林', '长春', '南关区', 'NGQ', null);
INSERT INTO `t_pub_city` VALUES ('2203', '220104', '朝阳区', '3', '0', '123', '吉林', '长春', '朝阳区', 'CYQ', null);
INSERT INTO `t_pub_city` VALUES ('2204', '220106', '绿园区', '3', '0', '123', '吉林', '长春', '绿园区', 'LYQ', null);
INSERT INTO `t_pub_city` VALUES ('2205', '220113', '九台区', '3', '0', '123', '吉林', '长春', '九台区', 'JTQ', null);
INSERT INTO `t_pub_city` VALUES ('2206', '220182', '榆树', '3', '0', '123', '吉林', '长春', '榆树', 'YS', null);
INSERT INTO `t_pub_city` VALUES ('2207', '220203', '龙潭区', '3', '0', '219', '吉林', '吉林', '龙潭区', 'LTQ', null);
INSERT INTO `t_pub_city` VALUES ('2208', '220211', '丰满区', '3', '0', '219', '吉林', '吉林', '丰满区', 'FMQ', null);
INSERT INTO `t_pub_city` VALUES ('2209', '220282', '桦甸', '3', '0', '219', '吉林', '吉林', '桦甸', 'HD', null);
INSERT INTO `t_pub_city` VALUES ('2210', '220284', '磐石', '3', '0', '219', '吉林', '吉林', '磐石', 'PS', null);
INSERT INTO `t_pub_city` VALUES ('2211', '220323', '伊通满族自治县', '3', '0', '220', '吉林', '四平', '伊通满族自治县', 'YTMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2212', '220382', '双辽', '3', '0', '220', '吉林', '四平', '双辽', 'SL', null);
INSERT INTO `t_pub_city` VALUES ('2213', '220421', '东丰县', '3', '0', '124', '吉林', '辽源', '东丰县', 'DFX', null);
INSERT INTO `t_pub_city` VALUES ('2214', '220502', '东昌区', '3', '0', '221', '吉林', '通化', '东昌区', 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('2215', '220523', '辉南县', '3', '0', '221', '吉林', '通化', '辉南县', 'HNX', null);
INSERT INTO `t_pub_city` VALUES ('2216', '220581', '梅河口', '3', '0', '221', '吉林', '通化', '梅河口', 'MHK', null);
INSERT INTO `t_pub_city` VALUES ('2217', '653121', '疏附县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '疏附县', 'SFX', null);
INSERT INTO `t_pub_city` VALUES ('2218', '653123', '英吉沙县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '英吉沙县', 'YJSX', null);
INSERT INTO `t_pub_city` VALUES ('2219', '653125', '莎车县', '3', '0', '130', '新疆维吾尔自治区', '喀什地区', '莎车县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('2220', '230321', '鸡东县', '3', '0', '37', '黑龙江', '鸡西', '鸡东县', 'JDX', null);
INSERT INTO `t_pub_city` VALUES ('2221', '230382', '密山', '3', '0', '37', '黑龙江', '鸡西', '密山', 'MS', null);
INSERT INTO `t_pub_city` VALUES ('2222', '230403', '工农区', '3', '0', '138', '黑龙江', '鹤岗', '工农区', 'GNQ', null);
INSERT INTO `t_pub_city` VALUES ('2223', '230405', '兴安区', '3', '0', '138', '黑龙江', '鹤岗', '兴安区', 'XAQ', null);
INSERT INTO `t_pub_city` VALUES ('2224', '230421', '萝北县', '3', '0', '138', '黑龙江', '鹤岗', '萝北县', 'LBX', null);
INSERT INTO `t_pub_city` VALUES ('2225', '230502', '尖山区', '3', '0', '38', '黑龙江', '双鸭山', '尖山区', 'JSQ', null);
INSERT INTO `t_pub_city` VALUES ('2226', '230505', '四方台区', '3', '0', '38', '黑龙江', '双鸭山', '四方台区', 'SFTQ', null);
INSERT INTO `t_pub_city` VALUES ('2227', '230521', '集贤县', '3', '0', '38', '黑龙江', '双鸭山', '集贤县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('2228', '230523', '宝清县', '3', '0', '38', '黑龙江', '双鸭山', '宝清县', 'BQX', null);
INSERT INTO `t_pub_city` VALUES ('2229', '230524', '饶河县', '3', '0', '38', '黑龙江', '双鸭山', '饶河县', 'RHX', null);
INSERT INTO `t_pub_city` VALUES ('2230', '230604', '让胡路区', '3', '0', '139', '黑龙江', '大庆', '让胡路区', 'RHLQ', null);
INSERT INTO `t_pub_city` VALUES ('2231', '230606', '大同区', '3', '0', '139', '黑龙江', '大庆', '大同区', 'DTQ', null);
INSERT INTO `t_pub_city` VALUES ('2232', '230622', '肇源县', '3', '0', '139', '黑龙江', '大庆', '肇源县', 'ZYX', null);
INSERT INTO `t_pub_city` VALUES ('2233', '230624', '杜尔伯特蒙古族自治县', '3', '0', '139', '黑龙江', '大庆', '杜尔伯特蒙古族自治县', 'DEBTMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2234', '230704', '友好区', '3', '0', '39', '黑龙江', '伊春', '友好区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('2235', '230706', '翠峦区', '3', '0', '39', '黑龙江', '伊春', '翠峦区', 'CLQ', null);
INSERT INTO `t_pub_city` VALUES ('2236', '230708', '美溪区', '3', '0', '39', '黑龙江', '伊春', '美溪区', 'MXQ', null);
INSERT INTO `t_pub_city` VALUES ('2237', '230710', '五营区', '3', '0', '39', '黑龙江', '伊春', '五营区', 'WYQ', null);
INSERT INTO `t_pub_city` VALUES ('2238', '230712', '汤旺河区', '3', '0', '39', '黑龙江', '伊春', '汤旺河区', 'SWHQ', null);
INSERT INTO `t_pub_city` VALUES ('2239', '230715', '红星区', '3', '0', '39', '黑龙江', '伊春', '红星区', 'GXQ', null);
INSERT INTO `t_pub_city` VALUES ('2240', '230722', '嘉荫县', '3', '0', '39', '黑龙江', '伊春', '嘉荫县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('2241', '230803', '向阳区', '3', '0', '140', '黑龙江', '佳木斯', '向阳区', 'XYQ', null);
INSERT INTO `t_pub_city` VALUES ('2242', '230805', '东风区', '3', '0', '140', '黑龙江', '佳木斯', '东风区', 'DFQ', null);
INSERT INTO `t_pub_city` VALUES ('2243', '230822', '桦南县', '3', '0', '140', '黑龙江', '佳木斯', '桦南县', 'HNX', null);
INSERT INTO `t_pub_city` VALUES ('2244', '230828', '汤原县', '3', '0', '140', '黑龙江', '佳木斯', '汤原县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('2245', '230881', '同江', '3', '0', '140', '黑龙江', '佳木斯', '同江', 'TJ', null);
INSERT INTO `t_pub_city` VALUES ('2246', '230883', '抚远', '3', '0', '140', '黑龙江', '佳木斯', '抚远', 'FY', null);
INSERT INTO `t_pub_city` VALUES ('2247', '230903', '桃山区', '3', '0', '141', '黑龙江', '七台河', '桃山区', 'TSQ', null);
INSERT INTO `t_pub_city` VALUES ('2248', '230921', '勃利县', '3', '0', '141', '黑龙江', '七台河', '勃利县', 'BLX', null);
INSERT INTO `t_pub_city` VALUES ('2249', '231003', '阳明区', '3', '0', '40', '黑龙江', '牡丹江', '阳明区', 'YMQ', null);
INSERT INTO `t_pub_city` VALUES ('2250', '231005', '西安区', '3', '0', '40', '黑龙江', '牡丹江', '西安区', 'XAQ', null);
INSERT INTO `t_pub_city` VALUES ('2251', '231081', '绥芬河', '3', '0', '40', '黑龙江', '牡丹江', '绥芬河', 'SFH', null);
INSERT INTO `t_pub_city` VALUES ('2252', '231084', '宁安', '3', '0', '40', '黑龙江', '牡丹江', '宁安', 'NA', null);
INSERT INTO `t_pub_city` VALUES ('2253', '231086', '东宁', '3', '0', '40', '黑龙江', '牡丹江', '东宁', 'DN', null);
INSERT INTO `t_pub_city` VALUES ('2254', '231121', '嫩江县', '3', '0', '142', '黑龙江', '黑河', '嫩江县', 'NJX', null);
INSERT INTO `t_pub_city` VALUES ('2255', '231124', '孙吴县', '3', '0', '142', '黑龙江', '黑河', '孙吴县', 'SWX', null);
INSERT INTO `t_pub_city` VALUES ('2256', '231182', '五大连池', '3', '0', '142', '黑龙江', '黑河', '五大连池', 'WDLC', null);
INSERT INTO `t_pub_city` VALUES ('2257', '231222', '兰西县', '3', '0', '41', '黑龙江', '绥化', '兰西县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('2258', '231224', '庆安县', '3', '0', '41', '黑龙江', '绥化', '庆安县', 'QAX', null);
INSERT INTO `t_pub_city` VALUES ('2259', '231226', '绥棱县', '3', '0', '41', '黑龙江', '绥化', '绥棱县', 'SLX', null);
INSERT INTO `t_pub_city` VALUES ('2260', '231282', '肇东', '3', '0', '41', '黑龙江', '绥化', '肇东', 'ZD', null);
INSERT INTO `t_pub_city` VALUES ('2261', '232721', '呼玛县', '3', '0', '143', '黑龙江', '大兴安岭地区', '呼玛县', 'HMX', null);
INSERT INTO `t_pub_city` VALUES ('2262', '232723', '漠河县', '3', '0', '143', '黑龙江', '大兴安岭地区', '漠河县', 'MHX', null);
INSERT INTO `t_pub_city` VALUES ('2263', '320104', '秦淮区', '3', '0', '50', '江苏', '南京', '秦淮区', 'QHQ', null);
INSERT INTO `t_pub_city` VALUES ('2264', '320106', '鼓楼区', '3', '0', '50', '江苏', '南京', '鼓楼区', 'GLQ', null);
INSERT INTO `t_pub_city` VALUES ('2265', '320113', '栖霞区', '3', '0', '50', '江苏', '南京', '栖霞区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('2266', '320115', '江宁区', '3', '0', '50', '江苏', '南京', '江宁区', 'JNQ', null);
INSERT INTO `t_pub_city` VALUES ('2267', '320117', '溧水区', '3', '0', '50', '江苏', '南京', '溧水区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2268', '320205', '锡山区', '3', '0', '144', '江苏', '无锡', '锡山区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('2269', '320211', '滨湖区', '3', '0', '144', '江苏', '无锡', '滨湖区', 'BHQ', null);
INSERT INTO `t_pub_city` VALUES ('2270', '320214', '新吴区', '3', '0', '144', '江苏', '无锡', '新吴区', 'XWQ', null);
INSERT INTO `t_pub_city` VALUES ('2271', '320282', '宜兴', '3', '0', '144', '江苏', '无锡', '宜兴', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('2272', '320303', '云龙区', '3', '0', '51', '江苏', '徐州', '云龙区', 'YLQ', null);
INSERT INTO `t_pub_city` VALUES ('2273', '320311', '泉山区', '3', '0', '51', '江苏', '徐州', '泉山区', 'QSQ', null);
INSERT INTO `t_pub_city` VALUES ('2274', '320322', '沛县', '3', '0', '51', '江苏', '徐州', '沛县', 'PX', null);
INSERT INTO `t_pub_city` VALUES ('2275', '320324', '睢宁县', '3', '0', '51', '江苏', '徐州', '睢宁县', 'SNX', null);
INSERT INTO `t_pub_city` VALUES ('2276', '320402', '天宁区', '3', '0', '145', '江苏', '常州', '天宁区', 'TNQ', null);
INSERT INTO `t_pub_city` VALUES ('2277', '320411', '新北区', '3', '0', '145', '江苏', '常州', '新北区', 'XBQ', null);
INSERT INTO `t_pub_city` VALUES ('2278', '320413', '金坛区', '3', '0', '145', '江苏', '常州', '金坛区', 'JTQ', null);
INSERT INTO `t_pub_city` VALUES ('2279', '320505', '虎丘区', '3', '0', '52', '江苏', '苏州', '虎丘区', 'HQQ', null);
INSERT INTO `t_pub_city` VALUES ('2280', '320507', '相城区', '3', '0', '52', '江苏', '苏州', '相城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('2281', '320509', '吴江区', '3', '0', '52', '江苏', '苏州', '吴江区', 'WJQ', null);
INSERT INTO `t_pub_city` VALUES ('2282', '320582', '张家港', '3', '0', '52', '江苏', '苏州', '张家港', 'ZJJ', null);
INSERT INTO `t_pub_city` VALUES ('2283', '320585', '太仓', '3', '0', '52', '江苏', '苏州', '太仓', 'TC', null);
INSERT INTO `t_pub_city` VALUES ('2284', '320611', '港闸区', '3', '0', '146', '江苏', '南通', '港闸区', 'GZQ', null);
INSERT INTO `t_pub_city` VALUES ('2285', '320621', '海安县', '3', '0', '146', '江苏', '南通', '海安县', 'HAX', null);
INSERT INTO `t_pub_city` VALUES ('2286', '320681', '启东', '3', '0', '146', '江苏', '南通', '启东', 'QD', null);
INSERT INTO `t_pub_city` VALUES ('2287', '320684', '海门', '3', '0', '146', '江苏', '南通', '海门', 'HM', null);
INSERT INTO `t_pub_city` VALUES ('2288', '320706', '海州区', '3', '0', '53', '江苏', '连云港', '海州区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('2289', '320722', '东海县', '3', '0', '53', '江苏', '连云港', '东海县', 'DHX', null);
INSERT INTO `t_pub_city` VALUES ('2290', '320724', '灌南县', '3', '0', '53', '江苏', '连云港', '灌南县', 'GNX', null);
INSERT INTO `t_pub_city` VALUES ('2291', '320803', '淮安区', '3', '0', '147', '江苏', '淮安', '淮安区', 'HAQ', null);
INSERT INTO `t_pub_city` VALUES ('2292', '320811', '清浦区', '3', '0', '147', '江苏', '淮安', '清浦区', 'QPQ', null);
INSERT INTO `t_pub_city` VALUES ('2293', '320826', '涟水县', '3', '0', '147', '江苏', '淮安', '涟水县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2294', '320903', '盐都区', '3', '0', '148', '江苏', '盐城', '盐都区', 'YDQ', null);
INSERT INTO `t_pub_city` VALUES ('2295', '320921', '响水县', '3', '0', '148', '江苏', '盐城', '响水县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('2296', '320923', '阜宁县', '3', '0', '148', '江苏', '盐城', '阜宁县', 'FNX', null);
INSERT INTO `t_pub_city` VALUES ('2297', '320925', '建湖县', '3', '0', '148', '江苏', '盐城', '建湖县', 'JHX', null);
INSERT INTO `t_pub_city` VALUES ('2298', '321002', '广陵区', '3', '0', '54', '江苏', '扬州', '广陵区', 'ALQ', null);
INSERT INTO `t_pub_city` VALUES ('2299', '321012', '江都区', '3', '0', '54', '江苏', '扬州', '江都区', 'JDQ', null);
INSERT INTO `t_pub_city` VALUES ('2300', '321084', '高邮', '3', '0', '54', '江苏', '扬州', '高邮', 'GY', null);
INSERT INTO `t_pub_city` VALUES ('2301', '321111', '润州区', '3', '0', '149', '江苏', '镇江', '润州区', 'RZQ', null);
INSERT INTO `t_pub_city` VALUES ('2302', '321182', '扬中', '3', '0', '149', '江苏', '镇江', '扬中', 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('2303', '321202', '海陵区', '3', '0', '55', '江苏', '泰州', '海陵区', 'HLQ', null);
INSERT INTO `t_pub_city` VALUES ('2304', '321281', '兴化', '3', '0', '55', '江苏', '泰州', '兴化', 'XH', null);
INSERT INTO `t_pub_city` VALUES ('2305', '321283', '泰兴', '3', '0', '55', '江苏', '泰州', '泰兴', 'TX', null);
INSERT INTO `t_pub_city` VALUES ('2306', '321322', '沭阳县', '3', '0', '150', '江苏', '宿迁', '沭阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('2307', '321324', '泗洪县', '3', '0', '150', '江苏', '宿迁', '泗洪县', 'SHX', null);
INSERT INTO `t_pub_city` VALUES ('2308', '330105', '拱墅区', '3', '0', '56', '浙江', '杭州', '拱墅区', 'GSQ', null);
INSERT INTO `t_pub_city` VALUES ('2309', '330108', '滨江区', '3', '0', '56', '浙江', '杭州', '滨江区', 'BJQ', null);
INSERT INTO `t_pub_city` VALUES ('2310', '330111', '富阳区', '3', '0', '56', '浙江', '杭州', '富阳区', 'FYQ', null);
INSERT INTO `t_pub_city` VALUES ('2311', '330127', '淳安县', '3', '0', '56', '浙江', '杭州', '淳安县', 'CAX', null);
INSERT INTO `t_pub_city` VALUES ('2312', '330203', '海曙区', '3', '0', '151', '浙江', '宁波', '海曙区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('2313', '330205', '江北区', '3', '0', '151', '浙江', '宁波', '江北区', 'JBQ', null);
INSERT INTO `t_pub_city` VALUES ('2314', '330212', '鄞州区', '3', '0', '151', '浙江', '宁波', '鄞州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('2315', '330226', '宁海县', '3', '0', '151', '浙江', '宁波', '宁海县', 'NHX', null);
INSERT INTO `t_pub_city` VALUES ('2316', '330282', '慈溪', '3', '0', '151', '浙江', '宁波', '慈溪', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('2317', '330302', '鹿城区', '3', '0', '152', '浙江', '温州', '鹿城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2318', '330304', '瓯海区', '3', '0', '152', '浙江', '温州', '瓯海区', 'OHQ', null);
INSERT INTO `t_pub_city` VALUES ('2319', '330324', '永嘉县', '3', '0', '152', '浙江', '温州', '永嘉县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('2320', '330328', '文成县', '3', '0', '152', '浙江', '温州', '文成县', 'WCX', null);
INSERT INTO `t_pub_city` VALUES ('2321', '330381', '瑞安', '3', '0', '152', '浙江', '温州', '瑞安', 'RA', null);
INSERT INTO `t_pub_city` VALUES ('2322', '330402', '南湖区', '3', '0', '57', '浙江', '嘉兴', '南湖区', 'NHQ', null);
INSERT INTO `t_pub_city` VALUES ('2323', '330421', '嘉善县', '3', '0', '57', '浙江', '嘉兴', '嘉善县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('2324', '330481', '海宁', '3', '0', '57', '浙江', '嘉兴', '海宁', 'HN', null);
INSERT INTO `t_pub_city` VALUES ('2325', '330483', '桐乡', '3', '0', '57', '浙江', '嘉兴', '桐乡', 'TX', null);
INSERT INTO `t_pub_city` VALUES ('2326', '330503', '南浔区', '3', '0', '153', '浙江', '湖州', '南浔区', 'NXQ', null);
INSERT INTO `t_pub_city` VALUES ('2327', '330522', '长兴县', '3', '0', '153', '浙江', '湖州', '长兴县', 'CXX', null);
INSERT INTO `t_pub_city` VALUES ('2328', '330602', '越城区', '3', '0', '154', '浙江', '绍兴', '越城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('2329', '330604', '上虞区', '3', '0', '154', '浙江', '绍兴', '上虞区', 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('2330', '330681', '诸暨', '3', '0', '154', '浙江', '绍兴', '诸暨', 'ZJ', null);
INSERT INTO `t_pub_city` VALUES ('2331', '330702', '婺城区', '3', '0', '58', '浙江', '金华', '婺城区', 'WCQ', null);
INSERT INTO `t_pub_city` VALUES ('2332', '330723', '武义县', '3', '0', '58', '浙江', '金华', '武义县', 'WYX', null);
INSERT INTO `t_pub_city` VALUES ('2333', '330727', '磐安县', '3', '0', '58', '浙江', '金华', '磐安县', 'PAX', null);
INSERT INTO `t_pub_city` VALUES ('2334', '330783', '东阳', '3', '0', '58', '浙江', '金华', '东阳', 'DY', null);
INSERT INTO `t_pub_city` VALUES ('2335', '330802', '柯城区', '3', '0', '155', '浙江', '衢州', '柯城区', 'KCQ', null);
INSERT INTO `t_pub_city` VALUES ('2336', '330822', '常山县', '3', '0', '155', '浙江', '衢州', '常山县', 'CSX', null);
INSERT INTO `t_pub_city` VALUES ('2337', '330825', '龙游县', '3', '0', '155', '浙江', '衢州', '龙游县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('2338', '330902', '定海区', '3', '0', '59', '浙江', '舟山', '定海区', 'DHQ', null);
INSERT INTO `t_pub_city` VALUES ('2339', '330921', '岱山县', '3', '0', '59', '浙江', '舟山', '岱山县', 'DSX', null);
INSERT INTO `t_pub_city` VALUES ('2340', '331002', '椒江区', '3', '0', '156', '浙江', '台州', '椒江区', 'JJQ', null);
INSERT INTO `t_pub_city` VALUES ('2341', '331004', '路桥区', '3', '0', '156', '浙江', '台州', '路桥区', 'LQQ', null);
INSERT INTO `t_pub_city` VALUES ('2342', '331022', '三门县', '3', '0', '156', '浙江', '台州', '三门县', 'SMX', null);
INSERT INTO `t_pub_city` VALUES ('2343', '331024', '仙居县', '3', '0', '156', '浙江', '台州', '仙居县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('2344', '331082', '临海', '3', '0', '156', '浙江', '台州', '临海', 'LH', null);
INSERT INTO `t_pub_city` VALUES ('2345', '331121', '青田县', '3', '0', '60', '浙江', '丽水', '青田县', 'QTX', null);
INSERT INTO `t_pub_city` VALUES ('2346', '331123', '遂昌县', '3', '0', '60', '浙江', '丽水', '遂昌县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('2347', '331125', '云和县', '3', '0', '60', '浙江', '丽水', '云和县', 'YHX', null);
INSERT INTO `t_pub_city` VALUES ('2348', '331181', '龙泉', '3', '0', '60', '浙江', '丽水', '龙泉', 'LQ', null);
INSERT INTO `t_pub_city` VALUES ('2349', '340103', '庐阳区', '3', '0', '157', '安徽', '合肥', '庐阳区', 'LYQ', null);
INSERT INTO `t_pub_city` VALUES ('2350', '340111', '包河区', '3', '0', '157', '安徽', '合肥', '包河区', 'BHQ', null);
INSERT INTO `t_pub_city` VALUES ('2351', '340122', '肥东县', '3', '0', '157', '安徽', '合肥', '肥东县', 'FDX', null);
INSERT INTO `t_pub_city` VALUES ('2352', '340124', '庐江县', '3', '0', '157', '安徽', '合肥', '庐江县', 'LJX', null);
INSERT INTO `t_pub_city` VALUES ('2353', '340202', '镜湖区', '3', '0', '61', '安徽', '芜湖', '镜湖区', 'JHQ', null);
INSERT INTO `t_pub_city` VALUES ('2354', '340207', '鸠江区', '3', '0', '61', '安徽', '芜湖', '鸠江区', 'JJQ', null);
INSERT INTO `t_pub_city` VALUES ('2355', '340221', '芜湖县', '3', '0', '61', '安徽', '芜湖', '芜湖县', 'WHX', null);
INSERT INTO `t_pub_city` VALUES ('2356', '340223', '南陵县', '3', '0', '61', '安徽', '芜湖', '南陵县', 'NLX', null);
INSERT INTO `t_pub_city` VALUES ('2357', '340302', '龙子湖区', '3', '0', '158', '安徽', '蚌埠', '龙子湖区', 'LZHQ', null);
INSERT INTO `t_pub_city` VALUES ('2358', '340304', '禹会区', '3', '0', '158', '安徽', '蚌埠', '禹会区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('2359', '340321', '怀远县', '3', '0', '158', '安徽', '蚌埠', '怀远县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('2360', '340402', '大通区', '3', '0', '159', '安徽', '淮南', '大通区', 'DTQ', null);
INSERT INTO `t_pub_city` VALUES ('2361', '340404', '谢家集区', '3', '0', '159', '安徽', '淮南', '谢家集区', 'XJJQ', null);
INSERT INTO `t_pub_city` VALUES ('2362', '340406', '潘集区', '3', '0', '159', '安徽', '淮南', '潘集区', 'PJQ', null);
INSERT INTO `t_pub_city` VALUES ('2363', '340422', '寿县', '3', '0', '159', '安徽', '淮南', '寿县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('2364', '340504', '雨山区', '3', '0', '62', '安徽', '马鞍山', '雨山区', 'YSQ', null);
INSERT INTO `t_pub_city` VALUES ('2365', '340521', '当涂县', '3', '0', '62', '安徽', '马鞍山', '当涂县', 'DTX', null);
INSERT INTO `t_pub_city` VALUES ('2366', '340523', '和县', '3', '0', '62', '安徽', '马鞍山', '和县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('2367', '340602', '杜集区', '3', '0', '160', '安徽', '淮北', '杜集区', 'DJQ', null);
INSERT INTO `t_pub_city` VALUES ('2368', '340621', '濉溪县', '3', '0', '160', '安徽', '淮北', '濉溪县', 'SXX', null);
INSERT INTO `t_pub_city` VALUES ('2369', '340706', '义安区', '3', '0', '63', '安徽', '铜陵', '义安区', 'YAQ', null);
INSERT INTO `t_pub_city` VALUES ('2370', '340722', '枞阳县', '3', '0', '63', '安徽', '铜陵', '枞阳县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('2371', '340803', '大观区', '3', '0', '161', '安徽', '安庆', '大观区', 'DGQ', null);
INSERT INTO `t_pub_city` VALUES ('2372', '340822', '怀宁县', '3', '0', '161', '安徽', '安庆', '怀宁县', 'HNX', null);
INSERT INTO `t_pub_city` VALUES ('2373', '340825', '太湖县', '3', '0', '161', '安徽', '安庆', '太湖县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('2374', '340827', '望江县', '3', '0', '161', '安徽', '安庆', '望江县', 'WJX', null);
INSERT INTO `t_pub_city` VALUES ('2375', '340881', '桐城', '3', '0', '161', '安徽', '安庆', '桐城', 'TC', null);
INSERT INTO `t_pub_city` VALUES ('2376', '341003', '黄山区', '3', '0', '64', '安徽', '黄山', '黄山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('2377', '341021', '歙县', '3', '0', '64', '安徽', '黄山', '歙县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('2378', '341023', '黟县', '3', '0', '64', '安徽', '黄山', '黟县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('2379', '341102', '琅琊区', '3', '0', '162', '安徽', '滁州', '琅琊区', 'LYQ', null);
INSERT INTO `t_pub_city` VALUES ('2380', '341122', '来安县', '3', '0', '162', '安徽', '滁州', '来安县', 'LAX', null);
INSERT INTO `t_pub_city` VALUES ('2381', '341125', '定远县', '3', '0', '162', '安徽', '滁州', '定远县', 'DYX', null);
INSERT INTO `t_pub_city` VALUES ('2382', '341181', '天长', '3', '0', '162', '安徽', '滁州', '天长', 'TC', null);
INSERT INTO `t_pub_city` VALUES ('2383', '341202', '颍州区', '3', '0', '163', '安徽', '阜阳', '颍州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('2384', '341204', '颍泉区', '3', '0', '163', '安徽', '阜阳', '颍泉区', 'YQQ', null);
INSERT INTO `t_pub_city` VALUES ('2385', '341222', '太和县', '3', '0', '163', '安徽', '阜阳', '太和县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('2386', '341282', '界首', '3', '0', '163', '安徽', '阜阳', '界首', 'JS', null);
INSERT INTO `t_pub_city` VALUES ('2387', '341321', '砀山县', '3', '0', '65', '安徽', '宿州', '砀山县', 'DSX', null);
INSERT INTO `t_pub_city` VALUES ('2388', '341323', '灵璧县', '3', '0', '65', '安徽', '宿州', '灵璧县', 'LBX', null);
INSERT INTO `t_pub_city` VALUES ('2389', '341502', '金安区', '3', '0', '164', '安徽', '六安', '金安区', 'JAQ', null);
INSERT INTO `t_pub_city` VALUES ('2390', '341504', '叶集区', '3', '0', '164', '安徽', '六安', '叶集区', 'XJQ', null);
INSERT INTO `t_pub_city` VALUES ('2391', '341523', '舒城县', '3', '0', '164', '安徽', '六安', '舒城县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('2392', '341525', '霍山县', '3', '0', '164', '安徽', '六安', '霍山县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('2393', '341621', '涡阳县', '3', '0', '66', '安徽', '亳州', '涡阳县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('2394', '341623', '利辛县', '3', '0', '66', '安徽', '亳州', '利辛县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('2395', '341721', '东至县', '3', '0', '165', '安徽', '池州', '东至县', 'DZX', null);
INSERT INTO `t_pub_city` VALUES ('2396', '341723', '青阳县', '3', '0', '165', '安徽', '池州', '青阳县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('2397', '341821', '郎溪县', '3', '0', '67', '安徽', '宣城', '郎溪县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('2398', '341823', '泾县', '3', '0', '67', '安徽', '宣城', '泾县', 'JX', null);
INSERT INTO `t_pub_city` VALUES ('2399', '341825', '旌德县', '3', '0', '67', '安徽', '宣城', '旌德县', 'JDX', null);
INSERT INTO `t_pub_city` VALUES ('2400', '350102', '鼓楼区', '3', '0', '166', '福建', '福州', '鼓楼区', 'GLQ', null);
INSERT INTO `t_pub_city` VALUES ('2401', '350104', '仓山区', '3', '0', '166', '福建', '福州', '仓山区', 'CSQ', null);
INSERT INTO `t_pub_city` VALUES ('2402', '350121', '闽侯县', '3', '0', '166', '福建', '福州', '闽侯县', 'MHX', null);
INSERT INTO `t_pub_city` VALUES ('2403', '350123', '罗源县', '3', '0', '166', '福建', '福州', '罗源县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('2404', '350125', '永泰县', '3', '0', '166', '福建', '福州', '永泰县', 'YTX', null);
INSERT INTO `t_pub_city` VALUES ('2405', '350181', '福清', '3', '0', '166', '福建', '福州', '福清', 'FQ', null);
INSERT INTO `t_pub_city` VALUES ('2406', '350203', '思明区', '3', '0', '68', '福建', '厦门', '思明区', 'SMQ', null);
INSERT INTO `t_pub_city` VALUES ('2407', '350206', '湖里区', '3', '0', '68', '福建', '厦门', '湖里区', 'HLQ', null);
INSERT INTO `t_pub_city` VALUES ('2408', '350212', '同安区', '3', '0', '68', '福建', '厦门', '同安区', 'TAQ', null);
INSERT INTO `t_pub_city` VALUES ('2409', '350302', '城厢区', '3', '0', '167', '福建', '莆田', '城厢区', 'CXQ', null);
INSERT INTO `t_pub_city` VALUES ('2410', '350304', '荔城区', '3', '0', '167', '福建', '莆田', '荔城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2411', '350322', '仙游县', '3', '0', '167', '福建', '莆田', '仙游县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('2412', '350403', '三元区', '3', '0', '168', '福建', '三明', '三元区', 'SYQ', null);
INSERT INTO `t_pub_city` VALUES ('2413', '350423', '清流县', '3', '0', '168', '福建', '三明', '清流县', 'QLX', null);
INSERT INTO `t_pub_city` VALUES ('2414', '350425', '大田县', '3', '0', '168', '福建', '三明', '大田县', 'DTX', null);
INSERT INTO `t_pub_city` VALUES ('2415', '350427', '沙县', '3', '0', '168', '福建', '三明', '沙县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('2416', '350429', '泰宁县', '3', '0', '168', '福建', '三明', '泰宁县', 'TNX', null);
INSERT INTO `t_pub_city` VALUES ('2417', '350481', '永安', '3', '0', '168', '福建', '三明', '永安', 'YA', null);
INSERT INTO `t_pub_city` VALUES ('2418', '350504', '洛江区', '3', '0', '69', '福建', '泉州', '洛江区', 'LJQ', null);
INSERT INTO `t_pub_city` VALUES ('2419', '350521', '惠安县', '3', '0', '69', '福建', '泉州', '惠安县', 'HAX', null);
INSERT INTO `t_pub_city` VALUES ('2420', '350525', '永春县', '3', '0', '69', '福建', '泉州', '永春县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2421', '350527', '金门县', '3', '0', '69', '福建', '泉州', '金门县', 'JMX', null);
INSERT INTO `t_pub_city` VALUES ('2422', '350582', '晋江', '3', '0', '69', '福建', '泉州', '晋江', 'JJ', null);
INSERT INTO `t_pub_city` VALUES ('2423', '350602', '芗城区', '3', '0', '169', '福建', '漳州', '芗城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('2424', '350622', '云霄县', '3', '0', '169', '福建', '漳州', '云霄县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('2425', '350624', '诏安县', '3', '0', '169', '福建', '漳州', '诏安县', 'ZAX', null);
INSERT INTO `t_pub_city` VALUES ('2426', '350626', '东山县', '3', '0', '169', '福建', '漳州', '东山县', 'DSX', null);
INSERT INTO `t_pub_city` VALUES ('2427', '350629', '华安县', '3', '0', '169', '福建', '漳州', '华安县', 'HAX', null);
INSERT INTO `t_pub_city` VALUES ('2428', '350702', '延平区', '3', '0', '70', '福建', '南平', '延平区', 'YPQ', null);
INSERT INTO `t_pub_city` VALUES ('2429', '350722', '浦城县', '3', '0', '70', '福建', '南平', '浦城县', 'PCX', null);
INSERT INTO `t_pub_city` VALUES ('2430', '350724', '松溪县', '3', '0', '70', '福建', '南平', '松溪县', 'SXX', null);
INSERT INTO `t_pub_city` VALUES ('2431', '350782', '武夷山', '3', '0', '70', '福建', '南平', '武夷山', 'WYS', null);
INSERT INTO `t_pub_city` VALUES ('2432', '350821', '长汀县', '3', '0', '170', '福建', '龙岩', '长汀县', 'CTX', null);
INSERT INTO `t_pub_city` VALUES ('2433', '350824', '武平县', '3', '0', '170', '福建', '龙岩', '武平县', 'WPX', null);
INSERT INTO `t_pub_city` VALUES ('2434', '350902', '蕉城区', '3', '0', '71', '福建', '宁德', '蕉城区', 'JCQ', null);
INSERT INTO `t_pub_city` VALUES ('2435', '350922', '古田县', '3', '0', '71', '福建', '宁德', '古田县', 'GTX', null);
INSERT INTO `t_pub_city` VALUES ('2436', '350925', '周宁县', '3', '0', '71', '福建', '宁德', '周宁县', 'ZNX', null);
INSERT INTO `t_pub_city` VALUES ('2437', '350981', '福安', '3', '0', '71', '福建', '宁德', '福安', 'FA', null);
INSERT INTO `t_pub_city` VALUES ('2438', '360103', '西湖区', '3', '0', '171', '江西', '南昌', '西湖区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('2439', '360105', '湾里区', '3', '0', '171', '江西', '南昌', '湾里区', 'WLQ', null);
INSERT INTO `t_pub_city` VALUES ('2440', '360121', '南昌县', '3', '0', '171', '江西', '南昌', '南昌县', 'NCX', null);
INSERT INTO `t_pub_city` VALUES ('2441', '360124', '进贤县', '3', '0', '171', '江西', '南昌', '进贤县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('2442', '360222', '浮梁县', '3', '0', '72', '江西', '景德镇', '浮梁县', 'FLX', null);
INSERT INTO `t_pub_city` VALUES ('2443', '360302', '安源区', '3', '0', '172', '江西', '萍乡', '安源区', 'AYQ', null);
INSERT INTO `t_pub_city` VALUES ('2444', '360322', '上栗县', '3', '0', '172', '江西', '萍乡', '上栗县', 'SLX', null);
INSERT INTO `t_pub_city` VALUES ('2445', '360403', '浔阳区', '3', '0', '173', '江西', '九江', '浔阳区', 'XYQ', null);
INSERT INTO `t_pub_city` VALUES ('2446', '360423', '武宁县', '3', '0', '173', '江西', '九江', '武宁县', 'WNX', null);
INSERT INTO `t_pub_city` VALUES ('2447', '360425', '永修县', '3', '0', '173', '江西', '九江', '永修县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('2448', '360427', '星子县', '3', '0', '173', '江西', '九江', '星子县', 'XZX', null);
INSERT INTO `t_pub_city` VALUES ('2449', '360429', '湖口县', '3', '0', '173', '江西', '九江', '湖口县', 'HKX', null);
INSERT INTO `t_pub_city` VALUES ('2450', '360482', '共青城', '3', '0', '173', '江西', '九江', '共青城', 'GQC', null);
INSERT INTO `t_pub_city` VALUES ('2451', '360521', '分宜县', '3', '0', '174', '江西', '新余', '分宜县', 'FYX', null);
INSERT INTO `t_pub_city` VALUES ('2452', '360622', '余江县', '3', '0', '73', '江西', '鹰潭', '余江县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('2453', '360702', '章贡区', '3', '0', '175', '江西', '赣州', '章贡区', 'ZGQ', null);
INSERT INTO `t_pub_city` VALUES ('2454', '360721', '赣县', '3', '0', '175', '江西', '赣州', '赣县', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('2455', '360723', '大余县', '3', '0', '175', '江西', '赣州', '大余县', 'DYX', null);
INSERT INTO `t_pub_city` VALUES ('2456', '360725', '崇义县', '3', '0', '175', '江西', '赣州', '崇义县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('2457', '360727', '龙南县', '3', '0', '175', '江西', '赣州', '龙南县', 'LNX', null);
INSERT INTO `t_pub_city` VALUES ('2458', '360729', '全南县', '3', '0', '175', '江西', '赣州', '全南县', 'QNX', null);
INSERT INTO `t_pub_city` VALUES ('2459', '360731', '于都县', '3', '0', '175', '江西', '赣州', '于都县', 'YDX', null);
INSERT INTO `t_pub_city` VALUES ('2460', '360733', '会昌县', '3', '0', '175', '江西', '赣州', '会昌县', 'HCX', null);
INSERT INTO `t_pub_city` VALUES ('2461', '360735', '石城县', '3', '0', '175', '江西', '赣州', '石城县', 'SCX', null);
INSERT INTO `t_pub_city` VALUES ('2462', '360802', '吉州区', '3', '0', '176', '江西', '吉安', '吉州区', 'JZQ', null);
INSERT INTO `t_pub_city` VALUES ('2463', '360821', '吉安县', '3', '0', '176', '江西', '吉安', '吉安县', 'JAX', null);
INSERT INTO `t_pub_city` VALUES ('2464', '360824', '新干县', '3', '0', '176', '江西', '吉安', '新干县', 'XGX', null);
INSERT INTO `t_pub_city` VALUES ('2465', '360826', '泰和县', '3', '0', '176', '江西', '吉安', '泰和县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('2466', '360828', '万安县', '3', '0', '176', '江西', '吉安', '万安县', 'WAX', null);
INSERT INTO `t_pub_city` VALUES ('2467', '360881', '井冈山', '3', '0', '176', '江西', '吉安', '井冈山', 'JGS', null);
INSERT INTO `t_pub_city` VALUES ('2468', '360921', '奉新县', '3', '0', '74', '江西', '宜春', '奉新县', 'FXX', null);
INSERT INTO `t_pub_city` VALUES ('2469', '360923', '上高县', '3', '0', '74', '江西', '宜春', '上高县', 'SGX', null);
INSERT INTO `t_pub_city` VALUES ('2470', '360925', '靖安县', '3', '0', '74', '江西', '宜春', '靖安县', 'JAX', null);
INSERT INTO `t_pub_city` VALUES ('2471', '360981', '丰城', '3', '0', '74', '江西', '宜春', '丰城', 'FC', null);
INSERT INTO `t_pub_city` VALUES ('2472', '360983', '高安', '3', '0', '74', '江西', '宜春', '高安', 'GA', null);
INSERT INTO `t_pub_city` VALUES ('2473', '361021', '南城县', '3', '0', '177', '江西', '抚州', '南城县', 'NCX', null);
INSERT INTO `t_pub_city` VALUES ('2474', '361023', '南丰县', '3', '0', '177', '江西', '抚州', '南丰县', 'NFX', null);
INSERT INTO `t_pub_city` VALUES ('2475', '361025', '乐安县', '3', '0', '177', '江西', '抚州', '乐安县', 'LAX', null);
INSERT INTO `t_pub_city` VALUES ('2476', '361028', '资溪县', '3', '0', '177', '江西', '抚州', '资溪县', 'ZXX', null);
INSERT INTO `t_pub_city` VALUES ('2477', '361030', '广昌县', '3', '0', '177', '江西', '抚州', '广昌县', 'ACX', null);
INSERT INTO `t_pub_city` VALUES ('2478', '361121', '上饶县', '3', '0', '75', '江西', '上饶', '上饶县', 'SRX', null);
INSERT INTO `t_pub_city` VALUES ('2479', '361123', '玉山县', '3', '0', '75', '江西', '上饶', '玉山县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('2480', '361125', '横峰县', '3', '0', '75', '江西', '上饶', '横峰县', 'HFX', '1');
INSERT INTO `t_pub_city` VALUES ('2481', '361127', '余干县', '3', '0', '75', '江西', '上饶', '余干县', 'YGX', null);
INSERT INTO `t_pub_city` VALUES ('2482', '361129', '万年县', '3', '0', '75', '江西', '上饶', '万年县', 'WNX', null);
INSERT INTO `t_pub_city` VALUES ('2483', '361181', '德兴', '3', '0', '75', '江西', '上饶', '德兴', 'DX', null);
INSERT INTO `t_pub_city` VALUES ('2484', '370103', '市中区', '3', '0', '178', '山东', '济南', '市中区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('2485', '370105', '天桥区', '3', '0', '178', '山东', '济南', '天桥区', 'TQQ', null);
INSERT INTO `t_pub_city` VALUES ('2486', '370113', '长清区', '3', '0', '178', '山东', '济南', '长清区', 'CQQ', null);
INSERT INTO `t_pub_city` VALUES ('2487', '370125', '济阳县', '3', '0', '178', '山东', '济南', '济阳县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('2488', '370181', '章丘', '3', '0', '178', '山东', '济南', '章丘', 'ZQ', null);
INSERT INTO `t_pub_city` VALUES ('2489', '370203', '市北区', '3', '0', '76', '山东', '青岛', '市北区', 'SBQ', null);
INSERT INTO `t_pub_city` VALUES ('2490', '370213', '李沧区', '3', '0', '76', '山东', '青岛', '李沧区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2491', '370281', '胶州', '3', '0', '76', '山东', '青岛', '胶州', 'JZ', null);
INSERT INTO `t_pub_city` VALUES ('2492', '370283', '平度', '3', '0', '76', '山东', '青岛', '平度', 'PD', null);
INSERT INTO `t_pub_city` VALUES ('2493', '370302', '淄川区', '3', '0', '179', '山东', '淄博', '淄川区', 'ZCQ', null);
INSERT INTO `t_pub_city` VALUES ('2494', '370304', '博山区', '3', '0', '179', '山东', '淄博', '博山区', 'BSQ', null);
INSERT INTO `t_pub_city` VALUES ('2495', '370306', '周村区', '3', '0', '179', '山东', '淄博', '周村区', 'ZCQ', null);
INSERT INTO `t_pub_city` VALUES ('2496', '370322', '高青县', '3', '0', '179', '山东', '淄博', '高青县', 'GQX', null);
INSERT INTO `t_pub_city` VALUES ('2497', '370402', '市中区', '3', '0', '77', '山东', '枣庄', '市中区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('2498', '370404', '峄城区', '3', '0', '77', '山东', '枣庄', '峄城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('2499', '370406', '山亭区', '3', '0', '77', '山东', '枣庄', '山亭区', 'STQ', null);
INSERT INTO `t_pub_city` VALUES ('2500', '370502', '东营区', '3', '0', '180', '山东', '东营', '东营区', 'DYQ', null);
INSERT INTO `t_pub_city` VALUES ('2501', '370505', '垦利区', '3', '0', '180', '山东', '东营', '垦利区', 'KLQ', null);
INSERT INTO `t_pub_city` VALUES ('2502', '370523', '广饶县', '3', '0', '180', '山东', '东营', '广饶县', 'ARX', null);
INSERT INTO `t_pub_city` VALUES ('2503', '370612', '牟平区', '3', '0', '181', '山东', '烟台', '牟平区', 'MPQ', null);
INSERT INTO `t_pub_city` VALUES ('2504', '370634', '长岛县', '3', '0', '181', '山东', '烟台', '长岛县', 'CDX', null);
INSERT INTO `t_pub_city` VALUES ('2505', '370682', '莱阳', '3', '0', '181', '山东', '烟台', '莱阳', 'LY', null);
INSERT INTO `t_pub_city` VALUES ('2506', '370684', '蓬莱', '3', '0', '181', '山东', '烟台', '蓬莱', 'PL', null);
INSERT INTO `t_pub_city` VALUES ('2507', '370686', '栖霞', '3', '0', '181', '山东', '烟台', '栖霞', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('2508', '370702', '潍城区', '3', '0', '78', '山东', '潍坊', '潍城区', 'WCQ', null);
INSERT INTO `t_pub_city` VALUES ('2509', '370704', '坊子区', '3', '0', '78', '山东', '潍坊', '坊子区', 'FZQ', null);
INSERT INTO `t_pub_city` VALUES ('2510', '370724', '临朐县', '3', '0', '78', '山东', '潍坊', '临朐县', 'LQX', null);
INSERT INTO `t_pub_city` VALUES ('2511', '370781', '青州', '3', '0', '78', '山东', '潍坊', '青州', 'QZ', null);
INSERT INTO `t_pub_city` VALUES ('2512', '370783', '寿光', '3', '0', '78', '山东', '潍坊', '寿光', 'SG', null);
INSERT INTO `t_pub_city` VALUES ('2513', '370785', '高密', '3', '0', '78', '山东', '潍坊', '高密', 'GM', null);
INSERT INTO `t_pub_city` VALUES ('2514', '370811', '任城区', '3', '0', '182', '山东', '济宁', '任城区', 'RCQ', null);
INSERT INTO `t_pub_city` VALUES ('2515', '370826', '微山县', '3', '0', '182', '山东', '济宁', '微山县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('2516', '370828', '金乡县', '3', '0', '182', '山东', '济宁', '金乡县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('2517', '370831', '泗水县', '3', '0', '182', '山东', '济宁', '泗水县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('2518', '370881', '曲阜', '3', '0', '182', '山东', '济宁', '曲阜', 'QF', null);
INSERT INTO `t_pub_city` VALUES ('2519', '370902', '泰山区', '3', '0', '79', '山东', '泰安', '泰山区', 'TSQ', null);
INSERT INTO `t_pub_city` VALUES ('2520', '370921', '宁阳县', '3', '0', '79', '山东', '泰安', '宁阳县', 'NYX', null);
INSERT INTO `t_pub_city` VALUES ('2521', '370982', '新泰', '3', '0', '79', '山东', '泰安', '新泰', 'XT', null);
INSERT INTO `t_pub_city` VALUES ('2522', '371002', '环翠区', '3', '0', '183', '山东', '威海', '环翠区', 'HCQ', null);
INSERT INTO `t_pub_city` VALUES ('2523', '371082', '荣成', '3', '0', '183', '山东', '威海', '荣成', 'RC', null);
INSERT INTO `t_pub_city` VALUES ('2524', '371102', '东港区', '3', '0', '80', '山东', '日照', '东港区', 'DGQ', null);
INSERT INTO `t_pub_city` VALUES ('2525', '371121', '五莲县', '3', '0', '80', '山东', '日照', '五莲县', 'WLX', null);
INSERT INTO `t_pub_city` VALUES ('2526', '371202', '莱城区', '3', '0', '184', '山东', '莱芜', '莱城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2527', '371302', '兰山区', '3', '0', '81', '山东', '临沂', '兰山区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2528', '371312', '河东区', '3', '0', '81', '山东', '临沂', '河东区', 'HDQ', null);
INSERT INTO `t_pub_city` VALUES ('2529', '371322', '郯城县', '3', '0', '81', '山东', '临沂', '郯城县', 'TCX', null);
INSERT INTO `t_pub_city` VALUES ('2530', '371324', '兰陵县', '3', '0', '81', '山东', '临沂', '兰陵县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('2531', '371327', '莒南县', '3', '0', '81', '山东', '临沂', '莒南县', 'JNX', null);
INSERT INTO `t_pub_city` VALUES ('2532', '371329', '临沭县', '3', '0', '81', '山东', '临沂', '临沭县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2533', '371403', '陵城区', '3', '0', '185', '山东', '德州', '陵城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2534', '371423', '庆云县', '3', '0', '185', '山东', '德州', '庆云县', 'QYX', null);
INSERT INTO `t_pub_city` VALUES ('2535', '371425', '齐河县', '3', '0', '185', '山东', '德州', '齐河县', 'JHX', null);
INSERT INTO `t_pub_city` VALUES ('2536', '371427', '夏津县', '3', '0', '185', '山东', '德州', '夏津县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('2537', '371481', '乐陵', '3', '0', '185', '山东', '德州', '乐陵', 'LL', null);
INSERT INTO `t_pub_city` VALUES ('2538', '371502', '东昌府区', '3', '0', '186', '山东', '聊城', '东昌府区', 'DCFQ', null);
INSERT INTO `t_pub_city` VALUES ('2539', '371522', '莘县', '3', '0', '186', '山东', '聊城', '莘县', 'SX', null);
INSERT INTO `t_pub_city` VALUES ('2540', '371524', '东阿县', '3', '0', '186', '山东', '聊城', '东阿县', 'DAX', null);
INSERT INTO `t_pub_city` VALUES ('2541', '371526', '高唐县', '3', '0', '186', '山东', '聊城', '高唐县', 'GTX', null);
INSERT INTO `t_pub_city` VALUES ('2542', '371602', '滨城区', '3', '0', '82', '山东', '滨州', '滨城区', 'BCQ', null);
INSERT INTO `t_pub_city` VALUES ('2543', '371621', '惠民县', '3', '0', '82', '山东', '滨州', '惠民县', 'HMX', null);
INSERT INTO `t_pub_city` VALUES ('2544', '371623', '无棣县', '3', '0', '82', '山东', '滨州', '无棣县', 'MDX', null);
INSERT INTO `t_pub_city` VALUES ('2545', '371702', '牡丹区', '3', '0', '187', '山东', '菏泽', '牡丹区', 'MDQ', null);
INSERT INTO `t_pub_city` VALUES ('2546', '371721', '曹县', '3', '0', '187', '山东', '菏泽', '曹县', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('2547', '371723', '成武县', '3', '0', '187', '山东', '菏泽', '成武县', 'CWX', null);
INSERT INTO `t_pub_city` VALUES ('2548', '371725', '郓城县', '3', '0', '187', '山东', '菏泽', '郓城县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2549', '371728', '东明县', '3', '0', '187', '山东', '菏泽', '东明县', 'DMX', null);
INSERT INTO `t_pub_city` VALUES ('2550', '410103', '二七区', '3', '0', '83', '河南', '郑州', '二七区', 'EQQ', null);
INSERT INTO `t_pub_city` VALUES ('2551', '410105', '金水区', '3', '0', '83', '河南', '郑州', '金水区', 'JSQ', null);
INSERT INTO `t_pub_city` VALUES ('2552', '410108', '惠济区', '3', '0', '83', '河南', '郑州', '惠济区', 'HJQ', null);
INSERT INTO `t_pub_city` VALUES ('2553', '410181', '巩义', '3', '0', '83', '河南', '郑州', '巩义', 'GY', null);
INSERT INTO `t_pub_city` VALUES ('2554', '410183', '新密', '3', '0', '83', '河南', '郑州', '新密', 'XM', null);
INSERT INTO `t_pub_city` VALUES ('2555', '410185', '登封', '3', '0', '83', '河南', '郑州', '登封', 'DF', null);
INSERT INTO `t_pub_city` VALUES ('2556', '410203', '顺河回族区', '3', '0', '188', '河南', '开封', '顺河回族区', 'SHHZQ', null);
INSERT INTO `t_pub_city` VALUES ('2557', '410212', '祥符区', '3', '0', '188', '河南', '开封', '祥符区', 'XFQ', null);
INSERT INTO `t_pub_city` VALUES ('2558', '410222', '通许县', '3', '0', '188', '河南', '开封', '通许县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('2559', '410225', '兰考县', '3', '0', '188', '河南', '开封', '兰考县', 'LKX', null);
INSERT INTO `t_pub_city` VALUES ('2560', '410303', '西工区', '3', '0', '84', '河南', '洛阳', '西工区', 'XGQ', null);
INSERT INTO `t_pub_city` VALUES ('2561', '410305', '涧西区', '3', '0', '84', '河南', '洛阳', '涧西区', 'JXQ', null);
INSERT INTO `t_pub_city` VALUES ('2562', '410311', '洛龙区', '3', '0', '84', '河南', '洛阳', '洛龙区', 'LLQ', null);
INSERT INTO `t_pub_city` VALUES ('2563', '410324', '栾川县', '3', '0', '84', '河南', '洛阳', '栾川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('2564', '410326', '汝阳县', '3', '0', '84', '河南', '洛阳', '汝阳县', 'RYX', null);
INSERT INTO `t_pub_city` VALUES ('2565', '410329', '伊川县', '3', '0', '84', '河南', '洛阳', '伊川县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2566', '410402', '新华区', '3', '0', '189', '河南', '平顶山', '新华区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('2567', '410411', '湛河区', '3', '0', '189', '河南', '平顶山', '湛河区', 'ZHQ', null);
INSERT INTO `t_pub_city` VALUES ('2568', '410422', '叶县', '3', '0', '189', '河南', '平顶山', '叶县', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('2569', '410481', '舞钢', '3', '0', '189', '河南', '平顶山', '舞钢', 'WG', null);
INSERT INTO `t_pub_city` VALUES ('2570', '410502', '文峰区', '3', '0', '85', '河南', '安阳', '文峰区', 'WFQ', null);
INSERT INTO `t_pub_city` VALUES ('2571', '410506', '龙安区', '3', '0', '85', '河南', '安阳', '龙安区', 'LAQ', null);
INSERT INTO `t_pub_city` VALUES ('2572', '410523', '汤阴县', '3', '0', '85', '河南', '安阳', '汤阴县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('2573', '410581', '林州', '3', '0', '85', '河南', '安阳', '林州', 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('2574', '410611', '淇滨区', '3', '0', '190', '河南', '鹤壁', '淇滨区', 'QBQ', null);
INSERT INTO `t_pub_city` VALUES ('2575', '410622', '淇县', '3', '0', '190', '河南', '鹤壁', '淇县', 'QX', null);
INSERT INTO `t_pub_city` VALUES ('2576', '410704', '凤泉区', '3', '0', '191', '河南', '新乡', '凤泉区', 'FQQ', null);
INSERT INTO `t_pub_city` VALUES ('2577', '410721', '新乡县', '3', '0', '191', '河南', '新乡', '新乡县', 'XXX', null);
INSERT INTO `t_pub_city` VALUES ('2578', '410726', '延津县', '3', '0', '191', '河南', '新乡', '延津县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('2579', '130102', '长安区', '3', '0', '192', '河北', '石家庄', '长安区', 'CAQ', null);
INSERT INTO `t_pub_city` VALUES ('2580', '130104', '桥西区', '3', '0', '192', '河北', '石家庄', '桥西区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('2581', '130107', '井陉矿区', '3', '0', '192', '河北', '石家庄', '井陉矿区', 'JJKQ', null);
INSERT INTO `t_pub_city` VALUES ('2582', '130109', '藁城区', '3', '0', '192', '河北', '石家庄', '藁城区', 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('2583', '130111', '栾城区', '3', '0', '192', '河北', '石家庄', '栾城区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2584', '130123', '正定县', '3', '0', '192', '河北', '石家庄', '正定县', 'ZDX', null);
INSERT INTO `t_pub_city` VALUES ('2585', '130126', '灵寿县', '3', '0', '192', '河北', '石家庄', '灵寿县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2586', '130127', '高邑县', '3', '0', '192', '河北', '石家庄', '高邑县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('2587', '130129', '赞皇县', '3', '0', '192', '河北', '石家庄', '赞皇县', 'ZHX', null);
INSERT INTO `t_pub_city` VALUES ('2588', '130131', '平山县', '3', '0', '192', '河北', '石家庄', '平山县', 'PSX', null);
INSERT INTO `t_pub_city` VALUES ('2589', '130133', '赵县', '3', '0', '192', '河北', '石家庄', '赵县', 'ZX', null);
INSERT INTO `t_pub_city` VALUES ('2590', '130183', '晋州', '3', '0', '192', '河北', '石家庄', '晋州', 'JZ', null);
INSERT INTO `t_pub_city` VALUES ('2591', '130202', '路南区', '3', '0', '102', '河北', '唐山', '路南区', 'LNQ', null);
INSERT INTO `t_pub_city` VALUES ('2592', '130203', '路北区', '3', '0', '102', '河北', '唐山', '路北区', 'LBQ', null);
INSERT INTO `t_pub_city` VALUES ('2593', '130205', '开平区', '3', '0', '102', '河北', '唐山', '开平区', 'KPQ', null);
INSERT INTO `t_pub_city` VALUES ('2594', '130208', '丰润区', '3', '0', '102', '河北', '唐山', '丰润区', 'FRQ', null);
INSERT INTO `t_pub_city` VALUES ('2595', '130223', '滦县', '3', '0', '102', '河北', '唐山', '滦县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('2596', '130225', '乐亭县', '3', '0', '102', '河北', '唐山', '乐亭县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('2597', '130229', '玉田县', '3', '0', '102', '河北', '唐山', '玉田县', 'YTX', null);
INSERT INTO `t_pub_city` VALUES ('2598', '130283', '迁安', '3', '0', '102', '河北', '唐山', '迁安', 'QA', null);
INSERT INTO `t_pub_city` VALUES ('2599', '130303', '山海关区', '3', '0', '193', '河北', '秦皇岛', '山海关区', 'SHGQ', null);
INSERT INTO `t_pub_city` VALUES ('2600', '130306', '抚宁区', '3', '0', '193', '河北', '秦皇岛', '抚宁区', 'FNQ', null);
INSERT INTO `t_pub_city` VALUES ('2601', '130322', '昌黎县', '3', '0', '193', '河北', '秦皇岛', '昌黎县', 'CLX', null);
INSERT INTO `t_pub_city` VALUES ('2602', '130324', '卢龙县', '3', '0', '193', '河北', '秦皇岛', '卢龙县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('2603', '130403', '丛台区', '3', '0', '103', '河北', '邯郸', '丛台区', 'CTQ', null);
INSERT INTO `t_pub_city` VALUES ('2604', '130406', '峰峰矿区', '3', '0', '103', '河北', '邯郸', '峰峰矿区', 'FFKQ', null);
INSERT INTO `t_pub_city` VALUES ('2605', '130423', '临漳县', '3', '0', '103', '河北', '邯郸', '临漳县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('2606', '130425', '大名县', '3', '0', '103', '河北', '邯郸', '大名县', 'DMX', null);
INSERT INTO `t_pub_city` VALUES ('2607', '130427', '磁县', '3', '0', '103', '河北', '邯郸', '磁县', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('2608', '130429', '永年县', '3', '0', '103', '河北', '邯郸', '永年县', 'YNX', null);
INSERT INTO `t_pub_city` VALUES ('2609', '130432', '广平县', '3', '0', '103', '河北', '邯郸', '广平县', 'APX', null);
INSERT INTO `t_pub_city` VALUES ('2610', '130434', '魏县', '3', '0', '103', '河北', '邯郸', '魏县', 'WX', null);
INSERT INTO `t_pub_city` VALUES ('2611', '130481', '武安', '3', '0', '103', '河北', '邯郸', '武安', 'WA', null);
INSERT INTO `t_pub_city` VALUES ('2612', '130503', '桥西区', '3', '0', '194', '河北', '邢台', '桥西区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('2613', '130522', '临城县', '3', '0', '194', '河北', '邢台', '临城县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('2614', '130524', '柏乡县', '3', '0', '194', '河北', '邢台', '柏乡县', 'BXX', null);
INSERT INTO `t_pub_city` VALUES ('2615', '130526', '任县', '3', '0', '194', '河北', '邢台', '任县', 'RX', null);
INSERT INTO `t_pub_city` VALUES ('2616', '130528', '宁晋县', '3', '0', '194', '河北', '邢台', '宁晋县', 'NJX', null);
INSERT INTO `t_pub_city` VALUES ('2617', '130530', '新河县', '3', '0', '194', '河北', '邢台', '新河县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2618', '130532', '平乡县', '3', '0', '194', '河北', '邢台', '平乡县', 'PXX', null);
INSERT INTO `t_pub_city` VALUES ('2619', '130534', '清河县', '3', '0', '194', '河北', '邢台', '清河县', 'QHX', null);
INSERT INTO `t_pub_city` VALUES ('2620', '130581', '南宫', '3', '0', '194', '河北', '邢台', '南宫', 'NG', null);
INSERT INTO `t_pub_city` VALUES ('2621', '130602', '竞秀区', '3', '0', '104', '河北', '保定', '竞秀区', 'JXQ', null);
INSERT INTO `t_pub_city` VALUES ('2622', '130606', '莲池区', '3', '0', '104', '河北', '保定', '莲池区', 'LCQ', null);
INSERT INTO `t_pub_city` VALUES ('2623', '130609', '徐水区', '3', '0', '104', '河北', '保定', '徐水区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('2624', '130624', '阜平县', '3', '0', '104', '河北', '保定', '阜平县', 'FPX', null);
INSERT INTO `t_pub_city` VALUES ('2625', '130627', '唐县', '3', '0', '104', '河北', '保定', '唐县', 'TX', null);
INSERT INTO `t_pub_city` VALUES ('2626', '130629', '容城县', '3', '0', '104', '河北', '保定', '容城县', 'RCX', null);
INSERT INTO `t_pub_city` VALUES ('2627', '130631', '望都县', '3', '0', '104', '河北', '保定', '望都县', 'WDX', null);
INSERT INTO `t_pub_city` VALUES ('2628', '130633', '易县', '3', '0', '104', '河北', '保定', '易县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('2629', '130635', '蠡县', '3', '0', '104', '河北', '保定', '蠡县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('2630', '620123', '榆中县', '3', '0', '298', '甘肃', '兰州', '榆中县', 'YZX', null);
INSERT INTO `t_pub_city` VALUES ('2631', '620321', '永昌县', '3', '0', '299', '甘肃', '金昌', '永昌县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2632', '620403', '平川区', '3', '0', '399', '甘肃', '白银', '平川区', 'PCQ', null);
INSERT INTO `t_pub_city` VALUES ('2633', '620422', '会宁县', '3', '0', '399', '甘肃', '白银', '会宁县', 'HNX', null);
INSERT INTO `t_pub_city` VALUES ('2634', '620503', '麦积区', '3', '0', '300', '甘肃', '天水', '麦积区', 'MJQ', null);
INSERT INTO `t_pub_city` VALUES ('2635', '620522', '秦安县', '3', '0', '300', '甘肃', '天水', '秦安县', 'QAX', null);
INSERT INTO `t_pub_city` VALUES ('2636', '620524', '武山县', '3', '0', '300', '甘肃', '天水', '武山县', 'WSX', null);
INSERT INTO `t_pub_city` VALUES ('2637', '620602', '凉州区', '3', '0', '301', '甘肃', '武威', '凉州区', 'LZQ', null);
INSERT INTO `t_pub_city` VALUES ('2638', '620622', '古浪县', '3', '0', '301', '甘肃', '武威', '古浪县', 'GLX', null);
INSERT INTO `t_pub_city` VALUES ('2639', '620702', '甘州区', '3', '0', '400', '甘肃', '张掖', '甘州区', 'GZQ', null);
INSERT INTO `t_pub_city` VALUES ('2640', '620722', '民乐县', '3', '0', '400', '甘肃', '张掖', '民乐县', 'MLX', null);
INSERT INTO `t_pub_city` VALUES ('2641', '620724', '高台县', '3', '0', '400', '甘肃', '张掖', '高台县', 'GTX', null);
INSERT INTO `t_pub_city` VALUES ('2642', '620802', '崆峒区', '3', '0', '302', '甘肃', '平凉', '崆峒区', 'KDQ', null);
INSERT INTO `t_pub_city` VALUES ('2643', '620822', '灵台县', '3', '0', '302', '甘肃', '平凉', '灵台县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('2644', '620824', '华亭县', '3', '0', '302', '甘肃', '平凉', '华亭县', 'HTX', null);
INSERT INTO `t_pub_city` VALUES ('2645', '620826', '静宁县', '3', '0', '302', '甘肃', '平凉', '静宁县', 'JNX', null);
INSERT INTO `t_pub_city` VALUES ('2646', '620921', '金塔县', '3', '0', '401', '甘肃', '酒泉', '金塔县', 'JDX', null);
INSERT INTO `t_pub_city` VALUES ('2647', '620923', '肃北蒙古族自治县', '3', '0', '401', '甘肃', '酒泉', '肃北蒙古族自治县', 'SBMGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2648', '620982', '敦煌', '3', '0', '401', '甘肃', '酒泉', '敦煌', 'DH', null);
INSERT INTO `t_pub_city` VALUES ('2649', '621021', '庆城县', '3', '0', '303', '甘肃', '庆阳', '庆城县', 'QCX', null);
INSERT INTO `t_pub_city` VALUES ('2650', '621023', '华池县', '3', '0', '303', '甘肃', '庆阳', '华池县', 'HCX', null);
INSERT INTO `t_pub_city` VALUES ('2651', '621025', '正宁县', '3', '0', '303', '甘肃', '庆阳', '正宁县', 'ZNX', null);
INSERT INTO `t_pub_city` VALUES ('2652', '621102', '安定区', '3', '0', '402', '甘肃', '定西', '安定区', 'ADQ', null);
INSERT INTO `t_pub_city` VALUES ('2653', '621122', '陇西县', '3', '0', '402', '甘肃', '定西', '陇西县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('2654', '621124', '临洮县', '3', '0', '402', '甘肃', '定西', '临洮县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('2655', '621126', '岷县', '3', '0', '402', '甘肃', '定西', '岷县', 'MX', null);
INSERT INTO `t_pub_city` VALUES ('2656', '621221', '成县', '3', '0', '304', '甘肃', '陇南', '成县', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('2657', '621223', '宕昌县', '3', '0', '304', '甘肃', '陇南', '宕昌县', 'DCX', null);
INSERT INTO `t_pub_city` VALUES ('2658', '621225', '西和县', '3', '0', '304', '甘肃', '陇南', '西和县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2659', '621227', '徽县', '3', '0', '304', '甘肃', '陇南', '徽县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('2660', '622901', '临夏', '3', '0', '305', '甘肃', '临夏回族自治州', '临夏', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('2661', '622921', '临夏县', '3', '0', '305', '甘肃', '临夏回族自治州', '临夏县', 'LXX', null);
INSERT INTO `t_pub_city` VALUES ('2662', '622923', '永靖县', '3', '0', '305', '甘肃', '临夏回族自治州', '永靖县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('2663', '622925', '和政县', '3', '0', '305', '甘肃', '临夏回族自治州', '和政县', 'HZX', null);
INSERT INTO `t_pub_city` VALUES ('2664', '622926', '东乡族自治县', '3', '0', '305', '甘肃', '临夏回族自治州', '东乡族自治县', 'DXZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2665', '623001', '合作', '3', '0', '403', '甘肃', '甘南藏族自治州', '合作', 'GZ', null);
INSERT INTO `t_pub_city` VALUES ('2666', '623022', '卓尼县', '3', '0', '403', '甘肃', '甘南藏族自治州', '卓尼县', 'ZNX', null);
INSERT INTO `t_pub_city` VALUES ('2667', '623024', '迭部县', '3', '0', '403', '甘肃', '甘南藏族自治州', '迭部县', 'DBX', null);
INSERT INTO `t_pub_city` VALUES ('2668', '623025', '玛曲县', '3', '0', '403', '甘肃', '甘南藏族自治州', '玛曲县', 'MQX', null);
INSERT INTO `t_pub_city` VALUES ('2669', '623027', '夏河县', '3', '0', '403', '甘肃', '甘南藏族自治州', '夏河县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2670', '630103', '城中区', '3', '0', '404', '青海', '西宁', '城中区', 'CZQ', null);
INSERT INTO `t_pub_city` VALUES ('2671', '630105', '城北区', '3', '0', '404', '青海', '西宁', '城北区', 'CBQ', null);
INSERT INTO `t_pub_city` VALUES ('2672', '630123', '湟源县', '3', '0', '404', '青海', '西宁', '湟源县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('2673', '630203', '平安区', '3', '0', '306', '青海', '海东', '平安区', 'PAQ', null);
INSERT INTO `t_pub_city` VALUES ('2674', '630223', '互助土族自治县', '3', '0', '306', '青海', '海东', '互助土族自治县', 'HZTZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2675', '630225', '循化撒拉族自治县', '3', '0', '306', '青海', '海东', '循化撒拉族自治县', 'XHSLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2676', '632222', '祁连县', '3', '0', '405', '青海', '海北藏族自治州', '祁连县', 'QLX', null);
INSERT INTO `t_pub_city` VALUES ('2677', '632224', '刚察县', '3', '0', '405', '青海', '海北藏族自治州', '刚察县', 'GCX', null);
INSERT INTO `t_pub_city` VALUES ('2678', '632322', '尖扎县', '3', '0', '307', '青海', '黄南藏族自治州', '尖扎县', 'JZX', null);
INSERT INTO `t_pub_city` VALUES ('2679', '632323', '泽库县', '3', '0', '307', '青海', '黄南藏族自治州', '泽库县', 'ZKX', null);
INSERT INTO `t_pub_city` VALUES ('2680', '632521', '共和县', '3', '0', '406', '青海', '海南藏族自治州', '共和县', 'GHX', null);
INSERT INTO `t_pub_city` VALUES ('2681', '632523', '贵德县', '3', '0', '406', '青海', '海南藏族自治州', '贵德县', 'GDX', null);
INSERT INTO `t_pub_city` VALUES ('2682', '632524', '兴海县', '3', '0', '406', '青海', '海南藏族自治州', '兴海县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2683', '632621', '玛沁县', '3', '0', '308', '青海', '果洛藏族自治州', '玛沁县', 'MQX', null);
INSERT INTO `t_pub_city` VALUES ('2684', '632623', '甘德县', '3', '0', '308', '青海', '果洛藏族自治州', '甘德县', 'GDX', null);
INSERT INTO `t_pub_city` VALUES ('2685', '632624', '达日县', '3', '0', '308', '青海', '果洛藏族自治州', '达日县', 'DRX', null);
INSERT INTO `t_pub_city` VALUES ('2686', '632626', '玛多县', '3', '0', '308', '青海', '果洛藏族自治州', '玛多县', 'MDX', null);
INSERT INTO `t_pub_city` VALUES ('2687', '632722', '杂多县', '3', '0', '407', '青海', '玉树藏族自治州', '杂多县', 'ZDX', null);
INSERT INTO `t_pub_city` VALUES ('2688', '632723', '称多县', '3', '0', '407', '青海', '玉树藏族自治州', '称多县', 'CDX', null);
INSERT INTO `t_pub_city` VALUES ('2689', '632725', '囊谦县', '3', '0', '407', '青海', '玉树藏族自治州', '囊谦县', 'NQX', null);
INSERT INTO `t_pub_city` VALUES ('2690', '632801', '格尔木', '3', '0', '309', '青海', '海西蒙古族藏族自治州', '格尔木', 'GEM', null);
INSERT INTO `t_pub_city` VALUES ('2691', '632802', '德令哈', '3', '0', '309', '青海', '海西蒙古族藏族自治州', '德令哈', 'DLH', null);
INSERT INTO `t_pub_city` VALUES ('2692', '632822', '都兰县', '3', '0', '309', '青海', '海西蒙古族藏族自治州', '都兰县', 'DLX', null);
INSERT INTO `t_pub_city` VALUES ('2693', '632823', '天峻县', '3', '0', '309', '青海', '海西蒙古族藏族自治州', '天峻县', 'TJX', null);
INSERT INTO `t_pub_city` VALUES ('2694', '640106', '金凤区', '3', '0', '408', '宁夏回族自治区', '银川', '金凤区', 'JFQ', null);
INSERT INTO `t_pub_city` VALUES ('2695', '640122', '贺兰县', '3', '0', '408', '宁夏回族自治区', '银川', '贺兰县', 'HLX', null);
INSERT INTO `t_pub_city` VALUES ('2696', '640202', '大武口区', '3', '0', '310', '宁夏回族自治区', '石嘴山', '大武口区', 'DWKQ', null);
INSERT INTO `t_pub_city` VALUES ('2697', '640221', '平罗县', '3', '0', '310', '宁夏回族自治区', '石嘴山', '平罗县', 'PLX', null);
INSERT INTO `t_pub_city` VALUES ('2698', '640323', '盐池县', '3', '0', '409', '宁夏回族自治区', '吴忠', '盐池县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2699', '640381', '青铜峡', '3', '0', '409', '宁夏回族自治区', '吴忠', '青铜峡', 'QTX', null);
INSERT INTO `t_pub_city` VALUES ('2700', '640422', '西吉县', '3', '0', '311', '宁夏回族自治区', '固原', '西吉县', 'XJX', null);
INSERT INTO `t_pub_city` VALUES ('2701', '640424', '泾源县', '3', '0', '311', '宁夏回族自治区', '固原', '泾源县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('2702', '640502', '沙坡头区', '3', '0', '312', '宁夏回族自治区', '中卫', '沙坡头区', 'SPTQ', null);
INSERT INTO `t_pub_city` VALUES ('2703', '650102', '天山区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '天山区', 'TSQ', null);
INSERT INTO `t_pub_city` VALUES ('2704', '650104', '新市区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '新市区', 'XSQ', null);
INSERT INTO `t_pub_city` VALUES ('2705', '650107', '达坂城区', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '达坂城区', 'DBCQ', null);
INSERT INTO `t_pub_city` VALUES ('2706', '650121', '乌鲁木齐县', '3', '0', '410', '新疆维吾尔自治区', '乌鲁木齐', '乌鲁木齐县', 'WLMJX', null);
INSERT INTO `t_pub_city` VALUES ('2707', '650203', '克拉玛依区', '3', '0', '313', '新疆维吾尔自治区', '克拉玛依', '克拉玛依区', 'KLMYQ', null);
INSERT INTO `t_pub_city` VALUES ('2708', '650402', '高昌区', '3', '0', '314', '新疆维吾尔自治区', '吐鲁番', '高昌区', 'GCQ', null);
INSERT INTO `t_pub_city` VALUES ('2709', '650422', '托克逊县', '3', '0', '314', '新疆维吾尔自治区', '吐鲁番', '托克逊县', 'TKXX', null);
INSERT INTO `t_pub_city` VALUES ('2710', '650522', '伊吾县', '3', '0', null, null, null, '伊吾县', 'YWX', null);
INSERT INTO `t_pub_city` VALUES ('2711', '652301', '昌吉', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '昌吉', 'CJ', null);
INSERT INTO `t_pub_city` VALUES ('2712', '652324', '玛纳斯县', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '玛纳斯县', 'MNSX', null);
INSERT INTO `t_pub_city` VALUES ('2713', '652327', '吉木萨尔县', '3', '0', '315', '新疆维吾尔自治区', '昌吉回族自治州', '吉木萨尔县', 'JMSEX', null);
INSERT INTO `t_pub_city` VALUES ('2714', '659002', '阿拉尔', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '阿拉尔', 'ALE', null);
INSERT INTO `t_pub_city` VALUES ('2715', '659004', '五家渠', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '五家渠', 'WJQ', null);
INSERT INTO `t_pub_city` VALUES ('2716', '659006', '铁门关', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '铁门关', 'TMG', null);
INSERT INTO `t_pub_city` VALUES ('2717', '659008', '可克达拉', '3', '0', '134', '新疆维吾尔自治区', '阿勒泰地区', '可克达拉', 'KKDL', null);
INSERT INTO `t_pub_city` VALUES ('2718', '429004', '仙桃', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '仙桃', 'XT', null);
INSERT INTO `t_pub_city` VALUES ('2719', '429006', '天门', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '天门', 'TM', null);
INSERT INTO `t_pub_city` VALUES ('2720', '429021', '神农架林区', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '神农架林区', 'SNJLQ', null);
INSERT INTO `t_pub_city` VALUES ('2721', '469005', '文昌', '3', '0', '347', '海南', '三沙', '文昌', 'WC', null);
INSERT INTO `t_pub_city` VALUES ('2722', '469007', '东方', '3', '0', '347', '海南', '三沙', '东方', 'DF', null);
INSERT INTO `t_pub_city` VALUES ('2723', '469022', '屯昌县', '3', '0', '347', '海南', '三沙', '屯昌县', 'TCX', null);
INSERT INTO `t_pub_city` VALUES ('2724', '469025', '白沙黎族自治县', '3', '0', '347', '海南', '三沙', '白沙黎族自治县', 'BSLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2725', '469027', '乐东黎族自治县', '3', '0', '347', '海南', '三沙', '乐东黎族自治县', 'LDLZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2726', '420303', '张湾区', '3', '0', '229', '湖北', '十堰', '张湾区', 'ZWQ', null);
INSERT INTO `t_pub_city` VALUES ('2727', '420323', '竹山县', '3', '0', '229', '湖北', '十堰', '竹山县', 'ZSX', null);
INSERT INTO `t_pub_city` VALUES ('2728', '420325', '房县', '3', '0', '229', '湖北', '十堰', '房县', 'FX', null);
INSERT INTO `t_pub_city` VALUES ('2729', '420502', '西陵区', '3', '0', '321', '湖北', '宜昌', '西陵区', 'XLQ', null);
INSERT INTO `t_pub_city` VALUES ('2730', '420504', '点军区', '3', '0', '321', '湖北', '宜昌', '点军区', 'DJQ', null);
INSERT INTO `t_pub_city` VALUES ('2731', '420506', '夷陵区', '3', '0', '321', '湖北', '宜昌', '夷陵区', 'YLQ', null);
INSERT INTO `t_pub_city` VALUES ('2732', '420526', '兴山县', '3', '0', '321', '湖北', '宜昌', '兴山县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('2733', '420528', '长阳土家族自治县', '3', '0', '321', '湖北', '宜昌', '长阳土家族自治县', 'CYTJZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2734', '420582', '当阳', '3', '0', '321', '湖北', '宜昌', '当阳', 'DY', null);
INSERT INTO `t_pub_city` VALUES ('2735', '420602', '襄城区', '3', '0', '230', '湖北', '襄阳', '襄城区', 'XCQ', null);
INSERT INTO `t_pub_city` VALUES ('2736', '420607', '襄州区', '3', '0', '230', '湖北', '襄阳', '襄州区', 'XZQ', null);
INSERT INTO `t_pub_city` VALUES ('2737', '420625', '谷城县', '3', '0', '230', '湖北', '襄阳', '谷城县', 'GCX', null);
INSERT INTO `t_pub_city` VALUES ('2738', '420682', '老河口', '3', '0', '230', '湖北', '襄阳', '老河口', 'LHK', null);
INSERT INTO `t_pub_city` VALUES ('2739', '420684', '宜城', '3', '0', '230', '湖北', '襄阳', '宜城', 'YC', null);
INSERT INTO `t_pub_city` VALUES ('2740', '420703', '华容区', '3', '0', '322', '湖北', '鄂州', '华容区', 'HRQ', null);
INSERT INTO `t_pub_city` VALUES ('2741', '420802', '东宝区', '3', '0', '231', '湖北', '荆门', '东宝区', 'DBQ', null);
INSERT INTO `t_pub_city` VALUES ('2742', '420821', '京山县', '3', '0', '231', '湖北', '荆门', '京山县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('2743', '420881', '钟祥', '3', '0', '231', '湖北', '荆门', '钟祥', 'ZX', null);
INSERT INTO `t_pub_city` VALUES ('2744', '420921', '孝昌县', '3', '0', '323', '湖北', '孝感', '孝昌县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('2745', '420981', '应城', '3', '0', '323', '湖北', '孝感', '应城', 'YC', null);
INSERT INTO `t_pub_city` VALUES ('2746', '420984', '汉川', '3', '0', '323', '湖北', '孝感', '汉川', 'HC', null);
INSERT INTO `t_pub_city` VALUES ('2747', '421003', '荆州区', '3', '0', '232', '湖北', '荆州', '荆州区', 'JZQ', null);
INSERT INTO `t_pub_city` VALUES ('2748', '421023', '监利县', '3', '0', '232', '湖北', '荆州', '监利县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('2749', '421081', '石首', '3', '0', '232', '湖北', '荆州', '石首', 'SS', null);
INSERT INTO `t_pub_city` VALUES ('2750', '421087', '松滋', '3', '0', '232', '湖北', '荆州', '松滋', 'SZ', null);
INSERT INTO `t_pub_city` VALUES ('2751', '421121', '团风县', '3', '0', '324', '湖北', '黄冈', '团风县', 'TFX', null);
INSERT INTO `t_pub_city` VALUES ('2752', '421123', '罗田县', '3', '0', '324', '湖北', '黄冈', '罗田县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('2753', '421125', '浠水县', '3', '0', '324', '湖北', '黄冈', '浠水县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('2754', '421127', '黄梅县', '3', '0', '324', '湖北', '黄冈', '黄梅县', 'HMX', null);
INSERT INTO `t_pub_city` VALUES ('2755', '421182', '武穴', '3', '0', '324', '湖北', '黄冈', '武穴', 'WX', null);
INSERT INTO `t_pub_city` VALUES ('2756', '421221', '嘉鱼县', '3', '0', '233', '湖北', '咸宁', '嘉鱼县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('2757', '421223', '崇阳县', '3', '0', '233', '湖北', '咸宁', '崇阳县', 'CYX', null);
INSERT INTO `t_pub_city` VALUES ('2758', '421281', '赤壁', '3', '0', '233', '湖北', '咸宁', '赤壁', 'CB', null);
INSERT INTO `t_pub_city` VALUES ('2759', '421381', '广水', '3', '0', '234', '湖北', '随州', '广水', 'AS', null);
INSERT INTO `t_pub_city` VALUES ('2760', '422801', '恩施', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '恩施', 'ES', null);
INSERT INTO `t_pub_city` VALUES ('2761', '422822', '建始县', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '建始县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('2762', '422823', '巴东县', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '巴东县', 'BDX', null);
INSERT INTO `t_pub_city` VALUES ('2763', '422826', '咸丰县', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '咸丰县', 'XFX', null);
INSERT INTO `t_pub_city` VALUES ('2764', '422827', '来凤县', '3', '0', '325', '湖北', '恩施土家族苗族自治州', '来凤县', 'LFX', null);
INSERT INTO `t_pub_city` VALUES ('2765', '430102', '芙蓉区', '3', '0', '235', '湖南', '长沙', '芙蓉区', 'FRQ', null);
INSERT INTO `t_pub_city` VALUES ('2766', '430104', '岳麓区', '3', '0', '235', '湖南', '长沙', '岳麓区', 'YLQ', null);
INSERT INTO `t_pub_city` VALUES ('2767', '430111', '雨花区', '3', '0', '235', '湖南', '长沙', '雨花区', 'YHQ', '1');
INSERT INTO `t_pub_city` VALUES ('2768', '430121', '长沙县', '3', '0', '235', '湖南', '长沙', '长沙县', 'CSX', null);
INSERT INTO `t_pub_city` VALUES ('2769', '430181', '浏阳', '3', '0', '235', '湖南', '长沙', '浏阳', 'LY', null);
INSERT INTO `t_pub_city` VALUES ('2770', '430203', '芦淞区', '3', '0', '326', '湖南', '株洲', '芦淞区', 'LSQ', null);
INSERT INTO `t_pub_city` VALUES ('2771', '430211', '天元区', '3', '0', '326', '湖南', '株洲', '天元区', 'TYQ', null);
INSERT INTO `t_pub_city` VALUES ('2772', '430223', '攸县', '3', '0', '326', '湖南', '株洲', '攸县', 'YX', null);
INSERT INTO `t_pub_city` VALUES ('2773', '430225', '炎陵县', '3', '0', '326', '湖南', '株洲', '炎陵县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('2774', '430302', '雨湖区', '3', '0', '236', '湖南', '湘潭', '雨湖区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('2775', '430381', '湘乡', '3', '0', '236', '湖南', '湘潭', '湘乡', 'XX', null);
INSERT INTO `t_pub_city` VALUES ('2776', '430405', '珠晖区', '3', '0', '327', '湖南', '衡阳', '珠晖区', 'ZHQ', null);
INSERT INTO `t_pub_city` VALUES ('2777', '430407', '石鼓区', '3', '0', '327', '湖南', '衡阳', '石鼓区', 'SGQ', null);
INSERT INTO `t_pub_city` VALUES ('2778', '430412', '南岳区', '3', '0', '327', '湖南', '衡阳', '南岳区', 'NYQ', null);
INSERT INTO `t_pub_city` VALUES ('2779', '430422', '衡南县', '3', '0', '327', '湖南', '衡阳', '衡南县', 'HNX', null);
INSERT INTO `t_pub_city` VALUES ('2780', '430424', '衡东县', '3', '0', '327', '湖南', '衡阳', '衡东县', 'HDX', null);
INSERT INTO `t_pub_city` VALUES ('2781', '430481', '耒阳', '3', '0', '327', '湖南', '衡阳', '耒阳', 'LY', null);
INSERT INTO `t_pub_city` VALUES ('2782', '430502', '双清区', '3', '0', '237', '湖南', '邵阳', '双清区', 'SQQ', null);
INSERT INTO `t_pub_city` VALUES ('2783', '430511', '北塔区', '3', '0', '237', '湖南', '邵阳', '北塔区', 'BDQ', null);
INSERT INTO `t_pub_city` VALUES ('2784', '430522', '新邵县', '3', '0', '237', '湖南', '邵阳', '新邵县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('2785', '430524', '隆回县', '3', '0', '237', '湖南', '邵阳', '隆回县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('2786', '430527', '绥宁县', '3', '0', '237', '湖南', '邵阳', '绥宁县', 'SNX', null);
INSERT INTO `t_pub_city` VALUES ('2787', '430529', '城步苗族自治县', '3', '0', '237', '湖南', '邵阳', '城步苗族自治县', 'CBMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2788', '430611', '君山区', '3', '0', '238', '湖南', '岳阳', '君山区', 'JSQ', null);
INSERT INTO `t_pub_city` VALUES ('2789', '430623', '华容县', '3', '0', '238', '湖南', '岳阳', '华容县', 'HRX', null);
INSERT INTO `t_pub_city` VALUES ('2790', '430681', '汨罗', '3', '0', '238', '湖南', '岳阳', '汨罗', 'ML', null);
INSERT INTO `t_pub_city` VALUES ('2791', '430702', '武陵区', '3', '0', '328', '湖南', '常德', '武陵区', 'WLQ', '1');
INSERT INTO `t_pub_city` VALUES ('2792', '430722', '汉寿县', '3', '0', '328', '湖南', '常德', '汉寿县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('2793', '430724', '临澧县', '3', '0', '328', '湖南', '常德', '临澧县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('2794', '430781', '津市', '3', '0', '328', '湖南', '常德', '津市', 'JS', null);
INSERT INTO `t_pub_city` VALUES ('2795', '430811', '武陵源区', '3', '0', '239', '湖南', '张家界', '武陵源区', 'WLYQ', '1');
INSERT INTO `t_pub_city` VALUES ('2796', '430902', '资阳区', '3', '0', '329', '湖南', '益阳', '资阳区', 'ZYQ', null);
INSERT INTO `t_pub_city` VALUES ('2797', '430922', '桃江县', '3', '0', '329', '湖南', '益阳', '桃江县', 'TJX', null);
INSERT INTO `t_pub_city` VALUES ('2798', '431002', '北湖区', '3', '0', '240', '湖南', '郴州', '北湖区', 'BHQ', null);
INSERT INTO `t_pub_city` VALUES ('2799', '431021', '桂阳县', '3', '0', '240', '湖南', '郴州', '桂阳县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('2800', '431024', '嘉禾县', '3', '0', '240', '湖南', '郴州', '嘉禾县', 'JHX', null);
INSERT INTO `t_pub_city` VALUES ('2801', '431026', '汝城县', '3', '0', '240', '湖南', '郴州', '汝城县', 'RCX', null);
INSERT INTO `t_pub_city` VALUES ('2802', '431081', '资兴', '3', '0', '240', '湖南', '郴州', '资兴', 'ZX', null);
INSERT INTO `t_pub_city` VALUES ('2803', '431103', '冷水滩区', '3', '0', '330', '湖南', '永州', '冷水滩区', 'LSTQ', '1');
INSERT INTO `t_pub_city` VALUES ('2804', '431123', '双牌县', '3', '0', '330', '湖南', '永州', '双牌县', 'SPX', null);
INSERT INTO `t_pub_city` VALUES ('2805', '431125', '江永县', '3', '0', '330', '湖南', '永州', '江永县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('2806', '431127', '蓝山县', '3', '0', '330', '湖南', '永州', '蓝山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2807', '431129', '江华瑶族自治县', '3', '0', '330', '湖南', '永州', '江华瑶族自治县', 'JHYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2808', '431222', '沅陵县', '3', '0', '241', '湖南', '怀化', '沅陵县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('2809', '431224', '溆浦县', '3', '0', '241', '湖南', '怀化', '溆浦县', 'XPX', null);
INSERT INTO `t_pub_city` VALUES ('2810', '431226', '麻阳苗族自治县', '3', '0', '241', '湖南', '怀化', '麻阳苗族自治县', 'MYMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2811', '431229', '靖州苗族侗族自治县', '3', '0', '241', '湖南', '怀化', '靖州苗族侗族自治县', 'JZMZDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2812', '431302', '娄星区', '3', '0', '331', '湖南', '娄底', '娄星区', 'LXQ', null);
INSERT INTO `t_pub_city` VALUES ('2813', '431322', '新化县', '3', '0', '331', '湖南', '娄底', '新化县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2814', '431382', '涟源', '3', '0', '331', '湖南', '娄底', '涟源', 'LY', null);
INSERT INTO `t_pub_city` VALUES ('2815', '433101', '吉首', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '吉首', 'JS', '1');
INSERT INTO `t_pub_city` VALUES ('2816', '433123', '凤凰县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '凤凰县', 'FHX', '1');
INSERT INTO `t_pub_city` VALUES ('2817', '433124', '花垣县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '花垣县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('2818', '433126', '古丈县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '古丈县', 'GZX', null);
INSERT INTO `t_pub_city` VALUES ('2819', '433127', '永顺县', '3', '0', '242', '湖南', '湘西土家族苗族自治州', '永顺县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('2820', '440103', '荔湾区', '3', '0', '332', '广东', '广州', '荔湾区', 'LWQ', null);
INSERT INTO `t_pub_city` VALUES ('2821', '440105', '海珠区', '3', '0', '332', '广东', '广州', '海珠区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('2822', '440112', '黄埔区', '3', '0', '332', '广东', '广州', '黄埔区', 'HBQ', null);
INSERT INTO `t_pub_city` VALUES ('2823', '440114', '花都区', '3', '0', '332', '广东', '广州', '花都区', 'HDQ', null);
INSERT INTO `t_pub_city` VALUES ('2824', '440117', '从化区', '3', '0', '332', '广东', '广州', '从化区', 'CHQ', null);
INSERT INTO `t_pub_city` VALUES ('2825', '440203', '武江区', '3', '0', '333', '广东', '韶关', '武江区', 'WJQ', null);
INSERT INTO `t_pub_city` VALUES ('2826', '440205', '曲江区', '3', '0', '333', '广东', '韶关', '曲江区', 'QJQ', null);
INSERT INTO `t_pub_city` VALUES ('2827', '440224', '仁化县', '3', '0', '333', '广东', '韶关', '仁化县', 'RHX', null);
INSERT INTO `t_pub_city` VALUES ('2828', '440232', '乳源瑶族自治县', '3', '0', '333', '广东', '韶关', '乳源瑶族自治县', 'RYYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2829', '440282', '南雄', '3', '0', '333', '广东', '韶关', '南雄', 'NX', null);
INSERT INTO `t_pub_city` VALUES ('2830', '440304', '福田区', '3', '0', '243', '广东', '深圳', '福田区', 'FTQ', null);
INSERT INTO `t_pub_city` VALUES ('2831', '440306', '宝安区', '3', '0', '243', '广东', '深圳', '宝安区', 'BAQ', null);
INSERT INTO `t_pub_city` VALUES ('2832', '440308', '盐田区', '3', '0', '243', '广东', '深圳', '盐田区', 'YTQ', null);
INSERT INTO `t_pub_city` VALUES ('2833', '440403', '斗门区', '3', '0', '244', '广东', '珠海', '斗门区', 'DMQ', null);
INSERT INTO `t_pub_city` VALUES ('2834', '440507', '龙湖区', '3', '0', '334', '广东', '汕头', '龙湖区', 'LHQ', null);
INSERT INTO `t_pub_city` VALUES ('2835', '440512', '濠江区', '3', '0', '334', '广东', '汕头', '濠江区', 'HJQ', null);
INSERT INTO `t_pub_city` VALUES ('2836', '440514', '潮南区', '3', '0', '334', '广东', '汕头', '潮南区', 'CNQ', null);
INSERT INTO `t_pub_city` VALUES ('2837', '440523', '南澳县', '3', '0', '334', '广东', '汕头', '南澳县', 'NAX', null);
INSERT INTO `t_pub_city` VALUES ('2838', '440605', '南海区', '3', '0', '245', '广东', '佛山', '南海区', 'NHQ', null);
INSERT INTO `t_pub_city` VALUES ('2839', '440607', '三水区', '3', '0', '245', '广东', '佛山', '三水区', 'SSQ', null);
INSERT INTO `t_pub_city` VALUES ('2840', '440703', '蓬江区', '3', '0', '335', '广东', '江门', '蓬江区', 'PJQ', null);
INSERT INTO `t_pub_city` VALUES ('2841', '440705', '新会区', '3', '0', '335', '广东', '江门', '新会区', 'XHQ', null);
INSERT INTO `t_pub_city` VALUES ('2842', '440784', '鹤山', '3', '0', '335', '广东', '江门', '鹤山', 'HS', null);
INSERT INTO `t_pub_city` VALUES ('2843', '440802', '赤坎区', '3', '0', '246', '广东', '湛江', '赤坎区', 'CKQ', null);
INSERT INTO `t_pub_city` VALUES ('2844', '440804', '坡头区', '3', '0', '246', '广东', '湛江', '坡头区', 'PTQ', null);
INSERT INTO `t_pub_city` VALUES ('2845', '440823', '遂溪县', '3', '0', '246', '广东', '湛江', '遂溪县', 'SXX', null);
INSERT INTO `t_pub_city` VALUES ('2846', '440881', '廉江', '3', '0', '246', '广东', '湛江', '廉江', 'LJ', null);
INSERT INTO `t_pub_city` VALUES ('2847', '440883', '吴川', '3', '0', '246', '广东', '湛江', '吴川', 'WC', null);
INSERT INTO `t_pub_city` VALUES ('2848', '440904', '电白区', '3', '0', '336', '广东', '茂名', '电白区', 'DBQ', null);
INSERT INTO `t_pub_city` VALUES ('2849', '440982', '化州', '3', '0', '336', '广东', '茂名', '化州', 'HZ', null);
INSERT INTO `t_pub_city` VALUES ('2850', '441202', '端州区', '3', '0', '247', '广东', '肇庆', '端州区', 'DZQ', null);
INSERT INTO `t_pub_city` VALUES ('2851', '441204', '高要区', '3', '0', '247', '广东', '肇庆', '高要区', 'GYQ', null);
INSERT INTO `t_pub_city` VALUES ('2852', '441224', '怀集县', '3', '0', '247', '广东', '肇庆', '怀集县', 'HJX', null);
INSERT INTO `t_pub_city` VALUES ('2853', '441226', '德庆县', '3', '0', '247', '广东', '肇庆', '德庆县', 'DQX', null);
INSERT INTO `t_pub_city` VALUES ('2854', '441302', '惠城区', '3', '0', '337', '广东', '惠州', '惠城区', 'HCQ', null);
INSERT INTO `t_pub_city` VALUES ('2855', '441322', '博罗县', '3', '0', '337', '广东', '惠州', '博罗县', 'BLX', null);
INSERT INTO `t_pub_city` VALUES ('2856', '441402', '梅江区', '3', '0', '248', '广东', '梅州', '梅江区', 'MJQ', null);
INSERT INTO `t_pub_city` VALUES ('2857', '441422', '大埔县', '3', '0', '248', '广东', '梅州', '大埔县', 'DBX', null);
INSERT INTO `t_pub_city` VALUES ('2858', '441424', '五华县', '3', '0', '248', '广东', '梅州', '五华县', 'WHX', null);
INSERT INTO `t_pub_city` VALUES ('2859', '441427', '蕉岭县', '3', '0', '248', '广东', '梅州', '蕉岭县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('2860', '441502', '城区', '3', '0', '249', '广东', '汕尾', '城区', 'CQ', null);
INSERT INTO `t_pub_city` VALUES ('2861', '441523', '陆河县', '3', '0', '249', '广东', '汕尾', '陆河县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('2862', '441602', '源城区', '3', '0', '338', '广东', '河源', '源城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('2863', '441622', '龙川县', '3', '0', '338', '广东', '河源', '龙川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('2864', '441624', '和平县', '3', '0', '338', '广东', '河源', '和平县', 'HPX', null);
INSERT INTO `t_pub_city` VALUES ('2865', '441702', '江城区', '3', '0', '250', '广东', '阳江', '江城区', 'JCQ', null);
INSERT INTO `t_pub_city` VALUES ('2866', '441721', '阳西县', '3', '0', '250', '广东', '阳江', '阳西县', 'YXX', null);
INSERT INTO `t_pub_city` VALUES ('2867', '441802', '清城区', '3', '0', '339', '广东', '清远', '清城区', 'QCQ', null);
INSERT INTO `t_pub_city` VALUES ('2868', '441821', '佛冈县', '3', '0', '339', '广东', '清远', '佛冈县', 'FGX', null);
INSERT INTO `t_pub_city` VALUES ('2869', '441825', '连山壮族瑶族自治县', '3', '0', '339', '广东', '清远', '连山壮族瑶族自治县', 'LSZZYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2870', '441882', '连州', '3', '0', '339', '广东', '清远', '连州', 'LZ', null);
INSERT INTO `t_pub_city` VALUES ('2871', '445103', '潮安区', '3', '0', '252', '广东', '潮州', '潮安区', 'CAQ', null);
INSERT INTO `t_pub_city` VALUES ('2872', '445202', '榕城区', '3', '0', '341', '广东', '揭阳', '榕城区', 'RCQ', null);
INSERT INTO `t_pub_city` VALUES ('2873', '445222', '揭西县', '3', '0', '341', '广东', '揭阳', '揭西县', 'JXX', null);
INSERT INTO `t_pub_city` VALUES ('2874', '445302', '云城区', '3', '0', '253', '广东', '云浮', '云城区', 'YCQ', null);
INSERT INTO `t_pub_city` VALUES ('2875', '445321', '新兴县', '3', '0', '253', '广东', '云浮', '新兴县', 'XXX', null);
INSERT INTO `t_pub_city` VALUES ('2876', '445381', '罗定', '3', '0', '253', '广东', '云浮', '罗定', 'LD', null);
INSERT INTO `t_pub_city` VALUES ('2877', '450103', '青秀区', '3', '0', '254', '广西壮族自治区', '南宁', '青秀区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('2878', '450107', '西乡塘区', '3', '0', '254', '广西壮族自治区', '南宁', '西乡塘区', 'XXTQ', null);
INSERT INTO `t_pub_city` VALUES ('2879', '450109', '邕宁区', '3', '0', '254', '广西壮族自治区', '南宁', '邕宁区', 'YNQ', null);
INSERT INTO `t_pub_city` VALUES ('2880', '450124', '马山县', '3', '0', '254', '广西壮族自治区', '南宁', '马山县', 'MSX', null);
INSERT INTO `t_pub_city` VALUES ('2881', '450126', '宾阳县', '3', '0', '254', '广西壮族自治区', '南宁', '宾阳县', 'BYX', null);
INSERT INTO `t_pub_city` VALUES ('2882', '450202', '城中区', '3', '0', '342', '广西壮族自治区', '柳州', '城中区', 'CZQ', null);
INSERT INTO `t_pub_city` VALUES ('2883', '450204', '柳南区', '3', '0', '342', '广西壮族自治区', '柳州', '柳南区', 'LNQ', null);
INSERT INTO `t_pub_city` VALUES ('2884', '450221', '柳江县', '3', '0', '342', '广西壮族自治区', '柳州', '柳江县', 'LJX', null);
INSERT INTO `t_pub_city` VALUES ('2885', '450223', '鹿寨县', '3', '0', '342', '广西壮族自治区', '柳州', '鹿寨县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('2886', '450226', '三江侗族自治县', '3', '0', '342', '广西壮族自治区', '柳州', '三江侗族自治县', 'SJDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2887', '450303', '叠彩区', '3', '0', '255', '广西壮族自治区', '桂林', '叠彩区', 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('2888', '450305', '七星区', '3', '0', '255', '广西壮族自治区', '桂林', '七星区', 'QXQ', null);
INSERT INTO `t_pub_city` VALUES ('2889', '450312', '临桂区', '3', '0', '255', '广西壮族自治区', '桂林', '临桂区', 'LGQ', null);
INSERT INTO `t_pub_city` VALUES ('2890', '450323', '灵川县', '3', '0', '255', '广西壮族自治区', '桂林', '灵川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('2891', '450325', '兴安县', '3', '0', '255', '广西壮族自治区', '桂林', '兴安县', 'XAX', null);
INSERT INTO `t_pub_city` VALUES ('2892', '450328', '龙胜各族自治县', '3', '0', '255', '广西壮族自治区', '桂林', '龙胜各族自治县', 'LSGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2893', '450330', '平乐县', '3', '0', '255', '广西壮族自治区', '桂林', '平乐县', 'PLX', null);
INSERT INTO `t_pub_city` VALUES ('2894', '450332', '恭城瑶族自治县', '3', '0', '255', '广西壮族自治区', '桂林', '恭城瑶族自治县', 'GCYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2895', '450406', '龙圩区', '3', '0', '256', '广西壮族自治区', '梧州', '龙圩区', 'LWQ', null);
INSERT INTO `t_pub_city` VALUES ('2896', '450422', '藤县', '3', '0', '256', '广西壮族自治区', '梧州', '藤县', 'TX', null);
INSERT INTO `t_pub_city` VALUES ('2897', '450481', '岑溪', '3', '0', '256', '广西壮族自治区', '梧州', '岑溪', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('2898', '450503', '银海区', '3', '0', '343', '广西壮族自治区', '北海', '银海区', 'YHQ', null);
INSERT INTO `t_pub_city` VALUES ('2899', '450521', '合浦县', '3', '0', '343', '广西壮族自治区', '北海', '合浦县', 'GPX', null);
INSERT INTO `t_pub_city` VALUES ('2900', '450603', '防城区', '3', '0', '257', '广西壮族自治区', '防城港', '防城区', 'FCQ', null);
INSERT INTO `t_pub_city` VALUES ('2901', '450681', '东兴', '3', '0', '257', '广西壮族自治区', '防城港', '东兴', 'DX', null);
INSERT INTO `t_pub_city` VALUES ('2902', '450703', '钦北区', '3', '0', '258', '广西壮族自治区', '钦州', '钦北区', 'QBQ', null);
INSERT INTO `t_pub_city` VALUES ('2903', '450722', '浦北县', '3', '0', '258', '广西壮族自治区', '钦州', '浦北县', 'PBX', null);
INSERT INTO `t_pub_city` VALUES ('2904', '450803', '港南区', '3', '0', '344', '广西壮族自治区', '贵港', '港南区', 'GNQ', null);
INSERT INTO `t_pub_city` VALUES ('2905', '450821', '平南县', '3', '0', '344', '广西壮族自治区', '贵港', '平南县', 'PNX', null);
INSERT INTO `t_pub_city` VALUES ('2906', '450902', '玉州区', '3', '0', '259', '广西壮族自治区', '玉林', '玉州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('2907', '450921', '容县', '3', '0', '259', '广西壮族自治区', '玉林', '容县', 'RX', null);
INSERT INTO `t_pub_city` VALUES ('2908', '450923', '博白县', '3', '0', '259', '广西壮族自治区', '玉林', '博白县', 'BBX', null);
INSERT INTO `t_pub_city` VALUES ('2909', '450981', '北流', '3', '0', '259', '广西壮族自治区', '玉林', '北流', 'BL', null);
INSERT INTO `t_pub_city` VALUES ('2910', '451021', '田阳县', '3', '0', '260', '广西壮族自治区', '百色', '田阳县', 'TYX', null);
INSERT INTO `t_pub_city` VALUES ('2911', '451023', '平果县', '3', '0', '260', '广西壮族自治区', '百色', '平果县', 'PGX', null);
INSERT INTO `t_pub_city` VALUES ('2912', '451027', '凌云县', '3', '0', '260', '广西壮族自治区', '百色', '凌云县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('2913', '451029', '田林县', '3', '0', '260', '广西壮族自治区', '百色', '田林县', 'TLX', null);
INSERT INTO `t_pub_city` VALUES ('2914', '451031', '隆林各族自治县', '3', '0', '260', '广西壮族自治区', '百色', '隆林各族自治县', 'LLGZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2915', '451102', '八步区', '3', '0', '345', '广西壮族自治区', '贺州', '八步区', 'BBQ', null);
INSERT INTO `t_pub_city` VALUES ('2916', '451122', '钟山县', '3', '0', '345', '广西壮族自治区', '贺州', '钟山县', 'ZSX', null);
INSERT INTO `t_pub_city` VALUES ('2917', '451202', '金城江区', '3', '0', '261', '广西壮族自治区', '河池', '金城江区', 'JCJQ', null);
INSERT INTO `t_pub_city` VALUES ('2918', '451224', '东兰县', '3', '0', '261', '广西壮族自治区', '河池', '东兰县', 'DLX', null);
INSERT INTO `t_pub_city` VALUES ('2919', '451226', '环江毛南族自治县', '3', '0', '261', '广西壮族自治区', '河池', '环江毛南族自治县', 'HJMNZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2920', '451281', '宜州', '3', '0', '261', '广西壮族自治区', '河池', '宜州', 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('2921', '451321', '忻城县', '3', '0', '262', '广西壮族自治区', '来宾', '忻城县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('2922', '451324', '金秀瑶族自治县', '3', '0', '262', '广西壮族自治区', '来宾', '金秀瑶族自治县', 'JXYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2923', '451402', '江州区', '3', '0', '346', '广西壮族自治区', '崇左', '江州区', 'JZQ', null);
INSERT INTO `t_pub_city` VALUES ('2924', '451423', '龙州县', '3', '0', '346', '广西壮族自治区', '崇左', '龙州县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('2925', '451425', '天等县', '3', '0', '346', '广西壮族自治区', '崇左', '天等县', 'TDX', null);
INSERT INTO `t_pub_city` VALUES ('2926', '460107', '琼山区', '3', '0', '263', '海南', '海口', '琼山区', 'QSQ', null);
INSERT INTO `t_pub_city` VALUES ('2927', '460202', '海棠区', '3', '0', '264', '海南', '三亚', '海棠区', 'HTQ', null);
INSERT INTO `t_pub_city` VALUES ('2928', '460205', '崖州区', '3', '0', '264', '海南', '三亚', '崖州区', 'YZQ', null);
INSERT INTO `t_pub_city` VALUES ('2929', '510104', '锦江区', '3', '0', '265', '四川', '成都', '锦江区', 'JJQ', null);
INSERT INTO `t_pub_city` VALUES ('2930', '510106', '金牛区', '3', '0', '265', '四川', '成都', '金牛区', 'JNQ', null);
INSERT INTO `t_pub_city` VALUES ('2931', '510108', '成华区', '3', '0', '265', '四川', '成都', '成华区', 'CHQ', null);
INSERT INTO `t_pub_city` VALUES ('2932', '510113', '青白江区', '3', '0', '265', '四川', '成都', '青白江区', 'QBJQ', null);
INSERT INTO `t_pub_city` VALUES ('2933', '510115', '温江区', '3', '0', '265', '四川', '成都', '温江区', 'WJQ', null);
INSERT INTO `t_pub_city` VALUES ('2934', '510124', '郫县', '3', '0', '265', '四川', '成都', '郫县', 'PX', null);
INSERT INTO `t_pub_city` VALUES ('2935', '510129', '大邑县', '3', '0', '265', '四川', '成都', '大邑县', 'DYX', null);
INSERT INTO `t_pub_city` VALUES ('2936', '510181', '都江堰', '3', '0', '265', '四川', '成都', '都江堰', 'DJY', null);
INSERT INTO `t_pub_city` VALUES ('2937', '510183', '邛崃', '3', '0', '265', '四川', '成都', '邛崃', 'QL', null);
INSERT INTO `t_pub_city` VALUES ('2938', '510185', '简阳', '3', '0', '265', '四川', '成都', '简阳', 'JY', null);
INSERT INTO `t_pub_city` VALUES ('2939', '510303', '贡井区', '3', '0', '266', '四川', '自贡', '贡井区', 'GJQ', null);
INSERT INTO `t_pub_city` VALUES ('2940', '510311', '沿滩区', '3', '0', '266', '四川', '自贡', '沿滩区', 'YTQ', null);
INSERT INTO `t_pub_city` VALUES ('2941', '510322', '富顺县', '3', '0', '266', '四川', '自贡', '富顺县', 'FSX', null);
INSERT INTO `t_pub_city` VALUES ('2942', '510403', '西区', '3', '0', '368', '四川', '攀枝花', '西区', 'XQ', null);
INSERT INTO `t_pub_city` VALUES ('2943', '510421', '米易县', '3', '0', '368', '四川', '攀枝花', '米易县', 'MYX', null);
INSERT INTO `t_pub_city` VALUES ('2944', '510502', '江阳区', '3', '0', '267', '四川', '泸州', '江阳区', 'JYQ', null);
INSERT INTO `t_pub_city` VALUES ('2945', '510504', '龙马潭区', '3', '0', '267', '四川', '泸州', '龙马潭区', 'LMTQ', null);
INSERT INTO `t_pub_city` VALUES ('2946', '510522', '合江县', '3', '0', '267', '四川', '泸州', '合江县', 'GJX', null);
INSERT INTO `t_pub_city` VALUES ('2947', '510525', '古蔺县', '3', '0', '267', '四川', '泸州', '古蔺县', 'GLX', null);
INSERT INTO `t_pub_city` VALUES ('2948', '510623', '中江县', '3', '0', '369', '四川', '德阳', '中江县', 'ZJX', null);
INSERT INTO `t_pub_city` VALUES ('2949', '510681', '广汉', '3', '0', '369', '四川', '德阳', '广汉', 'AH', null);
INSERT INTO `t_pub_city` VALUES ('2950', '510683', '绵竹', '3', '0', '369', '四川', '德阳', '绵竹', 'MZ', null);
INSERT INTO `t_pub_city` VALUES ('2951', '510704', '游仙区', '3', '0', '268', '四川', '绵阳', '游仙区', 'YXQ', null);
INSERT INTO `t_pub_city` VALUES ('2952', '510722', '三台县', '3', '0', '268', '四川', '绵阳', '三台县', 'STX', null);
INSERT INTO `t_pub_city` VALUES ('2953', '510725', '梓潼县', '3', '0', '268', '四川', '绵阳', '梓潼县', 'ZTX', null);
INSERT INTO `t_pub_city` VALUES ('2954', '510781', '江油', '3', '0', '268', '四川', '绵阳', '江油', 'JY', null);
INSERT INTO `t_pub_city` VALUES ('2955', '510811', '昭化区', '3', '0', '370', '四川', '广元', '昭化区', 'ZHQ', null);
INSERT INTO `t_pub_city` VALUES ('2956', '510821', '旺苍县', '3', '0', '370', '四川', '广元', '旺苍县', 'WCX', null);
INSERT INTO `t_pub_city` VALUES ('2957', '510823', '剑阁县', '3', '0', '370', '四川', '广元', '剑阁县', 'JGX', null);
INSERT INTO `t_pub_city` VALUES ('2958', '510903', '船山区', '3', '0', '269', '四川', '遂宁', '船山区', 'CSQ', null);
INSERT INTO `t_pub_city` VALUES ('2959', '510921', '蓬溪县', '3', '0', '269', '四川', '遂宁', '蓬溪县', 'PXX', null);
INSERT INTO `t_pub_city` VALUES ('2960', '510923', '大英县', '3', '0', '269', '四川', '遂宁', '大英县', 'DYX', null);
INSERT INTO `t_pub_city` VALUES ('2961', '511011', '东兴区', '3', '0', '270', '四川', '内江', '东兴区', 'DXQ', null);
INSERT INTO `t_pub_city` VALUES ('2962', '511025', '资中县', '3', '0', '270', '四川', '内江', '资中县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('2963', '511102', '市中区', '3', '0', '371', '四川', '乐山', '市中区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('2964', '511112', '五通桥区', '3', '0', '371', '四川', '乐山', '五通桥区', 'WTQQ', null);
INSERT INTO `t_pub_city` VALUES ('2965', '511123', '犍为县', '3', '0', '371', '四川', '乐山', '犍为县', 'JWX', null);
INSERT INTO `t_pub_city` VALUES ('2966', '511129', '沐川县', '3', '0', '371', '四川', '乐山', '沐川县', 'MCX', null);
INSERT INTO `t_pub_city` VALUES ('2967', '511133', '马边彝族自治县', '3', '0', '371', '四川', '乐山', '马边彝族自治县', 'MBYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('2968', '511302', '顺庆区', '3', '0', '271', '四川', '南充', '顺庆区', 'SQQ', null);
INSERT INTO `t_pub_city` VALUES ('2969', '511304', '嘉陵区', '3', '0', '271', '四川', '南充', '嘉陵区', 'JLQ', null);
INSERT INTO `t_pub_city` VALUES ('2970', '511322', '营山县', '3', '0', '271', '四川', '南充', '营山县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('2971', '511324', '仪陇县', '3', '0', '271', '四川', '南充', '仪陇县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('2972', '511402', '东坡区', '3', '0', '372', '四川', '眉山', '东坡区', 'DPQ', null);
INSERT INTO `t_pub_city` VALUES ('2973', '511421', '仁寿县', '3', '0', '372', '四川', '眉山', '仁寿县', 'RSX', null);
INSERT INTO `t_pub_city` VALUES ('2974', '511424', '丹棱县', '3', '0', '372', '四川', '眉山', '丹棱县', 'DLX', null);
INSERT INTO `t_pub_city` VALUES ('2975', '511502', '翠屏区', '3', '0', '272', '四川', '宜宾', '翠屏区', 'CPQ', null);
INSERT INTO `t_pub_city` VALUES ('2976', '511521', '宜宾县', '3', '0', '272', '四川', '宜宾', '宜宾县', 'YBX', null);
INSERT INTO `t_pub_city` VALUES ('2977', '511524', '长宁县', '3', '0', '272', '四川', '宜宾', '长宁县', 'CNX', null);
INSERT INTO `t_pub_city` VALUES ('2978', '511526', '珙县', '3', '0', '272', '四川', '宜宾', '珙县', 'GX', null);
INSERT INTO `t_pub_city` VALUES ('2979', '511528', '兴文县', '3', '0', '272', '四川', '宜宾', '兴文县', 'XWX', null);
INSERT INTO `t_pub_city` VALUES ('2980', '511602', '广安区', '3', '0', '373', '四川', '广安', '广安区', 'AAQ', null);
INSERT INTO `t_pub_city` VALUES ('2981', '511621', '岳池县', '3', '0', '373', '四川', '广安', '岳池县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('2982', '511623', '邻水县', '3', '0', '373', '四川', '广安', '邻水县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2983', '511702', '通川区', '3', '0', '273', '四川', '达州', '通川区', 'TCQ', null);
INSERT INTO `t_pub_city` VALUES ('2984', '511722', '宣汉县', '3', '0', '273', '四川', '达州', '宣汉县', 'XHX', null);
INSERT INTO `t_pub_city` VALUES ('2985', '511724', '大竹县', '3', '0', '273', '四川', '达州', '大竹县', 'DZX', null);
INSERT INTO `t_pub_city` VALUES ('2986', '511781', '万源', '3', '0', '273', '四川', '达州', '万源', 'WY', null);
INSERT INTO `t_pub_city` VALUES ('2987', '511803', '名山区', '3', '0', '374', '四川', '雅安', '名山区', 'MSQ', null);
INSERT INTO `t_pub_city` VALUES ('2988', '511824', '石棉县', '3', '0', '374', '四川', '雅安', '石棉县', 'SMX', null);
INSERT INTO `t_pub_city` VALUES ('2989', '511826', '芦山县', '3', '0', '374', '四川', '雅安', '芦山县', 'LSX', null);
INSERT INTO `t_pub_city` VALUES ('2990', '511902', '巴州区', '3', '0', '274', '四川', '巴中', '巴州区', 'BZQ', null);
INSERT INTO `t_pub_city` VALUES ('2991', '511921', '通江县', '3', '0', '274', '四川', '巴中', '通江县', 'TJX', null);
INSERT INTO `t_pub_city` VALUES ('2992', '511923', '平昌县', '3', '0', '274', '四川', '巴中', '平昌县', 'PCX', null);
INSERT INTO `t_pub_city` VALUES ('2993', '512021', '安岳县', '3', '0', '275', '四川', '资阳', '安岳县', 'AYX', null);
INSERT INTO `t_pub_city` VALUES ('2994', '513201', '马尔康区', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '马尔康区', 'MEKQ', null);
INSERT INTO `t_pub_city` VALUES ('2995', '513221', '汶川县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '汶川县', 'WCX', null);
INSERT INTO `t_pub_city` VALUES ('2996', '513223', '茂县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '茂县', 'MX', null);
INSERT INTO `t_pub_city` VALUES ('2997', '513224', '松潘县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '松潘县', 'SPX', null);
INSERT INTO `t_pub_city` VALUES ('2998', '513226', '金川县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '金川县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('2999', '513228', '黑水县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '黑水县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('3000', '513230', '壤塘县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '壤塘县', 'RTX', null);
INSERT INTO `t_pub_city` VALUES ('3001', '513232', '若尔盖县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '若尔盖县', 'REGX', null);
INSERT INTO `t_pub_city` VALUES ('3002', '513233', '红原县', '3', '0', '375', '四川', '阿坝藏族羌族自治州', '红原县', 'GYX', null);
INSERT INTO `t_pub_city` VALUES ('3003', '513322', '泸定县', '3', '0', '276', '四川', '甘孜藏族自治州', '泸定县', 'LDX', null);
INSERT INTO `t_pub_city` VALUES ('3004', '513324', '九龙县', '3', '0', '276', '四川', '甘孜藏族自治州', '九龙县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('3005', '513326', '道孚县', '3', '0', '276', '四川', '甘孜藏族自治州', '道孚县', 'DFX', null);
INSERT INTO `t_pub_city` VALUES ('3006', '513327', '炉霍县', '3', '0', '276', '四川', '甘孜藏族自治州', '炉霍县', 'LHX', null);
INSERT INTO `t_pub_city` VALUES ('3007', '513329', '新龙县', '3', '0', '276', '四川', '甘孜藏族自治州', '新龙县', 'XLX', null);
INSERT INTO `t_pub_city` VALUES ('3008', '513331', '白玉县', '3', '0', '276', '四川', '甘孜藏族自治州', '白玉县', 'BYX', null);
INSERT INTO `t_pub_city` VALUES ('3009', '513332', '石渠县', '3', '0', '276', '四川', '甘孜藏族自治州', '石渠县', 'SQX', null);
INSERT INTO `t_pub_city` VALUES ('3010', '513334', '理塘县', '3', '0', '276', '四川', '甘孜藏族自治州', '理塘县', 'LTX', null);
INSERT INTO `t_pub_city` VALUES ('3011', '513336', '乡城县', '3', '0', '276', '四川', '甘孜藏族自治州', '乡城县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('3012', '513337', '稻城县', '3', '0', '276', '四川', '甘孜藏族自治州', '稻城县', 'DCX', null);
INSERT INTO `t_pub_city` VALUES ('3013', '513401', '西昌', '3', '0', '376', '四川', '凉山彝族自治州', '西昌', 'XC', null);
INSERT INTO `t_pub_city` VALUES ('3014', '513423', '盐源县', '3', '0', '376', '四川', '凉山彝族自治州', '盐源县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('3015', '513424', '德昌县', '3', '0', '376', '四川', '凉山彝族自治州', '德昌县', 'DCX', null);
INSERT INTO `t_pub_city` VALUES ('3016', '513426', '会东县', '3', '0', '376', '四川', '凉山彝族自治州', '会东县', 'HDX', null);
INSERT INTO `t_pub_city` VALUES ('3017', '513428', '普格县', '3', '0', '376', '四川', '凉山彝族自治州', '普格县', 'PGX', null);
INSERT INTO `t_pub_city` VALUES ('3018', '513430', '金阳县', '3', '0', '376', '四川', '凉山彝族自治州', '金阳县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('3019', '513431', '昭觉县', '3', '0', '376', '四川', '凉山彝族自治州', '昭觉县', 'ZJX', null);
INSERT INTO `t_pub_city` VALUES ('3020', '513433', '冕宁县', '3', '0', '376', '四川', '凉山彝族自治州', '冕宁县', 'MNX', null);
INSERT INTO `t_pub_city` VALUES ('3021', '513435', '甘洛县', '3', '0', '376', '四川', '凉山彝族自治州', '甘洛县', 'GLX', null);
INSERT INTO `t_pub_city` VALUES ('3022', '513436', '美姑县', '3', '0', '376', '四川', '凉山彝族自治州', '美姑县', 'MGX', null);
INSERT INTO `t_pub_city` VALUES ('3023', '520102', '南明区', '3', '0', '377', '贵州', '贵阳', '南明区', 'NMQ', null);
INSERT INTO `t_pub_city` VALUES ('3024', '520111', '花溪区', '3', '0', '377', '贵州', '贵阳', '花溪区', 'HXQ', null);
INSERT INTO `t_pub_city` VALUES ('3025', '520113', '白云区', '3', '0', '377', '贵州', '贵阳', '白云区', 'BYQ', null);
INSERT INTO `t_pub_city` VALUES ('3026', '520121', '开阳县', '3', '0', '377', '贵州', '贵阳', '开阳县', 'KYX', null);
INSERT INTO `t_pub_city` VALUES ('3027', '520123', '修文县', '3', '0', '377', '贵州', '贵阳', '修文县', 'XWX', null);
INSERT INTO `t_pub_city` VALUES ('3028', '520201', '钟山区', '3', '0', '277', '贵州', '六盘水', '钟山区', 'ZSQ', null);
INSERT INTO `t_pub_city` VALUES ('3029', '520222', '盘县', '3', '0', '277', '贵州', '六盘水', '盘县', 'PX', null);
INSERT INTO `t_pub_city` VALUES ('3030', '520303', '汇川区', '3', '0', '278', '贵州', '遵义', '汇川区', 'HCQ', null);
INSERT INTO `t_pub_city` VALUES ('3031', '520323', '绥阳县', '3', '0', '278', '贵州', '遵义', '绥阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('3032', '520326', '务川仡佬族苗族自治县', '3', '0', '278', '贵州', '遵义', '务川仡佬族苗族自治县', 'WCGLZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3033', '520330', '习水县', '3', '0', '278', '贵州', '遵义', '习水县', 'XSX', null);
INSERT INTO `t_pub_city` VALUES ('3034', '520382', '仁怀', '3', '0', '278', '贵州', '遵义', '仁怀', 'RH', null);
INSERT INTO `t_pub_city` VALUES ('3035', '520422', '普定县', '3', '0', '378', '贵州', '安顺', '普定县', 'PDX', null);
INSERT INTO `t_pub_city` VALUES ('3036', '520424', '关岭布依族苗族自治县', '3', '0', '378', '贵州', '安顺', '关岭布依族苗族自治县', 'GLBYZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3037', '520522', '黔西县', '3', '0', '279', '贵州', '毕节', '黔西县', 'QXX', null);
INSERT INTO `t_pub_city` VALUES ('3038', '520524', '织金县', '3', '0', '279', '贵州', '毕节', '织金县', 'ZJX', null);
INSERT INTO `t_pub_city` VALUES ('3039', '520526', '威宁彝族回族苗族自治县', '3', '0', '279', '贵州', '毕节', '威宁彝族回族苗族自治县', 'WNYZHZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3040', '520603', '万山区', '3', '0', '379', '贵州', '铜仁', '万山区', 'WSQ', null);
INSERT INTO `t_pub_city` VALUES ('3041', '520622', '玉屏侗族自治县', '3', '0', '379', '贵州', '铜仁', '玉屏侗族自治县', 'YPDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3042', '520625', '印江土家族苗族自治县', '3', '0', '379', '贵州', '铜仁', '印江土家族苗族自治县', 'YJTJZMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3043', '520628', '松桃苗族自治县', '3', '0', '379', '贵州', '铜仁', '松桃苗族自治县', 'STMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3044', '522301', '兴义', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '兴义', 'XY', null);
INSERT INTO `t_pub_city` VALUES ('3045', '522323', '普安县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '普安县', 'PAX', null);
INSERT INTO `t_pub_city` VALUES ('3046', '522324', '晴隆县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '晴隆县', 'QLX', null);
INSERT INTO `t_pub_city` VALUES ('3047', '522326', '望谟县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '望谟县', 'WMX', null);
INSERT INTO `t_pub_city` VALUES ('3048', '522327', '册亨县', '3', '0', '380', '贵州', '黔西南布依族苗族自治州', '册亨县', 'CHX', null);
INSERT INTO `t_pub_city` VALUES ('3049', '522601', '凯里', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '凯里', 'KL', null);
INSERT INTO `t_pub_city` VALUES ('3050', '522623', '施秉县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '施秉县', 'SBX', null);
INSERT INTO `t_pub_city` VALUES ('3051', '522624', '三穗县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '三穗县', 'SSX', null);
INSERT INTO `t_pub_city` VALUES ('3052', '522626', '岑巩县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '岑巩县', 'CGX', null);
INSERT INTO `t_pub_city` VALUES ('3053', '522627', '天柱县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '天柱县', 'TZX', null);
INSERT INTO `t_pub_city` VALUES ('3054', '522629', '剑河县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '剑河县', 'JHX', null);
INSERT INTO `t_pub_city` VALUES ('3055', '522630', '台江县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '台江县', 'TJX', null);
INSERT INTO `t_pub_city` VALUES ('3056', '522632', '榕江县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '榕江县', 'RJX', null);
INSERT INTO `t_pub_city` VALUES ('3057', '522633', '从江县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '从江县', 'CJX', null);
INSERT INTO `t_pub_city` VALUES ('3058', '522635', '麻江县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '麻江县', 'MJX', null);
INSERT INTO `t_pub_city` VALUES ('3059', '522636', '丹寨县', '3', '0', '280', '贵州', '黔东南苗族侗族自治州', '丹寨县', 'DZX', null);
INSERT INTO `t_pub_city` VALUES ('3060', '522702', '福泉', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '福泉', 'FQ', null);
INSERT INTO `t_pub_city` VALUES ('3061', '522722', '荔波县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '荔波县', 'LBX', null);
INSERT INTO `t_pub_city` VALUES ('3062', '522725', '瓮安县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '瓮安县', 'WAX', null);
INSERT INTO `t_pub_city` VALUES ('3063', '522727', '平塘县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '平塘县', 'PTX', null);
INSERT INTO `t_pub_city` VALUES ('3064', '522728', '罗甸县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '罗甸县', 'LDX', null);
INSERT INTO `t_pub_city` VALUES ('3065', '522730', '龙里县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '龙里县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('3066', '522731', '惠水县', '3', '0', '381', '贵州', '黔南布依族苗族自治州', '惠水县', 'HSX', null);
INSERT INTO `t_pub_city` VALUES ('3067', '530102', '五华区', '3', '0', '281', '云南', '昆明', '五华区', 'WHQ', null);
INSERT INTO `t_pub_city` VALUES ('3068', '530111', '官渡区', '3', '0', '281', '云南', '昆明', '官渡区', 'GDQ', null);
INSERT INTO `t_pub_city` VALUES ('3069', '530113', '东川区', '3', '0', '281', '云南', '昆明', '东川区', 'DCQ', null);
INSERT INTO `t_pub_city` VALUES ('3070', '530122', '晋宁县', '3', '0', '281', '云南', '昆明', '晋宁县', 'JNX', null);
INSERT INTO `t_pub_city` VALUES ('3071', '530125', '宜良县', '3', '0', '281', '云南', '昆明', '宜良县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('3072', '530127', '嵩明县', '3', '0', '281', '云南', '昆明', '嵩明县', 'SMX', null);
INSERT INTO `t_pub_city` VALUES ('3073', '530129', '寻甸回族彝族自治县', '3', '0', '281', '云南', '昆明', '寻甸回族彝族自治县', 'XDHZYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3074', '530303', '沾益区', '3', '0', '382', '云南', '曲靖', '沾益区', 'ZYQ', null);
INSERT INTO `t_pub_city` VALUES ('3075', '530322', '陆良县', '3', '0', '382', '云南', '曲靖', '陆良县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('3076', '530324', '罗平县', '3', '0', '382', '云南', '曲靖', '罗平县', 'LPX', null);
INSERT INTO `t_pub_city` VALUES ('3077', '530326', '会泽县', '3', '0', '382', '云南', '曲靖', '会泽县', 'HZX', null);
INSERT INTO `t_pub_city` VALUES ('3078', '530402', '红塔区', '3', '0', '282', '云南', '玉溪', '红塔区', 'GDQ', null);
INSERT INTO `t_pub_city` VALUES ('3079', '530423', '通海县', '3', '0', '282', '云南', '玉溪', '通海县', 'THX', null);
INSERT INTO `t_pub_city` VALUES ('3080', '530425', '易门县', '3', '0', '282', '云南', '玉溪', '易门县', 'YMX', null);
INSERT INTO `t_pub_city` VALUES ('3081', '530427', '新平彝族傣族自治县', '3', '0', '282', '云南', '玉溪', '新平彝族傣族自治县', 'XPYZDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3082', '530521', '施甸县', '3', '0', '383', '云南', '保山', '施甸县', 'SDX', null);
INSERT INTO `t_pub_city` VALUES ('3083', '530523', '龙陵县', '3', '0', '383', '云南', '保山', '龙陵县', 'LLX', null);
INSERT INTO `t_pub_city` VALUES ('3084', '530602', '昭阳区', '3', '0', '283', '云南', '昭通', '昭阳区', 'ZYQ', null);
INSERT INTO `t_pub_city` VALUES ('3085', '530622', '巧家县', '3', '0', '283', '云南', '昭通', '巧家县', 'QJX', null);
INSERT INTO `t_pub_city` VALUES ('3086', '530624', '大关县', '3', '0', '283', '云南', '昭通', '大关县', 'DGX', null);
INSERT INTO `t_pub_city` VALUES ('3087', '530626', '绥江县', '3', '0', '283', '云南', '昭通', '绥江县', 'SJX', null);
INSERT INTO `t_pub_city` VALUES ('3088', '530628', '彝良县', '3', '0', '283', '云南', '昭通', '彝良县', 'YLX', null);
INSERT INTO `t_pub_city` VALUES ('3089', '530630', '水富县', '3', '0', '283', '云南', '昭通', '水富县', 'SFX', null);
INSERT INTO `t_pub_city` VALUES ('3090', '530721', '玉龙纳西族自治县', '3', '0', '384', '云南', '丽江', '玉龙纳西族自治县', 'YLNXZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3091', '530724', '宁蒗彝族自治县', '3', '0', '384', '云南', '丽江', '宁蒗彝族自治县', 'NLYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3092', '530822', '墨江哈尼族自治县', '3', '0', '284', '云南', '普洱', '墨江哈尼族自治县', 'MJHNZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3093', '530824', '景谷傣族彝族自治县', '3', '0', '284', '云南', '普洱', '景谷傣族彝族自治县', 'JGDZYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3094', '530827', '孟连傣族拉祜族佤族自治县', '3', '0', '284', '云南', '普洱', '孟连傣族拉祜族佤族自治县', 'MLDZLHZWZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3095', '530921', '凤庆县', '3', '0', '385', '云南', '临沧', '凤庆县', 'FQX', null);
INSERT INTO `t_pub_city` VALUES ('3096', '530923', '永德县', '3', '0', '385', '云南', '临沧', '永德县', 'YDX', null);
INSERT INTO `t_pub_city` VALUES ('3097', '530925', '双江拉祜族佤族布朗族傣族自治县', '3', '0', '385', '云南', '临沧', '双江拉祜族佤族布朗族傣族自治县', 'SJLHZWZBLZDZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3098', '532301', '楚雄', '3', '0', '285', '云南', '楚雄彝族自治州', '楚雄', 'CX', null);
INSERT INTO `t_pub_city` VALUES ('3099', '532323', '牟定县', '3', '0', '285', '云南', '楚雄彝族自治州', '牟定县', 'MDX', null);
INSERT INTO `t_pub_city` VALUES ('3100', '532325', '姚安县', '3', '0', '285', '云南', '楚雄彝族自治州', '姚安县', 'YAX', null);
INSERT INTO `t_pub_city` VALUES ('3101', '532326', '大姚县', '3', '0', '285', '云南', '楚雄彝族自治州', '大姚县', 'DYX', null);
INSERT INTO `t_pub_city` VALUES ('3102', '532328', '元谋县', '3', '0', '285', '云南', '楚雄彝族自治州', '元谋县', 'YMX', null);
INSERT INTO `t_pub_city` VALUES ('3103', '532331', '禄丰县', '3', '0', '285', '云南', '楚雄彝族自治州', '禄丰县', 'LFX', null);
INSERT INTO `t_pub_city` VALUES ('3104', '532501', '个旧', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '个旧', 'GJ', null);
INSERT INTO `t_pub_city` VALUES ('3105', '532503', '蒙自', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '蒙自', 'MZ', null);
INSERT INTO `t_pub_city` VALUES ('3106', '532504', '弥勒', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '弥勒', 'ML', null);
INSERT INTO `t_pub_city` VALUES ('3107', '532524', '建水县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '建水县', 'JSX', null);
INSERT INTO `t_pub_city` VALUES ('3108', '532525', '石屏县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '石屏县', 'SPX', null);
INSERT INTO `t_pub_city` VALUES ('3109', '532528', '元阳县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '元阳县', 'YYX', null);
INSERT INTO `t_pub_city` VALUES ('3110', '532529', '红河县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '红河县', 'GHX', null);
INSERT INTO `t_pub_city` VALUES ('3111', '532532', '河口瑶族自治县', '3', '0', '386', '云南', '红河哈尼族彝族自治州', '河口瑶族自治县', 'HKYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3112', '532622', '砚山县', '3', '0', '286', '云南', '文山壮族苗族自治州', '砚山县', 'YSX', null);
INSERT INTO `t_pub_city` VALUES ('3113', '532623', '西畴县', '3', '0', '286', '云南', '文山壮族苗族自治州', '西畴县', 'XCX', null);
INSERT INTO `t_pub_city` VALUES ('3114', '532625', '马关县', '3', '0', '286', '云南', '文山壮族苗族自治州', '马关县', 'MGX', null);
INSERT INTO `t_pub_city` VALUES ('3115', '532627', '广南县', '3', '0', '286', '云南', '文山壮族苗族自治州', '广南县', 'ANX', null);
INSERT INTO `t_pub_city` VALUES ('3116', '532628', '富宁县', '3', '0', '286', '云南', '文山壮族苗族自治州', '富宁县', 'FNX', null);
INSERT INTO `t_pub_city` VALUES ('3117', '532822', '勐海县', '3', '0', '387', '云南', '西双版纳傣族自治州', '勐海县', 'MHX', null);
INSERT INTO `t_pub_city` VALUES ('3118', '532823', '勐腊县', '3', '0', '387', '云南', '西双版纳傣族自治州', '勐腊县', 'MLX', null);
INSERT INTO `t_pub_city` VALUES ('3119', '532922', '漾濞彝族自治县', '3', '0', '388', '云南', '大理白族自治州', '漾濞彝族自治县', 'YBYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3120', '532924', '宾川县', '3', '0', '388', '云南', '大理白族自治州', '宾川县', 'BCX', null);
INSERT INTO `t_pub_city` VALUES ('3121', '532926', '南涧彝族自治县', '3', '0', '388', '云南', '大理白族自治州', '南涧彝族自治县', 'NJYZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3122', '532928', '永平县', '3', '0', '388', '云南', '大理白族自治州', '永平县', 'YPX', null);
INSERT INTO `t_pub_city` VALUES ('3123', '532930', '洱源县', '3', '0', '388', '云南', '大理白族自治州', '洱源县', 'EYX', null);
INSERT INTO `t_pub_city` VALUES ('3124', '532931', '剑川县', '3', '0', '388', '云南', '大理白族自治州', '剑川县', 'JCX', null);
INSERT INTO `t_pub_city` VALUES ('3125', '533102', '瑞丽', '3', '0', '287', '云南', '德宏傣族景颇族自治州', '瑞丽', 'RL', null);
INSERT INTO `t_pub_city` VALUES ('3126', '533103', '芒', '3', '0', '287', '云南', '德宏傣族景颇族自治州', '芒', 'M', null);
INSERT INTO `t_pub_city` VALUES ('3127', '533123', '盈江县', '3', '0', '287', '云南', '德宏傣族景颇族自治州', '盈江县', 'YJX', null);
INSERT INTO `t_pub_city` VALUES ('3128', '533124', '陇川县', '3', '0', '287', '云南', '德宏傣族景颇族自治州', '陇川县', 'LCX', null);
INSERT INTO `t_pub_city` VALUES ('3129', '533323', '福贡县', '3', '0', '389', '云南', '怒江傈僳族自治州', '福贡县', 'FGX', null);
INSERT INTO `t_pub_city` VALUES ('3130', '533325', '兰坪白族普米族自治县', '3', '0', '389', '云南', '怒江傈僳族自治州', '兰坪白族普米族自治县', 'LPBZPMZZZX', null);
INSERT INTO `t_pub_city` VALUES ('3131', '533422', '德钦县', '3', '0', '288', '云南', '迪庆藏族自治州', '德钦县', 'DQX', null);
INSERT INTO `t_pub_city` VALUES ('3132', '540102', '城关区', '3', '0', '390', '西藏自治区', '拉萨', '城关区', 'CGQ', null);
INSERT INTO `t_pub_city` VALUES ('3133', '540121', '林周县', '3', '0', '390', '西藏自治区', '拉萨', '林周县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('3134', '540123', '尼木县', '3', '0', '390', '西藏自治区', '拉萨', '尼木县', 'NMX', null);
INSERT INTO `t_pub_city` VALUES ('3135', '540126', '达孜县', '3', '0', '390', '西藏自治区', '拉萨', '达孜县', 'DZX', null);
INSERT INTO `t_pub_city` VALUES ('3136', '540202', '桑珠孜区', '3', '0', '289', '西藏自治区', '日喀则', '桑珠孜区', 'SZZQ', null);
INSERT INTO `t_pub_city` VALUES ('3137', '540222', '江孜县', '3', '0', '289', '西藏自治区', '日喀则', '江孜县', 'JZX', null);
INSERT INTO `t_pub_city` VALUES ('3138', '540224', '萨迦县', '3', '0', '289', '西藏自治区', '日喀则', '萨迦县', 'SJX', null);
INSERT INTO `t_pub_city` VALUES ('3139', '540226', '昂仁县', '3', '0', '289', '西藏自治区', '日喀则', '昂仁县', 'ARX', null);
INSERT INTO `t_pub_city` VALUES ('3140', '540228', '白朗县', '3', '0', '289', '西藏自治区', '日喀则', '白朗县', 'BLX', null);
INSERT INTO `t_pub_city` VALUES ('3141', '540230', '康马县', '3', '0', '289', '西藏自治区', '日喀则', '康马县', 'KMX', null);
INSERT INTO `t_pub_city` VALUES ('3142', '540232', '仲巴县', '3', '0', '289', '西藏自治区', '日喀则', '仲巴县', 'ZBX', null);
INSERT INTO `t_pub_city` VALUES ('3143', '540234', '吉隆县', '3', '0', '289', '西藏自治区', '日喀则', '吉隆县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('3144', '540236', '萨嘎县', '3', '0', '289', '西藏自治区', '日喀则', '萨嘎县', 'SGX', null);
INSERT INTO `t_pub_city` VALUES ('3145', '540302', '卡若区', '3', '0', '391', '西藏自治区', '昌都', '卡若区', 'KRQ', null);
INSERT INTO `t_pub_city` VALUES ('3146', '540322', '贡觉县', '3', '0', '391', '西藏自治区', '昌都', '贡觉县', 'GJX', null);
INSERT INTO `t_pub_city` VALUES ('3147', '540324', '丁青县', '3', '0', '391', '西藏自治区', '昌都', '丁青县', 'DQX', null);
INSERT INTO `t_pub_city` VALUES ('3148', '540326', '八宿县', '3', '0', '391', '西藏自治区', '昌都', '八宿县', 'BSX', null);
INSERT INTO `t_pub_city` VALUES ('3149', '540328', '芒康县', '3', '0', '391', '西藏自治区', '昌都', '芒康县', 'MKX', null);
INSERT INTO `t_pub_city` VALUES ('3150', '540330', '边坝县', '3', '0', '391', '西藏自治区', '昌都', '边坝县', 'BBX', null);
INSERT INTO `t_pub_city` VALUES ('3151', '540421', '工布江达县', '3', '0', '290', '西藏自治区', '林芝', '工布江达县', 'GBJDX', null);
INSERT INTO `t_pub_city` VALUES ('3152', '540423', '墨脱县', '3', '0', '290', '西藏自治区', '林芝', '墨脱县', 'MTX', null);
INSERT INTO `t_pub_city` VALUES ('3153', '540426', '朗县', '3', '0', '290', '西藏自治区', '林芝', '朗县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('3154', '540502', '乃东区', '3', '0', '392', '西藏自治区', '山南', '乃东区', 'NDQ', null);
INSERT INTO `t_pub_city` VALUES ('3155', '540523', '桑日县', '3', '0', '392', '西藏自治区', '山南', '桑日县', 'SRX', null);
INSERT INTO `t_pub_city` VALUES ('3156', '540525', '曲松县', '3', '0', '392', '西藏自治区', '山南', '曲松县', 'QSX', null);
INSERT INTO `t_pub_city` VALUES ('3157', '540527', '洛扎县', '3', '0', '392', '西藏自治区', '山南', '洛扎县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('3158', '540529', '隆子县', '3', '0', '392', '西藏自治区', '山南', '隆子县', 'LZX', null);
INSERT INTO `t_pub_city` VALUES ('3159', '540531', '浪卡子县', '3', '0', '392', '西藏自治区', '山南', '浪卡子县', 'LKZX', null);
INSERT INTO `t_pub_city` VALUES ('3160', '542422', '嘉黎县', '3', '0', '291', '西藏自治区', '那曲地区', '嘉黎县', 'JLX', null);
INSERT INTO `t_pub_city` VALUES ('3161', '542424', '聂荣县', '3', '0', '291', '西藏自治区', '那曲地区', '聂荣县', 'NRX', null);
INSERT INTO `t_pub_city` VALUES ('3162', '542426', '申扎县', '3', '0', '291', '西藏自治区', '那曲地区', '申扎县', 'SZX', null);
INSERT INTO `t_pub_city` VALUES ('3163', '542428', '班戈县', '3', '0', '291', '西藏自治区', '那曲地区', '班戈县', 'BGX', null);
INSERT INTO `t_pub_city` VALUES ('3164', '542430', '尼玛县', '3', '0', '291', '西藏自治区', '那曲地区', '尼玛县', 'NMX', null);
INSERT INTO `t_pub_city` VALUES ('3165', '542521', '普兰县', '3', '0', '292', '西藏自治区', '阿里地区', '普兰县', 'PLX', null);
INSERT INTO `t_pub_city` VALUES ('3166', '542522', '札达县', '3', '0', '292', '西藏自治区', '阿里地区', '札达县', 'ZDX', null);
INSERT INTO `t_pub_city` VALUES ('3167', '542524', '日土县', '3', '0', '292', '西藏自治区', '阿里地区', '日土县', 'RTX', null);
INSERT INTO `t_pub_city` VALUES ('3168', '542526', '改则县', '3', '0', '292', '西藏自治区', '阿里地区', '改则县', 'GZX', null);
INSERT INTO `t_pub_city` VALUES ('3169', '610103', '碑林区', '3', '0', '393', '陕西', '西安', '碑林区', 'BLQ', null);
INSERT INTO `t_pub_city` VALUES ('3170', '610111', '灞桥区', '3', '0', '393', '陕西', '西安', '灞桥区', 'BQQ', null);
INSERT INTO `t_pub_city` VALUES ('3171', '610115', '临潼区', '3', '0', '393', '陕西', '西安', '临潼区', 'LTQ', null);
INSERT INTO `t_pub_city` VALUES ('3172', '610117', '高陵区', '3', '0', '393', '陕西', '西安', '高陵区', 'GLQ', null);
INSERT INTO `t_pub_city` VALUES ('3173', '610125', '户县', '3', '0', '393', '陕西', '西安', '户县', 'HX', null);
INSERT INTO `t_pub_city` VALUES ('3174', '610203', '印台区', '3', '0', '293', '陕西', '铜川', '印台区', 'YTQ', null);
INSERT INTO `t_pub_city` VALUES ('3175', '610303', '金台区', '3', '0', '394', '陕西', '宝鸡', '金台区', 'JTQ', null);
INSERT INTO `t_pub_city` VALUES ('3176', '610322', '凤翔县', '3', '0', '394', '陕西', '宝鸡', '凤翔县', 'FXX', null);
INSERT INTO `t_pub_city` VALUES ('3177', '610326', '眉县', '3', '0', '394', '陕西', '宝鸡', '眉县', 'MX', null);
INSERT INTO `t_pub_city` VALUES ('3178', '610327', '陇县', '3', '0', '394', '陕西', '宝鸡', '陇县', 'LX', null);
INSERT INTO `t_pub_city` VALUES ('3179', '610329', '麟游县', '3', '0', '394', '陕西', '宝鸡', '麟游县', 'LYX', null);
INSERT INTO `t_pub_city` VALUES ('3180', '610331', '太白县', '3', '0', '394', '陕西', '宝鸡', '太白县', 'TBX', null);
INSERT INTO `t_pub_city` VALUES ('3181', '610404', '渭城区', '3', '0', '294', '陕西', '咸阳', '渭城区', 'WCQ', null);
INSERT INTO `t_pub_city` VALUES ('3182', '610423', '泾阳县', '3', '0', '294', '陕西', '咸阳', '泾阳县', 'JYX', null);
INSERT INTO `t_pub_city` VALUES ('3183', '610425', '礼泉县', '3', '0', '294', '陕西', '咸阳', '礼泉县', 'LQX', null);
INSERT INTO `t_pub_city` VALUES ('3184', '610427', '彬县', '3', '0', '294', '陕西', '咸阳', '彬县', 'BX', null);
INSERT INTO `t_pub_city` VALUES ('3185', '610429', '旬邑县', '3', '0', '294', '陕西', '咸阳', '旬邑县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('3186', '610481', '兴平', '3', '0', '294', '陕西', '咸阳', '兴平', 'XP', null);
INSERT INTO `t_pub_city` VALUES ('3187', '610503', '华州区', '3', '0', '395', '陕西', '渭南', '华州区', 'HZQ', null);
INSERT INTO `t_pub_city` VALUES ('3188', '610523', '大荔县', '3', '0', '395', '陕西', '渭南', '大荔县', 'DLX', null);
INSERT INTO `t_pub_city` VALUES ('3189', '610525', '澄城县', '3', '0', '395', '陕西', '渭南', '澄城县', 'CCX', null);
INSERT INTO `t_pub_city` VALUES ('3190', '610527', '白水县', '3', '0', '395', '陕西', '渭南', '白水县', 'BSX', null);
INSERT INTO `t_pub_city` VALUES ('3191', '610581', '韩城', '3', '0', '395', '陕西', '渭南', '韩城', 'HC', null);
INSERT INTO `t_pub_city` VALUES ('3192', '610602', '宝塔区', '3', '0', '295', '陕西', '延安', '宝塔区', 'BDQ', null);
INSERT INTO `t_pub_city` VALUES ('3193', '610622', '延川县', '3', '0', '295', '陕西', '延安', '延川县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('3194', '610624', '安塞县', '3', '0', '295', '陕西', '延安', '安塞县', 'ASX', null);
INSERT INTO `t_pub_city` VALUES ('3195', '610626', '吴起县', '3', '0', '295', '陕西', '延安', '吴起县', 'WQX', null);
INSERT INTO `t_pub_city` VALUES ('3196', '610628', '富县', '3', '0', '295', '陕西', '延安', '富县', 'FX', null);
INSERT INTO `t_pub_city` VALUES ('3197', '610630', '宜川县', '3', '0', '295', '陕西', '延安', '宜川县', 'YCX', null);
INSERT INTO `t_pub_city` VALUES ('3198', '610632', '黄陵县', '3', '0', '295', '陕西', '延安', '黄陵县', 'HLX', null);
INSERT INTO `t_pub_city` VALUES ('3199', '610722', '城固县', '3', '0', '296', '陕西', '汉中', '城固县', 'CGX', null);
INSERT INTO `t_pub_city` VALUES ('3200', '610724', '西乡县', '3', '0', '296', '陕西', '汉中', '西乡县', 'XXX', null);
INSERT INTO `t_pub_city` VALUES ('3201', '610726', '宁强县', '3', '0', '296', '陕西', '汉中', '宁强县', 'NJX', null);
INSERT INTO `t_pub_city` VALUES ('3202', '610728', '镇巴县', '3', '0', '296', '陕西', '汉中', '镇巴县', 'ZBX', null);
INSERT INTO `t_pub_city` VALUES ('3203', '610730', '佛坪县', '3', '0', '296', '陕西', '汉中', '佛坪县', 'FPX', null);
INSERT INTO `t_pub_city` VALUES ('3204', '610803', '横山区', '3', '0', '396', '陕西', '榆林', '横山区', 'HSQ', null);
INSERT INTO `t_pub_city` VALUES ('3205', '610822', '府谷县', '3', '0', '396', '陕西', '榆林', '府谷县', 'FGX', null);
INSERT INTO `t_pub_city` VALUES ('3206', '610825', '定边县', '3', '0', '396', '陕西', '榆林', '定边县', 'DBX', null);
INSERT INTO `t_pub_city` VALUES ('3207', '610827', '米脂县', '3', '0', '396', '陕西', '榆林', '米脂县', 'MZX', null);
INSERT INTO `t_pub_city` VALUES ('3208', '610829', '吴堡县', '3', '0', '396', '陕西', '榆林', '吴堡县', 'WBX', null);
INSERT INTO `t_pub_city` VALUES ('3209', '610831', '子洲县', '3', '0', '396', '陕西', '榆林', '子洲县', 'ZZX', null);
INSERT INTO `t_pub_city` VALUES ('3210', '610921', '汉阴县', '3', '0', '297', '陕西', '安康', '汉阴县', 'HYX', null);
INSERT INTO `t_pub_city` VALUES ('3211', '610923', '宁陕县', '3', '0', '297', '陕西', '安康', '宁陕县', 'NSX', null);
INSERT INTO `t_pub_city` VALUES ('3212', '610925', '岚皋县', '3', '0', '297', '陕西', '安康', '岚皋县', 'LGX', null);
INSERT INTO `t_pub_city` VALUES ('3213', '610928', '旬阳县', '3', '0', '297', '陕西', '安康', '旬阳县', 'XYX', null);
INSERT INTO `t_pub_city` VALUES ('3214', '611002', '商州区', '3', '0', '397', '陕西', '商洛', '商州区', 'SZQ', null);
INSERT INTO `t_pub_city` VALUES ('3215', '611022', '丹凤县', '3', '0', '397', '陕西', '商洛', '丹凤县', 'DFX', null);
INSERT INTO `t_pub_city` VALUES ('3216', '611024', '山阳县', '3', '0', '397', '陕西', '商洛', '山阳县', 'SYX', null);
INSERT INTO `t_pub_city` VALUES ('3217', '611026', '柞水县', '3', '0', '397', '陕西', '商洛', '柞水县', 'ZSX', null);
INSERT INTO `t_pub_city` VALUES ('3218', '620103', '七里河区', '3', '0', '298', '甘肃', '兰州', '七里河区', 'QLHQ', null);
INSERT INTO `t_pub_city` VALUES ('3219', '620105', '安宁区', '3', '0', '298', '甘肃', '兰州', '安宁区', 'ANQ', null);
INSERT INTO `t_pub_city` VALUES ('3220', '620121', '永登县', '3', '0', '298', '甘肃', '兰州', '永登县', 'YDX', null);
INSERT INTO `t_pub_city` VALUES ('3221', '430801', '张家界市区', '3', '0', '239', '湖南', '张家界', '张家界市区', 'ZJJSQ', '1');
INSERT INTO `t_pub_city` VALUES ('3465', '3465', '大洋洲', '1', '1', null, '大洋洲', null, null, 'DYZ', null);
INSERT INTO `t_pub_city` VALUES ('3466', '3466', '亚洲', '1', '1', null, '亚洲', null, null, 'YZ', null);
INSERT INTO `t_pub_city` VALUES ('3467', '3467', '欧洲', '1', '1', null, '欧洲', null, null, 'OZ', null);
INSERT INTO `t_pub_city` VALUES ('3468', '3468', '美洲', '1', '1', null, '美洲', null, null, 'MZ', null);
INSERT INTO `t_pub_city` VALUES ('3469', '3469', '其他', '1', '1', null, '其他', null, null, 'QT', null);
INSERT INTO `t_pub_city` VALUES ('3470', '3470', '非洲', '1', '1', null, '非洲', null, null, 'FZ', null);
INSERT INTO `t_pub_city` VALUES ('3471', '3471', '瓦努阿图', '2', '1', '3465', '大洋洲', '瓦努阿图', null, 'WNAT', null);
INSERT INTO `t_pub_city` VALUES ('3472', '3472', '密克罗尼西亚联邦', '2', '1', '3465', '大洋洲', '密克罗尼西亚联邦', null, 'MKLNXYLB', null);
INSERT INTO `t_pub_city` VALUES ('3473', '3473', '帕劳', '2', '1', '3465', '大洋洲', '帕劳', null, 'PL', null);
INSERT INTO `t_pub_city` VALUES ('3474', '3474', '马绍尔群岛', '2', '1', '3465', '大洋洲', '马绍尔群岛', null, 'MSEQD', null);
INSERT INTO `t_pub_city` VALUES ('3475', '3475', '基里巴斯', '2', '1', '3465', '大洋洲', '基里巴斯', null, 'JLBS', null);
INSERT INTO `t_pub_city` VALUES ('3476', '3476', '萨摩亚', '2', '1', '3465', '大洋洲', '萨摩亚', null, 'SMY', null);
INSERT INTO `t_pub_city` VALUES ('3477', '3477', '瑙鲁', '2', '1', '3465', '大洋洲', '瑙鲁', null, 'NL', null);
INSERT INTO `t_pub_city` VALUES ('3478', '3478', '所罗门群岛', '2', '1', '3465', '大洋洲', '所罗门群岛', null, 'SLMQD', null);
INSERT INTO `t_pub_city` VALUES ('3479', '3479', '图瓦卢', '2', '1', '3465', '大洋洲', '图瓦卢', null, 'TWL', null);
INSERT INTO `t_pub_city` VALUES ('3480', '3480', '巴布亚新几内亚', '2', '1', '3465', '大洋洲', '巴布亚新几内亚', null, 'BBYXJNY', null);
INSERT INTO `t_pub_city` VALUES ('3481', '3481', '汤加', '2', '1', '3465', '大洋洲', '汤加', null, 'SJ', null);
INSERT INTO `t_pub_city` VALUES ('3482', '3482', '斐济', '2', '1', '3465', '大洋洲', '斐济', null, 'FJ', null);
INSERT INTO `t_pub_city` VALUES ('3483', '3483', '新西兰', '2', '1', '3465', '大洋洲', '新西兰', null, 'XXL', null);
INSERT INTO `t_pub_city` VALUES ('3484', '3484', '澳大利亚', '2', '1', '3465', '大洋洲', '澳大利亚', null, 'ADLY', null);
INSERT INTO `t_pub_city` VALUES ('3485', '3485', '克什米尔', '2', '1', '3466', '亚洲', '克什米尔', null, 'KSME', null);
INSERT INTO `t_pub_city` VALUES ('3486', '3486', '塞浦路斯', '2', '1', '3466', '亚洲', '塞浦路斯', null, 'SPLS', null);
INSERT INTO `t_pub_city` VALUES ('3487', '3487', '亚美尼亚', '2', '1', '3466', '亚洲', '亚美尼亚', null, 'YMNY', null);
INSERT INTO `t_pub_city` VALUES ('3488', '3488', '格鲁吉亚', '2', '1', '3466', '亚洲', '格鲁吉亚', null, 'GLJY', null);
INSERT INTO `t_pub_city` VALUES ('3489', '3489', '阿塞拜疆', '2', '1', '3466', '亚洲', '阿塞拜疆', null, 'ASBJ', null);
INSERT INTO `t_pub_city` VALUES ('3490', '3490', '土库曼斯坦', '2', '1', '3466', '亚洲', '土库曼斯坦', null, 'TKMST', null);
INSERT INTO `t_pub_city` VALUES ('3491', '3491', '塔吉克斯坦', '2', '1', '3466', '亚洲', '塔吉克斯坦', null, 'DJKST', null);
INSERT INTO `t_pub_city` VALUES ('3492', '3492', '吉尔吉斯斯坦', '2', '1', '3466', '亚洲', '吉尔吉斯斯坦', null, 'JEJSST', null);
INSERT INTO `t_pub_city` VALUES ('3493', '3493', '乌兹别克斯坦', '2', '1', '3466', '亚洲', '乌兹别克斯坦', null, 'WCBKST', null);
INSERT INTO `t_pub_city` VALUES ('3494', '3494', '哈萨克斯坦', '2', '1', '3466', '亚洲', '哈萨克斯坦', null, 'HSKST', null);
INSERT INTO `t_pub_city` VALUES ('3495', '3495', '土耳其', '2', '1', '3466', '亚洲', '土耳其', null, 'TEJ', null);
INSERT INTO `t_pub_city` VALUES ('3496', '3496', '蒙古', '2', '1', '3466', '亚洲', '蒙古', null, 'MG', null);
INSERT INTO `t_pub_city` VALUES ('3497', '3497', '黎巴嫩', '2', '1', '3466', '亚洲', '黎巴嫩', null, 'LBN', null);
INSERT INTO `t_pub_city` VALUES ('3498', '3498', '卡塔尔', '2', '1', '3466', '亚洲', '卡塔尔', null, 'KDE', null);
INSERT INTO `t_pub_city` VALUES ('3499', '3499', '巴勒斯坦', '2', '1', '3466', '亚洲', '巴勒斯坦', null, 'BLST', null);
INSERT INTO `t_pub_city` VALUES ('3500', '3500', '叙利亚', '2', '1', '3466', '亚洲', '叙利亚', null, 'XLY', null);
INSERT INTO `t_pub_city` VALUES ('3501', '3501', '巴林', '2', '1', '3466', '亚洲', '巴林', null, 'BL', null);
INSERT INTO `t_pub_city` VALUES ('3502', '3502', '科威特', '2', '1', '3466', '亚洲', '科威特', null, 'KWT', null);
INSERT INTO `t_pub_city` VALUES ('3503', '3503', '阿曼', '2', '1', '3466', '亚洲', '阿曼', null, 'AM', null);
INSERT INTO `t_pub_city` VALUES ('3504', '3504', '阿联酋', '2', '1', '3466', '亚洲', '阿联酋', null, 'ALQ', null);
INSERT INTO `t_pub_city` VALUES ('3505', '3505', '沙特阿拉伯', '2', '1', '3466', '亚洲', '沙特阿拉伯', null, 'STALB', null);
INSERT INTO `t_pub_city` VALUES ('3506', '3506', '约旦', '2', '1', '3466', '亚洲', '约旦', null, 'YD', null);
INSERT INTO `t_pub_city` VALUES ('3507', '3507', '伊朗', '2', '1', '3466', '亚洲', '伊朗', null, 'YL', null);
INSERT INTO `t_pub_city` VALUES ('3508', '3508', '伊拉克', '2', '1', '3466', '亚洲', '伊拉克', null, 'YLK', null);
INSERT INTO `t_pub_city` VALUES ('3509', '3509', '印度尼西亚', '2', '1', '3466', '亚洲', '印度尼西亚', null, 'YDNXY', null);
INSERT INTO `t_pub_city` VALUES ('3510', '3510', '东帝汶', '2', '1', '3466', '亚洲', '东帝汶', null, 'DDW', null);
INSERT INTO `t_pub_city` VALUES ('3511', '3511', '文莱', '2', '1', '3466', '亚洲', '文莱', null, 'WL', null);
INSERT INTO `t_pub_city` VALUES ('3512', '3512', '马尔代夫', '2', '1', '3466', '亚洲', '马尔代夫', null, 'MEDF', null);
INSERT INTO `t_pub_city` VALUES ('3513', '3513', '新加坡', '2', '1', '3466', '亚洲', '新加坡', null, 'XJP', null);
INSERT INTO `t_pub_city` VALUES ('3514', '3514', '菲律宾', '2', '1', '3466', '亚洲', '菲律宾', null, 'FLB', null);
INSERT INTO `t_pub_city` VALUES ('3515', '3515', '也门', '2', '1', '3466', '亚洲', '也门', null, 'YM', null);
INSERT INTO `t_pub_city` VALUES ('3516', '3516', '以色列', '2', '1', '3466', '亚洲', '以色列', null, 'YSL', null);
INSERT INTO `t_pub_city` VALUES ('3517', '3517', '老挝', '2', '1', '3466', '亚洲', '老挝', null, 'LW', null);
INSERT INTO `t_pub_city` VALUES ('3518', '3518', '尼泊尔', '2', '1', '3466', '亚洲', '尼泊尔', null, 'NBE', null);
INSERT INTO `t_pub_city` VALUES ('3519', '3519', '柬埔寨', '2', '1', '3466', '亚洲', '柬埔寨', null, 'JBZ', null);
INSERT INTO `t_pub_city` VALUES ('3520', '3520', '阿富汗', '2', '1', '3466', '亚洲', '阿富汗', null, 'AFH', null);
INSERT INTO `t_pub_city` VALUES ('3521', '3521', '不丹', '2', '1', '3466', '亚洲', '不丹', null, 'BD', null);
INSERT INTO `t_pub_city` VALUES ('3522', '3522', '孟加拉国', '2', '1', '3466', '亚洲', '孟加拉国', null, 'MJLG', null);
INSERT INTO `t_pub_city` VALUES ('3523', '3523', '缅甸', '2', '1', '3466', '亚洲', '缅甸', null, 'MD', null);
INSERT INTO `t_pub_city` VALUES ('3524', '3524', '斯里兰卡', '2', '1', '3466', '亚洲', '斯里兰卡', null, 'SLLK', null);
INSERT INTO `t_pub_city` VALUES ('3525', '3525', '越南', '2', '1', '3466', '亚洲', '越南', null, 'YN', null);
INSERT INTO `t_pub_city` VALUES ('3526', '3526', '泰国', '2', '1', '3466', '亚洲', '泰国', null, 'TG', null);
INSERT INTO `t_pub_city` VALUES ('3527', '3527', '巴基斯坦', '2', '1', '3466', '亚洲', '巴基斯坦', null, 'BJST', null);
INSERT INTO `t_pub_city` VALUES ('3528', '3528', '印度', '2', '1', '3466', '亚洲', '印度', null, 'YD', null);
INSERT INTO `t_pub_city` VALUES ('3529', '3529', '马来西亚', '2', '1', '3466', '亚洲', '马来西亚', null, 'MLXY', null);
INSERT INTO `t_pub_city` VALUES ('3530', '3530', '日本', '2', '1', '3466', '亚洲', '日本', null, 'RB', null);
INSERT INTO `t_pub_city` VALUES ('3531', '3531', '朝鲜', '2', '1', '3466', '亚洲', '朝鲜', null, 'CX', null);
INSERT INTO `t_pub_city` VALUES ('3532', '3532', '韩国', '2', '1', '3466', '亚洲', '韩国', null, 'HG', null);
INSERT INTO `t_pub_city` VALUES ('3533', '3533', '黑山', '2', '1', '3467', '欧洲', '黑山', null, 'HS', null);
INSERT INTO `t_pub_city` VALUES ('3534', '3534', '摩尔多瓦', '2', '1', '3467', '欧洲', '摩尔多瓦', null, 'MEDW', null);
INSERT INTO `t_pub_city` VALUES ('3535', '3535', '白俄罗斯', '2', '1', '3467', '欧洲', '白俄罗斯', null, 'BELS', null);
INSERT INTO `t_pub_city` VALUES ('3536', '3536', '乌克兰', '2', '1', '3467', '欧洲', '乌克兰', null, 'WKL', null);
INSERT INTO `t_pub_city` VALUES ('3537', '3537', '奥地利', '2', '1', '3467', '欧洲', '奥地利', null, 'ADL', null);
INSERT INTO `t_pub_city` VALUES ('3538', '3538', '俄罗斯', '2', '1', '3467', '欧洲', '俄罗斯', null, 'ELS', null);
INSERT INTO `t_pub_city` VALUES ('3539', '3539', '芬兰', '2', '1', '3467', '欧洲', '芬兰', null, 'FL', null);
INSERT INTO `t_pub_city` VALUES ('3540', '3540', '安道尔', '2', '1', '3467', '欧洲', '安道尔', null, 'ADE', null);
INSERT INTO `t_pub_city` VALUES ('3541', '3541', '冰岛', '2', '1', '3467', '欧洲', '冰岛', null, 'BD', null);
INSERT INTO `t_pub_city` VALUES ('3542', '3542', '列支敦士登', '2', '1', '3467', '欧洲', '列支敦士登', null, 'LZDSD', null);
INSERT INTO `t_pub_city` VALUES ('3543', '3543', '匈牙利', '2', '1', '3467', '欧洲', '匈牙利', null, 'XYL', null);
INSERT INTO `t_pub_city` VALUES ('3544', '3544', '圣马力诺', '2', '1', '3467', '欧洲', '圣马力诺', null, 'SMLN', null);
INSERT INTO `t_pub_city` VALUES ('3545', '3545', '西班牙', '2', '1', '3467', '欧洲', '西班牙', null, 'XBY', null);
INSERT INTO `t_pub_city` VALUES ('3546', '3546', '波斯尼亚和黑塞哥维那', '2', '1', '3467', '欧洲', '波斯尼亚和黑塞哥维那', null, 'BSNYHHSGWN', null);
INSERT INTO `t_pub_city` VALUES ('3547', '3547', '卢森堡', '2', '1', '3467', '欧洲', '卢森堡', null, 'LSB', null);
INSERT INTO `t_pub_city` VALUES ('3548', '3548', '丹麦', '2', '1', '3467', '欧洲', '丹麦', null, 'DM', null);
INSERT INTO `t_pub_city` VALUES ('3549', '3549', '马耳他', '2', '1', '3467', '欧洲', '马耳他', null, 'MET', null);
INSERT INTO `t_pub_city` VALUES ('3550', '3550', '比利时', '2', '1', '3467', '欧洲', '比利时', null, 'BLS', null);
INSERT INTO `t_pub_city` VALUES ('3551', '3551', '梵蒂冈', '2', '1', '3467', '欧洲', '梵蒂冈', null, 'FDG', null);
INSERT INTO `t_pub_city` VALUES ('3552', '3552', '克罗地亚', '2', '1', '3467', '欧洲', '克罗地亚', null, 'KLDY', null);
INSERT INTO `t_pub_city` VALUES ('3553', '3553', '马其顿', '2', '1', '3467', '欧洲', '马其顿', null, 'MJD', null);
INSERT INTO `t_pub_city` VALUES ('3554', '3554', '斯洛文尼亚', '2', '1', '3467', '欧洲', '斯洛文尼亚', null, 'SLWNY', null);
INSERT INTO `t_pub_city` VALUES ('3555', '3555', '葡萄牙', '2', '1', '3467', '欧洲', '葡萄牙', null, 'PTY', null);
INSERT INTO `t_pub_city` VALUES ('3556', '3556', '斯洛伐克', '2', '1', '3467', '欧洲', '斯洛伐克', null, 'SLFK', null);
INSERT INTO `t_pub_city` VALUES ('3557', '3557', '捷克', '2', '1', '3467', '欧洲', '捷克', null, 'JK', null);
INSERT INTO `t_pub_city` VALUES ('3558', '3558', '爱尔兰', '2', '1', '3467', '欧洲', '爱尔兰', null, 'AEL', null);
INSERT INTO `t_pub_city` VALUES ('3559', '3559', '荷兰', '2', '1', '3467', '欧洲', '荷兰', null, 'HL', null);
INSERT INTO `t_pub_city` VALUES ('3560', '3560', '立陶宛', '2', '1', '3467', '欧洲', '立陶宛', null, 'LTW', null);
INSERT INTO `t_pub_city` VALUES ('3561', '3561', '爱沙尼亚', '2', '1', '3467', '欧洲', '爱沙尼亚', null, 'ASNY', null);
INSERT INTO `t_pub_city` VALUES ('3562', '3562', '保加利亚', '2', '1', '3467', '欧洲', '保加利亚', null, 'BJLY', null);
INSERT INTO `t_pub_city` VALUES ('3563', '3563', '塞尔维亚', '2', '1', '3467', '欧洲', '塞尔维亚', null, 'SEWY', null);
INSERT INTO `t_pub_city` VALUES ('3564', '3564', '挪威', '2', '1', '3467', '欧洲', '挪威', null, 'NW', null);
INSERT INTO `t_pub_city` VALUES ('3565', '3565', '阿尔巴尼亚', '2', '1', '3467', '欧洲', '阿尔巴尼亚', null, 'AEBNY', null);
INSERT INTO `t_pub_city` VALUES ('3566', '3566', '希腊', '2', '1', '3467', '欧洲', '希腊', null, 'XL', null);
INSERT INTO `t_pub_city` VALUES ('3567', '3567', '拉脱维亚', '2', '1', '3467', '欧洲', '拉脱维亚', null, 'LTWY', null);
INSERT INTO `t_pub_city` VALUES ('3568', '3568', '摩纳哥', '2', '1', '3467', '欧洲', '摩纳哥', null, 'MNG', null);
INSERT INTO `t_pub_city` VALUES ('3569', '3569', '德国', '2', '1', '3467', '欧洲', '德国', null, 'DG', null);
INSERT INTO `t_pub_city` VALUES ('3570', '3570', '意大利', '2', '1', '3467', '欧洲', '意大利', null, 'YDL', null);
INSERT INTO `t_pub_city` VALUES ('3571', '3571', '瑞典', '2', '1', '3467', '欧洲', '瑞典', null, 'RD', null);
INSERT INTO `t_pub_city` VALUES ('3572', '3572', '瑞士', '2', '1', '3467', '欧洲', '瑞士', null, 'RS', null);
INSERT INTO `t_pub_city` VALUES ('3573', '3573', '波兰', '2', '1', '3467', '欧洲', '波兰', null, 'BL', null);
INSERT INTO `t_pub_city` VALUES ('3574', '3574', '法国', '2', '1', '3467', '欧洲', '法国', null, 'FG', null);
INSERT INTO `t_pub_city` VALUES ('3575', '3575', '罗马尼亚', '2', '1', '3467', '欧洲', '罗马尼亚', null, 'LMNY', null);
INSERT INTO `t_pub_city` VALUES ('3576', '3576', '英国', '2', '1', '3467', '欧洲', '英国', null, 'YG', null);
INSERT INTO `t_pub_city` VALUES ('3577', '3577', '特立尼达和多巴哥', '2', '1', '3468', '美洲', '特立尼达和多巴哥', null, 'TLNDHDBG', null);
INSERT INTO `t_pub_city` VALUES ('3578', '3578', '哥斯达黎加', '2', '1', '3468', '美洲', '哥斯达黎加', null, 'GSDLJ', null);
INSERT INTO `t_pub_city` VALUES ('3579', '3579', '伯利兹', '2', '1', '3468', '美洲', '伯利兹', null, 'BLC', null);
INSERT INTO `t_pub_city` VALUES ('3580', '3580', '苏里南', '2', '1', '3468', '美洲', '苏里南', null, 'SLN', null);
INSERT INTO `t_pub_city` VALUES ('3581', '3581', '安提瓜和巴布达', '2', '1', '3468', '美洲', '安提瓜和巴布达', null, 'ADGHBBD', null);
INSERT INTO `t_pub_city` VALUES ('3582', '3582', '哥伦比亚', '2', '1', '3468', '美洲', '哥伦比亚', null, 'GLBY', null);
INSERT INTO `t_pub_city` VALUES ('3583', '3583', '委内瑞拉', '2', '1', '3468', '美洲', '委内瑞拉', null, 'WNRL', null);
INSERT INTO `t_pub_city` VALUES ('3584', '3584', '阿根廷', '2', '1', '3468', '美洲', '阿根廷', null, 'AGT', null);
INSERT INTO `t_pub_city` VALUES ('3585', '3585', '多米尼克', '2', '1', '3468', '美洲', '多米尼克', null, 'DMNK', null);
INSERT INTO `t_pub_city` VALUES ('3586', '3586', '墨西哥', '2', '1', '3468', '美洲', '墨西哥', null, 'MXG', null);
INSERT INTO `t_pub_city` VALUES ('3587', '3587', '多米尼加', '2', '1', '3468', '美洲', '多米尼加', null, 'DMNJ', null);
INSERT INTO `t_pub_city` VALUES ('3588', '3588', '危地马拉', '2', '1', '3468', '美洲', '危地马拉', null, 'WDML', null);
INSERT INTO `t_pub_city` VALUES ('3589', '3589', '圭亚那', '2', '1', '3468', '美洲', '圭亚那', null, 'GYN', null);
INSERT INTO `t_pub_city` VALUES ('3590', '3590', '圣卢西亚', '2', '1', '3468', '美洲', '圣卢西亚', null, 'SLXY', null);
INSERT INTO `t_pub_city` VALUES ('3591', '3591', '巴巴多斯', '2', '1', '3468', '美洲', '巴巴多斯', null, 'BBDS', null);
INSERT INTO `t_pub_city` VALUES ('3592', '3592', '乌拉圭', '2', '1', '3468', '美洲', '乌拉圭', null, 'WLG', null);
INSERT INTO `t_pub_city` VALUES ('3593', '3593', '牙买加', '2', '1', '3468', '美洲', '牙买加', null, 'YMJ', null);
INSERT INTO `t_pub_city` VALUES ('3594', '3594', '厄瓜多尔', '2', '1', '3468', '美洲', '厄瓜多尔', null, 'EGDE', null);
INSERT INTO `t_pub_city` VALUES ('3595', '3595', '洪都拉斯', '2', '1', '3468', '美洲', '洪都拉斯', null, 'HDLS', null);
INSERT INTO `t_pub_city` VALUES ('3596', '3596', '巴西', '2', '1', '3468', '美洲', '巴西', null, 'BX', null);
INSERT INTO `t_pub_city` VALUES ('3597', '3597', '巴拉圭', '2', '1', '3468', '美洲', '巴拉圭', null, 'BLG', null);
INSERT INTO `t_pub_city` VALUES ('3598', '3598', '格林纳达', '2', '1', '3468', '美洲', '格林纳达', null, 'GLND', null);
INSERT INTO `t_pub_city` VALUES ('3599', '3599', '玻利维亚', '2', '1', '3468', '美洲', '玻利维亚', null, 'BLWY', null);
INSERT INTO `t_pub_city` VALUES ('3600', '3600', '巴拿马', '2', '1', '3468', '美洲', '巴拿马', null, 'BNM', null);
INSERT INTO `t_pub_city` VALUES ('3601', '3601', '巴哈马', '2', '1', '3468', '美洲', '巴哈马', null, 'BHM', null);
INSERT INTO `t_pub_city` VALUES ('3602', '3602', '尼加拉瓜', '2', '1', '3468', '美洲', '尼加拉瓜', null, 'NJLG', null);
INSERT INTO `t_pub_city` VALUES ('3603', '3603', '古巴', '2', '1', '3468', '美洲', '古巴', null, 'GB', null);
INSERT INTO `t_pub_city` VALUES ('3604', '3604', '智利', '2', '1', '3468', '美洲', '智利', null, 'ZL', null);
INSERT INTO `t_pub_city` VALUES ('3605', '3605', '萨尔瓦多', '2', '1', '3468', '美洲', '萨尔瓦多', null, 'SEWD', null);
INSERT INTO `t_pub_city` VALUES ('3606', '3606', '海地', '2', '1', '3468', '美洲', '海地', null, 'HD', null);
INSERT INTO `t_pub_city` VALUES ('3607', '3607', '秘鲁', '2', '1', '3468', '美洲', '秘鲁', null, 'BL', null);
INSERT INTO `t_pub_city` VALUES ('3608', '3608', '加拿大', '2', '1', '3468', '美洲', '加拿大', null, 'JND', null);
INSERT INTO `t_pub_city` VALUES ('3609', '3609', '美国', '2', '1', '3468', '美洲', '美国', null, 'MG', null);
INSERT INTO `t_pub_city` VALUES ('3610', '3610', '留尼汪', '2', '1', '3469', '其他', '留尼汪', null, 'LNW', null);
INSERT INTO `t_pub_city` VALUES ('3611', '3611', '荷属安的列斯', '2', '1', '3469', '其他', '荷属安的列斯', null, 'HSADLS', null);
INSERT INTO `t_pub_city` VALUES ('3612', '3612', '瓜德罗普岛（法）', '2', '1', '3469', '其他', '瓜德罗普岛（法）', null, 'GDLPD（F）', null);
INSERT INTO `t_pub_city` VALUES ('3613', '3613', '波多黎各岛（美）', '2', '1', '3469', '其他', '波多黎各岛（美）', null, 'BDLGD（M）', null);
INSERT INTO `t_pub_city` VALUES ('3614', '3614', '格陵兰（丹）', '2', '1', '3469', '其他', '格陵兰（丹）', null, 'GLL（D）', null);
INSERT INTO `t_pub_city` VALUES ('3615', '3615', '皮特凯恩（英）', '2', '1', '3469', '其他', '皮特凯恩（英）', null, 'PTKE（Y）', null);
INSERT INTO `t_pub_city` VALUES ('3616', '3616', '纽埃（新）', '2', '1', '3469', '其他', '纽埃（新）', null, 'NA（X）', null);
INSERT INTO `t_pub_city` VALUES ('3617', '3617', '新喀里多尼克', '2', '1', '3469', '其他', '新喀里多尼克', null, 'XKLDNK', null);
INSERT INTO `t_pub_city` VALUES ('3618', '3618', '圣赫勒拿', '2', '1', '3469', '其他', '圣赫勒拿', null, 'SHLN', null);
INSERT INTO `t_pub_city` VALUES ('3619', '3619', '阿鲁巴（荷）', '2', '1', '3469', '其他', '阿鲁巴（荷）', null, 'ALB（H）', null);
INSERT INTO `t_pub_city` VALUES ('3620', '3620', '英属维尔京群岛', '2', '1', '3469', '其他', '英属维尔京群岛', null, 'YSWEJQD', null);
INSERT INTO `t_pub_city` VALUES ('3621', '3621', '开曼群岛', '2', '1', '3469', '其他', '开曼群岛', null, 'KMQD', null);
INSERT INTO `t_pub_city` VALUES ('3622', '3622', '关岛（美）', '2', '1', '3469', '其他', '关岛（美）', null, 'GD（M）', null);
INSERT INTO `t_pub_city` VALUES ('3623', '3623', '法属圭亚那', '2', '1', '3469', '其他', '法属圭亚那', null, 'FSGYN', null);
INSERT INTO `t_pub_city` VALUES ('3624', '3624', '美属萨摩亚', '2', '1', '3469', '其他', '美属萨摩亚', null, 'MSSMY', null);
INSERT INTO `t_pub_city` VALUES ('3625', '3625', '西撒哈拉', '2', '1', '3469', '其他', '西撒哈拉', null, 'XSHL', null);
INSERT INTO `t_pub_city` VALUES ('3626', '3626', '马尔维纳斯群岛', '2', '1', '3469', '其他', '马尔维纳斯群岛', null, 'MEWNSQD', null);
INSERT INTO `t_pub_city` VALUES ('3627', '3627', '加那利群岛', '2', '1', '3469', '其他', '加那利群岛', null, 'JNLQD', null);
INSERT INTO `t_pub_city` VALUES ('3628', '3628', '马提尼克岛（法）', '2', '1', '3469', '其他', '马提尼克岛（法）', null, 'MDNKD（F）', null);
INSERT INTO `t_pub_city` VALUES ('3629', '3629', '美属维尔京群岛', '2', '1', '3469', '其他', '美属维尔京群岛', null, 'MSWEJQD', null);
INSERT INTO `t_pub_city` VALUES ('3630', '3630', '百慕大群岛（英）', '2', '1', '3469', '其他', '百慕大群岛（英）', null, 'BMDQD（Y）', null);
INSERT INTO `t_pub_city` VALUES ('3631', '3631', '北马里亚纳群岛', '2', '1', '3469', '其他', '北马里亚纳群岛', null, 'BMLYNQD', null);
INSERT INTO `t_pub_city` VALUES ('3632', '3632', '法属波利尼西亚', '2', '1', '3469', '其他', '法属波利尼西亚', null, 'FSBLNXY', null);
INSERT INTO `t_pub_city` VALUES ('3633', '3633', '库克群岛', '2', '1', '3469', '其他', '库克群岛', null, 'KKQD', null);
INSERT INTO `t_pub_city` VALUES ('3634', '3634', '克什米尔', '2', '1', '3469', '其他', '克什米尔', null, 'KSME', null);
INSERT INTO `t_pub_city` VALUES ('3635', '3635', '南苏丹', '2', '1', '3470', '非洲', '南苏丹', null, 'NSD', null);
INSERT INTO `t_pub_city` VALUES ('3636', '3636', '塞内加尔', '2', '1', '3470', '非洲', '塞内加尔', null, 'SNJE', null);
INSERT INTO `t_pub_city` VALUES ('3637', '3637', '喀麦隆', '2', '1', '3470', '非洲', '喀麦隆', null, 'KML', null);
INSERT INTO `t_pub_city` VALUES ('3638', '3638', '科特迪瓦', '2', '1', '3470', '非洲', '科特迪瓦', null, 'KTDW', null);
INSERT INTO `t_pub_city` VALUES ('3639', '3639', '索马里', '2', '1', '3470', '非洲', '索马里', null, 'SML', null);
INSERT INTO `t_pub_city` VALUES ('3640', '3640', '莫桑比克', '2', '1', '3470', '非洲', '莫桑比克', null, 'MSBK', null);
INSERT INTO `t_pub_city` VALUES ('3641', '3641', '莱索托', '2', '1', '3470', '非洲', '莱索托', null, 'LST', null);
INSERT INTO `t_pub_city` VALUES ('3642', '3642', '突尼斯', '2', '1', '3470', '非洲', '突尼斯', null, 'TNS', null);
INSERT INTO `t_pub_city` VALUES ('3643', '3643', '津巴布韦', '2', '1', '3470', '非洲', '津巴布韦', null, 'JBBW', null);
INSERT INTO `t_pub_city` VALUES ('3644', '3644', '科摩罗', '2', '1', '3470', '非洲', '科摩罗', null, 'KML', null);
INSERT INTO `t_pub_city` VALUES ('3645', '3645', '南非', '2', '1', '3470', '非洲', '南非', null, 'NF', null);
INSERT INTO `t_pub_city` VALUES ('3646', '3646', '肯尼亚', '2', '1', '3470', '非洲', '肯尼亚', null, 'KNY', null);
INSERT INTO `t_pub_city` VALUES ('3647', '3647', '坦桑尼亚', '2', '1', '3470', '非洲', '坦桑尼亚', null, 'TSNY', null);
INSERT INTO `t_pub_city` VALUES ('3648', '3648', '赞比亚', '2', '1', '3470', '非洲', '赞比亚', null, 'ZBY', null);
INSERT INTO `t_pub_city` VALUES ('3649', '3649', '斯威士兰', '2', '1', '3470', '非洲', '斯威士兰', null, 'SWSL', null);
INSERT INTO `t_pub_city` VALUES ('3650', '3650', '厄立特里亚', '2', '1', '3470', '非洲', '厄立特里亚', null, 'ELTLY', null);
INSERT INTO `t_pub_city` VALUES ('3651', '3651', '纳米比亚', '2', '1', '3470', '非洲', '纳米比亚', null, 'NMBY', null);
INSERT INTO `t_pub_city` VALUES ('3652', '3652', '阿尔及利亚', '2', '1', '3470', '非洲', '阿尔及利亚', null, 'AEJLY', null);
INSERT INTO `t_pub_city` VALUES ('3653', '3653', '佛得角', '2', '1', '3470', '非洲', '佛得角', null, 'FDJ', null);
INSERT INTO `t_pub_city` VALUES ('3654', '3654', '利比里亚', '2', '1', '3470', '非洲', '利比里亚', null, 'LBLY', null);
INSERT INTO `t_pub_city` VALUES ('3655', '3655', '利比亚', '2', '1', '3470', '非洲', '利比亚', null, 'LBY', null);
INSERT INTO `t_pub_city` VALUES ('3656', '3656', '苏丹', '2', '1', '3470', '非洲', '苏丹', null, 'SD', null);
INSERT INTO `t_pub_city` VALUES ('3657', '3657', '多哥', '2', '1', '3470', '非洲', '多哥', null, 'DG', null);
INSERT INTO `t_pub_city` VALUES ('3658', '3658', '刚果', '2', '1', '3470', '非洲', '刚果', null, 'GG', null);
INSERT INTO `t_pub_city` VALUES ('3659', '3659', '吉布提', '2', '1', '3470', '非洲', '吉布提', null, 'JBD', null);
INSERT INTO `t_pub_city` VALUES ('3660', '3660', '圣多美和普林西比', '2', '1', '3470', '非洲', '圣多美和普林西比', null, 'SDMHPLXB', null);
INSERT INTO `t_pub_city` VALUES ('3661', '3661', '加蓬', '2', '1', '3470', '非洲', '加蓬', null, 'JP', null);
INSERT INTO `t_pub_city` VALUES ('3662', '3662', '加纳', '2', '1', '3470', '非洲', '加纳', null, 'JN', null);
INSERT INTO `t_pub_city` VALUES ('3663', '3663', '尼日利亚', '2', '1', '3470', '非洲', '尼日利亚', null, 'NRLY', null);
INSERT INTO `t_pub_city` VALUES ('3664', '3664', '尼日尔', '2', '1', '3470', '非洲', '尼日尔', null, 'NRE', null);
INSERT INTO `t_pub_city` VALUES ('3665', '3665', '乍得', '2', '1', '3470', '非洲', '乍得', null, 'ZD', null);
INSERT INTO `t_pub_city` VALUES ('3666', '3666', '卢旺达', '2', '1', '3470', '非洲', '卢旺达', null, 'LWD', null);
INSERT INTO `t_pub_city` VALUES ('3667', '3667', '布隆迪', '2', '1', '3470', '非洲', '布隆迪', null, 'BLD', null);
INSERT INTO `t_pub_city` VALUES ('3668', '3668', '摩洛哥', '2', '1', '3470', '非洲', '摩洛哥', null, 'MLG', null);
INSERT INTO `t_pub_city` VALUES ('3669', '3669', '塞拉利昂', '2', '1', '3470', '非洲', '塞拉利昂', null, 'SLLA', null);
INSERT INTO `t_pub_city` VALUES ('3670', '3670', '塞舌尔', '2', '1', '3470', '非洲', '塞舌尔', null, 'SSE', null);
INSERT INTO `t_pub_city` VALUES ('3671', '3671', '乌干达', '2', '1', '3470', '非洲', '乌干达', null, 'WGD', null);
INSERT INTO `t_pub_city` VALUES ('3672', '3672', '毛里塔尼亚', '2', '1', '3470', '非洲', '毛里塔尼亚', null, 'MLDNY', null);
INSERT INTO `t_pub_city` VALUES ('3673', '3673', '毛里求斯', '2', '1', '3470', '非洲', '毛里求斯', null, 'MLQS', null);
INSERT INTO `t_pub_city` VALUES ('3674', '3674', '贝宁', '2', '1', '3470', '非洲', '贝宁', null, 'BN', null);
INSERT INTO `t_pub_city` VALUES ('3675', '3675', '冈比亚', '2', '1', '3470', '非洲', '冈比亚', null, 'GBY', null);
INSERT INTO `t_pub_city` VALUES ('3676', '3676', '赤道几内亚', '2', '1', '3470', '非洲', '赤道几内亚', null, 'CDJNY', null);
INSERT INTO `t_pub_city` VALUES ('3677', '3677', '刚果民主共和国', '2', '1', '3470', '非洲', '刚果民主共和国', null, 'GGMZGHG', null);
INSERT INTO `t_pub_city` VALUES ('3678', '3678', '马拉维', '2', '1', '3470', '非洲', '马拉维', null, 'MLW', null);
INSERT INTO `t_pub_city` VALUES ('3679', '3679', '马里', '2', '1', '3470', '非洲', '马里', null, 'ML', null);
INSERT INTO `t_pub_city` VALUES ('3680', '3680', '马达加斯加', '2', '1', '3470', '非洲', '马达加斯加', null, 'MDJSJ', null);
INSERT INTO `t_pub_city` VALUES ('3681', '3681', '布基纳法索', '2', '1', '3470', '非洲', '布基纳法索', null, 'BJNFS', null);
INSERT INTO `t_pub_city` VALUES ('3682', '3682', '博茨瓦纳', '2', '1', '3470', '非洲', '博茨瓦纳', null, 'BCWN', null);
INSERT INTO `t_pub_city` VALUES ('3683', '3683', '几内亚比绍', '2', '1', '3470', '非洲', '几内亚比绍', null, 'JNYBS', null);
INSERT INTO `t_pub_city` VALUES ('3684', '3684', '几内亚', '2', '1', '3470', '非洲', '几内亚', null, 'JNY', null);
INSERT INTO `t_pub_city` VALUES ('3685', '3685', '中非', '2', '1', '3470', '非洲', '中非', null, 'ZF', null);
INSERT INTO `t_pub_city` VALUES ('3686', '3686', '埃及', '2', '1', '3470', '非洲', '埃及', null, 'AJ', null);
INSERT INTO `t_pub_city` VALUES ('3687', '3687', '埃塞俄比亚', '2', '1', '3470', '非洲', '埃塞俄比亚', null, 'ASEBY', null);
INSERT INTO `t_pub_city` VALUES ('3688', '3688', '安哥拉', '2', '1', '3470', '非洲', '安哥拉', null, 'AGL', null);
INSERT INTO `t_pub_city` VALUES ('3689', '710001', '台湾省', '2', '1', '16', '台湾', '台湾', '台湾', 'TW', null);
INSERT INTO `t_pub_city` VALUES ('3701', '5000001', '重庆市', '2', null, '34', '重庆', '重庆市', null, 'CQS', null);
INSERT INTO `t_pub_city` VALUES ('3702', '4331001', '凤凰县', '2', '0', '242', '湘西土家族苗族自治州', '凤凰县', null, 'FHX', null);
INSERT INTO `t_pub_city` VALUES ('3737', '21', '53', '3', '1', '86', '北京', '西城区', '53', null, '1');
INSERT INTO `t_pub_city` VALUES ('3747', '536', '535', '3', '1', '207', '内蒙古自治区', '鄂尔多斯', '535', '5', null);
INSERT INTO `t_pub_city` VALUES ('3748', '53525', '5345', '3', '1', '3472', '大洋洲', '密克罗尼西亚联邦', '5345', null, null);
INSERT INTO `t_pub_city` VALUES ('3756', '201', '测试城市2', '3', '1', '149', '江苏', '镇江', '测试城市2', null, null);
INSERT INTO `t_pub_city` VALUES ('3757', '2012', '测试城市4', '3', '1', '3499', '亚洲', '巴勒斯坦', '测试城市4', null, '1');
INSERT INTO `t_pub_city` VALUES ('3758', '302', '测试城市3', '3', '0', '423', '北京', '通州区', '测试城市3', null, null);
INSERT INTO `t_pub_city` VALUES ('3901', '820001', '澳门', '2', '1', '18', '澳门特别行政区', '澳门', '澳门', 'AM', null);
INSERT INTO `t_pub_city` VALUES ('3902', '810001', '香港', '2', '1', '17', '香港特别行政区', '香港', '香港', 'XG', null);

-- ----------------------------
-- Table structure for t_pub_destsp
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_destsp`;
CREATE TABLE `t_pub_destsp` (
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `F_WXSERVICEID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_SPTYPE` varchar(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联pubmap  运营商类型',
  `F_SPNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_LINKNAME` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TELPHONE` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_FAX` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_WWWSITE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ADDRESS` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_MEMO` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_DELTAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ORDERPREFIX` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_CARPREFIX` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_DESTPLACE` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_LNG` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_LAT` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ISHOT` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ISAPP` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ISB2B` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ACCOUNTPERIOD` decimal(3,0) DEFAULT NULL COMMENT '天数',
  `F_RATE` decimal(10,2) DEFAULT NULL COMMENT '天利率',
  `F_ZNRATE` decimal(10,2) DEFAULT NULL,
  `F_FREEPERIOD` decimal(3,0) DEFAULT NULL COMMENT '免息天数',
  `F_HOT` decimal(6,0) DEFAULT NULL,
  `F_ISB2C` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TICKETSUBJECT` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_LINESUBJECT` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_HOTELSUBJECT` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_GOODSSUBJECT` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_THUMBPIC` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`F_SPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='目的地运营商';

-- ----------------------------
-- Records of t_pub_destsp
-- ----------------------------
INSERT INTO `t_pub_destsp` VALUES ('da14b98e-cb26-4169-9b58-babe98b98047', '1', null, '测试运营商', '', '', '', '', '', '', null, null, '', '镇江', null, null, '0', '0', '0', null, null, null, null, null, '0', null, null, null, null, '');

-- ----------------------------
-- Table structure for t_pub_map
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_map`;
CREATE TABLE `t_pub_map` (
  `F_MAPID` varchar(50) NOT NULL COMMENT '字典编号',
  `F_MAPTYPE` varchar(10) NOT NULL COMMENT '字典类别',
  `F_MAPKEY` varchar(100) NOT NULL COMMENT '字典键',
  `F_MAPVALUE` varchar(100) DEFAULT NULL COMMENT '字典值',
  `F_MAPDESC` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `F_SYS` decimal(1,0) DEFAULT NULL COMMENT '0-否1-是',
  PRIMARY KEY (`F_MAPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商类别 VENTYPE :0-旅行社 1-酒店 2-景区\r\n产品类别PDCTYPE:0-旅游线路1-门票2';

-- ----------------------------
-- Records of t_pub_map
-- ----------------------------
INSERT INTO `t_pub_map` VALUES ('034ef557-7c55-4d4b-9ec8-a9291875fbbb', 'BANNERTAG', '2', '门票推荐', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('03543014-0adf-4e41-a101-ff38e5ba6a96', 'MESSTYPE', '%{orderDate}', '微信下单：下单时间', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('04faad0f-0bbe-4777-bae0-0960231af488', 'BANNERTAG', '4', '酒店推荐', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('07edf18d-9b75-40aa-aac1-e5441ed8e96e', 'GOODSTYPE', '7', '6666测试三四五', '商品类型', '0');
INSERT INTO `t_pub_map` VALUES ('0bee2420-aa58-49bd-a1cf-ccc0df14466c', 'BANKTYPE', '3', '农业银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('0d769037-3f8a-40f0-8798-3d00042c23a9', 'ARTTYPE', '0', '商品介绍', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('0e3ad792-1d1b-4954-af55-5669e80397fe', 'BANKTYPE', '5', '邮政储蓄银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('1', 'BACKREASON', '2-1', '库存不足', '退款原因', null);
INSERT INTO `t_pub_map` VALUES ('1b6c66ef-de1e-4996-9c92-efb1d6d0b704', 'BOOKLIMIT', '1', '1', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('1c0bfdc9-0519-4c3a-a8f0-73380383b97b', 'BACKREASON', '1-2', '质量问题', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('1ebfc56a-b097-4b73-8596-b839d8e365b4', 'BANNERTAG', '5', '特产推荐', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('1fc0142f-06ed-4914-80d4-161903fd1e6e', 'BANKTYPE', '9', '交通银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('2', 'BACKREASON', '2-2', '物流堵塞', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('217f8ca0-9cfc-47de-a1d6-fca00079b065', 'BANKTYPE', '2', '建设银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('226b093c-0de9-42d6-925e-96294e16162c', 'BACKREASON', '1-4', '大小尺寸与商品描述不符', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('262578a7-6061-4f9f-9ce2-a51772ee66bc', 'BANKTYPE', '8', '平安银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('27823b79-a189-45a7-bc0b-817643569e11', 'MESSTYPE', '%{payMoney}', '微信下单：订单金额', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('2f4dc186-0356-4c2f-98f8-e83fb5454fc6', 'MESSTYPE', '%{backCode}', '退货受理：退订单号', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('36efa8a4-b5a7-48d7-95ec-110b246a5a3f', 'BANKTYPE', '4', '中国银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('39fb5306-cd1c-4180-92f5-a86d77234710', 'BOOKLIMIT', '4', '4', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('3bfe1992-745b-4253-8903-872397eb6252', 'BACKREASON', '1-3', '材质/面料与商品描述不符', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('3d8c6bb5-24c8-4e9c-90e5-41eb436c6e4b', 'KFMSGSCENE', '1', '微信客户支付成功', '客服消息场景', '0');
INSERT INTO `t_pub_map` VALUES ('433d3a15-4fc2-4c01-b035-b20f2be0d2a0', 'MENUGROUP', '3', '供应商管理后台', '用户组根菜单', '0');
INSERT INTO `t_pub_map` VALUES ('465f858f-a890-40d2-af40-0b99e67f1d63', 'KFRECROLE', '1', '微信客户', '客服消息接收角色', '0');
INSERT INTO `t_pub_map` VALUES ('49278191-0425-4b54-a624-4f49f80fbc95', 'SEVTYPE', '1', '订阅号', '公众号类别', '0');
INSERT INTO `t_pub_map` VALUES ('49aaaea1-6ebb-4b89-af9d-49b08e84279e', 'MESSTYPE', '%{applyBackMoney}', '退订受理：退款金额', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('4c70165a-e23e-45dd-8144-86b1f8773260', 'BANKTYPE', '6', '招商银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('4e2f6fe4-02c0-45a9-ac03-eb579f62c8e8', 'CERTTYPE', '1', '身份证', '证件类型', '0');
INSERT INTO `t_pub_map` VALUES ('5378f51e-63d8-46e0-94a0-961630391879', 'BOOKLIMIT', '3', '3', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('57308845-6529-4c28-a922-699abd1f3803', 'BANKTYPE', '1', '工商银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('5f9288ff-77b0-48d3-9618-0e45d0eff77c', 'BOOKLIMIT', '2', '2', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('6120f326-1fa7-4214-ac8b-bb1f33466b43', 'BANNERTAG', '0', '普通', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('6352ed8d-baca-43ab-a3f3-07cfdc355251', 'MESSTYPE', '%{first}', '退订受理：FIRST', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('6881b40f-68d7-4d09-b0f8-86132d4f38f1', 'MENUGROUP', '2', '运营商管理后台', '用户组根菜单', '0');
INSERT INTO `t_pub_map` VALUES ('6e63514a-1cd0-49a8-abf1-4779a462597d', 'SEVTYPE', '2', '服务号', '公众号类别', '0');
INSERT INTO `t_pub_map` VALUES ('6f1bcd3d-a74b-46cd-a484-7b92042c4bed', 'SYSMSGTYPE', '1', '客服消息', '微信系统消息类型', '0');
INSERT INTO `t_pub_map` VALUES ('704909f3-e08a-4a6f-8a78-7940b1458265', 'MESSTYPE', '%{orderCode}', '订单编号', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('74c9e7f5-5504-47a1-977f-833fecaebe4c', 'PAYTYPE', '1', '到店支付', '支付方式', '0');
INSERT INTO `t_pub_map` VALUES ('883b26fe-b472-47b8-b39a-4bbd0ecc4613', 'ARTTYPE', '5', '售后服务', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('883b26fe-b472-47b8-b39s-4bbd0ecc4613', 'ARTTYPE', '6', '关于我们', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('885b26fe-b472-47b8-b39a-4bbd0ecc4613', 'ARTTYPE', '4', '关于订单', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('885b26fe-b472-47b8-b39a-4bbd0ecc4614', 'ARTTYPE', '2', '精选图文', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('885b26fe-b472-47b8-b39a-4bbd0ecc4615', 'ARTTYPE', '1', '活动介绍', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('885b26fe-b472-47b8-b39a-4bbd0ecc4616', 'ARTTYPE', '3', '购物指南', '文章类别', '0');
INSERT INTO `t_pub_map` VALUES ('885b26fe-b472-47b8-b39b-4bbd0ecc4616', 'ARTTYPE', '3', '活动介绍', '购物指南', '0');
INSERT INTO `t_pub_map` VALUES ('8a780037-b7e3-4c5e-84f1-66c68c17021a', 'BOOKLIMIT', '7', '7', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('8e95599b-e4d0-443c-b653-c6cce41e5ae0', 'MESSTYPE', '%{pdcInfo}', '商品信息', '微信客服消息模板', '0');
INSERT INTO `t_pub_map` VALUES ('90821294-172f-4110-999e-8e4293ce5024', 'BANKTYPE', '7', '华厦银行', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('93789f86-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'yuantong', '圆通速递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('93a17188-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'ems', 'EMS快递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('93cd4ef7-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'yunda', '韵达速递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('9401a2b7-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'shentong', '申通快递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('942f40dd-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'zhongtong', '中通快递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('945f79b7-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'tiantian', '天天快递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('948d1874-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'debangwuliu', '德邦物流', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('94badb20-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'shunfeng', '顺丰快递', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('94e530fe-0f29-11ea-822f-00163e0e671e', 'EXPRESS', 'youzhengguonei', '邮政包裹', '快递公司', '0');
INSERT INTO `t_pub_map` VALUES ('977a172b-c7a3-4e04-bdce-d5d8e95771fd', 'KFMSGSCENE', '2', '微信客户退订受理', '客服消息场景', '0');
INSERT INTO `t_pub_map` VALUES ('98976f12-eebb-4799-b9ce-03efa512a7f9', 'BOOKLIMIT', '30', '30', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('a0ab6d6d-1efc-48bb-a468-6287e9b45f3a', 'BANNERTAG', '7', '购物车推荐', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('ab358822-6ce6-4df0-9fbb-11e864e0a32a', 'KFMSGSCENE', '3', '微信客户退款成功', '客服消息场景', '0');
INSERT INTO `t_pub_map` VALUES ('b172362b-5aaa-468d-bf10-24f446ef9d3e', 'BANNERTAG', '6', '订单推荐', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('b831779f-33d8-45f6-ac15-43a780b180af', 'LUNBOTYPE', '2', '特产轮播图', '轮播图类型', '0');
INSERT INTO `t_pub_map` VALUES ('bb857ab3-4fb8-436c-a50f-0db3eb532a08', 'LUNBOTYPE', '1', '首页轮播图', '轮播图类型', '0');
INSERT INTO `t_pub_map` VALUES ('c8f48092-5251-495f-9e1c-3cbf323310ad', 'BANKTYPE', '10', '其它', '银行类型', '0');
INSERT INTO `t_pub_map` VALUES ('c9637f2a-15f3-4459-9868-129c187e8ee9', 'BOOKLIMIT', '14', '14', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('cdf53351-c189-4c35-99c6-74fb6839db51', 'FANSGROUP', '0', '普通用户', '移动用户类型', '0');
INSERT INTO `t_pub_map` VALUES ('d0ddae7b-ef9b-419f-8439-f29b567fb301', 'BOOKLIMIT', '0', '当', '预定提前天数', '0');
INSERT INTO `t_pub_map` VALUES ('d11adb1f-de5a-46ef-b2c2-ff440cfe0a6f', 'BACKREASON', '1-1', '尺码拍错/不喜欢/效果差', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('d98c41f9-e284-4ebb-bed7-bcf0c4730577', 'SYSMSGTYPE', '0', '多客服消息', '微信系统消息类型', '0');
INSERT INTO `t_pub_map` VALUES ('da0f2860-41ec-4b10-89ab-a659a61c90c8', 'BACKREASON', '1-5', '颜色/款式/图案与描述不符', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('dbca14eb-92b2-428a-b3f0-6bd81cc0577e', 'BACKREASON', '1-7', '假冒品牌', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('e64b0ec0-a455-4522-9165-8d7d291f4ac5', 'BACKREASON', '1-8', '收到商品少件或破损', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('e6bae994-3559-428a-8efe-e1b623434a92', 'BANNERTAG', '1', '首页推荐', '栏目类型标识', '0');
INSERT INTO `t_pub_map` VALUES ('e6fdd04d-8063-4a9e-9989-51c82045f536', 'MENUGROUP', '1', '系统管理后台', '用户组根菜单', '0');
INSERT INTO `t_pub_map` VALUES ('ee7764ee-41c5-4f4a-95c5-5ce7f43fddd9', 'BACKREASON', '1-6', '卖家发错货', '退款原因', '0');
INSERT INTO `t_pub_map` VALUES ('f2d058cf-ce34-4a01-b161-58851135b8d5', 'PAYTYPE', '0', '在线支付', '支付方式', '0');
INSERT INTO `t_pub_map` VALUES ('f46cec9d-344e-4478-8400-9f312ac12cbe', 'BANNERTAG', '3', '线路推荐', '栏目类型标识', '0');

-- ----------------------------
-- Table structure for t_pub_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_menu`;
CREATE TABLE `t_pub_menu` (
  `F_MENU_ID` varchar(30) NOT NULL COMMENT '菜单编号',
  `F_MENU_NAME` varchar(30) NOT NULL COMMENT '菜单名称',
  `F_MENU_LEVEL` int(11) DEFAULT NULL COMMENT '菜单级别 最小为0级',
  `F_PMENU_ID` varchar(30) DEFAULT NULL COMMENT '上级菜单编号',
  `F_MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单链接URL',
  `F_PRIV_ID` varchar(50) DEFAULT NULL COMMENT '该菜单对应的权限，即：具有哪个权限的时候才显示该菜单，0表示不受控制所有用户均可以看到该菜单',
  `F_MENU_ORDER` decimal(3,0) DEFAULT NULL COMMENT '同一级别下的顺序号',
  `F_MENU_DESC` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  `F_SYSTAG` decimal(3,0) DEFAULT NULL COMMENT '不同系统公用菜单时用于区分',
  `F_MENU_IS_ADMIN` int(11) DEFAULT NULL,
  PRIMARY KEY (`F_MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of t_pub_menu
-- ----------------------------
INSERT INTO `t_pub_menu` VALUES ('001', '系统管理', '1', '0', 'javascript:void();', null, '1', null, null, '1');
INSERT INTO `t_pub_menu` VALUES ('001-001', '系统菜单管理', '2', '001', 'toCreateMenu.action?menu.isAdmin=1', null, '1', '菜单管理', null, '1');
INSERT INTO `t_pub_menu` VALUES ('035', '系统设置', '1', '0', '', null, '10', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('035-002', '个人信息', '2', '035', 'toUpdateSysUser?entranceType=1', null, '4', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('035-004', '操作日志', '2', '035', 'pubUserLog?method=query', null, '6', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('035-005', '菜单管理', '2', '035', 'menu.do?method=query&menuIsAdmin=2', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('035-006', '广告管理', '2', '035', 'carousel.do?method=query', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('037', '产品管理', '1', '0', 'javascript:void();', null, '1', null, null, '3');
INSERT INTO `t_pub_menu` VALUES ('044', '商品管理', '1', '0', 'javascript:void(0);', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('044-001', '普通商品', '2', '044', 'commproduct?method=query&priceType=0', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('044-002', '团购商品', '2', '044', 'sellPrice?method=query&priceType=1', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('044-003', '秒杀商品', '2', '044', 'sellPrice?method=query&priceType=2', null, '3', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('045', '统计分析', '1', '0', '', null, '14', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('045-001', '交易分析', '2', '045', 'transactionAnalysis.do?method=toView', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('046', '财务管理', '1', '0', '', null, '5', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('046-001', '账单清单', '2', '046', 'orderList?method=queryOrderListBill&billType=month', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('048', '订单管理', '1', '0', '', null, '3', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('048-001', '订单信息', '2', '048', 'order?method=query', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('048-003', '退款管理', '2', '048', 'orderBack?method=query', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('049', '商家管理', '1', '0', '', null, '4', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('049-001', '合作商家', '2', '049', 'company?method=query', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('049-002', '运费管理', '2', '049', 'companyExpress.do?method=query', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('050', '微信基础配置', '1', '0', 'javascript:void(0);', null, '9', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('050-001', '自定义菜单', '2', '050', 'wxMenu?method=toShowWxMenu', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('050-002', '微信消息管理', '2', '050', 'feedback.do?method=query&msgType=0', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('050-003', '微信文章管理', '2', '050', 'article.do?method=query', null, '3', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('052', '用户管理', '1', '0', 'javascript:void(0);', null, '6', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('052-001', '平台用户', '2', '052', 'queryUserList?userRoleType=2', null, '4', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('052-002', '角色管理', '2', '052', 'userGroup?method=query', null, '5', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('052-003', '微商城用户', '2', '052', 'queryUserListForType?type=0', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('052-004', 'PC网站用户', '2', '052', '', null, '2', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('053', '分类管理', '1', '0', 'pdcType?method=query', null, '1', null, null, '2');
INSERT INTO `t_pub_menu` VALUES ('053-001', '商品一级分类', '2', '053', 'pdcType?method=query', null, '1', null, null, '2');

-- ----------------------------
-- Table structure for t_pub_menubutton
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_menubutton`;
CREATE TABLE `t_pub_menubutton` (
  `F_MENUBUTTON_ID` varchar(50) NOT NULL,
  `F_MENU_ID` varchar(30) DEFAULT NULL COMMENT '菜单编号',
  `F_PRIV_ID` varchar(50) DEFAULT NULL COMMENT '该菜单对应的权限，即：具有哪个权限的时候才显示该菜单，0表示不受控制所有用户均可以看到该菜单',
  `F_MENUBUTTON_NAME` varchar(30) DEFAULT NULL,
  `F_MENUBUTTON_DESC` varchar(255) DEFAULT NULL,
  `F_MENUBUTTON_TAG` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`F_MENUBUTTON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单功能按钮表';

-- ----------------------------
-- Records of t_pub_menubutton
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_message
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_message`;
CREATE TABLE `t_pub_message` (
  `F_MESSAGEID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `F_MSGTYPEID` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `F_USER_ID` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户ID',
  `F_USER_ROLETYPE` decimal(1,0) DEFAULT NULL,
  `F_UNIT_ID` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `F_CREATEDATE` varchar(23) CHARACTER SET utf8 DEFAULT NULL,
  `F_MESSAGE` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `F_ORDERID` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `F_CUSTID` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `F_PDCTYPE` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `F_MESSAGETITLE` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `F_STARTDATE` varchar(23) CHARACTER SET utf8 DEFAULT NULL,
  `F_CREATER` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `F_MESSAGELEVEL` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `F_DELFLAG` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `F_SPID` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`F_MESSAGEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户消息表';

-- ----------------------------
-- Records of t_pub_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_role
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_role`;
CREATE TABLE `t_pub_role` (
  `F_ROLEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0-采购商1-供应商商2系统平台3-目的地运营商4-分销渠道5-客人',
  `F_ROLENAME` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `F_IFPRIV` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否需要权限控制0-不需要1-需要',
  `F_ISMULTI` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '允许多个单位0-单个1-多个',
  `F_ROLEDESC` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`F_ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='0-采购商1-供应商商2系统平台3-目的地运营商4-分销渠道5-客人6-集团目的地运营商';

-- ----------------------------
-- Records of t_pub_role
-- ----------------------------
INSERT INTO `t_pub_role` VALUES ('1', '平台', '1', '0', '');
INSERT INTO `t_pub_role` VALUES ('2', '运营商', '1', '0', '');

-- ----------------------------
-- Table structure for t_pub_rolecsys
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_rolecsys`;
CREATE TABLE `t_pub_rolecsys` (
  `F_ROLEID` varchar(2) DEFAULT NULL,
  `F_CSID` varchar(30) DEFAULT NULL COMMENT '子系统编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色子系统关系表';

-- ----------------------------
-- Records of t_pub_rolecsys
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_rolerange
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_rolerange`;
CREATE TABLE `t_pub_rolerange` (
  `F_ROLEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色类型',
  `F_MANAROLEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '能够查看的角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色范围表\r\n平台运营商管辖目的地运营商，目的地运营商管辖供应商和分销渠道';

-- ----------------------------
-- Records of t_pub_rolerange
-- ----------------------------
INSERT INTO `t_pub_rolerange` VALUES ('1', '1');
INSERT INTO `t_pub_rolerange` VALUES ('1', '2');
INSERT INTO `t_pub_rolerange` VALUES ('2', '2');

-- ----------------------------
-- Table structure for t_pub_rspic
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_rspic`;
CREATE TABLE `t_pub_rspic` (
  `F_PICID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片编号',
  `F_RSID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源ID',
  `F_PICTITLE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片标题',
  `F_PICFILENAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片文件名称',
  `F_ORDER` decimal(6,0) DEFAULT NULL COMMENT '顺序号',
  `F_RSTYPE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源类型',
  PRIMARY KEY (`F_PICID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资源图片';

-- ----------------------------
-- Records of t_pub_rspic
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_ugcreatelink
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_ugcreatelink`;
CREATE TABLE `t_pub_ugcreatelink` (
  `F_LINKID` varchar(50) NOT NULL COMMENT '关系ID',
  `F_CREATEUGID` varchar(50) DEFAULT NULL COMMENT '创建者用户组ID',
  `F_ROLEID` varchar(2) DEFAULT NULL COMMENT '0-支撑商(平台)1-采购商2-供应商3-运营商4-销售商5-直客',
  `F_UGID` varchar(50) DEFAULT NULL COMMENT '生成用户组ID',
  `F_DEFAULT` varchar(1) DEFAULT NULL COMMENT '是否默认生成',
  `F_CONDITION` varchar(1) DEFAULT NULL COMMENT '触发场景0-新增企业1-审核通过企业2-管理员新增用户',
  PRIMARY KEY (`F_LINKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组创建关系表\r\n';

-- ----------------------------
-- Records of t_pub_ugcreatelink
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_ugmenubuttonlink
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_ugmenubuttonlink`;
CREATE TABLE `t_pub_ugmenubuttonlink` (
  `F_USERGROUP_ID` varchar(50) DEFAULT NULL COMMENT '用户组ID',
  `F_MENUBUTTON_ID` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组菜单按钮权限表';

-- ----------------------------
-- Records of t_pub_ugmenubuttonlink
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_ugmenulink
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_ugmenulink`;
CREATE TABLE `t_pub_ugmenulink` (
  `F_USERGROUP_ID` varchar(50) DEFAULT NULL COMMENT '用户组ID',
  `F_MENU_ID` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户组菜单表';

-- ----------------------------
-- Records of t_pub_ugmenulink
-- ----------------------------
INSERT INTO `t_pub_ugmenulink` VALUES ('a9693078a69a46e1a3aa7c92ec86a867', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a9693078a69a46e1a3aa7c92ec86a867', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('a9693078a69a46e1a3aa7c92ec86a867', '050-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a9693078a69a46e1a3aa7c92ec86a867', '050');
INSERT INTO `t_pub_ugmenulink` VALUES ('a9693078a69a46e1a3aa7c92ec86a867', '050-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a9693078a69a46e1a3aa7c92ec86a867', '050-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a593bbcdce2243168ede568d8e99a77b', '050-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a593bbcdce2243168ede568d8e99a77b', '050');
INSERT INTO `t_pub_ugmenulink` VALUES ('a593bbcdce2243168ede568d8e99a77b', '035-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a593bbcdce2243168ede568d8e99a77b', '035');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '050-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '050');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '050-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '050-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '044-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '044');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '044-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '044-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '044-004');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '049-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '049');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '048-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '048');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '048-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '048-004');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '048-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '047-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '047');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '047-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '047-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '046-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '046');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '045-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '045');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '052-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '052');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '052-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '035-005');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '035');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '035-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a1e0e9410c63424f9b6ce619443a3293', '035-004');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '044-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '044');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '048-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '048');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '048-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '049-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('9b835a84d05e4290bc41cc44771130e5', '049');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '044-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '044');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '044-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '044-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '049-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '049');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '035-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('a85a41fe1f824bd397f3fa93c8306938', '035');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '044-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '044');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '044-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '044-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '048-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '048');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '049-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '049');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '046-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '046');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '035-006');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '035');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '035-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '045-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('c23db4c5c81549baad67b1e55165bbe8', '045');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '044-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '044');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '044-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '044-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '035-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('eb61213c49004982a26628a3f26182f4', '035');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '053-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '053');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '044-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '044');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '044-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '044-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '048-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '048');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '048-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '049-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '049');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '049-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '046-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '046');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '052-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '052');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '052-004');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '052-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '052-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '054-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '054');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '050-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '050');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '050-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '050-003');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '035-006');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '035');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '035-005');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '035-002');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '035-004');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '045-001');
INSERT INTO `t_pub_ugmenulink` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '045');

-- ----------------------------
-- Table structure for t_pub_user
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_user`;
CREATE TABLE `t_pub_user` (
  `F_USER_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `F_USER_LOGINNAME` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户登录名。PC端:登录名；微信公众号:openId；',
  `F_USER_NAME` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `F_USER_DESC` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户描述',
  `F_USER_PWD` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `F_USER_TEL` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户固定电话',
  `F_USER_MOBILE` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户手机号码',
  `F_USER_EMAIL` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户电子邮件',
  `F_USER_ADDR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户联系地址',
  `F_USER_REG_DATE` varchar(23) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户注册日期',
  `F_USER_STATE` varchar(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户状态：1：有效；0：无效，不允许登录；-1：已删除   -2 取消关注',
  `F_USER_IP` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '绑定IP地址,为空时不绑定',
  `F_USER_LOCKED` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户是否被锁定0-没有1-锁定',
  `F_USER_LOCKTIME` varchar(23) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最近一次被锁定时间',
  `F_USER_ROLETYPE` decimal(1,0) DEFAULT NULL COMMENT '0-采购商1-供应商商2系统平台',
  `F_ACCID` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '存放目的地运营商编号',
  `F_UNIT_ID` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户所辖单位编号',
  `F_WXSERVICEID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_STOREID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0-微信1-PC',
  `F_COUNTRY` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家',
  `F_PROVINCE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `F_CITY` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市',
  `F_SEX` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别 1男 2女 3未知',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新时间',
  `F_HEADPIC` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像 微信',
  PRIMARY KEY (`F_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Records of t_pub_user
-- ----------------------------
INSERT INTO `t_pub_user` VALUES ('1', 'admin', '系统管理员', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, null, '1', null, '0', null, '1', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_pub_user` VALUES ('d8c4b2be-d62d-4078-94e9-9d22c65d3fd1', 'yys', '运营商管理员', '', 'e10adc3949ba59abbe56e057f20f883e', '', '', '', '', '2018-04-09 10:49:16', '1', null, '0', null, '2', 'da14b98e-cb26-4169-9b58-babe98b98047', 'da14b98e-cb26-4169-9b58-babe98b98047', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_pub_usergroup
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_usergroup`;
CREATE TABLE `t_pub_usergroup` (
  `F_USERGROUP_ID` varchar(50) NOT NULL COMMENT '用户组ID',
  `F_USERGROUP_NAME` varchar(50) DEFAULT NULL,
  `F_USERGROUP_STATE` varchar(3) DEFAULT NULL COMMENT '用户组状态：1：有效；0：禁用  -1:删除',
  `F_USERGROUP_CREATE_DATE` varchar(23) DEFAULT NULL COMMENT '该用户组创建日期',
  `F_ROLETYPE` varchar(1) DEFAULT NULL,
  `F_MEMO` varchar(500) DEFAULT NULL,
  `F_SPID` varchar(50) DEFAULT NULL,
  `F_CREATEROLETYPE` varchar(1) DEFAULT NULL,
  `F_CREATEUNITID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`F_USERGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Records of t_pub_usergroup
-- ----------------------------
INSERT INTO `t_pub_usergroup` VALUES ('cc26a583-a979-4448-8ecc-c5aaed01804f', '平台管理', '1', '2018-04-09', null, '三农壹购平台管理员yys', 'da14b98e-cb26-4169-9b58-babe98b98047', '2', null);

-- ----------------------------
-- Table structure for t_pub_usergrouplink
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_usergrouplink`;
CREATE TABLE `t_pub_usergrouplink` (
  `F_USER_ID` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `F_USERGROUP_ID` varchar(50) DEFAULT NULL COMMENT '用户组编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组用户关系表';

-- ----------------------------
-- Records of t_pub_usergrouplink
-- ----------------------------
INSERT INTO `t_pub_usergrouplink` VALUES ('d8c4b2be-d62d-4078-94e9-9d22c65d3fd1', 'cc26a583-a979-4448-8ecc-c5aaed01804f');
INSERT INTO `t_pub_usergrouplink` VALUES ('2b6ee2f34ce84370a08aa0ff82657864', 'a1e0e9410c63424f9b6ce619443a3293');
INSERT INTO `t_pub_usergrouplink` VALUES ('a61b7b7acb4542a48fde0fdda31b6ba0', 'a1e0e9410c63424f9b6ce619443a3293');
INSERT INTO `t_pub_usergrouplink` VALUES ('a61b7b7acb4542a48fde0fdda31b6ba0', 'a1e0e9410c63424f9b6ce619443a3293');
INSERT INTO `t_pub_usergrouplink` VALUES ('a61b7b7acb4542a48fde0fdda31b6ba0', 'cc26a583-a979-4448-8ecc-c5aaed01804f');
INSERT INTO `t_pub_usergrouplink` VALUES ('a61b7b7acb4542a48fde0fdda31b6ba0', 'cc26a583-a979-4448-8ecc-c5aaed01804f');
INSERT INTO `t_pub_usergrouplink` VALUES ('62411606b8fc40e79e254bf3d7685a91', 'a85a41fe1f824bd397f3fa93c8306938');
INSERT INTO `t_pub_usergrouplink` VALUES ('d74bcedab34c4588af2e77ebb381bed8', 'c23db4c5c81549baad67b1e55165bbe8');
INSERT INTO `t_pub_usergrouplink` VALUES ('74b06ab9e403415189a02e236ea95204', 'eb61213c49004982a26628a3f26182f4');

-- ----------------------------
-- Table structure for t_pub_userlog
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_userlog`;
CREATE TABLE `t_pub_userlog` (
  `F_LOG_ID` varchar(50) NOT NULL COMMENT '操作ID',
  `F_USER_NAME` varchar(30) DEFAULT NULL,
  `F_OPERATION_TIME` varchar(23) NOT NULL COMMENT '操作时间(yyyy-MM-dd HH:mm:ss:SSS)',
  `F_SESSION_ID` varchar(255) DEFAULT NULL COMMENT '会话编号',
  `F_IP` varchar(20) DEFAULT NULL COMMENT '用户IP',
  `F_OPERATION_NAME` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `F_OPERATION_RESULT` decimal(1,0) NOT NULL COMMENT '操作结果；0：操作失败；1：操作成功',
  `F_DURING` varchar(11) DEFAULT NULL COMMENT '操作时长',
  `F_LOG_MENU` varchar(110) DEFAULT NULL,
  `F_USER_ID` varchar(50) DEFAULT NULL COMMENT '操作ID',
  `F_OPERATION_CONTEXT` varchar(3000) DEFAULT NULL COMMENT '操作描述',
  `F_ISSYN` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`F_LOG_ID`),
  KEY `IDX_USER_TIME` (`F_OPERATION_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户操作日志';

-- ----------------------------
-- Records of t_pub_userlog
-- ----------------------------

-- ----------------------------
-- Table structure for t_pub_userrolelink
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_userrolelink`;
CREATE TABLE `t_pub_userrolelink` (
  `F_USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `F_ROLE_TYPE` decimal(1,0) DEFAULT NULL COMMENT '见用户角色表',
  `F_UNIT_ID` varchar(100) DEFAULT NULL COMMENT '用户所辖单位编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of t_pub_userrolelink
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_accessrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_accessrecord`;
CREATE TABLE `t_sm_accessrecord` (
  `F_RECORDID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '访问记录ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号',
  `F_USERID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户编号  userId',
  `F_ACCESSTIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问时间',
  `F_PDCID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品ID',
  `F_TYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问类型：1微信端 2PC端',
  PRIMARY KEY (`F_RECORDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='访问记录表';

-- ----------------------------
-- Records of t_sm_accessrecord
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_article
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_article`;
CREATE TABLE `t_sm_article` (
  `F_ARTICLEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_USER_ID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `F_USERNAME` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'pub_map\r\n            0-旅游咨询1-景点介绍',
  `F_TITLE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_CONTEXT` text COLLATE utf8mb4_unicode_ci,
  `F_PUBLISHDATE` varchar(23) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_FILENAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_PICURL` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0：否 ； 1：是',
  PRIMARY KEY (`F_ARTICLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文章资讯';

-- ----------------------------
-- Records of t_sm_article
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_banner`;
CREATE TABLE `t_sm_banner` (
  `F_BANNID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品栏目编号',
  `F_TYPE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '栏目类型：0-推荐产品1-热门产品 2-秒购产品 3-特惠产品 4-包装袋产品 5-送家人产品 6-送自己产品 7-送朋友产品',
  `F_CPRODUCTID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品编号',
  `F_SORT` decimal(6,0) DEFAULT NULL COMMENT '默认顺序',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商ID',
  PRIMARY KEY (`F_BANNID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品栏目表';

-- ----------------------------
-- Records of t_sm_banner
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_bannertype
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_bannertype`;
CREATE TABLE `t_sm_bannertype` (
  `F_BANNERTYPEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '栏目类型ID',
  `F_TYPENAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '栏目类型名称',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商ID',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  `F_BANNERTYPETAG` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '栏目类型标识',
  `F_PICURL` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '栏目类型图片',
  `F_SEQNUM` decimal(3,0) DEFAULT NULL COMMENT '排序',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  PRIMARY KEY (`F_BANNERTYPEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='栏目类型表';

-- ----------------------------
-- Records of t_sm_bannertype
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_commproduct
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_commproduct`;
CREATE TABLE `t_sm_commproduct` (
  `F_PRODUCTID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品编号',
  `F_PRODUCTCODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_latvian_ci DEFAULT NULL COMMENT '商品编号 当前时间毫秒数+3位随机数',
  `F_VENNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号',
  `F_VENID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '供应商编号',
  `F_PRODUCTNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `F_PRODUCTINFO` mediumtext COLLATE utf8mb4_unicode_ci COMMENT '产品详情',
  `F_FEEMEMO` varchar(4000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '费用说明',
  `F_TIGINFO` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '温馨提示',
  `F_STATE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0：未上架；1：已上架',
  `F_THUMBPIC` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图文件名称',
  `F_REORDER` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否允许退货：0-否1-是',
  `F_SUBJECT` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品主题：主题ID',
  `F_SALENUM` decimal(6,0) DEFAULT NULL COMMENT '默认顺序号（默认购买数量）',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  `F_RECOMMEND` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0-不推荐1-推荐',
  `F_TYPE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品类型',
  `F_SUBTYPE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品子类',
  PRIMARY KEY (`F_PRODUCTID`),
  KEY `index_commproduct_productid` (`F_PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='普通商品表';

-- ----------------------------
-- Records of t_sm_commproduct
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_company
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_company`;
CREATE TABLE `t_sm_company` (
  `F_VENID` varchar(50) NOT NULL COMMENT '供应商编号',
  `F_SPID` varchar(50) DEFAULT NULL COMMENT '运营商编号',
  `F_VENNAME` varchar(100) DEFAULT NULL COMMENT '运营商名称',
  `F_TEL` varchar(20) DEFAULT NULL COMMENT '法人电话',
  `F_WWWSITE` varchar(50) DEFAULT NULL COMMENT '公司网址',
  `F_FAX` varchar(20) DEFAULT NULL COMMENT '公司传真',
  `F_LEAGAL` varchar(30) DEFAULT NULL COMMENT '法人',
  `F_LEAGALTEL` varchar(200) DEFAULT NULL COMMENT '法人联系信息',
  `F_LINKPERSON` varchar(30) DEFAULT NULL COMMENT '联系人',
  `F_LINKTEL` varchar(200) DEFAULT NULL COMMENT '联系人电话',
  `F_VENMEMO` varchar(4000) DEFAULT NULL COMMENT '供应商备注',
  `F_BANKMEMO` varchar(4000) DEFAULT NULL COMMENT '银行信息备注',
  `F_LINKMEMO` varchar(4000) DEFAULT NULL COMMENT '联系方式备注',
  `F_COMPADDRESS` varchar(500) DEFAULT NULL COMMENT '公司详细地址',
  `F_BANKNAME` varchar(100) DEFAULT NULL COMMENT '开户行名称',
  `F_BANKACC` varchar(30) DEFAULT NULL COMMENT '开户行账号',
  `F_BANKTAX` varchar(30) DEFAULT NULL COMMENT '银行税号',
  `F_FUND` varchar(30) DEFAULT NULL COMMENT '注册资金',
  `F_BUSCERT` varchar(30) DEFAULT NULL COMMENT '经营许可证',
  `F_LOGOURL` varchar(300) DEFAULT NULL COMMENT '公司图片',
  `F_BUSINESSRANGE` varchar(500) DEFAULT NULL COMMENT '主营业务',
  `F_BANKUSER` varchar(100) DEFAULT NULL COMMENT '开户人名称',
  `F_CREATETIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) DEFAULT NULL COMMENT '修改人姓名',
  `F_DELFLAG` varchar(1) DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  `F_RECVADDRESS` varchar(500) DEFAULT NULL COMMENT '收货地址',
  `F_RECEIVER` varchar(100) DEFAULT NULL COMMENT '收货人',
  `F_RECVPHONE` varchar(20) DEFAULT NULL COMMENT '收货人电话',
  PRIMARY KEY (`F_VENID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商、分销商等都统一为商家';

-- ----------------------------
-- Records of t_sm_company
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_companyexpress
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_companyexpress`;
CREATE TABLE `t_sm_companyexpress` (
  `F_COMPANYEXPRESSID` varchar(50) NOT NULL COMMENT '运费模板Id',
  `F_COMPANYID` varchar(50) DEFAULT NULL COMMENT '商家ID',
  `F_FENNAME` varchar(100) DEFAULT NULL COMMENT '运费模板名称',
  `F_EPMECOMPANY` varchar(50) DEFAULT NULL COMMENT '快递公司',
  `F_UPDATETIME` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `F_SPID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`F_COMPANYEXPRESSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家运费模板';

-- ----------------------------
-- Records of t_sm_companyexpress
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_consignee
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_consignee`;
CREATE TABLE `t_sm_consignee` (
  `F_CONSIGNEE` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人ID',
  `F_USER_ID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID  ',
  `F_CUSTNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户姓名',
  `F_CUSTPHONE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户手机号',
  `F_PCX` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省市区',
  `F_RECADDRESS` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址',
  `F_CUSTCARD` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户证件号',
  `F_CARDTYPE` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户证件类型：1身份证（默认）',
  `F_ISDEFAULT` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否默认收货人：0否，1是',
  PRIMARY KEY (`F_CONSIGNEE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户收货地址';

-- ----------------------------
-- Records of t_sm_consignee
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_coupon`;
CREATE TABLE `t_sm_coupon` (
  `F_COUPONID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '优惠券ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号',
  `F_NAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券名称',
  `F_OBTAINTYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '获取方式:1商品页领取；2活动页领取',
  `F_TOTALNUM` decimal(10,0) DEFAULT NULL COMMENT '发行总量',
  `F_DAYNUM` decimal(10,0) DEFAULT NULL COMMENT '日发行量',
  `F_USETYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用类型:1满减，2折扣',
  `F_USELIMIT` decimal(10,2) DEFAULT NULL COMMENT '使用限制：满XXXX元',
  `F_DISCOUNT` decimal(10,2) DEFAULT NULL COMMENT '折扣优惠',
  `F_OBTAINLIMIT` decimal(10,0) DEFAULT NULL COMMENT '每人限领',
  `F_DAYOBTAINLIMIT` decimal(10,0) DEFAULT NULL COMMENT '每人每天限领',
  `F_VALIDBEGIN` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效开始日期',
  `F_VALIDEND` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效结束日期',
  `F_OBTAINDATETYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '领券日期类型：1有效时段，2有效时长',
  `F_OBTAINDATEBEGIN` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '领券开始日期',
  `F_OBTAINDATEEND` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '领券结束日期',
  `F_OBTAINDATESPAN` decimal(10,0) DEFAULT NULL COMMENT '领券结束时长',
  `F_COUPONTYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠类型:1全部商品，2指定商品',
  `F_STATUS` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态:0草稿，1发布，2暂停，3终止',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  PRIMARY KEY (`F_COUPONID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='优惠券';

-- ----------------------------
-- Records of t_sm_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_couponproduction
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_couponproduction`;
CREATE TABLE `t_sm_couponproduction` (
  `F_COUPONPDCID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '优惠券产品关联ID',
  `F_COUPONID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券ID',
  `F_PDCID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品ID',
  PRIMARY KEY (`F_COUPONPDCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='优惠券产品关联表';

-- ----------------------------
-- Records of t_sm_couponproduction
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_customercoupon
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_customercoupon`;
CREATE TABLE `t_sm_customercoupon` (
  `F_CUSTOMERCOUPONID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户优惠券关联ID',
  `F_CUSTOMERCODE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户编号',
  `F_COUPONID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券ID',
  `F_USETYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用类型:1满减，2折扣',
  `F_USELIMIT` decimal(10,2) DEFAULT NULL COMMENT '使用限制：满XXXX元',
  `F_DISCOUNT` decimal(10,2) DEFAULT NULL COMMENT '折扣优惠',
  `F_COUPONTYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠类型:1全部商品，2指定商品',
  `F_VALIDBEGIN` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效开始日期',
  `F_VALIDEND` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效结束日期',
  `F_OBTAINTIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '领券时间',
  `F_STATUS` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态:0未使用，1已使用',
  `F_ORDERID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单ID',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  PRIMARY KEY (`F_CUSTOMERCOUPONID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客户优惠券关联表';

-- ----------------------------
-- Records of t_sm_customercoupon
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_customercouponpdc
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_customercouponpdc`;
CREATE TABLE `t_sm_customercouponpdc` (
  `F_CUSTOMERCOUPONPDCID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户优惠券产品ID',
  `F_CUSTOMERCOUPONID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户优惠券关联ID',
  `F_PDCID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品ID',
  PRIMARY KEY (`F_CUSTOMERCOUPONPDCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客户优惠券产品表';

-- ----------------------------
-- Records of t_sm_customercouponpdc
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_expressprice
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_expressprice`;
CREATE TABLE `t_sm_expressprice` (
  `F_EXPRESSPRICEID` varchar(50) NOT NULL COMMENT '运费价格表ID',
  `F_COMPANYEXPRESSID` varchar(50) DEFAULT NULL COMMENT '运费模板Id',
  `F_PROVINCEID` varchar(50) DEFAULT NULL COMMENT '省份Id',
  `F_PROVINCE` varchar(50) DEFAULT NULL COMMENT '省份',
  `F_EXPRESSNUM` decimal(6,0) DEFAULT NULL COMMENT '首件',
  `F_EXPRESSPRICE` decimal(6,2) DEFAULT NULL COMMENT '首件价格',
  `F_EXPRESSNUMADD` decimal(6,0) DEFAULT NULL COMMENT '续件',
  `F_EXPRESSPRICEADD` decimal(6,2) DEFAULT NULL COMMENT '续件价格',
  `F_GROUPNUM` varchar(50) DEFAULT NULL COMMENT '同一组编码',
  PRIMARY KEY (`F_EXPRESSPRICEID`),
  UNIQUE KEY `AK_F_EXPRESSPRICEID` (`F_EXPRESSPRICEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运费价格表';

-- ----------------------------
-- Records of t_sm_expressprice
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_fansuserbind
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_fansuserbind`;
CREATE TABLE `t_sm_fansuserbind` (
  `F_BINDID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '����',
  `F_FANSID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '�ƶ��û�ID',
  `F_TYPE` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0-��������1-��Ӧ��2-b2b��Ӧ�� 3-b2b������4-�ҳ�5��ʦ',
  `F_BINDCODING` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '��Ӧ�̻�����������',
  `F_USER_ID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '��Ӧ���û�ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '��Ӫ�̱��',
  PRIMARY KEY (`F_BINDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='΢���û��󶨹�ϵ��';

-- ----------------------------
-- Records of t_sm_fansuserbind
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_goodsprice
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_goodsprice`;
CREATE TABLE `t_sm_goodsprice` (
  `F_GOODSPRICEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品规格ID',
  `F_PRODUCTID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品编号(普通商品表ID)',
  `F_PRICENAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '规格类型名称',
  `F_STORECOUNT` decimal(10,0) DEFAULT NULL COMMENT '库存 ',
  `F_THUMBPIC` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图文件名称',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_FREIGHT` decimal(8,2) DEFAULT NULL COMMENT '运费',
  `F_COMPANYEXPRESSID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运费模板Id',
  PRIMARY KEY (`F_GOODSPRICEID`),
  KEY `index_goodsprice_productid` (`F_PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品规格类型';

-- ----------------------------
-- Records of t_sm_goodsprice
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_linkinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_linkinfo`;
CREATE TABLE `t_sm_linkinfo` (
  `F_LINKID` varchar(50) NOT NULL COMMENT '联系人编号',
  `F_VENID` varchar(50) DEFAULT NULL COMMENT '供应商编号',
  `F_DUTY` varchar(100) DEFAULT NULL COMMENT '职务',
  `F_NAME` varchar(20) DEFAULT NULL COMMENT '姓名',
  `F_HANDPHONE` varchar(30) DEFAULT NULL COMMENT '手机',
  `F_FAX` varchar(30) DEFAULT NULL COMMENT '传真',
  `F_TEL` varchar(30) DEFAULT NULL COMMENT '办公电话',
  `F_QQ` varchar(30) DEFAULT NULL COMMENT 'QQ',
  `F_CREATETIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) DEFAULT NULL COMMENT '修改人姓名',
  PRIMARY KEY (`F_LINKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家联系人信息表';

-- ----------------------------
-- Records of t_sm_linkinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_logisticstemplate
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_logisticstemplate`;
CREATE TABLE `t_sm_logisticstemplate` (
  `F_LOGISTICSTEMPLATEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '物流模板ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商ID',
  `F_TEMPLATENAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模板名称',
  `F_DELIVERREGION` text COLLATE utf8mb4_unicode_ci COMMENT '配送区域',
  `F_TYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '计价方式-1按件数，2按重量，3按体积',
  `F_PIECE` decimal(6,0) DEFAULT NULL COMMENT '起数件',
  `F_PRICEPERPIECE` decimal(6,2) DEFAULT NULL COMMENT '件单价',
  `F_PIECEADD` decimal(6,0) DEFAULT NULL COMMENT '增件数',
  `F_PRICEPERPIECEADD` decimal(6,2) DEFAULT NULL COMMENT '增件价',
  `F_WEIGHT` decimal(6,2) DEFAULT NULL COMMENT '起数重（kg）',
  `F_PRICEPERKG` decimal(6,2) DEFAULT NULL COMMENT '重单价',
  `F_WEIGHTADD` decimal(6,2) DEFAULT NULL COMMENT '增重数',
  `F_PRICEPERKGADD` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '增重价',
  `F_VOLUME` decimal(6,0) DEFAULT NULL COMMENT '起数体积（cm3）',
  `F_PRICEPERVOLUME` decimal(6,2) DEFAULT NULL COMMENT '体积单价',
  `F_VOLUMEADD` decimal(6,0) DEFAULT NULL COMMENT '增体积数',
  `F_PRICEPERVOLUMEADD` decimal(6,2) DEFAULT NULL COMMENT '增体积价',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0-未删除1-已删除',
  PRIMARY KEY (`F_LOGISTICSTEMPLATEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='物流模板表';

-- ----------------------------
-- Records of t_sm_logisticstemplate
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_order
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_order`;
CREATE TABLE `t_sm_order` (
  `F_ORDERID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单ID',
  `F_ORDERCODE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '流水号',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号：前端下单时根据产品关联出来',
  `F_USERID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `F_PRODUCTNAME` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单名称，生成规则待定',
  `F_BACKNUM` decimal(6,0) DEFAULT NULL COMMENT '退订数量',
  `F_GIFTNUM` decimal(6,0) DEFAULT NULL COMMENT '赠送数量',
  `F_NUM` decimal(6,0) DEFAULT NULL COMMENT '数量',
  `F_MONEY` decimal(10,2) DEFAULT NULL COMMENT '总金额：产品单价*数量',
  `F_PAYMONEY` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `F_PRODUCTPRICE` decimal(10,2) DEFAULT NULL COMMENT '商品费用',
  `F_TRANSFEE` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `F_ORDERDATE` varchar(23) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单日期',
  `F_MEMO` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单备注',
  `F_STATUS` decimal(2,0) DEFAULT NULL COMMENT '订单状态：0-未确认 1-已发货2-已收货3-已取消（商户拒绝）4-发货失败5-订单关闭（定时、后台）',
  `F_BEFORE_PAY_STATUS` decimal(2,0) DEFAULT NULL COMMENT '支付前状态:0：正常 ；1：用户取消； 2：系统取消',
  `F_PAYTAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否支付：0-未支付1-已支付',
  `F_PAYDATE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付日期',
  `F_PAYTYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '付款类型：0-微信1-支付宝',
  `F_PLATFORM_FLOW_CODE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '我方批次流水号',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  `F_COMPANYREMARK` text COLLATE utf8mb4_unicode_ci COMMENT '商家备注',
  PRIMARY KEY (`F_ORDERID`),
  KEY `index_order_orderid` (`F_ORDERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单';

-- ----------------------------
-- Records of t_sm_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_orderback
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_orderback`;
CREATE TABLE `t_sm_orderback` (
  `F_BACKID` varchar(50) NOT NULL COMMENT '退订记录ID',
  `F_BACKCODE` varchar(50) DEFAULT NULL COMMENT '退订单号',
  `F_STATUS` varchar(2) DEFAULT NULL COMMENT '退订状态：1-申请退订2-受理3-不受理4-退货5-退款6-关闭',
  `F_ORDERID` varchar(50) DEFAULT NULL COMMENT '订单ID',
  `F_BACKDATA` varchar(500) DEFAULT NULL COMMENT '退订数据[{orderListId:,num}]',
  `F_BACKREASON_TYPE` varchar(50) DEFAULT NULL COMMENT '退订原因类型(PUBMAP)',
  `F_BACKREASON` varchar(500) DEFAULT NULL COMMENT '退订原因',
  `F_APPLYTIME` varchar(50) DEFAULT NULL COMMENT '退订申请时间',
  `F_APPLY_UID` varchar(50) DEFAULT NULL COMMENT '退订申请人ID',
  `F_APPLY_UNAME` varchar(100) DEFAULT NULL COMMENT '退订申请人名称',
  `F_OPTIME` varchar(50) DEFAULT NULL COMMENT '退订受理时间',
  `F_OP_UID` varchar(50) DEFAULT NULL COMMENT '退订受理人ID',
  `F_OP_UNAME` varchar(100) DEFAULT NULL COMMENT '退订受理人名称',
  `F_ISBACK_GOODS` varchar(1) DEFAULT NULL COMMENT '是否退货 1是，0否',
  `F_BACK_GOODS_STATUS` varchar(1) DEFAULT NULL COMMENT '退货状态 0待发货，1已发货，2已收货',
  `F_BACK_GOODS_EPMECOMPANY` varchar(50) DEFAULT NULL COMMENT '退货快递公司',
  `F_BACK_GOODS_EPMEORDCODE` varchar(100) DEFAULT NULL COMMENT '退货快递单号',
  `F_BACK_GOODS_NAME` varchar(50) DEFAULT NULL COMMENT '退货快递接收人',
  `F_BACK_GOODS_PHONE` varchar(50) DEFAULT NULL COMMENT '退货快递接收人电话',
  `F_BACK_GOODS_RECEIVE_TIME` varchar(50) DEFAULT NULL COMMENT '退货接收时间',
  `F_ISBACK_MONEY` varchar(1) DEFAULT NULL COMMENT '是否退款 1是，0否',
  `F_BACK_MONEY_STATUS` varchar(1) DEFAULT NULL COMMENT '退款状态 0待退款，1已退款',
  `F_BACK_MONEY_RECEIVE_TIME` varchar(50) DEFAULT NULL COMMENT '退款接收时间',
  `F_APPLYBACKMONEY` decimal(10,2) DEFAULT NULL COMMENT '申请退订金额',
  `F_BACKMONEY` decimal(10,2) DEFAULT NULL COMMENT '实际退订金额',
  `F_REFUSE_REASON` varchar(500) DEFAULT NULL COMMENT '不受理原因',
  `F_SPID` varchar(50) DEFAULT NULL,
  `F_BACK_GOODS_ADDR` varchar(100) DEFAULT NULL COMMENT '退货快递接收地址',
  PRIMARY KEY (`F_BACKID`),
  KEY `index_orderlist_orderid` (`F_ORDERID`),
  KEY `index_orderlist_backid` (`F_BACKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单退订流程';

-- ----------------------------
-- Records of t_sm_orderback
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_ordercustomer
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_ordercustomer`;
CREATE TABLE `t_sm_ordercustomer` (
  `F_ORDERID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单ID',
  `F_ORDERLISTID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单产品明细编号',
  `F_CUSTNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户姓名',
  `F_CUSTPHONE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户手机号',
  `F_RECADDRESS` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货地址',
  `F_CUSTCARD` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户证件号',
  `F_CARDTYPE` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户证件类型：1身份证（默认）',
  PRIMARY KEY (`F_ORDERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单收货地址信息';

-- ----------------------------
-- Records of t_sm_ordercustomer
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_orderexpress
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_orderexpress`;
CREATE TABLE `t_sm_orderexpress` (
  `F_ORDERID` varchar(50) NOT NULL COMMENT '订单ID',
  `F_ORDERLISTID` varchar(50) NOT NULL COMMENT '订单产品明细编号',
  `F_SPID` varchar(50) DEFAULT NULL COMMENT '运营商编号：前端下单时根据产品关联出来',
  `F_VENID` varchar(50) DEFAULT NULL COMMENT '供应商编号',
  `F_EPMECOMPANY` varchar(50) DEFAULT NULL COMMENT '快递公司',
  `F_EPMEORDCODE` varchar(100) DEFAULT NULL COMMENT '快递单号',
  `F_DELTAG` varchar(1) DEFAULT NULL COMMENT '删除标志：0-否1-是',
  `F_CREATETIME` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `F_CREATORUID` varchar(50) DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) DEFAULT NULL COMMENT '创建人姓名',
  `F_UPDATETIME` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) DEFAULT NULL COMMENT '修改人姓名',
  `F_STATUS` varchar(1) DEFAULT NULL COMMENT '快递状态 0:已收货,1:已发货',
  `F_ORDEREXPRESSID` varchar(50) NOT NULL COMMENT '快递记录ID',
  PRIMARY KEY (`F_ORDEREXPRESSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单发货记录表';

-- ----------------------------
-- Records of t_sm_orderexpress
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_orderlist
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_orderlist`;
CREATE TABLE `t_sm_orderlist` (
  `F_ORDERLISTID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单产品明细编号',
  `F_ORDERID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号：前端下单时根据产品关联出来',
  `F_VENID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '供应商编号',
  `F_VENNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `F_PRICEID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '销售价ID',
  `F_PRODUCTNAME` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品名称',
  `F_PRICE` decimal(10,2) DEFAULT NULL COMMENT '产品单价：客户实际销售金额',
  `F_NUM` decimal(6,0) DEFAULT NULL COMMENT '数量',
  `F_MONEY` decimal(10,2) DEFAULT NULL COMMENT '总金额：产品单价*数量',
  `F_PAYMONEY` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `F_BACKNUM` decimal(6,0) DEFAULT NULL COMMENT '退订数量',
  `F_GOODSPRICEID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '子产品编号：规格ID',
  `F_CHILDNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '子产品名称：商品规格名称',
  `F_TRANSFEE` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ORDERLISTTYPE` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0：下单 ；1：退订单；2：赠送',
  `F_PRODUCTID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`F_ORDERLISTID`),
  KEY `index_orderlist_orderlistid` (`F_ORDERLISTID`),
  KEY `index_orderlist_orderid` (`F_ORDERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单产品明细表';

-- ----------------------------
-- Records of t_sm_orderlist
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_orderlog
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_orderlog`;
CREATE TABLE `t_sm_orderlog` (
  `F_ORDERLOGID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单操作日志ID',
  `F_LINKID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联表ID：类型为订单则订单ID，类型为退订则问退订记录ID',
  `F_OPTIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作时间',
  `F_OPER` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作人',
  `F_OPCONTENT` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作内容',
  `F_TYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志类型:1订单日志，2退订日志',
  `F_RESULT` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作结果:0失败，1成功',
  PRIMARY KEY (`F_ORDERLOGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单操作日志';

-- ----------------------------
-- Records of t_sm_orderlog
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_orderremark
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_orderremark`;
CREATE TABLE `t_sm_orderremark` (
  `F_ORDERREMARKID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '������עID',
  `F_ORDERID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '����ID',
  `F_REMARK` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '��ע',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '����ʱ��',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '������',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '����������',
  PRIMARY KEY (`F_ORDERREMARKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='������ע';

-- ----------------------------
-- Records of t_sm_orderremark
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_pdctype
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_pdctype`;
CREATE TABLE `t_sm_pdctype` (
  `F_PDCTYPEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品类型ID',
  `F_TYPENAME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类别名称',
  `F_PPDCTYPEID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上级编号',
  `F_DELFLAG` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '删除标志',
  `F_PICURL` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_LEVEL` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '1：一级类别；2：二级类别；3：三级类别',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_SORT` varchar(4) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`F_PDCTYPEID`),
  KEY `index_pdctype_pdctypeid` (`F_PDCTYPEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品类型表';

-- ----------------------------
-- Records of t_sm_pdctype
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_price_1_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_price_1_ref`;
CREATE TABLE `t_sm_price_1_ref` (
  `F_REFID` varchar(50) NOT NULL COMMENT '信息ID/团购批次/每个订单',
  `F_PRICEID` varchar(50) NOT NULL COMMENT '销售价ID',
  `F_USERID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `F_ORDERLISTID` varchar(50) DEFAULT NULL COMMENT '订单ID',
  `F_REF_PATCHCODE` varchar(50) DEFAULT NULL COMMENT '团购批次(一起参团，相同团购批次)',
  `F_ISBEGIN` varchar(1) DEFAULT NULL COMMENT '发起人=1，非发起人=0',
  `F_PRICESTARTDATE` varchar(19) DEFAULT NULL COMMENT '发起人保存-效期开始日期',
  `F_PRICEENDDATE` varchar(19) DEFAULT NULL COMMENT '发起人保存-效期结束日期',
  `F_CREATETIME` varchar(19) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`F_REFID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售-团购-信息';

-- ----------------------------
-- Records of t_sm_price_1_ref
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_sellprice
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_sellprice`;
CREATE TABLE `t_sm_sellprice` (
  `F_PRICEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `F_GOODSPRICEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品规格ID',
  `F_PRODUCTID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品ID',
  `F_PRICE` decimal(10,2) DEFAULT NULL COMMENT '销售单价',
  `F_PRICETYPE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动类型 ：0常规商品；1团购价；2秒杀价',
  `F_PRICESTARTDATE` varchar(19) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动开始时间',
  `F_PRICEENDDATE` varchar(19) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动结束时间',
  `F_MAXBUYCOUNT` decimal(6,0) DEFAULT NULL COMMENT '产品最多购买数量  -1为不限',
  `F_LIMITBUYCOUNT` decimal(6,0) DEFAULT NULL COMMENT '产品最少制购买数量 -1为不限',
  `F_PEOPLENUM` decimal(6,0) DEFAULT NULL COMMENT '参团人数',
  `F_DELFLAG` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '删除标志',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`F_PRICEID`),
  KEY `index_sellprice_priceid` (`F_PRICEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='销售价表';

-- ----------------------------
-- Records of t_sm_sellprice
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_sendgoods
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_sendgoods`;
CREATE TABLE `t_sm_sendgoods` (
  `F_SENDGOODSID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发货记录ID',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商编号：前端下单时根据产品关联出来',
  `F_VENID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '供应商编号',
  `F_ORDERLISTID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单明细ID',
  `F_BACKID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '退订记录ID',
  `F_NUM` decimal(10,0) DEFAULT NULL COMMENT '发货数量',
  `F_EPMETHOD` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '快递方式',
  `F_EPMECOMPANY` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '快递公司',
  `F_EPMEORDCODE` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '快递单号',
  `F_SENDTIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发货时间',
  `F_CREATORUID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发货人ID',
  `F_CREATOR` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发货人姓名',
  `F_TYPE` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发货类型：1订单发货，2退订寄回',
  PRIMARY KEY (`F_SENDGOODSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发货记录表';

-- ----------------------------
-- Records of t_sm_sendgoods
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_shopcart
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_shopcart`;
CREATE TABLE `t_sm_shopcart` (
  `F_CARTID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '购物车ID',
  `F_PRICEID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_NUM` decimal(6,0) DEFAULT NULL COMMENT '数量',
  `F_USERID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `F_CREATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_UPDATETIME` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`F_CARTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='购物车';

-- ----------------------------
-- Records of t_sm_shopcart
-- ----------------------------

-- ----------------------------
-- Table structure for t_sm_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_subject`;
CREATE TABLE `t_sm_subject` (
  `F_SUBJECTID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主题ID',
  `F_SUBJECT` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主题名称',
  `F_SPID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运营商ID',
  PRIMARY KEY (`F_SUBJECTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品主题';

-- ----------------------------
-- Records of t_sm_subject
-- ----------------------------
INSERT INTO `t_sm_subject` VALUES ('1', '美味', 'da14b98e-cb26-4169-9b58-babe98b98047');
INSERT INTO `t_sm_subject` VALUES ('2', '绿色', 'da14b98e-cb26-4169-9b58-babe98b98047');
INSERT INTO `t_sm_subject` VALUES ('3', '特价', 'da14b98e-cb26-4169-9b58-babe98b98047');

-- ----------------------------
-- Table structure for t_sm_thirdpayflow
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_thirdpayflow`;
CREATE TABLE `t_sm_thirdpayflow` (
  `F_FLOWID` varchar(50) NOT NULL COMMENT '流水ID',
  `F_PLATFORM_FLOW_CODE` varchar(50) DEFAULT NULL COMMENT '我方批次流水号',
  `F_CREATETIME` varchar(50) DEFAULT NULL COMMENT '我方流水时间',
  `F_THIRD_FLOW_CODE` varchar(30) DEFAULT NULL COMMENT '对方支付回执编号',
  `F_THIRD_CREATETIME` varchar(23) DEFAULT NULL COMMENT '接收到支付回执的时间',
  `F_FLOW_STATE` varchar(1) DEFAULT NULL COMMENT '0-申请，1-流水成功，2-流水失败，3，流水终止',
  `F_FLOW_MONEY` decimal(10,2) DEFAULT NULL COMMENT '流水金额',
  `F_PLATFORM_ORDERS` varchar(2000) DEFAULT NULL COMMENT '订单1,订单2,订单3',
  `F_SPID` varchar(50) DEFAULT NULL COMMENT '运营商ID',
  PRIMARY KEY (`F_FLOWID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方流水表';

-- ----------------------------
-- Records of t_sm_thirdpayflow
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_article
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_article`;
CREATE TABLE `t_wx_article` (
  `F_ARTICLEID` varchar(50) NOT NULL,
  `F_SPID` varchar(50) DEFAULT NULL,
  `F_USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `F_USERNAME` varchar(20) DEFAULT NULL,
  `F_TYPE` varchar(1) DEFAULT NULL COMMENT 'pub_map：0-旅游咨询1-景点介绍',
  `F_TITLE` varchar(100) DEFAULT NULL,
  `F_PUBLISHDATE` varchar(23) DEFAULT NULL,
  `F_CONTEXT` text,
  `F_FILENAME` varchar(100) DEFAULT NULL,
  `F_PROLINK` varchar(200) DEFAULT NULL,
  `F_PICURL` varchar(500) DEFAULT NULL,
  `F_ISSHOWAPP` varchar(1) DEFAULT NULL COMMENT '是否移动端显示   0否（默认）  1是 ',
  `F_DELFLAG` varchar(1) DEFAULT NULL COMMENT '删除标识：0未删除；1删除',
  `F_CREATORUID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `F_CREATOR` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人姓名',
  `F_CREATETIME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `F_UPDATETIME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改时间',
  `F_UPDATERUID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `F_UPDATER` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人姓名',
  PRIMARY KEY (`F_ARTICLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信文章';

-- ----------------------------
-- Records of t_wx_article
-- ----------------------------
INSERT INTO `t_wx_article` VALUES ('1e5479cbb91e46b8946bc110afb1481b', 'da14b98e-cb26-4169-9b58-babe98b98047', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '5', '售后服务', '2019-11-17 18:21:11', '<p><img src=\"http://www.3nong1gou.com/upload/ckImage/201911/20191117182057648-84.jpg\" /></p>\r\n', 'article1e5479cbb91e46b8946bc110afb1481b.html', '', null, '1', '0', null, null, null, null, null, null);
INSERT INTO `t_wx_article` VALUES ('44d75b7c664f4fa78475062d08947688', 'da14b98e-cb26-4169-9b58-babe98b98047', 'd8c4b2be-d62d-4078-94e9-9d22c65d3fd1', '运营商管理员', '6', '平台介绍', '2019-11-17 20:44:00', '<p style=\"margin-left: 21.2pt; text-align: center;\"><img src=\"http://www.3nong1gou.com/upload/ckImage/201911/20191117204217594-15.jpg\" />&nbsp; &nbsp; &nbsp;</p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">农壹购新零售运营平台将聚焦农村市场，融合互联网精神，创新独特模式，以农产品为切入点，以供应链管理为核心能力；以&ldquo;商流、社交电商、信息流、资金流&rdquo;四网融合的农村电商生态系统为市场定位；发展农村新零售运营模式，真正做到精准扶贫，走可持续化发展道路。</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\">&nbsp;</p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\"><strong>三农壹购平台&mdash;&mdash;打造新零售区块链+电商智慧生态系统。</strong></span></p>\r\n\r\n<p style=\"margin-left:21.25pt\"><span style=\"font-size:14px\">运用多用户系统以B2B2C的理念出发，创新模块化设计，整合运营商，供货商，用户于一体，进行异业联盟拉动消费。以平台为中心，整合优质资源；以数据为基础，打造优质产业；以产业为核心，掌握核心技术，形成行业标准；并紧密联系目标客户需求，营造一个集&ldquo;供应、销售、生活&rdquo;于一体的用户体验中心。</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\"><strong>三农壹购微商城与PC网站</strong></span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">精美UI界面，便捷下单购买，商城性能流畅，用户体验好</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">一键转发，图文分享，拉新拓客，实现快速起量</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">丰富营销活动，秒杀、团购、限时抢购，天天都有新玩法</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">抓住更多流量，实现规模扩张，先人一步抢占市场</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\"><strong>三农壹购管理平台</strong></span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">助力精细化运营，掌握平台命脉</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">商品经营多维度展示，销量排行、毛利报表、用户分析</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">精细化管控运营全流程，决策高效科学有依据</span></p>\r\n\r\n<p style=\"margin-left:21.2pt\"><span style=\"font-size:14px\">订单自动汇总，供应商管理，对接采购更便捷</span></p>\r\n', 'article44d75b7c664f4fa78475062d08947688.html', '', '0c52aeac8b2741b79110a1bab2e47c4c', '1', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_wx_fansuser
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_fansuser`;
CREATE TABLE `t_wx_fansuser` (
  `F_FANSID` varchar(50) NOT NULL,
  `F_FAKEID` varchar(100) DEFAULT NULL COMMENT '微信号为openID',
  `F_WXSERVICEID` varchar(50) DEFAULT NULL,
  `F_FROM` varchar(30) DEFAULT NULL COMMENT '来源场景ID',
  `F_TYPE` varchar(1) DEFAULT NULL COMMENT '0-微信1-iosApp2-安卓App',
  `F_USERNAME` varchar(50) DEFAULT NULL,
  `F_PASSWD` varchar(10) DEFAULT NULL,
  `F_NICKNAME` varchar(100) DEFAULT NULL,
  `F_COUNTRY` varchar(30) DEFAULT NULL,
  `F_PROVINCE` varchar(30) DEFAULT NULL,
  `F_CITY` varchar(30) DEFAULT NULL,
  `F_CREATEDATE` varchar(23) DEFAULT NULL,
  `F_USERGROUP` int(1) DEFAULT NULL COMMENT '0-普通用户1-运营人员 pub_map',
  `F_LANG` varchar(10) DEFAULT NULL,
  `F_LOGO` varchar(500) DEFAULT NULL,
  `F_SEX` varchar(1) DEFAULT NULL COMMENT '0-女性1-男性',
  `F_LASTSIGNDATE` varchar(23) DEFAULT NULL COMMENT '暂时不用',
  `F_DELFLAG` int(1) DEFAULT NULL,
  `F_HANDPHONE` varchar(30) DEFAULT NULL,
  `F_BACKGROUNDURL` varchar(100) DEFAULT NULL,
  `F_EMAIL` varchar(30) DEFAULT NULL,
  `F_QQ` varchar(20) DEFAULT NULL,
  `F_SINAWEIBO` varchar(30) DEFAULT NULL,
  `F_LNG` varchar(30) DEFAULT NULL,
  `F_LAT` varchar(30) DEFAULT NULL,
  `F_STOCKADDRESS` varchar(2000) DEFAULT NULL,
  `F_BIRTH` varchar(100) DEFAULT NULL,
  `F_USER_ID` varchar(50) DEFAULT NULL,
  `F_DEVICETOKEN` varchar(100) DEFAULT NULL,
  `F_UNIONID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`F_FANSID`),
  KEY `IDX_FANSUSER_FROM` (`F_FROM`) USING BTREE,
  KEY `IDX_FANSUSER_WXSERVICEID` (`F_WXSERVICEID`) USING BTREE,
  KEY `F_FAKEID_UNIQUE` (`F_FAKEID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用户表';

-- ----------------------------
-- Records of t_wx_fansuser
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_feedback
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_feedback`;
CREATE TABLE `t_wx_feedback` (
  `F_WXSERVICEID` varchar(50) DEFAULT NULL,
  `F_FEEDBACKID` varchar(50) NOT NULL,
  `F_MSGNAME` varchar(100) DEFAULT NULL,
  `F_TITLE` varchar(100) DEFAULT NULL COMMENT '视频文件标题',
  `F_MSGTYPE` int(1) DEFAULT NULL COMMENT '0文本、1-图片、2-图文、3-语音、4-视频、5-音乐 7-链接 8-客服消息',
  `F_KEYWORD` varchar(100) DEFAULT NULL COMMENT '以,分隔',
  `F_KEYWORD2` varchar(100) DEFAULT NULL COMMENT '以,分隔',
  `F_CONTEXT` varchar(4000) DEFAULT NULL,
  `F_MEDIAID` varchar(30) DEFAULT NULL,
  `F_SUMMARY` varchar(2000) DEFAULT NULL,
  `F_LINKURL` varchar(500) DEFAULT NULL,
  `F_MEDIAFILENAME` varchar(100) DEFAULT NULL,
  `F_MEDIAURL` varchar(500) DEFAULT NULL,
  `F_HQMEDIAURL` varchar(500) DEFAULT NULL,
  `F_THUMBID` varchar(30) DEFAULT NULL,
  `F_DELFLAG` int(1) DEFAULT NULL,
  `F_LASTUPDATE` varchar(23) DEFAULT NULL,
  `F_XML` text,
  PRIMARY KEY (`F_FEEDBACKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复信息';

-- ----------------------------
-- Records of t_wx_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_kfmsgmodle
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_kfmsgmodle`;
CREATE TABLE `t_wx_kfmsgmodle` (
  `F_MODULEID` varchar(50) NOT NULL COMMENT '微信客服消息模板',
  `F_WXSERVICEID` varchar(50) DEFAULT NULL COMMENT '服务号ID',
  `F_SCENEID` varchar(4) DEFAULT NULL COMMENT '模板场景编号：0-供应商收单用户付款成功后1-用户下单(未支付)2-用户下单付款成功后3-订单状态改变时(确认、取消等)4-订单验证通过后',
  `F_RECROLE` varchar(4) DEFAULT NULL COMMENT '接受人角色：0-客人1-供应商相关人员2-分销渠道3-客服人员',
  `F_CONTEXT` text COMMENT '占位符统一为${表名_字段名}\r\n            供应商收单:\r\n                 收单编号：BILL_BILLCODE,供应商名称BILL_VENNAME\r\n                 应付金额：BILL_ORDERMONEY,实付金额BILL_PAYMONEY\r\n                 支付状态：BILL_PAYSTATUS\r\n            订单：\r\n                订单号：ORDER_ORDERCODE,下单日期：ORDER_ORDERDATE\r\n               供应商：ORDER_VENNAME,产品名称：ORDER_PRODUCTINFO\r\n               消费日期：ORDER_PLAYDATE,订单总金额：ORDER_MONEY\r\n               产品数量：ORDER_PCOUNT 订单状态：ORDER_STATUS\r\n            分销渠道\r\n               销售总额：PARTNER_ORDERMONEY,提成总额：PARTNER_DEDUCTMONEY,可体现金额：PARTNER_CASHABLEMONEY',
  `F_SENDTYPE` varchar(1) DEFAULT NULL COMMENT '发送类型：1文本消息，2微信模板消息接口',
  PRIMARY KEY (`F_MODULEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信客服消息模板';

-- ----------------------------
-- Records of t_wx_kfmsgmodle
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_material
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_material`;
CREATE TABLE `t_wx_material` (
  `F_MATID` varchar(50) NOT NULL COMMENT '素材ID',
  `F_SPID` varchar(50) DEFAULT NULL,
  `F_MATTYPE` varchar(1) DEFAULT NULL COMMENT '素材类型pub_map;0-图片1-声音2-视频3-缩略图\r\n            图片特指多图文内嵌的图片',
  `F_MATNAME` varchar(100) DEFAULT NULL COMMENT '素材名称',
  `F_MATURL` varchar(100) DEFAULT NULL COMMENT '素材URL',
  `F_ISFOREVER` varchar(1) DEFAULT NULL COMMENT '是否永久素材0-临时素材1-永久素材',
  `F_DELTAG` varchar(1) DEFAULT NULL COMMENT '删除标志',
  `F_WXMEDIAID` varchar(100) DEFAULT NULL COMMENT '媒体ID',
  `F_WXURL` varchar(300) DEFAULT NULL COMMENT '微信资源URL',
  `F_KEYWORD` varchar(2000) DEFAULT NULL COMMENT '关键字，',
  `F_MEMO` varchar(2000) DEFAULT NULL COMMENT '备注',
  `F_LASTSENDDATE` varchar(23) DEFAULT NULL COMMENT '最近一次推送时间',
  PRIMARY KEY (`F_MATID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='素材表';

-- ----------------------------
-- Records of t_wx_material
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_menu`;
CREATE TABLE `t_wx_menu` (
  `F_MENU_ID` varchar(50) NOT NULL COMMENT '菜单编号',
  `F_WXSERVICEID` varchar(50) DEFAULT NULL,
  `F_FEEDBACKID` varchar(50) DEFAULT NULL,
  `F_MENU_NAME` varchar(30) NOT NULL COMMENT '菜单名称',
  `F_MENU_LEVEL` int(1) DEFAULT NULL COMMENT '菜单级别 最小为0级',
  `F_PMENU_ID` varchar(50) DEFAULT NULL COMMENT '上级菜单编号',
  `F_MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单链接URL',
  `F_MENU_ORDER` int(3) DEFAULT NULL COMMENT '同一级别下的顺序号',
  `F_MENU_DESC` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  `F_XML` text,
  PRIMARY KEY (`F_MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信自定义菜单';

-- ----------------------------
-- Records of t_wx_menu
-- ----------------------------
INSERT INTO `t_wx_menu` VALUES ('1b2b48c927404961a9b6ed2334508c89', '1', 'b2cc38ebc4a64cdf9397bc05509af2df', '商城首页', '0', '0', null, '2', null, null);

-- ----------------------------
-- Table structure for t_wx_messagelog
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_messagelog`;
CREATE TABLE `t_wx_messagelog` (
  `F_LOGID` varchar(50) NOT NULL,
  `F_FANSID` varchar(50) DEFAULT NULL,
  `F_WXSERVICEID` varchar(50) DEFAULT NULL,
  `F_OPENID` varchar(50) DEFAULT NULL,
  `F_FROMTYPE` varchar(1) DEFAULT NULL COMMENT '0-微信1-自驾游',
  `F_DIRECT` varchar(1) DEFAULT NULL COMMENT '0-移动端到服务器1-服务器到移动端',
  `F_MSGTYPE` varchar(2) DEFAULT NULL COMMENT '0-关注1-取消关注2-普通消息',
  `F_CONTEXT` varchar(2000) DEFAULT NULL,
  `F_DATE` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`F_LOGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信消息日志';

-- ----------------------------
-- Records of t_wx_messagelog
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_msgnews
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_msgnews`;
CREATE TABLE `t_wx_msgnews` (
  `F_NEWSID` varchar(50) NOT NULL,
  `F_FEEDBACKID` varchar(50) DEFAULT NULL,
  `F_TITLE` varchar(100) DEFAULT NULL,
  `F_DESC` varchar(2000) DEFAULT NULL,
  `F_PICURL` varchar(100) DEFAULT NULL,
  `F_URL` varchar(500) DEFAULT NULL,
  `F_ISMAIN` varchar(1) DEFAULT NULL COMMENT '0-否1-是',
  `F_SORTNUM` int(2) DEFAULT NULL,
  PRIMARY KEY (`F_NEWSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复图文消息项';

-- ----------------------------
-- Records of t_wx_msgnews
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_printinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_printinfo`;
CREATE TABLE `t_wx_printinfo` (
  `F_ID` varchar(50) NOT NULL,
  `F_WXSERVICEID` varchar(50) DEFAULT NULL,
  `F_GETKEY` varchar(10) DEFAULT NULL,
  `F_TICKETFIX` varchar(10) DEFAULT NULL,
  `F_DEVICECODE` varchar(30) DEFAULT NULL,
  `F_PICTEXT` varchar(1000) DEFAULT NULL,
  `F_SUCCTEXT` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信打印机设备';

-- ----------------------------
-- Records of t_wx_printinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_printpic
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_printpic`;
CREATE TABLE `t_wx_printpic` (
  `F_PICID` varchar(50) NOT NULL,
  `F_WXSERVICEID` varchar(50) DEFAULT NULL,
  `F_OPENID` varchar(100) DEFAULT NULL,
  `F_PICURL` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`F_PICID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信打印图片信息';

-- ----------------------------
-- Records of t_wx_printpic
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_servicecode
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_servicecode`;
CREATE TABLE `t_wx_servicecode` (
  `F_WXSERVICEID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `F_NAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_FULLNAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_CODE` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TYPE` decimal(1,0) DEFAULT NULL COMMENT '0-订阅号1-服务号\r\n            pub_map中 ServiceCodeType',
  `F_APPID` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_APPSECRET` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_LOGOFILENAME` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_URL` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TOKEN` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_WELCOME` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_PAYSIGNKEY` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TENPAYPARTNER` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_TENPAYPARTNERKEY` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ALIPAYEMAIL` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ALIPAYPARTNER` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_ALIPAYPARTNERKEY` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_DELTAG` decimal(1,0) DEFAULT NULL,
  `F_CREATEDATE` varchar(23) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_INMSGID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_UNREADMSGID` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_COUPONMEMO` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `F_COUPONLINK` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`F_WXSERVICEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信公众平台服务号';

-- ----------------------------
-- Records of t_wx_servicecode
-- ----------------------------
INSERT INTO `t_wx_servicecode` VALUES ('1', '三农壹购', '三农壹购', 'gh_34798570658e', '1', 'wx43f80960a6089397', '669a917e7f2e5814c82fda981dd7bcbe', null, 'http://www.3nong1gou.com/', 'snyg_weixin', null, null, '1560146571', 'gXqjT7EPv6ZzEg34JIHkl6ZGu5JaaRGb', null, null, null, '0', null, 'e09f509c35e04b3280178d5d3764df9c', '954020e21a49423988ea37330c7f9b5b', null, null);

-- ----------------------------
-- View structure for v_pub_roledata
-- ----------------------------
DROP VIEW IF EXISTS `v_pub_roledata`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_pub_roledata` AS select 2 AS `F_ROLETYPE`,`t_pub_destsp`.`F_SPID` AS `F_UNIT_ID`,`t_pub_destsp`.`F_SPNAME` AS `F_UNIT_NAME`,`t_pub_destsp`.`F_SPID` AS `F_ACC_ID`,'0' AS `F_DELTAG` from `t_pub_destsp` ;
