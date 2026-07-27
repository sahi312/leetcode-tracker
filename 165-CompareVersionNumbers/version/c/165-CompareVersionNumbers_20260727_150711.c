// Last updated: 7/27/2026, 3:07:11 PM
1#pragma GCC optimize("O3", "unroll-loops")
2int compareVersion(char* v1, char* v2) {
3    const char* dot = ".";
4    char *token1, *token2;
5//    char *ptr1, *ptr2;
6    while(token1 != NULL || token2 != NULL){
7        token1 = strsep(&v1, dot);
8        token2 = strsep(&v2, dot);
9        int x1 = (token1 && *token1) ? atoi(token1) : 0;
10        int x2 = (token2 && *token2) ? atoi(token2) : 0;
11        if (x1 <x2) return -1;
12        else if (x1 > x2) return 1;
13    }
14    return 0;
15}