import math

def minimax(graph, node, depth, maximizing_player):
    if depth == 0 or node not in graph:
        # Reached a leaf node or maximum depth, return the maximum value from the list
        return max(int(node), 0)
    
    if maximizing_player:
        max_value = -math.inf
        for neighbor in graph[node]:
            value = minimax(graph, neighbor, depth - 1, False)
            max_value = max(max_value, value)
        return max_value
    else:
        min_value = math.inf
        for neighbor in graph[node]:
            value = minimax(graph, neighbor, depth - 1, True)
            min_value = min(min_value, value)
        return min_value

# Example graph
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E', 'F'],
    'C': ['G', 'H', 'I'],
    'D': ['J', 'K'],
    'E': ['L'],
    'F': ['M', 'N', 'O'],
    'G': ['P'],
    'H': ['Q', 'R'],
    'I': ['S', 'T', 'U'],
    'J': ['4', '3', '5'],
    'K': ['2', '1'],
    'L': ['4', '2', '3'],
    'M': ['5', '4'],
    'N': ['7'],
    'O': ['3', '2'],
    'P': ['1', '4', '0'],
    'Q': ['5', '3'],
    'R': ['0'],
    'S': ['2', '7', '4'],
    'T': ['3', '6'],
    'U': ['5', '3', '1'],
}

# Run the Minimax algorithm with a depth of 4, starting from node 'A'
result = minimax(graph, 'A', 4, True)
print("Minimax result:",result)
