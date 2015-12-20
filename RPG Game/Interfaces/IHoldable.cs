namespace RPG_Game.Interfaces
{
    using Entities.Characters;

    public interface IHoldable
    {
        int HealthModifier { get; }

        int EnergyModifier { get; }

        int DefensePointsModifier { get; }

        int AttackPointsModifier { get; }
    }
}
