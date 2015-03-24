function rootController($rootScope, $scope, $log, $http, $filter, $timeout) {

	$scope.message = '';

	$scope.execute = function(path) {
		$http.get(path).success(function(response) {
			$scope.message = response;
		})
	};

	$scope.branchsJson = [ {
		id : '-',
		name : '<Select JSON File>'
	} ];
	$scope.branchJson = $scope.branchsJson[0];

	$http.get('../modules/system/agency.json').success(function(response) {
		// $log.info(response);
		_.forEach(response, function(item) {
			$scope.branchsJson.push(item);
		})
	});

	$scope.branchJsonClazz = 'disabled';

	$scope.onAgencyChange = function() {
		var branchJson = $scope.branchJson;
		if (branchJson.id == '-') {
			return;
		}
		$log.info(branchJson);

		$scope.branchJsonClazz = 'active';

		var path = '../modules/system/' + branchJson.id;
		$http.get(path).success(function(response) {
			$log.info(response);
			branchJson.value = response;
			branchJson.json = $filter('json')(branchJson.value, '    ');
			$log.info(branchJson.json);
			$scope.branchJsonClazz = 'disabled';
		}).error(function(error) {
			$scope.branchJsonClazz = 'disabled';
		});
	};

	$scope.saveMasterTriggered = false;
	$scope.saveMaster = function() {
		$scope.branchJsonClazz = 'active';
		$timeout(function() {
			var branchJson = $scope.branchJson;
			var f = $http.post('../system/saveMaster', branchJson.json);
			f.success(function(response) {
				$scope.message = response;
				$scope.branchJsonClazz = 'disabled';
			}).error(function(error) {
				$scope.branchJsonClazz = 'disabled';
			});
		}, 5000);
	};

	$log.info('rootController...');
}
appControllers.controller('rootController', rootController);

var dependents = ['ngSanitize' ];
dependents.push('ngStorage');
dependents.push('ngNotify');
dependents.push('app.filters');
dependents.push('app.directives');
dependents.push('app.services');
dependents.push('app.controllers');
var app = angular.module('app', dependents);

app.config(function($httpProvider) {
	$httpProvider.interceptors.push('generalHttpInterceptor');
});

function appInit($log, $rootScope, $location, $sessionStorage) {
	$log.info('Initialization started...');

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', '$sessionStorage', appInit ]);
