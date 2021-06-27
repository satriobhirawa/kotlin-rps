class GameController : User("CPU"), Callback {
    private var scoreboard: MutableMap<String, Int> = mutableMapOf()
    private var playerList: MutableList<User> = arrayListOf()
    private val choice: Array<String> = arrayOf("batu", "gunting", "kertas")
    private val userInputTemp: MutableList<String> = arrayListOf()
    private val playerTemp: MutableList<String> = arrayListOf()

    fun menu() {
        userInputTemp.clear()
        playerTemp.clear()
        println("")
        println("")
        println("======================")
        println("______ WELCOME _______")
        println("======================")
        println("1) Game Start")
        println("2) Leaderboard")
        println("3) Show Players")
        println("")
        println("")

        val userMenuChoice: Int? = readLine()?.toInt()
        try {
            if (userMenuChoice is Int) {
                when (userMenuChoice) {
                    1 -> gameStart()
                    2 -> leaderboard()
                    3 -> printPlayerName()
                    else -> {
                        println("Please choose between 1-3")
                    }
                }
            }
        } catch (e: Exception) {
            println(e)
        }


    }

    private fun gameStart() {
        for (i in 1..2) {

            println("Insert player $i name ")
            val playerName: String = readLine().toString().lowercase()
            //var scoreFromScoreBoard = scoreboard.getValue(playerName)
            var player = User(playerName)
            //add player to list

            playerList.add(player)
            playerList.forEach {
                if (it.name == playerName)
                    scoreboard.put(player.name, player.score)
            }


            playerTemp.add(player.name)
            println("Player $playerName has been created...")
            println("======================")
            println("Input $playerName : ")
            val playerChoice: String = readLine().toString().lowercase()
            if (choice.contains(playerChoice)) {
                userInputTemp.add(playerChoice)
                if (userInputTemp.size == 2) {
                    when {
                        ((userInputTemp[0] == "gunting" && userInputTemp[1] == "kertas")
                                || (userInputTemp[0] == "kertas" && userInputTemp[1] == "batu")
                                || (userInputTemp[0] == "batu" && userInputTemp[1] == "gunting")) -> {

                            //scoreboard.get(playerTemp[0])?.let { scoreboard.put(playerTemp[0], it.plus(1)) }
                            for (i in 0..playerList.size.minus(1)) {
                                if (playerList[i].name == playerTemp[0]) {
                                    playerList[i].score += 1
                                    scoreboard[playerList[i].name] = playerList[i].score
                                }

                            }
                            //player.score = scoreboard.getValue(playerTemp[0])
                            println("${playerTemp[0]} WIN!")
                            menu()

                        }
                        ((userInputTemp[1] == "gunting" && userInputTemp[0] == "kertas")
                                || (userInputTemp[1] == "kertas" && userInputTemp[0] == "batu")
                                || (userInputTemp[1] == "batu" && userInputTemp[0] == "gunting")) -> {

                            //scoreboard.get(playerTemp[1])?.let { scoreboard.put(playerTemp[1], it.plus(1)) }
                            for (i in 0..playerList.size.minus(1)) {
                                if (playerList[i].name == playerTemp[1]) {
                                    playerList[i].score++
                                    scoreboard[playerList[i].name] = playerList[i].score
                                }

                            }
                            //scoreboard.put(playerTemp[1], scoreboard.getValue(playerTemp[1] + 1))
                            //player.score = scoreboard.getValue(playerTemp[1])
                            println("${playerTemp[1]} WIN!")
                            menu()

                        }
                        else -> {
                            println("DRAW!")
                            menu()
                        }
                    }
                }
            } else {
                println("Available input = 'gunting','batu','kertas'")
                gameStart()
            }


            /*if (!playerList.contains(player) && !(scoreboard.containsKey(player.name))) {
                    scoreboard.put(player.name, player.score)
                    playerList.add(player)
                    playerTemp.add(player.name)
                    println("Player $playerName has been created...")
                    println("======================")
                    println("Input $playerName : ")
                    val playerChoice: String = readLine().toString().lowercase()
                    if (choice.contains(playerChoice)) {
                        userInputTemp.add(playerChoice)
                        if (userInputTemp.size == 2) {
                            when {
                                ((userInputTemp[0] == "gunting" && userInputTemp[1] == "kertas")
                                        || (userInputTemp[0] == "kertas" && userInputTemp[1] == "batu")
                                        || (userInputTemp[0] == "batu" && userInputTemp[1] == "gunting")) -> {
                                    player.score++;
                                    scoreboard.get(playerTemp[0])?.let { scoreboard.put(playerTemp[0], it.plus(1)) }

                                    println("${playerTemp[0]} WIN!")
                                    userInputTemp.clear()
                                    playerTemp.clear()
                                    menu()

                                }
                                ((userInputTemp[1] == "gunting" && userInputTemp[0] == "kertas")
                                        || (userInputTemp[1] == "kertas" && userInputTemp[0] == "batu")
                                        || (userInputTemp[1] == "batu" && userInputTemp[0] == "gunting")) -> {
                                    player.score++;
                                    scoreboard.get(playerTemp[1])?.let { scoreboard.put(playerTemp[1], it.plus(1)) }

                                    println("${playerTemp[1]} WIN!")
                                    userInputTemp.clear()
                                    playerTemp.clear()

                                    menu()

                                }
                                else -> {
                                    println("DRAW!")
                                    menu()
                                }
                            }
                        }
                    } else {

                        gameStart()
                    }


                } else {
                    println("Player is already exist!!")
                    menu()
                }*/


        }
    }

    override fun leaderboard() {
        println("")
        println("______ LEADERBOARD _______")
        println("")


        for (key in scoreboard.keys) {
            println("${key}=${scoreboard[key]}")
        }
    }

    fun printPlayerName() {
        for (i in 0..playerList.size.minus(1)) {
            println(playerList[i].name)
        }
    }

}