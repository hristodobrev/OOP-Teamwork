namespace RPG_Game.Entities
{
    using Interfaces;
    using RPG_Game.Enums;
    using RPG_Game.Exceptions;
    using System.Windows.Controls;

    public abstract class Entity : IUpdatable
    {
        public bool isAlive = true;

        private string id;
        private int health;
        private int energy;
        private int attackPoints;
        private int defensePoints;
        private Position position;

        protected Entity(string id, Image image, int health, int energy, int attackPoints, int defensePoints, int x, int y)
        {
            this.Id = id;
            this.Image = image;
            this.Health = health;
            this.Energy = energy;
            this.AttackPoints = attackPoints;
            this.DefensePoints = defensePoints;
            this.Position = new Position(x, y);
        }

        public Image Image { get; set; }

        public string Id
        {
            get
            {
                return this.id;
            }

            set
            {
                if (string.IsNullOrEmpty(value.Trim()))
                {
                    throw new EntityNameException("Entity name cannot be null or empty.", "Entity name");
                }
                this.id = value;
            }
        }

        public int Health
        {
            get
            {
                return this.health;
            }

            set
            {
                if (value <= 0)
                {
                    throw new EntityStatOutOfRangeException("Entity health cannot be zero or negative.", "Entity health");
                }
                this.health = value;
            }
        }

        public int Energy
        {
            get
            {
                return this.energy;
            }

            set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Entity energy cannot be negative.", "Entity energy");
                }
                this.energy = value;
            }
        }

        public int AttackPoints
        {
            get
            {
                return this.attackPoints;
            }

            set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Entity attack points cannot be negative.", "Entity attack points");
                }
                this.attackPoints = value;
            }
        }

        public int DefensePoints
        {
            get
            {
                return this.defensePoints;
            }

            set
            {
                if (value < 0)
                {
                    throw new EntityStatOutOfRangeException("Entity defense points cannot be negative.", "Entity defense points");
                }
                this.defensePoints = value;
            }
        }

        public Position Position { get; set; }

        public void Update()
        {
            throw new System.NotImplementedException();
        }
    }
}
