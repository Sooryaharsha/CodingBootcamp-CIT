
import random

POPULATION_SIZE = 200
BOARD_SIZE = 8


def fitness(solution):
    attacks = 0
    for i in range(BOARD_SIZE):
        for j in range(i+1, BOARD_SIZE):
            if solution[i] == solution[j] or abs(solution[i] - solution[j]) == j - i:
                attacks += 1
    return 1 / (attacks + 1)

def create_solution():
    return [random.randint(0, BOARD_SIZE-1) for i in range(BOARD_SIZE)]


def selection(population):
    return sorted(population, key=lambda x: fitness(x), reverse=True)[:int(0.2*POPULATION_SIZE)]


def crossover(parent1, parent2):
    pos = random.randint(1, BOARD_SIZE-1)
    child = parent1[:pos] + parent2[pos:]
    return child

def mutation(solution):
    pos = random.randint(0, BOARD_SIZE-1)
    solution[pos] = random.randint(0, BOARD_SIZE-1)
    return solution


def generate_initial_population():
    return [create_solution() for i in range(POPULATION_SIZE)]


def main():
    population = generate_initial_population()
    for i in range(100):
        population = selection(population)
        for j in range(POPULATION_SIZE-int(0.2*POPULATION_SIZE)):
            parent1 = random.choice(population)
            parent2 = random.choice(population)
            child = crossover(parent1, parent2)
            if random.random() < 0.1:
                child = mutation(child)
            population.append(child)
    solution = selection(population)[0]
    print("Solution:", solution)

if __name__ == '__main__':
    main()

