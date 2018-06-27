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
<script type="text/javascript">
    var checkId = "";
	$(function () {
		getTyp();
   		getData();
		
	    $(".querybut").click(function(){
	    	currentPage = 1 ;
	    	getData();
	    }) 
	})
	
	function getTyp(){
		$.ajax({
			url:url+"getAssetsTypList.htm",
			data:"",
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.resultcode=="USR000"){
					var htmls=  "<option value='qxz'>请选择资产类型</option>"; 
					if(data.data.length>0){
						for(var i=0;i<data.data.length;i++){
							var d=data.data[i];
							 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
						}
					}
					$("#typ_id").html(htmls);
				}else{
					layer.alert(data.desc);
				}
				
			}
		})
	}
	
	
	function getTypeData(){
		$.ajax({
	    	url:url+"getAssetsTypList.htm",
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
			
			var typ_id=$("#typ_id").val();
			if(typ_id !=null && typ_id != "" && typ_id != undefined && typ_id != "qxz" ){
				curParam +="&&typ_id="+typ_id;
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
		param = substringParam(param);
		console.log("param="+param)
		 
		$.ajax({
	    	url:url+"getAssetsListByTyp.htm",
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
			    				htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
					              	"<td>"+(i+1)+"</td>"+
					              	"<td>"+d.ass_nam+"</td>"+
					              	"<td>"+d.ass_num+"</td>"+
					              	"<td>"+d.app_mod+"</td>"+
					              	"<td>"+d.man_nam+"</td>"+
					              	"<td>"+getIsNull(d.unit)+"</td>"+
					              	"<td>"+getIsZero(d.stock_num)+"</td>"+
					              	"<td>"+getIsZero(d.ala_num)+"</td>"+
					              	"<td>"+d.remark+"</td>"+
					              	/* 	"<td>"+d.ware_nam+"</td>"+
					              	"<td>"+getIsZero(d.price)+"</td>"+
					              	"<td>"+getIsZero(d.size)+"</td>"+
					              	"<td>"+getIsZero(d.weight)+"</td>"+
					              	"<td>"+getIsZero(d.inp_elc)+"</td>"+
					              	"<td>"+getIsZero(d.inp_vol)+"</td>"+
					              	"<td>"+getIsZero(d.rtd_pow)+"</td>"+
					              	"<td>"+getIsZero(d.out_elc)+"</td>"+
					              	"<td>"+getIsZero(d.out_vol)+"</td>"+
					              	"<td>"+getIsZero(d.work_temp)+"</td>"+
					              	"<td>"+getIsZero(d.altitude)+"</td>"+
					              	"<td>"+getIsZero(d.prtc_grade)+"</td>"+
					              	"<td>"+getIsZero(d.res_val)+"</td>"+
					              	"<td>"+getIsZero(d.dep_fix_num_year)+"</td>"+
					              	"<td>"+getIsZero(d.mon_dep)+"</td>"+
					              	"<td>"+getIsZero(d.acc_dep)+"</td>"+
					              	"<td>"+getIsZero(is_scrap)+"</td>"+*/
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
	    					htmls +=  "<tr><td colspan='9'>暂无数据</td></tr>";
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
	
	
	</script>
</head>
<body> 
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  	<input type="hidden" id="com_id" value="${user.com_id}">
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
	          	<select value="" id="typ_id" placeholder="物资名称、规格型号、物资编号" class="fl quinput" style="margin-left:5px;"></select>
	          	<input type="text" value="" id="words" placeholder="物资名称、规格型号、物资编号" class="fl quinput" style="margin-left:10px;">
	          	<input type="button" value="查询" class="querybut">
	          </div>
	         <%--  <div class="fr mr15">
	          	<a class="queryicon layer"  data-url="<%=basePath%>/commens/zcgl/wztz/addType.htm" data-title="新建类型"  data-height="300px"  ><i class="add"></i>新建类型</a>
	          	<a class="queryicon ml15"    onclick="editType();" data-height="200px"  ><i class="edit"></i>修改类型</a>
	          	<a class="queryicon ml15"    onclick="delType();"   ><i class="del"></i>删除类型</a>
	          </div> --%>
	        </div>
	      </div>
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <th>序号</th>
			              <th>资产名称</th>
			              <th>资产编号</th>
			              <th>设备型号</th>
			              <th>生产厂家</th>
			              <th>计量单位</th>
			              <th>库存数量</th>
			              <th>库存告警数量</th>
			              <th>备注</th>
			              
			            <!--   <th>所属仓库</th>
			              <th>价格</th>
			              <th>尺寸</th>
			              <th>重量</th>
			              <th>输入电流</th>
			              <th>输入电压</th>
			              <th>额定容量</th>
			              <th>输出电流</th>
			              <th>输出电压</th>
			              <th>工作温度</th>
			              <th>海拔</th>
			              <th>防护等级</th>
			              <th>残值率</th>
			              <th>折旧年限</th>
			              <th>月折旧额</th>
			              <th>累计折旧额</th>
			              <th>是否报废</th> -->
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
 
