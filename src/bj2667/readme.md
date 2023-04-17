<h1>백준 2667 - 단지번호붙이기</h1>

N이 주어진다.
이후 N x N의 지도가 주어진다.

지도에서 인접한 1들을 그룹으로 묶는다.
첫 번째 줄에 그릅의 개수를, 두 번째 줄부터 각 그룹원들의 수를 오름차순으로 출력한다.

<b>대충봐도 DFS 방식으로 푸는 문제다. 하지만 내 첫 시도에 큰 문제가 있었는데..</b>
```java
public static void dfs(int x, int y, int count) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }
        if (graph[x][y] == 0 || isVisit[x][y]) {
            temp = Math.max(temp, count-1);
            return;
        }

        visit[x][y] = true;
        dfs(x+1, y, count+1);
        dfs(x-1, y, count+1);
        dfs(x, y+1, count+1);
        dfs(x, y-1, count+1);

        }

```

이 DFS 함수에는 큰 결점이 있는데, 바로 <b>그룹원의 수를 한붓그리기로만 셀 수 있다는 것이다.</b>

StackOverFlow를 방지하는 데에 집중하다보니, return문을 남발하는 것이 문제였다.

테스트 케이스 하나를 예로 들 때,
```java
8
01110101
00000111
11100000
00100000
11100000
00001000
00111000
00010000
```
맨 아래의 그룹의 경우, DFS 재귀는 (5, 4)에서 시작할 것이고, (6, 3)까지는 정상적으로 동작할 것이다.

하지만 이 이후 (6, 2)로 가던, (7, 3)으로 가던 DFS 재귀가 끝난다. 이 그룹의 반환 값은 5여야 하지만, 4에서 끝나버리는 것이다.

구성원 수의 값을 저장하는 temp를 벽 또는 이미 방문한 곳일 경우에 갱신되도록 하고 이후에 함수를 return하므로 정상적으로 세지 못하는 것이다.

해결 방법은 간단하다.(물론 내가 걸린 과정은 간단하지 않았다.)
```java
public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }
        if (graph[x][y] == 0 || isVisit[x][y]) {
            //temp = Math.max(temp, count-1); 삭ㄴ
            return;
        }
        
        temp++; //추가

        visit[x][y] = true;
        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);

        }

```
temp = 구성원 수 이고, 이 함수는 방문했거나 0인 곳은 방문하지 않으므로
함수가 return되지 않을 때 마다 temp++ 해주면 그만이다.

