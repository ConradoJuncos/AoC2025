import java.util.ArrayList;
import java.util.List;

public class BatteryBank {
    List<Integer> batteries = new ArrayList<>();

    public BatteryBank(String line) {
        for (int i = 0; i < line.length(); i++) {
            batteries.add(Integer.parseInt(line.substring(i, i + 1)));
        }
    }

    public int getMaxJoltage() {
        int firstHighestNumber = -1;
        int firstHighestNumberPosition = -1;
        int secondHighestNumber = -1;

        for (int i = 0; i < batteries.toArray().length - 1; i++) {
            if (batteries.get(i) > firstHighestNumber) {
                firstHighestNumber = batteries.get(i);
                firstHighestNumberPosition = i;
            }
        }
        for (int i = firstHighestNumberPosition + 1; i < batteries.toArray().length; i++) {
            if (batteries.get(i) > secondHighestNumber) {
                secondHighestNumber = batteries.get(i);
            }
        }

        return (Integer.parseInt(String.valueOf(firstHighestNumber) + String.valueOf(secondHighestNumber)));
    }
}
