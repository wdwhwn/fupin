package com.jingzhun.poordatemanager.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 财产收入
 * @author onlineGenerator
 * @date 2019-03-29 15:27:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_poor_income", schema = "")
@SuppressWarnings("serial")
public class HPoorIncomeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**行政县*/
	@Excel(name="行政县",width=15)
	private java.lang.String dist;
	/**乡镇*/
	@Excel(name="乡镇",width=15)
	private java.lang.String town;
	/**行政村*/
	@Excel(name="行政村",width=15)
	private java.lang.String village;
	/**户编号*/
	@Excel(name="户编号",width=15)
	private java.lang.String householdNo;
	/**人编号*/
	@Excel(name="人编号",width=15)
	private java.lang.String humanNo;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String idno;
	/**家庭人口数*/
	@Excel(name="家庭人口数",width=15)
	private java.lang.Integer population;
	/**与户主关系*/
	@Excel(name="与户主关系",width=15,dicCode="与户主关系")
	private java.lang.String relationship;
	/**奖扶金*/
	@Excel(name="奖扶金",width=15)
	private java.math.BigDecimal jiangfu;
	/**特扶金*/
	@Excel(name="特扶金",width=15)
	private java.math.BigDecimal tefu;
	/**春节慰问金*/
	@Excel(name="春节慰问金",width=15)
	private java.math.BigDecimal weiwen;
	/**低保金*/
	@Excel(name="低保金",width=15)
	private java.math.BigDecimal dibao;
	/**特困供养金*/
	@Excel(name="特困供养金",width=15)
	private java.math.BigDecimal gongyang;
	/**养老保险金*/
	@Excel(name="养老保险金",width=15)
	private java.math.BigDecimal baoxian;
	/**生态补偿金*/
	@Excel(name="生态补偿金",width=15)
	private java.math.BigDecimal buchang;
	/**低保高龄补贴*/
	@Excel(name="低保高龄补贴",width=15)
	private java.math.BigDecimal gaoling;
	/**低保电量补贴*/
	@Excel(name="低保电量补贴",width=15)
	private java.math.BigDecimal dianliang;
	/**不能自理老人护理补贴*/
	@Excel(name="不能自理老人护理补贴",width=15)
	private java.math.BigDecimal huli;
	/**城镇三无人员生活费*/
	@Excel(name="城镇三无人员生活费",width=15)
	private java.math.BigDecimal sanwu;
	/**困难残疾人生活补贴*/
	@Excel(name="困难残疾人生活补贴",width=15)
	private java.math.BigDecimal canji;
	/**重度残疾人护理补贴*/
	@Excel(name="重度残疾人护理补贴",width=15)
	private java.math.BigDecimal zhongdu;
	/**孤儿生活费*/
	@Excel(name="孤儿生活费",width=15)
	private java.math.BigDecimal guer;
	/**困境儿童生活费*/
	@Excel(name="困境儿童生活费",width=15)
	private java.math.BigDecimal ertong;
	/**伤残军人*/
	@Excel(name="伤残军人",width=15)
	private java.math.BigDecimal junren;
	/**病故军人的家属*/
	@Excel(name="病故军人的家属",width=15)
	private java.math.BigDecimal sanshu;
	/**在乡复员军人*/
	@Excel(name="在乡复员军人",width=15)
	private java.math.BigDecimal fuyuan;
	/**带病回乡退伍军人*/
	@Excel(name="带病回乡退伍军人",width=15)
	private java.math.BigDecimal tuiwu;
	/**参加核试验*/
	@Excel(name="参加核试验",width=15)
	private java.math.BigDecimal shiyan;
	/**参战*/
	@Excel(name="参战",width=15)
	private java.math.BigDecimal canzhan;
	/**60岁以上农村籍退役士兵*/
	@Excel(name="60岁以上农村籍退役士兵",width=15)
	private java.math.BigDecimal tuiyi;
	/**部分烈士子女*/
	@Excel(name="部分烈士子女",width=15)
	private java.math.BigDecimal lieshi;
	/**朝阳助学*/
	@Excel(name="朝阳助学",width=15)
	private java.math.BigDecimal zhuxue;
	/**老年乡村医生生活补贴*/
	@Excel(name="老年乡村医生生活补贴",width=15)
	private java.math.BigDecimal yisheng;
	/**高龄补贴*/
	@Excel(name="高龄补贴",width=15)
	private java.math.BigDecimal gaolingbutie;
	/**企业遗属补助*/
	@Excel(name="企业遗属补助",width=15)
	private java.math.BigDecimal yishu;
	/**职工养老保险金*/
	@Excel(name="职工养老保险金",width=15)
	private java.math.BigDecimal zhigong;
	/**原民办代课教师教龄补助*/
	@Excel(name="原民办代课教师教龄补助",width=15)
	private java.math.BigDecimal jiaoshi;
	/**农支地保*/
	@Excel(name="农支地保",width=15)
	private java.math.BigDecimal nongzhi;
	/**棉花补贴*/
	@Excel(name="棉花补贴",width=15)
	private java.math.BigDecimal mianhua;
	/**居家托养*/
	@Excel(name="居家托养",width=15)
	private java.math.BigDecimal tuoyang;
	/**残疾学生*/
	@Excel(name="残疾学生",width=15)
	private java.math.BigDecimal xuesheng;
	/**残疾子女*/
	@Excel(name="残疾子女",width=15)
	private java.math.BigDecimal zinv;
	/**教育资助金*/
	@Excel(name="教育资助金",width=15)
	private java.math.BigDecimal jiaoyu;
	/**老民师待遇金*/
	@Excel(name="老民师待遇金",width=15)
	private java.math.BigDecimal minshi;
	/**老放影员生活补助*/
	@Excel(name="老放影员生活补助",width=15)
	private java.math.BigDecimal fangyingyuan;
	/**雨露计划*/
	@Excel(name="雨露计划",width=15)
	private java.math.BigDecimal yulu;
	/**产业扶贫项目受益*/
	@Excel(name="产业扶贫项目受益",width=15)
	private java.math.BigDecimal chanye;
	/**生产贷*/
	@Excel(name="生产贷",width=15)
	private java.math.BigDecimal shengchandai;
	/**村集体发放款*/
	@Excel(name="村集体发放款",width=15)
	private java.math.BigDecimal fafang;
	/**慈善帮扶项目*/
	@Excel(name="慈善帮扶项目",width=15)
	private java.math.BigDecimal bangfu;
	/**特困基金项目*/
	@Excel(name="特困基金项目",width=15)
	private java.math.BigDecimal jijin;
	/**慈善*/
	@Excel(name="慈善",width=15)
	private java.math.BigDecimal cishan;
	/**村集体入股分红*/
	@Excel(name="村集体入股分红",width=15)
	private java.math.BigDecimal fenhong;
	/**京博90岁以上老年人救助金*/
	@Excel(name="京博90岁以上老年人救助金",width=15)
	private java.math.BigDecimal laonianren;
	/**占地补偿*/
	@Excel(name="占地补偿",width=15)
	private java.math.BigDecimal zhandi;
	/**乡村干部退休金*/
	@Excel(name="乡村干部退休金",width=15)
	private java.math.BigDecimal ganbu;
	/**赡养费*/
	@Excel(name="赡养费",width=15)
	private java.math.BigDecimal shanyang;
	/**其他*/
	@Excel(name="其他",width=15)
	private java.math.BigDecimal qita;
	/**其他转移性收入合计*/
	@Excel(name="其他转移性收入合计",width=15)
	private java.math.BigDecimal zhuanyi;
	/**转移性收入合计*/
	@Excel(name="转移性收入合计",width=15)
	private java.math.BigDecimal zhuanyiheji;
	/**工资性收入*/
	@Excel(name="工资性收入",width=15)
	private java.math.BigDecimal gongzi;
	/**生产经营性收入*/
	@Excel(name="生产经营性收入",width=15)
	private java.math.BigDecimal shengchanjingying;
	/**资产收益扶贫分红收入*/
	@Excel(name="资产收益扶贫分红收入",width=15)
	private java.math.BigDecimal zichanshouyi;
	/**其他财产性收入*/
	@Excel(name="其他财产性收入",width=15)
	private java.math.BigDecimal caichanshouru;
	/**家庭总收入*/
	@Excel(name="家庭总收入",width=15)
	private java.math.BigDecimal jiating;
	/**生产经营性支出*/
	@Excel(name="生产经营性支出",width=15)
	private java.math.BigDecimal jingying;
	/**人均纯收入*/
	@Excel(name="人均纯收入",width=15)
	private java.math.BigDecimal renjun;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name ="ID",nullable=false,length=10)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行政县
	 */

	@Column(name ="DIST",nullable=false,length=30)
	public java.lang.String getDist(){
		return this.dist;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行政县
	 */
	public void setDist(java.lang.String dist){
		this.dist = dist;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乡镇
	 */

	@Column(name ="TOWN",nullable=false,length=30)
	public java.lang.String getTown(){
		return this.town;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  乡镇
	 */
	public void setTown(java.lang.String town){
		this.town = town;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行政村
	 */

	@Column(name ="VILLAGE",nullable=false,length=30)
	public java.lang.String getVillage(){
		return this.village;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行政村
	 */
	public void setVillage(java.lang.String village){
		this.village = village;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户编号
	 */

	@Column(name ="HOUSEHOLD_NO",nullable=false,length=30)
	public java.lang.String getHouseholdNo(){
		return this.householdNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户编号
	 */
	public void setHouseholdNo(java.lang.String householdNo){
		this.householdNo = householdNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人编号
	 */

	@Column(name ="HUMAN_NO",nullable=false,length=30)
	public java.lang.String getHumanNo(){
		return this.humanNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人编号
	 */
	public void setHumanNo(java.lang.String humanNo){
		this.humanNo = humanNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="NAME",nullable=false,length=30)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="IDNO",nullable=false,length=100)
	public java.lang.String getIdno(){
		return this.idno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdno(java.lang.String idno){
		this.idno = idno;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  家庭人口数
	 */

	@Column(name ="POPULATION",nullable=false,length=5)
	public java.lang.Integer getPopulation(){
		return this.population;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  家庭人口数
	 */
	public void setPopulation(java.lang.Integer population){
		this.population = population;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  与户主关系
	 */

	@Column(name ="RELATIONSHIP",nullable=false,length=30)
	public java.lang.String getRelationship(){
		return this.relationship;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  与户主关系
	 */
	public void setRelationship(java.lang.String relationship){
		this.relationship = relationship;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  奖扶金
	 */

	@Column(name ="JIANGFU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJiangfu(){
		return this.jiangfu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  奖扶金
	 */
	public void setJiangfu(java.math.BigDecimal jiangfu){
		this.jiangfu = jiangfu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  特扶金
	 */

	@Column(name ="TEFU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getTefu(){
		return this.tefu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  特扶金
	 */
	public void setTefu(java.math.BigDecimal tefu){
		this.tefu = tefu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  春节慰问金
	 */

	@Column(name ="WEIWEN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getWeiwen(){
		return this.weiwen;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  春节慰问金
	 */
	public void setWeiwen(java.math.BigDecimal weiwen){
		this.weiwen = weiwen;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  低保金
	 */

	@Column(name ="DIBAO",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getDibao(){
		return this.dibao;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  低保金
	 */
	public void setDibao(java.math.BigDecimal dibao){
		this.dibao = dibao;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  特困供养金
	 */

	@Column(name ="GONGYANG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getGongyang(){
		return this.gongyang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  特困供养金
	 */
	public void setGongyang(java.math.BigDecimal gongyang){
		this.gongyang = gongyang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  养老保险金
	 */

	@Column(name ="BAOXIAN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getBaoxian(){
		return this.baoxian;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  养老保险金
	 */
	public void setBaoxian(java.math.BigDecimal baoxian){
		this.baoxian = baoxian;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  生态补偿金
	 */

	@Column(name ="BUCHANG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getBuchang(){
		return this.buchang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  生态补偿金
	 */
	public void setBuchang(java.math.BigDecimal buchang){
		this.buchang = buchang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  低保高龄补贴
	 */

	@Column(name ="GAOLING",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getGaoling(){
		return this.gaoling;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  低保高龄补贴
	 */
	public void setGaoling(java.math.BigDecimal gaoling){
		this.gaoling = gaoling;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  低保电量补贴
	 */

	@Column(name ="DIANLIANG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getDianliang(){
		return this.dianliang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  低保电量补贴
	 */
	public void setDianliang(java.math.BigDecimal dianliang){
		this.dianliang = dianliang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  不能自理老人护理补贴
	 */

	@Column(name ="HULI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getHuli(){
		return this.huli;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  不能自理老人护理补贴
	 */
	public void setHuli(java.math.BigDecimal huli){
		this.huli = huli;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  城镇三无人员生活费
	 */

	@Column(name ="SANWU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getSanwu(){
		return this.sanwu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  城镇三无人员生活费
	 */
	public void setSanwu(java.math.BigDecimal sanwu){
		this.sanwu = sanwu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  困难残疾人生活补贴
	 */

	@Column(name ="CANJI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getCanji(){
		return this.canji;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  困难残疾人生活补贴
	 */
	public void setCanji(java.math.BigDecimal canji){
		this.canji = canji;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  重度残疾人护理补贴
	 */

	@Column(name ="ZHONGDU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZhongdu(){
		return this.zhongdu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  重度残疾人护理补贴
	 */
	public void setZhongdu(java.math.BigDecimal zhongdu){
		this.zhongdu = zhongdu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  孤儿生活费
	 */

	@Column(name ="GUER",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getGuer(){
		return this.guer;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  孤儿生活费
	 */
	public void setGuer(java.math.BigDecimal guer){
		this.guer = guer;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  困境儿童生活费
	 */

	@Column(name ="ERTONG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getErtong(){
		return this.ertong;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  困境儿童生活费
	 */
	public void setErtong(java.math.BigDecimal ertong){
		this.ertong = ertong;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  伤残军人
	 */

	@Column(name ="JUNREN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJunren(){
		return this.junren;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  伤残军人
	 */
	public void setJunren(java.math.BigDecimal junren){
		this.junren = junren;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  病故军人的家属
	 */

	@Column(name ="SANSHU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getSanshu(){
		return this.sanshu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  病故军人的家属
	 */
	public void setSanshu(java.math.BigDecimal sanshu){
		this.sanshu = sanshu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  在乡复员军人
	 */

	@Column(name ="FUYUAN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getFuyuan(){
		return this.fuyuan;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  在乡复员军人
	 */
	public void setFuyuan(java.math.BigDecimal fuyuan){
		this.fuyuan = fuyuan;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  带病回乡退伍军人
	 */

	@Column(name ="TUIWU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getTuiwu(){
		return this.tuiwu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  带病回乡退伍军人
	 */
	public void setTuiwu(java.math.BigDecimal tuiwu){
		this.tuiwu = tuiwu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  参加核试验
	 */

	@Column(name ="SHIYAN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getShiyan(){
		return this.shiyan;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  参加核试验
	 */
	public void setShiyan(java.math.BigDecimal shiyan){
		this.shiyan = shiyan;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  参战
	 */

	@Column(name ="CANZHAN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getCanzhan(){
		return this.canzhan;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  参战
	 */
	public void setCanzhan(java.math.BigDecimal canzhan){
		this.canzhan = canzhan;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  60岁以上农村籍退役士兵
	 */

	@Column(name ="TUIYI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getTuiyi(){
		return this.tuiyi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  60岁以上农村籍退役士兵
	 */
	public void setTuiyi(java.math.BigDecimal tuiyi){
		this.tuiyi = tuiyi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  部分烈士子女
	 */

	@Column(name ="LIESHI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getLieshi(){
		return this.lieshi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  部分烈士子女
	 */
	public void setLieshi(java.math.BigDecimal lieshi){
		this.lieshi = lieshi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  朝阳助学
	 */

	@Column(name ="ZHUXUE",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZhuxue(){
		return this.zhuxue;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  朝阳助学
	 */
	public void setZhuxue(java.math.BigDecimal zhuxue){
		this.zhuxue = zhuxue;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  老年乡村医生生活补贴
	 */

	@Column(name ="YISHENG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getYisheng(){
		return this.yisheng;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  老年乡村医生生活补贴
	 */
	public void setYisheng(java.math.BigDecimal yisheng){
		this.yisheng = yisheng;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  高龄补贴
	 */

	@Column(name ="GAOLINGBUTIE",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getGaolingbutie(){
		return this.gaolingbutie;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  高龄补贴
	 */
	public void setGaolingbutie(java.math.BigDecimal gaolingbutie){
		this.gaolingbutie = gaolingbutie;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  企业遗属补助
	 */

	@Column(name ="YISHU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getYishu(){
		return this.yishu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  企业遗属补助
	 */
	public void setYishu(java.math.BigDecimal yishu){
		this.yishu = yishu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  职工养老保险金
	 */

	@Column(name ="ZHIGONG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZhigong(){
		return this.zhigong;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  职工养老保险金
	 */
	public void setZhigong(java.math.BigDecimal zhigong){
		this.zhigong = zhigong;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  原民办代课教师教龄补助
	 */

	@Column(name ="JIAOSHI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJiaoshi(){
		return this.jiaoshi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  原民办代课教师教龄补助
	 */
	public void setJiaoshi(java.math.BigDecimal jiaoshi){
		this.jiaoshi = jiaoshi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  农支地保
	 */

	@Column(name ="NONGZHI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getNongzhi(){
		return this.nongzhi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  农支地保
	 */
	public void setNongzhi(java.math.BigDecimal nongzhi){
		this.nongzhi = nongzhi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  棉花补贴
	 */

	@Column(name ="MIANHUA",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getMianhua(){
		return this.mianhua;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  棉花补贴
	 */
	public void setMianhua(java.math.BigDecimal mianhua){
		this.mianhua = mianhua;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  居家托养
	 */

	@Column(name ="TUOYANG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getTuoyang(){
		return this.tuoyang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  居家托养
	 */
	public void setTuoyang(java.math.BigDecimal tuoyang){
		this.tuoyang = tuoyang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  残疾学生
	 */

	@Column(name ="XUESHENG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getXuesheng(){
		return this.xuesheng;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  残疾学生
	 */
	public void setXuesheng(java.math.BigDecimal xuesheng){
		this.xuesheng = xuesheng;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  残疾子女
	 */

	@Column(name ="ZINV",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZinv(){
		return this.zinv;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  残疾子女
	 */
	public void setZinv(java.math.BigDecimal zinv){
		this.zinv = zinv;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  教育资助金
	 */

	@Column(name ="JIAOYU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJiaoyu(){
		return this.jiaoyu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  教育资助金
	 */
	public void setJiaoyu(java.math.BigDecimal jiaoyu){
		this.jiaoyu = jiaoyu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  老民师待遇金
	 */

	@Column(name ="MINSHI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getMinshi(){
		return this.minshi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  老民师待遇金
	 */
	public void setMinshi(java.math.BigDecimal minshi){
		this.minshi = minshi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  老放影员生活补助
	 */

	@Column(name ="FANGYINGYUAN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getFangyingyuan(){
		return this.fangyingyuan;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  老放影员生活补助
	 */
	public void setFangyingyuan(java.math.BigDecimal fangyingyuan){
		this.fangyingyuan = fangyingyuan;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  雨露计划
	 */

	@Column(name ="YULU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getYulu(){
		return this.yulu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  雨露计划
	 */
	public void setYulu(java.math.BigDecimal yulu){
		this.yulu = yulu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  产业扶贫项目受益
	 */

	@Column(name ="CHANYE",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getChanye(){
		return this.chanye;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  产业扶贫项目受益
	 */
	public void setChanye(java.math.BigDecimal chanye){
		this.chanye = chanye;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  生产贷
	 */

	@Column(name ="SHENGCHANDAI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getShengchandai(){
		return this.shengchandai;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  生产贷
	 */
	public void setShengchandai(java.math.BigDecimal shengchandai){
		this.shengchandai = shengchandai;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  村集体发放款
	 */

	@Column(name ="FAFANG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getFafang(){
		return this.fafang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  村集体发放款
	 */
	public void setFafang(java.math.BigDecimal fafang){
		this.fafang = fafang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  慈善帮扶项目
	 */

	@Column(name ="BANGFU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getBangfu(){
		return this.bangfu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  慈善帮扶项目
	 */
	public void setBangfu(java.math.BigDecimal bangfu){
		this.bangfu = bangfu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  特困基金项目
	 */

	@Column(name ="JIJIN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJijin(){
		return this.jijin;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  特困基金项目
	 */
	public void setJijin(java.math.BigDecimal jijin){
		this.jijin = jijin;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  慈善
	 */

	@Column(name ="CISHAN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getCishan(){
		return this.cishan;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  慈善
	 */
	public void setCishan(java.math.BigDecimal cishan){
		this.cishan = cishan;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  村集体入股分红
	 */

	@Column(name ="FENHONG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getFenhong(){
		return this.fenhong;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  村集体入股分红
	 */
	public void setFenhong(java.math.BigDecimal fenhong){
		this.fenhong = fenhong;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  京博90岁以上老年人救助金
	 */

	@Column(name ="LAONIANREN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getLaonianren(){
		return this.laonianren;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  京博90岁以上老年人救助金
	 */
	public void setLaonianren(java.math.BigDecimal laonianren){
		this.laonianren = laonianren;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  占地补偿
	 */

	@Column(name ="ZHANDI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZhandi(){
		return this.zhandi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  占地补偿
	 */
	public void setZhandi(java.math.BigDecimal zhandi){
		this.zhandi = zhandi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  乡村干部退休金
	 */

	@Column(name ="GANBU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getGanbu(){
		return this.ganbu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  乡村干部退休金
	 */
	public void setGanbu(java.math.BigDecimal ganbu){
		this.ganbu = ganbu;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  赡养费
	 */

	@Column(name ="SHANYANG",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getShanyang(){
		return this.shanyang;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  赡养费
	 */
	public void setShanyang(java.math.BigDecimal shanyang){
		this.shanyang = shanyang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  其他
	 */

	@Column(name ="QITA",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getQita(){
		return this.qita;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  其他
	 */
	public void setQita(java.math.BigDecimal qita){
		this.qita = qita;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  其他转移性收入合计
	 */

	@Column(name ="ZHUANYI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZhuanyi(){
		return this.zhuanyi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  其他转移性收入合计
	 */
	public void setZhuanyi(java.math.BigDecimal zhuanyi){
		this.zhuanyi = zhuanyi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  转移性收入合计
	 */

	@Column(name ="ZHUANYIHEJI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZhuanyiheji(){
		return this.zhuanyiheji;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  转移性收入合计
	 */
	public void setZhuanyiheji(java.math.BigDecimal zhuanyiheji){
		this.zhuanyiheji = zhuanyiheji;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  工资性收入
	 */

	@Column(name ="GONGZI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getGongzi(){
		return this.gongzi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  工资性收入
	 */
	public void setGongzi(java.math.BigDecimal gongzi){
		this.gongzi = gongzi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  生产经营性收入
	 */

	@Column(name ="SHENGCHANJINGYING",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getShengchanjingying(){
		return this.shengchanjingying;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  生产经营性收入
	 */
	public void setShengchanjingying(java.math.BigDecimal shengchanjingying){
		this.shengchanjingying = shengchanjingying;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  资产收益扶贫分红收入
	 */

	@Column(name ="ZICHANSHOUYI",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getZichanshouyi(){
		return this.zichanshouyi;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  资产收益扶贫分红收入
	 */
	public void setZichanshouyi(java.math.BigDecimal zichanshouyi){
		this.zichanshouyi = zichanshouyi;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  其他财产性收入
	 */

	@Column(name ="CAICHANSHOURU",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getCaichanshouru(){
		return this.caichanshouru;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  其他财产性收入
	 */
	public void setCaichanshouru(java.math.BigDecimal caichanshouru){
		this.caichanshouru = caichanshouru;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  家庭总收入
	 */

	@Column(name ="JIATING",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJiating(){
		return this.jiating;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  家庭总收入
	 */
	public void setJiating(java.math.BigDecimal jiating){
		this.jiating = jiating;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  生产经营性支出
	 */

	@Column(name ="JINGYING",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getJingying(){
		return this.jingying;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  生产经营性支出
	 */
	public void setJingying(java.math.BigDecimal jingying){
		this.jingying = jingying;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  人均纯收入
	 */

	@Column(name ="RENJUN",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getRenjun(){
		return this.renjun;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  人均纯收入
	 */
	public void setRenjun(java.math.BigDecimal renjun){
		this.renjun = renjun;
	}
}