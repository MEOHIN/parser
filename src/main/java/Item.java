/**
 * 이 class 는 전문을 생성하는 항목을 나타낸다.
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
}
