namespace RPG_Game.Items
{
    using Interfaces;
    using Entities.Characters;

    public abstract class Armor : Item, IEquipable
    {
        protected Armor(string id, Character itemHolder, int healthModifier, int defensePointsModifier)
            : base(id, itemHolder)
        {
            this.HealthModifier = healthModifier;
            this.EnergyModifier = 0;
            this.AttackPointsModifier = 0;
            this.DefensePointsModifier = defensePointsModifier;
        }
    }
}
