using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Core.core.models
{
    [DataContract]
    public class Activity
    {
        [DataMember]
        internal int id;
        [DataMember]
        internal string name;
        [DataMember]
        internal double accessibility;
        [DataMember]
        internal int type;
        [DataMember]
        internal int participants;
        [DataMember]
        internal double price;
        [DataMember]
        internal string link;
        [DataMember]
        internal int activityKey;

        public Activity()
        {
        }

        public Activity(int id, string name, double accessibility, int type, int participants, double price, string link, int activityKey)
        {
            this.id = id;
            this.name = name;
            this.accessibility = accessibility;
            this.type = type;
            this.participants = participants;
            this.price = price;
            this.link = link;
            this.activityKey = activityKey;
        }

        public override string ToString() => this.name;
    }
}
