function rootController($rootScope, $scope, $log, wydNotifyService) {

	$scope.info = function() {
		wydNotifyService.addInfo('info message...', true);
	};

	$scope.success = function() {
		wydNotifyService.addSuccess('success message...', true);
	};

	$scope.warning = function() {
		wydNotifyService.addWarning('warning message...', true);
	};

	$scope.error = function() {
		wydNotifyService.addError('erro message...', true);
	};

	$log.info('rootController...');
}
appControllers.controller('rootController', rootController);

var dependents = [ 'ngSanitize' ];
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

function appInit($log, $rootScope, $location, $sessionStorage) {
	$log.info('Initialization started...');

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', '$sessionStorage', appInit ]);
