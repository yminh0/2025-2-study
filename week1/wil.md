# <백엔드 스터디 1주차 WIL>
## HTTP 요청
start line: 요청 메서드, 요청할 경로

headers: 요청에 대한 부가 정보

body: 실제 전송할 데이터

## 주요 메서드
get: 리소스를 조회

post: 리소스를 추가, 등록

put: 리소스를 교체, 없으면 새로 생성

patch: 리소스의 일부를 수정

delete: 리소스를 삭제

## HTTP 응답
status line: HTTP 버전, 상태 코드. 상태 메시지

headers: 응답에 대한 부가 정보

body: 실제 응답 데이터

## HTTP 주요 상태 코드
200 OK: 요청이 성공적으로 처리됨

201 Created: 요청이 성공적으로 처리되어 새로운 리소스가 생성됨

400 Bad Request: 클라이언트의 요청이 잘못되어 서버가 이해하지 못함

404 Not Found: 지정한 리소스를 찾을 수 없음

500 Internal Server Error: 서버 내부 오류로 요청을 처리할 수 없음

## API(Application Programming Interface)
한 프로그램이 다른 프로그램의 기능이나 데이터를 사용할 수 있도록 미리 정해놓은 약속이자 소통 창구

## REST(Representational State Transfer)
네트워크 아키텍처 스타일로, HTTP의 장점을 최대한 활용할 수 있는 아키텍처

#### 구성요소
자원(Resource) - URI

행위(Verb) - Method

표현(Representation)

REST API는 자원을 고유한 URI로 식별하고 해당 자원에 대한 행위를 HTTP 메서드로 정의하며, 그 결과를 JSON 같은 표준 형식으로 표현하는 웹 서비스 아키텍처 스타일

## Whitelabel Error Page 스크린샷
<img width="1394" height="534" alt="Image" src="https://github.com/user-attachments/assets/2a655c8e-3968-4cc8-9002-ae0fd5750716" />

## 온라인 쇼핑몰 프로젝트 API 명세서

### 상품 기능

#### 1. 상품 정보 등록
HTTP Method: POST

URI: /items

#### 2. 상품 목록 조회

HTTP Method: GET

URI: /items

#### 3. 개별 상품 정보 상세 조회

HTTP Method: GET

URI: /items/{itemId}

#### 4. 상품 정보 수정

HTTP Method: PATCH

URI: /items/{itemId}

#### 5. 상품 삭제

HTTP Method: DELETE

URI: /items/{itemId}


### 주문 기능

#### 1. 주문 정보 생성

HTTP Method: POST

URI: /orders

#### 2. 주문 목록 조회

HTTP Method: GET

URI: /orders

#### 3. 개별 주문 정보 상세 조회

HTTP Method: GET

URI: /orders/{orderId}

#### 4. 주문 취소

HTTP Method: DELETE

URI: /orders/{orderId}




















