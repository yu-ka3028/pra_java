# 高度な演算機能の実装

## 目的

基本電卓機能を拡張し、在庫管理システムで実用的な高度な演算機能を実装します。累乗、平方根、メモリ機能、統計計算を追加して、より実用的な電卓アプリケーションを開発します。

## ゴール

- 累乗計算（x^y）が正常に動作する
- 平方根計算（√x）が正常に動作する
- メモリ機能（M+, M-, MR, MC）が正常に動作する
- 統計計算（平均、標準偏差）が正常に動作する
- 在庫管理での実用性を考慮した設計になっている

## 事前準備（調査）

### 1. Java 数学ライブラリの調査

- [ ] `Math`クラスの使用方法
- [ ] `Math.pow()`メソッドの使用方法
- [ ] `Math.sqrt()`メソッドの使用方法
- [ ] 精度管理の方法

### 2. メモリ機能の設計

- [ ] メモリ変数の管理方法
- [ ] メモリ操作のユーザーインターフェース
- [ ] メモリ状態の表示方法

### 3. 統計計算の実装

- [ ] 配列を使用したデータ管理
- [ ] 平均値の計算方法
- [ ] 標準偏差の計算方法
- [ ] 在庫管理での統計活用方法

## 実装のタスク分解

### Phase 1: 累乗・平方根機能の実装

- [ ] `power()`メソッドの実装（Math.pow()を使用）
- [ ] `squareRoot()`メソッドの実装（Math.sqrt()を使用）
- [ ] 負の数の平方根エラーハンドリング
- [ ] 累乗計算の精度管理

### Phase 2: メモリ機能の実装

- [ ] メモリ変数の定義
- [ ] `memoryAdd()`メソッドの実装（M+）
- [ ] `memorySubtract()`メソッドの実装（M-）
- [ ] `memoryRecall()`メソッドの実装（MR）
- [ ] `memoryClear()`メソッドの実装（MC）

### Phase 3: 統計計算機能の実装

- [ ] データ配列の管理
- [ ] `calculateAverage()`メソッドの実装
- [ ] `calculateStandardDeviation()`メソッドの実装
- [ ] 統計データの表示機能

### Phase 4: ユーザーインターフェースの拡張

- [ ] 新しい演算子の入力処理
- [ ] メモリ状態の表示
- [ ] 統計データの入力・表示
- [ ] ヘルプ機能の追加

## 動作確認チェックリスト

### 累乗・平方根機能テスト

- [ ] 累乗計算（2^3 = 8）が正常に動作する
- [ ] 平方根計算（√16 = 4）が正常に動作する
- [ ] 負の数の平方根でエラーメッセージが表示される
- [ ] 小数の累乗・平方根が正常に動作する

### メモリ機能テスト

- [ ] M+（メモリ加算）が正常に動作する
- [ ] M-（メモリ減算）が正常に動作する
- [ ] MR（メモリ呼び出し）が正常に動作する
- [ ] MC（メモリクリア）が正常に動作する
- [ ] メモリ状態が適切に表示される

### 統計計算機能テスト

- [ ] 平均値計算が正常に動作する
- [ ] 標準偏差計算が正常に動作する
- [ ] 複数のデータ入力が正常に処理される
- [ ] 統計結果が適切に表示される

### 在庫管理での実用性テスト

- [ ] 在庫率の計算（平方根を使用した標準偏差）
- [ ] 平均使用量の計算
- [ ] 在庫予測の精度向上
- [ ] 薬剤濃度計算での精度向上

## その他備考

### 注意事項

- 薬剤計算では精度が重要なので、`BigDecimal`の使用を検討する
- 在庫管理での実用性を重視した機能設計にする
- メモリ機能は在庫の一時的な計算に活用できる
- 統計計算は在庫予測や品質管理に活用できる

### 参考資料

- [Java Math Class](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html)
- [BigDecimal for Precise Calculations](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigDecimal.html)
- [Statistics in Inventory Management](https://www.investopedia.com/terms/s/standarddeviation.asp)

### 実装例

```java
public class AdvancedCalculator extends Calculator {
    private double memory = 0.0;
    private List<Double> dataPoints = new ArrayList<>();

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("負の数の平方根は計算できません");
        }
        return Math.sqrt(number);
    }

    public void memoryAdd(double value) {
        memory += value;
    }

    public void memorySubtract(double value) {
        memory -= value;
    }

    public double memoryRecall() {
        return memory;
    }

    public void memoryClear() {
        memory = 0.0;
    }

    public void addDataPoint(double value) {
        dataPoints.add(value);
    }

    public double calculateAverage() {
        if (dataPoints.isEmpty()) {
            throw new IllegalStateException("データがありません");
        }
        return dataPoints.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calculateStandardDeviation() {
        if (dataPoints.size() < 2) {
            throw new IllegalStateException("標準偏差の計算には2つ以上のデータが必要です");
        }

        double average = calculateAverage();
        double variance = dataPoints.stream()
            .mapToDouble(x -> Math.pow(x - average, 2))
            .average()
            .orElse(0.0);

        return Math.sqrt(variance);
    }
}
```

### 次のステップ

- エラーハンドリングの強化
- 単体テストの作成
- 在庫管理システムとの統合準備
