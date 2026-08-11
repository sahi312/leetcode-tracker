// Last updated: 8/11/2026, 2:32:11 PM
1// Added using AI
2class Solution {
3    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
4        int n = positions.length;
5        Integer[] order = new Integer[n];
6        for (int i = 0; i < n; i++) order[i] = i;
7        Arrays.sort(order, (a, b) -> positions[a] - positions[b]);
8
9        boolean[] dead = new boolean[n];
10        Deque<Integer> st = new ArrayDeque<>();
11
12        for (int i : order) {
13            if (directions.charAt(i) == 'R') {
14                st.push(i);
15            } else {
16                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R') {
17                    int top = st.peek();
18                    if (healths[top] > healths[i]) {
19                        healths[top]--; dead[i] = true; break;
20                    } else if (healths[top] < healths[i]) {
21                        healths[i]--; dead[top] = true; st.pop();
22                    } else {
23                        dead[i] = dead[top] = true; st.pop(); break;
24                    }
25                }
26                if (!dead[i]) st.push(i);
27            }
28        }
29
30        List<Integer> res = new ArrayList<>();
31        for (int i = 0; i < n; i++)
32            if (!dead[i]) res.add(healths[i]);
33        return res;
34    }
35}