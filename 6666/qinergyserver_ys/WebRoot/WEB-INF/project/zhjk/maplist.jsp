<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
	</head>
	<body style="background: #FCFCFC;">
			<input type="hidden" id="userId" value="${user.id}">	
			<input type="hidden" id="use_typ" value="${user.use_typ}" >
			<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >	
		<div class="header">
			<div class="topnav">
				<!-- <input class="search bor-shadow bor-radius" type="text" placeholder="请输入关键字" />
				<i class="bor-shadow bor-radius"></i> -->
			<div class="topnav-center bor-shadow bor-radius ml150" style="display:none;">
				<span>运维公司</span>
				<select class="nav-select"  id="companyOne" onchange="setCompanytwo(this.value);" >
					<option>请选择</option>
				</select>
			</div>
			<div class="topnav-center bor-shadow bor-radius">
				<span>所属公司</span>
				<select class="nav-select" id="companyTwo" onchange="setCompanyThree(this.value);">
					<option>请选择</option>
				</select>
			</div>
			<div class="topnav-center bor-shadow bor-radius" >
				<span>子公司</span>
				<select class="nav-select" id="companyThree" onchange="setPws(this.value);">
					<option>请选择</option>
				</select>
			</div>
			</div>
		</div>
		<div class="header-right">
			<div  class="topnav-right list"  >
				<a style = "width: 100%;height: 100%;display: block;" href="<%=basePath %>/commens/map.htm"></a>
				<div class="checkarea bor-shadow bor-radius">
					<ul>
						<li style="border-bottom:1px solid #ccc;">
							<input type="checkbox" id="check-zd" checked="checked"/> 电站
						</li>
						<li>
							<input type="checkbox" id="check-ry"  checked="checked"/> 人员
						</li>
					</ul>
				</div> 
			</div>
		</div>
		<div class="list-main mb50">
			<div class="list-item">
				<ul>
					<li class="bor-radius">
						<i class="zd-icon"></i>
						<span class="num" id="dzNum">0</span>
						<span>电站总数量</span>
					</li>
					<!-- <li class="bor-radius">
						<i class="cdz-icon"></i>
						<span class="num" id="dzNum">0</span>
						<span>充电桩总数量</span>
					</li> -->
					<li class="bor-radius">
						<i class="wh-icon"></i>
						<span class="num" id="ryNum">0</span>
						<span>维护人员数量</span>
					</li>
				</ul>
			</div>
			<div class="clr"></div>
			<div class="list-zd bor-radius mt15">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="fanlist-list">
		            <tr>
		              <th width="18%">电站名称</th>
		              <th width="18%">位置</th>
		              <th width="48%">简述</th>
		              <th width="8%">状态</th>
		              <th width="8%">操作</th>
		            </tr>
		            <tbody id="pwsList">
		             	<tr><td colspan="5">暂无数据</td></tr>
		            </tbody>
		            <%-- <tr>
		              <td>密云伏电试验站1</td>
		              <td>9</td>
		              <td>密云北关环岛出口左侧电力局旁边的A口</td>
		              <td>独立运维</td>
		              <td>正常</td>
		              <td></td>
		              <td><a href="<%=basePath %>/commens/detail.htm" target="_self"  >查看详情</a></td>
		            </tr> --%>
	            </table>
			</div>
			<div class="list-person bor-radius mt15">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="fanlist-list">
		            <tr>
		              <th width="8%">人员姓名</th>
		              <th width="8%">手机号</th>
		              <th width="8%">工龄</th>
		              <th width="61%">简述</th>
		              <th width="15%">所属公司</th>
		            </tr>
		            <tbody id="perList">
		            	<tr><td colspan="5">暂无数据</td></tr>
		            </tbody>
		             
		           <!--  <tr>
		              <td>水电的</td>
		              <td>13533323911</td>
		              <td>勘察</td>
		              <td>在岗</td>
		              <td>密云子公司</td>
		              <td><a href="javascript:void(0);" target="_self"  >查看详情</a></td>
		            </tr> -->
	            </table>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="<%=basePath %>js/jquery.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/jsall.js?pubVersion=201802070001" ></script>
	<script type="text/javascript" src="<%=basePath %>js/zhjkCheckComList.js?pubVersion=201802070001" ></script>
	<script>
		$(function(){
			var userId = $("#userId").val();
			//userId = 7;
			
			
			getCompanyOne();
			
			$("#check-zd").click(function(){
				$(this).is(':checked')?$(".list-zd").show():$(".list-zd").hide();
			});
			
			$("#check-ry").click(function(){
				$(this).is(':checked')?$(".list-person").show():$(".list-person").hide();
			});
		})
	</script>
</html>
