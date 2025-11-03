// Number of greater elements to the right
class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        // code here
        int[] res = new int[indices.length];
        int curr_index=0;
        
        for(int i=0;i<indices.length;i++){
            int index = indices[i];
            
            int pointer = arr.length-1;
            int c=0;
            while(pointer> index){
                if(arr[pointer] > arr[index]){
                    c++;
                }
                pointer--;
            }
            res[curr_index++] = c;
        }
        return res;
        
    }
}
