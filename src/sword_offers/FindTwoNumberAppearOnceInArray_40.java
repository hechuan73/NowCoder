package sword_offers;

public class FindTwoNumberAppearOnceInArray_40 {

    /**
     * 主要通过三步获得结果：
     * 1. 把所有的元素进行异或操作，最终得到一个异或值。由于存在两个不同的数，所以这两个数的异或结果必然不为0。
     * 2. 取异或值最后一个二进制位为1的数字作为mask，mask最高位为1，表示两个数字在该位不同。注意，此处的实现方式是将异或值与其相反数按位与：
     *    如：对于数a: 101010，其相反数为-a: 010101（按位取反再加1），两者相与得mask: 000010，即为a的最后一个二进制位为1的数。
     * 3. 对于mask，最高位为1，表示这两个不同的数在该位是不同的。将数组每一个元素与mask进行按位与，为0表示在该位上是为0的，不为0表示在该位上是
     *    为1的，将它们为成两个数组，这两个不同的数将会被分到不同的数组内，并且其余数都是出现两次的。然后再分别进行异或即可得出这两个数。
     *
     * @param array input array
     * @param num1 answer 1
     * @param num2 answer 2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for (int val : array) { xor ^= val; }

        int mask = xor & (-xor);
        for (int val : array) {
            if ((val & mask) == 0) { num1[0] ^= val; }
            else { num2[0] ^= val; }
        }
    }
}
