# COS360-Project
Basic calculator using a built parser.

###How to use###

Input an equation of any of the following operations: addition, subtraction, multiplication, division, and modulus. 
Input can contain parenthsis to indicate that what is inside should be solved first. 
Use Y/N (case sensitive) to answer yes or no questions as indicated when asked if you would like to quit. It will continue to prompt for new equations until you respond 'N'.

###How it works###

Parser is built by taking in user input as a string value and splitting all values into a list of type char. Values are then compared to a list of operators and parenthesis.
If not in the list of operators or parenthesis, it is converted into a double and then computed.
