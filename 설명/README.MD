### 국내에서 참가할 수 있는 프로그래밍 대회

#### 한국 정보 올림피아드

#### ACM-ICPC(ACM 대학생 프로그래밍 경시대회) - 5시간 8~10문제

#### SAMSUNG SCPC - [코드그라운드](https://www.codeground.org/)

#### 탑코더(TopCoder)

#### 구글 코드 잼(Google Code Jam) - 원하는 언어 사용 가능

<br/><br/><br/>

# 시간복잡도

https://velog.io/@junyong92/TIL-Time-Complexity

<br/><br/>

# 완전 탐색 (무식하게 풀기)

### 완전탐색은 말 그대로 가능한 모든 경우를 다해보는 탐색 방법

### 이러한 완전 탐색을 하는 방법은 대략 4가지가 있다.

### 계산된 시간복잡도가 1억건 이하일 경우 -> 상황에 따라 완전탐색이 유리함.

### O(N^2)

### 10000\*10000 = 1억 (1초)

### 100000\*100000 = 100억 (100초)

<br/><br/>

<h2>1. brute force</h2>
  
  ### N중 for문으로 푸는 방법 O(N^2)

#### ROOK

- [예제](<https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv%203.%20(Simple%20Brute-Force%20Algorithm)%201/rook/rook.md>)
- [코드](<https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv%203.%20(Simple%20Brute-Force%20Algorithm)%201/rook/Main.java>)

<h2>2. 순열</h2>

- [문제](https://www.acmicpc.net/problem/10974)
- [설명](https://fieldanimal.tistory.com/26)

- 자료구조 트리
   [문제](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.13.%20%ED%8A%B8%EB%A6%AC(Tree)/%ED%8A%B8%EB%A6%AC%EC%88%9C%ED%9A%8C%EA%B2%B0%EA%B3%BC%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0/%ED%8A%B8%EB%A6%AC%EC%88%9C%ED%9A%8C%EA%B2%B0%EA%B3%BC%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0.md)
   [코드](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.13.%20%ED%8A%B8%EB%A6%AC(Tree)/%ED%8A%B8%EB%A6%AC%EC%88%9C%ED%9A%8C%EA%B2%B0%EA%B3%BC%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0/Main.java#L42)

 <h2>3. BFS / DFS</h2>

  -https://twpower.github.io/151-bfs-dfs-basic-problem

  -BFS / DFS는 O(정점 개수) 이기 때문에 N제한이 1초안에 가능할 경우 -간선의 가중치가 1일 때

단지번호 붙이기
[예제](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.19.%20BFS/%EB%8B%A8%EC%A7%80%EB%B2%88%ED%98%B8%20%EB%B6%99%EC%9D%B4%EA%B8%B0/%EB%8B%A8%EC%A7%80%EB%B2%88%ED%98%B8%20%EB%B6%99%EC%9D%B4%EA%B8%B0.md)
[BFS](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.19.%20BFS/%EB%8B%A8%EC%A7%80%EB%B2%88%ED%98%B8%20%EB%B6%99%EC%9D%B4%EA%B8%B0/Main.java)
[DFS](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.18.%20DFS/%EB%8B%A8%EC%A7%80%EB%B2%88%ED%98%B8%20%EB%B6%99%EC%9D%B4%EA%B8%B0/Main.java)

#### DFS의 경우는 재귀함수 사용.

https://wodonggun.github.io/wodonggun.github.io/algorithm/%EB%B0%B1%EC%A4%80-15686-%EC%B9%98%ED%82%A8%EB%B0%B0%EB%8B%AC.html

#### DFS 예제 웜바이러스, 테트로미노

 -[문제](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.18.%20DFS/%EC%9B%9C%20%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4/%EC%9B%9C%20%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4.md)
 -[소스](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.18.%20DFS/%EC%9B%9C%20%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4/Main.java)
 -[소스](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.19.%20BFS/%EC%9B%9C%20%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4/Main.java)

- [예제](https://www.acmicpc.net/problem/14500)
- [소스](http://boj.kr/6ee2e31aa5e84222979f5eaabf6e314b)

#### 예제 치킨배달

- [예제](https://wodonggun.github.io/wodonggun.github.io/algorithm/%EB%B0%B1%EC%A4%80-15686-%EC%B9%98%ED%82%A8%EB%B0%B0%EB%8B%AC.html)
- [소스](http://boj.kr/a2f1d49b437d45d18c29a02042af3441)

#### BFS의 경우는 Queue로 구현

<h2>4. 백트래킹</h2>

### NQEEN problem

http://sooyoung32.github.io/dev/2016/03/14/n-queen-algorithm.html
https://jayce-with.tistory.com/17
[코드](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.21.%20BFS%20%26%20DFS%20Problems/NQUEEN/Main.java)
<br/><br/><br/><br/><br/>

# 최적화 문제

### 어떤 기준에 따라 가장 "좋은" 답을 찾아내는 문제이다.

### 재귀를 이용한 피보나치 수열과 DP를 사용한 피보나치 수열의 시간복잡도 비교

https://velog.io/@junyong92/01-%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98-%EC%88%98%EC%97%B4%EA%B3%BC-%EC%8B%9C%EA%B0%84%EB%B3%B5%EC%9E%A1%EB%8F%84

### O(NlogN)

### O(N)

### O(lognN)

<h2>분할정복법</h2>

- 퀵정렬
https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html


<h2>이진탐색</h2>
https://codepractice.tistory.com/101

<h2>Parameter Search</h2>

- [중복없는 구간](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.10.%20parameter%20search/%EC%A4%91%EB%B3%B5%EC%97%86%EB%8A%94%EA%B5%AC%EA%B0%84/%EC%A4%91%EB%B3%B5%EC%97%86%EB%8A%94%EA%B5%AC%EA%B0%84.md)
- https://kosaf04pyh.tistory.com/86
- [코드](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.10.%20parameter%20search/%EC%A4%91%EB%B3%B5%EC%97%86%EB%8A%94%EA%B5%AC%EA%B0%84/Main.java)
  Greedy
  knapsack 문제
- https://ko.wikipedia.org/wiki/%EB%B0%B0%EB%82%AD_%EB%AC%B8%EC%A0%9C
- [문제](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.22.%20Greedy%20Algorithm/Fractional%20knapsack/Fractional%20knapsack.md)
- [코드](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.22.%20Greedy%20Algorithm/Fractional%20knapsack/Main.java)

<h2>DP(Dynamic Programming)</h2>
- 복잡한 문제를 간단한 여러 개의 문제로 나누어 푸는 방법
- 부분 문제 반복과 최적 부분 구조를 가지고 있는 알고리즘을 일반적인 방법에 비해 더욱 적은 시간 내에 풀 때 사용.
- [문제](https://www.acmicpc.net/problem/2747)
- [코드](http://boj.kr/49c399d9f87743a9bac986b98b780cef)

- [문제](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.16.%20Basic%20Dynamic%20Algorithm/%EC%A7%81%EC%82%AC%EA%B0%81%ED%98%95%EB%B0%B0%EC%B9%98%EC%9D%98%EA%B2%BD%EC%9A%B0%EC%9D%98%EC%88%98/%EC%A7%81%EC%82%AC%EA%B0%81%ED%98%95%EB%B0%B0%EC%B9%98%EC%9D%98%EA%B2%BD%EC%9A%B0%EC%9D%98%EC%88%98.md)
- [코드](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.16.%20Basic%20Dynamic%20Algorithm/%EC%A7%81%EC%82%AC%EA%B0%81%ED%98%95%EB%B0%B0%EC%B9%98%EC%9D%98%EA%B2%BD%EC%9A%B0%EC%9D%98%EC%88%98/Main.java)

<h2>greedy</h2>
https://m.blog.naver.com/PostView.nhn?blogId=lhm0812&logNo=220853228613&proxyReferer=https%3A%2F%2Fwww.google.com%2F

- [코드](https://github.com/zoomspeed/data-structure-and-algorithm/blob/master/Lv.22.%20Greedy%20Algorithm/Fractional%20knapsack/Main.java)