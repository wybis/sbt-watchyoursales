function transferController($rootScope, $scope, $log) {
	$log.debug('transferController...');
	$rootScope.viewName = 'Transfer';

}
appControllers.controller('transferController', transferController);
