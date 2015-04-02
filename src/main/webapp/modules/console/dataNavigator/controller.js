function dataNavigatorController($rootScope, $scope, $log) {
	$log.debug('dataNavigatorController...');
	$rootScope.viewName = 'Data Navigator';

	$scope.refresh($routeParams.pathId);
}
appControllers.controller('dataNavigatorController', dataNavigatorController);
