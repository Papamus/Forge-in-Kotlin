data class Axes(override var endurance: Int?, override val description: String, override val name: String, override var usage: Int, override val rarity: String, val weight: Double, var throwable: String?)
    : Weapons{
    fun isThrowable(){
        throwable = if (weight <= 3){"Yes";} else{"No";}
    }
}