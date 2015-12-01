namespace RPG_Game.Entities.Characters
{
    using System.Collections.Generic;

    using RPG_Game.Entities.Items;

    public abstract class Character : GameObject
    {
        private List<Item> inventory;

        protected Character(string id, int health, int energy, int attackPoints, int defensePoints)
            : base(id)
        {
            this.inventory = new List<Item>();
            this.Health = health;
            this.Energy = energy;
            this.AttackPoints = attackPoints;
            this.DefensePoints = defensePoints;
        }

        public int Health { get; set; }

        public int Energy { get; set; }

        public int AttackPoints { get; set; }

        public int DefensePoints { get; set; }
    }
}
