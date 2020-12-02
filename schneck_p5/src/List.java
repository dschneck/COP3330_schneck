import java.util.ArrayList;

public abstract class List <I extends Item> {

    /* Fields */
    public final String itemType;
    public ArrayList<I> list;

    /* Defined methods */
    protected boolean isValidIndex(int index) {
        return !(index < 0 || index > this.getSize());
    }

    protected List(String itemType) {
        this.itemType = itemType;

        list = new ArrayList<>();
    }

    public void addItem(I item) {list.add(item);}

    public void addItemFromFile(I item) {list.add(item);}

    public void clearList() {list.clear();}

    public void removeItem(int index) {
        if (isValidIndex(index)) {
            list.remove(index);
        } else {
            throw new IndexOutOfBoundsException("You must pick a " + itemType +  " index that is in the list\n");
        }
    }

    public int getSize() {return list.size();}

    /* Abstract methods */
    abstract String [] getItemString(int index);

    abstract void printList();

    abstract void saveToFile(String filename);

}