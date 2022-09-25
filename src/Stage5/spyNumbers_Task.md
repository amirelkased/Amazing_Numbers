# Description
In this stage, we will add another property that is called a Spy number. A number is said to be Spy if the sum of all digits is equal to the product of all digits.

Our program calculates the properties of numbers, and also knows how to process a list of numbers. But what if we want to find numbers that have a certain property? For example, in case we want to find ten Buzz numbers starting from 1000. We need to add a new request feature for this. In addition, add a new property — Spy numbers. These numbers hide well, so beware. Your task is to modify the program so that it can search for these numbers.

# Objectives
Your program should process the user requests. In this stage, your program should:

```palintext
Welcome users;
Display the instructions;
Ask for a request;
If a user enters zero, terminate the program;
If numbers are not natural, print an error message;
If a user inputs an incorrect property, print the error message and the list of available properties;
For one number, print the properties of the number;
For two numbers, print the list of numbers with their properties;
For two numbers and a property, print the list of numbers and their properties filtered by the indicated property;
Once a request is processed, continue execution from step 3.
```

In the current stage, the property names include `even`, `odd`, `buzz`, `duck`, `palindromic` , `gapful`, and `spy`. The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like. Please, add the information below:

# Instructions
```
Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameter shows how many consecutive numbers are to be printed;
- two natural numbers and a property to search for;
- separate the parameters with one space;
- enter 0 to exit.
```

# Error messages

`The first parameter should be a natural number or zero.`

`The second parameter should be a natural number.`

```
The property [SUN] is wrong.
Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]
```

# Examples
The greater-than symbol followed by a space `(> )` represents the user input. Note that it's not part of the input.

# Example 1:

```cmd
Welcome to Amazing Numbers!

Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameters show how many consecutive numbers are to be processed;
- two natural numbers and a property to search for;
- separate the parameters with one space;
- enter 0 to exit.

Enter a request: 9

Properties of 9
        buzz: false
        duck: false
 palindromic: true
      gapful: false
         spy: true
        even: false
         odd: true

Enter a request: 9 7

               9 is palindromic, spy, odd
              10 is duck, even
              11 is palindromic, odd
              12 is even
              13 is odd
              14 is buzz, even
              15 is odd

Enter a request: 99 9 spy

             123 is spy, odd
             132 is gapful, spy, even
             213 is spy, odd
             231 is buzz, gapful, spy, odd
             312 is spy, even
             321 is spy, odd
           1,124 is spy, even
           1,142 is spy, even
           1,214 is spy, even

Enter a request: 9 3 drake

The property [DRAKE] is wrong.
Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]

Enter a request: 9 3 duck

              10 is duck, even
              20 is duck, even
              30 is duck, even

Enter a request: bye

The first parameter should be a natural number or zero.

Enter a request: 0

Goodbye!

Process finished with exit code 0
```
