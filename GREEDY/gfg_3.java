// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
// N meetings in one room
class Solution {
    public int maxMeetings(int start[], int end[]) {

        int n = start.length;

        // 1️⃣ Pair bana lo (start, end)
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // 2️⃣ End time ke basis pe sort
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        // 3️⃣ Pointer-based greedy 
        int count = 1;
        int lastEnd = meetings[0][1];

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        return count;
    }
}
