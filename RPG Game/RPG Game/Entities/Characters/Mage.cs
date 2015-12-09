namespace RPG_Game.Entities.Characters
{
    using System.Windows.Controls;
    using Constants;

    public class Mage : Character
    {
        public Mage(string id, Image image, int x, int y)
            : base(id, image, Constants.CharacterHealth, Constants.CharacterEnergy, Constants.CharacterAttackPoints, Constants.CharacterDefensePoints, x, y)
        {
            
        }
    }
}
