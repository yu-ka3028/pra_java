# 基本電卓機能の実装

## 目的

Java の基本文法を習得しながら、四則演算ができるコンソールベースの電卓アプリケーションを開発します。

## ゴール

- 四則演算（加算、減算、乗算、除算）が正常に動作する
- コンソールから数値と演算子を入力できる
- 計算結果を適切に表示できる
- 基本的な入力値チェックができる

## 事前準備（調査）

### 1. Java 基本文法の確認

- [ ] 変数の宣言と初期化
- [ ] メソッドの定義と呼び出し
- [ ] 条件分岐（if-else 文）
- [ ] ループ処理（for 文、while 文）
- [ ] 配列の使用方法

### 2. コンソール入出力の調査

- [x] `Scanner`クラスの使用方法
- [x] `System.out.println()`の使用方法
- [ ] 文字列と数値の変換方法

### 3. 計算精度の調査

- [ ] `double`型と`BigDecimal`の違い
- [ ] 浮動小数点数の精度問題
- [ ] 薬剤計算での精度要件

## 実装のタスク分解
branch: console_calc
### Phase 1: 基本構造の作成

- [ ] `Calculator`クラスの作成
- [ ] メインメソッドの実装
- [ ] 基本的な計算メソッドの定義

### Phase 2: 四則演算の実装

- [ ] 加算メソッドの実装
- [ ] 減算メソッドの実装
- [ ] 乗算メソッドの実装
- [ ] 除算メソッドの実装

### Phase 3: コンソール入出力の実装

- [ ] `Scanner`オブジェクトの作成
- [ ] 数値入力の処理
- [ ] 演算子入力の処理
- [ ] 結果表示の実装

### Phase 4: 入力値チェックの実装

- [ ] 数値の妥当性チェック
- [ ] 演算子の妥当性チェック
- [ ] エラーメッセージの表示

## 動作確認チェックリスト

### 基本機能テスト

- [ ] 加算（5 + 3 = 8）が正常に動作する
- [ ] 減算（10 - 4 = 6）が正常に動作する
- [ ] 乗算（6 \* 7 = 42）が正常に動作する
- [ ] 除算（15 / 3 = 5）が正常に動作する

### エッジケーステスト

- [ ] 大きな数値の計算が正常に動作する
- [ ] 小数の計算が正常に動作する
- [ ] 負の数の計算が正常に動作する
- [ ] ゼロの計算が正常に動作する

### 入力値チェックテスト

- [ ] 不正な数値入力時にエラーメッセージが表示される
- [ ] 不正な演算子入力時にエラーメッセージが表示される
- [ ] プログラムが異常終了しない

### ユーザビリティテスト

- [ ] 入力方法が分かりやすい
- [ ] エラーメッセージが理解しやすい
- [ ] 計算結果が正確に表示される

## その他備考

### 注意事項

- 薬剤計算では精度が重要なので、必要に応じて`BigDecimal`を使用する
- 家族向けシステムとして、使いやすさを重視する
- 将来的な機能拡張を考慮した設計にする

### 参考資料

- [Java Scanner Class](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html)
- [Java Math Class](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html)
- [BigDecimal for Precise Calculations](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigDecimal.html)

### 実装例

```java
public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("ゼロ除算はできません");
        }
        return a / b;
    }
}
```

### 次のステップ

- 高度な演算機能の実装
- エラーハンドリングの強化
- 単体テストの作成
