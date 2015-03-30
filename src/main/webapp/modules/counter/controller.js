function counterController($rootScope, $scope, $log) {
	$log.debug('counterController...');
	$rootScope.viewName = 'Counter';
	
}
appControllers.controller('counterController', counterController);
