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
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode nextnode=null;
        while(curr!=null){
            nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1= reverseList(l1);
        ListNode r2=reverseList(l2);
        int totalsum=0;
        int carry=0;
        ListNode ans=new ListNode();
        while(r1!=null || r2!=null){
            if(r1!=null){
                totalsum+=r1.val;
                r1=r1.next;
            }
            if(r2!=null){
                totalsum+=r2.val;
                r2=r2.next;
            }
            ans.val=totalsum%10;
            carry=totalsum/10;
            ListNode head=new ListNode(1);
            head.next=ans;
            ans=head;
            totalsum=carry;
        }
        return carry==0 ? ans.next:ans;
    }
}

/*
Dry Run : 
7-2-4-3
5-6-4

Step1 : Reverse them: 
3-4-2-7
4-6-5
it1----------------------------
totalsum --> 0
totalsum --> 0+3
totalsum --> 3+4=7
carry --> 7/10= 0
ans.val=7....                  7 - - - 
ans |7|  head |0|
 ans -> 0-7
totalsum-->7
it2-----------------------------
totalsum --> 0
totalsum --> 0+4
totalsum --> 4+6=10
carry --> 10/10= 1
ans.val=0
head |1|  ans 0-7
ans= 1-0-7
totalsum-->1
it3---------------------
totalsum-->9
carry=0
ans=1-0-7
ans.val=8
0-8-0-7
it4----------------
totalsum-->7
ans=1-0-7
ans.val=7
7-8-0-7






 */