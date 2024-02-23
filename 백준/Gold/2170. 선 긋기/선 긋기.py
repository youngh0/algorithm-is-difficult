# 선 긋기
# https://www.acmicpc.net/problem/2170

import sys
input = sys.stdin.readline

n = int(input())

lines = []
for _ in range(n):
    lines.append(tuple(map(int,input().split())))

lines.sort()
ans = 0

combine_lines = []


start = lines[0][0]
end = lines[0][1]
combine_lines.append([start,end])

is_add = False

for i in range(1,n):
    n_start = lines[i][0]
    n_end = lines[i][1]

    if start <= n_start <= end:
        combine_lines[-1][1] = max(combine_lines[-1][1], n_end)
        end = max(combine_lines[-1][1], n_end)

    elif n_start > end:
        combine_lines.append([n_start, n_end])
        start = lines[i][0]
        end = lines[i][1]
# print(combine_lines)

for start,end in combine_lines:
    ans += abs(end - start)

print(ans)