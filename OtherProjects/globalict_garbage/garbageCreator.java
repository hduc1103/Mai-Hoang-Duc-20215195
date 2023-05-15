package OtherProjects.globalict_garbage;

public class garbageCreator {
    public static void main(String[] args) {
        String s = "";
        for(int i = 0; i < 10000000; i++) {
            s += "abcdefghijklmnop";
        }
    }
}
