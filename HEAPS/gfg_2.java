// https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1
// Convert Min Heap to Max Heap

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
        // Humein sirf non-leaf nodes pe heapify karna hota hai
        // kyunki leaf nodes already heap hote hain (unke children nahi hote)
        
        // Binary heap me:
        // total nodes = N
        // leaf nodes = N/2
        // last non-leaf node = (N/2) - 1
        
        // Isliye hum bottom-up approach follow karte hain
        // (N/2 - 1) se leke 0 tak heapify karenge
        
        for (int i = (N / 2) - 1; i >= 0; i--) {
            maxHeapify(i, arr, N);
        }
    }

    static void maxHeapify(int root, int[] arr, int N) {
        // maan lete hain ki root hi largest hai
        int largest = root;

        // left aur right child ke indices
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // agar left child exist karta hai aur root se bada hai
        // toh largest ko left bana do
        if (left < N && arr[left] > arr[largest])
            largest = left;

        // agar right child exist karta hai aur ab tak ke largest se bada hai
        // toh largest ko right bana do
        if (right < N && arr[right] > arr[largest])
            largest = right;

        // agar root largest nahi hai
        // matlab heap property violate ho rahi hai
        if (root != largest) {
            // root aur largest child ko swap karo
            swap(root, largest, arr);

            // ab jis position pe root gaya hai
            // wahan bhi heapify lagao (recursively)
            maxHeapify(largest, arr, N);
        }
    }

    static void swap(int node1, int node2, int[] arr) {
        // simple swapping of two elements
        int temp = arr[node1];
        arr[node1] = arr[node2];
        arr[node2] = temp;
    }
}
