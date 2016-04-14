var messageUtils = (function(messageUtils) {
	var self = messageUtils || {};
	var hostname = window.location.hostname;
	var port = window.location.port||80;
	var wsUrl = "ws://"+hostname+":"+port+"/springMVC-demo/webSocketServer";
	if ('WebSocket' in window) {
		console.log('WebSocket');
		ws = new WebSocket(wsUrl);
	} else if (window.MozWebSocket) {
		console.log('MozWebSocket');
		ws = new MozWebSocket(wsUrl);
	} else {
		ws = new SockJS("/springMVC-demo/sockjs/webSocketServer");
	}
	var maxId = 0;
	self.getMessages = function() {
		$.get("chats?id=" + maxId, function(data) {
			$.each(data, function(index, item) {
				var date = new Date(parseInt(item.date)).toLocaleString();
				$("#chats").append(
						'<p><a><strong>' + item.username + '(' + date
								+ ')：</strong></a></p>');
				$("#chats").append('<p>' + item.message + '</p>');
				if (item.id > maxId) {
					maxId = item.id;
				}
				$("#chats").scrollTop($("#chats")[0].scrollHeight);
			});
		});
	};
	self.getUsers = function() {
		$.get("users", function(data) {
			$("#users").html("");
			$.each(data, function(index, item) {
				$("#users").append(
						'<li class="list-group-item">' + item + '</li>');
			});
		});
	};
	var opearter = {
		"users" : self.getUsers,
		"chats" : self.getMessages
	}
	ws.onopen = function() {
	};
	ws.onmessage = function(e) {
		opearter[e.data]();
	};
	ws.onclose = function() {
		//window.location.reload();
	};
	self.sendMessage = function() {
		var message = $.trim($("#message").val());
		if (message) {
			ws.send(message);
			$("#message").val("");
		}
	};
	$("#message").keyup(function(event){
		if (event.ctrlKey && event.keyCode == 13) {
			self.sendMessage();
		  }
	});
	return self;
})(messageUtils||{});
messageUtils.getMessages();
