import itertools


def solve_cryptarithmetic():
    # Generate all possible permutations of digits 0 to 9
    digits = list(range(10))
    for permutation in itertools.permutations(digits):
        S = permutation[0]
        E = permutation[1]
        N = permutation[2]
        D = permutation[3]
        M = permutation[4]
        O = permutation[5]
        R = permutation[6]
        Y = permutation[7]

        # Skip if any leading digit is zero
        if S == 0 or M == 0:
            continue

        # Calculate the values for SEND, MORE, and MONEY
        SEND = S * 1000 + E * 100 + N * 10 + D
        MORE = M * 1000 + O * 100 + R * 10 + E
        MONEY = M * 10000 + O * 1000 + N * 100 + E * 10 + Y

        # Check if SEND + MORE equals MONEY
        if SEND + MORE == MONEY:
            return SEND, MORE, MONEY

    return None


# Solve the cryptarithmetic problem
solution = solve_cryptarithmetic()

# Check if a solution was found
if solution:
    SEND, MORE, MONEY = solution
    print("Solution:")
    print("  SEND =", SEND)
    print("  MORE =", MORE)
    print("  MONEY =", MONEY)
else:
    print("No solution found.")
