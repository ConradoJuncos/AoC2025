public class Range {
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
}
