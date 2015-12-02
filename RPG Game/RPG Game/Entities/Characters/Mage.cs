namespace RPG_Game.Entities.Characters
{
    using Constants;

    public class Mage : Character
    {
        public Mage(string id, int x, int y)
            : base(id, Constants.CharacterHealth, Constants.CharacterEnergy, Constants.CharacterAttackPoints, Constants.CharacterDefensePoints, x, y)
        {
            
        }
    }
}
