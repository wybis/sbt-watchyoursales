function dealerController($rootScope, $scope, $log) {
	$log.debug('dealerController...');
	$rootScope.viewName = 'Dealers';

}
appControllers.controller('dealerController', dealerController);
