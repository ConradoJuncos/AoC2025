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

//    public void move(String movement) {
//
//        switch (direction) {
//            case "L":
//                IO.println("DebugL: " + zeroCounter2);
//                int past_position = position;
//                position -= moves;
//                while (position < 0) {
//                    position = position + 100;
//                    if (past_position != 0) {
//                        zeroCounter2 += 1;
//                    }
//                }
//                break;
//            case "R":
//                position += moves;
//                while (position > 99) {
//                    if (position != 0) {
//                        zeroCounter2 += 1;
//                    }
//                    position = position - 100;
//                }
//                break;
//        }
//    }

    public void makeMove(String movementString) {
        String direction = movementString.substring(0, 1);
        int moves = Integer.parseInt(movementString.substring(1));

        switch (direction) {

            case "L":
                int lastPosition = position;
                IO.println("DL: " + zeroCounter2);
                position -= moves;
                if (position == 0) {
                    zeroCounter2 += 1;
                }
                while (position < 0) {
                    position += 100;
                    if (lastPosition != 0) {
                        zeroCounter2 += 1;
                    }
                    IO.println("DL: " + zeroCounter2);
                }
                IO.println("DL: " + zeroCounter2);
                break;

            case "R":
                IO.println("DR: " + zeroCounter2);
                position += moves;
                while (position > 99) {
                    position -= 100;
                    zeroCounter2 += 1;
                    IO.println("DR: " + zeroCounter2);
                }
                IO.println("DR: " + zeroCounter2);
                break;
        }

    }

    public int getZeroCounter1() {
        return zeroCounter1;
    }

    public int getZeroCounter2() {
        return zeroCounter2;
    }

}
