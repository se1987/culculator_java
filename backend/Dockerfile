# ベースイメージとしてMavenを使用（JDK 17を含む）
FROM maven:3.8.5-openjdk-17 AS build

# 作業ディレクトリを設定
WORKDIR /app

# プロジェクトのpom.xmlとソースコードをコピー
COPY pom.xml .
COPY src ./src

# Mavenでプロジェクトをビルドし、テストを実行
RUN mvn clean test

# アプリケーションを実行
CMD ["mvn", "exec:java", "-Dexec.mainClass=FinancialCalculator"]
