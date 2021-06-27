class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            val game = GameController()
            while(true){
                game.menu()
            }

            //game.printPlayerName()
        }
    }

}