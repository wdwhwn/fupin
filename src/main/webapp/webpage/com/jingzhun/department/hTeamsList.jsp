<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hTeamsList" checkbox="true" pagination="true" fitColumns="true" title="爱心助困党员先锋队" actionUrl="hTeamsController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="序号"  field="sort"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="区县"  field="district"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="town"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户主姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭成员姓名"  field="familyName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  query="true"  queryMode="single"  dictionary="csex"  width="120"></t:dgCol>
   <t:dgCol title="与户主关系"  field="relationship"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭成员数"  field="familyNumber"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="帮扶责任人"  field="personLiable"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="帮扶人手机号"  field="mobileHelp"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="派出单位"  field="unit"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="contact"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="爱心助困帮扶党员"  field="partyMember"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="村内职务"  field="job"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="mobile"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hTeamsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hTeamsController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hTeamsController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hTeamsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hTeamsController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'hTeamsController.do?upload', "hTeamsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hTeamsController.do?exportXls","hTeamsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hTeamsController.do?exportXlsByT","hTeamsList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

</script>
