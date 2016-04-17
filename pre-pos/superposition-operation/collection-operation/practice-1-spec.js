'use strict';

describe('hybrid_operation', function() {

  var collection = [1,5,7,11,35,67];

  it('每一个数*3 +2再算总和', function() {

    var result = hybrid_operation(collection);

    expect(result).toEqual(390);
  })
});
