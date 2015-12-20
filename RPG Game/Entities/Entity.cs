namespace RPG_Game.Entities
{
    using Interfaces;
    using RPG_Game.Enums;
    using RPG_Game.Exceptions;
    using System;
    using System.Windows;
    using System.Windows.Controls;

    public abstract class Entity : IUpdatable
    {
        private const int AttackEnergyCost = 10;

        public bool isAlive = true;

        private string id;
        private int health;
        private int energy;
        private int attackPoints;
        private int defensePoints;
        private Position position;

        protected Entity(string id, int health, int energy, int attackPoints, int defensePoints, int x, int y)
        {
            this.Id = id;
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
                if (value < 0)
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

        public Position Position
        {
            get
            {
                return this.position;
            }
            set
            {
                this.position = value;
            }
        }

        public virtual void Update(Canvas GamePlayLayout)
        {
            GamePlayLayout.Children.Remove(this.Image);

            Canvas.SetLeft(this.Image, this.Position.X);
            Canvas.SetTop(this.Image, this.Position.Y);

            GamePlayLayout.Children.Add(this.Image);
        }

        public string Attack(Entity target)
        {
            Random rnd = new Random();

            int increasement = rnd.Next(1, 11);

            int damage = this.AttackPoints - target.DefensePoints + increasement;

            string attackArguments = string.Format("{0} hitted {1} for {2} damage.", this.Id, target.Id, damage);

            if (this.Energy < AttackEnergyCost)
            {
                damage /= 4;
                target.ResponseAttack(damage);
                attackArguments = string.Format("(Not enough energy[Strength reduced by 75%]) {0} hitted {1} for {2} damage.", this.Id, target.Id, damage);
            }
            else
            {
                this.Energy -= AttackEnergyCost;
                target.ResponseAttack(damage);
            }

            return attackArguments;
        }

        public void ResponseAttack(int damage)
        {
            if (this.Energy < 20)
            {
                this.Energy += 5;
                if (this.Energy > Constants.Constants.CharacterEnergy)
                {
                    this.Energy = Constants.Constants.CharacterEnergy;
                }
            }
            try
            {
                this.Health -= damage;
            }
            catch (EntityStatOutOfRangeException)
            {
                this.isAlive = false;
                this.Health = 0;
            }
        }
    }
}
