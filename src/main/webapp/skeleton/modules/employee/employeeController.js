function employeeController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Employees';

	$log.debug('employeeController...');
}
appControllers.controller('employeeController', employeeController);
