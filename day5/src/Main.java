void main() {
    try (BufferedReader f = new BufferedReader(new FileReader("resources/input5"))) {
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();

        String newLine = f.readLine();
        while (!newLine.isEmpty()) {
            ranges.add(newLine);
            newLine = f.readLine();
        }
        newLine = f.readLine();
        while (newLine != null) {
            ids.add(newLine);
            newLine = f.readLine();
        }

        List<Range> newRanges = ranges.stream().map(Range::new).toList();
        List<Boolean> parallelBooleanArray = ids.stream().map(e -> RangeChecker.idIsInARange(newRanges, e)).toList();
        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < parallelBooleanArray.size(); i++) {
            if (parallelBooleanArray.get(i)) {
                result.add(Long.parseLong(ids.get(i)));
            }
        }

        IO.println(result.size());

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}