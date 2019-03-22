<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>项目脱贫</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="hProjectHelpPoorController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${hProjectHelpPoor.id}"/>
	<div class="form-group">
		<label for="village" class="col-sm-3 control-label">村名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="village" name="village" value='${hProjectHelpPoor.village}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入村名"  datatype="*"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">户主：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="name" name="name" value='${hProjectHelpPoor.name}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入户主"  datatype="*"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="idno" class="col-sm-3 control-label">身份证号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="idno" name="idno" value='${hProjectHelpPoor.idno}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入身份证号"  datatype="*"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="family" class="col-sm-3 control-label">家庭人口数：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="family" name="family" value='${hProjectHelpPoor.family}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入家庭人口数"  datatype="n"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="machine" class="col-sm-3 control-label">农机：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="machine" name="machine" value='${hProjectHelpPoor.machine}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入农机"  datatype="n"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="fungi" class="col-sm-3 control-label">食用菌：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="fungi" name="fungi" value='${hProjectHelpPoor.fungi}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入食用菌"  datatype="n"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="fermentation" class="col-sm-3 control-label">果蔬发酵：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="fermentation" name="fermentation" value='${hProjectHelpPoor.fermentation}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入果蔬发酵"  datatype="n"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="rectification" class="col-sm-3 control-label">整改：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="rectification" name="rectification" value='${hProjectHelpPoor.rectification}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入整改"  datatype="n"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="money" class="col-sm-3 control-label">人口额度：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="money" name="money" value='${hProjectHelpPoor.money}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入人口额度"  datatype="n"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="total" class="col-sm-3 control-label">合计收益数：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="total" name="total" value='${hProjectHelpPoor.total}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入合计收益数"  datatype="n"  ignore="checked" />
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