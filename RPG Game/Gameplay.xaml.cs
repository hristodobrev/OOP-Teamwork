using RPG_Game.Core;
using RPG_Game.Entities;
using RPG_Game.Entities.Characters;
using RPG_Game.Enums;
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
        private Character player = new Mage("Pancho", 200, 200);
        private Point mousePoint = new Point(200, 200);
        private List<Position> enemiesPositions = new List<Position>();
        private List<Enemy> enemies = new List<Enemy>();

        MainWindow gamePlayerParent = null;
        public Gameplay(MainWindow _gamePlayerParent)
        {
            gamePlayerParent = _gamePlayerParent;

            InitializeComponent();
            PrintMap();
            enemiesPositions.Add(new Position(50, 100));
            enemiesPositions.Add(new Position(550, 240));
            enemiesPositions.Add(new Position(150, 390));
            enemiesPositions.Add(new Position(380, 290));
            enemiesPositions.Add(new Position(430, 500));

            GenerateEnemies();
            PrintEnemies();

            DispatcherTimer dispatcherTimer = new DispatcherTimer();
            dispatcherTimer.Tick += (DispatcherTimer_Tick);
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0, 0, 1);
            dispatcherTimer.Start();

            player.Update(GamePlayLayout);
        }

        private void PrintEnemies()
        {
            foreach (var enemy in enemies)
            {
                enemy.Update(GamePlayLayout);
            }
        }

        private void GenerateEnemies()
        {
            foreach (var enemy in enemiesPositions)
            {
                enemies.Add(new Enemy(("Enemy" + (enemy.Y + enemy.X).ToString()), enemy.X, enemy.Y));
            }
        }

        private void Window_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            mousePoint = e.GetPosition(this);
        }

        private void DispatcherTimer_Tick(object sender, EventArgs e)
        {
            if (player.Position.X < mousePoint.X - (player.Image.Width / 2))
            {
                player.Move(Direction.Right, this.enemiesPositions);
                player.Update(GamePlayLayout);
            }

            if (player.Position.X > mousePoint.X - (player.Image.Width / 2))
            {
                player.Move(Direction.Left, this.enemiesPositions);
                player.Update(GamePlayLayout);
            }

            if (player.Position.Y < mousePoint.Y - (player.Image.Height / 2))
            {
                player.Move(Direction.Down, this.enemiesPositions);
                player.Update(GamePlayLayout);
            }

            if (player.Position.Y > mousePoint.Y - (player.Image.Height / 2))
            {
                player.Move(Direction.Up, this.enemiesPositions);
                player.Update(GamePlayLayout);
            }
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
                            myImage.Source = new BitmapImage(new Uri(@"C:\Users\nikidimitrow\Desktop\oop\OOP-Teamwork\RPG Game\Resources\tree2.png"));
                            break;
                        case '@':
                            myImage.Source = new BitmapImage(new Uri(@"C:\Users\nikidimitrow\Desktop\oop\OOP-Teamwork\RPG Game\Resources\tree1.png"));
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
