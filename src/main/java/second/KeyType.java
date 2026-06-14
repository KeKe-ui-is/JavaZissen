package second;

//列挙型
enum KeyType{
    PADLOCK(1024),BUTTON(10000),DIAL(30000),FINGER(100000);

    private final long count;

    KeyType(long count){
        this.count = count;
    }

    public long getCount(){
        return count;
    }
}
