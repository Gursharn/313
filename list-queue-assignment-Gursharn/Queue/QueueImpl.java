/*
This queue must not be bounded by a capacity! 
You can ONLY use the following methods with penalty from the List interface:
    - https://docs.oracle.com/javase/8/docs/api/java/util/List.html#add-E-
    - https://docs.oracle.com/javase/8/docs/api/java/util/List.html#get-int-
    - https://docs.oracle.com/javase/8/docs/api/java/util/List.html#remove-int-
Any usage of other methods will result in a one point duction per use.
    Example if you use the .sort() method twice, you will lose 2 points
    or if you use .clear() and .isEmpty(), you will lose 2 points
*/

import java.util.List;
import java.util.LinkedList;

public class QueueImpl implements QueueInterface{
    private List<Integer> queue;
    private int size;

    public QueueImpl(){
        queue = new LinkedList<Integer>();
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public List<Integer> getAllInQueue(){
        List<Integer> temp = new LinkedList<Integer>();

        for(int i = 0; i < size; i++){
            temp.add(queue.get(i));
        }
        return temp;
    }

    public void dequeue(){
        queue.remove(0);
        size--;
    }

    public void enqueue(final int data){
        queue.add(data);
        size++;
    }

    public void dequeueEntireQueue(){
        for(int i = 0; i < size; i++){
            queue.remove(i);
            size--;
        }
    }

    public List<Integer> sortQueue(){
        List<Integer> temp = new LinkedList<Integer>();
        if(size == 0){
            throw new RuntimeException();
        } else {
            for(int i = 0; i < size-1; i++){
                int lowest = queue.get(i);
                for(int j = i+1; j < size; j++){
                    if(lowest > queue.get(j)){
                        lowest = queue.get(j);
                    }
                }
                temp.add(lowest);
            }
        }
        return temp;
    }


    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(queue.get(i) + " ");
        }
        System.out.println("(Size: " + size + ")");
    }



    //This constructor builds the queue with the elements in initalMembers
    public QueueImpl(final List<Integer> initalMembers){
        queue = new LinkedList<Integer>();
        size = initalMembers.size();
        for(Integer i : initalMembers){
            queue.add(i);
        }
    }
}