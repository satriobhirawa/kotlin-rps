class GameController : User("CPU") {
    private var scoreboard : MutableMap<String, Int> = mutableMapOf()
    private var playerList : MutableList<User> = arrayListOf()

    fun menu(){
        println("======================")
        println("______ WELCOME _______")
        println("======================")
        println("1) Game Start")
        println("2) Leaderboard")
        println("3) Exit")
        println("4) Show")

        val userMenuChoice: Int? = readLine()?.toInt()
        try {
            if (userMenuChoice is Int){
                when(userMenuChoice){
                    1 -> gameStart()
                    2 -> leaderboard()
                    3 -> exit()
                    4 -> printPlayerName()
                    else -> {
                        println("Please choose between 1-3")
                    }
                }
            }
        }catch (e : Exception){
            println(e)
        }
        

    }

    private fun gameStart() {
        playerCreation()


    }
    override
    fun playerCreation(){
        for(i in 1..2) {
            println("Insert player $i name ")
            val playerName: String = readLine().toString()

            val player = User(playerName)
            //add player to list


            if(!playerList.contains(player) && !(scoreboard.containsKey(player.name))){
                scoreboard.put(player.name,player.score)
                playerList.add(player)
                println("Player $playerName has been created...")
            }else{
                println("Player is already exist!!")
                menu()
            }
        }
    }

    fun exit(){

    }

    fun leaderboard(){

    }

    fun gameLogic(){

    }

    fun printPlayerName(){
        for(i in 0..playerList.size.minus(1)){
            println(playerList[i].name)
        }
    }

}