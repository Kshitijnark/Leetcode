/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int ldata,rdata;
        while(left<=right){
            ListNode si=head;
        for(int i=1;i<left;i++){
            si=si.next;
        }
        ldata=si.val;
        ListNode ei=head;
        for(int i=1;i<right;i++){
            ei=ei.next;
        }
        rdata=ei.val;
        si=head;
        ei=head;
        for(int i=1;i<left;i++){
            si=si.next;
        }
        si.val=rdata;
        for(int i=1;i<right;i++){
            ei=ei.next;
        }
        ei.val=ldata;
        left++;
        right--;
        }
        System.gc();
        return head;
        

    }
}