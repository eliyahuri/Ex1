# Ex1

This is my solution to Assignment 1 in the Java course at Ariel University. The goal was to create a number formatting converter and calculator for bases 2 to 16.

The project uses Maven for JUnit integration, as I faced issues running tests without it.

Below is a gif showcasing my battle with JUnit:

![Trying to make JUnit work](https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExa3IyMmlsd2xiZmxkODdlY25ubjRyMHVuZ2VjMTVhMWR4N2NyZnlxayZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/SfYTJuxdAbsVW/200.webp)

## Features

- Validate number formats for bases 2-16.
- Convert numbers to/from decimal.
- Perform addition and multiplication with base-specific output.
- Identify the maximum number in an array.

## Usage

1. Clone the repository and run `Ex1Main`.
2. Input numbers in supported formats (e.g., `1`, `0`, `1b10`, `0b10`).
3. Specify a base (2-16) for calculations.

### Example Output

```plaintext
Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
1
num1= 1 is number: true , value: 1
Enter a string as number#2 (or "quit" to end the program): 
0
num2= 0 is number: true , value: 0
Enter a base for output: (a number [2,16])
10
1 + 0 = 1b10
1 * 0 = 0b10
Max number over [1, 0, 1b10, 0b10] is: 1

Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
```

## Technologies

- Java
- Maven (JUnit for testing)

---