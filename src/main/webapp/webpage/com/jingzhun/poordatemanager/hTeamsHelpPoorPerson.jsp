<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hTeamsHelpList" pageSize="1"  pagination="false" fitColumns="true" title="" actionUrl="poorHouseholdController.do?datagridHelpTerms&&id=${requestScope.id}" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="区县"  field="district"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="town"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户主姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="帮扶责任人"  field="personLiable"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="帮扶人手机号"  field="mobileHelp"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="contact"  queryMode="group"  width="120"></t:dgCol>

  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 


</script>
