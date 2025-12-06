void main() {
    // Main: el main
    // InstructionList: Guarda todos los movimientos que se deben realizar
    // Day1Iterator: Calcula la posicion del dial de la caja fuerte (cosas del enunciado)
    try (FileReader f = new FileReader("day1/src/resources/input")) {
        List<String> instructions = f.readAllLines();
        InstructionsList list = new InstructionsList(instructions);

        Day1Iterator i = list.createIterator();

        i.makeAllMovements();

        IO.println("Veces que quedó en cero: " + i.getZeroCounter1());
        IO.println("Pasos por cero: " + i.getZeroCounter2());

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}