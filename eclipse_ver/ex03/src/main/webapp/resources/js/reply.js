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
	
	/* List 처리 */
	function getList(param, callback, error) {
		
		var bno = param.bno;
		var page = param.page || 1;
		
		// Jquery의 getJSON
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
			function(data) {
				if (callback) {
					callback(data);
				}
			}).fail(function(xhr, status, err) {
				if(error) {
					error();
				}
			});
	}
	
	/* remove */
	function remove(rno, callback, error) {
		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			success : function(deleteResult, status, xhr) {
				if(callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, err) {
				if(error) {
					error(err);
				}
			}
		});
	}
	
	return {
		add : add,
		getList : getList,
		remove : remove
	};
})();