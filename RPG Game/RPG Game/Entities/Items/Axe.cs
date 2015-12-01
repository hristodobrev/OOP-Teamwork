namespace RPG_Game.Entities.Items
{
    using RPG_Game.Entities.Characters;

    public class Axe : Item
    {
        public Axe(string id, Character itemHolder)
            : base(id, itemHolder, 120, 30, 20)
        {

        }
    }
}
