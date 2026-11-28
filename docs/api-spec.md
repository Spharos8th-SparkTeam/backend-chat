# backend-chat API 정의서 (채팅 서비스)

> 현재는 환경 설정 단계다. MongoDB Document·Repository 연동 전 API 골격은 이후 PR에서 추가한다.
> 회원 식별은 Gateway 연동 전 `X-Member-UUID` 헤더로 받는다.
> JWT 검증은 Gateway 책임이며 본 서비스에 Security/JWT를 두지 않는다.

| 요구사항 이름 | HTTP 메소드 | Version | URI | 비고 |
|---|---|---|---|---|
| 채팅방 목록 조회 | GET | /api/v1 | /chats | Header: X-Member-UUID |
| 채팅방 생성 | POST | /api/v1 | /chats | Header: X-Member-UUID |
| 메시지 목록 조회 | GET | /api/v1 | /chats/{chatRoomId}/messages | chatRoomId = 채팅방 UUID |
| 메시지 전송 | POST | /api/v1 | /chats/{chatRoomId}/messages | Header: X-Member-UUID |

## 진행 상태

- 환경 설정: 완료 예정
- API 골격 / stub: 미구현 (다음 단계)
- MongoDB Document·CRUD: DB 확정 후 구현
