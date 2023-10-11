def is_safe(node, color, graph, color_map):
    for neighbor in graph[node]:
        if color_map[neighbor] == color:
            return False
    return True

def color_map_backtracking(graph, colors, node, color_map):
    if node == len(graph):
        return True

    for color in colors:
        if is_safe(node, color, graph, color_map):
            color_map[node] = color
            if color_map_backtracking(graph, colors, node + 1, color_map):
                return True
            color_map[node] = None

    return False

def solve_map_coloring(graph, colors):
    color_map = [None] * len(graph)
    if color_map_backtracking(graph, colors, 0, color_map):
        return color_map
    return None

# Example usage:
graph = {
    0: [1, 2],
    1: [0, 2, 3],
    2: [0, 1, 3],
    3: [1, 2]
}
colors = ['Red', 'Green', 'Blue']

solution = solve_map_coloring(graph, colors)
if solution:
    print("Solution found:")
    for node, color in enumerate(solution):
        print(f"Node {node}: {color}")
else:
    print("No solution found.")
