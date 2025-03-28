<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid #bcbcbc;
}
</style>
</head>

			<main>
				<div class="container-fluid">
					<h1 class="mt-4">회원관리</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="indexA">Necipe</a></li>
						<li class="breadcrumb-item"><a href="tables">회원관리</a></li>
						<li class="breadcrumb-item active"><a href="memberDetail">회원상세보기</a></li>
					</ol>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table mr-1"></i> ${board.mem_id } 회원님
						</div>
						<div class="card-body">



							<section class="panel">


								<form class="parsley-form" action="upupup" method="post">
									<input name="mem_no" type="hidden" value="${ board.mem_no }">
									<div class="row">
										<div class="col-md-6">

											<div class="form-group">

												<div class="form-group">
													<label>아이디</label>
													<div>
														<input type="text" class="form-control" name=""
															data-parsley-required="true" id="mem_id"
															data-parsley-trigger="change"
															placeholder="${board.mem_id }" value="${board.mem_id }" disabled>
													</div>
												</div>

												<label>닉네임</label>
												<div>
													<input type="text" class="form-control" name="mem_nickname"
														data-parsley-required="true" data-parsley-trigger="change"
														id="mem_nickname" placeholder="${board.mem_nickname }"
														value="${board.mem_nickname } ">
												</div>
											</div>

											


											<div class="form-group">
												<label>가입연도</label> <input class="form-control" type="date" name="mem_regdate"  id="mem_regdate"
													 value="${board.mem_regdate }" disabled>
										
											</div>

											

<!-- 											<div class="form-group"> -->
<!-- 												<label>정지횟수</label> <input class="form-control" type="text"  -->
<!-- 													placeholder="0" disabled=""> -->


<!-- 											</div> -->
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Email</label>
												<div>
													<input type="text" class="form-control" name="mem_email"
														data-parsley-type="email" data-parsley-required="true"
														id="mem_email" data-parsley-trigger="change"
														placeholder="${board.mem_email }"
														value="${board.mem_email }">
												</div>

											</div>




											<div class="form-group">
												<label>등급</label>
												<div>
													<input type="text" class="form-control" name="mem_grade_no"
														data-parsley-required="true" data-parsley-trigger="change"
														id="mem_grade_no" placeholder="${board.mem_grade_no }"
														value="${board.mem_grade_no }" disabled>
												</div>
											</div>
												
												<div class="form-group">
												<label>누적신고횟수</label> 
												<div>
													<input class="form-control" name="mem_declare" id="mem_declare"
													type="text" placeholder="${board.mem_declare }"
													value="${board.mem_declare } " disabled>

												</div>

											</div>

										</div>

										<br>

									</div>
									<br>
									<div class="col-md-12" align='center'>
										<div class="demo-button">
											<label></label>
											<div>
												
												<button type="button" class="btn btn-primary"
													style="width: 45%;" onclick="location.href='memberList'">목록가기</button>
												&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<button style="width: 45%;" type="submit"
													class="btn btn-success" id=btnUpdate>Save</button>
											
											</div>
										</div>
									</div>

								</form>
							</section>
						</div>





					</div>
				</div>
			</main>
<!-- 			<footer class="py-4 bg-light mt-auto"> -->
<!-- 				<div class="container-fluid"> -->
<!-- 					<div -->
<!-- 						class="d-flex align-items-center justify-content-between small"> -->
<!-- 						<div class="text-muted">Copyright &copy; Your Website 2020</div> -->
<!-- 						<div> -->
<!-- 							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms -->
<!-- 								&amp; Conditions</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</footer> -->


	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery/dist/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/chosen_v1.4.0/chosen.jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/fuelux/pillbox.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/fuelux/spinner.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/scripts/form-custom.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery.placeholder.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/switchery/dist/switchery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/fastclick/lib/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery_appear/jquery.appear.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery.easing/jquery.easing.js"></script>





	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/demo/datatables-demo.js"></script>
</body>
</html>
