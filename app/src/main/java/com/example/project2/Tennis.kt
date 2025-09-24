package com.example.project2

class Tennis {

    var leftSetScore = 0
    var rightSetScore = 0
    var leftGameScore = 0
    var rightGameScore = 0
    var winner = ""
    val gameScoreList : ArrayList<String> = arrayListOf("0", "15", "30", "40", "AD")

    fun score(player : String) : ArrayList<String> {

        if(player == "left"){
            //check for AD game
            if (rightGameScore == 4) {
                leftGameScore = 3
                rightGameScore = 3
                return arrayListOf(gameScoreList[3], gameScoreList[3])
            }
            //conditions for game being over
            if ((leftGameScore == 4) || (leftGameScore == 3 && rightGameScore < 3)) {
                leftGameScore = 0
                rightGameScore = 0
                increaseSetScore(player)
                return arrayListOf(gameScoreList[0], gameScoreList[0])
            }
            //just a normal addition to the score
            else {
                leftGameScore++
                return arrayListOf(gameScoreList[leftGameScore], gameScoreList[rightGameScore])
            }
        }

        else{
            //check for AD game
            if (leftGameScore == 4) {
                rightGameScore = 3
                leftGameScore = 3
                return arrayListOf(gameScoreList[3], gameScoreList[3])
            }
            //conditions for game being over
            if ((rightGameScore == 4) || (rightGameScore == 3 && leftGameScore < 3)) {
                rightGameScore = 0
                leftGameScore = 0
                increaseSetScore(player)
                return arrayListOf(gameScoreList[0], gameScoreList[0])
            }
            //just a normal addition to the score
            else {
                rightGameScore++
                return arrayListOf(gameScoreList[leftGameScore], gameScoreList[rightGameScore])
            }
        }
    }

    fun increaseSetScore(scorer : String){

        if(scorer == "left") {
            leftSetScore++
            if (leftSetScore >= 4 && leftSetScore > rightSetScore + 1){
                winner = "Federer won"
            }
        }

        else {
            rightSetScore++
            if (rightSetScore >= 4 && rightSetScore > leftSetScore + 1){
                winner = "Nadal won"
            }
        }
    }
}