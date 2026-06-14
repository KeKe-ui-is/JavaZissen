package five;

import five.Book;

import java.util.Comparator;

public class TitleComparator implements Comparator<five.Book> {
    @Override
    public int compare(five.Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
