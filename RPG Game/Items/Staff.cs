namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Staff : Weapon
    {
        private static int AttackModifier = (int)(Constants.ItemAttackPointsModifier * 0.4);
        private static int EnergyModifier = (int)(Constants.ItemAttackPointsModifier * 1.2);

        public Staff(string id)
            : base(id, EnergyModifier, AttackModifier)
        {

        }
    }
}
