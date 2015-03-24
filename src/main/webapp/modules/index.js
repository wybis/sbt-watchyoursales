function rootController($scope, $log, $location, $window, $rootScope) {

	$log.info('rootController...');
}
appControllers.controller('rootController', rootController);

var dependents = [ 'ngRoute', 'ngSanitize' ];
dependents.push('ngStorage');
dependents.push('ngNotify');
dependents.push('app.filters');
dependents.push('app.directives');
dependents.push('app.services');
dependents.push('app.controllers');
var app = angular.module('app', dependents);

app.config(function($httpProvider) {
	$httpProvider.interceptors.push('generalHttpInterceptor');
});

app.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/', {
		redirectTo : '/index'
	});

	$routeProvider.when('/notFound', {
		templateUrl : 'modules/zgeneral/notFound-d.html'
	});

	$routeProvider.when('/index', {
		templateUrl : 'modules/index/d.html',
		controller : 'indexController',
		reloadOnSearch : false
	});
	
	$routeProvider.when('/features', {
		templateUrl : 'modules/zgeneral/features-d.html'
	});
	
	$routeProvider.when('/about', {
		templateUrl : 'modules/zgeneral/about-d.html'
	});

	$routeProvider.when('/contact', {
		templateUrl : 'modules/zgeneral/contact-d.html'
	});

	$routeProvider.when('/signIn', {
		templateUrl : 'modules/session/signIn-d.html',
		controller : 'signInController',
		reloadOnSearch : false
	});

	$routeProvider.otherwise({
		redirectTo : '/notFound'
	});

});

function appInit($log, $rootScope, $location, $sessionStorage) {
	$log.info('Initialization started...');

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', '$sessionStorage', appInit ]);
