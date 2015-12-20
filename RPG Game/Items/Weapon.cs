namespace RPG_Game.Items
{
    using Interfaces;
    using Entities.Characters;

    public abstract class Weapon : Item, IEquipable
    {
        protected Weapon(string id, int energyModifier, int attackPointsModifier)
            : base(id)
        {
            this.HealthModifier = 0;
            this.EnergyModifier = energyModifier;
            this.AttackPointsModifier = attackPointsModifier;
            this.DefensePointsModifier = 0;
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
