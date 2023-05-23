import types
import math
from functional import seq

def custom_zip(*iterables):
    return map(lambda *args: args, *iterables)

class int(int):
    def is_prime(self):
        return is_prime(self)

def before():
    print("Before")

def after():
    print("After")

def replacement(*args, **kwargs):
    print("Replacement")
    return "replaced"

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

class PascalCaseString(str):
    def to_pascal_case(self):
        words = self.split()
        pascal_case_words = [word.capitalize() for word in words]
        return ''.join(pascal_case_words)


def run_example():
    # Exemplu 1 - Verificarea primalitatii
    print(int(5).is_prime)

    # Exemplu 2 - Convert to PascalCase
    input_str = input("Introduceți un șir de caractere: ")
    pascal_case_str = PascalCaseString(input_str).to_pascal_case()
    print(pascal_case_str)

    # Exemplu 3 - Implementarea functiei zip cu map
    numbers = [1, 2, 3]
    letters = ['a', 'b', 'c']
    result = custom_zip(numbers, letters)
    print(list(result))  # [(1, 'a'), (2, 'b'), (3, 'c')]

    # Exemplu 4 - Determinarea patratelor perfecte pare
    n = int(input("Introduceti valoarea lui n: "))
    squares = (x for x in range(n) if int(math.sqrt(x)) ** 2 == x)
    perfect_squares = filter(lambda x: x % 2 == 0, squares)
    print(list(perfect_squares))

    # Exemplu 5 - Eliminarea caracterelor duplicate dintr-un string
    input_str = list(input("Introduceți un șir de caractere: "))
    unique_chars = seq(input_str).distinct()
    print(unique_chars)

    # Exemplu 6 - Micșorarea unui string 
    input_str = input("Introduceți un șir de caractere: ")
    compressed_str = seq(input_str).map(lambda g: g.key + (str(len(g)) if len(g) > 1 else ""))
    print(compressed_str)


if __name__ == "__main__":
    run_example()
