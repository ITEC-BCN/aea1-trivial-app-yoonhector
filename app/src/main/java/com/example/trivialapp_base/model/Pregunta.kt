package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Pregunta(
    val pregunta: String,
    val categoria: String,
    val dificultad: String, // "Facil", "Medio", "Dificil"
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String,
    val respuestaCorrecta: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object ProveedorPreguntas {
    fun obtenerPreguntas(): MutableList<Pregunta> {
        return mutableListOf(
            Pregunta("Who is the person in the logo?", "K-pop", "Easy", "SHINee's Key", "EXO's Baekhyun", "Infinite's L", "BigBang's G-Dragon", "SHINee's Key"),
            Pregunta("What generation is Kanto's region from?", "Pokémon", "Easy", "1st", "3rd", "4th", "5th", "1st"),
            Pregunta("What is the Japanese \"Black Butler\" title?", "Anime", "Medium", "Kuroshitsuji", "Futatsu no Spica", "Isekai Meikyuu", "Kamisama Hajimemashita", "Kuroshitsuji"),
            Pregunta("Which is the most sold videogame ever?", "Videogames", "Easy", "Minecraft", "Grand Theft Auto V", "Tetris", "Wii Sports", "Minecraft"),
            Pregunta("Which manga genre does Junji Itto draw?", "Anime", "Easy", "Romance", "Horror", "Shoujo", "Shonen", "Horror"),
            Pregunta("\"My Neighbor Totoro\", \"Spirited Away,\" among others, are part of...", "Anime", "Easy", "Bli", "Disney", "Gabe", "Ghibli", "Ghibli"),
            Pregunta("Which year was Shingeki no Kyojin anime first released?", "Anime", "Medium", "2012", "2013", "2014", "2015", "2013"),
            Pregunta("What's the name of Kimetsu no Yaiba's first opening?", "Anime", "Hard", "Gurenge", "Akeboshi", "Mugen", "Zankyousanka", "Gurenge"),
            Pregunta("Who's NOT part of the first Quinx Squad?", "Anime", "Hard", "Haise Sasaki", "Kuki Urie", "Tooru Mutsuki", "Shinsanpei Aura", "Shinsanpei Aura"),
            Pregunta("What fandom is E.L.F from?", "K-pop", "Medium", "Super Junior", "BigBang", "Girls' Generation", "April", "Super Junior"),
            Pregunta("Which group are Yunho and Changmin from?", "K-pop", "Medium", "DBSK", "TVXQ!", "Tohoshinki", "All of them", "All of them"),
            Pregunta("Which group did Jonas Brothers collaborate with?", "K-pop", "Easy", "TXT", "BTS", "Enhypen", "Super M", "TXT"),
            Pregunta("Which group has won a daesang for more consecutive years?", "K-pop", "Hard", "EXO", "BTS", "Twice", "All Day Project", "EXO"),
            Pregunta("Who's an athlete, as well as an idol, actor and model?", "K-pop", "Hard", "Choi Minho", "Max Changmin", "Lee Donghae", "Lee Hoseok", "Choi Minho"),
            Pregunta("Which is Oricorio's form when eating Pink Nectar?", "Pokémon", "Hard", "Apasionate", "Refinate", "Placid", "Moody", "Placid"),
            Pregunta("Which was the first created Pokémon?", "Pokémon", "Hard", "Bulbasaur", "Mew", "Rhydon", "Arceus", "Rhydon"),
            Pregunta("When was the first videogame invented?", "Videogames", "Hard", "1958", "1963", "1970", "1972", "1958"),
            Pregunta("Where was Unova inspired from?", "Pokémon", "Medium", "New York", "Los Angeles", "Paris", "Zandvoort", "New York"),
            Pregunta("What do you use to evolve Pikachu?", "Pokémon", "Easy", "Thunder Stone", "Happiness + level", "Level up", "Trade", "Thunder Stone"),
            Pregunta("Which is a stat attack?", "Pokémon", "Hard", "Will-O-Wisp", "Devastating Drake", "Leafage", "Thief", "Will-O-Wisp"),
            Pregunta("Which mob is not hostile only during the day?", "Videogames", "Easy", "Pliglin", "Spider", "Creeper", "Pillager", "Spider"),
            Pregunta("Who's the Assassin's Creed Unity main character?", "Videogames", "Medium", "Ezio", "Altair", "Desmond", "Haytham", "Ezio"),
            Pregunta("Which was the first Final Fantasy released exclusively on Playstation?", "Videogames", "Medium", "FF I", "FF IV", "FF VII", "FF V", "FF VII"),
            Pregunta("What was the original name of Mario in Super Mario Bros?", "Videogames", "Hard", "Jumpman", "Luigi", "Wario", "Plumberman", "Jumpman"),
            Pregunta("What is the capital city of France?", "General", "Easy", "Berlin", "Madrid", "Paris", "Rome", "Paris"),
            Pregunta("What is the chemical symbol for the element Gold?", "General", "Easy", "Ag", "Au", "Pb", "Fe", "Au"),
            Pregunta("Who was the primary author of the United States Declaration of Independence?", "General", "Medium", "George Washington", "Benjamin Franklin", "Thomas Jefferson", "John Adams", "Thomas Jefferson"),
            Pregunta("In which century was the playwright William Shakespeare born?", "General", "Medium", "14th Century", "15th Century", "16th Century", "17th Century", "16th Century"),
            Pregunta("In Norse mythology, what is the name of the rainbow bridge that connects Midgard and Asgard?", "General", "Hard", "Yggdrasil", "Valhalla", "Bifrost", "Gjallarbrú", "Bifrost"),
            Pregunta("What is the most abundant gas in the Earth's atmosphere?", "General", "Hard", "Oxygen", "Carbon Dioxide", "Hydrogen", "Nitrogen", "Nitrogen")
        )
    }
}
