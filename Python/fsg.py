import os, sys, math, time
from random import *

#############################################################################
#   Flower Shop Game
 
#
#   A game that a customer can buy flowers and shop owner can manage the shop
#   Flowers are limited to rose, gardenia and lily
#   Events are limited to 4: Single Day Inflation, Weekend Sales, Mid Term Sales and Final Sales
#   Assuming all the costs and prices are constant and no tax
###############################################################################

day = 1
initialFund = 10000
flowerStocks = {}   # flower name to (quantity, cost)
flowerPrices = {}  # flower name to price
flowerSales = {}    # flower name to a list of sale record that is in the form of (quantity, price, day)

events = {  1:('\'Single Day Inflation\'', 'cost', 'up', .25), #event 1 will come in the first 5 days
            2:('\'Final Sales\'', 'price','down', .75), #event 2 is on the very last day
            3:('\'Mid Term Sales\'','price', 'down', .40), #event 3 will be the middle day(s) of the range
            4:('\'Weekend Sales\'', 'price', 'down', .10),  #event 4 is fixed on Saturday and Sunday
         }   
hasInflationEventHappened = False
flowerKindOfInteret = ''

def setupFlowerShop():
    flowerPrices['rose'] = 2.02
    flowerPrices['gardenia'] = 4.04
    flowerPrices['lily'] = 6.06
    flowerStocks['rose'] = (3000, 1.01)
    flowerStocks['gardenia'] = (2000, 2.02)
    flowerStocks['lily'] = (1000, 3.03)
                    
    flowerSales['rose'] = []
    flowerSales['gardenia'] = []
    flowerSales['lily']= []


def customerBuyFlower(kind, quantityOwnerBuy):
    global day
    cost = getCost(kind)
    price = getPrice(kind)
    print('\tAt day %d, customer to buy %d %s with price %.2f' % (day, quantityOwnerBuy, kind, price))
    doOneSale(kind, quantityOwnerBuy, cost, price, day, True)

def customerReturnFlower(kind, quantityCustomerReturn):
    global day
    cost = getCost(kind)
    price = getPrice(kind)
    print('\tAt day %d, customer to return %d %s with price %.2f' % (day, quantityCustomerReturn, kind, price))
    doOneSale(kind, quantityCustomerReturn, cost, price, day, False)

def ownerCheckStock():
    print('\tCurrently the flower shop has:')
    totalquantity = 0
    totalCost = 0.0
    for stock in flowerStocks:
        print('\t%s:    \t%d \t@ $%.2f' % (stock, flowerStocks[stock][0], flowerStocks[stock][1]))
        totalquantity += flowerStocks[stock][0]
        totalCost += flowerStocks[stock][0] * flowerStocks[stock][1]
    print('\tTotal quantity at hand:\t%d' % (totalquantity))
    print('\tTotal cost:\t$%.2f' % totalCost)

def ownerBuyStock(kind, quantityOwnerBuy):
    global day
    currentQuantity, cost = flowerStocks[kind]
    print('\tAt day %d, shop owner to buy %d %s at cost %.2f' % (day, quantityOwnerBuy, kind, cost))
    flowerStocks[kind] = (currentQuantity + quantityOwnerBuy, cost)

def ownerCheckSales():
    totalquantityitySold = 0
    totalSalesDollarAmount = 0.0
    totalCost = 0.0
    totalProfit = 0.0
    for kind in flowerSales:
        saleRecords = flowerSales[kind]
        for rec in saleRecords:
            totalquantityitySold += rec[0]
            totalSalesDollarAmount += rec[0] * rec[1]
            totalCost += rec[1] * getCost(kind)
    totalProfit = totalSalesDollarAmount - totalCost
    print('\tTotal sales amount:\t$%.2f' % (totalSalesDollarAmount))
    print('\tTotal quantity sold:\t%d' % totalquantityitySold)
    print('\tTotal cost:\t$%.2f' % (totalCost))
    print('\tTotal profit:\t$%.2f' % (totalProfit))

def getCost(flowerName):
    if flowerName in flowerStocks:
        return flowerStocks[flowerName][1]
    return -1

def getPrice(flowerName):
    if flowerName in flowerPrices:
        return flowerPrices[flowerName]
    return -1

def doOneSale(kind, quantity, cost, price, date, isBuy):
    msg = 'On day %d, sold %d %s @$%.2f with cost at $%.2f' % (date, quantity, kind, price, cost)
    print('\t' + msg)
    if isBuy:
        newQuantity = flowerStocks[kind][0] - quantity
        flowerSales[kind].append((quantity, price, date)) 
    else:
        newQuantity = flowerStocks[kind][0] + quantity
        flowerSales[kind].append((-1 * quantity, -1 * price, date)) 
    
    flowerStocks[kind] = (newQuantity, cost)

def getEvent(d):
    global hasInflationEventHappened
    if hasInflationEventHappened == False:
        if randint(1, 4) % 3 == 0:
            hasInflationEventHappened = True
            return 1
    if d == 30:
        return 2
    if d in (15, 16):
        return 3
    if day % 7 == 6 or day % 7 == 0:
        return 4
    return -1 #meaning no event

def simulateOneDayOnlineSale():
    global day
    print('\n-------On day %s-------' % day)
    evt = getEvent(day)
    costFactor = 1
    priceFactor = 1
    if evt != -1:
        print('\t*** We have %s event and %s will go %s by %d percent ***' % (events[evt][0], events[evt][1], events[evt][2], events[evt][3] * 100))
        if events[evt][1] == 'price':
            if events[evt][2] == 'down':
                priceFactor = 1 * (1 - float(events[evt][3]))
        elif events[evt][1] == 'cost':
            if events[evt][2] == 'up':
                costFactor = 1 * (1 + float(events[evt][3]))

    print('On day %s we have the following sales:' % day)
    for stock in flowerStocks:
        availableQuantity = int(flowerStocks[stock][0] / 4)  #only allow a quarter of the remaining goods for simulation
        if availableQuantity > 1:
            q = randint(1, availableQuantity)
            if q > 0 and q < flowerStocks[stock][0]: #sell only what the shop has
                cost = flowerStocks[stock][1] * costFactor
                price = flowerPrices[stock] * priceFactor
                doOneSale(stock, q, cost, price, day, True)
    day += 1

def simulate():
    print('\tNow the game is in simulation mode')
    print('\tWe will simulate 30 day sales')
    print('\tAnd simulate 4 event')
    secondToSleep = 2 #seconds
    numberOfDaysToSimulate = 30  #days
    n = 0
    while n < numberOfDaysToSimulate:
        simulateOneDayOnlineSale()
        ownerCheckStock()
        ownerCheckSales()
        time.sleep(secondToSleep)
        n += 1
    
def resetAll():
    global day
    global initialFund
    print('\tNow reset everything')
    flowerStocks.clear()
    flowerPrices.clear()
    flowerSales.clear()
    initialFund = 10000
    day = 1

def getQuantity():
    quantity = 0
    while True:
        try:
            userInput = str(input("Enter the quantity: ")).rstrip()
            quantity = int(userInput)
            print("Your choice is %s" % (userInput))
            break
        except:
            print ('Invalid quantity entered, please try again')
    return quantity

def getUserInput():
    userInput = str(input("Enter your choice: ")).rstrip()
    print("Your choice is %s" % (userInput))
    return userInput

def showMenu(option):
    if option == 'main':
        print('\n\t ***** Main Menu *****')
        print('\t 1 Customer Menu')
        print('\t 2 Shop Owner Menu')
        print('\t 3 Simulate the Game')
        print('\t 0 Exit')
        print('\t ********************\n')
    elif option == 'customer':
        print('\n\t ------ Customer Menu ------')
        print('\t 1 Buy flower')
        print('\t 2 Return flower')
        print('\t 9 Back to main menu')
        print('\t ------------------------\n')
    elif option == 'customer-buy-flower':
        print('\n\t ------ Customer Buy Flower Menu ------')
        print('\t 1 Rose')
        print('\t 2 Gardenia')
        print('\t 3 Lily')
        print('\t 9 Back to main menu')
        print('\t ------------------------\n')
    elif option == 'customer-return-flower':
        print('\n\t ------ Customer Return Flower Menu ------')
        print('\t 1 Rose')
        print('\t 2 Gardenia')
        print('\t 3 Lily')
        print('\t 9 Back to main menu')
        print('\t ------------------------\n')
    elif option == 'owner':
        print('\n\t ===== Shop Owner Menu =====')
        print('\t 1 Check stock')
        print('\t 2 Buy stock')
        print('\t 3 Check sales')
        print('\t 9 Back to main menu')
        print('\t ========================\n')
    elif option == 'owner-buy-stock':
        print('\n\t ===== Owner Buy Stock Menu =====')
        print('\t 1 Rose')
        print('\t 2 Gardenia')
        print('\t 3 Lily')
        print('\t 9 Back to main menu') 
        print('\t ========================\n')
    return option

def main():
    global flowerKindOfInteret
    setupFlowerShop()

    print('\tWelcome to Flower Shop Game')      
     
    print('\n\tGaming starting ...')        
    print("\n\tInitially You have $%.2f fund" % initialFund)
    ownerCheckStock()

    menuInDisplay = showMenu('main')
    while True:
        userInput = getUserInput()

        if menuInDisplay == 'main':
            if userInput == '1':
                menuInDisplay = showMenu('customer')
            elif userInput == '2':
                menuInDisplay = showMenu('owner')
            elif userInput == '3':
                simulate()
                resetAll()
                setupFlowerShop()
                menuInDisplay = showMenu('main')
            elif userInput == '0':
                answer = input('\nAre you sure to exit the game? (Yes or No)')
                if 'yes' in answer.rstrip().lower() :
                    break
                else:
                    print('Glad you stay, let us continue the game ...')
                    menuInDisplay = showMenu('main')
            else:
                print("Your input %s is invalid, please retry" % (userInput))
                menuInDisplay = showMenu('main')

        elif menuInDisplay == 'customer':
            if userInput == '1':
                menuInDisplay = showMenu('customer-buy-flower')
            elif userInput == '2':
                menuInDisplay = showMenu('customer-return-flower')
            elif userInput == '9':
                menuInDisplay = showMenu('main')
            else:
                print("Your input %s is invalid, please retry" % (userInput))
                menuInDisplay = showMenu('customer')
        elif menuInDisplay == 'customer-buy-flower':
            if userInput == '1':
                flowerKindOfInteret = 'rose'
                quantityCustomerBuy = getQuantity()
                customerBuyFlower(flowerKindOfInteret, quantityCustomerBuy)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('customer-buy-flower')
            elif userInput == '2':
                flowerKindOfInteret = 'gardenia'
                quantityCustomerBuy = getQuantity()
                customerBuyFlower(flowerKindOfInteret, quantityCustomerBuy)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('customer-buy-flower')
            elif userInput == '3':
                flowerKindOfInteret = 'lily'
                quantityCustomerBuy = getQuantity()
                customerBuyFlower(flowerKindOfInteret, quantityCustomerBuy)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('customer-buy-flower')
            elif userInput == '9':
                menuInDisplay = showMenu('customer')
            else:
                print("Your input %s is invalid, please retry" % (userInput))
                menuInDisplay = showMenu('customer-buy-flower')
        elif menuInDisplay == 'customer-return-flower':
            if userInput == '1':
                flowerKindOfInteret = 'rose'
                quantityCustomerReturn = getQuantity()
                customerReturnFlower(flowerKindOfInteret, quantityCustomerReturn)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('customer-return-flower')
            elif userInput == '2':
                flowerKindOfInteret = 'gardenia'
                quantityCustomerReturn = getQuantity()
                customerReturnFlower(flowerKindOfInteret, quantityCustomerReturn)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('customer-return-flower')
            elif userInput == '3':
                flowerKindOfInteret = 'lily'
                quantityCustomerReturn = getQuantity()
                customerReturnFlower(flowerKindOfInteret, quantityCustomerReturn)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('customer-return-flower')
            elif userInput == '9':
                menuInDisplay = showMenu('customer')
            else:
                print("Your input %s is invalid, please retry" % (userInput))
                menuInDisplay = showMenu('customer-return-flower')

        elif menuInDisplay == 'owner':
            if userInput == '1':
                ownerCheckStock()
                menuInDisplay = showMenu('owner')
            elif userInput == '2':
                menuInDisplay = showMenu('owner-buy-stock')
            elif userInput == '3':
                ownerCheckSales()
                menuInDisplay = showMenu('owner')
            elif userInput == '9':
                menuInDisplay = showMenu('main')
            else:
                print("Your input %s is invalid, please retry" % (userInput))
                menuInDisplay = showMenu('owner')
        elif menuInDisplay == 'owner-buy-stock':
            if userInput == '1':
                flowerKindOfInteret = 'rose'
                quantityOwnerBuy = getQuantity()
                ownerBuyStock(flowerKindOfInteret, quantityOwnerBuy)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('owner-buy-stock')
            elif userInput == '2':
                flowerKindOfInteret = 'gardenia'
                quantityOwnerBuy = getQuantity()
                ownerBuyStock(flowerKindOfInteret, quantityOwnerBuy)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('owner-buy-stock')
            elif userInput == '3':
                flowerKindOfInteret = 'lily'
                quantityOwnerBuy = getQuantity()
                ownerBuyStock(flowerKindOfInteret, quantityOwnerBuy)
                flowerKindOfInteret = ''
                menuInDisplay = showMenu('owner-buy-stock')
            elif userInput == '9':
                menuInDisplay = showMenu('owner')
            else:
                print("Your input %s is invalid, please retry" % (userInput))
                menuInDisplay = showMenu('owner-buy-stock')

    print('The game will end ...')
    time.sleep(2)

################################################################
main()

