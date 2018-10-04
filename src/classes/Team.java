package classes;

public enum Team
{
    RED,
    BLUE;
    public static Team getRandomTeam()
    {
        return values() [(int) (Math.random() * values().length)];
    }
}