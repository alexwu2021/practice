// Given an array of asynchronous functions functions and a pool limit n, return an asynchronous function promisePool. It should return a promise that resolves when all the input functions resolve.

// Pool limit is defined as the maximum number promises that can be pending at once. promisePool should begin execution of as many functions as possible and continue executing new functions when old promises resolve. promisePool should execute functions[i] then functions[i + 1] then functions[i + 2], etc. When the last promise resolves, promisePool should also resolve.

/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function(functions, n) {

    let i = 0;
    const execCurrentAndFireTheNext = async () => {
        const fn = functions[i++]
        if(fn) {
            await fn();
            return execCurrentAndFireTheNext();
        }
    }

    // Execute n function at once
    return Promise.all(Array(n).fill().map(execCurrentAndFireTheNext));
};

// other references

// var promisePool = async function(functions, n) { 
//     const results = [];
//     const inProgress = [];
//     let i = 0;
  
//     while (i < functions.length || inProgress.length > 0) {
//         while (inProgress.length < n && i < functions.length) {
//             const promise = functions[i]();
//             const index = i;
//             const resultPromise = promise.then((result) => {
//             results[index] = result;
//             inProgress.splice(inProgress.indexOf(resultPromise), 1);
//             });
//             inProgress.push(resultPromise);
//             i++;
//       }
  
//       await Promise.race(inProgress);
//     }
  
//     return results;
//   };


//   var promisePool = async function(functions, n){
//     let next = () => functions[n++]?.().then(next);
//     return Promise.all(functions.slice(0, n).map(f => f().then(next)));
//   };


