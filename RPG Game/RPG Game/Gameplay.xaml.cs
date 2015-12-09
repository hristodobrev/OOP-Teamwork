﻿using RPG_Game.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace RPG_Game
{
    /// <summary>
    /// Interaction logic for Gameplay.xaml
    /// </summary>
    public partial class Gameplay : UserControl
    {
        //private static GameEngine Engine { get; set; }

        public Gameplay()
        {
            InitializeComponent();

            GameEngine Engine = new GameEngine();

            CompositionTarget.Rendering += Engine.Run;
        }
    }
}
