class SinglyLinkedList implements LinkedListInterface{
    private Node head;
    private Node tail;
    private int size;
    private int i;

    SinglyLinkedList(){
        head = tail = null;
        size = 0;
    }

    /*
    Method to insert into the back of linklist
    Param data: the integer that is being inserted
    */
    public void addLast(int data){
        Node newNode = new Node(data);
        if(size == 0){
            head = tail = newNode;
            size++;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    /*
    Method to insert into the front of linklist
    Param data: the integer that is being inserted
    */
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        if(size == 0) {
            tail = newNode;
        }
        size++;
    }

    /*
    Method to insert data after a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data after
    */
    public void addAfter(int data, int after){
       Node afterNode = findNode(after);

        if(afterNode == null) {
            System.out.println("After node does not exist, defaulting insertion at rear");
            addLast(data);
            return;
        }

        if(afterNode == tail){
            addLast(data);
            return;
        }
        
        Node newNode = new Node(data);
        newNode.setNext(afterNode.getNext());
        afterNode.setNext(newNode);
        size++;
    }

    /*
    Method to find a node that contains the "target" value
    If such node exists, a reference to that node is returned
    Otherwise a null reference is returned
    Param target: the integer we want to find in the list
     */
    private Node findNode( int target ){
        Node targetNode = head;

        while(targetNode != null && targetNode.getData()!=target){
            targetNode = targetNode.getNext();
        }

        return targetNode;
    }

    /*
    Method to insert data before a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data before
    */
    public void addBefore(int data, int before){
        Node beforeNode = findNode(before);
        if(beforeNode ==null){
            System.out.println("Target Node doesnt exist, defaulting insertion to the rear");
            addLast(data);
            return;
        }
        if(beforeNode == head){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = head;
        
        while(prevNode!=null){
            if(prevNode.getNext() == beforeNode){
                prevNode.setNext(newNode);
                newNode.setNext(beforeNode);
            }
            prevNode = prevNode.getNext();
        }
         size++;

         // TODO:implement method (.5 point)
    }

    /*
    Method that checks to see if a given target value is in the list
    Returns true is it exist
    Returns false otherwise
    Param target: the integer we want to find in the list
     */
    public boolean contains(int target){
        return findNode(target) != null;
    }

    /*
    Method that returns the node from the given index
    Return the int stored at the index provided 
    If index is not in the list throw a IndexOutOfBounds Exception
    Param index: the position the user wants the data for 
    */
    public int get(int index) throws Exception{
        int counter = 0;
        Node current = head;

        if(index >= size){
            throw new IndexOutOfBoundsException("Index is not in the list");
        }

        while(current != null){
            
            
            if(counter == index) return current.getData();
            counter++;
            current = current.getNext();
            }
        
        
        return counter;
        // TODO:implement method (.5 point)
    }

    /*
    Method removes the head node from the list
    */
    public void removeHead(){
        Node curr = head;
        curr = head = curr.getNext();
        /* TODO:implement method (.5 point) */ 
    }

    public void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
           
        }
    }

}
