namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Shield : Armor
    {
        public Shield(string id, Character itemHolder)
            : base(id, itemHolder, Constants.ItemHealthModifier, Constants.ItemDeffensePointsModifier)
        {

        }
    }
}
