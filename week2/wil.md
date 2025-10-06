# <백엔드 스터디 2주차 WIL>
## 스프링 계층형 아키텍쳐
<img width="1470" height="538" alt="Image" src="https://github.com/user-attachments/assets/dc7de648-dce5-4b4b-bcad-a7bd611c7fe6" />

스프링 계층형 아키텍처(Layered Architecture): 레스토랑

Browser: 손님

Controller: 웨이터 / 고기 굽는법 모름 (비즈니스 로직 X)

Service: 주방장 / 재료가 없음

DAO: 창고 관리인

DB: 냉장/냉동 창고

DTO: 주문서, 영수증 / 데이터 전송 객체, 필요한 정보만 전달

Entity: 원재료 / 모든 정보 포함, 외부 직접 노출 금지

## Controller

HTTP 요청/응답

특정 endpoint로 요청을 가장 먼저 처리

DTO를 사용하여 서비스 계층과 데이터 주고받음

## 패키지 구조: 계층형 vs 도메인형

### 계층형 구조: 애플리케이션을 기능별로 나눈다.

### 도메인형 구조: 도메인 관련 모든 클래스를 포함

특정 도메인의 코드를 한 곳에-> 코드 탐색 쉽다.

도메인 단위 개발,유지보수하기 용이

New 도메인 추가 시 다른 곳에 영향 없음






