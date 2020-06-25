class Node<T>{
    private T data;
    private Node<T> next;
    private Node<T> previous;

    Node(){
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    Node(T data){
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    Node(T data, Node<T> previous, Node<T> next){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    void setData(T data){
        this.data = data;
    }

    void setNext(Node<T> next){
        this.next = next;
    }

    void setPrevious(Node<T> previous){
        this.previous = previous;
    }

    T getData(){
        return this.data;
    }

    Node<T> getNext(){
        return this.next;
    }

    Node<T> getPrevious(){
        return this.previous;
    }
}