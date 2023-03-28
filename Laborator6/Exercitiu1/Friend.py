import Contact

class Friend(Contact):
    def __init__(self,name,email,phone,since):
        super().__init__(self,name,email,phone)
        self.since = since
      
    def print_info(self):
        super().print_info()
        print("Since: ", self.since)