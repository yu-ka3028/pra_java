package com.example;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**
 * メインアプリケーションクラス
 */
public class App {
    // 有効な演算子のリスト
    private static final List<String> VALID_OPERATORS = Arrays.asList("+", "-", "*", "/");
    
    // 有効なアクションのリスト
    private static final List<String> VALID_ACTIONS = Arrays.asList("=", "clear");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            //デフォルトの値は0
            Integer count = 0;
            
            //電卓に入力した内容を取得
            System.out.println("Value a: ");
            int valueA = getValidInteger(scanner, "Value a");
            
            System.out.println("operator: ");
            String operator = getValidOperator(scanner);

            System.out.println("Value b: ");
            int valueB = getValidInteger(scanner, "Value b");

            System.out.println("= or clear");
            String action = getValidAction(scanner);

            if ("clear".equalsIgnoreCase(action)) {
                System.out.println("計算をクリアしました。");
                continue;
            } else if ("=".equals(action)) {
                // 計算実行
                try {
                    if ("+".equals(operator)) {
                        System.out.println("足し算");
                        count = calculator.add(valueA, valueB);
                        System.out.println("count: " + count);
                    } else if ("-".equals(operator)) {
                        System.out.println("引き算");
                        count = calculator.subtract(valueA, valueB);
                        System.out.println("count: " + count);
                    } else if ("*".equals(operator)) {
                        System.out.println("掛け算");
                        count = calculator.multiply(valueA, valueB);
                        System.out.println("count: " + count);
                    } else if ("/".equals(operator)) {
                        System.out.println("割り算");
                        count = calculator.divide(valueA, valueB);
                        System.out.println("count: " + count);
                    } else {
                        System.out.println("無効な演算子です");
                    }
                } catch (Exception e) {
                    System.out.println("エラー: " + e.getMessage());
                }
            } else {
                System.out.println("無効な入力です。= または clear を入力してください。");
            }
        }
    }
    
    /**
     * 有効な整数を取得するメソッド（型チェック）
     */
    private static int getValidInteger(Scanner scanner, String fieldName) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // 改行を消費
                return value;
            } else {
                System.out.println("エラー: " + fieldName + " には数値を入力してください。");
                scanner.nextLine(); // 無効な入力を消費
                System.out.println(fieldName + ": ");
            }
        }
    }
    
    /**
     * 有効な演算子を取得するメソッド（バリデーション）
     */
    private static String getValidOperator(Scanner scanner) {
        while (true) {
            String operator = scanner.nextLine();
            if (VALID_OPERATORS.contains(operator)) {
                return operator;
            } else {
                System.out.println("エラー: 演算子は +, -, *, / のいずれかを入力してください。");
                System.out.println("operator: ");
            }
        }
    }
    
    /**
     * 有効なアクションを取得するメソッド（バリデーション）
     */
    private static String getValidAction(Scanner scanner) {
        while (true) {
            String action = scanner.nextLine();
            if (VALID_ACTIONS.contains(action) || "clear".equalsIgnoreCase(action)) {
                return action;
            } else {
                System.out.println("エラー: = または clear を入力してください。");
                System.out.println("= or clear: ");
            }
        }
    }
}
