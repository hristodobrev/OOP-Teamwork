namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Axe : Weapon
    {
        private static int AttackModifier = (int)(Constants.ItemAttackPointsModifier * 0.3);
        private static int EnergyModifier = (int)(Constants.ItemAttackPointsModifier * 1.5);

        public Axe(string id, Character itemHolder)
            : base(id, itemHolder, EnergyModifier, AttackModifier)
        {

        }
    }
}
