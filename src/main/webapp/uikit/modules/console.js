function rootController($rootScope, $scope, $log, $http, $filter, $timeout) {

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
		redirectTo : '/home'
	});

	$routeProvider.when('/home', {
		templateUrl : 'modules/console/home/d.html',
		controller : 'homeController'
	});

	$routeProvider.when('/systemInfo', {
		templateUrl : 'modules/console/systemInfo/d.html',
		controller : 'systemInfoController'
	});

	$routeProvider.when('/notFound', {
		templateUrl : 'modules/zgeneral/notFound-d.html'
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
