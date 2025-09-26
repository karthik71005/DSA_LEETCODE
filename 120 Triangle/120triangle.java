class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Start from second last row and go upwards
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> below = triangle.get(i + 1);

            for (int j = 0; j < row.size(); j++) {
                // update row[j] with current value + min of the two possible paths below
                int best = row.get(j) + Math.min(below.get(j), below.get(j + 1));
                row.set(j, best);
            }
        }
        return triangle.get(0).get(0);
    }
}
