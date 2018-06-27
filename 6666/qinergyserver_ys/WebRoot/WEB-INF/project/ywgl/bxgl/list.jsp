<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
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
<title></title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
</head>
<body> 
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  		<input type="hidden" value="${user.id}" id="user_id" name="useId">
  		<div class="bge  pr8 pt10 pl8" style="padding-bottom:8px;">
  			<div class="bg-ff pb18 pl15 pt10 clr pl8">
  				<h4>报修任务</h4>
  			</div>
	  		<div class="bg-ff pl15 pt10 clr pl8">
		        <div class="query">
			          <div class="fl">
			          	<select class="fl quinput"  id="checkUser" >
				          		<!-- <option value="qxz">选择人员</option> -->
			          	</select>
			          	<select class="fl quinput ml15"  id="type">
			          		<option value="0">请选择创建状态</option>
			          		<option value="1">创建的</option>
			          		<option value="2">维修的</option>
			          		<option value="3">审核的</option>
			          	</select>
			          	<select class="fl quinput ml15"  id="check_sta">
			          		<option value="qxz">选择状态</option>
			          		<option value="1">未指派</option>
			          		<option value="2">未开始</option>
			          		<option value="3">执行中</option>
			          		<option value="4">待审核</option>
			          		<option value="5">审核通过</option>
			          		<option value="6">审核未通过</option>
			          	</select>
			          </div>
			           <div class="fl">
			          	 	<input type="button" value="查询" class="querybut">
			          </div>
			          <div class="fr">
			          		 <a class="queryicon layer XJRW_QX"  data-url="<%=basePath%>/commens/ywgl/bxgl/add.htm" data-title="新增报修"  ><i class="add"></i>新建</a>
			          </div>
		          </div>
	      	</div>
		  	<div  class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			            <th>序号</th>
			              <th>设备编号</th>
			              <th>状态</th>
			              <th>报修原因</th>
			              <th>创建人</th>
			              <th>维修人</th>
			              <th>审核人</th>
			              <th>是否更换</th>
			              <th>操作</th>
			            </tr>
			            <tbody id="datalist">
			             	 
			            </tbody>
			         </table>
			        </div>
			     <div class="tcdPageCode" id="tcdPageCode1"></div> 
			        
	          </div>
	          <div class="blank0"></div>
  			</div>
  </div>
   <!-- ./ viewFramework --> 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script>
var checkId = "";
$(function () {
	
	getQtYwry();
	
	getData();
	
    $(".querybut").click(function(){
    	getData();
    }) 
})
  
  
function getQtYwry(){
	var userId  = $("#user_id").val();
	$.ajax({
    	url:url+"getComPanyUserName.htm",
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				var sel = "" ;
   		    				if(userId == d.id){
   		    					sel = "selected" ;
   		    				}
   		    				htmls += "<option value='"+d.id+"' "+sel+">"+d.use_nam+"</option>";
   	    			 }
       			 } 
    			
   	    		$("#checkUser").html(htmls); 
    			
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}

var countAll = 0;
var currentPage  = 1;
function getData(param2){
	
	var curParam = "" ;
	var type = $("#type").val();
	var userId  = $("#user_id").val();
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		
		//可选择其他运维人员查询数据
		var checkUser  = $("#checkUser").val();
		if(checkUser != undefined && checkUser != "qxz"){ 
			curParam= "&&userId="+checkUser;
		}else{
			curParam= "&&userId="+userId;
		}
		
		if(type != ""  && type !=  undefined    ){
			curParam +="&&type="+type;
		}
		var check_sta = $("#check_sta").val();
		if(check_sta != ""  && check_sta !=  undefined && check_sta !=  'qxz' ){
			curParam +="&&check_sta="+check_sta;
		}
	}
	
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	var param = curParam + "&&currentPage="+currentPage;
	param = substringParam(param);
	console.log("param="+param)
	$.ajax({
    	url:url+"selRepair.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			countAll = data.totalPage;
				currentPage = data.currentPage;
    			 var htmls = "";
    			 if(data.data){
    				 if(data.data.length > 0 ){
        				 for(var i = 0; i< data.data.length ; i++){
    		    				var d =  data.data[i];
    		    				//序号
    		    				var a=i+1;
    		    				//操作栏对应功能
    		    				var layerA  = "";
    		    				//状态
    		    				var sta = "";
    		    				if(d.check_sta == 1 ){//未开始
    		    					sta = "未指派";
    		    				}else if(d.check_sta == 2 ){//未开始
    		    					sta = "未开始";
    		    				}else if(d.check_sta == 3 ){//进行中
    		    					sta = "进行中";
								}else if(d.check_sta == 4 ){//完成待审核
									sta = "完成待审核";
								}else if(d.check_sta == 5 ){//审核通过
									sta = "审核通过";
    		    				}else if(d.check_sta == 6 ){//审核驳回
    		    					sta = "审核驳回";
    		    				}
    		    				
    		    				if( userId != undefined && userId != ""   ){
    		    					//1.先判断是否不是当前用户的任务数据，如果是，则只显示查看权限，如果否，则判断对应的操作权限
    		    					if(userId != d.crt_use_id  && userId != d.repair_use_id && userId != d.check_use_id   ){
    		    						layerA = "<a  class='' data-url='<%=basePath%>commens/ywgl/bxgl/excuteQuery.htm?id="+d.id+"&routeId="+d.ornId+"' data-title='查看' data-width='750' data-height='500' onclick='chakan(this)'  href='javascript:void(0);' >查看</a>   " ;
    		    					}else{
    		    						//2.如果是当前用户的数据，判断状态是创建的、检修的、审核的或者多个的
    		    						//定义一个任务相关与人的状态的数组
    		    						var taskPersonStas = [];
    		    						if(d.crt_use_id && d.crt_use_id != undefined && d.crt_use_id == userId ){
    		    							taskPersonStas.push(1);//我发布的
    		    						}
    		    						if(d.repair_use_id && d.repair_use_id != undefined && d.repair_use_id == userId ){
    		    							taskPersonStas.push(2);//我维修的
    		    						}
    		    						if(d.check_use_id  && d.check_use_id  != undefined && d.check_use_id  == userId ){
    		    							taskPersonStas.push(3);//我审核的
    		    						}
    		    						layerA = "<a  class='' data-url='<%=basePath%>commens/ywgl/bxgl/excuteQuery.htm?id="+d.id+"&routeId="+d.ornId+"' data-title='查看' data-width='750' data-height='500' onclick='chakan(this)'  href='javascript:void(0);' >查看</a>   " ;
    		    						
    		    						
    		    						if(d.check_sta == 1 ){//未指派
    	    		    					if($.inArray(1, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer XGRW_QX' data-url='<%=basePath%>commens/ywgl/bxgl/edit.htm?id="+d.id+"' data-title='修改' data-width='750' data-height='400'  href='javascript:void(0);' >修改 </a> ";
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='SCRW_QX' href='javascript:void(0);' onclick='del("+d.id+")'>删除</a> " ;
    	    		    					}
    	    		    				}else if(d.check_sta == 2 ){//未开始
    	    		    					if($.inArray(2, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a   class='ZXRW_QX' href='javascript:void(0);' data-title='开始' data-width='750' data-height='500'  onclick='kaishi("+d.id+")' >开始</a>  " ;
    	    		    					}
    	    		    				
    	    		    					if($.inArray(1, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer XGRW_QX' data-url='<%=basePath%>commens/ywgl/bxgl/edit.htm?id="+d.id+"' data-title='修改' data-width='750' data-height='400'  href='javascript:void(0);' >修改 </a> ";
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='SCRW_QX' href='javascript:void(0);' onclick='del("+d.id+")'>删除</a> " ;
    	    		    					}
    	    		    				}else if(d.check_sta == 3 ){//进行中
    	    		    					if($.inArray(2, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='ZXRW_QX' data-url='<%=basePath%>commens/ywgl/bxgl/excute.htm?id="+d.id+"&routeId="+d.ornId+"' data-title='执行' data-width='900px' data-height='600' onclick='zhixing(this)' href='javascript:void(0);' >执行</a>  " ;
    	    		    					}
    									}else if(d.check_sta == 4 ){//完成待审核
    										<%-- if($.inArray(2, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='ZXRW_QX' data-url='<%=basePath%>commens/ywgl/bxgl/excute.htm?id="+d.id+"&routeId="+d.ornId+"' data-title='执行' data-width='900px' data-height='600'  onclick='zhixing(this)' href='javascript:void(0);' >执行</a>";
    	    		    					} --%>
    										if($.inArray(3, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='SHTG_QX' href='javascript:void(0);' onclick='shenhe("+d.id+")' >审核通过 </a> ";
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer SHBH_QX' data-url='<%=basePath%>commens/ywgl/bxgl/shenhe.htm?id="+d.id+"' data-title='审核' data-width='750' data-height='300'  href='javascript:void(0);' >驳回 </a>";
    	    		    					}
    									}else if(d.check_sta == 5 ){//审核通过
    	    		    				}else if(d.check_sta == 6 ){//审核驳回
    	    		    					if($.inArray(2, taskPersonStas) > -1){
    	    		    						layerA += "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='ZXRW_QX' data-url='<%=basePath%>commens/ywgl/bxgl/excute.htm?id="+d.id+"&routeId="+d.ornId+"' data-title='执行' data-width='900px' data-height='600'  onclick='zhixing(this)'  href='javascript:void(0);' >执行 </a> " ;
    	    		    					}
    	    		    				}
    		    					}
    		    					
    		    				}else{
    		    					layerA = "<a  class='' data-url='<%=basePath%>commens/ywgl/bxgl/excuteQuery.htm?id="+d.id+"&routeId="+d.ornId+"' data-title='查看' data-width='750' data-height='500' onclick='chakan(this)'  href='javascript:void(0);' >查看</a>   " ;
    		    				}
    		    				
    		    				
    		    				var if_change = d.if_change == 0 ?"否" : "是" ;
    		    				
    		    				 
    		    				htmls += "<tr>"+
    		    				"<td>"+a+"</td>"+
    		    					"<td>"+d.equ_num+"</td>"+
    				              	"<td>"+sta+"</td>"+
    				              	"<td>"+getIsNull(d.repair_reason)+"</td>"+
    				              	"<td>"+getIsNull(d.crt_nam)+"</td>"+
    				              	"<td>"+getIsNull(d.repair_nam)+"</td>"+
    				              	"<td>"+getIsNull(d.check_nam)+"</td>"+
    				              	"<td>"+getIsNull(if_change)+"</td>"+
    				              	"<td>"+layerA+"</td>"+
    				              	"</tr>";
    	    			 }
        				 
        				 $("#tcdPageCode1").createPage({
     				        pageCount:countAll,
     				        current:currentPage,
     				        backFn:function(p){
     				        	currentPage = p;
     				        	getData(curParam);
     				        }
     			    	});
        			 }else{
        					htmls +=  "<tr><td colspan='9'>暂无数据</td></tr>";
        					$("#tcdPageCode1").empty();
        			 }
       	    	 
    			 }else{
 					htmls +=  "<tr><td colspan='9'>暂无数据</td></tr>";
 					$("#tcdPageCode1").empty();
    			 }
    			
   	    		 $("#datalist").html(htmls);
   	    		$("#datalist").createQx();
   	    		layer.close(indexlayer);
			} else {
				layer.close(indexlayer);
               layer.alert(data.desc);
			}
    	}
    })
}
 

function del(id){
	layer.confirm("确定删除？",function(){

		$.ajax({
	    	url:url+"delRepair.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("删除成功");
	   	    		currentPage = 1 ;
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	})
} 

 
function  shenhe(id){
	var userId  = $("#user_id").val();
	layer.confirm("确定审核通过？",function(){
		$.ajax({
	    	url:url+"updRepairStaIfSuccess.htm",
	    	data : "id="+id+"&check_use_id="+userId+"&check_sta=5",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("审核成功");
	   	    		currentPage  = 1;
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	})
}

 
function  kaishi(id){
	var userId  = $("#user_id").val();
	layer.confirm("确定开始执行？",function(){
		$.ajax({
	    	url:url+"updRepairSta.htm",
	    	data : "id="+id+"&crt_id="+userId,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("开始执行成功,请记录数据");
	   	    		currentPage  = 1;
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	})
}
 
function  zhixing(a){
	var urlll = $(a).attr("data-url");
	layer.open({
		  type: 2,
		  skin: 'layer-class' ,
		  title:"执行",
		  shadeClose: false,
		  area: ['98%','90%'],
		  content:  urlll
	});
}

function  chakan(a){
	var urlll = $(a).attr("data-url");
	layer.open({
		  type: 2,
		  skin: 'layer-class' ,
		  title:"查看",
		  shadeClose: false,
		  area: ['98%','90%'],
		  content:  urlll
	});
}

</script>
</body>
</html>
 
