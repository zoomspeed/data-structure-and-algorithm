## 유전자
***
### 문제
***
DNA 서열은 4개의 문자 {a, c, g, t}로 이루어진 문자열이다. DNA 서열에는 생명의 신비를 풀 수 있는 많은 정보가 들어있다. 특히 KOI 유전자의 길이는 생물의 수명과 깊은 상관관계가 있다는 것이 알려져 있다. 이러한 KOI유전자는 다음의 조건을 만족한다.

(1) at와 gc는 가장 짧은 길이의 KOI 유전자이다. (2) 어떤 X가 KOI유전자라면, aXt와 gXc도 KOI 유전자이다. 예를 들어, agct와 gaattc는 KOI 유전자이나, tgca와 cgattc는 KOI유전자가 아니다. (3) 어떤 X가 KOI 유전자이고, 어떤 Y가 KOI 유전자라면, XY도 KOI 유전자이다.

KOI 유전자는 DNA서열 중에서 부분서열로 구성되어 있다. 부분서열이란 주어진 서열에서 임의의 위치에 있는 0개 이상의 문자들을 삭제해서 얻어지는 서열이다. 예를 들면, DNA 서열 acattgatcg에서 두 번째 문자 c와 마지막 문자 g를 삭제하여 생긴 부분 서열 aattgatc는 길이가 8 인 KOI 유전자이다.

### 입력
***
첫째 줄에는 분석하고자 하는 DNA 서열이 주어진다. DNA 서열의 길이는 최대 500이다.

### 출력
***
입력 DNA 서열로부터 계산된 가장 긴 길이의 KOI 유전자의 길이를 첫 번째 줄에 출력한다. 단, KOI 유전자가 없을 경우에는 0을 출력한다.

### 예제 입력
```
acattgagtc
```
### 예제 출력
```
8
```

### 출처
***
KOI 2005 중등부 2번  