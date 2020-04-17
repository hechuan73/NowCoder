package com.chuan.sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class PrintLinkedListToArrayListReversely_3 {

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        while (null != listNode) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }

        return res;
    }

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }

        return res;
    }
}
