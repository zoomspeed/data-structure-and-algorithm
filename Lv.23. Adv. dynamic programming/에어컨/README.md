## 에어컨
***
### 문제
***
N명의 사람이 직선상에 위치해 있다. 물론, 같은 위치에 사람이 2명 있는 경우는 없다. 이 N명의 사람들이 한 방에 모여있는데, 에어컨은 한 대 밖에 없다. 때문에 에어컨을 놓는 위치가 매우 중요하다.

어떠한 사람이 느끼는 “불쾌지수”는 그 사람의 위치에서 에어컨의 위치까지의 거리라고 하자. 만약 에어컨이 3의 위치에 있고 사람이 7의 위치에 있다면 “불쾌지수”는 4가 된다. 여러 사람의 “불쾌지수”를 다 더했을 때, 그 합이 가장 최소가 되는 곳에 에어컨을 놓는다면 그나마 가장 최적의 선택이라고 할 수 있다.

예를들어 6명의 사람의 위치가 각각 5, 9, 2, 6, 3, 1 이라고 하자. 이 경우 에어컨을 1의 위치에 둔다면 “불쾌지수”의 합은 (5-1) + (9-1) + (2-1) + (6-1) + (3-1) + (1-1) = 20이 된다. 그러나 에어컨을 4의 위치에 놓는다면 “불쾌지수”의 합은 (5-4) + (9-4) + (4-2) + (6-4) + (4-3) + (4-1) = 14가 된다.

에어컨은 총 M대를 놓을 수 있으며, 여러 대의 에어컨이 있을 경우 그 사람이 갖는 불쾌지수는 가장 가까운 에어컨으로부터 생기는 불쾌지수라 정의하자. 예를 들어 사람이 5에 있고 에어컨이 2, 10에 있다면 그 사람의 불쾌지수는 3이 된다. N명의 사람의 “불쾌지수”의 합의 최솟값을 출력하는 프로그램을 작성하시오.

### 입력
***
첫 번째 줄에 사람의 수 N ( 1 ≤ N ≤ 1,000 ) 이 주어지고 에어컨의 대수 M ( 1 ≤ M ≤ 100)이 주어진다. 두 번째 줄에 N개의 수가 주어진다. 이는 사람의 위치를 나타낸다. 사람의 위치는 자연수이며 int형의 범위를 초과하지 않는다.

### 출력
***
N명의 사람의 “불쾌지수”의 합의 최솟값을 출력한다.

### 예제입력
```
10 2
1 5 8 3 4 2 10 21 33 34
```

### 예제출력
```
30
```