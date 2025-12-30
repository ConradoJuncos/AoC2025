public class Range implements Comparable<Range> {
    long start;
    long end;

    public Range(String range) {
        String[] a = range.split("-");
        start = Long.parseLong(a[0]);
        end = Long.parseLong(a[1]);
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public int compareTo(Range o) {
        return Long.compare(this.getStart(), o.getStart());
    }

    @Override
    public String toString() {
//        return "Range: " +
//                "start=" +
//                start +
//                ", end=" +
//                end;
        return start+"|"+end;
    }
}
