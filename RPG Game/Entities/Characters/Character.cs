namespace RPG_Game.Entities.Characters
{
    using System.Windows.Controls;
    using System.Collections.Generic;

    using RPG_Game.Items;
    using Interfaces;
    using RPG_Game.Enums;
    using System.Windows.Media.Imaging;
    using System;
    using System.Windows;

    public abstract class Character : Entity, IControlable
    {
        private int MaxHealth = Constants.Constants.CharacterHealth;
        private int MaxEnergy = Constants.Constants.CharacterEnergy;

        private List<Item> inventory;

        protected Character(string id, int health, int energy, int attackPoints, int defensePoints, int x, int y)
            : base(id, health, energy, attackPoints, defensePoints, x, y)
        {
            MaxHealth = health;
            MaxEnergy = energy;
            this.inventory = new List<Item>();
            this.GeneratePlayerImage();
        }

        public int GetMaxHealth { get { return MaxHealth; } }

        public int GetMaxEnergy { get { return MaxEnergy; } }

        public void Move(Direction direction, List<Enemy> enemies, Canvas GamePlayLayout)
        {
            switch (direction)
            {
                case Direction.Left:
                    this.Position = new Position(this.Position.X - 1, this.Position.Y);
                    this.CheckColision(enemies, GamePlayLayout);
                    break;
                case Direction.Right:
                    this.Position = new Position(this.Position.X + 1, this.Position.Y);
                    this.CheckColision(enemies, GamePlayLayout);
                    break;
                case Direction.Up:
                    this.Position = new Position(this.Position.X, this.Position.Y - 1);
                    this.CheckColision(enemies, GamePlayLayout);
                    break;
                case Direction.Down:
                    this.Position = new Position(this.Position.X, this.Position.Y + 1);
                    this.CheckColision(enemies, GamePlayLayout);
                    break;
            }
        }

        private void CheckColision(List<Enemy> enemies, Canvas GamePlayLayout)
        {
            foreach (Enemy enemy in enemies)
            {
                if (Math.Abs(enemy.Position.X - this.Position.X) < 15 && Math.Abs(enemy.Position.Y - this.Position.Y) < 15)
                {
                    enemy.Image.Source = new BitmapImage(new Uri(@"D:\Others\OOP\OOP-Teamwork\RPG Game\Resources\CharRight.jpg"));
                    enemies.Remove(enemy);
                    FightField fieldWindow = new FightField(enemy, this);
                    fieldWindow.ShowDialog();
                    return;
                }
            }
        }

        public void Flee(Enemy enemy)
        {
            throw new System.NotImplementedException();
        }

        private void GeneratePlayerImage()
        {
            Image playerImage = new Image();
            playerImage.Width = 25;
            playerImage.Height = 25;
            playerImage.Source = new BitmapImage(new Uri(@"D:\Others\OOP\OOP-Teamwork\RPG Game\Resources\player.png"));
            this.Image = playerImage;
        }

        public void Equip(Item item)
        {
            this.MaxHealth += item.HealthModifier;
            this.MaxEnergy += item.EnergyModifier;
            this.AttackPoints += item.AttackPointsModifier;
            this.DefensePoints += item.DefensePointsModifier;
        }
    }
}
