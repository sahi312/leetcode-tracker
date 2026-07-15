// Last updated: 7/15/2026, 3:07:55 PM
1class Solution {
2    public static List<String> restoreIpAddresses(String s) {
3        // Initialize the list to hold all valid IP addresses
4        List<String> addresses = new ArrayList<>();
5        // Initialize the list to hold the current IP address being built
6        List<String> address = new ArrayList<>();
7        // Call the recursive helper function to generate all possible IP addresses
8        rec(s, 0, address, addresses);
9        // Return the list of all valid IP addresses
10        return addresses;
11    }
12    private static void rec(String s, int i, List<String> address, List<String> addresses) {
13        // If the current address has 4 segments, check if we have reached the end of the input string
14        if (address.size() == 4) {
15            if (i == s.length()) {
16                // If we have reached the end of the input string, add the current address to the list of valid addresses
17                addresses.add(String.join(".", address));
18            }
19        } else {
20            // Try all possible next segments for the current address
21            for (int j = i + 1; j <= i + 3 && j <= s.length(); j++) {
22                String nextInt = s.substring(i, j);
23                // Check if the next segment is valid (between 0 and 255, and not starting with 0 unless it is 0)
24                if (Integer.parseInt(nextInt) <= 255 && (nextInt.equals("0") || !nextInt.startsWith("0"))) {
25                    // Add the next segment to the current address
26                    address.add(nextInt);
27                    // Recursively call the function to generate the next segment
28                    rec(s, j, address, addresses);
29                    // Remove the last segment from the current address
30                    address.remove(address.size() - 1);
31                }
32            }
33        }
34    }
35}
36
37