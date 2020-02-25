package sword_offers;

public class FindEntryInCycleLinkedList_54 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead, fast =pHead;

        do {
            if (fast != null && fast.next != null) { fast = fast.next.next; }
            else { return null; }
            slow = slow.next;
        } while (slow != fast);

        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
