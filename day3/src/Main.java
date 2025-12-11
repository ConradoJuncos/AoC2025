void main() {

    try (BufferedReader f = new BufferedReader(new FileReader("resources/input3"))) {
        List<String> allLines = f.readAllLines();
        long joltageSum = 0;
        for (String line : allLines){
            BatteryBank b = new BatteryBank(line);
            joltageSum += b.getMaxJoltage();
        }
        IO.println("Joltage sum: " + joltageSum);

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}