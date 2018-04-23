package com.queuebylinkedlist;

class QueueItem{
    protected int value;
    protected QueueItem beforeItemPtr;
    protected QueueItem nextItemPtr;

    public QueueItem(int value) {
        this.value = value;
        beforeItemPtr = null;
        nextItemPtr = null;
    }
}

public class LinkedListQueue{
    private transient QueueItem back;
    private transient QueueItem front;

    public LinkedListQueue() {
        back = null;
        front = null;
        if(this.back == null){
            System.out.println("expression : null can be compared");
        }
    }

    public void push(int v){
        QueueItem item = new QueueItem(v);
        QueueItem lastBack = back;
        back = item;

        if(front == null){ // empty
            // QueueItem item2 = new QueueItem(v);
            front = item;
            return;
        }
        if(front.nextItemPtr == null){ // only one
            front.nextItemPtr = back;
            back.beforeItemPtr = lastBack;
            return;
        }
        back.beforeItemPtr = lastBack;
        lastBack.nextItemPtr = back;
    }

    public void pop(){
        if(back == null) {
            System.out.println("There is no content in the queue.");
            return;
        }
        if(front == back){
            front = null;
            back = null;
            return;
        }
        System.out.println("The removed item of the queue is : " + front.value);
        front = front.nextItemPtr;
        // System.out.println(front.beforeItemPtr);
        front.beforeItemPtr = null;
    }

    public void peek(){
        if(back == null){
            System.out.println("There is no content in the queue.");
            return;
        }
        System.out.println("The front item is : " + front.value);
    }

    public void printAllItems(){
        if(back == null){
            System.out.println("is empty");
            return;
        }
        QueueItem show = back;
        int i = 0;
        System.out.println("print from back : ");
        while(show != null){
            System.out.println("item " + i + " is " + show.value);
            i++;
            show = show.beforeItemPtr;
        }
    }
}
