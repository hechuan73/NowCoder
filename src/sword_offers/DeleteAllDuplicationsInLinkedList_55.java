package sword_offers;

/**
 * @author hechuan
 */
public class DeleteAllDuplicationsInLinkedList_55 {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = pHead;
        ListNode curr = pHead, prev = fakeHead, next;

        while (curr != null && curr.next!= null) {
            if (curr.val != curr.next.val) {
                prev = curr;
                curr = curr.next;
            }
            else {
                next = curr.next;
                while (next != null && curr.val == next.val) {
                    next = next.next;
                }
                prev.next = next;
                curr = next;
            }
        }

        return fakeHead.next;
    }
}
