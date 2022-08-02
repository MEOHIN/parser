# parser
`parser` 프로젝트는 전문을 생성하고 파싱(Parsing)하는 프로그램을 만든다.

## 전문 송수신
### 전문의 규칙
- 요청 전문으로 "이름", "전화번호"를 보내면 응답 전문으로 "생일", "주소"를 리턴한다.
- "이름"은 20자리다.
- "전화번호"는 11자리다.
- "생일"은 8자리다.
- "주소"는 50자리다.

요청은 `이름(20) + 전화번호(11)` 응답은 `생일(8) + 주소(50)` 이다.

요청 전문 예시

```
홍길동 01099998888
```
응답 전문 예시
```
19801215서울시 송파구 잠실동 123-3   
```
