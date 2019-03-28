<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="poorHouseholdList" checkbox="true" pagination="true" fitColumns="true" title="贫困户表" actionUrl="poorHouseholdController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键自增"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政县"  field="a1"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="a2"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="a3"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="自然村"  field="a4"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户编号"  field="a5"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人编号"  field="a6"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="a7"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="a8"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人数"  field="a9"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="与户主关系"  field="a10"  queryMode="single"  dictionary="与户主关系"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="a11"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文化程度"  field="a12"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="在校生状况"  field="a13"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="健康状况"  field="a14"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="劳动技能"  field="a15"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="务工状况"  field="a16"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="务工时间"  field="a17"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="参加大病医疗"  field="a18"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="脱贫属性"  field="a19"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="脱贫年度"  field="a20"  queryMode="group"  dictionary="贫困户属性"  width="120"></t:dgCol>
   <t:dgCol title="贫困户属性"  field="a21"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主要致贫原因"  field="a22"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="危房户"  field="a23"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="饮水安全"  field="a24"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="饮水困难"  field="a25"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人均纯收入"  field="a26"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="a27"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="长号码"  field="a28"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="短号码"  field="a29"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户照片"  field="a30"  queryMode="group"  image="true" imageSize="50,50" formatterjs="btListImgFormatter" width="120"></t:dgCol>
   <t:dgCol title="帮扶责任人手机号"  field="helperMobile"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="定位"  field="location"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="poorHouseholdController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="poorHouseholdController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="poorHouseholdController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="poorHouseholdController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="poorHouseholdController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'poorHouseholdController.do?upload', "poorHouseholdList");
}

//导出
function ExportXls() {
	JeecgExcelExport("poorHouseholdController.do?exportXls","poorHouseholdList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("poorHouseholdController.do?exportXlsByT","poorHouseholdList");
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
