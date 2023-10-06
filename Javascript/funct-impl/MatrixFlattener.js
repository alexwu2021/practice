// 2675. Array of Objects to Matrix
// Write a function that converts an array of objects arr into a matrix m.

// arr is an array of objects or arrays. Each item in the array can be deeply nested with child arrays and child objects. It can also contain numbers, strings, booleans, and null values.


/**
 * @param {Array} arr
 * @return {Matrix}
 */

const jsonToMatrix = function(arr) {
    
    const isObject = x => (x !== null && typeof x === 'object');
      
    const getKeys = object => {
      if (!isObject(object)) return ['']; 
    
      const result = [];
      for (const key of Object.keys(object)) {
            const childKeys = getKeys(object[key]);
            for (const childKey of childKeys) {
            result.push(childKey ? `${key}.${childKey}` : key); 
            }
        }
      return result;
    };
  
    const keys = Array.from(arr.reduce((acc, curr) => { getKeys(curr).forEach(key => acc.add(key)); return acc; }, new Set())).sort();
  
    const getValue = (obj, path) => {
        const paths = path.split('.');
        let i = 0;
        let value = obj;
        while (i < paths.length && isObject(value)) {
            value = value[paths[i++]];
        }
        return i < paths.length || isObject(value) || value === undefined ? '' : value;
    };
  
    
    const matrix = [keys];
    arr.forEach(obj => {
        matrix.push(keys.map(key => getValue(obj, key)));
    });  
    return matrix;
  };







//   const getAboutUsLink = require("./index");

  test("Return about-us for english language", () => {
  
      expect(getAboutUsLink("en-UK")).toBe("/about-us");
  
  });


// Example 1:

// Input: 
var arr = [
  {"b": 1, "a": 2},
  {"b": 3, "a": 4}
];


// Output: 
// [
//   ["a", "b"],
//   [2, 1],
//   [4, 3]
// ]

// Example 2:

// Input: 
// arr = [
//   {"a": 1, "b": 2},
//   {"c": 3, "d": 4},
//   {}
// ]
// Output: 
// [
//   ["a", "b", "c", "d"],
//   [1, 2, "", ""],
//   ["", "", 3, 4],
//   ["", "", "", ""]
// ]


