인스타그램 클론 코딩

초기에 구현 하려던 기능은
1. Follow한 사람들의 Board를 볼 수 있는 index페이지
2. 새로운 포스팅을 할 수 있는 post페이지
3. 나의 프로필들을 볼 수 있고 수정할 수 있는 profile페이지
4. Follow, Following 기능 구현

백엔드 구성은 spring boot 템플릿엔진 thymeleaf를 사용해 프론트엔드를 구성하고 DB는 Mysql을 사용, 로그인 로그아웃 방식으로 세션방식이 아닌 JWT 토큰을 사용하려했다.

이렇게 첫번째로 설계를 해놓고 진행을 하며 추가할 부분들을 추가하고 바꿀 부분을 바꾸자고 생각했다.

우선 바뀐부분은 DB를 Mysql이 아닌 MongoDB로 바꾸었는데 그 이유는 Follow기능을 구현하면서 Follow한 여러 사람들의 아이디를 저장해야했는데 Mysql에선 배열형 데이터타입을 지원하지않았기때문에 배열형 데이터타입을 지원하는 MongoDB로 바꾸었다.
또한, JWT토큰을 사용한 로그인 로그아웃을 구현하던 중 토큰을 클라이언트쪽의 localstorage에 저장하는 것이 아닌 서버 세션에 저장해놓고 사용하는 방식으로 바꿨다. 클라이언트에 저장해놓고 사용할때 서버로 토큰을 알려줄수있는 방법이 Ajax같은 방식뿐이라 제대로 동작하지않는다고 생각했기때문이다.

그 이외에는 크게 변경된 것이 없고, 기능중 DM기능을 추가해보려고 생각중이다. STOMP를 이용 할 생각이다.

새로 배우는 것들이 너무 많아서 코드도 난잡하고 가독성도 떨어지지만 아직까지 발전가능성이 있다는거라 되게 기쁘기도 하다. 좀 더 열심히 해야겠다.
