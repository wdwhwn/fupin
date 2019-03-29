<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
    <t:tabs id="tabsFive" iframe="true" heigth="800px" tabPosition="top" fit="false">
    <t:tab href="hPoorIncomeController.do?comprehensive0&id=${requestScope.id}" icon="icon-search" title="综合" id="tab6"></t:tab>
    <t:tab href="hPoorIncomeController.do?comprehensive1&id=${requestScope.id}" icon="icon-search" title="转移性收入" id="tab7"></t:tab>
    <t:tab href="hPoorIncomeController.do?comprehensive2&id=${requestScope.id}" icon="icon-search" title="其他转移性收入合计" id="tab8"></t:tab>
    <t:tab href="hPoorIncomeController.do?comprehensive3&id=${requestScope.id}" icon="icon-search" title="工资性收入" id="tab1"></t:tab>
    <t:tab href="hPoorIncomeController.do?comprehensive4&id=${requestScope.id}" icon="icon-search" title="财产性收入" id="tab2"></t:tab>
    <t:tab href="hPoorIncomeController.do?comprehensive5&id=${requestScope.id}" icon="icon-search" title="生产经营性收入" id="tab3"></t:tab>
    <t:tab href="hPoorIncomeController.do?comprehensive6&id=${requestScope.id}" icon="icon-search" title="生产经营性支出" id="tab4"></t:tab>
    </t:tabs>
</div>