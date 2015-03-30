function indexController($rootScope, $scope, $log) {
	$log.debug('indexController...');
	$rootScope.viewName = 'Index';

}
appControllers.controller('indexController', indexController);
