// package designpatterns.lab4; 

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PipeAndFilter {

    public static void main(String[] args) {

        // List.of is a static method in Java that creates an immutable list (a list
        // that cannot be modified).
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create a pipeline
        List<Function<List<Integer>, List<Integer>>> filters = new ArrayList<>();

        // :: is a method reference operator which store/ save the refernce of a
        // specific method in the filters list

        filters.add(PipeAndFilter::filterEvenNumbers);
        filters.add(PipeAndFilter::squareNumbers);
        filters.add(PipeAndFilter::filterNumbersGreaterThanTen);
        filters.add(PipeAndFilter::filterNumbersLessThanFifty); // New filter added

        // Process the input through the pipeline
        List<Integer> result = processPipeline(input, filters);

        // Output the result after processing
        System.out.println(result);
    }

    // Process the input through the pipeline of filters
    private static List<Integer> processPipeline(List<Integer> input,
            List<Function<List<Integer>, List<Integer>>> filters) {

        List<Integer> output = input;

        // for (int i = 0; i < filters.size(); i++) {
        // Function<List<Integer>, List<Integer>> filter = filters.get(i); // Get the
        // function from the list
        // output = filter.apply(output); // Apply the function to the output list
        // }
        // return output;

        for (Function<List<Integer>, List<Integer>> filter : filters) {
            output = filter.apply(output);
        }
        return output;
    }

    // Filter to keep even numbers
    private static List<Integer> filterEvenNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Filter to square the numbers
    private static List<Integer> squareNumbers(List<Integer> input) {
        return input.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Filter to keep numbers greater than 10
    private static List<Integer> filterNumbersGreaterThanTen(List<Integer> input) {
        return input.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
    }

    // Keep numbers less than 50
    private static List<Integer> filterNumbersLessThanFifty(List<Integer> input) {
        return input.stream()
                .filter(n -> n < 50)
                .collect(Collectors.toList());
    }
}
