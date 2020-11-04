import java.util.LinkedList;

public class Main {
    
        public static void main(String[] args) throws Exception{
            
    
            QueueImpl qu = new QueueImpl();
            qu.enqueue(1);
            qu.print();
            qu.enqueue(2);
            qu.dequeue();
            qu.enqueue(1);
            qu.print();
            qu.sortQueue();
            qu.print();
    
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(1);
            list.add(2);
    
            QueueImpl qu2 = new QueueImpl(list);
            qu2.enqueue(3);
            qu2.enqueue(4);
            qu2.print();
    
    
    
        }
    
    }
}
