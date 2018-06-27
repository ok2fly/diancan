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
 <!-- viewFramework   -->
  <div class=viewFramework> 
  		<input type="hidden" value="${user.id}" id="user_id" name="useId">
  		  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
  		<div class="bge  pr8 pt10 pl8" style="padding-bottom:8px;">
	  		<div class="bg-ff pl15 pt10 clr pl8">
		        <div class="query">
			          <div class="fl">
			          	<input type="text"  id="sta_tim" placeholder="请输入开始时间" class="fl quinput ml15 Wdate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'end_tim\')}'})">
			          	<span class="fl ml5 ">&nbsp;&nbsp;-</span>
			          	<input type="text"  id="end_tim"   placeholder="请输入结束时间" class="fl quinput ml15 Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'sta_tim\')}'})">
		          		<input type="button" value="查询" class="querybut" onclick="currentPage  = 1;getData();">
			          </div>
		         </div>
		         <%-- <div class="query pt10"> 
			          <div class="fr mr15">
			           	 <a class="queryicon layer"  data-url="<%=basePath%>/commens/ywgl/lxgh/add.htm" data-title="新增线路"  data-height="570px" data-width="850px"><i class="add"></i>新建</a>
			          </div>
	        	  </div> --%>
	      	</div>
		  	<div  class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <th>序号</th>
			              <th>操作人</th>
			              <th>操作类型</th>
			              <th>操作时间</th>
			              <th>操作功能</th>
			              <th>操作内容</th>
			              <th>是否操作成功</th>
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
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script>
var checkId = "";
$(function () {
	getData();
})
  
var countAll = 0;
var currentPage  = 1;
function getData(param2){
	
	var curParam = "" ;
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		 
		 
		var sta_tim = $("#sta_tim").val();
		if(sta_tim != ""  && sta_tim !=  undefined  ){
			curParam +="&&sta_tim="+sta_tim;
		} 
		var end_tim = $("#end_tim").val();
		if(end_tim != ""  && end_tim !=  undefined  ){
			curParam +="&&end_tim="+end_tim;
		}
		
	}
	
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	
	var param = curParam + "&&currentPage="+currentPage;
	
	param = substringParam(param);
	console.log("param="+param)
	
	$.ajax({
    	url:url+"getOptLogLst.htm",
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
    		    				var is_suc=d.is_suc==0?"不成功":d.is_suc==1?"成功":"无";
    		    				htmls += "<tr>"+
    		    					"<td>"+a+"</td>"+
    				              	"<td>"+getIsNull(d.use_nam)+"</td>"+
    				              	"<td>"+getIsNull(d.opt_typ)+"</td>"+
    		    					"<td>"+getLocalDateAndTime(d.opt_tim,1)+"</td>"+
    				              	"<td>"+getIsNull(d.opt_fut)+"</td>"+
    				              	"<td>"+getIsNull(d.opt_ctn)+"</td>"+
    				              	"<td>"+is_suc+"</td>"+
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
        					htmls +=  "<tr><td colspan='7'>暂无数据</td></tr>";
        					$("#tcdPageCode1").empty();
        			 }
       	    	 
    			 }else{
 					htmls +=  "<tr><td colspan='7'>暂无数据</td></tr>";
    			 }
    			
   	    		$("#datalist").html(htmls); 

   	    		layer.close(indexlayer);
			} else {

				layer.close(indexlayer);
               layer.alert(data.desc);
			}
    	}
    })
 
}
  

</script>
</body>
</html>
 
