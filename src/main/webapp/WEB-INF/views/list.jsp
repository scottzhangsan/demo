<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
	<!-- 标题 -->
	  <div class="row">
	     <div class="col-mod-12">
	        <h2>SSM-CRUD</h2>
	     </div>
	   </div>
	<!-- 增加，删除 -->
	<div class="row">
	    <div class="col-md-4 col-md-offset-8">
	      <button type="button" class="btn btn-primary">新增</button>
          <button type="button" class="btn btn btn-danger">删除</button>
	    </div>
	</div>
	<!-- 显示内容 -->
	<div class="row">
	    <div class="col-mod-12">
	     <table class="table">
	     <tr>
	     <th>编号</th>
	     <th>姓名</th>
	     <th>邮件</th>
	     <th>部门</th>
	     <th>操作</th>
	     </tr>
	     <c:forEach items="${page.list }" var="emp">
	     <tr>
	     <th>${emp.empName }</th>
	     <th>${emp.email }</th>
	     <th>${emp.gender }</th>
	    <th>${emp.department.deptName }</th>
	     <th><button type="button" class="btn btn-primary  btn-sm"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	     修改</button>
	        <button type="button" class="btn btn-danger  btn-sm">
	        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	        删除</button>
	     </th>
	     </tr>
	     </c:forEach>
	     </table>
	   </div>
	</div>
	<!-- 分页 -->
	<div class="row">
	<div class="col-mod-6 col-md-offset-3">
	当前第 ${page.pageNum} 页，总共${page.pages },总计 ${page.total }条记录数
	</div>
	<div class="col-mod-6 col-md-offset-6" >
	<nav aria-label="Page navigation">
  <ul class="pagination">
  <li><a href="${APP_PATH }/emps?pn=1">首页</a></li>
    
     <c:if test="${page.pageNum==1 }">
    <li class="disabled">
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    </c:if>
      <c:if test="${page.pageNum>1 }">
    <li >
      <a href="${APP_PATH }/emps?pn=${page.pageNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    </c:if>
    <c:forEach items="${page.navigatepageNums}" var="pageNum">
    <c:if test="${pageNum ==page.pageNum }">
    <li  class="active"><a href="#">${pageNum }</a></li>
    </c:if>
    <c:if test="${pageNum !=page.pageNum }">
    <li><a href="${APP_PATH }/emps?pn=${pageNum} ">${pageNum }</a></li>
    </c:if>
    </c:forEach>
    <c:if test="${page.pageNum==page.pages }">
    <li class="disabled">
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
    <c:if test="${page.pageNum!=page.pages }">
    <li >
      <a href="${APP_PATH }/emps?pn=${page.pageNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
    <li><a href="${APP_PATH }/emps?pn=${page.total}">末页</a></li>
  </ul>
</nav>
	</div>
	</div>
	</div>
</body>
</html>