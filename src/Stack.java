import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> array = new ArrayList<>();

    public void push(T item){
        array.add(item);
    }

    public T pop(){
        if(array.isEmpty()){
            return null;
        } else {
            return array.remove(array.size() - 1);
        }
    }

    public static void main(String[] args){
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
