# Java Development Environment

このプロジェクトは、Docker を使用した軽量な Java 開発環境です。

## 必要な環境

- Docker Desktop
- Visual Studio Code（推奨）

## セットアップ手順

### 1. Docker 環境の起動

```bash
# コンテナをビルドして起動
docker-compose up -d

# コンテナ内に入る
docker-compose exec java-dev bash
```

### 2. 環境の確認

コンテナ内で以下のコマンドを実行して環境を確認：

```bash
java -version
mvn -version
```

## プロジェクト構造

```
pra_java/
├── Dockerfile              # Docker環境設定
├── docker-compose.yml      # Docker Compose設定
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
# コンテナ内で実行
docker-compose exec java-dev mvn compile exec:java -Dexec.mainClass="com.example.App"

# または、コンテナ内に入ってから実行
docker-compose exec java-dev bash
mvn compile exec:java -Dexec.mainClass="com.example.App"
```

### テストの実行

```bash
# すべてのテストを実行
docker-compose exec java-dev mvn test

# 特定のテストクラスを実行
docker-compose exec java-dev mvn test -Dtest=AppTest
```

### プロジェクトのビルド

```bash
# JARファイルを作成
docker-compose exec java-dev mvn clean package

# 作成されたJARファイルを実行
docker-compose exec java-dev java -jar target/pra-java-1.0.0.jar
```

## 開発ワークフロー

### 1. コンテナの起動

```bash
docker-compose up -d
```

### 2. コンテナ内で開発

```bash
docker-compose exec java-dev bash
```

### 3. コードの編集

- ローカルの VS Code でファイルを編集
- コンテナ内で Maven コマンドを実行

### 4. コンテナの停止

```bash
docker-compose down
```

## 含まれる機能

- **Java 17**: 最新の LTS バージョン
- **Maven**: ビルドツール
- **Git**: バージョン管理
- **軽量**: Dev Container より高速で軽量

## カスタマイズ

### Java バージョンの変更

`Dockerfile`の`FROM`行を変更：

```dockerfile
FROM openjdk:11-jdk-slim  # Java 11
FROM openjdk:21-jdk-slim  # Java 21
```

### 追加の依存関係

`Dockerfile`の`RUN apt-get install`に追加：

```dockerfile
RUN apt-get update && apt-get install -y \
    maven \
    git \
    curl \
    wget \
    && rm -rf /var/lib/apt/lists/*
```

## トラブルシューティング

### コンテナが起動しない場合

1. Docker Desktop が起動していることを確認
2. ポート 8081 が使用されていないことを確認
3. 十分なディスク容量があることを確認

### Maven 関連のエラー

1. コンテナ内で`mvn clean`を実行してキャッシュをクリア
2. Maven の依存関係を再ダウンロード：
   ```bash
   docker-compose exec java-dev mvn dependency:resolve
   ```

### パフォーマンスの改善

1. Maven キャッシュボリュームを使用（既に設定済み）
2. 必要に応じて`MAVEN_OPTS`を調整

## ローカル開発（代替案）

Dev Container や Docker を使わずにローカルで開発する場合：

```bash
# Mavenをインストール
brew install maven

# Java 17をインストール
brew install openjdk@17

# 環境変数を設定
echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc

# アプリケーション実行
mvn compile exec:java -Dexec.mainClass="com.example.App"
```
