package com.jingzhun.property.entity;

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
 * @Description: 大型农机局信息
 * @author onlineGenerator
 * @date 2019-03-22 15:04:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_farm_machinery", schema = "")
@SuppressWarnings("serial")
public class HFarmMachineryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**地址 姓名*/
	@Excel(name="地址 姓名",width=15)
	private java.lang.String name;
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String idno;
	/**类型*/
	@Excel(name="类型",width=15)
	private java.lang.String type;
	/**车型*/
	@Excel(name="车型",width=15)
	private java.lang.String carType;
	/**注册登记日期*/
	@Excel(name="注册登记日期",width=15)
	private java.lang.String registrationDate;
	/**年检到期日*/
	@Excel(name="年检到期日",width=15)
	private java.lang.String expirationDate;
	
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
	 *@return: java.lang.String  地址 姓名
	 */

	@Column(name ="NAME",nullable=true,length=200)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址 姓名
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
	 *@return: java.lang.String  类型
	 */

	@Column(name ="TYPE",nullable=true,length=50)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型
	 */

	@Column(name ="CAR_TYPE",nullable=true,length=50)
	public java.lang.String getCarType(){
		return this.carType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型
	 */
	public void setCarType(java.lang.String carType){
		this.carType = carType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册登记日期
	 */

	@Column(name ="REGISTRATION_DATE",nullable=true,length=30)
	public java.lang.String getRegistrationDate(){
		return this.registrationDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册登记日期
	 */
	public void setRegistrationDate(java.lang.String registrationDate){
		this.registrationDate = registrationDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年检到期日
	 */

	@Column(name ="EXPIRATION_DATE",nullable=true,length=30)
	public java.lang.String getExpirationDate(){
		return this.expirationDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年检到期日
	 */
	public void setExpirationDate(java.lang.String expirationDate){
		this.expirationDate = expirationDate;
	}
}