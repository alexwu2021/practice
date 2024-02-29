
var areDeeplyEqual = function(o1, o2) {
    if (o1 === o2) return true;

    // nullity and undefinedness checking
    if (o1 === null || o1 === undefined || o2 === null || o2 === undefined)
        return false;


    // should both be objects or arrays

    
    if (typeof o1 != 'object' || typeof o2 != 'object') return false;


    if (Array.isArray(o1) !== Array.isArray(o2)) return false;
    if (Object.keys(o1).length != Object.keys(o2).length) return false;
    for (const k in o1)
        if (!areDeeplyEqual(o1[k], o2[k])) return false;

    return true;
}