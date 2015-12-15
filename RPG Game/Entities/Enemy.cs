namespace RPG_Game.Entities
{
    using System.Windows.Controls;
    using Constants;
    using RPG_Game.Enums;
    using System.Collections.Generic;
    using System.Windows.Media.Imaging;
    using System;

    public class Enemy : Entity
    {
        public Enemy(string id, int x, int y)
            : base(id, Constants.CharacterHealth, Constants.CharacterEnergy, Constants.CharacterAttackPoints, Constants.CharacterDefensePoints, x, y)
        {
            this.GenerateEnemyImage();
        }

        public Image Image
        {
            get
            {
                return base.Image;
            }
            set
            {
                base.Image = value;
            }
        }

        public override void Update(Canvas GamePlayLayout)
        {
            Image img = new Image();
            img.Source = this.Image.Source;

            GamePlayLayout.Children.Remove(img);

            Canvas.SetLeft(img, this.Position.X);
            Canvas.SetTop(img, this.Position.Y);

            GamePlayLayout.Children.Add(img);
        }

        private void GenerateEnemyImage()
        {
            Image enemyImage = new Image();
            enemyImage.Width = 25;
            enemyImage.Height = 25;
            enemyImage.Source = new BitmapImage(new Uri(@"C:\Users\nikidimitrow\Desktop\oop\OOP-Teamwork\RPG Game\Resources\player.png"));
            this.Image = enemyImage;
        }
    }
}
