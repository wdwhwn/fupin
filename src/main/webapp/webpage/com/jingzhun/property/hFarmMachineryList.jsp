<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hFarmMachineryList" checkbox="true" pagination="true" fitColumns="true" title="大型农机局信息" actionUrl="hFarmMachineryController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="地址 姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="车型"  field="carType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="注册登记日期"  field="registrationDate"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年检到期日"  field="expirationDate"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hFarmMachineryController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hFarmMachineryController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hFarmMachineryController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hFarmMachineryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hFarmMachineryController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hFarmMachineryController.do?upload', "hFarmMachineryList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hFarmMachineryController.do?exportXls","hFarmMachineryList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hFarmMachineryController.do?exportXlsByT","hFarmMachineryList");
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
