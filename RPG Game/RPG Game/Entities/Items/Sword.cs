namespace RPG_Game.Entities.Items
{
    using RPG_Game.Entities.Characters;

    public class Sword : Item
    {
        public Sword(string id, Character itemHolder)
            : base(id, itemHolder, 100, 20, 10)
        {

        }
    }
}
