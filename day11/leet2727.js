// Is Object Empty
/*
Given an object or an array, return if it is empty.

    An empty object contains no key-value pairs.
    An empty array contains no elements.

You may assume the object or array is the output of JSON.parse.
*/


/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function (obj) {
    // First check the type of the object is object or not if yes then
    if (typeof (obj) === 'object' && obj != null) {
        // return its length is equal to 0 or not
        return Object.keys(obj).length === 0
    }
    if (Array.isArray(obj)) {
        // Same with array
        return obj.length === 0
    }
    return false
};

// Multiple test cases 
console.log(isEmpty({ "x": 5, "y": 42 }));
console.log(isEmpty({}));
console.log(isEmpty([]));
console.log(isEmpty(null));
console.log(isEmpty(undefined));


// This is JavaScript program