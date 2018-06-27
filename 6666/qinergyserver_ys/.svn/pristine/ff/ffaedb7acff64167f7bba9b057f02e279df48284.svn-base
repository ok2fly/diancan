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
<title>物资出入库</title>
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
		<input type="hidden" id="com_id" value="${user.com_id}">
		<div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div>
		<div class="rc-right">
		     <div class="bg-ff pb18 pl15 pt10 clr pl8">
		        <div class="query">
		          <div class="fl">
		          	<input type="text" value="" id="words" placeholder="物资名称、规格型号、物资编号" class="fl quinput" >
		          	<input type="button" value="查询" class="querybut" onclick="currentPage = 1 ; getData();">
		          </div>
		          <div class="fr mr15">
		          	<a class="queryicon layer XZWZ_QX"  data-url="<%=basePath%>commens/zcgl/wzrk/add.htm" data-title="新建" data-height='400px' ><i class="add"></i>新增物资</a>
		          	<a class="queryicon layer XJLX_QX"  data-url="<%=basePath%>/commens/zcgl/wztz/addType.htm" data-title="新建类型"  data-height="300px"  ><i class="add"></i>新建类型</a>
		          	<a class="queryicon ml15 XGLX_QX"    onclick="editType();" data-height="200px"  ><i class="edit"></i>修改类型</a>
		          	<a class="queryicon ml15 SCLX_QX"    onclick="delType();"   ><i class="del"></i>删除类型</a>
		          </div>
		        </div>
		      </div>
			  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
					<div class="clr wauto"  >
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
				            <tr>
				              <!-- <th><input type="checkbox" onclick="selectCheck(this)"></th> -->
				              <th>序号</th>
				              <th>资产名称</th>
				              <th>资产编号</th>
				              <th>设备型号</th>
				              <th>生产厂家</th>
				              <th>计量单位</th>
				              <th>库存数量</th>
				              <th>库存告警数量</th>
				              <th>备注</th>
				              <th>操作</th>
				            </tr>
				            <tbody id="datalist"></tbody>
				         </table>
			        </div>
	   				<div class="tcdPageCode"></div>
	          </div>
	          <div class="blank0"></div>
          </div>
       </div>
  </div>
   <!-- ./ viewFramework --> 
   <script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" 	src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>

<script type="text/javascript">
    var checkId = "";
	$(function () {
		
   		
   	 	getTypeData();
		getData();
	})
	
	 
	function getTypeData(){
		$.ajax({
	    	url:url+"getAssetsTypList.htm",
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
	    					htmls +=  "<li><span class='file'>全部类型</span></li>";
	    			 }
	    			
	   	    		$("#navigation").html(htmls); 
	   	    	    $("#navigation").treeview();
	    			
	   	    	 	$(".treeview span").on("click",function(){
			   	  		$(".treeview").find("span").css("background-color","transparent");
			   	  		$(this).css("background-color","#f0f0f0");
			   	  	});	
	   	    	 	if(data.data.length > 0){
		   	    	    $($("#navigation").find(".file")[0]).click();
	   	    	 	}
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
	}
	
	function checkTyp(id){
		checkId = id ; 
		currentPage = 1;
		getData();
	}
	
	var countAll=0;
	var currentPage = 1;
	function getData(param2){
		var com_id=$("#com_id").val();
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			
			if(checkId !=null && checkId != "" && checkId != undefined   && checkId != 'qb'  ){
				curParam +="&&typ_id="+checkId;
			}
			
			var words = $("#words").val();
			if(!isNull(words)){
				curParam +="&&words="+words;
			}
		}
		
		
		var param = curParam + "&currentPage="+currentPage;
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 
		$.ajax({
	    	url:url+"getAssetsList.htm",
	    	data : param+="&com_id="+com_id,
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
			    				var is_scrap = d.is_scrap == 0 ?"是" : d.is_scrap == 1 ? "否" : "无" ;
			    				var colVal = "";
			    				var ck = "";
			    				if(d.stock_num==d.ala_num || d.stock_num<d.ala_num){
			    					colVal = 'color:red';
			    				}
			    				
			    				if(d.stock_num>0){
			    					ck = "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer CK_QX'  data-url='<%=basePath%>commens/zcgl/wzrk/outbround.htm?ass_num="+d.ass_num+"' data-title='出库' data-height='400px'  href='javascript:void(0);' >出库 </a>";
			    				}
			    				htmls += "<tr style='"+colVal+"'>"+
			    					//"<td style='"+colVal+"'>"+((currentPage-1)*10+i+1)+"</td>"+
			    					"<td style='"+colVal+"'>"+(i+1)+"</td>"+
					              	"<td style='"+colVal+"'>"+d.ass_nam+"</td>"+
					              	"<td style='"+colVal+"'>"+d.ass_num+"</td>"+
					              	"<td style='"+colVal+"'>"+d.app_mod+"</td>"+
					              	"<td style='"+colVal+"'>"+d.man_nam+"</td>"+
					              	"<td style='"+colVal+"'>"+getIsNull(d.unit)+"</td>"+
					              	"<td style='"+colVal+"'>"+getIsZero(d.stock_num)+"</td>"+
					            	"<td style='"+colVal+"'>"+getIsZero(d.ala_num)+"</td>"+
					              	"<td style='"+colVal+"'>"+d.remark+"</td>"+
					              	"<td><a  class='layer RK_QX'  data-url='<%=basePath%>commens/zcgl/wzrk/inbround.htm?ass_num="+d.ass_num+"' data-title='入库'   href='javascript:void(0);' >入库 </a>"+ck+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer XGWZ_QX'  data-url='<%=basePath%>commens/zcgl/wzrk/edit.htm?ass_num="+d.ass_num+"' data-title='修改' data-height='400px'  href='javascript:void(0);' >修改 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='SCWZ_QX' href='javascript:void(0);' onclick='del(&quot;"+d.ass_num+"&quot;)'>删除</a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer'  data-url='<%=basePath%>commens/zcgl/wzrk/detal.htm?ass_num="+d.ass_num+"' data-title='查看详情' data-height='400px'  href='javascript:void(0);' >查看详情</a></td>"+
					              	"</tr>";
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
	    					htmls +=  "<tr><td colspan='10'>暂无数据</td></tr>";
	    					$(".tcdPageCode").empty();
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
	
	function del(ass_num){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"delAssets.htm",
		    	data : "ass_num="+ass_num,
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
				  content: "<%=basePath%>/commens/zcgl/wztz/editType.htm?id="+checkId   //iframe的url
			});
			
		} 
	}	
	function delType(){
		
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待删除的类型");
		}else{
			var com_id = $("#com_id").val();
			layer.confirm("确定删除？",function(){
				$.ajax({
			    	url:url+"delAssetsTyp.htm",
			    	data : "id="+checkId + "&com_id="+com_id,
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
 
