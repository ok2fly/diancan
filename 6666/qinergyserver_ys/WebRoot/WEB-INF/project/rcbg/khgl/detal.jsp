<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		
	</head>
	<body >
	<input type="hidden" id="id" value="${id }">
		<div class="pt18 fl " style="width: 100%">
		<div class=" tabxq ">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"  >
				<tr>
					<th>公司</th>
					<td id="com_id" > </td>
					<th>部门</th>
					<td id="dep_id" > </td>
				</tr>
				<tr>
					<th>职位</th> 
					<td id="pos_id" > </td>
					<th>角色</th>
					<td id="rol_id" > </td>
				</tr>
				<tr>
					<th>账号</th>
					<td id="acc_num1" ></td>
					<th>姓名</th>
					<td id="use_nam" ></td>
				</tr>
				<tr>
					<th>性别</th>
					<td id="use_sex" ></td>
					<th>联系方式</th>
					<td id="use_mob" >
				</tr>
				<tr>
					</td>
					<th>邮箱</th>
					<td id="use_mal" ></td>
					<th>证件号</th>
					<td id="use_idc"  ></td>
				</tr>
				<tr>
					<th>学历</th> 
					<td id="edu_id" > </td>
					<th>专业</th>
					<td id="use_maj"  ></td>
				</tr>
				<tr>
					<th>入职时间</th>
					<td id="tak_tim" ></td>
					<th>籍贯</th>
					<td id="pla_ori" ></td>
				</tr>
				<tr>
					<th>通讯地址</th>
					<td id="use_add" ></td>
					<th>用户类型</th>
					<td id="use_typ" ></td>
				</tr>
				<tr>
					<th>在职状态</th>
					<td id="use_sta"  ></td>
					<th>站查看</th>
					<td id="slt_opt_sta" ></td>
				</tr>
				<tr>
					<th>告警查看</th>
					<td id="is_def_sta" ></td>
					<th>备注</th>
					<td  id="remark" > </td>
				</tr>
				</table>
			</div>
		</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
var comCheckId = "";
var depCheckId = "";
var posCheckId = "";
var eduCheckId = "";
var rolCheckId = "";
var id = "";
$(function(){
	id = $("#id").val()
	getById(id);
	getCom();
	getPos();
	
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
    			 $("#com_id").html(d.com_id);
    			 $("#dep_id").html(d.dep_id);
    			 $("#pos_id").html(d.pos_id);
    			 $("#rol_id").html(d.rol_id);
				 var use_sta=d.use_sta==1?"在职":d.use_sta==2?"离职":"";
    			 $("#use_sta").html(use_sta);
    			 $("#acc_num1").html(d.acc_num);
    			 $("#use_nam").html(d.use_nam);
    			 $("#use_mob").html(d.use_mob);
				 var use_sex=d.use_sex==1?"男":d.use_sex==2?"女":"";
    			 $("#use_sex").html(use_sex);
    			 $("#use_idc").html(d.use_idc);
    			 $("#use_mal").html(d.use_mal);
    			 var ut = d.use_typ == 1 ? "运维人员":"其他人员" ;
    			 $("#use_typ").html(ut);
    			 $("#use_add").html(d.use_add);
    			 $("#pic_url").html(d.pic_url);
    			 $("#use_maj").html(d.use_maj);
    			 if(d.tak_tim){
	    			 $("#tak_tim").html(getLocalDateAndTime(d.tak_tim,2));
    			 }
    			 $("#pla_ori").html(d.pla_ori);
				 var slt_opt_sta=d.slt_opt_sta==2?"不可查看":d.slt_opt_sta==1?"可查看":"";
    			 $("#slt_opt_sta").html(slt_opt_sta);
				 var is_def_sta=d.is_def_sta==2?"不可查看":d.is_def_sta==1?"可查看":"";
    			 $("#is_def_sta").html(is_def_sta);
    			 $("#remark").html(d.remark);
    			 comCheckId = d.com_id;
    			 depCheckId = d.dep_id;
    			 posCheckId = d.pos_id;
    			 getEduInfLst(d.edu_id);
    			 rolCheckId = d.rol_id;
			} else {
               layer.alert(data.desc);
			}
    	}
})
}
function getCom(){
	var userId = $("#user_id").val();
 	$.ajax({
	    	url:url+"getAllOwnComNam.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 if(data.data.length > 0 ){
	    				 var html = "";
	    				 for(var i = 0; i< data.data.length ; i++){
	    					 var org = data.data[i];
	    					 if(comCheckId == org.id){
	       						 $("#com_id").html(org.com_nam); 
	  							getDep(org.id);
	    					 }
		    			 } 
	    			 }
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}
function getEduInfLst(eduCheckId){
	$.ajax({
    	url:url+"getEduInfLst.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data3){
    		if (data3.resultcode=="USR000") {
    			 var htmls = "";
    			 if(data3.data.length > 0 ){
    				 for(var i = 0; i< data3.data.length ; i++){
		    			var d =  data3.data[i];
		    			if(eduCheckId==d.id){
		    				 $("#edu_id").html(d.edu_nam); 
		    			}
	    			 }
    			 } 
			} else {
               layer.alert(data3.desc);
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
							$("#dep_id").html(d.dep_nam);
						}
					}
				} 
			}else{
				layer.alert(data2.desc);
			}
		}
	});
	getRole(com_id);
}
	

function getPos(){
 	$.ajax({
	    	url:url+"getPosInfAll.htm",
	    	dataType:"json",
	    	async : false,
	    	type:"post",
	    	success:function(data2){
	    		if (data2.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data2.data.length > 0 ){
	    				 for(var i = 0; i< data2.data.length ; i++){
	    					 var d =  data2.data[i];
							if(posCheckId == d.id){
			    				 $("#pos_id").html(d.pos_nam); 
							}
		    			 }
	    			 } 
				} else {
	               layer.alert(data2.desc);
				}
	    	}
    })
}
 
 
function getRole(com_id){
	$.ajax({
    	url:url+"getBasRolInfo.htm",
    	/* data : , */
    	dataType:"json",
    	type:"post",
    	success:function(data3){
    		if (data3.resultcode=="USR000") {
    			 var htmls = "";
    			 if(data3.data.length > 0 ){
    				 for(var i = 0; i< data3.data.length ; i++){
		    			var d =  data3.data[i];
		    			if(rolCheckId == d.id){
		    				 $("#rol_id").html(d.rol_nam); 
		    			}
	    			 }
    			 } 
			} else {
               layer.alert(data3.desc);
			}
    	}
})
}
</script>		

</body>
</html>