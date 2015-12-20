namespace RPG_Game.Interfaces
{
    using Entities.Characters;

    public interface IHoldable
    {
        Character ItemHolder { get; set; }
    }
}
