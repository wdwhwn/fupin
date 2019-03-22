<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hHardInsuranceList" checkbox="true" pagination="true"
              fitColumns="false" title="" actionUrl="hHardInsuranceController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  query="true"  queryMode="single"  dictionary="csex"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="nation"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="marriage"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭关系"  field="relation"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户主姓名"  field="householder"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户主证件"  field="householderid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="地区"  field="district"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="homeAddress"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="特困编号"  field="code"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="birthday"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否残疾"  field="isDisabled"  query="true"  queryMode="single"  dictionary="disability"  width="120"></t:dgCol>
   <t:dgCol title="残疾证号"  field="disabledid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="残疾类别"  field="disabledtype"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="残疾等级"  field="disabledlevel"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="详细地址"  field="address"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="供养方式"  field="mode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hHardInsuranceController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hHardInsuranceController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hHardInsuranceController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hHardInsuranceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hHardInsuranceController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hHardInsuranceController.do?upload', "hHardInsuranceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hHardInsuranceController.do?exportXls","hHardInsuranceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hHardInsuranceController.do?exportXlsByT","hHardInsuranceList");
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
