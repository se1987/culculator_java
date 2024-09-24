// package main.java;
import java.util.Scanner;

public class PersistentCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("電卓アプリへようこそ！'exit'と入力すると終了します。");

        // アプリが終了コマンドを受け取るまでループ
        while (true) {
            System.out.print("計算式を入力してください (例: 2 + 3): ");
            input = scanner.nextLine();

            // 'exit' が入力された場合、ループを終了してアプリを閉じる
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("電卓アプリを終了します。");
                break;
            }

            try {
                // 入力された式を計算して結果を表示
                double result = evaluate(input);
                System.out.println("結果: " + result);
            } catch (Exception e) {
                System.out.println("無効な式です。もう一度入力してください。");
            }
        }

        scanner.close();
    }

    // シンプルな計算式を評価するメソッド
    public static double evaluate(String expression) {
        // スペースを除去して式を処理する
        expression = expression.replaceAll("\\s", "");

        // 四則演算のみ対応
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double nextNumber = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += nextNumber;
                    break;
                case "-":
                    result -= nextNumber;
                    break;
                case "*":
                    result *= nextNumber;
                    break;
                case "/":
                    result /= nextNumber;
                    break;
                default:
                    throw new IllegalArgumentException("無効な演算子です。");
            }
        }

        return result;
    }
}
