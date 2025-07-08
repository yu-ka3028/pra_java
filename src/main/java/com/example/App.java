package com.example;
import java.util.Scanner;
/**
 * メインアプリケーションクラス
 */
public class App {
    public static void main(String[] args) {
        //デフォルトの値は0
        Integer count = 0;
        //電卓に入力した内容を取得
        System.out.println("電卓: ");
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String inputValue = scanner.nextLine();
        String[] values = inputValue.split("[-+*/]");
        String operator = inputValue.replaceAll("[0-9]", "");

        System.out.println("inputValue: " + inputValue);
        System.out.println("values: " + java.util.Arrays.toString(values));
        System.out.println("operator: " + operator);

        while(true){
            if("+".equals(operator)){
                System.out.println("足し算");
                count = calculator.add(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                System.out.println("count: " + count);
            } else if("-".equals(operator)){
                System.out.println("引き算");
                count = calculator.subtract(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                System.out.println("count: " + count);
            } else if("*".equals(operator)){
                System.out.println("掛け算");
                count = calculator.multiply(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                System.out.println("count: " + count);
            } else if("/".equals(operator)){
                System.out.println("割り算");
                count = calculator.divide(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                System.out.println("count: " + count);
            } else{
                System.out.println("残念");
            }
            break;
        }
    }
}
