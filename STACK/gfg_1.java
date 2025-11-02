//Next Greater Element
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        if(arr.length==0) return new ArrayList<>();
        
        Stack<Integer> saveGreater = new Stack<>();
        int[] res = new int[arr.length];
        
        res[arr.length - 1] = -1;
        saveGreater.push(arr[arr.length - 1]);
        
        int pointer = arr.length - 2;
        
        while(pointer >= 0){
            int curr = arr[pointer];
            
            if(saveGreater.isEmpty()){
                res[pointer] = -1;
                saveGreater.push(curr);
                pointer--;
                continue;
            }
            else{
                while(!saveGreater.isEmpty() && !(saveGreater.peek() > curr)){
                    saveGreater.pop();
                }
                
                if(saveGreater.isEmpty()){
                    res[pointer] = -1;
                }
                else{
                    res[pointer] = saveGreater.peek();
                }
                
                saveGreater.push(curr);
                pointer--;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : res){
            list.add(num);
        }
        return list;
    }
}
