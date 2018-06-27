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
  	 <input type="hidden" value="${user.com_id}" id="com_id">
  	 <input type="hidden" id="ro_id" value="${user.rol_id}" >
  	 <input type="hidden" id="crt_use_id" value="${user.id}" >
  	 <input type="hidden" id="userId" value="${user.id}" >
  	   <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
     <div class="bg-ff pb18 pl15 pt10 clr pl8">
        <div class="query">
          <div class="fl">
          	<input type="text" value="" id="role_name" placeholder="请输入角色名称" class="fl quinput">
          	<input type="button" value="查询" onclick="currentPage  = 1;getData()" class="querybut">
          </div>
          <div class="fr mr15">
            <a class="queryicon layer XJJS_QX"  data-url="<%=basePath%>/commens/xtgl/jsgl/add.htm" data-title="添加角色"  ><i class="add"></i>添加角色</a>
          </div>
        </div>
      </div>
	  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto" >
				<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
		            <tr>
		              <th >序号</th>
		              <th >角色名称</th>
		              <th >角色标识</th>
		              <th >所属单位</th>
		              <th >备注</th>
		              <th >角色创建时间</th>
		              <th  >操作</th>
		            </tr>
		            <tbody id="datalist"></tbody>
		         </table>
	        </div>
	         <div class="tcdPageCode" id="tcdPageCode1"></div> 
          </div>
          <div class="blank0"></div>
  </div>
   <!-- ./ viewFramework --> 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>
var com_id  = $("#com_id").val();
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
		var role_name = $("#role_name").val();
		curParam = "com_id="+com_id;
		if(role_name != ""  && role_name != 'qb' ){
			curParam +="&&role_name="+role_name;
		}
		
	}
	
	var param  = curParam + "&currentPage="+currentPage;
	
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});

	//判断当前用户的角色id
	var  ro_id = $("#ro_id").val();
	console.log("param="+param)
	$.ajax({
    	url:url+"getBasRolInfo.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			countAll = data.totalPage;
				currentPage = data.currentPage;
    			 var htmls = "";
    			 if(data.data.length > 0 ){
    				 for(var i = 0; i< data.data.length ; i++){
		    				var d =  data.data[i];
		    				var j = "";
		    				if(d.id == 1){
		    					if(ro_id == 1){
		    						j = "<a  href='<%=basePath%>commens/xtgl/jsgl/edit.htm?id="+d.id+"' class='JSQXPZ_QX'>权限配置 </a>"+
		    						"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='<%=basePath%>commens/xtgl/jsgl/editApp.htm?id="+d.id+"' class='JSQXPZ_QX' >App权限配置 </a>"+
    								"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer XGJS_QX'  data-url='<%=basePath%>/commens/xtgl/jsgl/editOne.htm?id="+d.id+"' data-title='修改角色'  >修改</a>"+
				              		"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);'  class='SCJS_QX' onclick='del("+d.id+")'>删除</a></td>";
			    				}else{
			    					j = "";
			    				}
		    				}else{
		    					j = "<a  href='<%=basePath%>commens/xtgl/jsgl/edit.htm?id="+d.id+"' class='JSQXPZ_QX' >权限配置 </a>"+
		    						"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='<%=basePath%>commens/xtgl/jsgl/editApp.htm?id="+d.id+"' class='JSQXPZ_QX' >App权限配置 </a>"+
		    						"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer XGJS_QX'  data-url='<%=basePath%>/commens/xtgl/jsgl/editOne.htm?id="+d.id+"' data-title='修改角色'  >修改</a>"+
			              			"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);'  class='SCJS_QX' onclick='del("+d.id+")'>删除</a></td>";
		    				}
		    				htmls += "<tr>"+
				              	"<td>"+(i+1)+"</td>"+
				              	"<td>"+getIsNull(d.rol_nam)+"</td>"+
				              	"<td>"+getIsNull(d.rol_ide)+"</td>"+
				              	"<td>"+getIsNull(d.com_nam)+"</td>"+
				              	"<td>"+getIsNull(d.remark)+"</td>"+
				              	"<td>"+getLocalDateAndTime(d.bud_tim,1)+"</td>"+
				              	"<td>"+j+
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
	var use_id = $("#crt_use_id").val();
	layer.confirm("确定删除？",function(){
		$.ajax({
	    	url:url+"deleteUserRole.htm",
	    	data : "id="+id+"&use_id="+use_id,
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
</script>
</body>
</html>
 
