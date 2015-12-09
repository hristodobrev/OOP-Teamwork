using RPG_Game.Enums;
namespace RPG_Game.Interfaces
{
    public interface IUpdatable
    {
        Position Position { get; set; }

        void Update();
    }
}
