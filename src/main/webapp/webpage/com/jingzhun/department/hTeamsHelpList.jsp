<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hTeamsHelpList" checkbox="true" pagination="true" fitColumns="false" title="" actionUrl="hTeamsHelpController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="区县"  field="district"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="town"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户主姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="帮扶责任人"  field="personLiable"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="帮扶人手机号"  field="mobileHelp"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="contact"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hTeamsHelpController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hTeamsHelpController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hTeamsHelpController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hTeamsHelpController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hTeamsHelpController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hTeamsHelpController.do?upload', "hTeamsHelpList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hTeamsHelpController.do?exportXls","hTeamsHelpList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hTeamsHelpController.do?exportXlsByT","hTeamsHelpList");
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
