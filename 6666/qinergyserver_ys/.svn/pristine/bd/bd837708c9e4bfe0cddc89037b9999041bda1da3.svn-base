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
<title>培训计划</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="crt_use_id" name="crt_use_id">
	<input type="hidden" value="${user.com_id}" id="sub_com_id" name="sub_com_id">
	<input type="hidden" value="${type}" id="type">

	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>培训类型</th>
			<td><select value="" id="tra_typ_id" placeholder="请选择培训类型" class="popinput requiredInp"></select></td>
			<th>培训内容</th>
			<td><input type="text" id="tra_cont" placeholder="请输入培训内容" class="popinput requiredInp"></td>
		</tr>
		<tr>
			<th>主讲人</th>
			<td><input type="text" id="tra_speaker"  placeholder="请输入主讲人" class="popinput requiredInp"></td>
			<th>被培训对象 </th>
			<td><input type="text" id="tra_target" placeholder="请输入被培训对象"  class="popinput requiredInp"></td>
		</tr>
		<tr>	
			<th>开始时间</th>
			<td><input type="text" id="begin_tim"  placeholder="请输入开始时间" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'finish_tim\')}'})"></td>
			<th>结束时间</th>
			<td><input type="text" id="finish_tim"  placeholder="请输入结束时间" class="popinput Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'begin_tim\')}'})"></td>
		</tr>
		<tr>	
			<th>培训地点</th>
			<td><input type="text" id="tra_place"  placeholder="请输入培训地点" class="popinput requiredInp"></td>
		</tr>
		<tr>	
			<th>备注</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
			</td>
		</tr>
		
		<tr>
			
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getDefectTyp();
})
function getDefectTyp(){
	 var type=$("#type").val();
	$.ajax({
		url:url+"getTrainingTypList.htm",
		data:"",
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				if(data.data.length>0){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						if(type==d.id){
							 htmls +=  "<option value='"+d.id+"' selected>"+d.typ_nam+"</option>";							
						}else{
							
						 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
						}
					}
				}
				$("#tra_typ_id").html(htmls);
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
}
function insert(){
	
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

	
	
	var crt_use_id=$("#crt_use_id").val();
	var sub_com_id=$("#sub_com_id").val();
	 var param ="crt_use_id="+crt_use_id+"&sub_com_id="+sub_com_id;
	 var  tra_typ_id = $("#tra_typ_id").val();
	 var  tra_cont = $("#tra_cont").val();
	 var  tra_speaker = $("#tra_speaker").val();
	 var  tra_target = $("#tra_target").val();
	 var  begin_tim = $("#begin_tim").val();
	 var  finish_tim = $("#finish_tim").val();
	 var  tra_place = $("#tra_place").val();
	 var  remark = $("#remark").val();
	 
	 param += "&tra_typ_id="+tra_typ_id+"&tra_cont="+tra_cont+"&tra_speaker="+tra_speaker+
	 "&tra_target="+tra_target+"&begin_tim="+begin_tim+"&finish_tim="+finish_tim+"&tra_place="+tra_place+
	 "&remark="+remark,
	 
	 layer.confirm("确定保存？",function(){
		$.ajax({
	    	url:url+"insTrainingPlan.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage  = 1;
	            	window.parent.getData();
	    			layer.alert("保存成功",function(){
	    				$(".cancle").click();
	    			});
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
