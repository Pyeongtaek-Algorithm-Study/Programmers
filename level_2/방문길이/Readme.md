### 방문 길이

문제 사이트 : [방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994)

---

### 풀이
1. 좌표 평면의 범위가 `-5 ~ 5`로 제한되어 있으며, 이동 경로의 “중복 제거”가 핵심
2. `Set<String>`을 사용하여 **이동한 경로(간선)** 자체를 저장
3. 단순 좌표 방문이 아니라 `(출발 → 도착)` 형태의 경로를 문자열로 관리
4. 동일한 길을 반대로 이동하는 경우를 동일한 경로로 처리하기 위해 방향에 따라 문자열을 통일
   - (0,0 → 0,1) == (0,1 → 0,0)  
5. 이동 시 좌표가 범위를 벗어나면 해당 이동은 무시
6. 최종적으로 `Set`에 저장된 경로 개수를 반환 

### 핵심 코드

```java
switch (dirs.charAt(i)) {
    case 'U':
        nxtY++;
        path = currentX + "" + currentY + ">" + nxtX + nxtY;
        break;
    case 'D':
        nxtY--;
        path = nxtX + "" + nxtY + ">" + currentX + currentY;
        break;
    case 'R':
        nxtX++;
        path = currentX + "" + currentY + ">" + nxtX + nxtY;
        break;
    case 'L':
        nxtX--;
        path = nxtX + "" + nxtY + ">" + currentX + currentY;
        break;
}
```

- 좌표가 아닌 경로(간선) 기준으로 문제 접근
- 방향에 따라 문자열을 통일하여 역방향 이동을 동일 경로로 처리
