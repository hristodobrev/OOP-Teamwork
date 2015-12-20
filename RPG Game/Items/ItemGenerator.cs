namespace RPG_Game.Items
{
    using RPG_Game.Entities.Characters;
    using System;

    public static class ItemGenerator
    {
        public static Item GenerateItem()
        {
            int caseFactor = new Random().Next(1, 5);
            switch (caseFactor)
            {
                case 1:
                    return new Axe("CommonAxe");
                case 2:
                    return new Shield("CommonShield");
                case 3:
                    return new Staff("CommonStaff");
                case 4:
                    return new Sword("CommonSword");
            }
            return null;
        }
    }
}
