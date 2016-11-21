import sys
from functools import reduce

def fibonacci_recursive(position):
    if position == 1:
        return [1]
        
    elif position == 2:
        return [1, 1]

    series = fibonacci_recursive(position-1)
    return series + [series[-1] + series[-2]]

def fibonacci_iterative_mutable(position):
    fib_sequence = []

    if position >= 1:
        fib_sequence.append(1)

    if position >= 2:
        fib_sequence.append(1)

    for _ in range(2, position):
        fib_sequence.append(fib_sequence[-1] + fib_sequence[-2])

    return fib_sequence
  
def fibonacci_iterative_immutable(position):
    return reduce(lambda sequence, _: sequence + [sequence[-1] + sequence[-2]], range(position - 2), [1, 1])

if len(sys.argv[1]):
    nth_term = int(sys.argv[1])
  
    print(fibonacci_iterative_mutable(nth_term))

    print(fibonacci_iterative_immutable(nth_term))

    print(fibonacci_recursive(nth_term))