import operator

class GenericFile:
    def __init__(self,path,freq):
        self.path = path
        self.freq = freq
        
    def get_path():
        raise NotImplementedError

    def get_freq():
        raise NotImplementedError

    