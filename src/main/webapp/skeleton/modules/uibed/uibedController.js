function uibedController($rootScope, $scope, $log, wydNotifyService) {
	$rootScope.viewName = 'UI Bed';

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

	$log.debug('uibedController...');
}
appControllers.controller('uibedController', uibedController);
