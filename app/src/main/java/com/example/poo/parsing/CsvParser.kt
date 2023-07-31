import com.example.poo.parsing.Match

class CsvParser {
    fun parse(line :String) : Match {
        val token = line.split(",")
        return Match(
            homeTeam = token[5],
            homeTeamGoal = token[6],
            awayTeamGoal = token[7],
            awayTeam = token[8]
        )
    }
}