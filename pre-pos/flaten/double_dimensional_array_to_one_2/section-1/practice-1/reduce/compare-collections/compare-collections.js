'use strict';

function compare_collections(collection_a, collection_b) {
  //在这里写入代码
  /*var result = (collection_a == collection_b);
  alter(result);*/
  //javascript是不能直接比较数组相等
  var result = false;
  result = (collection_a.sort().toString() == collection_b.sort().toString());
  return result;
}
