function create_updated_collection(collection_a, object_b) {
  var result = [];
  var collection_c = [];
  var count = 1;

  for(var i = 0; i < collection_a.length; i++){
    if(collection_a[i] === collection_a[i+1]){
      count++;
    }else{
      collection_c.push({key:collection_a[i], count:count});
      count = 1;
    }
  }

  collection_c.forEach(//element 数组中的每个元素
    function compare(element){
      for(var i = 0; i < object_b.value.length; i++){
        if(element.key === object_b.value[i]){
          if(element.count >= 3){
            result.push({key:element.key,count:element.count-parseInt(element.count/3)});
          }

          d = false;
        }
      }
      if(d){
        result.push({key:element.key,count:element.count});
      }
      d = true;
    }
  );

  return result;
}
