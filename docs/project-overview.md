# Respark 아키텍처 개요

> 글로벌 완구 중고거래 플랫폼 · MSA 구조

## backend-chat 책임

- 채팅방 생성 (상품글 채팅하기, 1:1)
- 채팅방 목록 조회 (메시지 있는 방만)
- 메시지 조회·전송 (텍스트·미디어, 레이트리밋, 시스템 메시지)
- 메시지 번역 연동
- 채팅방 나가기 (soft delete)
- 채팅 참여자 비즈니스 권한 검증

## 인증/인가 역할 분담

| 역할 | 담당 |
| :--- | :--- |
| 회원 인증 및 JWT 발급 | Member Service |
| JWT 검증 및 공통 접근 제어 | Gateway |
| 비즈니스 예외 처리와 세부 권한 검증 | 각 서비스 |

## 기술 스택

| 영역 | 기술 |
| :--- | :--- |
| 언어 / 프레임워크 | Java 17, Spring Boot 4.0.10 |
| 빌드 | Gradle |
| 데이터베이스 | MongoDB, Spring Data MongoDB |
| API 문서 | springdoc-openapi (Swagger UI) |
| CI/CD | GitHub Actions, Docker |
