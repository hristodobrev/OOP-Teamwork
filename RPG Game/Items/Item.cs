namespace RPG_Game.Items
{
    using Entities.Characters;
    using Exceptions;
    using Interfaces;

    public class Item : IHoldable
    {
        private int healthModifier;
        private int energyModifier;
        private int defenseModifier;
        private int attackModifier;

        protected Item(string id)
        {
            this.Id = id;
        }

        public int HealthModifier
        {
            get
            {
                return this.healthModifier;
            }
            protected set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Health modifier cannot be negative.");
                }
                this.healthModifier = value;
            }
        }

        public int EnergyModifier
        {
            get
            {
                return this.energyModifier;
            }
            protected set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Energy modifier cannot be negative.");
                }
                this.energyModifier = value;
            }
        }

        public int DefensePointsModifier
        {
            get
            {
                return this.defenseModifier;
            }
            protected set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Deffense points modifier cannot be negative.");
                }
                this.defenseModifier = value;
            }
        }

        public int AttackPointsModifier
        {
            get
            {
                return this.attackModifier;
            }
            protected set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Attack points modifier cannot be negative.");
                }
                this.attackModifier = value;
            }
        }

        public string Id { get; set; }
    }
}
