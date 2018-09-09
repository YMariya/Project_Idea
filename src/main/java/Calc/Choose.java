package Calc;



import java.util.Scanner;


public class Choose {
    //поле класса для получения разных реализаций интерфейса OperationForTwoOperands
    public OperationForTwoOperands someOper;
    private static Scanner scanner = new Scanner(System.in);


    protected OperationForTwoOperands choose(String msg) {
        System.out.println(msg);
        char oper = scanner.next().charAt(0);

        switch (oper) {
            case '+':
                someOper = new Sum();
                break;
            case '-':
                someOper = new Min();
                break;
            case '*':
                someOper = new Mult();
                break;
            case '/':
                someOper = new Del();
                break;
            default:
                System.out.println("Выбрали операцию не из списка");
        }
        return someOper;
    }
}