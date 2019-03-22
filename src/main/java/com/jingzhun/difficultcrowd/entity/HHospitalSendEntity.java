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
 * @Description: 居民医保报销数据总
 * @author onlineGenerator
 * @date 2019-03-22 09:47:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_hospital_send", schema = "")
@SuppressWarnings("serial")
public class HHospitalSendEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**街道*/
	@Excel(name="街道",width=15)
	private java.lang.String jiedao;
	/**村庄*/
	@Excel(name="村庄",width=15)
	private java.lang.String cunzhuang;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String idno;
	/**入院日期*/
	@Excel(name="入院日期",width=15)
	private java.lang.String intime;
	/**出院日期*/
	@Excel(name="出院日期",width=15)
	private java.lang.String outtime;
	/**出院诊断疾病名称*/
	@Excel(name="出院诊断疾病名称",width=15)
	private java.lang.String disease;
	/**医疗机构名称*/
	@Excel(name="医疗机构名称",width=15)
	private java.lang.String hosName;
	/**医疗总费用*/
	@Excel(name="医疗总费用",width=15)
	private java.lang.String hosFee;
	/**基本补偿*/
	@Excel(name="基本补偿",width=15)
	private java.lang.String compensation;
	/**大病报销金额*/
	@Excel(name="大病报销金额",width=15)
	private java.lang.String trueFee;
	/**自付金额*/
	@Excel(name="自付金额",width=15)
	private java.lang.String selfFee;
	
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
	 *@return: java.lang.String  街道
	 */

	@Column(name ="JIEDAO",nullable=true,length=255)
	public java.lang.String getJiedao(){
		return this.jiedao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  街道
	 */
	public void setJiedao(java.lang.String jiedao){
		this.jiedao = jiedao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  村庄
	 */

	@Column(name ="CUNZHUANG",nullable=true,length=30)
	public java.lang.String getCunzhuang(){
		return this.cunzhuang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  村庄
	 */
	public void setCunzhuang(java.lang.String cunzhuang){
		this.cunzhuang = cunzhuang;
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
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="IDNO",nullable=true,length=50)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入院日期
	 */

	@Column(name ="INTIME",nullable=true,length=64)
	public java.lang.String getIntime(){
		return this.intime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入院日期
	 */
	public void setIntime(java.lang.String intime){
		this.intime = intime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出院日期
	 */

	@Column(name ="OUTTIME",nullable=true,length=64)
	public java.lang.String getOuttime(){
		return this.outtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出院日期
	 */
	public void setOuttime(java.lang.String outtime){
		this.outtime = outtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出院诊断疾病名称
	 */

	@Column(name ="DISEASE",nullable=false,length=255)
	public java.lang.String getDisease(){
		return this.disease;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出院诊断疾病名称
	 */
	public void setDisease(java.lang.String disease){
		this.disease = disease;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医疗机构名称
	 */

	@Column(name ="HOS_NAME",nullable=true,length=255)
	public java.lang.String getHosName(){
		return this.hosName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医疗机构名称
	 */
	public void setHosName(java.lang.String hosName){
		this.hosName = hosName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医疗总费用
	 */

	@Column(name ="HOS_FEE",nullable=true,length=255)
	public java.lang.String getHosFee(){
		return this.hosFee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医疗总费用
	 */
	public void setHosFee(java.lang.String hosFee){
		this.hosFee = hosFee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本补偿
	 */

	@Column(name ="COMPENSATION",nullable=true,length=255)
	public java.lang.String getCompensation(){
		return this.compensation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本补偿
	 */
	public void setCompensation(java.lang.String compensation){
		this.compensation = compensation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大病报销金额
	 */

	@Column(name ="TRUE_FEE",nullable=true,length=255)
	public java.lang.String getTrueFee(){
		return this.trueFee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大病报销金额
	 */
	public void setTrueFee(java.lang.String trueFee){
		this.trueFee = trueFee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自付金额
	 */

	@Column(name ="SELF_FEE",nullable=true,length=255)
	public java.lang.String getSelfFee(){
		return this.selfFee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自付金额
	 */
	public void setSelfFee(java.lang.String selfFee){
		this.selfFee = selfFee;
	}
}