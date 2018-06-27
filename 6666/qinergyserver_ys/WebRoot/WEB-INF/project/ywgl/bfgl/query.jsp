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
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	<input type="hidden" value="${id}" id="id" name="id">
	<input type="hidden"  value="${user.id}"  id="crt_use_id" name="crt_use_id">
	<input type="hidden"   id="equ_num" name="equ_num">
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>设备编号:</th>
			<td id="equ_num_name"></td>
		</tr>
		<tr>
			<th>第一次审核人</th>
			<td>
				<select class="popinput requiredInp" placeholder="请输入第一次审核人" id="one_check_use_id"   >
		 			
				</select>
			</td>
			<th>第二次审核人</th>
			<td>
				<select class="popinput requiredInp" placeholder="请输入第一次审核人" id="two_chcek_use_id"   >
		 			
				</select>
			</td>
		</tr>
		<tr>
			<th>处理意见</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入处理意见" id="scrap_opinion"   class="poptextarea requiredInp"  readonly="readonly"></textarea>
			</td>
		</tr>
		<tr>
			<th>报废原因</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入处理意见" id="scrap_resaon"   class="poptextarea requiredInp"  readonly="readonly"></textarea>
			</td>
		</tr>
		<tr>
			<th>第一次驳回原因</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入报废原因" id="one_check_detail"  class="poptextarea requiredInp"  readonly="readonly"></textarea>
			</td>
		</tr>
		<tr>
			<th>第二次驳回原因</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入报废原因" id="two_check_detail"   class="poptextarea requiredInp"  readonly="readonly"></textarea>
			</td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3"  placeholder="请输入备注" id="remark" class="poptextarea requiredInp"  readonly="readonly"></textarea>
			</td>
		</tr>
		<tbody id="fileimg"></tbody>
	</table>
	</form>
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
	var id = $("#id").val();
	getById(id);
})

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
       				 $("#scrap_resaon").val(d.scrap_resaon);
       				 $("#remark").val(d.remark);
       				 $("#equ_num_name").html(d.equ_num);
       				 $("#equ_num").val(d.equ_num);
       				$("#scrap_opinion").val(getIsNull(d.scrap_opinion));
       				$("#one_check_detail").val(getIsNull(d.one_check_detail));
       				$("#two_check_detail").val(getIsNull(d.two_check_detail));
       				getPerson(d.one_check_use_id,d.two_chcek_use_id);
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
 
function getPerson(id,id2){
	$.ajax({
    	url:url+"selUserNameTourCheck.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
    			 var htmls2 = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				if(d.id == id){
	   		    				htmls += "<option value='"+d.id+"' selected>"+d.use_nam+"</option>";
   		    				} 
   		    				if(d.id == id2){
	   		    				htmls2 += "<option value='"+d.id+"' selected>"+d.use_nam+"</option>";
   		    				} 
   	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>无</option>";
       			 }
    			if(htmls2 == ""){
    				htmls2  =  "<option value='qxz'>无</option>";
    			}
    			if(htmls == ""){
    				htmls  =  "<option value='qxz'>无</option>";
    			}
   	    		$("#one_check_use_id").html(htmls); 
   	    		$("#two_chcek_use_id").html(htmls2); 
    			
   	    		 
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
 
 
</Script>
</body>
</html>
