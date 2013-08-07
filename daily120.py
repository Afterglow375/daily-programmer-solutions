'''
Daily Programmer #120 [Hard] Bytelandian Exchange 3
Problem: http://bit.ly/10oUQAp
 
Python 3.3
Date: 4/27/13
Description: Bytelandian Currency consist of coins with positive integers on them.
    Machine 1 takes one coin of any value N. It pays back 3 coins of the values N/2, N/3 and N/4, rounded down.
              For example, if you insert a 19-valued coin, you get three coins worth 9, 6, and 4.
    Machine 2 takes two coins at once, one of any value N, and one of any positive value.
              It returns a single coin of value N+1.
 
These two machines can be used together to get arbitrarily large amounts of money from a single coin, provided it's worth enough.
If you can change an N-valued coin into an N-valued coin and a 1-valued coin, you can repeat the process to get arbitrarily many 1-valued coins.
What's the smallest N such that an N-valued coin can be changed into an N-valued coin and a 1-valued coin?
 
---Lowest coin found = 576 (not the best it seems)
 
###############################################################
'''
 
def machineOne(coin): # takes N (a coin)
    half = coin//2
    third = coin//3
    quarter = coin//4
    return (half, third, quarter)
 
def machineOneBreakDownStart(coin):                     # takes coin and breaks into 3 coins => a, b, c
    coinTuple = machineOne(coin)                        # each of three coins repeatedly put through machine one, yields x, y, z
    coinBreakdown0 = machineOneBreakDown(coinTuple[0])  # returns true if a+y+z, x+b+z or x+y+c is greater than the initial coin
    coinBreakdown1 = machineOneBreakDown(coinTuple[1])
    coinBreakdown2 = machineOneBreakDown(coinTuple[2])
    coinSum0 = coinTuple[0] + coinBreakdown1 + coinBreakdown2
    coinSum1 = coinTuple[1] + coinBreakdown0 + coinBreakdown2
    coinSum2 = coinTuple[2] + coinBreakdown0 + coinBreakdown1
    return coinSum0 > coin or coinSum1 > coin or coinSum2 > coin
 
def machineOneBreakDown(coin): # takes a coin and breaks it into a corresponding number of 1 value coins using machine 1
    coinTuple = machineOne(coin)
    sum = 0
 
    if 0 < coinTuple[0] < 3:
        sum += 1
    elif coinTuple[0] == 0:
        pass
    else:
        sum += machineOneBreakDown(coinTuple[0])
        
    if 0 < coinTuple[1] < 3:
        sum += 1
    elif coinTuple[1] == 0:
        pass
    else:
        sum += machineOneBreakDown(coinTuple[1])
 
    if 0 < coinTuple[2] < 3:
        sum += 1
    elif coinTuple[2] == 0:
        pass
    else:
        sum += machineOneBreakDown(coinTuple[2])
 
    return sum
        
def machineTwo(coin, coin2): # takes N and another coin of any positive value
    return coin+1
 
def allCoinTester():
    lowestSoFar = 897 # 897 works since it's the sample input in the problem
    for coin in range(897, 1, -1):
        print(coin)
        if machineOneBreakDownStart(coin):
            lowestSoFar = coin
    print(lowestSoFar)