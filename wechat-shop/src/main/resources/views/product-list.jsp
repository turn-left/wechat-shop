<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
  function jump(p){
	  location.href='selectProductList?cp='+p;
  }
  </script>
  <script type="text/javascript">
function selectname(){
	  var name = document.getElementById("selectname").value;
	  location.href='selectProductList?name='+name;
}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><c:if test="${name!=null}"><a href="selectdd?dd=${name.EU_USER_ID }">个人订单</a></c:if><c:if test="${name!=null}">当前用户${name.EU_USER_ID }</c:if><a href="ShopSelect" class="shopping">购物车</a><c:if test="${name==null}"><a href="login.html">登录</a></c:if><c:if test="${name!=null}"><a href="zx">退出</a></c:if><a href="register.jsp">注册</a><a href="SelallServlet">留言</a><c:if test="${name.EU_STATUS==2}"><a href="manage/index.jsp" >去后台</a></c:if></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="indexSelect">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><input type="text" id="selectname"/><a href="javascript:selectname()">搜索</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="indexSelect">易买网</a> &gt; <a href="selectProductList">商品分类</a> &gt; ${title }
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt><a href="selectProductList">全部商品</a></dt>
				<c:forEach var="f" items="${flist}">
					<dt><a href="selectProductList?fid=${f.EPC_ID }">${f.EPC_NAME }</a></dt>
					<c:forEach var="c" items="${clist}">
						<c:if test="${f.EPC_ID==c.EPC_PARENT_ID}">
							<c:if test="${p.EPC_CHILD_ID!=c.EPC_ID}">
								<dd><a href="selectProductList?cid=${c.EPC_ID }">${c.EPC_NAME }</a></dd>
							</c:if>
						</c:if>
					</c:forEach> 
				</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach var="lastp" items="${lastlylist}">
					<dt><a href="selectProductView?id=${lastp.EP_ID }"><img height="40" src="images/product/${lastp.EP_FILE_NAME }" /></a></dt>
					<dd><a href="selectProductView?id=${lastp.EP_ID }">${lastp.EP_NAME }</a></dd>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>${title }</h2>
			<div class="pager">
				<ul class="clearfix">
					<li>当前:${cpage}/${tpage }页</li>
				    <li><a href="selectProductList?cp=1">首页</a></li>
				    <li><a href="selectProductList?cp=${cpage-1<=0 ? 1 : cpage-1 }">上一页</a></li>
				    <li><a href="selectProductList?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a></li>
				    <li><a href="selectProductList?cp=${tpage }">尾页</a></li>
				    <li><select onchange="jump(this.value)">
				    	<c:forEach var="i" begin="1" end="${tpage}">
				    	<option ${i==cpage ? "selected" : "" } value="${i}">${i }页</option>
				    	</c:forEach>
				    </select></li>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
				<c:forEach var="p" items="${list}">
					<li>
						<dl>
							<dt><a href="selectProductView?id=${p.EP_ID }" target="_blank"><img src="images/product/${p.EP_FILE_NAME }" /></a></dt>
							<dd class="title"><a href="selectProductView?id=${p.EP_ID }" target="_blank">${p.EP_NAME }</a></dd>
							<dd class="price">￥${p.EP_PRICE }.00</dd>
						</dl>
					</li>
				</c:forEach>
				
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li>当前:${cpage}/${tpage }页</li>
				    <li><a href="selectProductList?cp=1">首页</a></li>
				    <li><a href="selectProductList?cp=${cpage-1<=0 ? 1 : cpage-1 }">上一页</a></li>
				    <li><a href="selectProductList?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a></li>
				    <li><a href="selectProductList?cp=${tpage }">尾页</a></li>
				    <li><select onchange="jump(this.value)">
				    	<c:forEach var="i" begin="1" end="${tpage}">
				    	<option ${i==cpage ? "selected" : "" } value="${i}">${i }页</option>
				    	</c:forEach>
				    </select></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
