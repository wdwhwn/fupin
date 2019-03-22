package com.jingzhun.income.tuopincuoshi.entity;

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
 * @Description: 项目脱贫
 * @author onlineGenerator
 * @date 2019-03-22 12:54:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_project_help_poor", schema = "")
@SuppressWarnings("serial")
public class HProjectHelpPoorEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**村名*/
	@Excel(name="村名",width=15)
	private java.lang.String village;
	/**户主*/
	@Excel(name="户主",width=15)
	private java.lang.String name;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String idno;
	/**家庭人口数*/
	@Excel(name="家庭人口数",width=15)
	private java.lang.Integer family;
	/**农机*/
	@Excel(name="农机",width=15)
	private java.lang.Integer machine;
	/**食用菌*/
	@Excel(name="食用菌",width=15)
	private java.lang.Integer fungi;
	/**果蔬发酵*/
	@Excel(name="果蔬发酵",width=15)
	private java.lang.Integer fermentation;
	/**整改*/
	@Excel(name="整改",width=15)
	private java.lang.Integer rectification;
	/**人口额度*/
	@Excel(name="人口额度",width=15)
	private java.lang.Integer money;
	/**合计收益数*/
	@Excel(name="合计收益数",width=15)
	private java.lang.Integer total;
	
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
	 *@return: java.lang.String  村名
	 */

	@Column(name ="VILLAGE",nullable=false,length=50)
	public java.lang.String getVillage(){
		return this.village;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  村名
	 */
	public void setVillage(java.lang.String village){
		this.village = village;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户主
	 */

	@Column(name ="NAME",nullable=false,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="IDNO",nullable=false,length=50)
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

	@Column(name ="FAMILY",nullable=false,length=10)
	public java.lang.Integer getFamily(){
		return this.family;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  家庭人口数
	 */
	public void setFamily(java.lang.Integer family){
		this.family = family;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  农机
	 */

	@Column(name ="MACHINE",nullable=false,length=10)
	public java.lang.Integer getMachine(){
		return this.machine;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  农机
	 */
	public void setMachine(java.lang.Integer machine){
		this.machine = machine;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  食用菌
	 */

	@Column(name ="FUNGI",nullable=false,length=10)
	public java.lang.Integer getFungi(){
		return this.fungi;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  食用菌
	 */
	public void setFungi(java.lang.Integer fungi){
		this.fungi = fungi;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  果蔬发酵
	 */

	@Column(name ="FERMENTATION",nullable=false,length=10)
	public java.lang.Integer getFermentation(){
		return this.fermentation;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  果蔬发酵
	 */
	public void setFermentation(java.lang.Integer fermentation){
		this.fermentation = fermentation;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  整改
	 */

	@Column(name ="RECTIFICATION",nullable=false,length=10)
	public java.lang.Integer getRectification(){
		return this.rectification;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  整改
	 */
	public void setRectification(java.lang.Integer rectification){
		this.rectification = rectification;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人口额度
	 */

	@Column(name ="MONEY",nullable=false,length=10)
	public java.lang.Integer getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  人口额度
	 */
	public void setMoney(java.lang.Integer money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  合计收益数
	 */

	@Column(name ="TOTAL",nullable=false,length=10)
	public java.lang.Integer getTotal(){
		return this.total;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  合计收益数
	 */
	public void setTotal(java.lang.Integer total){
		this.total = total;
	}
}