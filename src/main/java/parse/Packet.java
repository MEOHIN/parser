package parse;

import java.util.ArrayList;
import java.util.HashMap;

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
     * Item 을 Access 할 때 , Item 이름으로 Access 할 수 있도록 HashMap 객체를 추가
     * Key 는 아이템의 이름, Value 는 Item 이다.
     */
    private HashMap<String, Item> nameAccess = new HashMap<>();

    /**
     * Item 을 리스트 items 에 추가(.add)한다.
     * Item 을 HashMap nameAccess 에 추가(.put)한다.
     * 동일한 이름으로 사용하는 Item 이 2개 이상일 경우에 nameAccess 의 Key 가 종복되는 문제가 발생한다.
     * 따라서 전문 생성시 동일한 이름으로 Item 을 설정할 수 없도록 한다.
     * @param item 아이템
     */
    public void addItem(Item item) {
        this.items.add(item);
        // 이름이 중복되지 않도록, 동일한 Item 이름이면 RuntimeException 을 발생시킨다.
        if (nameAccess.containsKey(item.getName())) {
            throw new RuntimeException("Duplicated item name:[" + item.getName() + "]");
        }
        nameAccess.put(item.getName(), item);
    }

    /**
     * 이름으로 Item 을 가져온다.
     * @param name 이름
     * @return 이름으로 가져온 아이템을 반환한다.
     */
    public Item getItem(String name) {
        return nameAccess.get(name);
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

    /**
     * 이 메소드는 Packet 클래스에 추가한 아이템들의 값을 세탕한다.
     * 1. 수신받은 전문을 먼저 바이트 배열로 바꾼다.
     * 2. 수신 전문 규격에 의해 위에서 만들어진 receivePacket 아이템들을 순차적으로 돌면서 아이템의 길이만큼 temp 바이트 배열을 생성한다.
     * 3. System.arraycopy() 를 이용해서 값을 복사한다.
     *
     * System.arraycopy() 사용 방법은 다음과 같다.
     * System.arraycopy(소스, 소스시작위치, 대상, 대상시작위치, 복사할길이)
     *
     * @param data 수신받은 전문
     */
    public void parse(String data) {
        // 수신받은 전문을 바이트 배열로 바꾼다.
        byte[] bData = data.getBytes();
        int pos = 0;

        // 아이템 리스트를 순차적으로 반복한다. 이 때 아이템 리스트는 수신 전문 규격에 의해 만들어진 receivePacket 이다.
        for (Item item : items) {
            // 아이템의 길이만큼 바이트 배열 temp 를 생성한다.
            byte[] temp = new byte[item.getLength()];
            // 값을 복사한다.
            System.arraycopy(bData, pos, temp, 0, item.getLength());
            // 소스시작위치는 아이템 길이만큼 계속 증가해야 한다.
            pos += item.getLength();
            // temp 값이 복사되면 item 에 value 를 세팅한다.
            item.setValue(new String(temp));
        }

    }

    public static void main(String[] args) {
        // 전문 생성
        Item item1 = Item.create("이름", 20, "홍길동");
        Item item2 = Item.create("전화번호", 11, "01011112222");

        Packet packet = new Packet();
        packet.addItem(item1);
        packet.addItem(item2);

        System.out.printf("[%s]\n", packet.raw());

        // 전문 파싱
        Packet receivePacket = new Packet();
        // 값은 파싱을 해야 알 수 있으므로 null 로 세팅한다.
        receivePacket.addItem(Item.create("생일", 8, null));
        receivePacket.addItem(Item.create("주소", 50, null));
        receivePacket.parse("19801215서울시 송파구 잠실동 123-3               ");

        System.out.println(receivePacket.getItem("주소").raw());
    }
}
