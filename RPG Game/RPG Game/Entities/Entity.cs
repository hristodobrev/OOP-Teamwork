namespace RPG_Game.Entities
{
    using Interfaces;
    using System.Windows.Controls;

    public abstract class Entity : IUpdatable
    {
        protected Entity(string id, int health, int energy, int attackPoints, int defensePoints, int x, int y)
        {
            this.Id = id;
            this.Health = health;
            this.Energy = energy;
            this.AttackPoints = attackPoints;
            this.DefensePoints = defensePoints;
            this.X = x;
            this.Y = y;
        }

        public Image image { get; set; }

        public string Id { get; set; }

        public int Health { get; set; }

        public int Energy { get; set; }

        public int AttackPoints { get; set; }

        public int DefensePoints { get; set; }

        public int X { get; set; }

        public int Y { get; set; }

        public void Update()
        {
            throw new System.NotImplementedException();
        }
    }
}
