N = int(input())

# 리스트 선언
arr = []
# N개의 input 받기
for i in range(0, N):
    arr.append(int(input()))

arr.sort()

for i in arr:
    print(i)