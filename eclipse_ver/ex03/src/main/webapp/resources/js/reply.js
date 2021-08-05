console.log("Reply Module......");

var replyService = (function(){
	
	/* 내부함수 설정? */
	function add(reply, callback, error){
		console.log("add reply..........");
		
		// AJAX를 이용하여 POST 방식으로 호출
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, err) {
				if (error) {
					error(err);
				}
			}
		})
	}
	
	return {add:add};
})();