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
  <input type="hidden" id="type" >
  <input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  <div class="rc-body">
		<div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div>
		<div class="rc-right">
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
	          	<input type="text" value="" id="info" placeholder="请输入知识库名称" class="fl quinput">
	          	<input type="button" value="查询" class="querybut" >
	          </div>
	          <div class="fr mr15">
	            <a class="queryicon XJZSK_QX"   onclick="add()" data-title="新建"  ><i class="add"></i>新建知识库</a>
	          	<a class="queryicon layer XJLX_QX"  data-url="<%=basePath%>/commens/zsk/addType.htm" data-title="新建类型"  data-height="200px;"><i class="add"></i>新建类型</a>
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
			              <th>名称</th>
			              <th>描述</th>
			              <th>创建人</th>
			              <th>创建时间</th>
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
	    	currentPage = 1;
	    	getData();
	    }) 
	})
	
	function getTypeData(){
		$.ajax({
	    	url:url+"KnwType.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 htmls +=  "<li><span class='folder' onclick='checkTyp('qb')'>全部</span>";
	    				 htmls +=  "<ul>";
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				htmls +=  "<li><span class='file' onclick='checkTyp("+d.id+")'>"+d.knw_typ_nam+"</span></li>";
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
		$("#type").val(checkId);
		currentPage  = 1;
		getData();
	}
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			if(checkId != ""  && checkId != 'qb' ){
				curParam +="&&id="+checkId;
			}
			
			var info = $("#info").val();
			if(!isNull(info)){
				curParam +="&&info="+info;
			}
			
		}
		
		var param = curParam +"&currentPage="+currentPage;
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		param = substringParam(param);
		console.log("param="+param)
		$.ajax({
	    	url:url+"knwByTypeId.htm",
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
			    				htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
					              	"<td>"+(i+1)+"</td>"+
					              	"<td>"+d.knw_nam+"</td>"+
					              	"<td>"+d.knw_dec+"</td>"+
					              	"<td>"+d.use_nam+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.crt_tim,1)+"</td>"+
					              	"<td><a  class='layer CKWJ_QX'  data-url='<%=basePath%>commens/zsk/query.htm?id="+d.id+"' data-title='查看文件'   href='javascript:void(0);' >查看文件 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer XGZSK_QX'  data-url='<%=basePath%>commens/zsk/edit.htm?id="+d.id+"' data-title='修改' data-height='300px'  href='javascript:void(0);' >修改 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='SCZSK_QX' onclick='del("+d.id+")'>删除</a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer SCWJ_QX'  data-url='<%=basePath%>commens/zsk/editFile.htm?id="+d.id+"' data-title='上传文件' data-height='300px'  href='javascript:void(0);' >上传文件</a></td>"+
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
	
	function del(checkId){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"removeKnw.htm",
		    	data : "id="+checkId,
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
			layer.alert("请选择待修改的知识库类型");
		}else{
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"修改类型",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>/commens/zsk/editType.htm?id="+checkId   //iframe的url
			});
			
		} 
	}	
	function delType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待删除的知识库类型");
		}else{
			layer.confirm("确定删除？",function(){
				$.ajax({
			    	url:url+"removeKnwType.htm",
			    	data : "id="+checkId,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			    			currentPage  = 1;
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
	function add(){
		var type=$("#type").val();
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title:"新建",
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>commens/zsk/add.htm?type="+type  //iframe的url
		});
	}
	</script>
</body>
</html>
 
