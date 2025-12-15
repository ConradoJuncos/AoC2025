import java.util.ArrayList;
import java.util.List;

public class BatteryBank {
    final List<Integer> batteries = new ArrayList<>();

    public BatteryBank(String line) {
        for (int i = 0; i < line.length(); i++) {
            batteries.add(Integer.parseInt(line.substring(i, i + 1)));
        }
    }

    public Long nDigitMaxJoltage(int digits) {
        StringBuilder result = new StringBuilder();

        int latestAddedPosition = -1;
        for (int i = 0; i < digits; i++) {
            int maxValue = -1;

            // Busca el numero mas grande en el rango de digitos no agregados todavía
            for (int j = latestAddedPosition + 1; j <= batteries.toArray().length - digits + i; j++) {
                if (batteries.get(j) > maxValue) {
                    maxValue = batteries.get(j);
                    latestAddedPosition = j;
                }
            }

            result.append(maxValue);
        }
        return Long.parseLong(result.toString());
    }
}
