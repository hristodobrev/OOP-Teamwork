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
