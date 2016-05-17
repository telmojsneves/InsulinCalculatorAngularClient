'use strict';


/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {

    $scope.fetchCarsList = function() {
        $http.get('cars/carlist.json').success(function(results){
            $scope.cars = results;
        });
    };

    $scope.addNewCar = function(newCar) {
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchCarsList();
        });
        $scope.carName = '';
    };

/*

    $scope.removeCar = function(car) {
        $http.delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
    };

    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });

    };
*/

    $scope.fetchCarsList();
};
