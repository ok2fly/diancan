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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css?pubVersion=201802070001">
<style>
#uls li{
	position: relative;
}
.ative23{
    background: #f2f2f2 ;  
    color: #333;
    height: 20px;
    line-height: 20px;
    font-weight: normal;
    padding: 10px 0 10px 60px;
     margin-top: 1px;   
      border-bottom: 1px solid #f2f2f2;  
}
.ative24{
     padding: 10px 0 10px 120px;
      height: 20px;
       line-height: 20px;
        border-bottom: 1px solid #f2f2f2;
         margin-top: 2px;     
}
.ative25{
      padding: 10px 0 10px 160px;
      height: 20px;
      line-height: 20px;
      border-bottom: 1px solid #f2f2f2;
       margin-top: 2px;     
}
.ulli2{     
    color: #333;
    font-weight: normal;
    height: 20px;
    line-height: 20px;
    text-align: left; 
    margin-bottom: 2px ;   
    margin-top: 12px;   
    border-bottom: 1px solid #f2f2f2;
    left: -62px;
  
}   
.divs1{
  height: 1px;
  background:#f2f2f2; 
  z-index: 100; 
  position: relative;
  left: -62px; 
}

.hide{
   position: absolute;
     height: 11px;
    width: 21px;
    display: inline-block;
    font-size: 0px;
    background: url(../../../images/icon-all.png) no-repeat -75px 0;
    left: 210px;
    top: 13px;
    cursor: pointer;
}
 .active{
   background-position: -50px 0;
}
.inputCheck{
      margin-right: 18px;
}
</style>
</head>
<body >
	<!-- viewFramework   -->
  	<div class=viewFramework> 
		 <input id="roleId" type="hidden" value="${id}">
		 <input type="hidden" name = "com_id" id="com_id" value="${user.com_id}" >
		 <input type="hidden" name = "crt_use_id" id="crt_use_id" value="${user.id}" >
		 <div class="bg-ff pb18 pl15 pt9 clr">
	         <div class="fanlist-f clr wauto mt10">
	          <div style="width: 100%;" class="clr wauto mt10">
	           <ul id="uls">              
	           </ul>             
			  </div>
	        </div>  
			<div class="query mt10" style="margin-bottom:10px;"> 
				<a href="javascript:void(0);" onclick="update()" class="querybut" >修改</a>
				<a href="<%=basePath%>commens/xtgl/jsgl/list.htm" target="_self" class="querybut">返回</a>
			 </div>
	      </div>
    </div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script>
var roleId = "";
var crt_use_id = "";
var clickCount = 0 ;
$(function(){
	roleId = $("#roleId").val();
	crt_use_id = $("#crt_use_id").val();
	ullirefreshData();
	var ulst= $("#uls").width();
	$(".ulli2").width(ulst-120);
	$(".ulli3").width(ulst-180);
})



//采用ul，li来实现样式
 function ullirefreshData(){
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getUserRoleByModuleLevlApp.htm",
		data :"role_id="+parseInt(roleId),
	    dataType:"json", 
	    type:"post",
	    success:function(data){	   
	    	 layer.close(indexlayer); //关闭 loading 
	    	if(data.resultcode == "USR000"){
	    		 var ulli=data.data;	 
	    		 var htmls="";
	    		 $(ulli).each(function(i,datas){
	    			 var checkHtmlOne = "";
	    			 if(datas.levl == 1){
	    				 checkHtmlOne="checked";
	    			 } 
	    			 htmls += ('<li><div class="ative23"><input type="checkbox" '+checkHtmlOne+' value="'+datas.id+'" onclick="xzAllqx(this)" class="inputCheck">'+datas.module_name+'</div>');
	    			 if (datas.module2LevlAllLst.length>0) {
	    				 htmls += "<i class='hide active'></i><ul>";	    				
	    				 $(datas.module2LevlAllLst).each(function(j,datat){
	    					 var checkHtmlTwo = "";
	    					 if(datat.levl == 1){
	    						 checkHtmlTwo="checked";
	    	    			 } 
	    					 var butHtmlTwo = "";
	    					 if(datat.is_button == 1){
	    						 butHtmlTwo = "<div class='but-qx'  ><a href='javascript:void(0);' data-url='"+jumpPageUrl+"commens/xtgl/jsgl/editBut.htm?id="+datat.id+"&rol_id="+roleId+"' class='layer' data-title='配置按钮权限' data-height='300px' >按钮权限</a></div>";
	    					 }
	    					htmls += '<li ><div class="ative24"><input type="checkbox" '+checkHtmlTwo+' value="'+datat.id+'" name="ative24" onclick="xzAllqx2(this)" class="inputCheck">'+datat.module_name+' '+butHtmlTwo+'</div>';
	    				    if (datat.module3LevlAllLst != null && datat.module3LevlAllLst.length>0) {
	    				    	htmls += '<ul>';
								$(datat.module3LevlAllLst).each(function(t,data2){
									 var checkHtmlThree = ""; 
									 if(data2.levl == 1){
										 checkHtmlThree="checked";
			    	    			 } 
									 var butHtmlThree = "";
			    					 if(data2.is_button == 1){
			    						 butHtmlThree = "<div class='but-qx'  ><a href='javascript:void(0);' data-url='"+jumpPageUrl+"commens/xtgl/jsgl/editBut.htm?id="+data2.id+"&rol_id="+roleId+"' class='layer' data-title='配置按钮权限' data-height='300px' >按钮权限</a></div>";
			    					 }
									htmls+=('<li ><div class="ative25"><input type="checkbox" '+checkHtmlThree+'  value="'+data2.id+'"  onclick="xzAllqx3(this)" name="ative25" class="inputCheck">'+data2.module_name+' '+butHtmlThree+'</div></li>')
								})
								htmls+=('</ul></li>')
	    				    }
	    				 })
	    				 htmls+= "</ul>";
	    				 htmls+= "</li>";
					 }else{
						 htmls+="</li>";
					 } 
	    			 $("#uls").html(htmls);
	    		 })	  
	    		 bindChilk();	    		 
	    	}else{
	    		alert(data.desc);
	    	}
	    }
	  })	
} 

//全選按鈕
function xzAllqx(key){
	clickCount++;
	$(key).parent().parent().find(".ative24").children('input').prop('checked',$(key).prop("checked"));		
	$(key).parent().parent().find(".ative25").children('input').prop('checked',$(key).prop("checked"));		 
}	
//第二层
function xzAllqx2(key){
		clickCount++;
	    var douberst=[];
		$(key).parent().parent().find(".ative25").children('input').prop('checked',$(key).prop("checked"));		
		//循环所有二级的菜单
		$(key).parent().parent().parent().find(".ative24").each(function(i3){
			//给每个二级菜单的input赋选中或未选中的值
			douberst[i3]=$(this).children('input').prop('checked');
			//判断二级菜单的input是否选中,如果选中判断一级菜单选中 /* ，否则判断一级菜单不选中 TODO */
			if ($(this).children('input').prop('checked')) {
				$(key).parent().parent().parent().parent().find(".ative23").children('input').prop('checked',true);
			}
			/* else{
				$(key).parent().parent().parent().parent().find(".ative23").children('input').prop('checked',false);
			} */
		})
		//循环所有二级菜单的选中状态 /* 如有一个未赋值 就把一级菜单取消选中TODO  */ 如果全部未赋值则判断一级菜单取消
		var isCheckedTwo =  false; 
		for (var ist = 0; ist < douberst.length; ist++) {
			if (douberst[ist]==true) {
				isCheckedTwo =  true ;
			}
		}
		if(isCheckedTwo){
			$(key).parent().parent().parent().parent().find(".ative23").children('input').prop('checked',true);
		}else{
			$(key).parent().parent().parent().parent().find(".ative23").children('input').prop('checked',false);
		}
	}	
//第三层
function xzAllqx3(key){
	clickCount++;
	var doubers=[],doubers2=[];
	//找到该节点的一级菜单
	var $kest=$(key).parent().parent().parent().parent().parent().parent().find(".ative23");
	//循环所有三级菜单
	$(key).parent().parent().parent().find(".ative25").each(function(i){
		//给每个三个菜单的选中不选中状态赋值
		doubers[i]=$(this).children('input').prop('checked')
		//如果三级菜单选中则二级菜单选中，/* 否则二级菜单不选中TODO */
		if ($(this).children('input').prop('checked')==true) {			
			$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',true);
		}
		/* else{			 			
			 $(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',false);		     
		} */
	})
	//循环所有三级菜单判断是否有未选中的，/* 如有则把二级菜单不选中 TODO */ 如果全部未选中则判断二级菜单不选中
	var isCheckedThree = false 
	for (var is = 0; is < doubers.length; is++) {
		if (doubers[is]==true) {
			isCheckedThree = true;
		}		
	}	
	if(isCheckedThree){
		$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',true);			
	}else{
		$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',false);			
	}
	//循环所有二级菜单
	$(key).parent().parent().parent().parent().parent().find('.ative24').each(function(i){		 			
		//给所有二级菜单选中不选中状态赋值
		doubers2[i]=$(this).children('input').prop('checked')	
		//判断二级菜单是否选中，如选中则选中一级菜单，/* 否则不选中一级菜单 TODO */
		if (doubers2[i]==true) {
			$($kest).children('input').prop('checked',true)
		}
		/* else{
			$($kest).children('input').prop('checked',false)
		} */
	})
	//循环所有二级菜单，/* 如有未选中的则取消一级菜单选中 TODO */ 如果有选中的，则判断一级菜单选中
	var ischeck = false;
	for (var ist = 0; ist < doubers2.length; ist++) {
		if (doubers2[ist]==true) {
			ischeck  = true;
		}
	}
	if(ischeck){
		$($kest).children('input').prop('checked',true);
	}else{
		$($kest).children('input').prop('checked',false);
	}
}


function bindChilk(){
	 //重新加载点击事件
	 $(".hide").on('click',function(){		
			if($(this).hasClass("active"))
			{
				$(this).removeClass("active")
				$(this).parent().find('ul').hide();		
			}
			else
			{
				$(this).addClass("active");
				$(this).parent().find('ul').show();		
				 
			}
	});	
	 
}


//修改
function update(){
	if(clickCount == 0){
		layer.msg("没有做任何修改");
	}else{
		var id = "";
		$("input[type='checkbox']:checked").each(function(i){  
		    var idOne = $(this).val();
		    id += idOne+"-";
		});
		if(id != ""){
			id = id.substring(0, id.length-1);
		}else{
			layer.msg("没有做任何修改");
			return ;
		}
		layer.confirm("确定修改？",function(){

			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:url+"insertUserRoleByModuleApp.htm",
				data :"role_id="+roleId+"&module_ids="+id+"&use_id="+crt_use_id,
			    dataType:"json", 
			    type:"post",
			    success:function(data){	   
			    	 layer.close(indexlayer); //关闭 loading 
			    	if(data.resultcode == "USR000"){
			    		layer.msg("菜单权限配置成功");
			    		ullirefreshData();
			    	}else{
			    		alert(data.desc);
			    	}
			    }
			})
		})
	}
}


</script>
</body>
</html>
