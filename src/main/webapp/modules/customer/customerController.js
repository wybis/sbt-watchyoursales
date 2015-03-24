function customerController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Hawkers';

	$log.debug('customerController...');
}
appControllers.controller('customerController', customerController);
