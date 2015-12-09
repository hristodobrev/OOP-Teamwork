namespace RPG_Game.Entities
{
    using System.Windows.Controls;

    public class Enemy : Entity
    {
        public Enemy(string id, Image image, int health, int energy, int attackPoints, int defensePoints, int x, int y)
            : base(id, image, health, energy, attackPoints, defensePoints, x, y)
        {

        }
    }
}
