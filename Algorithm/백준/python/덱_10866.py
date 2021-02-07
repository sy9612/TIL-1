    # stack + queue가 섞인 것 = 덱
    import sys


    # 시간초과 방지
    N = int(sys.stdin.readline().rstrip())
    arr = []

    for _ in range(0, N):
        cmd = list(sys.stdin.readline().rstrip().split())

        if cmd[0] == 'push_front':
            arr.insert(0, cmd[1])

        elif cmd[0] == 'push_back':
            arr.append(cmd[1])

        elif cmd[0] == 'pop_front':
            print(arr.pop(0) if len(arr) else -1)

        elif cmd[0] == 'pop_back':
            print(arr.pop() if len(arr) else -1)

        elif cmd[0] == 'size':
            print(len(arr))

        elif cmd[0] == 'empty':
            print(0 if len(arr) else 1)

        elif cmd[0] == 'front':
            print(arr[0] if len(arr) else -1)

        elif cmd[0] == 'back':
            print(arr[-1] if len(arr) else -1)