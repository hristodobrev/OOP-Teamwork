namespace RPG_Game.Entities.Characters
{
    using Constants;

    public class Warrior : Character
    {
        public Warrior(string id, int x, int y)
            : base(id, Constants.CharacterHealth, Constants.CharacterEnergy, Constants.CharacterAttackPoints, Constants.CharacterDefensePoints, x, y)
        {

        }
    }
}
