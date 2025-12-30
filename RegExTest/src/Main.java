void main() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(4);
    a.add(5);

    a.remove(2);

    for (Integer i : a) {
        IO.println(i);
    }

}