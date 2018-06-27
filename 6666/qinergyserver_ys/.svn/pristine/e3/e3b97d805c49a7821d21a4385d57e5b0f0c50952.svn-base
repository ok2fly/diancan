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
<title>采购计划</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
</head>
<body>
  <input type="hidden" id="type" >
  <input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
	<div class="rc-body">
		<div class="w100 h670">
			<div class="bg-ff pl15 pt10 clr pl8">
				<div class="query">
					<div class="fl">
						<select value="" id="is_finish"  class="fl quinput">
							<option value="">--是否完成--</option>
							<option value="0">完成</option>
							<option value="1">未完成</option>
							
						</select> 
						<input type="text" value="" id="words" placeholder="创建人/采购人" class="fl quinput" style="margin-left:10px;"> 
						<input type="text" value="" id="sta_tim" placeholder="请输入开始时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})"> 
						<input type="text" value="" id="end_tim" placeholder="请输入结束时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim\')}'})"> 
						<input type="button" value="查询" onclick=" currentPage  = 1;getData()" class="querybut">
					</div>
				
					<div class="fr mr15">
						<a  class="queryicon TJJH_QX"  onclick="add()" data-title="添加计划"  ><i class="add"></i>添加</a>
					</div>
				</div>
			</div>
			<div class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list">
						 <tr>
							<th>序号</th>
							<th>采购编号</th>
							<th>采购时间</th>
							<th>是否完成</th>
							<th>计划采购人</th>
							<th>创建人</th>
							<th>创建时间</th>
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
	function add(){
		var type=$("#type").val();
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title:"新建",
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>commens/jhgl/wzcgjh/add.htm?type="+type  //iframe的url
		});
	}
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			if($("#is_finish").val()!=""){
				curParam+="&&is_finish="+$("#is_finish").val();
			}
			if($("#sta_tim").val()!=""){
				curParam+="&&sta_tim="+$("#sta_tim").val();
			}
			if($("#end_tim").val()!=""){
				curParam+="&&end_tim="+$("#end_tim").val();
			}
			if($("#words").val()!=""){
				curParam+="&&words="+$("#words").val();
			}
			
		}
		
		
		var param = curParam+"&currentPage="+currentPage;
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
 
		$.ajax({
			url:url+"getAssetsPurPlanList.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					countAll = data.totalPage;
					currentPage = data.currentPage;
					var htmls="";
					if(data.data != null){
						for(var i=0;i<data.data.length;i++){
							var d=data.data[i];
		    				var is_finish = d.is_finish == 0 ?"完成" : d.is_finish == 1 ? "未完成" : "无" ;
							htmls+="<tr>"+
							"<td>"+((currentPage-1)*25+i+1)+"</td>"+
							"<td>"+d.plan_num+"</td>"+
							"<td>"+getLocalDateAndTime(d.pur_tim,2)+"</td>"+
							"<td>"+getIsNull(is_finish)+"</td>"+
							"<td>"+getIsNull(d.plan_use)+"</td>"+
							"<td>"+getIsNull(d.crt_use)+"</td>"+
							"<td>"+getLocalDateAndTime(d.crt_tim,2)+"</td>"+
							"<td>"+getIsNull(d.remark)+"</td>"+
							"<td>"+
			              	"<a  class='layer CKWJ_QX'  data-url='<%=basePath%>commens/jhgl/wzcgjh/query.htm?id="+d.id+"' data-title='查看'   href='javascript:void(0);' >查看文件</a>"+
			              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer XGJH_QX'  data-url='<%=basePath%>commens/jhgl/wzcgjh/edit.htm?id="+d.id+"' data-title='修改'   href='javascript:void(0);' >修改 </a>"+
			              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);'  class='SCJH_QX' onclick='del(&quot;"+d.id+"&quot;,&quot;"+d.plan_num+"&quot;)'>删除</a>"+
			              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer SCWJ_QX'  data-url='<%=basePath%>commens/jhgl/wzcgjh/addfile.htm?id="+d.id+"&plan_num="+d.plan_num+"' data-title='上传'   href='javascript:void(0);' >上传文件</a>"+
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
		function del(id,plan_num){
		layer.confirm("确定删除？",function(){
			$.ajax({
				url:url+"delAssetsPurPlan.htm",
				type:"post",
				data:"id="+id + "&plan_num="+plan_num,
				dataType:"json",
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
		});
	}
	</script>
</body>
</html>