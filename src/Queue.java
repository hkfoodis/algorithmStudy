import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> array = new ArrayList<>();

    public void enqueue(T item){
        array.add(item);
    }

    public T dequeue(){
        if(array.isEmpty()){
            return null;
        } else {
            return array.remove(0);
        }
    }

    public static void main(String[] args){
        Queue<Integer> mq = new Queue<Integer>();

        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);

        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }

}