/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
    let ps = 0 , pf = 1;
    const ans = Array(0)
    while( ps <  nums.length) {
        if( pf === nums.length) {
            if( ps === nums.length - 1){
                ans.push(nums[ps].toString())
            } else {
                ans.push([ nums[ps], nums[nums.length-1]].join('->'))
            }
            return ans;
        }
        if(nums[pf] - nums[pf-1] === 1) pf++
        else {
            if( pf - ps === 1) ans.push(nums[ps].toString())
            else ans.push( [nums[ps], nums[pf-1]].join('->'))
            ps = pf;
            pf++;
        }
    }
    return ans;

};
