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
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace RPG_Game
{
    /// <summary>
    /// Interaction logic for Gameplay.xaml
    /// </summary>
    public partial class Gameplay : Window
    {
        Point playerPoint = new Point(400, 200);
        Image playerImage = new Image();
        Point mousePoint = new Point(400, 200);

        public Gameplay()
        {
            InitializeComponent();
            PrintMap();

            DispatcherTimer dispatcherTimer = new DispatcherTimer();
            dispatcherTimer.Tick += (dispatcherTimer_Tick);
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0, 0, 1);
            dispatcherTimer.Start();

            PrintPlayer();
        }

        private void Window_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            mousePoint = e.GetPosition(this);
        }

        private void dispatcherTimer_Tick(object sender, EventArgs e)
        {

            if (playerPoint.X < mousePoint.X)
            {
                playerPoint.X++;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }

            if (playerPoint.X > mousePoint.X)
            {
                playerPoint.X--;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }

            if (playerPoint.Y < mousePoint.Y)
            {
                playerPoint.Y++;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }

            if (playerPoint.Y > mousePoint.Y)
            {
                playerPoint.Y--;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }
        }

        private void PrintPlayer()
        {
            playerImage = new Image();
            playerImage.Width = 60;
            playerImage.Height = 60;
            playerImage.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/player.png"));

            Canvas.SetLeft(playerImage, playerPoint.X);
            Canvas.SetTop(playerImage, playerPoint.Y);

            GamePlayLayout.Children.Add(playerImage);
        }

        private void PrintMap()
        {
            char[,] map = new char[,]
            {
                {'#', '#', '@'},
                {'#', ' ', '#'},
                {'#', '#', '@'}
            };

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Image myImage = new Image();
                    myImage.Width = 60;
                    myImage.Height = 60;

                    switch (map[i, j])
                    {
                        case '#':
                            myImage.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/tree2.png"));
                            break;
                        case '@':
                            myImage.Source = new BitmapImage(new Uri(@"pack://application:,,,/Resources/tree1.png"));
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
