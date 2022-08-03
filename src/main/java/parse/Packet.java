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
        // 전문 생성
        Item item1 = Item.create("이름", 20, "홍길동");
        Item item2 = Item.create("전화번호", 11, "01011112222");

        Packet packet = new Packet();
        packet.addItem(item1);
        packet.addItem(item2);

        System.out.printf("[%s]", packet.raw());

        // 전문 파싱
        Packet receivePacket = new Packet();
        // 값은 파싱을 해야 알 수 있으므로 null 로 세팅한다.
        receivePacket.addItem(Item.create("생일", 8, null));
        receivePacket.addItem(Item.create("주소", 50, null));
        receivePacket.parse("19801215서울시 송파구 잠실동 123-3               ");
    }
}
