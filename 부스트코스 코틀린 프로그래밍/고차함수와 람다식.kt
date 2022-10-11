### 람다식

함수형 프로그래밍에서 람다식은,

**함수 로직을 변수**로서 할당, 전달 가능하게 하는 **함수이자 변수**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/17283257-9d8e-4413-8a69-09a3e7bdcf6d/Untitled.png)

```kotlin
fun main() {
    val result: Int

    //일반변수에 람다식 할당하기
    //val multi = { a: Int, b: Int -> a + b }
    val multi: (a: Int, b: Int) -> Int = { a, b ->

        a * b //여기 마지막 부분만 반환
    }

    result = multi(10, 20)
    println(result)
}
```

- 람다식의 다양한 표현법

```kotlin
val multi: (Int, Int) -> Int = { x: Int, y: Int -> x * y } //생략되지 않은 전체 표현
val multi = { x: Int, y: Int -> x * y } // 선언 자료형 생략
val multi: (Int, Int) -> Int{ x, y -> x * y } // 랍다식 매개변수 자료형의 생략
```

- 람다식 안에 람다식? 가능!

```kotlin
val nestedLambda: ()->()->Unit = {{println("nested")}}
```


---

### 고차함수

- 매개변수에 람다식 함수를 이용한 고차 함수

```kotlin
fun main() {
    var result: Int

    //람다식을 매개변수와 인자로 사용한 함수
    result = highOrder({ x, y -> x + y }, 10, 20)
    println(result)
}

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}
```

- 람다식과 고차함수 호출하기
1. **값에 의한 호출**

함수가 인자로 전달될 경우,
람다식 함수는 값으로 처리 → 그 즉시 함수가 수행된 후 값 전달.

```kotlin
fun main() {
    val result = callByValue(lambda()) // 람다식 함수를 호출
    println(result)
}

fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {  // 람다 표현식이 두 줄이다
    println("lambda function")
    true 		    // 마지막 표현식 문장의 결과가 반환
}
```

2. **이름에 의한 호출**

함수가 호출되어 사용될 때! 람다식 함수 내용 실행

```kotlin
fun main() {
    val result = callByName(otherLambda) // 람다식 이름으로 호출
    println(result)
}

fun callByName(b: () -> Boolean): Boolean { // 람다식 함수 자료형으로 선언된 매개변수
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}
```

3. **다른 함수의 참조에 의한 호출**

일반 함수를 또 다른 함수의 인자에서 호출하는 고차 함수의 경우,
두 개의 콜론(**::**)으로 함수 이름 앞에 사용해 소괄호와 인자를 생략하고 사용 → **일반함수를 참조에 의한 호출로 사용**

```kotlin
fun main() {
    // 1. 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::sum)
    println(res1)

    // 2. 인자가 없는 함수
    hello(::text) // 반환값이 없음

    // 3. 일반 변수에 값처럼 할당
    val likeLambda = ::sum
    println(likeLambda(6,6))
}

fun sum(a: Int, b: Int) = a + b

fun text(a: String, b: String) = "Hi! $a $b"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}
```


---

### 람다식 함수의 매개변수

1. 매개변수가 없는 경우

```kotlin
fun main() {
    // 매개변수 없는 람다식 함수
    noParam({ "Hello World!" })
    noParam { "Hello World!" } // 위와 동일 결과, 소괄호 생략 가능
}

// 매개변수가 없는 람다식 함수가 noParam 함수의 매개변수 out으로 지정됨
fun noParam(out: () -> String) = println(out())
```

2. 매개변수가 한 개인 경우

```kotlin
fun main() {
    // 매개변수 없는 람다식 함수
    ...
    // 매개변수가 하나 있는 람다식 함수
    oneParam({ a -> "Hello World! $a" })
    oneParam { a -> "Hello World! $a" } // 위와 동일 결과, 소괄호 생략 가능
    oneParam { "Hello World! $it" }  // 위와 동일 결과, it으로 대체 가능
    //it -> 앞에서 가져본 변수하나
}
...
// 매개변수가 하나 있는 람다식 함수가 oneParam함수의 매개변수 out으로 지정됨
fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}
```

3. 매개변수가 두 개 이상인 경우

```kotlin
fun main() {
    ...
    // 매개변수가 두 개 있는 람다식 함수
    moreParam { a, b -> "Hello World! $a $b"} // 매개변수명 생략 불가
    ...
}
// 매개변수가 두 개 있는 람다식 함수가 moreParam 함수의 매개변수로 지정됨
fun moreParam(out: (String, String) -> String) {
    println(out("OneParam", "TwoParam"))
}
```

4. 매개변수를 생략하는 경우

```kotlin
moreParam { _, b -> "Hello World! $b"} //첫 번째 문자열은 사용하지 않고 생략
```

5. 일반 매개변수와 람다식 매개변수

```kotlin
fun main() {
    ...
    // 인자와 함께 사용하는 경우
    withArgs("Arg1", "Arg2", { a, b -> "Hello World! $a $b" })
    //withArgs()의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리 가능
    withArgs("Arg1", "Arg2") { a, b -> "Hello World! $a $b" }
    ...
}

// withArgs함수는 일반 매개변수 2개(a,b)를 포함, 람다식 함수(out)를 마지막 매개변수로 가짐
fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}
```

6. 두 개의 람다식 매개변수를 가진 함수

```kotlin
fun main() {
    twoLambda({ a, b -> "First $a $b" }, { "Second $it" })
    twoLambda({ a, b -> "First $a $b" }) { "Second $it" } // 위와 동일
}

fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
    println(first("OneParam", "TwoParam"))
    println(second("OneParam"))
}
```