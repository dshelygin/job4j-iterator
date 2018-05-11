package mThreading.search;

    import java.util.Arrays;

public class Task {
    public static void main(String args[]) {
        ParallerSearch ps = new ParallerSearch("D:\\tmp\\2", Arrays.asList("txt","log"), "hello world" );
        ps.init();
    }
}
