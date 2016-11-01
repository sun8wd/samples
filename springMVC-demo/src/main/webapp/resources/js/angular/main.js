(function() {
	window.celloudApp = angular.module("celloudApp", [ "ngResource",
			"ui.router" ]);
	celloudApp.config(function($stateProvider) {
		$stateProvider.state("hello", {
			url : "/hello",
			templateUrl : "pages/angularjs/hello.jsp",
			controller : "hello"
		}).state("about", {
			url : "/about",
			templateUrl : "pages/angularjs/about.jsp",
			controller : "about"
		}).state("user", {
			template : "<ui-view></ui-view>",
		}).state("user.list", {
			url : "/users",
			templateUrl : "pages/angularjs/user-list.jsp",
			controller : "userList"
		}).state("user.detail", {
			url : "^/user/:id",
			templateUrl : "pages/angularjs/user-detail.jsp",
			controller : "userDetail"
		});
	});
	celloudApp.controller("hello", function($scope, $rootScope) {
		$scope.name = "sun";
	});
	celloudApp.controller("about", function($scope, $rootScope) {

	});
	celloudApp.controller("userList", function($scope, $rootScope, $state,
			$stateParams) {
		$scope.id = $stateParams.id;
		console.log("user:" + $stateParams.id);
	});
	celloudApp.controller("userDetail", function($scope, $rootScope, $state,
			$stateParams) {
		$scope.id = $stateParams.id;
		console.log("user:" + $stateParams.id);
	});
}());