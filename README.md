# Expression-Trees
Expression Trees
Create an ExpressionTree class extending TreeNode and implementing the Expressions interface,
provided on the portal. The TreeNode class is provided by the book.
1. For the purposes of this assignment, the only operators will be ‘*’ and ‘+’
2. Write a method, buildTree, that will take in an array of strings in postfix notation order and build
and return an expression tree of type TreeNode
3. Write a recursive method, evalTree, that will evaluate the expression tree and return the answer.
4. Write the following recursive conversion methods that traverse the expression tree and return a
string in the appropriate notation
i. toPrefixNotation
ii. toInfixNotation, with appropriate parentheses
iii. toPostfixNotation
5. Write a method, postFixEval, that will take in an array of strings that is an expression in post-fix
notation and using a stack, evaluate the expression and return the answer
For testing, create a secondary class. All output should be to a file.
1. Take in a file name as the first command line argument, if an argument is not provided, assume the
filename is postFixExpressions.txt. If no argument is provided and the assumed filename cannot be
opened, prompt for a filename.
2. The file will have several expressions in postfix notation. The elements in the expressions will be
separated by a space. Read the expressions into an array of Strings. Each expression will be on a
separate line. The expressions will be valid postfix notation expressions, you do not need to check
for missing operators or operands.
3. For each expression
a. Create an expression tree
b. Evaluate the expression using your evalExp method and print the answer to the output file
c. Print the prefix, infix, and postfix notations in that order, each on its own line
d. Print the result of calling your postFixEval method
e. Print two blank lines
4. Create your own test file named myExpressions.txt, test your program with it and rename your
output to myAnswers.txt. Upload both of these files when you submit your assignment.
5. Using the test file provided, run your program, rename the output file to yourName_Expressions.txt.
Upload this file when you submit your assignment. This file will not be provided until the day before
the assignment is due and only after you have uploaded your test file.
6. Print your two java classes, the class test file, your test file, your output file along with your java
docs for your ExpressionTree class. Staple them together in that order and put them in my box no
later than the next school day after the due date.
DO NOT wait to start this program. Expect to encounter problems that you do not know how to solve
and leave yourself time to find the solutions. Work will not be accepted after the due date. You must 
Instructor Name: Teresa M. Kelly
HW Assignment #6
Expression Trees
Course: CSC 202
Semester: Fall 2017, Spring 2018
Due: March 9, 2018
turn in what you have as of 11:59 PM on the due date. I expect this assignment is the most difficult to
date.
Do not forget to turn in your pseudo code in the next day or two. Do not forget to write complete java
docs. Turn in your pseudo code when you have it done, make sure that I date-stamp it.
After you have turned in your pseudo-code, create your github repository and invite me to it.
Your tests are due BEFORE the program is due. You will not be provided the test file until you have
uploaded your test files.
By the due date/time, upload your code (2 classes), your test input file (again), and your two test output
files. Your ability to write thorough tests for your program will be included in your grade.
