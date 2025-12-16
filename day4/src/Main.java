void main() {
    try (BufferedReader f = new BufferedReader(new FileReader("resources/input4"))) {
        // Leer el archivo y pasar la matriz
        List<List<String>> map = new ArrayList<>();
        String readLine;
        while (!Objects.equals(readLine = f.readLine(), null)) {
            List<String> line = new ArrayList<>();
            for (int i = 0; i < readLine.length(); i++) {
                line.add(readLine.substring(i, i+1));
            }
            map.add(line);
        }

        int accessibleRolls = 0;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < map.toArray().length; i++) {
            for (int j = 0; j < map.getFirst().toArray().length; j++) {
                int adjacentRolls = 0;
                for (int[] direction : directions) {
                    int newI = i + direction[0];
                    int newJ = j + direction[1];
                    if (newI < 0 || newI > map.toArray().length - 1) {
                        continue;
                    }
                    if (newJ < 0 || newJ > map.getFirst().toArray().length - 1) {
                        continue;
                    }
                    if (map.get(newI).get(newJ).equals("@")) {
                        adjacentRolls++;
                    }
                }
                if (adjacentRolls < 4 && map.get(i).get(j).equals("@")) {
                    accessibleRolls++;
                }
            }
        }
        IO.println("Accessible Rolls: " + accessibleRolls);

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}