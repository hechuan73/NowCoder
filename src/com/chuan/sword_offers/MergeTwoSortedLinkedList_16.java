package com.chuan.sword_offers;

public class MergeTwoSortedLinkedList_16 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode fakeHead = new ListNode(0), curr = fakeHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 == null ? list2 : list1;

        return fakeHead.next;
    }
}
