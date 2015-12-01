namespace RPG_Game.Entities.Items
{
    using RPG_Game.Entities.Characters;

    public class Item : GameObject
    {
        protected Item(string id, Character itemHolder, int attackBonus, int defenseBonus, int healthBonus)
            : base(id)
        {
            this.ItemHolder = itemHolder;
            this.AttackBonus = attackBonus;
            this.DefenseBonus = defenseBonus;
            this.HealthBonus = healthBonus;
        }

        public Character ItemHolder { get; private set; }

        public int AttackBonus { get; set; }

        public int DefenseBonus { get; set; }

        public int HealthBonus { get; set; }
    }
}
