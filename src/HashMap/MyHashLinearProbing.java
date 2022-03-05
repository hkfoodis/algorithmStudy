package HashMap;

public class MyHashLinearProbing {              // Chaning 기법과는 다르게 연결 리스트를 사용안하고 HashTable의 다음 방에 저장하는 방식
    public Slot[] hashTable;

    public MyHashLinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        String key;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key == key){
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null){
                    if(this.hashTable[currAddress].key == key){
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if(currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }

        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key == key){
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null){
                    if(this.hashTable[currAddress].key == key){
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if(currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }

        } else {
            return null;
        }
    }

    public static void main(String[] args){
        MyHashLinearProbing mainObject = new MyHashLinearProbing(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(mainObject.getData("David"));

    }
}
