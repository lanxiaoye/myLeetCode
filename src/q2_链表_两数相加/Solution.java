package q2_链表_两数相加;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author lanxiaoye
 * @date 2020/11/27 16:01
 * Description:
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6));
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为指针无法往回移，head用于记录最开始的地方
        ListNode head = new ListNode();
        ListNode indexNode = head;
        int flag = 0;

        // 只要l1或l2还有位数或者进位不为0，就继续循环
        while (l1 != null || l2 != null || flag != 0) {
            // l1或l2都可能为空，先判断
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            // 计算和、余数、进位
            int sum = val1 + val2 + flag;
            int indexVal = sum % 10;
            flag = sum / 10;
            indexNode.next = new ListNode(indexVal);
            indexNode = indexNode.next;
            // 指针往后移，继续循环
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode head = this;
            while (head != null) {
                sb.append(head.val);
                head = head.next;
            }
            return sb.toString();
        }
    }
}
