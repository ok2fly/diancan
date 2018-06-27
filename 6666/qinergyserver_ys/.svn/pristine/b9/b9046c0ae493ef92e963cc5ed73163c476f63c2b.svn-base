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
    height: 30px;
    line-height: 30px;
    font-weight: normal;
    padding: 10px 0 10px 60px;
     margin-top: 1px;   
      border-bottom: 1px solid #f2f2f2;  
}
.ative24{
     padding: 10px 0 10px 120px;
      height: 30px;
       line-height: 30px;
        border-bottom: 1px solid #f2f2f2;
         margin-top: 2px;     
}
.ative25{
      padding: 10px 0 10px 160px;
      height: 30px;
      line-height: 30px;
      border-bottom: 1px solid #f2f2f2;
       margin-top: 2px;     
}
.ative26{
      padding: 10px 0 10px 200px;
      height: 30px;
      line-height: 30px;
      border-bottom: 1px solid #f2f2f2;
       margin-top: 2px;     
}
.ulli2{     
    color: #333;
    font-weight: normal;
    height: 30px;
    line-height: 30px;
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
    left: 430px;
    top: 19px;
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
		 <input id="id" type="hidden" value="${id}">
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
				<a href="<%=basePath%>commens/rcbg/khgl/list.htm" target="_self" class="querybut">返回</a>
			 </div>
	      </div>
    </div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script>
var id = "";
var crt_use_id = "";
var clickCount = 0 ;
$(function(){
	id = $("#id").val();
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
		url:url+"getUseAndPwsInfLst.htm",
		data :"use_id="+parseInt(crt_use_id)+"&alt_use_id="+id,
	    dataType:"json", 
	    type:"post",
	    success:function(data){	   
	    	layer.close(indexlayer);  //关闭 loading 
	    	if(data.resultcode == "USR000"){
	    		 var ulli=data.data;	 
	    		 var htmls="";
	    		 $(ulli).each(function(i,datas){
	    			 var checkHtmlOne = "";
	    			 htmls += ('<li><div class="ative23"><input type="checkbox" '+checkHtmlOne+' value="'+datas.id+'" onclick="xzAllqx(this)"    class="inputCheck">'+datas.com_nam+'</div>');
	    			 if (datas.comLev2Lst.length>0) {
	    				 htmls += "<ul>";	    				
	    				 $(datas.comLev2Lst).each(function(j,datat){
	    					var checkHtmlTwo = "";
	    					htmls += '<li ><div class="ative24"><input type="checkbox" '+checkHtmlTwo+' value="'+datat.id+'" name="ative24"  onclick="xzAllqx1(this)" class="inputCheck">'+datat.com_nam+'</div>';
	    				    if (datat.comLev3Lst.length>0) {
	    				    	htmls += '<ul>';
								$(datat.comLev3Lst).each(function(t,data2){
									 var checkHtmlThree = ""; 
									 htmls+=('<li ><div class="ative25"><input type="checkbox" '+checkHtmlThree+'  value="'+data2.id+'" onclick="xzAllqx2(this)"  name="ative25" class="inputCheck">'+data2.com_nam+'</div>')
									 if (data2.pwsInfLst.length>0) {
			    				    	htmls += '<i class="hide active"></i><ul>';
										$(data2.pwsInfLst).each(function(t,data4){
											 var checkHtmlFour = ""; 
											 if(data4.is_dpl == 1){
												 checkHtmlFour="checked";
					    	    			 } 
											htmls+=('<li ><div class="ative26"><input type="checkbox" '+checkHtmlFour+'  value="'+data4.id+'" onclick="xzAllqx3()"  name="ative26" class="inputCheck">'+data4.pws_nam+'</div></li>')
										})
										htmls+=('</ul></li>')
			    				    }
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
	$(key).parent().parent().find(".ative26").children('input').prop('checked',$(key).prop("checked"));	
}	

//第二层
function xzAllqx1(key){
		clickCount++;
	    var douberst=[];
		$(key).parent().parent().find(".ative25").children('input').prop('checked',$(key).prop("checked"));		
		$(key).parent().parent().find(".ative26").children('input').prop('checked',$(key).prop("checked"));
		
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
function xzAllqx2(key){
		clickCount++;
	    var douberst=[];
		$(key).parent().parent().find(".ative26").children('input').prop('checked',$(key).prop("checked"));
		
		//循环所有三级的菜单
		$(key).parent().parent().parent().find(".ative25").each(function(i3){
			//给每个三级菜单的input赋选中或未选中的值
			douberst[i3]=$(this).children('input').prop('checked');
			//判断三级菜单的input是否选中,如果选中判断二级菜单选中 /* ，否则判断二级菜单不选中 TODO */
			if ($(this).children('input').prop('checked')) {
				$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',true);
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
			$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',true);
		}else{
			$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',false);
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
//第三层
function xzAllqx3(key){
	clickCount++;
	var doubers=[],doubers2=[],doubers3=[];
	//找到该节点的一级菜单
	var $kest=$(key).parent().parent().parent().parent().parent().parent().find(".ative23");
	//循环所有三级菜单
	$(key).parent().parent().parent().find(".ative26").each(function(i){
		//给每个三个菜单的选中不选中状态赋值
		doubers3[i]=$(this).children('input').prop('checked')
		//如果三级菜单选中则二级菜单选中，/* 否则二级菜单不选中TODO */
		if ($(this).children('input').prop('checked')==true) {			
			$(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',true);
		}
		/* else{			 			
			 $(key).parent().parent().parent().parent().find(".ative24").children('input').prop('checked',false);		     
		} */
	})
	//循环所有三级菜单判断是否有未选中的，/* 如有则把二级菜单不选中 TODO */ 如果全部未选中则判断二级菜单不选中
	var isCheckedFour = false 
	for (var is = 0; is < doubers3.length; is++) {
		if (doubers3[is]==true) {
			isCheckedFour = true;
		}		
	}	
	if(isCheckedFour){
		$(key).parent().parent().parent().parent().find(".ative26").children('input').prop('checked',true);			
	}else{
		$(key).parent().parent().parent().parent().find(".ative26").children('input').prop('checked',false);			
	}
	
	
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


//修改
function update(){
	/* if(clickCount == 0){
		layer.msg("没有做任何修改");
	}else{
	} */
		var ids = "";
		$("input[type='checkbox']:checked").each(function(i){  
			if($(this).parent().hasClass("ative26")){
			    var idOne = $(this).val();
			    ids += idOne+"-";
			}
		});
		if(ids != ""){
			ids = ids.substring(0, ids.length-1);
		}
		/* else{
			layer.msg("没有做任何修改");
			return ;
		} */
		layer.confirm("确定修改？",function(){
			console.log("ids=="+ids)
			$.ajax({
				url:url+"insertUseAndPwsInf.htm",
				data :"use_id="+crt_use_id+"&alt_use_id="+id+"&pws_ids="+ids,
			    dataType:"json", 
			    type:"post",
			    success:function(data){	   
			    	if(data.resultcode == "USR000"){
			    		layer.msg("电站权限配置成功");
			    		ullirefreshData();
			    	}else{
			    		alert(data.desc);
			    	}
			    }
			})
		}) 
}


</script>
</body>
</html>
