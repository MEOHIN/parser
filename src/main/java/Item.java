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

    /**
     * 이 method 는 항목의 값을 반환한다.
     * @return Item 클래스의 value 를 반환한다.
     */
   public String raw() {
        return this.value;
    }

    public static void main(String[] args) {
        Item item = new Item();    // 항목을 생성한다.
        item.setName("이름");    // 이름을 "이름" 으로 저장한다.
        item.setLength(20);    // 길이를 20 으로 저장한다.
        item.setValue("홍길동");    // 값을 "홍길동" 으로 저장한다.
    }
}
