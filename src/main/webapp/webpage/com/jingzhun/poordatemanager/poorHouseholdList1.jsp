<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
   <t:datagrid name="poorHouseholdList1" pageSize="15"  pagination="false" fitColumns="true" title="" actionUrl="poorHouseholdController.do?datagridSelectOne&id=${requestScope.id}" idField="id1" sortName="id1" fit="false" queryMode="group">
    <t:dgCol title="主键自增"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <%--<t:dgCol title="行政县"  field="a1"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="乡镇"  field="a2"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="行政村"  field="a3"    queryMode="single"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="自然村"  field="a4"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="户编号"  field="a5"    queryMode="single"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="人编号"  field="a6"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="姓名"  field="a7"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="证件号码"  field="a8"    queryMode="single"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="人数"  field="a9"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="与户主关系"  field="a10"  queryMode="single"  dictionary="与户主关系"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="民族"  field="a11"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="文化程度"  field="a12"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="在校生状况"  field="a13"  queryMode="group"  width="120"></t:dgCol>--%>
    <%--<t:dgCol title="健康状况"  field="a14"  queryMode="group"  width="120"></t:dgCol>--%>
    <t:dgCol title="劳动技能"  field="a15"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="务工状况"  field="a16"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="务工时间"  field="a17"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="参加大病医疗"  field="a18"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="脱贫属性"  field="a19"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="脱贫年度"  field="a20"  queryMode="group"  dictionary="贫困户属性"  width="120"></t:dgCol>
    <t:dgCol title="贫困户属性"  field="a21"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="主要致贫原因"  field="a22"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="危房户"  field="a23"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="饮水安全"  field="a24"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="饮水困难"  field="a25"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="人均纯收入"  field="a26"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="联系电话"  field="a27"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="长号码"  field="a28"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="短号码"  field="a29"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="用户照片"  field="a30"  queryMode="group"  image="true" imageSize="50,50" formatterjs="btListImgFormatter" width="120"></t:dgCol>
    <t:dgCol title="帮扶责任人手机号"  field="helperMobile"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="定位"  field="location"  queryMode="group"  width="120"></t:dgCol>
    <%--<t:dgOpenOpt url="poorHouseholdController.do?list1&id={id}" title="弹出窗"></t:dgOpenOpt>--%>
   </t:datagrid>
  <t:datagrid name="poorHouseholdList"  pageSize="1"  pagination="false" fitColumns="true" title="" actionUrl="poorHouseholdController.do?datagridSelectOne&id=${requestScope.id}" idField="id" sortName="id" fit="false" queryMode="group">
   <t:dgCol title="主键自增"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政县"  field="a1"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="a2"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="a3"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="自然村"  field="a4"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户编号"  field="a5"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人编号"  field="a6"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="a7"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="a8"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人数"  field="a9"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="与户主关系"  field="a10"  queryMode="single"  dictionary="与户主关系"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="a11"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文化程度"  field="a12"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="在校生状况"  field="a13"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="健康状况"  field="a14"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="劳动技能"  field="a15"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="务工状况"  field="a16"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="务工时间"  field="a17"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="参加大病医疗"  field="a18"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="脱贫属性"  field="a19"    queryMode="single"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="脱贫年度"  field="a20"  queryMode="group"  dictionary="贫困户属性"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="贫困户属性"  field="a21"    queryMode="single"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="主要致贫原因"  field="a22"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="危房户"  field="a23"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="饮水安全"  field="a24"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="饮水困难"  field="a25"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="人均纯收入"  field="a26"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="联系电话"  field="a27"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="长号码"  field="a28"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="短号码"  field="a29"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="用户照片"  field="a30"  queryMode="group"  image="true" imageSize="50,50" formatterjs="btListImgFormatter" width="120"></t:dgCol>--%>
   <%--<t:dgCol title="帮扶责任人手机号"  field="helperMobile"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="定位"  field="location"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgOpenOpt url="poorHouseholdController.do?list1&id={id}" title="弹出窗"></t:dgOpenOpt>--%>
  </t:datagrid>

  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });

</script>
<script>


</script>
