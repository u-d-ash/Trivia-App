package com.example.triviaapp

public class Game() {

    private var game_amt = ""
    private var game_diff = ""
    private var game_type = ""
    private var game_cat = ""

    public fun get_amount() : String{
        return game_amt
    }
    public fun get_category() : String{
        return game_cat
    }
    public fun get_type() : String{
        return game_type
    }
    public fun get_diff() : String{
        return game_diff
    }

    public fun set_amount(x : String){
        game_amt = x
    }
    public fun set_type(x : String){
        game_type = x
    }
    public fun set_category(x : String){
        game_cat = x
    }
    public fun set_diff(x : String){
        game_diff = x
    }




}

