<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hPoorTuopinList" checkbox="true" pagination="true"
              fitColumns="false" title="" actionUrl="hPoorTuopinController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政县"  field="dist"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="乡镇"  field="town"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="village"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="户编号"  field="householdNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人编号"  field="humanNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="idno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人数"  field="population"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="与户主关系"  field="relationship"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="nation"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文化程度"  field="education"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="在校生状况"  field="school"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="健康状况"  field="health"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="劳动技能"  field="labor"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="务工状况"  field="work"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="务工时间"  field="workTime"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="参加大病医疗"  field="seriousIllness"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="脱贫属性"  field="poverty"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="脱贫年度"  field="povertyYear"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="贫困户属性"  field="poor"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="致贫原因"  field="reson"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="危房户"  field="house"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否解决安全饮用水"  field="water"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人均纯收入"  field="income"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="mobile"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hPoorTuopinController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hPoorTuopinController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hPoorTuopinController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hPoorTuopinController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hPoorTuopinController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'hPoorTuopinController.do?upload', "hPoorTuopinList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hPoorTuopinController.do?exportXls","hPoorTuopinList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hPoorTuopinController.do?exportXlsByT","hPoorTuopinList");
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
