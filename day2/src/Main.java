void main() {
    try (FileReader f = new FileReader("day2/src/resources/input")) {
        String instructionsString = f.readAllAsString();
        String[] instructions = instructionsString.split(",");

        long sum = 0;
        for (String i : instructions) {
            String[] ranges = i.split("-");
            List<String> rangesList = Arrays.stream(ranges).toList();
            Intervalo intervalo = new Intervalo(Long.parseLong(rangesList.get(0)), Long.parseLong(rangesList.get(1)));
            sum += intervalo.getSumIdInvalidos();
        }
        IO.println("Suma: " + sum);

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}