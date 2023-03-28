from ContactList import ContactList

class Agenta:
    all_contacts = ContactList()

    def add(self, item):
        self.agenda.append(item)

    def print_agenda(self):
        for item in self.agenda:
            print(item)

