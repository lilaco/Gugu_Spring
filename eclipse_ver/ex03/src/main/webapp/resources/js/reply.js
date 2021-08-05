console.log("Reply Module......");

var replyService = (function(){
	
	/* 내부함수 설정? */
	function add(reply, callback){
		console.log("reply..........");
	}
	
	return {add:add};
})();