# フロントエンド UI 開発（React）

## 概要

Spring Boot で作成した Web API と連携するフロントエンド UI を React で開発します。在庫管理とスケジュール管理の機能をブラウザで利用できる Web アプリケーションを作成します。

## 目的

- React フレームワークの習得
- フロントエンド開発の基礎知識の獲得
- API 連携の実装
- モダンな Web 開発の体験

## サブ Issue 一覧

### 1. [React 設定](./01-react-setup.md)

- React プロジェクトの作成
- 開発環境の構築
- 基本的なコンポーネント設計

### 2. [在庫ダッシュボード](./02-inventory-dashboard.md)

- 在庫一覧表示
- 在庫追加・編集・削除機能
- 在庫不足アラート

### 3. [スケジュールカレンダー](./03-schedule-calendar.md)

- カレンダー表示
- スケジュール追加・編集・削除機能
- リマインダー機能

## 依存関係

- **前提条件**: Web API 開発の完了
- **後続機能**: なし（最終段階）
- **外部依存**: React、Node.js、npm/yarn

## 完了条件

- [ ] React アプリケーションが正常に起動する
- [ ] 在庫管理の UI が動作する
- [ ] スケジュール管理の UI が動作する
- [ ] Web API との連携が正常に動作する
- [ ] レスポンシブデザインが適用されている

## 技術スタック

- **フレームワーク**: React 18
- **言語**: TypeScript
- **スタイリング**: CSS Modules / Styled Components
- **状態管理**: React Hooks / Context API
- **HTTP 通信**: Axios / Fetch API
- **ビルドツール**: Vite

## 予定スケジュール

- **Week 1**: React 設定と基本コンポーネント
- **Week 2**: 在庫ダッシュボードの実装
- **Week 3**: スケジュールカレンダーの実装

## 成果物

- `frontend/src/components/InventoryDashboard.tsx`
- `frontend/src/components/ScheduleCalendar.tsx`
- `frontend/src/services/api.ts`
- `frontend/src/types/index.ts`
- `frontend/package.json`
- `frontend/README.md`

## UI 設計方針

### 1. ユーザビリティ

- 家族向けの使いやすさを重視
- 直感的な操作
- 視覚的に分かりやすいデザイン

### 2. レスポンシブデザイン

- デスクトップ、タブレット、スマートフォン対応
- モバイルファーストの設計
- タッチ操作への配慮

### 3. アクセシビリティ

- キーボード操作対応
- スクリーンリーダー対応
- 色覚異常への配慮

## 主要機能

### 在庫ダッシュボード

- 在庫一覧の表示（グリッド/リスト表示）
- 在庫追加フォーム
- 在庫編集・削除機能
- 在庫不足の警告表示
- 賞味期限の警告表示
- 検索・フィルタリング機能

### スケジュールカレンダー

- 月間カレンダー表示
- スケジュール追加フォーム
- スケジュール編集・削除機能
- 今日のスケジュール表示
- リマインダー通知
- 家族メンバー別の色分け

## コンポーネント設計

### 共通コンポーネント

```typescript
// ボタン、フォーム、モーダル等
interface ButtonProps {
  variant: 'primary' | 'secondary' | 'danger';
  children: React.ReactNode;
  onClick: () => void;
}

interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  title: string;
  children: React.ReactNode;
}
```

### 在庫管理コンポーネント

```typescript
interface InventoryItem {
  id: number;
  name: string;
  quantity: number;
  unit: string;
  expiryDate: string;
  category: string;
}

interface InventoryDashboardProps {
  items: InventoryItem[];
  onAdd: (item: Omit<InventoryItem, 'id'>) => void;
  onUpdate: (id: number, item: Partial<InventoryItem>) => void;
  onDelete: (id: number) => void;
}
```

### スケジュール管理コンポーネント

```typescript
interface Schedule {
  id: number;
  title: string;
  startTime: string;
  endTime: string;
  description: string;
  member: string;
}

interface ScheduleCalendarProps {
  schedules: Schedule[];
  onAdd: (schedule: Omit<Schedule, 'id'>) => void;
  onUpdate: (id: number, schedule: Partial<Schedule>) => void;
  onDelete: (id: number) => void;
}
```

## 備考

- 薬剤師の経験を活かした直感的な UI 設計
- 家族の健康管理に役立つ視覚的な情報表示
- 将来的な機能拡張を考慮したコンポーネント設計
- パフォーマンスを考慮した最適化
- セキュリティを考慮した API 通信
