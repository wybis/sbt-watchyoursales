appFilters.filter('capitalizeFilter', function() {
	return function(input) {
		input = _.capitalize(input);
		return input;
	};
});

appDirectives.directive('wydFocusOn', function() {
	return function(scope, elem, attr) {
		return scope.$on('wydFocusOn', function(e, name) {
			if (name === attr.wydFocusOn) {
				return elem[0].focus();
			}
		});
	};
});

function wydFocusService($rootScope, $timeout) {
	return function(name) {
		return $timeout(function() {
			return $rootScope.$broadcast('wydFocusOn', name);
		});
	};
}
appServices.factory('wydFocusService', [ '$rootScope', '$timeout',
		wydFocusService ]);

appServices.factory('generalHttpInterceptor', function($log) {
	return {
		'request' : function(config) {
			return config;
		},

		'requestError' : function(rejection) {
			$log.error(rejection);
			return rejection;
		},

		'response' : function(response) {
			return response;
		},

		'responseError' : function(rejection) {
			$log.error(rejection);
			return rejection;
		}
	};
});
