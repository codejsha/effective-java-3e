package org.example.demo.chapter6.item34;

// Switch on an enum to simulate a missing method (Page 167)
public class Inverse {
    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS:
                return Operation.MINUS;
            case MINUS:
                return Operation.PLUS;
            case TIMES:
                return Operation.DIVIDE;
            case DIVIDE:
                return Operation.TIMES;

            default:
                throw new AssertionError("Unknown op: " + op);
        }
    }

    public static void main(String[] args) {
        var x = Double.parseDouble(args[0]);
        var y = Double.parseDouble(args[1]);
        for (var op : Operation.values()) {
            var invOp = inverse(op);
            System.out.printf("%f %s %f %s %f = %f%n",
                    x, op, y, invOp, y, invOp.apply(op.apply(x, y), y));
        }
    }
}
