# Kotlin Java Pyhon Bash    


class FileHandler():
    def __init__(self, succesor):
        self.succesor = succesor

    def can_handle(self,filename):
        raise NotImplementedError

    def handle_file(self,filename):
        self.can_handle(filename)


class KotlinFileHandler(FileHandler):
    def can_handle(self, filename):
        with open(filename,'r') as f:
            contents = f.read()

            if 'fun ' in contents or 'when ' in contents:
                return True
            
        return False
    
class PythonFileHandler(FileHandler):
    def can_handle(self, filename):
        with open(filename,'r') as f:
            contents = f.read()

            if 'def main' in contents:
                return True
            
        return False