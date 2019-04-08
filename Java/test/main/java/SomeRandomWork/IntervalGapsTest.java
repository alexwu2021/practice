//package main.java.SomeRandomWork
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class IntervalGapsTest {
//
////    private IntervalGaps instance;
////    @Before
////    public void setUp() throws Exception {
////        instance = new IntervalGaps();
////    }
////
////
////    @After
////    public void tearDown() throws Exception {
////    }
////
////    @Test
////    public void findFreeInterval() {
////    }
////
////    @Test
////    public void merge() {
////        List<Interval> intervalList= new LinkedList<>();
////
////        List<Interval>res = new LinkedList<>();
////
//////        intervalList.add(new Interval(2, 7));
//////        intervalList.add(new Interval(1, 3));
//////        intervalList.add(new Interval(8, 13));
//////        res =  instance.merge(intervalList);
//////        assert (res != null && res.size() == 2 && res.get(0).end == 7);
//////        assert (res != null && res.size() == 2 && res.get(1).end == 13);
////
////
////        intervalList.clear();
////        intervalList.add(new Interval(1, 3));
////        intervalList.add(new Interval(2, 6));
////        intervalList.add(new Interval(8, 10));
////        intervalList.add(new Interval(15, 18));
////        res =  instance.merge(intervalList);
////
////        assert (res != null && res.size() == 3 && res.get(1).end == 10);
////        assert (res != null && res.size() == 3 && res.get(2).end == 18);
////
////    }
//}