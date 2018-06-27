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
<form  action="" id="uploadModel" enctype="multipart/form-data" >
	<input type = "hidden" value="${user.id}"   id="useId" name="userId">
	<input type="hidden"  id="tour_people_id" name="tour_people_id" value="${user.id}">
	<input type="hidden"  value="${task_id }"  id="tour_task_id"  name="tour_task_id">
	<input type="hidden"  value="${routeId }"  id="routeId"  name="routeId">
 	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>开始时间</th>
			<td><input type="text" placeholder="请输入开始时间" id="sta_time" name="sta_time"  class="popinput quinputcol Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'end_time\')}'})"></td>
			<th>结束时间</th>
			<td><input type="text" placeholder="请输入结束时间" id="end_time" name="end_time"  class="popinput quinputcol Wdate requiredInp" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'sta_time\')}'})"></td>
		</tr>
		<tr>
			<th>是否完成</th>
			<td> 
				<select class="popinput requiredInp" placeholder="请选择是否完成" id="tour_complete" name="tour_complete" >
					<option value="0"  >是</option>
					<option value="1"  >否</option>
				</select></td>
			<th>附件</th>
			<td><input type="file" name="files" id="files"  placeholder="请选择附件" class="popinput requiredInp" ></td>
		</tr>
		<tr>
			<th>电站</th>
			<td>
				<select class="popinput"  placeholder="请选择电站"  id="tour_route_id" name="tour_route_id">
					 
				</select></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3"    placeholder="请输入备注" id="remark" name="remark"  class="poptextarea"></textarea>
			</td>
		</tr>
		<tbody id="fileimg"></tbody>
	</table>
	</form>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="uploadImg();">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-form.js?pubVersion=201802070001"></script>

<Script>
$(function(){
	
	//getById(); 
	getLx1();
})

function getLx1(){
	var tour_task_id  = $("#tour_task_id").val();
	var routeId  = $("#routeId").val();
	var param = "tour_task_id="+tour_task_id+"&tour_route_id="+routeId;
	$.ajax({
    	url:url+"selOverhaulTaskRecord.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
				 var htmls = "<option value='0'>请选择路线</option>";
    			 if(data.data){
    				 if(data.data.recordMap.length > 0 ){
    					 for(var o=0;o<data.data.recordMap.length;o++){
    						 var a = data.data.recordMap[o];
    						 htmls += "<option value='"+a.id+"'>"+a.pws_nam+"</option>";
    					 }
    					 $("#tour_route_id").html(htmls);
    					 
        			 }else{
        				 $("#tour_route_id").html(htmls);
        			 }
    				 
    			 }else{
    				 $("#tour_route_id").html(htmls);
    			 }
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}


function getById(){
	var oreId= $("#oreId").val();
	 $.ajax({
	    	url:url+"selOverhaulRecordByRouteId.htm",
	    	data:"oreId="+oreId,
	    	dataType:"json",
	    	async:false,
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			if(data.data.lstMap){
	    				 var d = data.data.lstMap[0];
		    			 $("#sta_time").val(getLocalDateAndTime(d.sta_time,2));
		    			 $("#end_time").val(getLocalDateAndTime(d.end_time,2));
		    			 $("#tour_people_id").val(d.tour_people_id);
		    			 $("#tour_complete").val(d.tour_complete);
		    			 $("#tour_task_id").val(d.tour_task_id);
		    			 $("#remark").val(d.remark);
	    			} 
	    			var htmfil="";
	    			if(data.data.lstFile){
	    				for(var i=0;i<data.data.lstFile.length;i++){
	    					var fil=data.data.lstFile[i];
	    					htmfil='<tr>'+
	    					'<th>文件</th>'+
	    					'<td><span>'+fil.file_name+'</span></td>'+
	    					'<th></th>'+
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
	    					'<th></th>'+
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
 
 
 
/* function update(){
	 var  id = $("#id").val(); //节点id
	 var  tour_people_id = $("#useId").val();
	 var  sta_time = $("#sta_time").val();
	 var  end_time = $("#end_time").val();
	 var  tour_complete = $("#tour_complete").val();
	 var  tour_task_id = $("#tour_task_id").val();
	 var  remark = $("#remark").val();
	 var  treId = $("#treId").val();//记录id
	 var param =  "tour_route_id="+id+"&tour_people_id="+tour_people_id+"&sta_time="+sta_time+"&end_time="+end_time+"&tour_complete="+tour_complete+"&tour_task_id="+tour_task_id+"&remark="+remark;
	  
	 if(treId != "" && treId != undefined ){
		 param +=  "&treId="+treId;
	 } 
	 
	 $.ajax({
    	url:url+"updOrInsOverhaulRecord.htm",
    	data:param, 
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			layer.alert("保存成功");
            	$(".cancle").click();
            	window.parent.getLx();
			} else {
               layer.alert(data.desc);
			}
    	}
	});  
	 
} */

function uploadImg(){
 
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
	
	
	layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var  maxSize = 1024 * 1024 * 100 ;
		var size = document.getElementById('files').files[0].size;
        var filesize = (size).toFixed(2);
        if(filesize < maxSize){ 
			var option = {
		     　　 	url : url+'updOrInsOverhaulRecord.htm',
		    　　  	type : 'POST',
		     　　 	dataType : 'json',
		      　　	contentType: false,
		       	processData: false,
		    　　  	success : function(data) {
		       　　 			layer.close(indexlayer);  //关闭 loading 
				    	if(data.resultcode=="USR000"){
				    		window.parent.getLx();
				    		window.parent.getJl();
				    		layer.alert("保存成功",function(){
				    			$(".cancle").click();
				    		});
				    	}else{
				    		layer.alert(data.desc);
				    	}
			  },
			  error: function(res){  
			    	layer.close(indexlayer);  //关闭 loading 
			    	layer.alert("请检查文件,请勿上传>100M的文件");
			  }  
			}
			$("#uploadModel").ajaxSubmit(option);
		}else{
	    	layer.close(indexlayer);  //关闭 loading 
	    	layer.alert('请检查文件,请勿上传>100M的文件');
	    }
	});
}
</Script>
</body>
</html>
