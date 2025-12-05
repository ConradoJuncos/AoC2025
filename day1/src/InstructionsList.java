import java.util.List;

public record InstructionsList(List<String> elements) {

    public Day1Iterator createIterator() {
        return new Day1Iterator(elements);
    }

}