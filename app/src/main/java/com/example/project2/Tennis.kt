package com.example.project2

class Tennis {

    var leftSetScore = 0
    var rightSetScore = 0
    var leftGameScore = 0
    var rightGameScore = 0
    var gameOver = false
    val gameScoreList : ArrayList<String> = arrayListOf("0", "15", "30", "40", "AD")

    constructor(){

    }

    fun play(player : String) : String {
        val leftScored : Boolean = (player == "left")
        val rightScored : Boolean = (player == "right")

        if(leftScored){
            //conditions for game being over
            if ((leftGameScore == 4) || (leftGameScore == 3 && rightGameScore < 3)) {
                leftGameScore = 0
                rightGameScore = 0
                increaseSetScore("left")
            } else {
                leftGameScore++
                return gameScoreList[leftGameScore]
            }
        }

        else {

        }


    }

    fun increaseSetScore(scorer : String){

        if(scorer == "left") {
            leftSetScore++
            if (leftSetScore >= 6 && leftSetScore > rightSetScore + 1){
                gameOver = true
            }
        }

        else {

        }
    }
}