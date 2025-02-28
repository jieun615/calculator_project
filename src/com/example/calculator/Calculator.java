package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
public class Calculator {

    private List<Long> history;

    public Calculator() {
        this.history = new ArrayList<>();
    }
    public long calculate(long num1, String operand, long num2) {
        long result = 0;

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
                    System.out.println("0으로 나눌 수 없습니다.");
                    return result;
                }
                result = num1 / num2;
                break;
            case "%":
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return result;
                }
                result = num1 % num2;
                break;
            default:
                System.out.println("잘못된 연산 기호입니다.");
                break;
        }
        return result;
    }
    public List<Long> getHistory() {
        return history;
    }

    public void addHistory(long result) {
        history.add(result);
    }

    public void removeResult() {
        if (!history.isEmpty()) {
            long removedValue = history.remove(0);
            System.out.println("삭제된 결과: " + removedValue);
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}
