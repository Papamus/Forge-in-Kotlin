data class Swords(override var endurance: Int?, override val description: String, override val name: String, override var usage: Int, override val rarity: String, var sharpness: String)
    : Weapons{
        fun adjustSharpness(){
            sharpness = if (endurance!! >= 3) {"sharp";} else {"blunt"}
        }
    }
