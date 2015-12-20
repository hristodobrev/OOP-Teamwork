namespace RPG_Game.Items
{
    using RPG_Game.Entities.Characters;
    using System;

    public static class ItemGenerator
    {
        public static Item GenerateItem(Character player)
        {
            int caseFactor = new Random().Next(1, 5);
            switch (caseFactor)
            {
                case 1:
                    return new Axe("CommonAxe", player);
                case 2:
                    return new Shield("CommonShield", player);
                case 3:
                    return new Staff("CommonStaff", player);
                case 4:
                    return new Sword("CommonSword", player);
            }
            return null;
        }
    }
}
