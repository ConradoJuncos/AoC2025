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

        // Parte 1
        IO.println("Accessible Rolls: " + pt1(map));

        // Parte 2
        IO.println("Accessible Rolls 2: " + pt2(map));

    } catch (Exception e) {
        IO.println("Excepcion: " + e.getMessage());
    }
}

long pt2(List<List<String>> map) {
    long accessibleRolls = 0;
    long changedRolls = 0;
    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    // Crear un array secundario con todos los elementos del original, para modificarlo sin tocar el real
    List<List<String>> newMap = new ArrayList<>(map);
    for (int i = 0; i < map.size(); i++) {
        for (int j = 0; j < map.getFirst().size(); j++) {
            int adjacentRolls = 0;
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (newI < 0 || newI > map.size() - 1) {
                    continue;
                }
                if (newJ < 0 || newJ > map.getFirst().size() - 1) {
                    continue;
                }
                if (map.get(newI).get(newJ).equals("@")) {
                    adjacentRolls++;
                }
            }
            if (adjacentRolls < 4 && map.get(i).get(j).equals("@")) {
                accessibleRolls++;
                changedRolls++;
                newMap.get(i).set(j, ".");
            }
        }
    }
    if (changedRolls == 0) {
        return 0;
    } else {
        return accessibleRolls + pt2(newMap);
    }
}

int pt1(List<List<String>> map) {
    int accessibleRolls = 0;
    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    for (int i = 0; i < map.size(); i++) {
        for (int j = 0; j < map.getFirst().size(); j++) {
            int adjacentRolls = 0;
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (newI < 0 || newI > map.size() - 1) {
                    continue;
                }
                if (newJ < 0 || newJ > map.getFirst().size() - 1) {
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
    return accessibleRolls;
}