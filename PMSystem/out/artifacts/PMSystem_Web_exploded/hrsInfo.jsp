<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人信息</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/BeAlert.css" rel="stylesheet" >
<style>
    .lb-control{
        position:relative;
        float:left;
        width:120px;
        font-size:20px;
    }
    .bt-posi-control{
        postiton:relative;
        float:left;
        margin-top:20px;
        margin-left:300px;
    }
    
    

</style>

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="hrsIndex.jsp"><span>企业员工信息</span>管理系统</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-pencil"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="hrsInfo.jsp"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
							<li><a href="javascript:;" id="confirm"><span class="glyphicon glyphicon-pencil"></span> 注销</a></li>
						</ul>
					</li>
				</ul>
			</div>			
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li><a href="InfoManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 员工信息管理</a></li>
			<li><a href="GradeManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 员工评分管理</a></li>
			<li><a href="SalaryManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 员工薪水管理</a></li>
			<li><a href="AuthManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 权限管理</a></li>
			<li><a href="HrsInfoServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
			<!--<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> Dropdown <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
						</a>
					</li>
				</ul>
			</li>-->
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="hrsIndex.jsp"><span class="glyphicon glyphicon-pencil"></span></a></li>
				<li class="active">个人信息</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">个人信息</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form id="formTest">
								<div class="row">
									<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control">用户名: </label>
			
													<div class="col-sm-8">
														<input type="text" id="form-field-1" placeholder="用户名" class="form-control" disabled="disabled" value="${staff.username }">
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control" for="form-field-1">密  码: </label>
			
													<div class="col-sm-8">
														<input type="text" id="form-field-2" name="password" placeholder="密码" class="form-control" disabled="disabled" value="${staff.password }">
													</div>
												</div>
											</div>
									        
											<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control" for="form-field-1">角 色 :</label>
			
													<div class="col-sm-8">
														<input type="text" id="form-field-3" placeholder="角色" class="form-control" disabled="disabled" value="${staff.role}">
													</div>
												</div>
											</div>
											
											<div class="bt-posi-control">
												<div>
													<input class="btn btn-primary" type="button" id="update" value="修改"  >
												</div>
											</div>
											
											<div class="bt-posi-control">
												<div>
													<input class="btn btn-primary" id="submit" type="submit" value="确认" onclick="" disabled="disabled">
												</div>
											</div>
											</div>
											</form>
											</div>
											</div>
											</div>
	</div>
				
		
		
		

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/BeAlert.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	
	<script type="text/javascript">
	

	//将修改后的密码提交到UpdateHrsServlet当中
	$(function() {
		
		//使得密码框变成可修改的状态
		$('#update').click(function() {
			//使得密码的修改狂变成可以编辑的状态
			var textFiled = document.getElementById("form-field-2");
			//alert("修改i");
			textFiled.disabled  = "";
			
			//使得确认按钮可以点击
			var btSubmit = document.getElementById("submit");
			btSubmit.disabled = "";
		});
	
        $('#submit').click(function() {
            $.ajax({
            	type: 'get',
                url: "UpdateHrsServlet",
                dataType:'json',
                data: $("#formTest").serializeArray(),
                success: function(data) {
                	 if(data.result=="success"){
                    	 alert("修改成功!");
                     }else{
                    	alert("修改失败!");
                     }
                		//使得密码的修改狂变成不可以编辑的状态
                			var textFiled = document.getElementById("form-field-2");
                			//alert("修改");
                			textFiled.disabled  = "disabled";
                			
                			//使得确认按钮不可以点击
                			var btSubmit = document.getElementById("submit");
                			btSubmit.disabled = "disabled";
                	 
                }
            });
            
            return false;
        });
    });
	
	
	
	
	
	$(function () {
        $("#confirm").click(function () {
            confirm("是否退出登录?","退出登录将返回到登录界面!",function (isConfirm) {
                if (isConfirm) {
                    location.href="login.jsp";
                } else {
                    //after click the cancel
                }
            }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
        });
    });
	</script>	
</body>

</html>
