# Issues Directory

このディレクトリには、プロジェクトの実装計画を GitHub issue 形式で管理するファイルが含まれています。

## ディレクトリ構造

```
issues/
├── README.md                           # このファイル
├── 01-calculator-app/                  # 電卓アプリケーション
│   ├── parent-issue.md                 # 親issue（概要・管理）
│   ├── 01-basic-calculator.md          # 基本電卓機能
│   ├── 02-advanced-operations.md       # 高度な演算機能
│   └── 03-error-handling.md            # エラーハンドリング
├── 02-inventory-management/            # 在庫管理システム
│   ├── parent-issue.md                 # 親issue（概要・管理）
│   ├── 01-inventory-model.md           # 在庫モデル設計
│   ├── 02-stock-operations.md          # 在庫操作機能
│   └── 03-expiry-management.md         # 賞味期限管理
├── 03-schedule-management/             # スケジュール管理
│   ├── parent-issue.md                 # 親issue（概要・管理）
│   ├── 01-schedule-model.md            # スケジュールモデル
│   ├── 02-calendar-operations.md       # カレンダー操作
│   └── 03-reminder-system.md           # リマインダー機能
├── 04-web-api/                         # Web API開発
│   ├── parent-issue.md                 # 親issue（概要・管理）
│   ├── 01-spring-boot-setup.md         # Spring Boot設定
│   ├── 02-rest-api-design.md           # REST API設計
│   └── 03-database-integration.md      # データベース統合
└── 05-frontend-ui/                     # フロントエンドUI
    ├── parent-issue.md                 # 親issue（概要・管理）
    ├── 01-react-setup.md               # React設定
    ├── 02-inventory-dashboard.md       # 在庫ダッシュボード
    └── 03-schedule-calendar.md         # スケジュールカレンダー
```

## Issue ファイルの構成

各 issue ファイルは以下の構成で作成されています：

### 親 Issue（parent-issue.md）

- **概要**: 機能の全体像
- **サブ Issue 一覧**: 関連する issue の管理
- **依存関係**: 他の機能との関連
- **完了条件**: 全体の完了基準

### サブ Issue（各機能ファイル）

- **目的**: 実装の目的
- **ゴール**: 具体的な完了目標
- **事前準備（調査）**: 必要な調査項目
- **実装のタスク分解**: 具体的な実装タスク
- **動作確認チェックリスト**: テスト項目
- **その他備考**: 注意事項・参考資料

## 使用方法

1. **実装開始前**: 該当する issue ファイルを確認
2. **実装中**: タスクの進捗をチェックリストで管理
3. **実装完了**: 動作確認チェックリストで検証
4. **次の issue**: 依存関係を確認して次に進む

## 更新ルール

- 実装中は進捗状況をコメントで記録
- 完了したタスクはチェックリストで確認
- 新たな課題が見つかった場合は備考に追加
- 大きな変更がある場合は issue ファイルを更新

## 参考資料

- [GitHub Issues Best Practices](https://docs.github.com/en/issues)
- [Project Management with GitHub](https://docs.github.com/en/issues/organizing-your-work-with-project-boards)
