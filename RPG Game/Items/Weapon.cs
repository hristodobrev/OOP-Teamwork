namespace RPG_Game.Items
{
    using Interfaces;
    using Entities.Characters;

    public abstract class Weapon : Item, IEquipable
    {
        protected Weapon(string id, Character itemHolder, int energyModifier, int attackPointsModifier)
            : base(id, itemHolder)
        {
            this.HealthModifier = 0;
            this.EnergyModifier = energyModifier;
            this.AttackPointsModifier = attackPointsModifier;
            this.DefensePointsModifier = 0;
        }
    }
}
