package Calc;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Oper {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            try {

                Double firstOperand = Data.inputData("Вести первое дробное число А через запятую: ", scanner);
                Double secondOperand = Data.inputData("Вести второе дробное число Б через запятую: ", scanner1);
                OperationForTwoOperands operation =
                        new Choose().choose("Выбрать тип операции для (А ? Б) из следующих: +, -, *, /");


                Double result = operation.solve(firstOperand, secondOperand);
                System.out.printf(firstOperand + " " + operation.getName() + " " + secondOperand + " = ");
                System.out.printf("%.4f%n", result);
            } catch (InputMismatchException ex) {
                System.out.println("---ОШИБКА---Пожалуйста, введите числа------");
            } catch (ArithmeticException ex) {
                System.out.println("---ОШИБКА---Была попытка поделить на 0------");
            }
            finally {
                System.out.println("Введите 0, если хотите продолжить использовать калькулятор");
                try {
                    int use = scanner2.nextInt();
                    if (use != 0) {
                        scanner.close();
                        scanner1.close();
                        scanner2.close();
                        break;
                    }

                }catch (Exception ex) {
                    scanner.close();
                    scanner1.close();
                    scanner2.close();
                    break;
                }
            }
        }
    }
}