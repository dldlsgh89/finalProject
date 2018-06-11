<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>물품/시설 카테고리 2차분류</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<div class="container-fluid">
			<jsp:include page="/WEB-INF/views/module/top/navbar.jsp"/>
			<div class="row">
				<div class="col-sm-2" style="padding:15px;">
					<%-- <jsp:include page="./module/left/leftnavi.jsp"/> --%>
				</div>
				<div class="col-sm-8">
					<!-- Begin Content -->
					<div class="text-center">
						<h1>물품/시설 카테고리 2차분류</h1>
					</div>
						<div class="panel panel-default">
							<div class="panel-body text-center">
								<form id="insertGoodsFacilityCategory" class="form-horizontal" action="${pageContext.request.contextPath}/insertGoodsFacilityCategoryTwo" method="post">
									<div class="form-group">
										<label for="goodsfacilityOneCode" class="col-sm-3 control-label">1차 카테고리</label>
										<div class="col-sm-9">
											<select id=goodsfacilityCategoryDtoList name="goodsfacilityOneCode">
												<option>1차 카테고리</option>
												<c:forEach var="goodsFacilityCategoryDtoList" items="${goodsFacilityCategoryDtoList}">
													<option value="${goodsFacilityCategoryDtoList.goodsfacilityOneCode}">${goodsFacilityCategoryDtoList.goodsfacilityOneName}</option>
												</c:forEach>
											</select>											
										</div>
									</div>
									<div class="form-group">
										<label for="goodsfacilityTwoCode" class="col-sm-3 control-label">2차 카테고리 코드</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="goodsfacilityTwoCode" id="goodsfacilityTwoCode" placeholder="중분류 코드를 입력해주세요.">
										</div>
									</div>
									<div class="form-group">
										<label for="goodsfacilityTwoName" class="col-sm-3 control-label">물품/시설 명</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="goodsfacilityTwoName" id="goodsfacilityTwoName" placeholder="물품 또는 시설의 이름을 입력해주세요.">
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
		<jsp:include page="/WEB-INF/views/module/bottom/bottomContent.jsp"/>
	</body>
</html>