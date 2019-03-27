<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hHospitalSendList" pageSize="15" checkbox="true" pagination="true"
              fitColumns="false" title="" actionUrl="hHospitalSendController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="街道"  field="jiedao"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="村庄"  field="cunzhuang"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入院日期"  field="intime"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出院日期"  field="outtime"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出院诊断疾病名称"  field="disease"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="医疗机构名称"  field="hosName"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="医疗总费用"  field="hosFee"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基本补偿"  field="compensation"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="大病报销金额"  field="trueFee"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自付金额"  field="selfFee"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hHospitalSendController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hHospitalSendController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hHospitalSendController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hHospitalSendController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hHospitalSendController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hHospitalSendController.do?upload', "hHospitalSendList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hHospitalSendController.do?exportXls","hHospitalSendList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hHospitalSendController.do?exportXlsByT","hHospitalSendList");
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
