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
	<input type="hidden" value="${user.id}" id="user_id" name="crt_use_id">
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<table cellpadding="0"   border="0" width="100%" class="poptable">
		<tr>
			<th>一级公司</th>
			<td>
				 <select class="popinput quinputcol requiredInp"  placeholder="请选择一级公司" id="companyOne" name="companyOne" onchange="setCompanytwo(this.value);">
   	   			 	<option value="qxz">请选择一级公司</option>
   	   			 </select>
			</td>
			<th>二级公司</th>
			<td>
				 <select class="popinput quinputcol requiredInp" placeholder="请选择二级公司"  id="companyTwo" name="companyTwo" onchange="setCompanyThree(this.value);">
   	   			 	<option value="qxz">请选择二级公司</option>
   	   			 </select>
			</td>
		</tr>
		<tr>
			<th>三级公司</th>
			<td>
				 <select class="popinput quinputcol requiredInp"  placeholder="请选择三级公司"  id="companyThree" name="companyThree"   onchange="setPws(this.value);">
   	   			 	<option value="qxz">请选择三级公司</option>
   	   			 </select>
			</td>
			<th>电站</th>
			<td>
				<select class="popinput quinputcol requiredInp"   placeholder="请选择电站" id="companyPws" name="companyPws"   onchange="setTypeIde(this.value);" >
   	   			 	<option value="qxz">请选择电站</option>
   	   			 </select>
			</td>
		</tr>
		<tr>
			<th>设备类型</th>
			<td>
				<select class="popinput quinputcol requiredInp"  placeholder="请选择设备类型" id="typeIde" name="typeIde"   onchange="setTypeEquNum(this.value);" >
   	   			 	<option value="qxz">请选择设备类型</option>
   	   			 </select>
			</td>
			<th>设备编号</th>
			<td>
				<select class="popinput quinputcol requiredInp" placeholder="请选择设备编号" id="equ_num" name="equ_num">
		 			<option value="qxz">请选择设备编号</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>第一次审核人</th>
			<td>
				<select class="popinput requiredInp" placeholder="请选择第一次审核人"  id="one_check_use_id" name="one_check_use_id">
		 			
				</select>
			</td>
			<th>处理意见</th>
			<td><input type="text" placeholder="请输入处理意见" id="scrap_opinion"  class="popinput quinputcol requiredInp" name="scrap_opinion"></td>
		</tr>
		<tr>
			<th>附件</th>
			<td><input type="file" name="files" id="files"  placeholder="请选择附件" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>报废原因</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入报废原因" id="scrap_resaon"  name="scrap_resaon"  class="poptextarea requiredInp"></textarea>
			</td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"  name="remark"  class="poptextarea"></textarea>
			</td>
		</tr>
	</table>
</form>	
	
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="uploadImg()">确定</button>
	</div>

</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/ywCheckCom.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-form.js?pubVersion=201802070001"></script>
<Script>
$(function(){
	getCompanyOne();
	getPerson();
})


function getPerson(){
	$.ajax({
    	url:url+"selUserNameTourCheck.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				htmls += "<option value='"+d.id+"'>"+d.use_nam+"</option>";
   	    			 }
       			 }else{
       					htmls +=  "<option value='qxz'>选择第一次审核人</option>";
       			 }
    			
   	    		$("#one_check_use_id").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
 
/* function insert(){
	var userId  = $("#user_id").val();
	var equ_num  = $("#equ_num").val();
	var scrap_resaon  = $("#scrap_resaon").val();
	var remark  = $("#remark").val();
	var one_check_use_id  = $("#one_check_use_id").val();
	var scrap_opinion  = $("#scrap_opinion").val();
	
	var param = "crt_use_id="+userId;
	
	if(equ_num != '' && equ_num != undefined && equ_num != 'qxz'){
		param += "&equ_num="+equ_num;
	}else{
		layer.alert("请选择设备编号");
		return ;
	}
	
	if(one_check_use_id != '' && one_check_use_id != undefined){
		param += "&one_check_use_id="+one_check_use_id;
	}else{
		layer.alert("请选择第一次审核人");
		return ;
	}
	
	if(remark != '' && remark != undefined){
		param += "&remark="+remark;
	} 
	
	if(scrap_resaon != '' && scrap_resaon != undefined){
		param += "&scrap_resaon="+scrap_resaon;
	}  
	
	if(scrap_opinion != '' && scrap_opinion != undefined  ){
		param += "&scrap_opinion="+scrap_opinion;
	} 
	
	$.ajax({
    	url:url+"insertScrap.htm",
    	data : param+="&type=7",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			
    			window.parent.document.getElementById("type").value=1;
            	window.parent.getData();
   	    		$(".cancle").click();
   	    		window.parent.layer.alert("保存成功");
			} else {
               layer.alert(data.desc);
			}
    		
    	}
    })
	 
} */

function uploadImg(){
	
	var userId  = $("#user_id").val();
	var equ_num  = $("#equ_num").val();
	var scrap_resaon  = $("#scrap_resaon").val();
	var remark  = $("#remark").val();
	var one_check_use_id  = $("#one_check_use_id").val();
	var scrap_opinion  = $("#scrap_opinion").val();
	
 
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		//if($(this).val().trim() == "" || $(this).val() == undefined ){
  			if($(this).val() == undefined || $(this).val().trim() == "" ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	}else{
		   		if($(this).attr("id") == "companyOne" || $(this).attr("id") == "companyTwo" || $(this).attr("id") == "companyThree" 
		   				|| $(this).attr("id") == "companyPws" || $(this).attr("id") == "typeIde" || $(this).attr("id") == "equ_num" || $(this).attr("id") == "one_check_use_id" ){
	 		 		if($(this).val() == "qxz"){
	 		 		   reFlag = true;
					   layer.alert($(this).attr("placeholder"))
					   return false;
	 		 		}
	 		 	} 
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
		 var param="";
		 var userId =$("#user_id").val();
		var  maxSize = 1024 * 1024 * 100 ;
		var size = document.getElementById('files').files[0].size;
        var filesize = (size).toFixed(2);
        
        if(filesize < maxSize){  
			var option = {
		     　　 	url : url+'insertScrap.htm',
		    　　  	type : 'POST',
		     　　 	dataType : 'json',
		      　　	contentType: false,
		       	processData: false,
		    　　  	success : function(data) {
		       　　 			layer.close(indexlayer);  //关闭 loading 
				    	if(data.resultcode=="USR000"){
				    		layer.alert("保存成功");
			            	$(".cancle").click();
			            	window.parent.getData();
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
