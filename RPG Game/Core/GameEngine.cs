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

            }
        }

        private void Initialize()
        {
            this.player = new Mage("Mage", 10, 10);
        }

       
    }
}
