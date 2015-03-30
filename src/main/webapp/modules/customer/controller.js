function customerController($rootScope, $scope, $log) {
	$log.debug('customerController...');
	$rootScope.viewName = 'Customers';

}
appControllers.controller('customerController', customerController);
