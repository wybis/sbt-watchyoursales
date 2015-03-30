function transactionController($rootScope, $scope, $log) {
	$log.debug('transactionController...');
	$rootScope.viewName = 'Transactions';

}
appControllers.controller('transactionController', transactionController);
