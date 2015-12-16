namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Sword : Weapon
    {
        private static int AttackModifier = (int)(Constants.ItemAttackPointsModifier * 0.5);
        private static int EnergyModifier = (int)(Constants.ItemAttackPointsModifier * 0.7);

        public Sword(string id, Character itemHolder)
            : base(id, itemHolder, EnergyModifier, AttackModifier)
        {

        }
    }
}
