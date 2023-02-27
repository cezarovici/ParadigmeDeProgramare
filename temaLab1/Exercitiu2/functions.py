import string
import re

def readFile(path: str) -> str:
    inputFile = open(r"inputFile","r")

    return inputFile.read()


def removePunctuationMarks(content: str)-> str:
    return content.translate(str.maketrans('','',string.punctuation))

def removeExtraSpaces(content: str)->str:
    return re.sub(' +',' ',content)

def wordFilterByLenght(content: str) -> dict:
    wordDictionary = {}
    
    words = content.split()
 
    for word in words:
        wordLength = len(word)
        if wordLength not in wordDictionary:
            wordDictionary[wordLength] = [word]
        else:
            wordDictionary[wordLength].append(word)

    return wordDictionary

def numberFilter(content: str) -> str:
    return [int(i) for i in content.split() if i.isdigit()]

