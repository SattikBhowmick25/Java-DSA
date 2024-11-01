public class QueueLL {
    
}
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}
class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        QueueNode node=new QueueNode(a);
        if(rear==null){
            front=node;
            rear=node;
        }
        rear.next=node;
        rear=node;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        if(rear==null)  return -1;
        int a=front.data;
        if(front==rear){
            front=null;
            rear=null;
        }
        front=front.next;
        return a;
	}
}
