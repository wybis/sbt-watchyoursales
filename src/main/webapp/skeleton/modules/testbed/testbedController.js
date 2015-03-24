function themeController($rootScope, $scope, $log, wydNotifyService) {
	$rootScope.viewName = 'Theme';

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

	$log.debug('themeController...');
}
appControllers.controller('themeController', themeController);
