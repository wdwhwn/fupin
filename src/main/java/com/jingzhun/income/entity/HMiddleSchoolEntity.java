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
 * @Description: 中学教育补助金
 * @author onlineGenerator
 * @date 2019-03-23 10:28:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_middle_school", schema = "")
@SuppressWarnings("serial")
public class HMiddleSchoolEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="csex")
	private java.lang.String sex;
	/**身份证号码*/
	@Excel(name="身份证号码",width=15)
	private java.lang.String idno;
	/**所在学校班级*/
	@Excel(name="所在学校班级",width=15)
	private java.lang.String school;
	/**是否为寄宿生*/
	@Excel(name="是否为寄宿生",width=15,dicCode="是否寄宿")
	private java.lang.String isLodging;
	/**家庭住址*/
	@Excel(name="家庭住址",width=15)
	private java.lang.String address;
	/**户主姓名*/
	@Excel(name="户主姓名",width=15)
	private java.lang.String householderName;
	/**开户行*/
	@Excel(name="开户行",width=15)
	private java.lang.String bank;
	/**账户名*/
	@Excel(name="账户名",width=15)
	private java.lang.String bankAccount;
	/**账户号码*/
	@Excel(name="账户号码",width=15)
	private java.lang.String bankNo;
	
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

	@Column(name ="NAME",nullable=true,length=50)
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
	 *@return: java.lang.String  身份证号码
	 */

	@Column(name ="IDNO",nullable=false,length=50)
	public java.lang.String getIdno(){
		return this.idno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号码
	 */
	public void setIdno(java.lang.String idno){
		this.idno = idno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在学校班级
	 */

	@Column(name ="SCHOOL",nullable=true,length=100)
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
	 *@return: java.lang.String  是否为寄宿生
	 */

	@Column(name ="IS_LODGING",nullable=true,length=10)
	public java.lang.String getIsLodging(){
		return this.isLodging;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否为寄宿生
	 */
	public void setIsLodging(java.lang.String isLodging){
		this.isLodging = isLodging;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */

	@Column(name ="ADDRESS",nullable=true,length=100)
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
	 *@return: java.lang.String  户主姓名
	 */

	@Column(name ="HOUSEHOLDER_NAME",nullable=true,length=30)
	public java.lang.String getHouseholderName(){
		return this.householderName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主姓名
	 */
	public void setHouseholderName(java.lang.String householderName){
		this.householderName = householderName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行
	 */

	@Column(name ="BANK",nullable=true,length=100)
	public java.lang.String getBank(){
		return this.bank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行
	 */
	public void setBank(java.lang.String bank){
		this.bank = bank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户名
	 */

	@Column(name ="BANK_ACCOUNT",nullable=true,length=50)
	public java.lang.String getBankAccount(){
		return this.bankAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户名
	 */
	public void setBankAccount(java.lang.String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户号码
	 */

	@Column(name ="BANK_NO",nullable=true,length=50)
	public java.lang.String getBankNo(){
		return this.bankNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户号码
	 */
	public void setBankNo(java.lang.String bankNo){
		this.bankNo = bankNo;
	}
}