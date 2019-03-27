<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="hPoorTuopinController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${hPoorTuopin.id}"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					乡镇：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="town" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.town}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					行政村：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="village" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.village}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					户编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="householdNo" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.householdNo}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="humanNo" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.humanNo}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					姓名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="name" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.name}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					证件号码：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="idno" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.idno}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人数：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="population" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.population}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					与户主关系：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="relationship" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.relationship}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					民族：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="nation" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.nation}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					文化程度：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="education" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.education}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					在校生状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="school" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.school}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					健康状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="health" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.health}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					劳动技能：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="labor" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.labor}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					务工状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="work" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.work}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					务工时间：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="workTime" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.workTime}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					参加大病医疗：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="seriousIllness" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.seriousIllness}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					脱贫属性：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="poverty" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.poverty}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					脱贫年度：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="povertyYear" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.povertyYear}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					贫困户属性：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="poor" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.poor}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					致贫原因：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="reson" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.reson}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					危房户：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="house" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.house}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					是否解决安全饮用水：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="water" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.water}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人均纯收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="income" type="text" class="form-control" maxlength="10" value = "${hPoorTuopin.income}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					联系电话：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="mobile" type="text" class="form-control" maxlength="100" value = "${hPoorTuopin.mobile}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
});
</script>
</body>
</html>