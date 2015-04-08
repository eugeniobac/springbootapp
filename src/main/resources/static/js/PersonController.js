(function() {
	var app = angular.module('angularjsapp', []);
	var url = "http://localhost:8080";


	app.config(['$httpProvider', function($httpProvider) {
	        $httpProvider.defaults.useXDomain = true;
	        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	    }
	]);

	app.controller('PersonController', ['$scope', '$http', function($scope, $http) {
		$scope.list = function() {
			$http.get(url + '/person/list').success(function(data) {
				$scope.personlist = data;
			});
		};


		$scope.save = function() {
			$http.post(url +  "/person/create", angular.toJson($scope.person)).success(function(data) {
				$scope.personlist.unshift(data);
			});
		};
		
		$scope.updateData = function(person) {
			$scope.person = person;
		};	

		$scope.update = function() {
			$http.put(url +  "/person/update", angular.toJson($scope.person)).success(function(data) {
				$scope.personlist.unshift(data);
				$scope.list();
			});
		};

		$scope.remove = function(person) {
			var id = person.id;
			$http['delete'](url + "/person/delete/" + id).success(function() {
				var index = $scope.personlist.indexOf(person);
				$scope.personlist.splice(index, 1);
			});
		};

		var init = function() {
			$scope.list();
		}();
	}]);

})();