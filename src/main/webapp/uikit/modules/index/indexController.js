function indexController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Index';

	$log.debug('indexController...');
}
appControllers.controller('indexController', indexController);
