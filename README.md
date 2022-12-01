Create a Program that will accept an equation as input from the user using standard algebraic format.

Examples:\
N O N (ENTER)\
(N O N) O N (ENTER)\
( ( ( N  O N O N ) O N O ( N O N ) O N ) O N ) O N (ENTER)

where N is a number and O is either a math or logical comparison operator. Each token is separated by a space. The entire entry must be entered as a single input with one enter key click.

The Math operators that must be accepted are:\
+ addition
- subtraction
* multiplication\
/ division\
% modulus

The comparison operators are:\
== equals\
!= not equals\
@= absolute value of both are equal\
< less than\
<= less than or equals\
> greater than
>= greater than or equals

The use of math operators will cause the resulting number to be displayed.

Numbers (N) in the equation may be positive or negative. ie: 3 / -2

The use of a comparison will cause "True" of "False" to be displayed.

Allow the user to repeat the inputting of expressions as many times as they would like. The program must not fail due to improper user input, so, you must catch error exceptions and handle them.
