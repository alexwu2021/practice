package CommonTypes;

public class Interval  implements  Comparable<Interval>
{
    public int start;
    public int end;
    public Interval(int s, int e) { start = s; end = e; }

    @Override
    public int compareTo(Interval o) {
        return (this.start == o.start ) ? this.end - o.end : this.start - o.start;
    }
}


