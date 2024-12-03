# toby-spring

## 오브젝트와 의존관계

> 스프링에서 가장 중요한 2가지 

### 오브젝트 (Object)

객체라고도 하는 오브젝트, 객체지향 프로그래밍? 객체?  클래스와 오브젝트; 왜 클래스 오리엔티드가 아닐까?

- **오브젝트**: 프로그램을 실행하면 그 때 만들어져서 동작하는 대상을 말한다.
- **클래스**: 오브젝트를 만들기 위해서 청사진, 설계도를 의미한다. 

클래스를 기반으로 오브젝트를 만들어내는 것인데 클래스의 인스턴스를 오브젝트라고 한다.

> 자바에서의 오브젝트는 클래스의 인스턴스 혹은 배열(Array)을 말한다.

### 의존관계 (Dependency)

나하고 다른 누군가 사이의 관계를 의미한다. (A --> B; A가 B에 의존한다.)

_클래스 사이의 의존관계_

- A 클래스가 B 클래스를 의존한다란 말은 A 클래스의 기능이 제대로 동작하려면 B 클래스가 필요하다는 것을 의미한다.
- 이 때, B 클래스가 변경되면 A 클래스도 영향을 받는다.


## 관심사의 분리 (Separation of Concerns; SoC)

관심사가 잘 분리되어져 있는가? **관심사** 는 변경이라는 관점에서 바라볼 때, 변경이 되는 시점이 동일한지 아닌지를 의미한다.

- 외부 API를 통해 데이터를 가져오는 것이 동일한 관심사인가?



## 상속을 통한 확장

재사용 관점에서 Service 클래스를 분리해보자. 왜? 재사용가능하게 만들기 위해서.

- 만약 환율 정보를 가져오는걸 변경하고 싶다면?

이러한 상황에서 상속을 통해서 확장성있는 코드로 리팩토링이 가능해진다.
