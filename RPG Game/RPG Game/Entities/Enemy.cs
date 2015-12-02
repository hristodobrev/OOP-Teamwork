namespace RPG_Game.Entities
{
    public class Enemy : Entity
    {
        public Enemy(string id, int health, int energy, int attackPoints, int defensePoints, int x, int y)
            : base(id, health, energy, attackPoints, defensePoints, x, y)
        {

        }
    }
}
