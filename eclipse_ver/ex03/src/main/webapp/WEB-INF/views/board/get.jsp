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

<%@ include file="../includes/footer.jsp" %>

<!-- script의 모듈화 -->
<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
$(document).ready(function(){
	
	console.log(replyService);
	
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