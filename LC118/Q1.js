/**
 * @param {string[]} words
 * @param {character} x
 * @return {number[]}
 */
var findWordsContaining = function (words, x) {
  let ans = [];
  for (let i = 0; i < words.length; i++) {
    let current = words[i];
    for (let j = 0; j < current.length; j++) {
      if (current.charAt(j) == x) {
        ans.push(i);
        break;
      }
    }
  }
  return ans;
};
