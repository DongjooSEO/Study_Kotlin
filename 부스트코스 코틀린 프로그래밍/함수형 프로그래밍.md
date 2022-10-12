### 함수 선언과 호출

<aside>
🍀 **fun 함수명(매개변수명: 타입) : 반환타입 {…}**

</aside>

```kotlin
**fun 함수명(매개변수명(변수명): 타입(자료형)) : 반환타입 {
    [return 반환값]
}**
```

*** 반환 타입이 있는 함수 선언**

```kotlin
fun sample(data 1: Int): Int {
    return data 1 * 10
}
```

***기본값 활용**

```kotlin
fun main(){
    fun some(data1: Int, data2: Int = 10):Int[
    return data1 * data2
}
println(some(10)) //100
println(some(10,20)) //200
}
```

***매개변수명 생략 - 매개변수 순서대로 할당**

```kotlin
fun some(data1: Int, data2: Int):Int[
return data1 * data2
}
println(some(10,20)) //200

```

***매개변수명을 지정하여 호출**

```kotlin
some(data2 = 20, data1 = 10)
```

### 함수 활용 예제

```kotlin
fun avgFunc(initial: Float, vararg numbers: Float): Double {
    var result = 0f //초기값에 아무런 인자를 입력하지 않으면 0을 기본 사용
    for (num in numbers) { //초기값은 두번째 부터 나열된 인자의 최종 평균 결과에 더함
        result += num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    val avg = (result+initial) / (numbers.size+1) <<이 부분 논의필요
            return avg.toDouble
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}
```

### 함수형 프로그래밍

- **함수형 프로그래밍(FP)**
- **순수 함수 (Pure Function)**

**조건**

1. 같은 인자에 대하여 항상 같은 값을 반환 = ‘부작용이 없는 함수’
2. 함수 외부의 어떤 상태도 바꾸지 않음.

```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b // 동일한 인자인 a, b를 입력 받아 항상 a + b를 출력(부작용이 없음)
}
```

- **람다식 (Lambda Expression) 과 일급 객체 (First-class)**

**람다식** : `**{x,y -> x+y}**`

일급 객체 특징

1. 함수의 인자로 전달 가능
2. 함수의 반환값에 사용 가능
3. 변수에 담을 수 있음.

> 함수가 일급 객체이면 ‘일급함수’
일급함수에 이름이 없는 경우 → ‘람다함수’, ‘람다식’
>
- **고차 함수 (Higher-Order Function)**

*다른 함수를 인자로 사용하거나 함수를 결괏값으로 반환하는 함수*

```kotlin
fun main() {
    println(highFunc( { x, y -> x + y}, 10, 20)
}

fun highFunc(sum : (Int, Int) -> Int, a : Int, b : Int) : Int = sum(a, b)
```