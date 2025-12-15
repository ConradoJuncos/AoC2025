void main() {

    try (BufferedReader f = new BufferedReader(new FileReader("resources/input3"))) {
        List<String> allLines = f.readAllLines();
        long joltageSum2Digits = 0;
        long joltageSum12Digits = 0;
        for (String line : allLines){
            BatteryBank b = new BatteryBank(line);
            joltageSum2Digits += b.nDigitMaxJoltage(2);
            joltageSum12Digits += b.nDigitMaxJoltage(12);
        }
        IO.println("Joltage sum with 2 digits: " + joltageSum2Digits);
        IO.println("Joltage sum with 12 digits: " + joltageSum12Digits);

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}