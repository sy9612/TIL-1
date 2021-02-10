N = int(input())

points = []

for _ in range(0,N):
    [x, y] = map(int, input().split())
    points.append( [x, y] )

points = sorted(points)


for i in range(N):
    print(points[i][0], points[i][1])