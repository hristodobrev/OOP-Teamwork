namespace RPG_Game.Interfaces
{
    using RPG_Game.Entities;
    using RPG_Game.Enums;
    using System.Collections.Generic;
    using System.Windows;
    using System.Windows.Controls;

    public interface IControlable
    {
        void Move(Direction direction, List<Enemy> enemies, Canvas canvas);

        void Flee(Enemy enemy);
    }
}
