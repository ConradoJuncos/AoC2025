public class Intervalo {
    long a;
    long b;
    private long sum1;
    private long sum2;

    public Intervalo(long a, long b) {
        this.a = a;
        this.b = b;
        this.sum1 = 0;
        this.sum2 = 0;
    }

    public long getSumIdInvalidos1() {
        for (long i = a; i <= b; i++) {
            String strI = String.valueOf(i);
            if (strI.length() % 2 != 0) {
                continue;
            }
            if (strI.substring(0, (strI.length() / 2)).equals(strI.substring(strI.length() / 2))) {
                sum1 += Long.parseLong(strI);
            }
        }
        return sum1;
    }

    public long getSumIdInvalidos2() {
        for (long i = a; i <= b; i++) {
            String strI = String.valueOf(i);
            if (idIsInvalid2(strI)) {
                sum2 += Long.parseLong(strI);
            }
        }
        return sum2;
    }

    public boolean idIsInvalid2(String strI) {
        boolean flag;
        // for que determina cuales son los strings a comparar
        for (int i = 1; i <= strI.length() / 2; i++) {
            // Substring base a comparar
            String comparingSubstring = strI.substring(0, i);

            flag = true;
            // for que compara el string con cada otro substring
            for (int j = 1; j < strI.length() / comparingSubstring.length(); j++) {
                // Flag = false si la longitud del string a comparar no es un multiplo de la longitud del string original
                if (strI.length() % comparingSubstring.length() != 0) {
                    flag = false;
                }
                // Substrings que comparo con el base
                String longString = strI.substring(comparingSubstring.length() * j, comparingSubstring.length() * (j + 1));
                // Si son distintos seteo flag a false y corto el ciclo
                if (!longString.equals(comparingSubstring)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        // Si ningun string a comparar devolvio true, entonces no cumple la condicion y retorna false
        return false;
    }
}