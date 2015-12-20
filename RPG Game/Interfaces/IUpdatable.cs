namespace RPG_Game.Interfaces
{
    using RPG_Game.Enums;
    using System.Windows;
    using System.Windows.Controls;

    public interface IUpdatable
    {
        Position Position { get; set; }

        void Update(Canvas canvas);
    }
}
