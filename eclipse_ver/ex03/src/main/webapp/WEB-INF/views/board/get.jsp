<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- end col-lg-12 -->
</div>
<!-- end row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			<!-- panel-heading end point -->
			<div class="panel-body">
			
					<div class="form-group">
						<label>Bno</label> 
						<input class="form-control" name="bno" value="<c:out value="${board.bno}"/>" readonly="readonly"/>
					</div>
					
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly="readonly"/>	
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" row="3" name="content" readonly="readonly"><c:out value="${board.content}"/></textarea>
					</div>	
					<div class="form-group">
						<label>Writer</label> 
						<input class="form-control" name="writer" value="<c:out value="${board.writer }"/>" readonly="readonly"/>
					</div>
					
					<button data-oper="modify" class="btn btn-default">Modify</button>
					<button data-oper="list" class="btn btn-info">List</button>
					
					<!-- 수정, 목록 버튼을 form 처리하여 링크를 처리한다. 264 pages -->
					<!-- type="hidden"으로 설정시 내용은 화면에 보이지 않는다. -->
					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
						<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
						<input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
						
						<!-- 조회페이지에도 검색키워드(keyword)와 검색조건(type)을 넘긴다 -->
						<input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>">
						<input type="hidden" name="type" value="<c:out value='${cri.type}'/>">
					</form>
				
			</div><!-- end panel-body -->
		</div><!-- end panel-default -->
	</div><!-- end col-lg-12 -->
</div><!-- end row -->

<!-- reply 관련 HTML -->
<div class="row">
	<div class="col-lg-12">
	
		<!-- /.panel -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
			</div>
			
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<ul class="chat">
					<!-- start reply -->
					<li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2021-08-06 20:51</small>
							</div>
							<p>Good job!</p>
						</div>
					</li>
					<!-- End reply -->
				</ul>
				<!-- ./ end ul -->
			</div>
			<!-- /.panel .chat-panel -->
		</div>
	</div>
	<!-- ./ end row -->
</div>

<%@ include file="../includes/footer.jsp" %>

<!-- script의 모듈화 -->
<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
$(document).ready(function(){
	
	console.log(replyService);
	console.log("=================");
	console.log("JS TEST");
	
	var bnoValue = '<c:out value="${board.bno}"/>';
	
	//for replyService add test from reply.js
	replyService.add(
		{reply:"JS Test", replyer:"tester", bno:bnoValue}
		,
		function(result){
			alert("RESULT: " + result);
		}
	);
	
	//from replyService getList from reply.js
	replyService.getList({bno:bnoValue, page:1}, function(list){
		
		for(var i = 0, len = list.length||0; i < len; i++ ){
			console.log(list[i]);
		}
	});
	
	// 23번 댓글 삭제 테스트 from replyService remove from reply.js
	replyService.remove(23, function(count) {
		console.log(count);
		
		if (count === "success") {
			alert("REMOVED");
		}
	}, function(err) {
		alert('ERROR...');
	});
	
	// 22번 댓글 수정 테스트 from replyService update from reply.js
	replyService.update({
		rno : 22,
		bno : bnoValue,
		reply : "Modified Reply...."
	}, function(result) {
		alert("수정완료....");
	});
	
	// 댓글 조회처리 from replyService get from reply.js
	replyService.get(10, function(data){
		console.log(data);
	});
	
	var operForm = $("#operForm");
	
	$("button[data-oper='modify']").on("click", function(e){
		
		operForm.attr("action","/board/modify").submit();
		
	});
	
	$("button[data-oper='list']").on("click", function(e){
		
		operForm.find("#bno").remove();
		operForm.attr("action","/board/list");
		operForm.submit();
		
	});
});
</script>