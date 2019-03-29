<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>财产收入</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="hPoorIncomeController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${hPoorIncome.id}"/>
		<div class="row">
		<%--<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					行政县：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="dist" type="text" class="form-control" maxlength="30" value = "${hPoorIncome.dist}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					乡镇：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="town" type="text" class="form-control" maxlength="30" value = "${hPoorIncome.town}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					行政村：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="village" type="text" class="form-control" maxlength="30" value = "${hPoorIncome.village}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					户编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="householdNo" type="text" class="form-control" maxlength="30" value = "${hPoorIncome.householdNo}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="humanNo" type="text" class="form-control" maxlength="30" value = "${hPoorIncome.humanNo}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					姓名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="name" type="text" class="form-control" maxlength="30" value = "${hPoorIncome.name}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					身份证号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="idno" type="text" class="form-control" maxlength="100" value = "${hPoorIncome.idno}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					家庭人口数：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="population" type="text" class="form-control" maxlength="5" value = "${hPoorIncome.population}"  datatype="n"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					与户主关系：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="relationship" defaultVal = "${hPoorIncome.relationship}" type="select" hasLabel="false" title="与户主关系" extendJson="{class:'form-control'}"  datatype="*"   typeGroupCode="与户主关系" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					奖扶金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="jiangfu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.jiangfu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					特扶金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="tefu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.tefu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					春节慰问金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="weiwen" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.weiwen}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					低保金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="dibao" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.dibao}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					特困供养金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="gongyang" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.gongyang}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					养老保险金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="baoxian" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.baoxian}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					生态补偿金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buchang" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.buchang}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					低保高龄补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="gaoling" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.gaoling}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					低保电量补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="dianliang" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.dianliang}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					不能自理老人护理补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huli" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.huli}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					城镇三无人员生活费：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="sanwu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.sanwu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					困难残疾人生活补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="canji" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.canji}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					重度残疾人护理补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zhongdu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zhongdu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					孤儿生活费：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="guer" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.guer}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					困境儿童生活费：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="ertong" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.ertong}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					伤残军人：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="junren" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.junren}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					病故军人的家属：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="sanshu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.sanshu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					在乡复员军人：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="fuyuan" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.fuyuan}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					带病回乡退伍军人：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="tuiwu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.tuiwu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					参加核试验：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shiyan" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.shiyan}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					参战：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="canzhan" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.canzhan}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					60岁以上农村籍退役士兵：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="tuiyi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.tuiyi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					部分烈士子女：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="lieshi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.lieshi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					朝阳助学：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zhuxue" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zhuxue}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					老年乡村医生生活补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="yisheng" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.yisheng}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					高龄补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="gaolingbutie" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.gaolingbutie}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					企业遗属补助：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="yishu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.yishu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					职工养老保险金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zhigong" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zhigong}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					原民办代课教师教龄补助：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="jiaoshi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.jiaoshi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					农支地保：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="nongzhi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.nongzhi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					棉花补贴：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="mianhua" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.mianhua}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					居家托养：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="tuoyang" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.tuoyang}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					残疾学生：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="xuesheng" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.xuesheng}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					残疾子女：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zinv" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zinv}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					教育资助金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="jiaoyu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.jiaoyu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					老民师待遇金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="minshi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.minshi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					老放影员生活补助：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="fangyingyuan" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.fangyingyuan}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					雨露计划：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="yulu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.yulu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					产业扶贫项目受益：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="chanye" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.chanye}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					生产贷：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shengchandai" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.shengchandai}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					村集体发放款：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="fafang" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.fafang}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					慈善帮扶项目：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="bangfu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.bangfu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					特困基金项目：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="jijin" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.jijin}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					慈善：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="cishan" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.cishan}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					村集体入股分红：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="fenhong" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.fenhong}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					京博90岁以上老年人救助金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="laonianren" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.laonianren}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					占地补偿：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zhandi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zhandi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					乡村干部退休金：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="ganbu" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.ganbu}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					赡养费：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shanyang" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.shanyang}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					其他：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="qita" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.qita}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					其他转移性收入合计：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zhuanyi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zhuanyi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					转移性收入合计：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zhuanyiheji" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zhuanyiheji}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					工资性收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="gongzi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.gongzi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					生产经营性收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shengchanjingying" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.shengchanjingying}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>--%>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					资产收益扶贫分红收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="zichanshouyi" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.zichanshouyi}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					其他财产性收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="caichanshouru" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.caichanshouru}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<%--<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					家庭总收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="jiating" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.jiating}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					生产经营性支出：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="jingying" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.jingying}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人均纯收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="renjun" type="text" class="form-control" maxlength="10" value = "${hPoorIncome.renjun}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>--%>
		</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
});
</script>
</body>
</html>