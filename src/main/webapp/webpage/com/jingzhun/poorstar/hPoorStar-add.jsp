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
	<form class="form-horizontal" role="form" id="formobj" action="hPoorStarController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					乡镇：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="town" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					行政村：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="village" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					姓名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="name" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					身份证号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="idno" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					残疾等级：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="deformityLevel" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					低保等级：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="dibaoLevel" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					特困供养方式：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="gongyangType" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					孤儿：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="orphan" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					困境儿童：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="children" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					脱贫不享受政策：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="tuopin" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					大病：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="illness" type="text" class="form-control input-sm" maxlength="10"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					星级：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="starLevel" type="text" class="form-control input-sm" maxlength="3"  datatype="n"  ignore="checked"  />
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