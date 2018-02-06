package com.se.algorithm.chainreverse;

import java.util.Stack;

public class ReverseTest {


    public static void main(String[] args) {
        Note n1 = new Note(1);
        Note n2 = new Note(2);
        Note n3 = new Note(3);
        Note n4 = new Note(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        //Note note = n1;
        Note note = reverse(n1);
        do {
            System.out.println(note);
        } while ((note = note.next) != null);

    }

    public static Note reverse(Note head) {
        if (head == null || head.next == null) {
            return head;
        }
        Note reHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    /**
     * 遍历
     *
     * @param head
     * @return
     */
    public static Note reverse1(Note head) {
        if (head == null || head.next == null) {
            return head;
        }
        Note pre = head;
        Note cur = head.next;
        while (null != cur.next) {
            Note tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        head.next = null;
        return cur;

    }

    /**
     * 利用其他数据结构stack
     *
     * @param head
     * @return
     */
    public static Note reverse2(Note head) {
        Stack<Note> stack = new Stack<>();
        for (Note note = head; note != null; note = note.next) {
            stack.add(note);
        }
        Note reHead = stack.pop();
        Note cur = reHead;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = null;
        }
        return reHead;
    }


}
