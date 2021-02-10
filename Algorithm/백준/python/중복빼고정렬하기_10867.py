N = int(input())

arr = list( map(int, input().split()) )

arr = list(set(arr))
arr.sort()

for a in arr:
    print(a, end = " ")