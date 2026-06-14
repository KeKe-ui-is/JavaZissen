package five;
import five.TitleComparator;
import org.apache.commons.lang3.builder.*;

import java.util.*;

public class Book implements Comparable<five.Book> {
    public Book(){}

    public Book(String title, Date publishDate, String comment){
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }

    private String title;
    private Date publishDate;
    private String comment;

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public int compareTo(five.Book book){
        return CompareToBuilder.reflectionCompare(this,book ,"comment" ,"title");
    }

    @Override
    public five.Book clone(){
        five.Book result = new five.Book();
        result.title = this.title;
        result.publishDate = (Date)this.publishDate.clone();
        result.comment = this.comment;
        return result;
    }

    @Override
    public String toString(){
        return "Book[title:" + title + "publishDate:" + publishDate + "comment:" + comment +"]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static void main(String[] args){
        List<five.Book> list = new ArrayList<>();
        list.add(new five.Book("Java入門",new Date(2011,9,07),"スッキリわかる"));
        list.add(new five.Book("Python入門",new Date(2011,5,11),"カレーが食べたくなる"));
        list.add(new five.Book("C言語入門",new Date(2018,5,21),"ポインタも自由自在"));

        System.out.println("Sort前:");
        int i = 0;
        for (five.Book b : list){
            System.out.println(i + " : " +b);
            i++;
        }

        System.out.println("Sort後:");
        Collections.sort(list,new TitleComparator());
        i = 0;
        for (five.Book b : list){
            System.out.println(i + " : " +b);
            i++;
        }

    }
}
