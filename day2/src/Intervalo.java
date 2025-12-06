public class Intervalo {
    long a;
    long b;
    private long sum;

    public Intervalo(long a, long b) {
        this.a = a;
        this.b = b;
        this.sum = 0;
    }

    public long getSumIdInvalidos() {
        for (long i = a; i <= b; i++) {
            String strI = String.valueOf(i);
            if (strI.length() % 2 != 0) {
                continue;
            }
            if (strI.substring(0, (strI.length() / 2)).equals(strI.substring(strI.length() / 2))) {
                sum += Long.parseLong(strI);
//                IO.println(strI);
            }
        }
        return sum;
    }

}
