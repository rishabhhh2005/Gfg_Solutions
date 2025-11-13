//Alien Dictionary
class Solution {
    public String findOrder(String[] words) {
        // code here
        int l = words.length;
        // Topology sort with comparing Strings
        
        int[] present  = new int[26];
        for(String w : words){
            for( char c : w.toCharArray()){
                present[c- 'a']++;
                
            }
        }
        int count=0;
        for(int i=0;i<present.length;i++) {
            if(present[i] !=0) count++;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++) adj.add( new ArrayList<>());
        
        
        for(int i=0;i<l-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            if (s1.startsWith(s2) && s1.length() > s2.length()) {
                return "";
            }

            int minlen = Math.min(s1.length(), s2.length());
            for(int ptr =0; ptr<minlen;ptr++){
                if(s1.charAt(ptr) !=  s2.charAt(ptr)){
                    adj.get( s1.charAt(ptr) - 'a').add( s2.charAt(ptr) -'a');
                    break;
                }
            }
        }
        
        // now we will begin with topo sort
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int num : adj.get(i)){
                indegree[num]++;
            }
        }
        for(int i=0;i<indegree.length;i++){
           if (indegree[i] == 0 && present[i] > 0) q.offer(i);

        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.offer(neigh);
            }
            topo.add(curr);
        }
        if (topo.size() < count) return "";
        
        //now we have thw correct topo order. we just need to convert the int to string
        StringBuilder res = new StringBuilder();
        for(int num : topo){
           if (present[num] > 0)
                res.append((char) (num + 'a'));

            }
        return res.toString();
        
        
        
        
        
        
        
        
        
        
        
    }
}