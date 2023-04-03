from GenericFile import GenericFile

class Binary(GenericFile):
    def get_path(self):
        return self.path 
     
    def get_freq(self):
        return self.freq
    
    def get_type(self):
        return "Binary"