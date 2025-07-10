package com.example;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**
 * メインアプリケーションクラス
 */
public class App {
    private static final List<String> VALID_OPERATORS = Arrays.asList("+", "-", "*", "/", "^", "sqrt");
    private static final List<String> VALID_ACTIONS = Arrays.asList("=", "clear");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            //デフォルトの値は0
            double count = 0;
            
            System.out.println("Value a: ");
            double valueA = getValidDouble(scanner, "Value a");
            
            System.out.println("operator(+, -, *, /, ^, sqrt): ");
            String operator = getValidOperator(scanner);

            double valueB = 0.0;
            if (!"sqrt".equals(operator)) {
                System.out.println("Value b: ");
                valueB = getValidDouble(scanner, "Value b");
            }

            System.out.println("= or clear");
            String action = getValidAction(scanner);

            if ("clear".equalsIgnoreCase(action)) {
                System.out.println("計算をクリアしました。");
                continue;
            } else if ("=".equals(action)) {
                try {
                    switch (operator) {
                        case "+":
                            System.out.println("足し算");
                            count = calculator.add(valueA, valueB);
                            break;
                        case "-":
                            System.out.println("引き算");
                            count = calculator.subtract(valueA, valueB);
                            break;
                        case "*":
                            System.out.println("掛け算");
                            count = calculator.multiply(valueA, valueB);
                            break;
                        case "/":
                            System.out.println("割り算");
                            count = calculator.divide(valueA, valueB);
                            break;
                        case "^":
                            System.out.println("累乗");
                            count = calculator.power(valueA, valueB);
                            break;
                        case "sqrt":
                            System.out.println("平方根");
                            count = calculator.sqrt(valueA);
                            break;
                        default:
                            System.out.println("無効な演算子です");
                            continue;
                    }
                    System.out.println("count: " + count);
                } catch (Exception e) {
                    System.out.println("エラー: " + e.getMessage());
                }
            } else {
                System.out.println("無効な入力です。= または clear を入力してください。");
            }
        }
    }
    
    /**
     * 結果を有効数字に合わせてフォーマットするメソッド
     */

    
    /**
     * 有効な小数を取得するメソッド（型チェック）
     */
    private static double getValidDouble(Scanner scanner, String fieldName) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
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
                System.out.println("エラー: 演算子は +, -, *, /, ^ のいずれかを入力してください。");
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
