namespace RPG_Game.Entities.Items
{
    using RPG_Game.Entities.Characters;

    public class Shield : Item
    {
        public Shield(string id, Character itemHolder)
            : base(id, itemHolder, 0, 100, 20)
        {

        }
    }
}
