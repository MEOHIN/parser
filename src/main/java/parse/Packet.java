package parse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 완전한 송신 전문은 `이름+전화번호` 처럼 여러개의 아이템을 합쳐서 만든다.
 * 이 클래스는 여러개의 아이템을 포함한다.
 */
public class Packet {
    /**
     * Item 객체를 포함하는 item 속성을 추가한다.
     * Item 갯수는 가변이므로 ArrayList 에 담았다.
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Item 을 리스트 items 에 추가한다.
     * @param item 아이템
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Item 을 가져온다.
     * @param index items 리스트의 순번
     * @return items 리스트에서 입력받은 순번에 있는 item 을 반환한다.
     */
    public Item getItem(int index) {
        return this.items.get(index);
    }

    /**
     * 이 메소드는 items 의 항목을 하나씩 Item 클래스의 raw() 메소드에 대입해서 반환된 값을 모두 더한 Packet 의 전문을 반환한다.
     * @return Packet 의 전문을 반환한다.
     */
    public String raw() {
        StringBuilder result = new StringBuilder();
        for (Item item : items) {
            result.append(item.raw());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setName("이름");
        item1.setLength(20);
        item1.setValue("홍길동");

        Item item2 = new Item();
        item2.setName("전화번호");
        item2.setLength(11);
        item2.setValue("01011112222");

        Packet packet = new Packet();
        packet.addItem(item1);
        packet.addItem(item2);

        System.out.printf("[%s]", packet.raw());
    }
}
