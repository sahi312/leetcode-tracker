// Last updated: 8/11/2026, 2:35:30 PM
1class SQL {
2
3    // We can simplify things if we store table-specific data in a class.
4    private class Table {
5        int autoIncId;
6        final int columnSize;
7        final Map<Integer, List<String>> rows; // Key row id, value List<String>
8
9        Table(int columnSize) {
10            this.autoIncId = 1; // 1-indexed ids
11            this.columnSize = columnSize;
12            this.rows = new HashMap<>();
13        }
14    }
15
16    // A HashMap to store all tables (key name, value Table)
17    final Map<String, Table> tables;
18
19    public SQL(List<String> names, List<Integer> columns) {
20        // We can tell HashMap the capacity we need and the load factor. An
21        // optimization.
22        // Since we do not add any tables, we can have a load factor of 1, where the
23        // HashMap will not increase its capacity unless we insert more than capacity
24        // (default load factor of 0.75, which would cause an allocation)
25        tables = new HashMap<>(names.size(), 1f);
26        for (int i = 0; i < names.size(); i++) {
27            tables.put(names.get(i), new Table(columns.get(i)));
28        }
29    }
30
31    public boolean ins(String name, List<String> row) {
32        var table = tables.get(name);
33        if (table == null || table.columnSize != row.size())
34            return false;
35        table.rows.put(table.autoIncId++, row);
36        return true;
37    }
38
39    public void rmv(String name, int rowId) {
40        var table = tables.get(name);
41        if (table == null)
42            return;
43        table.rows.remove(rowId); // Won't do anything if does not exist
44    }
45
46    public String sel(String name, int rowId, int columnId) {
47        var table = tables.get(name);
48        if (table == null)
49            return "<null>";
50        var row = table.rows.get(rowId);
51        // They don't tell you this but columnId is 1-indexed
52        if (row == null || columnId > row.size())
53            return "<null>";
54        return row.get(columnId - 1);
55    }
56
57    public List<String> exp(String name) {
58        var table = tables.get(name);
59        if (table == null)
60            return List.of();
61        // EntrySet converts a HashMap into a list of K/V pairs
62        var entrySet = table.rows.entrySet();
63        // We choose a LinkedList since we will only ever append strings
64        List<String> ret = new LinkedList<>();
65        for (var row : entrySet) {
66            ret.add(row.getKey().toString() + "," + String.join(",", row.getValue()));
67        }
68        return ret;
69    }
70}
71
72/**
73 * Your SQL object will be instantiated and called as such:
74 * SQL obj = new SQL(names, columns);
75 * boolean param_1 = obj.ins(name,row);
76 * obj.rmv(name,rowId);
77 * String param_3 = obj.sel(name,rowId,columnId);
78 * List<String> param_4 = obj.exp(name);
79 */