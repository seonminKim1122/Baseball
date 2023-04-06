import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        // 정답 난수 생성
        String answer = "";
        while (answer.length() < 3) {
            String  randomInt = String.valueOf((int) (Math.random() * 10)); // o <= randomInt < 10
            if (!answer.contains(randomInt)) {
                answer = answer.concat(randomInt);
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (true) {
            System.out.print(i + "번째 시도 : ");
            String num = sc.nextLine();

            // 유저의 입력이 3 자리 숫자가 아닌 경우 처리
            if (num.length() != 3) {
                System.out.println("3자리 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해주세요.");
                continue;
            }

            int strike = 0;
            int ball = 0;

            for (String n : num.split("")) { // 유저가 입력한 숫자를 한 자리씩 확인
                if (answer.contains(n)) { // 정답에 포함된 숫자일 경우
                    if (num.indexOf(n) == answer.indexOf(n)) { // 자리가 같으면 strike
                        strike++;
                    } else{ // 그렇지 않으면 ball
                        ball++;
                    }
                }
            }

            // 결과 출력
            if (strike == 3) {
                System.out.println("3S");
                System.out.println(i + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (ball == 3) {
                System.out.println("3B");
            } else {
                System.out.println(ball + "B" + strike + "S");
            }

            i++;
        }
    }
}
