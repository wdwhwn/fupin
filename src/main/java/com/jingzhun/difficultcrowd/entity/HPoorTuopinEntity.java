package com.jingzhun.difficultcrowd.entity;

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
 * @Description: 脱贫不享受政策
 * @author onlineGenerator
 * @date 2019-03-22 09:47:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_poor_tuopin", schema = "")
@SuppressWarnings("serial")
public class HPoorTuopinEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**行政县*/
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
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String idno;
	/**人数*/
	@Excel(name="人数",width=15)
	private java.lang.String population;
	/**与户主关系*/
	@Excel(name="与户主关系",width=15)
	private java.lang.String relationship;
	/**民族*/
	@Excel(name="民族",width=15)
	private java.lang.String nation;
	/**文化程度*/
	@Excel(name="文化程度",width=15)
	private java.lang.String education;
	/**在校生状况*/
	@Excel(name="在校生状况",width=15)
	private java.lang.String school;
	/**健康状况*/
	@Excel(name="健康状况",width=15)
	private java.lang.String health;
	/**劳动技能*/
	@Excel(name="劳动技能",width=15)
	private java.lang.String labor;
	/**务工状况*/
	@Excel(name="务工状况",width=15)
	private java.lang.String work;
	/**务工时间*/
	@Excel(name="务工时间",width=15)
	private java.lang.String workTime;
	/**参加大病医疗*/
	@Excel(name="参加大病医疗",width=15)
	private java.lang.String seriousIllness;
	/**脱贫属性*/
	@Excel(name="脱贫属性",width=15)
	private java.lang.String poverty;
	/**脱贫年度*/
	@Excel(name="脱贫年度",width=15)
	private java.lang.String povertyYear;
	/**贫困户属性*/
	@Excel(name="贫困户属性",width=15)
	private java.lang.String poor;
	/**致贫原因*/
	@Excel(name="致贫原因",width=15)
	private java.lang.String reson;
	/**危房户*/
	@Excel(name="危房户",width=15)
	private java.lang.String house;
	/**是否解决安全饮用水*/
	@Excel(name="是否解决安全饮用水",width=15)
	private java.lang.String water;
	/**人均纯收入*/
	@Excel(name="人均纯收入",width=15)
	private java.math.BigDecimal income;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String mobile;
	
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

	@Column(name ="DIST",nullable=false,length=100)
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

	@Column(name ="TOWN",nullable=false,length=100)
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

	@Column(name ="VILLAGE",nullable=false,length=100)
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

	@Column(name ="HOUSEHOLD_NO",nullable=false,length=100)
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

	@Column(name ="HUMAN_NO",nullable=false,length=100)
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

	@Column(name ="NAME",nullable=false,length=100)
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
	 *@return: java.lang.String  证件号码
	 */

	@Column(name ="IDNO",nullable=false,length=100)
	public java.lang.String getIdno(){
		return this.idno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setIdno(java.lang.String idno){
		this.idno = idno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人数
	 */

	@Column(name ="POPULATION",nullable=false,length=100)
	public java.lang.String getPopulation(){
		return this.population;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人数
	 */
	public void setPopulation(java.lang.String population){
		this.population = population;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  与户主关系
	 */

	@Column(name ="RELATIONSHIP",nullable=false,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */

	@Column(name ="NATION",nullable=false,length=100)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文化程度
	 */

	@Column(name ="EDUCATION",nullable=false,length=100)
	public java.lang.String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化程度
	 */
	public void setEducation(java.lang.String education){
		this.education = education;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在校生状况
	 */

	@Column(name ="SCHOOL",nullable=false,length=100)
	public java.lang.String getSchool(){
		return this.school;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在校生状况
	 */
	public void setSchool(java.lang.String school){
		this.school = school;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  健康状况
	 */

	@Column(name ="HEALTH",nullable=false,length=100)
	public java.lang.String getHealth(){
		return this.health;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  健康状况
	 */
	public void setHealth(java.lang.String health){
		this.health = health;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  劳动技能
	 */

	@Column(name ="LABOR",nullable=false,length=100)
	public java.lang.String getLabor(){
		return this.labor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  劳动技能
	 */
	public void setLabor(java.lang.String labor){
		this.labor = labor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  务工状况
	 */

	@Column(name ="WORK",nullable=false,length=100)
	public java.lang.String getWork(){
		return this.work;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  务工状况
	 */
	public void setWork(java.lang.String work){
		this.work = work;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  务工时间
	 */

	@Column(name ="WORK_TIME",nullable=false,length=100)
	public java.lang.String getWorkTime(){
		return this.workTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  务工时间
	 */
	public void setWorkTime(java.lang.String workTime){
		this.workTime = workTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加大病医疗
	 */

	@Column(name ="SERIOUS_ILLNESS",nullable=false,length=100)
	public java.lang.String getSeriousIllness(){
		return this.seriousIllness;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加大病医疗
	 */
	public void setSeriousIllness(java.lang.String seriousIllness){
		this.seriousIllness = seriousIllness;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  脱贫属性
	 */

	@Column(name ="POVERTY",nullable=false,length=100)
	public java.lang.String getPoverty(){
		return this.poverty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脱贫属性
	 */
	public void setPoverty(java.lang.String poverty){
		this.poverty = poverty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  脱贫年度
	 */

	@Column(name ="POVERTY_YEAR",nullable=false,length=100)
	public java.lang.String getPovertyYear(){
		return this.povertyYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脱贫年度
	 */
	public void setPovertyYear(java.lang.String povertyYear){
		this.povertyYear = povertyYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贫困户属性
	 */

	@Column(name ="POOR",nullable=false,length=100)
	public java.lang.String getPoor(){
		return this.poor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贫困户属性
	 */
	public void setPoor(java.lang.String poor){
		this.poor = poor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  致贫原因
	 */

	@Column(name ="RESON",nullable=false,length=100)
	public java.lang.String getReson(){
		return this.reson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  致贫原因
	 */
	public void setReson(java.lang.String reson){
		this.reson = reson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  危房户
	 */

	@Column(name ="HOUSE",nullable=false,length=100)
	public java.lang.String getHouse(){
		return this.house;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  危房户
	 */
	public void setHouse(java.lang.String house){
		this.house = house;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否解决安全饮用水
	 */

	@Column(name ="WATER",nullable=false,length=100)
	public java.lang.String getWater(){
		return this.water;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否解决安全饮用水
	 */
	public void setWater(java.lang.String water){
		this.water = water;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  人均纯收入
	 */

	@Column(name ="INCOME",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getIncome(){
		return this.income;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  人均纯收入
	 */
	public void setIncome(java.math.BigDecimal income){
		this.income = income;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="MOBILE",nullable=false,length=100)
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
	}
}