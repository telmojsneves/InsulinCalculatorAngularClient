
'use strict';


/**
 * CarController
 * @constructor
 */
var MidsController = function($scope, $http) {

    $scope.values = {
        input_a: '',
        input_b: 12,
        input_c: '',
        input_d: '',
        input_e: 50,
    };


    //get data from server using data sended
    $scope.getMids = function(data) {

        $http.get('api/v1/mids/', {params:$scope.values}).success(function(results){
            $scope.results = results;
            console.log(results);
        });


        $scope.values = {
                input_a: '',
                input_b: 12,
                input_c: '',
                input_d: '',
                input_e: 50,
        };


    };

    $scope.isThisDisabled=function(){

        for(var i in $scope.values)
        {
            if(!$scope.values[i])
                return true;
        }
       return false;
   }

};
