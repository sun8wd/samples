define(['app','view2/service'],function(app){
	app.controller("view2",function($scope,view2Service){
		$scope.username=view2Service.getUsername();
	});
});