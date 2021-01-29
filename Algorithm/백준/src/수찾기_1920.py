# bs 함수 - 이진탐색
# low, high, num을 인자로 받음
# 각 인자들은 int 형으로 넘어온다. 아마도?
def bs(low, high, num):

    # low가 high 보다 커지게 되면 해당되는 숫자가 배열 안에 존재하지 않음
    if(low > high):
        return 0

    # int 형으로 바꿔주지 않으면 mid를 str로 인식한다.
    mid = int((low + high) / 2)

    # 존재한다면 1을 return한다.
    if(arr[mid] == num):
        return 1

    # 현재 mid의 숫자가 num 보다 크면 high를 mid-1로 정의하여 재귀
    if(arr[mid] > num):
        return bs(low, mid-1, num)

    # 현재 mid의 숫자가 num 보다 작으면 low를 mid+1로 정의하여 재귀
    return bs(mid+1, high, num)

# --------- main ----------

# int형 한 개를 입력받을 때
N = int(input())

# int형으로 여러 개를 입력받아 list 형식으로 저장할 때(배열)
arr = list(map(int,input().split()))

M = int(input())
num = list(map(int, input().split()))

# 배열 정렬 - 오름차순
arr.sort()

# 반복문
# 배열 num에 담긴 숫자들은 m이 되어 반복된다.
# ex) num = {1, 5, 8, 6} 이면, m은 1 -> 5 -> 8 -> 6 순서로 접근한 후 반복문 종료
for m in num:
    print(bs(0, N-1, m)) # bs 함수 시작