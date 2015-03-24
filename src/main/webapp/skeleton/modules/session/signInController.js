function signInController($rootScope, $scope, $log, wydNotifyService, $http,
		$window, $timeout) {
	$rootScope.viewName = 'SignIn';

	$scope.message = null

	$scope.user = {
		userId : '',
		password : ''
	};

	function signIn() {
		wydNotifyService.removeAll();
		$log.info('singing in...');
		$scope.message = null;

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

	$log.debug('signInController...');
}
appControllers.controller('signInController', signInController);
