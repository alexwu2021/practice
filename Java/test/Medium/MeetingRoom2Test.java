package Medium;

import CommonTypes.Interval;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingRoom2Test {

    @Test
    public void minMeetingRooms() {
        MeetingRoom2 meetingRoom2 = new MeetingRoom2();

        Interval[] intervals = new Interval[3];
        int i = 0;
        intervals[i++] = new Interval(0, 30);
        intervals[i++] = new Interval(5, 10);
        intervals[i++] = new Interval(15, 20);


        int actual, expected =  2;

        actual = meetingRoom2.minMeetingRooms(intervals);
        Assert.assertEquals(expected, actual);
    }
}