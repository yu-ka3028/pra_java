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

        String inputValue = scanner.nextLine();
        String[] values = inputValue.split("[-+*/]");
        String operator = inputValue.replaceAll("[0-9]", "");

        System.out.println("inputValue: " + inputValue);
        System.out.println("values: " + java.util.Arrays.toString(values));
        System.out.println("operator: " + operator);

        while(true){
            if("+".equals(operator)){
                System.out.println("足し算");
            } else if("-".equals(operator)){
                System.out.println("引き算");
            } else if("*".equals(operator)){
                System.out.println("掛け算");
            } else if("/".equals(operator)){
                System.out.println("割り算");
            } else{
                System.out.println("残念");
            }
            break;
        }
    }
}
