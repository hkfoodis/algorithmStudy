package HashMap;

public class MyHashChaning {           //Hash의 충돌을 방지하기위한 Chaining 기법(중복된 키가 있으면 슬롯 뒤에 링크드리스트로 데이터를 늘림)
    public Slot[] hashTable;

    public MyHashChaning(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        String key;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];        //LinkedList의 head 설정
            Slot prevSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);

        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args){
        MyHashChaning mainObject = new MyHashChaning(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(mainObject.getData("Dave"));
        System.out.println(mainObject.getData("DaveLee"));
    }
}