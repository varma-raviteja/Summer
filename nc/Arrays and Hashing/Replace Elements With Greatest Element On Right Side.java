class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res=new int[arr.length];
        res[arr.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--)
        {
            res[i]=Math.max(res[i+1],arr[i+1]);
        }
        return res;
    }
}


class Solution {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int newMax = Math.max(rightMax, arr[i]);
            arr[i] = rightMax;
            rightMax = newMax;
        }
        return arr;
    }
}