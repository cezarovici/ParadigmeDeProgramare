package ro.mike.tuiasi

class Date (
   private var Year: Int,
   private var Mounth: Int,
   private var Day : Int
){
    fun setYear(Year: Int) {
        this.Year = Year
    }

    fun setMounth(Mounth: Int){
        this.Mounth = Mounth
    }

    fun setDay(Day: Int){
        this.Day = Day
    }
}