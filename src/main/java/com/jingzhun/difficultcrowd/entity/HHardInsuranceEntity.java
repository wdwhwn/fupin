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
 * @Description: 特困供养人员信息
 * @author onlineGenerator
 * @date 2019-03-22 09:41:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_hard_insurance", schema = "")
@SuppressWarnings("serial")
public class HHardInsuranceEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String idno;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="csex")
	private java.lang.String sex;
	/**民族*/
	@Excel(name="民族",width=15)
	private java.lang.String nation;
	/**婚姻状况*/
	@Excel(name="婚姻状况",width=15)
	private java.lang.String marriage;
	/**家庭关系*/
	@Excel(name="家庭关系",width=15)
	private java.lang.String relation;
	/**户主姓名*/
	@Excel(name="户主姓名",width=15)
	private java.lang.String householder;
	/**户主证件*/
	@Excel(name="户主证件",width=15)
	private java.lang.String householderid;
	/**地区*/
	@Excel(name="地区",width=15)
	private java.lang.String district;
	/**家庭住址*/
	@Excel(name="家庭住址",width=15)
	private java.lang.String homeAddress;
	/**特困编号*/
	@Excel(name="特困编号",width=15)
	private java.lang.String code;
	/**出生日期*/
	@Excel(name="出生日期",width=15)
	private java.lang.String birthday;
	/**是否残疾*/
	@Excel(name="是否残疾",width=15,dicCode="disability")
	private java.lang.String isDisabled;
	/**残疾证号*/
	@Excel(name="残疾证号",width=15)
	private java.lang.String disabledid;
	/**残疾类别*/
	@Excel(name="残疾类别",width=15)
	private java.lang.String disabledtype;
	/**残疾等级*/
	@Excel(name="残疾等级",width=15)
	private java.lang.String disabledlevel;
	/**详细地址*/
	@Excel(name="详细地址",width=15)
	private java.lang.String address;
	/**供养方式*/
	private java.lang.String mode;
	
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
	 *@return: java.lang.String  证件号码
	 */

	@Column(name ="IDNO",nullable=false,length=50)
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

	@Column(name ="SEX",nullable=false,length=10)
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
	 *@return: java.lang.String  民族
	 */

	@Column(name ="NATION",nullable=false,length=10)
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
	 *@return: java.lang.String  婚姻状况
	 */

	@Column(name ="MARRIAGE",nullable=false,length=20)
	public java.lang.String getMarriage(){
		return this.marriage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setMarriage(java.lang.String marriage){
		this.marriage = marriage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭关系
	 */

	@Column(name ="RELATION",nullable=false,length=20)
	public java.lang.String getRelation(){
		return this.relation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭关系
	 */
	public void setRelation(java.lang.String relation){
		this.relation = relation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户主姓名
	 */

	@Column(name ="HOUSEHOLDER",nullable=false,length=30)
	public java.lang.String getHouseholder(){
		return this.householder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主姓名
	 */
	public void setHouseholder(java.lang.String householder){
		this.householder = householder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户主证件
	 */

	@Column(name ="HOUSEHOLDERID",nullable=false,length=50)
	public java.lang.String getHouseholderid(){
		return this.householderid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主证件
	 */
	public void setHouseholderid(java.lang.String householderid){
		this.householderid = householderid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地区
	 */

	@Column(name ="DISTRICT",nullable=false,length=30)
	public java.lang.String getDistrict(){
		return this.district;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地区
	 */
	public void setDistrict(java.lang.String district){
		this.district = district;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */

	@Column(name ="HOME_ADDRESS",nullable=false,length=200)
	public java.lang.String getHomeAddress(){
		return this.homeAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭住址
	 */
	public void setHomeAddress(java.lang.String homeAddress){
		this.homeAddress = homeAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特困编号
	 */

	@Column(name ="CODE",nullable=true,length=50)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特困编号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生日期
	 */

	@Column(name ="BIRTHDAY",nullable=false,length=30)
	public java.lang.String getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期
	 */
	public void setBirthday(java.lang.String birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否残疾
	 */

	@Column(name ="IS_DISABLED",nullable=true,length=10)
	public java.lang.String getIsDisabled(){
		return this.isDisabled;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否残疾
	 */
	public void setIsDisabled(java.lang.String isDisabled){
		this.isDisabled = isDisabled;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾证号
	 */

	@Column(name ="DISABLEDID",nullable=true,length=50)
	public java.lang.String getDisabledid(){
		return this.disabledid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾证号
	 */
	public void setDisabledid(java.lang.String disabledid){
		this.disabledid = disabledid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾类别
	 */

	@Column(name ="DISABLEDTYPE",nullable=true,length=30)
	public java.lang.String getDisabledtype(){
		return this.disabledtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾类别
	 */
	public void setDisabledtype(java.lang.String disabledtype){
		this.disabledtype = disabledtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾等级
	 */

	@Column(name ="DISABLEDLEVEL",nullable=true,length=20)
	public java.lang.String getDisabledlevel(){
		return this.disabledlevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾等级
	 */
	public void setDisabledlevel(java.lang.String disabledlevel){
		this.disabledlevel = disabledlevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */

	@Column(name ="ADDRESS",nullable=false,length=200)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供养方式
	 */

	@Column(name ="MODE",nullable=true,length=20)
	public java.lang.String getMode(){
		return this.mode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供养方式
	 */
	public void setMode(java.lang.String mode){
		this.mode = mode;
	}
}