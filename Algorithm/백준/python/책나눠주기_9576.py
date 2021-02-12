# 그리디
T = int(input())

for _ in range(T):
    N, M = map(int,input().split())

    books = []
    for _ in range(M):
        [a, b] = map(int, input().split())
        books.append( [a, b] )

    # b를 기준으로 정렬 후, 같으면 a로 정렬
    books.sort(key = lambda x: (x[1], x[0]))

    # 정렬한 순서대로 a번의 책을 준다.

    nl = [False for i in range(N+1)]

    result = 0

    for book in books:
        for i in range(book[0], book[1]+1):
            if nl[i] == False:
                nl[i] = True
                result += 1
                break

    print(result)