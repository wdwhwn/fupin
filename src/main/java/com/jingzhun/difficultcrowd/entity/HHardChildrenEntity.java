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
 * @Description: 困境儿童数据
 * @author onlineGenerator
 * @date 2019-03-22 11:23:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_hard_children", schema = "")
@SuppressWarnings("serial")
public class HHardChildrenEntity implements java.io.Serializable {
	/**主键*/
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
	/**出生日期*/
	@Excel(name="出生日期",width=15)
	private java.lang.String birthday;
	/**年龄*/
	@Excel(name="年龄",width=15)
	private java.lang.Integer age;
	/**户籍地址*/
	@Excel(name="户籍地址",width=15)
	private java.lang.String address;
	/**家庭住址*/
	@Excel(name="家庭住址",width=15)
	private java.lang.String homeAddress;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String remark;
	/**序号*/
	@Excel(name="序号",width=15)
	private java.lang.String sort;
	/**儿童福利证编号*/
	@Excel(name="儿童福利证编号",width=15)
	private java.lang.String code;
	/**户口类型*/
	@Excel(name="户口类型",width=15)
	private java.lang.Integer type;
	/**生活状态*/
	@Excel(name="生活状态",width=15)
	private java.lang.Integer state;
	/**监护人*/
	@Excel(name="监护人",width=15)
	private java.lang.Integer guardian;
	
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
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=20)
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

	@Column(name ="BIRTHDAY",nullable=true,length=30)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年龄
	 */

	@Column(name ="AGE",nullable=false,length=10)
	public java.lang.Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年龄
	 */
	public void setAge(java.lang.Integer age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍地址
	 */

	@Column(name ="ADDRESS",nullable=true,length=200)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */

	@Column(name ="HOME_ADDRESS",nullable=true,length=200)
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
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  序号
	 */

	@Column(name ="SORT",nullable=false,length=10)
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
	 *@return: java.lang.String  儿童福利证编号
	 */

	@Column(name ="CODE",nullable=true,length=50)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  儿童福利证编号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  户口类型
	 */

	@Column(name ="TYPE",nullable=false,length=10)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  户口类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  生活状态
	 */

	@Column(name ="STATE",nullable=false,length=10)
	public java.lang.Integer getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  生活状态
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  监护人
	 */

	@Column(name ="GUARDIAN",nullable=false,length=10)
	public java.lang.Integer getGuardian(){
		return this.guardian;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  监护人
	 */
	public void setGuardian(java.lang.Integer guardian){
		this.guardian = guardian;
	}
}