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

<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
	<%-- 
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="${APP_PATH }/CSS/leftnav.css" media="screen" type="text/css"/> --%>
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
<style>
            .panel-group{max-height:770px;overflow: auto;}
            .leftMenu{margin:10px;margin-top:5px;}
            .leftMenu .panel-heading{font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
            .leftMenu .panel-heading span{position:absolute;right:10px;top:12px;}
            .leftMenu .menu-item-left{padding: 2px; background: transparent; border:1px solid transparent;border-radius: 6px;}
            .leftMenu .menu-item-left:hover{background:#C4E3F3;border:1px solid #1E90FF;}
        </style>
</head>
<body>
<!-- 员工修改的模态框 -->



<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">员工修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">empName</label>
		    <div class="col-sm-10">
		      	<p class="form-control-static" id="empName_update_static"></p>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">email</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@atguigu.com">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
				</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">deptName</label>
		    <div class="col-sm-4">
		    	<!-- 部门提交部门id即可 -->
		      <select class="form-control" name="deptId">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>



<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">empName</label>
		    <div class="col-sm-10">
		      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="scott">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">email</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="1154769609@qq.com">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
				</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">deptName</label>
		    <div class="col-sm-4">
		    	<!-- 部门提交部门id即可 -->
		      <select class="form-control" name="deptId" id="selectDept">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
        <button type="button" class="btn btn-primary" id="emp_save_btn" onclick="addEmployee()">保存</button>
      </div>
    </div>
  </div>
</div>


	<!-- 搭建显示页面 -->
	<div class="container">
		<div class="row">
		
		<!--  左侧导航lan-->
	<div class="col-md-2">
	
	<!--  <div class="account-l fl">
        <a class="list-title">账户概览</a>
        <ul id="accordion" class="accordion">
            <li>
                <div class="link"><i class="fa fa-leaf"></i>产品管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="shop"><a>查看店铺</a></li>
                    <li id="publicproducts"><a>发布产品</a></li>
                    <li id="productlists"><a>查看产品</a></li>
                    <li id="mysaled"><a>已卖出产品</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-shopping-cart"></i>采购管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="publishpurchase"><a>发布采购</a></li>
                    <li id="postneeds"><a>查看采购</a></li>
                    <li id="getneeds"><a>已收到的报价单</a></li>
                    <li id="mypricesheet"><a>我的报价单</a></li>
                    <li id="concernshop"><a>已关注的店铺</a></li>
                    <li id="concerngood"><a>已关注的商品</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-pencil-square-o"></i>询盘管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="buyerxunpanlist"><a>收到的询盘</a></li>
                    <li id="publishrequire"><a>我的询盘</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-file-text"></i>订单管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="myorder"><a>我的订单</a></li>
                    <li id="myrefund"><a>退款申请</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-globe"></i>金融管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="myloan"><a>我的借贷</a></li>
                    <li id="financialmanage"><a>需求申请</a></li>
                    <li id="myapplication"><a>我的申请</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-unlock-alt"></i>安全管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="basecomInfo"><a>基本信息</a></li>
                    <li id="authenchange"><a>认证信息</a></li>
                    <li id="phoneAuth"><a>手机认证</a></li>
                    <li id="bankCardAuth"><a>银行卡认证</a></li>
                    <li id="emailAuth"><a>邮箱认证</a></li>
                    <li id="passwordmodify"><a>密码修改</a></li>
                    <li id="paymentpsdmodify"><a>支付密码</a></li>
                    <li id="address"><a>收货地址</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-star"></i>评价管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="usercomments"><a>我的评价</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-bell"></i>消息管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="mymsg"><a>我的消息</a></li>
                </ul>
            </li>
            视情况而定
            <li>
                <div class="link"><i class="fa fa-signal"></i>统计管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="censusmanager"><a>月贸易量</a></li>
                    <li id="statisticmanager"><a>月订单量</a></li>
                </ul>
            </li>
            <li>
                <div class="link"><i class="fa fa-credit-card"></i>白条管理<i class="fa fa-chevron-down"></i></div>
                <ul class="submenu">
                    <li id="oweindex"><a>开通白条</a></li>
                    <li id="myIous"><a>我的白条</a></li>
                    <li id="louorderlist"><a>订单列表</a></li>
                </ul>
            </li>
        </ul> -->
        <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
        <script src='js/leftnav.js'></script>
    </div>
	
	
              <!--   <div class="panel-group table-responsive" role="tablist">
                    <div class="panel panel-primary leftMenu">
                        利用data-target指定要折叠的分组列表
                        <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                            <h4 class="panel-title">
                                分组1
                                <span class="glyphicon glyphicon-chevron-up right"></span>
                            </h4>
                        </div>
                        .panel-collapse和.collapse标明折叠元素 .in表示要显示出来
                        <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                利用data-target指定URL
                                <button class="menu-item-left" data-target="test2.html">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项1-1
                                </button>
                              </li>
                              
                           </ul>
                        </div>
                    </div>panel end
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                            <h4 class="panel-title">
                                分组2
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项2-1
                                </button>
                              </li>
                              
                            </ul>
                        </div>
                    </div>  
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                            <h4 class="panel-title">
                                分组3
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项3-1
                                </button>
                              </li>
                              
                            </ul>
                        </div>
                    </div>  
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading4" data-toggle="collapse" data-target="#collapseListGroup4" role="tab" >
                            <h4 class="panel-title">
                                分组4
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading4">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项4-1
                                </button>
                              </li>
                              
                            </ul>
                        </div>
                    </div>  
                </div> -->
            </div>
		
		<!-- 右侧数据表 -->
		<div class="col-md-10">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn" onclick="toAddEmployee()">新增</button>
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							 <th>
								<input type="checkbox" id="check_all"/>
							</th> 
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>
		
		</div>
		</div>		
	</div>
	<!-- <script>
        $(function(){
            $(".panel-heading").click(function(e){
                /*切换折叠指示图标*/
                $(this).find("span").toggleClass("glyphicon-chevron-down");
                $(this).find("span").toggleClass("glyphicon-chevron-up");
            });
        });
        </script> -->
	<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>				
<script type="text/javascript" src="${APP_PATH }/static/ssm/ssm.js"> </script>	
<!--  <script src='js/leftnav.js'></script> -->
</body>
</html>