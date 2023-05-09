import threading
import multiprocessing
from concurrent.futures import ThreadPoolExecutor

import time
import random
import math

def is_prime(n):
     if n <= 1:
         return False
     for i in range(2, int(math.sqrt(n)) + 1):
         if n % i == 0:
             return False
     return True

    
def generateRandom():
    return [random.randint(0,1000) for i in range(100)]

def sortare(vector):
    vector = vector.sort()

def filtru(vector):
    vector = list(filter(is_prime,vector))

def square(vector):
    vector = list([element*element for element in vector])

def ver_1(vector):
    thread_1 = threading.Thread(target=sortare,args=vector)
    thread_2 = threading.Thread(target=filtru,args=vector)
    thread_3 = threading.Thread(target=square,args=vector)
    thread_1.start()
    thread_2.start()
    thread_3.start()
    thread_1.join()
    thread_2.join()
    thread_3.join()
    print(vector)

def ver_2(vector):
    v1 = vector.copy()
    sortare(v1)
    filtru(v1)
    square(v1)
    print(v1)


def ver_3(vector):
    process_1 = multiprocessing.Process(target=sortare(vector))
    process_2 = multiprocessing.Process(target=filtru(vector))
    process_3 = multiprocessing.Process(target=square(vector))
    process_1.start()
    process_2.start()
    process_3.start()
    process_1.join()
    process_2.join()
    process_3.join()
    print(vector)


def ver_4(vector):
    with ThreadPoolExecutor(max_workers=3) as executor:
        future = executor.submit(sortare(vector))
        future = executor.submit(filtru(vector))
        future = executor.submit(square(vector))
    print(vector)


if __name__ == '__main__':
    vector = generateRandom()
    print(vector)
    sortare(vector)
    filtru(vector)
    print(vector)

    print("___________________")

    start = time.time()
    ver_1(generateRandom())
    end = time.time()
    print("\n Timp executie pseudoparalelism cu GIL")
    print(end - start)
    start = time.time()
    ver_2(generateRandom())
    end = time.time()
    print("\n Timp executie secvential")
    print(end - start)
    start = time.time()
    ver_3(generateRandom())
    end = time.time()
    print("\n Timp executie paralela cu multiprocessing")
    print(end - start)
    start = time.time()
    ver_4(generateRandom())
    end = time.time()
    print("\n Timp executie paralela cu concurrent.futures")
    print(end - start)
