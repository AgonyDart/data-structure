package queue;

public class Work {
    private String title;
    private String author;
    private boolean printed;

    public Work(String title, String author, boolean printed) {
        this.title = title;
        this.author = author;
        this.printed = printed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }
}
