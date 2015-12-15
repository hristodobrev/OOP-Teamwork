using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
        private Dictionary<string, object> playerData;
        private Dictionary<string, object> enemyData;

        public FightField()
        {
            InitializeComponent();
        }

        public FightField(object location, Dictionary<string, object> data )
        {
            playerData = data;
            //Generate gad:
            enemyData = new Dictionary<string, object>();
            Random rg = new Random();

            this.enemyData.Add("id","Enemy Gad");
            this.enemyData.Add("health", rg.Next(int.Parse(this.playerData["health"].ToString())));
            this.enemyData.Add("energy", rg.Next(int.Parse(this.playerData["energy"].ToString())));
            this.enemyData.Add("attackPoints", rg.Next(int.Parse(this.playerData["attackPoints"].ToString())));
            this.enemyData.Add("defensePoints", rg.Next(int.Parse(this.playerData["defensePoints"].ToString())));

            InitializeComponent();
        }
    }
}
