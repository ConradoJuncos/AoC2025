void main(String[] args) {
    try (FileReader f = new FileReader("day2/src/resources/input")) {
        String instructionsString = f.readAllAsString();
        String[] instructions = instructionsString.split(",");

        long sum1 = 0;
        long sum2 = 0;
        for (String i : instructions) {
            String[] ranges = i.split("-");
            List<String> rangesList = Arrays.stream(ranges).toList();
            Intervalo intervalo = new Intervalo(Long.parseLong(rangesList.get(0)), Long.parseLong(rangesList.get(1)));
            sum1 += intervalo.getSumIdInvalidos1();
            sum2 += intervalo.getSumIdInvalidos2();
        }
        IO.println();
        IO.println("Suma 1: " + sum1);
        IO.println("Suma 2: " + sum2);
        IO.println();

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}