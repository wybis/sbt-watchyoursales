function productController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Books';

	$log.debug('productController...');
}
appControllers.controller('productController', productController);
