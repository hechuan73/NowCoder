package com.chuan.sword_offers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class CloneLinkedList_25 {

    /**
     * Solution with hash table.
     *
     * @param pHead root node of the list
     * @return the cloned list
     */
    public RandomListNode Clone1(RandomListNode pHead) {
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

    /**
     * Solution with splitting.
     *
     * @param pHead root node of the list
     * @return the cloned list
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) { return null; }
        RandomListNode curr = pHead, next;

        // copy nodes
        while (curr != null) {
            next = curr.next;
            curr.next = new RandomListNode(curr.label);
            curr.next.next = next;
            curr = next;
        }

        // set the random pointers of the new list
        curr = pHead;
        while (curr != null) {
            if (curr.random != null) { curr.next.random = curr.random.next; }
            curr = curr.next.next;
        }

        // split the two lists
        curr = pHead;
        RandomListNode fakeHead = new RandomListNode(0), node = fakeHead;
        while (curr != null) {
            node.next = curr.next;
            node = node.next;
            // reset the original list
            curr.next = node.next;
            curr = curr.next;
        }

        return fakeHead.next;
    }
}