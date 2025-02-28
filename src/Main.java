import com.example.calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner a = new Scanner(System.in);
        long result = 0L;

        while (true) {
            System.out.print("첫 번째 정수를 입력하세요 : ");
            int num1 = a.nextInt();

            a.nextLine();
            System.out.print("사칙 연산 기호를 입력하세요 : ");
            String operand = a.nextLine();

            System.out.print("두 번째 정수를 입력하세요 : ");
            int num2 = a.nextInt();

            a.nextLine();
            result = calc.calculate(num1, operand, num2);
            calc.addHistory(result);
            System.out.println("결과: " + result);

            System.out.print("지금까지 계산한 리스트를 확인하시겠습니까? y or n : ");
            String yn1 = a.nextLine().trim().toLowerCase();

            if(yn1.equals("y")) {
                System.out.println(calc.getHistory());
            }

            System.out.print("기록을 삭제하시겠습니까? y or n : ");
            String yn2 = a.nextLine().trim().toLowerCase();

            if(yn2.equals("y")) {
                calc.removeResult();
                System.out.println("삭제 되었습니다.");
            }

            System.out.println("더 계산하시겠습니까? y or exit : ");
            String yn = a.nextLine().trim().toLowerCase();

            if(yn.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        a.close();
    }
}