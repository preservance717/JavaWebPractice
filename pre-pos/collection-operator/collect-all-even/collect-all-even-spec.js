'use strict';

describe('collect_all_even', function () {

  var collection_a = [1, 2, 3, 4, 5];
  var collection_b = [2, 4];

  it('选出给定区间中所有的偶数', function() {

    var result = collect_all_even(collection_a);
    expect(result).toEqual(collection_b);
  });
});

