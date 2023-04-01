import TextASCII

class XMLFile(TextASCII):
    first_tag = None

    def get_first_tag(self):
        return self.first_tag
    
