<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>测试bootstrap table</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/metisMenu.min.css" />
<link href="css/mm-vertical.css" rel="stylesheet" type="text/css" />

<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="utf-8"></script>
<script src="js/metisMenu.min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format : 'yyyy-mm-dd',
		});

		$('#datetimepicker2').datetimepicker({
			format : 'yyyy-mm-dd',
		});
		$('#menu1').metisMenu();
	});
</script>
</head>

<body>
	<!--导航条-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--个人信息管理主体-->
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="leftbar.jsp"></jsp:include>
			<!--修改个人信息页面-->
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">修改你的个人信息</div>
					<div class="panel-body">
						<div class="col-md-10">
							<form
								action="${pageContext.request.contextPath}/UserAction_updateMyInfo"
								class="form-horizontal" method="post">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">您的工号为</label>
									<div class="col-sm-10">
										<input name="userId" class="form-control" id="disabledInput"
											type="text" value="${sessionScope.user.userId}"
											placeholder="${sessionScope.user.userId}" disabled>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">您的姓名为</label>
									<div class="col-sm-10">
										<input name="userName" class="form-control" id="disabledInput"
											type="text" value="${sessionScope.user.userName}"
											placeholder="${sessionScope.user.userName}">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">选择你的性别</label>
									<div class="col-sm-10">
										<select name="userSex" class="form-control">
											<option value="男"
												<c:if test="${sessionScope.user.userSex=='男'}">selected</c:if>>男</option>
											<option value="女"
												<c:if test="${sessionScope.user.userSex=='女'}">selected</c:if>>女</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">您所在的部门为</label>
									<div class="col-sm-10">
										<input class="form-control" id="disabledInput" type="text"
											placeholder="${sessionScope.user.department.dpName}" disabled>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">您的职位是</label>
									<div class="col-sm-10">
										<input class="form-control" id="disabledInput" type="text"
											placeholder='<c:forEach var="item" items="${sessionScope.user.roles}" varStatus="status">${item.roleName} </c:forEach>'
											disabled>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">你的手机号为</label>
									<div class="col-sm-10">
										<input name="userTelephone" type="text" class="form-control"
											id="inputEmail3"
											placeholder="${sessionScope.user.userTelephone}"
											value="${sessionScope.user.userTelephone}">
									</div>
								</div>
								<!--个人生日修改框-->
								<div class="form-group">
									<label for="dtp_input2" class="col-md-2 control-label">选择你的生日</label>
									<div class="col-sm-10">
										<div class="input-group date form_date" id='datetimepicker2'>
											<input name="userBirthday" class="form-control" size="16"
												type="text"
												value="<fmt:formatDate value="${sessionScope.user.userBirthday}" pattern="yyyy-MM-dd"/>"
												readonly> <span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span> </span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span> </span>
										</div>

									</div>

								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">保存信息</button>
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