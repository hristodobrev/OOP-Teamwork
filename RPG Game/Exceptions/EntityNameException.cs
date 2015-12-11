namespace RPG_Game.Exceptions
{
    using System;

    public class EntityNameException : ApplicationException
    {
        public EntityNameException()
        {
            throw new ApplicationException("Your name is null or empty.");
        }

        public EntityNameException(string msg)
            : base(msg)
        {
        }

        public EntityNameException(string msg, string prop)
            : base(msg + "\nProperty: " + prop)
        {
        }

        public EntityNameException(string msg, Exception innerException)
            : base(msg, innerException)
        {
        }
    }
}
