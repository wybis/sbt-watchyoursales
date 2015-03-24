function rootController($scope, $log, $location, $window, $rootScope) {

	$scope.viewSource = function() {
		var s = 'view-source:localhost:1121/' + $rootScope.currentViewSrcUrl;
		$log.info(s);
		$window.open(s);
	};

	$log.info('rootController...');
}
appControllers.controller('rootController', rootController);

var dependents = [ 'ngRoute', 'ngSanitize' ];
dependents.push('ngStorage');
dependents.push('green.inputmask4angular');
dependents.push('ngNotify');
//dependents.push('oitozero.ngSweetAlert');
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

	$routeProvider.when('/notFound', {
		templateUrl : 'modules/zgeneral/notFound-d.html'
	});

	$routeProvider.when('/home', {
		templateUrl : 'modules/home/d.html',
		controller : 'homeController',
		reloadOnSearch : false
	});

	$routeProvider.when('/transfer', {
		templateUrl : 'modules/transfer/d.html',
		controller : 'transferController',
		reloadOnSearch : false
	});

	$routeProvider.when('/products', {
		templateUrl : 'modules/product/d.html',
		controller : 'productController',
		reloadOnSearch : false
	});

	$routeProvider.when('/customers', {
		templateUrl : 'modules/customer/d.html',
		controller : 'customerController',
		reloadOnSearch : false
	});

	$routeProvider.when('/employees', {
		templateUrl : 'modules/employee/d.html',
		controller : 'employeeController',
		reloadOnSearch : false
	});

	$routeProvider.when('/settings', {
		templateUrl : 'modules/setting/d.html',
		controller : 'settingController',
		reloadOnSearch : false
	});

	$routeProvider.when('/signOut', {
		templateUrl : 'modules/session/signOut-d.html',
		controller : 'signOutController',
		reloadOnSearch : false
	});

	$routeProvider.when('/theme', {
		templateUrl : 'modules/theme/d.html',
		controller : 'themeController',
		reloadOnSearch : false
	});

	$routeProvider.otherwise({
		redirectTo : '/notFound'
	});

});

function appInit($log, $rootScope, $location, $sessionStorage) {
	$log.info('Initialization started...');

	$rootScope.$on("$routeChangeStart", function(event, next, current) {
		// $log.info('Location : ', $location.path());
		var curLocPath = $location.path();
		// $log.info('Before Current Location : ', curLocPath);
		if (curLocPath == '/notFound' || curLocPath == '/signIn'
				|| curLocPath == '/signOut') {
			return;
		}
		$sessionStorage.wysCLP = curLocPath;
		// $log.info('Stored Location : ', $sessionStorage.wysCLP);

		var srcUrl = $location.absUrl().indexOf('index');
		srcUrl = $location.absUrl().substring(0, srcUrl);
		srcUrl = srcUrl + next.templateUrl
		$rootScope.currentViewSrcUrl = srcUrl;
		// $log.info('srcUrl = ' + srcUrl);
	});

	$rootScope.$on("$routeChangeSuccess", function(event, next, current) {
		// $log.info('Location : ', $location.path());
		var curLocPath = $location.path();
		// $log.info('After Current Location : ', curLocPath);
	});

	var path = $sessionStorage.wysCLP;
	if (!path) {
		path = '/home';
	}
	$location.path(path);

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', '$sessionStorage', appInit ]);
