namespace RPG_Game.Entities.Characters
{
    using System.Windows.Controls;
    using Constants;

    public class Priest : Character
    {
        public Priest(string id, Image image, int x, int y)
            : base(id, image, Constants.CharacterHealth, Constants.CharacterEnergy, Constants.CharacterAttackPoints, Constants.CharacterDefensePoints, x, y)
        {

        }
    }
}
