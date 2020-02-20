package sword_offers;

public class MergeTwoSortedLinkedList_16 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(0), prev = res;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                prev.next = new ListNode(list2.val);
                list2 = list2.next; }
            else {
                prev.next = new ListNode(list1.val);
                list1 = list1.next;
            }

            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;
        return res.next;
    }
}
