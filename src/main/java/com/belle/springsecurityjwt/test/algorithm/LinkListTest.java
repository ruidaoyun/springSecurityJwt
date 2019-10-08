package com.belle.springsecurityjwt.test.algorithm;

/**
 * @author: rui.dy
 * @date: 2019/10/8
 * @description:
 */
public class LinkListTest {
    private  class ListNode {
        public ListNode(int value) {
            this.value=value;
        }

        public ListNode() {
        }

        int value;
        ListNode next;

        public ListNode next(int value) {
            this.next=new ListNode (value);
            return this.next;
        }

        @Override
        public String toString() {
            String s = String.valueOf (value);
            while (next!=null){
                s+="->"+String.valueOf (next);
                next = next.next;
            }
            return s;
        }
    }

    /**
     * 给定一个链表及两个正整数m和n，1<=m<=n<=链表长度，反转链表中从m到n的元素。
     * 例：链表1->2->3->4->5->NULL，m=2，n=4，输出1->4->3->2->5->NULL。
     */
    /*public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode pre=head;
        ListNode next=null;
        for (int i=1; i < m - 1; i++) {
            pre.next=head.next;
            next=head.next;
        }

        for (int i=0; i < n - m + 1; i++) {
            //next.next

        }
    }*/

    public static ListNode reverse(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode temp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = temp; //当前指针后移
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkListTest linkListTest=new LinkListTest ();
        ListNode listNode=linkListTest.new ListNode (0);
        ListNode next=listNode.next (1);
        //listNode.next(1).next(2).next (3).next (4).next=null;
        System.out.println (listNode);
        System.out.println (reverse (listNode));
    }
}
