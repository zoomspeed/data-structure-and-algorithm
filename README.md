# 기본 자료구조&알고리즘 정리

### 1. 다중 반복문 (multiple loops)
### 2. 배열 (array)
### 3. 간단한 완전탐색 (Simple Brute-Force Algorithm) 1
### 4. 간단한 완전탐색 (Simple Brute-Force Algorithm) 2
### 5. 기본 정렬 (Basic Sort)
### 6. 시간복잡도 (Time Complexity)
### 7. 기본 정수론 (Basic Number Theory)
### 8. 변수와 자료형 : 문자 (variable), 문자열 (String), 함수 (function)                   
### 9. 변수와 자료형 : 포인터 (pointer), 메모리 (memory), 포인터와 배열 (pointer & array)
### 10. 변수와 자료형 : call by value
### 11. 재귀함수 (basic recursive function)
### 12. Advanced Brute-Force (Backtracking)
### 13. 고급 정렬 (Advanced Sort)
### 14. 합병 정렬 (Merge Sort)
### 15. 퀵 정렬 (Quick Sort)
### 16. 이진탐색 (binary search)
### 17. 매개 변수 탐색 (parameter search)
### 18. 기본 자료구조 (basic data-structure)
### 19. 스택 (stack)
### 20. 큐 (queue)
### 21. 스택 & 큐 정리
### 22. 트리 (Tree)
### 23. 트리의 순회
### 24. 우선순위 큐
### 25. heap & 트리요약
### 26. Adv recursive function
### 27. Divide and conquer, Memorization
### 28. Basic Dynamic Algorithm
### 29. Intermediate Dynamic Algorithm
### 30. Graph
### 31. Library
### 32. Graph traversal
### 33. DFS
### 34. BFS
### 35. Graph Algorithm
### 36. BFS & DFS Problems
### 37. Greedy Algorithm
### 38. Adv. dynamic programming
백준 온라인 저지는 프로그래밍 문제를 풀고 온라인으로 채점받을 수 있는 곳입니다.

    특징:

        2010년 03월 19일부터 운영을 시작한 온라인 저지입니다.
        사용 가능한 프로그래밍 언어는 총 59가지입니다.
        현재까지 14270개 이상의 문제 보유하고 있습니다.

채점 환경

백준 온라인 저지의 Java 채점 환경은 아래와 같습니다.

    Java:

        컴파일 실행 옵션 : javac -J-Xms128m -J-Xmx512m -encoding UTF-8 Main.java
        버젼 : java version "1.8.0_91"
        시간제한 : +5초
        메모리제한 : +512MB

채점 결과

백준 온라인 저지의 채점 결과는 아래와 같습니다.

    기다리는 중 : 채점이 밀려서 아직 채점이 되지 않은 상태입니다. 조금만 기다려 보세요.
    재채점을 기다리는 중 : 재채점을 기다리는 중입니다.
    컴파일 하는 중 : 컴파일 하는 중입니다.
    채점중 : 채점을 하는 중입니다.
    맞았습니다!! : 제출한 프로그램이 모든 테스트 케이스를 통과했을 때 입니다. 즉, 정답입니다!
    출력 형식이 잘못되었습니다 : 출력 결과는 정답과 유사하나, 공백, 빈 줄과 같은 문제로 인해서 출력 결과가 일치하지 않은 경우 입니다.
    틀렸습니다 : 출력 결과가 정답과 다른 경우 입니다.
    시간 초과 : 프로그램이 제한된 시간이내에 끝나지 않은 경우입니다. 이런 경우에는 채점을 중간에 중단하므로, 정답이 맞는지 아닌지는 알 수가 없습니다.
    메모리 초과 : 프로그램이 허용된 메모리보다 많은 메모리를 사용했을 경우입니다.
    출력 초과 : 너무 많은 출력이 발생하는 경우입니다. 주로 프로그램이 무한 루프에 빠졌을 때 발생합니다. 출력 제한은 1MB 입니다.
    런타임 에러 : 실행 도중에 'segmentation fault', 'floating point exception', 'used forbidden functions', 'tried to access forbidden memories' 등의 에러가 발생하여서 프로그램이 종료된 경우 입니다.
    컴파일 에러 : 컴파일 하지 못한 경우입니다. Warning Message는 에러 메시지가 아닙니다. 채점 결과를 클릭하면 컴파일 에러 메시지를 볼 수 있습니다.

1000번 예제 소스

Java를 이용한 1000번 문제 풀이는 아래와 같습니다.

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a + b);
	}
}

BOJ-PSJ 구성

BOJ-PSJ는 다음과 같이 구성되어 있습니다. 코드를 보시려면 src > boj_문제번호 > Main.java를 보시면 됩니다.

BOJ-PSJ
├── .classpath (클래스패스 파일)
├── .git (git 디렉토리)
├── .project (프로젝트 파일)
├── .settings (설정 디렉토리)
├── LICENSE (프로젝트 라이센스 파일)
├── README.md (프로젝트 설명서 파일)
├── bin (컴파일 된 소스코드 디렉토리)
├── src (소스코드 디렉토리)
│   ├── boj_10156 (boj_문제번호 패키지)
│   │   ├── Main.java (소스코드 Java 파일)
...

BOJ SUBMITTER 이용하기

BOJ SUBMITTER는 매번 백준 온라인 저지에 정답 코드를 복사 및 붙여넣기를 반복하는 당신께 다음과 같은 편리한 기능을 제공합니다. 코드를 보시려면 src > boj_submitter > Main.java를 보시면 됩니다.

    사용방법:

        정답 코드를 작성합니다. (반드시 src > boj_문제번호 > Main.java 형태로 저장해주세요.)
        BOJ SUBMITTER를 실행해주세요. (src > boj_submitter > Main.java를 실행해주세요.)
        아래 그림과 같이 제출하려는 문제 번호, 백준 온라인 저지 아이디 및 비밀번호를 입력하시고 Submit 버튼을 클릭해주세요.

라이센스

본 프로젝트는 Apache 2.0 License를 따릅니다.
문의사항

기타 문의사항이 있으실 경우 아래의 문의 수단으로 연락해주세요.

    문의 수단:

        메일 : devetude@naver.com 또는 devetude@gmail.com
        github : https://github.com/devetude/BOJ-PSJ/issues

