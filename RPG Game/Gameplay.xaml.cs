using RPG_Game.Core;
using RPG_Game.Entities.Characters;
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
        Image playerImage = new Image();
        Character player = new Mage("Pencho", playerImage, 200, 400);
        Point mousePoint = new Point(400, 200);

        MainWindow gamePlayerParent = null;
        public Gameplay(MainWindow _gamePlayerParent)
        {
            gamePlayerParent = _gamePlayerParent;

            InitializeComponent();
            PrintMap();

            DispatcherTimer dispatcherTimer = new DispatcherTimer();
            dispatcherTimer.Tick += (DispatcherTimer_Tick);
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0, 0, 1);
            dispatcherTimer.Start();

            PrintPlayer();
        }

        private void Window_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            mousePoint = e.GetPosition(this);
        }

        private void DispatcherTimer_Tick(object sender, EventArgs e)
        {

            if (player.Position.X < mousePoint.X)
            {
                player.Position.X++;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }

            if (player.Position.X > mousePoint.X)
            {
                player.Position.X--;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }

            if (player.Position.Y < mousePoint.Y)
            {
                player.Position.Y++;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }

            if (player.Position.Y > mousePoint.Y)
            {
                player.Position.Y--;
                GamePlayLayout.Children.Remove(playerImage);
                PrintPlayer();
            }
        }

        private void PrintPlayer()
        {
            playerImage = new Image();
            playerImage.Width = 50;
            playerImage.Height = 50;
            playerImage.Source = new BitmapImage(new Uri(@"D:\Others\OOP\OOP-Teamwork\RPG Game\Resources\player.png"));

            Canvas.SetLeft(playerImage, player.Position.X);
            Canvas.SetTop(playerImage, player.Position.Y);

            GamePlayLayout.Children.Add(playerImage);
        }

        private void Window_Closing(object sender, System.ComponentModel.CancelEventArgs e)
        {
            this.gamePlayerParent.Show();
        }

        private void PrintMap()
        {
            char[,] map = new char[,]
            {
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'},
                {'#', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', ' ', ' ', ' ' ,' ' ,' ',' ', ' ', '#'}
            };

            for (int i = 0; i < map.GetLength(0); i++)
            {
                for (int j = 0; j < map.GetLength(1); j++)
                {
                    Image myImage = new Image();
                    myImage.Width = 50;
                    myImage.Height = 50;

                    switch (map[i, j])
                    {
                        case '#':
                            myImage.Source = new BitmapImage(new Uri(@"D:\Others\OOP\OOP-Teamwork\RPG Game\Resources\tree2.png"));
                            break;
                        case '@':
                            myImage.Source = new BitmapImage(new Uri(@"D:\Others\OOP\OOP-Teamwork\RPG Game\Resources\tree1.png"));
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
