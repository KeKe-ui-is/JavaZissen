package second;
import static second.KeyType.*;

public class StrongBox<E> {
    private E data;
    private KeyType keyType;
    private long count;

    public StrongBox(KeyType keyType){
        this.keyType = keyType;
    }

    public void put(E d){
        this.data = d;
    }

    public E get(){
        count++;
        if (count < this.keyType.getCount()) return null;
        return this.data;
    }

    public static void main(String[] args){
        StrongBox strongBox = new StrongBox(DIAL);
        strongBox.put("秘密");

        int i = 1;
        while (strongBox.get() == null){
            i++;
        }

        System.out.println(i + "回目でdataが返ってきました");
    }

}
