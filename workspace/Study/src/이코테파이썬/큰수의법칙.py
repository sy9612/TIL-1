N, M, K = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort(reverse=True)

# count = 가장 큰 수가 등장하는 횟수
# 6 6 6 5 가 한 묶음이 됨
# K + 1이 한 묶음
# * K => 가장 큰 수가 등장하는 횟수
count = int( M / (K+1) ) * K

count += M % (K + 1) # 딱 떨어지지 않을 경우, 나머지 만큼 가장 큰 수가 등장

result = 0
result += count * arr[0]
result += (M-count) * arr[1] # 두 번째로 큰 숫자가 등장하는 횟수, M에서 가장 큰 수가 등장하는 횟수 빼기


print(result)
