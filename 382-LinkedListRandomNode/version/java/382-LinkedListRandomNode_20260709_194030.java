// Last updated: 7/9/2026, 7:40:30 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11
12
13class Solution {
14    private ListNode head;
15    private Random random;
16
17    public Solution(ListNode head) {
18        this.head = head;
19        random = new Random();
20    }
21
22    public int getRandom() {
23        int count = 0;
24        int result = 0;
25        ListNode curr = head;
26
27        while (curr != null) {
28            count++;
29            // generate a random number between 1 and the count
30            // if the random number is 1, update the result with the current node's value
31            if (random.nextInt(count) == 0) {
32                result = curr.val;
33            }
34            curr = curr.next;
35        }
36
37        return result;
38    }
39}
40
41/**
42 * Your Solution object will be instantiated and called as such:
43 * Solution obj = new Solution(head);
44 * int param_1 = obj.getRandom();
45 */