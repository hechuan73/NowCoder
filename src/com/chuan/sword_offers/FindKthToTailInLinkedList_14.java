package com.chuan.sword_offers;

public class FindKthToTailInLinkedList_14 {

    public ListNode FindKthToTail(ListNode head,int k) {
        int count = 0;
        ListNode node = head;
        while (null != node) {
            node = node.next;
            count++;
        }

        int index = count-k;
        if (index < 0) { return null; }
        while (index-- > 0) {
            head = head.next;
        }

        return head;
    }
}
