<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hProjectHelpPoorList" pageSize="15" checkbox="true" pagination="true" fitColumns="false" title="" actionUrl="hProjectHelpPoorController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="村名"  field="village"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户主"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="家庭人口数"  field="family"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="农机"  field="machine"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="食用菌"  field="fungi"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="果蔬发酵"  field="fermentation"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="整改"  field="rectification"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人口额度"  field="money"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合计收益数"  field="total"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hProjectHelpPoorController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hProjectHelpPoorController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hProjectHelpPoorController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hProjectHelpPoorController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hProjectHelpPoorController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hProjectHelpPoorController.do?upload', "hProjectHelpPoorList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hProjectHelpPoorController.do?exportXls","hProjectHelpPoorList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hProjectHelpPoorController.do?exportXlsByT","hProjectHelpPoorList");
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
