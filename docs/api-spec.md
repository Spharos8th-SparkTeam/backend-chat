# backend-chat API 정의서 (채팅 서비스)

> 회원 식별은 Gateway 연동 전 `X-Member-UUID` 헤더로 받는다.
> JWT 검증은 Gateway 책임이며 본 서비스에 Security/JWT를 두지 않는다.
> 공식 API 시트에는 채팅 구분의 req/res가 아직 없다. 아래 URI는 기능명세서(No.23~25)와 Gateway 경로(`/api/v1/chats/**`)에 맞춘 **잠정 정의**다.
> MongoDB Document·Repository 연동 전 API 골격은 stub이다. 스키마 확정 후 구현한다.

| 요구사항 이름 | HTTP 메소드 | Version | URI | req | res | 비고 |
|---|---|---|---|---|---|---|
| 채팅방 목록 조회 | GET | /api/v1 | /chats | Header: X-Member-UUID | ChatRoomSummaryResponse[] | 메시지 없는 방은 미노출 |
| 채팅방 생성 | POST | /api/v1 | /chats | Header: X-Member-UUID<br>body: productId, sellerId | ChatRoomCreateResponse | 상품글 채팅하기, 1:1 |
| 채팅방 나가기 | POST | /api/v1 | /chats/{chatRoomId}/leave | Header: X-Member-UUID | ChatRoomLeaveResponse | soft delete |
| 메시지 목록 조회 | GET | /api/v1 | /chats/{chatRoomId}/messages | Header: X-Member-UUID | MessageResponse[] | |
| 메시지 전송 | POST | /api/v1 | /chats/{chatRoomId}/messages | Header: X-Member-UUID<br>body: content, mediaKeys | MessageResponse | media 최대 10 |
| 메시지 번역 | POST | /api/v1 | /chats/messages/{messageId}/translate | Header: X-Member-UUID<br>body: targetLanguage | MessageTranslateResponse | 번역 제공자 미확정 |

## stub 동작

- 채팅방 목록 / 메시지 목록: 빈 배열
- 채팅방 생성 / 나가기 / 메시지 전송 / 번역: `FEATURE_NOT_READY(501, 5100)`

## 진행 상태

| 단계 | 상태 |
|---|---|
| 환경 설정 | 완료 |
| 기능·API 문서 반영 | 완료 |
| API 골격 / stub | 진행 |
| MongoDB Document·CRUD | DB 확정 후 |
| 실시간(WebSocket)·번역·미디어 | 이후 단계 |
