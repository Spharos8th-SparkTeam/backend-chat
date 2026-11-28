# backend-chat API 정의서 (채팅 서비스)

> 회원 식별은 Gateway 연동 전 `X-Member-UUID` 헤더로 받는다.
> JWT 검증은 Gateway 책임이며 본 서비스에 Security/JWT를 두지 않는다.
> 공식 API 시트에는 채팅 구분의 req/res가 아직 없다. 아래 URI는 기능명세서(No.23~25)와 Gateway 경로(`/api/v1/chats/**`)에 맞춘 **잠정 정의**다.
> MongoDB Document·Repository 연동 전 API 골격은 stub으로 두고, 스키마 확정 후 구현한다.

| 요구사항 이름 | HTTP 메소드 | Version | URI | req | res | 비고 |
|---|---|---|---|---|---|---|
| 채팅방 목록 조회 | GET | /api/v1 | /chats | Header: X-Member-UUID | (미정) | 메시지 없는 방은 미노출 |
| 채팅방 생성 | POST | /api/v1 | /chats | Header: X-Member-UUID<br>body: productId, sellerId 등 (미정) | (미정) | 상품글 채팅하기, 1:1, 정지 유저 불가 |
| 메시지 목록 조회 | GET | /api/v1 | /chats/{chatRoomId}/messages | Header: X-Member-UUID | (미정) | chatRoomId = 채팅방 UUID |
| 메시지 전송 | POST | /api/v1 | /chats/{chatRoomId}/messages | Header: X-Member-UUID<br>body: content, media 등 (미정) | (미정) | 레이트리밋·경고·시스템 메시지는 이후 구현 |
| 채팅방 나가기 | DELETE 또는 POST | /api/v1 | /chats/{chatRoomId}/leave | Header: X-Member-UUID | (미정) | soft delete. 메서드는 API 확정 시 결정 |
| 메시지 번역 | POST | /api/v1 | /chats/messages/{messageId}/translate | Header: X-Member-UUID<br>body: targetLanguage 등 (미정) | (미정) | 번역 제공자 미확정 |

## 진행 상태

| 단계 | 상태 |
|---|---|
| 환경 설정 | 완료 |
| 기능·API 문서 반영 | 진행 |
| API 골격 / stub | 미구현 |
| MongoDB Document·CRUD | DB 확정 후 |
| 실시간(WebSocket)·번역·미디어 | 이후 단계 |

## stub 동작 (API 골격 PR 예정)

- 목록 조회: 빈 배열
- 생성/전송/나가기/번역: `FEATURE_NOT_READY` 등 DB 연동 전 응답
