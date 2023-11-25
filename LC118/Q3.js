/**
 * @param {number[]} prices
 * @return {number}
 */
var minimumCoins = function (prices) {
  let dp = new Array(prices.length).fill(0);
  //base case
  dp[dp.length - 1] = prices[prices.length - 1];
  for (let i = prices.length - 2; i >= 0; i--) {
    let ans1 = dp[i + 1];
    let ans2 = dp[i + i] + 1 || 0;
    dp[i] = Math.min(ans1, ans2) + prices[i];
  }
  return dp[0];
};

//try 1-d dp

let map;

/**
 *
 * @param {number[]} prices
 * @param {number} index
 * @param {number} isFree
 * @param {number} costTillNow
 */
let util = (prices, index, freeNo, costTillNow) => {
  if (index == prices.length) {
    return costTillNow;
  }
  let key = index;
  if (Object.hasOwn(map, key)) {
    return map.key;
  }
  let ans = util(prices, index + 1, index + 1, costTillNow + prices[index]);
  if (freeNo > 0) {
    let ans2 = util(prices, index + 1, freeNo - 1, costTillNow);
    ans = Math.min(ans, ans2);
  }
  map.key = ans;
  return ans;
};
// let prices = [
//   176, 391, 307, 836, 76, 650, 625, 648, 466, 990, 643, 399, 422, 604, 328, 343,
//   835, 153, 92, 171, 802, 731, 483, 469, 27, 307, 194, 427, 824, 503, 661, 5,
//   540, 761, 127, 579, 324, 997, 891, 809, 968, 855, 397, 730, 583, 549, 493,
//   471, 809, 860, 771, 502, 177, 25, 107, 26, 321, 796, 726, 519, 800, 764, 804,
//   50, 471, 812, 747, 862, 220,
// ];
//console.log(minimumCoins(prices));

let prices = [1, 10, 1, 1];
console.log(minimumCoins(prices));
let arr = [1, 2];
//console.log(arr[3]||0);

// let obj = {
//     aloo:'a',
// };
// console.log(obj.aloo);
