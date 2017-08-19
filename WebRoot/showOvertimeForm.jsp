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
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-table.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-editable.css" />
		<link rel="stylesheet" type="text/css" href="css/sweetalert.css" />
		<link rel="stylesheet" type="text/css" href="css/toastr.css" />

		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-datetimepicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table-zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-editable.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/sweetalert.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/toastr.js" type="text/javascript" charset="utf-8"></script>
		 <link rel="stylesheet" type="text/css" href="css/metisMenu.min.css"/>
		 <link href="css/mm-vertical.css" rel="stylesheet" type="text/css"/>
		 <script src="js/metisMenu.min.js" type="text/javascript" charset="utf-8"></script>
		 <script>
		   $(function () {
		       $('#menu1').metisMenu();
		
		   });
		 </script>
	</head>

	<body>
	
		<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
				<div class="row">
					<!-- 左部导航条 -->
					<jsp:include page="leftbar.jsp"></jsp:include>
				
		
					<div class="col-md-8">
						<div class="panel-body" style="padding-bottom:0px;">
							<div class="panel panel-default">
								<div class="panel-heading">查看加班申请单</div>
								<div class="panel-body">
								<h3>加班表基本信息</h3>
								<div class="col-md-4">
									<label for="">填报人:${requestScope.overtimeForm.chaimVovcher.user.userName}</label>
								</div>
								<div class="col-md-4">
									<label for="">填报时间:${requestScope.overtimeForm.chaimVovcher.cvCreateTime}</label>
								</div>
								<div class="col-md-4">
									<label for="">状态:${requestScope.overtimeForm.chaimVovcher.cvStatus}</label>
								</div>
								
								<form>
			
							<!--开始时间-->
							<div class="form-group">
								<label for="dtp_input2">预计加班时间</label>
				
								<div class="input-group date form_date" id='datetimepicker4'>
									<input class="form-control" size="16" type="text" placeholder="<fmt:formatDate value="${requestScope.overtimeForm.otFDate}" pattern="yyyy-MM-dd"/>" disabled="">
									<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
							
						</form>
						<hr />
						<!-- 在action中传入是否审核的标志位，在jsp页面进行判断，
						只要不是待审核的状态，都在下面显示该申请单的审核结果 -->
						<c:if test="${! empty requestScope.isChecked}">
							<form>
							<h3>加班表审核情况</h3>
									<div class="col-md-4">
										<label for="">审核人:${requestScope.myResult.user.userName}</label>
									</div>
									<div class="col-md-4">
										<label for="">审核时间:${requestScope.myResult.ckTime}</label>
									</div>
									<div class="col-md-4">
										<label for="">审批结果:${requestScope.myResult.ckResult}</label>
									</div>
									
									<div class="form-group">
										<label>审批意见</label>
										<textarea class="form-control" rows="3" name="comm" placeholder="${requestScope.myResult.ckComm}" disabled></textarea>
									</div>
								</form>
				
						</c:if>
								
								
									
						</div>
					</div>
				</div>
		
	
	

	</body>
</html>