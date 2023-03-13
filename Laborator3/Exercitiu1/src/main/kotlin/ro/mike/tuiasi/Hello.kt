class Birth(val year: Int, val Month: Int, val Day: Int){
    override fun toString() : String{
        return "($Day.$Month.$year)"
    }
}

enum class SearchOption{
    byPhone,byName
}

// val -> var ( variable / mutable )
class Contact(val Name: String, var Phone: String, val BirthDate: Birth){
    fun Print() {
        println("Name: $Name, Mobile: $Phone, Date: $BirthDate")
    }

    fun NewPhoneNumber( newPhoneNumber: String) {
        Phone = newPhoneNumber
    }
}

fun Search(contacts: List<Contact>, toSearch: String,option:SearchOption) {
    when (option){
        SearchOption.byPhone -> {
            for (person in contacts){
                if(person.Phone == toSearch){
                    print("There is a person with this number and it is: ")
                    person.Print()
                }
            }
        }
        SearchOption.byName -> {
            for (person in contacts){
                if(person.Name == toSearch){
                    print("There is a person with this name and it is: ")
                    person.Print()
                }
            }
        }
    }
}

fun main(args : Array<String>){
    val agenda = mutableListOf<Contact>()
    agenda.add(Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    agenda += Contact("George", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Liviu" , "0231450211", Birth(1999, 7, 30))
    agenda += Contact("Popescu", "0211342787", Birth(1955, 5, 12))

//    for (persoana in agenda){
//        persoana.Print()
//    }


    Search(agenda,"Mihai",SearchOption.byName)
    Search(agenda,"0231450211",SearchOption.byPhone)


//    println("Agenda dupa eliminare contact [George]:")
//    agenda.removeAt(1)
//    for (persoana in agenda){
//        persoana.Print()
//    }
//
//    agenda.remove(Contact("Liviu" , "0231450211", Birth(1999, 7, 30)))
//    println("Agenda dupa eliminare contact [Liviu]:")
//
//    agenda.removeAt(1)
//    for (persoana in agenda){
//        persoana.Print()
//    }
}