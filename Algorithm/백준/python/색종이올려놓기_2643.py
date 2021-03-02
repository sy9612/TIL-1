import sys

N = int(sys.stdin.readline().rstrip())

paper = []

for i in range(N):
    tmp = list(map(int,sys.stdin.readline().rstrip().split()))
    if tmp[0] > tmp[1]:
        tmp[0], tmp[1] = tmp[1], tmp[0]
    paper.append(tmp)

paper.sort()
print(paper)
dp = [0 for i in range(N)]
max = 0
for i in range(N):
    for j in range(N):
        # 올릴 수 있을 때
        if paper[i][0] >= paper[j][0] and paper[i][1] >= paper[j][1]:
            dp[i] = dp[i] if dp[i] > dp[j] else dp[j]

    # 위에 올린 개수 + 내꺼 1
    dp[i] += 1
    max = dp[i] if dp[i] > max else max

print(max)


