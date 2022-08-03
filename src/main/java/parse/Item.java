package parse;

import java.nio.charset.StandardCharsets;

/**
 * 데이터 성격의 클래스를 생성할 땐, 필요한 속성들을 private 으로 선언하고 getter, setter 를 만들어서 사용한다.
 *
 * 이 클래스는 전문을 생성하는 항목을 나타낸다.
 * 항목은 이름, 길이, 값이 필요하다.
 * 항목의 예시는 다음과 같다.
 * 이름: "이름", "전화번호"
 * 길이: 20자리, 11자리
 * 값: "홍길동", "01011112222"
 */
public class Item {
    private String name;
    private int length;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 이 method 는 항목의 값을 반환한다.
     * @return Item 클래스의 value 를 반환한다.
     */
   public String raw() {
       StringBuilder padded = new StringBuilder(this.value);
       /*
        * 자바는 한글 한 글자의 길이를 1도 계산한다.
        * 문자열.length() 로 길이를 세면 바이트의 실제 길이와 다르기 때문에 오류가 발생한다.
        * 문자열.toString().getByte().length 은 문자열을 바이트로 변환하여 길이를 체크한다.
        * "홍길동".length();    // 3
        * "홍길동".getByte().length;    // 9
        *
        * 따라서 전문 송수신할 때 길이는 바이트 단위로 변환한 후에 체크하는 것이 안전하다.
        */
       while (padded.toString().getBytes(StandardCharsets.UTF_8).length < this.length) {
           padded.append(' ');
       }
       return padded.toString();
    }

    /**
     * 이 static 메소드는 Item 객체를 쉽게 생성해서 반환한다.
     * 객체를 생성하는 static 메소드를 팩토리 메소드라고 한다.
     * @param name Item 의 이름
     * @param length Item 의 길이
     * @param value Item 의 값
     * @return Item 을 반환한다.
     */
    public static Item create(String name, int length, String value) {
       Item item = new Item();
       item.setName(name);
       item.setLength(length);
       item.setValue(value);
       return item;
    }

    public static void main(String[] args) {
        Item item = new Item();    // 항목을 생성한다.
        item.setName("이름");    // 이름을 "이름" 으로 저장한다.
        item.setLength(20);    // 길이를 20 으로 저장한다.
        item.setValue("홍길동");    // 값을 "홍길동" 으로 저장한다.

        System.out.printf("[%s]", item.raw());
    }
}
