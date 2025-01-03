class Solution {
    public int[] solution(int brown, int yellow) {        
        // 카펫의 전체 면적
        int total = brown + yellow;
       
        // 가로와 세로의 길이는 total의 약수여야함.
        // total의 약수는 total의 제곱근(Math.sqrt(total))까지만 탐색하면, 
        // 약수는 대칭적이기 때문에 모든 액수에 대해 탐색할 수 있다.
        // ex) total = 12일때 (1,12)(2,6)(3,4)|(4,3)(6,2)(12,1)로 대칭
        // 가로길이가 세로길이보다 길어야하기 때문에, for문의 변수를 height로 지정하여 탐색
        for (int height = 1; height <= Math.sqrt(total); height++) {
            // height가 total의 약수일 경우
            if (total % height == 0) {
                int width = total / height;
                
                // yellow 조건에 맞는지 확인
                if ((width-2)*(height-2) == yellow) {
                    return new int[]{width, height}; // [가로,세로] 배열 반환
                }
            }
        }
    
        return new int[]{};
    }
}