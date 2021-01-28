def bs(low, high, num):

    if(low > high):
        return 0

    mid = int((low + high) / 2)

    if(arr[mid] == num):
        return 1

    if(arr[mid] > num):
        return bs(low, mid-1, num)

    return bs(mid+1, high, num)


N = int(input())

arr = list(map(int,input().split()))

M = int(input())

arr.sort()

num = list(map(int, input().split()))

for m in num:
    print(bs(0, N-1, m))