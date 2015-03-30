function stockController($rootScope, $scope, $log) {
	$log.debug('stockController...');
	$rootScope.viewName = 'Stocks';

}
appControllers.controller('stockController', stockController);
