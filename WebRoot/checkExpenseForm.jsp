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
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-table.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-editable.css" />
<link rel="stylesheet" type="text/css" href="css/sweetalert.css" />
<link rel="stylesheet" type="text/css" href="css/toastr.css" />

<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-table-zh-CN.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-editable.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/sweetalert.min.js" type="text/javascript"
	charset="utf-8"></script>
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
								<div class="panel-heading">审批报销单</div>
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
										<label for="depName">预计报销金额</label> <input type="text"
											class="form-control" id="depName"
											placeholder="${requestScope.expenseForm.exFAccount}" disabled>
									</div>
					
									<div class="form-group">
										<label>报销理由</label>
										<textarea class="form-control" rows="3"
											placeholder="${requestScope.expenseForm.exFReason}" disabled></textarea>
									</div>
					
								</form>
								<hr />
								<form action="${pageContext.request.contextPath }/chaim_checkChaim"
									method="post">
									<h3>财务意见</h3>
									<input name="chaim_id" type="hidden"
										value="${requestScope.expenseForm.chaimVovcher.cvId}">
									<div class="form-group">
										<div class="radio">
											<label> <input type="radio" name="result"
												id="optionsRadios1" value="通过" checked> 同意该申请 </label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="result"
												id="optionsRadios2" value="未通过"> 拒绝该申请 </label>
										</div>
									</div>
									<div class="form-group">
										<label>审批意见</label>
										<textarea class="form-control" rows="3" name="comm" placeholder="${requestScope.beforeResult.ckComm}"></textarea>
									</div>
									<c:if test="${empty requestScope.isManager}">
										<button type="submit" class="btn btn-default btn-primary">提交申请</button>
										<button type="reset" class="btn btn-default">重新填写</button>
									</c:if>
								</form>
					
								<c:if test="${requestScope.expenseForm.exFAccount>5000}">
									<c:if test="${not empty requestScope.isManager}">
										<h3>总经理意见</h3>
										<form action="${pageContext.request.contextPath }/chaim_checkChaim"
											method="post">
											<input name="chaim_id" type="hidden"
												value="${requestScope.expenseForm.chaimVovcher.cvId}">
											<div class="form-group">
												<div class="radio">
													<label> <input type="radio" name="result"
														id="optionsRadios1" value="通过" checked> 同意该申请 </label>
												</div>
												<div class="radio">
													<label> <input type="radio" name="result"
														id="optionsRadios2" value="未通过"> 拒绝该申请 </label>
												</div>
											</div>
											<div class="form-group">
												<label>审批意见</label>
												<textarea class="form-control" rows="3"
													placeholder="${requestScope.leaveForm.leFReason}" name="comm"></textarea>
											</div>
											<button type="submit" class="btn btn-default btn-primary">提交</button>
											<button type="reset" class="btn btn-default">重新填写</button>
										</form>
									</c:if>
								</c:if>							
						</div>
					</div>
				</div>
</body>
</html>