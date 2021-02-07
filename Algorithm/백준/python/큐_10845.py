# from queue import Queue

# que = Queue()

# N = int(input())

# for _ in N:
#     cmd = list(input())

#     if cmd[0] == "push":
#         que.put(cmd[1])
    
#     elif cmd[0] == "pop":
#         print(que.get() if len(que) else -1)

#     elif cmd[0] == "size":
#         print(que.qsize())

#     elif cmd[0] == "empty":
#         print(que.empty())

#     elif cmd[0] == "front":
#         print(que.)

#     elif cmd[0] == "back":
#         print


import sys
N = int(sys.stdin.readline().rstrip())
que = []

for _ in range(N):
    cmd = list(sys.stdin.readline().rstrip().split())

    if cmd[0] == "push":
        que.append(cmd[1])

    elif cmd[0] == "pop":
        print(que.pop(0) if len(que) else -1)

    elif cmd[0] == "size":
        print(len(que))

    elif cmd[0] == "empty":
        print(0 if len(que) else 1)

    elif cmd[0] == "front":
        print(que[0] if len(que) else -1)

    elif cmd[0] == "back":
        print(que[-1] if len(que) else -1)