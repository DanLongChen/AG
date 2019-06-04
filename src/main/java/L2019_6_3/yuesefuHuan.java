package L2019_6_3;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/3
 **/
public class yuesefuHuan {
    public static void main(String[] args) {
        int n=0,m=0;
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        m=input.nextInt();

        Node head=new Node(0);
        Node p=head;
        for (int i=1;i<=n;i++){
            p.next=new Node(i);
            p=p.next;
        }
        p.next=head.next;
        int flag=1;
        p=head.next;
        Node pre=head;
        int count=0;
        while (p.next!=p){
            if (flag==m){
                System.out.println(p.val);
                pre.next=p.next;
                p=pre.next;
                flag=1;
                count++;
            }
            pre=pre.next;
            p=p.next;
            flag++;
        }
        System.out.println(p.val);
    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
