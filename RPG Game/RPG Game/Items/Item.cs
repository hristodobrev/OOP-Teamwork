namespace RPG_Game.Items
{
    using Entities.Characters;
    using Interfaces;

    public class Item : IHoldable
    {
        protected Item(string id, Character itemHolder)
        {
            this.Id = id;
            this.ItemHolder = itemHolder;
        }

        public string Id { get; set; }

        public Character ItemHolder { get; set; }
    }
}
