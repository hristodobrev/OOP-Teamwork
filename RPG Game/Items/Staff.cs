namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Staff : Weapon
    {
        public Staff(string id, Character itemHolder)
            : base(id, itemHolder, Constants.ItemEnergyModifier, Constants.ItemAttackPointsModifier)
        {

        }
    }
}
