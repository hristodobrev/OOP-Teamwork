namespace RPG_Game.Interfaces
{
    using RPG_Game.Entities;
    public interface IControlable
    {
        void Move();

        void Flee(Enemy enemy);
    }
}
