<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<title>Introduce</title>
		<script>
			$(document).ready(function(){
				$('#goHomeBtn').click(function(){
					$(location).attr('href', './'); 
				});	
			});
			
		</script>
	</head>
	<body>
		<div style="position:fixed; z-index:-1; width:100%">
			<img style="width:1900px;" src="${pageContext.request.contextPath}/resources/image/background/bgMain.jpg">
		</div>
		
		<div class="container-fluid" style="height:1500px;">
			<jsp:include page="../module/top/navbar.jsp"/>
			<%-- <jsp:include page="./module/top/mainHeader.jsp"/> --%>
			<div class="row" >
				<div class="col-sm-2" style="padding:15px;">
					<jsp:include page="../module/leftHome/leftHome.jsp"/>
				</div>
				<div class="col-sm-8" style="height:850px; padding:15px">
				<!-- Begin Content -->
		
				<div class="panel panel-default">
					<div class="panel-body">
						<h3 class="text-center"><strong>프로젝트 소개</strong></h3>
						<hr/>
						<h3>프로젝트명 : </h3>
						<h4>국가 통합 대여/예약 시스템 (Nation Integrated Reserve and Rental)</h4>
						<h3>목적 :</h3>
						<h4>각 시도군청 별로 있는 예약하고 대여 할 수 있는 모든 물품/시설을 모아서 한곳에서 간편하게 처리하기 위함.</h4>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-body">
						<h3 class="text-center"><strong>조원 소개</strong></h3>
						<hr/>
						<div class="row">
							<div class="col-sm-3">
								<div class="thumbnail">
								<!-- 118 * 162 -->
								<!-- src="${pageContext.request.contextPath}/resources/image/idPhoto/LeeInho.jpg" -->
									<img data-src="holder.js/100%x200" alt="100%x200" src="${pageContext.request.contextPath}/resources/image/idPhoto/LeeInHo.jpg" data-holder-rendered="true" style="height: 255px; width: 195px; display: block;">
									<div class="caption">
										<h3 style="text-align:center;" id="thumbnail-label">이인호<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
										<p>
											역할 :<br/>
											◈ 공무원 회원관리<br/>
											◈ 대행업체 관리<br/>
											◈ 물품반납<br/>
											◈ 연회비/패키지<br/>
											◈ 상벌관리
										</p>
									</div>
								</div>
							</div>
							
							<div class="col-sm-3">
								<div class="thumbnail">
								<!-- 358 * 472 -->
								<!-- src="${pageContext.request.contextPath}/resources/image/idPhoto/LeeJunhee.jpg" -->
									<img data-src="holder.js/100%x200" alt="100%x200" src="${pageContext.request.contextPath}/resources/image/idPhoto/LeeJunHee.jpg" data-holder-rendered="true" style="height: 255px; width: 195px; display: block;">
									<div class="caption">
										<h3 style="text-align:center;" id="thumbnail-label">이준희<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
										<p>
											역할 :<br/>
											◈ 시민 회원관리<br/>
											◈ 대여 물품/시설 관리<br/>
											◈ 시설/물품 대여/예약<br/>
											◈ 시설 정기점검
										</p>
									</div>
								</div>
							</div>
						<!-- </div>
						<div class="row"> -->
						
							<div class="col-sm-3">
								<div class="thumbnail">
									<!-- height: 354px; width: 472px; -->
									<img data-src="holder.js/100%x200" alt="100%x200" src="${pageContext.request.contextPath}/resources/image/idPhoto/leeChunLim.jpg" data-holder-rendered="true" style="height: 255px; width: 195px; display: block;">
									<div class="caption">
										<h3 style="text-align:center;" id="thumbnail-label">이춘림<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
										<p>
											역할 :<br/>
											◈ 조장<br/>
											◈ 대행업체 직원 회원관리<br/>
											◈ 의뢰신청<br/>
											◈ 자유게시판<br/>
											◈ 위기관리
										</p>
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="thumbnail">
									<!-- height: 709px; width: 945px; -->
									<img data-src="holder.js/100%x200" alt="100%x200" src="${pageContext.request.contextPath}/resources/image/idPhoto/LimGaHyun.jpg" data-holder-rendered="true" style="height: 255px; width: 195px; display: block;">
									<div class="caption">
										<h3 style="text-align:center;" id="thumbnail-label">임가현<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
										<p>
											역할 :<br/>
											◈ 기부 관리<br/>
											◈ 결제<br/>
											◈ 관리자 회원관리<br/>
											◈ 행정구역 등록<br/>
											◈ 지자체 기관 등록<br/>
											◈ 시설/물품 카테고리 등록<br/>
											◈ 대행업체 업종분류코드 등록
										</p>
									</div>
								</div>
							</div>
							
						</div>
						
					</div>
				</div>
		
				<div class="panel panel-default">
					<div class="panel-body text-center">
						<h3 class="text-center"><strong>홈으로 가기</strong></h3>
						<hr/>
						<button id="goHomeBtn" type="button" class="btn btn-primary btn-lg">홈으로</button>
					</div>
				</div>
		
		
					

					<!-- End Content -->
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
		<jsp:include page="../module/bottom/bottomContent.jsp"/>
		
	</body>
</html>