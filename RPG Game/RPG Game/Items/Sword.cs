namespace RPG_Game.Items
{
    using Entities.Characters;
    using Constants;

    public class Sword : Weapon
    {
        public Sword(string id, Character itemHolder)
            : base(id, itemHolder, Constants.ItemEnergyModifier, Constants.ItemAttackPointsModifier)
        {

        }
    }
}
