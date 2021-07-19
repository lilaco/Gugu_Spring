<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!-- end col-lg-12 -->
</div>
<!-- end row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Modify Page</div>
			<!-- panel-heading end point -->
			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
				
					<div class="form-group">
						<label>Bno</label> 
						<input class="form-control" name="bno" value="<c:out value="${board.bno}"/>" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value="<c:out value="${board.title}"/>"/>	
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" row="3" name="content"><c:out value="${board.content}"/></textarea>
					</div>	
					<div class="form-group">
						<label>Writer</label> 
						<input class="form-control" name="writer" value="<c:out value="${board.writer}"/>" readonly="readonly"/>
					</div>
					
					<div class="form-group">
						<label>RegDate</label>
						<input class="form-control" name="regDate" value='<fmt:formatDate pattern = "yyyy/MM/dd" value= "${board.regDate}"/>' readonly="readonly"/>
					</div>
					
					<div class="form-group">
						<label>Update Date</label>
						<input class="form-control" name="updateDate" value='<fmt:formatDate pattern = "yyyy/MM/dd" value= "${board.updateDate}"/>' readonly="readonly"/>
					</div>
					
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-into">List</button>
					
				</form>
			</div><!-- end panel-body -->
		</div><!-- end panel-default -->
	</div><!-- end col-lg-12 -->
</div><!-- end row -->

<%@ include file="../includes/footer.jsp" %>

<script>
$(document).ready(function(){
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();// 기본 동작 막기
		
		var operation = $(this).data("oper");
		
		console.log(operation);
	
		if(operation === 'remove') {
			formObj.attr("action", "/board/remove");
		} else if (operation === 'list'){
			//move to list ,form으로 목록페이지로 이동할 수 있도록 한다.
			formObj.attr("action", "/board/list").attr("method","get");
			//.clone()?? form태그에서 필요한 부분만 잠시 복사(clone)하여 보관.
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
		}
		formObj.submit();
	});
});

</script>