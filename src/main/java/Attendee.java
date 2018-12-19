import java.util.ArrayList;

public class Attendee {
    private ArrayList<String> list;

    public Attendee() {
        this.list = new ArrayList<>();
    }

    public void add(String name) {
        list.add(name);
    }

    public String get(int i) {
        return list.get(i);
    }
}
