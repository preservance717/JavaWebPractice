function count_same_elements(collection) {
  //在这里写入代码
  var count = 1;
  var result = [];
 //方法一
  for(var i = 0; i < collection.length; i++){
    if(collection[i] === collection[i+1]){
      ++count;
    }else{
      // var object = {};
      // object.key = collection[i];
      // object.count = count;
      // result.push(object);
      result.push({key:collection[i],count:count});
      count = 1;
    }
  }
  //push时，object若为全局的对象，数组添加时，则会被赋新的值
  // for(var i=0; i < 10; i++){
  //   count++;
  //   result.push(count);
  // }


  // var object = {};
  // for(var i=0; i < 10; i++){
  //   count++;
  //   object.count = count;
  //   result.push(object);
  // }
  return result;
}
