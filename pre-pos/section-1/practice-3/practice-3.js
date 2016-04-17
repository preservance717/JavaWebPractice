function collect_same_elements(collection_a, object_b) {
  var result = [];
  collection_a.forEach(
    function equal(element){
      for(var i = 0; i < object_b.value.length; i++){
        if(element == object_b.value[i]){
          result.push(element);
        }
      }
    }
  );
  return result;
}
