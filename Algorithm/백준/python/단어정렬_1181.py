import heapq

N = int(input())
arr = []

for _ in range(0, N):
    word = str(input())
    arr.append((len(word), word))


arr = list(set(arr))

# word: 인자
# : 뒤는 조건을 의미
arr.sort(key = lambda word: (word[0], word[1]))

for word in arr:
    print(word[1])