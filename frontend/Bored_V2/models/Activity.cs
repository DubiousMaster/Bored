namespace Bored_V2.models
{
    internal sealed class Activity : Entity
    {
        private string name;
        private decimal accessibility;
        private string activityType;
        private int participants;
        private decimal price;
        private string link;
        private int activityKey;

        public string Name
        {
            get
            {
                return name;
            }
        }

        public decimal Accessibility
        {
            get
            {
                return accessibility;
            }
        }

        public string ActivityType
        {
            get
            {
                return activityType;
            }
        }

        public int Participants
        {
            get
            {
                return participants;
            }
        }

        public decimal Price
        {
            get
            {
                return price;
            }
        }

        public string Link
        {
            get
            {
                return link;
            }
        }

        public int ActivityKey
        {
            get
            {
                return activityKey;
            }
        }

        public Activity(string name, decimal accessibility, string activityType, int participants, decimal price, string link, int activityKey)
        {
            this.name = name;
            this.accessibility = accessibility;
            this.activityType = activityType;
            this.participants = participants;
            this.price = price;
            this.link = link;
            this.activityKey = activityKey;
        }

        public override string ToString() => this.name;
    }
}
