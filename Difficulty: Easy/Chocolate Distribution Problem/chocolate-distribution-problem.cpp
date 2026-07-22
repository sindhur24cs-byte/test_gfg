#include <vector>
#include <algorithm>
#include <climits>

// Standalone function expected by Driver.cpp
int minDiff(std::vector<int>& arr, int m) {
    int n = arr.size();
    
    // Edge cases
    if (m == 0 || n == 0) return 0;
    if (n < m) return -1;
    
    // Step 1: Sort packet sizes in ascending order
    std::sort(arr.begin(), arr.end());
    
    int minDifference = INT_MAX;
    
    // Step 2: Sliding window of size m
    for (int i = 0; i + m - 1 < n; i++) {
        int diff = arr[i + m - 1] - arr[i];
        minDifference = std::min(minDifference, diff);
    }
    
    return minDifference;
}