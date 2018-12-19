# TDD-pattern-sample
TDD를 하면서 마주치는 다양한 패턴들을 알아보자


## 1. DTO 스타일의 객체?
클래스가 단순히 필드들과 getter/setter만으로 이루어진 DTO(Data Transfer Object)인 경우 테스트를 작성하지 않는다.

## 2. 닭과 달걀 메서드 테스트
로직 메서드(add,remove,set) 와 상태확인 메서드(get,show)가 함께 나올 때 테스트케이스를 만들기가 어렵다.

```java
    @Test
    public void testAdd() throws Exception {
        Attendee attendee = new Attendee();
        attendee.add("Park");
        assertEquals("Park", attendee.get(0));
    }


    @Test
    void testGet() throws Exception {
        Attendee attendee = new Attendee();
        attendee.add("Park");
        assertEquals("Park", attendee.get(0));
    }
```
이렇게 서로 상충하게 되며 실패하는 테스트가 2개가 만들어진다.

## 3. 객체의 동치성 테스트
3.1 객체에 toString()을 오버라이드 해 놓고 assertEquals로 각 인스턴스들의 toString()을 호출하며 비교한다.
3.2 위 방법보다 더 좋은 방법은 Equals and hashcode를 구현하는 것이다.

## 4. 컬렉션 비교

4.1 primitive type이 들어 있는 경우
```java
@Test
    public void testListEqual_원시형() {
        List<String> listA = new ArrayList<>();
        listA.add("park");
        listA.add("lee");

        List<String> listB = new ArrayList<>();
        listB.add("park");
        listB.add("lee");

        assertEquals("리스트비교",listA, listB);
    }
```

그냥 비교하며 된다. 컬렉션에서는 안에 들어있는 객체들을 하나씩 꺼내서 equals를 한다.

4.2 객체가 컬렉션에 들어있는 경우

```java
@Test
public void testListEqual_객체() {
    List<Employee> list1 = new ArrayList<>();
    list1.add(new Employee("park"));
    list1.add(new Employee("lee"));

    List<Employee> list2 = new ArrayList<>();
    list2.add(new Employee("park"));
    list2.add(new Employee("lee"));

    assertEquals("리스트비교", list1.toString(), list2.toString());
}
```
객체를 그냥 assertEquals로 비교하면 다 고유한 값이기 때문에 비교하면 항상 다르다고 나온다. 그래서 Employee라는 클래스에 toString()을 override해놓고 비교를 하면 원하는 결과를 얻을 수 있다.


