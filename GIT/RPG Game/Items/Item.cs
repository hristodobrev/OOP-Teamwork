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

        public int HealthModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public int EnergyModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public int DefensePointsModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public int AttackPointsModifier
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
                throw new System.NotImplementedException();
            }
        }

        public string Id { get; set; }

        public Character ItemHolder { get; set; }
    }
}
