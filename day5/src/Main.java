void main() {
    try (BufferedReader f = new BufferedReader(new FileReader("resources/input5"))) {
        ArrayList<String> stringRanges = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();

        String newLine = f.readLine();
        while (!newLine.isEmpty()) {
            stringRanges.add(newLine);
            newLine = f.readLine();
        }
        newLine = f.readLine();
        while (newLine != null) {
            ids.add(newLine);
            newLine = f.readLine();
        }

        List<Range> ranges = stringRanges.stream().map(Range::new).toList();
        List<Boolean> parallelBooleanArray = ids.stream().map(e -> RangeChecker.idIsInARange(ranges, e)).toList();
        ArrayList<Long> pt1 = new ArrayList<>();
        for (int i = 0; i < parallelBooleanArray.size(); i++) {
            if (parallelBooleanArray.get(i)) {
                pt1.add(Long.parseLong(ids.get(i)));
            }
        }

        // pt 2

        long freshIngredients2 = 0;

        // 1 - Ordenar los rangos de menor a mayor por el valor start

        ArrayList<Range> clonedRanges = new ArrayList<>(ranges);
        Collections.sort(clonedRanges);

        // 2 - Iterar para combinar los rangos que se superpongan, hasta dejar solo rangos que no se superpongan

        for (int i = 0; i < clonedRanges.size() - 1; i++) {
            Range r1 = clonedRanges.get(i);
            Range r2 = clonedRanges.get(i+1);

            if (r1.getStart() == r2.getStart() && r1.getEnd() >= r2.getEnd()) {
                clonedRanges.remove(i+1);
                i = -1;
                continue;
            }

            if (r1.getStart() == r2.getStart() && r1.getEnd() < r2.getEnd()) {
                clonedRanges.remove(i);
                i = -1;
                continue;
            }

            if (r1.getStart() < r2.getStart() && r1.getEnd() >= r2.getEnd()) {
                clonedRanges.remove(i+1);
                i = -1;
                continue;
            }

            if (r1.getStart() <= r2.getStart() && r1.getEnd() <= r2.getEnd() && r1.getEnd() >= r2.getStart()) {
                r1.setEnd(r2.getEnd());
                clonedRanges.remove(i+1);
                i = -1;
            }
        }

        // 3 - Para cada rango: freshIngredients2 += (end - start) + 1

        for (Range range : clonedRanges) {
            IO.println(range);
            freshIngredients2 += (range.getEnd() - range.getStart() + 1);
        }

        IO.println("Fresh ingredients pt1: " + pt1.size());
        IO.println("Fresh ingredients pt2: " + freshIngredients2);

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}