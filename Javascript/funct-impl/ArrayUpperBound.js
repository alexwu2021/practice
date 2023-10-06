/** 
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function(target) {

    let i = 0;
    while (i < this.length && this[i] < target){
        i++;
    }
    if (i == this.length){
        return -1;
    }
    if (this[i] > target){
        return -1;
    }

    while (i < this.length && this[i] == target){
        i++;
    }
    return i -1
    
};

Array.prototype.upperBound_nlogn = function(target){
    let l = 0
    let r = this.length - 1
    let lastIdx = -1
  
    while(l <= r) {
      let mid = Math.floor((r - l)/2) + l
      
      if(this[mid] == target) lastIdx = mid
        
      if(this[mid] <= target) {
        l = mid + 1
      } else if(this[mid] > target) {
        r = mid - 1
      }
    }
  
    return lastIdx
  };
  
  