var app=angular.module("qna",[]);




app.controller("qnaPage1",["$scope","$http","httpServiceCall","angularServices",function($scope,$http,httpServiceCall,angularServices){
	var qType="";
	$scope.init=function(){
		console.log(' qnaPage1 init() called');
		var qPattern=[];
		$scope.typeOfQuestion=[{"key":"-1","value":"----Select-----"},{"key":"1","value":"MCQ"},{"key":"2","value":"Comprehnsive Question"}];
		$scope.phase1Selected=false;
		
	}
	$scope.showNextDiv=function(){
	//	$scope.MAQ=false;
	var selectedVal=$scope.qType;
	console.log('Selected Value '+selectedVal);
	if(selectedVal==='1'){
		$scope.phase1Selected=true;
		$scope.comprehensive=false;
	}else{
		$scope.phase1Selected=false;
		$scope.comprehensive=true;
	}
}
$scope.showNextCheckBox=function(MAQ){
	$scope.MAQ=MAQ;
	console.log("MAQ Check Box Clicked ::" +MAQ+"---$scope value ::"+$scope.MAQ);
}
$scope.makeQuestionPatteren=function(){
	var id=$scope.qType;
	console.log("id :"+id+" $cc ::"+$scope.qType);
	var qTypeSelected="";
	var qPattern="";
	var qList=$scope.typeOfQuestion;
	for(var i=0;i<qList.length;i++){
		console.log("---"+qList[i]);
			//var obj=JSON.parse(qList[i]);
			var obj=qList[i];
			if(id===obj.key){
				console.log(" Key :"+obj.key +" Value :"+obj.value);
				qTypeSelected=obj.value;
			}
		}
		console.log("id :"+id);
		if(id==2)
		{
			console.log("Word count "+$scope.myQnAForm.totalWord.$viewValue);
			qPattern={"type":qTypeSelected,"typeCode":id,"pattern":{"wordCount":$scope.myQnAForm.totalWord.$viewValue}};
			console.log(" final Json :"+JSON.stringify(qPattern));
		}
		else if(id==1)
		{
			qPattern={"type":qTypeSelected,"typeCode":id,"pattern":{"multipleAnswer":$scope.MAQ,"NumberOfQuestion":$scope.myQnAForm.TotalQ.$viewValue}}
			
			console.log(" final Json ::::"+JSON.stringify(qPattern));
		}/*for(var i=0;i<$scope.typeOfQuestion.length;i++){}
		var qType={
		}
		var qPattern={"type":$scope.};*/
		console.log("Calling Http Service"+JSON.stringify(httpServiceCall.addfns(qPattern)));
		//console.log("----------------"+httpServiceCall.addfns(qPattern));

	}

}]);
app.service('angularServices', function ($http) {

	this.squareofnumber = function (x) {
		console.log("-----"+x);

	return x;

	}

	});
app.service('httpServiceCall', function($http) { 
	
	this.addfns = function(qPattern) {    
		console.log('Custom service httpServiceCall function called '+JSON.stringify(qPattern));    
		
		var data="";
		var url="http://localhost:8081/QnAProjectV1.0/rest/QnAFirstController";
		var config="";
		var myResponseData =$http({
			method :'POST',
			url : 'http://localhost:8081/QnAProjectV1.0/rest/QnAFirstController',
			headers: {
				   'Content-Type': 'application/json'
				 },
			data :qPattern
		})
		.then(function(response){
			var jsonVar=response.data;//JSON.parse(response.data);
			console.log(JSON.stringify(response.data)+' Value='+jsonVar.ErrMsg+" Value 2:"+jsonVar.ErrCode);
			//console.log(JSON.parse(response.data));
		//	$scope.returnVal=response.data;
			//console.log(dataval.Name);
			myResponseData= response.data;
		},function(response){
			console.log(response);
			myResponseData= response.data;
		});
		
		console.log(JSON.stringify(myResponseData)+'------');
		
		/*$http.get(url, data,{
		    headers : {
		        'Content-Type' : 'application/json; charset=UTF-8'
		    }
		}).then(function (response) {

			console.log("Success");
			// This function handles success

			}, function (response) {
				console.log("Failure");
			// this function handles error

			});*/
		return myResponseData;

	}

});

