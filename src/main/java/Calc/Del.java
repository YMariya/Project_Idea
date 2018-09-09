
package Calc;


public class Del implements OperationForTwoOperands {

    public Double solve(Double a, Double b) {
        if(b==0) throw new ArithmeticException("поделили на ноль");
        return a/b;
    }

    public String getName() {
        return "/";
    }
}