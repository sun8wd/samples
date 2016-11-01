define(['app','angular-resource'],function(app){
	app.service('view1Service',function($resource){
		this.getUser = function(){
			return $resource("resources/data/user1.json").get();
		};
	});
	app.factory("test",function($resource){
		var self = {};
		self.find = function(){
			
		}
		self.get = function(){
			
		}
		return self;
	});
});