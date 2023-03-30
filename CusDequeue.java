class Node<E>{
    protected Node<E> next;
    protected Node<E> prev;
    private E data;

    public Node(E data) {
        setData(data);
        setNext(null);
        setPrev(null);
    }

    public Node() {
        setData(null);
        setNext(null);
        setPrev(null);
    }

    public void setNext(Node obj){this.next = obj;}

    public void setPrev(Node obj){this.prev = obj;}

    public void setData(E data){this.data = data;}

    public E getData(){return this.data;}
}

public class CusDequeue<E> {
    protected Node<E> head;
    protected Node<E> tail;

    protected int size;

    private void setFirstElement(E data){
        this.head = new Node<E>(data);
        this.tail = this.head;
        this.size++;
    }

    public int getSize(){return this.size;}
    public E getF(){return this.head.getData();}
    public E getB(){return this.tail.getData();}

    public CusDequeue(){
        reset();
    }

    private void reset(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void enqueueF(E data){
        if(isEmpty()){
            setFirstElement(data);
            return;
        }

        Node<E> newHead = new Node<>(data);
        newHead.setNext(this.head);

        this.head.prev = newHead;
        this.head = newHead;
        this.size++;
    }

    public void enqueueB(E data){
        if(isEmpty()){
            setFirstElement(data);
            return;
        }

        Node<E> newTail = new Node<>(data);
        newTail.setPrev(this.tail);

        this.tail.next = newTail;
        this.tail = newTail;
        this.size++;
    }

    public void removeF(){
        if(isEmpty()) return;
        if(this.size == 1){
            reset();
            return;
        }

        this.head = this.head.next;
        this.head.prev = null;
        size--;
    }

    public void removeB(){
        if(isEmpty()) return;
        if(this.size == 1){
            reset();
            return;
        }

        this.tail = this.tail.prev;
        this.tail.next = null;
        size--;
    }

    public boolean isEmpty(){return this.size == 0;}

}
