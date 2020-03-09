package sword_offers;

/**
 * @author hechuan
 */
public class IsPostOrderOfBST_23 {

    /**
     * BST的后序序列的合法序列是: 对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段
     * （左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
     *
     * @param sequence post order sequence of BST
     * @return whether the sequence is post order sequence of BST
     */
    public boolean VerifySequenceOfBST(int [] sequence) {
        if (sequence.length == 0) { return false; }
        return check(sequence, 0, sequence.length-1);
    }

    private boolean check(int[] sequence, int start, int end) {
        if (start >= end) { return true; }

        int i = end;
        while (i > start && sequence[i-1] > sequence[end]) { i--; }
        int pivot = i;
        while (i > start) {
            if (sequence[--i] > sequence[end]) { return false; }
        }

        return check(sequence, start, pivot-1) && check(sequence,pivot, end-1);
    }
}
