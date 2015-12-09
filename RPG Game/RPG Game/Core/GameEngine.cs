namespace RPG_Game.Core
{
    using RPG_Game.Entities.Characters;
    using System;
    using System.Windows;
    using System.Windows.Controls;
    using System.Windows.Media.Imaging;

    public class GameEngine
    {
        private Character player;

        public GameEngine()
        {
            this.Initialize();
        }

        public void Run(object sender, EventArgs e)
        {
            if (this.player.isAlive)
            {
                this.player.Update();
            }
        }

        private void Initialize()
        {
            var img = new Image();
            img.Name = "Player Image";
            img.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/CharRight.jpg"));
            img.Width = 28;
            img.Height = 32;

            this.player = new Mage("Mage", img, 10, 10);
        }
    }
}
