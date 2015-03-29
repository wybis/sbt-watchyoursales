function signOutController($rootScope, $scope, $log, $http, $window) {
	$rootScope.viewName = 'SignOut';

	var path = 'sessions/signOut';
	$http.get(path).success(function(response) {
		$window.location = 'index-d.html';
		// $log.info(response);
	}).error(function() {
		deferred.reject("unable to logout...");
		$window.location = 'index-d.html';
	});

	$log.debug('signOutController...');
}
appControllers.controller('signOutController', signOutController);