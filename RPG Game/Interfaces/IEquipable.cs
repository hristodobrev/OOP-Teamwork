namespace RPG_Game.Interfaces
{
    using Entities.Characters;

    public interface IEquipable
    {
        void UpdateStats(Character itemHolder);
    }
}
