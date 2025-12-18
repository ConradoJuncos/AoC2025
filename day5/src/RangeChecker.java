import java.util.List;

public class RangeChecker{
    public static boolean idIsInARange (List<Range> ranges, String id) {
        for (Range range : ranges) {
            if (range.getStart() <= Long.parseLong(id) && range.getEnd() >= Long.parseLong(id)) {
                return true;
            }
        }
        return false;
    }
}
