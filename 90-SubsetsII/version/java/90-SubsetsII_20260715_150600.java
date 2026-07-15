// Last updated: 7/15/2026, 3:06:00 PM
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
11class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if (head == null || left == right) {
14            return head;
15        }
16
17        ListNode dummy = new ListNode(0);
18        dummy.next = head;
19        ListNode prev = dummy;
20
21        for (int i = 0; i < left - 1; i++) {
22            prev = prev.next;
23        }
24
25        ListNode cur = prev.next;
26
27        for (int i = 0; i < right - left; i++) {
28            ListNode temp = cur.next;
29            cur.next = temp.next;
30            temp.next = prev.next;
31            prev.next = temp;
32        }
33
34        return dummy.next;        
35    }
36}