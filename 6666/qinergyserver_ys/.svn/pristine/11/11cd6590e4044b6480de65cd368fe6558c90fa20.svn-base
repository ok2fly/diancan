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
<meta charset="utf-8">
<title>公告管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<table cellpadding="0"  border="0" width="100%" class="poptable">
		<tr>
			<th>公告内容</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入公告内容" id="ann_cont"   onfocus="" class="poptextarea quinputcol requiredInp"></textarea>
			</td>
		</tr>
		<tr>
			<th>公告状态</th>
			<td>
				<select  class="popinput quinputcol requiredInp" id="ann_typ" placeholder="区域标识">
	          	  	<option value="1">播出</option>
	          	  	<option value="2">不播出</option>
          	 	 </select>
			</td>
			<th>公告排序号</th>
			<td><input type="text" id="ann_sort"  placeholder="请输入公告排序号" class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
			</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()" >确定</button>
		<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()">
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript">
 
function insert(){
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	} 
	  		if(reFlag){
	  			return false;
	  		}
	 }); 
	 if(reFlag){
		   return false;
	 }
	var ann_cont = $("#ann_cont").val();
	var ann_sort = $("#ann_sort").val();
	var ann_typ = $("#ann_typ").val();
	var remark = $("#remark").val();
	
   	layer.confirm("是否添加？",function(){

	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		  url:url+"insAnnInf.htm",
		  data: "ann_cont="+ann_cont 
		  		+"&&ann_sort="+ann_sort
		  		+"&&ann_typ="+ann_typ
		  		+"&&remark="+remark  ,
		  dataType:"json",
		  async: false,
		  type:"post",
		  success:function(data){
			  layer.close(indexlayer); //关闭 loading 
			  if(data.resultcode=="USR000"){
				  top.frames['bottom'].getGg();
				  layer.alert("保存成功");
				  window.parent.getData();
			  }else{
				  layer.alert(data.desc);
			  }
		  }
	 })
   	})
}
function reset(){
	window.location.reload();
}
</script>
</body>
</html>
