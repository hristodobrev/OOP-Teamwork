namespace RPG_Game.Interfaces
{
    using Enums;

    public interface IConsumable
    {
        int Ammount { get; }

        PotionType Type { get; }
    }
}
