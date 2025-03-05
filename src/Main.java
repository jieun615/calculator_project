import com.example.calculator.Calculator;
import com.example.calculator.OperatorType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner a = new Scanner(System.in);
        long result;

        while (true) {
            System.out.print("첫 번째 정수를 입력하세요 : ");
            long num1 = a.nextLong();

            a.nextLine();
            System.out.print("사칙 연산 기호를 입력하세요 : ");
            String operand = a.nextLine();

            System.out.print("두 번째 정수를 입력하세요 : ");
            long num2 = a.nextLong();
            a.nextLine();

            try {
                OperatorType operatorType = OperatorType.fromSymbol(operand);
                result = calc.calculate(num1, operatorType, num2);
                System.out.println("결과 : " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.print("지금까지 계산한 리스트를 확인하시겠습니까? y or n : ");
            String yn1 = a.nextLine().trim().toLowerCase();

            if (yn1.equals("y")) {
                System.out.println(calc.getHistory());
            }

            System.out.print("앞 기록을 삭제하시겠습니까? y or n : ");
            String yn2 = a.nextLine().trim().toLowerCase();

            if (yn2.equals("y")) {
                calc.removeResult();

                System.out.println("삭제 되었습니다.");
            }

            System.out.println("더 계산하시겠습니까? y or exit : ");
            String yn = a.nextLine().trim().toLowerCase();

            if (yn.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        a.close();
    }
}