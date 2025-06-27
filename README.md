# Java Development Environment

このプロジェクトは、Dev Container を使用した Java 開発環境です。

## 必要な環境

- Docker Desktop
- Visual Studio Code
- Dev Containers 拡張機能

## セットアップ手順

### 1. Dev Container の起動

1. VS Code でこのプロジェクトを開く
2. `Ctrl+Shift+P` (macOS: `Cmd+Shift+P`) でコマンドパレットを開く
3. "Dev Containers: Reopen in Container" を選択
4. コンテナのビルドと起動を待つ

### 2. 環境の確認

コンテナ内で以下のコマンドを実行して環境を確認：

```bash
java -version
mvn -version
gradle -version
```

## プロジェクト構造

```
pra_java/
├── .devcontainer/
│   └── devcontainer.json    # Dev Container設定
├── src/
│   ├── main/java/
│   │   └── com/example/
│   │       └── App.java     # メインアプリケーション
│   └── test/java/
│       └── com/example/
│           └── AppTest.java # テストクラス
├── pom.xml                  # Maven設定
└── README.md               # このファイル
```

## 使用方法

### アプリケーションの実行

```bash
# Mavenでコンパイルと実行
mvn compile exec:java -Dexec.mainClass="com.example.App"

# または直接Javaで実行
mvn compile
java -cp target/classes com.example.App
```

### テストの実行

```bash
# すべてのテストを実行
mvn test

# 特定のテストクラスを実行
mvn test -Dtest=AppTest
```

### プロジェクトのビルド

```bash
# JARファイルを作成
mvn clean package

# 作成されたJARファイルを実行
java -jar target/pra-java-1.0.0.jar
```

## 含まれる機能

- **Java 17**: 最新の LTS バージョン
- **Maven**: ビルドツール
- **Gradle**: 代替ビルドツール
- **JUnit 5**: テストフレームワーク
- **VS Code 拡張機能**:
  - Java Extension Pack
  - Maven for Java
  - Test Runner for Java
  - Debugger for Java

## カスタマイズ

### Java バージョンの変更

`.devcontainer/devcontainer.json`の`version`を変更：

```json
"ghcr.io/devcontainers/features/java:1": {
  "version": "11",  // または "8", "21" など
  "installMaven": true,
  "installGradle": true
}
```

### 追加の依存関係

`pom.xml`に必要な依存関係を追加してください。

## トラブルシューティング

### コンテナが起動しない場合

1. Docker Desktop が起動していることを確認
2. 十分なメモリが割り当てられていることを確認（推奨: 4GB 以上）
3. VS Code の Dev Containers 拡張機能がインストールされていることを確認

### Java 関連のエラー

1. コンテナ内で`java -version`を実行して Java が正しくインストールされているか確認
2. `mvn clean`を実行してキャッシュをクリア
3. VS Code の Java 拡張機能が正しく動作しているか確認
