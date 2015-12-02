namespace RPG_Game.Entities.Characters
{
    using System.Collections.Generic;

    using RPG_Game.Items;
    using Interfaces;

    public abstract class Character : Entity, IControlable
    {
        private List<Item> inventory;

        protected Character(string id, int health, int energy, int attackPoints, int defensePoints, int x, int y)
            : base(id, health, energy, attackPoints, defensePoints, x, y)
        {
            this.inventory = new List<Item>();
        }

        public void Move()
        {
            throw new System.NotImplementedException();
        }

        public void Flee(Enemy enemy)
        {
            throw new System.NotImplementedException();
        }
    }
}
