// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
// Minimum Platforms
class Solution {
    public int minPlatform(int arr[], int dep[]) {

        // Arrivals aur departures ko sort karna zaroori hai
        Arrays.sort(arr);
        Arrays.sort(dep);

        int p1 = 0; // arrival pointer (next train ka arrival time)
        int p2 = 0; // departure pointer (next train ka departure time)

        int platform = 0; // current platforms in use
        int max = 0;      // maximum platforms required
        int n = arr.length;

        // Jab tak dono pointers valid hain
        while (p1 < n && p2 < n) {

            // Agar next train ka arrival, pehle departure se pehle ya same time pe hai
            // to naya platform chahiye
            if (arr[p1] <= dep[p2]) {
                platform++;   // platform occupy hua
                p1++;         // next arrival pe move
            } 
            // Warna ek train depart ho gayi, platform free hua
            else {
                platform--;   // platform free
                p2++;         // next departure pe move
            }

            // Har step pe maximum platforms track karte hain
            max = Math.max(max, platform);
        }

        return max;
    }
}
