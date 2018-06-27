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
<title>巡视计划</title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
</head>
<body> 
 <!-- viewFramework   -->
  <div class=viewFramework> 
  		<input type="hidden" value="${user.id}"  id="userId" name="userId">
  		<input type="hidden" value="${user.id}" id="user_id" name="useId">
  		<input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  		<input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
  		<div class="bge  pr8 pt10 pl8" style="padding-bottom:8px;">
  			<div class="bg-ff pb18 pl15 pt10 clr pl8">
  				<h4>巡视计划</h4>
  			</div>
	  		<div class="bg-ff pl15 pt10 clr pl8">
		        <div class="query">
		          <div class="fl">
		          	<select class="fl quinput" id="run_flat">
		          		<option value="qxz">请选择</option>
		          		<option value="1">执行</option>
						<option value="2">停止</option>
		          	</select>
		          </div>
		          <div class="fl">
		          		<input type="button" value="查询" class="querybut">
		          </div>
		         </div>
		         <div class="query pt10"> 
			          <div class="fr mr15">
			            <a class="queryicon layer XZXSJH_QX"  data-url="<%=basePath%>/commens/jhgl/xsjh/add.htm" data-title="新增计划"  ><i class="add"></i>添加巡视计划</a>
			          	<a class="queryicon DC_QX" onclick="download1()"><i class="exp"></i>导出</a>
			          </div>
		        </div>
	      	</div>
		  	<div  class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <th>序号</th>
			              <th>计划名称</th>
			              <th>巡视路线</th>
			              <th>计划开始时间</th>
			              <th>下次巡视时间</th>
			              <th>巡视周期</th>
			              <th>巡视工期(日)</th>
			              <th>计划结束时间</th>
			              <th>巡视状态</th>
			              <th>任务派发人</th>
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

<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>
var checkId = "";
$(function () {
	getData();
	
    $(".querybut").click(function(){
    	currentPage  = 1;
    	getData();
    }) 
})
  
	var countAll = 0;
var currentPage  = 1;
function getData(param2){
	
	var curParam = "" ;
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		var userId  = $("#user_id").val();
		curParam = "&&id="+userId;
		var run_flat = $("#run_flat").val();
		if(run_flat != ""  && run_flat !=  undefined && run_flat !=  'qxz'  ){
			curParam +="&&run_flat="+run_flat;
		}
	}
	
	
	
	
	var param  = curParam + "&&currentPage="+currentPage;
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	param = substringParam(param);
	console.log("param="+param);
	$.ajax({
    	url:url+"selTourPlan.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			countAll = data.totalPage;
				currentPage = data.currentPage;
    			 var htmls = "";
    			 if(data.data){
    				 console.log("data="+JSON.stringify(data));
    				 if(data.data.length > 0 ){
        				 for(var i = 0; i< data.data.length ; i++){
    		    				var d =  data.data[i];
    		    				var sta = d.run_flat == 1  ? "执行" : d.run_flat == 2  ?   "停止" : "无";
    		    				var ss = ""
    		    				if(d.run_flat  == 2){
    		    					ss = "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='KSZX_QX' onclick='excute("+d.id+")'>开始执行</a>";
    		    				} 
    		    				if(d.run_flat  == 1){
    		    					ss = "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='TZ_QX' onclick='stop("+d.id+")'>停止</a>";
    		    				}  
    		    				var dw = d.day_type == 1 ? "月" : "天" ; 
    		    				
    		    				if(d.next_time == "计划已过期"){
    		    					ss = "";
    		    				}
    		    				htmls += "<tr>"+
    		    					"<td>"+((currentPage-1)*25+i+1)+"</td>"+
    		    					"<td>"+getIsNull(d.tour_plan_name)+"</td>"+
    				              	"<td>"+getIsNull(d.trn_nam)+"</td>"+
    				              	"<td>"+getLocalDateAndTime(d.first_time,2)+"</td>"+
    				              	"<td>"+d.next_time+"</td>"+
    				              	"<td>"+getIsNull2(d.frequency)+dw+"</td>"+
    				              	"<td>"+d.plan_tour_time+"</td>"+
    				              	"<td>"+getLocalDateAndTime(d.end_time,2)+"</td>"+
    				              	"<td>"+sta+"</td>"+
    				              	"<td>"+getIsNull(d.crt_nam)+"</td>"+
    				              	"<td><a  class='layer XGXSJH_QX' data-url='<%=basePath%>commens/jhgl/xsjh/edit.htm?id="+d.id+"' data-title='修改' data-height='350px'  href='javascript:void(0);' >修改 </a>"+
    				              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='SCXSJH_QX' onclick='del("+d.id+")'>删除</a>"+ss+
    				              	"</tr>";
    		     			       
    	    			 }
        			 }else{
        					htmls +=  "<tr><td colspan='10'>暂无数据</td></tr>";
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
    			
   	    		$("#datalist").html(htmls); 
   	    		layer.close(indexlayer);
   	    		$("#datalist").createQx();
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
	    	url:url+"delTourPlan.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			currentPage  = 1;
	   	    		layer.alert("删除成功");
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	 })
}
function excute(id){
	layer.confirm("确定开始执行？",function(){
		$.ajax({
	    	url:url+"updTourPlanRunFlat.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			currentPage  = 1;
	   	    		getData();				
	   	    		layer.alert("执行成功");
   	    		} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	 })
}
function stop(id){
	layer.confirm("确定停止？",function(){
		 $.ajax({
	    	url:url+"stopTourPlan.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			currentPage  = 1;
	   	    		getData();				
	   	    		layer.alert("停止计划成功");
   	    		} else {
	               layer.alert(data.desc);
				}
	    	}
	    })  
	 })
}

function download1(){
	 
	var  layerC = layer.confirm("确定下载？",function(){
		
		//location.href = url + "TourPlanExport.htm"; 
		
		$.ajax({
			url :url+"TourPlanExport.htm",
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.resultcode && data.resultcode != "USER000") {
					layer.alert(data.desc);
					return ;
				} else {
					location.href = url + "TourPlanExport.htm";
				}
				layer.close(layerC)
			},
			error : function(){
				location.href = url + "TourPlanExport.htm";
				layer.close(layerC)
			}
		})  
		
	})
}
 

</script>
</body>
</html>
 
