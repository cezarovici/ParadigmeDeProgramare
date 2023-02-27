import functions

_inputFile = "inputFile"

def main():
    content = functions.readFile(_inputFile)
    result = functions.removePunctuationMarks(content)

    print(functions.numberFilter(result))

if __name__ == '__main__':
    main()