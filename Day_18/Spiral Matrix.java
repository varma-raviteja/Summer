class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> finalres=new ArrayList<>();

        int top=0;
        int left=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;

        while(left<=right && top<=bottom)
        {
            for(int i=left;i<=right;i++)
            {
                finalres.add(matrix[top][i]);
            }
             top++;
            for(int i=top;i<=bottom;i++)
            {
                finalres.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){   // for row major matrix
             for(int i=right;i>=left;i--)
            {
                finalres.add(matrix[bottom][i]);
            }}
            bottom--;
            if(left<=right){   // for column major matrix
            for(int i=bottom;i>=top;i--)
            {
                finalres.add(matrix[i][left]);
            }}
            left++;

        }
        return finalres;
    }
}
