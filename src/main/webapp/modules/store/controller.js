function storeController($rootScope, $scope, $log) {
	$log.debug('storeController...');
	$rootScope.viewName = 'Stores';
}
appControllers.controller('storeController', storeController);
