namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Shield : Armor
    {
        private static int HealthModifier = (int)(Constants.ItemAttackPointsModifier * 1.1);
        private static int DeffenseModifier = (int)(Constants.ItemAttackPointsModifier * 0.2);

        public Shield(string id)
            : base(id, HealthModifier, DeffenseModifier)
        {

        }
    }
}
