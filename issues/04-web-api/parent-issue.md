# Web API 開発（Spring Boot）

## 概要

コンソールアプリケーションを Spring Boot を使用して Web API 化します。RESTful API として在庫管理とスケジュール管理の機能を提供し、将来的なフロントエンド開発の基盤を構築します。

## 目的

- Spring Boot フレームワークの習得
- RESTful API 設計の理解
- データベース連携の実装
- Web 開発の基礎知識の獲得

## サブ Issue 一覧

### 1. [Spring Boot 設定](./01-spring-boot-setup.md)

- Spring Boot プロジェクトの設定
- 依存関係の管理
- アプリケーション設定

### 2. [REST API 設計](./02-rest-api-design.md)

- 在庫管理 API の設計
- スケジュール管理 API の設計
- エンドポイントの定義

### 3. [データベース統合](./03-database-integration.md)

- H2 データベースの設定
- JPA エンティティの作成
- リポジトリパターンの実装

## 依存関係

- **前提条件**: 在庫管理システム、スケジュール管理システムの完了
- **後続機能**: フロントエンド UI 開発
- **外部依存**: Spring Boot、H2 Database、JPA

## 完了条件

- [ ] Spring Boot アプリケーションが正常に起動する
- [ ] 在庫管理の REST API が動作する
- [ ] スケジュール管理の REST API が動作する
- [ ] データベースとの連携が正常に動作する
- [ ] API ドキュメントが作成されている

## 技術スタック

- **フレームワーク**: Spring Boot 3.2.0
- **データベース**: H2 Database（開発用）
- **ORM**: Spring Data JPA
- **API 仕様**: OpenAPI 3.0
- **テスト**: Spring Boot Test

## 予定スケジュール

- **Week 1**: Spring Boot 設定と基本 API
- **Week 2**: 在庫管理 API の実装
- **Week 3**: スケジュール管理 API の実装

## 成果物

- `src/main/java/com/example/web/InventoryController.java`
- `src/main/java/com/example/web/ScheduleController.java`
- `src/main/java/com/example/entity/InventoryItem.java`
- `src/main/java/com/example/entity/Schedule.java`
- `src/main/resources/application.properties`
- `src/test/java/com/example/web/ControllerTest.java`

## API 設計方針

### 1. RESTful 設計

- リソース指向の URL 設計
- HTTP メソッドの適切な使用
- ステータスコードの適切な返却

### 2. データ形式

- リクエスト・レスポンスは JSON 形式
- 日付は ISO 8601 形式
- エラーレスポンスの統一

### 3. セキュリティ

- 基本的な入力値検証
- CORS 設定
- 将来的な認証機能の準備

## エンドポイント例

### 在庫管理 API

```
GET    /api/inventory          # 在庫一覧取得
POST   /api/inventory          # 在庫追加
GET    /api/inventory/{id}     # 在庫詳細取得
PUT    /api/inventory/{id}     # 在庫更新
DELETE /api/inventory/{id}     # 在庫削除
GET    /api/inventory/low-stock # 在庫不足アイテム取得
```

### スケジュール管理 API

```
GET    /api/schedules          # スケジュール一覧取得
POST   /api/schedules          # スケジュール追加
GET    /api/schedules/{id}     # スケジュール詳細取得
PUT    /api/schedules/{id}     # スケジュール更新
DELETE /api/schedules/{id}     # スケジュール削除
GET    /api/schedules/today    # 今日のスケジュール取得
```

## 備考

- 開発環境では H2 Database を使用し、本番環境では PostgreSQL 等を想定
- API ドキュメントは Swagger UI で自動生成
- 将来的な認証・認可機能の拡張を考慮した設計
- フロントエンド開発との連携を考慮した CORS 設定
