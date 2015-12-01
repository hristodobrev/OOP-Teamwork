namespace RPG_Game.Entities
{
    public abstract class GameObject
    {
        protected GameObject(string id)
        {
            this.Id = id;
        }

        private string Id { get; set; }
    }
}
