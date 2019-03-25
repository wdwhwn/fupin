package com.jingzhun.poorstar.entity;

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
 * @Description: 贫困星级预警
 * @author onlineGenerator
 * @date 2019-03-23 15:31:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_poor_star", schema = "")
@SuppressWarnings("serial")
public class HPoorStarEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**乡镇*/
	@Excel(name="乡镇",width=15)
	private java.lang.String town;
	/**行政村*/
	@Excel(name="行政村",width=15)
	private java.lang.String village;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String name;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String idno;
	/**残疾类别*/
	private java.lang.String deformityType;
	/**残疾等级*/
	@Excel(name="残疾等级",width=15)
	private java.lang.String deformityLevel;
	/**低保等级*/
	@Excel(name="低保等级",width=15)
	private java.lang.String dibaoLevel;
	/**特困供养方式*/
	@Excel(name="特困供养方式",width=15)
	private java.lang.String gongyangType;
	/**孤儿*/
	@Excel(name="孤儿",width=15)
	private java.lang.String orphan;
	/**困境儿童*/
	@Excel(name="困境儿童",width=15)
	private java.lang.String children;
	/**脱贫不享受政策*/
	@Excel(name="脱贫不享受政策",width=15)
	private java.lang.String tuopin;
	/**大病*/
	@Excel(name="大病",width=15)
	private java.math.BigDecimal illness;
	/**星级*/
	@Excel(name="星级",width=15)
	private java.lang.Integer starLevel;
	/**是否享受脱贫政策贫困户*/
	private java.lang.String isPoor;
	
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

	@Column(name ="TOWN",nullable=false,length=100)
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

	@Column(name ="VILLAGE",nullable=false,length=100)
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
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="NAME",nullable=false,length=100)
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

	@Column(name ="IDNO",nullable=false,length=100)
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
	 *@return: java.lang.String  残疾类别
	 */

	@Column(name ="DEFORMITY_TYPE",nullable=false,length=100)
	public java.lang.String getDeformityType(){
		return this.deformityType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾类别
	 */
	public void setDeformityType(java.lang.String deformityType){
		this.deformityType = deformityType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾等级
	 */

	@Column(name ="DEFORMITY_LEVEL",nullable=false,length=100)
	public java.lang.String getDeformityLevel(){
		return this.deformityLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾等级
	 */
	public void setDeformityLevel(java.lang.String deformityLevel){
		this.deformityLevel = deformityLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  低保等级
	 */

	@Column(name ="DIBAO_LEVEL",nullable=false,length=100)
	public java.lang.String getDibaoLevel(){
		return this.dibaoLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  低保等级
	 */
	public void setDibaoLevel(java.lang.String dibaoLevel){
		this.dibaoLevel = dibaoLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特困供养方式
	 */

	@Column(name ="GONGYANG_TYPE",nullable=false,length=100)
	public java.lang.String getGongyangType(){
		return this.gongyangType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特困供养方式
	 */
	public void setGongyangType(java.lang.String gongyangType){
		this.gongyangType = gongyangType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  孤儿
	 */

	@Column(name ="ORPHAN",nullable=false,length=100)
	public java.lang.String getOrphan(){
		return this.orphan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  孤儿
	 */
	public void setOrphan(java.lang.String orphan){
		this.orphan = orphan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  困境儿童
	 */

	@Column(name ="CHILDREN",nullable=false,length=100)
	public java.lang.String getChildren(){
		return this.children;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  困境儿童
	 */
	public void setChildren(java.lang.String children){
		this.children = children;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  脱贫不享受政策
	 */

	@Column(name ="TUOPIN",nullable=false,length=100)
	public java.lang.String getTuopin(){
		return this.tuopin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脱贫不享受政策
	 */
	public void setTuopin(java.lang.String tuopin){
		this.tuopin = tuopin;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  大病
	 */

	@Column(name ="ILLNESS",nullable=false,scale=2,length=10)
	public java.math.BigDecimal getIllness(){
		return this.illness;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  大病
	 */
	public void setIllness(java.math.BigDecimal illness){
		this.illness = illness;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  星级
	 */

	@Column(name ="STAR_LEVEL",nullable=false,length=3)
	public java.lang.Integer getStarLevel(){
		return this.starLevel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  星级
	 */
	public void setStarLevel(java.lang.Integer starLevel){
		this.starLevel = starLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否享受脱贫政策贫困户
	 */

	@Column(name ="IS_POOR",nullable=false,length=10)
	public java.lang.String getIsPoor(){
		return this.isPoor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否享受脱贫政策贫困户
	 */
	public void setIsPoor(java.lang.String isPoor){
		this.isPoor = isPoor;
	}
}