Zohaib Ahmed
zoaib7ti@gmail.com

**Pipe and Filter Pattern in Java**

Overview
This codde demonstrates the **Pipe and Filter** architectural pattern using **Java streams and functional programming**. The implementation processes a list of integers through a series of filters (functions) that transform the data in steps.

    How It Works

- The program initializes a list of integers using `List.of(...)`.
- A list of functions (`filters`) is created to store multiple filter operations.
- These functions are applied **sequentially** to modify the data at each step.
- The final transformed list is printed as output.

  Code Breakdown
  **1. Creating the Input List**

```java
List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
```

- `List.of(...)` is a method that creates an **immutable list** (cannot be modified after creation).

  **2. Defining the Filters**

```java
List<Function<List<Integer>, List<Integer>>> filters = new ArrayList<>();
```

- `filters` is a list that stores **functions**.
- Each function processes a `List<Integer>` and returns a modified `List<Integer>`.

  **3. Adding Filter Functions**

```java
filters.add(PipeAndFilter::filterEvenNumbers);
filters.add(PipeAndFilter::squareNumbers);
filters.add(PipeAndFilter::filterNumbersGreaterThanTen);
filters.add(PipeAndFilter::filterNumbersLessThanFifty);
```

- `::` is the **method reference operator**.
- Functions (`filterEvenNumbers`, etc.) are **stored as references** in `filters`.
- These functions **execute later** when applied to data.

  **4. Processing the Pipeline**

```java
List<Integer> result = processPipeline(input, filters);
System.out.println(result);
```

- Calls `processPipeline()` to **apply all filters sequentially**.
- The modified list is printed.

  **5. Processing the Filters Sequentially**

```java
private static List<Integer> processPipeline(List<Integer> input, List<Function<List<Integer>, List<Integer>>> filters) {
    List<Integer> output = input;
    for (Function<List<Integer>, List<Integer>> filter : filters) {
        output = filter.apply(output);
    }
    return output;
}
```

- Iterates through each function in `filters`.
- Applies the function to the current list (`output`).
- Returns the **final transformed list**.

  **6. Individual Filters**
  Each filter performs a **specific transformation** on the list:

  **Filter 1: Keep Even Numbers**

```java
private static List<Integer> filterEvenNumbers(List<Integer> input) {
    return input.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
}
```

- Uses **Java Streams** to filter out **only even numbers**.

  **Filter 2: Square Each Number**

```java
private static List<Integer> squareNumbers(List<Integer> input) {
    return input.stream().map(n -> n * n).collect(Collectors.toList());
}
```

- Squares each number in the list using `.map(...)`.

  **Filter 3: Keep Numbers Greater than 10**

```java
private static List<Integer> filterNumbersGreaterThanTen(List<Integer> input) {
    return input.stream().filter(n -> n > 10).collect(Collectors.toList());
}
```

- Removes numbers **≤ 10** from the list.

  **Filter 4: Keep Numbers Less than 50**

```java
private static List<Integer> filterNumbersLessThanFifty(List<Integer> input) {
    return input.stream().filter(n -> n < 50).collect(Collectors.toList());
}
```

- Removes numbers **≥ 50** from the list.

  **Expected Output**
  After applying all filters sequentially, the output depends on the **order of execution**. Example:

```
[16, 36, 64, 100]
```

**Explanation:**

1. Keep even numbers → `[2, 4, 6, 8, 10]`
2. Square numbers → `[4, 16, 36, 64, 100]`
3. Keep numbers > 10 → `[16, 36, 64, 100]`
4. Keep numbers < 50 → `[16, 36]`

   **Conclusion**

- This program **demonstrates the Pipe and Filter pattern** using functional programming.
- It allows easy addition or removal of filters without modifying the main logic.
- Useful for **data transformation pipelines** in real-world applications.
