<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hHardOrphanList" checkbox="true" pagination="true"
              fitColumns="false" title="" actionUrl="hHardOrphanController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idno"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  query="true"  queryMode="single"  dictionary="csex"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="birthday"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="序号"  field="sort"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="address"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hHardOrphanController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hHardOrphanController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hHardOrphanController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hHardOrphanController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hHardOrphanController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hHardOrphanController.do?upload', "hHardOrphanList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hHardOrphanController.do?exportXls","hHardOrphanList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hHardOrphanController.do?exportXlsByT","hHardOrphanList");
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
