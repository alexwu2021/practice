/**
 * @param {Object|Array} obj
 * @return {Object}
 */
var invertObject = function(obj) {
    return Object.keys(obj).reduce(
        (result , key) => {
            result[obj[key]] = result[obj[key]] ? [].concat(result[obj[key]], key) : key;
            return result
        },
        {});


    // return Object.keys(obj).reduce((result, key) => {
    //     if (result[obj[key]]) {
    //         result[obj[key]] = [].concat(result[obj[key]], key);
    //     } else {
    //         result[obj[key]] = key;
    //     }
    //     return result;
    // }, {});

};


