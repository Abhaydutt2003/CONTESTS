/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var findChampion = function (n, edges) {
  //based on indegree
  let indegree = new Array(n).fill(0);
  for (let i = 0; i < edges.length; i++) {
    indegree[edges[i][1]]++;
  }
  console.log(indegree);
  let ans = -1;
  for (let i = 0; i < indegree.length; i++) {
    if (indegree[i] == 0) {
      if (ans != -1) {
        return -1;
      } else {
        ans = i;
      }
    }
  }
  return ans;
};

let matrix = [
  [0, 1],
  [1, 2],
];
console.log(findChampion(3, matrix));
