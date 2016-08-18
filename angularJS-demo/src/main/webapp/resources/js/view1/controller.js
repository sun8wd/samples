define(['app','view1/service'],function(app){
	app.controller("view1",function($scope,view1Service){
		$scope.user=view1Service.getUser();
	});
});