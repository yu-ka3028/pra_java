package com.example;
import java.util.Scanner;
import java.util.Random;
/**
 * メインアプリケーションクラス
 */
public class App {
    public static void main(String[] args) {
        // System.out.println("Hello, Java Development Environment!");
        // System.out.println("Java version: " + System.getProperty("java.version"));
        // System.out.println("Java home: " + System.getProperty("java.home"));
        
        //変数の扱い方
        // String name = "Taro";
        // System.out.println("Hello," + name);
        // System.out.println("Nice!!");

        // System.out.print("Hello," + name);
        // System.out.println("Nice!!");

        Integer count = 0;
        //答えは8で固定
        // Integer answer = 8;
        Integer answer = new Random().nextInt(10) + 1;

        while (true){
            // ユーザーからの入力をそのまま取得
            // System.out.print("Your guess:" + guess);

            //1.答えと一致したら正解、不正解なら残念と表示
            //2.guessに対してanswerが大きいか小さいかを判断して表示
            //3.正解するまでループする

            System.out.print("Your guess?(1-10) ");
            count++;
            Integer guess = new Scanner(System.in).nextInt();
            
            if (guess == answer){
                System.out.println("正解" + "Answer: " + answer + "\n" + "試行回数: " + count);
                break;
            } 
            else if (guess < answer){
                System.out.println("残念!!" + "Your guess:" + guess + "\n" + "もっと大きいです");
            }

            else {
                System.out.println("残念!!" + "Your guess:" + guess + "\n" + "もっと小さいです");
            }
        }
    }
    
} 