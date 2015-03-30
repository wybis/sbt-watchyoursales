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
		$scope.signInClazz = 'active';
		$scope.message = '';

		$timeout(function() {
			$log.info('signin wait...');
		}, 3000);

		var path = 'sessions/signIn';
		$http.post(path, $scope.user).success(function(response) {
			if (response.type != 0) {
				$scope.message = response.message;
				$scope.user.userId = '';
				$scope.user.password = '';
				wydNotifyService.addError($scope.message, true);
			} else {
				$window.location = 'home-d.html';
			}
			$log.info(response);
			$scope.signInClazz = '';
		}).error(function(error) {
			$log.debug("unable to login...");
			$scope.signInClazz = '';
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
