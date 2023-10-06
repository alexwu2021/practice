/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */

var checkIfInstanceOf = function(obj, classFunction) {
    // obj = Object.getPrototypeOf(obj);  // this should not be invoked first
    while(obj != null){
        if(obj.constructor === classFunction) { // .constructor
            return true;
        }
        obj = Object.getPrototypeOf(obj);  // get Prototype Of
    }
    return false;
};