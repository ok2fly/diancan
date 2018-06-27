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
 <input type="hidden" id="userId" value="${user.id}" >
   <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
  <div class=viewFramework> 
     <div class="bg-ff pb18 pl15 pt10 clr pl8">
        <div class="query">
          <div class="fl">
          	<input type="text" value="" id="words"   placeholder="反馈/回复人，反馈/回复描述" class="fl quinput">
			<input type="text" value="" id="sta_tim" placeholder="请输入开始" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})">
			<input type="text" value="" id="end_tim" placeholder="请输入结束" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})">
          	
          	<input type="button" value="查询" class="querybut" onclick="currentPage  = 1;getData()">
          </div>
          <div class="fr mr15">
	          	<a class="queryicon layer XJYJFK_QX"  data-url="<%=basePath%>/commens/rcbg/yjfk/add.htm" data-title="新建"  data-height="200px;"><i class="add"></i>新建</a>
	          </div>
         
        </div>
      </div>
	  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
		            <tr>
		              <th>序号</th>
		              <th>反馈人姓名</th>
		              <th>意见反馈描述</th>
		              <th>反馈时间</th>
		              <th>回复人姓名</th>
		              <th>回复描述</th>
		              <th>回复时间</th>
		              <th>操作</th>
		              
		            </tr>
		            <tbody id="tab"></tbody>
		         </table>
	             <div class="tcdPageCode" id="tcdPageCode1"></div> 
		         
		        </div>
          </div>
          <div class="blank0"></div>
  </div>
   <!-- ./ viewFramework --> 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>
	$(function(){
		getData();
	})
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			sta_tim=$("#sta_tim").val();
			if(!isNull(sta_tim)){
				curParam+="&sta_tim="+sta_tim;
			}
			end_tim=$("#end_tim").val();
			if(!isNull(end_tim)){
				curParam+="&end_tim="+end_tim;
			}
			words=$("#words").val();
			if(!isNull(words)){
				curParam+="&words="+words;
			}
		}
		
		
		var param  = curParam + "&currentPage="+currentPage;	
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"selFeedBackAll.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				layer.close(indexlayer);
				if(data.resultcode=="USR000"){
					countAll = data.totalPage;
					currentPage = data.currentPage;
					var html="";
					if(data.data.length > 0){
						for(var i=0;i<data.data.length;i++){
							var d=data.data[i];
							html+="<tr>"+
							"<td style='width: 5%;'>"+(i+1)+"</td>"+
							"<td style='width: 5%;'>"+getIsNull(d.feedback_use_nam)+"</td>"+
							"<td >"+getIsNull(d.feedback_desc)+"</td>"+
							"<td style='width: 7%;'>"+getLocalDateAndTime(d.feedback_tim,2)+"</td>"+
							"<td style='width: 5%;'>"+getIsNull(d.reply_use_nam)+"</td>"+
							"<td >"+getIsNull(d.reply_desc)+"</td>"+
							"<td style='width: 7%;'>"+getLocalDateAndTime(d.reply_tim,2)+"</td>"+
							"<td style='width: 8%;'><a  class='layer HFYJ_QX'  data-url='<%=basePath%>commens/rcbg/yjfk/huifu.htm?id="+d.id+"' data-title='回复' data-height='200'  href='javascript:void(0);' >回复</a>"+
			              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='SCYJ_QX' href='javascript:void(0);' onclick='del("+d.id+")'>删除</a></td>"+
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
						html = "<tr><td colspan='8'>暂无数据</td></tr>";
						$("#tcdPageCode1").empty();
					}
					$("#tab").html(html);
					$("#tab").createQx();
				}else{
					layer.alert(data.desc);
				}
			}
		})
	}
	function del(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"delFeedBackById.htm",
		    	data : "id="+id,
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
</script>
</body>
</html>
 
