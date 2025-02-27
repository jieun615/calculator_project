package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        long result;
        String err;
        Scanner a = new Scanner(System.in);
        while (true) {
            result = 0L;
            err = "";
            System.out.println("첫 번째 정수를 입력하세요 : ");
            int num1 = a.nextInt();

            a.nextLine();
            System.out.println("사칙 연산 기호를 입력하세요 : ");
            String operand = a.nextLine();

            System.out.println("두 번째 정수를 입력하세요 : ");
            int num2 = a.nextInt();

            switch (operand) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        err = "0으로 나눌 수 없습니다.";
                    } else {
                        result = num1 / num2;
                    }
                    break;
                case "%":
                    if (num2 == 0) {
                        err = "0으로 나눌 수 없습니다.";
                    } else {
                        result = num1 % num2;
                    }
                    break;
                default:
                    err = "잘못된 연산 기호입니다.";
                    break;
            }
            if (!err.isEmpty()) {
                System.out.println(err);
            } else {
                System.out.println("결과: " + result);
            }
            a.nextLine();
            System.out.println("더 계산하시겠습니까? y or exit");
            String yn = a.nextLine().trim().toLowerCase();

            if(yn.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        a.close();
    }
}
