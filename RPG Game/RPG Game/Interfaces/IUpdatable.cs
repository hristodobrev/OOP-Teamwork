namespace RPG_Game.Interfaces
{
    public interface IUpdatable
    {
        int X { get; set; }

        int Y { get; set; }

        void Update();
    }
}
