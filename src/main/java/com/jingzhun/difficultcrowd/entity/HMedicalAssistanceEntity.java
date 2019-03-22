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
 * @Description: 低保五保救助台账
 * @author onlineGenerator
 * @date 2019-03-22 11:29:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_medical_assistance", schema = "")
@SuppressWarnings("serial")
public class HMedicalAssistanceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**身份证号码*/
	@Excel(name="身份证号码",width=15)
	private java.lang.String idno;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="csex")
	private java.lang.String sex;
	/**出生日期*/
	@Excel(name="出生日期",width=15)
	private java.lang.String birthday;
	/**家庭住址*/
	@Excel(name="家庭住址",width=15)
	private java.lang.String address;
	/**疾病诊断*/
	@Excel(name="疾病诊断",width=15)
	private java.lang.String disease;
	/**救助金额*/
	@Excel(name="救助金额",width=15)
	private java.math.BigDecimal money;
	/**救助人员类别*/
	@Excel(name="救助人员类别",width=15)
	private java.lang.String type;
	/**救助时间*/
	@Excel(name="救助时间",width=15)
	private java.lang.String rescueTime;
	/**救助比例*/
	@Excel(name="救助比例",width=15)
	private java.math.BigDecimal proportion;
	/**是否建档*/
	private java.lang.String jiandang;
	
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
	 *@return: java.lang.String  身份证号码
	 */

	@Column(name ="IDNO",nullable=true,length=50)
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
	 *@return: java.lang.String  出生日期
	 */

	@Column(name ="BIRTHDAY",nullable=true,length=20)
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
	 *@return: java.lang.String  疾病诊断
	 */

	@Column(name ="DISEASE",nullable=true,length=50)
	public java.lang.String getDisease(){
		return this.disease;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  疾病诊断
	 */
	public void setDisease(java.lang.String disease){
		this.disease = disease;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  救助金额
	 */

	@Column(name ="MONEY",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  救助金额
	 */
	public void setMoney(java.math.BigDecimal money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  救助人员类别
	 */

	@Column(name ="TYPE",nullable=true,length=100)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  救助人员类别
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  救助时间
	 */

	@Column(name ="RESCUE_TIME",nullable=true,length=100)
	public java.lang.String getRescueTime(){
		return this.rescueTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  救助时间
	 */
	public void setRescueTime(java.lang.String rescueTime){
		this.rescueTime = rescueTime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  救助比例
	 */

	@Column(name ="PROPORTION",nullable=true,scale=2,length=5)
	public java.math.BigDecimal getProportion(){
		return this.proportion;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  救助比例
	 */
	public void setProportion(java.math.BigDecimal proportion){
		this.proportion = proportion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否建档
	 */

	@Column(name ="JIANDANG",nullable=false,length=100)
	public java.lang.String getJiandang(){
		return this.jiandang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否建档
	 */
	public void setJiandang(java.lang.String jiandang){
		this.jiandang = jiandang;
	}
}