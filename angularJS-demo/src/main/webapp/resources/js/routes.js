/**
 * Created with IntelliJ IDEA. User: Mateusz Date: 14.11.12 Time: 20:21
 */

'use strict';

define([ 'app', 'routes/view1', 'routes/view2' ], function(app) {
	return app.config(function($routeProvider) {
		$routeProvider.otherwise({
			redirectTo : '/view1'
		});
	});
});
