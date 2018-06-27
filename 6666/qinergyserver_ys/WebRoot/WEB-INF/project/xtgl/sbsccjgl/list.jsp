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
<input type="hidden" value="${user.id}" id="crt_use_id" name="crt_use_id">
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  <!-- <div class="rc-body">
		 <div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div> 
		<div class="rc-right"> -->
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
	          	<input type="text" value="" id="info" placeholder="请输入厂家名称" class="fl quinput">
	          	<input type="button" value="查询" onclick="currentPage  = 1; getData();" class="querybut">
	          </div>
	          <div class="fr mr15">
	            <a class="queryicon layer XJSCCJ_QX"  data-url="<%=basePath%>/commens/xtgl/sbsccjgl/add.htm" data-title="新增厂家信息"  ><i class="add"></i>添加厂家</a>
	          <%-- 	<a class="queryicon layer"  data-url="<%=basePath%>/commens/xtgl/sbsccjgl/addType.htm" data-title="新建类型"  data-height="300px"  ><i class="add"></i>添加厂家类型</a>
	          	<a class="queryicon ml15"    onclick="editType();" data-height="300px"  ><i class="edit"></i>修改类型</a>
	          	<a class="queryicon ml15"    onclick="delType();"   ><i class="del"></i>删除类型</a> --%>
	          </div>
	        </div>
	      </div>
		  <div class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto"  style="overflow-x:scroll">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list zjjg">
			            <tr>
			              <th>序号</th>
			              <th>生产厂商</th>
			              <th>厂家地址</th>
			              <th>联系人</th>
			              <th>联系电话</th>
			              <th>操作</th>
			            </tr>
			            <tbody id="datalist"></tbody>
			         </table>
			        </div>
			        <div class="tcdPageCode" id="tcdPageCode1"></div>
	          </div>
	          <div class="blank0"></div>
	  </div>
  <!-- </div> -->
   <!-- ./ viewFramework --> 
   <script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" 	src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript">
    var checkId = "";
	$(function () {
		
		 //设置宽高
   		var ScreenWidth  = (document.documentElement.clientWidth);  
   		ScreenWidth = ScreenWidth;
   		
   		//设置地图高
   		$(".wauto").css("width",ScreenWidth-20);
   		var tab = $('.table-list');
   		var td = $(tab.find('tr')[0]).find('th');
   		if(td.length * 90 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
   			tab[0].width = td.length *90;
   		} 
   		
   		
    	getData();   		
		/* getTypeData();
	    $(".querybut").click(function(){
	    	getData();
	    })  */
	})
	
	
	/* function getTypeData(){
		$.ajax({
	    	url:url+"getBasManTypAll.htm",
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
		$("#").val();
		getData();
	} */
	
	
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			var info = $("#info").val();
			if(checkId != ""  && checkId != 'qb' ){
				curParam +="&&man_typ_id="+checkId;
			}
			
			if(info != ""  && info != 'qb' ){
				curParam +="&&man_nam="+info;
			}
		}
		
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		var param =  curParam + "&&currentPage="+currentPage;
		param = substringParam(param);
		console.log("param="+param)
		$.ajax({
	    	url:url+"getManInf.htm",
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
			    				var sta = d.man_sta == 1 ?"可用":"不可用";
			    				var a=i+1;
			    				htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
					              	"<td>"+a+"</td>"+
					              	"<td>"+getIsNull(d.man_nam)+"</td>"+
					              	"<td>"+d.pro_nam+d.cit_nam+d.are_nam+d.man_add+"</td>"+
			    					"<td>"+getIsNull(d.man_cot)+"</td>"+
					              	"<td>"+getIsNull(d.man_mob)+"</td>"+
					              	"<td><a  class='layer XGSCCJ_QX'  data-url='<%=basePath%>commens/xtgl/sbsccjgl/edit.htm?id="+d.id+"' data-title='修改' data-height='500px'  href='javascript:void(0);' >修改 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer'  data-url='<%=basePath%>commens/xtgl/sbsccjgl/detal.htm?id="+d.id+"' data-title='详细' data-height='500px'  href='javascript:void(0);' >详细</a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='SCSCCJ_QX' onclick='del("+d.id+")'>删除</a>"+
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
	    					htmls +=  "<tr><td colspan='6'>暂无数据</td></tr>";
	    					$("#tcdPageCode1").empty();
	    			 }
	    			
	   	    		$("#datalist").html(htmls); 
	   	    		
	   	    		layer.close(indexlayer);
	   	    		
	   	    		$("#datalist").createQx();
		   	    	//设置宽高
	   	    		var ScreenWidth  = (document.documentElement.clientWidth);  
	   	    		ScreenWidth = ScreenWidth;
	   	    		//设置地图高
	   	    		$(".wauto").css("width",ScreenWidth-20);
	   	    		var tab = $('.table-list');
	   	    		var td = $(tab.find('tr')[1]).find('td');
	   	    		if(td.length * 150 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
	   	    			tab[0].width = td.length *150;
	   	    		}
	   	    		
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
		    	url:url+"delMan.htm",
		    	data : "man_id="+id,
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
				  content: "<%=basePath%>/commens/xtgl/sbsccjgl/editType.htm?id="+checkId   //iframe的url
			});
			
		} 
	}	
	function delType(){
		var crt_use_id = $("#crt_use_id").val();
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待删除的知识库类型");
		}else{
			layer.confirm("确定删除？",function(){
				$.ajax({
			    	url:url+"delManTyp.htm",
			    	data : "man_typ_id="+checkId+"&use_id="+crt_use_id,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
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
 
