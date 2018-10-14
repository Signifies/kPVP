package classes;

public enum Team
{
    A,
    B;
    public static Team getRandomTeam()
    {
        return values() [(int) (Math.random() * values().length)];
    }
}