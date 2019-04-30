package CommonTypes;

public class Interval  implements  Comparable<Interval> //Integer
{
    public int start;
    public int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }

    @Override
    public int compareTo(Interval o) {
        return (this.start == o.start ) ? this.end - o.end : this.start - o.start;
    }
}


