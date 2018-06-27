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
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>设备编号:</th>
			<td id="equ_num_name"></td>
			<th>审核</th>
			<td>
				<select class="popinput quinputcol requiredInp"  placeholder="请选择审核状态" id="shenheId" onchange="changeVal(this.value)">
					<option value="1">通过</option>
					<option value="2">驳回</option>
				</select>
			</td>
		</tr>
		<tr class="yy" style="display:none;">
			<th>驳回原因</th>
			<td colspan="3"><input type="text" placeholder="审核驳回请输入驳回原因"  id="task_reject_reason" class="popinput quinputcol requiredInp" style="width: 580px;"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3"  placeholder="请输入备注" id="remark"  class="poptextarea" readonly="readonly"></textarea>
			</td>
		</tr>
		<tbody id="fileimg"></tbody>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="return update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<Script>
$(function(){
	var id=$("#id").val();
	getById(id);
})

function changeVal(vv){
	if(vv == 1){
		 $(".yy").hide();
	}else{
		$(".yy").show();
	}
}


function getById(id){
	$.ajax({
    	url:url+"selScrapById.htm",
    	data : "id="+id,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 if(data.data.lstMap ){
       				 var d =  data.data.lstMap[0];
       				 //$("#scrap_resaon").val(d.scrap_resaon);
       				 $("#remark").val(d.remark);
       				 $("#equ_num_name").html(d.equ_num);

       			 }
   				var htmfil="";
    			if(data.data.lstFile){
    				for(var i=0;i<data.data.lstFile.length;i++){
    					var fil=data.data.lstFile[i];
    					htmfil='<tr>'+
    					'<th>文件</th>'+
    					'<td><span>'+fil.file_name+'</span></td>'+
    					'<th><a onclick="down('+fil.id+','+fil.type+')">下载</a></th>'+
    					'<td></td>';
    				}

    			}
    			var htmimg="";
    			if(data.data.lstImg){
    				for(var i=0;i<data.data.lstImg.length;i++){
    					var img=data.data.lstImg[i];
    					htmimg='<tr>'+
    					'<th>图片</th>'+
    					//'<td><img src="'+img.image_path+'"  width="200px" height="100px"></td>'+
    					'<td><span>'+img.tour_image_name+'</span></td>'+
    					'<th><a onclick="down('+img.id+','+img.type+')">下载</a></th>'+
    					'<td></td>';
    				}
    			}
    			var html=htmfil+htmimg;
    			$("#fileimg").html(html);
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
function down(id,type){
	<%-- layer.confirm("确定下载？",function(){
	 	location.href="<%=basePath%>service/downloadImgOrFile.htm?id="+id+"&type="+type;  
	}) --%>
	
	var layerC = layer.confirm("确定下载？",function(){
		$.ajax({
			url : url+"downloadImgOrFile.htm?id="+id+"&type="+type,
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.resultcode && data.resultcode != "USR000") {
					layer.alert(data.desc);
					return ;
				} else {
					location.href = url+"downloadImgOrFile.htm?id="+id+"&type="+type;
					layer.close(layerC);
				}
			},
			error : function(){
				location.href =  url+"downloadImgOrFile.htm?id="+id+"&type="+type;
				layer.close(layerC);
			}
		})  
		
	})
	
}
 

function update(){
	var id  = $("#id").val();
	var user_id = $("#user_id").val();
	
	var shenheId = $("#shenheId").val();
	var task_reject_reason = $("#task_reject_reason").val();
	var two_check_use_id = $("#two_check_use_id").val();
	
	var param =  "id="+id+"&user_id="+user_id ;
	if(shenheId == "1"){
		if(task_reject_reason != '' && task_reject_reason != undefined && task_reject_reason != 'qxz'){
			param += "&two_check_detail="+task_reject_reason ;
		} 
		param += "&check_sta=4" ;
	}else if(shenheId == "2"){
		if(task_reject_reason != '' && task_reject_reason != undefined){
			param += "&two_check_detail="+task_reject_reason+"&check_sta=5" ;
		}else{
			layer.alert("审核驳回请输入驳回原因");
			return ;
		}
	}
	
	layer.confirm("确定保存？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		  $.ajax({
	    	url:url+"updScrapStaTwo.htm",
	    	data : param ,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	            	window.parent.getData();
	   	    		$(".cancle").click();
	    			window.parent.layer.alert("审核成功");
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })  
    })  
 
}
</Script>
</body>
</html>
