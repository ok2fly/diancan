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
</head>
<body> 
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  <div class="rc-body">
  		<input type="hidden" value="${user.id}" id="use_id">
  		<input type="hidden" value="${user.com_id}" id="com_id">
  			<div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div>
		<div class="rc-right">
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
				<select value="" id="def_grade" class="fl quinput"  class="fl quinput" style="margin-left:8px;">
					<option value="">--缺陷等级--</option>
					<option value="1">一级</option>
					<option value="2">二级</option>
					<option value="3">三级</option>
				</select> 
				<select   id="def_sta"  class="fl quinput" style="margin-left:8px;">
						<option value="">--缺陷状态--</option>
						<option value="0">未消除</option>
						<option value="1">已消除</option>
						<option value="2">不处理</option> 
				</select>
				<input type="text" value="" id="words" placeholder="缺陷编号、描述" class="fl quinput" style="margin-left:8px;">
	          	<input type="button" value="查询" class="querybut">
	          </div>
	          <div class="fr mr15 mt15">
	            <a class="queryicon layer XJQX_QX"  data-url="<%=basePath%>commens/zcgl/qxgl/add.htm" data-title="新建缺陷"  ><i class="add"></i>新建缺陷</a>
	            <a class="queryicon layer XJLX_QX"  data-url="<%=basePath%>/commens/zcgl/qxgl/addType.htm" data-title="新建类型"  data-height="300px"  ><i class="add"></i>新建类型</a>
	          	<a class="queryicon ml15 XGLX_QX"    onclick="editType();" data-height="200px"  ><i class="edit"></i>修改类型</a>
	          	<a class="queryicon ml15 SCLX_QX"    onclick="delType();"   ><i class="del"></i>删除类型</a>
	          </div>
	        </div>
	      </div>
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <!-- <th><input type="checkbox" onclick="selectCheck(this)"></th> -->
			              <th>序号</th>
			              <th>缺陷编号</th>
			              <th>缺陷等级</th>
			              <th>缺陷状态</th>
			              <th>创建时间</th>
			              <th>创建人</th>
			              <th>备注</th>
			              <th>操作</th>
			            </tr>
			            <tbody id="datalist"></tbody>
			         </table>
			        </div>
			       <div class="tcdPageCode" id="tcdPageCode1"></div> 
	          </div>
	          <div class="blank0"></div>
	  </div>
  </div>
   <!-- ./ viewFramework --> 
   <script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" 	src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>

<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script type="text/javascript">
    var checkId = "";
	$(function () {
		getTypeData();
		
	    $(".querybut").click(function(){
	    	currentPage = 1 ;
	    	getData();
	    }) 
	})
	
	function getTypeData(){
		$.ajax({
	    	url:url+"getDefectTypList.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 htmls +=  "<li><span class='folder' onclick='checkTyp(\"qb\")'>全部</span>";
	    				 htmls +=  "<ul>";
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				htmls +=  "<li><span class='file' onclick='checkTyp("+d.id+")'>"+d.typ_nam+"</span></li>";
		    			 }
	    				 htmls +=  "</ul>";
		    			 htmls += "</li>";
	    			 }else{
	    					htmls +=  "<li><span class='file'>全部</span></li>";
	    			 }
	    			
	   	    		$("#navigation").html(htmls); 
	   	    	    $("#navigation").treeview();
	   	    	    
	    			
	   	    	 	$(".treeview span").on("click",function(){
			   	  		$(".treeview").find("span").css("background-color","transparent");
			   	  		$(this).css("background-color","#f0f0f0");
			   	  	});	
	   	    	 	if(data.data.length > 0){
		   	    	    $($("#navigation").find("ul").find("li")[0]).find("span").click();
	   	    	 	}

				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
	}
	
	function checkTyp(id){
		checkId = id ; 
		currentPage = 1 ;
		getData();
	}
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		var com_id=$("#com_id").val();
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			if(checkId != ""  && checkId != 'qb' ){
				curParam +="&&typ_id="+checkId;
			}
			if($("#words").val()!=""){
				curParam+="&&words="+$("#words").val();
			}
			if($("#def_sta").val()!=""){
				curParam+="&&def_sta="+$("#def_sta").val();
			}
			if($("#def_grade").val()!=""){
				curParam+="&&def_grade="+$("#def_grade").val();
			}
		}
		
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var param = curParam + "&currentPage="+currentPage;
		$.ajax({
	    	url:url+"getDefectList.htm",
	    	data : param+"&&com_id="+com_id,
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
			    				var lev = d.def_grade == 1 ? "一级" :  d.def_grade == 2 ? "二级" :  d.def_grade == 3 ? "三级" : "无" ;
			    				var sta = d.def_sta == 0 ? "未消除" :  d.def_sta == 1 ? "已消除" :  d.def_sta == 2 ? "不处理" : "无" ;
			    				htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
			    					"<td>"+(i+1)+"</td>"+
			    					"<td>"+d.def_num+"</td>"+
					              	"<td>"+lev+"</td>"+
					              	"<td>"+sta+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.crt_tim,2)+"</td>"+
					              	"<td>"+d.crt_use+"</td>"+
					              	"<td>"+d.remark+"</td>"+
					              	"<td><a  class='layer CKWJ_QX'  data-url='<%=basePath%>commens/zcgl/qxgl/query.htm?def_num="+d.def_num+"' data-title='查看文件' data-height='400px' data-width='600px'  href='javascript:void(0);' >查看文件 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer XGQX_QX'  data-url='<%=basePath%>commens/zcgl/qxgl/edit.htm?def_num="+d.def_num+"' data-title='修改' data-height='400px'  href='javascript:void(0);' >修改 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='SCQX_QX' href='javascript:void(0);' onclick='del(&quot;"+d.id+"&quot;,&quot;"+d.def_num+"&quot;)'>删除</a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer SCWJ_QX'  data-url='<%=basePath%>commens/zcgl/qxgl/file.htm?id="+d.id+"&def_num="+d.def_num+"' data-title='上传文件' data-height='300px'  href='javascript:void(0);' >上传文件</a></td>"+
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
	    					htmls +=  "<tr><td colspan='8'>暂无数据</td></tr>";
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
	
	function del(id,def_num){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"delDefectInfo.htm",
		    	data : "id="+id+"&&def_num="+def_num,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			currentPage = 1 ;
		   	    		layer.alert("删除成功");
		   	    		getData();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		})
	}
	
	function editType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待修改的类型");
		}else{
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"修改类型",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>/commens/zcgl/qxgl/editType.htm?id="+checkId    
			});
			
		} 
	}	
	function delType(){
		var use_id = $("#use_id").val();
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待删除的类型");
		}else{
			layer.confirm("确定删除？",function(){
				$.ajax({
			    	url:url+"delDefectTyp.htm",
			    	data : "id="+checkId+"&use_id="+use_id,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			    			currentPage = 1 ;
			   	    		layer.alert("删除类型成功");
			   	    		getTypeData();
						} else {
			               layer.alert(data.desc);
						}
			    	}
			    })
			})
		} 
	}
	
	
	</script>
</body>
</html>
 
