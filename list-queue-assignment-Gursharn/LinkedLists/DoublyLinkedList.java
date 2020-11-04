class DoublyLinkedList implements LinkedListInterface {
    private DNode header, trailer;
    private int size;

    DoublyLinkedList(){
        header = new DNode();
        trailer = new DNode();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public void addFirst(int data){
        DNode newNode = new DNode(data);
        addAfter( newNode, header);
        size++;
    }

    private void addAfter( DNode newData, DNode after){
        after.getNext().setPrev(newData);
        newData.setNext(after.getNext());
        after.setNext(newData);
        newData.setPrev(after);
    }

    /*
    Method to insert into the back of linklist
    Param data: the integer that is being inserted
    */
    public void addLast(int data) {
        DNode newNode = new DNode(data);
        if(size == 0){
            addFirst(data);
            return;
               }
               
        trailer.getPrev().setNext(newNode);
        newNode.setPrev(trailer.getPrev());
        trailer.setPrev(newNode);
        newNode.setNext(trailer);
               
        
        size++;

        // TODO:implement method (.5 point)
    }

    /*
    Method to insert data before a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data before
    */
    private void addBefore (DNode data, DNode before) {
        data.setNext(before);

        data.setPrev(before.getPrev());
        before.getPrev().setNext(data);
        before.setPrev(data);
        /* before.setPrev(data);

        before.getPrev().setNext(data);
        data.getPrev().setNext(data);
        before.setPrev(data); */
        
         size++;
        

        // TODO:implement method (.5 point)
    }

    public void addAfter(int data, int after){
        DNode newData = new DNode(data);
        DNode afterNode = findNode(after);
        if(afterNode == trailer) {
            System.out.println("After node does not exist, defaulting insertion at rear");
            addBefore(newData, trailer);
            size++;
            return;
        }
        addAfter(newData, afterNode);
        size ++;
        return;
    }

    /*
    Method to insert data before a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data before
    */
    public void addBefore(int data, int before){
        DNode newNode = new DNode(data);
        DNode beforeNode =  findNode(before);
        

        if(beforeNode == trailer){
           
            addBefore(newNode, trailer);
            size++;
            return;
            
        } 

    

        if(beforeNode == header){
            addFirst(data);
            size++;
            return;
        }

        addBefore(newNode, beforeNode);
        size++;
        
        
        // TODO:implement method (.5 point)
    }

    private DNode findNode(int target){
        DNode targetNode = header.getNext();
        while(targetNode != trailer && targetNode.getData()!=target){
            targetNode = targetNode.getNext();
        }
        return targetNode;
    }

    /*
    Method that checks to see if a given target value is in the list
    Returns true is it exist
    Returns false otherwise
    Param target: the integer we want to find in the list
     */
    public boolean contains(int target){
        DNode current = header.getNext();
        while(current != trailer){
            if(current.getData() == target){return true;}
            current = current.getNext();
        }

        return false;

        // TODO:implement method (.5 point)
    }

    /*
    Method that returns the node from the given index
    Return the int stored at the index provided 
    If index is not in the list throw a IndexOutOfBounds Exception
    Param index: the position the user wants the data for 
    */
    public int get(int index) throws Exception{
        
        DNode current = header.getNext();

        if(index ==0){
            return header.getNext().getData();
        }

        if(index ==(size-1) ){
            return trailer.getPrev().getData();
        }

        if(index < (size-1) || index >0){
            for(int i =0; i< index; i++){
                if(current.getNext()==null){
                    throw new IndexOutOfBoundsException();
                }
                current = current.getNext();
            }

        }
        return current.getData();
        // TODO:implement method (.5 point)
 }

    /*
    Method removes the head node from the list
    */
    public void removeHead(){
       
        header.getNext().getNext().setPrev(header);
        header.setNext(header.getNext().getNext()); 
       
        
        // TODO:implement method (.5 point)
    }

    public void printt(){
        DNode current = header.getNext();
        while(current != trailer){
            System.out.println(current.getData());
            current = current.getNext(); 
           
        }
    }
}
