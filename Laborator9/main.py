import os
import abc
import json

class File(metaclass = abc.ABCMeta):   
    @abc.abstractmethod
    def read_from_stdin(self):
        self.__title = input("Title of the book: ")
        self.__author = input("Author of the book: ")
        number_of_pararaphs = int(input("Number of paragraphs: "))
        
        self.__paragraphs = []

        print("Enter paragraphs: ")
        while(number_of_pararaphs):
            line = (str(input("Line " + str(len(self.__paragraphs)) + ": ")))
            self.__paragraphs.append(line)
            number_of_pararaphs = number_of_pararaphs - 1
            
class JSONFile(File):
    file = vars(File)
    
    def read_from_stdin(self):
        return super().read_from_stdin()

    def print(self):
        print(json.dumps(self.file, indent = 4))

class HTMLFile(File):
    file = vars(File)
    
    def read_from_stdin(self):
        return super().read_from_stdin()

    def print(self):
        print("<html>")
        print("<head>")
        print("<title>" + self.file["_File__title"] + "</title>")
        print("</head>")
        print("<body>")
        print("<h1>" + self.file["_File__title"] + "</h1>")
        print("<h2>" + self.file["_File__author"] + "</h2>")
        print("<p>")
        for paragraph in self.file["_File__paragraphs"]:
            print(paragraph)
        print("</p>")
        print("</body>")
        print("</html>")

class TextFile(abc.ABCMeta,File):
    def __init__(self,template):
        self.template = template

    @abc.abstractmethod
    def print_text(self):
        pass

    def read_from_stdin(self):
        return super().read_from_stdin()


class Article(TextFile):
    def __init__(self,template):
        super().__init__(template)

    def print_text(self):
        print("Article")

class Blog(TextFile):
    def __init__(self,template):
        super().__init__(template)
        
    def print_text(self):
        print("Blog")

class FileFactory:
    def factory(self, file_type):
        if file_type == "JSON":
            return JSONFile()
        elif file_type == "HTML":
            return HTMLFile()
        elif file_type == "ARTICLE":
            return Article()
        elif file_type == "BLOG":
            return Blog()
        else:
            return None

if __name__ == "__main__":
  pass