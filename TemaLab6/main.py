import os

from collections import Counter
import statistics

from TextUNICODE import *
from TextASCII import *
from Binary import *

def type_of_file(file_path):
    if os.path.isfile(file_path):
        # deschide fișierul spre acces binar
        f = open(file_path, 'rb')
        try:
            # în content se va depune o listă de octeți
            content = f.read()                
        finally:
            f.close()

        total_chars = len(content)
        counter = Counter(content)
        frequencies = dict(counter)
    
        high_values = [counter[char] for char in range(256) 
                       if char in range(9,10)
                       or char == 13 
                       or char == 32 
                       or char in range(32,127)]
        
        low_values = [counter[char] for char in range (256)
                      if char in range(0,8)
                      or char in range (11,12)
                      or char in range (14,15)
                      or char == 31
                      or char in range(32,127)
                      ]
    
        # 48 code for 0 character...
        if content.count(ord('0')) / total_chars >= 0.3:
            print("Unicode")
            return TextUNICODE(file_path,frequencies)
                                
        if sum(high_values)/total_chars >= 0.9 or sum(low_values)/total_chars <= 0.1:
            print("ASCII")
            return TextASCII(file_path,frequencies)

        freq_list = list(frequencies.values())
        mean_freq = statistics.mean(freq_list)
        stdev_freq = statistics.stdev(freq_list)

        print(mean_freq,stdev_freq)

        threshold = 0.5  
        if stdev_freq <= threshold * mean_freq:
            print("Binary")
            return Binary(file_path,frequencies)
        




if __name__ == '__main__':
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))+"/searchDirectory"

    generic_files = []

    for root, subdirs, files in os.walk(ROOT_DIR):
        for file in os.listdir(root):
            file_path = os.path.join(root, file)

            generic_files.append(type_of_file(file_path))
            print(type_of_file(file_path),file_path)
          
    for element in generic_files:
        print(element.get_path())