// 2803. Factorial Generator
// Easy
// 13
// 1
// Write a generator function that takes an integer n as an argument and returns a generator object which yields the factorial sequence.

// The factorial sequence is defined by the relation n! = n * (n-1) * (n-2) * ... * 2 * 1​​​.

// The factorial of 0 is defined as 1.
/**
 * @param {number} n
 * @yields {number}
 */
function* factorial(n){
    let output = 1;
    if (n <= 0){
        return output;
    }
    let count = 1;

    while (count <= n){
        yield output;
        output *= ++count;
    } 
};


