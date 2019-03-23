package com.jingzhun.income.entity;

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
 * @Description: 幼儿园教育补助金
 * @author onlineGenerator
 * @date 2019-03-23 09:34:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_spring_kindergarten", schema = "")
@SuppressWarnings("serial")
public class HSpringKindergartenEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="csex")
	private java.lang.String sex;
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String idno;
	/**所在学校班级*/
	@Excel(name="所在学校班级",width=15)
	private java.lang.String school;
	/**家庭住址*/
	@Excel(name="家庭住址",width=15)
	private java.lang.String address;
	/**户主*/
	@Excel(name="户主",width=15)
	private java.lang.String huzhu;
	/**开户行*/
	@Excel(name="开户行",width=15)
	private java.lang.String idcard;
	/**开户行用户名*/
	@Excel(name="开户行用户名",width=15)
	private java.lang.String idcardName;
	/**开户行账号*/
	@Excel(name="开户行账号",width=15)
	private java.lang.String idcardNum;
	
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
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="NAME",nullable=true,length=30)
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
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=30)
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
	 *@return: java.lang.String  证件号码
	 */

	@Column(name ="IDNO",nullable=true,length=50)
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
	 *@return: java.lang.String  所在学校班级
	 */

	@Column(name ="SCHOOL",nullable=true,length=255)
	public java.lang.String getSchool(){
		return this.school;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在学校班级
	 */
	public void setSchool(java.lang.String school){
		this.school = school;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */

	@Column(name ="ADDRESS",nullable=true,length=255)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭住址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户主
	 */

	@Column(name ="HUZHU",nullable=true,length=255)
	public java.lang.String getHuzhu(){
		return this.huzhu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主
	 */
	public void setHuzhu(java.lang.String huzhu){
		this.huzhu = huzhu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行
	 */

	@Column(name ="IDCARD",nullable=true,length=255)
	public java.lang.String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行
	 */
	public void setIdcard(java.lang.String idcard){
		this.idcard = idcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行用户名
	 */

	@Column(name ="IDCARD_NAME",nullable=true,length=255)
	public java.lang.String getIdcardName(){
		return this.idcardName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行用户名
	 */
	public void setIdcardName(java.lang.String idcardName){
		this.idcardName = idcardName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行账号
	 */

	@Column(name ="IDCARD_NUM",nullable=true,length=255)
	public java.lang.String getIdcardNum(){
		return this.idcardNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行账号
	 */
	public void setIdcardNum(java.lang.String idcardNum){
		this.idcardNum = idcardNum;
	}
}