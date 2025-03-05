package com.example.calculator;

public enum OperatorType {
    ADD("+") {
        public long apply(long num1, long num2) {
            return num1 + num2;
        }
    },
    SUB("-") {
        public long apply(long num1, long num2) {
            return num1 - num2;
        }
    },
    MUL("*") {
        public long apply(long num1, long num2) {
            return num1 * num2;
        }
    },
    DIVD("/") {
        public long apply(long num1, long num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    },
    MOD("%") {
        public long apply(long num1, long num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return num1 % num2;
        }
    };

    private final String symbol;
    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract long apply(long x, long y);

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다: " + symbol);
    }
}