# 시간 초과를 해결하기 위한 sys 선언
import sys
N = int(sys.stdin.readline().rstrip())

# python은 list로 stack을 흉내 낼 수 있음
stack = []

# 0부터 N-1까지 반복
for _ in range(N):
    # push의 경우는 두 개의 명령어가 필요하므로 list 형식으로 받는다.
    cmd = list(sys.stdin.readline().rstrip().split())

    # python은 switch문이 존재하지 않는다.

    # 헷갈렸던 것, if 문에 아무리 한줄이라도 python은 : 을 붙여줘야 한다.
    if cmd[0] == "push":
        stack.append(cmd[1])

    elif cmd[0] == "pop":
        if len(stack) != 0:
            print(stack.pop())
        else:
            print(-1)
    
    elif cmd[0] == "size":
            print(len(stack))
    elif cmd[0] == "empty":
    # 0 if stack else 1
    # 이렇게 써도 동일하게 작동한다
            if len(stack) == 0:
                print(1)
            else:
                print(0)

    elif cmd[0] == "top":

    # stack[-1] if stack else -1
        if len(stack) != 0:
            # 리스트의 맨 뒤의 숫자 가져올 때 -1을 해주면 됨
            print(stack[-1])
        else:
            print(-1)


# list에 아무런 원소가 없으면 not list, if list 등으로 존재 여부를 확인할 수 있다.