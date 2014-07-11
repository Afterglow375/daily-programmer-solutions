# Daily Programmer #123 [Easy] Sum Some Digits
# Problem: http://bit.ly/11CEleX

# Python 3.3
# Date: 4/27/13
# Description: Finds the digital root of a number.
 
###############################################################
 
def digitalRoot():
    number = input("Enter a number: ")
    _digitalRootHelper(number)
 
def _digitalRootHelper(number): # treats number as a string
    if (len(number) == 1):
        print(number)
        return 0
    sum = 0
    for digit in number:
        sum += int(digit)
    _digitalRootHelper(str(sum))