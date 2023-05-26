package programmers.level1;


// 코드 처리하기
/*
문자열 code가 주어집니다.
code를 앞에서부터 읽으면서 만약 문자가 "1"이면 mode를 바꿉니다. mode에 따라 code를 읽어가면서 문자열 ret을 만들어냅니다.

mode는 0과 1이 있으며, idx를 0 부터 code의 길이 - 1 까지 1씩 키워나가면서 code[idx]의 값에 따라 다음과 같이 행동합니다.

mode가 0일 때
code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다.
mode가 1일 때
code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다.
 */
public class Pro00003 {

  public String solution(String code) {
    String answer = "";
    String[] split = code.split("");
    boolean mode = false;
    //false == 0 true == 1
    for(int i=0; i<split.length; i++){
      //홀수번째 인덱스일때
      if(i%2==0){
        if(!mode&&!split[i].equals("1")){
          answer+=split[i];
        }
        if(split[i].equals("1")){
          mode = !mode;
        }
      }
      //짝수번째 인덱스일때
      if(i%2==1){
        if(mode&&!split[i].equals("1")){
          answer+=split[i];
        }
        if(split[i].equals("1")){
          mode= !mode;
        }
      }
    }
    if(answer==""){
      return "EMPTY";
    }
    return answer;
  }

}
