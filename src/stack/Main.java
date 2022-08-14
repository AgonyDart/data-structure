package stack;

// Testing file
public class Main {
    public static void main(String[] args) {
        URL yt = new URL("youtube");
        URL gh = new URL("github");
        URL fb = new URL("facebook");
        URL ig = new URL("instagram");
        URL gg = new URL("google");
        StackProcess process = new StackProcess();

        process.push(yt);
        process.push(fb);
        process.push(ig);
        process.push(gg);
        process.push(gh);

        while (!process.isEmpty()) {
            System.out.println(process.get().getUrl());
            System.out.println(process.length());
            process.pop();
        }

        System.out.println(process.get());
        System.out.println(process.length());
        process.pop();
    }
}
