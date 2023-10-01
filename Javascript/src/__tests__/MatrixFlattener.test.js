const jsonToMatrix = require('../funct-impl/MatrixFlattener');
describe('test suite', () => {
     it('sample test1 ', () => {
         let arr = [
             {"b": 1, "a": 2},
             {"b": 3, "a": 4}
         ];
         let expected = [['a','b'],[2,1],[4,3]];
         let actual = jsonToMatrix(arr);
         expect(actual.length).toEqual(expected.length);
         expect(new Set(actual)).toEqual(new Set(expected));
     });

     it('sample test2 ', () => {
         let arr = [
             [{"a": null}],
             [{"b": true}],
             [{"c": "x"}]
         ];
         let expected = [
             ["0.a", "0.b", "0.c"],
             [null, "", ""],
             ["", true, ""],
             ["", "", "x"]
         ];
         let actual = jsonToMatrix(arr);
         expect(actual.length).toEqual(expected.length);
         expect(new Set(actual)).toEqual(new Set(expected));
     });

});
