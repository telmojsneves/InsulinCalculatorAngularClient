
'use strict';


/**
 * CarController
 * @constructor
 */
var BidController = function($scope, $http) {

    $scope.values = {
        input_a: '',
    };


    //get data from server using data sended
    $scope.getBid = function(data) {

        $http.get('api/v1/bid/', {params:$scope.values}).success(function(results){
            $scope.results = results;
            console.log(results);
        });


        $scope.values = {
                input_a: '',
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
