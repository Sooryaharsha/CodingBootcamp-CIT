stock = [ ( "25-Jan-2001", 43.50, 25, 'CAT', 92.45 ),
( "25-Jan-2001", 42.80, 50, 'DD', 51.19 ),
( "25-Jan-2001", 42.10, 75, 'EK', 34.87 ),
( "25-Jan-2001", 37.58, 100, 'GM', 37.58 )
]

def total_purchase_price(stock):
    total = 0
    for purchase_date, purchase_price, shares, ticker_symbol, current_price in stock:
        total += shares*purchase_price
    return total

def total_value(stock):
    total = 0
    for purchase_date, purchase_price, shares, ticker_symbol, current_price in stock:
        total += shares*purchase_price + shares*current_price
    return total

def sort_by_current_price(stock):
    return sorted(stock, key = lambda tup: tup[4])

def sort_by_total_value(stock):
    return sorted(stock, key = lambda tup: shares*tup[1]+shares*tup[4], reverse=True)

print(total_purchase_price(stock))
print(total_value(stock))
print(sort_by_current_price(stock))
print(sort_by_total_value(stock))