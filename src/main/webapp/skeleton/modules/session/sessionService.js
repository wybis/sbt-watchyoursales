function sessionService($log, $http, $q) {
	var basePath = 'sessions', service = {};

	service.login = function(user) {
		var path = basePath + '/signIn';
		
		var deferred = $q.defer();
		$http.post(path, user).success(function(response) {
			if (response.type >= 0) {
				deferred.resolve(response);
			}
			//$log.info(response);
		}).error(function() {
			deferred.reject("unable to signing in...");
		});

		return deferred.promise;
	};

	service.logout = function() {
		var path = basePath + '/signOut';

		var deferred = $q.defer();
		$http.get(path).success(function(response) {
			if (response.type === 0) {
				deferred.resolve(response);
			}
			// $log.info(response);
		}).error(function() {
			deferred.reject("unable to signing out...");
		});

		return deferred.promise;
	};

	return service;
}
appServices.factory('sessionService', sessionService);