
'use strict';


/**
 * CarController
 * @constructor
 */
var MidpController = function($scope, $http) {

    $scope.isSampleArrayMaxValue = false;

    $scope.values = {
        input_a: '',
        input_b: 12,
        input_c: '',
        input_d: '',
        input_e: '',
    };


    $scope.samples_array = [];

            $scope.add = function () {
              $scope.samples_array.push({
                physical: "",
                drops: ""
              });

              if ($scope.samples_array.length == 10){
                  $scope.isSampleArrayMaxValue = true;
              }
            };




    //get data from server using data sended
    $scope.getMidp = function(data) {

        var i = 0;
        //just for testing
        for (i = 0; i < $scope.samples_array.length ; i++){
            $scope.values["physical_" + i] = $scope.samples_array[i].physical;
            $scope.values["drops_" + i] = $scope.samples_array[i].drops;

        }


        $http.get('api/v1/midp/', {params:$scope.values}).success(function(results){
            $scope.results = results;
            console.log(results);
        });

        $scope.values = {
                input_a: '',
                input_b: 12,
                input_c: '',
                input_d: '',
                input_e: "",
        };

        $scope.samples_array = [];

    };

    $scope.isThisDisabled=function(){

        var isAvailable = $scope.isArrayValid();


        if (isAvailable == false){
            return true;
        }

        var sr = "";

        for(var i in $scope.values)
        {
            if (i == "input_e"){
                if ($scope.values[i] === undefined){
                    return true;
                }
            }
            else if (!$scope.values[i])
                    return true;
        }


       return false;
   }

   $scope.isArrayValid = function(){

       var i = 0;
       var size = $scope.samples_array.length;
       var isAvailable = false;

       var sr = "";

       if (size >= 2 && size <= 10 && size%2==0){
           for (i = 0; i < size; i++) {


                if (($scope.samples_array[i].physical != '' || $scope.samples_array[i].physical !== sr) && $scope.samples_array[i].drops != ''

                    ){
                        if ($scope.samples_array[i].physical >= 0 && $scope.samples_array[i].physical <= 10 &&
                            $scope.samples_array[i].drops >= 15 && $scope.samples_array[i].drops <= 100){
                                isAvailable = true;
                        }
                        else{
                            return false;
                        }
                }
                else{
                    return false;
                }
            }
        }
        return isAvailable;


   }


};
