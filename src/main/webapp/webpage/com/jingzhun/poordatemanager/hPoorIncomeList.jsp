<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hPoorIncomeList"  pagination="false" fitColumns="true" title="财产收入" actionUrl="hPoorIncomeController.do?datagrid&id={requestScope.id}" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政县"  field="dist"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="town"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户编号"  field="householdNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人编号"  field="humanNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idno"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭人口数"  field="population"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="与户主关系"  field="relationship"  queryMode="group"  dictionary="与户主关系"  width="120"></t:dgCol>
   <t:dgCol title="奖扶金"  field="jiangfu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="特扶金"  field="tefu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="春节慰问金"  field="weiwen"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="低保金"  field="dibao"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="特困供养金"  field="gongyang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="养老保险金"  field="baoxian"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="生态补偿金"  field="buchang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="低保高龄补贴"  field="gaoling"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="低保电量补贴"  field="dianliang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="不能自理老人护理补贴"  field="huli"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="城镇三无人员生活费"  field="sanwu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="困难残疾人生活补贴"  field="canji"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="重度残疾人护理补贴"  field="zhongdu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="孤儿生活费"  field="guer"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="困境儿童生活费"  field="ertong"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="伤残军人"  field="junren"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="病故军人的家属"  field="sanshu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="在乡复员军人"  field="fuyuan"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="带病回乡退伍军人"  field="tuiwu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="参加核试验"  field="shiyan"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="参战"  field="canzhan"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="60岁以上农村籍退役士兵"  field="tuiyi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="部分烈士子女"  field="lieshi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="朝阳助学"  field="zhuxue"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="老年乡村医生生活补贴"  field="yisheng"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="高龄补贴"  field="gaolingbutie"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业遗属补助"  field="yishu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职工养老保险金"  field="zhigong"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原民办代课教师教龄补助"  field="jiaoshi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="农支地保"  field="nongzhi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="棉花补贴"  field="mianhua"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="居家托养"  field="tuoyang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="残疾学生"  field="xuesheng"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="残疾子女"  field="zinv"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="教育资助金"  field="jiaoyu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="老民师待遇金"  field="minshi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="老放影员生活补助"  field="fangyingyuan"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="雨露计划"  field="yulu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产业扶贫项目受益"  field="chanye"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="生产贷"  field="shengchandai"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="村集体发放款"  field="fafang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="慈善帮扶项目"  field="bangfu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="特困基金项目"  field="jijin"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="慈善"  field="cishan"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="村集体入股分红"  field="fenhong"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="京博90岁以上老年人救助金"  field="laonianren"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="占地补偿"  field="zhandi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡村干部退休金"  field="ganbu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="赡养费"  field="shanyang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="其他"  field="qita"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="其他转移性收入合计"  field="zhuanyi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="转移性收入合计"  field="zhuanyiheji"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工资性收入"  field="gongzi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="生产经营性收入"  field="shengchanjingying"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="资产收益扶贫分红收入"  field="zichanshouyi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="其他财产性收入"  field="caichanshouru"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭总收入"  field="jiating"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="生产经营性支出"  field="jingying"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人均纯收入"  field="renjun"  queryMode="group"  width="120"></t:dgCol>
  </t:datagrid>
  </div>
 </div>


</script>
