package sword_offers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class CloneLinkedList_25 {

    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode prev = new RandomListNode(0);
        RandomListNode head = prev, curr, origin = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (origin != null) {
            curr = new RandomListNode(origin.label);
            map.put(origin, curr);

            prev.next = curr;
            prev = curr;
            origin = origin.next;
        }

        curr = head.next;
        while (pHead != null) {
            curr.random = map.get(pHead.random);
            pHead = pHead.next;
            curr = curr.next;
        }

        return head.next;
    }
}
