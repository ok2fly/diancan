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
  				<h4>报废管理</h4>
  			</div>
	  		<div class="bg-ff pl15 pt10 clr pl8">
		        <div class="query">
			          <div class="fl">
			          	<select class="fl quinput"  id="type">
			          		<option value="1">我创建的</option>
			          		<option value="2">我第一次审核</option>
			          		<option value="3">我第二次审核</option>
			          	</select>
			          	<select class="fl quinput ml15"  id="check_sta">
			          		<option value="qxz">选择状态</option>
			          		<option value="0">未开始</option>
			          		<option value="1">开始未审核</option>
			          		<option value="2">第一次审核通过</option>
			          		<option value="3">第一次审核驳回</option>
			          		<option value="4">第二次审核通过</option>
			          		<option value="5">第二次审核驳回</option>
			          	</select>
			          </div>
			          <div class="fl">
			          	 	<input type="button" value="查询" class="querybut">
			          </div>
			          <div class="fr">
			          		 <a class="queryicon layer XJRW_QX"  data-url="<%=basePath%>/commens/ywgl/bfgl/add.htm" data-title="新增报废"  ><i class="add"></i>新建</a>
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
			              <th>报废原因</th>
			              <th>处理意见</th>
			              <th>第一次审核人</th>
			              <th>第一次驳回原因</th>
			              <th>第二次审核人</th>
			              <th>第二次驳回原因</th>
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
	getData();
	
    $(".querybut").click(function(){
    	getData();
    }) 
})
  
var countAll = 0;
var currentPage  = 1;
function getData(param2){

	var curParam = "" ;
	var type = $("#type").val();
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		var userId  = $("#user_id").val();
		curParam = "&&userId="+userId;
		
		if(type != ""  && type !=  undefined  && type !=  'qxz' ){
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

	var param  = curParam + "&&currentPage="+currentPage;
	param = substringParam(param);
	console.log("param="+param)
	$.ajax({
    	url:url+"selScrap.htm",
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
    		    				var a=i+1;
    		    				var layerA  = "";
    		    				var sta = "";
    		    				if(d.check_sta == 0 ){//未开始
    		    					sta = "未开始";
    		    					if(type == 1 ){
    		    						layerA += "<a  class='layer XGRW_QX' data-url='<%=basePath%>commens/ywgl/bfgl/edit.htm?id="+d.id+"' data-title='修改' data-width='700px' data-height='400px'  href='javascript:void(0);' >修改 </a> <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='SCRW_QX' href='javascript:void(0);' onclick='del("+d.id+")'>删除</a> " ;
    		    					}
    		    				}else if(d.check_sta == 1 ){//开始未审核
    		    					sta = "开始未审核";
    		    					if(type == 2 ){
    		    						layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a><span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='layer SH_QX' data-url='<%=basePath%>commens/ywgl/bfgl/shenhe.htm?id="+d.id+"' data-title='审核' data-width='700px' data-height='300px'  href='javascript:void(0);' >审核 </a>";
    		    					}
    		    					if(type == 1 ){
    		    						layerA += "<a  class='layer XGRW_QX' data-url='<%=basePath%>commens/ywgl/bfgl/edit.htm?id="+d.id+"' data-title='修改' data-width='700px' data-height='400px'  href='javascript:void(0);' >修改 </a> <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='SCRW_QX'  href='javascript:void(0);' onclick='del("+d.id+")'>删除</a> " ;
    		    					}
								}else if(d.check_sta == 2 ){//第一次审核通过
									sta = "第一次审核通过";
									if(type == 3 ){
										layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a><span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='layer SH_QX' data-url='<%=basePath%>commens/ywgl/bfgl/shenhe2.htm?id="+d.id+"' data-title='审核' data-width='700px' data-height='300px'  href='javascript:void(0);' >审核 </a>";
    		    					}
									if(type == 1 ){
										layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a>";
    		    					}
									if(type == 2 ){
										layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a>";
    		    					}
								}else if(d.check_sta == 3 ){//第一次审核驳回
									sta = "第一次审核驳回";
									if(type == 1 ){
										layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a><span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='layer XGRW_QX' data-url='<%=basePath%>commens/ywgl/bfgl/edit.htm?id="+d.id+"' data-title='修改' data-width='700px' data-height='400px'  href='javascript:void(0);' >重新提交 </a> <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='SCRW_QX'  href='javascript:void(0);' onclick='del("+d.id+")'>删除</a> " ;
    		    					}
									if(type == 2 ){
										layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a>";
    		    					}
    		    				}else if(d.check_sta == 4 ){//第二次审核通过
    		    					sta = "第二次审核通过";
   		    						layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a>";
    		    				}else if(d.check_sta == 5 ){//第二次审核驳回
    		    					sta = "第二次审核驳回";
    		    					if(type == 1 ){
    		    						layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a><span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='layer XGRW_QX' data-url='<%=basePath%>commens/ywgl/bfgl/edit.htm?id="+d.id+"' data-title='修改' data-width='700px' data-height='400px'  href='javascript:void(0);' >重新提交 </a> <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>";
    		    						layerA += "<a  class='SCRW_QX'  href='javascript:void(0);' onclick='del("+d.id+")'>删除</a> " ;
    		    					}
    		    					if(type == 2 ){
    		    						layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a>";
    		    					}
    		    					if(type == 3 ){
    		    						layerA += "<a  class='layer' data-url='<%=basePath%>commens/ywgl/bfgl/query.htm?id="+d.id+"' data-title='查看' data-width='700px' data-height='300px'  href='javascript:void(0);' >查看 </a>";
    		    					}
    		    				}
    		    				
    		    				htmls += "<tr>"+
    		    				"<td>"+a+"</td>"+
    		    					"<td>"+d.equ_num+"</td>"+
    				              	"<td>"+sta+"</td>"+
    				              	"<td>"+getIsNull(d.scrap_resaon)+"</td>"+
    				              	"<td>"+getIsNull(d.scrap_opinion)+"</td>"+
    				              	"<td>"+getIsNull(d.one_check_nam)+"</td>"+
    				              	"<td>"+getIsNull(d.one_check_detail)+"</td>"+
    				              	"<td>"+getIsNull(d.two_check_nam)+"</td>"+
    				              	"<td>"+getIsNull(d.two_check_detail)+"</td>"+
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
        					htmls +=  "<tr><td colspan='10'>暂无数据</td></tr>";
        					$("#tcdPageCode1").empty();
        			 }
       	    	 
    			 }else{
 					htmls +=  "<tr><td colspan='10'>暂无数据</td></tr>";
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
	    	url:url+"delScrap.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("删除成功");
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	})
} 

 
 
</script>
</body>
</html>
 
