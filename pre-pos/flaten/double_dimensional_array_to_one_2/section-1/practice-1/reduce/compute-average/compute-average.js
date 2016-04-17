'use strict';

function compute_average(collection) {
  //在这里写入代码
  var sum = 0;
  var count = 0;
  for(var i = 0; i < collection.length; i++){
    count++;
    sum += collection[i];
  }
  return sum/count;
}
