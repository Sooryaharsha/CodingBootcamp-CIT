def print_board(board):
    for row in board:
        print(" | ".join(row))
        print("-" * 9)


def initialize_board():
    board = [[" " for _ in range(3)] for _ in range(3)]
    return board


def make_move(board, row, col, player):
    board[row][col] = player


def is_valid_move(board, row, col):
    if 0 <= row < 3 and 0 <= col < 3:
        if board[row][col] == " ":
            return True
    return False


def is_board_full(board):
    for row in board:
        if " " in row:
            return False
    return True


def has_won(board, player):
    # Check rows
    for row in board:
        if row.count(player) == 3:
            return True

    # Check columns
    for col in range(3):
        if board[0][col] == board[1][col] == board[2][col] == player:
            return True

    # Check diagonals
    if board[0][0] == board[1][1] == board[2][2] == player:
        return True
    if board[0][2] == board[1][1] == board[2][0] == player:
        return True

    return False


def evaluate(board):
    if has_won(board, "X"):
        return 1
    elif has_won(board, "O"):
        return -1
    else:
        return 0


def alpha_beta_pruning(board, depth, alpha, beta, is_maximizing):
    if has_won(board, "X"):
        return 1
    elif has_won(board, "O"):
        return -1
    elif is_board_full(board):
        return 0

    if is_maximizing:
        best_value = float("-inf")
        for row in range(3):
            for col in range(3):
                if is_valid_move(board, row, col):
                    make_move(board, row, col, "X")
                    value = alpha_beta_pruning(board, depth + 1, alpha, beta, False)
                    undo_move(board, row, col)
                    best_value = max(best_value, value)
                    alpha = max(alpha, best_value)
                    if beta <= alpha:
                        break
        return best_value
    else:
        best_value = float("inf")
        for row in range(3):
            for col in range(3):
                if is_valid_move(board, row, col):
                    make_move(board, row, col, "O")
                    value = alpha_beta_pruning(board, depth + 1, alpha, beta, True)
                    undo_move(board, row, col)
                    best_value = min(best_value, value)
                    beta = min(beta, best_value)
                    if beta <= alpha:
                        break
        return best_value


def get_best_move(board):
    best_value = float("-inf")
    best_move = None
    alpha = float("-inf")
    beta = float("inf")

    for row in range(3):
        for col in range(3):
            if is_valid_move(board, row, col):
                make_move(board, row, col, "X")
                value = alpha_beta_pruning(board, 0, alpha, beta, False)
                undo_move(board, row, col)

                if value > best_value:
                    best_value = value
                    best_move = (row, col)

    return best_move


def undo_move(board, row, col):
    board[row][col] = " "


def play_game():
    board = initialize_board()
    current_player = "X"

    while True:
        print_board(board)

        if current_player == "X":
            print("Player X turn:")
            row = int(input("Enter row (0-2): "))
            col = int(input("Enter column (0-2): "))

            if not is_valid_move(board, row, col):
                print("Invalid move. Try again.")
                continue

            make_move(board, row, col, current_player)

        else:
            print("Player O turn:")

            if is_board_full(board):
                print("The board is full. It's a draw!")
                break

            best_move = get_best_move(board)
            if best_move is None:
                print("No valid moves left. It's a draw!")
                break

            make_move(board, best_move[0], best_move[1], current_player)

        if has_won(board, current_player):
            print_board(board)
            print("Player", current_player, "wins!")
            break

        current_player = "O" if current_player == "X" else "X"


play_game()
