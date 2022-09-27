# Description
A number is a Jumping number if the adjacent digits inside the number differ by 1. The difference between 9 and 0 is not considered as 1. Single-digit numbers are considered Jumping numbers. For example, 78987, and 4343456 are Jumping numbers, but 796 and 89098 are not.

In this stage, we will also remove the limitation on pending properties in a request. The program knows how to calculate ten properties of numbers, and it would be strange to limit the query to just two properties. Let's remove this limitation. Let the program indicate all properties for all numbers in the request.

# Objectives
Your program should process the user requests. In this stage, your program should:
```
Welcome users;
Display the instructions;
Ask for a request;
If a user enters zero, terminate the program;
If numbers are not natural, print the error message;
If an incorrect property is specified, print the error message and the list of available properties;
For one number, print the properties of the number;
For two numbers, print the list of numbers with their properties.
For two numbers and properties, print the numbers with the specified properties;
If a user specifies mutually exclusive properties, abort the request and warn the user;
Once a request has been processed, continue execution from step 3.
```

In the current stage, the property names include `even, odd, buzz, duck, palindromic, gapful, spy, square, sunny, and jumping.` The test won't check the order of properties, their indentation, and spaces. You may format numbers as you like.

# Instructions
```
Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameter shows how many consecutive numbers are to be printed;
- two natural numbers and properties to search for;
- separate the parameters with one space;
- enter 0 to exit.
```
# Error messages

`The first parameter should be a natural number or zero.`

`The second parameter should be a natural number.`

```
The property [SUN] is wrong.
Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]
```

```
The properties [HOT, SUN] are wrong.
Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]
```

```
The request contains mutually exclusive properties: [SQUARE, SUNNY]
There are no numbers with these properties.
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
  * the second parameter shows how many consecutive numbers are to be processed;
- two natural numbers and properties to search for;
- separate the parameters with one space;
- enter 0 to exit.

Enter a request: > 1234567890

Properties of 1,234,567,890
        buzz: false
        duck: true
 palindromic: false
      gapful: true
         spy: false
      square: false
       sunny: false
     jumping: false
        even: true
         odd: false

Enter a request: > 1234567890 4

   1,234,567,890 is duck, gapful, even
   1,234,567,891 is odd
   1,234,567,892 is even
   1,234,567,893 is gapful, odd

Enter a request: > 1234567890 4 jumping

   1,234,567,898 is jumping, even
   2,101,010,101 is duck, jumping, odd
   2,101,010,121 is buzz, duck, gapful, jumping, odd
   2,101,010,123 is duck, jumping, odd

Enter a request: > 5000 5 duck spy

The request contains mutually exclusive properties: [DUCK, SPY]
There are no numbers with these properties.

Enter a request: > 5000 5 duck jumping

          10,101 is buzz, duck, palindromic, jumping, odd
          10,121 is duck, jumping, odd
          10,123 is duck, jumping, odd
          12,101 is duck, jumping, odd
          21,010 is duck, jumping, even

Enter a request: > 999 6 jumping odd palindromic

          10,101 is buzz, duck, palindromic, jumping, odd
          12,121 is palindromic, jumping, odd
          12,321 is palindromic, square, jumping, odd
          32,123 is buzz, palindromic, jumping, odd
          32,323 is palindromic, jumping, odd
          34,343 is palindromic, jumping, odd

Enter a request: 1 5 hot sunny

The property [HOT] is wrong.
Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, EVEN, ODD]

Enter a request: exit

The first parameter should be a natural number or zero.

Enter a request: 0

Goodbye!

Process finished with exit code 0
```
