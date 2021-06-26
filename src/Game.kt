class Game : User() {
    private lateinit var scoreboard : Map<String, Int>
    private var score: Int = 0
    private var playerList = MutableList<String>()

    fun menu(){
        println("======================")
        println("______ WELCOME _______")
        println("======================")
        println("1) Game Start")
        println("2) High Score")
        println("3) Exit")

        val userMenuChoice: Int? = readLine()?.toInt()
        try {
            if (userMenuChoice is Int){
                when(userMenuChoice){
                    1 -> gameStart()
                    2 -> highScore()
                    3 -> exit()
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
            val player = User()
            player.name = playerName
            playerList.add(playerName)
        }
    }

    fun exit(){

    }

    fun highScore(){

    }

    fun inGame(){

    }

    fun printPlayerName(){
        for(i in 0..playerList.size.minus(1)){
            println(playerList[i])
        }
    }

}