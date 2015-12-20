namespace RPG_Game.Items
{
    using Interfaces;
    using Entities.Characters;

    public abstract class Armor : Item, IEquipable
    {
        protected Armor(string id, int healthModifier, int defensePointsModifier)
            : base(id)
        {
            this.HealthModifier = healthModifier;
            this.EnergyModifier = 0;
            this.AttackPointsModifier = 0;
            this.DefensePointsModifier = defensePointsModifier;
        }

        public void UpdateStats(Character itemHolder)
        {
            itemHolder.GetMaxHealth += this.HealthModifier;
            itemHolder.GetMaxEnergy += this.EnergyModifier;
            itemHolder.AttackPoints += this.AttackPointsModifier;
            itemHolder.DefensePoints += this.DefensePointsModifier;
        }
    }
}
