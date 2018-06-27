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
<form  action="" id="uploadModel"  enctype="multipart/form-data" >
	<input type="hidden" value="${id}" id="id"  name="id" >
	
 	<table cellpadding="0"   border="0" width="100%" class="poptable">
 		
		<tr>
			<th>姓名</th>
			<td><input type="text"  id="use_nam"    class="popinput" readonly="readonly"></td>
			<th>用户状态</th>
			<td><input type="text"  id="state"  class="popinput" readonly="readonly"></td>
		</tr>
		<tr>
			<th>部门</th>
			<td><input type="text"  id="dep_nam" value="无"  class="popinput " readonly="readonly" ></td>
			<th>性别</th>
			<td><input type="text"  id="sex"   class="popinput" readonly="readonly"></td>
		</tr>
		<tr>
			<th>手机</th>
			<td><input type="text"  id="use_mob"   class="popinput " readonly="readonly"></td>
			<th>邮箱</th>
			<td><input type="text" id="use_mal"  class="popinput" readonly="readonly"></td>
		</tr>
		<tr>
			<th>告警查看状态</th>
			<td><input type="text"  id="isDefSta"   class="popinput " readonly="readonly"></td>
			<th>站查看状态</th>
			<td><input type="text"  id="sltOptSta"  class="popinput" readonly="readonly"></td>
		</tr>
		<tr> 
			<th>头像</th>
			<td id="tx"></td>
			<th>重新上传</th>
			<td><input type="file" name="files" id="files" placeholder="请选择文件" class="popinput quinputcol "></td>
		</tr>
		
	</table>
</form>
	<div id="ht"></div>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="uploadImg()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-form.js?pubVersion=201802070001"></script>

<Script>
var comCheckId = "";
var depCheckId = "";
var posCheckId = "";
var eduCheckId = "";
var rolCheckId = "";
var id = "";
$(function(){
	id = $("#id").val()
	getById(id);
	
})

function getById(id){
	$.ajax({
    	url:url+"getUserInfById.htm",
    	data  : "id="+id,
    	dataType:"json",
    	async:false,
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var d= data.data[0];
				 var state1=d.use_sta==1?"在职":d.use_sta==2?"离职":"";
				 var sex1=d.use_sex==1?"男":d.use_sex==2?"女":"";
				 var isDefSta1=d.is_def_sta==1?"可查看":d.is_def_sta ==2?"不可查看":"";
				 var sltOptSta1=d.slt_opt_sta==1?"可查看":d.slt_opt_sta ==2?"不可查看":"";
				 var ht="";
    			 $("#use_nam").val(d.use_nam);
    			 $("#state").val(state1);
    			 $("#sex").val(sex1);
    			 $("#use_mob").val(d.use_mob);
    			 $("#use_mal").val(d.use_mal);
    			 $("#isDefSta").val(isDefSta1);
    			 $("#sltOptSta").val(sltOptSta1);
    			 if(d.pic_url && d.pic_url != ''){
    				 ht = '<img src="'+d.pic_url+'" style="width: 100px;height: 100px;margin-left: 135px;margin-top: -32px;" >';
    				 $("#ht").html(ht);
    			 }else{
    				 ht = '无';
    				 $("#tx").html(ht);
    			 }
    			 
    			 
    			 getDep(d.com_id);
    			 depCheckId = d.dep_id;
    			 
			} else {
               layer.alert(data.desc);
			}
    	}
})
}

function getDep(com_id){
	$.ajax({                
		type : "post",
		url: url + "getDepInfLst.htm",
		data : "com_id="+com_id,
		success: function(data){                          
			if('USR000' == data.resultcode){
				var html="";
				if(data.data.length > 0 ){
					for(var i = 0 ;i < data.data.length ; i++){
						var d = data.data[i];
						if(depCheckId == d.id){
							$("#dep_nam").val(d.dep_nam);						
						}
					}
				} 
				
			}else{
				layer.alert(data2.desc);
			}
		}
	});
}

function uploadImg(){
	
	
	 
	var id=$("#id").val();
	
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	var option = {
     　　 	url : url+'uploadUserImg.htm',
    　　  	type : 'POST',
     　　 	dataType : 'json',
      　　	contentType: false,
       	processData: false,
    　　  	success : function(data) {
       　　 			layer.close(indexlayer);  //关闭 loading 
		    	if(data.isSuccess==0){
		    		layer.alert("保存成功",function(){
		    			$(".cancle").click();
		    		});
		    	}else{
		    		layer.alert("上传失败，请重试");
		    	}
  },
  error: function(res){  
	    	layer.close(indexlayer);  //关闭 loading 
	    	layer.alert("请检查文件,请勿上传>100M的文件");
	  }  
	}
	$("#uploadModel").ajaxSubmit(option);
}
</Script>
</body>
</html>
