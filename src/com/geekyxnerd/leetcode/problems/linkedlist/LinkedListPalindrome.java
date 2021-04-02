package com.geekyxnerd.leetcode.problems.linkedlist;

/**
 * @author geekyxnerd
 * Created on 02-Apr-21 at 12:26 PM.
 *
 * Problem Url: https://leetcode.com/problems/palindrome-linked-list/
 *
 * Problem description:
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class LinkedListPalindrome {
    // Solution
    public boolean isPalindrome(ListNode head) {
        //Step 1: Validate the list for null or size = 1
        if(head == null || head.next == null) {
            return true;
        }

        //Step 2: Making the first half reverse using double pointer
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        //Step 3: Incase of odd length -> move the slow pointer from middle to middle -> next
        if (fast != null) {
            slow = slow.next;
        }

        //Step 4: Lets start comparing
        while (slow != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}


