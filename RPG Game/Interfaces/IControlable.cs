namespace RPG_Game.Interfaces
{
    using RPG_Game.Entities;
    using RPG_Game.Enums;
    using System.Collections.Generic;
using System.Windows;
    public interface IControlable
    {
        void Move(Direction direction, List<Position> enemiesPositions);

        void Flee(Enemy enemy);
    }
}
