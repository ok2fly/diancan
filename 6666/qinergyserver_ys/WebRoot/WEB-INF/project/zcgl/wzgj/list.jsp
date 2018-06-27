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
  	<input type="hidden" id="com_id" value="${user.com_id}">
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
	          	<input type="text" value="" id="words" placeholder="物资名称、规格型号、物资编号" class="fl quinput">
	          	<input type="button" value="查询" class="querybut" onclick="currentPage = 1 ; getData();">
	          </div>
	        </div>
	      </div>
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
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
			              <!--  <th>备注</th>
			              <th>所属仓库</th>
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
			              <th>操作</th>
			            </tr>
			            <tbody id="datalist"></tbody>
			         </table>
			        </div>
			        <div class="tcdPageCode"></div>
	          </div>
	          <div class="blank0"></div>
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
    	getData();
	})
	
	var countAll=0;
	var currentPage = 1;

	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			var com_id=$("#com_id").val();
			if(checkId != ""  && checkId != 'qb' ){
				curParam +="&&typ_id="+checkId;
			}
			
			var words = $("#words").val();
			if(!isNull(words)){
				curParam +="&&words="+words;
			}
		}
	
		 
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 
		var param  = curParam + "&currentPage="+currentPage;
		
		param = substringParam(param);
		
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
					              	/*
					              	"<td>"+d.ware_nam+"</td>"+
					              	"<td>"+getIsZero(d.price)+"</td>"+
					              	"<td>"+getIsZero(d.siz)+"</td>"+
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
					              	"<td>"+getIsNull(is_scrap)+"</td>"+*/
					              	"<td><a  class='layer SZGJKC_QX'  data-url='<%=basePath%>commens/zcgl/wzgj/query.htm?ass_num="+d.ass_num+"' data-title='设置告警库存'   href='javascript:void(0);' >设置告警库存 </a></td>"+
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
	    					htmls +=  "<tr><td colspan='11'>暂无数据</td></tr>";
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
	</script>
</body>
</html>
 
