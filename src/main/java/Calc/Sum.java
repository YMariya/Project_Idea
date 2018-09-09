package Calc;


public class Sum implements OperationForTwoOperands {

    public Double solve(Double a, Double b) {
        return a+b;
    }

    public String getName() {
        return "+";
    }
}