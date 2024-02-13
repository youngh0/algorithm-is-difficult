# 멀티탭 스케줄링
# https://www.acmicpc.net/problem/1700

# 1. 멀티탭을 다 쓰고 있는지
# 1.1 다 안쓰고 있다면 멀티탭에 연결
# 1.2 다 쓰고 있다면, 2가지 경우를 고려
# 2.1 멀티탭에 꽃혀있는 기기 중 추후 사용하지 않는 기기가 있으면 걔를 뽑아
# 2.2 전부 추후 사용한다면 가장 나중에 사용하는 기기를 뽑아

# 2 3 2 3 1 2 7 3
n, k = map(int, input().split())

array = list(map(int, input().split()))

# is_used = [False] * (k+1)

plugs = []

ans = 0

for i in range(k):
    product = array[i]

    # if is_used[product]:
    if product in plugs:
        continue
    if len(plugs) < n:
        plugs.append(product)
        # is_used[product] = True
        continue
    ans += 1

    far_idx = 0
    temp = 0

    for plug_idx in range(n):
        plug_product = plugs[plug_idx]
        if plug_product not in array[i:]:
            # far_idx = plug_idx
            temp = plug_product
            break
        tmp_idx = array[i:].index(plug_product)
        if tmp_idx > far_idx:
            far_idx = tmp_idx
            temp = plug_product
    plugs[plugs.index(temp)] = product


print(ans)