using RPG_Game.Entities;
using RPG_Game.Entities.Characters;
using RPG_Game.Items;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace RPG_Game
{
    /// <summary>
    /// Interaction logic for FightField.xaml
    /// </summary>
    public partial class FightField : Window
    {
        static Random rnd = new Random();

        public FightField()
        {
            InitializeComponent();
        }

        public FightField(Entity enemy, Entity player)
        {
            this.Player = player;
            this.Enemy = enemy;
            InitializeComponent();
            this.UpdateStats();
            Log.Clear();
        }

        private Entity Player { get; set; }

        private Entity Enemy { get; set; }

        private void UpdateStats()
        {
            playerHealthBar.Value = (this.Player.Health * 100) / Constants.Constants.CharacterHealth;
            playerEnergyBar.Value = this.Player.Energy;
            enemyHealthBar.Value = (this.Enemy.Health * 100) / Constants.Constants.CharacterHealth;
            enemyEnergyBar.Value = this.Enemy.Energy;
            playerHealth.Content = this.Player.Health;
            playerEnergy.Content = this.Player.Energy;
            enemyHealth.Content = this.Enemy.Health;
            enemyEnergy.Content = this.Enemy.Energy;
        }

        private void attackButton_Click(object sender, RoutedEventArgs e)
        {
            Log.AppendText(this.Player.Attack(this.Enemy) + Environment.NewLine);
            this.CheckPlayer();
            Log.AppendText(this.Enemy.Attack(this.Player) + Environment.NewLine);
            this.CheckEnemy();
            Log.Focus();
            Log.CaretIndex = Log.Text.Length;
            Log.ScrollToEnd();
            this.UpdateStats();
            var charaa = new Mage("Penka", 2, 2);
        }

        private void CheckPlayer()
        {
            if (!this.Player.isAlive)
            {
                MessageBox.Show("You have died!");
                Environment.Exit(0);
            }
        }

        private void CheckEnemy()
        {
            if (!this.Enemy.isAlive)
            {
                MessageBox.Show("You have defeated your enemy!");
                (Character)(this.Player).
                this.Close();
            }
        }

        public void EquipItem(Item item)
        {
            
        }
    }
}
