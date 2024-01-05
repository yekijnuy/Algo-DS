function kadanesAlgorithm(array) {
  let maxEndingHere = array[0];
  let maxSoFar = array[0];

  for(let i = 1; i< array.length; i++) {
    maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
  }

  return maxSoFar;
}

// Do not edit the line below.
exports.kadanesAlgorithm = kadanesAlgorithm;
