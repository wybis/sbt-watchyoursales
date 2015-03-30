function productController($rootScope, $scope, $log) {
	$log.debug('productController...');
	$rootScope.viewName = 'Products';
	
}
appControllers.controller('productController', productController);
