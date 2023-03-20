package ro.mike.tuiasi;

public open class Person (
  private var name: String,
  private var age: Int,
){
   fun getName(): String {
    return name
  }

   fun setName(newName: String) {
    name = newName
  }

   fun getAge(): Int {
    return age
  }

   fun setAge(newAge: Int) {
    age = newAge
  }
}
