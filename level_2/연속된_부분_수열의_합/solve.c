#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// sequence_len은 배열 sequence의 길이입니다.
int* solution(int sequence[], size_t sequence_len, int k) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(2 * sizeof(int));
    
    int st = 0, end = 0;
    int sum = 0;
    // answer의 최소 길이 저장용
    size_t min_len = sequence + 1;
    
    for(end = 0; end < sequence_len; end++) {
        sum += sequence[end];
        
        while(st <= end && sum > k) { // sum이 k보다 클 경우 st를 이동하며 sum 줄이기
            sum -= sequence[st++];
        }
        
        if(sum == k && (end - st + 1) < min_len) {
            min_len = end - st + 1;
            answer[0] = st;
            answer[1] = end;
        }
    }
    
    return answer;
}