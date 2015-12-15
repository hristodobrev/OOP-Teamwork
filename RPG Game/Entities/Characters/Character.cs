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
        private List<Item> inventory;

        Dictionary<string, object> playerData = new Dictionary<string, object>();

        protected Character(string id, int health, int energy, int attackPoints, int defensePoints, int x, int y)
            : base(id, health, energy, attackPoints, defensePoints, x, y)
        {
            this.playerData.Clear();
            this.playerData.Add("id", id);
            this.playerData.Add("health", health);
            this.playerData.Add("energy", energy);
            this.playerData.Add("attackPoints", attackPoints);
            this.playerData.Add("defensePoints", defensePoints);

            this.inventory = new List<Item>();
            this.GeneratePlayerImage();
        }

        public void Move(Direction direction, List<Position> enemiesPositions)
        {
            Position previousPosition = this.Position;

            switch (direction)
            {
                case Direction.Left:
                    this.Position = new Position(this.Position.X - 1, this.Position.Y);
                    this.CheckColision(enemiesPositions, previousPosition);
                    break;
                case Direction.Right:
                    this.Position = new Position(this.Position.X + 1, this.Position.Y);
                    this.CheckColision(enemiesPositions, previousPosition);
                    break;
                case Direction.Up:
                    this.Position = new Position(this.Position.X, this.Position.Y - 1);
                    this.CheckColision(enemiesPositions, previousPosition);
                    break;
                case Direction.Down:
                    this.Position = new Position(this.Position.X, this.Position.Y + 1);
                    this.CheckColision(enemiesPositions, previousPosition);
                    break;
            }
        }

        private void CheckColision(List<Position> enemiesPositions, Position previousPosition)
        {
            foreach (var enemy in enemiesPositions)
            {
                if (Math.Abs(enemy.X - this.Position.X) < 15 && Math.Abs(enemy.Y - this.Position.Y) < 15)
                {
                    this.Position = previousPosition;
                    FightField fieldWindow = new FightField(enemy, playerData);
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
            playerImage.Source = new BitmapImage(new Uri(@"C:\Users\nikidimitrow\Desktop\oop\OOP-Teamwork\RPG Game\Resources\player.png"));
            this.Image = playerImage;
        }

        private void settingsButton_Click(Object sender, EventArgs e)
        {

        }
    }
}
