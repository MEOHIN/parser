package parse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 완전한 송신 전문은 `이름+전화번호` 처럼 여러개의 아이템을 합쳐서 만든다.
 * 이 클래스는 여러개의 아이템을 포함한다.
 */
public class Packet {
    private ArrayList<Item> items = new ArrayList<>();
}
