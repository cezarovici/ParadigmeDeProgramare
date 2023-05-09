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

def sort():
    vector = generateRandom()
    vector.sort()
    vector= list(filter(is_prime,vector))
    print(vector)
    

def ver_1(vector):
    thread_1 = threading.Thread(target=sort)
    thread_2 = threading.Thread(target=sort)
    thread_1.start()
    thread_2.start()
    thread_1.join()
    thread_2.join()

def ver_2(vector):
    sort()
    sort()

def ver_3(vector):
    process_1 = multiprocessing.Process(target=sort)
    process_2 = multiprocessing.Process(target=sort)
    process_1.start()
    process_2.start()
    process_1.join()
    process_2.join()

def ver_4(vector):
    with ThreadPoolExecutor(max_workers=2) as executor:
        future = executor.submit(sort())
        future = executor.submit(sort())


if __name__ == '__main__':
    start = time.time()
    ver_1()
    end = time.time()
    print("\n Timp executie pseudoparalelism cu GIL")
    print(end - start)
    start = time.time()
    ver_2()
    end = time.time()
    print("\n Timp executie secvential")
    print(end - start)
    start = time.time()
    ver_3()
    end = time.time()
    print("\n Timp executie paralela cu multiprocessing")
    print(end - start)
    start = time.time()
    ver_4()
    end = time.time()
    print("\n Timp executie paralela cu concurrent.futures")
    print(end - start)
