function signInController($rootScope, $scope, $log, wydNotifyService, $http,
		$window, $timeout) {
	$rootScope.viewName = 'SignIn';

	$scope.message = '';

	$scope.user = {
		userId : '',
		password : ''
	};

	function signIn() {
		wydNotifyService.removeAll();
		$log.info('singing in...');
		$scope.message = '';

		var path = 'sessions/signIn';
		$http.post(path, $scope.user).success(function(response) {
			if (response.type != 0) {
				$scope.message = response.message;
				wydNotifyService.addError($scope.message, true);
			} else {
				$window.location = 'home-d.html';
			}
			$log.info(response);
		}).error(function(error) {
			$log.debug("unable to login...");
		});
	}
	$scope.signIn = signIn;

	// $timeout(function() {
	$log.info('Before signin...');
	$scope.user.userId = 'vteial@watchyoursales';
	// $scope.signin();
	$log.info('After signin...');
	// }, 1000);

	$log.debug('signInController...');
}
appControllers.controller('signInController', signInController);
