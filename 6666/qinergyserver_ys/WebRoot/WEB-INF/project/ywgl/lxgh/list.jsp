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
	  		<div class="bg-ff pl15 pt10 clr pl8">
		        <div class="query">
			          <div class="fl">
			          	<select  class="fl quinput" id="lxType">
			          		<option value="1">检修路线</option>
			          		<option value="2">巡视路线</option>
			          	</select>
			          	<input type="text" value=""  id="route_name" placeholder="请输入路线名称" class="fl quinput ml15">
			          </div>
			          <div class="fl">
			          	<input type="text"  id="sta_tim" placeholder="请输入开始时间" class="fl quinput ml15 Wdate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'end_tim\')}'})">
			          	<span class="fl ml5 ">&nbsp;&nbsp;-</span>
			          	<input type="text"  id="end_tim"   placeholder="请输入结束时间" class="fl quinput ml15 Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'sta_tim\')}'})">
			          		<input type="button" value="查询" class="querybut">
			          </div>
			          <div class="fr">
			           	 <a class="queryicon XJLX_QX"  data-url="<%=basePath%>/commens/ywgl/lxgh/add.htm" data-title="新增线路"  onclick="add(this);" ><i class="add"></i>新建</a>
			          </div>
		         </div>
	      	</div>
		  	<div  class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <th>序号</th>
			              <th>路线名称</th>
			              <th>创建人</th>
			              <th>创建时间</th>
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
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		var userId  = $("#user_id").val();
		curParam = "&&id="+userId;
		var route_name = $("#route_name").val();
		if(route_name != ""  && route_name !=  undefined  ){
			curParam +="&&route_name="+route_name;
		}
		var sta_tim = $("#sta_tim").val();
		if(sta_tim != ""  && sta_tim !=  undefined  ){
			curParam +="&&sta_tim="+sta_tim;
		}
		var end_tim = $("#end_tim").val();
		if(end_tim != ""  && end_tim !=  undefined  ){
			curParam +="&&end_tim="+end_tim;
		}
		
	}
	
	var lxType = $("#lxType").val();
	curParam +="&&type="+lxType;
	var param  = curParam +  "&&currentPage="+currentPage;
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	param = substringParam(param);
	console.log("param="+param)
	
	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});

	$.ajax({
    	url:url+"getTourOrOverHaul.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		layer.close(indexlayer); //关闭 loading 
    		if (data.resultcode=="USR000") {
    			countAll = data.totalPage;
				currentPage = data.currentPage;
    			 var htmls = "";
    			 if(data.data){
    				 if(data.data.length > 0 ){
        				 for(var i = 0; i< data.data.length ; i++){
    		    				var d =  data.data[i];
    		    				var a=i+1;
    		    				
    		    				htmls += "<tr>"+
    		    					"<td>"+a+"</td>"+
    				              	"<td>"+d.route_name+"</td>"+
    				              	"<td>"+d.use_nam+"</td>"+
    				              	"<td>"+getLocalDateAndTime(d.crate_time,2)+"</td>"+
    				              	"<td><a  class='' data-url='<%=basePath%>commens/ywgl/lxgh/query.htm?id="+d.id+"&type="+lxType+"' data-title='查看详情'  onclick='query(this)' href='javascript:void(0);' >查看详情 </a>"+
    				              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);'  class='SCLX_QX' onclick='del("+d.id+","+lxType+")'>删除</a>"+
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
        					htmls +=  "<tr><td colspan='5'>暂无数据</td></tr>";
        					$("#tcdPageCode1").empty();
        			 }
       	    	 
    			 }else{
 					htmls +=  "<tr><td colspan='5'>暂无数据</td></tr>";
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
  
function del(id,type){
	layer.confirm("是否确定删除？删除路线后，该路线下的运维任务也会一并删除，请谨慎操作！",function(){
		$.ajax({
	    	url:url+"delRouteOrOverhaul.htm",
	    	data : "id="+id+"&type="+type,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("删除成功");
	   	    		currentPage  = 1;
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	})
}
 
function  add(a){
	var urlll = $(a).attr("data-url");
	layer.open({
		  type: 2,
		  skin: 'layer-class' ,
		  title:"新建路线",
		  shadeClose: false,
		  area: ['98%','90%'],
		  content:  urlll
	});
}


function  query(a){
	var urlll = $(a).attr("data-url");
	layer.open({
		  type: 2,
		  skin: 'layer-class' ,
		  title:"路线详情",
		  shadeClose: false,
		  area: ['98%','90%'],
		  content:  urlll
	});
}


</script>
</body>
</html>
 
