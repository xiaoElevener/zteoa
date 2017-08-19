<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<div class="panel-heading">查看报销单</div>
								<div class="panel-body">
									<h3>报销表基本信息</h3>
									<div class="col-md-4">
										<label for="">填报人:${requestScope.expenseForm.chaimVovcher.user.userName}</label>
									</div>
									<div class="col-md-4">
										<label for="">填报时间:${requestScope.expenseForm.chaimVovcher.cvCreateTime}</label>
									</div>
									<div class="col-md-4">
										<label for="">状态:${requestScope.expenseForm.chaimVovcher.cvStatus}</label>
									</div>
									<form>
									<div class="form-group">
										<label for="depName">预计报销金额</label>
										<input type="text" class="form-control" id="depName" placeholder="${requestScope.expenseForm.exFAccount}" disabled=true>
									</div>
									
									<div class="form-group">
										<label>报销理由</label>
										<textarea class="form-control" rows="3" placeholder="${requestScope.expenseForm.exFReason}" disabled=true></textarea>
									</div>
								</form>
								<br>
								<!-- 如果这个申请表不是待审核的状态，就显示它的审核结果 -->
								<c:if test="${! empty requestScope.isChecked}">
									<!-- 首先一定会显示财务的意见 -->
										<form>
											<h3>财务审核情况</h3>
											<div class="col-md-4">
												<label for="">审核人:${requestScope.basicResult.user.userName}</label>
											</div>
											<div class="col-md-4">
												<label for="">审核时间:${requestScope.basicResult.ckTime}</label>
											</div>
											<div class="col-md-4">
												<label for="">财务审批结果:${requestScope.basicResult.ckResult}</label>
											</div>
										
											<div class="form-group">
												<label>财务审批意见</label>
												<textarea class="form-control" rows="3" name="comm" placeholder="${requestScope.basicResult.ckComm}" disabled></textarea>
											</div>
										</form>
										<br />
									<!-- 判断经理意见是否存在 如果存在显示经理意见 -->
									<c:if test="${! empty requestScope.manageResult }">
										<form>
												<h3>总经理审核情况</h3>
												<div class="col-md-4">
													<label for="">审核人:${requestScope.manageResult.user.userName}</label>
												</div>
												<div class="col-md-4">
													<label for="">审核时间:${requestScope.manageResult.ckTime}</label>
												</div>
												<div class="col-md-4">
													<label for="">总经理审批结果:${requestScope.manageResult.ckResult}</label>
												</div>
											
												<div class="form-group">
													<label>总经理审批意见</label>
													<textarea class="form-control" rows="3" name="comm" placeholder="${requestScope.manageResult.ckComm}" disabled></textarea>
												</div>
											</form>
									</c:if>
								</c:if>
						</div>
					</div>
				</div>
	
	
	
	
				
		
	

	</body>

</html>