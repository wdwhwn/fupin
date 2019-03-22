package com.jingzhun.department.entity;

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
 * @Description: 爱心助困党员先锋队
 * @author onlineGenerator
 * @date 2019-03-22 17:18:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_teams", schema = "")
@SuppressWarnings("serial")
public class HTeamsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**序号*/
	@Excel(name="序号",width=15)
	private java.lang.String sort;
	/**区县*/
	private java.lang.String district;
	/**乡镇*/
	@Excel(name="乡镇",width=15)
	private java.lang.String town;
	/**行政村*/
	@Excel(name="行政村",width=15)
	private java.lang.String village;
	/**户主姓名*/
	@Excel(name="户主姓名",width=15)
	private java.lang.String name;
	/**家庭成员姓名*/
	@Excel(name="家庭成员姓名",width=15)
	private java.lang.String familyName;
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String idno;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="csex")
	private java.lang.String sex;
	/**与户主关系*/
	@Excel(name="与户主关系",width=15)
	private java.lang.String relationship;
	/**家庭成员数*/
	@Excel(name="家庭成员数",width=15)
	private java.lang.Integer familyNumber;
	/**帮扶责任人*/
	@Excel(name="帮扶责任人",width=15)
	private java.lang.String personLiable;
	/**帮扶人手机号*/
	@Excel(name="帮扶人手机号",width=15)
	private java.lang.String mobileHelp;
	/**派出单位*/
	@Excel(name="派出单位",width=15)
	private java.lang.String unit;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String contact;
	/**爱心助困帮扶党员*/
	@Excel(name="爱心助困帮扶党员",width=15)
	private java.lang.String partyMember;
	/**村内职务*/
	@Excel(name="村内职务",width=15)
	private java.lang.String job;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String mobile;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name ="ID",nullable=false,length=10)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  序号
	 */

	@Column(name ="SORT",nullable=true,length=10)
	public java.lang.String getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  序号
	 */
	public void setSort(java.lang.String sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区县
	 */

	@Column(name ="DISTRICT",nullable=true,length=128)
	public java.lang.String getDistrict(){
		return this.district;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区县
	 */
	public void setDistrict(java.lang.String district){
		this.district = district;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乡镇
	 */

	@Column(name ="TOWN",nullable=true,length=128)
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

	@Column(name ="VILLAGE",nullable=true,length=128)
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
	 *@return: java.lang.String  户主姓名
	 */

	@Column(name ="NAME",nullable=true,length=128)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭成员姓名
	 */

	@Column(name ="FAMILY_NAME",nullable=true,length=128)
	public java.lang.String getFamilyName(){
		return this.familyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭成员姓名
	 */
	public void setFamilyName(java.lang.String familyName){
		this.familyName = familyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码
	 */

	@Column(name ="IDNO",nullable=false,length=128)
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
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=10)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  与户主关系
	 */

	@Column(name ="RELATIONSHIP",nullable=true,length=10)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  家庭成员数
	 */

	@Column(name ="FAMILY_NUMBER",nullable=true,length=10)
	public java.lang.Integer getFamilyNumber(){
		return this.familyNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  家庭成员数
	 */
	public void setFamilyNumber(java.lang.Integer familyNumber){
		this.familyNumber = familyNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  帮扶责任人
	 */

	@Column(name ="PERSON_LIABLE",nullable=true,length=50)
	public java.lang.String getPersonLiable(){
		return this.personLiable;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  帮扶责任人
	 */
	public void setPersonLiable(java.lang.String personLiable){
		this.personLiable = personLiable;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  帮扶人手机号
	 */

	@Column(name ="MOBILE_HELP",nullable=true,length=255)
	public java.lang.String getMobileHelp(){
		return this.mobileHelp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  帮扶人手机号
	 */
	public void setMobileHelp(java.lang.String mobileHelp){
		this.mobileHelp = mobileHelp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派出单位
	 */

	@Column(name ="UNIT",nullable=true,length=255)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派出单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="CONTACT",nullable=true,length=255)
	public java.lang.String getContact(){
		return this.contact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setContact(java.lang.String contact){
		this.contact = contact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  爱心助困帮扶党员
	 */

	@Column(name ="PARTY_MEMBER",nullable=true,length=255)
	public java.lang.String getPartyMember(){
		return this.partyMember;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  爱心助困帮扶党员
	 */
	public void setPartyMember(java.lang.String partyMember){
		this.partyMember = partyMember;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  村内职务
	 */

	@Column(name ="JOB",nullable=true,length=255)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  村内职务
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="MOBILE",nullable=true,length=255)
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