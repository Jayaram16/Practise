package crackCodingInterview;

import test.linkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode top=head;
        
        boolean found=false;
        while(top!=null){
            if(top.val<x){
                found=true;
                break;
            }
            top=top.next;
        }
        if(!found){
            return head;
        }
        if(top==head){
        
            //top=addFirstLowerElementAtBeginning(head,x);
        ListNode top2 = head.next;
        ListNode prev=head;
        while(top2!=null && top2.val>=x){
            top2=top2.next;
            prev=prev.next;
        }
        if(top2!=null){
            ListNode temp=top2.next;
            top2.next=head;
            prev.next=temp;
            head=top2;
        }
         top=head.next;   
        }
        partitionForNonEndElements(top,head,x);
        return head;
    }
    public void partitionForNonEndElements(ListNode top,ListNode head,int x){
    //After we get the value.Provided top is not the last node.
        //backNode for adding at the front of the node.
        //prev is to re allocate the changes after x and during transfer.
        ListNode prev=top;
        top=top.next;
        ListNode backNode=head;
        while(top!=null){
            if(top.val< x){
                prev.next=top.next;
                ListNode temp=backNode.next;
                backNode.next=top;
                top.next=temp;
                top=prev.next;
                backNode=backNode.next;
            }
            else{
                prev=prev.next;
                top=top.next;
            }
        }
    }
}