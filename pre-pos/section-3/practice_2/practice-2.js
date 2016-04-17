function create_updated_collection(collection_a, object_b) {
  //在这里写入代码
  var result = [];
  var d = true;

  collection_a.forEach(//element 数组中的每个元素
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
