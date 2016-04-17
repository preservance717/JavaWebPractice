function count_same_elements(collection) {
  var result = [];
  var count = 1;

  for(var i = 0; i < collection.length; i++){

    var existLine = collection[i].split("-");

    if(existLine[1]){
      result.push({key:existLine[0],count:parseInt(existLine[1])});
    }else{
      if(collection[i] === collection[i+1]){
        ++count;
      }else{
        result.push({key:collection[i],count:count});
        count = 1;
      }
    }
  }
  return result;
}
