function collect_same_elements(collection_a, collection_b) {

  var result = [];

  collection_a.forEach(
    function equal(element){
      for(var i = 0; i < collection_b[0].length; i++){
        if(element == collection_b[0][i]){
          result.push(element);
        }
      }
    }
  );
  return result;
}
