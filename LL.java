public class LL<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    LL(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }

    private Node<T> getNodeHead(){
        return this.head;
    }

    private Node<T> getNodeTail(){
        return this.tail;
    }

    public boolean contains(T data) throws EmptyListException {
        boolean decision = false;
        if(this.size == 0){
            throw new EmptyListException("List is empty");
        }
        Node<T> tmp = this.head;
        while(tmp != null){
            if(tmp.getData().equals(data)){
                decision = true;
                break;
            }
            tmp = tmp.getNext();
        }

        return decision;
    } 

    // push at beginning
    public void pushStart(T data){

        if(this.size == 0){
            this.head = new Node<T>(data, null, null);
            this.tail = this.head;
        }

        else{
            Node<T> head = new Node<T>(data, null, this.head);
            this.head.setPrevious(head);
            this.head = head;
        }
        
        this.size++;

    }

    public void pushAfter(T data, T newData){
        if(this.size == 0){
            this.head = new Node<T>(newData, null, null);
        }
        else{
            Node<T> tmp = this.head;
            while(tmp != null){
                if(tmp.getData().equals(data)){
                    Node<T> newNode = new Node<T>(newData, tmp, tmp.getNext());
                    Node<T> backwardsNode = tmp.getNext();
                    tmp.setNext(newNode);
                    if(backwardsNode != null){
                        backwardsNode.setPrevious(newNode);
                        tmp = backwardsNode;
                    }
                    else{
                        this.tail = newNode;
                        this.size++;
                        break;
                    }
                    this.size++;
                }
                else{
                    tmp = tmp.getNext();
                }
            }
        }
    }

    // push at the end
    public void pushEnd(T data){

        if(this.size == 0){
            this.tail = new Node<T>(data, null, null);
            this.head = this.tail;
        }
        else{
            Node<T> tail = new Node<T>(data, this.tail, null);
            this.tail.setNext(tail);
            this.tail = tail;
        }

        this.size++;

    }

    public void removeBegin() throws EmptyListException {
        if(this.size == 0){
            throw new EmptyListException("List has no size");
        }
        this.head = this.head.getNext();
        this.size--;
    }

    public void removeAnyInstanceOf(T data) throws EmptyListException {
        if(this.size == 0){
            throw new EmptyListException("List has no size");
        }
        
        Node<T> tmp = this.head;
            
        while(tmp != null){
            if(tmp.getData().equals(data)){

                Node<T> forwardLink = tmp.getPrevious();
                Node<T> backwardLink = tmp.getNext();

                if(backwardLink != null && forwardLink != null){
                    forwardLink.setNext(backwardLink);
                    backwardLink.setPrevious(forwardLink);
                }
                else if(backwardLink == null && forwardLink == null){
                    this.head = null;
                    this.tail = null;
                    this.size--;
                    break;
                }
                else if(backwardLink == null){
                    forwardLink.setNext(null);
                    this.tail = forwardLink;
                    this.size--;
                    break;
                }
                else if(forwardLink == null){
                    backwardLink.setPrevious(null);
                    this.head = backwardLink;
                }

                tmp = backwardLink;
                 
                this.size--;
            }
            else{
                tmp = tmp.getNext();
            }

        }   

    }
    
    public void removeEnd() throws EmptyListException {
        if(this.size == 0){
            throw new EmptyListException("List has no size");
        }
        
        this.tail = this.tail.getPrevious();
        this.tail.setNext(null);
        this.size--;
    }

    @Override
    public String toString() {
        String args = "";
        if(this.head == null){
            System.out.println("List is empty...");
        }
        Node<T> tmp = this.head;
        while(tmp != null){
            args += tmp.getData() + " ";
            tmp = tmp.getNext();
        }
        return args;
    }

    public void printBackwards() throws EmptyListException {
        if(this.size == 0){
            throw new EmptyListException("empty list");
        }
        Node<T> tmp = this.tail;
        while(tmp != null){
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getPrevious();
        }
        System.out.println();
    }
    
    public boolean equals(LL<T> list) throws EmptyListException {
        boolean decision = true;
        Node<T> tmp1 = this.head;
        Node<T> tmp2 = list.getNodeHead();
        if(tmp1 == null || tmp2 == null){
            throw new EmptyListException("List is empty");
        }
        while(tmp1 != null && tmp1 != null){

            if(!tmp1.getData().equals(tmp2.getData())){
                decision = false;
                break;
            }

            tmp1 = tmp1.getNext();
            tmp2 = tmp2.getNext();
            if((tmp1 != null && tmp2 == null)
            || (tmp1 == null && tmp2 != null)){
                decision = false;
                break;
            }
        }
        return decision;
    }

}