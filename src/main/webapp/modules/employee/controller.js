function employeeController($rootScope, $scope, $log) {
	$log.debug('employeeController...');
	$rootScope.viewName = 'Employees';
	
}
appControllers.controller('employeeController', employeeController);
