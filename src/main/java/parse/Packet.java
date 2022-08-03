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
}
