import GenericFile

class Binary(GenericFile):
    path_absolute = None
    frequency = None

    def get_path(self):
        return self.path_absolute
     
    def get_freq(self):
        return self.frequency