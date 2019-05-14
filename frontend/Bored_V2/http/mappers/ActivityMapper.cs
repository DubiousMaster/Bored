using Bored_V2.models;
using System.Runtime.Serialization;

namespace Bored_V2.http.mappers
{
    internal sealed class ActivityMapper : Mapper
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
            set
            {
                name = value;
            }
        }

        public decimal Accessibility
        {
            get
            {
                return accessibility;
            }
            set
            {
                accessibility = value;
            }
        }

        public string ActivityType
        {
            get
            {
                return activityType;
            }
            set
            {
                activityType = value;
            }
        }

        public int Participants
        {
            get
            {
                return participants;
            }
            set
            {
                participants = value;
            }
        }

        public decimal Price
        {
            get
            {
                return price;
            }
            set
            {
                price = value;
            }
        }

        public string Link
        {
            get
            {
                return link;
            }
            set
            {
                link = value;
            }
        }

        public int ActivityKey
        {
            get
            {
                return activityKey;
            }
            set
            {
                activityKey = value;
            }
        }

        public ActivityMapper() { }

        public ActivityMapper(string name, decimal accessibility, string activityType, int participants, decimal price, string link, int activityKey)
        {
            this.name = name;
            this.accessibility = accessibility;
            this.activityType = activityType;
            this.participants = participants;
            this.price = price;
            this.link = link;
            this.activityKey = activityKey;
        }

        public override Entity ToEntity => new Activity(name: name, accessibility: accessibility, activityType: activityType, participants: participants, price: price, link: link, activityKey: activityKey);
    }
}
