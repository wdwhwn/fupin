<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>特困供养人员信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="hHardInsuranceController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${hHardInsurance.id}"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					姓名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="name" type="text" class="form-control" maxlength="30" value = "${hHardInsurance.name}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					证件号码：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="idno" type="text" class="form-control" maxlength="50" value = "${hHardInsurance.idno}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					性别：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<div style="padding-top:5px">
	            	<t:dictSelect field="sex" defaultVal = "${hHardInsurance.sex}" extendJson="{class:'i-checks'}" type="radio" hasLabel="false"  title="性别"  typeGroupCode="csex" ></t:dictSelect>
	            	</div>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					民族：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="nation" type="text" class="form-control" maxlength="10" value = "${hHardInsurance.nation}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					婚姻状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="marriage" type="text" class="form-control" maxlength="20" value = "${hHardInsurance.marriage}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					家庭关系：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="relation" type="text" class="form-control" maxlength="20" value = "${hHardInsurance.relation}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					户主姓名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="householder" type="text" class="form-control" maxlength="30" value = "${hHardInsurance.householder}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					户主证件：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="householderid" type="text" class="form-control" maxlength="50" value = "${hHardInsurance.householderid}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					地区：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="district" type="text" class="form-control" maxlength="30" value = "${hHardInsurance.district}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					家庭住址：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="homeAddress" type="text" class="form-control" maxlength="200" value = "${hHardInsurance.homeAddress}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					特困编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="code" type="text" class="form-control" maxlength="50" value = "${hHardInsurance.code}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					出生日期：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="birthday" type="text" class="form-control" maxlength="30" value = "${hHardInsurance.birthday}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					是否残疾：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<div style="padding-top:5px">
	            	<t:dictSelect field="isDisabled" defaultVal = "${hHardInsurance.isDisabled}" extendJson="{class:'i-checks'}" type="radio" hasLabel="false"  title="是否残疾"  typeGroupCode="disability" ></t:dictSelect>
	            	</div>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					残疾证号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="disabledid" type="text" class="form-control" maxlength="50" value = "${hHardInsurance.disabledid}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					残疾类别：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="disabledtype" type="text" class="form-control" maxlength="30" value = "${hHardInsurance.disabledtype}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					残疾等级：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="disabledlevel" type="text" class="form-control" maxlength="20" value = "${hHardInsurance.disabledlevel}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					详细地址：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="address" type="text" class="form-control" maxlength="200" value = "${hHardInsurance.address}"  datatype="*"  ignore="checked"  />
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