<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>대행업체 업종 등록</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<div style="position:fixed; z-index:-1; width:100%">
			<img style="width:1900px;" src="${pageContext.request.contextPath}/resources/image/background/bgMain.jpg">
		</div>
		<jsp:include page="/WEB-INF/views/module/top/navbar.jsp"/>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2" style="padding:15px;">
					<%-- <jsp:include page="./module/left/leftnavi.jsp"/> --%>
				</div>
				<div class="col-sm-8">
					<div class="text-center">
						<h1>업종 등록</h1>
					</div>
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-8">
								<!-- Begin Content -->
									<div class="panel panel-default">
										<div class="panel-body text-center">
											<form id="insertAgencyBusinesstype" class="form-horizontal" action="${pageContext.request.contextPath}/insertAgencyBusinesstype" method="post">
												<div class="form-group">
													<label for="agencyBusinesstypeName" class="col-sm-3 control-label">업종명</label>
													<div class="col-sm-9">
														<input type="text" class="form-control" name="agencyBusinesstypeName" id="agencyBusinesstypeName" placeholder="업종을 입력해주세요.">
													</div>
												</div>
												<br>
												<div class="form-group">
													<div class="col-sm-12">
														<button type="submit" id="insertButton" class="btn btn-default">등록하기</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								<!-- End Content -->
							</div>
							<div class="col-sm-2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/module/bottom/bottomContent.jsp"/>
	</body>
</html>