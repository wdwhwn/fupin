<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hVocationalSchoolList" checkbox="true" pagination="true" fitColumns="true" title="中职教育补助金" actionUrl="hVocationalSchoolController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  query="true"  queryMode="single"  dictionary="csex"  width="120"></t:dgCol>
   <t:dgCol title="身份证号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所在学校班级"  field="school"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否为寄宿生"  field="isLodging"  query="true"  queryMode="single"  dictionary="是否寄宿"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="address"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户主姓名"  field="householderName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户行"  field="bank"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="账户名"  field="bankAccount"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="账户号码"  field="bankNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hVocationalSchoolController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hVocationalSchoolController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hVocationalSchoolController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hVocationalSchoolController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hVocationalSchoolController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hVocationalSchoolController.do?upload', "hVocationalSchoolList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hVocationalSchoolController.do?exportXls","hVocationalSchoolList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hVocationalSchoolController.do?exportXlsByT","hVocationalSchoolList");
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
