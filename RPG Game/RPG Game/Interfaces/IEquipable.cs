namespace RPG_Game.Interfaces
{
    using Entities.Characters;

    public interface IEquipable
    {
        Character ItemHolder { get; set; }

        int HealthModifier { get; set; }

        int EnergyModifier { get; set; }

        int DefensePointsModifier { get; set; }

        int AttackPointsModifier { get; set; }
    }
}
