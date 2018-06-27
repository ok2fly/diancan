<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>故障类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden" value="${user.id}" id="mod_use_id" name="mod_use_id">
	<input type="hidden" value="${user.com_id}" id="sub_com_id" name="sub_com_id">
	
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>培训类型ID</th>
			<td><select value="" id="tra_typ_id"  placeholder="请选择培训类型" class="popinput requiredInp"></select></td>
			<th>培训内容</th>
			<td><input type="text" id="tra_cont" placeholder="请输入培训内容"  class="popinput requiredInp"></td>
		</tr>
		<tr>
			<th>主讲人</th>
			<td><input type="text" id="tra_speaker"  placeholder="请输入主讲人" class="popinput requiredInp"></td>
			<th>被培训对象 </th>
			<td><input type="text" id="tra_target"  placeholder="请输入被培训对象" class="popinput requiredInp"></td>
		</tr>
		<tr>	
			<th>开始时间</th>
			<td><input type="text" id="begin_tim" class="popinput Wdate requiredInp" placeholder="请输入开始时间"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'finish_tim\')}'})"></td>
			<th>结束时间</th>
			<td><input type="text" id="finish_tim"  placeholder="请输入结束时间" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'begin_tim\')}'})"></td>
		</tr>
		<tr>	
			<th>培训地点</th>
			<td><input type="text" id="tra_place"  placeholder="请输入培训地点" class="popinput requiredInp"></td>
		</tr>
		<tr>	
			<th>备注</th>
			<td colspan="3"><input type="text" id="remark" placeholder="请输入备注"  style="width:96%;" class="popinput"></td>
		</tr>
		<tr>
			
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>


$(function(){
	var mod_use_id=$("#mod_use_id").val();
	var id = $("#id").val();
	getDataById(id);
})
function getDefectTyp(tra_typ_id){
	$.ajax({
		url:url+"getTrainingTypList.htm",
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				var html="";
				if(data.data.length>0){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						var selHtml="";
						if(tra_typ_id==d.id){
							selHtml = 'selected' ;
						}
						 html +=  "<option value="+d.id+" "+selHtml+">"+d.typ_nam+"</option>";
					}
				}
				else{
					html +=  "<option value='qxz'>请选择</option>";
			 }
				$("#tra_typ_id").html(html);
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
}
function getDataById(id){
	
	$.ajax({
		url:url+"getTrainingById.htm",
		type:"post",
		data:"id="+id,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var d=data.data;
			/* 	$("#tra_num").val(d.tra_num);
				$("#plan_num").val(d.plan_num);
				$("#is_exec").val(d.is_exec); */
				$("#tra_cont").val(d.tra_cont);
				$("#tra_speaker").val(d.tra_speaker);
				$("#tra_target").val(d.tra_target);
				$("#begin_tim").val(getLocalDateAndTime(d.begin_tim,2));
				$("#finish_tim").val(getLocalDateAndTime(d.finish_tim,2));
				$("#tra_place").val(d.tra_place);
				$("#remark").val(d.remark);
				$("#sub_com_id").val(d.sub_com_id);
				$("#crt_use_id").val(d.crt_use_id);
				$("#crt_tim").val(getLocalDateAndTime(d.crt_tim,2));
				getDefectTyp(d.tra_typ_id);
				
			}else{
				layer.alert(data.desc);
			}
		}
	})
}


function update(){
	
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	} 
	  		if(reFlag){
	  			return false;
	  		}
	}); 
	if(reFlag){
	   return false;
	}
	
	
	 var  param ="";
	 var id=$("#id").val();
	 var  tra_typ_id = $("#tra_typ_id").val();
	/*  var  tra_num = $("#tra_num").val();
	 var  plan_num = $("#plan_num").val();
	 var  is_exec = $("#is_exec").val(); */
	 var  tra_cont = $("#tra_cont").val();
	 var  tra_speaker = $("#tra_speaker").val();
	 var  tra_target = $("#tra_target").val();
	 var  begin_tim = $("#begin_tim").val();
	 var  finish_tim = $("#finish_tim").val();
	 var  tra_place = $("#tra_place").val();
	 var  remark = $("#remark").val();
	 var  sub_com_id = $("#sub_com_id").val();
	 var  mod_use_id = $("#mod_use_id").val();

	 
	 param +="&id="+id+"&tra_typ_id="+tra_typ_id+"&tra_cont="+tra_cont+
	 "&tra_speaker="+tra_speaker+"&tra_target="+tra_target+
	 "&begin_tim="+begin_tim+"&finish_tim="+finish_tim+
	 "&tra_place="+tra_place+"&remark="+remark+"&sub_com_id="+sub_com_id+"&mod_use_id="+mod_use_id,
	 layer.confirm("确定修改？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
	    	url:url+"updTraining.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			layer.alert("保存成功");
	            	$(".cancle").click();
	            	window.parent.getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	});
	
	 
}
</Script>
</body>
</html>
