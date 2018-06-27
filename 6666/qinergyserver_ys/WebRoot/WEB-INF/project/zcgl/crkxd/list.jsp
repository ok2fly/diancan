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
<link rel="stylesheet" href="<%=basePath%>/js/jquery-treeview/jquery.treeview.css?pubVersion=201802070001" />
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" 	src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script >
$(function (){
	getData();
	
})

var countAll=0;
var currentPage = 1;
function getData(param2){
	
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			var cur_sta=$("#cur_sta").val();
			var com_id=$("#com_id").val();
			var words = $("#words").val();
			var start_tim = $("#start_tim").val();
			var end_tim = $("#end_tim").val();
			
			if(start_tim!=null && start_tim!= ''){
				curParam +="&&start_tim="+start_tim;
			}
			if(end_tim!=null && end_tim!= '' ){
				curParam +="&&end_tim="+end_tim;
			}
			if(com_id!=null){
				curParam +="&&com_id="+com_id;
			}
			
			if(words!=null){
				curParam +="&&words="+words;
			}
			if(cur_sta!=null && cur_sta != "" && cur_sta != undefined && cur_sta != "qxz"){
				curParam+="&cur_sta="+cur_sta;
			}
		}
	
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var param  = curParam+"&currentPage="+currentPage;
		$.ajax({
	    	url:url+"getInOutBroundList.htm",
	    	data : param ,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 countAll = data.totalPage;
						 currentPage = data.currentPage;
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				var sta = d.cur_sta == 1? "入库":d.cur_sta == 2 ?"出库":"无";
			    				htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
					              	"<td>"+(i+1)+"</td>"+
					              	"<td class='hid' title='"+getIsNull(d.ord_num)+"'>"+getIsNull(d.ord_num)+"</td>"+
					              	"<td>"+d.ass_nam+"</td>"+
					              	"<td>"+getIsNull(d.ass_num)+"</td>"+
					              	"<td>"+d.app_mod+"</td>"+
					              	"<td>"+getIsNull(d.unit)+"</td>"+
					              	"<td>"+d.cou+"</td>"+
					              	"<td>"+sta+"</td>"+
					              	"<td>"+getIsNull(d.use_nam)+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.crt_tim,2)+"</td>"+
					              	"<td class='hid' >"+getIsNull(d.remark)+"</td>"+
<%-- 					              	"<td><a  class='layer'  data-url='<%=basePath%>commens/zcgl/crkxd/query.htm?ord_num="+d.ord_num+"' data-title='详情' data-height='850px'  href='javascript:void(0);' >详情 </a></td>"+ 
 --%>					              	"</tr>";
		    			 }
	    				 $(".tcdPageCode").createPage({
	 				        pageCount:countAll,
	 				        current:currentPage,
	 				        backFn:function(p){
	 				        	currentPage = p ; 
	 				        	getData(curParam);
	 				        }
	 				    });
	    			 }else{
	    					htmls +=  "<tr><td colspan='11'>暂无数据</td></tr>";
	    					$(".tcdPageCode").empty();
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
	
	function del(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"delAssets.htm",
		    	data : "id="+id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			currentPage = 1; 
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
</head>
<body> 
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
		<input type="hidden" value="${user.com_id}" id="com_id" >
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
          		<input type="text"  id="start_tim" placeholder="请输入开始时间" class="fl quinput Wdate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'end_tim\')}'})">
	          	<span class="fl " >&nbsp;&nbsp;-</span>
          		<input type="text"  id="end_tim"   placeholder="请输入结束时间" style="margin-left:10px;" class="fl quinput  Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'start_tim\')}'})">
	          	<input type="text" value="" id="words" placeholder="出入库单号、经手人  " class="fl quinput" style="margin-left:10px;">
	          	<select value="" id="cur_sta" class="fl quinput"  style="margin-left:10px;">
	          		<option value="qxz">请选择出入库状态</option>
	          		<option value="1">入库</option>
	          		<option value="2">出库</option>
	          	</select>
	          	
	          	<input type="button" value="查询" class=" querybut" onclick="currentPage = 1 ; getData();">
	          </div>
	        </div>
	      </div>
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <!-- <th><input type="checkbox" onclick="selectCheck(this)"></th> -->
			              <th>序号</th>
			              <th>出入库单号</th>
			              <th>资产名称</th>
			              <th>资产编号</th>
			              <th>设备型号</th>
			              <th>计量单位</th>
			              <th>出入库数量</th>
			              <th>出入库状态</th>
			              <th>操作人</th>
			              <th>操作时间</th>
			              <th>备注</th>
			            </tr>
			            <tbody id="datalist"></tbody>
			         </table>
			        </div>
			        <div class="tcdPageCode"></div>
	          </div>
	          <div class="blank0"></div>
  </div>
  
   <!-- ./ viewFramework --> 
</body>
</html>
 
