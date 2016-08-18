'use strict';

require.config({
    baseUrl:'resources/js',
    paths:{
    	'angular':'//cdn.bootcss.com/angular.js/1.5.8/angular.min',
    	'angular-route':'//cdn.bootcss.com/angular.js/1.5.8/angular-route.min',
    	'angular-resource':'//cdn.bootcss.com/angular.js/1.5.8/angular-resource.min'
    },
    shim:{
        'angular':{
            exports:'angular'
        },
        'angular-route':{
        	deps:['angular'],
        	exports:'angular-route'
        },
        'angular-resource':{
        	deps:['angular'],
        	exports:'angular-resource'
        }
    },
    priority:[
        'angular'
    ],
    urlArgs:'v=1.1'
});
require([
    'angular',
    'angular-route',
    'angular-resource',
    'app',
    'controllers',
    'routes'
], function (angular) {
	angular.bootstrap(document, ['celloudApp']);
});