# Last updated: 7/9/2026, 7:44:32 PM
1class Solution(object):
2    def deserialize(self, s):
3        from ast import literal_eval
4        def build(x):
5            obj = NestedInteger()
6            if isinstance(x, int):
7                obj.setInteger(x)
8            else:
9                for i in x:
10                    obj.add(build(i))
11            return obj
12        return build(literal_eval(s))