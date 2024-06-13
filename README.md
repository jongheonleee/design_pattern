# ⚙️ 디자인패턴 

## 📌 00. 디자인패턴을 학습하기 앞서 

### 1. UML에서 중요한 포인트 

> ### 👉 화살표 방향
- A -> B 
  - A가 B를 알고있다. 이는 B가 변경되면 A에도 영향이 미침
  - 의존하고 있다고도 표현함 

> ### 👉 클래스의 관계
- A -Uses-> B : A가 B를 사용한다
- A -Creates-> B : A가 B를 생성한다
- A -Notifies-> B : A가 B를 통지한다

> ### 👉 시퀀스 다이어그램은 "시간에 따라 변동하는 것(동적인 관계)"


### 2. 디자인패턴이란?

> ### 👉 OOP 설계를 추상화한 패턴 
- OOP를 설계하다 보면, 자주 사용되는 패턴이 있음. 이를 정리해서 패턴처럼 이용하는 것 

> ### 👉 설계도를 보는 태도
- 누가 누구를 알고 있는지
- 클래스, 인터페이마다의 역할이 무엇인지
- 무엇을 위해 분리되어 있고 그룹핑되어 있는지
- OOP의 핵심인 "변경에 유리한 설계"를 어떻게 충족시키는지

<br>
<br>

##  📌 01. 인스턴스를 효율적으로 관리 및 생성  

### 1. Singleton : 자원 절약, 인스턴스 1개 공유

<img src="https://github.com/jongheonleee/design_pattern_java/assets/87258372/d2563b0e-b38e-464b-9427-6d6f0b29496a" width="500" height="500"/>


> ### 👉 인스턴스 하나만 생성하고 공유한다
  
- 자원을 절약하려는 의도, 무분별하게 new 연산자 하는 것을 막음 
- 인스턴스가 하나만 생성되는 것을 보증 해야한다 
- 공유하기 때문에 멀티쓰레드 환경에서 인스턴스 변수(iv) 값이 임의로 변경되는 것을 막아야한다
- iv가 없는게 좋음, 있어야하면 동기화 처리가 된 것을 사용하거나 상수를 사용해야함, 또한 iv에 계산된 값을 저장하기 보다는 메서드로 반환하는 게 좋음

> ### 👉 스프링에서 컨테이너에 빈 등록할 때, 기본적으로 Singleton으로 등록

- 빈으로 등록할 객체는 정보 공유가 가능한지, 멀티 쓰레드 환경에서 iv 오염이 발생하지 않는지 고려

### 2. Flyweight : 자원 절약, n개의 인스턴스를 한번만 생성하고 등록하여 공유

<img src="https://github.com/jongheonleee/design_pattern_java/assets/87258372/3dd289aa-297c-48d0-a635-67251501da59" width="500" height="500"/>

> ### 👉 n개의 인스턴스를 한번만 생성하고 맵에 등록하여 공유한다  

- Singleton 의 확장 버전, Singleton은 인스턴스 1개 생성을 절약하려는 의도. Flyweight는 인스턴스 n개 생성을 절약하려는 의도
- FlyweightFactory에 Singleton 적용, Map으로 생성한 인스턴스를 등록하고 관리
  - Map은 대용량 데이터 저장할 때 유용함. 내부적으로 해시 함수를 통해 데이터 조회함(충돌 발생을 낮추려는 의도)
  - 따라서, 소용량의 경우 Flyweight패턴과는 어울리지 않음. 예를들어 enum의 경우 여러개의 상수로 묶어도 맵으로 등록하지 않음 
  
- 공유하기 때문에 멀티 쓰레드 환경에 주의해야함. 즉 Flyweight를 적용할 인스턴스가 무거운지, 공유 가능한 인스턴스인지 따져 봐야함
- getFlyweight()메서드가 동기화 처리되야함. 예를 들어, 서로 다른 쓰레드가 동시에 같은 인스턴스를 사용하길 원하고 해당 인스턴스가 없는 경우 여러번 생성될 수 있음 

> ### 👉 스프링에서 컨테이너 구조와 매우 유사

- 스프링은 제어의 역전, 즉 사용과 생성을 분리함. 따라서, 스프링 컨테이너에서 빈을 생성 및 등록 그리고 관리해줌(생성). 개발자는 해당 빈을 사용하기만 하면됨
- 물론, 빈은 크게 두 부류로 등록됨, Singleton과 Prototype으로 등록됨
- Flyweight는 Singleton 사용함 

### 3. Prototype : 원형 등록, 필요시 복제품 사용 

<img src="https://github.com/jongheonleee/design_pattern_java/assets/87258372/a498a8d1-ee5a-4082-9c08-a72648692c87" width="500" height="500"/>

> ### 👉 생성이 어렵거나 복잡한 인스턴스를 생성하고 맵에 등록하여 추후에는 복제해서 사용 

- 사용 시기
    - (1) 종류가 많아 클래스로 정리하기 어려움 : 다형성 적용된 배열, 타입이 매우 많음(배열 생성하는 과정이 다른 인스턴스와 다른 이유임)
    - (2) 인스턴스 생성이 복잡함 : 한번만 생성하고 맵에 등록함, 추후에는 등록된 인스턴스를 복제해서 사용
    - (3) 프레임워크와 인스턴스를 분리 : 프레임워크를 특정 클래스에 의존하지 않게하려는 의도

- 얕은 복사(값 그대로 복사), 깊은 복사(참조하는 인스턴스도 복사)인지 고려
- Flyweight 는 참조값을 줌, Prototype 은 복사한 인스턴스를 줌(새로운 인스턴스)
- 선언부와 구현부가 분리되어 있음, 선언부는 설계도로 변경 주기가 낮음, 하지만 구현부는 변경 주기가 높음

> ### 👉 스프링에서 컨테이너 구조와 매우 유사

- 스프링은 제어의 역전, 즉 사용과 생성을 분리함. 따라서, 스프링 컨테이너에서 빈을 생성 및 등록 그리고 관리해줌(생성). 개발자는 해당 빈을 사용하기만 하면됨
- 물론, 빈은 크게 두 부류로 등록됨, Singleton과 Prototype으로 등록됨

<br>
<br>

##  📌 02. 변경되는 부분을 분리

### 1. Iterator : 반복해서 처리를 분리함(사용과 구현), 구체적인 반복 처리 과정을 분리(조건식, 반복 처리)

<img src="https://github.com/jongheonleee/design_pattern/assets/87258372/9459b35d-8b18-48f6-afd3-b4f508a4bf4c" width="500" height="500"/>

> ### 👉 for 문에서 조건식 부분을 외부로 분리함
- 조건식에서 특히 에러가 많이 발생, 조건식은 변경 주기가 잦음, 그 외에는 불변
- iterator를 사용하는 인스턴스는 단순히 반복 처리해서 사용만함. 즉, 반복 처리 과정 및 해당 집합의 내부 사정을 몰라도됨
- 대표적으로 자바에는 Collection의 하위 클래스인 List, array, set이 있음
  - set의 경우 순서가 없음, 하지만 treeSet을 탐색하는 순서가 있기 때문에 그 방법에 따라 반복 처리가 달라짐
    - (1) 전위
    - (2) 중위
    - (3) 후위
    - (4) 레벨(bfs)  


### 2. Template Method Pattern : 세부 내용(변경이 자주 일어나는) 부분을 분리, 상속을 통해 코드 완성, 상위의 전체 틀을 구성하고 하위에서 세부 내용을 결정함 


<img src="https://github.com/jongheonleee/design_pattern/assets/87258372/de37b59b-91d9-4b0d-a89b-30a3fb1c16c3" width="500" height="500"/>


> ### 👉 변경되는 것과 변경되지 않는 것의 분리, 즉, 불변과 가변의 분리
- 기존에 서로 관련도 높은 것들 끼리 묶음. 하지만, 그 내부에서 변경 시점이 서로 다른 경우 분리함
- 변경되는 것과 변경되지 않는 것의 분리
- 상위 클래스에서 뼈대를 구성하고 하위 클래스에서 구체적인 내용 결정



> ### 👉 전략 패턴과 같음. 하지만, 코드를 완성하는 방식에는 차이가 있음 
- 코드를 상속을 통해 완성시킴(추상 클래스를 상속 받아서 완성시켜서 사용)
- 전략 패턴의 경우 알고리즘을 주입 받아서 코드 완성
  - 생성자 주입
  - 매개변수 전달

> ### 👉 자바에서의 적용 사례 : Object, Enum, [ ] (배열), Thread(상속 구현)



> ### 👉 브릿지 패턴과의 차이, 추상 메서드 개수
- 템플릿 메서드 패턴의 경우 하나의 추상 메서드에 대한 내용
- 브릿지 패턴은 n개의 추상 메서드에 대한 내용
  - n개의 추상 메서드를 인터페이스로 추출해서 선언(기능)과 구현을 분리한 형태 


### 3. Strategy : 알고리즘을 분리해서 주입 받아서 사용(특정 문제를 다양한 방식으로 처리가능)

<img src="https://github.com/jongheonleee/design_pattern/assets/87258372/0f20b692-fcff-4e2f-88e0-40092bd68a80" width="500" height="500"/>


> ### 👉 변경되는 것과 변경되지 않는 것의 분리, 즉, 불변과 가변의 분리
- 기존에 서로 관련도 높은 것들 끼리 묶음. 하지만, 그 내부에서 변경 시점이 서로 다른 경우 분리함
- 변경되는 것과 변경되지 않는 것의 분리
- 변경이 자주 일어나는 알고리즘을 외부로 부터 주입받아서 구체적인 알고리즘 내용 완성 시킴 


> ### 👉 템플릿 패턴과의 차이점
- 코드를 완성하는 방식이 다름
- 전략 패턴은 코드를 주입받아서 완성시킴
  - 생성자를 통해 주입 
  - 매개변수로 전달 

> ### 👉 자바에서의 적용 사례 : sort("비교 대상", "비교 기준"), Comparator 전달, Thread 생성시 Runnable 매개변수로 전달 

> ### 👉 브릿지 패턴과의 차이, 추상 메서드 개수
- 전략 패턴의 경우 하나의 추상 메서드에 대한 내용
- 브릿지 패턴은 n개의 추상 메서드에 대한 내용
  - n개의 추상 메서드를 인터페이스로 추출해서 선언(기능)과 구현을 분리한 형태 


### 4. Bridge : 기능(선언)과 구현을 분리

<img src="https://github.com/jongheonleee/design_pattern/assets/87258372/cdb6e844-e33c-4054-838f-2e52836ed288" width="500" height="500"/>


> ### 👉 변경되는 것과 변경되지 않는 것의 분리, 즉, 불변과 가변의 분리
- 위의 Template Method, Strategy는 1개의 추상 메서드를 다뤘다면, Bridge는 n개의 추상 메서드를 다룸
  - 인터페이스 선언, 클래스 단위로 주입 받음 
  - 결론적으로는 기능과 구현을 분리 
  - 즉, Template Method, Strategy는 메서드나 특정 알고리즘 단위로 분리했다면 Bridge는 클래스 단위로 분리
    - 그 결과 기능의 클래스 계층과 구현의 클래스 계층으로 나뉨

- 더욱 면밀히 얘기하면, 기능의 클래스 계층과 구현의 클래스 계층을 분리함(두 개의 독립된 클래스 계층으로 나눔)
  - 새로운 기능을 추가할 때는 각 계층에 맞는 곳에 상속으로 추가하면됨 
  - 상위에서는 기본 기능 구상, 하위에서는 새로운 기능 추가 
