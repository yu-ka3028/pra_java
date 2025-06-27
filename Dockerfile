# Java 17 + Maven の軽量な開発環境
FROM openjdk:17-jdk-slim

# 作業ディレクトリを設定
WORKDIR /app

# Mavenをインストール
RUN apt-get update && apt-get install -y \
    maven \
    git \
    && rm -rf /var/lib/apt/lists/*

# Mavenの設定を最適化（Java 17対応）
ENV MAVEN_OPTS="-Xmx512m"

# ポートを公開（必要に応じて）
EXPOSE 8080

# デフォルトコマンド
CMD ["bash"] 