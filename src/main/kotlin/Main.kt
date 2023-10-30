

//fun printName(){    // zadanie 2
//    println("Tell me your name!")
//    val name = readln()
//    println("Hello $name!")
//}


fun main() {
//    printName()
val forgeWeapon = ForgeWeapon()
    while (true) {

        println("Choose your next action")
        println("[1] Forge new weapon")
        println("[2] Erase one of your weapons")
        println("[3] Use your weapon")
        println("[4] Stats from one of your weapons")
        println("[5] Your inventory")
        println("[6] Quit")

        when (readln()){
            "1" -> { forgeWeapon.forgeWeapons() }
            "2" -> { println("Write which weapon from your inventory you want to erase")
                forgeWeapon.showInventory()
                val erase = readln()
                forgeWeapon.removeWeapon(erase)
            }
            "3" -> {forgeWeapon.showInventory()
                println("Write which item from your inventory you want to use")
                val use = readln()
                forgeWeapon.weaponUsage(use)

            }
            "4" -> {forgeWeapon.showInventory()
                println("Write which weapon from your inventory you want to see detailed info about")
                val details = readln()
                forgeWeapon.displayDetails(details)

            }
            "5" -> {forgeWeapon.displayWeapons()}
            "6" -> { println("If you leave your inventory will be gone! Type 1 if you wish to leave and 2 if you will stay")
                when (readln()){
                    "1" -> {forgeWeapon.eraseItAll()
                        break}
                    "2" -> continue
                    else -> {println("Invalid option")
                        continue}
                }

            }
            else -> println("Invalid option. Try again")

        }
    }
}

