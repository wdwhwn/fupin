package com.jingzhun.poordatemanager.entity;

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
 * @Description: 贫困户表
 * @author onlineGenerator
 * @date 2019-03-25 19:32:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "h_poor_household", schema = "")
@SuppressWarnings("serial")
public class HPoorHouseholdEntity implements java.io.Serializable {
	/**主键自增*/
	private java.lang.Integer id;
	/**行政县*/
	private java.lang.String a1;
	/**乡镇*/
	private java.lang.String a2;
	/**行政村*/
	@Excel(name="行政村",width=15)
	private java.lang.String a3;
	/**自然村*/
	private java.lang.String a4;
	/**户编号*/
	@Excel(name="户编号",width=15)
	private java.lang.String a5;
	/**人编号*/
	private java.lang.String a6;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String a7;
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String a8;
	/**人数*/
	@Excel(name="人数",width=15)
	private java.lang.String a9;
	/**与户主关系*/
	@Excel(name="与户主关系",width=15,dicCode="与户主关系")
	private java.lang.String a10;
	/**民族*/
	private java.lang.String a11;
	/**文化程度*/
	private java.lang.String a12;
	/**在校生状况*/
	private java.lang.String a13;
	/**健康状况*/
	private java.lang.String a14;
	/**劳动技能*/
	private java.lang.String a15;
	/**务工状况*/
	private java.lang.String a16;
	/**务工时间*/
	private java.lang.String a17;
	/**参加大病医疗*/
	private java.lang.String a18;
	/**脱贫属性*/
	@Excel(name="脱贫属性",width=15)
	private java.lang.String a19;
	/**脱贫年度*/
	private java.lang.String a20;
	/**贫困户属性*/
	@Excel(name="贫困户属性",width=15)
	private java.lang.String a21;
	/**主要致贫原因*/
	@Excel(name="主要致贫原因",width=15)
	private java.lang.String a22;
	/**危房户*/
	private java.lang.String a23;
	/**饮水安全*/
	private java.lang.String a24;
	/**饮水困难*/
	private java.lang.String a25;
	/**人均纯收入*/
	private java.lang.String a26;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String a27;
	/**长号码*/
	private java.lang.String a28;
	/**短号码*/
	private java.lang.String a29;
	/**用户照片*/
	@Excel(name="用户照片",width=15)
	private java.lang.String a30;
	/**帮扶责任人手机号*/
	private java.lang.String helperMobile;
	/**定位*/
	private java.lang.String location;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键自增
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name ="ID",nullable=false,length=10)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键自增
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行政县
	 */

	@Column(name ="A1",nullable=false,length=100)
	public java.lang.String getA1(){
		return this.a1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行政县
	 */
	public void setA1(java.lang.String a1){
		this.a1 = a1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  乡镇
	 */

	@Column(name ="A2",nullable=false,length=100)
	public java.lang.String getA2(){
		return this.a2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  乡镇
	 */
	public void setA2(java.lang.String a2){
		this.a2 = a2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行政村
	 */

	@Column(name ="A3",nullable=false,length=100)
	public java.lang.String getA3(){
		return this.a3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行政村
	 */
	public void setA3(java.lang.String a3){
		this.a3 = a3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自然村
	 */

	@Column(name ="A4",nullable=true,length=100)
	public java.lang.String getA4(){
		return this.a4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自然村
	 */
	public void setA4(java.lang.String a4){
		this.a4 = a4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户编号
	 */

	@Column(name ="A5",nullable=true,length=100)
	public java.lang.String getA5(){
		return this.a5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户编号
	 */
	public void setA5(java.lang.String a5){
		this.a5 = a5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人编号
	 */

	@Column(name ="A6",nullable=true,length=100)
	public java.lang.String getA6(){
		return this.a6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人编号
	 */
	public void setA6(java.lang.String a6){
		this.a6 = a6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="A7",nullable=true,length=100)
	public java.lang.String getA7(){
		return this.a7;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setA7(java.lang.String a7){
		this.a7 = a7;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码
	 */

	@Column(name ="A8",nullable=true,length=100)
	public java.lang.String getA8(){
		return this.a8;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setA8(java.lang.String a8){
		this.a8 = a8;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人数
	 */

	@Column(name ="A9",nullable=true,length=100)
	public java.lang.String getA9(){
		return this.a9;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人数
	 */
	public void setA9(java.lang.String a9){
		this.a9 = a9;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  与户主关系
	 */

	@Column(name ="A10",nullable=true,length=100)
	public java.lang.String getA10(){
		return this.a10;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  与户主关系
	 */
	public void setA10(java.lang.String a10){
		this.a10 = a10;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */

	@Column(name ="A11",nullable=true,length=100)
	public java.lang.String getA11(){
		return this.a11;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setA11(java.lang.String a11){
		this.a11 = a11;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文化程度
	 */

	@Column(name ="A12",nullable=true,length=100)
	public java.lang.String getA12(){
		return this.a12;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化程度
	 */
	public void setA12(java.lang.String a12){
		this.a12 = a12;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在校生状况
	 */

	@Column(name ="A13",nullable=true,length=100)
	public java.lang.String getA13(){
		return this.a13;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在校生状况
	 */
	public void setA13(java.lang.String a13){
		this.a13 = a13;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  健康状况
	 */

	@Column(name ="A14",nullable=true,length=100)
	public java.lang.String getA14(){
		return this.a14;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  健康状况
	 */
	public void setA14(java.lang.String a14){
		this.a14 = a14;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  劳动技能
	 */

	@Column(name ="A15",nullable=true,length=100)
	public java.lang.String getA15(){
		return this.a15;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  劳动技能
	 */
	public void setA15(java.lang.String a15){
		this.a15 = a15;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  务工状况
	 */

	@Column(name ="A16",nullable=true,length=100)
	public java.lang.String getA16(){
		return this.a16;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  务工状况
	 */
	public void setA16(java.lang.String a16){
		this.a16 = a16;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  务工时间
	 */

	@Column(name ="A17",nullable=true,length=100)
	public java.lang.String getA17(){
		return this.a17;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  务工时间
	 */
	public void setA17(java.lang.String a17){
		this.a17 = a17;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加大病医疗
	 */

	@Column(name ="A18",nullable=true,length=100)
	public java.lang.String getA18(){
		return this.a18;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加大病医疗
	 */
	public void setA18(java.lang.String a18){
		this.a18 = a18;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  脱贫属性
	 */

	@Column(name ="A19",nullable=true,length=100)
	public java.lang.String getA19(){
		return this.a19;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脱贫属性
	 */
	public void setA19(java.lang.String a19){
		this.a19 = a19;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  脱贫年度
	 */

	@Column(name ="A20",nullable=true,length=100)
	public java.lang.String getA20(){
		return this.a20;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脱贫年度
	 */
	public void setA20(java.lang.String a20){
		this.a20 = a20;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贫困户属性
	 */

	@Column(name ="A21",nullable=true,length=100)
	public java.lang.String getA21(){
		return this.a21;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贫困户属性
	 */
	public void setA21(java.lang.String a21){
		this.a21 = a21;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主要致贫原因
	 */

	@Column(name ="A22",nullable=true,length=100)
	public java.lang.String getA22(){
		return this.a22;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主要致贫原因
	 */
	public void setA22(java.lang.String a22){
		this.a22 = a22;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  危房户
	 */

	@Column(name ="A23",nullable=true,length=100)
	public java.lang.String getA23(){
		return this.a23;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  危房户
	 */
	public void setA23(java.lang.String a23){
		this.a23 = a23;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  饮水安全
	 */

	@Column(name ="A24",nullable=true,length=100)
	public java.lang.String getA24(){
		return this.a24;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  饮水安全
	 */
	public void setA24(java.lang.String a24){
		this.a24 = a24;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  饮水困难
	 */

	@Column(name ="A25",nullable=true,length=100)
	public java.lang.String getA25(){
		return this.a25;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  饮水困难
	 */
	public void setA25(java.lang.String a25){
		this.a25 = a25;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人均纯收入
	 */

	@Column(name ="A26",nullable=true,length=100)
	public java.lang.String getA26(){
		return this.a26;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人均纯收入
	 */
	public void setA26(java.lang.String a26){
		this.a26 = a26;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="A27",nullable=true,length=100)
	public java.lang.String getA27(){
		return this.a27;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setA27(java.lang.String a27){
		this.a27 = a27;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  长号码
	 */

	@Column(name ="A28",nullable=true,length=100)
	public java.lang.String getA28(){
		return this.a28;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长号码
	 */
	public void setA28(java.lang.String a28){
		this.a28 = a28;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  短号码
	 */

	@Column(name ="A29",nullable=true,length=100)
	public java.lang.String getA29(){
		return this.a29;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  短号码
	 */
	public void setA29(java.lang.String a29){
		this.a29 = a29;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户照片
	 */

	@Column(name ="A30",nullable=true,length=255)
	public java.lang.String getA30(){
		return this.a30;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户照片
	 */
	public void setA30(java.lang.String a30){
		this.a30 = a30;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  帮扶责任人手机号
	 */

	@Column(name ="HELPER_MOBILE",nullable=false,length=30)
	public java.lang.String getHelperMobile(){
		return this.helperMobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  帮扶责任人手机号
	 */
	public void setHelperMobile(java.lang.String helperMobile){
		this.helperMobile = helperMobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  定位
	 */

	@Column(name ="LOCATION",nullable=false,length=100)
	public java.lang.String getLocation(){
		return this.location;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  定位
	 */
	public void setLocation(java.lang.String location){
		this.location = location;
	}
}