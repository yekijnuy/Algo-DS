// Time: O (m * n)
// Space: O (m * n)
function levenshteinDistance(a, b) {
  if (a.length === 0) return b.length;
  if (b.length === 0) return a.length;

  const matrix = [];

  // Initialize the first row and column.
  for (let i = 0; i <= b.length; i++) {
      matrix[i] = [i];
  }
  for (let j = 0; j <= a.length; j++) {
      matrix[0][j] = j;
  }

  for (let i = 1; i <= b.length; i++) {
      for (let j = 1; j <= a.length; j++) {
          if (b.charAt(i - 1) === a.charAt(j - 1)) {
              matrix[i][j] = matrix[i - 1][j - 1];
          } else {
              matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, // Substitution
                                      Math.min(matrix[i][j - 1] + 1, // Insertion
                                               matrix[i - 1][j] + 1)); // Deletion
          }
      }
  }

  return matrix[b.length][a.length];
}

// Do not edit the line below.
exports.levenshteinDistance = levenshteinDistance;
