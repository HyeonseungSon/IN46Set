/*
Set
 - 객체의 순서 관계 없으며 중복된 객체 없이 저장할 자료형으로 적합합니다.
 - 객체를 이름이나 순서 등으로 관리하는 주체가 없는 Collection 입니다.
 - 중복된 객체를 담을 수 없습니다.
 - 순서에 관계 없고 중복된 객체를 담지 않을 경우 사용합니다.
 - Set 은 순서, 이름과 같은 관리 주체가 없으며 중복된 객체를 담을 수 없는 Collection 입니다.

Set 생성
 - setOf () : 불변형 Set 생성
 - mutableSetOf () : 가변형 Set 생성

Set 호출
 - Set 은 관리 주체가 없으므로 객체를 직접 접근하는 Method 는 제공될 수 없습니다.
 - for 문을 통해 객체를 순회하여 접근해야 합니다.

Set Method
 - size () : 관리하는 요소의 개수

가변형 Set Method
 - add () : 관리하는 객체를 추가합니다. 같은 객체일 경우 추가되지 않습니다. (Set 은 요솟값의 중복을 허용하지 않습니다.)
 - remove() : 관리하는 객체를 제거합니다.
 - toSet () : 불변형 Set 으로 변경합니다.
 - toMutableSet () : 가변형 Set 으로 변경합니다.

Set => List (변경)
 - toList () : 불변형 List 로 변경합니다.
 - toMutable () : 가변형 List 로 변경합니다.

List => Set (변경)
 - toSet () : 불변형 Set 으로 변경합니다.
 - toMutableSet () : 가변형 Set 으로 변환합니다.
 * Set 의 특성에 따라 중복된 객체는 제거됩니다. *
 * List 의 Index 순서를 보장받을 수 없습니다. *
 */

fun main() {

    val set0 = setOf<Int>(1, 2, 3, 1, 2, 3)

    val set1 = setOf(1, 5, 10, 10, 1, 5, 10)
    println("set1 : $set1")

    val set2 = mutableSetOf <Int> ()
    println("set2 : $set2")

    println("----- Set 호출 -----")

    // println("set1.get(0) : ${set1.get(0)}")
    // println("set1[1] : ${set1[1]}")

    var cnt = 1

    for (item in set1) {
        println("set1 [$cnt] : $item")
        cnt++
    }

    println("----- Set Method -----")

    println("set1.size() : ${set1.size}")
    println("set2 : $set2")
    set2.add (10)
    set2.add (15)
    set2.add (20)
    set2.addAll(listOf(100, 200, 300))
    println("set2 : $set2")

    println("set2.add (15) : ${set2.add (15)}") // => false
    println("set2.add (15) : ${set2.add (1000)}") // => true

    set2.addAll(listOf(15, 20, 25, 30)) // => set2 : [10, 15, 20, 100, 200, 300, 1000, 25, 30]
    println("set2 : $set2")

    set2.remove(100)
    println("set2 : $set2")
    set2.removeAll(listOf(200, 300, 1000))
    println("set2 : $set2")

    println("----- Set -> List (변경) -----")

    val set3 = set1.toMutableSet()
    set3.add(1000)
    println("set3 : $set3")
    val set4 = set3.toSet()
    // println(set4.add(2000)) // 오류 발생 : set4 는 불변형

    val list100 = listOf(10, 20, 30, 10, 20, 30) // List 생성
    println("list100 : $list100")

    val set5 = list100.toSet() // List 를 불변형 Set 으로 변경
    // set5.add(40)
    println("set5 : $set5")

    val set6 = list100.toMutableSet() // List 를 가변형 Set 으로 변경
    println("set6 : $set6")
    set6.add(40)
    println("set6 : $set6")

    val list200 = set6.toList() // set 을 불변형 List 로 변경
    //list200.add(50)
    println("list200 : $list200")
    println("list200[0] : ${list200[0]}")
    println("list200[1] : ${list200[1]}")
    println("list200[2] : ${list200[2]}")
    println("list200[3] : ${list200[3]}")

    val list300 = set6.toMutableList() // set 을 가변형 List 로 변경
    list300.add(50)
    println("list300 : $list300")
    println("list300[0] : ${list300[0]}")
    println("list300[1] : ${list300[1]}")
    println("list300[2] : ${list300[2]}")
    println("list300[3] : ${list300[3]}")
    println("list300[4] : ${list300[4]}")
}




