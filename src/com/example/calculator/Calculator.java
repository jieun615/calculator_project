package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
public class Calculator {

    private List<Long> history;

    public Calculator() {
        this.history = new ArrayList<>();
    }
    public long calculate(long num1, OperatorType operand, long num2) {
        long result = operand.apply(num1, num2);
        history.add(result);
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
            System.out.println(history);
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}
