<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hHardChildrenList" pageSize="15" checkbox="true" pagination="true" fitColumns="false" title="" actionUrl="hHardChildrenController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  dictionary="csex"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="birthday"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户籍地址"  field="address"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="homeAddress"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="序号"  field="sort"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="儿童福利证编号"  field="code"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户口类型"  field="type"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="生活状态"  field="state"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="监护人"  field="guardian"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hHardChildrenController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hHardChildrenController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hHardChildrenController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hHardChildrenController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hHardChildrenController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hHardChildrenController.do?upload', "hHardChildrenList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hHardChildrenController.do?exportXls","hHardChildrenList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hHardChildrenController.do?exportXlsByT","hHardChildrenList");
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
