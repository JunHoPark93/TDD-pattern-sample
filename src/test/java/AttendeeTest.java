import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AttendeeTest {

    @Test
    public void testAdd() throws Exception {
        Attendee attendee = new Attendee();
        attendee.add("Park");
        assertEquals("Park", attendee.get(0));
    }


    @Test
    void testGet() throws Exception {
        Attendee attendee = new Attendee();
        attendee.add("Park");
        assertEquals("Park", attendee.get(0));
    }
}
