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
	<input type = "hidden" value="${user.id}"   id="useId">
	<input type="hidden" value="${id}" id="id"  >
	<input type="hidden" value="${pws_id}" id="pws_id" >
	<input type="hidden" value="${user.id}" id="tour_people_id" >
	<input type="hidden"  value="${task_id }"  id="tour_task_id" >
	<input type="hidden"  value="${oreId}"  id="oreId" >
 	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>开始时间</th>
			<td id="sta_time">  </td>
			<th>结束时间</th>
			<td id="end_time"></td>
		</tr>
		<tr>
			<th>是否完成</th>
			<td id="tour_complete" >
				 </td>
			<th>备注</th>
			<td id="remark"></td>
		</tr>
		<tbody id="fileimg"></tbody>
	</table>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	var oreId = $("#oreId").val();
	getById(oreId); 
})


function getById(oreId){
	 $.ajax({
	    	url:url+"selOverhaulRecordByRouteId.htm",
	    	data : "oreId="+oreId,
	    	dataType:"json",
	    	async:false,
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			
	    			if(data.data.lstMap){
	    				 var d = data.data.lstMap[0];
		    			 $("#sta_time").html(getLocalDateAndTime(d.sta_time,2));
		    			 $("#end_time").html(getLocalDateAndTime(d.end_time,2));
		    			 var s = d.tour_complete == 0 ? "是" : "否" ;
		    			 $("#tour_complete").html(s);
		    			 $("#remark").html(d.remark);
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
	    					'<td><img src="'+img.image_path+'"  width="200px" height="100px"></td>'+
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
	}); --%>
	
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
</Script>
</body>
</html>
