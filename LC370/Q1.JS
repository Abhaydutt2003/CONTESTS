/**
 * @param {number[][]} grid
 * @return {number}
 */
var findChampion = function (grid) {
  let arr = new Array(grid.length).fill(0);
  let s = new Set();
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (i == j) {
        continue;
      } else {
        if (grid[i][j] == 1) {
          let key = i + " " + j;
          if (s.has(key) == false) {
            arr[i]++;
            s.add(key);
            let key2 = j + " " + i;
            s.add(key2);
          }
        } else {
          let key = j + " " + i;
          if (s.has(key) == false) {
            arr[j]++;
            s.add(key);
            let key2 = i + " " + j;
            s.add(key2);
          }
        }
      }
    }
  }
  console.log(arr);
  let ans = -1;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] >= grid.length - 1) {
      ans = i;
      break;
    }
  }
  return ans;
};

let arr = [
  [0, 0, 1],
  [1, 0, 1],
  [0, 0, 0],
];
console.log(findChampion(arr));
