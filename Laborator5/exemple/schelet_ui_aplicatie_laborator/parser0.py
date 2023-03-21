import os
import tkinter as tk
import pygubu


def prime(n):
    if n < 2:
        return False
    
    for i in range(2,n):
        if n % i == 0:
            return False
    return True


class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self, master):
        self.master = master
        # 1: Create a builder
        self.builder = builder = pygubu.Builder()

        # 2: Load an ui file
        ui_path = os.path.join(self.ROOT_DIR, 'parser0.ui')
        builder.add_from_file(ui_path)

        # 3: Create the widget using a master as parent
        self.parser = builder.get_object('Parser', master)

        self.add_list_btn = self.builder.get_object('add_list_btn')
        self.integer_list_text = self.builder.get_object('integer_list_text')
        self.filter_odd_btn = self.builder.get_object('filter_odd_btn')
        self.filter_primes_btn = self.builder.get_object('filter_primes_btn')
        self.sum_numbers_btn = self.builder.get_object('sum_numbers_btn')
        self.add_text_btn = self.builder.get_object('add_text_result')

        self.sum_numbers_btn['command'] = self.sum_numbers
        self.add_list_btn['command'] = self.add_list
        self.filter_odd_btn['command'] = self.filter_odd
        self.filter_primes_btn['command'] = self.filter_primes
        #self.add_text_btn['text']="cezar"
        

        builder.connect_callbacks(self)
        self.integer_list = None

    def add_list(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        self.printInUi(result)

    def filter_odd(self):
        result = self.integer_list_text.get("1.0",tk.END)
        result = result.strip().replace(' ','')
        result = [int(item) for item in result.split(',')]
        result = [item for item in result if item % 2 == 1]
        self.integer_list = result
        
        self.printInUi(result)

    def filter_primes(self):
        result = self.integer_list_text.get("1.0",tk.END)
        result = result.strip().replace(' ','')
        result = [int(item) for item in result.split(',')]
        
        result = [item for item in result if prime(item)]
        
        self.printInUi(result)

    def sum_numbers(self):
        result = self.integer_list_text.get("1.0",tk.END)
        result = result.strip().replace(' ','')
        result = [int(item) for item in result.split(',')]
        self.printInUi(result)

    def printInUi(self,content):
         self.add_text_btn.delete('1.0',tk.END)
         self.add_text_btn.insert('1.0',content)       
        


if __name__ == '__main__':
    root = tk.Tk()
    root.title('Exemplul 1 cu Tkinter si PyGubu')
    app = Parser(root)
    root.mainloop()
