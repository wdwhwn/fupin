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
 * @Description: 农商行博华农业
 * @author onlineGenerator
 * @date 2019-03-22 16:54:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_hard_population", schema = "")
@SuppressWarnings("serial")
public class HHardPopulationEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**乡镇*/
	@Excel(name="乡镇",width=15)
	private java.lang.String town;
	/**行政村*/
	@Excel(name="行政村",width=15)
	private java.lang.String village;
	/**带动脱贫人口姓名*/
	@Excel(name="带动脱贫人口姓名",width=15)
	private java.lang.String leadName;
	/**性别*/
	@Excel(name="性别",width=15)
	private java.lang.String sex;
	/**身份证号码*/
	@Excel(name="身份证号码",width=15)
	private java.lang.String idno;
	/**家庭人口*/
	@Excel(name="家庭人口",width=15)
	private java.lang.String population;
	/**账户名*/
	@Excel(name="账户名",width=15)
	private java.lang.String account;
	/**一卡通账号*/
	@Excel(name="一卡通账号",width=15)
	private java.lang.String code;
	/**开户行*/
	@Excel(name="开户行",width=15)
	private java.lang.String bank;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String reamrk;
	/**发放金额*/
	@Excel(name="发放金额",width=15)
	private java.math.BigDecimal money;
	
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
	 *@return: java.lang.String  乡镇
	 */

	@Column(name ="TOWN",nullable=true,length=50)
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

	@Column(name ="VILLAGE",nullable=true,length=50)
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
	 *@return: java.lang.String  带动脱贫人口姓名
	 */

	@Column(name ="LEAD_NAME",nullable=true,length=50)
	public java.lang.String getLeadName(){
		return this.leadName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  带动脱贫人口姓名
	 */
	public void setLeadName(java.lang.String leadName){
		this.leadName = leadName;
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
	 *@return: java.lang.String  家庭人口
	 */

	@Column(name ="POPULATION",nullable=true,length=10)
	public java.lang.String getPopulation(){
		return this.population;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭人口
	 */
	public void setPopulation(java.lang.String population){
		this.population = population;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户名
	 */

	@Column(name ="ACCOUNT",nullable=true,length=50)
	public java.lang.String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户名
	 */
	public void setAccount(java.lang.String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  一卡通账号
	 */

	@Column(name ="CODE",nullable=true,length=50)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  一卡通账号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
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
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REAMRK",nullable=true,length=255)
	public java.lang.String getReamrk(){
		return this.reamrk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setReamrk(java.lang.String reamrk){
		this.reamrk = reamrk;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  发放金额
	 */

	@Column(name ="MONEY",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  发放金额
	 */
	public void setMoney(java.math.BigDecimal money){
		this.money = money;
	}
}