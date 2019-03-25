<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hPoorStarList" checkbox="true"  pageSize="15" pagination="true" fitColumns="true" title="贫困星级预警" actionUrl="hPoorStarController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="jiedao"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="cunzhung"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="贫困等级"  field="count"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预警状态"  field="result"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="残疾"  field="canji"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="低保"  field="dibao"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="特困供养方式"  field="tekun"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="孤儿"  field="guer"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="困境儿童"  field="kunjingertong"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="脱贫不享受政策"  field="tuopinbuxiangshou"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="大病"  field="selfFee"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hPoorStarController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hPoorStarController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hPoorStarController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hPoorStarController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hPoorStarController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hPoorStarController.do?upload', "hPoorStarList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hPoorStarController.do?exportXls","hPoorStarList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hPoorStarController.do?exportXlsByT","hPoorStarList");
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
