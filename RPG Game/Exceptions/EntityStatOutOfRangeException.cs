namespace RPG_Game.Exceptions
{
    using System;

    public class EntityStatOutOfRangeException : ApplicationException
    {
        public EntityStatOutOfRangeException()
        {
            throw new ApplicationException("Entity stat is negative.");
        }

        public EntityStatOutOfRangeException(string msg)
            : base(msg)
        {
        }

        public EntityStatOutOfRangeException(string msg, string prop)
            : base(msg + "\nProperty: " + prop)
        {
        }

        public EntityStatOutOfRangeException(string msg, Exception innerException)
            : base(msg, innerException)
        {
        }
    }
}
