class Contact():
    def __init__(self, name, phone, email, addr):
        self.name = name
        self.phone = phone
        self.email = email
        self.addr = addr

    def print_info(self):
        print("Name: ", self.name)
        print("Phone" , self.phone)
        print("Email: ", self.email)
        print("Address: ", self.addr)

    def __repr__(self):
        return "Name: " + self.name + "\n" + \
               "Phone: " + self.phone + "\n" + \
               "Email: " + self.email + "\n" + \
               "Address : " + self.addr
    



    