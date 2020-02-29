package sword_offers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author hechuan
 */
public class MaximumNumberInSlidingWindow_63 {

    /**
     * 使用动态规划的思想，借助两个辅助数组，来完成在时间复杂度O(1)内获取窗口内元素的最大值。
     * 算法的思想是将输入数组分割成有 k 个元素的块。若 n % k != 0，则最后一块的元素个数可能更少。
     * 对于数组[1, 3, -1, -3, 5, 3, 6, 7], k = 3。当窗口左端为i，右端为j，则该窗口可能在一个块内，也可能在两个块中：
     * 1. 一个块：i        j
     * [1, 3, -1] ｜ -3, 5, 3 ｜ 6, 7
     * 2. 两个块：       i        j
     * 1, 3, [-1 ｜ -3, 5], 3 ｜ 6, 7
     * <p>
     * 对于1，这种情况比较简单，建立数组left， 其中left[j]是从块的开始到下标j最大的元素，方向：左->右。则块内的最大元素即为left[j]。
     * 对于2，这种情况比较复杂，建立数组right，其中right[j]是从块的结尾到下标j最大的元素，方向：右->左。right数组和left除了方向不同以外基本
     * 一致。
     * <p>
     * 两数组一起可以提供两个块内元素的全部信息。考虑从下标i到下标j的滑动窗口。根据定义，right[i]是左边的块内的最大元素，left[j]是右边的块内
     * 的最大元素。因此滑动窗口中的最大元素为max(right[i], left[j])，j = i+k-1。
     *
     * @param num  input array
     * @param size the width of the window
     * @return the maximum element in each window.
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length == 0 || size <= 0) {
            return res;
        }

        int n = num.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = num[0];
        right[n - 1] = num[n - 1];

        int j;
        for (int i = 1; i < n; i++) {
            if (i % size == 0) {
                left[i] = num[i];
            } else {
                left[i] = Math.max(left[i - 1], num[i]);
            }

            j = n - i - 1;
            if ((j + 1) % size == 0) {
                right[j] = num[j];
            } else {
                right[j] = Math.max(right[j + 1], num[j]);
            }
        }

        int resLen = n - size + 1;
        for (int i = 0; i < resLen; i++) {
            res.add(Math.max(left[i + size - 1], right[i]));
        }

        return res;
    }

    /**
     * 该问题的关键在于如何在O(1)的时间复杂度内获得窗口内的最大值，由于使用堆，每次堆化的时间复杂度为O(logh)，所以这里我们考虑使用双向队列来进
     * 行优化。算法如下：
     * 1. 处理前k个元素，初始化双向队列。
     * 2. 遍历整个数组，在每一步：
     *     a. 从首部清理队列，只保留当前窗口内的索引。
     *     b. 从尾部清理队列，只保留比当前元素大的元素的索引，因为比当前元素小的元素，不可能是窗口内的最大元素。这样队首始终保存当前窗口最大的
     *        元素的索引，同时队列是单调递减队列。
     * 3. 将当前元素添加到队列中。
     * 4. 当达到窗口宽度k时，开始取队首元素到结果集中。
     *
     * 每个元素会被添加到队列一次，以及被删除一次，而添加/删除操作时间复杂度都为O(1)，取队首时间复杂度也为O(1)，总时间复杂度为O(n)。
     *
     * @param num input array
     * @param size the width of the window
     * @return the maximum element in each window.
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length == 0 || size <= 0) { return res; }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - size + 1) { deque.poll(); }
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) { deque.pollLast(); }

            deque.offer(i);
            if (i - size + 1 >= 0) {
                res.add(num[deque.peek()]);
            }
        }

        return res;
    }
}
