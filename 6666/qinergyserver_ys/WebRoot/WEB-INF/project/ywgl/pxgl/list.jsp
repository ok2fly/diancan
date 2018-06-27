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
  <div class="rc-body"> 
  		<input type="hidden" value="${user.id}" id="use_id" name="use_id">
  		<input type="hidden" value="${user.com_id}" id="com_id" name="com_id">
  		
  		<div class="w100 h670" >
  			
	  		<div class="bg-ff pl15 pt10 clr pl8">
		        <div class="query">
		          <div class="fl">
		          	<input type="text" id="start_tim" class="fl quinput popinput Wdate" placeholder="开始时间" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})" style="margin-left:8px;">
					<input type="text" id="end_tim" class="fl quinput popinput Wdate" placeholder="结束时间" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'start_tim\')}'})" style="margin-left:8px;">
					<input type="text" value="" id="words" placeholder="主讲人、被培训对象" class="fl quinput" style="margin-left:8px;">
		          </div>
		          <div class="fl">
		          		<input type="button" value="查询" class="querybut">
		          </div>
		          <div class="fr mr15">
		           	  <a class="queryicon layer"  data-url="<%=basePath%>/commens/ywgl/pxgl/add.htm" data-title="新增任务"  ><i class="add"></i>新建</a>
		          </div>
		   		</div>
	      	</div>
		  	<div  class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			            	<th>序号</th>
			              <th>培训类型</th>
			              <th>培训编号</th>
			              <th>培训状态</th>
			              <th>培训内容</th>
			              <th>主讲人</th>
			              <th>被培训对象</th>
			              <th>开始时间</th>
			              <th>结束时间</th>
			              <th>培训地点</th>
			              <th>备注</th>
			              <th>公司</th>
			              <th>创建用户</th>
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
function getData(){
	//var use_id  = $("#use_id").val();
	var com_id=$("#com_id").val();
	var param ="com_id="+com_id;
	if($("#words").val()!=""){
		param+="&&words="+$("#words").val();
	}
	if($("#start_tim").val()!=""){
		param+="&&start_tim="+$("#start_tim").val();
	}
	if($("#end_tim").val()!=""){
		param+="&&end_tim="+$("#end_tim").val();
	}
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});


	param += "&&currentPage="+currentPage;
	$.ajax({
    	url:url+"getTrainingList.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			countAll = data.totalPage;
				currentPage = data.currentPage;
    			var htmls="";
    			if(data.data.length > 0 ){
	    			for(var i=0;i<data.data.length;i++){
	    				var d=data.data[i];
	    				var a=i+1;
	    				var tra_sta = d.tra_sta == 0 ?"未开始" : d.tra_sta == 1 ? "进行中" :d.tra_sta == 2 ? "已结束" : "无" ;
	    				htmls+="<tr>"+
	    				"<td>"+a+"</td>"+
	    				"<td>"+getIsNull(d.typ_nam)+"</td>"+
	    				"<td>"+getIsNull(d.tra_num)+"</td>"+
	    				"<td>"+getIsNull(tra_sta)+"</td>"+
	    				"<td>"+getIsNull(d.tra_cont)+"</td>"+
	    				"<td>"+getIsNull(d.tra_speaker)+"</td>"+
	    				"<td>"+getIsNull(d.tra_target)+"</td>"+
	    				"<td>"+getLocalDateAndTime(d.begin_tim,2)+"</td>"+
	    				"<td>"+getLocalDateAndTime(d.finish_tim,2)+"</td>"+
	    				"<td>"+getIsNull(d.tra_place)+"</td>"+
	    				"<td>"+getIsNull(d.remark)+"</td>"+
	    				"<td>"+getIsNull(d.sub_com_id)+"</td>"+
	    				"<td>"+getIsNull(d.crt_use_id)+"</td>"+
	    				"<td>"+getLocalDateAndTime(d.crt_tim,2)+"</td>"+
		              	"<td><a class='layer'  data-url='<%=basePath%>commens/ywgl/pxgl/edit.htm?id="+d.id+"' data-title='修改' data-height='400px'  href='javascript:void(0);' >修改 </a>"+
		              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' onclick='del("+d.id+")'>删除</a>";
		              	if(d.tra_sta==0){
			              	htmls+="<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' onclick='sta("+d.id+")'>开始</a>";
		              	}
		              	htmls+= "</td></tr>";
	    			}
	    			
	    			 $("#tcdPageCode1").createPage({
					        pageCount:countAll,
					        current:currentPage,
					        backFn:function(p){
					        	currentPage = p;
					        	getData();
					        }
				    	});
    			}else{
    				htmls = "<tr><td colspan='6'>暂无数据</td></tr>";
    				 $("#tcdPageCode1").empty();
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
 
function sta(id){
		var mod_use_id=$("use_id").val();
		layer.confirm("确定开始？",function(){
			$.ajax({
		    	url:url+"executeTraining.htm",
		    	data : "id="+id+"&mod_use_id="+mod_use_id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		   	    		layer.alert("开始成功");
		   	    		getData();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
	    })
	
} 

function del(id){
	layer.confirm("确定删除？",function(){

		$.ajax({
	    	url:url+"delTrainingById.htm",
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
 
