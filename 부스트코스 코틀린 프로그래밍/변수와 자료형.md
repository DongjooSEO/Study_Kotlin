### 2-1 기본 자료형과 변수 선언방법

*코틀린의 모든 변수는 객체*

**(1) 불변형, 기본형**

**자료형**

- `int` ; 정수형 1, 2, 3
- `String` ; 문자열
- `Float` ; 실수

**변수**

- `val` (value) - 불변형
- `var` (variable) - 가변형

`**val(선언 키워드)** username(변수 이름) : String(자료형) = “Doran”(값)`

**변수 선언 ex**

```kotlin
val username = "tama" //자료형을 추론하여 String으로 결정
var username : //자료형을 지정하지 않은 변수는 사용할 수 없다.
val init: Int //사용 전 혹은 생성자 시점에서 init변수를 초기화 해야함.
val number = 10 //number 변수는 Int형으로 추론
```

일반 변수, 함수명 → 카멜 표기법 camelCase

클래스, 인터페이스 → 쌍봉 낙타 AnimalCategoty

**기초 타입 객체**

- 정수표현

`Int`

`Short`

`Long`

- 실수표현

`Double`

`Float`

- 2진수

`Byte`

- T/F

`Boolean`


**문자와 문자열**

`Char`은 문자, `String`은 문자열

문자열 출력하기

```kotlin
val name: String = "tama"
println("name : $name")
```

### 2-2 나를 괴롭히는 널(Null)!

null을 활용한 변수 검사

코틀린의 변수 선언은 기본적으로 null을 허용하지 않는다.

`Int` vs `Int?` → **?**가 붙으면 **Null허용**

null 허용하는 경우 NPE 조심!

- non-null 단정 기호

> `!!`뒤에 이거 붙이면 “null일 리 없다!!”
>

### 2-3 검사와 자료형을 변환해보기

코틀린은 기본형을 사용하지 않고 참조형만 사용
→ 서로 다른 자료형은 변환 과정을 거친 후 비교하기

```kotlin
val a : Int = 1
val b : Double = a //자료형 불일치 오류
val c : Int = 1.1 //자료형 불일치

//변환 메서드 이용
val b : Double = a.toDouble()

//표현식에서 자료형의 **자동**변환
val result = 1L + 3 //Long + Int -> result : Long
```

- 변환 메서드 to(바꾸고싶은자료형)

**이중 등호(==) vs 삼중 등호(===)**

이중 등호(==)  : 값만 비교하는 경우

삼중 등호(===)  : 값과 참조 주로를 비교

```kotlin
val a : Int = 123
val b : Int? = 123

println(a == b) //true
println(a === b) //false
```

**`is` 키워드**

```kotlin
if(num is Int) ~
if(num !is Int) ~
```

`**Any :자료형이 정해지지 않는 경우**`

Any 는 코틀린에서 최상위 클래스
→ Any 타입으로 선언한 변수에는 모든 타입의 데이터 할당 가능

### 2-4 연산자를 조합해 다양한 식 만들기

(1) 기본연산자

(2) 비트연산자

[https://blog.skylightqp.kr/269](https://blog.skylightqp.kr/269)