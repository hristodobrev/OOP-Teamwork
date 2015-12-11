namespace RPG_Game.Items
{
    using Interfaces;
    using Entities.Characters;

    public abstract class Armor : Item, IEquipable
    {
        protected Armor(string id, Character itemHolder, int healthModifier, int defensePointsModifier)
            : base (id, itemHolder)
        {
            this.HealthModifier = healthModifier;
            this.EnergyModifier = 0;
            this.AttackPointsModifier = 0;
            this.DefensePointsModifier = defensePointsModifier;
        }

        public int HealthModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public int EnergyModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public int DefensePointsModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public int AttackPointsModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }
    }
}
