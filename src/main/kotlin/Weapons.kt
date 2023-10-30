import kotlin.random.Random

interface Weapons {

    var endurance: Int?
    val description: String
    val name: String
    var usage: Int
    val rarity: String

    fun randomEndurance(userChoice: Int) {
        val diceList = setOf(6, 8, 10, 12, 20)
        endurance = if (diceList.contains(userChoice)) {
            Random.nextInt(1, userChoice)
        } else {
            println("You chose wrong type of dice, try again!")
            var choice = readln().toInt()
            while (!diceList.contains(choice)) {
                println("You chose wrong type of dice, try again!")
                choice = readln().toInt()
            }
            Random.nextInt(1, userChoice)
        }
    }


}

open class ForgeWeapon{
    private val fireSword = Swords(null, "Special sword that is soaked with fire dragon's energy", "Shakk's breath", 0, "Gold", "sharp")
    private val frostSword = Swords(null, "Legendary sword found in an block of ice centuries ago", "Frostbite", 0, "Legendary", "sharp")
    private val basicSword = Swords(null, "Standard army sword", "Longsword", 0, "Bronze", "sharp")
    private val voidShield = Shields(
        null,
        "Shield with huge eye in the middle, that whispers dark spells against your enemies",
        "Curse of the void",
        0,
        "Gold",
        "Steel"
    )
    private val lightShield = Shields(null, "Enlightened shield, blessed by a High Priest", "Bright prayer", 0, "Silver", "Wooden")
    private val woodenShield = Shields(null, "Shield used by common soldiers and bandits", "War shield", 0, "Bronze", "Wooden")
    private val berserkAxe = Axes(
        null,
        "Handy axe, which recipe was found in the old mine, probably one of the Berserk hideouts",
        "Berserk axe",
        0,
        "Gold",
        2.7,
        null
    )
    private val bloodAxe = Axes(
        null,
        "Great axe recovered from one w the bloodshed's that happened in one of the village in the mountains",
        "Bloodpainter",
        0,
        "Diamond",
        4.0,
        null
    )
    private val lightningAxe = Axes(
        null,
        "This weapon is a treasure that first was used by mountain giants and was stolen from them",
        "Thunderlord",
        0,
        "Legendary",
        2.9,
        null
    )
    private val basicMace = Maces(null, "Basic mace used in the army", "Steel Mace", 0, "Bronze", "Light armor")
    private val stoneMace = Maces(
        null,
        "On of the finest maces created by a blacksmiths in the capitol",
        "Stone heart",
        0,
        "Gold",
        "Light/medium armor"
    )
    private val darkMace = Maces(
        null,
        "Mace filled with dark energy, stories say this mace was used by a Dark Lord himself",
        "Dark skullbreaker",
        0,
        "Diamond",
        "Heavy armor"
    )


    private val inventory = mutableListOf<Weapons>()

    private var swordList = listOf(fireSword.name, frostSword.name, basicSword.name)
    private var shieldList = listOf(voidShield.name, lightShield.name, woodenShield.name)
    private var axeList = listOf(berserkAxe.name, bloodAxe.name, lightningAxe.name)
    private var maceList = listOf(basicMace.name, stoneMace.name, darkMace.name)

    fun checkIfWeaponInInventory(weaponName: String): Boolean {
        if (inventory.any { it.name == weaponName }){
            println("That item already exists in your inventory!")
            return false
        }
        return true
    }
    fun forgeWeapons() {
        if (inventory.size <= 4){
            println("Choose which type of weapon you wish to forge\n")
            println("[1] Swords")
            println("[2] Shields")
            println("[3] Axes")
            println("[4] Maces")
            val weaponChoice = readln()

            when (weaponChoice) {
                "1" -> {
                    println("Forge your weapon from the list below")
                    println(swordList)
                    println("Write name of the sword you want to forge")
                    when (val specificWeapon = readln()) {
                        swordList[0] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                fireSword.randomEndurance(diceChoice.toInt())
                                fireSword.adjustSharpness()
                                inventory.add(fireSword)
                                println("${fireSword.name} with ${fireSword.endurance} endurance was added to your inventory!")
                            }
                        }
                        swordList[1] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                frostSword.randomEndurance(diceChoice.toInt())
                                frostSword.adjustSharpness()
                                inventory.add(frostSword)
                                println("${frostSword.name} with ${frostSword.endurance} endurance was added to your inventory!")
                            }
                        }
                        swordList[2] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                basicSword.randomEndurance(diceChoice.toInt())
                                basicSword.adjustSharpness()
                                inventory.add(basicSword)
                                println("${basicSword.name} with ${basicSword.endurance} endurance was added to your inventory!")
                            }
                        }
                        else -> {
                            println("There is no such weapon!")
                        }
                    }
                }
                "2" -> {
                    println("Forge your weapon from the list below")
                    println(shieldList)
                    println("Write name of the sword you want to forge")
                    when (val specificWeapon = readln()) {
                        shieldList[0] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                voidShield.randomEndurance(diceChoice.toInt())
                                inventory.add(voidShield)
                                println("${voidShield.name} with ${voidShield.endurance} endurance was added to your inventory!")
                            }
                        }
                        shieldList[1] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                lightShield.randomEndurance(diceChoice.toInt())
                                inventory.add(lightShield)
                                println("${lightShield.name} with ${lightShield.endurance} endurance was added to your inventory!")
                            }

                        }
                        shieldList[2] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                woodenShield.randomEndurance(diceChoice.toInt())
                                inventory.add(woodenShield)
                                println("${woodenShield.name} with ${woodenShield.endurance} endurance was added to your inventory!")
                            }
                        }
                        else -> {
                            println("There is no such weapon!")
                        }
                    }
                }
                "3" -> {
                    println("Forge your weapon from the list below")
                    println(axeList)
                    println("Write name of the sword you want to forge")
                    when (val specificWeapon = readln()) {
                        axeList[0] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                berserkAxe.randomEndurance(diceChoice.toInt())
                                berserkAxe.isThrowable()
                                inventory.add(berserkAxe)
                                println("${berserkAxe.name} with ${berserkAxe.endurance} endurance was added to your inventory!")
                            }
                        }
                        axeList[1] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                bloodAxe.randomEndurance(diceChoice.toInt())
                                bloodAxe.isThrowable()
                                inventory.add(bloodAxe)
                                println("${bloodAxe.name} with ${bloodAxe.endurance} endurance was added to your inventory!")
                            }
                        }
                        axeList[2] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                lightningAxe.randomEndurance(diceChoice.toInt())
                                lightningAxe.isThrowable()
                                inventory.add(lightningAxe)
                                println("${lightningAxe.name} with ${lightningAxe.endurance} endurance was added to your inventory!")
                            }
                        }
                        else -> {
                            println("There is no such weapon!")
                        }
                    }
                }
                "4" -> {
                    println("Forge your weapon from the list below")
                    println(maceList)
                    println("Write name of the sword you want to forge")
                    when (val specificWeapon = readln()) {
                        maceList[0] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                basicMace.randomEndurance(diceChoice.toInt())
                                inventory.add(basicMace)
                                println("${basicMace.name} with ${basicMace.endurance} endurance was added to your inventory!")
                            }
                        }
                        maceList[1] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                stoneMace.randomEndurance(diceChoice.toInt())
                                inventory.add(stoneMace)
                                println("${stoneMace.name} with ${stoneMace.endurance} endurance was added to your inventory!")
                            }
                        }
                        maceList[2] -> {
                            if (checkIfWeaponInInventory(specificWeapon)){
                                println("Now it's time for you to throw a dice that will set your weapons endurance!")
                                println("Choose type of dice you want to use to adjust your weapons Endurance. Possible types of cubes are: 6, 8, 10, 12 and 20")
                                val diceChoice = readln()
                                darkMace.randomEndurance(diceChoice.toInt())
                                inventory.add(darkMace)
                                println("${darkMace.name} with ${darkMace.endurance} endurance was added to your inventory!")
                            }
                        }
                        else -> {
                            println("There is no such weapon!")
                        }
                    }
                }
                else -> {
                    println("Invalid number! Try again")
                }
            }
        }
        else{
            println("You can't carry more weapons, they are too heavy! Destroy or use one!")
        }
    }

    fun showInventory(){
        println("Here is your current inventory")
        if (inventory.isEmpty()){
            println("Your inventory is empty!")

        }
        else{
            var i = 1
            inventory.forEach{
                println("[$i]. ${it.name}")
                i +=1
            }
        }
    }

    fun displayWeapons(){
        if (inventory.isEmpty()){
            println("Your inventory is empty!")

        }
        else{
            println("Your inventory and basic info about your weapons look like this!")
            inventory.forEach{
                println("-----------------------------------------------------")
                println("Name: ${it.name}")
                println("Description: ${it.description}")
                println("Endurance: ${it.endurance}")
                println("Usage: ${it.usage}")
                println("Rarity: ${it.rarity}\n")
            }
        }
    }
    fun displayDetails(weaponName: String){
        val weaponToShow = inventory.find { it.name == weaponName }
        if (weaponToShow != null){
            println(weaponToShow)
        }
        else {
            println("There is no weapon named $weaponName in your inventory!")
        }

    }

    fun removeWeapon(weaponName: String){
        val weaponToRemove = inventory.find { it.name == weaponName }
        if (weaponToRemove != null){
            inventory.remove(weaponToRemove)
            println("$weaponName was erased and removed from your inventory!")
        }
        else {
            println("There is no weapon named $weaponName in your inventory!")
        }
    }

    fun weaponUsage(weaponName: String){
        val weaponToUse = inventory.find { it.name == weaponName }
        if (weaponToUse != null){
            weaponToUse.usage+=1
            weaponToUse.endurance = weaponToUse.endurance?.minus(1)
            if (weaponToUse.endurance!! <= 0){
                inventory.remove(weaponToUse)
            }
        }
        else {
            println("There is no weapon named $weaponName in your inventory!")
        }

    }

    fun eraseItAll(){
        println("Your inventory is gone!")
        inventory.clear()
    }

}