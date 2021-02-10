# 그리디
T = int(input())

for _ in range(T):
    N, M = map(int,input().split())

    book = []
    for _ in range(M):
        [a, b] = map(int, input().split())
        book.append( [a, b] )
