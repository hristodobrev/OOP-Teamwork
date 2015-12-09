using RPG_Game.Core;
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
    public partial class Gameplay : Window
    {

        public Gameplay()
        {
            InitializeComponent();

            char[,] map = new char[,]
            {
                {'#', '#', '@'},
                {'#', ' ', '#'},
                {'#', ' ', '@'}
            };

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Image myImage = new Image();

                    switch (map[i, j])
                    {
                        case '#':
                            myImage.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/tree.png"));
                            break;
                        case '@':
                            myImage.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/water.png"));
                            break;
                    }
                    int x = (i) * 50;
                    int y = (j) * 50;

                    Canvas.SetTop(myImage, x);
                    Canvas.SetLeft(myImage, y);

                    GamePlayLayout.Children.Add(myImage);
                }
            }
        }
    }
}
