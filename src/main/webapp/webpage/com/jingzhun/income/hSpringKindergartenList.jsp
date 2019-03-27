<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hSpringKindergartenList" pageSize="15" checkbox="true" pagination="true" fitColumns="false" title="" actionUrl="hSpringKindergartenController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  query="true"  queryMode="single"  dictionary="csex"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所在学校班级"  field="school"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发放月份"  field="month"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发放金额"  field="money"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="address"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户主"  field="huzhu"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户行"  field="idcard"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户行用户名"  field="idcardName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户行账号"  field="idcardNum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hSpringKindergartenController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hSpringKindergartenController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hSpringKindergartenController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hSpringKindergartenController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hSpringKindergartenController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hSpringKindergartenController.do?upload', "hSpringKindergartenList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hSpringKindergartenController.do?exportXls","hSpringKindergartenList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hSpringKindergartenController.do?exportXlsByT","hSpringKindergartenList");
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
