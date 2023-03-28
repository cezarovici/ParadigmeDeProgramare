class ContactList(list):
    def search(self,name):
        matchingContacts = []
        for contact in self:
            if name in contact.name:
                matchingContacts.append(contact)   

        return matchingContacts
    
    def addContact(self, contact):
        self.contacts.append(contact)
        
    def removeContact(self, contact):
        self.contacts.remove(contact)
        
    def showContacts(self):
        for contact in self.contacts:
            print(contact.name)