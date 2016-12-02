package Model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class Book implements Serializable {
    private Integer id;
    private String bookTitle;
    private String author;
    private String publishing;
    public Book(){

    }

    public Book(Integer id, String bookTitle, String author, String publishing) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publishing = publishing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }
}
