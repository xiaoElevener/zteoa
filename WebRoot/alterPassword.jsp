<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>Bootstrap 101 Template</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		
		 <link rel="stylesheet" type="text/css" href="css/metisMenu.min.css"/>
		 <link href="css/mm-vertical.css" rel="stylesheet" type="text/css"/>
		 <script src="js/metisMenu.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
		</script>
    </head>
    <body>
    	<!--导航条-->
		<jsp:include page="header.jsp"></jsp:include>
		<!--个人信息管理主体-->
		<div class="container-fluid">
			<div class="row">
				<!-- 左部导航 -->
				<jsp:include page="leftbar.jsp"></jsp:include>
				<!--修改个人信息页面-->
				<div class="col-md-8">
					<div class="panel panel-primary">
						<div class="panel-heading">在这里修改你的密码</div>
						<div class="panel-body">
							<div class="col-md-10">
								<form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/UserAction_updatePassword">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">请输入原密码</label>
									<div class="col-sm-10">
										<input name="oldPassword" class="form-control" type="password"
											placeholder="原密码">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">输入你的新密码</label>
									<div class="col-sm-10">
										<input name="newPassword" class="form-control" type="password"
											placeholder="新密码">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">确认密码</label>
									<div class="col-sm-10">
										<input class="form-control" type="password" placeholder="确认密码">
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">保存新密码</button>
									</div>
								</div>
							</form>

							</div>

						</div>

					</div>

				</div>
			</div>

		</div>
 	</body>
</html>