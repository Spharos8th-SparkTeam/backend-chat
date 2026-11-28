# backend-chat

ReSpark(글로벌 완구 중고거래 플랫폼)의 **채팅 서비스**입니다.

## 프로젝트 소개 및 목적

- 거래 당사자 간 채팅방·메시지 기능을 제공한다.
- 다른 서비스와는 각 서비스가 제공하는 API로만 통신한다.

## 주요 기능

- 채팅방 생성 (상품글 채팅하기, 1:1, 정지 유저 제한)
- 채팅방 목록 조회 (메시지 없는 방 미노출)
- 메시지 조회·전송 (미디어 첨부, 레이트리밋, 거래 시스템 메시지)
- 메시지 번역
- 채팅방 나가기 (soft delete)

> 현재는 API 골격(stub) 단계이며, Document·CRUD는 DB 확정 후 구현한다.
> 상세 요구사항은 `docs/feature-spec.md`를 따른다.

## 기술 스택

| 영역 | 기술 |
| :--- | :--- |
| 언어 / 프레임워크 | Java 17, Spring Boot 4.0.10 |
| 빌드 | Gradle |
| 데이터베이스 | MongoDB, Spring Data MongoDB |
| 보안 | Gateway JWT 검증 · 서비스는 비즈니스 권한 검증 |
| API 문서 | springdoc-openapi (Swagger UI) |
| 기타 | Lombok |
| CI/CD | GitHub Actions, Docker |

## 인증/인가 역할 분담

| 역할 | 담당 |
| :--- | :--- |
| 회원 인증 및 JWT 발급 | Member Service |
| JWT 검증 및 공통 접근 제어 | Gateway |
| 비즈니스 예외 처리와 세부 권한 검증 | 각 서비스 |

## 디렉터리 구조

```
backend-chat
├── .github/workflows/
├── docs/
└── src/main/java/com/spark/backend_chat/
    ├── BackendChatApplication.java
    ├── common/
    │   ├── config/SwaggerConfig.java
    │   └── error/
    ├── room/          # 채팅방 API 골격
    └── message/       # 메시지 API 골격
```


## 실행 방법

### 사전 준비

- JDK 17
- MongoDB (로컬 `localhost:27017`, 데이터베이스 `chat`)
- `.env.example`을 참고해 로컬 `.env`를 구성한다

### 환경변수

| 변수 | 설명 |
| :--- | :--- |
| `MONGODB_URI` | MongoDB 연결 URI |
| `SPRING_PROFILES_ACTIVE` | Spring Profile |
| `SERVER_PORT` | 서버 포트 (기본 8085) |

### 실행

```bash
# Windows
gradlew.bat bootRun

# macOS / Linux
./gradlew bootRun
```

- 서버 포트: `8085`
- Swagger UI: `http://localhost:8085/swagger-ui/index.html`

## 협업 및 Git 브랜치 전략

- 브랜치는 `main` / `develop` / `feature`만 사용한다.
- Issue 생성 후 `feature`에서 작업하고 `develop`으로 PR한다.
