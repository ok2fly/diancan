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
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>公司</th>
			<td><select  id="com_id"  placeholder="请选择公司"  class="popinput requiredInp" onchange=getDep(this.value)></select></td>
			<th>部门</th>
			<td><select  id="dep_id"  placeholder="请选择部门" class="popinput"></select></td>
		</tr>
		<tr>
			<th>职位</th> 
			<td><select  id="pos_id" placeholder="请选择职位" class="popinput"></select></td>
			<th>角色</th>
			<td><select  id="rol_id" placeholder="请选择角色" class="popinput requiredInp"></select></td>
		</tr>
		<tr>
			<th>账号</th>
			<td><input type="text" placeholder="请输入账号"  id="acc_num1"   class="popinput quinputcol requiredInp" autocomplete="off"   oninput="if(value.length>20)value=value.slice(0,20)" ></td>
			<th>密码</th>
			<td>
				<input type="password" name="txtPassword" style="display:none">
				<input type="password" placeholder="请输入密码" name="txtPassword" id="use_pas1"   class="popinput quinputcol requiredInp" autocomplete="off">
			</td>
		</tr>
		<tr>
			<th>姓名</th>
			<td><input type="text" placeholder="请输入姓名"  id="use_nam"   class="popinput quinputcol requiredInp"  oninput="if(value.length>20)value=value.slice(0,20)" ></td>
			<th>性别</th>
			<td>
				<select  id="use_sex"  class="popinput requiredInp" placeholder="请选择性别">
					<option value="1">男</option>
					<option value="2">女</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>联系方式</th>
			<td>
				<input type="text" placeholder="请输入联系方式"  id="use_mob"   class="popinput quinputcol "   oninput="if(value.length>11)value=value.slice(0,11)" >
			</td>
			<th>邮箱</th>
			<td><input type="text" placeholder="请输入邮箱"  id="use_mal"   class="popinput quinputcol"   oninput="if(value.length>40)value=value.slice(0,40)" ></td>
		</tr>
		<tr>
			<th>证件号</th>
			<td><input type="text" placeholder="请输入证件号"  id="use_idc"   class="popinput quinputcol"  oninput="if(value.length>30)value=value.slice(0,30)" ></td>
			<th>学历</th> 
			<td><select  id="edu_id" placeholder="请选择学历" class="popinput"></select></td>
		</tr>
		<tr>
			<th>专业</th>
			<td><input type="text" placeholder="请输入专业"  id="use_maj"   class="popinput quinputcol"  oninput="if(value.length>30)value=value.slice(0,30)" ></td>
			<th>入职时间</th>
			<td><input type="text" placeholder="请输入入职时间"  id="tak_tim"  onFocus="WdatePicker()" class="popinput quinputcol Wdate"></td>
		</tr>
		<tr>
			<th>籍贯</th>
			<td><input type="text" placeholder="请输入籍贯"  id="pla_ori"   class="popinput quinputcol"  oninput="if(value.length>50)value=value.slice(0,50)" ></td>
			<th>通讯地址</th>
			<td><input type="text" placeholder="请输入通讯地址"  id="use_add"   class="popinput quinputcol"  oninput="if(value.length>100)value=value.slice(0,100)" ></td>
		</tr>
		<tr>
			<th>用户类型</th>
			<td>
				<select  id="use_typ"  class="popinput requiredInp" placeholder="请选择用户类型">
					<option value="2">其他人员</option>
					<option value="1">运维人员</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>站查看</th>
			<td>
				<select  id="slt_opt_sta"  placeholder="请选择站是否可见"  class="popinput requiredInp">
					<option value="2">不可查看</option>
					<option value="1">可查看</option>
				</select>
			</td>
			<th>告警查看</th>
			<td>
				<select  id="is_def_sta"  placeholder="请选择告警是否可见"  class="popinput requiredInp">
					<option value="2">不可查看</option>
					<option value="1">可查看</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"  oninput="if(value.length>1000)value=value.slice(0,1000)" ></textarea>
			</td>
		</tr>
	</table>
</div>
<div class="tc popbutbox">
	<button class="popbut cancle"  >取消</button>
	<button class="popbut" onclick="insert()">确定</button>
	<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()">
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getCom();
	getPos();
	getEduInfLst();
	getRole();
})
function getEduInfLst(){
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
		    			htmls +=  "<option value='"+d.id+"'>"+d.edu_nam+"</option>";
	    			 }
    				 $("#edu_id").html(htmls); 
    			 } 
			} else {
               layer.alert(data3.desc);
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
	    					 if(org.id == window.parent.checkComId){
	    						 html += "<option value="+org.id+" selected >"+org.com_nam+"</option>"
	    						 getDep(org.id);
	    					 }else{
	    						 html += "<option value="+org.id+">"+org.com_nam+"</option>"
	    						 /* html += "<option value="+org.id+" >"+org.com_nam+"</option>" */
	    					 }
		    			 } 
   						 $("#com_id").html(html); 
	    			 }
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
						html += "<option value="+d.id+">"+d.dep_nam+"</option>";
					}
				}else{
					html+='<option value="0"></option>';
				}  
				$("#dep_id").html(html);
			}else{
				layer.alert(data2.desc);
			}
		}
	});
	
}
	

function getPos(){
 	$.ajax({
	    	url:url+"getPosInfAll.htm",
	    	dataType:"json",
	    	type:"post",
	    	async : false,
	    	success:function(data2){
	    		if (data2.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data2.data.length > 0 ){
	    				 for(var i = 0; i< data2.data.length ; i++){
			    			var d =  data2.data[i];
			    			htmls +=  "<option value='"+d.id+"'>"+d.pos_nam+"</option>";
		    			 }
	    				 $("#pos_id").html(htmls); 
	    			 } 
				} else {
	               layer.alert(data2.desc);
				}
	    	}
    })
}
 
 
function getRole(){
	$.ajax({
    	url:url+"getAllRolInf.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data3){
    		if (data3.resultcode=="USR000") {
    			 var htmls = "";
    			 if(data3.data.length > 0 ){
    				 for(var i = 0; i< data3.data.length ; i++){
		    			var d =  data3.data[i];
		    			htmls +=  "<option value='"+d.id+"'>"+d.rol_nam+"</option>";
	    			 }
    				 $("#rol_id").html(htmls); 
    			 } 
			} else {
               layer.alert(data3.desc);
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
	
	
	 var param = "";
	 
	 var use_typ=$("#use_typ").val();
	 var  com_id = $("#com_id").val();
	 var  dep_id = $("#dep_id").val();
	 var  pos_id = $("#pos_id").val();
	 var  edu_id = $("#edu_id").val();
	 //var  pos_id = 1;
	 //var  edu_id = 1;
	 var pic_url=$("#pic_url").val();
	 var  rol_id = $("#rol_id").val();
	 var  use_sta = $("#use_sta").val();
	 var  acc_num = $("#acc_num1").val();
	 var  use_pas = $("#use_pas1").val();
	 var  use_nam = $("#use_nam").val();
	 var  use_mob = $("#use_mob").val();
	 var  use_sex = $("#use_sex").val();
	 var  use_idc = $("#use_idc").val();
	 var  use_mal = $("#use_mal").val();
	 var  use_add = $("#use_add").val();
	 var  use_maj = $("#use_maj").val();
	 var  tak_tim = $("#tak_tim").val();
	 
	 var  pla_ori = $("#pla_ori").val();
	 var  is_def_sta = $("#is_def_sta").val();
	 var  slt_opt_sta = $("#slt_opt_sta").val();
	 var  remark = $("#remark").val();
	 
	 param += "&com_id="+com_id+"&dep_id="+dep_id+"&pos_id="+pos_id+"&edu_id="+edu_id+"&rol_id="+rol_id+"&acc_num="+acc_num+
		"&use_pas="+use_pas+"&use_nam="+use_nam+"&use_mob="+use_mob+"&use_sex="+use_sex+"&use_idc="+use_idc+"&use_mal="+use_mal+
		"&use_add="+use_add+"&use_maj="+use_maj+"&tak_tim="+tak_tim+"&pla_ori="+pla_ori+"&remark="+remark+"&use_typ="+use_typ+
		"&is_def_sta="+is_def_sta+"&slt_opt_sta="+slt_opt_sta;
	
	layer.confirm("是否添加？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});	
		
		$.ajax({
	    	url:url+"insUserInfo.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ; 
	            	window.parent.getData();
	    			layer.alert("保存成功");
				} else {
	               layer.alert(data.desc);
				}
	    	}
		})
	})
	
	 
}

function reset(){
	window.location.reload();
}
    
</Script>
</body>
</html>
