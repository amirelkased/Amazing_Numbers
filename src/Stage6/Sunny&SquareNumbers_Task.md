# Description

N is a sunny number if N+1 is a perfect square number. In mathematics, a square number or a perfect square is an integer
that is the square of an integer; in other words, it is the product of an integer with itself. For example, 9 is a
square number, since it equals 32 and can be written as 3×3.

Our program can search for Spy and Palindromic numbers. What if we want to find all even Spy numbers? Or find all odd
numbers among Palindromic numbers? Are there any Palindromics that are also Spies? In this stage, you will add the
ability to search for several properties at once!

What if a user enters the same property twice by mistake? For example, they want to find all even numbers that are even?
Just ignore this duplicate property. What about two mutually exclusive properties? For example, if a user wants to find
even numbers that are odd. In this case, the program will initiate the search, but there are no such numbers. We need to
make our program foolproof. If a request contains mutually exclusive properties, the program should abort this request
and warn the user. There are three pairs of mutually exclusive properties. A request cannot include Even and Odd, Duck
and Spy, Sunny and Square numbers.

# Objectives

Your program should process the user requests. In this stage, your program should:


Welcome users;
Display the instructions;
Ask for a request;
If a user enters zero, terminate the program;
If numbers are not natural, print the error message;
If an incorrect property is specified, print the error message and the list of available properties;
For one number, calculate and print the properties of the number;
For two numbers, print the list of numbers with their properties;
For two numbers and one property, print the numbers with this property only;
For two numbers and two properties, print the numbers that have both properties.
If a user specifies mutually exclusive properties, abort the request and warn a user.
Once a request has been processed, continue execution from step 3.
In the current stage, the property names include even, odd, buzz , duck, palindromic , gapful , spy, square, and sunny.
The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like. Please,
add the information below:

Instructions
Supported requests:

- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
    * the first parameter represents a starting number;
    * the second parameter shows how many consecutive numbers are to be printed;
- two natural numbers and a property to search for;
- two natural numbers and two properties to search for;
- separate the parameters with one space;
- enter 0 to exit.
  Error messages
  The first parameter should be a natural number or zero.
  The second parameter should be a natural number.
  The property [SUN] is wrong.
  Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]
  The properties [HOT, SUN] are wrong.
  Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]
  The request contains mutually exclusive properties: [ODD, EVEN]
  There are no numbers with these properties.
  Examples
  The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1:

Welcome to Amazing Numbers!

Supported requests:

- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
    * the first parameter represents a starting number;
    * the second parameters show how many consecutive numbers are to be processed;
- two natural numbers and two properties to search for;
- separate the parameters with one space;
- enter 0 to exit.

Enter a request: > 1

Properties of 1
buzz: false
duck: false
palindromic: true
gapful: false
spy: true
square: true
sunny: false
even: false
odd: true

Enter a request: > 1 8 square

               1 is palindromic, spy, square, odd
               4 is palindromic, spy, square, even
               9 is palindromic, spy, square, odd
              16 is square, even
              25 is square, odd
              36 is square, even
              49 is buzz, square, odd
              64 is square, even

Enter a request: > 1 7 sunny

               3 is palindromic, spy, sunny, odd
               8 is palindromic, spy, sunny, even
              15 is sunny, odd
              24 is sunny, even
              35 is buzz, sunny, odd
              48 is sunny, even
              63 is buzz, sunny, odd

Enter a request: > 1 7 sunny square

The request contains mutually exclusive properties: [SQUARE, SUNNY]
There are no numbers with these properties.

Enter a request: > 1 2 sunny polindromic

The property [POLINDROMIC] is wrong.
Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]

Enter a request: > 1 2 sunny palindromic

               3 is palindromic, spy, sunny, odd
               8 is palindromic, spy, sunny, even

Enter a request: 0

Goodbye!

Process finished with exit code 0