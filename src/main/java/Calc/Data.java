package Calc;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Data {


    public static double inputData(String m, Scanner scanner){
        System.out.println(m);
        //return scanner.nextDouble();
        double d;
        try{
            d = scanner.nextDouble();
        }
        catch (InputMismatchException ex) {
            System.out.println("---ОШИБКА---Допустимы для ввода только числа------");
            throw new InputMismatchException("Ввели не число");

        }
        return d;
    }

}