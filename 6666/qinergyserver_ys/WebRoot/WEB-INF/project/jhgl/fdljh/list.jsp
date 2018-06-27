<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发电量计划</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
</head>
<body>
	<div class="rc-body">
		<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
		<div class="w100 h670">
			<div class="bg-ff pl15 pt10 clr pl8">
				<div class="query">
					<div class="fl">
						 <select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
           	   			 	<option value="qxz">请选择一级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:10px;" onchange="setCompanyThree(this.value);">
           	   			 	<option value="qxz">请选择二级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:10px;" onchange="setPws(this.value);">
           	   			 	<option value="qxz">请选择三级公司</option>
           	   			 </select>
           	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:10px;"  >
           	   			 	<option value="qxz">请选择电站</option>
           	   			 </select>
						 <input type="button" value="查询" onclick="currentPage  = 1;getData()" class="querybut">
					</div>
				
					<div class="fr mr15">
						<a  class="queryicon layer XZJH_QX"  data-url="<%=basePath%>/commens/jhgl/fdljh/add.htm" data-title="新增发电量计划" data-height="300px" ><i class="add"></i>新增计划</a>
					</div>
				</div>
			</div>
			<div class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list">
						 <tr>
							<th>序号</th>
							<th>电站</th>
							<th>计划电量(kWh)</th>
							<th>计划时间</th>
							<!-- <th>创建时间</th> -->
							<th>操作</th>
						</tr>
						<tbody id="datalist">
							<tr><td colspan='5'>暂无数据</td></tr>
						</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<div class="blank0"></div>
		</div>
	</div>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jhCheckCom.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>

	<script>
	$(function(){
		//getData();
		getCompanyOne();
	})
	
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		var param="";
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			var sbpId = $("#companyPws").val();
			if(sbpId != '' && sbpId != undefined && sbpId != 'qxz'){
				curParam  += "sbpId="+sbpId;
			}
		}
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		
		param += curParam+"&currentPage="+currentPage;
		
		$.ajax({
			url:url+"selPvPlanPower.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					countAll = data.totalPage;
					currentPage = data.currentPage;
					var htmls="";
					if(data.data.length > 0){
						for(var i=0;i<data.data.length;i++){
							var d=data.data[i];
							htmls+="<tr>"+
							"<td>"+((currentPage-1)*25+i+1)+"</td>"+
							"<td>"+getIsNull(d.pws_nam)+"</td>"+
							"<td>"+getIsNull2(d.plan_power)+"</td>"+
							"<td>"+getIsNull(d.plan_tim).split("-")[0]+"-"+getIsNull(d.plan_tim).split("-")[1]+"</td>"+
							/* "<td>"+getIsNull(getLocalDateAndTime(d.crt_tim,1))+"</td>"+ */
							"<td><a  href='javascript:void(0);' class='SCJH_QX' onclick='del("+d.id+")'>删除</a>"+
			              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer XGJH_QX'  data-height='300px'  data-url='<%=basePath%>commens/jhgl/fdljh/edit.htm?id="+d.id+"' data-title='修改' data-height='200px;'  href='javascript:void(0);' >修改 </a>"+
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
						htmls+= '<tr><td colspan="9">暂无数据</td></tr>';
						$("#tcdPageCode1").empty();
					}
					
					$("#datalist").html(htmls);
					layer.close(indexlayer);
					$("#datalist").createQx();
				}else{

					layer.close(indexlayer);
					layer.alert(data.desc);
				}
				
			}
		})
	}
		function del(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
				url:url+"delPvPlanPowerById.htm",
				type:"post",
				data:"id="+id,
				dataType:"json",
				success:function(data){
					if (data.resultcode=="USR000") {
						currentPage  = 1;
						layer.msg("删除成功");
						getData();
					} else {
						layer.alert("删除失败")
					}
				}
			})
		});
	}
	</script>
</body>
</html>