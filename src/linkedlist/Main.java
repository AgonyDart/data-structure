package linkedlist;

// Testing File
public class Main {
    public static void main(String[] args) {
        List list = new List();
        Book buk = new Book("Treasure Island", "Robert Louis Stevenson", "9780195811391");
        Book bok = new Book("El principito", "Antoine de Saint-Exupéry", "9780195811391");

        list.insertChild(buk);
        System.out.println(list.get(0));
        System.out.println(list.get(0).getTitle());
        System.out.println(list.get(0).getAuthor());

        list.appendChild(bok);
        System.out.println(list.get(1));
        System.out.println(list.get(1).getTitle());
        System.out.println(list.get(1).getAuthor());
    }
}
