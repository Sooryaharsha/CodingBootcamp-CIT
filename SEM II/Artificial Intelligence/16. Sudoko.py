def solve_sudoku(board):
    # Find the next empty cell (represented by 0)
    empty_cell = find_empty_cell(board)
    if not empty_cell:
        # No empty cells remain, puzzle solved
        return True

    row, col = empty_cell

    # Try placing numbers 1 to 9 in the empty cell
    for num in range(1, 10):
        if is_valid(board, num, row, col):
            # Number is valid, place it in the cell
            board[row][col] = num

            # Recursively solve the updated board
            if solve_sudoku(board):
                return True

            # Backtrack by resetting the cell if a solution is not found
            board[row][col] = 0

    # No valid number can be placed, backtrack to previous cell
    return False


def find_empty_cell(board):
    # Find the next empty cell represented by 0
    for row in range(9):
        for col in range(9):
            if board[row][col] == 0:
                return row, col
    return None


def is_valid(board, num, row, col):
    # Check if the number is valid in the given row, column, and box

    # Check row
    for i in range(9):
        if board[row][i] == num:
            return False

    # Check column
    for i in range(9):
        if board[i][col] == num:
            return False

    # Check box
    start_row = (row // 3) * 3
    start_col = (col // 3) * 3
    for i in range(start_row, start_row + 3):
        for j in range(start_col, start_col + 3):
            if board[i][j] == num:
                return False

    return True


def print_board(board):
    # Print the Sudoku board
    for i in range(9):
        for j in range(9):
            print(board[i][j], end=" ")
        print()


board = [
    [5, 3, 0, 0, 7, 0, 0, 0, 0],
    [6, 0, 0, 1, 9, 5, 0, 0, 0],
    [0, 9, 8, 0, 0, 0, 0, 6, 0],
    [8, 0, 0, 0, 6, 0, 0, 0, 3],
    [4, 0, 0, 8, 0, 3, 0, 0, 1],
    [7, 0, 0, 0, 2, 0, 0, 0, 6],
    [0, 6, 0, 0, 0, 0, 2, 8, 0],
    [0, 0, 0, 4, 1, 9, 0, 0, 5],
    [0, 0, 0, 0, 8, 0, 0, 7, 9],
]

print("Input Sudoku:")
print_board(board)
print()

if solve_sudoku(board):
    print("Solution:")
    print_board(board)
else:
    print("No solution exists for the given Sudoku puzzle.")
