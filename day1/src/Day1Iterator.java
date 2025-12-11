import java.util.List;

public class Day1Iterator {
    private int position;
    private final List<String> elements;
    private int zeroCounter1;
    private int zeroCounter2;

    public Day1Iterator(List<String> elements) {
        this.position = 50;
        this.elements = elements;
        this.zeroCounter1 = 0;
        this.zeroCounter2 = 0;
    }

    public void makeAllMovements() {
        for (String s : elements) {
            makeMove(s);
        }
    }

    public void makeMove(String movementString) {
        String direction = movementString.substring(0, 1);
        int steps = Integer.parseInt(movementString.substring(1));

        switch (direction) {
            case "L":
                makeLeftMove(steps);
                break;
            case "R":
                makeRightMove(steps);
                break;
        }
        if (position == 0) {
            zeroCounter1 += 1;
        }
    }

    public void makeLeftMove(int steps) {
        int lastPosition = position;
        position -= steps;
        while (position < 0) {
            position += 100;
            // Si la posicion anterior es 0, no suma la primera vuelta porque contabilizaria doble
            if (lastPosition != 0) {
                zeroCounter2 += 1;
            }
            // Setea lastPosition como 1 (distinto de 0) para que pueda entrar al if de arriba la proxima vez
            lastPosition = 1;
        }
        if (position == 0) {
            zeroCounter2 += 1;
        }
    }

    public void makeRightMove(int steps) {
        position += steps;
        if (position == 0) {
            zeroCounter2 += 1;
        }
//        while (position > 99) {
//            position -= 100;
//            zeroCounter2 += 1;
//        }
        int resto = position % 100;
        int div = position / 100;
        position = resto;
        zeroCounter2 += div;
    }

    public int getZeroCounter1() {
        return zeroCounter1;
    }

    public int getZeroCounter2() {
        return zeroCounter2;
    }

}
