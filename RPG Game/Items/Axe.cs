namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Axe : Weapon
    {
        public Axe(string id, Character itemHolder)
            : base(id, itemHolder, Constants.ItemEnergyModifier, Constants.ItemAttackPointsModifier)
        {

        }
    }
}
