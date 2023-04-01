from GenericFile import GenericFile

class TextASCII(GenericFile):
    def get_path(self):
        return self.path_absolute 
     
    def get_freq(self):
        f = self.get_path.read()
        try:
            content = open(f, 'rb')
        finally:
            f.close()
            
        freq = {}   
   
        for char in content:
            freq[char] = GenericFile.operator.countOf(content,char)

        return freq


file: GenericFile = TextASCII("path")