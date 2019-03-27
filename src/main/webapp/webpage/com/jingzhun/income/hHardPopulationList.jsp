<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hHardPopulationList" pageSize="15" checkbox="true" pagination="true" fitColumns="false" title="" actionUrl="hHardPopulationController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="town"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="带动脱贫人口姓名"  field="leadName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="家庭人口"  field="population"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="账户名"  field="account"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="一卡通账号"  field="code"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户行"  field="bank"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="reamrk"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发放金额"  field="money"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hHardPopulationController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hHardPopulationController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hHardPopulationController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hHardPopulationController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hHardPopulationController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hHardPopulationController.do?upload', "hHardPopulationList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hHardPopulationController.do?exportXls","hHardPopulationList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hHardPopulationController.do?exportXlsByT","hHardPopulationList");
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
