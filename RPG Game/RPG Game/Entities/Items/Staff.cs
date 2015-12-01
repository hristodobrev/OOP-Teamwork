namespace RPG_Game.Entities.Items
{
    using RPG_Game.Entities.Characters;

    public class Staff : Item
    {
        public Staff(string id, Character itemHolder)
            : base(id, itemHolder, 50, 80, 30)
        {

        }
    }
}
