package queue;
// Testing file
public class Main {

    public static void main(String[] args) {
        // Declaration of 3 tasks and the processor/'queue list'
        Work NewspaperMonday = new Work("Monday", "James McGill", true);
        Work NewspaperTuesday = new Work("Tuesday", "Charles McGill", true);
        Work NewspaperWednesday = new Work("Wednesday", "Kim Wexler", true);
        QueueProcessor processor = new QueueProcessor();

        // Verify that the queue is clear before adding
        System.out.println(processor.get()); // <- should return null

        // Adding the 3 newspapers to the queue
        processor.add(NewspaperMonday);
        processor.add(NewspaperTuesday);
        processor.add(NewspaperWednesday);

        // Process the first with 2 actions/methods
        System.out.println(processor.get().getTitle()); // <- should return Monday Newspaper (without .getTitle() should return the value in memory)
        processor.remove();

        // Next 2 are going to be processed in the all-in-one method
        System.out.println(processor.settle().getTitle()); // <- Tuesday
        System.out.println(processor.settle().getTitle()); // <- Wednesday

        // Queue is empty again
        System.out.println(processor.get());
    }
}