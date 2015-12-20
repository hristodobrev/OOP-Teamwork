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

        public override void Update(Canvas GamePlayLayout)
        {
            Image.Height = 45;
            Image.Width = 45;

            GamePlayLayout.Children.Remove(Image);

            Canvas.SetLeft(Image, this.Position.X);
            Canvas.SetTop(Image, this.Position.Y);

            GamePlayLayout.Children.Add(Image);

            if (this.Health <= 0)
            {
                GamePlayLayout.Children.Remove(Image);
            }
        }

        private void GenerateEnemyImage()
        {
            Image enemyImage = new Image();
            enemyImage.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/orc.png"));
            this.Image = enemyImage;
        }
    }
}
