import sys


# 커서를 기준으로
left = list(sys.stdin.readline().rstrip())
right = []

M = int(sys.stdin.readline().rstrip())


for _ in range(0, M):
    cmd = list(sys.stdin.readline().rstrip().split())

    if cmd[0] == 'L':
        if len(left):
            mv = left.pop()
            right.append(mv)

    elif cmd[0] == 'D':
        if len(right):
            mv = right.pop()
            left.append(mv)

    elif cmd[0] == 'B':
        if len(left):
            left.pop()

    elif cmd[0] == 'P':
        left.append(cmd[1])
    
print(''.join(left+right[::-1]))



# stack과 Queue의 in/out의 시간복잡도는 O(1)
# list를 통해 append와 pop의 경우 O(n)