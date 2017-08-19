<%@page import="com.ncu.oa.common.entity.User"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>导航条</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>导航条</title>
<script src="js/toastr.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.navbar-inverse input[type="text"] {
	background: #313131;
	border: none;
	color: #999;
}

.navbar-inverse .navbar-form {
	position: relative;
}

.navbar-inverse button[type="submit"] {
	position: absolute;
	top: 15%;
	right: 20px;
	background: none;
	border: none;
}

.navbar-inverse .glyphicon {
	color: #999;
}
</style>

</head>

<body>

	<!--
		        	导航条
		  -->
	<nav class="navbar navbar-inverse">
		<div class="container">
			<a href="#" class="navbar-brand"><strong>中兴OA</strong> </a>



			<div class="profile navbar-right">
				<ul class="nav navbar-nav">


					<button id="signIn" class="btn btn-primary btn-sm navbar-btn">签到</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="signOut"
						class="btn btn-primary btn-sm navbar-btn navbar-right">签退</button>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" aria-expanded="false">
							${sessionScope.user.userName} <b class="caret"></b> </a>
						<ul class="dropdown-menu">
							<li class="text-center">
							<li>
							<li><a
								href="${pageContext.request.contextPath }/alterInfo.jsp">修改个人信息</a>
							</li>

							<li role="separator" class="divider"></li>
							<li><a
								href="${pageContext.request.contextPath }/UserAction_logout">退出登录</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

</body>
<script>
	$(document).ready(function() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/attendance_canSign",
			async : true,
			success : function(data, status) {
				if (data != 1) {
					$("#signIn").attr("disabled", true);
				}
				;
				if (data != 2) {
					$("#signOut").attr("disabled", true);
				}
				;
			}
		});

		$("#signIn").click(function() {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/attendance_signIn",
				//提交表单中序列化的值
				async : true,
				success : function() {
					$("#signIn").attr("disabled", true);
					$("#signOut").attr("disabled", false);
				}
			});
		});

		$("#signOut").click(function() {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/attendance_signOut",
				//提交表单中序列化的值
				async : true,
				success : function() {
					$("#signOut").attr("disabled", true);
				}
			});
		});
	});
</script>
</html>